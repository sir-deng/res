package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.b.e;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.compat.a.b.n;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";
    p jlr;
    private com.tencent.mm.plugin.appbrand.compat.a.b jpn;
    private a jpo;
    Map<String, String> jpp = new HashMap();

    class a implements e {
        a() {
        }

        public final View a(h hVar) {
            String str = (String) d.this.jpp.get(hVar.getId());
            if (!bi.oN(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    f.aR(jSONObject.optString("shadowColor", ""), Color.parseColor("#000000"));
                    jSONObject.optInt("shadowOpacity");
                    jSONObject.optInt("shadowOffsetX");
                    jSONObject.optInt("shadowOffsetY");
                    View linearLayout = new LinearLayout(d.this.jlr.mContext);
                    linearLayout.setLayoutParams(new LayoutParams(-2, -2));
                    linearLayout.setOrientation(1);
                    linearLayout.setGravity(17);
                    int ma = f.ma(3);
                    linearLayout.setPadding(ma, ma, ma, ma);
                    View textView = new TextView(d.this.jlr.mContext);
                    Object optString = jSONObject.optString("color");
                    ma = Color.parseColor("#000000");
                    if (!TextUtils.isEmpty(optString)) {
                        ma = f.aR(optString, Color.parseColor("#000000"));
                    }
                    if (jSONObject.has("padding")) {
                        int a = f.a(jSONObject, "padding", 0);
                        textView.setPadding(a, a, a, a);
                    }
                    textView.setTextColor(ma);
                    if (jSONObject.has("fontSize")) {
                        textView.setTextSize((float) jSONObject.optInt("fontSize"));
                    }
                    if (jSONObject.has("content")) {
                        textView.setText(jSONObject.optString("content"));
                    }
                    textView.setLayoutParams(new LayoutParams(-2, -2));
                    if (jSONObject.has("textAlign")) {
                        String optString2 = jSONObject.optString("textAlign", "");
                        if (optString2.equals("left")) {
                            textView.setGravity(3);
                        } else if (optString2.equals("right")) {
                            textView.setGravity(5);
                        } else if (optString2.equals("center")) {
                            textView.setGravity(17);
                        }
                    }
                    linearLayout.addView(textView);
                    Drawable bVar = new com.tencent.mm.plugin.appbrand.widget.e.b();
                    if (jSONObject.has("borderRadius")) {
                        bVar.Wl = (float) jSONObject.optInt("borderRadius");
                    }
                    bVar.fC.setColor(f.aR(jSONObject.optString("bgColor", ""), Color.parseColor("#000000")));
                    linearLayout.setBackgroundDrawable(bVar);
                    return linearLayout;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e, "getInfoWindow", new Object[0]);
                }
            }
            return null;
        }
    }

    private static class b extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 199;
        private static final String NAME = "onMapCalloutClick";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    private static class c extends com.tencent.mm.plugin.appbrand.jsapi.f {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    protected final int j(JSONObject jSONObject) {
        int i = 0;
        try {
            return jSONObject.optInt("mapId");
        } catch (Exception e) {
            x.e("MicroMsg.JsApiAddMapMarkers", "get mapId error, exception : %s", e);
            return i;
        }
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        com.tencent.mm.y.u.b z = pVar.aeW().z(i, false);
        if (z == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "KeyValueSet(%s) is null.", Integer.valueOf(i));
            return false;
        } else if (!(view instanceof CoverViewContainer)) {
            x.w("MicroMsg.JsApiAddMapMarkers", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i));
            return false;
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "data is null");
            return false;
        } else {
            x.i("MicroMsg.JsApiAddMapMarkers", "onUpdateView, data:%s", jSONObject.toString());
            this.jlr = pVar;
            this.jpn = ((com.tencent.mm.plugin.appbrand.compat.a.c) g.h(com.tencent.mm.plugin.appbrand.compat.a.c.class)).bE(((CoverViewContainer) view).w(View.class));
            final Map map = (Map) z.get("marker", new HashMap());
            final Map map2 = (Map) z.get("marker_data", new HashMap());
            try {
                if (jSONObject.has("markers")) {
                    h a;
                    if (jSONObject.optBoolean("clear", true)) {
                        for (h a2 : map.values()) {
                            a2.remove();
                        }
                        map.clear();
                        map2.clear();
                    }
                    JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= jSONArray.length()) {
                            break;
                        }
                        int a3;
                        float width;
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        float f = bi.getFloat(jSONObject2.optString("latitude"), 0.0f);
                        float f2 = bi.getFloat(jSONObject2.optString("longitude"), 0.0f);
                        String optString = jSONObject2.optString("iconPath");
                        i abM = this.jpn.abM();
                        abM.f((double) f, (double) f2);
                        View view2 = (FrameLayout) ((LayoutInflater) pVar.mContext.getSystemService("layout_inflater")).inflate(q.h.izv, null);
                        ImageView imageView = (ImageView) view2.findViewById(q.g.iyo);
                        TextView textView = (TextView) view2.findViewById(q.g.iyp);
                        view2.setVisibility(8);
                        Bitmap bitmap = null;
                        if (optString == null || !optString.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) {
                            bitmap = o.j(pVar.iuk, optString);
                        } else {
                            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(pVar.mAppId, optString);
                            if (itemByLocalId != null) {
                                bitmap = com.tencent.mm.sdk.platformtools.d.decodeFile(itemByLocalId.hjJ, null);
                            }
                        }
                        if (bitmap != null) {
                            int a4 = f.a(jSONObject2, "width", 0);
                            a3 = f.a(jSONObject2, "height", 0);
                            if (a4 == 0 && a3 == 0) {
                                a4 = f.ma(bitmap.getWidth());
                                a3 = f.ma(bitmap.getHeight());
                            }
                            if (a4 <= 0 || a3 <= 0 || (a4 == bitmap.getWidth() && a3 == bitmap.getHeight())) {
                                imageView.setImageBitmap(bitmap);
                                imageView.setScaleType(ScaleType.CENTER);
                            } else {
                                width = ((float) a4) / ((float) bitmap.getWidth());
                                f2 = ((float) a3) / ((float) bitmap.getHeight());
                                Matrix matrix = new Matrix();
                                matrix.postScale(width, f2);
                                imageView.setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
                            }
                        }
                        imageView.measure(0, 0);
                        a3 = imageView.getMeasuredWidth();
                        int measuredHeight = imageView.getMeasuredHeight();
                        float f3 = 0.5f;
                        width = 1.0f;
                        if (jSONObject2.has("anchor")) {
                            JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("anchor"));
                            f3 = (float) jSONObject3.optDouble("x");
                            width = (float) jSONObject3.optDouble("y");
                            x.i("MicroMsg.JsApiAddMapMarkers", "anchorObj:%s", jSONObject3.toString());
                        }
                        int i4 = (int) (((float) a3) * f3);
                        measuredHeight = (int) (((float) measuredHeight) * width);
                        String optString2 = jSONObject2.optString("label");
                        if (!bi.oN(optString2)) {
                            int a5;
                            JSONObject jSONObject4 = new JSONObject(optString2);
                            CharSequence optString3 = jSONObject4.optString("color");
                            a3 = Color.parseColor("#000000");
                            if (!TextUtils.isEmpty(optString3)) {
                                a3 = f.aR(optString3, Color.parseColor("#000000"));
                            }
                            int optInt = jSONObject4.optInt("fontSize", 0);
                            String optString4 = jSONObject4.optString("content");
                            Drawable gradientDrawable = new GradientDrawable();
                            if (jSONObject4.has("borderRadius")) {
                                gradientDrawable.setCornerRadius((float) jSONObject4.optInt("borderRadius"));
                            }
                            if (jSONObject4.has("borderWidth") && jSONObject4.has("borderColor")) {
                                gradientDrawable.setStroke(f.b(jSONObject4, "borderWidth"), f.vg(jSONObject4.optString("borderColor")));
                            }
                            gradientDrawable.setColor(f.aR(jSONObject4.optString("bgColor", ""), Color.parseColor("#000000")));
                            textView.setBackgroundDrawable(gradientDrawable);
                            if (jSONObject4.has("textAlign")) {
                                String optString5 = jSONObject4.optString("textAlign", "");
                                if (optString5.equals("left")) {
                                    textView.setGravity(3);
                                } else if (optString5.equals("right")) {
                                    textView.setGravity(5);
                                } else if (optString5.equals("center")) {
                                    textView.setGravity(17);
                                } else {
                                    textView.setGravity(8388659);
                                }
                            } else {
                                textView.setGravity(8388659);
                            }
                            if (jSONObject4.has("padding")) {
                                a5 = f.a(jSONObject4, "padding", 0);
                                textView.setPadding(a5, a5, a5, a5);
                            }
                            a5 = f.a(jSONObject4, "x", 0);
                            int a6 = f.a(jSONObject4, "y", 0);
                            textView.setText(optString4);
                            textView.setTextColor(a3);
                            if (optInt > 0) {
                                textView.setTextSize((float) optInt);
                            }
                            ((MarginLayoutParams) textView.getLayoutParams()).setMargins(i4 + a5, a6 + measuredHeight, 0, 0);
                            textView.requestLayout();
                        }
                        if (bitmap != null) {
                            view2.setVisibility(0);
                            abM.bD(view2);
                        } else if (bi.oN(optString2)) {
                            x.e("MicroMsg.JsApiAddMapMarkers", "bitmap is null");
                        } else {
                            view2.setVisibility(0);
                            abM.bD(view2);
                        }
                        f = (float) jSONObject2.optDouble("alpha", 1.0d);
                        abM.T((float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d));
                        abM.U(f);
                        if (bi.oN(optString2)) {
                            abM.p(f3, width);
                        } else {
                            view2.measure(0, 0);
                            i2 = view2.getMeasuredWidth();
                            int measuredHeight2 = view2.getMeasuredHeight();
                            if (i2 <= 0 || measuredHeight2 <= 0) {
                                f = width;
                                f2 = f3;
                            } else {
                                f2 = ((float) i4) / ((float) i2);
                                f = ((float) measuredHeight) / ((float) measuredHeight2);
                            }
                            abM.p(f2, f);
                        }
                        String optString6 = jSONObject2.optString("title");
                        if (!bi.oN(optString6)) {
                            abM.qS(optString6);
                        }
                        abM.f(new Animation() {
                        });
                        abM.e(new Animation() {
                        });
                        a2 = this.jpn.a(abM);
                        if (jSONObject2.has(SlookAirButtonFrequentContactAdapter.ID)) {
                            map.put(jSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID), a2);
                        } else {
                            map.put(a2.hashCode(), a2);
                        }
                        String optString7 = jSONObject2.optString("callout");
                        if (!bi.oN(optString7)) {
                            this.jpp.put(a2.getId(), optString7);
                            this.jpo = new a();
                            this.jpn.a(this.jpo);
                            if (d(a2)) {
                                a2.showInfoWindow();
                            }
                        }
                        map2.put(a2.getId(), jSONObject2.optString(SlookAirButtonFrequentContactAdapter.DATA));
                        i2 = i3 + 1;
                    }
                    if (map.size() > 0) {
                        z.o("marker", map);
                        z.o("marker_data", map2);
                    }
                    final int i5 = i;
                    final p pVar2 = pVar;
                    this.jpn.a(new j() {
                        public final void b(h hVar) {
                            b bVar = new b();
                            String oM = bi.oM((String) map2.get(hVar.getId()));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mapId", i5);
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, oM);
                            } catch (JSONException e) {
                                x.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", e);
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.f aA = bVar.aA(pVar2.mAppId, pVar2.hashCode());
                            aA.mData = jSONObject.toString();
                            aA.afI();
                        }
                    });
                    i5 = i;
                    pVar2 = pVar;
                    this.jpn.a(new l() {
                        public final void abZ() {
                            if (map == null) {
                                x.e("MicroMsg.JsApiAddMapMarkers", "markerMap is null, return");
                                return;
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.map.i.c cVar = new com.tencent.mm.plugin.appbrand.jsapi.map.i.c();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mapId", i5);
                            } catch (JSONException e) {
                                x.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", e);
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.f a = cVar.a(pVar2);
                            a.mData = jSONObject.toString();
                            a.afI();
                            for (h hVar : map.values()) {
                                if (!d.this.d(hVar) && hVar.isInfoWindowShown()) {
                                    hVar.hideInfoWindow();
                                }
                            }
                        }
                    });
                    i5 = i;
                    pVar2 = pVar;
                    this.jpn.a(new n() {
                        public final boolean c(h hVar) {
                            c cVar = new c();
                            String oM = bi.oM((String) map2.get(hVar.getId()));
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("mapId", i5);
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, oM);
                            } catch (JSONException e) {
                                x.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", e);
                            }
                            com.tencent.mm.plugin.appbrand.jsapi.f aA = cVar.aA(pVar2.mAppId, pVar2.hashCode());
                            aA.mData = jSONObject.toString();
                            aA.afI();
                            oM = (String) d.this.jpp.get(hVar.getId());
                            if (bi.oN(oM) && bi.oN(hVar.getTitle()) && bi.oN(hVar.getSnippet())) {
                                x.e("MicroMsg.JsApiAddMapMarkers", "callout and title and snippet is empty, don't show info window");
                                return true;
                            } else if (bi.oN(oM)) {
                                if (hVar.isInfoWindowShown()) {
                                    hVar.hideInfoWindow();
                                } else {
                                    hVar.showInfoWindow();
                                }
                                return true;
                            } else if (d.this.d(hVar)) {
                                return false;
                            } else {
                                if (!hVar.isInfoWindowShown()) {
                                    hVar.showInfoWindow();
                                }
                                return true;
                            }
                        }
                    });
                } else {
                    x.e("MicroMsg.JsApiAddMapMarkers", "data has not markers");
                }
                return true;
            } catch (Exception e) {
                x.e("MicroMsg.JsApiAddMapMarkers", "parse markers error, exception : %s", e);
                return false;
            }
        }
    }

    final boolean d(h hVar) {
        String str = (String) this.jpp.get(hVar.getId());
        try {
            if (TextUtils.isEmpty(str)) {
                x.e("MicroMsg.JsApiAddMapMarkers", "isShowInfoWindow, callout is empty");
                return false;
            }
            if (new JSONObject(str).optInt("display") == 1) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e, "isShowInfoWindow", new Object[0]);
        }
    }
}
