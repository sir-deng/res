package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.soter.b.c.a;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

final class b extends i {
    a rYe = new a();
    com.tencent.mm.plugin.soter.b.c.b rYf = new com.tencent.mm.plugin.soter.b.c.b();

    b() {
    }

    public final int getType() {
        return 627;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/updatesoteraskrsa";
    }

    public final e Hv() {
        return this.rYf;
    }

    protected final d Hu() {
        return this.rYe;
    }

    public final int Ke() {
        return 1;
    }
}
