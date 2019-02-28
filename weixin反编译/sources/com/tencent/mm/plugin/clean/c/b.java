package com.tencent.mm.plugin.clean.c;

import java.util.ArrayList;
import java.util.Iterator;

public final class b implements Comparable<b> {
    public long fxb;
    public ArrayList<a> lkR;
    public String username;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        if (this.fxb < bVar.fxb) {
            return -1;
        }
        return this.fxb > bVar.fxb ? 1 : 0;
    }

    public final boolean ayH() {
        this.fxb = 0;
        Iterator it = this.lkR.iterator();
        while (it.hasNext()) {
            this.fxb += ((a) it.next()).size;
        }
        if (this.lkR.size() == 0) {
            return false;
        }
        return true;
    }
}
