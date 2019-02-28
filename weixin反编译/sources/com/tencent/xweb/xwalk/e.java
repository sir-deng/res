package com.tencent.xweb.xwalk;

import android.content.Context;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView.FindListener;
import com.tencent.xweb.l;
import java.util.Map;
import org.xwalk.core.XWalkDownloadListener;
import org.xwalk.core.XWalkFindListener;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkUIClient.ConsoleMessageType;
import org.xwalk.core.XWalkWebResourceRequest;

public final class e {

    public static class b implements Callback {
        XWalkGeolocationPermissionsCallback ACk;

        public b(XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
            this.ACk = xWalkGeolocationPermissionsCallback;
        }

        public final void invoke(String str, boolean z, boolean z2) {
            if (this.ACk != null) {
                this.ACk.invoke(str, z, z2);
            }
        }
    }

    public static class c extends com.tencent.xweb.f {
        public XWalkJavascriptResult ACl;

        public c(XWalkJavascriptResult xWalkJavascriptResult) {
            this.ACl = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            this.ACl.confirmWithResult(str);
        }

        public final void confirm() {
            this.ACl.confirm();
        }

        public final void cancel() {
            this.ACl.cancel();
        }
    }

    public static class d extends com.tencent.xweb.e {
        public XWalkJavascriptResult ACl;

        public d(XWalkJavascriptResult xWalkJavascriptResult) {
            this.ACl = xWalkJavascriptResult;
        }

        public final void confirmWithResult(String str) {
            this.ACl.confirmWithResult(str);
        }

        public final void confirm() {
            this.ACl.confirm();
        }

        public final void cancel() {
            this.ACl.cancel();
        }
    }

    public static class g implements com.tencent.xweb.h {
        ValueCallback<Boolean> ACm;

        public g(ValueCallback<Boolean> valueCallback) {
            this.ACm = valueCallback;
        }

        public final void proceed() {
            this.ACm.onReceiveValue(Boolean.valueOf(true));
        }

        public final void cancel() {
            this.ACm.onReceiveValue(Boolean.valueOf(false));
        }
    }

    public static class h implements l {
        private Uri AAr;
        com.tencent.xweb.a.a AAs = new com.tencent.xweb.a.a(this);
        private boolean hasUserGesture;
        private boolean isMainFrame;
        private String method;
        private Map<String, String> requestHeaders;

        public h(XWalkWebResourceRequest xWalkWebResourceRequest) {
            this.AAr = xWalkWebResourceRequest.getUrl();
            this.isMainFrame = xWalkWebResourceRequest.isForMainFrame();
            this.hasUserGesture = xWalkWebResourceRequest.hasGesture();
            this.method = xWalkWebResourceRequest.getMethod();
            this.requestHeaders = xWalkWebResourceRequest.getRequestHeaders();
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

    public static class a implements CustomViewCallback {
        org.xwalk.core.CustomViewCallback ACj;

        a(org.xwalk.core.CustomViewCallback customViewCallback) {
            this.ACj = customViewCallback;
        }

        public final void onCustomViewHidden() {
            this.ACj.onCustomViewHidden();
        }
    }

    public static class f extends XWalkFindListener {
        FindListener AAR;

        public f(FindListener findListener) {
            this.AAR = findListener;
        }

        public final void onFindResultReceived(int i, int i2, boolean z) {
            if (this.AAR != null) {
                this.AAR.onFindResultReceived(i, i2, z);
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.e$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ACi = new int[ConsoleMessageType.values().length];

        static {
            try {
                ACi[ConsoleMessageType.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ACi[ConsoleMessageType.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ACi[ConsoleMessageType.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ACi[ConsoleMessageType.INFO.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                ACi[ConsoleMessageType.WARNING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static class e extends XWalkDownloadListener {
        DownloadListener AAQ;

        public e(Context context, DownloadListener downloadListener) {
            super(context);
            this.AAQ = downloadListener;
        }

        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (this.AAQ != null) {
                this.AAQ.onDownloadStart(str, str2, str3, str4, j);
            }
        }
    }
}
