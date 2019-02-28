package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class c {
    private static Object AcH;
    private static Method AcI;
    private static boolean AcJ;

    static {
        AcH = null;
        AcI = null;
        if (VERSION.SDK_INT >= 14) {
            try {
                AcH = e.gb("libcore.io.Libcore", "os");
                AcI = e.a("libcore.io.Os", "stat", String.class);
                AcJ = true;
                return;
            } catch (Throwable th) {
            }
        }
        AcJ = false;
    }

    public static boolean isAvailable() {
        return AcJ;
    }

    public static int abD(String str) {
        if (!AcJ) {
            return 0;
        }
        Object invoke = AcI.invoke(AcH, new Object[]{str});
        if (invoke != null) {
            return ((Integer) e.a(invoke.getClass(), "st_mode", invoke)).intValue();
        }
        return 0;
    }
}
