package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.x;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> hbE = new ConcurrentSkipListMap();
    private Vector<a> hbF = new Vector();
    protected long hbG = 0;

    public abstract class a {
        public abstract S EC();

        public abstract long ED();

        public abstract int EE();
    }

    public abstract long Ex();

    public abstract long Ey();

    public abstract long aN(T t);

    public abstract S aO(T t);

    public abstract S b(S s);

    public abstract d<T, S> c(S s);

    public abstract T d(S s);

    static /* synthetic */ void a(e eVar) {
        while (eVar.hbF.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = (a) eVar.hbF.remove(0);
            d c = eVar.c(eVar.b(aVar.EC()));
            long j = 0;
            int i = 0;
            long ED = aVar.ED();
            int EE = aVar.EE();
            x.i("MicroMsg.BucketPool", "%s preload start preloadSize: %s sizeInBytes: %s  preLoadBytes: %s and nums: %s", eVar, aVar.EC(), eVar.b(aVar.EC()), Long.valueOf(ED), Integer.valueOf(EE));
            while (eVar.hbG < eVar.Ex() && ((ED <= 0 || j < ED) && (EE <= 0 || i < EE))) {
                Object d = eVar.d(aVar.EC());
                c.put(d);
                j += eVar.aN(d);
                i++;
                eVar.aI(eVar.aN(d));
            }
            j = System.currentTimeMillis();
            x.d("MicroMsg.BucketPool", "%s preload finished, put %d elements, used %dms", eVar, Integer.valueOf(c.size()), Long.valueOf(j - currentTimeMillis));
            eVar.hbE.put(eVar.b(aVar.EC()), c);
        }
    }

    public final void a(a aVar) {
        this.hbF.add(aVar);
        x.i("MicroMsg.BucketPool", "%s addPreload: %s", this, aVar);
        EB();
    }

    public final void EB() {
        if (this.hbF.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    e.a(e.this);
                }
            }, "BucketPool_preload");
        }
    }

    public synchronized T a(S s) {
        T t;
        d dVar = (d) this.hbE.get(s);
        if (dVar == null || dVar.size() <= 0) {
            x.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", s);
            t = null;
        } else {
            T pop = dVar.pop();
            this.hbE.put(dVar.EA(), dVar);
            aJ(aN(pop));
            t = pop;
        }
        return t;
    }

    public synchronized void aM(T t) {
        if (t != null) {
            Comparable aO = aO(t);
            long aN = aN(t);
            if (aN > Ey()) {
                x.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", Long.valueOf(aN));
            } else if (this.hbG + aN > Ex()) {
                x.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", Long.valueOf(aN), Long.valueOf(this.hbG));
            } else {
                d dVar = (d) this.hbE.get(aO);
                if (dVar == null) {
                    dVar = c(aO);
                }
                dVar.put(t);
                this.hbE.put(aO, dVar);
                aI(aN);
            }
        }
    }

    private synchronized void aI(long j) {
        this.hbG += j;
    }

    protected final synchronized void aJ(long j) {
        this.hbG -= j;
    }

    public void Ez() {
        x.i("MicroMsg.BucketPool", "freeAll: %s", getClass().getName());
        this.hbE.clear();
        this.hbG = 0;
    }
}
