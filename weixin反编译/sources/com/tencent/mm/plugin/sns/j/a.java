package com.tencent.mm.plugin.sns.j;

import android.database.Cursor;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.c.bko;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.q;

public final class a extends com.tencent.mm.vending.app.a implements e {
    String jPV;
    String rOd;
    boolean rOe;
    int rOf;
    public volatile aw rPy;
    protected volatile com.tencent.mm.plugin.sns.model.al.a rSb;
    private com.tencent.mm.plugin.sns.b.h.a rXU;
    boolean rzo;

    public final void a(com.tencent.mm.plugin.sns.b.h.a aVar) {
        this.rSb = ae.bvV();
        com.tencent.mm.plugin.sns.j.c.a aVar2 = (com.tencent.mm.plugin.sns.j.c.a) J(com.tencent.mm.plugin.sns.j.c.a.class);
        this.rXU = aVar;
        this.rSb.a(1, aVar2.jPV, this.rXU);
    }

    public final com.tencent.mm.plugin.sns.model.al.a bvV() {
        return this.rSb;
    }

    protected final void onCreate() {
        super.onCreate();
        a(b.class, new com.tencent.mm.vending.app.a.a<b>() {
            protected final /* synthetic */ Object WW() {
                x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", b.class);
                return a.bDs();
            }
        });
        a(com.tencent.mm.plugin.sns.j.c.a.class, new com.tencent.mm.vending.app.a.a<com.tencent.mm.plugin.sns.j.c.a>() {
            protected final /* synthetic */ Object WW() {
                x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor index %s", com.tencent.mm.plugin.sns.j.c.a.class);
                com.tencent.mm.vending.app.a aVar = a.this;
                com.tencent.mm.plugin.sns.j.c.a aVar2 = new com.tencent.mm.plugin.sns.j.c.a();
                aVar.rOf = aVar.zKi.getIntExtra("sns_source", 0);
                aVar.jPV = aVar.zKi.getStringExtra("sns_userName");
                if (aVar.jPV == null) {
                    aVar.jPV = "";
                }
                g.Dr();
                aVar.rOe = ((h) g.h(h.class)).Ff().Xr(aVar.jPV);
                aVar.rOd = q.FY();
                aVar.rzo = aVar.rOd.equals(aVar.jPV);
                ar bvT = ae.bvT();
                String aD = bi.aD(aVar.zKi.getStringExtra("sns_signature"), "");
                String aD2 = bi.aD(aVar.zKi.getStringExtra("sns_nickName"), "");
                ag Xv = (aVar.jPV == null || aVar.jPV.equals("")) ? bvT.Xv(aVar.rOd) : bvT.Xv(aVar.jPV);
                if (Xv != null && ((int) Xv.gKO) > 0) {
                    aD = Xv.signature;
                    aD2 = Xv.AW();
                    x.i("MicroMsg.SnsTimelineInteractor", "contact:user[%s] id[%d] nickname[%s]", Xv.field_username, Integer.valueOf((int) Xv.gKO), aD2);
                }
                aVar2.jPV = aVar.jPV;
                aVar2.rOd = aVar.rOd;
                aVar2.rOe = aVar.rOe;
                aVar2.rzo = aVar.rzo;
                aVar2.rOf = aVar.rOf;
                aVar2.nqW = aD2;
                aVar2.rRn = aD;
                return aVar2;
            }
        });
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", this);
        ae.bwa().qYD.clear();
        ae.bwa();
        com.tencent.mm.plugin.sns.model.b.bvi();
    }

    protected final void onDestroy() {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", this);
        g.Dr();
        if (!(!g.Do().CF() || this.rSb == null || this.rXU == null)) {
            this.rSb.a(this.rXU, 1);
        }
        super.onDestroy();
    }

    static b bDs() {
        String str;
        b bVar = new b();
        Cursor byL = ae.bwk().byL();
        int count = byL.getCount();
        String str2 = "";
        if (count > 0) {
            byL.moveToFirst();
            i iVar = new i();
            iVar.b(byL);
            try {
                str = ((bko) new bko().aH(iVar.field_curActionBuf)).wNo;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
            byL.close();
            bVar.rYb = count;
            bVar.rYa = str;
            return bVar;
        }
        str = str2;
        byL.close();
        bVar.rYb = count;
        bVar.rYa = str;
        return bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString());
    }

    public final void g(String str, boolean z, int i) {
        this.rSb.a(1, str, z, i);
    }

    public final void h(String str, boolean z, int i) {
        this.rSb.b(1, str, z, i);
    }
}
