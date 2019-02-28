package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.rh;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.protocal.c.fw;
import com.tencent.mm.protocal.c.pg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class b extends k implements com.tencent.mm.network.k {
    private e gLE;
    private Set<String> ptb;

    public b(Set<String> set) {
        Assert.assertTrue(true);
        this.ptb = set;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        List<String> linkedList = new LinkedList();
        for (String add : this.ptb) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", g.zo() + "doScene reqSize ==0");
            return -1;
        }
        a aVar = new a();
        aVar.hnT = new fv();
        aVar.hnU = new fw();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
        aVar.hnV = 28;
        aVar.hnW = 1000000028;
        q Kf = aVar.Kf();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(n.oK(add2));
        }
        ((fv) Kf.hnQ.hnY).vSd = linkedList2;
        ((fv) Kf.hnQ.hnY).vSc = 1;
        ((fv) Kf.hnQ.hnY).kyA = linkedList2.size();
        return a(eVar, Kf, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX;
    }

    protected final int Bo() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            if (h(qVar) && this.ptb.size() > 0) {
                a(this.hok, this.gLE);
            }
            x.d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.ptb.size());
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    private boolean h(q qVar) {
        fw fwVar = (fw) ((com.tencent.mm.ad.b) qVar).hnR.hnY;
        if (fwVar == null) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            return false;
        } else if (qVar.Hv().vIb == 1) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            return false;
        } else if (qVar.Hv().vIb == -1) {
            x.e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            return true;
        } else {
            List list = fwVar.vSe;
            if (list == null) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                pg pgVar;
                boolean z;
                try {
                    pgVar = (pg) new pg().aH(n.a((bes) list.get(i)));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    pgVar = null;
                }
                if (pgVar == null || pgVar.kyG == null) {
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.ptb.contains(pgVar.kyG)) {
                    this.ptb.remove(pgVar.kyG);
                    as.Hm();
                    ag Xv = c.Ff().Xv(pgVar.kyG);
                    if (Xv == null || ((int) Xv.gKO) == 0) {
                        x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        Xv.setUsername(pgVar.kyG);
                        Xv.cZ(pgVar.hxj);
                        Xv.setType(pgVar.weQ & pgVar.weR);
                        Xv.dc(pgVar.kzN);
                        Xv.dd(pgVar.weO);
                        Xv.de(pgVar.weP);
                        Xv.eD(pgVar.hxe);
                        Xv.da(pgVar.weS);
                        Xv.dg(pgVar.weV);
                        Xv.dh(pgVar.weU);
                        Xv.eG(pgVar.weW);
                        Xv.db(pgVar.weZ);
                        Xv.eH(pgVar.wfa);
                        as.Hm();
                        if (c.Ff().a(Xv.field_username, Xv) == -1) {
                            x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (com.tencent.mm.storage.x.Xf(pgVar.kyG)) {
                            d Ii = g.bkF().Ii(pgVar.kyG);
                            if (Ii == null || bi.oM(Ii.getUsername()).length() <= 0) {
                                x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                Ii.extInfo = pgVar.nqi;
                                Ii.pte = (long) pgVar.wfc;
                                Ii.ptf = (long) pgVar.wfd;
                                Ii.fEo = 52;
                                if (!g.bkF().a(pgVar.kyG, Ii)) {
                                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (com.tencent.mm.storage.x.Xd(pgVar.kyG)) {
                            com.tencent.mm.sdk.b.b rhVar = new rh();
                            rhVar.fJQ.opType = 0;
                            rhVar.fJQ.fEx = pgVar.kyG;
                            rhVar.fJQ.fEy = pgVar.wfc;
                            rhVar.fJQ.fEz = pgVar.weT;
                            com.tencent.mm.sdk.b.a.xmy.m(rhVar);
                        }
                        z = true;
                    }
                } else {
                    x.e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }
    }
}
