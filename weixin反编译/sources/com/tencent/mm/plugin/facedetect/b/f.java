package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.plugin.facedetect.b.j.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class f extends i {
    a mkJ = new a();
    b mkK = new b();

    f() {
    }

    public final int getType() {
        return 931;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/registerfacersa";
    }

    public final e Hv() {
        return this.mkK;
    }

    protected final d Hu() {
        return this.mkJ;
    }

    public final int Ke() {
        return 1;
    }
}
