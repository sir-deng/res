package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.y.aw.b;

final class a extends i {
    com.tencent.mm.y.aw.a smB = new com.tencent.mm.y.aw.a();
    b smC = new b();

    a() {
    }

    public final int getType() {
        return 616;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintresourcersa";
    }

    public final e Hv() {
        return this.smC;
    }

    protected final d Hu() {
        return this.smB;
    }

    public final int Ke() {
        return 1;
    }
}
