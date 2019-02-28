package com.tencent.mm.plugin.card.model;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class j extends i<i> {
    public static final String[] gLy = new String[]{i.a(i.gKN, "CardQrCodeConfi")};
    private e gLA;

    public j(e eVar) {
        super(eVar, i.gKN, "CardQrCodeConfi", null);
        this.gLA = eVar;
    }

    public final i wM(String str) {
        c iVar = new i();
        iVar.field_card_id = str;
        return b(iVar, new String[0]) ? iVar : null;
    }
}
