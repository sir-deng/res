package com.tencent.d.a.c;

import junit.framework.Assert;

public final class c {
    private static b Alw = new a();

    private static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void v(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void d(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void i(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void w(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void e(String str, String str2, Object... objArr) {
            try {
                String.format(str2, objArr);
            } catch (Exception e) {
            }
        }

        public final void a(String str, Throwable th, String str2) {
        }
    }

    public static void a(b bVar) {
        Assert.assertTrue(bVar != null);
        Alw = bVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        Alw.v(str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        Alw.d(str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        Alw.i(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        Alw.w(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        Alw.e(str, str2, objArr);
    }

    public static void a(String str, Throwable th, String str2) {
        Alw.a(str, th, str2);
    }
}
