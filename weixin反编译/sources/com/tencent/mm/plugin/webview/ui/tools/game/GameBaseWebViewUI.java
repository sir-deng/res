package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI extends WebViewUI {
    private c nff = new c() {
        protected final void A(Bundle bundle) {
            try {
                if (GameBaseWebViewUI.this.jAm != null && bundle != null) {
                    GameBaseWebViewUI.this.jAm.e(96, bundle);
                }
            } catch (RemoteException e) {
            }
        }
    };
    protected a tLx;

    protected class a extends h {
        protected a() {
            super();
        }

        public void b(WebView webView, String str, Bitmap bitmap) {
            GameBaseWebViewUI.this.nff.tLR.bUT();
            super.b(webView, str, bitmap);
        }

        public void a(WebView webView, String str) {
            super.a(webView, str);
            GameBaseWebViewUI.this.nff.tLR.bUU();
        }
    }

    protected final void T(Bundle bundle) {
        this.nff.tLR.Z(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        this.nff.tLR.onResume();
        if (this.tLx != null) {
            this.tLx.nff.tLR.onResume();
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.nff.tLR.onPause();
        if (this.tLx != null) {
            this.tLx.nff.tLR.onPause();
        }
    }

    public void onDestroy() {
        c.a(this.nff.tLR.tLS);
        if (this.tLx != null) {
            this.tLx.onDestroy();
        }
        super.onDestroy();
    }
}
