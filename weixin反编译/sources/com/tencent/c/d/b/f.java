package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

public final class f {
    private static Boolean AcM = null;
    private static final Object AcN = new Object();

    public static boolean cEo() {
        Boolean bool;
        boolean booleanValue;
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        synchronized (AcN) {
            if (AcM == null) {
                if (VERSION.SDK_INT < 17 || !new File("/sys/fs/selinux/enforce").exists()) {
                    bool = null;
                } else {
                    Closeable fileInputStream;
                    try {
                        fileInputStream = new FileInputStream("/sys/fs/selinux/enforce");
                        try {
                            if (fileInputStream.read() == 49) {
                                z = true;
                            }
                            Boolean valueOf = Boolean.valueOf(z);
                            b.b(fileInputStream);
                            bool = valueOf;
                        } catch (Exception e) {
                            b.b(fileInputStream);
                            bool = null;
                            if (bool == null) {
                                bool = Boolean.valueOf(false);
                            }
                            AcM = bool;
                            booleanValue = AcM.booleanValue();
                            return booleanValue;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            closeable = fileInputStream;
                            th = th3;
                            b.b(closeable);
                            throw th;
                        }
                    } catch (Exception e2) {
                        fileInputStream = null;
                        b.b(fileInputStream);
                        bool = null;
                        if (bool == null) {
                            bool = Boolean.valueOf(false);
                        }
                        AcM = bool;
                        booleanValue = AcM.booleanValue();
                        return booleanValue;
                    } catch (Throwable th4) {
                        th = th4;
                        b.b(closeable);
                        throw th;
                    }
                }
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                AcM = bool;
            }
            booleanValue = AcM.booleanValue();
        }
        return booleanValue;
    }
}
