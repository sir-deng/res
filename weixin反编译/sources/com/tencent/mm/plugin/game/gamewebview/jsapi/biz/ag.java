package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ag extends a {
    public static final int CTRL_BYTE = 250;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "openWeApp";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiOpenWeApp", "invoke");
        JSONObject sx = d.sx(str);
        if (sx == null) {
            x.e("MicroMsg.GameJsApiOpenWeApp", "data is null");
            aVar.sE(a.e("openWeApp:fail_null_data", null));
            return;
        }
        b qrVar = new qr();
        qrVar.fJd.context = context;
        qrVar.fJd.userName = sx.optString("userName");
        qrVar.fJd.appId = sx.optString("appId");
        qrVar.fJd.fJf = sx.optString("relativeURL");
        qrVar.fJd.fJh = sx.optInt("appVersion", 0);
        qrVar.fJd.scene = sx.optInt("scene", 1018);
        qrVar.fJd.foi = sx.optString("sceneNote");
        if (bi.oN(qrVar.fJd.foi)) {
            qrVar.fJd.foi = p.encode(bi.oM(sx.optString("current_url")));
        }
        qrVar.fJd.fwM = sx.optString("downloadURL");
        qrVar.fJd.fJg = sx.optInt("openType", 0);
        qrVar.fJd.fJi = sx.optString("checkSumMd5");
        qrVar.fJd.fJk = false;
        com.tencent.mm.sdk.b.a.xmy.m(qrVar);
        if (qrVar.fJe.fJp) {
            aVar.sE(a.e("openWeApp:ok", null));
        } else {
            aVar.sE(a.e("openWeApp:fail:" + bi.oM(qrVar.fJe.fJq), null));
        }
    }
}
