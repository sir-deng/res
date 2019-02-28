package com.tencent.xweb.x5;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebView.FindListener;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.ab;
import com.tencent.smtt.sdk.ah;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.g;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.x5.g.b;
import com.tencent.xweb.x5.g.c;
import com.tencent.xweb.x5.g.d;
import com.tencent.xweb.x5.g.e;
import com.tencent.xweb.x5.g.f;
import com.tencent.xweb.x5.sdk.ProxyWebViewSuperWrapper;
import java.util.Map;
import org.xwalk.core.Log;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class j implements g {
    com.tencent.xweb.j AAA;
    long AAE = 0;
    WebView AAx;
    p AAz;
    i ABq;
    k ABr;
    private b ABs = new b() {
        public final void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {
            Log.i("X5WebView", "onProgressChanged, progress = " + i);
            if (j.this.AAA != null) {
                j.this.AAA.a(j.this.AAx, i);
            } else {
                super.onProgressChanged(webView, i);
            }
        }

        public final void onReceivedTitle(com.tencent.smtt.sdk.WebView webView, String str) {
            Log.i("X5WebView", "onReceivedTitle: " + str);
            if (j.this.AAA != null) {
                j.this.AAA.d(j.this.AAx, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            Log.i("X5WebView", "onShowCustomView");
            if (j.this.AAA != null) {
                j.this.AAA.onShowCustomView(view, new c(customViewCallback));
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        public final void onHideCustomView() {
            Log.i("X5WebView", "onHideCustomView");
            if (j.this.AAA != null) {
                j.this.AAA.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        public final boolean onJsAlert(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            Log.i("X5WebView", "onJsAlert");
            if (j.this.AAA != null) {
                return j.this.AAA.a(j.this.AAx, str, str2, new f(jsResult));
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        public final boolean onJsConfirm(com.tencent.smtt.sdk.WebView webView, String str, String str2, JsResult jsResult) {
            Log.i("X5WebView", "onJsConfirm");
            if (j.this.AAA != null) {
                return j.this.AAA.b(j.this.AAx, str, str2, new f(jsResult));
            }
            return super.onJsConfirm(webView, str, str2, jsResult);
        }

        public final boolean onJsPrompt(com.tencent.smtt.sdk.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            Log.i("X5WebView", "onJsPrompt");
            if (j.this.AAA == null) {
                return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            return j.this.AAA.a(j.this.AAx, str, str2, str3, new g.g(jsPromptResult));
        }

        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            Log.i("X5WebView", "onGeolocationPermissionsShowPrompt");
            if (j.this.AAA != null) {
                j.this.AAA.onGeolocationPermissionsShowPrompt(str, new e(geolocationPermissionsCallback));
            } else {
                super.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            }
        }

        public final void onGeolocationPermissionsHidePrompt() {
            Log.i("X5WebView", "onGeolocationPermissionsHidePrompt");
            if (j.this.AAA == null) {
                super.onGeolocationPermissionsHidePrompt();
            }
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Log.i("X5WebView", "onConsoleMessage " + consoleMessage.message());
            if (j.this.AAA == null) {
                return super.onConsoleMessage(consoleMessage);
            }
            android.webkit.ConsoleMessage consoleMessage2;
            com.tencent.xweb.j jVar = j.this.AAA;
            if (consoleMessage == null) {
                consoleMessage2 = null;
            } else {
                MessageLevel messageLevel = MessageLevel.DEBUG;
                switch (consoleMessage.messageLevel()) {
                    case DEBUG:
                        messageLevel = MessageLevel.DEBUG;
                        break;
                    case ERROR:
                        messageLevel = MessageLevel.ERROR;
                        break;
                    case LOG:
                        messageLevel = MessageLevel.LOG;
                        break;
                    case TIP:
                        messageLevel = MessageLevel.TIP;
                        break;
                    case WARNING:
                        messageLevel = MessageLevel.WARNING;
                        break;
                }
                consoleMessage2 = new android.webkit.ConsoleMessage(consoleMessage.message(), consoleMessage.sourceId(), consoleMessage.lineNumber(), messageLevel);
            }
            return jVar.onConsoleMessage(consoleMessage2);
        }

        public final void openFileChooser(ab<Uri> abVar, String str, String str2) {
            Log.i("X5WebView", "openFileChooser with three param");
            if (j.this.AAA != null) {
                j.this.AAA.openFileChooser(abVar, str, str2);
            } else {
                abVar.onReceiveValue(null);
            }
        }

        public final boolean onShowFileChooser(com.tencent.smtt.sdk.WebView webView, ab<Uri[]> abVar, com.tencent.smtt.sdk.WebChromeClient.a aVar) {
            Log.i("X5WebView", "onShowFileChooser last method");
            if (j.this.AAA != null) {
                return j.this.AAA.a(j.this.AAx, abVar, new d(aVar));
            }
            return super.onShowFileChooser(webView, new a.d(abVar), aVar);
        }

        public final View getVideoLoadingProgressView() {
            if (j.this.AAA != null) {
                return j.this.AAA.getVideoLoadingProgressView();
            }
            return super.getVideoLoadingProgressView();
        }
    };
    private c ABt = new c() {
        public final boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String str) {
            Log.i("X5WebView", "shouldOverrideUrlLoading " + str);
            if (j.this.AAz != null) {
                return j.this.AAz.b(j.this.AAx, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void onPageStarted(com.tencent.smtt.sdk.WebView webView, String str, Bitmap bitmap) {
            Log.i("X5WebView", "onPageStarted " + str);
            if (j.this.AAz != null) {
                j.this.AAz.b(j.this.AAx, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            j.this.AAE = System.currentTimeMillis();
            com.tencent.xweb.util.e.cJv();
            com.tencent.xweb.util.e.cJz();
        }

        public final void onPageFinished(com.tencent.smtt.sdk.WebView webView, String str) {
            Log.i("X5WebView", "onPageFinished " + str);
            if (j.this.AAz != null) {
                j.this.AAz.a(j.this.AAx, str);
            } else {
                super.onPageFinished(webView, str);
            }
            com.tencent.xweb.util.e.gD(System.currentTimeMillis() - j.this.AAE);
            com.tencent.xweb.util.e.gF(System.currentTimeMillis() - j.this.AAE);
        }

        public final void onLoadResource(com.tencent.smtt.sdk.WebView webView, String str) {
            if (j.this.AAz != null) {
                j.this.AAz.f(j.this.AAx, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, String str) {
            if (j.this.AAz != null) {
                return a.b(j.this.AAz.c(j.this.AAx, str));
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest) {
            if (j.this.AAz == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return a.b(j.this.AAz.a(j.this.AAx, new b(webResourceRequest)));
        }

        public final WebResourceResponse shouldInterceptRequest(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (j.this.AAz == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest, bundle);
            }
            return a.b(j.this.AAz.a(j.this.AAx, new b(webResourceRequest), bundle));
        }

        public final void onScaleChanged(com.tencent.smtt.sdk.WebView webView, float f, float f2) {
            if (j.this.AAz != null) {
                j.this.AAz.blM();
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        public final void doUpdateVisitedHistory(com.tencent.smtt.sdk.WebView webView, String str, boolean z) {
            if (j.this.AAz != null) {
                j.this.AAz.a(j.this.AAx, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public final void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i, String str, String str2) {
            if (j.this.AAz != null) {
                j.this.AAz.a(j.this.AAx, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            com.tencent.xweb.util.e.cJw();
            com.tencent.xweb.util.e.cJA();
        }

        public final void onReceivedSslError(com.tencent.smtt.sdk.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Log.i("X5WebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (j.this.AAz != null) {
                j.this.AAz.a(j.this.AAx, new com.tencent.xweb.x5.g.a(sslErrorHandler), sslError != null ? new android.net.http.SslError(sslError.getPrimaryError(), sslError.getCertificate()) : null);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public final void onReceivedHttpError(com.tencent.smtt.sdk.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Log.i("X5WebView", "onReceivedHttpError code:" + webResourceResponse.getStatusCode());
            if (j.this.AAz != null) {
                j.this.AAz.a(new b(webResourceRequest), g.a(webResourceResponse));
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }
    };
    com.tencent.smtt.sdk.WebView AeA;

    class a extends com.tencent.smtt.sdk.WebView {
        public a(Context context) {
            super(context);
        }

        protected final void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (j.this.AAx != null) {
                j.this.AAx.onWebViewScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public j(WebView webView) {
        this.AAx = webView;
        this.AeA = new a(webView.getContext());
        this.ABq = new i(this.AeA);
        this.AeA.setWebChromeClient(this.ABs);
        this.AeA.setWebViewClient(this.ABt);
        this.ABq.ABj = this.ABt;
        this.ABq.ABk = this.ABs;
    }

    public final Object getX5WebViewExtension() {
        return this.AeA.getX5WebViewExtension();
    }

    public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
        this.AeA.setWebViewClientExtension(new ProxyWebViewSuperWrapper(bVar));
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return this.AeA.super_onTouchEvent(motionEvent);
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.AeA.super_onInterceptTouchEvent(motionEvent);
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
        this.AeA.super_onOverScrolled(i, i2, z, z2);
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return this.AeA.super_dispatchTouchEvent(motionEvent);
    }

    public final void super_computeScroll() {
        this.AeA.super_computeScroll();
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
        this.AeA.super_onScrollChanged(i, i2, i3, i4);
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return this.AeA.super_overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
    }

    public final void onResume() {
        this.AeA.onResume();
    }

    public final void onPause() {
        this.AeA.onPause();
    }

    public final n getSettings() {
        if (this.ABr != null) {
            return this.ABr;
        }
        if (this.AeA == null) {
            return null;
        }
        this.ABr = new k(this.AeA);
        return this.ABr;
    }

    public final View getView() {
        return this.AeA.getView();
    }

    public final ViewGroup getTopView() {
        return (ViewGroup) this.AeA.getView();
    }

    public final View getWebViewUI() {
        return this.AeA;
    }

    public final void setWebViewClient(p pVar) {
        this.AAz = pVar;
    }

    public final void setWebChromeClient(com.tencent.xweb.j jVar) {
        this.AAA = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.AeA.setDownloadListener(new com.tencent.xweb.x5.a.a(downloadListener));
    }

    public final void setFindListener(FindListener findListener) {
        this.AeA.setFindListener(new a.b(findListener));
    }

    public final void loadUrl(String str) {
        this.AeA.loadUrl(str);
    }

    public final boolean canGoBack() {
        return this.AeA.canGoBack();
    }

    public final void goBack() {
        this.AeA.goBack();
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        this.AeA.clearView();
    }

    public final void destroy() {
        this.AeA.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.AeA.evaluateJavascript(str, new a.d(valueCallback));
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.ABq;
    }

    public final void reload() {
        this.AeA.reload();
    }

    public final void clearSslPreferences() {
        this.AeA.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.AeA.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.AeA.getContentHeight();
    }

    public final float getScale() {
        return this.AeA.getScale();
    }

    public final int getVisibleTitleHeight() {
        return this.AeA.getVisibleTitleHeight();
    }

    public final boolean overlayHorizontalScrollbar() {
        return this.AeA.overlayHorizontalScrollbar();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.AeA.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.AeA.zoomOut();
    }

    public final boolean zoomIn() {
        return this.AeA.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.AeA.loadUrl(str, map);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.AeA.addJavascriptInterface(obj, str);
    }

    public final String getUrl() {
        return this.AeA.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.AeA.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.AeA.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.AeA.setWebViewCallbackClient(new a.f(oVar));
    }

    public final com.tencent.xweb.WebView.a getHitTestResult() {
        HitTestResult hitTestResult = this.AeA.getHitTestResult();
        com.tencent.xweb.WebView.a aVar = new com.tencent.xweb.WebView.a();
        aVar.mType = hitTestResult.getType();
        aVar.mExtra = hitTestResult.getExtra();
        return aVar;
    }

    public final String getTitle() {
        return this.AeA.getTitle();
    }

    public final void clearMatches() {
        this.AeA.clearMatches();
    }

    public final void findNext(boolean z) {
        this.AeA.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.AeA.findAllAsync(str);
    }

    public final String getVersionInfo() {
        if ((this.AeA.getX5WebViewExtension() != null ? 1 : null) != null) {
            return "use x5 and x5 kernel, wrapper version = 3, V8 type=" + com.tencent.xweb.g.cJg();
        }
        return "use x5 but sys kernel, wrapper version = 3, V8 type=" + com.tencent.xweb.g.cJg();
    }

    public final String getAbstractInfo() {
        return "webviewtype = x5, is using x5 core = " + (this.AeA.getX5WebViewExtension() != null) + "\n core version = " + QbSdk.getTbsVersion(this.AAx.getContext()) + "\n miniqbversion = " + QbSdk.getMiniQBVersion(this.AAx.getContext()) + "\n canUseX5JsCore = " + ah.hH(this.AAx.getContext()) + "\n canUseNativeBuffer = " + ah.hI(this.AAx.getContext());
    }

    public final p getCurWebviewClient() {
        return this.AAz;
    }

    public final com.tencent.xweb.j getCurWebChromeClient() {
        return this.AAA;
    }

    public final int getWebScrollY() {
        return this.AeA.getWebScrollY();
    }

    public final int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    public final boolean isOverScrollStart() {
        return getView().getScrollY() == 0;
    }
}
