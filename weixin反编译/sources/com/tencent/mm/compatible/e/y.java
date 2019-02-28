package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class y {
    private static Class<?> gIs;
    private static Method gIt;
    private static Method gIu;

    static {
        gIs = null;
        gIt = null;
        gIu = null;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            gIs = cls;
            gIt = cls.getDeclaredMethod("get", new Class[]{String.class});
            gIu = gIs.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            gIt.setAccessible(true);
            gIu.setAccessible(true);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
        }
    }

    public static String get(String str) {
        try {
            return (String) gIt.invoke(null, new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SystemProperties", e, "", new Object[0]);
            return null;
        }
    }
}
