package com.tencent.mm.plugin.aj;

import android.webkit.JavascriptInterface;

public final class b implements com.tencent.mm.bg.b {
    public com.tencent.mm.bg.b tpT;

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        if (this.tpT != null) {
            this.tpT._sendMessage(str);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(String str) {
        if (this.tpT != null) {
            this.tpT._getAllHosts(str);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        if (this.tpT != null) {
            this.tpT._getHtmlContent(str);
        }
    }
}
