package com.tencent.mm.modelfriend;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.protocal.c.api;
import com.tencent.mm.protocal.c.apj;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class y extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;

    public y(String str, List<String[]> list) {
        int i = 0;
        a aVar = new a();
        aVar.hnT = new api();
        aVar.hnU = new apj();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.hnS = d.CTRL_INDEX;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        api api = (api) this.gLB.hnQ.hnY;
        api.wgO = str;
        api.wCN = 0;
        if (list != null) {
            i = list.size();
        }
        api.wCL = i;
        api.wCO = new LinkedList();
        api.wCM = new LinkedList();
        if (list != null) {
            for (String[] strArr : list) {
                if (!bi.oN(strArr[2])) {
                    api.wCM.add(new bet().Vf(strArr[2]));
                }
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final LinkedList<aph> Ow() {
        LinkedList linkedList = ((apj) this.gLB.hnR.hnY).wCP;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aph aph = (aph) it.next();
                as.Hm();
                c.FP().fH(aph.kyG, aph.woW);
            }
        }
        return ((apj) this.gLB.hnR.hnY).wCP;
    }

    public final int getType() {
        return d.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        final apj apj = (apj) this.gLB.hnR.hnY;
        as.Dt().a(new ah.a() {
            public final boolean JI() {
                return false;
            }

            public final boolean JH() {
                if (apj != null && apj.wCP.size() > 0) {
                    Iterator it = apj.wCP.iterator();
                    while (it.hasNext()) {
                        aph aph = (aph) it.next();
                        if (aph.kyY == 1) {
                            h hVar = new h();
                            hVar.username = aph.kyG;
                            hVar.hni = aph.wbY;
                            hVar.hnh = aph.wbZ;
                            hVar.fEo = -1;
                            x.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
                            hVar.fWZ = 3;
                            hVar.bC(true);
                            n.JW().a(hVar);
                        }
                    }
                }
                return true;
            }

            public final String toString() {
                return super.toString() + "|onGYNetEnd";
            }
        });
        this.gLE.a(i2, i3, str, this);
    }
}
