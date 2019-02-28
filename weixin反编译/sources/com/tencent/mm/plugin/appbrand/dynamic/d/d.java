package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.ad;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.b.b;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public d(int i) {
        super(ad.NAME, i);
    }

    protected final void a(com.tencent.mm.t.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        Context context = aVar.getContext();
        u.b Ci = aVar.Ci();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        Map hashMap = new HashMap();
        hashMap.put("model", q.yQ());
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Integer.valueOf(f.lZ(Ci.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(f.lZ(Ci.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(f.lZ(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(f.lZ(displayMetrics.heightPixels)));
        hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.eM(context));
        hashMap.put("version", com.tencent.mm.sdk.platformtools.f.ag(null, com.tencent.mm.protocal.d.vHl));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        aVar2.aw(a(true, "", hashMap));
    }
}
