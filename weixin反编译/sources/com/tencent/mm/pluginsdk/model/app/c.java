package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c extends i<b> {
    public static final String[] gLy = new String[]{i.a(b.gKN, "appattach")};
    e gLA;

    public c(e eVar) {
        super(eVar, b.gKN, "appattach", null);
        this.gLA = eVar;
    }

    public final b Se(String str) {
        b bVar = new b();
        bVar.field_mediaSvrId = str;
        if (b((com.tencent.mm.sdk.e.c) bVar, "mediaSvrId")) {
            return bVar;
        }
        return !b((com.tencent.mm.sdk.e.c) bVar, "mediaId") ? null : bVar;
    }

    public final b fp(long j) {
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_msgInfoId = j;
        return b(bVar, "msgInfoId") ? bVar : null;
    }
}
