package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends a {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        View appBrandCameraView = new AppBrandCameraView(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("devicePosition", "back");
        String optString2 = jSONObject.optString("flash", "auto");
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        appBrandCameraView.mAppId = pVar.mAppId;
        appBrandCameraView.jlr = pVar;
        appBrandCameraView.jls = optInt;
        appBrandCameraView.T(optString, true);
        appBrandCameraView.sG(optString2);
        appBrandCameraView.jlw = optBoolean;
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a = com.tencent.mm.plugin.appbrand.q.f.a(optJSONObject, "width", 0);
        int a2 = com.tencent.mm.plugin.appbrand.q.f.a(optJSONObject, "height", 0);
        if (!(a == 0 || a2 == 0)) {
            appBrandCameraView.bH(a, a2);
        }
        x.d("MicroMsg.JsApiInsertCamera", "inflateView appId:%s,cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", pVar.mAppId, Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a), Integer.valueOf(a2));
        a(pVar, (AppBrandCameraView) appBrandCameraView);
        return new CoverViewContainer(context, appBrandCameraView);
    }

    protected final int j(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }

    protected final void a(final p pVar, final int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i));
        final e eVar = (AppBrandCameraView) ((CoverViewContainer) view).w(AppBrandCameraView.class);
        a agp = a.jlq;
        agp.jlp.put(Integer.valueOf(eVar.jls), eVar);
        pVar.a((com.tencent.mm.plugin.appbrand.page.p.f) eVar);
        pVar.a((d) eVar);
        pVar.a(eVar);
        c.a(pVar.mAppId, new b() {
            public final void onDestroy() {
                pVar.b(eVar);
                pVar.b(eVar);
                pVar.b(eVar);
                a.jlq.g(Integer.valueOf(i));
                c.b(pVar.mAppId, this);
            }
        });
        eVar.jlD = new b() {
        };
    }

    final boolean a(final p pVar, final AppBrandCameraView appBrandCameraView) {
        com.tencent.mm.plugin.appbrand.a.a(pVar.mAppId, new android.support.v4.app.a.a() {
            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                Map hashMap;
                String jSONObject;
                com.tencent.mm.plugin.appbrand.jsapi.f a;
                if (i == 16) {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        hashMap = new HashMap();
                        hashMap.put("cameraId", Integer.valueOf(appBrandCameraView.jls));
                        jSONObject = new JSONObject(hashMap).toString();
                        a = new d().a(pVar);
                        a.mData = jSONObject;
                        a.afI();
                        a.jlq.jln = false;
                        return;
                    }
                    a.jlq.jln = true;
                    f.this.a(pVar, appBrandCameraView);
                } else if (i != 18) {
                } else {
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        hashMap = new HashMap();
                        hashMap.put("cameraId", Integer.valueOf(appBrandCameraView.jls));
                        jSONObject = new JSONObject(hashMap).toString();
                        a = new d().a(pVar);
                        a.mData = jSONObject;
                        a.afI();
                        a.jlq.jlo = false;
                        return;
                    }
                    a.jlq.jlo = true;
                    f.this.a(pVar, appBrandCameraView);
                }
            }
        });
        Activity activity = (Activity) pVar.mContext;
        if (activity == null) {
            return false;
        }
        boolean a = com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.CAMERA", 16, "", "");
        a.jlq.jln = a;
        if (!a) {
            return false;
        }
        boolean a2 = com.tencent.mm.pluginsdk.g.a.a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
        a.jlq.jlo = a2;
        if (!a2) {
            return false;
        }
        com.tencent.mm.plugin.appbrand.a.pj(pVar.mAppId);
        appBrandCameraView.initView();
        return true;
    }
}
