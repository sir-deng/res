package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.ato;
import com.tencent.mm.protocal.c.atr;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class p extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE;

    public p(int i) {
        a aVar = new a();
        aVar.hnT = new atn();
        aVar.hnU = new ato();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        this.gLB = aVar.Kf();
        ((atn) this.gLB.hnQ.hnY).wzN = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        ato ato = (ato) this.gLB.hnR.hnY;
        x.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + ato.nlt.size() + " group:" + ato.vOp.size());
        Set hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < ato.wHY) {
                if (!hashSet.contains(((atr) ato.nlt.get(i5)).kyG)) {
                    linkedList.add(ato.nlt.get(i5));
                    hashSet.add(((atr) ato.nlt.get(i5)).kyG);
                }
                i4 = i5 + 1;
            } else {
                ato.nlt = linkedList;
                ato.wHY = linkedList.size();
                this.gLE.a(i2, i3, str, this);
                return;
            }
        }
    }
}
