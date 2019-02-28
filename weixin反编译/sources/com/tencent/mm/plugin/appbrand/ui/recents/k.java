package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.q;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class k extends v {
    boolean jWC = false;
    boolean jWD = true;
    private final android.support.v7.widget.RecyclerView.e.a jWE = new android.support.v7.widget.RecyclerView.e.a() {
        public final void fT() {
            for (android.support.v7.widget.RecyclerView.e.a fT : k.this.jWF) {
                fT.fT();
            }
            k.this.jWV = false;
        }
    };
    final Set<android.support.v7.widget.RecyclerView.e.a> jWF = new HashSet();
    private final Interpolator jWG = new AccelerateDecelerateInterpolator();
    private final ArrayList<b> jWH = new ArrayList();
    final ArrayList<t> jWI = new ArrayList();
    private final ArrayList<d> jWJ = new ArrayList();
    final ArrayList<t> jWK = new ArrayList();
    private final ArrayList<d> jWL = new ArrayList();
    final ArrayList<d> jWM = new ArrayList();
    private final ArrayList<d> jWN = new ArrayList();
    final ArrayList<d> jWO = new ArrayList();
    private final ArrayList<f> jWP = new ArrayList();
    final ArrayList<d> jWQ = new ArrayList();
    private final ArrayList<t> jWR = new ArrayList();
    private final ArrayList<d> jWS = new ArrayList();
    final ArrayList<d> jWT = new ArrayList();
    final ArrayList<d> jWU = new ArrayList();
    boolean jWV = false;

    private static final class d extends g {
        d(d dVar, int i, int i2) {
            super(dVar, i, i2);
        }
    }

    private static final class e extends a {
        private e() {
            super();
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    private static class f {
        int Rn;
        int Ro;
        d jWY;

        /* synthetic */ f(d dVar, int i, int i2, byte b) {
            this(dVar, i, i2);
        }

        private f(d dVar, int i, int i2) {
            this.jWY = dVar;
            this.Rn = i;
            this.Ro = i2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.k$8 */
    class AnonymousClass8 extends an {
        final /* synthetic */ ai Re;
        final /* synthetic */ d jWX;

        AnonymousClass8(d dVar, ai aiVar) {
            this.jWX = dVar;
            this.Re = aiVar;
        }

        public final void p(View view) {
        }

        public final void ar(View view) {
            if (view != null) {
                z.c(view, 0.0f);
                z.d(view, 1.0f);
            }
        }

        public final void q(View view) {
            this.Re.a(null);
            k.this.k(this.jWX);
            k.this.jWU.remove(this.jWX);
            k.a(k.this);
        }
    }

    private static class a extends android.support.v7.widget.RecyclerView.e.c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final android.support.v7.widget.RecyclerView.e.c b(t tVar, int i) {
            super.b(tVar, i);
            this.UZ = i;
            return this;
        }

        final boolean amk() {
            return (this.UZ & 2048) > 0;
        }
    }

    private static class g {
        int Rn;
        int Ro;
        d jWY;

        g(d dVar, int i, int i2) {
            this.jWY = dVar;
            this.Rn = i;
            this.Ro = i2;
        }
    }

    private static final class b extends g {
        b(d dVar, int i, int i2) {
            super(dVar, i, i2);
        }
    }

    private static final class c extends a {
        private c() {
            super();
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    k() {
    }

    static /* synthetic */ void a(k kVar) {
        if (!kVar.isRunning()) {
            kVar.fS();
        }
    }

    final void b(android.support.v7.widget.RecyclerView.e.a aVar) {
        if (aVar != null) {
            this.jWF.add(aVar);
        }
    }

    final void c(android.support.v7.widget.RecyclerView.e.a aVar) {
        if (aVar != null) {
            this.jWF.remove(aVar);
        }
    }

    private void e(t tVar) {
        android.support.v4.a.a.v(tVar.VU);
        d(tVar);
        z.c(tVar.VU, 0.0f);
        z.d(tVar.VU, 1.0f);
    }

    public final boolean isRunning() {
        return (this.jWH.isEmpty() && this.jWI.isEmpty() && this.jWJ.isEmpty() && this.jWK.isEmpty() && this.jWL.isEmpty() && this.jWM.isEmpty() && this.jWN.isEmpty() && this.jWO.isEmpty() && this.jWP.isEmpty() && this.jWQ.isEmpty() && this.jWS.isEmpty() && this.jWT.isEmpty() && this.jWU.isEmpty() && !super.isRunning()) ? false : true;
    }

    public final void eJ() {
        Iterator it;
        final ai U;
        final d dVar;
        final ai U2;
        a(this.jWE);
        if (!this.jWH.isEmpty()) {
            it = this.jWH.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                this.jWI.add(bVar.jWY);
                final t tVar = bVar.jWY;
                View view = bVar.jWY.VU;
                bVar.jWY.jVl.setVisibility(0);
                z.c(view, 0.0f);
                U = z.U(view);
                U.d(Math.max(this.UX, Math.min(Math.round((((double) bVar.Ro) / ((double) bVar.jWY.VU.getHeight())) * ((double) this.UX)) + this.UX, 400)));
                U.b(this.jWG);
                U.a(new an() {
                    public final void p(View view) {
                        ((RecentsRecyclerView) view.getParent()).bN(view);
                        k.this.z(tVar);
                    }

                    public final void q(View view) {
                        if (view != null) {
                            ((RecentsRecyclerView) view.getParent()).bO(view);
                            U.a(null);
                            z.c(view, 0.0f);
                            k.this.k(tVar);
                            k.this.jWI.remove(tVar);
                            k.a(k.this);
                        }
                    }

                    public final void ar(View view) {
                        if (view != null) {
                            z.c(view, 0.0f);
                            z.d(view, 1.0f);
                        }
                    }
                });
                U.s((float) ((-bVar.Ro) - view.getHeight())).start();
            }
            this.jWH.clear();
        }
        if (!this.jWJ.isEmpty()) {
            Iterator it2 = this.jWJ.iterator();
            while (it2.hasNext()) {
                d dVar2 = (d) it2.next();
                this.jWK.add(dVar2.jWY);
                final t tVar2 = dVar2.jWY;
                View view2 = dVar2.jWY.VU;
                RecentsRecyclerView recentsRecyclerView = (RecentsRecyclerView) view2.getParent();
                dVar2.jWY.jVl.setVisibility(8);
                z.c(view2, 0.0f);
                U = z.U(view2);
                U.d(this.UX);
                U.a(new an() {
                    public final void p(View view) {
                        ((RecentsRecyclerView) view.getParent()).bN(view);
                        k.this.z(tVar2);
                    }

                    public final void q(View view) {
                        if (view != null) {
                            ((RecentsRecyclerView) view.getParent()).bO(view);
                            U.a(null);
                            z.c(view, 0.0f);
                            k.this.k(tVar2);
                            k.this.jWK.remove(tVar2);
                            k.a(k.this);
                        }
                    }

                    public final void ar(View view) {
                        if (view != null) {
                            z.c(view, 0.0f);
                            z.d(view, 1.0f);
                        }
                    }
                });
                U.s((float) (recentsRecyclerView.getHeight() - dVar2.Ro)).start();
            }
            this.jWJ.clear();
        }
        if (!this.jWL.isEmpty()) {
            it = this.jWL.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                this.jWM.add(dVar);
                z.e(dVar.jVl, 0.1f);
                z.f(dVar.jVl, 0.1f);
                z.d(dVar.jVl, 0.0f);
                dVar.jVl.setVisibility(0);
                U2 = z.U(dVar.jVl);
                U2.d(this.UY);
                U2.a(new an() {
                    public final void p(View view) {
                    }

                    public final void q(View view) {
                        U2.a(null);
                        k.this.k(dVar);
                        k.this.jWM.remove(dVar);
                        k.a(k.this);
                    }

                    public final void ar(View view) {
                        if (view != null) {
                            z.c(view, 0.0f);
                            z.d(view, 1.0f);
                        }
                    }
                });
                U2.q(1.0f).t(1.0f).u(1.0f).start();
            }
            this.jWL.clear();
        }
        if (!this.jWN.isEmpty()) {
            it = this.jWN.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                this.jWO.add(dVar);
                z.e(dVar.jVl, 1.0f);
                z.f(dVar.jVl, 1.0f);
                z.d(dVar.jVl, 1.0f);
                dVar.jVl.setVisibility(0);
                U2 = z.U(dVar.jVl);
                U2.d(this.UY);
                U2.a(new an() {
                    public final void p(View view) {
                    }

                    public final void q(View view) {
                        z.e(dVar.jVl, 1.0f);
                        z.f(dVar.jVl, 1.0f);
                        z.d(dVar.jVl, 1.0f);
                        dVar.jVl.setVisibility(8);
                        k.this.k(dVar);
                        k.this.jWO.remove(dVar);
                        k.a(k.this);
                    }
                });
                U2.q(0.0f).t(0.1f).u(0.1f).start();
            }
            this.jWN.clear();
        }
        if (!this.jWP.isEmpty()) {
            it = this.jWP.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                this.jWQ.add(fVar.jWY);
                View view3 = fVar.jWY.VU;
                z.c(view3, 0.0f);
                z.d(view3, 1.0f);
                dVar = fVar.jWY;
                ai U3 = z.U(view3);
                U3.d(this.UX);
                U3.a(new an() {
                    public final void p(View view) {
                        k.this.z(dVar);
                    }

                    public final void q(View view) {
                        z.c(view, 0.0f);
                        z.d(view, 1.0f);
                        k.this.k(dVar);
                        k.this.jWQ.remove(dVar);
                        k.a(k.this);
                    }
                });
                U3.q(0.0f).s((float) (-view3.getHeight())).start();
            }
            this.jWP.clear();
        }
        super.eJ();
        if (!this.jWS.isEmpty()) {
            this.jWT.addAll(this.jWS);
            Runnable anonymousClass7 = new Runnable() {
                public final void run() {
                    Iterator it = k.this.jWT.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        android.support.v7.widget.RecyclerView.e eVar = k.this;
                        ai U = z.U(dVar.VU);
                        eVar.jWU.add(dVar);
                        U.s(0.0f).d(eVar.UX).a(new AnonymousClass8(dVar, U)).start();
                    }
                    k.this.jWT.clear();
                }
            };
            this.jWS.clear();
            if (this.jWV) {
                z.a(((d) this.jWT.get(0)).VU, anonymousClass7, this.UW);
            } else {
                anonymousClass7.run();
            }
        }
    }

    public final void z(t tVar) {
        super.z(tVar);
        if (!this.jWQ.contains(tVar)) {
            this.jWV = true;
        }
    }

    public final boolean a(t tVar, int i, int i2, int i3, int i4) {
        if ((tVar instanceof d) && this.jWD) {
            return super.a(tVar, i, i2, i3, i4);
        }
        e(tVar);
        y(tVar);
        return false;
    }

    public final boolean c(t tVar) {
        e(tVar);
        k(tVar);
        return false;
    }

    public final void d(t tVar) {
        if ((tVar instanceof d) && this.jWS.remove(tVar)) {
            z.c(tVar.VU, 0.0f);
            k(tVar);
        }
        super.d(tVar);
    }

    public final boolean e(t tVar, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (!this.jWD) {
            return c(tVar);
        }
        if (cVar == null || (cVar.left == cVar2.left && cVar.top == cVar2.top)) {
            if (this.jWC && (tVar.VU.getParent() instanceof RecyclerView) && (tVar instanceof d)) {
                RecyclerView recyclerView = (RecyclerView) tVar.VU.getParent();
                if (recyclerView.getHeight() > 0) {
                    d dVar;
                    if (cVar2.bottom >= recyclerView.getHeight()) {
                        dVar = (d) tVar;
                        z.c(dVar.VU, (float) dVar.VU.getHeight());
                        this.jWS.add(dVar);
                        return true;
                    } else if (cVar2.top <= 0) {
                        dVar = (d) tVar;
                        z.c(dVar.VU, (float) (-dVar.VU.getHeight()));
                        this.jWS.add(dVar);
                        return true;
                    }
                }
            }
            return c(tVar);
        }
        return super.a(tVar, cVar.left, cVar.top, cVar2.left, cVar2.top);
    }

    public final boolean d(t tVar, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (!this.jWD) {
            e(tVar);
            k(tVar);
            return false;
        } else if (cVar instanceof c) {
            e(tVar);
            this.jWH.add(new b((d) tVar, cVar.left, cVar.top));
            return true;
        } else if (cVar instanceof e) {
            e(tVar);
            this.jWJ.add(new d((d) tVar, cVar.left, cVar.top));
            return true;
        } else {
            if ((cVar.UZ & 2048) > 0 && (tVar instanceof d) && cVar2 == null) {
                boolean z;
                try {
                    z = ((d) tVar).ama().iMQ;
                } catch (Exception e) {
                    z = false;
                }
                if (!z) {
                    e(tVar);
                    this.jWP.add(new f((d) tVar, cVar.left, cVar.top, (byte) 0));
                    return true;
                }
            }
            return super.d(tVar, cVar, cVar2);
        }
    }

    public final boolean b(t tVar) {
        if (this.jWD) {
            return super.b(tVar);
        }
        e(tVar);
        k(tVar);
        return false;
    }

    public final boolean a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        if (z.U(tVar.VU) == null) {
            z.d(tVar.VU, 1.0f);
            z.c(tVar.VU, 0.0f);
        }
        if (z.U(tVar2.VU) == null) {
            z.d(tVar2.VU, 1.0f);
            z.c(tVar2.VU, 0.0f);
        }
        k(tVar);
        k(tVar2);
        return false;
    }

    public final boolean f(t tVar, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (this.jWD) {
            return super.f(tVar, cVar, cVar2);
        }
        e(tVar);
        y(tVar);
        return false;
    }

    public final void l(t tVar) {
        super.l(tVar);
        ViewParent parent = tVar.VU.getParent();
        if (parent instanceof RecentsRecyclerView) {
            ((RecentsRecyclerView) parent).bO(tVar.VU);
        }
    }

    public final void A(t tVar) {
        super.A(tVar);
        if (this.jWR.contains(tVar)) {
            ((RecentsRecyclerView) tVar.VU.getParent()).bN(tVar.VU);
        }
    }

    public final void B(t tVar) {
        super.B(tVar);
        if (this.jWR.contains(tVar)) {
            this.jWR.remove(tVar);
            ((RecentsRecyclerView) tVar.VU.getParent()).bO(tVar.VU);
        }
    }

    public final android.support.v7.widget.RecyclerView.e.c a(q qVar, t tVar, int i, List<Object> list) {
        if ((i & 2) > 0) {
            for (Object next : list) {
                if (next instanceof Bundle) {
                    Boolean bool = (Boolean) ((Bundle) next).get("star");
                    if (bool != null && bool.booleanValue()) {
                        return new c().b(tVar, i);
                    }
                    if (!(bool == null || bool.booleanValue())) {
                        return new e().b(tVar, i);
                    }
                }
            }
        }
        android.support.v7.widget.RecyclerView.e.c a = super.a(qVar, tVar, i, (List) list);
        a.UZ = i;
        return a;
    }

    public final boolean a(t tVar, t tVar2, android.support.v7.widget.RecyclerView.e.c cVar, android.support.v7.widget.RecyclerView.e.c cVar2) {
        if (!this.jWD) {
            k(tVar);
            k(tVar2);
            return false;
        } else if (cVar instanceof c) {
            if (((c) cVar).amk()) {
                ((d) tVar2).jVl.setVisibility(0);
                ((d) tVar2).jVl.invalidate();
                ((RecentsRecyclerView) tVar2.VU.getParent()).bN(tVar2.VU);
                this.jWR.add(tVar2);
                return super.a(tVar2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(tVar2);
            this.jWL.add((d) tVar2);
            return true;
        } else if (!(cVar instanceof e)) {
            return super.a(tVar, tVar2, cVar, cVar2);
        } else {
            if (((e) cVar).amk()) {
                ((d) tVar2).jVl.setVisibility(8);
                return super.a(tVar2, cVar.left, cVar.top, cVar2.left, cVar2.top);
            }
            e(tVar2);
            this.jWN.add((d) tVar2);
            return true;
        }
    }

    public final boolean a(t tVar, List<Object> list) {
        return (tVar instanceof d) || super.a(tVar, (List) list);
    }
}
