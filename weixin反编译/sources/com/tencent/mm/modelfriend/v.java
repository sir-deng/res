package com.tencent.mm.modelfriend;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.adz;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.protocal.c.apt;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class v extends k implements com.tencent.mm.network.k {
    b gLB;
    private e gLE = null;
    private List<String> hxB;
    private List<String> hyi;

    public v() {
        Os();
        ady ady = (ady) this.gLB.hnQ.hnY;
        ady.wgY = "";
        ady.wtn = null;
        ady.wtm = 0;
        ady.wtl = null;
        ady.wtk = 0;
        ady.nne = 0;
        ady.sfa = 1;
    }

    public v(List<String> list, List<String> list2) {
        Os();
        if ((list != null && list.size() != 0) || (list2 != null && list2.size() != 0)) {
            this.hxB = list;
            this.hyi = list2;
            ady ady = (ady) this.gLB.hnQ.hnY;
            ady.wgY = "";
            ady.nne = 2;
            ady.sfa = 1;
        }
    }

    private void Os() {
        a aVar = new a();
        aVar.hnT = new ady();
        aVar.hnU = new adz();
        aVar.uri = "/cgi-bin/micromsg-bin/getmfriend";
        aVar.hnS = 142;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final void Ot() {
        ady ady = (ady) this.gLB.hnQ.hnY;
        as.Hm();
        ady.wgY = (String) c.Db().get(65828, null);
        ady.nne = 1;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        ady ady = (ady) this.gLB.hnQ.hnY;
        if (ady.nne == 2) {
            if ((this.hxB == null || this.hxB.size() == 0) && (this.hyi == null || this.hyi.size() == 0)) {
                x.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
                return -1;
            }
            LinkedList linkedList;
            if (this.hxB != null && this.hxB.size() > 0) {
                x.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", Integer.valueOf(this.hxB.size()));
                linkedList = new LinkedList();
                for (String str : this.hxB) {
                    ars ars = new ars();
                    ars.v = str;
                    linkedList.add(ars);
                }
                ady.wtl = linkedList;
                ady.wtk = linkedList.size();
            }
            if (this.hyi != null && this.hyi.size() > 0) {
                x.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", Integer.valueOf(this.hyi.size()));
                linkedList = new LinkedList();
                for (String str2 : this.hyi) {
                    aps aps = new aps();
                    aps.v = str2;
                    linkedList.add(aps);
                }
                ady.wtn = linkedList;
                ady.wtm = linkedList.size();
            }
        }
        return a(eVar, this.gLB, this);
    }

    public final int getType() {
        return 32;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        adz adz = (adz) this.gLB.hnR.hnY;
        ady ady = (ady) this.gLB.hnQ.hnY;
        if (i2 == 4 && i3 == -68) {
            this.gLE.a(i2, i3, adz.wRa.vRT.wRo, this);
        } else if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            as.Hm();
            String oM = bi.oM((String) c.Db().get(65828, null));
            if (!(ady.nne != 1 || bi.oN(adz.wgY) || adz.wgY.equals(oM))) {
                as.Hm();
                c.Db().set(65828, adz.wgY);
                af.OK().NM();
            }
            if (adz.nlt == null) {
                x.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
                return;
            }
            x.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", Integer.valueOf(adz.nlt.size()));
            as.Hm();
            long dA = c.Fc().dA(Thread.currentThread().getId());
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 < adz.nlt.size()) {
                    apt apt = (apt) adz.nlt.get(i5);
                    if (apt == null) {
                        x.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
                    } else {
                        b kV = af.OJ().kV(apt.hxd);
                        if (kV != null || ady.nne == 1) {
                            as.Hm();
                            c.FP().fH(apt.vPp, apt.woW);
                            h hVar = new h();
                            if (ady.nne == 1) {
                                if (apt.wDi == null) {
                                    x.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
                                } else {
                                    hVar.fXc = apt.wDi.pXa;
                                    hVar.hxy = apt.wDi.wiW;
                                    com.tencent.mm.ac.b.iT(apt.wDi.pXa);
                                    hVar.hxx = apt.wDi.nkW;
                                    hVar.ggL = apt.hxj;
                                    hVar.fXl = apt.hxg;
                                    hVar.fXk = apt.hxf;
                                    hVar.signature = apt.hxh;
                                    hVar.fXj = apt.hxi;
                                    hVar.fXa = apt.hxe;
                                    hVar.bgo = apt.wDh;
                                    hVar.hwX = com.tencent.mm.platformtools.c.oE(apt.wDi.nkW);
                                    hVar.hwY = com.tencent.mm.platformtools.c.oD(apt.wDi.nkW);
                                    hVar.username = apt.vPp;
                                }
                            } else if (bi.oN(apt.vPp)) {
                                x.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
                            }
                            k kVar = new k();
                            kVar.username = apt.vPp;
                            kVar.fXk = apt.hxf;
                            kVar.fXl = apt.hxg;
                            kVar.signature = apt.hxh;
                            kVar.fXa = apt.hxe;
                            kVar.fXj = apt.hxi;
                            ag agVar = null;
                            if (!bi.oN(apt.vPp)) {
                                as.Hm();
                                agVar = c.Ff().Xv(apt.vPp);
                                if (agVar == null || !apt.vPp.equals(agVar.field_username)) {
                                    agVar = null;
                                } else if (!(bi.oN(apt.hxj) || apt.hxj.equals(agVar.vU()))) {
                                    agVar.cZ(apt.hxj);
                                    as.Hm();
                                    c.Ff().a(agVar.field_username, agVar);
                                }
                            }
                            if (bi.oN(apt.vPp)) {
                                Assert.assertTrue("mobile friend never go here", ady.nne == 1);
                                hVar.status = 102;
                            } else if (agVar == null || !com.tencent.mm.k.a.ga(agVar.field_type)) {
                                hVar.status = 100;
                                if (kV != null) {
                                    x.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + apt.wDh + " realName:" + kV.Nz() + "  MFriend:" + apt.toString());
                                    kV.status = 1;
                                    kV.username = apt.vPp;
                                    kV.bgo = apt.wDh;
                                    kV.hwX = com.tencent.mm.platformtools.c.oE(apt.wDi.nkW);
                                    kV.hwY = com.tencent.mm.platformtools.c.oD(apt.wDi.nkW);
                                    kV.hxc = kV.Ak();
                                    a(kV, apt);
                                    kV.fEo = -1;
                                    af.OJ().a(kV.Nx(), kV);
                                    h hVar2 = new h();
                                    hVar2.username = apt.vPp;
                                    hVar2.hni = apt.wbY;
                                    hVar2.hnh = apt.wbZ;
                                    hVar2.bC(true);
                                    hVar2.fWZ = 3;
                                    n.JW().a(hVar2);
                                }
                            } else {
                                hVar.status = 101;
                                if (kV != null) {
                                    x.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + apt.wDh + "  md5:" + apt.hxd);
                                    kV.status = 2;
                                    kV.username = apt.vPp;
                                    kV.bgo = apt.wDh;
                                    kV.hxc = kV.Ak();
                                    a(kV, apt);
                                    kV.fEo = -1;
                                    af.OJ().a(kV.Nx(), kV);
                                    com.tencent.mm.ac.b.I(apt.vPp, 3);
                                }
                            }
                            if (ady.nne == 1) {
                                af.OK().a(hVar);
                            }
                            af.OL().a(kVar);
                        } else {
                            x.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + apt.wDh + " md5: " + apt.hxd);
                        }
                    }
                    i4 = i5 + 1;
                } else {
                    as.Hm();
                    c.Fc().fT(dA);
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
            }
        } else {
            x.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.gLE.a(i2, i3, str, this);
        }
    }

    private static void a(b bVar, apt apt) {
        bVar.hxd = apt.hxd;
        bVar.hxe = apt.hxe;
        bVar.hxf = apt.hxf;
        bVar.hxg = apt.hxg;
        bVar.hxh = apt.hxh;
        bVar.hxi = apt.hxi;
        bVar.hxj = apt.hxj;
        bVar.hxk = apt.hxk;
        bVar.hxm = apt.hxm;
        bVar.hxl = apt.hxl;
        bVar.hxn = apt.hxn;
        bVar.hxo = apt.hxo;
        bmk bmk = apt.wCw;
        if (bmk != null) {
            bVar.hxp = bmk.hxp;
            bVar.hxq = bmk.hxq;
            bVar.hxr = bmk.hxr;
        }
        py pyVar = apt.wCx;
        if (pyVar != null) {
            bVar.hxs = pyVar.hxs;
            bVar.hxt = pyVar.hxt;
            bVar.hxu = pyVar.hxu;
            bVar.hxv = pyVar.hxv;
        }
    }
}
