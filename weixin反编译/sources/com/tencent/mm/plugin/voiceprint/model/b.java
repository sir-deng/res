package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.i;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.y.ax.a;

final class b extends i {
    a smD = new a();
    com.tencent.mm.y.ax.b smE = new com.tencent.mm.y.ax.b();

    b() {
    }

    public final int getType() {
        return 618;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/getvoiceprintticketrsa";
    }

    public final e Hv() {
        return this.smE;
    }

    protected final d Hu() {
        return this.smD;
    }

    public final int Ke() {
        return 1;
    }
}
