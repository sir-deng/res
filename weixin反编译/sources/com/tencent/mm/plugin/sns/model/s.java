package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.qj;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bmg;
import com.tencent.mm.protocal.c.bmh;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends k implements com.tencent.mm.network.k {
    public int Pb = 0;
    final int fqY;
    private b gLB;
    public e gLE;
    private long qZP = 0;
    public int qZR = 0;
    public int qZS = 0;
    private long rao = 0;
    private String rap = "";

    public s() {
        int i;
        a aVar = new a();
        aVar.hnT = new bmg();
        aVar.hnU = new bmh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspreloadingtimeline";
        aVar.hnS = 718;
        aVar.hnV = 0;
        aVar.hnW = 0;
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
        this.fqY = 2;
        bmg bmg = (bmg) this.gLB.hnQ.hnY;
        bmg.wWa = i;
        bmg.wUB = 0;
        int bwE = ae.bvV().bwE();
        this.qZP = ae.bwf().d(0, bwE, true);
        bmg.wVX = this.qZP;
        bmg.wVY = c.a(this.qZP, 0, "@__weixintimtline");
        this.rao = ae.bwf().d(0, 1, true);
        x.i("MicroMsg.NetSceneSnsPreTimeLine", "newerid " + this.rao);
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
            x.d("MicroMsg.NetSceneSnsPreTimeLine", "request adsession %s", LV.field_adsession);
            bmg.wUf = new bes().bl(LV.field_adsession);
        }
        x.i("MicroMsg.NetSceneSnsPreTimeLine", " This req nextCount: " + bwE + " min:" + this.qZP + " ReqTime:" + bmg.wVY + " nettype: " + i);
        x.d("MicroMsg.NetSceneSnsPreTimeLine", "minId: %s lastReqTime: %s", i.er(this.qZP), Integer.valueOf(r7));
    }

    private void a(bmh bmh, String str) {
        ai.a("@__weixintimtline", this.fqY, bmh.vSf, str);
        this.qZP = ((blf) bmh.vSf.getLast()).vWS;
        c.d("@__weixintimtline", ((blf) bmh.vSf.getFirst()).vWS, this.qZP, bmh.wWb);
        Iterator it = bmh.vSf.iterator();
        while (it.hasNext()) {
            blf blf = (blf) it.next();
            if (blf.wUY == 0) {
                m eS = ae.bwf().eS(blf.vWS);
                if (!(eS == null || eS.byF() == null)) {
                    List<are> list = eS.byF().wYj.wfh;
                    for (are are : list) {
                        Object obj = list.size() <= 1 ? 1 : null;
                        if (are != null) {
                            String e = i.e(are);
                            int i = obj != null ? 1 : 0;
                            String r = am.r(ae.getAccSnsPath(), are.nMq);
                            if (FileOp.bO(r + e) || FileOp.bO(r + i.l(are)) || FileOp.bO(r + i.m(are))) {
                                x.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia exist:%s", are.nMq);
                            } else {
                                x.i("MicroMsg.NetSceneSnsPreTimeLine", "dealwithMedia ready to download:%s", are.nMq);
                                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(are);
                                eVar.qWU = i;
                                eVar.hMN = are.nMq;
                                ae.bwa().a(are, are.kzz == 6 ? 5 : 1, eVar, an.xHp);
                            }
                        }
                    }
                    if (eS.field_type == 15) {
                        aq bwd = ae.bwd();
                        if (eS != null) {
                            x.i("MicroMsg.SnsVideoService", "%d add preload video[%s]", Integer.valueOf(bwd.hashCode()), eS.bza());
                            synchronized (bwd.rdI) {
                                bwd.rdI.addFirst(eS);
                            }
                        }
                        try {
                            String str2 = ((are) eS.byF().wYj.wfh.get(0)).nlE;
                            g.pWK.h(14388, Long.valueOf(blf.vWS), Integer.valueOf(4), str2, Integer.valueOf(0));
                        } catch (Exception e2) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        ae.bwd().bwJ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsPreTimeLine", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bmh bmh = (bmh) ((b) qVar).hnR.hnY;
        if (qVar.Hv().vIb == 207 || qVar.Hv().vIb == 0) {
            int i4;
            if (bmh.wUG != null) {
                x.d("MicroMsg.NetSceneSnsPreTimeLine", "serverConfig  " + bmh.wUG.wVT + " " + bmh.wUG.wVS);
                i4 = bmh.wUG.wVT;
                com.tencent.mm.plugin.sns.c.a.qWI = i4;
                if (i4 <= 0) {
                    com.tencent.mm.plugin.sns.c.a.qWI = Integer.MAX_VALUE;
                }
                v.xva = bmh.wUG.wVS;
            }
            this.qZR = bmh.wUE;
            this.qZS = bmh.wUF;
            x.i("MicroMsg.NetSceneSnsPreTimeLine", "for same md5 count: " + bmh.wUE + " , objCount:  " + bmh.wGO + " cflag : " + bmh.wUF);
            this.Pb = bmh.wGO;
            String es = i.es(0);
            if (bmh.vSf.isEmpty()) {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", " respone is Empty");
            } else {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "respone size " + bmh.vSf.size() + " Max " + ((blf) bmh.vSf.getFirst()).vWS + " " + i.er(((blf) bmh.vSf.getFirst()).vWS) + "  respone min  " + ((blf) bmh.vSf.getLast()).vWS + " " + i.er(((blf) bmh.vSf.getLast()).vWS));
            }
            this.Pb = bmh.wGO;
            if (this.rap.equals(bmh.wUA)) {
                this.qZP = ae.bwf().d(0, this.qZR, true);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "md5 is no change!! the new minid %s", Long.valueOf(this.qZP));
                x.KI("@__weixintimtline");
                this.gLE.a(i2, i3, str, this);
                return;
            }
            x.d("MicroMsg.NetSceneSnsPreTimeLine", "fp resp list size " + bmh.vSf.size() + " adsize : " + bmh.wWc);
            ae.bwj().e("@__weixintimtline", bmh.wUA, n.a(bmh.wUf));
            i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= bmh.wWd.size()) {
                    break;
                }
                cf cfVar = (cf) bmh.wWd.get(i5);
                String a = n.a(cfVar.vOf);
                String a2 = n.a(cfVar.vOe.wUe);
                String b = n.b(cfVar.vOe.wUd.wUN);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "skXml " + a);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "adXml " + a2);
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "snsXml " + b + "\r\n");
                i4 = i5 + 1;
            }
            a.e(bmh.wWd, bmh.vSf);
            a.ag(bmh.wWd);
            if (bmh.wWc == 0) {
                x.i("MicroMsg.NetSceneSnsPreTimeLine", "recv %d recommend", Integer.valueOf(bmh.wWe));
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
                } else {
                    ae.bwf().LX(i.es(((blf) bmh.vSf.getFirst()).vWS));
                    ae.bwf().LW(i.es(((blf) bmh.vSf.getLast()).vWS));
                    a(bmh, es);
                    a.ah(bmh.vSf);
                }
                x.KI("@__weixintimtline");
                this.gLE.a(i2, i3, str, this);
                return;
            }
            if (bmh.vSf.isEmpty()) {
                ae.bwf().bzr();
            } else {
                a(bmh, es);
                a.ah(bmh.vSf);
            }
            x.KI("@__weixintimtline");
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.KI("@__weixintimtline");
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 718;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
