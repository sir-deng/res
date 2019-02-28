package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class r extends a {
    public static final int CTRL_BYTE = -2;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "getLocalWePkgInfo";

    public final void a(Context context, String str, final GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiGetLocalWePkgInfo", "invoke");
        ah.y(new Runnable() {
            public final void run() {
                g.a(new g.a() {
                    public final void H(JSONObject jSONObject) {
                        Map hashMap = new HashMap();
                        hashMap.put("wepkg_info", jSONObject);
                        aVar.sE(a.e("getLocalWePkgInfo:ok", hashMap));
                    }
                });
            }
        });
    }
}
