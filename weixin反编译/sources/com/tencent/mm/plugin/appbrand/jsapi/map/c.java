package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.u.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 134;
    public static final String NAME = "addMapLines";

    protected final int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapLines", "get mapId error, exception : %s", e);
            return i;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        b z = pVar.aeW().z(i, false);
        if (z == null) {
            x.e("MicroMsg.JsApiAddMapLines", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (view instanceof CoverViewContainer) {
            try {
                com.tencent.mm.plugin.appbrand.compat.a.b bE = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
                if (jSONObject == null) {
                    x.e("MicroMsg.JsApiAddMapLines", "data is null");
                    return false;
                }
                x.d("MicroMsg.JsApiAddMapLines", "onUpdateView, data:%s", jSONObject.toString());
                try {
                    if (jSONObject.has("lines")) {
                        List list;
                        int i2;
                        int i3;
                        List list2 = (List) z.get("map_line", null);
                        if (list2 == null) {
                            ArrayList arrayList = new ArrayList();
                            z.o("map_line", arrayList);
                            list = arrayList;
                        } else {
                            list = list2;
                        }
                        if (list.size() > 0) {
                            i2 = 0;
                            while (true) {
                                i3 = i2;
                                if (i3 >= list.size()) {
                                    break;
                                }
                                ((o) list.get(i3)).remove();
                                i2 = i3 + 1;
                            }
                            list.clear();
                        }
                        JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                        i2 = 0;
                        while (true) {
                            int i4 = i2;
                            if (i4 >= jSONArray.length()) {
                                break;
                            }
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i4);
                            Iterable arrayList2 = new ArrayList();
                            JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                            for (i3 = 0; i3 < jSONArray2.length(); i3++) {
                                JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
                                arrayList2.add(bE.e((double) bi.getFloat(jSONObject3.optString("latitude"), 0.0f), (double) bi.getFloat(jSONObject3.optString("longitude"), 0.0f)));
                            }
                            i3 = f.aR(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                            int a = f.a(jSONObject2, "width", 0);
                            boolean optBoolean = jSONObject2.optBoolean("dottedLine", false);
                            int aR = f.aR(jSONObject2.optString("borderColor", ""), Color.parseColor("#000000"));
                            int a2 = f.a(jSONObject2, "borderWidth", 0);
                            boolean optBoolean2 = jSONObject2.optBoolean("arrowLine", false);
                            String optString = jSONObject2.optString("arrowIconPath", "");
                            com.tencent.mm.plugin.appbrand.compat.a.b.p abO = bE.abO();
                            abO.a(arrayList2);
                            abO.jQ(i3);
                            abO.jR(a);
                            abO.setDottedLine(optBoolean);
                            abO.jS(aR);
                            abO.jT(a2);
                            if (optBoolean2) {
                                Object obj = 1;
                                Bitmap decodeFile;
                                if (!bi.oN(optString) && optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                                    AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                                    if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.hjJ)) {
                                        x.e("MicroMsg.JsApiAddMapLines", "arrowIconPath:%s, item is null", optString);
                                    } else {
                                        x.d("MicroMsg.JsApiAddMapLines", "fileFullPath:%s", itemByLocalId.hjJ);
                                        decodeFile = d.decodeFile(itemByLocalId.hjJ, null);
                                        if (decodeFile != null) {
                                            abO.q(decodeFile);
                                            obj = null;
                                        } else {
                                            x.e("MicroMsg.JsApiAddMapLines", "BitmapUtil decode fail, mLocalBitmap is null, use default");
                                        }
                                    }
                                } else if (!bi.oN(optString)) {
                                    decodeFile = com.tencent.mm.plugin.appbrand.page.o.j(pVar.iuk, optString);
                                    if (decodeFile != null) {
                                        obj = null;
                                        abO.q(decodeFile);
                                    } else {
                                        x.e("MicroMsg.JsApiAddMapLines", "arrowIconPath:%s, AppBrandPageIconCache.getIcon fail, mLocalBitmap is null", optString);
                                    }
                                }
                                if (obj != null) {
                                    abO.q(BitmapFactory.decodeStream(ad.getContext().getAssets().open("app_brand_map_line_texture_arrow.png")));
                                }
                            }
                            list.add(bE.a(abO));
                            i2 = i4 + 1;
                        }
                    } else {
                        x.e("MicroMsg.JsApiAddMapLines", "data has not lines info");
                    }
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiAddMapLines", "parse lines error, exception : %s", e);
                    return false;
                }
            } catch (Exception e2) {
                x.e("MicroMsg.JsApiAddMapLines", "get SoSoMapView(%s) by id failed, exception : %s", Integer.valueOf(i), e2);
                return false;
            }
        } else {
            x.w("MicroMsg.JsApiAddMapLines", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }
}
