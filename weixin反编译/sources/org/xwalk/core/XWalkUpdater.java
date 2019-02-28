package org.xwalk.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import com.tencent.xweb.util.BSpatch;
import com.tencent.xweb.util.a;
import com.tencent.xweb.util.c;
import com.tencent.xweb.util.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;

public class XWalkUpdater {
    private static final String ANDROID_MARKET_DETAILS = "market://details?id=";
    public static final int ERROR_DOPATCH_FAILED = -3;
    public static final int ERROR_DOPATCH_MD5_FAILED = -4;
    public static final int ERROR_DOWNLOAD_FAILED = -1;
    public static final int ERROR_DOWNLOAD_MD5_FAILED = -2;
    public static final int ERROR_EXTRACT_RESOURCE_FAILED = -5;
    public static final int ERROR_NONE = 0;
    public static final int ERROR_SET_VERNUM = -101;
    private static final String GOOGLE_PLAY_PACKAGE = "com.android.vending";
    private static final String TAG = "XWalkLib";
    public static final int UPDATE_BIZ_TYPE_RUNTIME_PACKAGE = 1;
    public static final int UPDATE_BIZ_TYPE_RUNTIME_PATCH = 2;
    private XWalkBackgroundUpdateListener mBackgroundUpdateListener;
    private Runnable mCancelCommand;
    private Context mContext;
    private XWalkDialogManager mDialogManager;
    private Runnable mDownloadCommand;
    private XWalkUpdateListener mUpdateListener;

    public static class UpdateConfig {
        public int apkVer = -1;
        public boolean bUseCdn;
        public String downUrl;
        public String downloadFileMd5;
        public boolean isMatchMd5 = false;
        public boolean isPatchUpdate;
        public String patchEndFileMd5;
        public String versionDetail;

        public UpdateConfig(String str, boolean z, int i) {
            this.isPatchUpdate = z;
            this.downUrl = str;
            this.apkVer = i;
            if (!checkValid()) {
                throw new RuntimeException("royle:UpdateConfig is not valid");
            }
        }

        public UpdateConfig(String str, boolean z, String str2, String str3, int i) {
            this.downloadFileMd5 = str;
            this.isPatchUpdate = z;
            this.patchEndFileMd5 = str2;
            this.downUrl = str3;
            this.apkVer = i;
            if (!checkValid()) {
                throw new RuntimeException("royle:UpdateConfig is not valid");
            }
        }

        public String getDownloadPath() {
            if (!checkValid()) {
                throw new RuntimeException("royle:UpdateConfig is not valid");
            } else if (this.isPatchUpdate) {
                return XWalkEnvironment.getDownloadPatchPath(this.apkVer);
            } else {
                return XWalkEnvironment.getDownloadZipDir(this.apkVer);
            }
        }

        public int getUpdateBizType() {
            if (this.isPatchUpdate) {
                return 2;
            }
            return 1;
        }

        public boolean checkValid() {
            if ((this.isMatchMd5 && (this.downloadFileMd5 == null || this.downloadFileMd5.isEmpty())) || this.downUrl == null || this.downUrl.isEmpty() || this.apkVer == -1) {
                return false;
            }
            if (this.isMatchMd5 && this.isPatchUpdate && (this.patchEndFileMd5 == null || this.patchEndFileMd5.isEmpty())) {
                return false;
            }
            return true;
        }

        public String getLogSelf() {
            if (checkValid()) {
                return "UpdateConfig isMatchMd5:" + this.isMatchMd5 + " downloadFileMd5:" + this.downloadFileMd5 + ",isPatchUpdate:" + this.isPatchUpdate + ",downUrl:" + this.downUrl + ",apkVer:" + this.apkVer + ",downloadPath:" + getDownloadPath() + ".";
            }
            return "UpdateConfig is not valid";
        }
    }

    public interface XWalkUpdateListener {
        void onXWalkUpdateCancelled();
    }

    private class BackgroundListener implements DownloadListener {
        private BackgroundListener() {
        }

        /* synthetic */ BackgroundListener(XWalkUpdater xWalkUpdater, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onDownloadStarted() {
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateStarted();
        }

        public void onDownloadUpdated(int i) {
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateProgress(i);
        }

        public void onDownloadCancelled() {
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCancelled();
        }

        public void onDownloadFailed(int i, int i2) {
            XWalkInitializer.addXWalkInitializeLog(XWalkUpdater.TAG, "download apk failed");
            XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(-1);
        }

        public void onDownloadCompleted(final UpdateConfig updateConfig) {
            XWalkInitializer.addXWalkInitializeLog(XWalkUpdater.TAG, "download apk completed, apkver = " + updateConfig.apkVer);
            new AsyncTask<Void, Void, Integer>() {
                protected Integer doInBackground(Void... voidArr) {
                    return XWalkUpdater.onHandleFile(updateConfig);
                }

                protected void onPostExecute(Integer num) {
                    if (num.intValue() != 0) {
                        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateFailed(num.intValue());
                    } else {
                        XWalkUpdater.this.mBackgroundUpdateListener.onXWalkUpdateCompleted();
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public static class PatchFileConfigParser {
        private static final String ADD_FLAG = "ADD:";
        private static final int ADD_TYPE = 1;
        private static final int APK_FILE_TYPE = 1;
        private static final String DEL_FLAG = "DEL:";
        private static final int DEL_TYPE = 3;
        private static final int EXTRACTED_FILE_TYPE = 2;
        private static final String MOD_FLAG = "MOD:";
        private static final int MOD_TYPE = 2;
        private static final String PATCH_SUFFIX = ".patch";

        public static ArrayList<PatchFileConfig> getPatchFileConfigList(int i) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(XWalkEnvironment.getPatchConfig(i)))));
                ArrayList<PatchFileConfig> arrayList = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return arrayList;
                    }
                    if (!(readLine == null || readLine.isEmpty())) {
                        int i2;
                        if (readLine.startsWith(ADD_FLAG)) {
                            readLine = readLine.substring(4);
                            i2 = 1;
                        } else if (readLine.startsWith(MOD_FLAG)) {
                            readLine = readLine.substring(4);
                            i2 = 2;
                        } else if (readLine.startsWith(DEL_FLAG)) {
                            readLine = readLine.substring(4);
                            i2 = 3;
                        } else {
                            i2 = 0;
                        }
                        for (String str : readLine.split(",")) {
                            if (!(str == null || str.isEmpty())) {
                                PatchFileConfig patchFileConfig = new PatchFileConfig();
                                patchFileConfig.originalFileName = str;
                                patchFileConfig.type = i2;
                                if (i2 == 2) {
                                    patchFileConfig.patchFileName = patchFileConfig.originalFileName + PATCH_SUFFIX;
                                }
                                if (i2 == 2 && patchFileConfig.originalFileName.equals(XWalkEnvironment.XWALK_CORE_APK_NAME)) {
                                    patchFileConfig.originalFileType = 1;
                                } else {
                                    patchFileConfig.originalFileType = 2;
                                }
                                Log.d(XWalkUpdater.TAG, "getPatchFileConfigList config:" + patchFileConfig.toString());
                                arrayList.add(patchFileConfig);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(XWalkUpdater.TAG, "getPatchFileConfigList error:" + e.getMessage());
                return null;
            }
        }
    }

    public static class PatchFileConfig {
        public String originalFileName;
        public int originalFileType;
        public String patchEndFileMd5;
        public String patchFileName;
        public int type;

        public boolean isTypeAdd() {
            return this.type == 1;
        }

        public boolean isTypeModify() {
            return this.type == 2;
        }

        public boolean isTypeRemove() {
            return this.type == 3;
        }

        public boolean isOriginalFileTypeApk() {
            return this.originalFileType == 1;
        }

        public boolean isExtractedFile() {
            return this.originalFileType == 2;
        }

        public String toString() {
            return "PatchFileConfig type:" + this.type + ",originalFileType:" + this.originalFileType + ",originalFileName:" + this.originalFileName + ",patchFileName:" + this.patchFileName + ",patchEndFileMd5:" + this.patchEndFileMd5;
        }
    }

    public static class FileListMD5Checker {
        public static boolean checkFileListMd5(int i, String str) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(str))));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        return true;
                    }
                    if (!(readLine == null || readLine.isEmpty())) {
                        String[] split = readLine.split(":");
                        if (!(split == null || split.length != 2 || split[0] == null || split[0].isEmpty() || split[1] == null || split[1].isEmpty() || checkFileMd5(i, split[0], split[1]))) {
                            Log.e(XWalkUpdater.TAG, "checkFileListMd5 error name:" + split[0] + ",md5:" + split[1]);
                            return false;
                        }
                    }
                }
            } catch (Exception e) {
                Log.e(XWalkUpdater.TAG, "checkFileListMd5 error:" + e.getMessage());
                return false;
            }
        }

        private static boolean checkFileMd5(int i, String str, String str2) {
            String downloadApkPath;
            if (XWalkEnvironment.XWALK_CORE_APK_NAME.equals(str)) {
                downloadApkPath = XWalkEnvironment.getDownloadApkPath(i);
            } else {
                downloadApkPath = XWalkEnvironment.getExtractedCoreFile(i, str);
            }
            if (c.gn(downloadApkPath, str2)) {
                Log.i(XWalkUpdater.TAG, "checkFileMd5 successful path:" + downloadApkPath);
                return true;
            }
            Log.e(XWalkUpdater.TAG, "checkFileMd5 error path:" + downloadApkPath);
            return false;
        }
    }

    public interface XWalkBackgroundUpdateListener {
        void onXWalkUpdateCancelled();

        void onXWalkUpdateCompleted();

        void onXWalkUpdateFailed(int i);

        void onXWalkUpdateProgress(int i);

        void onXWalkUpdateStarted();
    }

    public XWalkUpdater(XWalkUpdateListener xWalkUpdateListener, Context context) {
        this.mUpdateListener = xWalkUpdateListener;
        this.mContext = context;
        this.mDialogManager = new XWalkDialogManager(context);
    }

    public XWalkUpdater(XWalkUpdateListener xWalkUpdateListener, Context context, XWalkDialogManager xWalkDialogManager) {
        this.mUpdateListener = xWalkUpdateListener;
        this.mContext = context;
        this.mDialogManager = xWalkDialogManager;
    }

    public XWalkUpdater(XWalkBackgroundUpdateListener xWalkBackgroundUpdateListener, Context context) {
        this.mBackgroundUpdateListener = xWalkBackgroundUpdateListener;
        this.mContext = context;
    }

    public boolean updateXWalkRuntime(UpdateConfig updateConfig) {
        if (XWalkLibraryLoader.isDownloading()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "Other initialization or download is proceeding");
            return false;
        } else if (this.mBackgroundUpdateListener != null) {
            if (updateConfig == null || !updateConfig.checkValid()) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
            }
            XWalkInitializer.addXWalkInitializeLog(TAG, "start download apk");
            XWalkLibraryLoader.startHttpDownload(new BackgroundListener(), this.mContext, updateConfig);
            return true;
        } else {
            throw new IllegalArgumentException("Update listener is null");
        }
    }

    public static void updateLocalXWalkRuntime() {
        onHandleFile(new UpdateConfig(XWalkEnvironment.LOCAL_TEST_ZIP_NAME, false, 999));
    }

    public void cancelXWalkRuntimeDownload() {
        if (XWalkLibraryLoader.isDownloading()) {
            XWalkInitializer.addXWalkInitializeLog(TAG, "canceled download apk");
            XWalkLibraryLoader.cancelHttpDownload();
        }
    }

    public boolean dismissDialog() {
        if (this.mDialogManager == null || !this.mDialogManager.isShowingDialog()) {
            return false;
        }
        this.mDialogManager.dismissDialog();
        return true;
    }

    public boolean cancelBackgroundDownload() {
        return XWalkLibraryLoader.cancelHttpDownload();
    }

    public static Integer onHandleFile(UpdateConfig updateConfig) {
        String downloadPath = updateConfig.getDownloadPath();
        String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(updateConfig.apkVer);
        Log.d(TAG, "Download mode extract dir: " + extractedCoreDir);
        if (!updateConfig.isMatchMd5 || c.gn(downloadPath, updateConfig.downloadFileMd5)) {
            if (updateConfig.isPatchUpdate) {
                if (!onDoPatch(downloadPath, XWalkEnvironment.getAvailableVersion(), updateConfig.apkVer)) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode ,but patch error");
                    return Integer.valueOf(-3);
                } else if (!updateConfig.isMatchMd5 || FileListMD5Checker.checkFileListMd5(updateConfig.apkVer, XWalkEnvironment.getPatchFileListConfig(updateConfig.apkVer))) {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "do patch sucsess");
                } else {
                    XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode, but md5 not match");
                    e.gC(36);
                    return Integer.valueOf(-4);
                }
            } else if (!XWalkDecompressor.decompressDownloadFullZip(downloadPath, updateConfig.apkVer)) {
                e.gC(32);
                return Integer.valueOf(-5);
            } else if (updateConfig.isMatchMd5 && !FileListMD5Checker.checkFileListMd5(updateConfig.apkVer, XWalkEnvironment.getDownloadZipFileListConfig(updateConfig.apkVer))) {
                XWalkInitializer.addXWalkInitializeLog(TAG, "patch update mode, but md5 not match");
                e.gC(33);
                return Integer.valueOf(-4);
            }
            if (XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(updateConfig.apkVer), extractedCoreDir)) {
                boolean availableVersion = XWalkEnvironment.setAvailableVersion(updateConfig.apkVer, updateConfig.versionDetail);
                XWalkInitializer.addXWalkInitializeLog(TAG, "do update sucsess");
                if (availableVersion) {
                    return Integer.valueOf(0);
                }
                return Integer.valueOf(ERROR_SET_VERNUM);
            }
            XWalkInitializer.addXWalkInitializeLog(TAG, "extract faield");
            return Integer.valueOf(-5);
        }
        XWalkInitializer.addXWalkInitializeLog(TAG, "downloaded apk md5 check failed");
        return Integer.valueOf(-2);
    }

    public static boolean onDoPatch(String str, int i, int i2) {
        Log.i(TAG, "onDoPatch:" + str + ",currentVersion:" + i + ",newVersion:" + i2);
        if (!new File(str).exists()) {
            Log.e(TAG, "onDoPatch no patch zip file");
            return false;
        } else if (XWalkDecompressor.decompressDownloadPatchZip(str, XWalkEnvironment.getPatchZipTempDecompressPath(i2))) {
            ArrayList patchFileConfigList = PatchFileConfigParser.getPatchFileConfigList(i2);
            if (patchFileConfigList == null) {
                Log.e(TAG, "onDoPatch patchFileConfigList = null");
                e.gC(38);
                return false;
            } else if (a.gm(XWalkEnvironment.getExtractedCoreDir(i), XWalkEnvironment.getExtractedCoreDir(i2))) {
                PatchFileConfig patchFileConfig;
                Log.i(TAG, "onDoPatch copy all extraced file finished");
                ArrayList arrayList = new ArrayList();
                Iterator it = patchFileConfigList.iterator();
                while (it.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it.next();
                    if (patchFileConfig.isTypeAdd()) {
                        arrayList.add(patchFileConfig);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it2.next();
                    if (a.fv(XWalkEnvironment.getPatchZipTempDecompressFilePath(i2, patchFileConfig.originalFileName), XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName))) {
                        Log.i(TAG, "onDoPatch add file:" + patchFileConfig);
                    } else {
                        Log.e(TAG, "onDoPatch add file error:" + patchFileConfig);
                        e.gC(40);
                    }
                }
                Log.i(TAG, "onDoPatch add file finished");
                arrayList = new ArrayList();
                it = patchFileConfigList.iterator();
                while (it.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it.next();
                    if (patchFileConfig.isTypeRemove()) {
                        arrayList.add(patchFileConfig);
                    }
                }
                it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it2.next();
                    if (a.deleteFile(XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName))) {
                        Log.i(TAG, "onDoPatch delete file:" + patchFileConfig);
                    } else {
                        Log.e(TAG, "onDoPatch delete file error:" + patchFileConfig);
                        e.gC(41);
                    }
                }
                Log.i(TAG, "onDoPatch remove file finished");
                arrayList = new ArrayList();
                Iterator it3 = patchFileConfigList.iterator();
                while (it3.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it3.next();
                    if (patchFileConfig.isTypeModify()) {
                        arrayList.add(patchFileConfig);
                    }
                }
                it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it3.next();
                    if (patchFileConfig.isExtractedFile()) {
                        if (BSpatch.an(XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName), XWalkEnvironment.getPatchZipTempDecompressFilePath(i2, patchFileConfig.patchFileName), XWalkEnvironment.getExtractedCoreFile(i2, patchFileConfig.originalFileName)) < 0) {
                            Log.e(TAG, "onDoPatch patch error file:" + patchFileConfig);
                            return false;
                        }
                        Log.i(TAG, "onDoPatch patch file finished");
                    }
                }
                Log.i(TAG, "onDoPatch patch file finished");
                it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    patchFileConfig = (PatchFileConfig) it3.next();
                    if (patchFileConfig.isOriginalFileTypeApk()) {
                        if (BSpatch.an(XWalkEnvironment.getDownloadApkPath(i), XWalkEnvironment.getPatchZipTempDecompressFilePath(i2, patchFileConfig.patchFileName), XWalkEnvironment.getDownloadApkPath(i2)) < 0) {
                            Log.e(TAG, "onDoPatch apk patch error file:" + patchFileConfig);
                            return false;
                        }
                        Log.i(TAG, "onDoPatch apk patch finished");
                        return true;
                    }
                }
                Log.i(TAG, "onDoPatch apk patch finished");
                return true;
            } else {
                Log.e(TAG, "onDoPatch copy all extraced file error");
                e.gC(39);
                return false;
            }
        } else {
            Log.e(TAG, "onDoPatch decompress zip error");
            e.gC(37);
            return false;
        }
    }

    private boolean verifyDownloadedXWalkRuntime(String str) {
        PackageInfo packageArchiveInfo = this.mContext.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo == null) {
            Log.e(TAG, "The downloaded XWalkRuntimeLib.apk is invalid!");
            return false;
        }
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
            if (packageArchiveInfo.signatures == null || packageInfo.signatures == null) {
                Log.e(TAG, "No signature in package info");
                return false;
            } else if (packageArchiveInfo.signatures.length != packageInfo.signatures.length) {
                Log.e(TAG, "signatures length not equal");
                return false;
            } else {
                int i = 0;
                while (i < packageArchiveInfo.signatures.length) {
                    Log.d(TAG, "Checking signature " + i);
                    if (packageInfo.signatures[i].equals(packageArchiveInfo.signatures[i])) {
                        i++;
                    } else {
                        Log.e(TAG, "signatures do not match");
                        return false;
                    }
                }
                Log.d(TAG, "Signature check passed");
                return true;
            }
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
