package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.facedetect.b.k.a;
import com.tencent.mm.plugin.facedetect.b.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class g extends i {
    a mkL = new a();
    b mkM = new b();

    g() {
    }

    public final int getType() {
        return 930;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/verifyfacersa";
    }

    public final e Hv() {
        return this.mkM;
    }

    protected final d Hu() {
        return this.mkL;
    }

    public final int Ke() {
        return 1;
    }
}
