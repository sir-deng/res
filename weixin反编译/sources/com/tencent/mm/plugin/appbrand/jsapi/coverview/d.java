package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.base.a {
    private static final int CTRL_INDEX = 253;
    public static final String NAME = "insertTextView";

    private static class a extends f {
        private static final int CTRL_INDEX = 256;
        private static final String NAME = "onTextViewClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        return new CoverViewContainer(context, new com.tencent.mm.plugin.appbrand.widget.f(context));
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final void a(final p pVar, int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiInsertTextView", "onInsertView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        com.tencent.mm.plugin.appbrand.widget.f fVar = (com.tencent.mm.plugin.appbrand.widget.f) ((CoverViewContainer) view).w(com.tencent.mm.plugin.appbrand.widget.f.class);
        boolean optBoolean = jSONObject.optBoolean("clickable");
        boolean optBoolean2 = jSONObject.optBoolean("transEvt");
        String optString = jSONObject.optString("sendTo", "appservice");
        String optString2 = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, "");
        com.tencent.mm.plugin.appbrand.jsapi.m.a.a(fVar, jSONObject.optJSONObject("label"));
        com.tencent.mm.plugin.appbrand.jsapi.m.d.a(view, jSONObject.optJSONObject("style"));
        final b z = pVar.aeW().z(i, true);
        z.o(SlookAirButtonFrequentContactAdapter.DATA, optString2);
        z.o("sendTo", optString);
        z.o("transEvt", Boolean.valueOf(optBoolean2));
        z.o("clickable", Boolean.valueOf(optBoolean));
        fVar.setOnClickListener(new OnClickListener() {
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
        fVar.setClickable(optBoolean);
    }
}
