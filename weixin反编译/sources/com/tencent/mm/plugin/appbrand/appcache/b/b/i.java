package com.tencent.mm.plugin.appbrand.appcache.b.b;

import com.tencent.mm.cc.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

public enum i {
    ;
    
    public volatile boolean iJJ;
    public volatile f<Void> iJK;

    private i(String str) {
        this.iJJ = false;
    }

    public final synchronized void aaE() {
        if (this.iJJ) {
            x.d("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, queueRunning, skip");
        } else if (g.Do().gRj) {
            x.i("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, set flag queue running");
            this.iJJ = true;
            this.iJK = com.tencent.mm.cc.g.cDh();
            this.iJK.j(new a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    i.a(i.this);
                    return null;
                }
            });
        } else {
            x.e("MicroMsg.AppBrand.Predownload.GetCodeRetryLogic", "triggerRetry, account not ready");
        }
    }
}
