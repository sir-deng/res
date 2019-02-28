package b.c.b;

import b.e.d;

public abstract class g extends a implements d {
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj instanceof d ? obj.equals(cKn()) : false;
        } else {
            g gVar = (g) obj;
            if (cKo().equals(gVar.cKo()) && getName().equals(gVar.getName()) && ckA().equals(gVar.ckA()) && e.h(cKm(), gVar.cKm())) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        return (((cKo().hashCode() * 31) + getName().hashCode()) * 31) + ckA().hashCode();
    }

    public String toString() {
        g cKn = cKn();
        if (cKn != this) {
            return cKn.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
