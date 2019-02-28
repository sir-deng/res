package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class h extends c {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h.h$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ a jsY;

        AnonymousClass2(a aVar) {
            this.jsY = aVar;
        }

        public final void run() {
            if (this.jsY.kja != null && (this.jsY.kja instanceof View)) {
                ((View) this.jsY.kja).requestLayout();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.h.h$3 */
    class AnonymousClass3 implements d.a<String> {
        final /* synthetic */ a jsY;
        final /* synthetic */ AppBrandOptionsPicker jsZ;

        AnonymousClass3(a aVar, AppBrandOptionsPicker appBrandOptionsPicker) {
            this.jsY = aVar;
            this.jsZ = appBrandOptionsPicker;
        }

        public final /* synthetic */ void f(boolean z, Object obj) {
            this.jsY.hide();
            if (z) {
                Map hashMap = new HashMap(2);
                hashMap.put(Columns.VALUE, this.jsZ.aos());
                hashMap.put("index", Integer.valueOf(this.jsZ.getValue()));
                h.this.f("ok", hashMap);
                return;
            }
            h.this.f("cancel", null);
        }
    }

    h() {
    }

    final void s(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("array");
        final int optInt = jSONObject.optInt("current", 0);
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            f("fail:invalid data", null);
            return;
        }
        final String[] strArr = new String[optJSONArray.length()];
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                strArr[i] = optJSONArray.getString(i);
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrand.JsApi.OptionsPickerHandler", "opt data.array, exp = %s", bi.i(e));
                f("fail", null);
                return;
            }
        }
        c.runOnUiThread(new Runnable() {
            public final void run() {
                b bVar = h.this;
                String[] strArr = strArr;
                int i = optInt;
                AppBrandOptionsPicker appBrandOptionsPicker = (AppBrandOptionsPicker) bVar.y(AppBrandOptionsPicker.class);
                if (appBrandOptionsPicker == null) {
                    bVar.f("fail cant init view", null);
                    return;
                }
                d dVar = bVar.kiC;
                dVar.post(new AnonymousClass2(dVar));
                appBrandOptionsPicker.j(strArr);
                appBrandOptionsPicker.setValue(i);
                dVar.kjc = new AnonymousClass3(dVar, appBrandOptionsPicker);
                dVar.show();
            }
        });
    }
}
