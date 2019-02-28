package com.tencent.mm.af;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.ok;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.om;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bd;
import java.util.LinkedList;

public final class q extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;

    public q(String str, int i, String str2, LinkedList<ok> linkedList) {
        a aVar = new a();
        aVar.hnT = new ol();
        aVar.hnU = new om();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        this.gLB = aVar.Kf();
        ol olVar = (ol) this.gLB.hnQ.hnY;
        olVar.weg = i;
        olVar.weh = str2;
        olVar.vTX = str;
        olVar.vNR = bd.HJ();
        if (linkedList != null) {
            olVar.wei = linkedList;
        }
        x.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d", str, Integer.valueOf(i), str2, olVar.vNR, Integer.valueOf(olVar.wei.size()));
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 359;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
