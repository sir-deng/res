package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.xweb.f;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.util.Map;

public final class c {

    public static class b extends com.tencent.xweb.j.a {
        public FileChooserParams AAp;

        public b(FileChooserParams fileChooserParams) {
            this.AAp = fileChooserParams;
        }

        @TargetApi(21)
        public final int getMode() {
            if (this.AAp != null) {
                return this.AAp.getMode();
            }
            return 0;
        }

        @TargetApi(21)
        public final String[] getAcceptTypes() {
            if (this.AAp != null) {
                return this.AAp.getAcceptTypes();
            }
            return new String[0];
        }

        @TargetApi(21)
        public final boolean isCaptureEnabled() {
            if (this.AAp != null) {
                return this.AAp.isCaptureEnabled();
            }
            return false;
        }
    }

    public static class d extends f {
        public JsResult mJsResult;

        public d(JsResult jsResult) {
            this.mJsResult = jsResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            if (this.mJsResult != null) {
                this.mJsResult.confirm();
            }
        }

        public final void cancel() {
            if (this.mJsResult != null) {
                this.mJsResult.cancel();
            }
        }
    }

    public static class c extends com.tencent.xweb.e {
        public JsPromptResult AAq;

        public c(JsPromptResult jsPromptResult) {
            this.AAq = jsPromptResult;
        }

        public final void confirmWithResult(String str) {
        }

        public final void confirm() {
            if (this.AAq != null) {
                this.AAq.confirm();
            }
        }

        public final void cancel() {
            if (this.AAq != null) {
                this.AAq.cancel();
            }
        }
    }

    public static class e implements l {
        private Uri AAr;
        com.tencent.xweb.a.a AAs;
        private boolean hasUserGesture;
        private boolean isMainFrame;
        private String method;
        private Map<String, String> requestHeaders;

        public e(WebResourceRequest webResourceRequest) {
            if (VERSION.SDK_INT >= 21) {
                this.AAr = webResourceRequest.getUrl();
                this.isMainFrame = webResourceRequest.isForMainFrame();
                this.hasUserGesture = webResourceRequest.hasGesture();
                this.method = webResourceRequest.getMethod();
                this.requestHeaders = webResourceRequest.getRequestHeaders();
                this.AAs = new com.tencent.xweb.a.a(this);
            }
        }

        public final Uri getUrl() {
            return this.AAr;
        }

        public final boolean isForMainFrame() {
            return this.isMainFrame;
        }

        public final boolean hasGesture() {
            return this.hasUserGesture;
        }

        public final String getMethod() {
            return this.method;
        }

        public final Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }
    }

    @JgClassChecked(author = 30, fComment = "checked", lastDate = "20171024", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
    public static class a implements h {
        SslErrorHandler AAo;

        public a(SslErrorHandler sslErrorHandler) {
            this.AAo = sslErrorHandler;
        }

        public final void proceed() {
            this.AAo.proceed();
        }

        public final void cancel() {
            this.AAo.cancel();
        }
    }

    public static WebResourceResponse a(m mVar) {
        if (mVar == null) {
            return null;
        }
        if (mVar.mStatusCode == 0 || VERSION.SDK_INT < 21) {
            return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mInputStream);
        }
        return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mStatusCode, mVar.mReasonPhrase, mVar.mResponseHeaders, mVar.mInputStream);
    }
}
