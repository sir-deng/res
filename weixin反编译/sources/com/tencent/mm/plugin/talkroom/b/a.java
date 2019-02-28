package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.protocal.c.bot;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.protocal.c.tc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    private final b gLB;
    private e gLE;
    public int nJe;
    public long nJf;
    private final String oae;
    private int sceneType = 0;
    public int shW;
    public int shX;
    public LinkedList<bos> shZ;
    public LinkedList<bot> sis;

    public a(String str, int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        this.sceneType = i;
        aVar.hnT = new tb();
        aVar.hnU = new tc();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.hnS = 332;
        aVar.hnV = 147;
        aVar.hnW = 1000000147;
        this.gLB = aVar.Kf();
        ((tb) this.gLB.hnQ.hnY).wik = str;
        ((tb) this.gLB.hnQ.hnY).sfa = i;
        this.oae = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", Integer.valueOf(this.sceneType));
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 332;
    }

    public final String bFI() {
        return this.oae;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            tc tcVar = (tc) this.gLB.hnR.hnY;
            x.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", tcVar.toString());
            this.nJe = tcVar.wil;
            this.nJf = tcVar.wim;
            this.shW = tcVar.win;
            this.shX = tcVar.wip;
            this.sis = ak(tcVar.vNu);
            this.shZ = al(tcVar.vQG);
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

    private static LinkedList<bos> al(LinkedList<bos> linkedList) {
        LinkedList<bos> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((bos) it.next());
        }
        return linkedList2;
    }

    public final int bFJ() {
        return this.sceneType;
    }
}
