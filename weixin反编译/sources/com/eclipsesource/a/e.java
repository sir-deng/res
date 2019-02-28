package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends h implements Iterable<b> {
    public final List<String> abD = new ArrayList();
    public transient a abE = new a();
    public final List<h> abw = new ArrayList();

    public static class b {
        private final h abJ;
        private final String name;

        b(String str, h hVar) {
            this.name = str;
            this.abJ = hVar;
        }

        public final int hashCode() {
            return ((this.name.hashCode() + 31) * 31) + this.abJ.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.name.equals(bVar.name) && this.abJ.equals(bVar.abJ)) {
                return true;
            }
            return false;
        }
    }

    static class a {
        final byte[] abI = new byte[32];

        final void h(String str, int i) {
            int T = T(str);
            if (i < 255) {
                this.abI[T] = (byte) (i + 1);
            } else {
                this.abI[T] = (byte) 0;
            }
        }

        public final void remove(int i) {
            for (int i2 = 0; i2 < this.abI.length; i2++) {
                if (this.abI[i2] == i + 1) {
                    this.abI[i2] = (byte) 0;
                } else if (this.abI[i2] > i + 1) {
                    byte[] bArr = this.abI;
                    bArr[i2] = (byte) (bArr[i2] - 1);
                }
            }
        }

        final int T(Object obj) {
            return obj.hashCode() & (this.abI.length - 1);
        }
    }

    public final e a(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (hVar == null) {
            throw new NullPointerException("value is null");
        } else {
            this.abE.h(str, this.abD.size());
            this.abD.add(str);
            this.abw.add(hVar);
            return this;
        }
    }

    public final e g(String str, int i) {
        b(str, a.bS(i));
        return this;
    }

    public final e b(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (hVar == null) {
            throw new NullPointerException("value is null");
        } else {
            int indexOf = indexOf(str);
            if (indexOf != -1) {
                this.abw.set(indexOf, hVar);
            } else {
                this.abE.h(str, this.abD.size());
                this.abD.add(str);
                this.abw.add(hVar);
            }
            return this;
        }
    }

    public final h C(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int indexOf = indexOf(str);
        return indexOf != -1 ? (h) this.abw.get(indexOf) : null;
    }

    public final Iterator<b> iterator() {
        final Iterator it = this.abD.iterator();
        final Iterator it2 = this.abw.iterator();
        return new Iterator<b>() {
            public final /* synthetic */ Object next() {
                return new b((String) it.next(), (h) it2.next());
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
        iVar.hH();
        Iterator it = this.abw.iterator();
        Object obj = 1;
        for (String H : this.abD) {
            if (obj == null) {
                iVar.hK();
            }
            iVar.H(H);
            iVar.hJ();
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.hI();
    }

    public final boolean isObject() {
        return true;
    }

    public final e hu() {
        return this;
    }

    public final int hashCode() {
        return ((this.abD.hashCode() + 31) * 31) + this.abw.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.abD.equals(eVar.abD) && this.abw.equals(eVar.abw)) {
            return true;
        }
        return false;
    }

    public final int indexOf(String str) {
        a aVar = this.abE;
        int i = (aVar.abI[aVar.T(str)] & 255) - 1;
        return (i == -1 || !str.equals(this.abD.get(i))) ? this.abD.lastIndexOf(str) : i;
    }
}
