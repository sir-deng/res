package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class e extends l {
    public b gLB;
    private com.tencent.mm.ad.e gLE;

    public e(PayReq payReq, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hnT = new awo();
        aVar.hnU = new awp();
        aVar.uri = "/cgi-bin/mmpay-bin/payauthapp";
        aVar.hnV = n.CTRL_BYTE;
        aVar.hnW = 1000000188;
        this.gLB = aVar.Kf();
        awo awo = (awo) this.gLB.hnQ.hnY;
        awo.nlV = payReq.appId;
        awo.wKH = payReq.partnerId;
        awo.wov = payReq.prepayId;
        awo.wdk = payReq.nonceStr;
        awo.wKI = payReq.timeStamp;
        awo.wdl = payReq.packageValue;
        awo.wdm = payReq.sign;
        awo.wdn = payReq.signType;
        awo.wKJ = str;
        awo.nkY = str2;
        awo.noG = str3;
        awo.vXW = i.bLR();
        awo.wKL = str4;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gLE.a(i, i2, str, this);
    }

    public final int getType() {
        return 397;
    }
}
