package com.tencent.mm.compatible.e;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class u {
    public static boolean gIf = false;
    public String gIg = "";
    Map<String, String> gIh = null;
    public int gIi = 0;

    public final void fL(int i) {
        this.gIi = i;
        gIf = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        x.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.gIi));
    }

    public static boolean zb() {
        if (!gIf) {
            return false;
        }
        gIf = false;
        return true;
    }

    public final void eL(String str) {
        this.gIg = str;
    }

    public final void i(Map<String, String> map) {
        this.gIh = map;
    }
}
