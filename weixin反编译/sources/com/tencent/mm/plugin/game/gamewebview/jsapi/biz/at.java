package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public final class at extends a {
    public static final int CTRL_BYTE = 298;
    public static final int DO_IN_ENV = 1;
    public static final String NAME = "setGameData";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiSetGameData", "invoke");
        JSONObject sx = d.sx(str);
        if (sx == null) {
            x.e("MicroMsg.GameJsApiSetGameData", "data is null");
            aVar.sE(a.e("setGameData:fail_null_data", null));
            return;
        }
        String optString = sx.optString("current_appid");
        if (bi.oN(optString)) {
            x.i("MicroMsg.GameJsApiSetGameData", "appId is null");
            aVar.sE(a.e("setGameData:fail_appid_null", null));
            return;
        }
        String optString2 = sx.optString("key");
        String optString3 = sx.optString(Columns.VALUE);
        String optString4 = sx.optString("weight", "1");
        String optString5 = sx.optString("expireTime");
        boolean optBoolean = sx.optBoolean("autoClean", true);
        if (bi.oN(optString2) || bi.oN(optString3)) {
            x.i("MicroMsg.GameJsApiSetGameData", "key or value is null");
            aVar.sE(a.e("setGameData:fail_null_key", null));
        } else if (b.bPO().a(optString, optString2, optString3, optString4, optString5, optBoolean)) {
            aVar.sE(a.e("setGameData:ok", null));
        } else {
            aVar.sE(a.e("setGameData:fail_exceed_size", null));
        }
    }
}
