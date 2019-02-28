package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.r;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class SystemWebViewClient extends WebViewClient {
    private static String AfM = null;
    private WebView AeA;
    private WebViewClient AfL;

    private static class WebResourceRequestImpl2 implements WebResourceRequest {
        android.webkit.WebResourceRequest mWebResourceRequest;

        WebResourceRequestImpl2(android.webkit.WebResourceRequest webResourceRequest) {
            this.mWebResourceRequest = webResourceRequest;
        }

        public String getMethod() {
            return this.mWebResourceRequest.getMethod();
        }

        public Map<String, String> getRequestHeaders() {
            return this.mWebResourceRequest.getRequestHeaders();
        }

        public Uri getUrl() {
            return this.mWebResourceRequest.getUrl();
        }

        public boolean hasGesture() {
            return this.mWebResourceRequest.hasGesture();
        }

        public boolean isForMainFrame() {
            return this.mWebResourceRequest.isForMainFrame();
        }

        public boolean isRedirect() {
            if (VERSION.SDK_INT >= 24) {
                Object f = o.f(this.mWebResourceRequest, "isRedirect");
                if (f instanceof Boolean) {
                    return ((Boolean) f).booleanValue();
                }
            }
            return false;
        }
    }

    private static class ClientCertRequestImpl extends ClientCertRequest {
        private android.webkit.ClientCertRequest mClientCertRequest;

        public ClientCertRequestImpl(android.webkit.ClientCertRequest clientCertRequest) {
            this.mClientCertRequest = clientCertRequest;
        }

        public void cancel() {
            this.mClientCertRequest.cancel();
        }

        public String getHost() {
            return this.mClientCertRequest.getHost();
        }

        public String[] getKeyTypes() {
            return this.mClientCertRequest.getKeyTypes();
        }

        public int getPort() {
            return this.mClientCertRequest.getPort();
        }

        public Principal[] getPrincipals() {
            return this.mClientCertRequest.getPrincipals();
        }

        public void ignore() {
            this.mClientCertRequest.ignore();
        }

        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.mClientCertRequest.proceed(privateKey, x509CertificateArr);
        }
    }

    private static class HttpAuthHandlerImpl implements HttpAuthHandler {
        private android.webkit.HttpAuthHandler mHandler;

        HttpAuthHandlerImpl(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.mHandler = httpAuthHandler;
        }

        public void cancel() {
            this.mHandler.cancel();
        }

        public void proceed(String str, String str2) {
            this.mHandler.proceed(str, str2);
        }

        public boolean useHttpAuthUsernamePassword() {
            return this.mHandler.useHttpAuthUsernamePassword();
        }
    }

    private static class WebResourceResponseImpl2 extends WebResourceResponse {
        android.webkit.WebResourceResponse mWebResourceResponse;

        public WebResourceResponseImpl2(android.webkit.WebResourceResponse webResourceResponse) {
            this.mWebResourceResponse = webResourceResponse;
        }

        public InputStream getData() {
            return this.mWebResourceResponse.getData();
        }

        public String getEncoding() {
            return this.mWebResourceResponse.getEncoding();
        }

        public String getMimeType() {
            return this.mWebResourceResponse.getMimeType();
        }

        public String getReasonPhrase() {
            return this.mWebResourceResponse.getReasonPhrase();
        }

        public Map<String, String> getResponseHeaders() {
            return this.mWebResourceResponse.getResponseHeaders();
        }

        public int getStatusCode() {
            return this.mWebResourceResponse.getStatusCode();
        }

        public void setData(InputStream inputStream) {
            this.mWebResourceResponse.setData(inputStream);
        }

        public void setEncoding(String str) {
            this.mWebResourceResponse.setEncoding(str);
        }

        public void setMimeType(String str) {
            this.mWebResourceResponse.setMimeType(str);
        }

        public void setResponseHeaders(Map<String, String> map) {
            this.mWebResourceResponse.setResponseHeaders(map);
        }

        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.mWebResourceResponse.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    private class WebResourceRequestImpl implements WebResourceRequest {
        private boolean hasUserGesture;
        private boolean isMainFrame;
        private boolean isRedirect;
        private String method;
        private Map<String, String> requestHeaders;
        private String url;

        public WebResourceRequestImpl(String str, boolean z, boolean z2, boolean z3, String str2, Map<String, String> map) {
            this.url = str;
            this.isMainFrame = z;
            this.isRedirect = z2;
            this.hasUserGesture = z3;
            this.method = str2;
            this.requestHeaders = map;
        }

        public String getMethod() {
            return this.method;
        }

        public Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        public Uri getUrl() {
            return Uri.parse(this.url);
        }

        public boolean hasGesture() {
            return this.hasUserGesture;
        }

        public boolean isForMainFrame() {
            return this.isMainFrame;
        }

        public boolean isRedirect() {
            return this.isRedirect;
        }
    }

    private static class SslErrorImpl implements SslError {
        android.net.http.SslError mSslError;

        SslErrorImpl(android.net.http.SslError sslError) {
            this.mSslError = sslError;
        }

        public boolean addError(int i) {
            return this.mSslError.addError(i);
        }

        public SslCertificate getCertificate() {
            return this.mSslError.getCertificate();
        }

        public int getPrimaryError() {
            return this.mSslError.getPrimaryError();
        }

        public boolean hasError(int i) {
            return this.mSslError.hasError(i);
        }
    }

    private static class SslErrorHandlerImpl implements SslErrorHandler {
        android.webkit.SslErrorHandler mSslErrorHandler;

        SslErrorHandlerImpl(android.webkit.SslErrorHandler sslErrorHandler) {
            this.mSslErrorHandler = sslErrorHandler;
        }

        public void cancel() {
            this.mSslErrorHandler.cancel();
        }

        public void proceed() {
            this.mSslErrorHandler.proceed();
        }
    }

    SystemWebViewClient(WebView webView, WebViewClient webViewClient) {
        this.AeA = webView;
        this.AfL = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.AfL.doUpdateVisitedHistory(this.AeA, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.AfL.onFormResubmission(this.AeA, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        this.AfL.onLoadResource(this.AeA, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (AfM == null) {
            r cGz = r.cGz();
            if (cGz != null) {
                cGz.ob(true);
                AfM = Boolean.toString(true);
            }
        }
        WebView webView2 = this.AeA;
        webView2.AiA++;
        this.AfL.onPageFinished(this.AeA, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            WebView.hC(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.cFV();
        if (!(x.AhV || this.AeA.getContext() == null || !x.hs(this.AeA.getContext()))) {
            x.AhV = true;
            new Thread(new Runnable() {
                public void run() {
                    SystemWebViewClient.this.AeA.getContext();
                    if (p.gJ(SystemWebViewClient.this.AeA.getContext())) {
                        p.gK(SystemWebViewClient.this.AeA.getContext());
                    }
                }
            }).start();
        }
        if (this.AeA.getContext() != null && !v.hp(this.AeA.getContext()).Ahp) {
            v.hp(this.AeA.getContext()).Ahp = true;
            v.hp(this.AeA.getContext()).cFD();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.AfL.onPageStarted(this.AeA, str, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.AfL.onReceivedClientCertRequest(this.AeA, new ClientCertRequestImpl(clientCertRequest));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.AfL.onReceivedError(this.AeA, i, str, str2);
    }

    public void onReceivedError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        WebResourceRequest webResourceRequestImpl2 = webResourceRequest != null ? new WebResourceRequestImpl2(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new com.tencent.smtt.export.external.interfaces.WebResourceError() {
                public CharSequence getDescription() {
                    return webResourceError.getDescription();
                }

                public int getErrorCode() {
                    return webResourceError.getErrorCode();
                }
            };
        }
        this.AfL.onReceivedError(this.AeA, webResourceRequestImpl2, webResourceError2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.AfL.onReceivedHttpAuthRequest(this.AeA, new HttpAuthHandlerImpl(httpAuthHandler), str, str2);
    }

    public void onReceivedHttpError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.AfL.onReceivedHttpError(this.AeA, new WebResourceRequestImpl2(webResourceRequest), new WebResourceResponseImpl2(webResourceResponse));
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 12) {
            this.AfL.onReceivedLoginRequest(this.AeA, str, str2, str3);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (VERSION.SDK_INT >= 8) {
            this.AfL.onReceivedSslError(this.AeA, new SslErrorHandlerImpl(sslErrorHandler), new SslErrorImpl(sslError));
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        this.AfL.onScaleChanged(this.AeA, f, f2);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.AfL.onTooManyRedirects(this.AeA, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.AfL.onUnhandledKeyEvent(this.AeA, keyEvent);
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT < 21) {
            return null;
        }
        if (webResourceRequest == null) {
            return null;
        }
        boolean z = false;
        if (VERSION.SDK_INT >= 24) {
            Object f = o.f(webResourceRequest, "isRedirect");
            if (f instanceof Boolean) {
                z = ((Boolean) f).booleanValue();
            }
        }
        WebResourceResponse shouldInterceptRequest = this.AfL.shouldInterceptRequest(this.AeA, new WebResourceRequestImpl(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
        int statusCode = shouldInterceptRequest.getStatusCode();
        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
        if (statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase()))) {
            return webResourceResponse;
        }
        webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        return webResourceResponse;
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.AfL.shouldInterceptRequest(this.AeA, str);
        return shouldInterceptRequest != null ? new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData()) : null;
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.AfL.shouldOverrideKeyEvent(this.AeA, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        String str = null;
        if (!(webResourceRequest == null || webResourceRequest.getUrl() == null)) {
            str = webResourceRequest.getUrl().toString();
        }
        if (str == null || this.AeA.showDebugView(str) || m.cGt().bQ(this.AeA.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean z = false;
        if (VERSION.SDK_INT >= 24) {
            Object f = o.f(webResourceRequest, "isRedirect");
            if (f instanceof Boolean) {
                z = ((Boolean) f).booleanValue();
            }
        }
        return this.AfL.shouldOverrideUrlLoading(this.AeA, new WebResourceRequestImpl(webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), z, webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return (str == null || this.AeA.showDebugView(str) || m.cGt().bQ(this.AeA.getContext().getApplicationContext(), str)) ? true : this.AfL.shouldOverrideUrlLoading(this.AeA, str);
    }
}
