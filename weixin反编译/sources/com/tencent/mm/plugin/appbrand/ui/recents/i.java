package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.q.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import junit.framework.Assert;

final class i extends ArrayList<k> {
    private final ArrayList<k> jWA = new ArrayList(200);
    private final ArrayList<k> jWz = new ArrayList(10);

    public final /* synthetic */ Object clone() {
        return amj();
    }

    public final /* synthetic */ Object get(int i) {
        return lV(i);
    }

    public final /* synthetic */ Object remove(int i) {
        return lW(i);
    }

    i() {
    }

    static i c(ArrayList<k> arrayList, ArrayList<k> arrayList2) {
        i iVar = new i();
        e.e(iVar.jWz, arrayList);
        e.e(iVar.jWA, arrayList2);
        return iVar;
    }

    final synchronized ArrayList<k> amh() {
        return this.jWz;
    }

    final synchronized ArrayList<k> ami() {
        return this.jWA;
    }

    public final boolean addAll(Collection<? extends k> collection) {
        boolean z = false;
        if (i.class.isInstance(collection)) {
            synchronized (this) {
                i iVar = (i) collection;
                this.jWz.addAll(iVar.jWz);
                this.jWA.addAll(iVar.jWA);
                z = true;
            }
        } else {
            Assert.assertTrue("collection type mismatch!!", false);
        }
        return z;
    }

    public final synchronized i amj() {
        i iVar;
        iVar = new i();
        iVar.jWz.addAll(this.jWz);
        iVar.jWA.addAll(this.jWA);
        return iVar;
    }

    public final synchronized int size() {
        return this.jWz.size() + this.jWA.size();
    }

    private synchronized k lV(int i) {
        k kVar;
        if (i < this.jWz.size()) {
            kVar = (k) this.jWz.get(i);
        } else {
            kVar = (k) this.jWA.get(i - this.jWz.size());
        }
        return kVar;
    }

    public final synchronized k lW(int i) {
        k kVar;
        if (i < this.jWz.size()) {
            kVar = (k) this.jWz.remove(i);
        } else {
            kVar = (k) this.jWA.remove(i - this.jWz.size());
        }
        return kVar;
    }

    public final synchronized void clear() {
        this.jWz.clear();
        this.jWA.clear();
    }

    public final Iterator<k> iterator() {
        Assert.assertTrue("Why you need this?? call @smoothieli fix it", false);
        return new Iterator<k>() {
            public final /* bridge */ /* synthetic */ Object next() {
                return null;
            }

            public final boolean hasNext() {
                return false;
            }

            public final void remove() {
            }
        };
    }
}
