package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.e.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.d.b.e.e, com.tencent.mm.network.k {
    private b gLB;
    private com.tencent.mm.ad.e gLE;
    private com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> mFx = null;

    public final /* synthetic */ void br(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hnT = new brd();
        aVar2.hnU = new bre();
        aVar2.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar2.hnS = 619;
        aVar2.hnV = 0;
        aVar2.hnW = 0;
        this.gLB = aVar2.Kf();
        brd brd = (brd) this.gLB.hnQ.hnY;
        brd.sfa = 619;
        brd.wZs = aVar.Amd;
        brd.wZt = aVar.Amc;
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", aVar.Amc, aVar.Amd);
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", Integer.valueOf(hashCode()));
    }

    public final int getType() {
        return 619;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.mFx != null) {
                this.mFx.cz(new com.tencent.d.b.e.e.b(true));
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
        if (this.mFx != null) {
            this.mFx.cz(new com.tencent.d.b.e.e.b(false));
        }
    }

    public final void a(com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> bVar) {
        this.mFx = bVar;
    }

    public final void execute() {
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        g.CN().a((k) this, 0);
    }
}
