package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.eu;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class b {

    private static class a {
        private static b mJp = new b();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public final synchronized void a(eu euVar) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String Bg = m.Bg(euVar.fuj.ssid);
        final String str = euVar.fuj.bssid;
        if (m.Bf(Bg)) {
            a(euVar, 1141, "Ssid is empty.");
        } else if (m.Bf(str)) {
            a(euVar, 1142, "Bssid is empty.");
        } else {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + euVar.fuj.ssid + "; bssid=" + euVar.fuj.bssid + "; version=" + euVar.fuj.version);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            com.tencent.mm.plugin.freewifi.b.a.b cH = a.mJl.cH(Bg, str);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (cH != null) {
                final String str2 = cH.fqu;
                int i = cH.mIj;
                if (i == 4) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    ah.y(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.aLP());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            d.b(ad.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    });
                    a(euVar, 1, null);
                } else if (i == 31) {
                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    ah.y(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", Bg);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(ad.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            ad.getContext().startActivity(intent);
                        }
                    });
                    a(euVar, 1, null);
                } else {
                    a(euVar, 1143, "Wechant installed Currently doesn't support connect protocol " + i);
                }
            } else if (a.mJl.size() == 0) {
                a(euVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
            } else {
                a(euVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
            }
        }
    }

    private static void a(eu euVar, int i, String str) {
        euVar.fuk.fun = i;
        euVar.fuk.fuo = str;
        euVar.fuk.fum = 1;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", Integer.valueOf(i), str);
        if (euVar.frD != null) {
            euVar.frD.run();
        }
    }
}
