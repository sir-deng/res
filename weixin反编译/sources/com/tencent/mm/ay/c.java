package com.tencent.mm.ay;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e {
    private static c hLb;
    private int hLa = 3;
    private boolean hlc = false;

    public static c QI() {
        if (hLb == null) {
            hLb = new c();
        }
        return hLb;
    }

    public final void update() {
        x.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.hlc);
        x.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.Dq().isSDCardAvailable());
        if (!this.hlc && g.Dq().isSDCardAvailable()) {
            release();
            this.hlc = true;
            g.Dp().gRu.a((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
            g.Dp().gRu.a(new k(7), 0);
        }
    }

    private void release() {
        this.hlc = false;
        g.Dp().gRu.b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            x.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                g.Dq().Db().set(81938, Long.valueOf(bi.Wx()));
            } else {
                int i3 = this.hLa - 1;
                this.hLa = i3;
                if (i3 < 0) {
                    g.Dq().Db().set(81938, Long.valueOf(((bi.Wy() - 86400000) + 3600000) / 1000));
                    this.hLa = 3;
                }
            }
            release();
        }
    }
}
