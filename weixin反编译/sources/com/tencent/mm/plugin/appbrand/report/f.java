package com.tencent.mm.plugin.appbrand.report;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.d.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends d {
    long jMO;
    public long jMP;
    private final c jMQ = new c();
    final b jMR = new b();
    final a jMS = new a();
    private boolean jMT = false;
    public boolean mStopped = false;

    private final class b extends d {
        private long jMW;

        private b() {
        }

        /* synthetic */ b(f fVar, byte b) {
            this();
        }

        public final String getName() {
            return f.this.mName + "|Foreground";
        }

        public final boolean j(Message message) {
            if (1 != message.what) {
                return super.j(message);
            }
            f.this.b(f.this.jMS);
            return true;
        }

        public final void enter() {
            super.enter();
            this.jMW = bi.Wy();
        }

        public final void exit() {
            super.exit();
            f.this.jMP = bi.Wy() - this.jMW;
        }
    }

    private final class c extends d {
        private c() {
        }

        /* synthetic */ c(f fVar, byte b) {
            this();
        }

        public final String getName() {
            return f.this.mName + "|Init";
        }

        public final boolean j(Message message) {
            if (2 == message.what) {
                f.this.b(f.this.jMR);
                return true;
            } else if (1 != message.what) {
                return super.j(message);
            } else {
                f.this.b(f.this.jMS);
                return true;
            }
        }
    }

    private final class a extends d {
        private long jMU;

        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final String getName() {
            return f.this.mName + "|Background";
        }

        public final boolean j(Message message) {
            if (2 != message.what) {
                return super.j(message);
            }
            f.this.b(f.this.jMR);
            return true;
        }

        public final void enter() {
            super.enter();
            this.jMU = bi.Wy();
        }

        public final void exit() {
            super.exit();
            f.this.jMO = bi.Wy() - this.jMU;
        }
    }

    public f(String str) {
        super("MicroMsg.StayingRecorder[" + str + "]", Looper.getMainLooper());
        a(this.jMR);
        a(this.jMS);
        a(this.jMQ);
        b(this.jMQ);
        start();
    }

    public final boolean aku() {
        return chu() == this.jMS || this.jMT;
    }

    public final void akv() {
        x.d(this.mName, "toForeground");
        jC(2);
    }

    public final void akw() {
        x.d(this.mName, "toBackground");
        jC(1);
    }

    private void jC(int i) {
        if (cht() == null) {
            DA(i);
        } else if (Looper.myLooper() == this.xrk.getLooper()) {
            this.xrk.handleMessage(Message.obtain(this.xrk, i));
        } else {
            DB(i);
        }
    }

    public final void start() {
        if (!this.mStopped) {
            super.start();
        }
    }

    protected final void ZQ() {
        super.ZQ();
        this.jMT = true;
    }
}
