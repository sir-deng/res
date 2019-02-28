package com.tencent.mm.plugin.appbrand.page;

public final class b {

    public enum a {
        ;

        public static int[] ajp() {
            return (int[]) jIm.clone();
        }

        static {
            jIi = 1;
            jIj = 2;
            jIk = 3;
            jIl = 4;
            jIm = new int[]{jIi, jIj, jIk, jIl};
        }
    }

    private static final class b extends com.tencent.mm.plugin.appbrand.jsapi.b {
        static final int CTRL_INDEX = 237;
        static final String NAME = "config_navigationBarRightButton";
        static b jIn = new b();

        private b() {
        }
    }

    public static int a(final p pVar, final boolean z) {
        if (pVar == null) {
            return a.jIi;
        }
        pVar.getContentView().post(new Runnable() {
            public final void run() {
                pVar.jJr.ds(!z);
            }
        });
        return a.jIl;
    }
}
