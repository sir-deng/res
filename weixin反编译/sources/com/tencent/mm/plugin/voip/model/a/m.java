package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bvs;
import com.tencent.mm.protocal.c.bwu;
import com.tencent.mm.protocal.c.bwv;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public final class m extends n<bwu, bwv> {
    public m(int i, bvs bvs, byte[] bArr, long j, int i2) {
        a aVar = new a();
        aVar.hnT = new bwu();
        aVar.hnU = new bwv();
        aVar.uri = "/cgi-bin/micromsg-bin/voipsync";
        aVar.hnS = GameJsApiOperateGameCenterMsg.CTRL_BYTE;
        this.gLB = aVar.Kf();
        bwu bwu = (bwu) this.gLB.hnQ.hnY;
        bwu.wil = i;
        bwu.xeC = bvs;
        bwu.wim = j;
        bwu.wNo = q.FY();
        bwu.vYD = i2;
        bwu.vYE = new bes().bl(bArr);
        bwu.xcm = System.currentTimeMillis();
        x.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + bwu.xcm);
    }

    public final int getType() {
        return GameJsApiOperateGameCenterMsg.CTRL_BYTE;
    }

    public final int bIv() {
        return ((bwu) this.gLB.hnQ.hnY).vYD;
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.NetSceneVoipSync", "onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                try {
                    if (((bwv) m.this.bIx()).wil != m.this.sqC.sqj.nJe) {
                        com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.NetSceneVoipSync", "syncOnSceneEnd: recv roomId != current roomid");
                        return;
                    }
                } catch (Exception e) {
                }
                if (i != 0) {
                    com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.NetSceneVoipSync", "VoipSync Failed, type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                    m.this.sqC.sqj.svN.sqW = 11;
                    m.this.sqC.sqj.svN.sqY = i2;
                    m.this.sqC.sqj.svN.sqX = i2;
                    m.this.sqC.sqj.svN.srp = 3;
                    if (i == 1) {
                        m.this.sqC.sqj.svN.srj = 8;
                    } else {
                        m.this.sqC.sqj.svN.srj = 99;
                    }
                    m.this.sqC.p(1, -9004, "");
                    return;
                }
                m.this.sqC.sqm.o(kVar);
            }
        };
    }
}
