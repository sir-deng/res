package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.d;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends c {
    private static final int CTRL_INDEX = 447;
    public static final String NAME = "updateScrollView";

    protected final int j(JSONObject jSONObject) {
        return jSONObject.getInt("viewId");
    }

    protected final boolean c(final p pVar, final int i, View view, JSONObject jSONObject) {
        x.d("MicroMsg.JsApiUpdateScrollView", "onUpdateView(viewId : %s, %s)", Integer.valueOf(i), jSONObject);
        if (view instanceof WxaScrollView) {
            WxaScrollView wxaScrollView = (WxaScrollView) view;
            d.a(view, jSONObject.optJSONObject("style"));
            try {
                if (jSONObject.getBoolean("needScrollEvent")) {
                    wxaScrollView.jmF = new l() {
                        public final void h(View view, int i, int i2) {
                            if (view instanceof WxaScrollView) {
                                b z = pVar.aeW().z(i, false);
                                if (z != null) {
                                    String string = z.getString(SlookAirButtonFrequentContactAdapter.DATA, null);
                                    if (string != null) {
                                        View view2 = ((WxaScrollView) view).jmD;
                                        Map hashMap = new HashMap();
                                        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, string);
                                        hashMap.put("scrollLeft", Integer.valueOf(f.lZ(i)));
                                        hashMap.put("scrollTop", Integer.valueOf(f.lZ(i2)));
                                        hashMap.put("scrollWidth", Integer.valueOf(f.lZ(view2.getWidth())));
                                        hashMap.put("scrollHeight", Integer.valueOf(f.lZ(view2.getHeight())));
                                        new k().a(pVar).v(hashMap).afI();
                                    }
                                }
                            }
                        }
                    };
                } else {
                    wxaScrollView.jmF = null;
                }
            } catch (JSONException e) {
            }
            return super.c(pVar, i, view, jSONObject);
        }
        x.w("MicroMsg.JsApiUpdateScrollView", "the view(%s) is not a instance of WxaScrollView", Integer.valueOf(i));
        return false;
    }
}
