package com.tencent.tinker.loader.shareutil;

import android.os.Build;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SharePatchInfo {
    public String ArY;
    public String AuP;
    public String AuQ;
    public String AuR;

    public SharePatchInfo(String str, String str2, String str3, String str4) {
        this.AuP = str;
        this.AuQ = str2;
        this.AuR = str3;
        this.ArY = str4;
    }

    public static SharePatchInfo o(File file, File file2) {
        ShareFileLockHelper ad;
        Throwable e;
        Throwable th;
        SharePatchInfo sharePatchInfo = null;
        if (!(file == null || file2 == null)) {
            File parentFile = file2.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                ad = ShareFileLockHelper.ad(file2);
                try {
                    sharePatchInfo = aj(file);
                    try {
                        ad.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable e4) {
                th = e4;
                ad = null;
                e = th;
            } catch (Throwable e42) {
                th = e42;
                ad = null;
                e = th;
                if (ad != null) {
                    try {
                        ad.close();
                    } catch (IOException e5) {
                    }
                }
                throw e;
            }
        }
        return sharePatchInfo;
        try {
            throw new TinkerRuntimeException("readAndCheckPropertyWithLock fail", e);
        } catch (Throwable th2) {
            e = th2;
            if (ad != null) {
                ad.close();
            }
            throw e;
        }
    }

    public static boolean a(File file, SharePatchInfo sharePatchInfo, File file2) {
        if (file == null || sharePatchInfo == null || file2 == null) {
            return false;
        }
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            shareFileLockHelper = ShareFileLockHelper.ad(file2);
            boolean a = a(file, sharePatchInfo);
            try {
                shareFileLockHelper.close();
                return a;
            } catch (IOException e) {
                return a;
            }
        } catch (Throwable e2) {
            throw new TinkerRuntimeException("rewritePatchInfoFileWithLock fail", e2);
        } catch (Throwable th) {
            if (shareFileLockHelper != null) {
                try {
                    shareFileLockHelper.close();
                } catch (IOException e3) {
                }
            }
        }
    }

    private static SharePatchInfo aj(File file) {
        Object fileInputStream;
        String property;
        Object e;
        Throwable th;
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (i < 2 && i2 == 0) {
            int i3 = i + 1;
            Properties properties = new Properties();
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    str4 = properties.getProperty("old");
                    str3 = properties.getProperty("new");
                    str2 = properties.getProperty("print");
                    property = properties.getProperty("dir");
                    SharePatchFileUtil.cA(fileInputStream);
                } catch (IOException e2) {
                    e = e2;
                    try {
                        new StringBuilder("read property failed, e:").append(e);
                        SharePatchFileUtil.cA(fileInputStream);
                        property = str;
                        if (str4 != null) {
                        }
                        str = property;
                        i = i3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (IOException e3) {
                e = e3;
                fileInputStream = null;
                new StringBuilder("read property failed, e:").append(e);
                SharePatchFileUtil.cA(fileInputStream);
                property = str;
                if (str4 != null) {
                }
                str = property;
                i = i3;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
            if (str4 != null || str3 == null) {
                str = property;
                i = i3;
            } else if ((str4.equals("") || SharePatchFileUtil.acv(str4)) && SharePatchFileUtil.acv(str3)) {
                str = property;
                i2 = 1;
                i = i3;
            } else {
                new StringBuilder("path info file  corrupted:").append(file.getAbsolutePath());
                str = property;
                i = i3;
            }
        }
        if (i2 != 0) {
            return new SharePatchInfo(str4, str3, str2, str);
        }
        return null;
        SharePatchFileUtil.cA(fileInputStream);
        throw th;
    }

    private static boolean a(File file, SharePatchInfo sharePatchInfo) {
        Object fileOutputStream;
        Object e;
        SharePatchInfo aj;
        boolean z;
        Throwable th;
        if (file == null || sharePatchInfo == null) {
            return false;
        }
        if (ShareTinkerInternals.oN(sharePatchInfo.AuR)) {
            sharePatchInfo.AuR = Build.FINGERPRINT;
        }
        if (ShareTinkerInternals.oN(sharePatchInfo.ArY)) {
            sharePatchInfo.ArY = "odex";
        }
        new StringBuilder("rewritePatchInfoFile file path:").append(file.getAbsolutePath()).append(" , oldVer:").append(sharePatchInfo.AuP).append(", newVer:").append(sharePatchInfo.AuQ).append(", fingerprint:").append(sharePatchInfo.AuR).append(", oatDir:").append(sharePatchInfo.ArY);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        int i = 0;
        boolean z2 = false;
        while (i < 2 && !z2) {
            int i2 = i + 1;
            Properties properties = new Properties();
            properties.put("old", sharePatchInfo.AuP);
            properties.put("new", sharePatchInfo.AuQ);
            properties.put("print", sharePatchInfo.AuR);
            properties.put("dir", sharePatchInfo.ArY);
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    properties.store(fileOutputStream, "from old version:" + sharePatchInfo.AuP + " to new version:" + sharePatchInfo.AuQ);
                    SharePatchFileUtil.cA(fileOutputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        new StringBuilder("write property failed, e:").append(e);
                        SharePatchFileUtil.cA(fileOutputStream);
                        aj = aj(file);
                        if (aj == null) {
                        }
                        z = false;
                        if (z) {
                            file.delete();
                        }
                        z2 = z;
                        i = i2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
                new StringBuilder("write property failed, e:").append(e);
                SharePatchFileUtil.cA(fileOutputStream);
                aj = aj(file);
                if (aj == null) {
                }
                z = false;
                if (z) {
                    file.delete();
                }
                z2 = z;
                i = i2;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            aj = aj(file);
            if (aj == null && aj.AuP.equals(sharePatchInfo.AuP) && aj.AuQ.equals(sharePatchInfo.AuQ)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                file.delete();
            }
            z2 = z;
            i = i2;
        }
        if (z2) {
            return true;
        }
        return false;
        SharePatchFileUtil.cA(fileOutputStream);
        throw th;
    }
}
