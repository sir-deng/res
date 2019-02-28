package com.tencent.mm.y;

import com.tencent.mm.f.a.rg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class bs {
    private String hjA = "";
    private int hjB = 1;
    private a hjx = null;
    private long hjy = 0;
    private long hjz = 0;

    public interface a {
        boolean Ij();
    }

    public bs(a aVar) {
        Assert.assertTrue(true);
        this.hjx = aVar;
        Ic();
    }

    private void Ic() {
        this.hjB = 1;
        this.hjy = 0;
        this.hjz = 0;
        this.hjA = "";
    }

    public final synchronized boolean Id() {
        boolean z = true;
        synchronized (this) {
            long Wy = bi.Wy();
            this.hjA = bi.chl().toString();
            if (this.hjB == 1) {
                this.hjz = Wy;
                this.hjy = 1800000;
                x.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", Long.valueOf(1800000), this.hjA);
                this.hjB = 2;
                if (this.hjx.Ij()) {
                    If();
                }
            } else {
                long j = this.hjz + this.hjy;
                Wy += 1800000;
                if (Wy > j) {
                    this.hjy += Wy - j;
                }
                x.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", Integer.valueOf(this.hjB), Long.valueOf(1800000), Long.valueOf(Wy - j), Long.valueOf(this.hjy), this.hjA);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void Ie() {
        x.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", Integer.valueOf(this.hjB), bi.chl());
        if (this.hjB == 1) {
            x.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", bi.chl());
        } else {
            Ic();
            b rgVar = new rg();
            rgVar.fJP.status = 1;
            com.tencent.mm.sdk.b.a.xmy.m(rgVar);
        }
    }

    public final synchronized void If() {
        if (this.hjB != 2) {
            x.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", Integer.valueOf(this.hjB), bi.chl());
        } else {
            x.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", Long.valueOf(bi.bA(this.hjz)), bi.chl());
            this.hjB = 3;
            b rgVar = new rg();
            rgVar.fJP.status = 3;
            com.tencent.mm.sdk.b.a.xmy.m(rgVar);
        }
    }

    private synchronized void Ig() {
        if (this.hjB != 1 && this.hjy + this.hjz < bi.Wy()) {
            Ie();
        }
    }

    public final synchronized boolean Ih() {
        Ig();
        return this.hjB == 2;
    }

    public final synchronized boolean Ii() {
        Ig();
        return this.hjB == 3;
    }
}
