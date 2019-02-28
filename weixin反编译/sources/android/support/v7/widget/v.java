package android.support.v7.widget;

import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends aj {
    private ArrayList<t> QO = new ArrayList();
    private ArrayList<t> QP = new ArrayList();
    private ArrayList<b> QQ = new ArrayList();
    private ArrayList<a> QR = new ArrayList();
    ArrayList<ArrayList<t>> QS = new ArrayList();
    ArrayList<ArrayList<b>> QT = new ArrayList();
    ArrayList<ArrayList<a>> QU = new ArrayList();
    ArrayList<t> QV = new ArrayList();
    ArrayList<t> QW = new ArrayList();
    ArrayList<t> QX = new ArrayList();
    ArrayList<t> QY = new ArrayList();

    /* renamed from: android.support.v7.widget.v$5 */
    class AnonymousClass5 extends c {
        final /* synthetic */ t Rd;
        final /* synthetic */ ai Re;

        AnonymousClass5(t tVar, ai aiVar) {
            this.Rd = tVar;
            this.Re = aiVar;
            super();
        }

        public final void p(View view) {
        }

        public final void ar(View view) {
            z.d(view, 1.0f);
        }

        public final void q(View view) {
            this.Re.a(null);
            v.this.k(this.Rd);
            v.this.QV.remove(this.Rd);
            v.this.eK();
        }
    }

    private static class c implements am {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public void p(View view) {
        }

        public void q(View view) {
        }

        public void ar(View view) {
        }
    }

    /* renamed from: android.support.v7.widget.v$6 */
    class AnonymousClass6 extends c {
        final /* synthetic */ t Rd;
        final /* synthetic */ ai Re;
        final /* synthetic */ int Rf;
        final /* synthetic */ int Rg;

        AnonymousClass6(t tVar, int i, int i2, ai aiVar) {
            this.Rd = tVar;
            this.Rf = i;
            this.Rg = i2;
            this.Re = aiVar;
            super();
        }

        public final void p(View view) {
            v.this.A(this.Rd);
        }

        public final void ar(View view) {
            if (this.Rf != 0) {
                z.b(view, 0.0f);
            }
            if (this.Rg != 0) {
                z.c(view, 0.0f);
            }
        }

        public final void q(View view) {
            this.Re.a(null);
            v.this.y(this.Rd);
            v.this.QW.remove(this.Rd);
            v.this.eK();
        }
    }

    /* renamed from: android.support.v7.widget.v$7 */
    class AnonymousClass7 extends c {
        final /* synthetic */ a Rh;
        final /* synthetic */ ai Ri;

        AnonymousClass7(a aVar, ai aiVar) {
            this.Rh = aVar;
            this.Ri = aiVar;
            super();
        }

        public final void p(View view) {
        }

        public final void q(View view) {
            this.Ri.a(null);
            z.d(view, 1.0f);
            z.b(view, 0.0f);
            z.c(view, 0.0f);
            v.this.k(this.Rh.Rl);
            v.this.QY.remove(this.Rh.Rl);
            v.this.eK();
        }
    }

    /* renamed from: android.support.v7.widget.v$8 */
    class AnonymousClass8 extends c {
        final /* synthetic */ a Rh;
        final /* synthetic */ ai Rj;
        final /* synthetic */ View Rk;

        AnonymousClass8(a aVar, ai aiVar, View view) {
            this.Rh = aVar;
            this.Rj = aiVar;
            this.Rk = view;
            super();
        }

        public final void p(View view) {
        }

        public final void q(View view) {
            this.Rj.a(null);
            z.d(this.Rk, 1.0f);
            z.b(this.Rk, 0.0f);
            z.c(this.Rk, 0.0f);
            v.this.k(this.Rh.Rm);
            v.this.QY.remove(this.Rh.Rm);
            v.this.eK();
        }
    }

    private static class a {
        public t Rl;
        public t Rm;
        public int Rn;
        public int Ro;
        public int Rp;
        public int Rq;

        /* synthetic */ a(t tVar, t tVar2, int i, int i2, int i3, int i4, byte b) {
            this(tVar, tVar2, i, i2, i3, i4);
        }

        private a(t tVar, t tVar2) {
            this.Rl = tVar;
            this.Rm = tVar2;
        }

        private a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
            this(tVar, tVar2);
            this.Rn = i;
            this.Ro = i2;
            this.Rp = i3;
            this.Rq = i4;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.Rl + ", newHolder=" + this.Rm + ", fromX=" + this.Rn + ", fromY=" + this.Ro + ", toX=" + this.Rp + ", toY=" + this.Rq + '}';
        }
    }

    private static class b {
        public int Rn;
        public int Ro;
        public int Rp;
        public int Rq;
        public t Rr;

        /* synthetic */ b(t tVar, int i, int i2, int i3, int i4, byte b) {
            this(tVar, i, i2, i3, i4);
        }

        private b(t tVar, int i, int i2, int i3, int i4) {
            this.Rr = tVar;
            this.Rn = i;
            this.Ro = i2;
            this.Rp = i3;
            this.Rq = i4;
        }
    }

    public void eJ() {
        int i;
        int i2;
        int i3;
        int i4 = !this.QO.isEmpty() ? 1 : 0;
        if (this.QQ.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.QR.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.QP.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.QO.iterator();
            while (it.hasNext()) {
                final t tVar = (t) it.next();
                final ai U = z.U(tVar.VU);
                this.QX.add(tVar);
                U.d(this.UW).q(0.0f).a(new c() {
                    public final void p(View view) {
                        v.this.z(tVar);
                    }

                    public final void q(View view) {
                        U.a(null);
                        z.d(view, 1.0f);
                        v.this.k(tVar);
                        v.this.QX.remove(tVar);
                        v.this.eK();
                    }
                }).start();
            }
            this.QO.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.QQ);
                this.QT.add(arrayList);
                this.QQ.clear();
                anonymousClass1 = new Runnable() {
                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            e eVar = v.this;
                            t tVar = bVar.Rr;
                            int i = bVar.Rn;
                            int i2 = bVar.Ro;
                            int i3 = bVar.Rp;
                            int i4 = bVar.Rq;
                            View view = tVar.VU;
                            i = i3 - i;
                            i2 = i4 - i2;
                            if (i != 0) {
                                z.U(view).r(0.0f);
                            }
                            if (i2 != 0) {
                                z.U(view).s(0.0f);
                            }
                            ai U = z.U(view);
                            eVar.QW.add(tVar);
                            U.d(eVar.UX).a(new AnonymousClass6(tVar, i, i2, U)).start();
                        }
                        arrayList.clear();
                        v.this.QT.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    z.a(((b) arrayList.get(0)).Rr.VU, anonymousClass1, this.UW);
                } else {
                    anonymousClass1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.QR);
                this.QU.add(arrayList);
                this.QR.clear();
                anonymousClass1 = new Runnable() {
                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ai d;
                            a aVar = (a) it.next();
                            e eVar = v.this;
                            t tVar = aVar.Rl;
                            View view = tVar == null ? null : tVar.VU;
                            t tVar2 = aVar.Rm;
                            View view2 = tVar2 != null ? tVar2.VU : null;
                            if (view != null) {
                                d = z.U(view).d(eVar.UY);
                                eVar.QY.add(aVar.Rl);
                                d.r((float) (aVar.Rp - aVar.Rn));
                                d.s((float) (aVar.Rq - aVar.Ro));
                                d.q(0.0f).a(new AnonymousClass7(aVar, d)).start();
                            }
                            if (view2 != null) {
                                d = z.U(view2);
                                eVar.QY.add(aVar.Rm);
                                d.r(0.0f).s(0.0f).d(eVar.UY).q(1.0f).a(new AnonymousClass8(aVar, d, view2)).start();
                            }
                        }
                        arrayList.clear();
                        v.this.QU.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    z.a(((a) arrayList.get(0)).Rl.VU, anonymousClass1, this.UW);
                } else {
                    anonymousClass1.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.QP);
                this.QS.add(arrayList2);
                this.QP.clear();
                Runnable anonymousClass3 = new Runnable() {
                    public final void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            t tVar = (t) it.next();
                            e eVar = v.this;
                            ai U = z.U(tVar.VU);
                            eVar.QV.add(tVar);
                            U.q(1.0f).d(eVar.UV).a(new AnonymousClass5(tVar, U)).start();
                        }
                        arrayList2.clear();
                        v.this.QS.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    anonymousClass3.run();
                    return;
                }
                long j;
                long j2;
                long j3 = i4 != 0 ? this.UW : 0;
                if (i != 0) {
                    j = this.UX;
                } else {
                    j = 0;
                }
                if (i2 != 0) {
                    j2 = this.UY;
                } else {
                    j2 = 0;
                }
                z.a(((t) arrayList2.get(0)).VU, anonymousClass3, j3 + Math.max(j, j2));
            }
        }
    }

    public boolean b(t tVar) {
        e(tVar);
        this.QO.add(tVar);
        return true;
    }

    public boolean c(t tVar) {
        e(tVar);
        z.d(tVar.VU, 0.0f);
        this.QP.add(tVar);
        return true;
    }

    public boolean a(t tVar, int i, int i2, int i3, int i4) {
        View view = tVar.VU;
        int Q = (int) (((float) i) + z.Q(tVar.VU));
        int R = (int) (((float) i2) + z.R(tVar.VU));
        e(tVar);
        int i5 = i3 - Q;
        int i6 = i4 - R;
        if (i5 == 0 && i6 == 0) {
            y(tVar);
            return false;
        }
        if (i5 != 0) {
            z.b(view, (float) (-i5));
        }
        if (i6 != 0) {
            z.c(view, (float) (-i6));
        }
        this.QQ.add(new b(tVar, Q, R, i3, i4, (byte) 0));
        return true;
    }

    public boolean a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        if (tVar == tVar2) {
            return a(tVar, i, i2, i3, i4);
        }
        float Q = z.Q(tVar.VU);
        float R = z.R(tVar.VU);
        float G = z.G(tVar.VU);
        e(tVar);
        int i5 = (int) (((float) (i3 - i)) - Q);
        int i6 = (int) (((float) (i4 - i2)) - R);
        z.b(tVar.VU, Q);
        z.c(tVar.VU, R);
        z.d(tVar.VU, G);
        if (tVar2 != null) {
            e(tVar2);
            z.b(tVar2.VU, (float) (-i5));
            z.c(tVar2.VU, (float) (-i6));
            z.d(tVar2.VU, 0.0f);
        }
        this.QR.add(new a(tVar, tVar2, i, i2, i3, i4, (byte) 0));
        return true;
    }

    private void a(List<a> list, t tVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, tVar) && aVar.Rl == null && aVar.Rm == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.Rl != null) {
            a(aVar, aVar.Rl);
        }
        if (aVar.Rm != null) {
            a(aVar, aVar.Rm);
        }
    }

    private boolean a(a aVar, t tVar) {
        if (aVar.Rm == tVar) {
            aVar.Rm = null;
        } else if (aVar.Rl != tVar) {
            return false;
        } else {
            aVar.Rl = null;
        }
        z.d(tVar.VU, 1.0f);
        z.b(tVar.VU, 0.0f);
        z.c(tVar.VU, 0.0f);
        k(tVar);
        return true;
    }

    public void d(t tVar) {
        int size;
        ArrayList arrayList;
        View view = tVar.VU;
        z.U(view).cancel();
        for (size = this.QQ.size() - 1; size >= 0; size--) {
            if (((b) this.QQ.get(size)).Rr == tVar) {
                z.c(view, 0.0f);
                z.b(view, 0.0f);
                y(tVar);
                this.QQ.remove(size);
            }
        }
        a(this.QR, tVar);
        if (this.QO.remove(tVar)) {
            z.d(view, 1.0f);
            k(tVar);
        }
        if (this.QP.remove(tVar)) {
            z.d(view, 1.0f);
            k(tVar);
        }
        for (size = this.QU.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.QU.get(size);
            a(list, tVar);
            if (list.isEmpty()) {
                this.QU.remove(size);
            }
        }
        for (int size2 = this.QT.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.QT.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).Rr == tVar) {
                    z.c(view, 0.0f);
                    z.b(view, 0.0f);
                    y(tVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.QT.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.QS.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.QS.get(size);
            if (arrayList.remove(tVar)) {
                z.d(view, 1.0f);
                k(tVar);
                if (arrayList.isEmpty()) {
                    this.QS.remove(size);
                }
            }
        }
        this.QX.remove(tVar);
        this.QV.remove(tVar);
        this.QY.remove(tVar);
        this.QW.remove(tVar);
        eK();
    }

    private void e(t tVar) {
        android.support.v4.a.a.v(tVar.VU);
        d(tVar);
    }

    public boolean isRunning() {
        return (this.QP.isEmpty() && this.QR.isEmpty() && this.QQ.isEmpty() && this.QO.isEmpty() && this.QW.isEmpty() && this.QX.isEmpty() && this.QV.isEmpty() && this.QY.isEmpty() && this.QT.isEmpty() && this.QS.isEmpty() && this.QU.isEmpty()) ? false : true;
    }

    final void eK() {
        if (!isRunning()) {
            fS();
        }
    }

    public final void eL() {
        int size;
        for (size = this.QQ.size() - 1; size >= 0; size--) {
            b bVar = (b) this.QQ.get(size);
            View view = bVar.Rr.VU;
            z.c(view, 0.0f);
            z.b(view, 0.0f);
            y(bVar.Rr);
            this.QQ.remove(size);
        }
        for (size = this.QO.size() - 1; size >= 0; size--) {
            k((t) this.QO.get(size));
            this.QO.remove(size);
        }
        for (size = this.QP.size() - 1; size >= 0; size--) {
            t tVar = (t) this.QP.get(size);
            z.d(tVar.VU, 1.0f);
            k(tVar);
            this.QP.remove(size);
        }
        for (size = this.QR.size() - 1; size >= 0; size--) {
            a((a) this.QR.get(size));
        }
        this.QR.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.QT.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.QT.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.Rr.VU;
                    z.c(view2, 0.0f);
                    z.b(view2, 0.0f);
                    y(bVar2.Rr);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.QT.remove(arrayList);
                    }
                }
            }
            for (size2 = this.QS.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.QS.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    t tVar2 = (t) arrayList.get(size3);
                    z.d(tVar2.VU, 1.0f);
                    k(tVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.QS.remove(arrayList);
                    }
                }
            }
            for (size2 = this.QU.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.QU.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.QU.remove(arrayList);
                    }
                }
            }
            h(this.QX);
            h(this.QW);
            h(this.QV);
            h(this.QY);
            fS();
        }
    }

    private static void h(List<t> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            z.U(((t) list.get(size)).VU).cancel();
        }
    }

    public boolean a(t tVar, List<Object> list) {
        return !list.isEmpty() || super.a(tVar, list);
    }
}
