package com.tencent.magicbrush.a;

public final class c {

    public interface e {
        void a(String str, Throwable th, String str2, Object... objArr);

        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static class a {
        private static d bnn = new c();

        public static void a(d dVar) {
            bnn = dVar;
        }

        public static void i(int i, String str) {
            bnn.j(i, str);
        }
    }

    private static class c implements d {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void j(int i, String str) {
            f.i("Console", str, new Object[0]);
        }
    }

    public static class f {
        private static e bno = new b();

        public static void a(e eVar) {
            bno = eVar;
        }

        public static void v(String str, String str2, Object... objArr) {
            bno.v(str, str2, objArr);
        }

        public static void d(String str, String str2, Object... objArr) {
            bno.d(str, str2, objArr);
        }

        public static void i(String str, String str2, Object... objArr) {
            bno.i(str, str2, objArr);
        }

        public static void w(String str, String str2, Object... objArr) {
            bno.w(str, str2, objArr);
        }

        public static void e(String str, String str2, Object... objArr) {
            bno.e(str, str2, objArr);
        }

        public static void a(String str, Throwable th, String str2, Object... objArr) {
            bno.a(str, th, str2, objArr);
        }
    }

    private static class b implements e {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void v(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                }
            }
        }

        public final void d(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                }
            }
        }

        public final void i(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                }
            }
        }

        public final void w(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                }
            }
        }

        public final void e(String str, String str2, Object... objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                }
            }
        }

        public final void a(String str, Throwable th, String str2, Object... objArr) {
            if (th != null && objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String.format(str2, objArr);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public interface d {
        void j(int i, String str);
    }
}
