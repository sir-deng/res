package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class t extends a {
    public static final int CTRL_BYTE = -3;
    public static final String NAME = "getWePkgAuthResult";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetWePkgAuthResult", "invoke");
        if (dVar.neQ) {
            x.i("MicroMsg.GameJsApiGetWePkgAuthResult", "gettingA8Key");
            dVar.E(i, a.e("getWePkgAuthResult:fail_auth_result_not_return", null));
            return;
        }
        String str = dVar.neN;
        if (bi.oN(str)) {
            dVar.E(i, a.e("getWePkgAuthResult:fail_full_url_empty", null));
            return;
        }
        Object hashMap = new HashMap();
        if (dVar.neW) {
            hashMap.put("set_cookie", Integer.valueOf(1));
        } else {
            hashMap.put("set_cookie", Integer.valueOf(0));
        }
        hashMap.put("full_url", str);
        dVar.E(i, a.e("getWePkgAuthResult:ok", hashMap));
    }
}
