package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.x.g;

public final class k extends i<g> {
    public static final String[] gLy = new String[]{i.a(g.gKN, "AppMessage")};

    public k(e eVar) {
        super(eVar, g.gKN, "AppMessage", null);
    }

    public final g fq(long j) {
        c gVar = new g();
        gVar.field_msgId = j;
        return super.b(gVar, new String[0]) ? gVar : null;
    }
}
