package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.mm.f.a.fm;
import com.tencent.mm.f.a.mf;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.y.s;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class c implements com.tencent.mm.sdk.e.m.b {
    private static final String TAG = TAG;
    public static final b pCl = new b();
    final Context context;
    private final ag handler = new ag();
    private final LinkedList<String> pCg = new LinkedList();
    public final HashMap<String, String> pCh = new HashMap();
    public final i pCi = new i(this);
    public final g pCj = new g(this);
    final c pCk;

    public static final class f implements d {
        final /* synthetic */ c pCp;
        final /* synthetic */ String pCv;
        final /* synthetic */ long pCw;

        f(c cVar, String str, long j) {
            this.pCp = cVar;
            this.pCv = str;
            this.pCw = j;
        }

        public final void a(boolean z, boolean z2, String str, String str2) {
            b bVar;
            if (z) {
                boolean contains;
                Object h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                h = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(str);
                b.c.b.e.h(h, "contact");
                if (h.AV() > 0) {
                    s.p(h);
                }
                c.bX(str, 1);
                Iterable<Object> a = this.pCp.pCg;
                b.c.b.e.i(a, "$receiver");
                if (a instanceof Collection) {
                    contains = ((Collection) a).contains(str);
                } else {
                    int indexOf;
                    b.c.b.e.i(a, "$receiver");
                    if (a instanceof List) {
                        indexOf = ((List) a).indexOf(str);
                    } else {
                        indexOf = 0;
                        for (Object h2 : a) {
                            if (b.c.b.e.h((Object) str, h2)) {
                                break;
                            }
                            indexOf++;
                        }
                        indexOf = -1;
                    }
                    contains = indexOf >= 0;
                }
                if (contains) {
                    Collection a2 = this.pCp.pCg;
                    if (a2 == null) {
                        throw new b.i("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                    }
                    b.c.b.m.cE(a2).remove(str);
                }
                bVar = c.pCl;
                x.d(c.TAG, "addContact %s return ok", this.pCv);
            } else if (z2) {
                if (!(str == null || this.pCp.pCg.contains(str))) {
                    this.pCp.pCg.add(str);
                }
                c.bX(str, 2);
                bVar = c.pCl;
                x.d(c.TAG, "addContact has sent verify to %s", this.pCv);
            } else {
                bVar = c.pCl;
                x.d(c.TAG, "addContact return not ok, user canceled or error");
            }
            this.pCp.handler.post(new h(this.pCp, z, z2, str2, str, this.pCw));
        }
    }

    static final class j implements Runnable {
        final /* synthetic */ com.tencent.mm.storage.x pCD;
        final /* synthetic */ c pCp;

        j(c cVar, com.tencent.mm.storage.x xVar) {
            this.pCp = cVar;
            this.pCD = xVar;
        }

        public final void run() {
            this.pCp.pCk.I(this.pCD);
        }
    }

    static final class k implements Runnable {
        final /* synthetic */ com.tencent.mm.storage.x pCD;
        final /* synthetic */ c pCp;

        k(c cVar, com.tencent.mm.storage.x xVar) {
            this.pCp = cVar;
            this.pCD = xVar;
        }

        public final void run() {
            this.pCp.pCk.J(this.pCD);
        }
    }

    public static final class m implements d {
        final /* synthetic */ String pCE;
        final /* synthetic */ c pCp;
        final /* synthetic */ long pCw;

        public m(c cVar, String str, long j) {
            this.pCp = cVar;
            this.pCE = str;
            this.pCw = j;
        }

        public final void a(boolean z, boolean z2, String str, String str2) {
            boolean z3;
            b bVar;
            if (z) {
                Object h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                com.tencent.mm.storage.x Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(str);
                if (Xv == null || Xv.AV() == 0) {
                    com.tencent.mm.storage.x a = c.a(com.tencent.mm.storage.au.d.Yb(this.pCE));
                    h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                    b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                    if (!((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().S(a)) {
                        bVar = c.pCl;
                        x.e(c.TAG, "canAddContact fail, insert fail");
                        z = false;
                    }
                    h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
                    b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                    Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(a.getUsername());
                }
                b bVar2 = c.pCl;
                x.d(c.TAG, "verifyContact return ok");
                s.p(Xv);
                c.bX(str, 1);
                z3 = z;
            } else {
                bVar = c.pCl;
                x.d(c.TAG, "verifyContact return not ok");
                z3 = z;
            }
            this.pCp.handler.post(new l(this.pCp, z3, str2, str, this.pCw));
        }
    }

    public static final class i extends com.tencent.mm.sdk.b.c<mf> {
        final /* synthetic */ c pCp;

        i(c cVar) {
            this.pCp = cVar;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mf mfVar = (mf) bVar;
            b.c.b.e.i(mfVar, "event");
            String str = mfVar.fEI.fEK;
            com.tencent.mm.storage.x a = c.a(com.tencent.mm.storage.au.d.Yb(str));
            this.pCp.H(a);
            c cVar = this.pCp;
            b.c.b.e.h((Object) str, "msgContent");
            c.a(cVar, a, str);
            Object h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
            b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
            ar Ff = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff();
            if (!Ff.Xx(a.vZ())) {
                Ff.R(a);
            }
            b bVar2 = c.pCl;
            x.d(c.TAG, "receive verify mssage %s, encypt %s", a.getUsername(), a.vZ());
            this.pCp.handler.post(new k(this.pCp, a));
            return false;
        }
    }

    public final class a implements com.tencent.mm.ad.e {
        String jPV;
        final LinkedList<String> pCm = new LinkedList();
        LinkedList<Integer> pCn;
        private final d pCo;

        public a(d dVar) {
            this.pCo = dVar;
        }

        public final void onStart() {
            com.tencent.mm.kernel.g.CN().a(30, (com.tencent.mm.ad.e) this);
        }

        private final void b(boolean z, boolean z2, String str, String str2) {
            com.tencent.mm.kernel.g.CN().b(30, (com.tencent.mm.ad.e) this);
            d dVar = this.pCo;
            if (dVar != null) {
                dVar.a(z, z2, str, str2);
            }
        }

        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
            b.c.b.e.i(kVar, "scene");
            b bVar = c.pCl;
            x.d(c.TAG, "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (kVar.getType() != 30) {
                bVar = c.pCl;
                x.w(c.TAG, "not expected scene,  type = " + kVar.getType());
                return;
            }
            if (((o) kVar).bZg() == 2) {
                if (i == 0 && i2 == 0) {
                    b(false, true, this.jPV, "");
                    return;
                } else if (i == 4 && i2 == -34) {
                    str = c.this.context.getString(com.tencent.mm.plugin.radar.a.f.eix);
                } else if (i == 4 && i2 == -94) {
                    str = c.this.context.getString(com.tencent.mm.plugin.radar.a.f.eiy);
                } else if (i != 4 || (!(i2 == -24 || i2 == XWalkUpdater.ERROR_SET_VERNUM) || str == null)) {
                    str = c.this.context.getString(com.tencent.mm.plugin.radar.a.f.eKq);
                }
            } else if (i == 0 && i2 == 0) {
                b(true, false, this.jPV, "");
                return;
            } else if (i2 == -44) {
                com.tencent.mm.kernel.g.CN().d((com.tencent.mm.ad.k) new o(2, this.pCm, this.pCn, "", ""));
                return;
            } else if (i2 == -87) {
                b(false, false, this.jPV, c.this.context.getString(com.tencent.mm.plugin.radar.a.f.dUK));
                return;
            } else if (i2 == -24 && !bi.oN(str)) {
                String str2 = this.jPV;
                if (str == null) {
                    str = "";
                }
                b(false, false, str2, str);
                return;
            } else if (i == 4 && i2 == -22) {
                str = c.this.context.getString(com.tencent.mm.plugin.radar.a.f.lud);
            } else {
                str = c.this.context.getString(com.tencent.mm.plugin.radar.a.f.luc);
            }
            b(false, false, this.jPV, str);
        }
    }

    public interface c {
        void I(com.tencent.mm.storage.x xVar);

        void J(com.tencent.mm.storage.x xVar);

        void a(boolean z, String str, String str2, long j);

        void a(boolean z, boolean z2, String str, String str2, long j);
    }

    public static final class g implements com.tencent.mm.y.bt.a {
        final /* synthetic */ c pCp;
        private final String pCx = ".sysmsg.addcontact.type";
        private final String pCy = ".sysmsg.addcontact.username";
        private final String pCz = ".sysmsg.addcontact.encryptusername";

        g(c cVar) {
            this.pCp = cVar;
        }

        public final void a(com.tencent.mm.ad.d.a aVar) {
            b.c.b.e.i(aVar, "addMsgInfo");
            Map y = bj.y(n.a(aVar.hoa.vNO), "sysmsg");
            if (y != null && b.c.b.e.h((String) y.get(this.pCx), (Object) "1")) {
                int i;
                b bVar;
                String str = (String) y.get(this.pCy);
                String str2 = (String) y.get(this.pCz);
                CharSequence charSequence = str;
                if (charSequence == null || b.f.g.Y(charSequence)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    charSequence = str2;
                    i = (charSequence == null || b.f.g.Y(charSequence)) ? 1 : 0;
                    if (i == 0) {
                        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
                        xVar.setUsername(str);
                        xVar.di(str2);
                        this.pCp.I(xVar);
                        bVar = c.pCl;
                        x.d(c.TAG, "receive contact added system message useranme %s, encypt %s", xVar.getUsername(), xVar.vZ());
                        return;
                    }
                }
                bVar = c.pCl;
                x.e(c.TAG, "error! server return incorrect content! : %s", r5);
            }
        }
    }

    static final class h implements Runnable {
        final /* synthetic */ boolean pCA;
        final /* synthetic */ boolean pCB;
        final /* synthetic */ String pCC;
        final /* synthetic */ c pCp;
        final /* synthetic */ String pCv;
        final /* synthetic */ long pCw;

        h(c cVar, boolean z, boolean z2, String str, String str2, long j) {
            this.pCp = cVar;
            this.pCA = z;
            this.pCB = z2;
            this.pCC = str;
            this.pCv = str2;
            this.pCw = j;
        }

        public final void run() {
            this.pCp.pCk.a(this.pCA, this.pCB, this.pCC, this.pCv, this.pCw);
        }
    }

    public enum e {
        Stranger,
        Verifying,
        Added,
        NeedVerify
    }

    static final class l implements Runnable {
        final /* synthetic */ boolean pCA;
        final /* synthetic */ String pCC;
        final /* synthetic */ c pCp;
        final /* synthetic */ String pCv;
        final /* synthetic */ long pCw;

        l(c cVar, boolean z, String str, String str2, long j) {
            this.pCp = cVar;
            this.pCA = z;
            this.pCC = str;
            this.pCv = str2;
            this.pCw = j;
        }

        public final void run() {
            this.pCp.pCk.a(this.pCA, this.pCC, this.pCv, this.pCw);
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public interface d {
        void a(boolean z, boolean z2, String str, String str2);
    }

    public c(c cVar, Context context) {
        b.c.b.e.i(cVar, "delegate");
        b.c.b.e.i(context, "context");
        this.pCk = cVar;
        this.context = context;
    }

    public static final /* synthetic */ com.tencent.mm.storage.x a(com.tencent.mm.storage.au.d dVar) {
        com.tencent.mm.storage.x xVar = new com.tencent.mm.storage.x();
        if (dVar != null) {
            xVar.setUsername(dVar.cky());
            xVar.di(dVar.ckB());
            xVar.cZ(dVar.vU());
            xVar.dc(dVar.vW());
            xVar.dd(dVar.vX());
            xVar.de(dVar.vY());
            xVar.eD(dVar.ckz());
            xVar.dp(dVar.ckA());
            xVar.dq(dVar.getProvince());
            xVar.dr(dVar.getCity());
        } else {
            x.e(TAG, "verify is null! must be parsed error before!");
        }
        return xVar;
    }

    public static final /* synthetic */ void a(c cVar, com.tencent.mm.storage.x xVar, String str) {
        cVar.pCh.put(xVar.getUsername(), str);
        cVar.pCh.put(xVar.vZ(), str);
    }

    public static final /* synthetic */ void bX(String str, int i) {
        fm fmVar = new fm();
        fmVar.fvE.fvG = 0;
        fmVar.fvE.talker = str;
        fmVar.fvE.state = i;
        com.tencent.mm.sdk.b.a.xmy.m(fmVar);
    }

    public final long ID(String str) {
        b.c.b.e.i(str, "username");
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = new a(new f(this, str, currentTimeMillis));
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(48));
        boolean z = str != null && str.length() > 0;
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        aVar.onStart();
        aVar.pCn = linkedList;
        aVar.jPV = str;
        if (str != null) {
            aVar.pCm.add(str);
        }
        com.tencent.mm.kernel.g.CN().d((com.tencent.mm.ad.k) new o(2, aVar.pCm, linkedList, "", ""));
        return currentTimeMillis;
    }

    public final e IE(String str) {
        e eVar;
        b.c.b.e.i(str, "username");
        Object h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
        b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
        com.tencent.mm.storage.x Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(str);
        if (Xv == null || Xv.AV() == 0) {
            if (this.pCg.contains(str)) {
                eVar = e.Verifying;
            } else {
                eVar = e.Stranger;
            }
        } else if (Xv.AJ()) {
            eVar = e.Added;
        } else if (this.pCh.containsKey(str)) {
            eVar = e.NeedVerify;
        } else if (this.pCg.contains(str)) {
            eVar = e.Verifying;
        } else {
            eVar = e.Stranger;
        }
        x.d(TAG, "query username(%s) status %s", str, eVar);
        return eVar;
    }

    private final void H(com.tencent.mm.storage.x xVar) {
        if (this.pCg.contains(xVar.getUsername())) {
            this.pCg.remove(xVar.getUsername());
        }
        if (this.pCg.contains(xVar.vZ())) {
            this.pCg.remove(xVar.vZ());
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        b.c.b.e.i(mVar, "stg");
        x.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
        if (obj == null || !(obj instanceof String)) {
            x.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        String str = (String) obj;
        Object h = com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class);
        b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
        com.tencent.mm.storage.x Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) h).Ff().Xv(str);
        if (Xv != null && Xv.AJ()) {
            x.d(TAG, "ContactStg onNotifyChange %s", str);
            I(Xv);
        }
    }

    private final void I(com.tencent.mm.storage.x xVar) {
        H(xVar);
        this.pCh.remove(xVar.getUsername());
        this.pCh.remove(xVar.vZ());
        this.handler.post(new j(this, xVar));
    }
}
