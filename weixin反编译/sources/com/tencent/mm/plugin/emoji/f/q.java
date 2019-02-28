package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    private int lEU;
    public String lEs;

    public q(String str, int i) {
        this.lEs = str;
        if (!bi.oN(str) && str.equals(String.valueOf(EmojiGroupInfo.xIE))) {
            this.lEs = "com.tencent.xin.emoticon.tusiji";
        }
        this.lEU = i;
        a aVar = new a();
        aVar.hnT = new asf();
        aVar.hnU = new asg();
        aVar.uri = "/cgi-bin/micromsg-bin/modemotionpack";
        aVar.hnS = 413;
        aVar.hnV = com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
        aVar.hnW = 1000000212;
        this.gLB = aVar.Kf();
    }

    public final int getType() {
        return 413;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        asf asf = (asf) this.gLB.hnQ.hnY;
        asf.vPI = this.lEs;
        asf.vKI = this.lEU;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneModEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.lEU == 1) {
                g.pWK.a(165, 2, 1, false);
            } else {
                g.pWK.a(165, 4, 1, false);
            }
            this.gQm.a(i2, i3, str, this);
            return;
        }
        this.gQm.a(i2, i3, str, this);
        if (this.lEU == 1) {
            g.pWK.a(165, 3, 1, false);
            x.i("MicroMsg.emoji.NetSceneModEmotionPack", "del tukiz failed  ");
            return;
        }
        g.pWK.a(165, 5, 1, false);
        x.i("MicroMsg.emoji.NetSceneModEmotionPack", "del emoji failed md5:%s", this.lEs);
    }
}
