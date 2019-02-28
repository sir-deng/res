package com.tencent.mm.kernel.a.a;

import com.tencent.mm.kernel.f;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class a<T> {
    public final ConcurrentHashMap<T, a<T>> gTB = new ConcurrentHashMap();

    public static class a<T> {
        private HashSet<a> gTC;
        private HashSet<a> gTD;
        public T gTE;
        public volatile boolean gTF = false;
        private boolean gTG = true;

        public a(T t) {
            this.gTE = t;
        }

        public final synchronized HashSet<a> DD() {
            return this.gTD == null ? null : new HashSet(this.gTD);
        }

        public final synchronized HashSet<a> DE() {
            return this.gTC == null ? null : new HashSet(this.gTC);
        }

        public final synchronized int DF() {
            return this.gTC == null ? 0 : this.gTC.size();
        }

        public final synchronized boolean DG() {
            return this.gTG;
        }

        public final synchronized void DH() {
            if (this.gTC == null || this.gTC.size() == 0) {
                this.gTG = true;
            }
        }

        public final synchronized boolean DI() {
            boolean z;
            z = this.gTC != null && this.gTC.size() > 0;
            return z;
        }

        public String toString() {
            return "Ref-" + this.gTE.toString();
        }

        public void a(a aVar) {
            b(aVar);
            aVar.c(this);
        }

        private synchronized void b(a aVar) {
            this.gTG = false;
            if (this.gTC == null) {
                this.gTC = new HashSet(4);
            }
            this.gTC.add(aVar);
        }

        private synchronized void c(a aVar) {
            if (this.gTD == null) {
                this.gTD = new HashSet(4);
            }
            this.gTD.add(aVar);
        }

        public int hashCode() {
            return this.gTE.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.gTE.equals(((a) obj).gTE);
            }
            return this.gTE.equals(obj);
        }
    }

    public a<T> aF(T t) {
        if (!this.gTB.containsKey(t)) {
            this.gTB.putIfAbsent(t, new a(t));
        }
        return (a) this.gTB.get(t);
    }

    public final a<T> aG(T t) {
        return (a) this.gTB.get(t);
    }

    private static void aH(T t) {
        Assert.assertNotNull("Found a null object, maybe your component isn't installedor registered.", t);
        Assert.assertFalse("Found a dummy object, maybe your component isn't installed or registered.", f.aA(t));
    }

    public final void o(T t, T t2) {
        Object[] objArr = new Object[]{t, t2};
        aH(t);
        aH(t2);
        if (t == t2) {
            aF(t).DH();
        } else {
            aF(t).a(aF(t2));
        }
    }
}
