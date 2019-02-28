package com.tencent.mm.plugin.freewifi.c;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class a {
    public String bssid;
    public String mJA;
    public String mJB;
    public long mJC;
    public String mJD;
    public long mJE;
    public String ssid;
    public String type;
    public long uin;

    private a() {
    }

    public static a Bm(String str) {
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", str);
        if (m.Bf(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            return null;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", str);
        Map y = bj.y(str, "sysmsg");
        if (y == null || y.size() == 0) {
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            return null;
        }
        x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + y.toString());
        if ("freewifi".equalsIgnoreCase((String) y.get(".sysmsg.$type"))) {
            a aVar = new a();
            aVar.type = (String) y.get(".sysmsg.type");
            x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
            if ("schemamsg".equals(aVar.type)) {
                boolean k = m.k(y, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=" + k);
                if (k) {
                    aVar.uin = bi.getLong((String) y.get(".sysmsg.uin"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
                    aVar.ssid = (String) y.get(".sysmsg.schemamsg.ssid");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
                    if (m.Bf(aVar.ssid)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        return null;
                    }
                    aVar.bssid = m.Bh((String) y.get(".sysmsg.schemamsg.bssid"));
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
                    aVar.mJA = (String) y.get(".sysmsg.schemamsg.mobilemac");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.mJA);
                    if (m.Bf(aVar.mJA)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        return null;
                    }
                    aVar.mJB = (String) y.get(".sysmsg.schemamsg.mpappid");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.mJB);
                    aVar.mJC = bi.getLong((String) y.get(".sysmsg.schemamsg.mpshopid"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.mJC);
                    aVar.mJD = (String) y.get(".sysmsg.schemamsg.schemaurl");
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.mJD);
                    if (m.Bf(aVar.mJD)) {
                        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        return null;
                    }
                    aVar.mJE = bi.getLong((String) y.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    x.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.mJE);
                    return aVar;
                }
                x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                return null;
            }
            x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            return null;
        }
        x.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        return null;
    }
}
