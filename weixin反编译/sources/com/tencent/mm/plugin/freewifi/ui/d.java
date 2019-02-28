package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static void xd() {
        try {
            c aNm = c.aNm();
            a anonymousClass1 = new a() {
                public final void v(float f, float f2) {
                    try {
                        String valueOf = String.valueOf(f);
                        String valueOf2 = String.valueOf(f2);
                        if (j.aMv().Bw(com.tencent.mm.plugin.freewifi.model.d.aMk()) != null) {
                            g.pWK.h(12073, r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf2, valueOf);
                            x.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf, valueOf2);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e.getMessage() + m.f(e));
                    }
                }
            };
            if (!aNm.bgH) {
                aNm.bgH = true;
                aNm.mNs = c.OV();
                if (aNm.mNs == null) {
                    x.e(c.TAG, "doGeoLocation fail, iGetLocation is null");
                    return;
                }
                if (aNm.jnP == null) {
                    aNm.jnP = new com.tencent.mm.plugin.freewifi.ui.c.AnonymousClass1(anonymousClass1);
                }
                if (aNm.mNt == null) {
                    aNm.mNt = new ag(Looper.myLooper());
                }
                aNm.mNt.postDelayed(new Runnable() {
                    public final void run() {
                        c.this.bgH = false;
                        if (c.this.mNs != null) {
                            c.this.mNs.c(c.this.jnP);
                        }
                        if (c.this.jnP == null) {
                            x.w(c.TAG, "already callback");
                        } else {
                            c.this.jnP = null;
                        }
                    }
                }, 20000);
                aNm.mNs.a(aNm.jnP);
            }
        } catch (Exception e) {
            x.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
        }
    }
}
