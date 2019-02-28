package com.tencent.mm.ad;

import com.tencent.mm.network.q;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.k.d;

public abstract class i implements q {
    private d hog;
    public boolean hoh = false;

    public abstract d Hu();

    public final d Kh() {
        if (this.hog == null) {
            this.hog = Hu();
            d dVar = this.hog;
            dVar.vHU = com.tencent.mm.compatible.e.q.yM();
            dVar.vHT = com.tencent.mm.protocal.d.DEVICE_TYPE;
            dVar.vHS = com.tencent.mm.protocal.d.vHl;
            dVar.eE(a.vHH.Hs());
        }
        return this.hog;
    }

    public int Ke() {
        return 0;
    }

    public final boolean Ki() {
        return this.hoh;
    }
}
