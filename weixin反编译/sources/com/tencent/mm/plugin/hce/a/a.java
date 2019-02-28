package com.tencent.mm.plugin.hce.a;

import com.tencent.mm.f.a.ic;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public final class a extends c<ic> {
    public a() {
        this.xmG = ic.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ic icVar = (ic) bVar;
        if (!b.aSZ()) {
            icVar.fzu.errCode = 13000;
            icVar.fzu.foE = "not support NFC";
        } else if (b.aSY()) {
            icVar.fzu.errCode = 0;
            icVar.fzu.foE = "support HCE and system NFC switch is opened";
        } else {
            icVar.fzu.errCode = 13002;
            icVar.fzu.foE = "not support HCE";
        }
        return false;
    }
}
