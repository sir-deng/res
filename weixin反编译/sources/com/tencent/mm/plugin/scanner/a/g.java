package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.ie;
import com.tencent.mm.protocal.c.if;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    public b gLB;
    private e gLE;
    private int hmZ;
    private int offset;
    private byte[] pYH;
    private int pYI = 1;
    private int pYL;

    public g(byte[] bArr, int i, int i2) {
        this.pYH = bArr;
        this.pYI = 1;
        this.hmZ = i;
        this.offset = 0;
        this.pYL = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        a aVar = new a();
        aVar.hnT = new ie();
        aVar.hnU = new if();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        aVar.hnS = 1062;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ie ieVar = (ie) this.gLB.hnQ.hnY;
        ieVar.vUK = ((int) bi.Wy()) & Integer.MAX_VALUE;
        ieVar.vUL = new bes().bl(this.pYH);
        ieVar.vUM = this.hmZ;
        ieVar.vUN = this.offset;
        if (this.offset + this.pYH.length < this.hmZ) {
            ieVar.vSa = 0;
        } else {
            ieVar.vSa = 1;
        }
        ieVar.vUO = this.pYI;
        ieVar.vUP = this.pYL;
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        ie ieVar = (ie) ((b) qVar).hnQ.hnY;
        if (ieVar.vUK > 0 && ieVar.vUO >= 0 && ieVar.vUL != null && ieVar.vUL.wRk > 0 && ieVar.vUM > 0 && ieVar.vUN >= 0 && ieVar.vUN + ieVar.vUL.wRk <= ieVar.vUM) {
            return b.hoz;
        }
        x.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", Integer.valueOf(ieVar.vUO), Integer.valueOf(ieVar.vUM), Integer.valueOf(ieVar.vUN));
        if (ieVar.vUL != null) {
            x.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", Integer.valueOf(ieVar.vUL.wRk));
        }
        return b.hoA;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1062;
    }
}
