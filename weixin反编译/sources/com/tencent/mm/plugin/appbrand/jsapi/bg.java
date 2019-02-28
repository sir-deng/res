package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.plugin.appbrand.widget.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.io.InputStream;
import org.json.JSONObject;

public final class bg extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setTabBarItem";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        try {
            int i2 = jSONObject.getInt("index");
            String optString = jSONObject.optString("text", "");
            String optString2 = jSONObject.optString("iconPath", "");
            String optString3 = jSONObject.optString("selectedIconPath", "");
            l ajy = jVar.iuk.isX.ajy();
            if (ajy instanceof e) {
                Closeable d = ao.d(jVar.iuk, optString2);
                Bitmap decodeStream = BitmapFactory.decodeStream(d);
                if (d != null) {
                    bi.d(d);
                }
                InputStream d2 = ao.d(jVar.iuk, optString3);
                Bitmap decodeStream2 = BitmapFactory.decodeStream(d2);
                if (d2 != null) {
                    bi.d(d);
                }
                c cVar = ((e) ajy).jIy;
                if (i2 < cVar.kak.size()) {
                    a aVar = (a) cVar.kak.get(i2);
                    aVar.kav = optString;
                    if (decodeStream == null) {
                        decodeStream = aVar.uX;
                    }
                    aVar.uX = decodeStream;
                    if (decodeStream2 == null) {
                        decodeStream = aVar.kau;
                    } else {
                        decodeStream = decodeStream2;
                    }
                    aVar.kau = decodeStream;
                    cVar.amN();
                }
                jVar.E(i, e("ok", null));
                return;
            }
            jVar.E(i, e("fail:not TabBar page", null));
        } catch (Exception e) {
            jVar.E(i, e("fail", null));
        }
    }
}
