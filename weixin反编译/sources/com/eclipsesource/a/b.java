package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends h implements Iterable<h> {
    public final List<h> abw = new ArrayList();

    public final b bT(int i) {
        this.abw.add(a.bS(i));
        return this;
    }

    public final b h(long j) {
        this.abw.add(a.g(j));
        return this;
    }

    public final b e(double d) {
        this.abw.add(a.d(d));
        return this;
    }

    public final b ad(boolean z) {
        this.abw.add(a.ac(z));
        return this;
    }

    public final b a(h hVar) {
        if (hVar == null) {
            throw new NullPointerException("value is null");
        }
        this.abw.add(hVar);
        return this;
    }

    public final h bU(int i) {
        return (h) this.abw.get(i);
    }

    public final Iterator<h> iterator() {
        final Iterator it = this.abw.iterator();
        return new Iterator<h>() {
            public final /* bridge */ /* synthetic */ Object next() {
                return (h) it.next();
            }

            public final boolean hasNext() {
                return it.hasNext();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    final void a(i iVar) {
        iVar.hE();
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            if (obj == null) {
                iVar.hG();
            }
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.hF();
    }

    public final boolean isArray() {
        return true;
    }

    public final b hp() {
        return this;
    }

    public final int hashCode() {
        return this.abw.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.abw.equals(((b) obj).abw);
    }
}
