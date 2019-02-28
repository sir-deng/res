package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bhv;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class m extends k implements com.tencent.mm.network.k {
    private b gLB = null;
    private e gLE;
    private bhv nLu = null;
    public bhw nLv = null;

    public m(int i, int i2, LinkedList<byb> linkedList) {
        a aVar = new a();
        aVar.hnT = new bhv();
        aVar.hnU = new bhw();
        aVar.hnS = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.nLu = (bhv) this.gLB.hnQ.hnY;
        this.nLu.wGp = i2;
        this.nLu.wSH = linkedList;
        this.nLu.wSG = linkedList.size();
        this.nLu.wSI = i;
        x.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size()));
    }

    public final int getType() {
        return 871;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nLv = (bhw) ((b) qVar).hnR.hnY;
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
