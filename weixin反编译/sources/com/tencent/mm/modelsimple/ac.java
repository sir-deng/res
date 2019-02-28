package com.tencent.mm.modelsimple;

import com.tencent.mm.ac.h;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.c.bfq;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.Iterator;

public final class ac extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    public final boolean hPV;

    public ac(String str) {
        this(str, 0);
    }

    public ac(String str, int i) {
        this(str, i, (byte) 0);
    }

    private ac(String str, int i, byte b) {
        this(str, 1, i, false);
    }

    public ac(String str, int i, int i2, boolean z) {
        this.hPV = z;
        a aVar = new a();
        aVar.hnT = new bfq();
        aVar.hnU = new bfr();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.hnS = 106;
        aVar.hnV = 34;
        aVar.hnW = 1000000034;
        this.gLB = aVar.Kf();
        x.d("MicroMsg.NetSceneSearchContact", "search username [%s]", str);
        bfq bfq = (bfq) this.gLB.hnQ.hnY;
        bfq.wfM = new bet().Vf(str);
        bfq.wMt = i;
        bfq.wRF = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 106;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        h hVar;
        bfr bfr = (bfr) this.gLB.hnR.hnY;
        if (bfr != null && bfr.wrp > 0) {
            Iterator it = bfr.wrq.iterator();
            while (it.hasNext()) {
                bfp bfp = (bfp) it.next();
                x.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", bfp.wfM);
                h hVar2 = new h();
                hVar2.username = n.a(bfp.wfM);
                hVar2.hni = bfp.wbY;
                hVar2.hnh = bfp.wbZ;
                hVar2.fEo = -1;
                x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar2.getUsername(), hVar2.JM(), hVar2.JN());
                hVar2.fWZ = 3;
                hVar2.bC(true);
                com.tencent.mm.ac.n.JW().a(hVar2);
            }
        } else if (!(bfr == null || bi.oN(n.a(bfr.wfM)))) {
            String a = n.a(bfr.wfM);
            hVar = new h();
            hVar.username = a;
            hVar.hni = bfr.wbY;
            hVar.hnh = bfr.wbZ;
            hVar.fEo = -1;
            x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
            hVar.fWZ = 3;
            hVar.bC(true);
            com.tencent.mm.ac.n.JW().a(hVar);
        }
        Iterator it2 = bfr.wRK.iterator();
        while (it2.hasNext()) {
            bgg bgg = (bgg) it2.next();
            hVar = new h();
            hVar.username = bgg.kyG;
            hVar.hni = bgg.wbY;
            hVar.hnh = bgg.wbZ;
            hVar.fEo = -1;
            x.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.JM(), hVar.JN());
            hVar.fWZ = 3;
            hVar.bC(true);
            com.tencent.mm.ac.n.JW().a(hVar);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final bfr Sv() {
        bfr bfr = (bfr) this.gLB.hnR.hnY;
        if (bfr != null) {
            Iterator it = bfr.wrq.iterator();
            while (it.hasNext()) {
                bfp bfp = (bfp) it.next();
                as.Hm();
                c.FP().fH(bfp.wfM.wRo, bfp.woW);
            }
        }
        return bfr;
    }
}
