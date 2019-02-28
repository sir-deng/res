package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    private static class a extends f {
        private static final int CTRL_INDEX = 143;
        private static final String NAME = "onMapControlClick";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    protected final int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapControls", "get mapId error, exception : %s", e);
            return i;
        }
    }

    protected final boolean c(final p pVar, int i, View view, JSONObject jSONObject) {
        com.tencent.mm.y.u.b z = pVar.aeW().z(i, false);
        if (z == null) {
            x.i("MicroMsg.JsApiAddMapControls", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (view instanceof CoverViewContainer) {
            View w = ((CoverViewContainer) view).w(View.class);
            if (jSONObject.has("controls")) {
                List list;
                int i2;
                int i3;
                List list2 = (List) z.get("map_controls", null);
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    z.o("map_controls", arrayList);
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
                        ((ImageView) list.get(i3)).setVisibility(8);
                        i2 = i3 + 1;
                    }
                    list.clear();
                }
                JSONArray jSONArray = new JSONArray(jSONObject.optString("controls"));
                i2 = 0;
                while (true) {
                    int i4 = i2;
                    if (i4 >= jSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject2;
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i4);
                    String optString = jSONObject3.optString("iconPath");
                    boolean optBoolean = jSONObject3.optBoolean("clickable");
                    final String optString2 = jSONObject3.optString(SlookAirButtonFrequentContactAdapter.DATA);
                    try {
                        jSONObject2 = jSONObject3.getJSONObject("position");
                        i3 = 0;
                        i2 = 0;
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiAddMapControls", "parse position error, exception : %s", e);
                        return false;
                    }
                    try {
                        int a;
                        final View imageView = new ImageView(view.getContext());
                        if (optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                            if (itemByLocalId != null) {
                                Bitmap decodeFile = d.decodeFile(itemByLocalId.hjJ, null);
                                imageView.setImageBitmap(decodeFile);
                                i2 = decodeFile.getHeight();
                                i3 = decodeFile.getWidth();
                            }
                        } else {
                            Bitmap j = o.j(pVar.iuk, optString);
                            if (!(j == null || j.isRecycled())) {
                                imageView.setImageBitmap(j);
                                i2 = j.getHeight();
                                i3 = j.getWidth();
                            }
                        }
                        if (jSONObject2.has("width")) {
                            a = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "width", 0);
                        } else {
                            a = i3;
                        }
                        if (jSONObject2.has("height")) {
                            i3 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "height", 0);
                        } else {
                            i3 = i2;
                        }
                        int a2 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "top", 0);
                        int a3 = com.tencent.mm.plugin.appbrand.q.f.a(jSONObject2, "left", 0);
                        FrameLayout frameLayout = (FrameLayout) w;
                        LayoutParams layoutParams = new FrameLayout.LayoutParams(a, i3);
                        layoutParams.setMargins(a3, a2, 0, 0);
                        frameLayout.addView(imageView, layoutParams);
                        list.add(imageView);
                        if (optBoolean) {
                            imageView.setOnTouchListener(new OnTouchListener() {
                                public final boolean onTouch(View view, MotionEvent motionEvent) {
                                    int action = motionEvent.getAction();
                                    if (action == 0) {
                                        imageView.setColorFilter(Color.parseColor("#88888888"));
                                    } else if (action == 3 || action == 1) {
                                        imageView.clearColorFilter();
                                    }
                                    return false;
                                }
                            });
                            imageView.setClickable(true);
                            final int i5 = i;
                            imageView.setOnClickListener(new OnClickListener() {
                                public final void onClick(View view) {
                                    a aVar = new a();
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("mapId", i5);
                                        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, optString2);
                                    } catch (JSONException e) {
                                        x.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", e);
                                    }
                                    f a = aVar.a(pVar);
                                    a.mData = jSONObject.toString();
                                    a.afI();
                                }
                            });
                        }
                        i2 = i4 + 1;
                    } catch (Exception e2) {
                        x.e("MicroMsg.JsApiAddMapControls", "parse circles error, exception : %s", e2);
                        return false;
                    }
                }
            }
            return true;
        } else {
            x.w("MicroMsg.JsApiAddMapControls", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        }
    }
}
