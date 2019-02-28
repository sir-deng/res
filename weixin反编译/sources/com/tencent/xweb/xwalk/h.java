package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebResourceResponse;
import android.webkit.WebView.FindListener;
import android.widget.AbsoluteLayout;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c.g;
import com.tencent.xweb.j;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.p;
import com.tencent.xweb.util.e;
import com.tencent.xweb.xwalk.a.d;
import com.tencent.xweb.xwalk.e.b;
import com.tencent.xweb.xwalk.e.c;
import com.tencent.xweb.xwalk.e.f;
import java.util.Map;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkLogMessageListener;
import org.xwalk.core.XWalkNavigationHistory.Direction;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkUIClient.InitiateBy;
import org.xwalk.core.XWalkUIClient.JavascriptMessageType;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkView.OverScrolledListener;
import org.xwalk.core.XWalkView.ScrollChangedListener;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class h implements g {
    long AAE = 0;
    WebView AAx;
    j ACn;
    k ACo;
    XWalkView ACp;
    i ACt;
    AbsoluteLayout ACu;
    f ACv;
    boolean ACw = false;
    String ACx = null;
    boolean ACy = false;
    p iXj = new p();
    o jAg;
    j jKM = new j();
    int mApkVersion = XWalkEnvironment.getAvailableVersion();
    int type = 0;

    class a extends XWalkView {
        public a(Context context) {
            super(context);
        }

        public final void onScrollChangedDelegate(int i, int i2, int i3, int i4) {
            super.onScrollChangedDelegate(i, i2, i3, i4);
            if (h.this.AAx != null) {
                h.this.AAx.onWebViewScrollChanged(i, i2, i3, i4);
            }
        }
    }

    public static synchronized boolean ed(Context context) {
        boolean isXWalkReady;
        synchronized (h.class) {
            d.iV(context);
            isXWalkReady = d.isXWalkReady();
        }
        return isXWalkReady;
    }

    private void cJS() {
        if (this.ACn == null) {
            this.ACn = new j(this.ACp) {
                String ACz = null;

                public final void onPageLoadStarted(XWalkView xWalkView, String str) {
                    Log.i("XWWebView", "onPageLoadStarted: url = " + str);
                    h.this.iXj.b(h.this.AAx, str, h.this.ACp.getFavicon());
                    this.ACz = null;
                    if (!(h.this.ACx == null || str == null || str.equals(h.this.ACx) || e.adb(str) == e.adb(h.this.ACx))) {
                        if (e.adb(h.this.ACx) == 1 && e.adb(str) == 2) {
                            h.this.type = 1;
                        } else if (e.adb(h.this.ACx) == 2 && e.adb(str) == 1) {
                            h.this.type = 2;
                        }
                    }
                    h.this.ACx = str;
                    h.this.AAE = System.currentTimeMillis();
                    if (str == null) {
                        str = "";
                    }
                    e.dP(str, h.this.type);
                }

                public final void onPageLoadStopped(XWalkView xWalkView, String str, LoadStatus loadStatus) {
                    if (this.ACz == null || !this.ACz.equals(str)) {
                        this.ACz = str;
                        Log.i("XWWebView", "onPageFinished: url = " + str + " status = " + loadStatus);
                        h.this.iXj.a(h.this.AAx, str);
                        LoadStatus loadStatus2 = LoadStatus.FAILED;
                        e.j(str, System.currentTimeMillis() - h.this.AAE, h.this.type);
                        h.this.AAE = System.currentTimeMillis();
                        return;
                    }
                    Log.i("XWWebView", "abandoned onPageFinished: url = " + str + " status = " + loadStatus);
                }

                public final void onReceivedTitle(XWalkView xWalkView, String str) {
                    Log.i("XWWebView", "onReceivedTitle: " + str);
                    super.onReceivedTitle(xWalkView, str);
                    h.this.jKM.d(null, str);
                }

                public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                    Log.i("XWWebView", "onShowCustomView");
                    h.this.ACu.setVisibility(4);
                    h.this.jKM.onShowCustomView(view, new com.tencent.xweb.xwalk.e.a(customViewCallback));
                }

                public final void onHideCustomView() {
                    Log.i("XWWebView", "onHideCustomView");
                    h.this.ACu.setVisibility(0);
                    h.this.jKM.onHideCustomView();
                }

                public final View getVideoLoadingProgressView() {
                    Log.i("XWWebView", "getVideoLoadingProgressView");
                    return h.this.jKM.getVideoLoadingProgressView();
                }

                public final boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                    Log.i("XWWebView", "onJsAlert");
                    return h.this.jKM.a(h.this.AAx, str, str2, new c(xWalkJavascriptResult));
                }

                public final boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                    Log.i("XWWebView", "onJsConfirm");
                    return h.this.jKM.b(h.this.AAx, str, str2, new c(xWalkJavascriptResult));
                }

                public final boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                    Log.i("XWWebView", "onJsPrompt");
                    return h.this.jKM.a(h.this.AAx, str, str2, str3, new e.d(xWalkJavascriptResult));
                }

                public final void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
                    h.this.jKM.onGeolocationPermissionsShowPrompt(str, new b(xWalkGeolocationPermissionsCallback));
                }

                public final void onGeolocationPermissionsHidePrompt() {
                }

                public final boolean onConsoleMessage(XWalkView xWalkView, String str, int i, String str2, ConsoleMessageType consoleMessageType) {
                    Log.i("XWWebView", "onConsoleMessage " + str);
                    j jVar = h.this.jKM;
                    MessageLevel messageLevel = MessageLevel.DEBUG;
                    switch (consoleMessageType) {
                        case DEBUG:
                            messageLevel = MessageLevel.DEBUG;
                            break;
                        case ERROR:
                            messageLevel = MessageLevel.ERROR;
                            break;
                        case LOG:
                            messageLevel = MessageLevel.LOG;
                            break;
                        case INFO:
                            messageLevel = MessageLevel.TIP;
                            break;
                        case WARNING:
                            messageLevel = MessageLevel.WARNING;
                            break;
                    }
                    return jVar.onConsoleMessage(new ConsoleMessage(str, str2, i, messageLevel));
                }

                public final void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
                    Log.i("XWWebView", "openFileChooser with three param");
                    h.this.jKM.openFileChooser(valueCallback, str, str2);
                }

                public final boolean onCreateWindowRequested(XWalkView xWalkView, InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
                    return super.onCreateWindowRequested(xWalkView, initiateBy, valueCallback);
                }

                public final void onIconAvailable(XWalkView xWalkView, String str, Message message) {
                    super.onIconAvailable(xWalkView, str, message);
                }

                public final void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
                    super.onReceivedIcon(xWalkView, str, bitmap);
                }

                public final void onRequestFocus(XWalkView xWalkView) {
                    super.onRequestFocus(xWalkView);
                }

                public final void onJavascriptCloseWindow(XWalkView xWalkView) {
                    super.onJavascriptCloseWindow(xWalkView);
                }

                public final boolean onJavascriptModalDialog(XWalkView xWalkView, JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                    return super.onJavascriptModalDialog(xWalkView, javascriptMessageType, str, str2, str3, xWalkJavascriptResult);
                }

                public final void onFullscreenToggled(XWalkView xWalkView, boolean z) {
                    super.onFullscreenToggled(xWalkView, z);
                }

                public final void onScaleChanged(XWalkView xWalkView, float f, float f2) {
                    h.this.iXj.blM();
                }

                public final boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                    return super.shouldOverrideKeyEvent(xWalkView, keyEvent);
                }

                public final void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                    super.onUnhandledKeyEvent(xWalkView, keyEvent);
                }

                public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, i, customViewCallback);
                }
            };
            this.ACv.ACn = this.ACn;
            this.ACp.setUIClient(this.ACn);
            this.ACo = new k(this.ACp) {
                public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
                    boolean b = h.this.iXj.b(h.this.AAx, str);
                    Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + b + " url = " + str);
                    return b;
                }

                public final void onLoadStarted(XWalkView xWalkView, String str) {
                    h.this.iXj.f(h.this.AAx, str);
                }

                public final WebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, String str) {
                    m c = h.this.iXj.c(h.this.AAx, str);
                    if (c == null) {
                        return null;
                    }
                    return (c.mStatusCode == 0 || VERSION.SDK_INT < 21) ? new WebResourceResponse(c.mMimeType, c.mEncoding, c.mInputStream) : new WebResourceResponse(c.mMimeType, c.mEncoding, c.mStatusCode, c.mReasonPhrase, c.mResponseHeaders, c.mInputStream);
                }

                public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
                    m a;
                    m a2;
                    l hVar = new com.tencent.xweb.xwalk.e.h(xWalkWebResourceRequest);
                    Bundle bundle = hVar.AAs == null ? null : hVar.AAs.getBundle();
                    if (bundle != null) {
                        a = h.this.iXj.a(h.this.AAx, hVar, bundle);
                    } else {
                        a = null;
                    }
                    if (a == null) {
                        a2 = h.this.iXj.a(h.this.AAx, hVar);
                    } else {
                        a2 = a;
                    }
                    if (a2 != null) {
                        return createXWalkWebResourceResponse(a2.mMimeType, a2.mEncoding, a2.mInputStream, a2.mStatusCode, a2.mReasonPhrase, a2.mResponseHeaders);
                    }
                    return null;
                }

                public final void onReceivedLoadError(XWalkView xWalkView, int i, String str, String str2) {
                    Log.i("XWWebView", "onReceivedError " + str2);
                    super.onReceivedLoadError(xWalkView, i, str, str2);
                    h.this.ACw = true;
                    h.this.iXj.a(h.this.AAx, i, str, str2);
                    h.this.ACp.loadDataWithBaseURL("file:///android_asset/", String.format("<html>\n<head>\n</head>\n<body>\n<p><b><font size=\"15\">\n\n\n网页无法打开</font></b></p>\n<p><font size=\"7\">位于<b>%s</b>的网页无法加载，因为:</font></p>\n<p><font size=\"7\">错误码:%s</font></p>\n\n</body>\n\n</html>", new Object[]{str2, str}), "text/html", ProtocolPackage.ServerEncoding, null);
                    e.c(str2, i, System.currentTimeMillis() - h.this.AAE, h.this.type);
                }

                public final void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
                    Log.i("XWWebView", "onReceivedSslError " + sslError.getPrimaryError());
                    h.this.iXj.a(h.this.AAx, new e.g(valueCallback), sslError);
                }

                public final void onProgressChanged(XWalkView xWalkView, int i) {
                    Log.i("XWWebView", "onProgressChanged, progress = " + i);
                    h.this.jKM.a(h.this.AAx, i);
                }

                public final void onDocumentLoadedInFrame(XWalkView xWalkView, long j) {
                    super.onDocumentLoadedInFrame(xWalkView, j);
                }

                public final void onLoadFinished(XWalkView xWalkView, String str) {
                    super.onLoadFinished(xWalkView, str);
                }

                public final void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
                    super.onReceivedClientCertRequest(xWalkView, clientCertRequest);
                }

                public final void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
                    if (xWalkWebResourceResponse.getStatusCode() == HardCoderJNI.SCENE_QUIT_CHATTING) {
                        String str = (String) xWalkWebResourceResponse.getResponseHeaders().get("location");
                        if (str == null || str.isEmpty()) {
                            str = (String) xWalkWebResourceResponse.getResponseHeaders().get("Location");
                        }
                        if (str != null && str.trim().startsWith("weixin://")) {
                            h.this.iXj.b(h.this.AAx, str, null);
                            h.this.ACp.postDelayed(new Runnable() {
                                public final void run() {
                                    h.this.iXj.b(h.this.AAx, str, null);
                                }
                            }, 300);
                        }
                    } else if (xWalkWebResourceResponse.getStatusCode() >= 400) {
                        Log.i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
                        h.this.iXj.a(new com.tencent.xweb.xwalk.e.h(xWalkWebResourceRequest), xWalkWebResourceResponse == null ? null : new m(xWalkWebResourceResponse.getMimeType(), xWalkWebResourceResponse.getEncoding(), xWalkWebResourceResponse.getStatusCode(), xWalkWebResourceResponse.getReasonPhrase(), xWalkWebResourceResponse.getResponseHeaders(), xWalkWebResourceResponse.getData()));
                    }
                    super.onReceivedResponseHeaders(xWalkView, xWalkWebResourceRequest, xWalkWebResourceResponse);
                }

                public final void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
                    if (str == null || !str.startsWith("data:text/html;charset=utf-8")) {
                        h.this.iXj.a(h.this.AAx, str, z);
                    }
                }

                public final void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
                    super.onReceivedHttpAuthRequest(xWalkView, xWalkHttpAuthHandler, str, str2);
                }
            };
            this.ACv.ACo = this.ACo;
            this.ACp.setResourceClient(this.ACo);
        }
    }

    public h(WebView webView) {
        Context xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), this.mApkVersion);
        XWalkLibraryLoader.prepareToInit(xWalkContextWrapper);
        try {
            XWalkPreferences.setValue(XWalkPreferences.XWEB_VERSION, String.valueOf(this.mApkVersion));
            XWalkPreferences.setValue(XWalkPreferences.XWEBSDK_VERSION, "17");
        } catch (Exception e) {
            Log.e("XWWebView", e.getMessage());
        }
        this.ACp = new a(xWalkContextWrapper);
        this.ACu = new AbsoluteLayout(xWalkContextWrapper);
        this.ACp.getXWalkContentView().addView(this.ACu);
        this.ACp.setCustomOnScrollChangedListener(new ScrollChangedListener() {
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                h.this.ACu.scrollTo(i, i2);
                if (h.this.jAg != null) {
                    h.this.jAg.onScrollChanged(i, i2, i3, i4, h.this.ACp);
                }
            }
        });
        this.ACp.setCustomOnOverScrolledListener(new OverScrolledListener() {
            public final void onOverScrolled(boolean z) {
                if (z) {
                    h.this.ACy = true;
                } else {
                    h.this.ACy = false;
                }
            }
        });
        this.ACv = new f(this.ACp);
        this.AAx = webView;
        this.ACt = new i(this.ACp);
        this.ACp.getSettings().SetLogCallBack(new XWalkLogMessageListener() {
            public final void onLogMessage(int i, String str, int i2, String str2) {
                Log.i("WCWebview", "[WCWebview] severity:" + i + ", file:" + str + ", line:" + i2 + ", info:" + str2);
            }
        });
    }

    public final void setWebViewClient(p pVar) {
        if (pVar == null) {
            this.iXj = new p();
            this.iXj.Azp = this.ACv;
            return;
        }
        cJS();
        this.iXj = pVar;
    }

    public final void setWebChromeClient(j jVar) {
        if (jVar == null) {
            this.jKM = new j();
            return;
        }
        cJS();
        this.jKM = jVar;
    }

    public final void setDownloadListener(DownloadListener downloadListener) {
        this.ACp.setDownloadListener(new e.e(this.AAx.getContext(), downloadListener));
    }

    public final void setFindListener(FindListener findListener) {
        this.ACp.setFindListener(new f(findListener));
    }

    public final void loadUrl(String str) {
        if (str == null || !str.trim().startsWith("javascript:")) {
            this.ACw = false;
            this.ACp.loadUrl(str);
            return;
        }
        this.ACp.evaluateJavascript(str, null);
    }

    public final boolean canGoBack() {
        return !this.ACw && this.ACp.getNavigationHistory().canGoBack();
    }

    public final void goBack() {
        if (this.ACp.getNavigationHistory().canGoBack()) {
            this.ACp.getNavigationHistory().navigate(Direction.BACKWARD, 1);
            if (this.ACp.getNavigationHistory() != null && this.ACp.getNavigationHistory().getCurrentItem() != null) {
                this.jKM.d(this.AAx, this.ACp.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
    }

    public final boolean hasEnteredFullscreen() {
        return this.ACp.hasEnteredFullscreen();
    }

    public final void leaveFullscreen() {
        this.ACp.leaveFullscreen();
    }

    public final void clearView() {
    }

    public final void destroy() {
        this.ACp.onDestroy();
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.ACp.evaluateJavascript(str, valueCallback);
    }

    public final com.tencent.xweb.c.e getDefalutOpProvider() {
        return this.ACv;
    }

    public final void reload() {
        this.ACp.reload(0);
    }

    public final void clearSslPreferences() {
        this.ACp.clearSslPreferences();
    }

    public final void loadData(String str, String str2, String str3) {
        this.ACp.loadData(str, str2, str3);
    }

    public final int getContentHeight() {
        return this.ACp.getContentHeight();
    }

    public final float getScale() {
        return this.ACp.getScale();
    }

    public final int getVisibleTitleHeight() {
        return 0;
    }

    public final boolean overlayHorizontalScrollbar() {
        int scrollBarStyle = this.ACp.getScrollBarStyle();
        if (scrollBarStyle == 0 || scrollBarStyle == 33554432) {
            return true;
        }
        return false;
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.ACp.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final boolean zoomOut() {
        return this.ACp.zoomOut();
    }

    public final boolean zoomIn() {
        return this.ACp.zoomIn();
    }

    public final void loadUrl(String str, Map<String, String> map) {
        this.ACp.loadUrl(str, map);
    }

    public final void addJavascriptInterface(Object obj, String str) {
        this.ACp.addJavascriptInterface(obj, str);
    }

    public final View getView() {
        return this.ACp;
    }

    public final String getUrl() {
        return this.ACp.getUrl();
    }

    public final void removeJavascriptInterface(String str) {
        this.ACp.removeJavascriptInterface(str);
    }

    public final void stopLoading() {
        this.ACp.stopLoading();
    }

    public final void setWebViewCallbackClient(o oVar) {
        this.jAg = oVar;
    }

    public final com.tencent.xweb.WebView.a getHitTestResult() {
        com.tencent.xweb.WebView.a aVar = new com.tencent.xweb.WebView.a();
        XWalkHitTestResult hitTestResult = this.ACp.getHitTestResult();
        aVar.mType = hitTestResult.getType().ordinal();
        aVar.mExtra = hitTestResult.getExtra();
        return aVar;
    }

    public final String getTitle() {
        return this.ACp.getTitle();
    }

    public final n getSettings() {
        return this.ACt;
    }

    public final View getWebViewUI() {
        return this.ACp;
    }

    public final ViewGroup getTopView() {
        return this.ACu;
    }

    public final void clearMatches() {
        this.ACp.clearMatches();
    }

    public final void findNext(boolean z) {
        this.ACp.findNext(z);
    }

    public final void findAllAsync(String str) {
        this.ACp.findAllAsync(str);
    }

    public final String getVersionInfo() {
        return "webviewType = WV_KIND_CW,V8 type=" + com.tencent.xweb.g.cJg() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 17";
    }

    public final String getAbstractInfo() {
        return "webviewtype = xwalk, sdkver = 17\n apkver = " + XWalkEnvironment.getAvailableVersion();
    }

    public final p getCurWebviewClient() {
        return this.iXj;
    }

    public final j getCurWebChromeClient() {
        return this.jKM;
    }

    public final int getWebScrollY() {
        return this.ACp.computeVerticalScrollOffset();
    }

    public final int getWebScrollX() {
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            return ((XWalkView) webViewUI).computeHorizontalScrollOffset();
        }
        return webViewUI.getScrollX();
    }

    public final boolean isOverScrollStart() {
        int computeVerticalScrollOffset;
        boolean z = this.ACy;
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            computeVerticalScrollOffset = ((XWalkView) webViewUI).computeVerticalScrollOffset();
        } else {
            computeVerticalScrollOffset = webViewUI.getScrollY();
        }
        if (computeVerticalScrollOffset == 0 && z) {
            return true;
        }
        return false;
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
    }

    public final void onPause() {
    }
}
