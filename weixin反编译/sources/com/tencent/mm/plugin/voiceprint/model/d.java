package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.protocal.c.aia;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    String smH = "";
    int smI = 0;
    String smJ = "";

    public d(int i, String str) {
        a aVar = new a();
        aVar.hnT = new ahz();
        aVar.hnU = new aia();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.hnS = 611;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ahz ahz = (ahz) this.gLB.hnQ.hnY;
        x.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", Integer.valueOf(i), str);
        ahz.wwj = i;
        ahz.wwk = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 611;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aia aia = (aia) ((b) qVar).hnR.hnY;
        if (i2 == 0 || i3 == 0) {
            if (aia.wwl != null) {
                this.smH = new String(aia.wwl.wQR.wRm.oz);
                this.smI = aia.wwl.wPL;
                x.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", Integer.valueOf(this.smI), this.smH);
            } else {
                x.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
