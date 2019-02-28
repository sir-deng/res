package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.m.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertImageView";

    private static class a extends f {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onImageViewClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        View bVar = new com.tencent.mm.plugin.appbrand.widget.b(context);
        bVar.setScaleType(ScaleType.FIT_XY);
        return new CoverViewContainer(context, bVar);
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(final p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertImageView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        com.tencent.mm.plugin.appbrand.widget.b bVar = (com.tencent.mm.plugin.appbrand.widget.b) ((CoverViewContainer) view).w(com.tencent.mm.plugin.appbrand.widget.b.class);
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        d.a(view, jSONObject.optJSONObject("style"));
        com.tencent.mm.plugin.appbrand.jsapi.m.a.a(pVar, bVar, jSONObject);
        final com.tencent.mm.y.u.b z = pVar.aeW().z(i, true);
        z.o(SlookAirButtonFrequentContactAdapter.DATA, optString2);
        z.o("sendTo", optString);
        z.o("transEvt", Boolean.valueOf(optBoolean2));
        z.o("clickable", Boolean.valueOf(optBoolean));
        bVar.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (z.hD("clickable")) {
                    a aVar = new a();
                    Map hashMap = new HashMap();
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, z.getString(SlookAirButtonFrequentContactAdapter.DATA, ""));
                    aVar.a(pVar);
                    aVar.v(hashMap);
                    if ("webview".equals(z.getString("sendTo", null))) {
                        aVar.f(new int[]{pVar.hashCode()});
                        return;
                    }
                    aVar.afI();
                }
            }
        });
        bVar.setClickable(optBoolean);
    }
}
