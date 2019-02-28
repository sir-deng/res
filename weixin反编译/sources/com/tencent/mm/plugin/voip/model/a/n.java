package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public abstract class n<REQ, RESP> extends k implements com.tencent.mm.network.k {
    protected b gLB;
    e gLE;
    private e mKD;
    protected com.tencent.mm.plugin.voip.model.e sqC = f.bHm();

    public abstract e bIt();

    public final void a(int i, final int i2, final int i3, final String str, q qVar, byte[] bArr) {
        dT(i2, i3);
        if (this.mKD != null) {
            this.mKD.a(i2, i3, str, this);
        }
        if (this.gLE != null) {
            ah.y(new Runnable() {
                public final void run() {
                    if (n.this.gLE != null) {
                        n.this.gLE.a(i2, i3, str, n.this);
                    }
                }
            });
        }
    }

    public int bIu() {
        return 0;
    }

    public void dT(int i, int i2) {
    }

    public final void bIw() {
        x.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        as.CN().a((k) this, 0);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int bIu = bIu();
        if (bIu != 0) {
            return bIu;
        }
        this.mKD = eVar2;
        this.gLE = bIt();
        return a(eVar, this.gLB, this);
    }

    public final <RESP> RESP bIx() {
        return this.gLB.hnR.hnY;
    }

    public final <REQ> REQ bIy() {
        return this.gLB.hnQ.hnY;
    }
}
