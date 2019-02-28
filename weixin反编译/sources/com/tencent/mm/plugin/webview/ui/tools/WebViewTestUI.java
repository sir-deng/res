package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

public class WebViewTestUI extends MMActivity {
    private p iXj = new p() {
        public final void a(WebView webView, String str) {
            super.a(webView, str);
        }
    };
    MMWebViewWithJsApi tEJ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("rawUrl");
        this.tEJ = a.dT(this);
        this.tEJ.setWebViewClient(this.iXj);
        setContentView(this.tEJ);
        this.tEJ.loadUrl(stringExtra);
    }

    protected final int getLayoutId() {
        return -1;
    }
}
