package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.blz;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bmf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends k implements com.tencent.mm.network.k {
    private int fvo;
    private b gLB;
    public e gLE;
    private long raF = 0;

    public w(long j, String str) {
        x.d("MicroMsg.NetSceneSnsTagOption", "opcode 3" + " snsTagId " + j + " tagName " + str);
        this.raF = j;
        this.fvo = 3;
        a aVar = new a();
        aVar.hnT = new bme();
        aVar.hnU = new bmf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstagoption";
        aVar.hnS = JsApiDestroyInstanceAudio.CTRL_INDEX;
        aVar.hnV = 114;
        aVar.hnW = 1000000114;
        this.gLB = aVar.Kf();
        bme bme = (bme) this.gLB.hnQ.hnY;
        bme.vKI = 3;
        bme.wVU = j;
        bme.noE = str;
    }

    public final int getType() {
        return JsApiDestroyInstanceAudio.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSnsTagOption", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            blz blz = ((bmf) ((b) qVar).hnR.hnY).wVW;
            x.d("MicroMsg.NetSceneSnsTagOption", blz.toString());
            switch (this.fvo) {
                case 1:
                case 2:
                    s eU = ae.bwl().eU(blz.wVU);
                    eU.field_tagId = blz.wVU;
                    eU.field_tagName = bi.aD(blz.noE, "");
                    eU.field_count = blz.kyA;
                    eU.bU(blz.kyB);
                    ae.bwl().a(eU);
                    break;
                case 3:
                    x.d("MicroMsg.NetSceneSnsTagOption", "MM_SNS_TAG_DEL " + ae.bwl().eV(this.raF));
                    break;
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }
}
