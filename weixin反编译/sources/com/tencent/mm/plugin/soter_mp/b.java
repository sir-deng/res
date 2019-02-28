package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.plugin.soter_mp.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public final class b implements ap {
    private static com.tencent.mm.plugin.soter_mp.b.b rYV = new com.tencent.mm.plugin.soter_mp.b.b();
    private static a rYW = new a();

    public final HashMap<Integer, d> Bu() {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter getBaseDBFactories");
        return null;
    }

    public final void ge(int i) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter clearPluginData");
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoter onAccountPostReset");
        if (!com.tencent.mm.sdk.b.a.xmy.d(rYV)) {
            com.tencent.mm.sdk.b.a.xmy.b(rYV);
        }
        if (!com.tencent.mm.sdk.b.a.xmy.d(rYW)) {
            com.tencent.mm.sdk.b.a.xmy.b(rYW);
        }
    }

    public final void bt(boolean z) {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onSdcardMount");
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSoterMp", "hy: on SubCoreSoterMp onAccountRelease");
    }
}
