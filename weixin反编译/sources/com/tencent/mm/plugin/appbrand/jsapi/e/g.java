package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.Rect;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.input.b.f;
import com.tencent.mm.plugin.appbrand.widget.input.b.h;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a<h> {
    private static final int CTRL_INDEX = 112;
    private static final String NAME = "updateInput";

    public void a(p pVar, JSONObject jSONObject, int i) {
        final f hVar = new h();
        if (a(hVar, jSONObject, pVar, i)) {
            try {
                final int i2 = jSONObject.getInt("inputId");
                if (hVar.khv != null && hVar.khv.intValue() < 0) {
                    hVar.khv = Integer.valueOf(0);
                }
                if (hVar.khw != null && hVar.khw.intValue() < 0) {
                    hVar.khw = Integer.valueOf(0);
                }
                String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA, null);
                if (optString != null) {
                    a.J(i2, optString);
                }
                final p pVar2 = pVar;
                final int i3 = i;
                c.runOnUiThread(new Runnable() {
                    public final void run() {
                        Object obj;
                        com.tencent.mm.plugin.appbrand.widget.input.h ani = a.kcY;
                        int i = i2;
                        h hVar = hVar;
                        com.tencent.mm.plugin.appbrand.widget.input.c cVar = (com.tencent.mm.plugin.appbrand.widget.input.c) ani.kcT.get(Integer.valueOf(i));
                        if (cVar != null) {
                            if (hVar.khu != null) {
                                cVar.vC(hVar.khu);
                            }
                            cVar.a(hVar);
                            View anc = cVar.anc();
                            if (anc != null) {
                                p pVar = (p) cVar.kcw.get();
                                if (!(pVar == null || pVar.jJw == null)) {
                                    com.tencent.mm.plugin.appbrand.widget.input.f fVar = pVar.jJv;
                                    if (fVar != null) {
                                        Rect and = cVar.and();
                                        fVar.b(pVar.jJw, anc, and.width(), and.height(), and.left, and.top);
                                    }
                                }
                            }
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            pVar2.E(i3, g.this.e("ok", null));
                        } else if (m.a(hVar, i2)) {
                            pVar2.E(i3, g.this.e("ok", null));
                        } else {
                            pVar2.E(i3, g.this.e("fail", null));
                        }
                    }
                });
            } catch (JSONException e) {
                pVar.E(i, e("fail:invalid data", null));
            }
        }
    }

    protected final boolean agA() {
        return true;
    }
}
