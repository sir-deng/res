package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends i<c> {
    public static final String[] gLy = new String[]{i.a(c.gKN, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    public d(e eVar) {
        super(eVar, c.gKN, "FreeWifiInfo", null);
    }

    public final c Bv(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + ac.VF(str) + "' and wifiType = 1");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c Bw(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", "select * from FreeWifiInfo where ssidmd5 = '" + ac.VF(str) + "'");
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c aMX() {
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", "select * from FreeWifiInfo where connectState = 2");
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final void Bx(String str) {
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", "update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + ac.VF(str) + "'");
        boolean fD = fD("FreeWifiInfo", r0);
        x.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", Boolean.valueOf(fD));
    }
}
