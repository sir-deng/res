package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.m;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements com.tencent.mm.network.k {
    public List<String> fBI;
    private b gLB;
    private e gLE;

    public g(String str, List<String> list) {
        this(str, list, 0);
    }

    public g(String str, List<String> list, int i) {
        a aVar = new a();
        aVar.hnT = new qd();
        aVar.hnU = new qe();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        aVar.hnS = 179;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        qd qdVar = (qd) this.gLB.hnQ.hnY;
        qdVar.wfN = str;
        LinkedList linkedList = new LinkedList();
        for (String str2 : list) {
            qm qmVar = new qm();
            qmVar.wfS = n.oK(str2);
            linkedList.add(qmVar);
        }
        qdVar.vNu = linkedList;
        qdVar.lfj = linkedList.size();
        qdVar.sfa = i;
        this.fBI = list;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 179;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        qd qdVar = (qd) this.gLB.hnQ.hnY;
        qe qeVar = (qe) this.gLB.hnR.hnY;
        if (this.gLB.hnR.vIb != 0) {
            this.gLE.a(i2, i3, str, this);
            return;
        }
        m.a(qdVar.wfN, qeVar);
        this.gLE.a(i2, i3, str, this);
    }
}
