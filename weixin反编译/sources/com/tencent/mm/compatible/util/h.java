package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.os.Environment;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class h {
    private static Boolean gJv = null;

    public static File getExternalStorageDirectory() {
        if (bi.oN(q.gHP.gGY)) {
            return Environment.getExternalStorageDirectory();
        }
        return new File(q.gHP.gGY);
    }

    @TargetApi(8)
    public static File getExternalStoragePublicDirectory(String str) {
        if (bi.oN(q.gHP.gGZ)) {
            return Environment.getExternalStoragePublicDirectory(str);
        }
        return new File(q.gHP.gGZ);
    }

    public static File getDataDirectory() {
        if (bi.oN(q.gHP.gHa)) {
            return Environment.getDataDirectory();
        }
        return new File(q.gHP.gHa);
    }

    public static File getRootDirectory() {
        if (bi.oN(q.gHP.gHb)) {
            return Environment.getRootDirectory();
        }
        return new File(q.gHP.gHb);
    }

    public static File getDownloadCacheDirectory() {
        if (bi.oN(q.gHP.gHd)) {
            return Environment.getDownloadCacheDirectory();
        }
        return new File(q.gHP.gHd);
    }

    public static String getExternalStorageState() {
        if (bi.oN(q.gHP.gHc)) {
            return Environment.getExternalStorageState();
        }
        return q.gHP.gHc;
    }

    public static boolean zq() {
        Throwable e;
        if (gJv == null) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    gJv = Boolean.valueOf(properties.containsKey("ro.miui.ui.version.name"));
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                        gJv = Boolean.valueOf(false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return gJv.booleanValue();
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                x.printErrStackTrace("MicroMsg.Environment", e, "** failed to fetch miui prop, assume we are not on miui. **", new Object[0]);
                gJv = Boolean.valueOf(false);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return gJv.booleanValue();
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e;
            }
        }
        return gJv.booleanValue();
    }
}
