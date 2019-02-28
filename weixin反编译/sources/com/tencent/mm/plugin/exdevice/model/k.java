package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.af.d;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.protocal.c.gh;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    private e gQm = null;
    private b lSH = null;
    private String[] lSI;

    public k(String[] strArr, String str) {
        this.lSI = strArr;
        x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", str, Integer.valueOf(1));
        a aVar = new a();
        aVar.hnT = new gf();
        aVar.hnU = new gg();
        aVar.hnS = 542;
        aVar.uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.lSH = aVar.Kf();
        gf gfVar = (gf) this.lSH.hnQ.hnY;
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i <= 0; i++) {
            String str2 = strArr[0];
            if (str2 != null) {
                ge geVar = new ge();
                geVar.vSj = str2;
                linkedList.add(geVar);
                x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", str2);
            }
        }
        gfVar.vSk = linkedList;
        if (!bi.oN(str)) {
            gd gdVar = new gd();
            gdVar.vSi = str;
            gfVar.vSl = gdVar;
        }
        gfVar.vSm = 3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.lSI != null && this.lSI.length == 1) {
            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", this.lSI[0]);
        }
        if (qVar == null) {
            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
        } else if (this.lSH.hnS != qVar.getType()) {
            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", Integer.valueOf(this.lSH.hnS), Integer.valueOf(qVar.getType()));
        } else {
            if (i2 == 0 && i3 == 0) {
                Iterator it = aEJ().vSn.iterator();
                while (it.hasNext()) {
                    gh ghVar = (gh) it.next();
                    x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", Integer.valueOf(ghVar.vQL), ghVar.vSo, ghVar.vSj, ghVar.kyK);
                    if (ghVar.vSp == null) {
                        x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
                    } else {
                        asc asc = ghVar.vSp;
                        if (asc == null) {
                            x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
                        } else {
                            String a = n.a(asc.wfM);
                            String oM = bi.oM(asc.wGt);
                            if (bi.oN(a) && bi.oN(oM)) {
                                x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", a, oM);
                            } else {
                                x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", a);
                                as.Hm();
                                ag Xv = c.Ff().Xv(a);
                                if (Xv == null || !a.equals(Xv.field_encryptUsername)) {
                                    com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x(a);
                                    xVar.cZ(asc.hxj);
                                    xVar.setType(asc.weQ & asc.weR);
                                    if (!bi.oN(oM)) {
                                        xVar.di(oM);
                                    } else if (Xv != null && ((int) Xv.gKO) > 0) {
                                        xVar.di(Xv.field_encryptUsername);
                                    }
                                    xVar.gKO = Xv == null ? 0 : (long) ((int) Xv.gKO);
                                    xVar.dc(n.a(asc.wzM));
                                    xVar.dd(n.a(asc.wfA));
                                    xVar.de(n.a(asc.wfB));
                                    xVar.eD(asc.hxe);
                                    xVar.eG(asc.weW);
                                    xVar.db(n.a(asc.wGn));
                                    xVar.eH(asc.wfa);
                                    xVar.eI(asc.hxi);
                                    xVar.dv(RegionCodeDecoder.ai(asc.hxn, asc.hxf, asc.hxg));
                                    xVar.dp(asc.hxh);
                                    xVar.ez(asc.wCq);
                                    xVar.du(asc.wCr);
                                    xVar.setSource(asc.vON);
                                    xVar.ey(asc.wCu);
                                    xVar.df(asc.wCt);
                                    if (s.hw(asc.wCs)) {
                                        xVar.dt(asc.wCs);
                                    }
                                    xVar.eK((int) bi.Wx());
                                    xVar.da(n.a(asc.wFS));
                                    xVar.dg(n.a(asc.wFU));
                                    xVar.dh(n.a(asc.wFT));
                                    xVar.dw(asc.vPF);
                                    xVar.dx(asc.wGD);
                                    if (!(Xv == null || bi.oM(Xv.fXu).equals(bi.oM(asc.wGD)))) {
                                        com.tencent.mm.ba.c.QS();
                                        com.tencent.mm.ba.c.lT(a);
                                    }
                                    as.Hm();
                                    c.Ff().XA(a);
                                    if (bi.oN(xVar.field_username)) {
                                        x.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                                    } else {
                                        String str2 = xVar.field_username;
                                        com.tencent.mm.ac.n.JW().a(com.tencent.mm.ac.b.a(str2, asc));
                                        bmk bmk = asc.wCw;
                                        if (!(xVar.field_username.endsWith("@chatroom") || bmk == null)) {
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + bmk.hxp + " " + asc.wfM);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + bmk.hxq);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + bmk.hxr);
                                            x.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + bmk.wWj);
                                            if (com.tencent.mm.plugin.sns.b.n.qWC != null) {
                                                com.tencent.mm.plugin.sns.b.n.qWC.a(xVar.field_username, bmk);
                                            }
                                        }
                                        String FY = com.tencent.mm.y.q.FY();
                                        if (!(FY == null || FY.equals(str2))) {
                                            d jN = y.Ml().jN(str2);
                                            jN.field_username = str2;
                                            jN.field_brandList = asc.hxo;
                                            py pyVar = asc.wCx;
                                            if (pyVar != null) {
                                                jN.field_brandFlag = pyVar.hxs;
                                                jN.field_brandInfo = pyVar.hxu;
                                                jN.field_brandIconURL = pyVar.hxv;
                                                jN.field_extInfo = pyVar.hxt;
                                                jN.field_attrSyncVersion = null;
                                                jN.field_incrementUpdateTime = 0;
                                            }
                                            if (!y.Ml().e(jN)) {
                                                y.Ml().d(jN);
                                            }
                                            xVar.eL(jN.field_type);
                                        }
                                    }
                                    xVar.eB(asc.wGC);
                                    if (!(asc.wGy == null || asc.wGy.vOb == null)) {
                                        xVar.dy(asc.wGy.vOb.vSL);
                                        xVar.dz(asc.wGy.vOb.vSM);
                                        xVar.dA(asc.wGy.vOb.vSN);
                                    }
                                    if (s.hq(a)) {
                                        xVar.Aw();
                                    }
                                    if (xVar.ciN()) {
                                        xVar.Az();
                                    }
                                    if (bi.oN(oM)) {
                                        as.Hm();
                                        c.Ff().R(xVar);
                                    } else {
                                        as.Hm();
                                        c.Ff().b(oM, xVar);
                                    }
                                    if (!(Xv == null || (Xv.field_type & 2048) == (xVar.field_type & 2048))) {
                                        if ((xVar.field_type & 2048) != 0) {
                                            as.Hm();
                                            c.Fk().XK(xVar.field_username);
                                        } else {
                                            as.Hm();
                                            c.Fk().XL(xVar.field_username);
                                        }
                                    }
                                } else {
                                    x.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
                                }
                            }
                        }
                    }
                }
            }
            this.gQm.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 542;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        return a(eVar, this.lSH, this);
    }

    public final gg aEJ() {
        if (this.lSH == null || this.lSH.hnR.hnY == null) {
            return null;
        }
        return (gg) this.lSH.hnR.hnY;
    }
}
