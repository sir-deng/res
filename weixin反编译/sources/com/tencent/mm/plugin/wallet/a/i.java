package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.f.a.hf;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

public final class i extends c<hf> {
    public i() {
        this.xmG = hf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        hf hfVar = (hf) bVar;
        if (!(hfVar instanceof hf)) {
            return false;
        }
        hfVar.fyl.fyn = o.bMc().bMB();
        String azW = o.bMc().azW();
        if (bi.oN(azW)) {
            hfVar.fyl.fym = "";
        } else {
            String str = "";
            while (i < azW.length() - 1) {
                str = str + "*";
                i++;
            }
            hfVar.fyl.fym = str + azW.substring(azW.length() - 1, azW.length());
        }
        return true;
    }
}
