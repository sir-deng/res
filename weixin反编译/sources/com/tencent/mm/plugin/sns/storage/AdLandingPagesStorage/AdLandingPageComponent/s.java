package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public abstract class s implements Serializable {
    public int fqh;
    public float height;
    public String rfQ;
    public String rmN;
    public int rmO;
    public float rmP;
    public float rmQ;
    public float rmR;
    public float rmS;
    public float rmT = -2.0f;
    public float rmU = -2.0f;
    public boolean rmV;
    public String rmW = "";
    public int rmX;
    public int rmY;
    public boolean rmZ;
    public boolean rna;
    public int rnb;
    public boolean rnc;
    public int rnd;
    public int type;
    public String uin;
    public float width;

    public final void xn(int i) {
        this.rnb = i;
        for (s xn : bxw()) {
            xn.xn(i);
        }
    }

    public final void iG(boolean z) {
        this.rnc = z;
        for (s iG : bxw()) {
            iG.iG(z);
        }
    }

    public final void LB(String str) {
        this.rfQ = str;
        for (s LB : bxw()) {
            LB.LB(str);
        }
    }

    public final void LC(String str) {
        this.uin = str;
        for (s LC : bxw()) {
            LC.LC(str);
        }
    }

    public final void xo(int i) {
        this.rnd = i;
        for (s xo : bxw()) {
            xo.xo(i);
        }
    }

    protected List<s> bxw() {
        return Collections.emptyList();
    }
}
