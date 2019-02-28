package com.tencent.mm.i;

import com.tencent.mm.storage.au;

public interface a {

    public static class a {
        private static a gDw = null;

        public static void a(a aVar) {
            gDw = aVar;
        }

        public static a xK() {
            return gDw;
        }
    }

    void b(au auVar);

    String c(au auVar);

    boolean eG(String str);

    String z(String str, int i);
}
