package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class f<T> extends com.tencent.mm.kernel.a.a.a<T> implements c<T> {
    private c<T> gTR;
    d<T> gTX;
    public Class gTY;
    volatile boolean gTZ = false;

    public static class b {
        public com.tencent.mm.cc.b gUi = new com.tencent.mm.cc.b();
    }

    public static class a<T> extends com.tencent.mm.kernel.a.a.a.a<T> {
        volatile int gUa;
        private boolean gUb;
        volatile boolean gUc;
        public volatile a gUd;
        public volatile a gUe;
        public h gUf;
        private c gUg;
        public b gUh;

        /* synthetic */ a(Object obj, Class cls, c cVar, byte b) {
            this(obj, cls, cVar);
        }

        private a(T t, Class cls, c cVar) {
            super(t);
            this.gUa = 0;
            this.gUb = false;
            this.gUc = false;
            this.gUf = new h();
            this.gUh = new b();
            this.gUf.gTI = cls;
            this.gUg = cVar;
        }

        public final void a(com.tencent.mm.kernel.a.a.a.a aVar) {
            super.a(aVar);
            synchronized (this) {
                this.gUa++;
            }
        }

        public final void a(com.tencent.mm.vending.c.a aVar) {
            if (!this.gTF) {
                if (!DU()) {
                    boolean z;
                    HashSet DE = DE();
                    Assert.assertNotNull(DE);
                    Iterator it = DE.iterator();
                    while (it.hasNext()) {
                        if (!((a) ((com.tencent.mm.kernel.a.a.a.a) it.next())).gTF) {
                            x.i("MMSkeleton.ParallelsDependencies", "ParallelsNode(%s) found it's depending node(%s) not consumed.", this, (com.tencent.mm.kernel.a.a.a.a) it.next());
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (z) {
                        DV();
                    }
                }
                this.gUh.gUi.cDg();
                if (!this.gTF) {
                    j.i("MMSkeleton.ParallelsDependencies", "Consume node(%s) on phase(%s) may after waiting resolved.", this, this.gUf.gTI);
                    aVar.call(this);
                    this.gTF = true;
                }
                this.gUh.gUi.done();
            }
        }

        private boolean DS() {
            return this.gUa == 0 && (this.gUd == null || this.gUd.gTF);
        }

        public final synchronized boolean DT() {
            boolean z = false;
            synchronized (this) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolvedAndSwallowIt for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.gTE;
                objArr[1] = this.gUf.gTI;
                objArr[2] = Boolean.valueOf(this.gUc);
                objArr[3] = Integer.valueOf(this.gUa);
                objArr[4] = this.gUd;
                objArr[5] = this.gUd != null ? Boolean.valueOf(this.gUd.gTF) : "";
                objArr[6] = this.gUf.gUr;
                x.i(str, str2, objArr);
                if (!this.gUc && DS()) {
                    x.d("MMSkeleton.ParallelsDependencies", "checkIfResolvedAndSwallowIt node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.gTF), this.gUf.gTI);
                    this.gUc = true;
                    notify();
                    z = true;
                }
            }
            return z;
        }

        private synchronized boolean DU() {
            boolean z = true;
            synchronized (this) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies checkIfResolved for %s with type %s mProvided %s, %s, %s, %s, %s";
                Object[] objArr = new Object[7];
                objArr[0] = this.gTE;
                objArr[1] = this.gUf.gTI;
                objArr[2] = Boolean.valueOf(this.gUc);
                objArr[3] = Integer.valueOf(this.gUa);
                objArr[4] = this.gUd;
                objArr[5] = this.gUd != null ? Boolean.valueOf(this.gUd.gTF) : "";
                objArr[6] = this.gUf.gUr;
                x.i(str, str2, objArr);
                if (!this.gUc) {
                    z = DS();
                }
            }
            return z;
        }

        private synchronized void DV() {
            try {
                if (this.gUc) {
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s resolved!", this, Boolean.valueOf(this.gTF), this.gUf.gTI);
                } else {
                    x.i("MMSkeleton.ParallelsDependencies", "waiting resolved");
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s", this, Boolean.valueOf(this.gTF), this.gUf.gTI);
                    wait();
                    x.d("MMSkeleton.ParallelsDependencies", "waitingResolved node %s, consumed %s, phase %s done", this, Boolean.valueOf(this.gTF), this.gUf.gTI);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MMSkeleton.ParallelsDependencies", e, "", new Object[0]);
            }
            return;
        }

        public final synchronized boolean DW() {
            this.gUa--;
            return DT();
        }

        public final String toString() {
            return super.toString() + " - with type " + this.gUf.gTI;
        }
    }

    public f(Class cls, d<T> dVar, c cVar) {
        this.gTY = cls;
        this.gTX = dVar;
        if (cVar == null) {
            cVar = this;
        }
        this.gTR = cVar;
    }

    protected final com.tencent.mm.kernel.a.a.a.a<T> aF(T t) {
        if (!this.gTB.containsKey(t)) {
            this.gTB.putIfAbsent(t, new a(t, this.gTY, this.gTR, (byte) 0));
        }
        return (com.tencent.mm.kernel.a.a.a.a) this.gTB.get(t);
    }

    public final a<T> aK(T t) {
        return (a) this.gTB.get(t);
    }

    public final void prepare() {
        x.i("MMSkeleton.ParallelsDependencies", "ParallelsDependencies for type %s", this.gTY);
        Assert.assertNotNull(this.gTX);
        this.gTZ = true;
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.gTB.values()) {
            if (aVar.DG()) {
                a aVar2 = (a) aVar;
                x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s", aVar2);
                if (aVar2.DT()) {
                    this.gTX.b(aVar2);
                }
                x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare can provide %s done", aVar2);
            }
        }
        x.d("MMSkeleton.ParallelsDependencies", "ParallelsDependencies prepare %s done", this.gTY);
    }

    public final a<T> DK() {
        return this.gTX.DK();
    }

    public final void a(a<T> aVar) {
        HashSet DD = aVar.DD();
        if (DD != null) {
            Iterator it = DD.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) ((com.tencent.mm.kernel.a.a.a.a) it.next());
                if (aVar2.DW()) {
                    this.gTX.b(aVar2);
                }
            }
        }
    }

    public final List<com.tencent.mm.kernel.a.a.a.a> DR() {
        List<com.tencent.mm.kernel.a.a.a.a> arrayList = new ArrayList(1);
        for (com.tencent.mm.kernel.a.a.a.a aVar : this.gTB.values()) {
            if (!((a) aVar).gTF) {
                String str = "MMSkeleton.ParallelsDependencies";
                String str2 = "ParallelsDependencies node(%s) not consumed!!!! %s, %s, %s";
                Object[] objArr = new Object[4];
                objArr[0] = aVar;
                objArr[1] = Integer.valueOf(((a) aVar).gUa);
                objArr[2] = ((a) aVar).gUd;
                objArr[3] = ((a) aVar).gUd != null ? Boolean.valueOf(((a) aVar).gUd.gTF) : "";
                x.e(str, str2, objArr);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }
}
