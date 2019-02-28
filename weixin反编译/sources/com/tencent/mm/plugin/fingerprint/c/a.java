package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.c.bmp;
import com.tencent.mm.protocal.c.bmq;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends d implements k {
    public final b gLB;
    private e gLE;
    public String mFv = "";
    public boolean mFw = false;

    public a() {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bmp();
        aVar.hnU = new bmq();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.hnS = 1586;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        bmp bmp = (bmp) this.gLB.hnQ.hnY;
        c bDz = com.tencent.mm.plugin.soter.c.b.bDz();
        x.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", bDz.rYp, bDz.rYq);
        bmp.rYp = r2;
        bmp.rYq = r1;
        bmp.scene = 0;
    }

    public final int getType() {
        return 1586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            boolean z;
            bmq bmq = (bmq) ((b) qVar).hnR.hnY;
            this.mFv = bmq.mFv;
            s.sVy.mFv = this.mFv;
            this.mFw = 1 == bmq.wWo;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == bmq.wWo) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str2, str3, objArr);
            s.sVy.mFw = this.mFw;
            x.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", this.mFv, Boolean.valueOf(this.mFw));
        }
        this.gLE.a(i, i2, str, this);
    }

    public final void aLm() {
        x.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.gLE != null) {
            this.gLE.a(4, -1, "", this);
        }
    }

    public final void cC(int i, int i2) {
        if (this.gLE != null) {
            this.gLE.a(4, -1, "", this);
        }
    }
}
