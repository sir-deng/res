package com.tencent.mm.svg.b;

import java.lang.reflect.Field;

public final class b {
    private static boolean gUI = false;
    private static String mPackageName = "";
    private static boolean xLu = false;
    private static boolean xLv = false;

    public static void cu(String str) {
        mPackageName = str;
    }

    public static final boolean clV() {
        return xLv;
    }

    public static final void lR(boolean z) {
        xLv = z;
    }

    private static final Object YQ(String str) {
        try {
            Class cls = Class.forName(mPackageName + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Throwable e) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
        } catch (Throwable e2) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
        } catch (Throwable e22) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e22, "ClassNotFoundException", new Object[0]);
        } catch (Throwable e222) {
            c.printErrStackTrace("MicroMSG.WeChatSVGConfig", e222, "IllegalAccessException", new Object[0]);
        }
        return null;
    }

    public static final boolean clW() {
        if (!gUI) {
            Object YQ = YQ("WxSVGCode");
            if (YQ == null) {
                xLu = false;
            } else {
                xLu = ((Boolean) YQ).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(xLu));
            gUI = true;
        }
        if (xLu) {
            return false;
        }
        return true;
    }

    public static final Class<?> clX() {
        Object YQ = YQ("WxSVGRawClass");
        if (YQ != null) {
            return (Class) YQ;
        }
        return null;
    }

    public static long clY() {
        return System.nanoTime();
    }

    public static long fU(long j) {
        return (System.nanoTime() - j) / 1000;
    }
}
