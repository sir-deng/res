package com.tencent.mm.plugin.record.b;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class k implements com.tencent.mm.ad.e, com.tencent.mm.plugin.record.a.c {
    boolean pKJ = false;
    SparseArray<e> pKM = new SparseArray();
    LinkedList<g> pKN = new LinkedList();

    private class c implements Runnable {
        private g pKG;

        public c(g gVar) {
            this.pKG = gVar;
        }

        public final void run() {
            Iterator it = this.pKG.field_dataProto.wlY.iterator();
            while (it.hasNext()) {
                uz uzVar = (uz) it.next();
                com.tencent.mm.sdk.b.b fwVar = new fw();
                fwVar.fwl.type = 2;
                fwVar.fwl.fwn = uzVar;
                com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                x.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", uzVar.mBr, Integer.valueOf(uzVar.bjS));
                if (!bi.oN(fwVar.fwm.path)) {
                    String c = h.c(uzVar, this.pKG.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", fwVar.fwm.path, c);
                    if (!fwVar.fwm.path.equals(c)) {
                        com.tencent.mm.sdk.platformtools.k.r(fwVar.fwm.path, c, false);
                    }
                }
                if (!bi.oN(fwVar.fwm.fwx)) {
                    String f = h.f(uzVar, this.pKG.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", fwVar.fwm.fwx, f);
                    if (!fwVar.fwm.fwx.equals(f)) {
                        com.tencent.mm.sdk.platformtools.k.r(fwVar.fwm.fwx, f, false);
                    }
                }
            }
            as.CN().a(new a(this.pKG), 0);
        }
    }

    private class a implements Runnable {
        private g pKG;

        public a(g gVar) {
            this.pKG = gVar;
        }

        public final void run() {
            Iterator it = this.pKG.field_dataProto.wlY.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String str;
                String c;
                uz uzVar = (uz) it.next();
                if (!bi.oN(uzVar.wjN) || com.tencent.mm.a.e.bO(uzVar.wkl)) {
                    str = uzVar.wkl;
                    c = h.c(uzVar, this.pKG.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", uzVar.wjN, str, c, Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.r(str, c, false)));
                    if (com.tencent.mm.sdk.platformtools.k.r(str, c, false)) {
                        if (bi.oN(uzVar.wke)) {
                            x.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                            uzVar.Ug(com.tencent.mm.a.g.bV(c));
                            z = true;
                        }
                        if (bi.oN(uzVar.wkg)) {
                            x.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                            uzVar.Uh(com.tencent.mm.a.g.bW(c));
                            z = true;
                        }
                    }
                    if (com.tencent.mm.a.e.bN(c) != 0) {
                        uzVar.fx((long) com.tencent.mm.a.e.bN(c));
                    }
                    str = h.d(uzVar.mBr, this.pKG.field_msgId, false);
                    if (n.getRecordMsgCDNStorage().IO(str) == null) {
                        f fVar = new f();
                        fVar.field_cdnKey = uzVar.wjP;
                        fVar.field_cdnUrl = uzVar.wjN;
                        fVar.field_dataId = uzVar.mBr;
                        fVar.field_mediaId = str;
                        fVar.field_totalLen = (int) uzVar.wki;
                        fVar.field_localId = fVar.field_mediaId.hashCode();
                        fVar.field_path = h.c(uzVar, this.pKG.field_msgId);
                        fVar.field_type = 2;
                        fVar.field_fileType = h.vK(uzVar.bjS);
                        fVar.field_recordLocalId = this.pKG.field_localId;
                        fVar.field_toUser = this.pKG.field_toUser;
                        fVar.field_isThumb = false;
                        boolean a = n.getRecordMsgCDNStorage().a(fVar);
                        x.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", Integer.valueOf(fVar.field_localId), Boolean.valueOf(a), Integer.valueOf(fVar.field_fileType), str);
                    }
                }
                if (!bi.oN(uzVar.hcU) || com.tencent.mm.a.e.bO(uzVar.wkn)) {
                    str = uzVar.wkn;
                    c = h.f(uzVar, this.pKG.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", str, c, Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.r(str, c, false)));
                    uzVar.fy((long) com.tencent.mm.a.e.bN(c));
                    if (com.tencent.mm.sdk.platformtools.k.r(str, c, false)) {
                        if (bi.oN(uzVar.wkp)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                            uzVar.Ul(com.tencent.mm.a.g.bV(c));
                            z = true;
                        }
                        if (bi.oN(uzVar.wkr)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                            uzVar.Um(com.tencent.mm.a.g.bW(c));
                            z = true;
                        }
                    }
                    str = h.AH(uzVar.mBr);
                    c = h.d(str, this.pKG.field_msgId, false);
                    if (n.getRecordMsgCDNStorage().IO(c) == null) {
                        f fVar2 = new f();
                        fVar2.field_cdnKey = uzVar.wjJ;
                        fVar2.field_cdnUrl = uzVar.hcU;
                        fVar2.field_dataId = str;
                        fVar2.field_mediaId = c;
                        fVar2.field_totalLen = (int) uzVar.wkt;
                        fVar2.field_localId = fVar2.field_mediaId.hashCode();
                        fVar2.field_path = h.f(uzVar, this.pKG.field_msgId);
                        fVar2.field_type = 2;
                        fVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                        fVar2.field_recordLocalId = this.pKG.field_localId;
                        fVar2.field_toUser = this.pKG.field_toUser;
                        fVar2.field_isThumb = true;
                        boolean a2 = n.getRecordMsgCDNStorage().a(fVar2);
                        x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(fVar2.field_localId), Boolean.valueOf(a2));
                    }
                }
                z = z;
            }
            if (z) {
                x.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.pKG.field_localId), Long.valueOf(this.pKG.field_msgId), Integer.valueOf(this.pKG.field_type));
                n.bny().c(this.pKG, "localId");
            }
            n.bnA().run();
        }
    }

    private class b implements com.tencent.mm.ad.e, com.tencent.mm.modelvideo.s.a, Runnable {
        private boolean fdr = false;
        private int i = 0;
        private g pKG;
        HashMap<Long, Boolean> pLb = new HashMap();
        HashMap<Long, String> pLf = new HashMap();

        public b(g gVar) {
            this.pKG = gVar;
            o.Ub().a(this, Looper.getMainLooper());
            as.CN().a(221, (com.tencent.mm.ad.e) this);
        }

        public final void run() {
            this.i = 0;
            this.fdr = false;
            Iterator it = this.pKG.field_dataProto.wlY.iterator();
            while (it.hasNext()) {
                uz uzVar = (uz) it.next();
                final long j = uzVar.wkT;
                if (j > 0) {
                    as.Hm();
                    final au dI = com.tencent.mm.y.c.Fh().dI(j);
                    String str = uzVar.wkl;
                    Object obj = (System.currentTimeMillis() - dI.field_createTime <= 259200000 || (!bi.oN(str) && com.tencent.mm.a.e.bO(str))) ? null : 1;
                    if (obj != null) {
                        x.i("MicroMsg.RecordMsgSendService", "dataItem is expired!! msgType:%s", Integer.valueOf(dI.getType()));
                    } else if (uzVar.bjS == 2) {
                        if (dI.cjT()) {
                            int i;
                            final com.tencent.mm.ap.e bi = com.tencent.mm.ap.o.PC().bi(dI.field_msgSvrId);
                            if (dI.field_isSend == 1) {
                                int i2;
                                if (bi.Pk()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                i = i2;
                            } else if (bi.Pk()) {
                                if (com.tencent.mm.a.e.bO(com.tencent.mm.ap.o.PC().m(com.tencent.mm.ap.f.a(bi).hBB, "", ""))) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            } else {
                                i = 0;
                            }
                            if (bi.offset < bi.hmZ || bi.hmZ == 0) {
                                this.pLb.put(Long.valueOf(j), Boolean.valueOf(false));
                                this.i = this.pKG.field_dataProto.wlY.indexOf(uzVar);
                                com.tencent.mm.ap.o.PD().a(bi.hBA, dI.field_msgId, i, uzVar, R.g.bAI, new com.tencent.mm.ap.d.a() {
                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.ad.k kVar) {
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj, int i3, int i4, String str, com.tencent.mm.ad.k kVar) {
                                        boolean z = i3 == 0 && i4 == 0;
                                        x.i("MicroMsg.RecordMsgSendService", "download image succed: %s, errType: %s, errCode:%s", Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4));
                                        if (obj instanceof uz) {
                                            uz uzVar = (uz) obj;
                                            uzVar.Uj(com.tencent.mm.ap.o.PC().m(com.tencent.mm.ap.f.c(bi), "", ""));
                                            uzVar.Uk(com.tencent.mm.ap.o.PC().B(dI.field_imgPath, true));
                                            Map y = bj.y(bi.hBL, "msg");
                                            if (y != null) {
                                                uzVar.TZ((String) y.get(".msg.img.$cdnbigimgurl"));
                                                uzVar.fx((long) bi.getInt((String) y.get(".msg.img.$length"), 0));
                                                uzVar.Ua((String) y.get(".msg.img.$aeskey"));
                                                b.this.pKG.field_dataProto.wlY.set(b.this.i, uzVar);
                                            } else {
                                                x.i("MicroMsg.RecordMsgSendService", "parse cdnInfo failed. [%s]", bi.hBL);
                                            }
                                            b.this.pLb.put(Long.valueOf(uzVar.wkT), Boolean.valueOf(true));
                                        } else {
                                            b.this.pLb.put(Long.valueOf(j), Boolean.valueOf(true));
                                        }
                                        b.this.a(b.this.pLb, b.this.fdr, b.this.pKG);
                                    }

                                    public final void a(long j, long j2, int i, int i2, Object obj) {
                                        b.this.pLb.put(Long.valueOf(j), Boolean.valueOf(true));
                                        b.this.a(b.this.pLb, b.this.fdr, b.this.pKG);
                                    }
                                });
                            }
                        } else if (dI.ckb()) {
                            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dI.field_content);
                            if (fV == null) {
                                x.e("MicroMsg.RecordMsgSendService", "parse msgContent error, %s", dI.field_content);
                            } else {
                                if (bi.oN(fV.for) && !bi.oN(fV.hcT)) {
                                    x.e("MicroMsg.RecordMsgSendService", "msgContent format error, %s", dI.field_content);
                                    fV.for = fV.hcT.hashCode();
                                }
                                str = fV.for;
                                if (!l.a(dI, l.aj(str, dI.field_msgId))) {
                                    this.pLb.put(Long.valueOf(dI.field_msgId), Boolean.valueOf(false));
                                    this.pLf.put(Long.valueOf(dI.field_msgId), str);
                                    l.a(dI, null);
                                }
                            }
                        }
                    } else if (uzVar.bjS == 4 || uzVar.bjS == 15) {
                        r nJ = t.nJ(dI.field_imgPath);
                        if (!(nJ == null || nJ.status == 199)) {
                            this.pLb.put(Long.valueOf(j), Boolean.valueOf(false));
                            if (nJ.Up()) {
                                x.i("MicroMsg.RecordMsgSendService", "start complete online video");
                                t.nN(dI.field_imgPath);
                            } else {
                                x.i("MicroMsg.RecordMsgSendService", "start complete offline video");
                                t.nF(dI.field_imgPath);
                            }
                        }
                    }
                }
            }
            this.fdr = true;
            k.this.pKJ = false;
            a(this.pLb, this.fdr, this.pKG);
        }

        public final void a(com.tencent.mm.modelvideo.s.a.a aVar) {
            r nJ = t.nJ(aVar.fileName);
            if (nJ != null) {
                as.Hm();
                cg dI = com.tencent.mm.y.c.Fh().dI((long) nJ.hXw);
                if (nJ.Uq()) {
                    this.pLb.put(Long.valueOf(dI.field_msgId), Boolean.valueOf(true));
                    a(this.pLb, this.fdr, this.pKG);
                    return;
                }
                return;
            }
            a(null, this.fdr, this.pKG);
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
            if (kVar instanceof ab) {
                as.CN().b(221, (com.tencent.mm.ad.e) this);
                if (this.pLf != null) {
                    for (Entry entry : this.pLf.entrySet()) {
                        long longValue = ((Long) entry.getKey()).longValue();
                        String str2 = (String) entry.getValue();
                        if (longValue > 0 && !((Boolean) this.pLb.get(Long.valueOf(longValue))).booleanValue()) {
                            as.Hm();
                            com.tencent.mm.y.c.Fh().dI(longValue);
                            com.tencent.mm.pluginsdk.model.app.b aj = l.aj(str2, longValue);
                            if (aj != null) {
                                str2 = aj.field_fileFullPath;
                            } else {
                                str2 = null;
                            }
                            if (str2 != null && str2.length() > 0) {
                                this.pLb.put(Long.valueOf(longValue), Boolean.valueOf(true));
                                Iterator it = this.pKG.field_dataProto.wlY.iterator();
                                while (it.hasNext()) {
                                    uz uzVar = (uz) it.next();
                                    if (uzVar.wkT == longValue) {
                                        uzVar.Uj(aj.field_fileFullPath);
                                    }
                                }
                            }
                        }
                    }
                }
                a(this.pLb, this.fdr, this.pKG);
                return;
            }
            a(null, this.fdr, this.pKG);
        }

        private void a(HashMap<Long, Boolean> hashMap, boolean z, g gVar) {
            int i;
            if (hashMap != null) {
                for (Entry value : hashMap.entrySet()) {
                    if (!Boolean.valueOf(((Boolean) value.getValue()).booleanValue()).booleanValue()) {
                        i = 0;
                        break;
                    }
                }
            }
            i = 1;
            if (i != 0 && z) {
                o.Ub().a((com.tencent.mm.modelvideo.s.a) this);
                gVar.field_type = 2;
                n.bny().c(gVar, "localId");
                n.bnz().a(gVar);
            }
        }
    }

    private class d implements Runnable {
        private g pKG;

        public d(g gVar) {
            this.pKG = gVar;
        }

        public final void run() {
            Iterator it = this.pKG.field_dataProto.wlY.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String c;
                String c2;
                uz uzVar = (uz) it.next();
                if (!bi.oN(uzVar.wjN)) {
                    c = h.c(uzVar, this.pKG.field_oriMsgId);
                    c2 = h.c(uzVar, this.pKG.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", c, c2, Boolean.valueOf(com.tencent.mm.sdk.platformtools.k.r(c, c2, false)));
                    if (com.tencent.mm.sdk.platformtools.k.r(c, c2, false)) {
                        if (bi.oN(uzVar.wke)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            uzVar.Ug(com.tencent.mm.a.g.bV(c2));
                            z = true;
                        }
                        if (bi.oN(uzVar.wkg)) {
                            x.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            uzVar.Uh(com.tencent.mm.a.g.bW(c2));
                            z = true;
                        }
                    }
                    c = h.d(uzVar.mBr, this.pKG.field_msgId, false);
                    if (n.getRecordMsgCDNStorage().IO(c) == null) {
                        f fVar = new f();
                        fVar.field_cdnKey = uzVar.wjP;
                        fVar.field_cdnUrl = uzVar.wjN;
                        fVar.field_dataId = uzVar.mBr;
                        fVar.field_mediaId = c;
                        fVar.field_totalLen = (int) uzVar.wki;
                        fVar.field_localId = fVar.field_mediaId.hashCode();
                        fVar.field_path = h.c(uzVar, this.pKG.field_msgId);
                        fVar.field_type = 2;
                        fVar.field_fileType = h.vK(uzVar.bjS);
                        fVar.field_recordLocalId = this.pKG.field_localId;
                        fVar.field_toUser = this.pKG.field_toUser;
                        fVar.field_isThumb = false;
                        boolean a = n.getRecordMsgCDNStorage().a(fVar);
                        x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(fVar.field_localId), Boolean.valueOf(a));
                    }
                }
                if (!bi.oN(uzVar.hcU)) {
                    boolean r = com.tencent.mm.sdk.platformtools.k.r(h.f(uzVar, this.pKG.field_oriMsgId), h.f(uzVar, this.pKG.field_msgId), false);
                    x.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", c, c2, Boolean.valueOf(r));
                    c = h.AH(uzVar.mBr);
                    c2 = h.d(c, this.pKG.field_msgId, false);
                    if (n.getRecordMsgCDNStorage().IO(c2) == null) {
                        f fVar2 = new f();
                        fVar2.field_cdnKey = uzVar.wjJ;
                        fVar2.field_cdnUrl = uzVar.hcU;
                        fVar2.field_dataId = c;
                        fVar2.field_mediaId = c2;
                        fVar2.field_totalLen = (int) uzVar.wkt;
                        fVar2.field_localId = fVar2.field_mediaId.hashCode();
                        fVar2.field_path = h.f(uzVar, this.pKG.field_msgId);
                        fVar2.field_type = 2;
                        fVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                        fVar2.field_recordLocalId = this.pKG.field_localId;
                        fVar2.field_toUser = this.pKG.field_toUser;
                        fVar2.field_isThumb = true;
                        boolean a2 = n.getRecordMsgCDNStorage().a(fVar2);
                        x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(fVar2.field_localId), Boolean.valueOf(a2));
                    }
                }
            }
            if (z) {
                x.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", Integer.valueOf(this.pKG.field_localId), Long.valueOf(this.pKG.field_msgId), Integer.valueOf(this.pKG.field_type));
                n.bny().c(this.pKG, "localId");
            }
            n.bnA().run();
        }
    }

    private static final class e {
        int ieM;
        long pKQ;

        private e() {
            this.pKQ = SystemClock.elapsedRealtime();
            this.ieM = 3;
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    public k() {
        as.CN().a(632, (com.tencent.mm.ad.e) this);
        n.getRecordMsgCDNStorage().a((com.tencent.mm.plugin.record.a.c) this);
    }

    public final void a(final g gVar) {
        as.Dt().F(new Runnable() {
            public final void run() {
                if (gVar != null) {
                    if (((e) k.this.pKM.get(gVar.field_localId)) == null) {
                        x.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", Integer.valueOf(gVar.field_localId), Long.valueOf(gVar.field_msgId));
                        k.this.pKM.put(gVar.field_localId, new e());
                    }
                    k.this.b(gVar);
                }
                k kVar = k.this;
                if (kVar.pKJ) {
                    x.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
                    return;
                }
                g gVar;
                e eVar;
                if (kVar.pKN.isEmpty()) {
                    x.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
                    for (g gVar2 : n.bny().bnt()) {
                        as.Hm();
                        if (com.tencent.mm.y.c.Fh().dI(gVar2.field_msgId).getType() != 49) {
                            x.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", Integer.valueOf(gVar2.field_localId), Long.valueOf(gVar2.field_msgId));
                            n.bny().vI(gVar2.field_localId);
                        } else {
                            eVar = (e) kVar.pKM.get(gVar2.field_localId);
                            if (eVar == null) {
                                kVar.pKM.put(gVar2.field_localId, new e());
                            } else if (eVar.ieM >= 0 || SystemClock.elapsedRealtime() - eVar.pKQ >= 300000) {
                                if (eVar.ieM < 0) {
                                    eVar.ieM = 3;
                                }
                            }
                            x.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", Integer.valueOf(gVar2.field_localId), Long.valueOf(gVar2.field_msgId));
                            kVar.b(gVar2);
                        }
                    }
                }
                if (kVar.pKN.isEmpty()) {
                    x.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
                    kVar.finish();
                    return;
                }
                boolean z;
                gVar2 = (g) kVar.pKN.removeFirst();
                eVar = (e) kVar.pKM.get(gVar2.field_localId);
                if (eVar == null) {
                    eVar = new e();
                    kVar.pKM.put(gVar2.field_localId, eVar);
                }
                eVar.ieM--;
                if (eVar.ieM < 0) {
                    if (300000 > SystemClock.elapsedRealtime() - eVar.pKQ) {
                        z = false;
                        if (z) {
                            kVar.a(null);
                            return;
                        }
                        kVar.pKJ = true;
                        switch (gVar2.field_type) {
                            case 0:
                                com.tencent.mm.sdk.f.e.post(new d(gVar2), "RecordMsgSendService_normalDataCopy");
                                return;
                            case 1:
                                com.tencent.mm.sdk.f.e.post(new c(gVar2), "RecordMsgSendService_favDataCopy");
                                return;
                            case 2:
                                com.tencent.mm.sdk.f.e.post(new a(gVar2), "RecordMsgSendService_chatDataCopy");
                                return;
                            case 3:
                                com.tencent.mm.sdk.f.e.post(new b(gVar2), "RecordMsgSendService_chatDataDownLoad");
                                return;
                            default:
                                kVar.pKJ = false;
                                return;
                        }
                    }
                    eVar.ieM = 2;
                }
                eVar.pKQ = SystemClock.elapsedRealtime();
                z = true;
                if (z) {
                    kVar.a(null);
                    return;
                }
                kVar.pKJ = true;
                switch (gVar2.field_type) {
                    case 0:
                        com.tencent.mm.sdk.f.e.post(new d(gVar2), "RecordMsgSendService_normalDataCopy");
                        return;
                    case 1:
                        com.tencent.mm.sdk.f.e.post(new c(gVar2), "RecordMsgSendService_favDataCopy");
                        return;
                    case 2:
                        com.tencent.mm.sdk.f.e.post(new a(gVar2), "RecordMsgSendService_chatDataCopy");
                        return;
                    case 3:
                        com.tencent.mm.sdk.f.e.post(new b(gVar2), "RecordMsgSendService_chatDataDownLoad");
                        return;
                    default:
                        kVar.pKJ = false;
                        return;
                }
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    final void b(g gVar) {
        if (!this.pKN.contains(gVar)) {
            this.pKN.add(gVar);
        }
    }

    final void finish() {
        this.pKN.clear();
        this.pKM.clear();
        this.pKJ = false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            x.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            return;
        }
        switch (kVar.getType()) {
            case 632:
                x.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
                a aVar = (a) kVar;
                if (i == 3) {
                    Object obj;
                    Iterator it = aVar.pKG.field_dataProto.wlY.iterator();
                    while (it.hasNext()) {
                        if (((uz) it.next()).bjS != 1) {
                            obj = null;
                            if (obj != null) {
                                i = 0;
                                i2 = 0;
                            }
                        }
                    }
                    int obj2 = 1;
                    if (obj2 != null) {
                        i = 0;
                        i2 = 0;
                    }
                }
                if (i == 0 && i2 == 0) {
                    as.Hm();
                    au dI = com.tencent.mm.y.c.Fh().dI(aVar.pKG.field_msgId);
                    if (dI.field_msgId == aVar.pKG.field_msgId) {
                        dI.setContent(aVar.pKF);
                        dI.eR(1);
                        as.Hm();
                        com.tencent.mm.y.c.Fh().a(aVar.pKG.field_msgId, dI);
                    }
                    com.tencent.mm.sdk.e.c fq = an.bZF().fq(aVar.pKG.field_msgId);
                    if (fq != null) {
                        fq.field_xml = dI.field_content;
                        an.bZF().c(fq, "msgId");
                    }
                    n.bny().vI(aVar.pKG.field_localId);
                    this.pKM.remove(aVar.pKG.field_localId);
                    an.bZH();
                    com.tencent.mm.pluginsdk.model.app.am.a.fu(aVar.pKG.field_msgId);
                    x.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", Long.valueOf(aVar.pKG.field_msgId), Integer.valueOf(aVar.pKG.field_localId));
                    break;
                }
                x.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", Long.valueOf(aVar.pKG.field_msgId), Integer.valueOf(aVar.pKG.field_localId));
                x.w("MicroMsg.RecordMsgSendService", "try upload from local");
                Iterator it2 = aVar.pKG.field_dataProto.wlY.iterator();
                while (it2.hasNext()) {
                    String d;
                    uz uzVar = (uz) it2.next();
                    if (uzVar.wki > 0) {
                        d = h.d(uzVar.mBr, aVar.pKG.field_msgId, false);
                        if (n.getRecordMsgCDNStorage().IO(d) == null) {
                            f fVar = new f();
                            fVar.field_cdnKey = uzVar.wjP;
                            fVar.field_cdnUrl = uzVar.wjN;
                            fVar.field_dataId = uzVar.mBr;
                            fVar.field_mediaId = d;
                            fVar.field_totalLen = (int) uzVar.wki;
                            fVar.field_localId = fVar.field_mediaId.hashCode();
                            fVar.field_path = h.c(uzVar, aVar.pKG.field_msgId);
                            fVar.field_type = 2;
                            fVar.field_fileType = h.vK(uzVar.bjS);
                            fVar.field_recordLocalId = aVar.pKG.field_localId;
                            fVar.field_toUser = aVar.pKG.field_toUser;
                            fVar.field_isThumb = false;
                            boolean a = n.getRecordMsgCDNStorage().a(fVar);
                            x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(fVar.field_localId), Boolean.valueOf(a));
                        }
                    }
                    if (uzVar.wkt > 0) {
                        d = h.AH(uzVar.mBr);
                        String d2 = h.d(d, aVar.pKG.field_msgId, false);
                        if (n.getRecordMsgCDNStorage().IO(d2) == null) {
                            f fVar2 = new f();
                            fVar2.field_cdnKey = uzVar.wjJ;
                            fVar2.field_cdnUrl = uzVar.hcU;
                            fVar2.field_dataId = d;
                            fVar2.field_mediaId = d2;
                            fVar2.field_totalLen = (int) uzVar.wkt;
                            fVar2.field_localId = fVar2.field_mediaId.hashCode();
                            fVar2.field_path = h.f(uzVar, aVar.pKG.field_msgId);
                            fVar2.field_type = 2;
                            fVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                            fVar2.field_recordLocalId = aVar.pKG.field_localId;
                            fVar2.field_toUser = aVar.pKG.field_toUser;
                            fVar2.field_isThumb = true;
                            boolean a2 = n.getRecordMsgCDNStorage().a(fVar2);
                            x.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", Integer.valueOf(fVar2.field_localId), Boolean.valueOf(a2));
                        }
                    }
                }
                n.bnA().run();
                return;
        }
        this.pKJ = false;
        a(null);
    }

    public final void a(int i, f fVar) {
        if (1 != i) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", Integer.valueOf(i));
        } else if (fVar == null) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
        } else if (2 != fVar.field_type) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload");
        } else if (fVar.field_status == 0 || 1 == fVar.field_status) {
            x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
        } else {
            Object obj;
            List<f> vH = n.getRecordMsgCDNStorage().vH(fVar.field_recordLocalId);
            for (f fVar2 : vH) {
                if (fVar2.field_status != 0) {
                    if (1 == fVar2.field_status) {
                    }
                }
                x.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", fVar2.field_mediaId);
                obj = null;
            }
            int obj2 = 1;
            if (obj2 != null) {
                g vJ = n.bny().vJ(fVar.field_recordLocalId);
                String str = "MicroMsg.RecordMsgSendService";
                String str2 = "finish get record info, id %d result %B";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(fVar.field_recordLocalId);
                objArr[1] = Boolean.valueOf(vJ != null);
                x.d(str, str2, objArr);
                if (vJ != null) {
                    List<uz> list = vJ.field_dataProto.wlY;
                    for (f fVar22 : vH) {
                        x.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", fVar22.field_dataId, Boolean.valueOf(fVar22.field_isThumb));
                        if (!fVar22.field_isThumb) {
                            for (uz uzVar : list) {
                                if (fVar22.field_dataId.equals(uzVar.mBr)) {
                                    x.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", uzVar.wjP, fVar22.field_cdnKey, uzVar.wjN, fVar22.field_cdnUrl, Long.valueOf(uzVar.wki), Integer.valueOf(fVar22.field_totalLen));
                                    uzVar.Ua(fVar22.field_cdnKey);
                                    uzVar.TZ(fVar22.field_cdnUrl);
                                    break;
                                }
                            }
                        }
                        for (uz uzVar2 : list) {
                            if (fVar22.field_dataId.equals(h.AH(uzVar2.mBr))) {
                                x.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", uzVar2.wjJ, fVar22.field_cdnKey, uzVar2.hcU, fVar22.field_cdnUrl, Long.valueOf(uzVar2.wkt), Integer.valueOf(fVar22.field_totalLen));
                                uzVar2.TY(fVar22.field_cdnKey);
                                uzVar2.TX(fVar22.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    as.Hm();
                    au dI = com.tencent.mm.y.c.Fh().dI(vJ.field_msgId);
                    x.i("MicroMsg.RecordMsgSendService", "update msg content, msg null ? %B, msgId %d recordInfoId %d", Boolean.valueOf(false), Long.valueOf(dI.field_msgId), Long.valueOf(vJ.field_msgId));
                    if (dI.field_msgId == vJ.field_msgId) {
                        dI.setContent(h.a(vJ.field_title, vJ.field_desc, vJ.field_dataProto, vJ.field_favFrom));
                        dI.eR(1);
                        as.Hm();
                        com.tencent.mm.y.c.Fh().a(vJ.field_msgId, dI);
                    }
                    com.tencent.mm.sdk.e.c fq = an.bZF().fq(vJ.field_msgId);
                    if (fq != null) {
                        fq.field_xml = dI.field_content;
                        an.bZF().c(fq, "msgId");
                    }
                    n.bny().vI(vJ.field_localId);
                    this.pKM.remove(vJ.field_localId);
                    an.bZH();
                    com.tencent.mm.pluginsdk.model.app.am.a.fu(vJ.field_msgId);
                }
                for (f fVar222 : vH) {
                    n.getRecordMsgCDNStorage().a(fVar222, "localId");
                }
                this.pKJ = false;
                a(null);
            }
        }
    }
}
