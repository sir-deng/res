package com.tencent.mm.plugin.appbrand.appstorage;

import android.annotation.TargetApi;
import android.support.annotation.Keep;
import android.system.Os;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.j.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

@Keep
public final class AppBrandLocalMediaObjectManager {
    private static final Collection<a> MEDIA_OBJECT_INFO_HANDLERS;
    private static final AppBrandLocalMediaObject Nil = new AppBrandLocalMediaObject() {
        public final String toString() {
            return "AppBrandLocalMediaObject::Nil";
        }
    };
    public static final String OBJECT_NAME_PREFIX = "wxfile://";
    static final String OBJECT_ROOT_DIR_PATH;
    static final String PREFIX_STORE_FILE = "store_";
    static final String PREFIX_TEMP_FILE = "tmp_";
    static final String PREFIX_TEMP_VOICE = "tmpvoice_";
    static final String SUFFIX_PERMANENT_FILE = ".dat";
    static final String SUFFIX_TEMP_FILE = ".tmp";
    private static final String TAG = "MicroMsg.AppBrand.LocalMediaObjectManager";

    private interface a {
        AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject);

        AppBrandLocalMediaObject aR(String str, String str2);

        com.tencent.mm.vending.j.a b(String str, String str2, String str3, boolean z);

        AppBrandLocalMediaObject c(String str, String str2, boolean z);
    }

    private static final class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject c(String str, String str2, boolean z) {
            String str3 = null;
            if (!str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE) && !str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE) && !str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_TEMP_VOICE)) {
                return str3;
            }
            String TC = s.TC(str2);
            String replaceFirst = str2.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE, "").replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, "");
            if (z) {
                replaceFirst = replaceFirst.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_VOICE, "");
            }
            if (!bi.oN(TC)) {
                replaceFirst = replaceFirst.replaceFirst("." + TC, "");
            }
            if (bi.oN(replaceFirst)) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            try {
                str3 = AppBrandLocalMediaObjectManager.decrypt(replaceFirst, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
            }
            if (bi.oN(str3)) {
                x.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                return AppBrandLocalMediaObjectManager.Nil;
            }
            String[] split = str3.split("\\|");
            if (split == null || split.length != 2) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            if (z) {
                str3 = AppBrandLocalMediaObjectManager.PREFIX_TEMP_VOICE;
                replaceFirst = AppBrandLocalMediaObjectManager.getTmpVoiceDir(str) + str3 + replaceFirst;
            } else {
                str3 = str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE) ? AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE : AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE;
                replaceFirst = AppBrandLocalMediaObjectManager.getParentDir(str) + str3 + replaceFirst;
            }
            long j = bi.getLong(split[0], 0);
            String str4 = split[1];
            if (!str4.equalsIgnoreCase(TC)) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            try {
                if (j != AppBrandLocalMediaObjectManager.getCRC(replaceFirst)) {
                    x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", Long.valueOf(AppBrandLocalMediaObjectManager.getCRC(replaceFirst)), Long.valueOf(j), str2, str);
                    return AppBrandLocalMediaObjectManager.Nil;
                }
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.fvn = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(str2).toString();
                appBrandLocalMediaObject.hjJ = replaceFirst;
                appBrandLocalMediaObject.mimeType = s.TA(str4);
                appBrandLocalMediaObject.iKL = str3.equalsIgnoreCase(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
                File file = new File(appBrandLocalMediaObject.hjJ);
                appBrandLocalMediaObject.iKM = file.lastModified();
                appBrandLocalMediaObject.igZ = file.length();
                return appBrandLocalMediaObject;
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", bi.i(e2));
                return AppBrandLocalMediaObjectManager.Nil;
            }
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            if (appBrandLocalMediaObject == null) {
                return null;
            }
            String replaceFirst = appBrandLocalMediaObject.hjJ.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
            if (!i.aS(appBrandLocalMediaObject.hjJ, replaceFirst)) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject2.hjJ = replaceFirst;
            appBrandLocalMediaObject2.fvn = appBrandLocalMediaObject.fvn.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
            appBrandLocalMediaObject2.igZ = appBrandLocalMediaObject.igZ;
            appBrandLocalMediaObject2.iKK = appBrandLocalMediaObject.iKK;
            appBrandLocalMediaObject2.iKM = new File(appBrandLocalMediaObject2.hjJ).lastModified();
            appBrandLocalMediaObject2.mimeType = appBrandLocalMediaObject.mimeType;
            appBrandLocalMediaObject2.iKL = true;
            return appBrandLocalMediaObject2;
        }

        public final com.tencent.mm.vending.j.a b(String str, String str2, String str3, boolean z) {
            String aD = bi.aD(str3, "unknown");
            try {
                String access$600;
                Long valueOf = Long.valueOf(AppBrandLocalMediaObjectManager.getCRC(str2));
                try {
                    access$600 = AppBrandLocalMediaObjectManager.encrypt(String.format(Locale.US, "%d|%s", new Object[]{valueOf, aD}), str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    access$600 = null;
                }
                if (bi.oN(access$600)) {
                    return null;
                }
                String str4;
                if (z) {
                    access$600 = new StringBuilder(AppBrandLocalMediaObjectManager.PREFIX_TEMP_VOICE).append(access$600).toString();
                    str4 = AppBrandLocalMediaObjectManager.getTmpVoiceDir(str) + access$600;
                } else {
                    access$600 = new StringBuilder(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE).append(access$600).toString();
                    str4 = AppBrandLocalMediaObjectManager.getParentDir(str) + access$600;
                }
                String stringBuilder = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(access$600).append(bi.oN(aD) ? "" : "." + aD).toString();
                x.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", stringBuilder, str4);
                com.tencent.mm.vending.j.a dVar = new d();
                dVar.zMj = new Object[]{stringBuilder, str4, aD};
                return (d) dVar;
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", bi.i(e2));
                return null;
            }
        }

        public final AppBrandLocalMediaObject aR(String str, String str2) {
            String access$300;
            String replaceFirst = str2.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE, "").replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, "");
            try {
                access$300 = AppBrandLocalMediaObjectManager.decrypt(replaceFirst, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                access$300 = null;
            }
            if (bi.oN(access$300)) {
                return null;
            }
            String[] split = access$300.split("\\|");
            if (split == null || split.length != 2) {
                return null;
            }
            access$300 = split[1];
            access$300 = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(str2).append(bi.oN(access$300) ? "" : "." + access$300).toString();
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.fvn = access$300;
            appBrandLocalMediaObject.hjJ = AppBrandLocalMediaObjectManager.getParentDir(str) + str2;
            appBrandLocalMediaObject.iKK = replaceFirst;
            appBrandLocalMediaObject.iKL = true;
            File file = new File(appBrandLocalMediaObject.hjJ);
            appBrandLocalMediaObject.iKM = file.lastModified();
            appBrandLocalMediaObject.igZ = file.length();
            return appBrandLocalMediaObject;
        }
    }

    private static final class b {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private AppBrandLocalMediaObjectManager() {
    }

    static {
        String str = e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        OBJECT_ROOT_DIR_PATH = str + "wxafiles/";
        Collection linkedList = new LinkedList();
        linkedList.add(new c());
        MEDIA_OBJECT_INFO_HANDLERS = Collections.unmodifiableCollection(linkedList);
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            return null;
        }
        return getParentDir(str) + str2;
    }

    @TargetApi(21)
    private static void symlinkOs(String str, String str2) {
        b bVar = new b();
        Os.symlink(str, str2);
    }

    private static boolean createLocalFileLink(boolean z, String str, String str2) {
        if (z && i.aS(str, str2)) {
            return true;
        }
        if (z || !k.fv(str, str2)) {
            return false;
        }
        return true;
    }

    public static void clear(String str) {
        if (!bi.oN(str)) {
            com.tencent.mm.a.e.bP(getParentDirWithoutCheckExistence(str));
        }
    }

    public static List<AppBrandLocalMediaObject> listStoredFiles(String str) {
        File[] listStoredRawFiles = listStoredRawFiles(str);
        if (listStoredRawFiles == null || listStoredRawFiles.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : listStoredRawFiles) {
            AppBrandLocalMediaObject infoByRealFileName = getInfoByRealFileName(str, name.getName());
            if (infoByRealFileName != null) {
                linkedList.add(infoByRealFileName);
            }
        }
        return linkedList;
    }

    private static File[] listStoredRawFiles(String str) {
        File file = new File(getParentDir(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.exists() && !file.isDirectory() && !bi.oN(file.getName()) && file.getName().startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
                }
            });
        }
        return null;
    }

    private static File[] listTmpRawFiles(String str) {
        File file = new File(getParentDir(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    return file.exists() && !file.isDirectory() && !bi.oN(file.getName()) && file.getName().startsWith(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE);
                }
            });
        }
        return null;
    }

    public static List<AppBrandLocalMediaObject> listTmpFiles(String str) {
        File[] listTmpRawFiles = listTmpRawFiles(str);
        if (listTmpRawFiles == null || listTmpRawFiles.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : listTmpRawFiles) {
            AppBrandLocalMediaObject infoByRealFileName = getInfoByRealFileName(str, name.getName());
            if (infoByRealFileName != null) {
                linkedList.add(infoByRealFileName);
            }
        }
        return linkedList;
    }

    public static long getTmpFilesOccupation(String str) {
        long j = 0;
        File[] listTmpRawFiles = listTmpRawFiles(str);
        if (listTmpRawFiles != null && listTmpRawFiles.length > 0) {
            int i = 0;
            while (i < listTmpRawFiles.length) {
                long length = listTmpRawFiles[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static long getStoredFilesOccupation(String str) {
        long j = 0;
        File[] listStoredRawFiles = listStoredRawFiles(str);
        if (listStoredRawFiles != null && listStoredRawFiles.length > 0) {
            int i = 0;
            while (i < listStoredRawFiles.length) {
                long length = listStoredRawFiles[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static String getTmpVoiceLocalIdPrefix() {
        return "wxfile://tmpvoice_";
    }

    public static AppBrandLocalVideoObject attachVideo(String str, String str2) {
        return (AppBrandLocalVideoObject) attachCast(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
    }

    public static AppBrandLocalTmpVoiceObject attachTmpVoice(String str, String str2, String str3, boolean z) {
        AppBrandLocalTmpVoiceObject appBrandLocalTmpVoiceObject = (AppBrandLocalTmpVoiceObject) attachCast(str, str2, AppBrandLocalTmpVoiceObject.class, str3, false);
        if (z) {
            com.tencent.mm.loader.stub.b.deleteFile(str2);
        }
        return appBrandLocalTmpVoiceObject;
    }

    public static AppBrandLocalTmpVoiceObject attachTmpVoiceFullPath(String str, String str2, String str3) {
        if (bi.oN(str) || !com.tencent.mm.a.e.bO(str2)) {
            return null;
        }
        String nilAs = nilAs(s.TC(str2), str3);
        com.tencent.mm.vending.j.a aVar = null;
        for (a b : MEDIA_OBJECT_INFO_HANDLERS) {
            aVar = b.b(str, str2, nilAs, true);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.vending.j.a aVar2 = aVar;
        if (aVar2 == null || aVar2.size() < 2) {
            String str4 = TAG;
            nilAs = "attachCast, no handler return correct info, attach.size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVar2 == null ? -1 : aVar2.size());
            x.e(str4, nilAs, objArr);
            return null;
        }
        try {
            AppBrandLocalTmpVoiceObject appBrandLocalTmpVoiceObject = new AppBrandLocalTmpVoiceObject();
            appBrandLocalTmpVoiceObject.fvn = (String) aVar2.get(0);
            appBrandLocalTmpVoiceObject.mimeType = s.TA(nilAs);
            appBrandLocalTmpVoiceObject.hjJ = (String) aVar2.get(1);
            if (bi.oN(appBrandLocalTmpVoiceObject.hjJ)) {
                x.e(TAG, "attachCast appId %s, Null Or Nil fileFullPath");
                return null;
            }
            appBrandLocalTmpVoiceObject.iKK = bi.aD((String) aVar2.get(3), bi.aD(nilAs, "unknown"));
            return appBrandLocalTmpVoiceObject;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            return null;
        }
    }

    private static <T extends AppBrandLocalMediaObject> T attachCast(String str, String str2, Class<T> cls, String str3, boolean z) {
        if (bi.oN(str) || !com.tencent.mm.a.e.bO(str2)) {
            return null;
        }
        boolean z2;
        String nilAs = nilAs(s.TC(str2), str3);
        try {
            boolean z3;
            if (((AppBrandLocalMediaObject) cls.newInstance()) instanceof AppBrandLocalTmpVoiceObject) {
                z3 = true;
            } else {
                z3 = false;
            }
            z2 = z3;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            z2 = false;
        }
        com.tencent.mm.vending.j.a aVar = null;
        for (a b : MEDIA_OBJECT_INFO_HANDLERS) {
            aVar = b.b(str, str2, nilAs, z2);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.vending.j.a aVar2 = aVar;
        if (aVar2 == null || aVar2.size() < 2) {
            int i;
            nilAs = TAG;
            String str4 = "attachCast, no handler return correct info, attach.size = %d";
            Object[] objArr = new Object[1];
            if (aVar2 == null) {
                i = -1;
            } else {
                i = aVar2.size();
            }
            objArr[0] = Integer.valueOf(i);
            x.e(nilAs, str4, objArr);
            return null;
        }
        try {
            T t = (AppBrandLocalMediaObject) cls.newInstance();
            t.fvn = (String) aVar2.get(0);
            t.mimeType = s.TA(nilAs);
            t.hjJ = (String) aVar2.get(1);
            if (bi.oN(t.hjJ)) {
                x.e(TAG, "attachCast appId %s, Null Or Nil fileFullPath");
                return null;
            }
            t.iKK = bi.aD((String) aVar2.get(3), bi.aD(nilAs, "unknown"));
            if (!createLocalFileLink(z, str2, t.hjJ)) {
                return null;
            }
            File file = new File(t.hjJ);
            t.igZ = file.length();
            t.iKM = file.lastModified();
            return t;
        } catch (Throwable e2) {
            x.printErrStackTrace(TAG, e2, "", new Object[0]);
            return null;
        }
    }

    private static String nilAs(String str, String str2) {
        return bi.oN(str) ? str2 : str;
    }

    public static AppBrandLocalMediaObject attach(String str, String str2) {
        return attach(str, str2, null, false);
    }

    public static AppBrandLocalMediaObject attach(String str, String str2, boolean z) {
        return attach(str, str2, null, z);
    }

    public static AppBrandLocalMediaObject attach(String str, String str2, String str3, boolean z) {
        return attachCast(str, str2, AppBrandLocalMediaObject.class, str3, z);
    }

    private static String getParentDirWithoutCheckExistence(String str) {
        return OBJECT_ROOT_DIR_PATH + str + "/";
    }

    private static String getParentDir(String str) {
        String parentDirWithoutCheckExistence = getParentDirWithoutCheckExistence(str);
        i.QZ(parentDirWithoutCheckExistence);
        try {
            new File(parentDirWithoutCheckExistence, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        return parentDirWithoutCheckExistence;
    }

    public static String getTmpVoiceDir(String str) {
        String str2 = ad.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint" + File.separator + str + File.separator;
        i.QZ(str2);
        try {
            new File(str2, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        return str2;
    }

    private static String encrypt(String str, String str2) {
        return bi.bA(new com.tencent.mm.platformtools.s().encrypt(str.getBytes(), str2.getBytes()));
    }

    private static String decrypt(String str, String str2) {
        byte[] Wj = bi.Wj(str);
        com.tencent.mm.platformtools.s sVar = new com.tencent.mm.platformtools.s();
        byte[] bytes = str2.getBytes();
        int length = Wj.length;
        sVar.preCrypt = 0;
        sVar.crypt = 0;
        sVar.key = bytes;
        bytes = new byte[8];
        if (length % 8 != 0 || length < 16) {
            bytes = null;
        } else {
            sVar.prePlain = sVar.decipher(Wj, 0);
            if (sVar.prePlain == null) {
                bytes = null;
            } else {
                sVar.pos = sVar.prePlain[0] & 7;
                int i = (length - sVar.pos) - 10;
                if (i < 0) {
                    bytes = null;
                } else {
                    for (int i2 = 0; i2 < 8; i2++) {
                        bytes[i2] = (byte) 0;
                    }
                    sVar.out = new byte[i];
                    sVar.preCrypt = 0;
                    sVar.crypt = 8;
                    sVar.contextStart = 8;
                    sVar.pos++;
                    sVar.padding = 1;
                    while (sVar.padding <= 2) {
                        if (sVar.pos < 8) {
                            sVar.pos++;
                            sVar.padding++;
                        }
                        if (sVar.pos == 8) {
                            if (!sVar.decrypt8Bytes(Wj, 0, length)) {
                                bytes = null;
                                break;
                            }
                            bytes = Wj;
                        }
                    }
                    byte[] bArr = bytes;
                    int i3 = 0;
                    while (i != 0) {
                        if (sVar.pos < 8) {
                            sVar.out[i3] = (byte) (bArr[(sVar.preCrypt + 0) + sVar.pos] ^ sVar.prePlain[sVar.pos]);
                            i3++;
                            i--;
                            sVar.pos++;
                        }
                        if (sVar.pos == 8) {
                            sVar.preCrypt = sVar.crypt - 8;
                            if (!sVar.decrypt8Bytes(Wj, 0, length)) {
                                bytes = null;
                                break;
                            }
                            bArr = Wj;
                        }
                    }
                    sVar.padding = 1;
                    bytes = bArr;
                    while (sVar.padding < 8) {
                        if (sVar.pos < 8) {
                            if ((bytes[(sVar.preCrypt + 0) + sVar.pos] ^ sVar.prePlain[sVar.pos]) != 0) {
                                bytes = null;
                                break;
                            }
                            sVar.pos++;
                        }
                        if (sVar.pos == 8) {
                            sVar.preCrypt = sVar.crypt;
                            if (!sVar.decrypt8Bytes(Wj, 0, length)) {
                                bytes = null;
                                break;
                            }
                            bytes = Wj;
                        }
                        sVar.padding++;
                    }
                    bytes = sVar.out;
                }
            }
        }
        if (bi.oN(str)) {
            return null;
        }
        return new String(bytes);
    }

    public static AppBrandLocalMediaObject markPermanent(String str, AppBrandLocalMediaObject appBrandLocalMediaObject) {
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        for (a a : MEDIA_OBJECT_INFO_HANDLERS) {
            appBrandLocalMediaObject2 = a.a(appBrandLocalMediaObject);
            if (appBrandLocalMediaObject2 != null) {
                break;
            }
        }
        return appBrandLocalMediaObject2;
    }

    private static AppBrandLocalMediaObject getInfoByRealFileName(String str, String str2) {
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        if (!bi.oN(str) && !bi.oN(str2)) {
            for (a aR : MEDIA_OBJECT_INFO_HANDLERS) {
                appBrandLocalMediaObject = aR.aR(str, str2);
                if (appBrandLocalMediaObject != null) {
                    break;
                }
            }
        }
        return appBrandLocalMediaObject;
    }

    @Deprecated
    public static AppBrandLocalMediaObject getItemByLocalId(String str, String str2) {
        if (bi.oN(str2) || !str2.startsWith(OBJECT_NAME_PREFIX) || bi.oN(str)) {
            x.e(TAG, "getItemByLocalId, invalid args, localId(%s), appId(%s) ", str2, str);
            return null;
        }
        boolean z;
        if (str2.startsWith("wxfile://tmpvoice_")) {
            z = true;
        } else {
            z = false;
        }
        if (str2.startsWith("wxfile://usr")) {
            File ql = new e(o.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.h(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).qt(str)), str).ql(str2);
            if (ql == null || !ql.exists() || !ql.isFile()) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.fvn = str2;
            appBrandLocalMediaObject.hjJ = ql.getAbsolutePath();
            appBrandLocalMediaObject.mimeType = s.TB(str2);
            appBrandLocalMediaObject.iKL = true;
            appBrandLocalMediaObject.igZ = ql.length();
            appBrandLocalMediaObject.iKM = ql.lastModified();
            return appBrandLocalMediaObject;
        }
        AppBrandLocalMediaObject c;
        String substring = str2.substring(9);
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        for (a c2 : MEDIA_OBJECT_INFO_HANDLERS) {
            c = c2.c(str, substring, z);
            if (c != null) {
                x.i(TAG, "getItemByLocalId, handled by %s, result = %s", c2.toString(), c);
                break;
            }
            appBrandLocalMediaObject2 = c;
        }
        c = appBrandLocalMediaObject2;
        if (Nil != c) {
            return c;
        }
        return null;
    }

    @Keep
    @Deprecated
    public static String getFilePathByLocalId(String str, String str2) {
        AppBrandLocalMediaObject itemByLocalId = getItemByLocalId(str, str2);
        return itemByLocalId == null ? null : itemByLocalId.hjJ;
    }

    private static long getCRC(String str) {
        Closeable fileInputStream = new FileInputStream(str);
        Closeable checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        bi.d(checkedInputStream);
        bi.d(fileInputStream);
        return value;
    }
}
