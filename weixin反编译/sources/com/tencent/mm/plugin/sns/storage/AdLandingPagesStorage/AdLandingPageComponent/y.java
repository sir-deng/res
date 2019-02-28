package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.List;

public final class y extends s {
    public List<a> qeK = new ArrayList();
    public String rns = "";
    public float rnt;
    public String rnu = "";
    public int rnv;
    public int rnw;
    public int rnx;
    public int rny;
    public String rnz = "";

    public static class a {
        public String label = "";
        public String rnA = "";
        public float value;

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.label.equals(this.label) && aVar.rnA.equals(this.rnA) && aVar.value == this.value) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (int) (((float) (this.label.hashCode() + this.rnA.hashCode())) + this.value);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (yVar.rns != null ? !yVar.rns.equals(this.rns) : this.rns != null) {
            if (yVar.rnt == this.rnt && (yVar.rnu != null ? !yVar.rnu.equals(this.rnu) : this.rnu != null) && yVar.rnv == this.rnv && yVar.rnw == this.rnw && yVar.rnx == this.rnx && yVar.rny == this.rny && (yVar.qeK != null ? !yVar.qeK.equals(this.qeK) : this.qeK != null)) {
                if (yVar.rnz == null) {
                    if (this.rnz == null) {
                        return true;
                    }
                } else if (yVar.rnz.equals(this.rnz)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
