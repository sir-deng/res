package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.aie;
import com.tencent.mm.protocal.c.bur;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class b extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private com.tencent.mm.ad.b hnL;
    private e oVh;
    private String seW;
    public bur sff;
    public int sfj = -1;

    public b(String str) {
        Assert.assertTrue(!bi.oN(str));
        this.seW = str;
        a aVar = new a();
        aVar.hnT = new aid();
        aVar.hnU = new aie();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.hnS = 548;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hnL = aVar.Kf();
    }

    public final int getType() {
        return 548;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oVh = eVar2;
        ((aid) this.hnL.hnQ.hnY).wdG = this.seW;
        return a(eVar, this.hnL, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            aie aie = (aie) this.hnL.hnR.hnY;
            if (aie.wdK != null) {
                this.sfj = aie.wdK.wOD;
            }
            this.sff = aie.wdI;
        } else {
            x.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.oVh.a(i2, i3, str, this);
    }

    public final boolean isComplete() {
        return this.sff != null && this.sff.vSa == 1;
    }

    public final boolean bEU() {
        return (this.sff == null || bi.oN(this.sff.xcd)) ? false : true;
    }
}
