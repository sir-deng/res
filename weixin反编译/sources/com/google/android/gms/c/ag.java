package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ag<T extends ag> {
    public final ah aYj;
    protected final ae aYk;
    private final List<Object> aYl = new ArrayList();

    public ag(ah ahVar, v vVar) {
        w.ag(ahVar);
        this.aYj = ahVar;
        ae aeVar = new ae(this, vVar);
        aeVar.aYg = true;
        this.aYk = aeVar;
    }

    public void a(ae aeVar) {
    }

    public ae nL() {
        ae pO = this.aYk.pO();
        pR();
        return pO;
    }

    public final ae pP() {
        return this.aYk;
    }

    public final List<ai> pQ() {
        return this.aYk.aYi;
    }

    public final void pR() {
        Iterator it = this.aYl.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
