package com.tencent.mm.modelfriend;

import android.database.Cursor;
import com.tencent.mm.a.o;
import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afl;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.bag;
import com.tencent.mm.protocal.c.bah;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class w extends k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gLE = null;

    public w(int i) {
        a aVar = new a();
        aVar.hnT = new afl();
        aVar.hnU = new afm();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.hnS = 143;
        aVar.hnV = 38;
        aVar.hnW = 1000000038;
        this.gLB = aVar.Kf();
        afl afl = (afl) this.gLB.hnQ.hnY;
        afl.nne = 1;
        afl.wtY = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        afl afl = (afl) this.gLB.hnQ.hnY;
        if (afl.nne != 1 || af.OM().hJ(afl.wtY) != null) {
            return a(eVar, this.gLB, this);
        }
        x.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
        return -1;
    }

    public final int getType() {
        return 143;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            afl afl = (afl) this.gLB.hnQ.hnY;
            afm afm = (afm) this.gLB.hnR.hnY;
            if (afl.nne == 0) {
                a(afm.wtZ);
            } else {
                ad adVar;
                List<ad> arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                List arrayList3 = new ArrayList();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= afm.wua.kyA) {
                        break;
                    }
                    Object obj;
                    k kVar;
                    h hVar;
                    bae bae = (bae) afm.wua.wNH.get(i5);
                    int i6 = afl.wtY;
                    x.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    ad adVar2 = new ad();
                    adVar2.hyC = new o(bae.wND).longValue();
                    com.tencent.mm.ac.b.c(adVar2.hyC, 3);
                    adVar2.hyE = i6;
                    adVar2.hyD = bae.wNF;
                    if (bae.wNF != 0) {
                        if (bae.kyG == null || bae.kyG.equals("")) {
                            obj = null;
                            arrayList.add(obj);
                            kVar = new k();
                            kVar.fXa = bae.hxe;
                            kVar.fXj = bae.hxi;
                            kVar.fXk = bae.hxf;
                            kVar.fXl = bae.hxg;
                            kVar.signature = bae.hxh;
                            kVar.username = bae.kyG;
                            arrayList2.add(kVar);
                            hVar = new h();
                            hVar.fWZ = 3;
                            hVar.bC(true);
                            hVar.username = bae.kyG;
                            hVar.hni = bae.wbY;
                            hVar.hnh = bae.wbZ;
                            arrayList3.add(hVar);
                            i4 = i5 + 1;
                        } else {
                            as.Hm();
                            ag Xv = c.Ff().Xv(bae.kyG);
                            if (Xv != null && Xv.field_username.equals(bae.kyG) && com.tencent.mm.k.a.ga(Xv.field_type)) {
                                adVar2.hyD = 2;
                            } else {
                                adVar2.hyD = 1;
                            }
                        }
                    }
                    adVar2.username = bae.kyG;
                    adVar2.fqG = bae.kzN;
                    adVar2.hyK = bae.wNG;
                    adVar2.hyL = com.tencent.mm.platformtools.c.oE(bae.wNG);
                    adVar2.hyM = com.tencent.mm.platformtools.c.oD(bae.wNG);
                    adVar2.hyF = com.tencent.mm.platformtools.c.oE(bae.kzN);
                    adVar2.hyG = com.tencent.mm.platformtools.c.oD(bae.kzN);
                    adVar2.hyH = bae.wNE;
                    adVar2.hyI = com.tencent.mm.platformtools.c.oE(bae.wNE);
                    adVar2.hyJ = com.tencent.mm.platformtools.c.oD(bae.wNE);
                    i6 = 32;
                    if (!bi.oN(adVar2.OF())) {
                        i6 = adVar2.OF().charAt(0);
                    } else if (!bi.oN(adVar2.OG())) {
                        i6 = adVar2.OG().charAt(0);
                    } else if (!bi.oN(adVar2.OC())) {
                        i6 = adVar2.OC().charAt(0);
                    } else if (!bi.oN(adVar2.OD())) {
                        i6 = adVar2.OD().charAt(0);
                    }
                    if (i6 >= 97 && i6 <= 122) {
                        i6 = (char) (i6 - 32);
                    } else if (i6 < 65 || i6 > 90) {
                        i6 = 123;
                    }
                    adVar2.hne = i6;
                    as.Hm();
                    c.FP().fH(bae.kyG, bae.woW);
                    x.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + adVar2.OB() + "  remark: " + adVar2.OE());
                    ad obj2 = adVar2;
                    arrayList.add(obj2);
                    kVar = new k();
                    kVar.fXa = bae.hxe;
                    kVar.fXj = bae.hxi;
                    kVar.fXk = bae.hxf;
                    kVar.fXl = bae.hxg;
                    kVar.signature = bae.hxh;
                    kVar.username = bae.kyG;
                    arrayList2.add(kVar);
                    hVar = new h();
                    hVar.fWZ = 3;
                    hVar.bC(true);
                    hVar.username = bae.kyG;
                    hVar.hni = bae.wbY;
                    hVar.hnh = bae.wbZ;
                    arrayList3.add(hVar);
                    i4 = i5 + 1;
                }
                HashMap hashMap = new HashMap();
                ae OO = af.OO();
                i4 = afl.wtY;
                x.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i4);
                Cursor a = OO.hiZ.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i4 + "\"", null, 0);
                while (a.moveToNext()) {
                    adVar = new ad();
                    adVar.b(a);
                    hashMap.put(Long.valueOf(adVar.hyC), adVar);
                }
                a.close();
                for (ad adVar3 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(adVar3.hyC))) {
                        adVar = (ad) hashMap.get(Long.valueOf(adVar3.hyC));
                        Object obj3 = !bi.s(Long.valueOf(adVar.hyC), Long.valueOf(adVar3.hyC)) ? null : !bi.s(Integer.valueOf(adVar.hyD), Integer.valueOf(adVar3.hyD)) ? null : !bi.s(Integer.valueOf(adVar.hyE), Integer.valueOf(adVar3.hyE)) ? null : !bi.s(adVar.username, adVar3.username) ? null : !bi.s(adVar.fqG, adVar3.fqG) ? null : !bi.s(adVar.hyF, adVar3.hyF) ? null : !bi.s(adVar.hyG, adVar3.hyG) ? null : !bi.s(adVar.hyH, adVar3.hyH) ? null : !bi.s(adVar.hyI, adVar3.hyI) ? null : !bi.s(adVar.hyJ, adVar3.hyJ) ? null : !bi.s(adVar.hyK, adVar3.hyK) ? null : !bi.s(adVar.hyL, adVar3.hyL) ? null : !bi.s(adVar.hyM, adVar3.hyM) ? null : !bi.s(adVar.hnc, adVar3.hnc) ? null : !bi.s(adVar.hnd, adVar3.hnd) ? null : !bi.s(Integer.valueOf(adVar.hne), Integer.valueOf(adVar3.hne)) ? null : !bi.s(Integer.valueOf(adVar.hnf), Integer.valueOf(adVar3.hnf)) ? null : 1;
                        if (obj3 == null) {
                            af.OO().a(adVar3.hyC, adVar3);
                            hashMap.remove(Long.valueOf(adVar3.hyC));
                        }
                    } else {
                        af.OO().a(adVar3);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    m OO2 = af.OO();
                    x.d("MicroMsg.QQListStorage", "delete: QQ:" + longValue2);
                    if (OO2.hiZ.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        OO2.b(5, OO2, String.valueOf(longValue2));
                    }
                }
                af.OL().H(arrayList2);
                n.JW().H(arrayList3);
                ab abVar = new ab();
                abVar.hyu = afl.wtY;
                abVar.hyz = 0;
                abVar.hyy = (int) bi.Wx();
                abVar.fEo = 48;
                af.OM().a(abVar);
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    private static void a(bah bah) {
        Map map;
        ab abVar;
        ab abVar2;
        Cursor a = af.OM().hiZ.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
        if (a == null) {
            map = null;
        } else if (a.getCount() <= 0) {
            a.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < a.getCount(); i++) {
                a.moveToPosition(i);
                abVar = new ab();
                abVar.b(a);
                map.put(Integer.valueOf(abVar.hyu), abVar);
            }
            a.close();
        }
        for (int i2 = 0; i2 < bah.kyA; i2++) {
            bag bag = (bag) bah.wNJ.get(i2);
            x.d("MicroMsg.NetSceneGetQQGroup", "id:" + bag.wtY + " name:" + bag.wnK + " mem:" + bag.wio + " wei:" + bag.wNI + " md5:" + bag.wgY);
            if (bag.wtY < 0) {
                abVar = null;
            } else {
                abVar = new ab();
                abVar.hyu = bag.wtY;
                abVar.hyB = bag.wnK;
                abVar.hyv = bag.wio;
                abVar.hyw = bag.wNI;
                abVar.hyA = bag.wgY;
            }
            if (abVar == null) {
                x.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i2);
            } else if (abVar.hyv != 0) {
                if (map != null) {
                    abVar2 = (ab) map.get(Integer.valueOf(abVar.hyu));
                } else {
                    abVar2 = null;
                }
                if (abVar2 == null) {
                    boolean z;
                    abVar.hyx = (int) bi.Wx();
                    abVar.hyy = (int) bi.Wx();
                    abVar.hyz = 1;
                    ac OM = af.OM();
                    if (abVar != null) {
                        x.d("MicroMsg.QQGroupStorage", "insert: name:" + abVar.Oz());
                        abVar.fEo = -1;
                        if (((int) OM.hiZ.insert("qqgroup", "grouopid", abVar.Ox())) >= 0) {
                            OM.doNotify();
                            z = true;
                            x.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + abVar.Oz() + " ret:" + z);
                        }
                    }
                    z = false;
                    x.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + abVar.Oz() + " ret:" + z);
                } else {
                    abVar2.hyz = -1;
                    x.d("MicroMsg.NetSceneGetQQGroup", abVar.Oy() + " " + abVar2.Oy() + " " + abVar.hyu);
                    if (!abVar2.Oy().equals(abVar.Oy())) {
                        abVar.hyy = (int) bi.Wx();
                        abVar.hyz = 1;
                        abVar.fEo = -1;
                        x.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + abVar.Oz() + " ret:" + af.OM().a(abVar));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                abVar2 = (ab) map.get(obj);
                if (abVar2.hyz == 0) {
                    boolean z2;
                    ac OM2 = af.OM();
                    x.d("MicroMsg.QQGroupStorage", "delete: id:" + abVar2.hyu);
                    if (OM2.hiZ.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        OM2.doNotify();
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    x.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + abVar2.Oz() + " ret:" + z2);
                    ae OO = af.OO();
                    x.d("MicroMsg.QQListStorage", "delete: GroupID:" + abVar2.hyu);
                    if (OO.hiZ.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    x.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + abVar2.Oz() + " ret:" + z2);
                }
            }
        }
    }
}
