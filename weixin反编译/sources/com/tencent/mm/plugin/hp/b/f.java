package com.tencent.mm.plugin.hp.b;

import com.tencent.mm.f.a.e;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class f extends c<e> {
    private static long bpv = 0;

    public f() {
        this.xmG = e.class.getName().hashCode();
    }

    private boolean a(e eVar) {
        if (!(eVar.fnJ.fnK || as.Hf())) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - bpv < 21600000) {
                currentTimeMillis = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getLong("tinker_delay_download", 0);
                x.d("MicroMsg.Tinker.TinkerBootsActivateListener", "wait for next time. will check after %d second deployTime:%s", Long.valueOf((21600000 - r2) / 1000), Long.valueOf(currentTimeMillis));
                if (currentTimeMillis > 0 && System.currentTimeMillis() >= currentTimeMillis) {
                    com.tencent.mm.plugin.hp.d.c.a(new a() {
                        public final void a(boolean z, b bVar) {
                            if (z && bVar != null) {
                                new e(bVar).fR(true);
                                g.pWK.a(614, 75, 1, false);
                                x.i("MicroMsg.Tinker.TinkerBootsActivateListener", "process tinker node on activate. It is use bsdiff download.");
                            }
                        }
                    });
                    com.tencent.mm.plugin.hp.tinker.g.g(ad.getContext(), 0);
                }
            } else if (com.tinkerboots.sdk.a.cKg() != null) {
                com.tinkerboots.sdk.a.cKg().om(false);
                x.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
                bpv = currentTimeMillis;
            }
        }
        return false;
    }

    public static void dx(long j) {
        bpv = j;
    }
}
