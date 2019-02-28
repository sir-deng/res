package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.plugin.appbrand.widget.picker.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    private static final int CTRL_INDEX = 258;
    private static final String NAME = "updateMultiPickerView";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        new c() {
            static /* synthetic */ e a(AnonymousClass1 anonymousClass1, Class cls) {
                d dD = super.dD(false);
                return (dD == null || !cls.isInstance(dD.kja)) ? null : dD.kja;
            }

            final void s(JSONObject jSONObject) {
                final int optInt = jSONObject.optInt("column", -1);
                JSONArray optJSONArray = jSONObject.optJSONArray("array");
                if (optInt < 0 || optJSONArray == null || optJSONArray.length() < 0) {
                    f("fail:invalid data", null);
                    return;
                }
                try {
                    String[] strArr = new String[optJSONArray.length()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = optJSONArray.getString(i);
                    }
                    final AppBrandMultiOptionsPicker.a aVar = new AppBrandMultiOptionsPicker.a(strArr, jSONObject.optInt("current", 0));
                    c.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) AnonymousClass1.a(AnonymousClass1.this, AppBrandMultiOptionsPicker.class);
                            if (appBrandMultiOptionsPicker == null) {
                                AnonymousClass1.this.f("fail picker not exists", null);
                                return;
                            }
                            int i = optInt;
                            AppBrandMultiOptionsPicker.a aVar = aVar;
                            if (i >= 0 && i < appBrandMultiOptionsPicker.aor() && aVar != null) {
                                appBrandMultiOptionsPicker.T(true);
                                appBrandMultiOptionsPicker.mD(i).j(aVar.kiT);
                                if (!bi.G(aVar.kiT)) {
                                    appBrandMultiOptionsPicker.mD(i).setValue(aVar.kiU);
                                }
                                appBrandMultiOptionsPicker.T(false);
                            }
                            AnonymousClass1.this.f("ok", null);
                        }
                    });
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.JsApiUpdateMultiPickerView", e, "opt params", new Object[0]);
                    f("fail:invalid data", null);
                }
            }
        }.a(this, pVar, jSONObject, i);
    }
}
