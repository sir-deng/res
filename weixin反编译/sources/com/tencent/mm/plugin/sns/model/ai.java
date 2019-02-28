package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.a;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.ajv;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bln;
import com.tencent.mm.protocal.c.blu;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.ci;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ai {
    private static Map<String, blf> rdb = new ConcurrentHashMap();

    public static List<m> a(String str, boolean z, String str2, boolean z2) {
        Cursor a;
        if (z2) {
            a = ae.bwf().a(false, str, 10, z, str2);
        } else {
            a = ae.bwf().a(false, str, 0, z, str2);
        }
        List<m> arrayList = new ArrayList();
        if (a.getCount() == 0) {
            a.close();
            return arrayList;
        }
        if (a.moveToFirst()) {
            do {
                m mVar = new m();
                mVar.b(a);
                arrayList.add(mVar);
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public static m KQ(String str) {
        Cursor a = ae.bwf().a(true, str, 1, false, "");
        if (a.getCount() == 0) {
            a.close();
            return null;
        }
        a.moveToFirst();
        m mVar = new m();
        mVar.b(a);
        if (a.isClosed()) {
            return mVar;
        }
        a.close();
        return mVar;
    }

    public static void bwy() {
        if (rdb != null) {
            rdb.clear();
        }
    }

    public static blf m(m mVar) {
        try {
            blf c = ae.bwe().c((blf) new blf().aH(mVar.field_attrBuf));
            rdb.clear();
            return c;
        } catch (Throwable e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new blf();
        }
    }

    public static blf n(m mVar) {
        try {
            blf blf;
            if (mVar.ruL == null) {
                mVar.ruL = g.s(mVar.field_content) + g.s(mVar.field_attrBuf);
            }
            if (rdb.containsKey(mVar.ruL)) {
                blf = (blf) rdb.get(mVar.ruL);
                if (blf != null) {
                    ae.bwe().c(blf);
                    return blf;
                }
            }
            blf = (blf) new blf().aH(mVar.field_attrBuf);
            rdb.put(mVar.ruL, blf);
            ae.bwe().c(blf);
            return blf;
        } catch (Throwable e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "SnsObject parseFrom error");
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            return new blf();
        }
    }

    public static void b(long j, bkp bkp) {
        bko bko = bkp.wUu;
        if (bko.kzz == 9) {
            m eS = ae.bwf().eS(j);
            if (eS != null) {
                try {
                    blf blf = (blf) new blf().aH(eS.field_attrBuf);
                    blf.vWS = j;
                    Iterator it = blf.wUU.iterator();
                    while (it.hasNext()) {
                        bku bku = (bku) it.next();
                        if (bku.wUn == bko.wUn && !bi.oN(bku.vPp) && bku.vPp.equals(bko.wNo)) {
                            blf.wUU.remove(bku);
                            break;
                        }
                    }
                    eS.aL(blf.toByteArray());
                    ae.bwf().a(blf.vWS, eS);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void c(long j, bkp bkp) {
        bko bko = bkp.wUu;
        if (bko.kzz == 13) {
            m eS = ae.bwf().eS(j);
            if (eS != null) {
                try {
                    blf blf = (blf) new blf().aH(eS.field_attrBuf);
                    blf.vWS = j;
                    if (blf.wVf == null) {
                        blf.wVf = new blu();
                    }
                    if (bko.kzz == 13) {
                        Iterator it = blf.wVf.wVI.iterator();
                        while (it.hasNext()) {
                            if (((blb) it.next()).vPp.equals(bko.wNo)) {
                                return;
                            }
                        }
                        blb blb = new blb();
                        blb.wUr = bko.wUr;
                        blb.pgR = bko.pgR;
                        blb.vPp = bko.wNo;
                        blf.wVf.wVI.add(blb);
                        blf.wVf.wVH = blf.wVf.wVI.size();
                    }
                    eS.aL(blf.toByteArray());
                    ae.bwf().a(blf.vWS, eS);
                } catch (Throwable e) {
                    x.e("MicroMsg.SnsInfoStorageLogic", "error for update hbaction " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static boolean a(long j, bkp bkp) {
        bko bko = bkp.wUu;
        if (bko.kzz != 1 && bko.kzz != 2) {
            return true;
        }
        m eS = ae.bwf().eS(j);
        if (eS == null) {
            return true;
        }
        if (eS.field_type != 21 || com.tencent.mm.plugin.sns.lucky.a.g.buZ()) {
            try {
                blf blf = (blf) new blf().aH(eS.field_attrBuf);
                blf.vWS = j;
                Iterator it;
                bku bku;
                if (bko.kzz == 1) {
                    it = blf.wUR.iterator();
                    while (it.hasNext()) {
                        bku = (bku) it.next();
                        if (bku.pgR == bko.pgR && bku.vPp.equals(bko.wNo)) {
                            return true;
                        }
                    }
                    blf.wUR.add(ac.a(bkp));
                } else if (bko.kzz == 2) {
                    it = blf.wUU.iterator();
                    while (it.hasNext()) {
                        bku = (bku) it.next();
                        if (bku.pgR == bko.pgR && bku.vPp.equals(bko.wNo)) {
                            return true;
                        }
                    }
                    blf.wUU.add(ac.a(bkp));
                }
                eS.aL(blf.toByteArray());
                ae.bwf().a(blf.vWS, eS);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            }
            return true;
        }
        x.i("MicroMsg.SnsInfoStorageLogic", "passed because close lucky");
        return false;
    }

    public static long d(blf blf) {
        String str = "";
        m eS = ae.bwf().eS(blf.vWS);
        if (eS == null) {
            eS = new m();
        }
        return a(eS, blf, str, 0);
    }

    private static long a(m mVar, blf blf, String str, int i) {
        int i2 = 1;
        if (mVar == null) {
            mVar = new m();
        }
        if (!ae.bwe().eD(mVar.field_snsId)) {
            return blf.vWS;
        }
        if (blf.wUY != 0) {
            x.i("MicroMsg.SnsInfoStorageLogic", "hit the filter id:" + blf.vWS + "  " + i.er(blf.vWS));
            if (mVar.xD(i)) {
                i2 = 0;
            } else {
                mVar.xB(i);
            }
            if (i2 != 0) {
                ae.bwf().a(blf.vWS, mVar);
            }
            return blf.vWS;
        }
        LinkedList linkedList = blf.wUU;
        x.i("MicroMsg.SnsInfoStorageLogic", "hasChange id:  %s listSize %s Stringid %s", Long.valueOf(blf.vWS), Integer.valueOf(linkedList.size()), i.er(blf.vWS));
        if (blf.wUN == null || blf.wUN.wRm == null) {
            x.i("MicroMsg.SnsInfoStorageLogic", "object desc is null");
            return blf.vWS;
        }
        String str2 = new String(blf.wUN.wRm.toByteArray());
        x.d("MicroMsg.SnsInfoStorageLogic", "from server %d ", Long.valueOf(blf.vWS));
        if (bi.oN(str2)) {
            return blf.vWS;
        }
        if (!mVar.LP(str2)) {
            return blf.vWS;
        }
        int i3;
        blf.wVe = b(blf.wVe, mVar.field_attrBuf);
        x.d("MicroMsg.SnsInfoStorageLogic", "from server xml ok %d", Long.valueOf(blf.vWS));
        blf.wUN.bl(new byte[0]);
        mVar.field_userName = blf.vPp;
        mVar.hN(blf.pgR);
        mVar.field_likeFlag = blf.wUO;
        mVar.eO(blf.vWS);
        mVar.eQ(blf.vWS);
        mVar.xB(i);
        try {
            long Wz = bi.Wz();
            try {
                if (mVar.field_type == 15) {
                    blf blf2 = (blf) new blf().aH(mVar.field_attrBuf);
                    if (!(blf2 == null || blf2.wVg == null || blf2.wVg.wMm <= 0)) {
                        blf.wVg = blf2.wVg;
                        x.i("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo predownload info [%d %d %s] cost[%d]", Integer.valueOf(blf.wVg.wMm), Integer.valueOf(blf.wVg.wMn), blf.wVg.wMo, Long.valueOf(bi.bB(Wz)));
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SnsInfoStorageLogic", "mergePreloadInfo error %s", e.toString());
            }
            mVar.aL(blf.toByteArray());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e2, "", new Object[0]);
        }
        bpb byF = mVar.byF();
        byF.kyG = blf.vPp;
        int i4 = byF.wER;
        mVar.field_pravited = i4;
        x.i("MicroMsg.SnsInfoStorageLogic", "ext flag %s  extflag %s", Long.valueOf(blf.vWS), Integer.valueOf(blf.wGH));
        if ((blf.wGH & 1) > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            mVar.byX();
        } else {
            mVar.byY();
        }
        if (i4 != 1 || i == 4) {
            if (i4 == 1 || (!str.equals(blf.vPp) && i == 4)) {
                mVar.byU();
            }
            mVar.c(byF);
            mVar.field_type = byF.wYj.wfg;
            mVar.field_subType = byF.wYj.wfi;
            ae.bwf().a(blf.vWS, mVar);
            return blf.vWS;
        }
        x.e("MicroMsg.SnsInfoStorageLogic", "svr error push me the private pic in timelnie or others");
        return 0;
    }

    public static bes b(bes bes, byte[] bArr) {
        bes bes2;
        if (bArr != null) {
            try {
                bes2 = ((blf) new blf().aH(bArr)).wVe;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                return null;
            }
        }
        bes2 = null;
        if (bes == null) {
            return bes2;
        }
        bln bln = new bln();
        if (bes2 != null) {
            bln = (bln) bln.aH(bes2.wRm.oz);
        }
        bln bln2 = (bln) new bln().aH(bes.wRm.oz);
        if (bln2.wVt == null) {
            bln2.wVt = bln.wVt;
        }
        if (bln.wVs == null) {
            bln2.wVs = null;
        } else if (bln2.wVs == null) {
            bln2.wVs = bln.wVs;
        }
        return new bes().bl(bln2.toByteArray());
    }

    private static String bM(List<String> list) {
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = (String) it.next();
            if (str2.length() != 0) {
                str = str2 + "," + str;
            }
        }
    }

    public static void a(String str, int i, LinkedList<blf> linkedList, String str2) {
        if (linkedList != null && !linkedList.isEmpty()) {
            String str3;
            String str4;
            Cursor rawQuery;
            n bwf = ae.bwf();
            List arrayList = new ArrayList();
            List linkedList2 = new LinkedList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                }
                blf blf = (blf) linkedList.get(i3);
                m eS = bwf.eS(blf.vWS);
                if (eS == null) {
                    eS = new m();
                }
                if (a(eS, blf, str, i) != 0) {
                    if (linkedList2.size() < 3 && (eS.field_type == 1 || eS.field_type == 15)) {
                        linkedList2.add(i.er(eS.field_snsId));
                    }
                    arrayList.add(Long.valueOf(blf.vWS));
                }
                i2 = i3 + 1;
            }
            if ((i == 4 || i == 8) && str2.equals("")) {
                k LV = ae.bwj().LV(str);
                List F = bi.F(bi.aD(LV != null ? LV.field_newerIds : "", "").split(","));
                x.d("MicroMsg.SnsInfoStorageLogic", "newerIds " + bM(linkedList2));
                while (linkedList2.size() < 3 && F.size() > 0) {
                    str3 = (String) F.remove(0);
                    if (str3 != null) {
                        i2 = 0;
                        while (true) {
                            int i4 = i2;
                            if (i4 >= linkedList2.size()) {
                                break;
                            }
                            str4 = (String) linkedList2.get(i4);
                            if (str3.compareTo(str4) == 0) {
                                break;
                            } else if (str3.compareTo(str4) > 0) {
                                linkedList2.add(0, str3);
                                break;
                            } else {
                                i2 = i4 + 1;
                            }
                        }
                        if (!linkedList2.contains(str3)) {
                            linkedList2.add(str3);
                        }
                    }
                }
                x.i("MicroMsg.SnsInfoStorageLogic", "merge newerIds " + bM(linkedList2));
                ae.bwj().et(str, bM(linkedList2));
            }
            str3 = i.Ks(i.er(((blf) linkedList.getLast()).vWS));
            x.d("MicroMsg.SnsInfoStorageLogic", "FIlTER SEQ :: " + str2 + "  -  " + str3);
            n bwf2;
            if (i == 2) {
                bwf2 = ae.bwf();
                str4 = n.bzs();
                if (str2 == null || !str2.equals("")) {
                    str4 = str4 + " AND " + bwf2.Md(str2);
                }
                if (n.LZ(str3)) {
                    str4 = str4 + " AND " + bwf2.Ma(str3);
                }
                x.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = bwf2.gLA.rawQuery(str4, null);
            } else {
                bwf2 = ae.bwf();
                str4 = n.d(true, str, i == 4);
                if (n.LZ(str2)) {
                    str4 = str4 + " AND " + bwf2.Md(str2);
                }
                if (n.LZ(str3)) {
                    str4 = str4 + " AND " + bwf2.Ma(str3);
                }
                x.d("MicroMsg.SnsInfoStorage", "getCursorByUserSeq " + str4);
                rawQuery = bwf2.gLA.rawQuery(str4, null);
            }
            if (rawQuery == null) {
                return;
            }
            if (rawQuery.moveToFirst()) {
                do {
                    m mVar = new m();
                    mVar.b(rawQuery);
                    long j = mVar.field_snsId;
                    if (mVar.bzb()) {
                        x.d("MicroMsg.SnsInfoStorageLogic", "uploading one ");
                    } else if (mVar.bzc()) {
                        x.d("MicroMsg.SnsInfoStorageLogic", "die one ");
                    } else if (!arrayList.contains(Long.valueOf(j))) {
                        mVar.xE(i);
                        ae.bwf().b(j, mVar);
                        x.i("MicroMsg.SnsInfoStorageLogic", "removeSourceFlag sns Id " + j + " source " + i);
                    }
                } while (rawQuery.moveToNext());
                rawQuery.close();
                return;
            }
            rawQuery.close();
        }
    }

    public static boolean K(int i, boolean z) {
        if (!z || i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean wZ(int i) {
        arf arf;
        Throwable e;
        int i2;
        int i3;
        q eT;
        arh arh;
        x.d("MicroMsg.SnsInfoStorageLogic", "retryPostItem localId　" + i);
        m xG = ae.bwf().xG(i);
        if (xG == null) {
            return false;
        }
        xG.bzd();
        xG.hN((int) (System.currentTimeMillis() / 1000));
        arf arf2 = null;
        try {
            arf arf3 = (arf) new arf().aH(xG.field_postBuf);
            try {
                arf3.hmE = 0;
                arf3.wFq = System.currentTimeMillis();
                xG.field_postBuf = arf3.toByteArray();
                arf = arf3;
            } catch (Throwable e2) {
                Throwable th = e2;
                arf2 = arf3;
                e = th;
                x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
                arf = arf2;
                if (arf != null) {
                    return false;
                }
                ae.bwf().b(i, xG);
                for (i2 = 0; i2 < arf.wFn.size(); i2++) {
                    i3 = ((apk) arf.wFn.get(i2)).wCR;
                    eT = ae.bvU().eT((long) i3);
                    if (eT == null) {
                        eT.offset = 0;
                        try {
                            arh = (arh) new arh().aH(eT.rvw);
                            if (arh.wFL == 0) {
                                arh.wFL = 2;
                                arh.wFM = "";
                                eT.rvw = arh.toByteArray();
                                ae.bvU().a(i3, eT);
                            } else {
                                continue;
                            }
                        } catch (Exception e3) {
                            x.e("MicroMsg.SnsInfoStorageLogic", "MediaUploadInfo parseFrom MediaUploadInfo Exception");
                            return false;
                        }
                    }
                }
                return true;
            }
        } catch (Exception e4) {
            e = e4;
            x.printErrStackTrace("MicroMsg.SnsInfoStorageLogic", e, "", new Object[0]);
            arf = arf2;
            if (arf != null) {
                return false;
            }
            ae.bwf().b(i, xG);
            for (i2 = 0; i2 < arf.wFn.size(); i2++) {
                i3 = ((apk) arf.wFn.get(i2)).wCR;
                eT = ae.bvU().eT((long) i3);
                if (eT == null) {
                    eT.offset = 0;
                    arh = (arh) new arh().aH(eT.rvw);
                    if (arh.wFL == 0) {
                        continue;
                    } else {
                        arh.wFL = 2;
                        arh.wFM = "";
                        eT.rvw = arh.toByteArray();
                        ae.bvU().a(i3, eT);
                    }
                }
            }
            return true;
        }
        if (arf != null) {
            return false;
        }
        ae.bwf().b(i, xG);
        for (i2 = 0; i2 < arf.wFn.size(); i2++) {
            i3 = ((apk) arf.wFn.get(i2)).wCR;
            eT = ae.bvU().eT((long) i3);
            if (eT == null) {
                eT.offset = 0;
                arh = (arh) new arh().aH(eT.rvw);
                if (arh.wFL == 0) {
                    continue;
                } else {
                    arh.wFL = 2;
                    arh.wFM = "";
                    eT.rvw = arh.toByteArray();
                    ae.bvU().a(i3, eT);
                }
            }
        }
        return true;
    }

    public static boolean KR(String str) {
        return com.tencent.mm.y.q.FY().equals(str.trim());
    }

    public static List<m> bwz() {
        List arrayList = new ArrayList();
        n bwf = ae.bwf();
        Cursor rawQuery = bwf.gLA.rawQuery(n.bzt() + " AND " + n.rvi + " AND  (snsId = 0  ) ", null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
        } else {
            rawQuery.moveToFirst();
            do {
                m mVar = new m();
                mVar.b(rawQuery);
                arrayList.add(mVar);
            } while (rawQuery.moveToNext());
            rawQuery.close();
        }
        return arrayList;
    }

    public static String KS(String str) {
        int i = 1;
        List linkedList = new LinkedList();
        Cursor cursor = ae.bwl().getCursor();
        if (cursor.moveToFirst()) {
            do {
                s sVar = new s();
                sVar.b(cursor);
                linkedList.add(bi.aD(sVar.field_tagName, ""));
            } while (cursor.moveToNext());
        }
        cursor.close();
        String str2 = str;
        while (linkedList.contains(str2)) {
            StringBuilder append = new StringBuilder().append(str);
            int i2 = i + 1;
            str2 = append.append(i).toString();
            i = i2;
        }
        return str2;
    }

    public static m xa(int i) {
        m mVar = new m();
        n bwf = ae.bwf();
        x.i("MicroMsg.SnsInfoStorage", "getTimelineByCreateTime sql %s", ((n.bzu() + " and createTime < " + i) + n.rvc) + " LIMIT 1");
        Cursor rawQuery = bwf.gLA.rawQuery(r3, null);
        if (rawQuery == null) {
            rawQuery = null;
        }
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.moveToFirst()) {
            mVar.b(rawQuery);
            rawQuery.close();
            return mVar;
        }
        rawQuery.close();
        return null;
    }

    public static List<b> eh(String str, String str2) {
        int i = 0;
        List<b> arrayList = new ArrayList();
        ci ciVar = null;
        try {
            String str3 = str2 + str + "_ARTISTF.mm";
            String str4 = str2 + str + "_ARTIST.mm";
            if (FileOp.bO(str3)) {
                ciVar = (ci) new ci().aH(FileOp.d(str3, 0, (int) FileOp.mi(str3)));
            }
            if (ciVar == null) {
                FileOp.deleteFile(str3);
                ciVar = a.Lv(new String(FileOp.d(str4, 0, (int) FileOp.mi(str4))));
                FileOp.b(str3, ciVar.toByteArray(), -1);
            }
            Iterator it = ciVar.vOp.iterator();
            while (it.hasNext()) {
                ajv ajv = (ajv) it.next();
                str4 = ajv.nkW;
                Iterator it2 = ajv.wfh.iterator();
                while (it2.hasNext()) {
                    are are = (are) it2.next();
                    are.nkL = str4;
                    b bVar = new b();
                    bVar.fIx = are;
                    bVar.rgK = "";
                    int i2 = i + 1;
                    bVar.rgL = i;
                    arrayList.add(bVar);
                    i = i2;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SnsInfoStorageLogic", "error initDataArtist");
        }
        return arrayList;
    }

    public static are a(m mVar, int i) {
        if (ae.bvO() || mVar == null) {
            return null;
        }
        bpb byF = mVar.byF();
        if (byF.wYj == null || byF.wYj.wfh.size() == 0 || byF.wYj.wfh.size() <= i) {
            return null;
        }
        return (are) byF.wYj.wfh.get(i);
    }

    public static are a(m mVar, String str) {
        bpb byF = mVar.byF();
        if (byF.wYj == null || byF.wYj.wfh.size() == 0) {
            return null;
        }
        Iterator it = byF.wYj.wfh.iterator();
        while (it.hasNext()) {
            are are = (are) it.next();
            if (are.nMq.equals(str)) {
                return are;
            }
        }
        return null;
    }

    public static List<b> KT(String str) {
        List<b> arrayList = new ArrayList();
        if (ae.bvO()) {
            return arrayList;
        }
        m LR = h.LR(str);
        if (LR == null) {
            return arrayList;
        }
        bpb byF = LR.byF();
        if (byF.wYj == null || byF.wYj.wfh.size() == 0) {
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = byF.wYj.wfh.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return arrayList;
            }
            are are = (are) it.next();
            b bVar = new b();
            bVar.fIx = are;
            bVar.rgK = str;
            bVar.hBH = byF.pgR;
            i = i2 + 1;
            bVar.rgL = i2;
            arrayList.add(bVar);
        }
    }

    public static List<b> bN(List<String> list) {
        List<b> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        arrayList.clear();
        int i = 0;
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return arrayList;
            }
            String str = (String) it.next();
            b bVar = new b();
            are are = new are();
            are.nMq = "pre_temp_extend_pic" + str;
            bVar.fIx = are;
            bVar.rgK = "";
            i = i2 + 1;
            bVar.rgL = i2;
            arrayList.add(bVar);
        }
    }

    public static void xb(int i) {
        x.d("MicroMsg.SnsInfoStorageLogic", "unsetOmitResendFlag localId　" + i);
        m xG = ae.bwf().xG(i);
        if (xG != null) {
            if (((xG.field_localFlag & 64) > 0 ? 1 : null) != null) {
                xG.field_localFlag &= -65;
            }
            ae.bwf().b(i, xG);
        }
    }

    public static void bwA() {
        Cursor cj = ae.bwf().cj("", 0);
        if (cj != null) {
            x.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId begin");
            while (cj.moveToNext()) {
                m mVar = new m();
                mVar.b(cj);
                x.i("MicroMsg.SnsInfoStorageLogic", mVar.byG());
            }
            x.i("MicroMsg.SnsInfoStorageLogic", "all timeline snsId end");
            cj.close();
        }
    }
}
