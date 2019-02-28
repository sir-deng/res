package com.tencent.c.f;

public final class h {
    private static boolean Aea;
    private static g Aeb;

    static {
        Aea = false;
        Aeb = new k();
        Aea = false;
        Aeb = new k();
    }

    public static void k(Throwable th) {
        cw(th);
    }

    public static void cw(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void cx(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Exception) {
            new StringBuilder().append(obj);
        } else {
            obj.toString();
        }
    }

    public static void abG(String str) {
        cy(str);
    }

    public static void abH(String str) {
        cy(str);
    }

    public static void cy(Object obj) {
        if (obj != null) {
            obj.toString();
        }
    }
}
