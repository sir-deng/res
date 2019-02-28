package com.tencent.mm.plugin.sns.model;

import android.content.Intent;
import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.protocal.c.bkp;
import com.tencent.mm.protocal.c.bku;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class al {

    public static class a implements e, h {
        public static int rdg = -1;
        private Map<com.tencent.mm.plugin.sns.b.h.a, String> hoJ = new HashMap();
        private Map<String, Long> rdh = new HashMap();
        private Map<String, Integer> rdi = new HashMap();
        private int rdj = 0;
        public long rdk = 0;
        private LinkedList<String> rdl = new LinkedList();
        public Map<String, ArrayList<b>> rdm = new HashMap();
        public Map<String, Integer> rdn = new HashMap();

        static /* synthetic */ void a(a aVar) {
            if (!ae.bvO() && aVar.hoJ.isEmpty()) {
                ae.bwc().bvt();
                x.d("MicroMsg.SnsService", "clean sns cache");
            }
        }

        public final void h(String str, ArrayList<b> arrayList) {
            this.rdm.put(str, arrayList);
        }

        public final Intent e(Intent intent, String str) {
            intent.putExtra("sns_userName", str);
            if (this.rdl != null && this.rdl.contains(str)) {
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent.addFlags(67108864);
            }
            return intent;
        }

        public final void a(int i, String str, com.tencent.mm.plugin.sns.b.h.a aVar) {
            x.i("MicroMsg.SnsService", "startServer " + i + " " + aVar);
            ae.bwe().gAM = q.FY();
            ae.bwe().bvG();
            ae.bwb().buT();
            if (this.hoJ.isEmpty()) {
                g.Dr();
                g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (e) this);
                g.Dr();
                g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, (e) this);
            }
            if (!this.hoJ.containsKey(aVar)) {
                if (i == 1) {
                    this.hoJ.put(aVar, "@__weixintimtline");
                } else if (i == 2 || i == 3) {
                    this.hoJ.put(aVar, str);
                } else if (i == 4) {
                    this.hoJ.put(aVar, "@__classify_timeline");
                } else if (i == 5) {
                    this.hoJ.put(aVar, "");
                } else {
                    this.hoJ.put(aVar, "");
                }
            }
            switch (i) {
                case 1:
                    this.rdk = 0;
                    this.rdj = bwE();
                    x.KI("@__weixintimtline");
                    return;
                case 2:
                    synchronized (this.rdh) {
                        this.rdh.put(str, Long.valueOf(0));
                    }
                    synchronized (this.rdi) {
                        if (!this.rdi.containsKey(str)) {
                            this.rdi.put(str, Integer.valueOf(bwE()));
                        }
                    }
                    z.KL(str);
                    this.rdl.add(str);
                    return;
                default:
                    return;
            }
        }

        public final boolean a(com.tencent.mm.plugin.sns.b.h.a aVar, int i) {
            x.d("MicroMsg.SnsService", "closeServer");
            this.hoJ.remove(aVar);
            if (i == 2 && this.rdl.size() > 0) {
                this.rdl.removeLast();
            }
            if (this.hoJ.isEmpty()) {
                g.Dr();
                g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, (e) this);
                g.Dr();
                g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX, (e) this);
                am.release();
                m.release();
                new ag(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        a.a(a.this);
                    }
                }, 5000);
                ai.bwy();
                x.i("MicroMsg.SnsService", "close finish");
            }
            return true;
        }

        public final void b(int i, String str, boolean z, int i2) {
            if (!r.ifu) {
                synchronized (this.rdh) {
                    x.d("MicroMsg.SnsService", "DO NP　NP ~_~ %s type %s timeLastId: %s userLastIds: %s", str, Integer.valueOf(i), Long.valueOf(this.rdk), this.rdh);
                }
                if (i == 2) {
                    if (z.KK(str)) {
                        long j = 0;
                        synchronized (this.rdh) {
                            if (this.rdh.containsKey(str)) {
                                j = ((Long) this.rdh.get(str)).longValue();
                            }
                        }
                        if (j == 0) {
                            x.KI(str);
                            return;
                        }
                        g.Dr();
                        g.Dp().gRu.a(new z(str, j, z, i2), 0);
                    }
                } else if (i == 1) {
                    if (!x.KH("@__weixintimtline")) {
                        return;
                    }
                    if (this.rdk == 0) {
                        x.KI("@__weixintimtline");
                        return;
                    }
                    g.Dr();
                    g.Dp().gRu.a(new x(this.rdk), 0);
                } else if (i == 3 || i != 4 || !m.KH("@__classify_timeline")) {
                } else {
                    if (this.rdk == 0) {
                        m.KI("@__classify_timeline");
                        return;
                    }
                    g.Dr();
                    g.Dp().gRu.a(new m(""), 0);
                }
            }
        }

        public final void a(int i, String str, boolean z, int i2) {
            if (!r.ifu) {
                x.d("MicroMsg.SnsService", "doFpList type: %s, objectId: %s", Integer.valueOf(i), str);
                if (i == 2) {
                    if (z.KK(str)) {
                        g.Dr();
                        g.Dp().gRu.a(new z(str, 0, z, i2), 0);
                    }
                } else if (i == 1) {
                    if (x.KH("@__weixintimtline")) {
                        g.Dr();
                        g.Dq().Db().set(68377, "");
                        g.Dr();
                        g.Dp().gRu.a(new x(0), 0);
                    }
                } else if (i != 3 && i == 4 && m.KH("@__classify_timeline")) {
                    g.Dr();
                    g.Dp().gRu.a(new m(""), 0);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int KU(java.lang.String r3) {
            /*
            r2 = this;
            r1 = r2.rdi;
            monitor-enter(r1);
            r0 = r2.rdi;	 Catch:{ all -> 0x0026 }
            r0 = r0.containsKey(r3);	 Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0020;
        L_0x000b:
            r0 = r2.rdi;	 Catch:{ all -> 0x0026 }
            r0 = r0.get(r3);	 Catch:{ all -> 0x0026 }
            r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0026 }
            r0 = r0.intValue();	 Catch:{ all -> 0x0026 }
            if (r0 <= 0) goto L_0x001b;
        L_0x0019:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        L_0x001a:
            return r0;
        L_0x001b:
            r0 = com.tencent.mm.plugin.sns.data.i.buV();	 Catch:{ all -> 0x0026 }
            goto L_0x0019;
        L_0x0020:
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            r0 = com.tencent.mm.plugin.sns.data.i.buV();
            goto L_0x001a;
        L_0x0026:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0026 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.model.al.a.KU(java.lang.String):int");
        }

        public final int bwE() {
            return this.rdj > 0 ? this.rdj : i.buV();
        }

        public final void y(long j, int i) {
            x.d("MicroMsg.SnsService", "setTimeLastId %d", Long.valueOf(j));
            if (i > 0) {
                this.rdj = i;
                i.wO(i);
            }
            if (j != 0) {
                this.rdk = j;
            }
        }

        public static int bwF() {
            if (rdg != -1) {
                return rdg;
            }
            int buU = i.buU();
            rdg = buU;
            return buU;
        }

        public final void a(int i, int i2, String str, k kVar) {
            Object obj;
            x xVar;
            int i3;
            z zVar;
            String str2;
            long j;
            d dVar;
            Iterator it;
            com.tencent.mm.plugin.sns.b.h.a aVar;
            String str3;
            String es;
            boolean bvm;
            boolean bvo;
            boolean z;
            boolean bvn;
            x.i("MicroMsg.SnsService", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
            if (!((i == 4 && i2 == 207) || (i == 4 && i2 == 203))) {
                if (i == 4 && (i2 == 2001 || i2 == TXLiveConstants.PLAY_EVT_PLAY_BEGIN)) {
                    obj = 1;
                    if (obj != null) {
                        switch (kVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                                xVar = (x) kVar;
                                y(xVar.qZP, xVar.qZR);
                                i3 = xVar.qZS;
                                if (rdg != i3) {
                                    i.wN(i3);
                                }
                                rdg = i3;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                zVar = (z) kVar;
                                str2 = zVar.userName;
                                j = zVar.qZP;
                                i3 = zVar.qZR;
                                if (i3 > 0) {
                                    synchronized (this.rdi) {
                                        this.rdi.put(str2, Integer.valueOf(i3));
                                    }
                                }
                                if (j != 0) {
                                    synchronized (this.rdh) {
                                        this.rdh.put(str2, Long.valueOf(j));
                                    }
                                }
                                break;
                        }
                        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                        }
                        dVar = (d) kVar;
                        it = new ArrayList(this.hoJ.keySet()).iterator();
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.plugin.sns.b.h.a) it.next();
                            if (!this.hoJ.containsKey(aVar)) {
                                str3 = (String) this.hoJ.get(aVar);
                                if (!dVar.getUserName().equals(str3)) {
                                    x.d("MicroMsg.SnsService", "notify ui " + str3);
                                    if (dVar.bvp() != 0) {
                                    }
                                    if (dVar.bvl()) {
                                        bvm = dVar.bvm();
                                        bvo = dVar.bvo();
                                        if (i != 4) {
                                        }
                                        aVar.a(bvm, es, bvo, z, i2, dVar.bvr());
                                    } else {
                                        bvn = dVar.bvn();
                                        bvm = dVar.bvm();
                                        bvo = dVar.bvq();
                                        if (i != 4) {
                                        }
                                        aVar.a(bvn, bvm, es, bvo, z, i2, dVar.bvr());
                                    }
                                }
                            }
                        }
                    }
                } else if (i == 4 && (i2 == 2001 || i2 == 2003)) {
                    obj = 1;
                    if (obj != null) {
                        switch (kVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                                xVar = (x) kVar;
                                y(xVar.qZP, xVar.qZR);
                                i3 = xVar.qZS;
                                if (rdg != i3) {
                                    i.wN(i3);
                                }
                                rdg = i3;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                zVar = (z) kVar;
                                str2 = zVar.userName;
                                j = zVar.qZP;
                                i3 = zVar.qZR;
                                if (i3 > 0) {
                                    synchronized (this.rdi) {
                                        this.rdi.put(str2, Integer.valueOf(i3));
                                    }
                                }
                                if (j != 0) {
                                    synchronized (this.rdh) {
                                        this.rdh.put(str2, Long.valueOf(j));
                                    }
                                }
                                break;
                        }
                        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                        }
                        dVar = (d) kVar;
                        it = new ArrayList(this.hoJ.keySet()).iterator();
                        while (it.hasNext()) {
                            aVar = (com.tencent.mm.plugin.sns.b.h.a) it.next();
                            if (!this.hoJ.containsKey(aVar)) {
                                str3 = (String) this.hoJ.get(aVar);
                                if (!dVar.getUserName().equals(str3)) {
                                    x.d("MicroMsg.SnsService", "notify ui " + str3);
                                    if (dVar.bvp() != 0) {
                                    }
                                    if (dVar.bvl()) {
                                        bvm = dVar.bvm();
                                        bvo = dVar.bvo();
                                        if (i != 4) {
                                        }
                                        aVar.a(bvm, es, bvo, z, i2, dVar.bvr());
                                    } else {
                                        bvn = dVar.bvn();
                                        bvm = dVar.bvm();
                                        bvo = dVar.bvq();
                                        if (i != 4) {
                                        }
                                        aVar.a(bvn, bvm, es, bvo, z, i2, dVar.bvr());
                                    }
                                }
                            }
                        }
                    }
                } else if (!(i == 0 && i2 == 0)) {
                    obj = null;
                    if (obj != null) {
                        switch (kVar.getType()) {
                            case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                                xVar = (x) kVar;
                                y(xVar.qZP, xVar.qZR);
                                i3 = xVar.qZS;
                                if (rdg != i3) {
                                    i.wN(i3);
                                }
                                rdg = i3;
                                break;
                            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                                zVar = (z) kVar;
                                str2 = zVar.userName;
                                j = zVar.qZP;
                                i3 = zVar.qZR;
                                if (i3 > 0) {
                                    synchronized (this.rdi) {
                                        this.rdi.put(str2, Integer.valueOf(i3));
                                    }
                                }
                                if (j != 0) {
                                    synchronized (this.rdh) {
                                        this.rdh.put(str2, Long.valueOf(j));
                                    }
                                }
                                break;
                        }
                        if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX || kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX) {
                            dVar = (d) kVar;
                            it = new ArrayList(this.hoJ.keySet()).iterator();
                            while (it.hasNext()) {
                                aVar = (com.tencent.mm.plugin.sns.b.h.a) it.next();
                                if (!this.hoJ.containsKey(aVar)) {
                                    str3 = (String) this.hoJ.get(aVar);
                                    if (!dVar.getUserName().equals(str3)) {
                                        x.d("MicroMsg.SnsService", "notify ui " + str3);
                                        es = dVar.bvp() != 0 ? "" : i.es(dVar.bvp());
                                        if (dVar.bvl()) {
                                            bvn = dVar.bvn();
                                            bvm = dVar.bvm();
                                            bvo = dVar.bvq();
                                            z = i != 4 && (i2 == 2001 || i2 == TXLiveConstants.PLAY_EVT_PLAY_BEGIN || i2 == 2003);
                                            aVar.a(bvn, bvm, es, bvo, z, i2, dVar.bvr());
                                        } else {
                                            bvm = dVar.bvm();
                                            bvo = dVar.bvo();
                                            z = i != 4 && (i2 == 2001 || i2 == TXLiveConstants.PLAY_EVT_PLAY_BEGIN || i2 == 2003);
                                            aVar.a(bvm, es, bvo, z, i2, dVar.bvr());
                                        }
                                    }
                                }
                            }
                        }
                        return;
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                switch (kVar.getType()) {
                    case com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX /*211*/:
                        xVar = (x) kVar;
                        y(xVar.qZP, xVar.qZR);
                        i3 = xVar.qZS;
                        if (rdg != i3) {
                            i.wN(i3);
                        }
                        rdg = i3;
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                        zVar = (z) kVar;
                        str2 = zVar.userName;
                        j = zVar.qZP;
                        i3 = zVar.qZR;
                        if (i3 > 0) {
                            synchronized (this.rdi) {
                                this.rdi.put(str2, Integer.valueOf(i3));
                            }
                        }
                        if (j != 0) {
                            synchronized (this.rdh) {
                                this.rdh.put(str2, Long.valueOf(j));
                            }
                        }
                        break;
                }
                if (kVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX) {
                }
                dVar = (d) kVar;
                it = new ArrayList(this.hoJ.keySet()).iterator();
                while (it.hasNext()) {
                    aVar = (com.tencent.mm.plugin.sns.b.h.a) it.next();
                    if (!this.hoJ.containsKey(aVar)) {
                        str3 = (String) this.hoJ.get(aVar);
                        if (!dVar.getUserName().equals(str3)) {
                            x.d("MicroMsg.SnsService", "notify ui " + str3);
                            if (dVar.bvp() != 0) {
                            }
                            if (dVar.bvl()) {
                                bvm = dVar.bvm();
                                bvo = dVar.bvo();
                                if (i != 4) {
                                }
                                aVar.a(bvm, es, bvo, z, i2, dVar.bvr());
                            } else {
                                bvn = dVar.bvn();
                                bvm = dVar.bvm();
                                bvo = dVar.bvq();
                                if (i != 4) {
                                }
                                aVar.a(bvn, bvm, es, bvo, z, i2, dVar.bvr());
                            }
                        }
                    }
                }
            }
        }

        public static void KV(String str) {
            com.tencent.mm.plugin.sns.storage.a byD;
            Object obj;
            String obj2;
            ac bwe = ae.bwe();
            if (bi.oN(bwe.gAM)) {
                bwe.gAM = q.FY();
            }
            String str2 = bwe.gAM;
            m LQ = com.tencent.mm.plugin.sns.storage.h.LQ(str);
            try {
                blf blf = (blf) new blf().aH(LQ.field_attrBuf);
                Iterator it = blf.wUR.iterator();
                while (it.hasNext()) {
                    bku bku = (bku) it.next();
                    if (bku.vPp.equals(str2)) {
                        blf.wUR.remove(bku);
                        blf.wUP--;
                        LQ.field_attrBuf = blf.toByteArray();
                        if (LQ.xD(32)) {
                            ae.bwi().a(LQ.bzl());
                        } else {
                            ae.bwf().z(LQ);
                        }
                        if (!ae.bwe().eG(u.Mk(str))) {
                            if (LQ.xD(32)) {
                                g.Dr();
                                g.Dp().gRu.a(new q(u.Mk(str), 5), 0);
                                return;
                            }
                            byD = LQ.byD();
                            if (byD != null) {
                                obj2 = "";
                            } else {
                                obj2 = byD.iWv;
                            }
                            ((c) g.h(c.class)).a(11855, LQ.bzm(), Integer.valueOf(0), obj2, Integer.valueOf(LQ.bzm()));
                            g.Dr();
                            g.Dp().gRu.a(new q(u.Mk(str), 7), 0);
                        }
                        return;
                    }
                }
            } catch (Exception e) {
            }
            if (!ae.bwe().eG(u.Mk(str))) {
                return;
            }
            if (LQ.xD(32)) {
                g.Dr();
                g.Dp().gRu.a(new q(u.Mk(str), 5), 0);
                return;
            }
            byD = LQ.byD();
            if (byD != null) {
                obj2 = byD.iWv;
            } else {
                obj2 = "";
            }
            ((c) g.h(c.class)).a(11855, LQ.bzm(), Integer.valueOf(0), obj2, Integer.valueOf(LQ.bzm()));
            g.Dr();
            g.Dp().gRu.a(new q(u.Mk(str), 7), 0);
        }

        public static bku a(m mVar, int i, String str) {
            return a(mVar, i, str, null, false, 0, 0);
        }

        public static bku a(m mVar, int i, String str, bku bku, int i2) {
            return a(mVar, i, str, bku, false, i2);
        }

        public static bku a(m mVar, int i, String str, bku bku, boolean z, int i2) {
            return a(mVar, i, str, bku, z, 0, i2);
        }

        private static bku a(m mVar, int i, String str, bku bku, boolean z, int i2, int i3) {
            bko bko = new bko();
            bko.noL = str;
            bko.pgR = (int) (bi.Wy() / 1000);
            bko.wUk = q.Ga();
            bko.wNo = q.FY();
            bko.vON = 0;
            bko.wUl = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gw(mVar.field_userName);
            bko.wik = mVar.field_userName;
            bko.kzz = i;
            bko.wUs = i3;
            if (mVar.xD(32)) {
                bko.wUp = bku == null ? 0 : bku.wUq;
            } else {
                bko.wUm = bku == null ? 0 : bku.wUn;
            }
            bko bko2 = new bko();
            bko2.wNo = bku == null ? "" : bku.vPp;
            bkp bkp = new bkp();
            bkp.vWS = mVar.field_snsId;
            bkp.wUu = bko;
            bkp.wUv = bko2;
            String str2 = "";
            if (mVar.xD(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a byD = mVar.byD();
                if (byD == null) {
                    obj = "";
                } else {
                    String obj2 = byD.iWv;
                }
                str2 = byD == null ? "" : byD.rfQ;
                if (bko.kzz == 7) {
                    ((c) g.h(c.class)).a(11855, mVar.bzm(), Integer.valueOf(1), obj2, Integer.valueOf(mVar.bzm()));
                } else if (bko.kzz == 8) {
                    ((c) g.h(c.class)).a(11855, mVar.bzm(), Integer.valueOf(2), obj2, Integer.valueOf(mVar.bzm()));
                }
                com.tencent.mm.plugin.sns.storage.e bzl = mVar.bzl();
                if (bzl != null && bzl.field_firstControlTime == 0) {
                    bzl.field_firstControlTime = bko.pgR;
                    ae.bwi().b(bzl.field_snsId, bzl);
                }
            }
            String s = com.tencent.mm.a.g.s((bi.Wz()).getBytes());
            if (mVar.xD(32)) {
                s = "_AD_TAG_" + s;
            }
            if (!ae.bwe().a(s, bkp)) {
                x.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ac.KM(s)) {
                g.Dr();
                g.Dp().gRu.a(new j(bkp, s, str2), 0);
            } else {
                g.Dr();
                g.Dp().gRu.a(new n(bkp, s), 0);
            }
            if (!z) {
                return null;
            }
            bku bku2 = new bku();
            bku2.pgR = bko.pgR;
            bku2.kzz = bko.kzz;
            bku2.vON = bko.vON;
            bku2.vPp = bko.wNo;
            bku2.wDh = bko.wUk;
            bku2.noL = bko.noL;
            bku2.wUs = bko.wUs;
            if (mVar.xD(32)) {
                bku2.wUp = bku == null ? 0 : bku.wUq;
            } else {
                bku2.wUm = bku == null ? 0 : bku.wUn;
            }
            bku2.wUH = bku == null ? "" : bku.vPp;
            return bku2;
        }

        public static bku a(m mVar, int i, String str, String str2, int i2) {
            bko bko = new bko();
            bko.noL = str;
            bko.pgR = (int) (bi.Wy() / 1000);
            bko.wUk = q.Ga();
            bko.wNo = q.FY();
            bko.vON = i2;
            bko.wUl = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gw(mVar.field_userName);
            bko.wik = mVar.field_userName;
            bko.kzz = i;
            if (mVar.xD(32)) {
                bko.wUp = 0;
            } else {
                bko.wUm = 0;
            }
            bko bko2 = new bko();
            bko2.wNo = str2;
            bkp bkp = new bkp();
            bkp.vWS = mVar.field_snsId;
            bkp.wUu = bko;
            bkp.wUv = bko2;
            String str3 = "";
            if (mVar.xD(32)) {
                Object obj;
                com.tencent.mm.plugin.sns.storage.a byD = mVar.byD();
                if (byD == null) {
                    obj = "";
                } else {
                    String obj2 = byD.iWv;
                }
                str3 = byD == null ? "" : byD.rfQ;
                if (bko.kzz == 7) {
                    ((c) g.h(c.class)).a(11855, mVar.bzm(), Integer.valueOf(1), obj2, Integer.valueOf(mVar.bzm()));
                } else if (bko.kzz == 8) {
                    ((c) g.h(c.class)).a(11855, mVar.bzm(), Integer.valueOf(2), obj2, Integer.valueOf(mVar.bzm()));
                }
            }
            String s = com.tencent.mm.a.g.s((bi.Wz()).getBytes());
            if (mVar.xD(32)) {
                s = "_AD_TAG_" + s;
            }
            if (!ae.bwe().a(s, bkp, str3)) {
                x.e("MicroMsg.SnsService", "can not add Comment");
            } else if (ac.KM(s)) {
                g.Dr();
                g.Dp().gRu.a(new j(bkp, s, str3), 0);
            } else {
                g.Dr();
                g.Dp().gRu.a(new n(bkp, s), 0);
            }
            return null;
        }

        public static void a(String str, int i, String str2, m mVar, int i2) {
            if (i == 3 || i == 5) {
                bko bko = new bko();
                bko.noL = str2;
                bko.pgR = (int) (System.currentTimeMillis() / 1000);
                bko.wUk = q.Ga();
                bko.wNo = q.FY();
                bko.vON = i2;
                bko.wUl = ((com.tencent.mm.plugin.messenger.a.b) g.h(com.tencent.mm.plugin.messenger.a.b.class)).gw(str);
                bko.wik = str;
                bko.kzz = i;
                bkp bkp = new bkp();
                bkp.vWS = mVar.field_snsId;
                bkp.wUu = bko;
                bkp.wUv = new bko();
                String s = com.tencent.mm.a.g.s((bi.Wz()).getBytes());
                long j = mVar.field_snsId;
                try {
                    x.v("MicroMsg.SnsService", "comment stg inserted");
                    com.tencent.mm.sdk.e.c iVar = new com.tencent.mm.plugin.sns.storage.i();
                    iVar.field_talker = str;
                    iVar.field_snsID = j;
                    iVar.field_createTime = (int) (System.currentTimeMillis() / 1000);
                    iVar.field_curActionBuf = bko.toByteArray();
                    iVar.field_type = i;
                    iVar.field_isSend = true;
                    iVar.field_isRead = (short) 1;
                    ae.bwk().b(iVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.SnsService", e, "", new Object[0]);
                }
                ae.bwe().a(s, bkp);
            }
        }

        public final void Kh(String str) {
            String accSnsPath = ae.getAccSnsPath();
            String str2 = str + "bg_";
            String str3 = str + "tbg_";
            if (FileOp.bO(str2)) {
                FileOp.deleteFile(am.r(accSnsPath, str) + str3);
                FileOp.g(am.r(accSnsPath, str), str2, str3);
            }
        }
    }
}
