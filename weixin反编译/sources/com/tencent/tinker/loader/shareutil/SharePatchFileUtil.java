package com.tencent.tinker.loader.shareutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharePatchFileUtil {
    private static char[] xnH = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static File iA(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker");
    }

    public static File iB(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, "tinker_temp");
    }

    public static File iC(Context context) {
        File iB = iB(context);
        if (iB == null) {
            return null;
        }
        return new File(iB, "tinker_last_crash");
    }

    public static File acr(String str) {
        return new File(str + "/patch.info");
    }

    public static File acs(String str) {
        return new File(str + "/info.lock");
    }

    public static String act(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return "patch-" + str.substring(0, 8);
    }

    public static String acu(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return act(str) + ".apk";
    }

    public static boolean acv(String str) {
        if (str == null || str.length() != 32) {
            return false;
        }
        return true;
    }

    public static String iD(Context context) {
        Object e;
        Throwable th;
        File iC = iC(context);
        if (!ae(iC)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Object bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(iC)));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } else {
                        cA(bufferedReader);
                        return stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            e = e3;
            bufferedReader = null;
            try {
                new StringBuilder("checkTinkerLastUncaughtCrash exception: ").append(e);
                cA(bufferedReader);
                return null;
            } catch (Throwable th2) {
                th = th2;
                cA(bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            cA(bufferedReader);
            throw th;
        }
    }

    @SuppressLint({"NewApi"})
    public static void cA(Object obj) {
        if (obj != null) {
            if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                } catch (Throwable th) {
                }
            } else if (VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                try {
                    ((AutoCloseable) obj).close();
                } catch (Throwable th2) {
                }
            } else if (obj instanceof ZipFile) {
                try {
                    ((ZipFile) obj).close();
                } catch (Throwable th3) {
                }
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        }
    }

    public static final boolean ae(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static long af(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            long af;
            if (file2.isDirectory()) {
                af = af(file2);
            } else {
                af = file2.length();
            }
            j += af;
        }
        return j;
    }

    public static final boolean ag(File file) {
        boolean z = true;
        if (file != null && file.exists()) {
            new StringBuilder("safeDeleteFile, try to delete path: ").append(file.getPath());
            z = file.delete();
            if (!z) {
                new StringBuilder("Failed to delete file, try to delete when exit. path: ").append(file.getPath());
                file.deleteOnExit();
            }
        }
        return z;
    }

    public static final boolean bP(String str) {
        if (str == null) {
            return false;
        }
        return g(new File(str));
    }

    public static final boolean g(File file) {
        int i = 0;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            ag(file);
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    g(listFiles[i]);
                    i++;
                }
                ag(file);
            }
        }
        return true;
    }

    public static boolean f(File file, String str) {
        if (str == null) {
            return false;
        }
        String ah = ah(file);
        if (ah != null) {
            return str.equals(ah);
        }
        return false;
    }

    public static boolean acw(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(".dex");
    }

    public static boolean g(File file, String str) {
        return b(file, "classes.dex", str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.io.File r7, java.lang.String r8, java.lang.String r9) {
        /*
        r1 = 0;
        r0 = 0;
        if (r7 == 0) goto L_0x0008;
    L_0x0004:
        if (r9 == 0) goto L_0x0008;
    L_0x0006:
        if (r8 != 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r2 = r7.getName();
        r2 = acw(r2);
        if (r2 == 0) goto L_0x001c;
    L_0x0013:
        r0 = ah(r7);
    L_0x0017:
        r0 = r9.equals(r0);
        goto L_0x0008;
    L_0x001c:
        r3 = new java.util.zip.ZipFile;	 Catch:{ Throwable -> 0x008c, all -> 0x0086 }
        r3.<init>(r7);	 Catch:{ Throwable -> 0x008c, all -> 0x0086 }
        r2 = r3.getEntry(r8);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        if (r2 != 0) goto L_0x003a;
    L_0x0027:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        r2 = "There's no entry named: classes.dex in ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        r2 = r7.getAbsolutePath();	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        a(r3);
        goto L_0x0008;
    L_0x003a:
        r1 = r3.getInputStream(r2);	 Catch:{ Throwable -> 0x0050, all -> 0x0079 }
        w(r1);	 Catch:{ Throwable -> 0x0050 }
        cA(r1);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
    L_0x0044:
        r1 = r3.getInputStream(r2);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        r0 = w(r1);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        a(r3);
        goto L_0x0017;
    L_0x0050:
        r4 = move-exception;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008e }
        r5 = "exception occurred when get md5: ";
        r4.<init>(r5);	 Catch:{ all -> 0x008e }
        r5 = r7.getAbsolutePath();	 Catch:{ all -> 0x008e }
        r4.append(r5);	 Catch:{ all -> 0x008e }
        cA(r1);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        goto L_0x0044;
    L_0x0064:
        r1 = move-exception;
        r1 = r3;
    L_0x0066:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0089 }
        r3 = "Bad dex jar file: ";
        r2.<init>(r3);	 Catch:{ all -> 0x0089 }
        r3 = r7.getAbsolutePath();	 Catch:{ all -> 0x0089 }
        r2.append(r3);	 Catch:{ all -> 0x0089 }
        a(r1);
        goto L_0x0008;
    L_0x0079:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
    L_0x007d:
        cA(r2);	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
        throw r1;	 Catch:{ Throwable -> 0x0064, all -> 0x0081 }
    L_0x0081:
        r0 = move-exception;
    L_0x0082:
        a(r3);
        throw r0;
    L_0x0086:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0082;
    L_0x0089:
        r0 = move-exception;
        r3 = r1;
        goto L_0x0082;
    L_0x008c:
        r2 = move-exception;
        goto L_0x0066;
    L_0x008e:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x007d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.b(java.io.File, java.lang.String, java.lang.String):boolean");
    }

    public static void m(File file, File file2) {
        Object fileOutputStream;
        Throwable th;
        Object obj = null;
        if (ae(file) && file2 != null && !file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            File parentFile = file2.getParentFile();
            if (!(parentFile == null || parentFile.exists())) {
                parentFile.mkdirs();
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, false);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    FileInputStream obj2 = fileInputStream;
                    cA(obj2);
                    cA(fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            cA(fileInputStream);
                            cA(fileOutputStream);
                            return;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj2 = fileInputStream;
                    cA(obj2);
                    cA(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                cA(obj2);
                cA(fileOutputStream);
                throw th;
            }
        }
    }

    public static String a(JarFile jarFile, JarEntry jarEntry) {
        Throwable th;
        StringBuilder stringBuilder = new StringBuilder();
        Object bufferedInputStream;
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read > 0) {
                        stringBuilder.append(new String(bArr, 0, read));
                    } else {
                        cA(bufferedInputStream);
                        return stringBuilder.toString();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            cA(bufferedInputStream);
            throw th;
        }
    }

    private static String w(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuilder stringBuilder = new StringBuilder(32);
            byte[] bArr = new byte[102400];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            for (byte b : digest) {
                stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String bS(byte[] bArr) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr = new char[(length * 2)];
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr[i2] = xnH[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = xnH[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static String ah(File file) {
        Throwable th;
        String str = null;
        if (file != null && file.exists()) {
            Object fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    str = w(fileInputStream);
                    cA(fileInputStream);
                } catch (Exception e) {
                    cA(fileInputStream);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    cA(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                fileInputStream = str;
                cA(fileInputStream);
                return str;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                fileInputStream = str;
                th = th4;
                cA(fileInputStream);
                throw th;
            }
        }
        return str;
    }

    public static String n(File file, File file2) {
        String name;
        if (ShareTinkerInternals.cIb()) {
            try {
                String cIc = ShareTinkerInternals.cIc();
                File parentFile = file.getParentFile();
                name = file.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    name = name.substring(0, lastIndexOf);
                }
                return parentFile.getAbsolutePath() + "/oat/" + cIc + "/" + name + ".odex";
            } catch (Throwable e) {
                throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e);
            }
        }
        name = file.getName();
        if (!name.endsWith(".dex")) {
            int lastIndexOf2 = name.lastIndexOf(".");
            if (lastIndexOf2 < 0) {
                name = name + ".dex";
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf2 + 4);
                stringBuilder.append(name, 0, lastIndexOf2);
                stringBuilder.append(".dex");
                name = stringBuilder.toString();
            }
        }
        return new File(file2, name).getPath();
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static boolean h(File file, String str) {
        Throwable th;
        Throwable th2;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("resources.arsc");
                if (entry == null) {
                    a(zipFile2);
                    return false;
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                String w = w(inputStream);
                if (w == null || !w.equals(str)) {
                    cA(inputStream);
                    a(zipFile2);
                    return false;
                }
                cA(inputStream);
                a(zipFile2);
                return true;
            } catch (Throwable th3) {
                th2 = th3;
                zipFile = zipFile2;
                a(zipFile);
                throw th2;
            }
        } catch (Throwable th4) {
            th = th4;
            try {
                new StringBuilder("checkResourceArscMd5 throwable:").append(th.getMessage());
                a(zipFile);
                return false;
            } catch (Throwable th5) {
                th2 = th5;
                a(zipFile);
                throw th2;
            }
        }
    }

    public static void ai(File file) {
        if (file != null) {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
        }
    }
}
