package com.tencent.mm.plugin.secinforeport.a;

import com.tencent.mm.sdk.platformtools.x;

public enum d implements c {
    ;
    
    private static c qlj;

    private static class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean G(int i, long j) {
            x.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
            return false;
        }

        public final void JC(String str) {
            x.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
        }

        public final void ca(String str, int i) {
            x.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
        }

        public final void JD(String str) {
            x.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
        }

        public final void bqZ() {
            x.w("MicroMsg.SecInfoReporter", "!! Dummy implementation !!");
        }
    }

    private d(String str) {
    }

    static {
        qlj = new a();
    }

    public static void a(c cVar) {
        if (cVar != null) {
            qlj = cVar;
        }
    }

    public final boolean G(int i, long j) {
        return qlj.G(i, j);
    }

    public final void JC(String str) {
        qlj.JC(str);
    }

    public final void ca(String str, int i) {
        qlj.ca(str, i);
    }

    public final void JD(String str) {
        qlj.JD(str);
    }

    public final void bqZ() {
        qlj.bqZ();
    }
}
