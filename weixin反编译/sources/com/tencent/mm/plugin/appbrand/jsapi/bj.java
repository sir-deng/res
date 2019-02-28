package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ObjectAnimator;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.plugin.appbrand.widget.c.AnonymousClass5;
import org.json.JSONObject;

public final class bj extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "showTabBar";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        l ajy = jVar.iuk.isX.ajy();
        if (ajy instanceof e) {
            int i2;
            c cVar = ((e) ajy).jIy;
            boolean optBoolean = jSONObject.optBoolean("animation", true);
            String str = "translationY";
            float[] fArr = new float[2];
            int height = cVar.getHeight();
            if ("top".equals(cVar.kah)) {
                i2 = -1;
            } else {
                i2 = 1;
            }
            fArr[0] = (float) (i2 * height);
            fArr[1] = 0.0f;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar, str, fArr);
            ofFloat.setDuration(optBoolean ? 250 : 0);
            cVar.post(new AnonymousClass5(ofFloat));
            jVar.E(i, e("ok", null));
            return;
        }
        jVar.E(i, e("fail:not TabBar page", null));
    }
}
