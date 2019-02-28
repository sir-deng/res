package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.protocal.c.bvx;
import com.tencent.mm.protocal.c.bvy;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends n<bvx, bvy> {
    public e(int i, long j, String str) {
        a aVar = new a();
        aVar.hnT = new bvx();
        aVar.hnU = new bvy();
        aVar.uri = "/cgi-bin/micromsg-bin/voipgetroominfo";
        this.gLB = aVar.Kf();
        bvx bvx = (bvx) this.gLB.hnQ.hnY;
        bvx.wil = i;
        bvx.wim = j;
        bvx.xdp = str;
        bvx.kzz = 1;
        bvx.xcm = System.currentTimeMillis();
    }

    public final int getType() {
        return 303;
    }

    public final void dT(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bvy) bIx()) != null) {
                x.i("MicroMsg.Voip.GetRoomInfo", "roomId:%d, roomKey:%s, memberCount:%d, inviteType:%d", Integer.valueOf(((bvy) bIx()).wil), Long.valueOf(((bvy) bIx()).wim), Integer.valueOf(((bvy) bIx()).lfj), Integer.valueOf(((bvy) bIx()).xdh));
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.GetRoomInfo", "Get RoomInfo error");
    }

    public final com.tencent.mm.ad.e bIt() {
        return new com.tencent.mm.ad.e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.GetRoomInfo", "Voip onSceneEnd type:" + kVar.getType() + " errType:" + i + " errCode:" + i2);
                if (i == 0 && i2 == 0 && kVar != null) {
                    bvy bvy = (bvy) e.this.bIx();
                    if (bvy.wRa.vQL == 0 && !d.bGT().ssY.bIk()) {
                        d.bGT().a(bvy);
                    }
                }
            }
        };
    }
}
