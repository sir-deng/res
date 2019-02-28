package com.tencent.mm.plugin.appbrand.game.c;

import android.os.Process;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.al;

public final class f {
    public al jcp;
    c jcq;
    volatile int jcr;
    public int jcs;

    private class a implements com.tencent.mm.sdk.platformtools.al.a {
        private a() {
        }

        public /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final boolean uG() {
            synchronized (f.this) {
                f.this.jcr = (int) Math.round(f.this.jcq.ajZ());
            }
            return true;
        }
    }

    public f() {
        this.jcr = 0;
        this.jcs = 1000;
        this.jcr = 0;
        this.jcq = new c(Process.myPid());
    }
}
