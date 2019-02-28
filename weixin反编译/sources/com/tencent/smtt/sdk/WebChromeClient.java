package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.utils.TbsLog;

public class WebChromeClient {

    public static abstract class a {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public static Uri[] parseResult(int i, Intent intent) {
            try {
                af cFZ = af.cFZ();
                if (cFZ == null || !cFZ.cGa()) {
                    return VERSION.SDK_INT >= 21 ? FileChooserParams.parseResult(i, intent) : null;
                }
                Object invokeStaticMethod = cFZ.cGb().Ain.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
                return invokeStaticMethod == null ? null : (Uri[]) invokeStaticMethod;
            } catch (Exception e) {
                TbsLog.i("WebChromeClient", "parseResult:" + e.toString());
                return null;
            }
        }

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(ab<String[]> abVar) {
    }

    public void onCloseWindow(WebView webView) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return false;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, com.tencent.smtt.sdk.ad.a aVar) {
        aVar.updateQuota(j2);
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        geolocationPermissionsCallback.invoke(str, true, true);
    }

    public void onHideCustomView() {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean onJsTimeout() {
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
    }

    public void onReachedMaxAppCacheSize(long j, long j2, com.tencent.smtt.sdk.ad.a aVar) {
        aVar.updateQuota(j2);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
    }

    public boolean onShowFileChooser(WebView webView, ab<Uri[]> abVar, a aVar) {
        return false;
    }

    public void openFileChooser(ab<Uri> abVar, String str, String str2) {
        abVar.onReceiveValue(null);
    }
}
