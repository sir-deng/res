package com.tencent.mm.plugin.hardwareopt.b;

import com.tencent.mm.protocal.c.akn;

public class a {
    private static volatile a nFQ = null;
    private akn nFR = null;

    private a() {
    }

    public static a aSV() {
        if (nFQ != null) {
            return nFQ;
        }
        a aVar;
        synchronized (a.class) {
            if (nFQ == null) {
                nFQ = new a();
            }
            aVar = nFQ;
        }
        return aVar;
    }

    public final akn aSW() {
        if (this.nFR == null) {
            this.nFR = new akn();
        }
        return this.nFR;
    }
}
