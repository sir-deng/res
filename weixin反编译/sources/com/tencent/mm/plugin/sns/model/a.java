package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import android.util.Base64;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.protocal.c.bkm;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.bne;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.cf;
import com.tencent.mm.protocal.c.z;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final String qYu;
    private static LinkedHashMap<Long, Integer> qYv;
    private static Comparator<bku> qYw = new Comparator<bku>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((bku) obj).pgR - ((bku) obj2).pgR;
        }
    };

    static {
        StringBuilder stringBuilder = new StringBuilder();
        g.Dr();
        qYu = stringBuilder.append(g.Dq().cachePath).append("sns_recvd_ad").toString();
    }

    public static void a(bkj bkj, bes bes) {
        if (bkj == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (bkj.wUd == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            e b = b(bkj);
            if (b != null) {
                b.LO(a(b.field_adinfo, bes));
                if (ae.bwi().eM(bkj.wUd.vWS)) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "ind this adobj and update" + bkj.wUd.vWS);
                    ae.bwi().b(bkj.wUd.vWS, b);
                    return;
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "local can not find this adobj " + bkj.wUd.vWS);
            }
        }
    }

    public static void a(blt blt) {
        a(b(blt));
    }

    public static void a(bkj bkj) {
        if (bkj == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (bkj.wUd == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            ae.bwi().a(bkj.wUd.vWS, b(bkj));
        }
    }

    private static e b(bkj bkj) {
        e eVar;
        e eL = ae.bwi().eL(bkj.wUd.vWS);
        blf blf = bkj.wUd;
        String str = null;
        if (eL == null) {
            eVar = new e();
        } else {
            str = eL.byF().rzD;
            eVar = eL;
        }
        String b = n.b(blf.wUN);
        if (bi.oN(b)) {
            return null;
        }
        if (!eVar.LP(b)) {
            return null;
        }
        bpb byF;
        Iterator it;
        if (!bi.oN(str)) {
            byF = eVar.byF();
            byF.rzD = str;
            eVar.c(byF);
        }
        blf.wVe = ai.b(blf.wVe, eVar.field_attrBuf);
        x.d("MicroMsg.AdSnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(blf.vWS));
        blf.wUN.bl(new byte[0]);
        eVar.field_userName = blf.vPp;
        if (bkj.wUe != null) {
            str = n.a(bkj.wUe);
            if (!bi.oN(str)) {
                eVar.field_recxml = str;
            }
            str = eVar.field_recxml;
            if (!(bi.oN(str) || str.equals(eVar.field_adxml))) {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "update field adxml " + str);
                eVar.field_adxml = str;
            }
        }
        eVar.field_likeFlag = blf.wUO;
        long j = blf.vWS;
        eVar.field_snsId = j;
        if (j != 0) {
            eVar.field_stringSeq = i.er(j);
            eVar.field_stringSeq = i.Ks(eVar.field_stringSeq);
            x.d("MicroMsg.AdSnsInfo", j + " stringSeq " + eVar.field_stringSeq);
        }
        eVar.xB(2);
        eVar.xB(32);
        try {
            blf blf2;
            List<bku> linkedList;
            Iterator it2;
            bku bku;
            Iterator it3;
            bku bku2;
            ag Xv;
            if (eVar.field_attrBuf == null) {
                blf2 = new blf();
            } else {
                blf2 = (blf) new blf().aH(eVar.field_attrBuf);
            }
            if (!(blf2 == null || blf2.wUU == null)) {
                linkedList = new LinkedList();
                it2 = blf.wUU.iterator();
                while (it2.hasNext()) {
                    bku = (bku) it2.next();
                    if (bku.wGC > 0) {
                        linkedList.add(bku);
                        it3 = blf2.wUU.iterator();
                        while (it3.hasNext()) {
                            bku2 = (bku) it3.next();
                            if (bku2.wUq == bku.wUq) {
                                blf2.wUU.remove(bku2);
                                break;
                            }
                        }
                    }
                }
                for (bku bku3 : linkedList) {
                    blf.wUU.remove(bku3);
                }
                linkedList.clear();
                Iterator it4 = blf2.wUU.iterator();
                while (it4.hasNext()) {
                    bku3 = (bku) it4.next();
                    if (!(b(bku3, blf.wUU) || bku3.wUq == 0)) {
                        g.Dr();
                        Xv = ((h) g.h(h.class)).Ff().Xv(bku3.vPp);
                        if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type) || Xv.AM()) {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "not in ommentlist not mycontact " + bku3.vPp);
                        } else {
                            blf.wUU.add(bku3);
                            blf.wUT = blf.wUU.size();
                        }
                    }
                }
            }
            Collections.sort(blf.wUU, qYw);
            if (blf.wUR != null) {
                linkedList = new LinkedList();
                it2 = blf.wUR.iterator();
                while (it2.hasNext()) {
                    bku3 = (bku) it2.next();
                    if (bku3.wGC > 0) {
                        linkedList.add(bku3);
                        it3 = blf2.wUR.iterator();
                        while (it3.hasNext()) {
                            bku2 = (bku) it3.next();
                            if (!bi.oN(bku2.vPp)) {
                                if (bku2.vPp.equals(bku3.vPp)) {
                                }
                            }
                            blf2.wUR.remove(bku2);
                        }
                    }
                }
                for (bku bku32 : linkedList) {
                    blf.wUR.remove(bku32);
                }
                linkedList.clear();
                if (!(blf2 == null || blf2.wUR == null)) {
                    it = blf2.wUR.iterator();
                    while (it.hasNext()) {
                        bku32 = (bku) it.next();
                        if (!a(bku32, blf.wUR)) {
                            g.Dr();
                            Xv = ((h) g.h(h.class)).Ff().Xv(bku32.vPp);
                            if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type) || Xv.AM()) {
                                x.i("MicroMsg.AdSnsInfoStorageLogic", "not in likelist not mycontact " + bku32.vPp);
                            } else {
                                blf.wUR.add(bku32);
                                blf.wUQ = blf.wUR.size();
                            }
                        }
                    }
                }
                Collections.sort(blf.wUR, qYw);
            }
        } catch (Throwable e) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error " + e.getMessage());
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        try {
            eVar.aL(blf.toByteArray());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e2, "", new Object[0]);
        }
        byF = eVar.byF();
        byF.kyG = blf.vPp;
        eVar.field_pravited = byF.wER;
        x.d("MicroMsg.AdSnsInfoStorageLogic", "ext flag " + blf.wGH + " " + blf.wUU.size() + " " + blf.wUR.size());
        it = byF.wYj.wfh.iterator();
        while (it.hasNext()) {
            ((are) it.next()).qWK = true;
        }
        eVar.c(byF);
        eVar.field_type = byF.wYj.wfg;
        eVar.field_subType = byF.wYj.wfi;
        return eVar;
    }

    private static boolean a(bku bku, List<bku> list) {
        for (bku bku2 : list) {
            if (!bi.oN(bku.vPp) && bku.vPp.equals(bku2.vPp)) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(bku bku, List<bku> list) {
        for (bku bku2 : list) {
            if (bku.wUq == bku2.wUq && bku2.wUq != 0) {
                return true;
            }
        }
        return false;
    }

    private static void a(cf cfVar, int i, int i2, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (cfVar == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else if (cfVar.vOe == null || cfVar.vOe.wUd == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "error adobj");
        } else {
            String a;
            blf blf = cfVar.vOe.wUd;
            e b = b(cfVar.vOe);
            bpb byF = b.byF();
            bnd bnd = new bnd();
            bnd.wXc = new bne();
            bnd.wXc.wXg = aVar.rfQ;
            bnd.wXc.wXf = byF.nMq;
            bnd.wXc.cPf = b.getSource();
            bnd.wXc.ruy = p.a(bnd.wXc);
            if (byF.wYj.wfg == 1) {
                bnd.wXc.hQn = 1;
            } else if (byF.wYj.wfg == 15) {
                bnd.wXc.hQn = 2;
            } else {
                bnd.wXc.hQn = 0;
            }
            bne bne = bnd.wXc;
            b byC = b.byC();
            bne.wXh = byC == null ? 0 : byC.rkU;
            try {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "replace newly add snsId:%s, statExtStr:%s(id=%s,uxInfo=%s)", byF.nMq, Base64.encodeToString(bnd.toByteArray(), 0).replace("\n", ""), bnd.wXc.wXf, bnd.wXc.wXg);
                byF.rzD = a;
                b.c(byF);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
            }
            if (b != null) {
                b.field_createTime = i;
                b.field_exposureTime = 0;
                b.field_createAdTime = i2;
                a = n.a(cfVar.vOe.wUe);
                if (!bi.oN(a)) {
                    b.field_recxml = a;
                }
                b.field_adinfo = n.a(cfVar.vOf);
                b.field_adxml = b.field_recxml;
                ae.bwi().a(blf.vWS, b);
            }
        }
    }

    private static bkj b(blt blt) {
        if (blt == null) {
            return null;
        }
        bkj bkj = new bkj();
        bkj.wUe = blt.wVG;
        if (bkj.wUe == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "recommendObj.RecommendXml is null");
        }
        bkj.wUd = blt.wUd;
        return bkj;
    }

    private static cf a(bcm bcm) {
        if (bcm == null) {
            return null;
        }
        cf cfVar = new cf();
        cfVar.vOf = bcm.wPo;
        if (cfVar.vOf == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "recObject.RecommendInfo is null");
            return null;
        }
        cfVar.vOe = b(bcm.wPn);
        return cfVar;
    }

    public static void b(bcm bcm) {
        cf a = a(bcm);
        if (a != null) {
            com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(n.a(a.vOf));
            int i = aVar.rjN;
            int i2 = i <= 0 ? 1 : i + 1;
            int Me = ae.bwf().Me("");
            x.i("MicroMsg.AdSnsInfoStorageLogic", "ad.pos = %d, dbLimit = %d, createTime.limit = %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(Me));
            com.tencent.mm.plugin.sns.storage.n bwf = ae.bwf();
            String str = "";
            String str2 = (com.tencent.mm.plugin.sns.storage.n.rvb + " from SnsInfo where ") + com.tencent.mm.plugin.sns.storage.n.bzq();
            if (com.tencent.mm.plugin.sns.storage.n.LZ(str)) {
                str2 = str2 + " AND " + bwf.Ma(str);
            }
            String str3 = ((((str2 + " AND createTime >= " + Me) + " UNION ") + com.tencent.mm.plugin.sns.storage.n.rvb + " from AdSnsInfo where createTime" + " > " + Me) + com.tencent.mm.plugin.sns.storage.n.rvc) + " limit " + i2;
            x.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str3 + " limtiSeq: " + str);
            Cursor rawQuery = bwf.gLA.rawQuery(str3, null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "db return nothing");
                i2 = (int) bi.Wx();
            } else {
                x.i("MicroMsg.AdSnsInfoStorageLogic", "db return %d feeds", Integer.valueOf(rawQuery.getCount()));
                m mVar = new m();
                if (i < 0) {
                    i2 = 0;
                } else {
                    i2 = i;
                }
                if (rawQuery.moveToPosition(i2)) {
                    mVar.b(rawQuery);
                } else {
                    rawQuery.moveToLast();
                    mVar.b(rawQuery);
                }
                i2 = mVar.field_createTime + 1;
            }
            rawQuery.close();
            x.i("MicroMsg.AdSnsInfoStorageLogic", "inserting snsid  " + a.vOe.wUd.vWS + " ,createTime " + i2);
            a(a, i2, (int) bi.Wx(), aVar);
            a(a);
            a(a.vOe.wUd.vWS, aVar);
        }
    }

    public static void d(LinkedList<bcm> linkedList, LinkedList<blf> linkedList2) {
        if (linkedList != null) {
            LinkedList ae = ae(linkedList);
            x.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ae.size() + " recObj to AdvertiseObj");
            Iterator it = ae.iterator();
            while (it.hasNext()) {
                cf cfVar = (cf) it.next();
                if (et(cfVar.vOe.wUd.vWS)) {
                    x.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by snsId " + cfVar.vOe.wUd.vWS);
                    it.remove();
                }
            }
            a(ae, linkedList2, true);
        }
    }

    public static void e(LinkedList<cf> linkedList, LinkedList<blf> linkedList2) {
        a(linkedList, linkedList2, false);
    }

    private static LinkedList<cf> ae(LinkedList<bcm> linkedList) {
        LinkedList<cf> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cf a = a((bcm) it.next());
            if (a != null) {
                linkedList2.add(a);
            }
        }
        return linkedList2;
    }

    private static void a(LinkedList<cf> linkedList, LinkedList<blf> linkedList2, boolean z) {
        if (linkedList != null && linkedList2 != null && linkedList2.size() != 0) {
            int a = a((blf) linkedList2.get(linkedList2.size() - 1));
            for (int i = 0; i < linkedList.size(); i++) {
                cf cfVar = (cf) linkedList.get(i);
                if (cfVar == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "ad is null");
                } else if (cfVar.vOe == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject is null");
                } else if (cfVar.vOe.wUd == null) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "item.SnsADObject.SnsObject is null");
                } else if (z && ae.bwi().eM(cfVar.vOe.wUd.vWS)) {
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsId %d already exist, ignore ", Long.valueOf(cfVar.vOe.wUd.vWS));
                } else {
                    String a2 = n.a(cfVar.vOf);
                    String a3 = n.a(cfVar.vOe.wUe);
                    String b = n.b(cfVar.vOe.wUd.wUN);
                    com.tencent.mm.plugin.sns.storage.a aVar = new com.tencent.mm.plugin.sns.storage.a(a2);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "skXml " + a2);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "adXml " + a3);
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsXml " + b + "\r\n");
                    b bVar = new b(a3);
                    if (bVar.rkV == 0 || !et(bVar.rkV)) {
                        int i2 = a + 1;
                        if (aVar.rjN >= linkedList2.size() || aVar.rjN < 0) {
                            x.w("MicroMsg.AdSnsInfoStorageLogic", "invalid ad.pos " + aVar.rjN);
                        } else {
                            i2 = a((blf) linkedList2.get(aVar.rjN)) + 1;
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "create adinfo time  " + i2 + " pos " + aVar.rjN);
                        }
                        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "gettime " + currentTimeMillis);
                        a(cfVar, i2, currentTimeMillis, aVar);
                        eu(cfVar.vOe.wUd.vWS);
                        eu(bVar.rkV);
                        a(cfVar.vOe.wUd.vWS, aVar);
                    } else {
                        x.w("MicroMsg.AdSnsInfoStorageLogic", "ignore recvd ad filter by originSnsId " + bVar.rkV);
                    }
                }
            }
        }
    }

    private static void a(long j, com.tencent.mm.plugin.sns.storage.a aVar) {
        if (aVar.rkp && !bi.oN(aVar.rko)) {
            k lVar = new l(j, 1, aVar.rko);
            g.Dr();
            g.Dp().gRu.a(lVar, 0);
        }
    }

    public static void af(LinkedList<bcm> linkedList) {
        if (linkedList != null && !linkedList.isEmpty()) {
            LinkedList ae = ae(linkedList);
            x.i("MicroMsg.AdSnsInfoStorageLogic", "convert " + ae.size() + " recObj to AdvertiseObj");
            ag(ae);
        }
    }

    public static void ag(LinkedList<cf> linkedList) {
        if (linkedList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < linkedList.size()) {
                    a((cf) linkedList.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private static void a(cf cfVar) {
        String a = n.a(cfVar.vOe.wUe);
        if (!bi.oN(a) && new b(a).bxd()) {
            f.byy().d("adId", a, "adxml", 0);
        }
    }

    public static void ah(LinkedList<blf> linkedList) {
        if (linkedList != null) {
            com.tencent.mm.plugin.sns.storage.n bwf = ae.bwf();
            for (int i = 0; i < linkedList.size(); i++) {
                blf blf = (blf) linkedList.get(i);
                if (blf != null) {
                    m eS = bwf.eS(blf.vWS);
                    if (eS != null) {
                        bpb byF = eS.byF();
                        if (!(byF == null || bi.oN(byF.rRR))) {
                            f.byy().d("adId", byF.rRR, "adxml", 0);
                        }
                    }
                }
            }
        }
    }

    public static void KA(String str) {
        if (!bi.oN(str)) {
            f.byy().d("adId", str, "adxml", 1);
        }
    }

    private static int a(blf blf) {
        m eS = ae.bwf().eS(blf.vWS);
        return eS == null ? blf.pgR : eS.field_createTime;
    }

    public static boolean a(long j, bkp bkp, int i, int i2, int i3, boolean z) {
        if (bkp != null) {
            bko bko = bkp.wUu;
            if (!(bko.kzz == 7 || bko.kzz == 8)) {
                return false;
            }
        }
        String FY = q.FY();
        if (bkp != null && bkp.wUv != null && bkp.wUv.wNo != null && bkp.wUv.wNo.equals(FY)) {
            return true;
        }
        e eL = ae.bwi().eL(j);
        try {
            m LQ;
            com.tencent.mm.plugin.sns.storage.a byD;
            c cVar;
            bku bku;
            int i4;
            blf blf = (blf) new blf().aH(eL.field_attrBuf);
            blf.vWS = j;
            int i5 = eL.field_firstControlTime;
            bko bko2 = bkp.wUu;
            int source;
            Object[] objArr;
            if (bko2.kzz == 7) {
                if (i2 > 0 && i5 + i2 < bko2.pgR) {
                    if (z) {
                        LQ = ae.bwf().LQ(eL.byG());
                        if (LQ != null) {
                            byD = LQ.byD();
                            if (byD != null) {
                                cVar = (c) g.h(c.class);
                                source = eL.getSource();
                                objArr = new Object[7];
                                objArr[0] = Long.valueOf(u.Mk(eL.byG()));
                                objArr[1] = byD.iWv;
                                objArr[2] = Integer.valueOf(2);
                                objArr[3] = Integer.valueOf(1);
                                objArr[4] = Integer.valueOf(blf.wUR != null ? blf.wUR.size() : 0);
                                objArr[5] = Integer.valueOf(blf.wUU != null ? blf.wUU.size() : 0);
                                objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                                cVar.a(13182, source, objArr);
                            } else {
                                x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                            }
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                        }
                    }
                    x.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionLikeTimeLimit: " + i2 + " curAction.createTime: " + bko2.pgR + "is over the time limit!");
                    return false;
                }
            } else if (bko2.kzz == 8 && i3 > 0 && i5 + i3 < bko2.pgR) {
                if (z) {
                    LQ = ae.bwf().LQ(eL.byG());
                    if (LQ != null) {
                        byD = LQ.byD();
                        if (byD != null) {
                            cVar = (c) g.h(c.class);
                            source = eL.getSource();
                            objArr = new Object[7];
                            objArr[0] = Long.valueOf(u.Mk(eL.byG()));
                            objArr[1] = byD.iWv;
                            objArr[2] = Integer.valueOf(2);
                            objArr[3] = Integer.valueOf(2);
                            objArr[4] = Integer.valueOf(blf.wUR != null ? blf.wUR.size() : 0);
                            objArr[5] = Integer.valueOf(blf.wUU != null ? blf.wUU.size() : 0);
                            objArr[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            cVar.a(13182, source, objArr);
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "snsid " + j + " firstCreateTime " + i5 + " actionCommentTimeLimit: " + i3 + " curAction.createTime: " + bko2.pgR + "is over the time limit!");
                return false;
            }
            int i6 = 0;
            Iterator it = blf.wUR.iterator();
            while (it.hasNext()) {
                bku = (bku) it.next();
                if (bku.pgR <= i5 || !(bku == null || bku.vPp == null || !bku.vPp.equals(FY))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            int i7 = i6 + 0;
            i6 = 0;
            Iterator it2 = blf.wUU.iterator();
            while (it2.hasNext()) {
                bku = (bku) it2.next();
                if (bku.pgR <= i5 || !(bku == null || bku.vPp == null || !bku.vPp.equals(FY))) {
                    i4 = i6;
                } else {
                    i4 = i6 + 1;
                }
                i6 = i4;
            }
            i4 = i7 + i6;
            x.i("MicroMsg.AdSnsInfoStorageLogic", "totalsize " + i4 + " firstCreateTime " + i5 + " actionLimit: " + i + " actionLikeTimeLimit: " + i2 + " actionCommentTimeLimit: " + i3);
            if (i4 >= i) {
                if (z) {
                    LQ = ae.bwf().LQ(eL.byG());
                    if (LQ != null) {
                        byD = LQ.byD();
                        if (byD != null) {
                            cVar = (c) g.h(c.class);
                            i5 = eL.getSource();
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Long.valueOf(u.Mk(eL.byG()));
                            objArr2[1] = byD.iWv;
                            objArr2[2] = Integer.valueOf(1);
                            objArr2[3] = Integer.valueOf(2);
                            objArr2[4] = Integer.valueOf(blf.wUR != null ? blf.wUR.size() : 0);
                            objArr2[5] = Integer.valueOf(blf.wUU != null ? blf.wUU.size() : 0);
                            objArr2[6] = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
                            cVar.a(13182, i5, objArr2);
                        } else {
                            x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the adinfo is null!");
                        }
                    } else {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "when report ad time limit,the snsInfo is null!");
                    }
                }
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    public static boolean a(long j, bkp bkp) {
        bko bko = bkp.wUu;
        if (bko.kzz != 7 && bko.kzz != 8) {
            return false;
        }
        e eL = ae.bwi().eL(j);
        if (eL == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "pass the action because the snsinfo is null " + j);
            return false;
        }
        try {
            blf blf = (blf) new blf().aH(eL.field_attrBuf);
            blf.vWS = j;
            Iterator it;
            bku bku;
            if (bko.kzz == 7) {
                it = blf.wUR.iterator();
                while (it.hasNext()) {
                    bku = (bku) it.next();
                    if (bku.pgR == bko.pgR && bku.vPp.equals(bko.wNo)) {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + bku.pgR + " ");
                        return false;
                    }
                }
                blf.wUR.add(ac.a(bkp));
            } else if (bko.kzz == 8) {
                it = blf.wUU.iterator();
                while (it.hasNext()) {
                    bku = (bku) it.next();
                    if (bku.pgR == bko.pgR && bku.vPp.equals(bko.wNo)) {
                        x.i("MicroMsg.AdSnsInfoStorageLogic", "like create time " + bku.pgR + " ");
                        return false;
                    }
                }
                blf.wUU.add(ac.a(bkp));
            }
            eL.aL(blf.toByteArray());
            ae.bwi().a(blf.vWS, eL);
        } catch (Throwable e) {
            x.e("MicroMsg.AdSnsInfoStorageLogic", "e " + e.getMessage());
            x.printErrStackTrace("MicroMsg.AdSnsInfoStorageLogic", e, "", new Object[0]);
        }
        return true;
    }

    private static boolean et(long j) {
        bvh();
        return qYv.get(Long.valueOf(j)) != null;
    }

    private static void bvh() {
        Throwable e;
        if (qYv == null) {
            byte[] SE = com.tencent.mm.pluginsdk.i.a.e.a.SE(qYu);
            if (SE != null) {
                ObjectInput objectInputStream;
                try {
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(SE));
                    try {
                        qYv = (LinkedHashMap) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e2) {
                        }
                    } catch (StreamCorruptedException e3) {
                        e = e3;
                        try {
                            x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                            if (qYv != null) {
                                qYv = new LinkedHashMap<Long, Integer>(((int) Math.ceil(666.6666870117188d)) + 1) {
                                    protected final boolean removeEldestEntry(Entry<Long, Integer> entry) {
                                        if (size() > 500 && entry != null) {
                                            x.i("MicroMsg.AdSnsInfoStorageLogic", "remove eldest ad snsId " + entry.getKey());
                                        }
                                        return size() > 500;
                                    }
                                };
                            }
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (IOException e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        if (qYv != null) {
                            qYv = /* anonymous class already generated */;
                        }
                    } catch (ClassNotFoundException e8) {
                        e = e8;
                        x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        if (qYv != null) {
                            qYv = /* anonymous class already generated */;
                        }
                    }
                } catch (StreamCorruptedException e10) {
                    e = e10;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (qYv != null) {
                        qYv = /* anonymous class already generated */;
                    }
                } catch (IOException e11) {
                    e = e11;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (qYv != null) {
                        qYv = /* anonymous class already generated */;
                    }
                } catch (ClassNotFoundException e12) {
                    e = e12;
                    objectInputStream = null;
                    x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e));
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (qYv != null) {
                        qYv = /* anonymous class already generated */;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw e;
                }
            }
            if (qYv != null) {
                qYv = /* anonymous class already generated */;
            }
        }
    }

    private static void eu(long j) {
        if (j != 0) {
            if (qYv == null) {
                bvh();
            }
            qYv.put(Long.valueOf(j), Integer.valueOf(0));
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ObjectOutput objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(qYv);
                objectOutputStream.flush();
                com.tencent.mm.pluginsdk.i.a.e.a.u(qYu, byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.AdSnsInfoStorageLogic", bi.i(e2));
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Throwable e22) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                }
                throw e22;
            }
        }
    }

    private static String a(String str, bes bes) {
        if (bes == null || str == null) {
            x.i("MicroMsg.AdSnsInfoStorageLogic", "update with empty dynamic data");
            return str;
        }
        String str2;
        try {
            z zVar = new z();
            zVar.aH(bes.wRm.oz);
            if (zVar.vKE != null) {
                String str3 = "<(([a-zA-Z0-9\\-_]+)([^>]+)dynamicKey=[\"']%s[\"']([^>]*))";
                String str4 = "";
                Iterator it = zVar.vKE.iterator();
                str2 = str;
                while (it.hasNext()) {
                    try {
                        String str5;
                        bkm bkm = (bkm) it.next();
                        if (bkm.aAM != null) {
                            String format = String.format(str3, new Object[]{bkm.aAM});
                            Matcher matcher = Pattern.compile(format).matcher(str2);
                            if (matcher.find()) {
                                String group = matcher.group(2);
                                if (group != null && group.length() > 0) {
                                    str2 = str2.replaceAll(format + String.format("((>[\\s\\S]*</%s>)|(/([^>]*)>))", new Object[]{group}), String.format("<$1>%s</%s>", new Object[]{bkm.value, group}));
                                    str5 = str4 + bkm.aAM + ":" + bkm.value + ";";
                                    str2 = str2;
                                    str4 = str5;
                                }
                            }
                        }
                        str5 = str4;
                        str2 = str2;
                        str4 = str5;
                    } catch (Exception e) {
                    }
                }
                x.i("MicroMsg.AdSnsInfoStorageLogic", "DynamicData is: [%s]", str4);
                if (bj.y(str, "ADInfo") == null) {
                    x.w("MicroMsg.AdSnsInfoStorageLogic", "DynamicData xml format error!");
                    return str;
                }
            }
            str2 = str;
        } catch (Exception e2) {
            str2 = str;
            x.w("MicroMsg.AdSnsInfoStorageLogic", "replace error occurs!");
            return str2;
        }
        return str2;
    }
}
