package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;

public class al extends ag {
    private static int xnB;
    private final boolean jvU;
    private boolean mStop = false;
    private final int xnC;
    private long xom = 0;
    private final a xon;

    public interface a {
        boolean uG();
    }

    public al(a aVar, boolean z) {
        this.xon = aVar;
        this.xnC = cgw();
        this.jvU = z;
        if (getLooper().getThread().getName().equals("initThread")) {
            x.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bi.chl());
        }
    }

    public al(Looper looper, a aVar, boolean z) {
        super(looper);
        this.xon = aVar;
        this.xnC = cgw();
        this.jvU = z;
        if (looper.getThread().getName().equals("initThread")) {
            x.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", bi.chl());
        }
    }

    private static int cgw() {
        if (xnB >= 8192) {
            xnB = 0;
        }
        int i = xnB + 1;
        xnB = i;
        return i;
    }

    protected void finalize() {
        TN();
        super.finalize();
    }

    public void handleMessage(Message message) {
        if (message.what == this.xnC && this.xon != null && this.xon.uG() && this.jvU && !this.mStop) {
            sendEmptyMessageDelayed(this.xnC, this.xom);
        }
    }

    public final void fI(long j) {
        K(j, j);
    }

    public final void TN() {
        removeMessages(this.xnC);
        this.mStop = true;
    }

    public final void K(long j, long j2) {
        this.xom = j2;
        TN();
        this.mStop = false;
        sendEmptyMessageDelayed(this.xnC, j);
    }

    public final boolean cgx() {
        return this.mStop || !hasMessages(this.xnC);
    }

    public String toString() {
        if (this.xon == null) {
            return "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
        }
        return "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.xon.getClass().getName() + "}";
    }
}
