package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nb;
import com.tencent.mm.protocal.c.nc;
import com.tencent.mm.protocal.c.pl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends k implements com.tencent.mm.network.k {
    b gLB;
    private e gLE;
    private ArrayList<Long> puC;

    public l(ArrayList<Long> arrayList) {
        this.puC = arrayList;
        a aVar = new a();
        aVar.hnT = new nb();
        aVar.hnU = new nc();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        this.gLB = aVar.Kf();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if ((i2 != 0 || i3 != 0) && this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        } else if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 483;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        nb nbVar = (nb) this.gLB.hnQ.hnY;
        nbVar.kyA = this.puC.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.puC.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            pl plVar = new pl();
            plVar.vNT = longValue;
            linkedList.add(plVar);
            x.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", Long.valueOf(longValue));
        }
        nbVar.wcA = linkedList;
        x.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", Integer.valueOf(nbVar.kyA), Integer.valueOf(nbVar.wcA.size()));
        return a(eVar, this.gLB, this);
    }
}
