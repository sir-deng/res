package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class k<T, E> {
    public int xsa = 0;
    private final Hashtable<T, Object> xsb = new Hashtable();
    private final HashSet<E> xsc = new HashSet();

    public abstract void p(T t, E e);

    public final void lock() {
        this.xsa++;
    }

    public final void unlock() {
        this.xsa--;
        if (this.xsa <= 0) {
            this.xsa = 0;
            chD();
        }
    }

    public final boolean isLocked() {
        return this.xsa > 0;
    }

    public synchronized void a(T t, Looper looper) {
        if (!this.xsb.containsKey(t)) {
            if (looper != null) {
                this.xsb.put(t, looper);
            } else {
                this.xsb.put(t, new Object());
            }
        }
    }

    public final synchronized void remove(T t) {
        this.xsb.remove(t);
    }

    public final synchronized void removeAll() {
        this.xsb.clear();
    }

    private synchronized Vector<T> chC() {
        Vector<T> vector;
        vector = new Vector();
        vector.addAll(this.xsb.keySet());
        return vector;
    }

    public final boolean cb(E e) {
        boolean add;
        synchronized (this.xsc) {
            add = this.xsc.add(e);
        }
        return add;
    }

    public final void doNotify() {
        if (!isLocked()) {
            chD();
        }
    }

    public void cD(List<E> list) {
    }

    private void chD() {
        Vector chC = chC();
        if (chC.size() <= 0) {
            this.xsc.clear();
            return;
        }
        Object arrayList;
        synchronized (this.xsc) {
            arrayList = new ArrayList(this.xsc);
            this.xsc.clear();
        }
        cD(arrayList);
        Map hashMap = new HashMap();
        Iterator it = chC.iterator();
        while (it.hasNext()) {
            final Object next = it.next();
            Object obj = this.xsb.get(next);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                final Object next2 = it2.next();
                if (!(next2 == null || obj == null)) {
                    if (obj instanceof Looper) {
                        Looper looper = (Looper) obj;
                        ag agVar = (ag) hashMap.get(looper);
                        if (agVar == null) {
                            agVar = new ag(looper);
                            hashMap.put(looper, agVar);
                        }
                        agVar.post(new Runnable() {
                            public final void run() {
                                k.this.p(next, next2);
                            }
                        });
                    } else {
                        p(next, next2);
                    }
                }
            }
        }
    }
}
