package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.f.a.hw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;

public final class g extends c<hw> {
    public g() {
        this.xmG = hw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hw hwVar = (hw) bVar;
        if (hwVar != null) {
            hwVar.fzg.fzi = TenpayUtil.signWith3Des("passwd=" + hwVar.fzf.fzh);
            x.v("MicroMsg.GetWcPaySignEventListener", "alvinluo wcpaysign: %s", hwVar.fzg.fzi);
        }
        return false;
    }
}
