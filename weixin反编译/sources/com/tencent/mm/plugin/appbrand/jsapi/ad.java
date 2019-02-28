package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.appbrand.game.m;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class ad extends l {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private float jgp = -1.0f;

    public final String a(j jVar, JSONObject jSONObject) {
        int[] iArr;
        HashMap hashMap = new HashMap();
        hashMap.put("brand", Build.BRAND);
        hashMap.put("model", Build.MODEL);
        hashMap.put("pixelRatio", Float.valueOf(jVar.getContext().getResources().getDisplayMetrics().density));
        if (c(jVar) != null) {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: normal");
            iArr = new int[]{c(jVar).getWidth(), c(jVar).getHeight()};
        } else if (jVar.getContext() instanceof Activity) {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: DecorView");
            jVar.getContext().getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
            iArr = new int[]{r2.right - r2.left, (r2.bottom - r2.top) - a.fromDPToPix(jVar.getContext(), 48)};
        } else {
            x.i("MicroMsg.JsApiGetSystemInfo", "Method: Screen");
            iArr = new int[]{jVar.getContext().getResources().getDisplayMetrics().widthPixels, jVar.getContext().getResources().getDisplayMetrics().heightPixels};
        }
        hashMap.put("windowWidth", Integer.valueOf(f.lZ(iArr[0])));
        hashMap.put("windowHeight", Integer.valueOf(f.lZ(iArr[1])));
        if (jVar.iuk == null || !jVar.iuk.YI()) {
            hashMap.put("screenWidth", Integer.valueOf(f.lZ(jVar.getContext().getResources().getDisplayMetrics().widthPixels)));
            hashMap.put("screenHeight", Integer.valueOf(f.lZ(jVar.getContext().getResources().getDisplayMetrics().heightPixels)));
        } else {
            Point point = new Point();
            m.jaX.b(point);
            hashMap.put("screenWidth", Integer.valueOf(f.lZ(point.x)));
            hashMap.put("screenHeight", Integer.valueOf(f.lZ(point.y)));
        }
        if (jVar.iuk.isT.iPE.acd()) {
            hashMap.put("statusBarHeight", Integer.valueOf(f.lZ(com.tencent.mm.ui.statusbar.a.ab(jVar.getContext()))));
        }
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.eM(jVar.getContext()));
        hashMap.put("version", com.tencent.mm.sdk.platformtools.f.ag(null, d.vHl));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        hashMap.put("benchmarkLevel", Integer.valueOf(jVar.iuk.isS.iRT));
        if (this.jgp != -1.0f) {
            hashMap.put("fontSizeSetting", Integer.valueOf((int) (this.jgp * 16.0f)));
        } else {
            float f = MultiProcessSharedPreferences.getSharedPreferences(jVar.getContext(), com.tencent.mm.sdk.platformtools.ad.cgf(), 0).getFloat("text_size_scale_key", 1.0f);
            hashMap.put("fontSizeSetting", Integer.valueOf((int) (f * 16.0f)));
            this.jgp = f;
        }
        return e("ok", hashMap);
    }

    private static View c(j jVar) {
        p b = e.b(jVar);
        return b == null ? null : b.afc();
    }
}
