package com.tencent.xweb.x5;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ab;
import com.tencent.smtt.sdk.ae;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.o;
import java.util.Map;

public final class a {

    public static class b implements FindListener {
        WebView.FindListener AAR;

        public b(WebView.FindListener findListener) {
            this.AAR = findListener;
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            if (this.AAR != null) {
                this.AAR.onFindResultReceived(i, i2, z);
            }
        }
    }

    public static class d<T> implements ab<T> {
        ValueCallback<T> AAS;

        public d(ValueCallback<T> valueCallback) {
            this.AAS = valueCallback;
        }

        public final void onReceiveValue(T t) {
            if (this.AAS != null) {
                this.AAS.onReceiveValue(t);
            }
        }
    }

    public static class a implements DownloadListener {
        android.webkit.DownloadListener AAQ;

        public a(android.webkit.DownloadListener downloadListener) {
            this.AAQ = downloadListener;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (this.AAQ != null) {
                this.AAQ.onDownloadStart(str, str2, str3, str4, j);
            }
        }
    }

    public static class f implements ae {
        o AAU;

        public f(o oVar) {
            this.AAU = oVar;
        }

        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            if (this.AAU != null) {
                return this.AAU.z(motionEvent);
            }
            return false;
        }

        public final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, View view) {
            if (this.AAU != null) {
                return this.AAU.a(i, i2, i3, i4, i5, i6, i7, i8, z);
            }
            return false;
        }

        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            if (this.AAU != null) {
                return this.AAU.A(motionEvent);
            }
            return false;
        }

        public final void computeScroll(View view) {
            if (this.AAU != null) {
                this.AAU.aik();
            }
        }

        public final void onOverScrolled(int i, int i2, boolean z, boolean z2, View view) {
            if (this.AAU != null) {
                this.AAU.b(i, i2, z, z2);
            }
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            if (this.AAU != null) {
                return this.AAU.B(motionEvent);
            }
            return false;
        }

        public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
            if (this.AAU != null) {
                this.AAU.onScrollChanged(i, i2, i3, i4, view);
            }
        }
    }

    public static class c implements JsResult {
        public com.tencent.xweb.f nfc;

        public c(com.tencent.xweb.f fVar) {
            this.nfc = fVar;
        }

        public final void confirm() {
            this.nfc.confirm();
        }

        public final void cancel() {
            this.nfc.cancel();
        }
    }

    public static class e implements WebResourceRequest {
        public l AAT;

        public static WebResourceRequest a(l lVar) {
            if (lVar == null) {
                return null;
            }
            return new e(lVar);
        }

        private e(l lVar) {
            this.AAT = lVar;
        }

        public final Uri getUrl() {
            return this.AAT.getUrl();
        }

        public final boolean isForMainFrame() {
            return this.AAT.isForMainFrame();
        }

        public final boolean isRedirect() {
            return false;
        }

        public final boolean hasGesture() {
            return this.AAT.hasGesture();
        }

        public final String getMethod() {
            return this.AAT.getMethod();
        }

        public final Map<String, String> getRequestHeaders() {
            return this.AAT.getRequestHeaders();
        }
    }

    public static WebResourceResponse b(m mVar) {
        if (mVar == null) {
            return null;
        }
        return new WebResourceResponse(mVar.mMimeType, mVar.mEncoding, mVar.mStatusCode, mVar.mReasonPhrase, mVar.mResponseHeaders, mVar.mInputStream);
    }
}
