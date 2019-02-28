package com.tencent.mm.plugin.soter.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.d.a.a;
import com.tencent.d.a.c.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static c bDz() {
        SharedPreferences cgg = ad.cgg();
        if (cgg == null) {
            return new c();
        }
        String string = cgg.getString("cpu_id", "");
        String string2 = cgg.getString("uid", "");
        if (bi.oN(string) || bi.oN(string2)) {
            x.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            h cGG = a.cGG();
            if (cGG != null) {
                string = cGG.rYp;
                string2 = String.valueOf(cGG.uid);
                if (!(bi.oN(string) || bi.oN(string2))) {
                    ex(string, string2);
                    return new c(string, string2);
                }
            }
            return new c();
        }
        x.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        return new c(string, string2);
    }

    public static void ex(String str, String str2) {
        SharedPreferences cgg = ad.cgg();
        if (cgg != null) {
            x.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
            Editor edit = cgg.edit();
            edit.putString("cpu_id", str);
            edit.putString("uid", str2);
            edit.apply();
        }
    }
}
