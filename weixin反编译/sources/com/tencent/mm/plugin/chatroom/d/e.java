package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajw;
import com.tencent.mm.protocal.c.ow;
import com.tencent.mm.protocal.c.ox;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.m;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements com.tencent.mm.network.k {
    private LinkedList<ajw> fBD;
    private final b gLB;
    private com.tencent.mm.ad.e gLE;

    public e(LinkedList<ajw> linkedList) {
        this.fBD = linkedList;
        a aVar = new a();
        aVar.hnT = new ow();
        aVar.hnU = new ox();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        this.gLB = aVar.Kf();
        ow owVar = (ow) this.gLB.hnQ.hnY;
        owVar.wez = linkedList;
        owVar.wey = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 181;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (qVar.Hv().vIb != 0) {
            this.gLE.a(i2, i3, str, this);
            return;
        }
        if (this.fBD != null) {
            Iterator it = this.fBD.iterator();
            while (it.hasNext()) {
                ajw ajw = (ajw) it.next();
                x.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + ajw.wxR);
                m.gi(ajw.wxR);
            }
        }
        this.gLE.a(i2, i3, str, this);
    }
}
