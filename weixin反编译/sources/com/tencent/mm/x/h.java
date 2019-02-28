package com.tencent.mm.x;

import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;

public final class h {
    public static int g(au auVar) {
        if (!auVar.aNJ()) {
            return 0;
        }
        a I = a.I(auVar.field_content, auVar.field_reserved);
        if (I == null) {
            return 0;
        }
        return I.type;
    }
}
