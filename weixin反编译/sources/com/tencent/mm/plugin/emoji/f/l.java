package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.acd;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.j;

public final class l extends k implements com.tencent.mm.network.k {
    private int aIt;
    private final b gLB;
    private e gLE;
    private int itU;
    public String lEs;

    public l(String str, int i, int i2) {
        this.lEs = str;
        this.itU = i;
        this.aIt = i2;
        a aVar = new a();
        aVar.hnT = new acd();
        aVar.hnU = new ace();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
        aVar.hnS = 412;
        aVar.hnV = h.CTRL_INDEX;
        aVar.hnW = 1000000211;
        this.gLB = aVar.Kf();
    }

    public l(String str, int i) {
        this(str, i, -1);
    }

    public final int getType() {
        return 412;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", this.lEs, Integer.valueOf(this.itU), Integer.valueOf(this.aIt));
        this.gLE = eVar2;
        acd acd = (acd) this.gLB.hnQ.hnY;
        acd.vPI = this.lEs;
        acd.sfa = this.itU;
        acd.kzy = this.aIt;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + i2 + "   errCode:" + i3);
        if (i2 == 0 || i3 == 0 || i3 == 5) {
            if (i2 == 0 && i3 == 0) {
                j jVar = i.aCl().lCA;
                String str2 = this.lEs;
                ace ace = (ace) this.gLB.hnR.hnY;
                String eM = w.eM(ad.getContext());
                if (bi.oN(str2) || ace == null) {
                    x.w("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                }
                try {
                    com.tencent.mm.storage.emotion.i iVar = new com.tencent.mm.storage.emotion.i();
                    iVar.field_productID = str2;
                    iVar.field_content = ace.toByteArray();
                    iVar.field_lan = eM;
                    if (jVar.gLA.replace("EmotionDetailInfo", "productID", iVar.vP()) > 0) {
                        x.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID success. ProductId:%s", str2);
                    } else {
                        x.i("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionDetailResponseWithPID failed. ProductId:%s", str2);
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDetailInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", bi.i(e));
                }
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final st aCz() {
        st stVar = new st();
        return ((ace) this.gLB.hnR.hnY).wrI;
    }
}
