package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.r;
import com.tencent.wcdb.database.SQLiteDatabase;

final class j extends X5ProxyWebViewClient {
    private static String AfM = null;
    private WebView AeA;
    private WebViewClient AfL;

    public j(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.AeA = webView;
        this.AfL = webViewClient;
    }

    private void abO(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            if (this.AeA.getContext() != null) {
                this.AeA.getContext().startActivity(intent);
            }
        } catch (Exception e) {
        }
    }

    public final void countPVContentCacheCallBack(String str) {
        WebView webView = this.AeA;
        webView.AiA++;
    }

    public final void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.doUpdateVisitedHistory(this.AeA, str, z);
    }

    public final void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onDetectedBlankScreen(str, i);
    }

    public final void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onFormResubmission(this.AeA, message, message2);
    }

    public final void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onLoadResource(this.AeA, str);
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, int i, int i2, String str) {
        if (AfM == null) {
            r cGz = r.cGz();
            if (cGz != null) {
                cGz.ob(false);
                AfM = Boolean.toString(false);
            }
        }
        this.AeA.Aix = iX5WebViewBase;
        WebView webView = this.AeA;
        webView.AiA++;
        this.AfL.onPageFinished(this.AeA, str);
        if ("com.qzone".equals(iX5WebViewBase.getView().getContext().getApplicationInfo().packageName)) {
            WebView.hC(iX5WebViewBase.getView().getContext());
        }
        TbsLog.app_extra("SmttWebViewClient", iX5WebViewBase.getView().getContext());
        try {
            super.onPageFinished(iX5WebViewBase, i, i2, str);
        } catch (Exception e) {
        }
        WebView.cFV();
        if (!(x.AhV || this.AeA.getContext() == null || !x.hs(this.AeA.getContext()))) {
            x.AhV = true;
            new Thread(new Runnable() {
                public final void run() {
                    j.this.AeA.getContext();
                    if (p.gJ(j.this.AeA.getContext())) {
                        p.gK(j.this.AeA.getContext());
                    }
                }
            }).start();
        }
        if (this.AeA.getContext() != null && !v.hp(this.AeA.getContext()).Ahp) {
            v.hp(this.AeA.getContext()).Ahp = true;
            v.hp(this.AeA.getContext()).cFD();
        }
    }

    public final void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onPageStarted(this.AeA, str, bitmap);
    }

    public final void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    public final void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedClientCertRequest(this.AeA, clientCertRequest);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                return;
            }
        }
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedError(this.AeA, i, str, str2);
    }

    public final void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedError(this.AeA, webResourceRequest, webResourceError);
    }

    public final void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedHttpAuthRequest(this.AeA, httpAuthHandler, str, str2);
    }

    public final void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedHttpError(this.AeA, webResourceRequest, webResourceResponse);
    }

    public final void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedLoginRequest(this.AeA, str, str2, str3);
    }

    public final void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onReceivedSslError(this.AeA, sslErrorHandler, sslError);
    }

    public final void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onScaleChanged(this.AeA, f, f2);
    }

    public final void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onTooManyRedirects(this.AeA, message, message2);
    }

    public final void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.AeA.Aix = iX5WebViewBase;
        this.AfL.onUnhandledKeyEvent(this.AeA, keyEvent);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.AeA.Aix = iX5WebViewBase;
        return this.AfL.shouldInterceptRequest(this.AeA, webResourceRequest);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.AeA.Aix = iX5WebViewBase;
        return this.AfL.shouldInterceptRequest(this.AeA, webResourceRequest, bundle);
    }

    public final WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.AeA.Aix = iX5WebViewBase;
        return this.AfL.shouldInterceptRequest(this.AeA, str);
    }

    public final boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.AeA.Aix = iX5WebViewBase;
        return this.AfL.shouldOverrideKeyEvent(this.AeA, keyEvent);
    }

    public final boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        String uri = (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : webResourceRequest.getUrl().toString();
        if (uri == null || this.AeA.showDebugView(uri)) {
            return true;
        }
        this.AeA.Aix = iX5WebViewBase;
        if (m.cGt().bQ(this.AeA.getContext().getApplicationContext(), uri)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.AfL.shouldOverrideUrlLoading(this.AeA, webResourceRequest);
        if (!shouldOverrideUrlLoading) {
            if (uri.startsWith("wtai://wp/mc;")) {
                this.AeA.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(uri.substring(13)).toString())));
                return true;
            } else if (uri.startsWith(WebView.SCHEME_TEL)) {
                abO(uri);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    public final boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.AeA.showDebugView(str)) {
            return true;
        }
        this.AeA.Aix = iX5WebViewBase;
        if (m.cGt().bQ(this.AeA.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.AfL.shouldOverrideUrlLoading(this.AeA, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                this.AeA.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str.substring(13)).toString())));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                abO(str);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }

    public final void w(String str, Bitmap bitmap) {
        super.onPageStarted(this.AeA.Aix, 0, 0, str, bitmap);
    }
}
