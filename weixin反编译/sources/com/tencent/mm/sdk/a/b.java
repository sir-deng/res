package com.tencent.mm.sdk.a;

public final class b {
    public static boolean foreground = false;
    public static String xmr = "unknow";
    private static c xms = null;
    private static boolean xmt = false;
    private static String xmu = null;
    private static boolean xmv = false;
    private static boolean xmw = false;

    public static void a(c cVar) {
        xms = cVar;
    }

    public static void z(String str, String str2) {
        if (xms != null) {
            xms.z(str, str2);
        }
    }

    public static void l(int i, String str) {
        if (xms != null) {
            xms.l(i, str);
        }
    }

    public static void bF(boolean z) {
        foreground = z;
    }

    public static void Vm(String str) {
        xmr = str;
    }

    public static void a(a aVar) {
        if (xms != null) {
            xms.a(aVar);
        }
    }

    public static void lF(boolean z) {
        xmv = z;
    }

    public static boolean cfv() {
        return xmv;
    }

    public static void cfw() {
        xmt = true;
    }

    public static boolean cfx() {
        return xmt;
    }

    public static void Vn(String str) {
        xmu = str;
    }

    public static String cfy() {
        return xmu;
    }

    public static boolean cfz() {
        return xmw;
    }

    public static void lG(boolean z) {
        xmw = z;
    }
}
