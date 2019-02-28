package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.JsApiDownloadSilkVoice;
import com.tencent.mm.protocal.c.acp;
import com.tencent.mm.protocal.c.acq;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;

    public q() {
        a aVar = new a();
        aVar.hnT = new acp();
        aVar.hnU = new acq();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.hnS = JsApiDownloadSilkVoice.CTRL_INDEX;
        aVar.hnV = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
        aVar.hnW = 1000000217;
        this.gLB = aVar.Kf();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            acq acq = (acq) ((b) qVar).hnR.hnY;
            x.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", Long.valueOf(acq.vNJ), Long.valueOf(acq.kyX), Integer.valueOf(acq.wsh), Integer.valueOf(acq.wsg), Integer.valueOf(acq.wsf));
            j.dj(acq.vNJ);
            j.dk(acq.kyX);
            j.dl((long) acq.wsh);
            j.dm((long) acq.wsg);
            j.dn((long) acq.wsf);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return JsApiDownloadSilkVoice.CTRL_INDEX;
    }
}
