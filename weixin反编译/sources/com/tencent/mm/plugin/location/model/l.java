package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.bk;
import com.tencent.mm.f.a.eq;
import com.tencent.mm.f.a.fy;
import com.tencent.mm.f.a.hv;
import com.tencent.mm.f.a.iw;
import com.tencent.mm.f.a.iy;
import com.tencent.mm.f.a.nz;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.protocal.c.bfg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bq;
import com.tencent.mm.y.e;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class l implements ap {
    private c nWS = new c();
    private a nWT = new a();
    private b nWU = new b();
    private com.tencent.mm.plugin.location.model.a.a nWV;
    private int nWW = 0;
    private e nWX = new b();
    private e nWY = new n();
    private o nWZ = null;
    private p nXa = null;
    private i nXb = null;
    private m nXc = null;
    private d nXd = new d();
    private k nXe = null;
    private j nXf = null;
    private com.tencent.mm.ad.e nXg = new com.tencent.mm.ad.e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                ab abVar = (ab) kVar;
                bfg Su = abVar.Su();
                if (Su.kzz == 0) {
                    long j = abVar.frh;
                    String mC = ab.mC(Su.vUQ);
                    as.Hm();
                    au dI = com.tencent.mm.y.c.Fh().dI(j);
                    if (dI.aNL()) {
                        dI.dW(mC);
                        as.Hm();
                        com.tencent.mm.y.c.Fh().a(j, dI);
                    }
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c nXh = new com.tencent.mm.sdk.b.c<eq>() {
        {
            this.xmG = eq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            eq eqVar = (eq) bVar;
            x.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", com.tencent.mm.pluginsdk.q.a.vjd.aWh(), eqVar.fub.username);
            l.aWa().stop();
            if (!bi.oN(com.tencent.mm.pluginsdk.q.a.vje.aWr())) {
                l.aWa().se(1);
                com.tencent.mm.sdk.b.b rkVar = new rk();
                rkVar.fJX.fKa = true;
                com.tencent.mm.sdk.b.a.xmy.m(rkVar);
            }
            if (!bi.oN(eqVar.fub.username)) {
                com.tencent.mm.plugin.location.a.a Eh = l.aWb().Eh(eqVar.fub.username);
                if (Eh != null) {
                    Eh.fBS.remove(q.FY());
                    l.aWb().a(eqVar.fub.username, Eh.fBS, Eh.latitude, Eh.longitude, Eh.nWa, null, null);
                    if (com.tencent.mm.pluginsdk.q.a.viX != null) {
                        com.tencent.mm.pluginsdk.q.a.viX.a(eqVar.fub.username, null, null, null, 1);
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nXi = new com.tencent.mm.sdk.b.c<nz>() {
        {
            this.xmG = nz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            nz nzVar = (nz) bVar;
            x.d("MicroMsg.SubCoreLocation", "trackEvent state " + nzVar.fGL.ahf);
            if (nzVar.fGL.ahf) {
                if (l.aWa().aWf() && l.aWa().nXz) {
                    l.aWa().aWg();
                }
            } else if (l.aWa().aWf()) {
                o aWa = l.aWa();
                x.d("MicorMsg.TrackRefreshManager", "pause refresh");
                aWa.nXz = true;
                if (aWa.hry != null) {
                    aWa.hry.c(aWa.gAn);
                }
                if (aWa.nXq != null) {
                    aWa.nXq.b(aWa.nXF);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nXj = new com.tencent.mm.sdk.b.c<hv>() {
        {
            this.xmG = hv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            hv hvVar = (hv) bVar;
            j aVZ = l.aVZ();
            cg cgVar = hvVar.fyZ.fou;
            ImageView imageView = hvVar.fyZ.fzb;
            ProgressBar progressBar = hvVar.fyZ.fzd;
            ImageView imageView2 = hvVar.fyZ.fzc;
            int i = hvVar.fyZ.fze;
            int i2 = hvVar.fyZ.w;
            int i3 = hvVar.fyZ.h;
            String str = cgVar.field_content;
            if (!bi.oN(str)) {
                aVZ.w = i2;
                aVZ.h = i3;
                if (aVZ.w <= 0 || aVZ.h <= 0) {
                    aVZ.w = 300;
                    aVZ.h = 300;
                }
                boolean z = cgVar.field_isSend == 0;
                if (s.eX(cgVar.field_talker) && z) {
                    int hR = bb.hR(str);
                    if (hR != -1) {
                        str = str.substring(hR + 1).trim();
                    }
                }
                as.Hm();
                com.tencent.mm.storage.au.b Fr = com.tencent.mm.y.c.Fh().Fr(str);
                if (cgVar.gkJ == 5 || aVZ.nWL.contains(Long.valueOf(cgVar.field_msgId))) {
                    x.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", Long.valueOf(cgVar.field_msgId), Integer.valueOf(cgVar.gkJ));
                    imageView2.setVisibility(0);
                    progressBar.setVisibility(8);
                } else {
                    com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(cgVar.field_msgId, (float) Fr.nWe, (float) Fr.nWf, (int) (((double) Fr.fAq) * 1.1d), 0);
                    progressBar.setVisibility(0);
                    imageView2.setVisibility(8);
                    k aVY = l.aVY();
                    aVY.w = i2;
                    aVY.h = i3;
                    if (aVY.w <= 0 || aVY.h <= 0) {
                        aVY.w = 300;
                        aVY.h = 300;
                    }
                    String b = k.b(bVar2);
                    if (com.tencent.mm.a.e.bO(b)) {
                        if (!as.Hp()) {
                            b = "";
                        }
                    } else if (aVY.nWN == null || !aVY.nWN.toString().equals(bVar2.toString())) {
                        Iterator it = aVY.nWM.iterator();
                        while (it.hasNext()) {
                            if (bVar2.toString().equals(((com.tencent.mm.pluginsdk.location.b) it.next()).toString())) {
                                x.i("MicroMsg.StaticMapServer", "has add queue");
                                aVY.OU();
                                b = "";
                                break;
                            }
                        }
                        aVY.nWM.add(bVar2);
                        x.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", Integer.valueOf(aVY.nWM.size()), Integer.valueOf(aVY.w), Integer.valueOf(aVY.h));
                        aVY.OU();
                        b = "";
                    } else {
                        x.i("MicroMsg.StaticMapServer", "has add queue");
                        aVY.OU();
                        b = "";
                    }
                    if (bi.oN(b) || !com.tencent.mm.a.e.bO(b)) {
                        aVZ.nWG.put(Long.valueOf(bVar2.vjD), Fr);
                        aVZ.nWK.put(Long.valueOf(cgVar.field_msgId), Integer.valueOf(i));
                        aVZ.nWJ.put(Fr, cgVar);
                        aVZ.nWF.put(Long.valueOf(cgVar.field_msgId), new WeakReference(imageView));
                        aVZ.nWH.put(Long.valueOf(cgVar.field_msgId), new WeakReference(progressBar));
                        aVZ.nWI.put(Long.valueOf(cgVar.field_msgId), new WeakReference(imageView2));
                        aVZ.start();
                    } else {
                        x.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", Integer.valueOf(i));
                        if (as.Hp()) {
                            Bitmap a = o.PC().a(cgVar.field_msgId, b, i, aVZ.w, aVZ.h, z);
                            if (!(a == null || a.isRecycled())) {
                                imageView.setImageBitmap(a);
                                progressBar.setVisibility(8);
                                imageView2.setVisibility(0);
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.b.c nXk = new com.tencent.mm.sdk.b.c<bk>() {
        {
            this.xmG = bk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            com.tencent.mm.pluginsdk.location.a aVZ = l.aVZ();
            x.i("MicroMsg.StaticMapMsgLogic", "clean task");
            aVZ.nWF.clear();
            aVZ.nWJ.clear();
            aVZ.nWK.clear();
            aVZ.nWH.clear();
            aVZ.nWI.clear();
            aVZ.nWL.clear();
            aVZ.nWG.clear();
            l.aVY().a(aVZ);
            l.aVY().a(aVZ);
            return false;
        }
    };
    private com.tencent.mm.y.bt.a nXl = new com.tencent.mm.y.bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            new n().b(aVar);
        }
    };

    private static final class a extends com.tencent.mm.sdk.b.c<fy> {
        private a() {
            this.xmG = fy.class.getName().hashCode();
        }

        /* synthetic */ a(byte b) {
            this();
            this.xmG = fy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            fy fyVar = (fy) bVar;
            if (!(fyVar instanceof fy)) {
                return false;
            }
            l.O(fyVar.fwI.fou);
            return true;
        }
    }

    private static final class c extends com.tencent.mm.sdk.b.c<iy> {
        private volatile boolean Ki;

        private c() {
            this.Ki = false;
            this.xmG = iy.class.getName().hashCode();
        }

        /* synthetic */ c(byte b) {
            this();
            this.xmG = iy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            iy iyVar = (iy) bVar;
            if (!(iyVar instanceof iy)) {
                return false;
            }
            x.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + iyVar.fAs.fAm);
            switch (iyVar.fAs.fAm) {
                case 0:
                    l.aVX().nWk = new HashSet();
                    this.Ki = true;
                    return true;
                case 1:
                    if (this.Ki) {
                        String[] N = l.aVX().N(iyVar.fAs.fou);
                        iyVar.fAt.fxq = N[0];
                        iyVar.fAt.fAv = N[1];
                        return true;
                    }
                    iyVar.fAt.fxq = "err_not_started";
                    return true;
                case 2:
                    if (!this.Ki) {
                        return true;
                    }
                    l.aVX().aVS();
                    return true;
                default:
                    return true;
            }
        }
    }

    private static final class b extends com.tencent.mm.sdk.b.c<iw> {
        private b() {
            this.xmG = iw.class.getName().hashCode();
        }

        /* synthetic */ b(byte b) {
            this();
            this.xmG = iw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            iw iwVar = (iw) bVar;
            if (!(iwVar instanceof iw)) {
                return false;
            }
            x.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + iwVar.fAk.fAm);
            switch (iwVar.fAk.fAm) {
                case 0:
                    iwVar.fAl.path = e.a(iwVar.fAk.fAn, iwVar.fAk.filename, iwVar.fAk.view);
                    break;
                case 1:
                    com.tencent.mm.pluginsdk.location.b bVar2 = new com.tencent.mm.pluginsdk.location.b(-1, iwVar.fAk.fAo, iwVar.fAk.fAp, iwVar.fAk.fAq, 1);
                    iwVar.fAl.path = k.b(bVar2);
                    break;
                case 2:
                    as.CN().a(new g(iwVar.fAk.fAo, iwVar.fAk.fAp, iwVar.fAk.fAq, iwVar.fAk.width, iwVar.fAk.height, iwVar.fAk.filename, w.cfV()), 0);
                    break;
                case 3:
                    g gVar = (g) iwVar.fAk.frW;
                    iwVar.fAl.path = gVar.nWs;
                    break;
            }
            return true;
        }
    }

    private static l aVW() {
        as.Hg();
        l lVar = (l) bq.ib("plugin.location");
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        as.Hg().a("plugin.location", lVar2);
        return lVar2;
    }

    public static com.tencent.mm.plugin.location.model.a.a aVX() {
        g.Do().CA();
        if (aVW().nWV == null) {
            aVW().nWV = new com.tencent.mm.plugin.location.model.a.a();
        }
        return aVW().nWV;
    }

    public static k aVY() {
        g.Do().CA();
        if (aVW().nXe == null) {
            aVW().nXe = new k();
        }
        return aVW().nXe;
    }

    public static j aVZ() {
        g.Do().CA();
        if (aVW().nXf == null) {
            aVW().nXf = new j();
        }
        return aVW().nXf;
    }

    public static o aWa() {
        if (aVW().nWZ == null) {
            aVW().nWZ = new o();
        }
        return aVW().nWZ;
    }

    public static p aWb() {
        if (aVW().nXa == null) {
            aVW().nXa = new p();
        }
        return aVW().nXa;
    }

    public static i aWc() {
        if (aVW().nXb == null) {
            aVW().nXb = new i();
        }
        return aVW().nXb;
    }

    public static m aWd() {
        if (aVW().nXc == null) {
            aVW().nXc = new m();
        }
        return aVW().nXc;
    }

    public static void O(au auVar) {
        if (auVar != null && auVar.field_msgId != 0) {
            com.tencent.mm.storage.au.b XZ = com.tencent.mm.storage.au.b.XZ(auVar.field_content);
            as.CN().a(new ab((float) XZ.nWf, (float) XZ.nWe, auVar.field_msgId), 0);
        }
    }

    public static String aWe() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(com.tencent.mm.y.c.FI()).append("trackroom/").toString();
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(48), this.nWX);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(61), this.nWY);
        as.getSysCmdMsgExtension().a("trackmsg", this.nXl, true);
        as.CN().a(424, this.nXg);
        com.tencent.mm.sdk.b.a.xmy.b(this.nWS);
        com.tencent.mm.sdk.b.a.xmy.b(this.nWT);
        com.tencent.mm.sdk.b.a.xmy.b(this.nXh);
        com.tencent.mm.sdk.b.a.xmy.b(this.nXi);
        com.tencent.mm.sdk.b.a.xmy.b(this.nXj);
        com.tencent.mm.sdk.b.a.xmy.b(this.nXk);
        com.tencent.mm.sdk.b.a.xmy.b(this.nWU);
        com.tencent.mm.pluginsdk.q.a.vjd = aWa();
        com.tencent.mm.pluginsdk.q.a.vje = aWb();
        com.tencent.mm.bq.a.a.a.xjs = aWd();
        g.Do().CA();
        if (aVW().nXd == null) {
            aVW().nXd = new d();
        }
        com.tencent.mm.plugin.p.c.a.oem = aVW().nXd;
    }

    public final void onAccountRelease() {
        if (this.nWZ != null) {
            this.nWZ.nXA = null;
            this.nWZ.stop();
            this.nWZ.se(1);
        }
        com.tencent.mm.ad.d.c.b(Integer.valueOf(48), this.nWX);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(61), this.nWY);
        as.getSysCmdMsgExtension().b("trackmsg", this.nXl, true);
        as.CN().b(424, this.nXg);
        com.tencent.mm.sdk.b.a.xmy.c(this.nWS);
        com.tencent.mm.sdk.b.a.xmy.c(this.nWT);
        com.tencent.mm.sdk.b.a.xmy.c(this.nXh);
        com.tencent.mm.sdk.b.a.xmy.c(this.nXi);
        com.tencent.mm.sdk.b.a.xmy.c(this.nXj);
        com.tencent.mm.sdk.b.a.xmy.c(this.nXk);
        com.tencent.mm.sdk.b.a.xmy.c(this.nWU);
        if (this.nXb != null) {
            i iVar = this.nXb;
            iVar.aVV();
            iVar.jYt.clear();
        }
        if (this.nXe != null) {
            this.nXe.stop();
        }
        if (this.nXf != null) {
            aVY().a(this.nXf);
        }
    }

    public final void bt(boolean z) {
    }
}
