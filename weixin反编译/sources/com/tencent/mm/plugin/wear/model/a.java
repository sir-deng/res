package com.tencent.mm.plugin.wear.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.c;
import com.tencent.mm.bx.h;
import com.tencent.mm.plugin.wear.model.e.e;
import com.tencent.mm.plugin.wear.model.e.f;
import com.tencent.mm.plugin.wear.model.e.g;
import com.tencent.mm.plugin.wear.model.e.k;
import com.tencent.mm.plugin.wear.model.e.l;
import com.tencent.mm.plugin.wear.model.e.m;
import com.tencent.mm.plugin.wear.model.e.n;
import com.tencent.mm.plugin.wear.model.e.o;
import com.tencent.mm.plugin.wear.model.e.q;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.g.b;
import com.tencent.mm.pluginsdk.q.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.util.HashMap;

public final class a implements ap {
    q toi;
    public r toj;
    public d tok;
    private e tol;
    public g tom;
    public b ton;
    private WearMessageLogic too;
    private i toq;
    public j tor;
    public com.tencent.mm.plugin.wear.model.g.a tos;
    private d tot;

    public a() {
        x.i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", getClass().getClassLoader());
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public static a bPh() {
        as.Hg();
        a aVar = (a) bq.ib("plugin.wear");
        if (aVar != null) {
            return aVar;
        }
        Object aVar2 = new a();
        as.Hg().a("plugin.wear", aVar2);
        return aVar2;
    }

    public final void ge(int i) {
        x.i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", Integer.valueOf(i));
    }

    public final void bs(boolean z) {
        aa.vjm = new c();
        x.i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", Boolean.valueOf(z));
        this.toi = new q();
        this.toj = new r();
        this.tor = new j();
        this.tol = new e();
        this.tom = new g();
        this.ton = new b();
        this.tok = new d();
        this.too = new WearMessageLogic();
        this.toq = new i();
        this.tos = new com.tencent.mm.plugin.wear.model.g.a();
        this.tot = new b();
        c.a(Integer.valueOf(63), this.tot);
        this.toi.a(this.tok.toB);
        this.toi.a(this.tok.toC);
        this.toi.a(this.tok.toD);
        this.toi.a(new com.tencent.mm.plugin.wear.model.e.h());
        this.toi.a(new g());
        this.toi.a(new com.tencent.mm.plugin.wear.model.e.d());
        this.toi.a(new com.tencent.mm.plugin.wear.model.e.c());
        this.toi.a(new e());
        this.toi.a(new f());
        this.toi.a(new k());
        this.toi.a(new m());
        this.toi.a(new o());
        this.toi.a(new n());
        this.toi.a(new l());
        this.tor.a(new com.tencent.mm.plugin.wear.model.f.c() {
            protected final void send() {
                r.a(CdnLogic.kMediaTypeBackupFile, null, false);
                r.a(20008, null, false);
            }

            public final String getName() {
                return "PhoneStartTask";
            }
        });
        j jVar = this.tor;
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.wear.model.f.c() {
            protected final void send() {
                if (a.this.tok.bPn() != null) {
                    a.this.tok.bPn().bPt();
                }
                r.a(20009, null, false);
                r.a(20017, null, false);
            }

            public final String getName() {
                return "SyncFileTask";
            }
        };
        if (jVar.jFp != null) {
            jVar.jFp.sendMessageDelayed(jVar.jFp.obtainMessage(0, anonymousClass2), 5000);
        }
    }

    public final void bt(boolean z) {
        x.i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", Boolean.valueOf(z));
    }

    public final void onAccountRelease() {
        c.b(Integer.valueOf(63), this.tot);
        this.tot = null;
        x.i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.toi.tpE.clear();
        this.toi = null;
        this.toj = null;
        e eVar = this.tol;
        eVar.ind.TN();
        eVar.rOm.dead();
        eVar.toH.dead();
        eVar.toI.dead();
        eVar.toJ.dead();
        eVar.toK.dead();
        eVar.toL.dead();
        eVar.toM.dead();
        eVar.gBo.dead();
        eVar.ojq.dead();
        as.Hm();
        com.tencent.mm.y.c.Fh().a(eVar.mfj);
        this.tol = null;
        this.tom = null;
        b bVar = this.ton;
        com.tencent.mm.sdk.b.a.xmy.c(bVar.tow);
        as.Hm();
        com.tencent.mm.y.c.Ff().b(bVar.mSw);
        bVar.tox.TN();
        this.ton = null;
        d dVar = this.tok;
        dVar.toA.finish();
        dVar.toE.reset();
        this.tok = null;
        ad.getContext().unregisterReceiver(this.too);
        this.too = null;
        j jVar = this.tor;
        if (jVar.handlerThread != null) {
            jVar.handlerThread.quit();
        }
        this.tor = null;
        i iVar = this.toq;
        iVar.gDM = null;
        iVar.bPo();
        ad.getContext().unregisterReceiver(iVar.tpf);
        this.toq = null;
    }
}
