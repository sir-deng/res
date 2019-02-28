package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.protocal.c.aqb;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    public String sign;
    public String tyC;
    public String tyD;
    public String tyE;
    public int tyF;

    public q(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hnT = new aqa();
        aVar.hnU = new aqb();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        this.gLB = aVar.Kf();
        aqa aqa = (aqa) this.gLB.hnQ.hnY;
        aqa.kPE = str;
        aqa.wpr = str2;
        aqa.kTk = str3;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            aqb aqb = (aqb) this.gLB.hnR.hnY;
            this.tyC = aqb.tyC;
            this.sign = aqb.sign;
            this.tyD = aqb.tyD;
            this.tyE = aqb.tyE;
            this.tyF = aqb.tyF;
            x.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", this.tyC, this.sign, this.tyD, this.tyE, Integer.valueOf(this.tyF));
        }
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1177;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.gLB, this);
    }
}
