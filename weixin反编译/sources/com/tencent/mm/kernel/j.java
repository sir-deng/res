package com.tencent.mm.kernel;

public final class j {
    private static volatile a gSQ = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        gSQ = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (gSQ != null) {
            gSQ.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (gSQ != null) {
            gSQ.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (gSQ != null) {
            gSQ.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (gSQ != null) {
            gSQ.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (gSQ != null) {
            gSQ.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
