package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.d;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a {
    public static a xmy = new a();
    private final HashMap<Integer, b> xmA = new HashMap();
    private a xmx = new a();
    private final HashMap<Integer, LinkedList<c>> xmz = new HashMap();

    public static class a extends d {
        public final void f(Runnable runnable) {
            runnable.run();
        }

        public final void f(Runnable runnable, long j) {
            runnable.run();
        }

        public final String getType() {
            return Thread.currentThread().toString();
        }

        public final void cancel() {
        }
    }

    private class b extends com.tencent.mm.vending.b.a<c> {
        public b() {
            super(a.this.xmx);
        }

        public final void a(com.tencent.mm.vending.j.a aVar) {
            LinkedList cAE = cAE();
            b bVar = (b) aVar.get(0);
            if (bVar == null) {
                x.e("MicroMsg.EventCenter", "event is null! fatal!");
                return;
            }
            if (bVar.xmE) {
                Collections.sort(cAE, new Comparator<com.tencent.mm.vending.b.b>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((c) ((com.tencent.mm.vending.b.b) obj2).zKW).priority - ((c) ((com.tencent.mm.vending.b.b) obj).zKW).priority;
                    }
                });
            }
            com.tencent.mm.vending.b.b[] bVarArr = new com.tencent.mm.vending.b.b[cAE.size()];
            cAE.toArray(bVarArr);
            int length = bVarArr.length;
            int i = 0;
            while (i < length && (!((c) bVarArr[i].zKW).a(bVar) || !bVar.xmE)) {
                i++;
            }
            if (bVar.frD != null) {
                bVar.frD.run();
            }
        }
    }

    private a() {
    }

    public final com.tencent.mm.vending.b.b<c> a(c cVar) {
        com.tencent.mm.vending.b.b<c> a;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            x.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.cfA()));
            com.tencent.mm.vending.b.a aVar = (b) this.xmA.get(Integer.valueOf(cVar.cfA()));
            if (aVar == null) {
                HashMap hashMap = this.xmA;
                Integer valueOf = Integer.valueOf(cVar.cfA());
                aVar = new b();
                hashMap.put(valueOf, aVar);
            }
            a = aVar.a(new com.tencent.mm.vending.b.b(cVar, aVar));
        }
        return a;
    }

    @Deprecated
    public final boolean b(c cVar) {
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.add", cVar);
            x.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.cfA()));
            LinkedList linkedList = (LinkedList) this.xmz.get(Integer.valueOf(cVar.cfA()));
            if (linkedList == null) {
                HashMap hashMap = this.xmz;
                Integer valueOf = Integer.valueOf(cVar.cfA());
                linkedList = new LinkedList();
                hashMap.put(valueOf, linkedList);
            }
            if (linkedList.contains(cVar)) {
                return true;
            }
            ListenerInstanceMonitor.bV(cVar);
            boolean add = linkedList.add(cVar);
            return add;
        }
    }

    @Deprecated
    public final boolean c(c cVar) {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            Assert.assertNotNull("EventPoolImpl.remove", cVar);
            x.v("MicroMsg.EventCenter", "removeListener %s(%d)", cVar, Integer.valueOf(cVar.cfA()));
            LinkedList linkedList = (LinkedList) this.xmz.get(Integer.valueOf(cVar.cfA()));
            if (linkedList != null) {
                z2 = linkedList.remove(cVar);
            }
            b bVar = (b) this.xmA.get(Integer.valueOf(cVar.cfA()));
            if (bVar != null) {
                bVar.b(new com.tencent.mm.vending.b.b(cVar, bVar));
                z = true;
            } else {
                z = z2;
            }
            ListenerInstanceMonitor.bW(cVar);
        }
        return z;
    }

    public final boolean m(b bVar) {
        b bVar2;
        boolean z = false;
        boolean z2 = true;
        Assert.assertNotNull("EventPoolImpl.publish", bVar);
        x.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.cfA()));
        LinkedList linkedList = null;
        synchronized (this) {
            int cfA = bVar.cfA();
            LinkedList linkedList2 = (LinkedList) this.xmz.get(Integer.valueOf(cfA));
            if (linkedList2 != null) {
                linkedList = new LinkedList(linkedList2);
                z = true;
            }
            bVar2 = (b) this.xmA.get(Integer.valueOf(cfA));
            if (bVar2 == null) {
                z2 = z;
            }
            if (!z2) {
                x.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", bVar, Integer.valueOf(cfA), "");
            }
        }
        if (linkedList != null) {
            a(linkedList, bVar);
        }
        if (bVar2 != null) {
            bVar2.a(g.cr(bVar));
        }
        return z2;
    }

    public final void a(final b bVar, Looper looper) {
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", bVar);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        x.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.cfA()));
        new ag(looper).post(new Runnable() {
            public final void run() {
                a.xmy.m(bVar);
            }
        });
    }

    public final synchronized boolean B(Class<? extends b> cls) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList linkedList = (LinkedList) this.xmz.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            b bVar = (b) this.xmA.get(Integer.valueOf(cls.getName().hashCode()));
            if (bVar == null || bVar.size() <= 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    public final synchronized boolean d(c cVar) {
        boolean z;
        Assert.assertNotNull("EventPoolImpl.hadListened", cVar);
        LinkedList linkedList = (LinkedList) this.xmz.get(Integer.valueOf(cVar.cfA()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(cVar)) {
            b bVar = (b) this.xmA.get(Integer.valueOf(cVar.cfA()));
            if (bVar == null || bVar.size() <= 0 || !bVar.contains(cVar)) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = true;
        }
        return z;
    }

    private void a(LinkedList<c> linkedList, b bVar) {
        if (bVar.xmE) {
            Collections.sort(linkedList, new Comparator<c>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj2).priority - ((c) obj).priority;
                }
            });
        }
        c[] cVarArr = new c[linkedList.size()];
        linkedList.toArray(cVarArr);
        int length = cVarArr.length;
        int i = 0;
        while (i < length && (!cVarArr[i].a(bVar) || !bVar.xmE)) {
            i++;
        }
        if (bVar.frD != null) {
            bVar.frD.run();
        }
    }
}
