package com.tencent.mm.kernel.a.b;

import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g implements b, c<Object>, d<Object> {
    public Map<Class<?>, f<Object>> gUj = new ConcurrentHashMap();
    private Class<?>[] gUk;
    public volatile Class<?>[] gUl;
    public Map<Class, Object> gUm = new ConcurrentHashMap();
    private int gUn = 0;
    private Queue<com.tencent.mm.kernel.a.b.f.a> gUo = new ConcurrentLinkedQueue();
    public ConcurrentHashMap<Object, a> gUp = new ConcurrentHashMap();

    private static class a {
        byte[] gUq;

        private a() {
            this.gUq = new byte[1];
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean DY() {
            boolean z = false;
            synchronized (this.gUq) {
                if (this.gUq[0] == (byte) 2) {
                    z = true;
                }
            }
            return z;
        }
    }

    public final void a(Class... clsArr) {
        int i = 0;
        this.gUk = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.gUk, 0, clsArr.length);
        while (i < this.gUk.length) {
            this.gUj.put(this.gUk[i], new f(this.gUk[i], this, this));
            i++;
        }
    }

    public final <T> f<T> p(Class<T> cls) {
        return (f) this.gUj.get(cls);
    }

    public final void b(Class cls, boolean z) {
        int i = 0;
        while (i < this.gUk.length) {
            if (this.gUk[i] == cls) {
                break;
            }
            i++;
        }
        i = -1;
        int min = Math.min(i, this.gUk.length - 1);
        if (min >= 0 && this.gUn > min) {
            for (int i2 = min; i2 < this.gUn; i2++) {
                for (com.tencent.mm.kernel.a.a.a.a aVar : p(this.gUk[i2]).gTB.values()) {
                    com.tencent.mm.kernel.a.b.f.a aVar2 = (com.tencent.mm.kernel.a.b.f.a) aVar;
                    if (z) {
                        aVar2.gTF = false;
                    }
                    synchronized (aVar2) {
                        aVar2.gUa = aVar2.DF();
                        aVar2.gUc = false;
                    }
                }
            }
            this.gUn = min;
        }
    }

    public final void prepare() {
        int i;
        j.i("MicroMsg.ParallelsManagement", "prepare()", new Object[0]);
        synchronized (this.gUk) {
            if (this.gUk.length > this.gUn) {
                i = this.gUn;
                this.gUn++;
            } else {
                i = -1;
            }
        }
        if (i != -1) {
            p(this.gUk[i]).prepare();
        }
    }

    public final void DX() {
        while (true) {
            synchronized (this.gUk) {
                if (this.gUk.length <= this.gUn) {
                    return;
                }
            }
            prepare();
        }
    }

    public final com.tencent.mm.kernel.a.b.f.a DK() {
        com.tencent.mm.kernel.a.b.f.a aVar;
        synchronized (this.gUo) {
            aVar = (com.tencent.mm.kernel.a.b.f.a) this.gUo.poll();
        }
        return aVar;
    }

    public final void a(com.tencent.mm.kernel.a.b.f.a aVar) {
        x.i("MicroMsg.ParallelsManagement", "ParallelsManagement resolvedOne %s for type %s then next %s", aVar, aVar.gUf.gTI, aVar.gUf.gUs);
        p(aVar.gUf.gTI).a(aVar);
        if (aVar.gUf.gUs != null) {
            f p = p(aVar.gUf.gUs);
            com.tencent.mm.kernel.a.b.f.a aVar2 = (com.tencent.mm.kernel.a.b.f.a) p.gTB.get(aVar);
            if (aVar2.gTE != aVar.gTE) {
                x.e("MMSkeleton.ParallelsDependencies", "not same!!!! %s, %s, %s, %s", aVar2, aVar2.gTE, aVar, p.gTB.get(aVar));
            }
            if (p.gTZ && aVar2.DT()) {
                p.gTX.b(aVar2);
            }
        }
    }

    public final void b(com.tencent.mm.kernel.a.b.f.a<Object> aVar) {
        synchronized (this.gUo) {
            this.gUo.offer(aVar);
        }
        x.d("MicroMsg.ParallelsManagement", "ParallelsManagement provideOne %s %s", aVar, aVar.gUf.gTI);
    }

    public final void a(Class cls, Object obj, Object obj2) {
        int i;
        f p;
        if (this.gUl != null) {
            Class[] clsArr = this.gUl;
            int length = clsArr.length;
            i = 0;
            while (i < length) {
                if (clsArr[i] != cls) {
                    i++;
                }
            }
            i = 0;
            if (i == 0) {
                p = p(cls);
                if (p != null) {
                    p.o(obj, obj2);
                }
            }
            j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
            return;
        }
        i = 1;
        if (i == 0) {
            j.w("MicroMsg.ParallelsManagement", "Not allow phase(%s) has dependency", cls);
            return;
        }
        p = p(cls);
        if (p != null) {
            p.o(obj, obj2);
        }
    }

    public final void aL(Object obj) {
        int i = 0;
        if (!this.gUp.containsKey(obj)) {
            this.gUp.putIfAbsent(obj, new a());
        }
        a aVar = (a) this.gUp.get(obj);
        synchronized (aVar.gUq) {
            if (aVar.gUq[0] == (byte) 2) {
            } else {
                if (aVar.gUq[0] == (byte) 1) {
                    try {
                        aVar.gUq.wait();
                    } catch (InterruptedException e) {
                    }
                } else {
                    aVar.gUq[0] = (byte) 1;
                }
            }
        }
        if (aVar.DY()) {
            j.i("MicroMsg.ParallelsManagement", "%s Has done. return.", obj);
            return;
        }
        Class cls;
        j.i("MicroMsg.ParallelsManagement", "Make dependency on subject(%s), hashcode(%s)", obj, Integer.valueOf(obj.hashCode()));
        if (obj instanceof b) {
            a.start();
            ((b) obj).parallelsDependency();
            b DJ = a.DJ();
            if (DJ.gTK != null) {
                for (com.tencent.mm.kernel.a.b.a.a aVar2 : DJ.gTK.values()) {
                    for (Object next : aVar2.gTJ) {
                        if (p(aVar2.gTI).aG(next) == null) {
                            j.i("MicroMsg.ParallelsManagement", "Traversal make dependency for %s by subject(%s)", next, obj);
                            aL(next);
                        }
                        a(aVar2.gTI, obj, next);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Class cls2 : this.gUk) {
            if (cls2.isInstance(obj)) {
                arrayList.add(cls2);
            }
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        com.tencent.mm.kernel.a.b.f.a aVar3 = null;
        com.tencent.mm.kernel.a.b.f.a aVar4 = null;
        while (i < clsArr.length) {
            Class cls3 = clsArr[i];
            cls2 = i < clsArr.length + -1 ? clsArr[i + 1] : null;
            com.tencent.mm.kernel.a.b.f.a a = aVar3 != null ? aVar3 : a(cls3, obj);
            aVar3 = cls2 != null ? a(cls2, obj) : null;
            a.gUd = aVar4;
            a.gUe = aVar3;
            if (aVar4 != null) {
                a.gUf.gUr = aVar4.gUf.gTI;
            }
            if (aVar3 != null) {
                a.gUf.gUs = aVar3.gUf.gTI;
            }
            i++;
            aVar4 = a;
        }
        synchronized (aVar.gUq) {
            if (aVar.gUq[0] == (byte) 1) {
                aVar.gUq[0] = (byte) 2;
                aVar.gUq.notifyAll();
            }
        }
    }

    private com.tencent.mm.kernel.a.b.f.a a(Class cls, Object obj) {
        f p = p(cls);
        com.tencent.mm.kernel.a.b.f.a aVar = (com.tencent.mm.kernel.a.b.f.a) p.aG(obj);
        x.d("MicroMsg.ParallelsManagement", "makeDependency on IDependency of type %s for %s with %s", cls, obj, p);
        if (aVar != null) {
            return aVar;
        }
        Object obj2 = this.gUm.get(cls);
        if (obj2 == null) {
            obj2 = obj;
        }
        p.o(obj, obj2);
        return (com.tencent.mm.kernel.a.b.f.a) p.aG(obj);
    }
}
