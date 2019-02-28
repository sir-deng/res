package com.tencent.mm.openim.d;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class a extends i<b> {
    public static final String[] gLy = new String[]{i.a(b.gKN, "OpenIMAccTypeInfo")};
    private e gLA;

    public a(e eVar) {
        super(eVar, b.gKN, "OpenIMAccTypeInfo", null);
        this.gLA = eVar;
    }

    public final boolean a(b bVar) {
        bVar.field_updateTime = bi.Wx();
        return super.a(bVar);
    }
}
