package com.tencent.mm.plugin.appbrand.jsapi.voicejoint;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalTmpVoiceObject;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 451;
    public static final String NAME = "setResPath";
    private j isW;
    private int jfG;
    private String jyi;
    private String jyj;

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        x.d("MicroMsg.JsApiSetResPath", "alvinluo setResPath data: %s", jSONObject.toString());
        int i2 = f.jzB;
        f.kY(1);
        this.isW = jVar;
        this.jfG = i;
        this.jyi = jSONObject.optString("resPath");
        x.i("MicroMsg.JsApiSetResPath", "alvinluo setResPath resPath: %s", this.jyi);
        if (bi.oN(this.jyi)) {
            x.e("MicroMsg.JsApiSetResPath", "alvinluo setResPath resPath invalid");
            sE(e("fail set failed", null));
            ahO();
            return;
        }
        String c = com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.c(this.isW, this.jyi);
        if (bi.oN(c)) {
            sE(e("fail set failed", null));
            ahO();
        } else if (new File(c).exists()) {
            this.jyj = s.TC(this.jyi);
            AppBrandLocalTmpVoiceObject attachTmpVoice = AppBrandLocalMediaObjectManager.attachTmpVoice(this.isW.mAppId, c, this.jyj != null ? this.jyj : "unknown", true);
            if (attachTmpVoice != null) {
                x.d("MicroMsg.JsApiSetResPath", "alvinluo setResPath saveFullPath: %s, localId: %s", attachTmpVoice.hjJ, attachTmpVoice.fvn);
                Map hashMap = new HashMap();
                hashMap.put("savePath", attachTmpVoice.fvn);
                sE(e("ok", hashMap));
                i2 = f.jzB;
                f.kY(2);
                return;
            }
            x.e("MicroMsg.JsApiSetResPath", "alvinluo setResPath attach tmp voice failed");
            sE(e("fail set failed", null));
            ahO();
        } else {
            x.e("MicroMsg.JsApiSetResPath", "alvinluo setResPath res file not exist");
            sE(e("fail set failed", null));
            ahO();
        }
    }

    private void sE(String str) {
        x.i("MicroMsg.JsApiSetResPath", "alvinluo setResPath callback result: %s", str);
        if (this.isW != null) {
            this.isW.E(this.jfG, str);
        }
    }

    private static void ahO() {
        int i = f.jzB;
        f.kY(3);
    }
}
