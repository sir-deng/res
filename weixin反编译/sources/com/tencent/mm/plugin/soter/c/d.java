package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.f.a.cl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<cl> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public d() {
        this.xmG = cl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i(TAG, "alvinluo dynamic config updated.");
        h.bDA();
        return true;
    }
}
