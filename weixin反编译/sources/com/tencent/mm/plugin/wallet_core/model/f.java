package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class f {
    public int sRJ;
    public String sRK;
    public String sRL;
    public String sRM;
    public String sRN;
    public String sRO;

    public static f Nv(String str) {
        if (!bi.oN(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                f fVar = new f();
                fVar.sRJ = jSONObject.optInt("menu_jump_type", -1);
                fVar.sRK = jSONObject.optString("menu_jump_url", "");
                fVar.sRL = jSONObject.optString("menu_username", "");
                fVar.sRM = jSONObject.optString("menu_path", "");
                fVar.sRN = jSONObject.optString("menu_title", "");
                fVar.sRO = jSONObject.optString("menu_icon_url", "");
                x.i("BindCardMenu", "parse bind card menu, type: %s, title: %s", Integer.valueOf(fVar.sRJ), fVar.sRN);
                return fVar;
            } catch (Throwable e) {
                x.printErrStackTrace("BindCardMenu", e, "", new Object[0]);
            }
        }
        return null;
    }
}
