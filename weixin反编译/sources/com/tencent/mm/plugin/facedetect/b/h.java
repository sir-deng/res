package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.plugin.facedetect.b.i.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class h extends i {
    a mkN = new a();
    b mkO = new b();

    h() {
    }

    public final int getType() {
        return 733;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getbioconfigrsa";
    }

    public final e Hv() {
        return this.mkO;
    }

    protected final d Hu() {
        return this.mkN;
    }

    public final int Ke() {
        return 1;
    }
}
