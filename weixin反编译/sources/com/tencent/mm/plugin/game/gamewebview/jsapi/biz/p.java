package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends a {
    public static final int CTRL_BYTE = 299;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "getGameData";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject sx = d.sx(str);
        if (sx == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            aVar.sE(a.e("getGameData:fail_null_data", null));
            return;
        }
        String optString = sx.optString("current_appid");
        if (bi.oN(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            aVar.sE(a.e("getGameData:fail_appid_null", null));
            return;
        }
        String optString2 = sx.optString("key");
        if (bi.oN(optString2)) {
            x.i("MicroMsg.GameJsApiSetGameData", "key is null");
            aVar.sE(a.e("getGameData:fail_null_key", null));
            return;
        }
        com.tencent.mm.plugin.webview.b.a eO = b.bPO().eO(optString, optString2);
        if (bi.oN(eO.field_value)) {
            aVar.sE(a.e("getGameData:ok", null));
            return;
        }
        Map hashMap = new HashMap();
        hashMap.put(Columns.VALUE, eO.field_value);
        hashMap.put("weight", eO.field_weight);
        hashMap.put("expireTime", Long.valueOf(eO.field_expireTime - (System.currentTimeMillis() / 1000)));
        aVar.sE(a.e("getGameData:ok", hashMap));
    }
}
