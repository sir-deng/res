package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;

public final class b implements com.tencent.mm.compatible.b.f.a, com.tencent.mm.plugin.ipcall.a.b.d.a, com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a {
    public MMActivity fnF;
    public com.tencent.mm.compatible.util.b hZB = new com.tencent.mm.compatible.util.b(ad.getContext());
    public a nJR = new a();
    public c nJS = new c();
    public d nJT = new d();
    public HeadsetPlugReceiver nJU = new HeadsetPlugReceiver();
    public j nJV;
    private boolean nJW = false;
    public a nJX;
    public boolean nJY = false;
    public boolean nJZ = false;
    public long nKa = 0;

    public interface a {
        void gd(boolean z);

        void ge(boolean z);
    }

    public final void a(j jVar) {
        this.nJV = jVar;
        if (jVar != null) {
            i.aUj().aTG();
        }
    }

    public final void aUx() {
        c cVar = this.nJS;
        if (cVar.fBn) {
            x.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            return;
        }
        x.i("MicroMsg.IPCallRecorder", "start record");
        cVar.fBn = true;
        cVar.nKd = i.aUh().nJR.nJN;
        if (cVar.nKd <= 10) {
            if (cVar.nKd <= 0) {
                x.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.aUg().aUF();
            }
            cVar.nKd = 92;
        }
        synchronized (cVar.nKc) {
            e.post(new Runnable() {
                public final void run() {
                    try {
                        c cVar = c.this;
                        cVar.nKb = new com.tencent.mm.audio.b.c(v2protocal.oLp, 1, 6);
                        cVar.nKb.et(20);
                        cVar.nKb.aR(true);
                        cVar.nKb.vr();
                        cVar.nKb.fkT = -19;
                        cVar.nKb.n(1, false);
                        cVar.nKb.aQ(true);
                        cVar.nKb.fle = cVar.nKh;
                        if (cVar.nKb.vs()) {
                            cVar.nKb.aS(cVar.kYN);
                            return;
                        }
                        x.e("MicroMsg.IPCallRecorder", "start record failed");
                        if (cVar.nKb.fkJ != 13) {
                            i.aUg().aUF();
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.IPCallRecorder", "start record error: %s", e.getMessage());
                        i.aUg().aUF();
                    }
                }
            }, "IPCallRecorder_startRecord");
        }
    }

    public final void ga(boolean z) {
        this.nJR.ga(z);
    }

    public final void gb(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", Boolean.valueOf(z));
        if (this.fnF != null) {
            MMActivity mMActivity = this.fnF;
            if (z) {
                z2 = false;
            }
            mMActivity.setScreenEnable(z2);
        }
        if (!i.aUi().aTZ()) {
            return;
        }
        if (z) {
            this.nJW = a.xX();
            this.nJR.ga(false);
            return;
        }
        this.nJR.ga(this.nJW);
    }

    public final void er(int i) {
        x.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                this.nJY = true;
                if (this.nJX != null && !this.nJZ) {
                    this.nJX.ge(true);
                    return;
                }
                return;
            case 2:
            case 4:
                this.nJY = false;
                if (this.nJX != null && !this.nJZ) {
                    this.nJX.ge(false);
                    return;
                }
                return;
            case 3:
                as.Hn().xP();
                if (as.Hn().xS() && this.nJX != null) {
                    this.nJX.gd(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void gc(boolean z) {
        x.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", Boolean.valueOf(z));
        if (this.nJX != null && z != this.nJZ) {
            this.nJZ = z;
            if (!this.nJY) {
                this.nJX.gd(z);
            }
        }
    }

    public final int aUy() {
        a aVar = this.nJR;
        return (aVar.nJL == null || !aVar.fBn) ? -1 : aVar.nJL.bGR();
    }
}
