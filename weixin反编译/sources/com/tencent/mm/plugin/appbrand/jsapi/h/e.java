package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 257;
    private static final String NAME = "showMultiPickerView";

    private final class b extends c implements Runnable {
        private final AtomicReference<com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[]> jsO;

        private b() {
            this.jsO = new AtomicReference();
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        final void s(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
                f("fail:invalid data", null);
            } else if (optJSONArray.length() <= 0) {
                f("fail empty range", null);
            } else {
                try {
                    Object obj = new com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[optJSONArray.length()];
                    int i = 1;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        int i3;
                        JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                        int i4 = optJSONArray2.getInt(i2);
                        String[] strArr = new String[jSONArray.length()];
                        for (i3 = 0; i3 < strArr.length; i3++) {
                            strArr[i3] = jSONArray.getString(i3);
                        }
                        obj[i2] = new com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a(strArr, i4);
                        if (jSONArray.length() <= 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        i &= i3;
                    }
                    if (i != 0) {
                        f("fail empty range", null);
                        return;
                    }
                    this.jsO.set(obj);
                    c.runOnUiThread(this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e, "opt params", new Object[0]);
                    f("fail:invalid data", null);
                }
            }
        }

        public final void run() {
            AppBrandMultiOptionsPicker appBrandMultiOptionsPicker = (AppBrandMultiOptionsPicker) y(AppBrandMultiOptionsPicker.class);
            if (appBrandMultiOptionsPicker == null) {
                f("fail cant init view", null);
                return;
            }
            com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[] aVarArr = (com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a[]) this.jsO.get();
            if (aVarArr == null || aVarArr.length <= 0) {
                f("fail error data", null);
                return;
            }
            if (aVarArr != null && aVarArr.length > 0) {
                int aor = appBrandMultiOptionsPicker.aor();
                appBrandMultiOptionsPicker.T(true);
                if (aor < aVarArr.length) {
                    aor = aVarArr.length - aor;
                    if (aor > 0) {
                        for (int i = aor; i > 0; i--) {
                            View anonymousClass2 = new com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.AnonymousClass2(appBrandMultiOptionsPicker.getContext());
                            anonymousClass2.kkl = appBrandMultiOptionsPicker.kiR;
                            String str = "end";
                            String[] strArr = new String[]{"end", "middle", "start"};
                            for (aor = 0; aor < 3; aor++) {
                                if (strArr[aor].equals(str)) {
                                    anonymousClass2.kjP = str;
                                    break;
                                }
                            }
                            anonymousClass2.kjP = "end";
                            anonymousClass2.setDividerHeight(com.tencent.mm.bu.a.fromDPToPix(appBrandMultiOptionsPicker.getContext(), 1));
                            anonymousClass2.setTag(g.iwR, Integer.valueOf(appBrandMultiOptionsPicker.kiP.getChildCount()));
                            appBrandMultiOptionsPicker.kiP.addView(anonymousClass2, new LayoutParams(0, -1, 1.0f));
                        }
                    }
                } else if (aor > aVarArr.length) {
                    appBrandMultiOptionsPicker.mE(aor - aVarArr.length);
                }
                for (aor = 0; aor < aVarArr.length; aor++) {
                    YANumberPicker mD = appBrandMultiOptionsPicker.mD(aor);
                    com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker.a aVar = aVarArr[aor];
                    mD.j(aVar.kiT);
                    mD.setValue(aVar.kiU);
                    mD.kkl = appBrandMultiOptionsPicker.kiR;
                }
                appBrandMultiOptionsPicker.kiP.setWeightSum((float) appBrandMultiOptionsPicker.aor());
                appBrandMultiOptionsPicker.T(false);
            }
            this.kiC.kjc = new com.tencent.mm.plugin.appbrand.widget.picker.d.a<int[]>() {
                public final /* synthetic */ void f(boolean z, Object obj) {
                    int[] iArr = (int[]) obj;
                    b.this.kiC.hide();
                    if (!z) {
                        b.this.f("cancel", null);
                    } else if (iArr == null || iArr.length <= 0) {
                        b.this.f("fail error result", null);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        for (int put : iArr) {
                            jSONArray.put(put);
                        }
                        Map hashMap = new HashMap(1);
                        hashMap.put("current", jSONArray);
                        b.this.f("ok", hashMap);
                    }
                }
            };
            this.kiC.kje = new com.tencent.mm.plugin.appbrand.widget.picker.d.b<int[]>() {
                public final /* synthetic */ void be(Object obj) {
                    com.tencent.mm.plugin.appbrand.jsapi.c cVar;
                    int[] iArr = (int[]) obj;
                    int i = iArr[0];
                    int i2 = iArr[1];
                    f aVar = new a();
                    Map hashMap = new HashMap(2);
                    hashMap.put("errMsg", "ok");
                    hashMap.put("column", Integer.valueOf(i));
                    hashMap.put("current", Integer.valueOf(i2));
                    aVar.v(hashMap);
                    c cVar2 = b.this;
                    if (cVar2.mPageRef == null) {
                        cVar = null;
                    } else {
                        p cVar3 = (p) cVar2.mPageRef.get();
                    }
                    if (cVar3 != null) {
                        aVar.a(cVar3).f(new int[]{cVar3.hashCode()});
                    }
                }
            };
            this.kiC.show();
        }
    }

    private static final class a extends f {
        private static final int CTRL_INDEX = 259;
        private static final String NAME = "onMultiPickerViewChange";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        new b().a(this, pVar, jSONObject, i);
    }
}
