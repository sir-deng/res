package com.tencent.mm.insane_statistic;

import com.tencent.mm.ap.r;
import com.tencent.mm.insane_statistic.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;

public class PluginInsaneStatistic extends f implements a {
    public void execute(g gVar) {
        if (gVar.DZ()) {
            r.hEB = new b();
            com.tencent.mm.modelstat.r.hUI = new a();
        }
    }
}
