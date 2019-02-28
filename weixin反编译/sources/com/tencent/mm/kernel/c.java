package com.tencent.mm.kernel;

import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.b;
import com.tencent.mm.kernel.c.d;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class c {
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, f> gRE = new ConcurrentHashMap();
    private final ArrayList<f> gRF = new ArrayList();
    private final ConcurrentHashMap<Class<? extends f>, ArrayList<Class<? extends com.tencent.mm.kernel.b.a>>> gRG = new ConcurrentHashMap();
    private final ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends f>> gRH = new ConcurrentHashMap();
    public com.tencent.mm.kernel.a.a.a<Class<? extends f>> gRI = new com.tencent.mm.kernel.a.a.a();
    private ConcurrentHashMap<Class<? extends com.tencent.mm.kernel.c.a>, com.tencent.mm.kernel.c.c> gRJ = new ConcurrentHashMap();
    protected a gRK;
    public Class<? extends com.tencent.mm.kernel.b.a> gRL = null;
    private com.tencent.mm.kernel.a.a gRM;

    public interface a {
        void a(com.tencent.mm.kernel.c.a aVar);

        void b(f fVar);

        void b(com.tencent.mm.kernel.c.a aVar);

        void c(f fVar);

        void c(com.tencent.mm.kernel.c.a aVar);
    }

    public final synchronized f f(Class<? extends f> cls) {
        return a((Class) cls, false);
    }

    private synchronized f a(Class<? extends f> cls, boolean z) {
        f fVar;
        Assert.assertNotNull(cls);
        try {
            fVar = (f) cls.newInstance();
            if (z) {
                fVar.markAsPendingPlugin();
            }
            fVar = a(fVar);
        } catch (Throwable e) {
            j.printErrStackTrace("MMSkeleton.CorePlugins", e, "Install plugin %s failed.", cls);
            fVar = null;
        }
        return fVar;
    }

    public final synchronized f fL(String str) {
        return p(str, false);
    }

    public final synchronized f p(String str, boolean z) {
        f a;
        try {
            Class cls = Class.forName(str);
            if (f.class.isAssignableFrom(cls)) {
                a = a(cls, z);
            } else {
                j.e("MMSkeleton.CorePlugins", "class string %s, not a Plugin", str);
                a = null;
            }
        } catch (ClassNotFoundException e) {
            j.e("MMSkeleton.CorePlugins", "plugin %s not found.", str);
            h.Dv().Dn().CU();
            new Object[1][0] = str;
        }
        return a;
    }

    private synchronized f a(f fVar) {
        f fVar2;
        boolean z = false;
        synchronized (this) {
            if (g(fVar.getClass())) {
                j.w("MMSkeleton.CorePlugins", "Plugin %s has been installed.", fVar.getClass());
                fVar2 = (f) l(fVar.getClass());
            } else {
                Assert.assertNotNull(fVar);
                String[] ofProcesses = fVar.ofProcesses();
                if (ofProcesses != null && ofProcesses.length > 0) {
                    g CU = h.Dv().Dn().CU();
                    for (String fT : ofProcesses) {
                        z = CU.fT(fT);
                        if (z) {
                            break;
                        }
                    }
                    if (!z) {
                        throw new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{fVar, CU.gQd, Arrays.asList(ofProcesses)}));
                    }
                }
                this.gRE.put(fVar.getClass(), fVar);
                this.gRF.add(fVar);
                fVar.invokeInstalled();
                if (this.gRK != null) {
                    this.gRK.b(fVar);
                }
                fVar2 = fVar;
            }
        }
        return fVar2;
    }

    public final synchronized boolean g(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        return this.gRE.containsKey(cls);
    }

    public final synchronized void c(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        f fVar = (f) this.gRE.get(cls);
        Assert.assertNotNull(fVar);
        ArrayList arrayList = (ArrayList) this.gRG.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.gRG.put(cls, arrayList);
        }
        this.gRH.put(cls2, cls);
        arrayList.add(cls2);
        this.gRE.put(cls2, fVar);
    }

    public final <T extends com.tencent.mm.kernel.c.a> T h(Class<T> cls) {
        T i;
        T i2 = i(cls);
        if (i2 == null) {
            int i3;
            if (cls != null) {
                e eVar = (e) cls.getAnnotation(e.class);
                if (!(eVar == null || eVar.value() == null)) {
                    com.tencent.mm.kernel.b.a k = k(eVar.value());
                    i3 = (k == null || f.aA(k)) ? 0 : 1;
                    if (i3 != 0) {
                        j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                        i = i(cls);
                        if (i == null) {
                            return i;
                        }
                        h.Dv().Dn().CU();
                        new Object[1][0] = cls;
                        return (com.tencent.mm.kernel.c.a) f.n(cls);
                    }
                }
            }
            i3 = 0;
            if (i3 != 0) {
                j.i("MMSkeleton.CorePlugins", "Try load OwnerPlugin for service(%s)...", cls);
                i = i(cls);
                if (i == null) {
                    return i;
                }
                h.Dv().Dn().CU();
                new Object[1][0] = cls;
                return (com.tencent.mm.kernel.c.a) f.n(cls);
            }
        }
        i = i2;
        if (i == null) {
            return i;
        }
        h.Dv().Dn().CU();
        new Object[1][0] = cls;
        return (com.tencent.mm.kernel.c.a) f.n(cls);
    }

    private <T extends com.tencent.mm.kernel.c.a> T i(Class<T> cls) {
        int i;
        com.tencent.mm.kernel.c.a Ec;
        com.tencent.mm.kernel.c.c cVar = (com.tencent.mm.kernel.c.c) this.gRJ.get(cls);
        if (cls.isInterface() || !Modifier.isAbstract(cls.getModifiers())) {
            i = 0;
        } else {
            j.w("MMSkeleton.CorePlugins", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!", new Object[0]);
            i = 1;
        }
        if (cVar != null) {
            Ec = cVar.Ec();
        } else {
            j.e("MMSkeleton.CorePlugins", "Service(%s) not found!!! ", cls);
            if (i != 0) {
                j.e("MMSkeleton.CorePlugins", "This error must cause by using implementation class to call service! Use interface instead! Understand?", new Object[0]);
            }
            T Ec2 = null;
        }
        if (this.gRK != null) {
            this.gRK.c(Ec2);
        }
        return Ec2;
    }

    public final <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        this.gRJ.put(cls, cVar);
        if (cVar instanceof b) {
            ((b) cVar).Ea();
        }
        if ((cVar instanceof d) && this.gRK != null) {
            this.gRK.a(cVar.Ec());
        }
        j.i("MMSkeleton.CorePlugins", "register service %s %s", cls, cVar);
    }

    public final void j(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        com.tencent.mm.kernel.c.c cVar = (com.tencent.mm.kernel.c.c) this.gRJ.remove(cls);
        if (cVar instanceof b) {
            ((b) cVar).Eb();
        }
        if ((cVar instanceof d) && this.gRK != null) {
            this.gRK.b(cVar.Ec());
        }
    }

    public final synchronized <T extends com.tencent.mm.kernel.b.a> T k(Class<T> cls) {
        T t;
        T l = l(cls);
        if (this.gRK != null) {
            this.gRK.c((f) l);
        }
        if (l == null) {
            t = (com.tencent.mm.kernel.b.a) f.n(cls);
        } else {
            t = l;
        }
        return t;
    }

    private synchronized <T extends com.tencent.mm.kernel.b.a> T l(Class<T> cls) {
        Assert.assertNotNull(cls);
        return (com.tencent.mm.kernel.b.a) this.gRE.get(cls);
    }

    private synchronized boolean m(Class<? extends com.tencent.mm.kernel.b.a> cls) {
        boolean z = false;
        synchronized (this) {
            Assert.assertNotNull(cls);
            if (g(cls)) {
                z = true;
            } else {
                j.w("MMSkeleton.CorePlugins", "Plugin " + cls + " must be installed!", new Object[0]);
            }
        }
        return z;
    }

    public final void d(Class<? extends f> cls, Class<? extends com.tencent.mm.kernel.b.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        if (m(cls2)) {
            Class cls22;
            if (this.gRH.containsKey(cls22)) {
                cls22 = (Class) this.gRH.get(cls22);
            }
            this.gRI.o(cls, cls22);
            if (this.gRM == null) {
                this.gRM = h.Dv().Dn().CU().gRM;
            }
            f fVar = (f) l(cls);
            f fVar2 = (f) l(cls22);
            this.gRM.gSR.a(com.tencent.mm.kernel.b.b.class, fVar, fVar2);
            this.gRM.gSR.a(com.tencent.mm.kernel.a.c.b.class, fVar, fVar2);
            return;
        }
        String format = String.format("depends plugin %s not install, plugin %s will not add in to dependency tree", new Object[]{cls22.getName(), cls.getName()});
        j.e("MMSkeleton.CorePlugins", format, new Object[0]);
        throw new IllegalAccessError(format);
    }

    public final synchronized void CS() {
        Iterator it = this.gRF.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            if (fVar.isDependencyMade()) {
                com.tencent.mm.kernel.a.a.a("skip make dependency for plugin %s.", fVar);
            } else {
                com.tencent.mm.kernel.a.a.a("make dependency for plugin %s...", fVar);
                fVar.invokeDependency();
            }
        }
    }

    public final synchronized List<f> CT() {
        return this.gRF;
    }
}
