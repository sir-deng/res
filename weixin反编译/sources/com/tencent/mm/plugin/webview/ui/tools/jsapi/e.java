package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class e implements b {
    private MMWebView jAa;
    private d tLH;

    public e(MMWebView mMWebView, d dVar) {
        this.jAa = mMWebView;
        this.tLH = dVar;
    }

    public final boolean Cy(String str) {
        if (bi.oN(str)) {
            return false;
        }
        return s.eL(str, "weixin://private/setresult/");
    }

    public final boolean Cz(String str) {
        String str2 = null;
        if (this.jAa != null) {
            this.jAa.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
        }
        String substring = str.substring(27);
        if (bi.oN(substring)) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler handleUrl fail, value is null");
            return false;
        }
        int indexOf = substring.indexOf("&");
        if (indexOf <= 0) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler, handleUrl fail, invalid splitorIdx = %d", Integer.valueOf(indexOf));
            return false;
        }
        byte[] decode;
        String substring2 = substring.substring(0, indexOf);
        try {
            decode = Base64.decode(substring.substring(indexOf + 1), 0);
        } catch (Exception e) {
            x.e("MicroMsg.JsApiResultHandler", "SetResultHandler decodeBase64 failed");
            decode = null;
        }
        if (decode != null) {
            str2 = new String(decode);
        }
        x.i("MicroMsg.JsApiResultHandler", "SetResultHandler, scene = %s, result = %s", substring2, str2);
        this.tLH.keep_setReturnValue(substring2, str2);
        return true;
    }
}
