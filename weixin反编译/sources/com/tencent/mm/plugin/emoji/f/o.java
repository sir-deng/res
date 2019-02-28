package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.acj;
import com.tencent.mm.protocal.c.ack;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.l;

public final class o extends k implements com.tencent.mm.network.k {
    public static int lEP = 0;
    public static int lEQ = 1;
    public static int lER = 1;
    public static int lES = 2;
    public static int lET = 256;
    private final b gLB;
    private e gLE;
    private int lEU;
    private String lEi;

    public o(String str, int i) {
        a aVar = new a();
        aVar.hnT = new acj();
        aVar.hnU = new ack();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotionreward";
        this.gLB = aVar.Kf();
        this.lEi = str;
        this.lEU = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionReward", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            if (this.lEU == lEP) {
                l lVar = i.aCl().lCB;
                String str2 = this.lEi;
                ack aCD = aCD();
                if (bi.oN(str2) || aCD == null) {
                    x.w("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. productId or response is null.");
                } else {
                    try {
                        com.tencent.mm.storage.emotion.k kVar = new com.tencent.mm.storage.emotion.k();
                        kVar.field_productID = str2;
                        kVar.field_content = aCD.toByteArray();
                        if (lVar.gLA.replace("EmotionRewardInfo", "productID", kVar.vP()) > 0) {
                            x.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID success. ProductId:%s", str2);
                        } else {
                            x.i("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID failed. ProductId:%s", str2);
                        }
                    } catch (Throwable e) {
                        x.e("MicroMsg.emoji.EmotionRewardInfoStorage", "saveEmotionRewardResponseWithPID exception:%s", bi.i(e));
                    }
                }
            }
            if (aCD() == null || aCD().wsa == null) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionReward", "getEmotionRewardRespone is null. so i think no such product reward information");
                i.aCl().lCD.dg(this.lEi, lET);
                i.aCm().bg(this.lEi, lET);
            } else {
                i.aCl().lCD.dg(this.lEi, aCD().wsa.vNC);
                i.aCm().bg(this.lEi, aCD().wsa.vNC);
            }
        } else if (i3 == 1) {
            i.aCl().lCD.dg(this.lEi, lET);
            i.aCm().bg(this.lEi, lET);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 822;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        acj acj = (acj) this.gLB.hnQ.hnY;
        acj.vPI = this.lEi;
        acj.vKI = this.lEU;
        return a(eVar, this.gLB, this);
    }

    public final ack aCD() {
        return (ack) this.gLB.hnR.hnY;
    }
}
