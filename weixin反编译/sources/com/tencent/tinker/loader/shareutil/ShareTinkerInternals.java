package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.wcdb.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ShareTinkerInternals {
    private static final boolean Avf = acy(System.getProperty("java.vm.version"));
    private static final boolean Avg = cId();
    private static Boolean Avh = null;
    private static String Avi = null;
    private static String Avj = null;
    private static String processName = null;

    public static boolean cHZ() {
        return Avf || VERSION.SDK_INT >= 21;
    }

    public static boolean cIa() {
        return Avg && VERSION.SDK_INT < 24;
    }

    public static boolean cIb() {
        return VERSION.SDK_INT > 25;
    }

    public static String cIc() {
        if (Avj != null) {
            return Avj;
        }
        Avj = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(Avj);
        return Avj;
    }

    public static boolean acx(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    public static ShareDexDiffPatchInfo a(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (!shareDexDiffPatchInfo.AtJ.startsWith("test.dex")) {
            return null;
        }
        String str;
        if (i != 1) {
            str = "classes" + i + ".dex";
        } else {
            str = "classes.dex";
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.AtK, shareDexDiffPatchInfo.AtL, shareDexDiffPatchInfo.AtO, shareDexDiffPatchInfo.AtM, shareDexDiffPatchInfo.AtN, shareDexDiffPatchInfo.AtP);
    }

    public static boolean oN(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    public static int a(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int i2;
        HashMap cHY;
        if (shareSecurityCheck.ak(file)) {
            String iE = iE(context);
            if (iE == null) {
                i2 = -5;
            } else {
                cHY = shareSecurityCheck.cHY();
                if (cHY == null) {
                    i2 = -2;
                } else {
                    String str = (String) cHY.get("TINKER_ID");
                    if (str == null) {
                        i2 = -6;
                    } else if (iE.equals(str)) {
                        i2 = 0;
                    } else {
                        new StringBuilder("tinkerId is not equal, base is ").append(iE).append(", but patch is ").append(str);
                        i2 = -7;
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            return i2;
        }
        Object obj;
        if (i == 7) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            cHY = shareSecurityCheck.Avd;
            if (!Jk(i) && cHY.containsKey("assets/dex_meta.txt")) {
                return -9;
            }
            if (!Jl(i) && cHY.containsKey("assets/so_meta.txt")) {
                return -9;
            }
            if (!Jm(i) && cHY.containsKey("assets/res_meta.txt")) {
                return -9;
            }
        }
        return 0;
    }

    public static Properties al(File file) {
        Throwable th;
        IOException e;
        ZipFile zipFile;
        Throwable th2;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.a(zipFile2);
                    return null;
                }
                Object inputStream;
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.cA(inputStream);
                        SharePatchFileUtil.a(zipFile2);
                        return properties;
                    } catch (Throwable th3) {
                        th = th3;
                        SharePatchFileUtil.cA(inputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
            } catch (Throwable th5) {
                th2 = th5;
                SharePatchFileUtil.a(zipFile2);
                throw th2;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            try {
                new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                SharePatchFileUtil.a(zipFile);
                return null;
            } catch (Throwable th6) {
                th2 = th6;
                zipFile2 = zipFile;
                SharePatchFileUtil.a(zipFile2);
                throw th2;
            }
        } catch (Throwable th7) {
            zipFile2 = null;
            th2 = th7;
            SharePatchFileUtil.a(zipFile2);
            throw th2;
        }
    }

    private static String iE(Context context) {
        if (Avi != null) {
            return Avi;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), FileUtils.S_IWUSR).metaData.get("TINKER_ID");
            if (obj != null) {
                Avi = String.valueOf(obj);
            } else {
                Avi = null;
            }
            return Avi;
        } catch (Exception e) {
            new StringBuilder("getManifestTinkerID exception:").append(e.getMessage());
            return null;
        }
    }

    public static boolean Jk(int i) {
        return (i & 1) != 0;
    }

    public static boolean Jl(int i) {
        return (i & 2) != 0;
    }

    public static boolean Jm(int i) {
        return (i & 4) != 0;
    }

    public static String Jn(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static void iF(Context context) {
        context.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable_1.9.4", false).commit();
    }

    public static boolean iG(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable_1.9.4", true);
    }

    public static boolean Jo(int i) {
        return i != 0;
    }

    public static boolean iH(Context context) {
        String str = null;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        }
        if (oN(str)) {
            str = context.getPackageName();
        }
        Object iK = iK(context);
        if (iK == null || iK.length() == 0) {
            iK = "";
        }
        return str.equals(iK);
    }

    public static boolean iI(Context context) {
        if (Avh != null) {
            return Avh.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(iK(context).endsWith(":patch"));
        Avh = valueOf;
        return valueOf.booleanValue();
    }

    public static String bW(Context context, String str) {
        if (!str.equals("changing")) {
            return str;
        }
        if (iH(context)) {
            return "odex";
        }
        return "interpet";
    }

    public static void iJ(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    public static String iK(Context context) {
        if (processName != null) {
            return processName;
        }
        String iL = iL(context);
        processName = iL;
        return iL;
    }

    private static String iL(Context context) {
        Exception e;
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                RunningAppProcessInfo runningAppProcessInfo;
                try {
                    for (RunningAppProcessInfo runningAppProcessInfo2 : runningAppProcesses) {
                        if (runningAppProcessInfo2.pid == myPid) {
                            break;
                        }
                    }
                    runningAppProcessInfo2 = null;
                } catch (Exception e2) {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    runningAppProcessInfo2 = null;
                }
                if (runningAppProcessInfo2 != null) {
                    return runningAppProcessInfo2.processName;
                }
            }
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if ((bArr[i] & 255) > FileUtils.S_IWUSR || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static boolean acy(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean cId() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            String str2 = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"});
            if (!oN(str) && oN(str2) && str.equals("true")) {
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isVmJitInternal ex:").append(th);
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String j(java.lang.Throwable r3) {
        /*
        if (r3 != 0) goto L_0x0006;
    L_0x0002:
        r0 = "";
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r2 = new java.io.PrintStream;
        r2.<init>(r1);
    L_0x0010:
        r0 = r3.getCause();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x0018;
    L_0x0016:
        r3 = r0;
        goto L_0x0010;
    L_0x0018:
        r3.printStackTrace(r2);	 Catch:{ all -> 0x0027 }
        r0 = r1.toString();	 Catch:{ all -> 0x0027 }
        r0 = VM(r0);	 Catch:{ all -> 0x0027 }
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.cA(r2);
        goto L_0x0005;
    L_0x0027:
        r0 = move-exception;
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.cA(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.j(java.lang.Throwable):java.lang.String");
    }

    private static String VM(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > 127) {
                toCharArray[i] = 0;
                c = 1;
                break;
            }
            i++;
        }
        c = 0;
        if (c != 0) {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}
