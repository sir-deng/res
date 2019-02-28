package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.mm.f.a.rf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<rf> {
    private ag mHandler;

    public d() {
        this.mHandler = new ag(Looper.getMainLooper());
        this.xmG = rf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rf rfVar = (rf) bVar;
        if (g.Do().CF() && (rfVar instanceof rf)) {
            x.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = rfVar.fJN.fJO;
            final boolean z2 = rfVar.fJN.scene == 1;
            if (z2) {
                com.tencent.mm.plugin.report.service.g.pWK.a(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable() {
                    public final void run() {
                        if (g.Do().CF()) {
                            k.bhD();
                            k.bhG().hh(z2);
                        }
                    }
                }, 10000);
            } else {
                k.bhD();
                k.bhG().hh(z2);
            }
        }
        return false;
    }
}
