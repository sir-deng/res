package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    private static class a {
        private static b mKG = new b();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    public static b aMR() {
        return a.mKG;
    }

    public static void I(Intent intent) {
        boolean z = true;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("free_wifi_ap_key");
            if (!m.Bf(stringExtra)) {
                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                if (2 == intExtra) {
                    intExtra = 11;
                } else if (3 == intExtra) {
                    intExtra = 12;
                } else if (4 == intExtra) {
                    intExtra = 13;
                } else {
                    intExtra = 1;
                }
                intent.putExtra("free_wifi_channel_id", intExtra);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.D(intent) + "_" + m.F(intent) + "_" + m.G(intent) + "_" + System.currentTimeMillis());
                boolean j = a.mKL.j(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
                com.tencent.mm.plugin.freewifi.k.a aLL = k.aLL();
                aLL.ssid = m.Bi(TAG);
                aLL.bssid = m.Bj(TAG);
                aLL.fqu = stringExtra;
                aLL.mIi = intent.getStringExtra("free_wifi_schema_ticket");
                aLL.mIj = m.F(intent);
                aLL.mIk = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.mIW;
                aLL.mIl = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.name;
                aLL.fDM = m.G(intent);
                aLL.result = j ? 0 : -1;
                k aLN = aLL.aLN();
                if (j) {
                    z = false;
                }
                aLN.b(intent, z).aLM();
                x.i(TAG, "getLock = " + j);
                m.Bl("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + j);
                if (j) {
                    m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                    intent.setClass(ad.getContext(), FreeWifiNetCheckUI.class);
                    intent.addFlags(67108864);
                    d.b(ad.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                }
            }
        }
    }
}
