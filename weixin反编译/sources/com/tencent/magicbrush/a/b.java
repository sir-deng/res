package com.tencent.magicbrush.a;

public final class b {
    private static a bnm = new a() {
        public final void loadLibrary(String str) {
            com.tencent.magicbrush.a.loadLibrary(str);
        }
    };

    public interface a {
        void loadLibrary(String str);
    }

    public static void a(a aVar) {
        bnm = aVar;
    }

    public static void loadLibrary(String str) {
        bnm.loadLibrary(str);
    }
}
