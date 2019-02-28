package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    private final b gLB;
    private e gLE;
    private final String oae;
    private int sceneType = 0;
    public int shW;
    public LinkedList<bot> sis;

    public c(int i, long j, String str, int i2) {
        this.sceneType = i2;
        a aVar = new a();
        aVar.hnT = new aha();
        aVar.hnU = new ahb();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.hnS = 336;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        aha aha = (aha) this.gLB.hnQ.hnY;
        aha.wil = i;
        aha.wim = j;
        this.oae = str;
        aha.sfa = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 336;
    }

    public final String bFI() {
        return this.oae;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ahb ahb = (ahb) this.gLB.hnR.hnY;
            x.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", ahb.toString());
            this.shW = ahb.win;
            this.sis = ak(ahb.vNu);
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    private static LinkedList<bot> ak(LinkedList<bot> linkedList) {
        LinkedList<bot> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bot bot = (bot) it.next();
            if (!bi.oN(bot.kyG)) {
                linkedList2.add(bot);
            }
        }
        return linkedList2;
    }

    public final int bFJ() {
        return this.sceneType;
    }
}
