package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.storage.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public final class x extends k implements com.tencent.mm.network.k, d {
    private static Vector<String> qZQ = new Vector();
    public int Pb = 0;
    final int fqY;
    private b gLB;
    public e gLE;
    private boolean hNJ = false;
    public boolean qZN;
    private long qZO = 0;
    long qZP = 0;
    public int qZR = 0;
    public int qZS = 0;
    private long raG = 0;
    private boolean raH = false;
    private boolean raI = false;
    private long rao = 0;
    private String rap = "";

    public static synchronized boolean KH(String str) {
        boolean z;
        synchronized (x.class) {
            if (qZQ.contains(str)) {
                z = false;
            } else {
                qZQ.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean KI(String str) {
        synchronized (x.class) {
            qZQ.remove(str);
        }
        return true;
    }

    public x(long j) {
        int i;
        long j2;
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a();
        aVar.hnT = new bmg();
        aVar.hnU = new bmh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstimeline";
        aVar.hnS = h.CTRL_INDEX;
        aVar.hnV = 98;
        aVar.hnW = 1000000098;
        this.gLB = aVar.Kf();
        if (ao.isWifi(ad.getContext())) {
            i = 1;
        } else if (ao.is3G(ad.getContext())) {
            i = 3;
        } else if (ao.is4G(ad.getContext())) {
            i = 4;
        } else if (ao.is2G(ad.getContext())) {
            i = 2;
        } else {
            i = 0;
        }
        this.qZO = j;
        this.qZN = j == 0;
        this.fqY = 2;
        bmg bmg = (bmg) this.gLB.hnQ.hnY;
        bmg.wWa = i;
        bmg.wUB = j;
        int bwE = ae.bvV().bwE();
        n bwf = ae.bwf();
        if (this.qZN) {
            j2 = 0;
        } else {
            j2 = j;
        }
        this.qZP = bwf.d(j2, bwE, true);
        bmg.wVX = this.qZP;
        bmg.wVY = c.a(this.qZP, j, "@__weixintimtline");
        if (this.qZN) {
            this.rao = ae.bwf().d(0, 1, true);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "newerid " + this.rao);
            bmg.wVZ = this.rao;
            com.tencent.mm.plugin.sns.storage.k LV = ae.bwj().LV("@__weixintimtline");
            this.rap = LV == null ? "" : LV.field_md5;
            if (this.rap == null) {
                this.rap = "";
            }
            bmg.wUA = this.rap;
            if (LV == null || LV.field_adsession == null) {
                bmg.wUf = new bes().bl(new byte[0]);
            } else {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "request adsession %s", LV.field_adsession);
                bmg.wUf = new bes().bl(LV.field_adsession);
            }
        }
        this.raG = j;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", " This req nextCount: " + bwE + " max:" + j + " min:" + this.qZP + " ReqTime:" + bmg.wVY + " nettype: " + i);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "maxId: %s minId: %s lastReqTime: %s", i.er(j), i.er(this.qZP), Integer.valueOf(r3));
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "NetSceneSnsTimeLine %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private void bvC() {
        n bwf = ae.bwf();
        Cursor a = bwf.gLA.a(n.xF(3), null, 2);
        int i = 0;
        while (a.moveToNext()) {
            i++;
        }
        a.close();
        if (i < 3 && i > 0) {
            this.raI = true;
        } else if (i == 0) {
            this.raH = true;
        }
    }

    private void a(bmh bmh, String str) {
        ai.a("@__weixintimtline", this.fqY, bmh.vSf, str);
        this.qZP = ((blf) bmh.vSf.getLast()).vWS;
        if (this.qZO == 0) {
            this.qZO = ((blf) bmh.vSf.getFirst()).vWS;
        } else {
            this.qZO = c.ev(this.qZO);
        }
        c.d("@__weixintimtline", this.qZO, this.qZP, bmh.wWb);
        try {
            Iterator it = bmh.vSf.iterator();
            while (it.hasNext()) {
                blf blf = (blf) it.next();
                if (blf.wUY == 0) {
                    m eS = ae.bwf().eS(blf.vWS);
                    if (!(eS == null || eS.byF() == null || eS.field_type != 15)) {
                        try {
                            String str2 = ((are) eS.byF().wYj.wfh.get(0)).nlE;
                            g.pWK.h(14388, Long.valueOf(blf.vWS), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bmh bmh = (bmh) ((b) qVar).hnR.hnY;
        if (qVar.Hv().vIb == 207 || qVar.Hv().vIb == 0) {
            int i4;
            if (bmh.wUG != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "serverConfig  " + bmh.wUG.wVT + " " + bmh.wUG.wVS);
                i4 = bmh.wUG.wVT;
                com.tencent.mm.plugin.sns.c.a.qWI = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.qWI = Integer.MAX_VALUE;
                }
                v.xva = bmh.wUG.wVS;
            }
            this.qZR = bmh.wUE;
            this.qZS = bmh.wUF;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "for same md5 count: " + bmh.wUE + " , objCount:  " + bmh.wGO + " cflag : " + bmh.wUF);
            this.Pb = bmh.wGO;
            String es = i.es(this.qZO);
            if (bmh.vSf.isEmpty()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", " respone is Empty");
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "respone size " + bmh.vSf.size() + " Max " + ((blf) bmh.vSf.getFirst()).vWS + " " + i.er(((blf) bmh.vSf.getFirst()).vWS) + "  respone min  " + ((blf) bmh.vSf.getLast()).vWS + " " + i.er(((blf) bmh.vSf.getLast()).vWS));
            }
            if (this.qZN) {
                this.Pb = bmh.wGO;
                if (this.rap.equals(bmh.wUA)) {
                    this.qZP = ae.bwf().d(this.qZN ? 0 : this.raG, this.qZR, true);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qZP));
                    bvC();
                    KI("@__weixintimtline");
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
                cf cfVar;
                String str2;
                String a;
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "fp resp list size " + bmh.vSf.size() + " adsize : " + bmh.wWc);
                ae.bwj().e("@__weixintimtline", bmh.wUA, com.tencent.mm.platformtools.n.a(bmh.wUf));
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= bmh.wWd.size()) {
                        break;
                    }
                    cfVar = (cf) bmh.wWd.get(i5);
                    if (this.hNJ) {
                        str2 = ae.FJ() + "ad.proto";
                        try {
                            byte[] toByteArray = cfVar.toByteArray();
                            com.tencent.mm.a.e.b(str2, toByteArray, toByteArray.length);
                        } catch (Exception e) {
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneSnsTimeLine", "save error " + e.getMessage());
                        }
                    }
                    str2 = com.tencent.mm.platformtools.n.a(cfVar.vOf);
                    a = com.tencent.mm.platformtools.n.a(cfVar.vOe.wUe);
                    String b = com.tencent.mm.platformtools.n.b(cfVar.vOe.wUd.wUN);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + str2);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + a);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + b + "\r\n");
                    i4 = i5 + 1;
                }
                if (this.hNJ && bmh.wWd.size() == 0) {
                    try {
                        byte[] e2 = com.tencent.mm.a.e.e(ae.FJ() + "ad.proto", 0, -1);
                        cf cfVar2 = new cf();
                        cfVar2.aH(e2);
                        bmh.wWd.add(cfVar2);
                        bmh.wWc = bmh.wWd.size();
                        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "read from path " + bmh.wWc);
                        if (bmh.wWd.size() > 0) {
                            cfVar = (cf) bmh.wWd.get(0);
                            String a2 = com.tencent.mm.platformtools.n.a(cfVar.vOf);
                            str2 = com.tencent.mm.platformtools.n.a(cfVar.vOe.wUe);
                            a = com.tencent.mm.platformtools.n.b(cfVar.vOe.wUd.wUN);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "skXml " + a2);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "adXml " + str2);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "snsXml " + a + "\r\n");
                            b(cfVar);
                        }
                    } catch (Exception e3) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NetSceneSnsTimeLine", "read error " + e3.getMessage());
                    }
                }
                a.e(bmh.wWd, bmh.vSf);
                a.ag(bmh.wWd);
                if (bmh.wWc == 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.NetSceneSnsTimeLine", "recv %d recommend", Integer.valueOf(bmh.wWe));
                    a.d(bmh.wWf, bmh.vSf);
                    a.af(bmh.wWf);
                }
                LinkedList linkedList = new LinkedList();
                Iterator it = bmh.vSf.iterator();
                while (it.hasNext()) {
                    linkedList.add(Long.valueOf(((blf) it.next()).vWS));
                }
                com.tencent.mm.sdk.b.b qjVar = new qj();
                qjVar.fIN.fIO = linkedList;
                com.tencent.mm.sdk.b.a.xmy.m(qjVar);
                if (qVar.Hv().vIb == 207) {
                    if (bmh.vSf.isEmpty()) {
                        ae.bwf().bzr();
                        this.qZP = this.qZO;
                    } else {
                        ae.bwf().LX(i.es(((blf) bmh.vSf.getFirst()).vWS));
                        ae.bwf().LW(i.es(((blf) bmh.vSf.getLast()).vWS));
                        a(bmh, es);
                        a.ah(bmh.vSf);
                    }
                    this.raH = true;
                    KI("@__weixintimtline");
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
                if (bmh.vSf.isEmpty()) {
                    ae.bwf().bzr();
                    this.qZP = this.qZO;
                    this.raH = true;
                } else {
                    a(bmh, es);
                    a.ah(bmh.vSf);
                }
                KI("@__weixintimtline");
                this.gLE.a(i2, i3, str, this);
                return;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NetSceneSnsTimeLine", "np resp list size " + bmh.vSf.size());
            if (bmh.vSf.isEmpty()) {
                ae.bwf().LW(es);
                this.raH = true;
                this.qZP = this.qZO;
            } else {
                a(bmh, es);
            }
            KI("@__weixintimtline");
            this.gLE.a(i2, i3, str, this);
            return;
        }
        KI("@__weixintimtline");
        this.gLE.a(i2, i3, str, this);
    }

    private static boolean b(cf cfVar) {
        if (!ao.isWifi(ad.getContext())) {
            return false;
        }
        try {
            com.tencent.mm.modelsns.e.mK(com.tencent.mm.platformtools.n.b(cfVar.vOe.wUd.wUN));
            ae.bwa();
            b.bvj();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final int getType() {
        return h.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final String getUserName() {
        return "@__weixintimtline";
    }

    public final boolean bvl() {
        return this.qZN;
    }

    public final boolean bvm() {
        return this.raH;
    }

    public final boolean bvn() {
        return this.raI;
    }

    public final boolean bvo() {
        return false;
    }

    public final long bvp() {
        return this.qZP;
    }

    public final boolean bvq() {
        return false;
    }

    public final long bvr() {
        return 0;
    }
}
