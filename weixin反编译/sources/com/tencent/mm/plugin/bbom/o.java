package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.f.a.qs;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.network.n;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ak;

public final class o {
    private static boolean kBr = false;

    static /* synthetic */ void arK() {
        if (!g.Do().CF() || a.Cz()) {
            x.w("MicroMsg.OnNetworkAvailableListener", "dealWithNetworkAvailable hasSetuin:" + g.Do().CF() + " isHold:" + a.Cz());
            return;
        }
        m.UM().run();
        com.tencent.mm.modelvideo.o.Ug().run();
        com.tencent.mm.ap.o.PA().run();
        an.bZH().run();
        if (ak.a.hhy != null) {
            ak.a.hhy.GY();
        }
        com.tencent.mm.sdk.b.a.xmy.m(new qs());
    }

    public static synchronized void cc(final Context context) {
        synchronized (o.class) {
            if (!kBr) {
                kBr = true;
                g.Dp().a(new n.a() {
                    public final void eq(int i) {
                        if (i == 4 || i == 6) {
                            o.arK();
                        }
                    }
                });
            }
        }
    }
}
