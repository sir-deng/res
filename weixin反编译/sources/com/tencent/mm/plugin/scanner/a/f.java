package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ic;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    public int fqW;
    public int fqX;
    private b gLB;
    private e gLE;
    public boolean pYM = false;

    public f(int i, String str, int i2, int i3) {
        a aVar = new a();
        aVar.hnT = new ic();
        aVar.hnU = new id();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.hnS = 1061;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ic icVar = (ic) this.gLB.hnQ.hnY;
        icVar.kzz = i;
        icVar.vUJ = str;
        icVar.sfa = 1;
        this.fqW = i2;
        this.fqX = i3;
        x.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    protected final int a(q qVar) {
        ic icVar = (ic) ((b) qVar).hnQ.hnY;
        if (icVar.kzz >= 0 && icVar.vUJ != null && icVar.vUJ.length() > 0) {
            return b.hoz;
        }
        x.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + icVar.kzz + ", Barcode = %s" + icVar.vUJ);
        return b.hoA;
    }

    public final id bpl() {
        if (this.gLB == null || this.gLB.hnR.hnY == null) {
            return null;
        }
        return (id) this.gLB.hnR.hnY;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1061;
    }
}
