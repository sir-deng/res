package com.tencent.mm.ae;

import com.tencent.mm.a.o;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.sb;
import com.tencent.mm.f.a.sc;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.hf;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a extends k implements com.tencent.mm.network.k {
    private String fyO;
    private String fyQ;
    public final b gLB;
    private e gLE;
    public long hpJ;

    public a(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] c;
        this.hpJ = 0;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new hf();
        aVar.hnU = new hg();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.hpJ = j;
        hf hfVar = (hf) this.gLB.hnQ.hnY;
        hfVar.vTr = new o(j).intValue();
        hfVar.vTg = "";
        hfVar.vTs = "";
        hfVar.vTt = "";
        hfVar.vTu = "";
        hfVar.vTw = new bet().Vf("");
        hfVar.vTv = 1;
        if (z) {
            c = as.Cx().c(j, str3);
        } else {
            c = as.Cx().a(j, bi.Wi(str), true);
        }
        hfVar.vRI = new bes().bl(c);
        as.Hm();
        hfVar.vTx = new bes().bl(bi.Wj(bi.oM((String) c.Db().get(47, null))));
        x.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(bi.bz(c)), str3, str2, str4, r1);
    }

    public a(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        this.fyO = str5;
        this.fyQ = str6;
        hf hfVar = (hf) this.gLB.hnQ.hnY;
        hfVar.vSX = str5;
        hfVar.vSY = str6;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        hf hfVar = (hf) this.gLB.hnQ.hnY;
        hg hgVar = (hg) this.gLB.hnR.hnY;
        byte[] a = n.a(hgVar.vPT);
        boolean z = false;
        if (!bi.by(a)) {
            z = as.Cx().a(new o(hfVar.vTr).longValue(), a);
        }
        x.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(bi.bz(a)), hgVar.vTt);
        if (i2 == 0 && i3 == 0) {
            as.Hm();
            c.Db().set(9, Integer.valueOf(hfVar.vTr));
            if (hfVar.vTv == 1) {
                as.Hm();
                c.Db().set(17, Integer.valueOf(hgVar.vMm));
            }
            as.Hm();
            c.Fn().ar(hgVar.vTA, hgVar.vTz == 1);
            int i4 = hfVar.vTr;
            if (i4 != 0) {
                as.Hm();
                c.Fn().bJ(new o(i4) + "@qqim", 3);
            }
            com.tencent.mm.ac.b.c((long) i4, 3);
            as.Hm();
            c.Db().set(32, hfVar.vTg);
            as.Hm();
            c.Db().set(33, hfVar.vTs);
            x.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", Boolean.valueOf(z), bi.Wz(bi.bA(as.Cx().aR(new o(hfVar.vTr).longValue()))));
            as.Hm();
            c.Db().set(72, r3);
            as.Hm();
            c.Db().set(46, bi.bA(n.a(hgVar.vPZ)));
            String bA = bi.bA(n.a(hfVar.vTx));
            as.Hm();
            c.Db().set(47, bA);
            as.Hk().set(18, bA);
            as.Hm();
            c.Db().set(-1535680990, hgVar.vTB);
            if (!(bi.oN(this.fyO) || bi.oN(this.fyQ))) {
                as.Hm();
                c.Db().set(64, Integer.valueOf(hgVar.vMj));
                com.tencent.mm.sdk.b.b sbVar = new sb();
                sbVar.fKD.fKE = hgVar;
                com.tencent.mm.sdk.b.a.xmy.m(sbVar);
                com.tencent.mm.sdk.b.b scVar = new sc();
                scVar.fKF.fKG = true;
                scVar.fKF.fKH = true;
                com.tencent.mm.sdk.b.a.xmy.m(scVar);
            }
        } else if (i2 == 4) {
            as.Hm();
            c.Db().set(32, "");
            as.Hm();
            c.Db().set(33, "");
        }
        if (hfVar.vTv == 3 && i3 == -3) {
            i3 = 10000;
            x.d("MicroMsg.NetSceneBindQQ", new StringBuilder("onGYNetEnd : retCode = 10000").toString());
        }
        this.gLE.a(i2, i3, str, this);
    }
}
