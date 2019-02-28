package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.storage.emotion.h;

public final class i extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    private String lEE;

    public i(String str) {
        a aVar = new a();
        aVar.hnT = new abt();
        aVar.hnU = new abu();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesignersimpleinfo";
        aVar.hnS = ai.CTRL_BYTE;
        this.gLB = aVar.Kf();
        this.lEE = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetDesignerSimpleInfo", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            h hVar = com.tencent.mm.plugin.emoji.model.i.aCl().lCC;
            String str2 = this.lEE;
            abu aCx = aCx();
            if (bi.oN(str2) || aCx == null) {
                x.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID or response is null.");
            } else {
                try {
                    g gVar = new g();
                    gVar.field_designerIDAndType = str2 + h.a.DesignerSimpleInfo.value;
                    gVar.field_content = aCx.toByteArray();
                    ContentValues vP = gVar.vP();
                    new String[1][0] = str2 + h.a.DesignerSimpleInfo.value;
                    if (hVar.gLA.replace("EmotionDesignerInfo", "designerIDAndType", vP) > 0) {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID success. designerID:%s", str2);
                    } else {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID failed. designerID:%s", str2);
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", bi.i(e));
                }
            }
        }
        this.gQm.a(i2, i3, str, this);
    }

    public final abu aCx() {
        return this.gLB == null ? null : (abu) this.gLB.hnR.hnY;
    }

    public final int getType() {
        return ai.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        ((abt) this.gLB.hnQ.hnY).wgQ = this.lEE;
        return a(eVar, this.gLB, this);
    }
}
