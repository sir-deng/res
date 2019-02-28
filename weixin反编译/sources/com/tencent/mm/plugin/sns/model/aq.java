package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.a.e;
import com.tencent.mm.f.a.ar;
import com.tencent.mm.f.a.la;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.i;
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aq implements a {
    boolean hWt;
    boolean hWu;
    f hWx;
    ax rdF;
    LinkedList<ax> rdG;
    Map<String, ax> rdH;
    LinkedList<m> rdI;
    c rdJ;
    c rdv;
    c rdw;

    /* renamed from: com.tencent.mm.plugin.sns.model.aq$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Object[] huN;
        final /* synthetic */ String rdL;

        public AnonymousClass5(String str, Object[] objArr) {
            this.rdL = str;
            this.huN = objArr;
        }

        public final void run() {
            o.Uc().b(this.rdL, this.huN);
            if (aq.this.rdF != null && bi.fA(aq.this.rdF.hVi, this.rdL)) {
                aq.a(aq.this);
            }
            aq.this.rdG.remove((ax) aq.this.rdH.get(this.rdL));
        }
    }

    static /* synthetic */ void a(aq aqVar) {
        g.Dr();
        g.Dt().F(new Runnable() {
            public final void run() {
                if (aq.this.rdF != null) {
                    x.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", aq.this.rdF.hVi);
                    aq.this.rdH.remove(aq.this.rdF.hVi);
                }
                aq.this.rdF = null;
                aq.this.bwL();
            }
        });
    }

    static /* synthetic */ j b(m mVar, int i, String str) {
        if (mVar == null) {
            return null;
        }
        are are = (are) mVar.byF().wYj.wfh.get(0);
        String bza = mVar.bza();
        String a = ap.a(bza, are);
        if (bi.oN(a)) {
            boolean bS = e.bS(ap.KY(are.nMq));
            a = ap.D(are);
            r KZ = ap.KZ(bza);
            if (KZ == null) {
                ap.ch(bza, 30);
            } else {
                ap.c(KZ, 30);
            }
            x.i("MicroMsg.SnsVideoService", "preload stream download sns video %s mkDir %b", a, Boolean.valueOf(bS));
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(are.nMq);
            aVar.qZY = are;
            an cjI = an.cjI();
            cjI.time = mVar.field_createTime;
            aVar.reG = cjI;
            aVar.reE = true;
            aVar.url = are.nlE;
            int i2 = are.kzz;
            aVar.reD = false;
            n.TZ();
            o.Uc();
            j a2 = com.tencent.mm.modelcdntran.f.a(aVar.reG, aVar.url, a, ap.nw(bza), 2);
            if (a2 == null) {
                return null;
            }
            a2.feA = are.wFk;
            a2.field_preloadRatio = i;
            a2.fAR = str;
            String str2 = mVar.field_userName;
            a2.hvv = str2;
            a2.fAJ = str2;
            return a2;
        }
        x.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing.", a);
        o.Ud().a(are.wFk, 3, (long) e.bN(a), mVar.field_userName, "", 0, "", are.nlE, str);
        com.tencent.mm.plugin.report.service.g.pWK.a(354, 147, 1, false);
        return null;
    }

    public aq() {
        this.rdG = null;
        this.rdH = null;
        this.hWx = null;
        this.rdI = null;
        this.hWt = false;
        this.hWu = false;
        this.rdJ = new c<la>() {
            {
                this.xmG = la.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                la laVar = (la) bVar;
                if (aq.this.rdF != null && bi.fA(aq.this.rdF.hVi, laVar.fDe.mediaId)) {
                    if (laVar.fDe.retCode != 0) {
                        aq.this.bwL();
                    } else if (laVar.fDe.fvG == 4 || laVar.fDe.fvG == 6) {
                        aq.a(aq.this);
                    }
                }
                return false;
            }
        };
        this.rdv = new c<com.tencent.mm.f.a.f>() {
            {
                this.xmG = com.tencent.mm.f.a.f.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                com.tencent.mm.f.a.f fVar = (com.tencent.mm.f.a.f) bVar;
                if (fVar.fnL.className.equals("SnsTimeLineUI")) {
                    aq.this.hWu = fVar.fnL.ahf;
                    x.d("MicroMsg.SnsVideoService", "set isInSnsTimeline:%b", Boolean.valueOf(aq.this.hWu));
                    if (aq.this.hWu || aq.this.hWt) {
                        aq.this.bwK();
                    }
                    i Ud = o.Ud();
                    Ud.hWu = aq.this.hWu;
                    if (Ud.hWu) {
                        Ud.stopDownload();
                    }
                }
                return false;
            }
        };
        this.rdw = new c<ar>() {
            {
                this.xmG = ar.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ar arVar = (ar) bVar;
                aq.this.hWt = arVar.fpJ.fpK;
                x.d("MicroMsg.SnsVideoService", "set isInChatting:%b", Boolean.valueOf(aq.this.hWt));
                if (aq.this.hWu || aq.this.hWt) {
                    aq.this.bwK();
                }
                if (!(aq.this.hWt || aq.this.hWu)) {
                    aq.this.bwJ();
                }
                i Ud = o.Ud();
                Ud.hWt = aq.this.hWt;
                if (Ud.hWt) {
                    Ud.stopDownload();
                } else {
                    Ud.TU();
                }
                return false;
            }
        };
        this.rdF = null;
        this.rdG = new LinkedList();
        this.rdH = new HashMap();
        this.rdI = new LinkedList();
        com.tencent.mm.sdk.b.a.xmy.b(this.rdJ);
        com.tencent.mm.sdk.b.a.xmy.b(this.rdv);
        com.tencent.mm.sdk.b.a.xmy.b(this.rdw);
    }

    public final void bwJ() {
        g.Dt().F(new Runnable() {
            public final void run() {
                if (aq.this.rdF == null && aq.this.rdG.isEmpty() && aq.this.hWx == null && !aq.this.hWt && !aq.this.hWu) {
                    m mVar;
                    m mVar2 = null;
                    j jVar = null;
                    PBool pBool = new PBool();
                    PInt pInt = new PInt();
                    PString pString = new PString();
                    synchronized (aq.this.rdI) {
                        Iterator it = aq.this.rdI.iterator();
                        while (it.hasNext()) {
                            Object obj;
                            mVar2 = (m) it.next();
                            aq aqVar = aq.this;
                            if (mVar2 == null) {
                                pBool.value = true;
                                obj = null;
                            } else if (bi.bz((long) mVar2.field_createTime) >= 86400) {
                                pBool.value = true;
                                obj = null;
                            } else if (o.Ud().cb(false)) {
                                pBool.value = true;
                                obj = null;
                            } else {
                                blf m = ai.m(mVar2);
                                if (m == null || m.wVg == null) {
                                    x.i("MicroMsg.SnsVideoService", "sns obj is null or sns obj PreDownloadInfo is null");
                                    pBool.value = true;
                                    obj = null;
                                } else {
                                    x.i("MicroMsg.SnsVideoService", "%d check sns video[%s] preload [%d %d %s]", Integer.valueOf(aqVar.hashCode()), mVar2.bza(), Integer.valueOf(m.wVg.wMm), Integer.valueOf(m.wVg.wMn), m.wVg.wMo);
                                    if (m.wVg.wMm <= 0) {
                                        x.i("MicroMsg.SnsVideoService", "%d can not preload because percent <= 0", Integer.valueOf(aqVar.hashCode()));
                                        pBool.value = true;
                                        obj = null;
                                    } else {
                                        pString.value = m.vWS;
                                        pInt.value = m.wVg.wMm;
                                        if (!com.tencent.mm.modelcontrol.b.kN(m.wVg.wMo)) {
                                            int i;
                                            if (ao.isWifi(ad.getContext())) {
                                                i = m.wVg.wMn & 1;
                                            } else if (ao.is4G(ad.getContext())) {
                                                i = m.wVg.wMn & 2;
                                            } else if (ao.is3G(ad.getContext())) {
                                                i = m.wVg.wMn & 4;
                                            } else {
                                                pBool.value = false;
                                                obj = null;
                                            }
                                            if (i > 0) {
                                                pBool.value = false;
                                                obj = 1;
                                            }
                                        }
                                        pBool.value = false;
                                        obj = null;
                                    }
                                }
                            }
                            if (pBool.value) {
                                it.remove();
                            }
                            if (obj != null) {
                                jVar = aq.b(mVar2, pInt.value, pString.value);
                                if (jVar != null) {
                                    break;
                                }
                                it.remove();
                            } else {
                                mVar2 = null;
                            }
                        }
                        mVar = mVar2;
                    }
                    if (mVar != null && jVar != null) {
                        Object obj2 = null;
                        if (jVar != null) {
                            try {
                                aq.this.hWx = new f(jVar, mVar.bza());
                                if (aq.this.hWx.a(aq.this) < 0) {
                                    x.w("MicroMsg.SnsVideoService", "%s curr preload task do scene error.", Integer.valueOf(aq.this.hashCode()));
                                    obj2 = 1;
                                    aq.this.hWx = null;
                                }
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.SnsVideoService", e, "", new Object[0]);
                                return;
                            }
                        }
                        obj2 = 1;
                        if (obj2 != null) {
                            synchronized (aq.this.rdI) {
                                Iterator it2 = aq.this.rdI.iterator();
                                while (it2.hasNext()) {
                                    mVar2 = (m) it2.next();
                                    if (mVar2 != null && bi.fA(mVar2.bza(), mVar.bza())) {
                                        x.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", Integer.valueOf(aq.this.hashCode()), mVar.bza());
                                        it2.remove();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public final void bwK() {
        x.d("MicroMsg.SnsVideoService", "%d stop preload %s", Integer.valueOf(hashCode()), bi.chl());
        g.Dt().F(new Runnable() {
            public final void run() {
                if (aq.this.hWx != null) {
                    aq.this.hWx.stop();
                }
                aq.this.hWx = null;
            }
        });
    }

    public final void a(final f fVar, boolean z, int i, int i2) {
        if (fVar == null) {
            x.e("MicroMsg.SnsVideoService", "%d on preload finish but scene is null?", Integer.valueOf(hashCode()));
            return;
        }
        if (this.hWx != fVar) {
            x.w("MicroMsg.SnsVideoService", "%d on preload finish, but scene callback not same object.", Integer.valueOf(hashCode()));
        }
        x.i("MicroMsg.SnsVideoService", "%d preload video[%s] finish success[%b] range[%d, %d]", Integer.valueOf(hashCode()), fVar.TT(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2));
        g.Dt().F(new Runnable() {
            public final void run() {
                String str = fVar.fsC;
                synchronized (aq.this.rdI) {
                    Iterator it = aq.this.rdI.iterator();
                    while (it.hasNext()) {
                        m mVar = (m) it.next();
                        if (mVar != null && bi.fA(str, mVar.bza())) {
                            x.i("MicroMsg.SnsVideoService", "%d find sns info[%s], remove now", Integer.valueOf(aq.this.hashCode()), str);
                            it.remove();
                        }
                    }
                }
                o.Ud().ca(false);
                if (aq.this.hWx != null) {
                    aq.this.hWx.hVY = null;
                }
                aq.this.hWx = null;
                aq.this.dz(130, 1);
                aq.this.bwJ();
            }
        });
    }

    final boolean dz(int i, int i2) {
        int i3;
        long Wz = bi.Wz();
        x.i("MicroMsg.SnsVideoService", "%d start to delete expired file limit[%d] status[%d] expiredTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(1), Integer.valueOf(130), Long.valueOf(bi.Wx() - (((long) ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("SnSPreLoadVideoExpiredTime", 1)) * 86400)));
        List<r> a = o.Ub().a(130, 1, r0);
        if (a == null || a.isEmpty()) {
            return false;
        }
        int i4 = 0;
        for (r rVar : a) {
            if (rVar != null) {
                try {
                    int i5;
                    String D = ap.D((are) ae.bwf().LR(ap.KX(rVar.getFileName())).byF().wYj.wfh.get(0));
                    if (!bi.oN(D)) {
                        File file = new File(D);
                        if (file.exists()) {
                            long length = file.length();
                            x.i("MicroMsg.SnsVideoService", "%s file[%d %d] lastmodifytime[%d] path[%s]", rVar.getFileName(), Long.valueOf(length), Integer.valueOf(rVar.fAP), Long.valueOf(rVar.hXt), D);
                            if (length > 0 && length <= ((long) rVar.fAP)) {
                                file.delete();
                                i5 = i4 + 1;
                                rVar.fAP = 0;
                                rVar.fEo = 1;
                                t.e(rVar);
                                i4 = i5;
                            }
                        }
                    }
                    i5 = i4;
                    try {
                        rVar.fAP = 0;
                        rVar.fEo = 1;
                        t.e(rVar);
                        i4 = i5;
                    } catch (Exception e) {
                        i3 = i5;
                        i4 = i3;
                    }
                } catch (Exception e2) {
                    i3 = i4;
                    i4 = i3;
                }
            }
        }
        com.tencent.mm.plugin.report.service.g.pWK.a(354, 145, (long) i4, false);
        x.i("MicroMsg.SnsVideoService", "%d delete expire file size %d delete count %d costTime[%d]", Integer.valueOf(hashCode()), Integer.valueOf(a.size()), Integer.valueOf(i4), Long.valueOf(bi.bB(Wz)));
        return false;
    }

    public final boolean a(are are, int i, String str, boolean z, final boolean z2, int i2) {
        int i3 = 0;
        if (are.wEO == 2) {
            x.w("MicroMsg.SnsVideoService", "add video task, but url is weixin, do nothing");
            return false;
        }
        final ax axVar = new ax();
        axVar.hVi = ap.aL(i, are.nlE);
        axVar.fIx = are;
        axVar.hBH = i;
        axVar.fsC = str;
        if (z) {
            i3 = 1;
        }
        axVar.hvu = i3;
        axVar.hvw = i2;
        g.Dr();
        g.Dt().F(new Runnable() {
            public final void run() {
                m LR = ae.bwf().LR(axVar.fsC);
                axVar.reC = LR != null ? LR.field_userName : "";
                x.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", Boolean.valueOf(z2), axVar);
                if (z2) {
                    aq.this.rdG.offerFirst(axVar);
                } else {
                    aq.this.rdG.offerLast(axVar);
                }
                aq.this.rdH.put(axVar.hVi, axVar);
            }
        });
        if (z2) {
            bwL();
        }
        return true;
    }

    final void bwL() {
        g.Dr();
        g.Dt().F(new Runnable() {
            public final void run() {
                boolean z = true;
                if (aq.this.rdG.isEmpty()) {
                    x.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
                    return;
                }
                ax axVar = (ax) aq.this.rdG.poll();
                if (axVar == null) {
                    x.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", Integer.valueOf(aq.this.rdG.size()));
                    return;
                }
                if (aq.this.rdF == null || !axVar.hVi.equals(aq.this.rdF.hVi)) {
                    z = false;
                }
                aq.this.a(axVar, z);
            }
        });
    }

    final boolean a(ax axVar, boolean z) {
        if (bi.oN(ap.a(axVar.fsC, axVar.fIx))) {
            boolean bS = e.bS(ap.KY(axVar.fIx.nMq));
            String D = ap.D(axVar.fIx);
            r KZ = ap.KZ(axVar.fsC);
            if (KZ == null) {
                ap.ch(axVar.fsC, axVar.hvw);
            } else {
                ap.c(KZ, axVar.hvw);
            }
            x.i("MicroMsg.SnsVideoService", "prepare stream download sns video %s mkDir %b", D, Boolean.valueOf(bS));
            com.tencent.mm.plugin.sns.model.a.a aVar = new com.tencent.mm.plugin.sns.model.a.a(axVar.fIx.nMq);
            aVar.qZY = axVar.fIx;
            an cjI = an.cjI();
            cjI.time = axVar.hBH;
            aVar.reG = cjI;
            aVar.reE = true;
            aVar.url = axVar.fIx.nlE;
            int i = axVar.fIx.kzz;
            aVar.reD = false;
            n.TZ();
            o.Uc();
            j a = com.tencent.mm.modelcdntran.f.a(aVar.reG, aVar.url, D, ap.nw(axVar.fsC), axVar.hvu);
            if (a == null) {
                return false;
            }
            D = axVar.reC;
            a.hvv = D;
            a.fAJ = D;
            try {
                blf m = ai.m(ae.bwf().LR(axVar.fsC));
                if (m != null) {
                    a.fAR = m.vWS;
                    a.hvz = m.wVg.wMm;
                }
            } catch (Exception e) {
            }
            this.rdF = axVar;
            this.rdF.hVi = a.field_mediaId;
            x.i("MicroMsg.SnsVideoService", "start stream download sns video cdnMediaId %s delay %b", this.rdF.hVi, Boolean.valueOf(z));
            o.Uc().a(a, z);
            return true;
        }
        x.i("MicroMsg.SnsVideoService", "this video[%s] already download finish, do nothing. [%s, %s]", axVar.hVi, axVar.fsC, ap.a(axVar.fsC, axVar.fIx));
        return false;
    }
}
