package com.tencent.mm.ipcinvoker.wx_extension.b;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private final List<b<a>> gOW;
    private final List<Object> gOX;

    private static final class a {
        private static b gOY = new b();
    }

    private static class b<T> extends WeakReference<T> {
        public b(T t) {
            super(t);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            Object obj2 = ((b) obj).get();
            Object obj3 = get();
            if (obj2 == obj3) {
                return true;
            }
            if (obj3 == null || !obj3.equals(obj2)) {
                return false;
            }
            return true;
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this.gOW = new LinkedList();
        this.gOX = new LinkedList();
    }

    public final boolean a(a aVar) {
        if (c(aVar)) {
            return false;
        }
        synchronized (this.gOW) {
            this.gOW.add(new b(aVar));
            BK();
        }
        return true;
    }

    public final boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        boolean remove;
        synchronized (this.gOW) {
            remove = this.gOW.remove(new b(aVar));
            BL();
        }
        return remove;
    }

    public final boolean c(a aVar) {
        if (aVar == null) {
            return false;
        }
        synchronized (this.gOW) {
            for (b bVar : this.gOW) {
                if (bVar != null) {
                    a aVar2 = (a) bVar.get();
                    if (aVar2 != null && aVar.equals(aVar2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final int size() {
        int size;
        synchronized (this.gOW) {
            size = this.gOW.size();
        }
        return size;
    }

    private synchronized void BK() {
        Iterator it = this.gOX.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private synchronized void BL() {
        Iterator it = this.gOX.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
