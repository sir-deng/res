package com.tencent.mm.sdk.platformtools;

public abstract class bd<R> {
    long hiL;
    private final long hoU;
    private Object lock;
    private R result;
    private Runnable xoo;
    long xqA;
    boolean xqB;

    public abstract R run();

    public bd() {
        this(0, null);
    }

    public bd(long j, R r, boolean z) {
        this.lock = new Object();
        this.xqB = false;
        this.xoo = new Runnable() {
            public final void run() {
                x.i("MicroMsg.SDK.SyncTask", "task run manualFinish = " + bd.this.xqB);
                if (bd.this.xqB) {
                    bd.this.run();
                } else {
                    bd.this.bY(bd.this.run());
                }
                bd.this.xqA = bi.bB(bd.this.hiL);
            }
        };
        this.hoU = j;
        this.result = r;
        this.xqB = true;
    }

    public bd(long j, R r) {
        this.lock = new Object();
        this.xqB = false;
        this.xoo = /* anonymous class already generated */;
        this.hoU = j;
        this.result = r;
    }

    public final void bY(R r) {
        x.i("MicroMsg.SDK.SyncTask", "setResultFinish ");
        this.result = r;
        synchronized (this.lock) {
            x.i("MicroMsg.SDK.SyncTask", "setResultFinish synchronized");
            this.lock.notify();
        }
    }

    public final R b(ag agVar) {
        if (agVar == null) {
            x.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        x.i("MicroMsg.SDK.SyncTask", "sync task exec...");
        if (Thread.currentThread().getId() == agVar.getLooper().getThread().getId()) {
            x.i("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.hiL = bi.Wz();
        try {
            synchronized (this.lock) {
                x.i("MicroMsg.SDK.SyncTask", "sync task exec at synchronized");
                agVar.post(this.xoo);
                this.lock.wait(this.hoU);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SDK.SyncTask", e, "", new Object[0]);
        }
        long bB = bi.bB(this.hiL);
        x.i("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", this.result, Long.valueOf(bB), Long.valueOf(this.xqA), Long.valueOf(bB - this.xqA));
        return this.result;
    }
}
