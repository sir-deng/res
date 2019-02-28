package com.tencent.mm.plugin.appbrand.jsapi.lbs;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        try {
            float f = bi.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f2 = bi.getFloat(jSONObject.optString("longitude"), 0.0f);
            String vk = c.vk(jSONObject.optString("name"));
            String vk2 = c.vk(jSONObject.optString("address"));
            try {
                i2 = bi.getInt(jSONObject.optString("scale"), 0);
            } catch (Exception e) {
            }
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 7);
            intent.putExtra("kwebmap_slat", (double) f);
            intent.putExtra("kwebmap_lng", (double) f2);
            if (i2 > 0) {
                intent.putExtra("kwebmap_scale", i2);
            }
            intent.putExtra("kPoiName", vk);
            intent.putExtra("Kwebmap_locaion", vk2);
            Context a = a(jVar);
            if (a == null) {
                jVar.E(i, e("fail", null));
                return;
            }
            d.b(a, "location", ".ui.RedirectUI", intent);
            jVar.E(i, e("ok", null));
        } catch (Exception e2) {
            jVar.E(i, e("invalid_coordinate", null));
        }
    }
}
