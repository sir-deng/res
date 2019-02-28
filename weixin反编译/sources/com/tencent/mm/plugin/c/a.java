package com.tencent.mm.plugin.c;

import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements p {
    public static volatile n ihN;
    public static volatile m ihO;

    public final void a(n nVar) {
        ihN = nVar;
    }

    public final void a(m mVar) {
        x.i("MicroMsg.AccountSyncApplication", "regitMMModelCallback %s", mVar);
        ihO = mVar;
    }
}
