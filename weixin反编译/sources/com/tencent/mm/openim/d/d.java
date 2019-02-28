package com.tencent.mm.openim.d;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "OpenIMAppIdInfo")};
    public e gLA;

    public d(e eVar) {
        super(eVar, c.gKN, "OpenIMAppIdInfo", null);
        this.gLA = eVar;
    }

    public final boolean a(c cVar) {
        cVar.field_updateTime = bi.Wx();
        return super.a(cVar);
    }
}
