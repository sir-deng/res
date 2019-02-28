package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.e;
import com.tencent.mm.plugin.aa.a.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;

public final class d extends a {
    l ijO = new l();
    e ijP = new e();

    protected final void onCreate() {
        super.onCreate();
        x.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onCreate");
        com.tencent.mm.ad.e WV = this.ijO.WV();
        g.Dr();
        g.Dp().gRu.a(1624, WV);
        g.Dr();
        g.Dp().gRu.a(1655, WV);
        WV = this.ijP.WQ();
        x.i("MicroMsg.AAOperationData", "init");
        g.Dr();
        g.Dp().gRu.a(1698, WV);
    }

    protected final void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.LaunchAAInteractor", "LaunchAAInteractor, onDestroy");
        com.tencent.mm.ad.e WV = this.ijO.WV();
        g.Dr();
        g.Dp().gRu.b(1624, WV);
        g.Dr();
        g.Dp().gRu.b(1655, WV);
        WV = this.ijP.WQ();
        x.i("MicroMsg.AAOperationData", "uninit");
        g.Dr();
        g.Dp().gRu.b(1698, WV);
    }
}
