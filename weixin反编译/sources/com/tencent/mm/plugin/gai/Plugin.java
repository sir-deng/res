package com.tencent.mm.plugin.gai;

import android.content.Context;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.c.b;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;

public class Plugin implements c {

    public interface a {
        void BV(String str);
    }

    public Plugin() {
        x.i("MicroMsg.Plugin.gai", "gai Plugin!");
        if (!ad.getContext().getSharedPreferences(ad.cgf() + "_google_aid", 4).getBoolean("already_report_googleaid", false)) {
            final Context context = ad.getContext();
            final a anonymousClass1 = new a() {
                public final void BV(String str) {
                    ad.getContext().getSharedPreferences(ad.cgf() + "_google_aid", 4).edit().putString("getgoogleaid", str).commit();
                    String deviceID = q.getDeviceID(ad.getContext());
                    String androidId = q.getAndroidId();
                    String yN = q.yN();
                    String string = ad.getContext().getSharedPreferences(ad.cgf(), 0).getString("installreferer", "");
                    x.i("MicroMsg.Plugin.gai", "Advertisement MAT rsakv logID:%d val:%s", Integer.valueOf(11238), String.format("%s,%s,%s,%s,%s,%s", new Object[]{"", deviceID, androidId, yN, str, string}));
                    g.pWK.a(11238, r0, true, true);
                    ad.getContext().getSharedPreferences(ad.cgf() + "_google_aid", 4).edit().putBoolean("already_report_googleaid", true).commit();
                }
            };
            e.post(new Runnable() {
                public final void run() {
                    String str = "";
                    com.google.android.gms.a.a.a.a aVar = null;
                    try {
                        aVar = com.google.android.gms.a.a.a.x(context);
                        x.d("MicroMsg.Plugin.gai", "adInfo: %s", aVar);
                        if (aVar != null) {
                            str = aVar.aEq;
                            x.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", str);
                        }
                        if (anonymousClass1 != null) {
                            anonymousClass1.BV(str);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Plugin.gai", e, "AdMatReport:: get Ad Id info error %s", e.getMessage());
                        x.e("MicroMsg.Plugin.gai", "AdMatReport:: get Ad Id info error %s", e.getMessage());
                        if (anonymousClass1 != null) {
                            anonymousClass1.BV(str);
                        }
                    } catch (Throwable th) {
                        if (aVar != null) {
                            str = aVar.aEq;
                            x.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", str);
                        }
                        if (anonymousClass1 != null) {
                            anonymousClass1.BV(str);
                        }
                    }
                }
            }, "Advertisement-MAT-thread");
        }
    }

    public p createApplication() {
        return new com.tencent.mm.plugin.gai.a.a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new com.tencent.mm.plugin.gai.b.a();
    }
}
