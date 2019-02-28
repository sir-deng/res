package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.xweb.c.g;
import com.tencent.xweb.j;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20171020", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public final class e implements g {
    j AAA;
    d AAB;
    f AAD;
    long AAE = 0;
    private WebChromeClient AAF = new SysWebView$1(this);
    private WebViewClient AAG = new WebViewClient() {
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.i("SysWebView", "shouldOverrideUrlLoading " + str);
            if (e.this.AAz != null) {
                return e.this.AAz.b(e.this.AAx, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.i("SysWebView", "onPageStarted " + str);
            if (e.this.AAz != null) {
                e.this.AAz.b(e.this.AAx, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            e.this.AAE = System.currentTimeMillis();
            com.tencent.xweb.util.e.cJv();
            com.tencent.xweb.util.e.cJx();
        }

        public final void onPageFinished(WebView webView, String str) {
            Log.i("SysWebView", "onPageFinished " + str);
            if (e.this.AAz != null) {
                e.this.AAz.a(e.this.AAx, str);
            } else {
                super.onPageFinished(webView, str);
            }
            com.tencent.xweb.util.e.gD(System.currentTimeMillis() - e.this.AAE);
            com.tencent.xweb.util.e.gE(System.currentTimeMillis() - e.this.AAE);
        }

        public final void onLoadResource(WebView webView, String str) {
            if (e.this.AAz != null) {
                e.this.AAz.f(e.this.AAx, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (e.this.AAz != null) {
                return c.a(e.this.AAz.c(e.this.AAx, str));
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            m mVar = null;
            if (e.this.AAz == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            Bundle bundle;
            l eVar = new com.tencent.xweb.sys.c.e(webResourceRequest);
            if (eVar.AAs == null) {
                bundle = null;
            } else {
                bundle = eVar.AAs.getBundle();
            }
            if (bundle != null) {
                mVar = e.this.AAz.a(e.this.AAx, eVar, bundle);
            }
            if (mVar == null) {
                mVar = e.this.AAz.a(e.this.AAx, eVar);
            }
            return c.a(mVar);
        }

        public final void onScaleChanged(WebView webView, float f, float f2) {
            if (e.this.AAz != null) {
                e.this.AAz.blM();
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (e.this.AAz != null) {
                e.this.AAz.a(e.this.AAx, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            if (e.this.AAz != null) {
                e.this.AAz.a(e.this.AAx, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
            com.tencent.xweb.util.e.cJw();
            com.tencent.xweb.util.e.cJy();
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Log.i("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (e.this.AAz != null) {
                e.this.AAz.a(e.this.AAx, new com.tencent.xweb.sys.c.a(sslErrorHandler), sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Log.i("SysWebView", "onReceivedHttpError code:" + (VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : "Invalid"));
            if (e.this.AAz != null) {
                p pVar = e.this.AAz;
                l eVar = new com.tencent.xweb.sys.c.e(webResourceRequest);
                m mVar = webResourceResponse == null ? null : VERSION.SDK_INT >= 21 ? new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData()) : new m(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
                pVar.a(eVar, mVar);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    };
    b AAH;
    final String AAI = "xwalkTempCallBack";
    com.tencent.xweb.WebView AAx;
    a AAy;
    p AAz;

    class a extends WebView {
        public o jAg;

        public a(Context context) {
            super(context);
        }

        protected final void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (e.this.AAx != null) {
                e.this.AAx.onWebViewScrollChanged(i, i2, i3, i4);
            }
            if (this.jAg != null) {
                this.jAg.onScrollChanged(i, i2, i3, i4, this);
            }
        }
    }

    public static class b {
        HashMap<String, ValueCallback<String>> AAK = new HashMap();
        int AAL = 0;

        @JavascriptInterface
        public final void notifyJava(String str, String str2) {
            ValueCallback valueCallback = (ValueCallback) this.AAK.get(str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str2);
                this.AAK.remove(str);
            }
        }
    }

    public e(com.tencent.xweb.WebView webView) {
        this.AAx = webView;
        this.AAy = new a(webView.getContext());
        getSettings();
        this.AAB = new d(this.AAy);
        this.AAy.setWebChromeClient(this.AAF);
        this.AAy.setWebViewClient(this.AAG);
        if (VERSION.SDK_INT < 19) {
            this.AAH = new b();
            this.AAy.addJavascriptInterface(this.AAH, "xwalkTempCallBack");
        }
    }

    public final n getSettings() {
        if (this.AAD != null) {
            return this.AAD;
        }
        if (this.AAy == null) {
            return null;
        }
        this.AAD = new f(this.AAy);
        return this.AAD;
    }

    public final View getWebViewUI() {
        return this.AAy;
    }

    public final ViewGroup getTopView() {
        return this.AAy;
    }

    public final void setWebViewClient(p pVar) {
        this.AAz = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        this.AAA = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.AAy.setDownloadListener(downloadListener);
    }

    public final void setFindListener(FindListener findListener) {
        this.AAy.setFindListener(findListener);
    }

    public final void loadUrl(String str) {
        this.AAy.loadUrl(str);
    }

    public final boolean canGoBack() {
        return this.AAy.canGoBack();
    }

    public final void goBack() {
        this.AAy.goBack();
    }

    public final boolean hasEnteredFullscreen() {
        return false;
    }

    public final void leaveFullscreen() {
    }

    public final void clearView() {
        this.AAy.clearView();
    }

    public final void destroy() {
        this.AAy.destroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (str != null) {
            if (VERSION.SDK_INT >= 19) {
                this.AAy.evaluateJavascript(str, valueCallback);
            } else if (valueCallback == null) {
                this.AAy.loadUrl(str);
            } else {
                String stringBuilder;
                if (str.trim().startsWith("javascript:")) {
                    str = str.replaceFirst("javascript:", "");
                }
                if (this.AAH == null) {
                    this.AAH = new b();
                    this.AAy.addJavascriptInterface(this.AAH, "xwalkTempCallBack");
                }
                b bVar = this.AAH;
                if (valueCallback != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    int i = bVar.AAL;
                    bVar.AAL = i + 1;
                    stringBuilder = stringBuilder2.append(i).toString();
                    bVar.AAK.put(stringBuilder, valueCallback);
                } else {
                    stringBuilder = "";
                }
                this.AAy.loadUrl("javascript:xwalkTempCallBack.notifyJava(" + stringBuilder + ", " + str + ")");
            }
        }
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.AAB;
    }

    public final void reload() {
        this.AAy.reload();
    }

    public final void clearSslPreferences() {
        this.AAy.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.AAy.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.AAy.getContentHeight();
    }

    public final float getScale() {
        return this.AAy.getScale();
    }

    public final int getVisibleTitleHeight() {
        Object g = d.g(this.AAy, "getVisibleTitleHeight");
        return g == null ? 0 : ((Integer) g).intValue();
    }

    public final boolean overlayHorizontalScrollbar() {
        return this.AAy.overlayHorizontalScrollbar();
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.AAy.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.AAy.zoomOut();
    }

    public final boolean zoomIn() {
        return this.AAy.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.AAy.loadUrl(str, map);
    }

    @SuppressLint({"JavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        this.AAy.addJavascriptInterface(obj, str);
    }

    public final View getView() {
        return this.AAy;
    }

    public final String getUrl() {
        return this.AAy.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.AAy.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.AAy.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        if (this.AAy != null) {
            this.AAy.jAg = oVar;
        }
    }

    public final com.tencent.xweb.WebView.a getHitTestResult() {
        HitTestResult hitTestResult = this.AAy.getHitTestResult();
        com.tencent.xweb.WebView.a aVar = new com.tencent.xweb.WebView.a();
        aVar.mType = hitTestResult.getType();
        aVar.mExtra = hitTestResult.getExtra();
        return aVar;
    }

    public final String getTitle() {
        return this.AAy.getTitle();
    }

    public final void clearMatches() {
        this.AAy.clearMatches();
    }

    public final void findNext(boolean z) {
        this.AAy.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.AAy.findAllAsync(str);
    }

    public final String getVersionInfo() {
        return "webviewtype = WV_KIND_SYS, V8 type=" + com.tencent.xweb.g.cJg();
    }

    public final String getAbstractInfo() {
        return getVersionInfo();
    }

    public final p getCurWebviewClient() {
        return this.AAz;
    }

    public final j getCurWebChromeClient() {
        return this.AAA;
    }

    public final int getWebScrollY() {
        return this.AAy.getScrollY();
    }

    public final int getWebScrollX() {
        return getWebViewUI().getScrollX();
    }

    public final boolean isOverScrollStart() {
        return getWebViewUI().getScrollY() == 0;
    }

    public final Object getX5WebViewExtension() {
        return null;
    }

    public final void setWebViewClientExtension(com.tencent.xweb.x5.a.a.a.a.b bVar) {
    }

    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_onOverScrolled(int i, int i2, boolean z, boolean z2) {
    }

    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void super_computeScroll() {
    }

    public final void super_onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public final boolean super_overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        return false;
    }

    public final void onResume() {
        this.AAy.onResume();
    }

    public final void onPause() {
        this.AAy.onPause();
    }
}
