package com.tencent.mm.compatible.i;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    private static int gIU = 0;

    public static boolean zj() {
        if (b.zg()) {
            boolean z;
            u uVar = q.gHK;
            if (!ad.cgj()) {
                uVar.gIi = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 4).getInt("update_swip_back_status", 0);
            }
            if (uVar.gIi == 1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
        }
        if (gIU == 0) {
            SharedPreferences cgg = ad.cgg();
            if (cgg == null || !cgg.getBoolean("settings_support_swipe", true)) {
                gIU = 2;
            } else {
                gIU = 1;
            }
        }
        if (gIU == 1) {
            return true;
        }
        return false;
    }

    public static void bk(boolean z) {
        SharedPreferences cgg = ad.cgg();
        if (cgg.getBoolean("settings_support_swipe", true) != z) {
            cgg.edit().putBoolean("settings_support_swipe", z).commit();
        }
        x.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
    }
}
