package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;

public class ContactQZoneWebView extends WebViewUI {
    private String pka = "";
    private boolean tCx = false;
    private String tCy = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(getString(R.l.dWd));
        this.pzt.setWebViewClient(new p() {
            public final boolean b(WebView webView, String str) {
                if (str.startsWith("weixin://viewimage/")) {
                    ContactQZoneWebView.this.PC(str);
                    webView.stopLoading();
                } else if (!(str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe"))) {
                    webView.loadUrl(str);
                }
                return true;
            }

            public final void b(WebView webView, String str, Bitmap bitmap) {
                if (str.startsWith("weixin://viewimage/")) {
                    ContactQZoneWebView.this.PC(str);
                    webView.stopLoading();
                } else if (str.equals(ContactQZoneWebView.this.pka)) {
                    bi.F(ContactQZoneWebView.this, str);
                    webView.stopLoading();
                } else {
                    super.b(webView, str, bitmap);
                }
            }
        });
        this.pzt.loadUrl(this.fJB);
        x.d("MicroMsg.ContactQZoneWebView", "loadUrl:loadUrl, url = " + this.fJB);
    }

    protected void onResume() {
        super.onResume();
        this.tCx = false;
    }

    final void PC(String str) {
        if (!this.tCx) {
            this.tCx = true;
            String substring = str.substring(19);
            x.d("MicroMsg.ContactQZoneWebView", "get url :" + substring);
            Intent intent = new Intent();
            intent.putExtra("nowUrl", substring);
            intent.putExtra("tweetid", bi.oM(getIntent().getStringExtra("tweetid")));
            intent.putExtra("htmlData", this.tCy);
            intent.putExtra(Columns.TYPE, getIntent().getIntExtra(Columns.TYPE, 0));
            Bundle bundle = new Bundle();
            bundle.putInt("stat_scene", 4);
            bundle.putString("stat_url", aPR());
            intent.putExtra("_stat_obj", bundle);
            startActivity(intent);
            a.ihN.t(intent, this);
        }
    }
}
