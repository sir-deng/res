package com.tencent.mm.plugin.appbrand.jsapi;

import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class be extends a {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    float jhx = Float.NaN;
    float jhy;

    public final void a(final j jVar, final JSONObject jSONObject, final int i) {
        x.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            jVar.E(i, e("fail:data is null", null));
            x.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            return;
        }
        ah.y(new Runnable() {
            public final void run() {
                float f = 0.01f;
                be.this.jhy = (float) jSONObject.optDouble(Columns.VALUE);
                if (Float.isNaN(be.this.jhy) || be.this.jhy < 0.0f || be.this.jhy > 1.0f) {
                    jVar.E(i, be.this.e("fail:value invalid", null));
                    x.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
                    return;
                }
                final MMActivity a = be.this.a(jVar);
                if (a == null) {
                    jVar.E(i, be.this.e("fail", null));
                    x.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
                    return;
                }
                final LayoutParams attributes = a.getWindow().getAttributes();
                if (Float.isNaN(be.this.jhx)) {
                    be.this.jhx = attributes.screenBrightness;
                    c.a(jVar.mAppId, new b() {
                        public final void a(c.c cVar) {
                            attributes.screenBrightness = be.this.jhx;
                            a.getWindow().setAttributes(attributes);
                        }

                        public final void onResume() {
                            attributes.screenBrightness = be.this.jhy;
                            a.getWindow().setAttributes(attributes);
                        }
                    });
                }
                if (be.this.jhy >= 0.01f) {
                    f = be.this.jhy;
                }
                attributes.screenBrightness = f;
                a.getWindow().setAttributes(attributes);
                jVar.E(i, be.this.e("ok", null));
            }
        });
    }
}
