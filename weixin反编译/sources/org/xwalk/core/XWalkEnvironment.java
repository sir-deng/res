package org.xwalk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.util.a;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class XWalkEnvironment {
    private static final String APK_DIR = "apk";
    public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
    public static final int LOCAL_TEST_VERSION = 999;
    public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
    public static final String[] MANDATORY_RESOURCES = new String[]{XWALK_CORE_CLASSES_DEX, "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak"};
    private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
    private static final String OPTIMIZED_DEX_DIR = "dex";
    private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
    private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
    public static final int SDK_SUPPORT_MIN_APKVERSION = 24;
    public static final int SDK_VERSION = 17;
    private static final int SPECIAL_TEST_USER_ID = 10001;
    private static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
    private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
    private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
    private static final String TAG = "XWalkLib";
    public static String UPDATEINFOTAG = "xwalk_update_info";
    public static final String XWALK_CORE_APK_NAME = "base.apk";
    private static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
    private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
    private static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
    private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
    private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
    private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
    private static final String XWALK_CORE_ZIP_NAME = "base.zip";
    private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
    private static final String ZIP_DIR = "zip";
    private static Context sApplicationContext;
    private static String sApplicationName;
    private static int sAvailableVersion = -1;
    private static String sDeviceAbi;
    private static Boolean sIsDownloadMode = Boolean.valueOf(true);
    private static Boolean sIsDownloadModeUpdate = Boolean.valueOf(true);
    private static Boolean sIsXWalkVerify;
    static int sNDeviceRd = 0;
    static int sPid = Process.myPid();
    private static String sRuntimeAbi;
    static String sStrDeviceId = null;
    private static String sStrTempUpdateConfigUrl;
    private static String sStrVersionDetail;
    private static String sXWalkApkUrl;
    private static String sXWalkDownConfigUrl;
    static int s_grayValue = 0;

    public static void init(Context context) {
        sApplicationContext = context.getApplicationContext();
        if (sAvailableVersion == -1) {
            sAvailableVersion = getSharedPreferencesForVersionInfo().getInt("availableVersion", -1);
            sStrVersionDetail = getSharedPreferencesForVersionInfo().getString("versionDetail", "");
            if (sAvailableVersion != -1) {
                getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sAvailableVersion)).commit();
            }
        }
    }

    public static SharedPreferences getSharedPreferencesForUpdateConfig() {
        return sApplicationContext.getSharedPreferences("UPDATEINFOTAG", 4);
    }

    public static SharedPreferences getSharedPreferencesForVersionInfo() {
        return sApplicationContext.getSharedPreferences("XWALKINFOS", 4);
    }

    public static SharedPreferences getSharedPreferencesForLog() {
        if (sApplicationContext == null) {
            return null;
        }
        return sApplicationContext.getSharedPreferences("UPDATELOG", 4);
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static SharedPreferences getSharedPreferences() {
        return sApplicationContext.getSharedPreferences("libxwalkcore", 4);
    }

    public static boolean hasAvailableVersion() {
        if (24 > getAvailableVersion()) {
            return false;
        }
        return true;
    }

    public static int getAvailableVersion() {
        return sAvailableVersion;
    }

    public static String getAvailableVersionDetail() {
        return sStrVersionDetail;
    }

    public static boolean setAvailableVersion(int i, String str) {
        Log.i(TAG, "setAvailableVersion:" + i);
        Editor edit = getSharedPreferencesForVersionInfo().edit();
        edit.putInt("availableVersion", i);
        edit.putString("versionDetail", str);
        boolean commit = edit.commit();
        addXWalkInitializeLog(TAG, "set xwalk version to " + i + " suc = " + commit);
        return commit;
    }

    public static String getVesionDir(int i) {
        String absolutePath = sApplicationContext.getDir(new StringBuilder(XWALK_CORE_NAME_PREFIX).append(i).toString(), 0).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        return absolutePath;
    }

    public static void clearAllVersion(Context context) {
        if (context != null && context.getApplicationInfo() != null && context.getApplicationInfo().dataDir != null) {
            File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.getName().startsWith("app_xwalk_") && file.isDirectory()) {
                        a.ada(file.getAbsolutePath());
                    }
                }
                setAvailableVersion(-1, "");
            }
        }
    }

    public static void addXWalkInitializeLog(String str, String str2) {
        addXWalkInitializeLog(str + ": " + str2);
    }

    public static void addXWalkInitializeLog(String str) {
        if (str != null && !str.isEmpty()) {
            Log.i("XWalkUpdater", str);
            String str2 = sPid + ":" + new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date()) + " : " + str;
            SharedPreferences sharedPreferencesForLog = getSharedPreferencesForLog();
            String string = sharedPreferencesForLog.getString("log", "");
            if (string.length() > 5000) {
                string = string.substring(4000);
            }
            sharedPreferencesForLog.edit().putString("log", str2 + "\n" + string).apply();
        }
    }

    public static int getGrayValue() {
        if (s_grayValue != 0) {
            return s_grayValue;
        }
        try {
            int i = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE_TEST, -1);
            s_grayValue = i;
            if (i <= 0) {
                s_grayValue = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE, -1);
            }
            if (s_grayValue <= 0) {
                s_grayValue = getDeviceRd();
            }
        } catch (Exception e) {
            Log.e("XWalkEnvironment", "match gray rate exception: " + e.getMessage());
        }
        return s_grayValue;
    }

    public static String getXWalkInitializeLog() {
        SharedPreferences sharedPreferencesForLog = getSharedPreferencesForLog();
        if (sharedPreferencesForLog == null) {
            return "";
        }
        return sharedPreferencesForLog.getString("log", "");
    }

    public static String getUpdateConfigDir() {
        return sApplicationContext.getDir(XWALK_UPDATE_CONFIG_DIR, 0).getAbsolutePath();
    }

    public static String getExtractedCoreDir(int i) {
        String str = getVesionDir(i) + File.separator + XWALK_CORE_EXTRACTED_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getExtractedCoreFile(int i, String str) {
        String str2 = getVesionDir(i) + File.separator + XWALK_CORE_EXTRACTED_DIR;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + str;
    }

    public static String getOptimizedDexDir(int i) {
        String str = getVesionDir(i) + File.separator + OPTIMIZED_DEX_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getDownloadZipDir(int i) {
        String str = getVesionDir(i) + File.separator + ZIP_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + File.separator + XWALK_CORE_ZIP_NAME;
    }

    public static String getPatchZipTempDecompressPath(int i) {
        String str = getVesionDir(i) + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getPatchZipTempDecompressFilePath(int i, String str) {
        String str2 = getVesionDir(i) + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + File.separator + str;
    }

    public static String getDownloadZipFileListConfig(int i) {
        return getExtractedCoreFile(i, XWALK_CORE_FILELIST_CONFIG_NAME);
    }

    public static String getPatchFileListConfig(int i) {
        return getPatchZipTempDecompressFilePath(i, XWALK_CORE_FILELIST_CONFIG_NAME);
    }

    public static String getPatchConfig(int i) {
        return getPatchZipTempDecompressFilePath(i, XWALK_CORE_PATCH_CONFIG_NAME);
    }

    public static String getDownloadApkPath(int i) {
        String str = getVesionDir(i) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + File.separator + XWALK_CORE_APK_NAME;
    }

    public static String getDownloadPatchPath(int i) {
        String str = getVesionDir(i) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + File.separator + XWALK_CORE_PATCH_NAME;
    }

    public static String getClassDexFilePath(int i) {
        return getExtractedCoreDir(i) + File.separator + XWALK_CORE_CLASSES_DEX;
    }

    public static String getTestDownLoadUrl(Context context) {
        return context.getSharedPreferences("TESTXWEB", 4).getString("XWEB_TEST_CONFIG_URL", "");
    }

    public static void setTestDownLoadUrl(Context context, String str) {
        if (str == null || str.isEmpty()) {
            context.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
            getXWalkUpdateConfigUrl();
            return;
        }
        context.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", str).commit();
        getXWalkUpdateConfigUrl();
    }

    public static synchronized void setTempUpdateConfigUrl(String str) {
        synchronized (XWalkEnvironment.class) {
            sStrTempUpdateConfigUrl = str;
        }
    }

    public static synchronized String getTempUpdateConfigUrl() {
        String str;
        synchronized (XWalkEnvironment.class) {
            str = sStrTempUpdateConfigUrl;
        }
        return str;
    }

    public static String getXWalkUpdateConfigUrl() {
        if (sXWalkDownConfigUrl == null) {
            String testDownLoadUrl = getTestDownLoadUrl(getApplicationContext());
            sXWalkDownConfigUrl = testDownLoadUrl;
            if (testDownLoadUrl == null || sXWalkDownConfigUrl.trim().isEmpty()) {
                testDownLoadUrl = getTempUpdateConfigUrl();
                sXWalkDownConfigUrl = testDownLoadUrl;
                if (testDownLoadUrl == null || sXWalkDownConfigUrl.trim().isEmpty()) {
                    sXWalkDownConfigUrl = DOWNLOAD_CONFIG_URL;
                } else {
                    addXWalkInitializeLog("use temp config url : " + sXWalkDownConfigUrl);
                }
            } else {
                addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
            }
        }
        return sXWalkDownConfigUrl;
    }

    public static String getApplicationName() {
        if (sApplicationName == null) {
            try {
                PackageManager packageManager = sApplicationContext.getPackageManager();
                sApplicationName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(sApplicationContext.getPackageName(), 0));
            } catch (NameNotFoundException e) {
            }
            if (sApplicationName == null || sApplicationName.isEmpty() || sApplicationName.matches(PACKAGE_RE)) {
                sApplicationName = "this application";
            }
            Log.d(TAG, "Crosswalk application name: " + sApplicationName);
        }
        return sApplicationName;
    }

    public static boolean isDownloadMode() {
        return sIsDownloadMode.booleanValue();
    }

    public static boolean isDownloadModeUpdate() {
        return sIsDownloadModeUpdate.booleanValue();
    }

    public static boolean isIaDevice() {
        String deviceAbi = getDeviceAbi();
        return deviceAbi.equals("x86") || deviceAbi.equals("x86_64");
    }

    public static boolean is64bitDevice() {
        String deviceAbi = getDeviceAbi();
        return deviceAbi.equals("arm64-v8a") || deviceAbi.equals("x86_64");
    }

    public static boolean is64bitApp() {
        String runtimeAbi = getRuntimeAbi();
        return runtimeAbi.equals("arm64-v8a") || runtimeAbi.equals("x86_64");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getRuntimeAbi() {
        /*
        r4 = 3;
        r3 = 2;
        r2 = 1;
        r0 = 0;
        r1 = -1;
        r5 = sRuntimeAbi;
        if (r5 != 0) goto L_0x00d3;
    L_0x0009:
        r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ NoSuchFieldError -> 0x0015 }
        r6 = 21;
        if (r5 < r6) goto L_0x0042;
    L_0x000f:
        r5 = new java.lang.NoSuchFieldError;	 Catch:{ NoSuchFieldError -> 0x0015 }
        r5.<init>();	 Catch:{ NoSuchFieldError -> 0x0015 }
        throw r5;	 Catch:{ NoSuchFieldError -> 0x0015 }
    L_0x0015:
        r5 = move-exception;
        r5 = "os.arch";
        r5 = java.lang.System.getProperty(r5);
        r5 = r5.toLowerCase();
        r6 = r5.hashCode();
        switch(r6) {
            case -1409295825: goto L_0x012f;
            case -1221096139: goto L_0x0154;
            case -806050265: goto L_0x0123;
            case -738963905: goto L_0x013b;
            case 117046: goto L_0x0117;
            case 117110: goto L_0x00e8;
            case 3178856: goto L_0x00ff;
            case 3181739: goto L_0x00f3;
            case 3222903: goto L_0x010b;
            case 93084186: goto L_0x016e;
            case 93086174: goto L_0x0161;
            case 145444210: goto L_0x0147;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = r1;
    L_0x0029:
        switch(r0) {
            case 0: goto L_0x017b;
            case 1: goto L_0x017b;
            case 2: goto L_0x017b;
            case 3: goto L_0x017b;
            case 4: goto L_0x0182;
            case 5: goto L_0x0182;
            case 6: goto L_0x0196;
            case 7: goto L_0x0196;
            case 8: goto L_0x0196;
            case 9: goto L_0x019d;
            case 10: goto L_0x019d;
            case 11: goto L_0x019d;
            default: goto L_0x002c;
        };
    L_0x002c:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unexpected os.arch: ";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0042:
        r5 = android.os.Build.CPU_ABI;	 Catch:{ NoSuchFieldError -> 0x0015 }
        r6 = r5.toLowerCase();	 Catch:{ NoSuchFieldError -> 0x0015 }
        r5 = r6.hashCode();	 Catch:{ NoSuchFieldError -> 0x0015 }
        switch(r5) {
            case -806050265: goto L_0x0095;
            case -738963905: goto L_0x0069;
            case 117110: goto L_0x008a;
            case 145444210: goto L_0x0074;
            case 1431565292: goto L_0x007f;
            default: goto L_0x004f;
        };	 Catch:{ NoSuchFieldError -> 0x0015 }
    L_0x004f:
        r5 = r1;
    L_0x0050:
        switch(r5) {
            case 0: goto L_0x00a0;
            case 1: goto L_0x00a0;
            case 2: goto L_0x00d6;
            case 3: goto L_0x00dc;
            case 4: goto L_0x00e2;
            default: goto L_0x0053;
        };	 Catch:{ NoSuchFieldError -> 0x0015 }
    L_0x0053:
        r5 = new java.lang.RuntimeException;	 Catch:{ NoSuchFieldError -> 0x0015 }
        r7 = new java.lang.StringBuilder;	 Catch:{ NoSuchFieldError -> 0x0015 }
        r8 = "Unexpected CPU_ABI: ";
        r7.<init>(r8);	 Catch:{ NoSuchFieldError -> 0x0015 }
        r6 = r7.append(r6);	 Catch:{ NoSuchFieldError -> 0x0015 }
        r6 = r6.toString();	 Catch:{ NoSuchFieldError -> 0x0015 }
        r5.<init>(r6);	 Catch:{ NoSuchFieldError -> 0x0015 }
        throw r5;	 Catch:{ NoSuchFieldError -> 0x0015 }
    L_0x0069:
        r5 = "armeabi";
        r5 = r6.equals(r5);	 Catch:{ NoSuchFieldError -> 0x0015 }
        if (r5 == 0) goto L_0x004f;
    L_0x0072:
        r5 = r0;
        goto L_0x0050;
    L_0x0074:
        r5 = "armeabi-v7a";
        r5 = r6.equals(r5);	 Catch:{ NoSuchFieldError -> 0x0015 }
        if (r5 == 0) goto L_0x004f;
    L_0x007d:
        r5 = r2;
        goto L_0x0050;
    L_0x007f:
        r5 = "arm64-v8a";
        r5 = r6.equals(r5);	 Catch:{ NoSuchFieldError -> 0x0015 }
        if (r5 == 0) goto L_0x004f;
    L_0x0088:
        r5 = r3;
        goto L_0x0050;
    L_0x008a:
        r5 = "x86";
        r5 = r6.equals(r5);	 Catch:{ NoSuchFieldError -> 0x0015 }
        if (r5 == 0) goto L_0x004f;
    L_0x0093:
        r5 = r4;
        goto L_0x0050;
    L_0x0095:
        r5 = "x86_64";
        r5 = r6.equals(r5);	 Catch:{ NoSuchFieldError -> 0x0015 }
        if (r5 == 0) goto L_0x004f;
    L_0x009e:
        r5 = 4;
        goto L_0x0050;
    L_0x00a0:
        r5 = "armeabi-v7a";
        sRuntimeAbi = r5;	 Catch:{ NoSuchFieldError -> 0x0015 }
    L_0x00a5:
        r0 = sRuntimeAbi;
        r1 = "armeabi-v7a";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x01b1;
    L_0x00b0:
        r0 = isIaDevice();
        if (r0 == 0) goto L_0x00bb;
    L_0x00b6:
        r0 = "x86";
        sRuntimeAbi = r0;
    L_0x00bb:
        r0 = "XWalkLib";
        r1 = new java.lang.StringBuilder;
        r2 = "Runtime ABI: ";
        r1.<init>(r2);
        r2 = sRuntimeAbi;
        r1 = r1.append(r2);
        r1 = r1.toString();
        org.xwalk.core.Log.d(r0, r1);
    L_0x00d3:
        r0 = sRuntimeAbi;
        return r0;
    L_0x00d6:
        r5 = "arm64-v8a";
        sRuntimeAbi = r5;	 Catch:{ NoSuchFieldError -> 0x0015 }
        goto L_0x00a5;
    L_0x00dc:
        r5 = "x86";
        sRuntimeAbi = r5;	 Catch:{ NoSuchFieldError -> 0x0015 }
        goto L_0x00a5;
    L_0x00e2:
        r5 = "x86_64";
        sRuntimeAbi = r5;	 Catch:{ NoSuchFieldError -> 0x0015 }
        goto L_0x00a5;
    L_0x00e8:
        r2 = "x86";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0028;
    L_0x00f1:
        goto L_0x0029;
    L_0x00f3:
        r0 = "i686";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x00fc:
        r0 = r2;
        goto L_0x0029;
    L_0x00ff:
        r0 = "i386";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0108:
        r0 = r3;
        goto L_0x0029;
    L_0x010b:
        r0 = "ia32";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0114:
        r0 = r4;
        goto L_0x0029;
    L_0x0117:
        r0 = "x64";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0120:
        r0 = 4;
        goto L_0x0029;
    L_0x0123:
        r0 = "x86_64";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x012c:
        r0 = 5;
        goto L_0x0029;
    L_0x012f:
        r0 = "armv7l";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0138:
        r0 = 6;
        goto L_0x0029;
    L_0x013b:
        r0 = "armeabi";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0144:
        r0 = 7;
        goto L_0x0029;
    L_0x0147:
        r0 = "armeabi-v7a";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0150:
        r0 = 8;
        goto L_0x0029;
    L_0x0154:
        r0 = "aarch64";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x015d:
        r0 = 9;
        goto L_0x0029;
    L_0x0161:
        r0 = "armv8";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x016a:
        r0 = 10;
        goto L_0x0029;
    L_0x016e:
        r0 = "arm64";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0028;
    L_0x0177:
        r0 = 11;
        goto L_0x0029;
    L_0x017b:
        r0 = "x86";
        sRuntimeAbi = r0;
        goto L_0x00a5;
    L_0x0182:
        r0 = is64bitDevice();
        if (r0 == 0) goto L_0x018f;
    L_0x0188:
        r0 = "x86_64";
        sRuntimeAbi = r0;
        goto L_0x00a5;
    L_0x018f:
        r0 = "x86";
        sRuntimeAbi = r0;
        goto L_0x00a5;
    L_0x0196:
        r0 = "armeabi-v7a";
        sRuntimeAbi = r0;
        goto L_0x00a5;
    L_0x019d:
        r0 = is64bitDevice();
        if (r0 == 0) goto L_0x01aa;
    L_0x01a3:
        r0 = "arm64-v8a";
        sRuntimeAbi = r0;
        goto L_0x00a5;
    L_0x01aa:
        r0 = "armeabi-v7a";
        sRuntimeAbi = r0;
        goto L_0x00a5;
    L_0x01b1:
        r0 = sRuntimeAbi;
        r1 = "arm64-v8a";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00bb;
    L_0x01bc:
        r0 = isIaDevice();
        if (r0 == 0) goto L_0x00bb;
    L_0x01c2:
        r0 = "x86_64";
        sRuntimeAbi = r0;
        goto L_0x00bb;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xwalk.core.XWalkEnvironment.getRuntimeAbi():java.lang.String");
    }

    public static int getDeviceRd() {
        if (sNDeviceRd <= 0) {
            int i = getSharedPreferences().getInt(SP_KEY_DEVICE_RD, -1);
            sNDeviceRd = i;
            if (i <= 0) {
                sNDeviceRd = new Random().nextInt(10000000) + 1;
                getSharedPreferences().edit().putInt(SP_KEY_DEVICE_RD, sNDeviceRd).apply();
            }
        }
        return (sNDeviceRd % 10000) + 1;
    }

    public static void setGrayValueForTest(int i) {
        if (i != 10001) {
            s_grayValue = i % 10000;
        }
        getSharedPreferences().edit().putInt(SP_KEY_GRAY_VALUE_TEST, s_grayValue).commit();
    }

    public static void setGrayValueByUserId(int i) {
        if (i != 0) {
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(("xweb_gray_value" + (4294967295L & ((long) i))).getBytes());
                if (digest != null && digest.length > 3) {
                    int i2 = ((digest[0] & 127) << 24) | (((digest[3] & 255) | ((digest[2] & 255) << 8)) | ((digest[1] & 255) << 16));
                    if (i2 != 0) {
                        s_grayValue = (i2 % 10000) + 1;
                        getSharedPreferences().edit().putInt(SP_KEY_GRAY_VALUE, s_grayValue).commit();
                    }
                }
            } catch (Exception e) {
                s_grayValue = 0;
            }
        }
    }

    public static String getDeviceId() {
        if (sStrDeviceId == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService("phone");
                if (telephonyManager == null) {
                    sStrDeviceId = "";
                } else {
                    sStrDeviceId = telephonyManager.getDeviceId();
                }
            } catch (Exception e) {
                sStrDeviceId = "";
                Log.e("XWalkEnvironment", "getDeviceId failed " + e.getMessage());
            }
        }
        return sStrDeviceId;
    }

    public static String getDeviceAbi() {
        if (sDeviceAbi == null) {
            try {
                sDeviceAbi = Build.SUPPORTED_ABIS[0].toLowerCase();
            } catch (NoSuchFieldError e) {
                try {
                    Reader inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    sDeviceAbi = bufferedReader.readLine().toLowerCase();
                    bufferedReader.close();
                    inputStreamReader.close();
                } catch (IOException e2) {
                    throw new RuntimeException("Can not detect device's ABI");
                }
            }
            Log.d(TAG, "Device ABI: " + sDeviceAbi);
        }
        return sDeviceAbi;
    }

    private static String getApplicationMetaData(String str) {
        try {
            return sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), FileUtils.S_IWUSR).metaData.get(str).toString();
        } catch (NameNotFoundException e) {
        } catch (NullPointerException e2) {
        }
        return null;
    }

    public static boolean checkApiVersionAvailable(int i) {
        try {
            String extractedCoreDir = getExtractedCoreDir(i);
            String classDexFilePath = getClassDexFilePath(i);
            if (!new File(classDexFilePath).exists()) {
                return false;
            }
            try {
                Class loadClass = new DexClassLoader(classDexFilePath, getOptimizedDexDir(i), extractedCoreDir, ClassLoader.getSystemClassLoader()).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
                classDexFilePath = "";
                try {
                    classDexFilePath = (String) new ReflectField(loadClass, "XWALK_BUILD_VERSION").get();
                } catch (RuntimeException e) {
                }
                int intValue = ((Integer) new ReflectField(loadClass, "API_VERSION").get()).intValue();
                Log.d(TAG, "[Lib Version] build:" + classDexFilePath + ", api:" + intValue + ", min_api:" + ((Integer) new ReflectField(loadClass, "MIN_API_VERSION").get()).intValue());
                return true;
            } catch (Exception e2) {
                return false;
            }
        } catch (Exception e3) {
            return false;
        }
    }

    public static boolean checkApiVersionAllFileExist(int i) {
        return checkApiVersionExtractResourceExist(i) && checkApiVersionBaseApkExist(i);
    }

    public static boolean checkApiVersionBaseApkExist(int i) {
        if (new File(getDownloadApkPath(i)).exists()) {
            return true;
        }
        return false;
    }

    private static boolean checkApiVersionExtractResourceExist(int i) {
        String[] strArr = MANDATORY_RESOURCES;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr[i2];
            File file = new File(getExtractedCoreDir(i) + str);
            if (file.exists()) {
                i2++;
            } else {
                Log.i(TAG, "XWalkEnvironment checkApiVersionExtractResourceExist not exist Version:" + i + ", resource name:" + str + ", Path:" + file.getAbsolutePath());
                return false;
            }
        }
        return true;
    }

    public static boolean delApiVersion(int i) {
        return a.ada(getVesionDir(i));
    }
}
