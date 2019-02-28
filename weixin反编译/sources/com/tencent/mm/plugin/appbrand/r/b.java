package com.tencent.mm.plugin.appbrand.r;

import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public String appId;
    public a jXx = new a() {
        public final void amn() {
            x.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
            k.sz(b.this.appId);
        }
    };
}
