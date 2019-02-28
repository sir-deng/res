package com.tencent.mm.plugin.appbrand;

public interface p {

    public interface a {
        void a(c cVar);
    }

    public static class b implements p {
        public final boolean Ze() {
            return false;
        }

        public final String pL(String str) {
            return "__APP__";
        }

        public final void a(String str, a aVar) {
            aVar.a(c.OK);
        }
    }

    public enum c {
        OK,
        FAIL,
        CANCEL
    }

    boolean Ze();

    void a(String str, a aVar);

    String pL(String str);
}
