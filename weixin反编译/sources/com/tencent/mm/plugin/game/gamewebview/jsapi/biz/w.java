package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.xweb.b;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class w extends a {
    public static final int CTRL_BYTE = 1;
    public static final String NAME = "imagePreview";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        Context aPO = dVar.aPO();
        if (aPO != null) {
            if (jSONObject == null) {
                x.e("MicroMsg.GameJsApiSendAppMessage", "fail, data is null");
                dVar.E(i, a.e("imagePreview:fail_invalid_data", null));
                return;
            }
            String optString = jSONObject.optString("current");
            JSONArray optJSONArray = jSONObject.optJSONArray("urls");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray == null || optJSONArray.length() == 0) {
                x.e("MicroMsg.GameJsApiSendAppMessage", "fail, urls is null");
                dVar.E(i, a.e("imagePreview:fail_invalid_url", null));
                return;
            }
            String str;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                Object optString2 = optJSONArray.optString(i2);
                if (bi.oN(optString2) || optString2.equalsIgnoreCase("null")) {
                    x.e("MicroMsg.GameJsApiSendAppMessage", "null url, i = %d", Integer.valueOf(i2));
                } else {
                    if (bi.oM(optString2).startsWith("weixin://resourceid/")) {
                        WebViewJSSDKFileItem OS = f.bSo().OS(optString2);
                        if (OS != null) {
                            optString2 = OS.iOz;
                        }
                    }
                    arrayList.add(optString2);
                }
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (bi.oN(optString)) {
                str = strArr[0];
            } else if (optString.startsWith("weixin://resourceid/")) {
                WebViewJSSDKFileItem OS2 = f.bSo().OS(optString);
                str = OS2 != null ? OS2.iOz : "";
            } else {
                str = optString;
            }
            Intent intent = new Intent();
            optString = b.cJc().getCookie(dVar.aPR());
            if (!bi.oN(optString)) {
                intent.putExtra("cookie", optString);
            }
            intent.putExtra("nowUrl", str);
            intent.putExtra("urlList", strArr);
            intent.putExtra(Columns.TYPE, -255);
            intent.putExtra("isFromWebView", true);
            com.tencent.mm.bl.d.b(aPO, "subapp", ".ui.gallery.GestureGalleryUI", intent);
            dVar.E(i, a.e("imagePreview:ok", null));
        }
    }
}
