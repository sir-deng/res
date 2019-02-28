package com.tencent.xweb.sys;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import com.tencent.xweb.sys.c.b;
import com.tencent.xweb.sys.c.c;
import com.tencent.xweb.sys.c.d;
import org.xwalk.core.Log;

class SysWebView$1 extends WebChromeClient {
    final /* synthetic */ e AAJ;

    SysWebView$1(e eVar) {
        this.AAJ = eVar;
    }

    public void onProgressChanged(WebView webView, int i) {
        Log.i("SysWebView", "onProgressChanged, progress = " + i);
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.a(this.AAJ.AAx, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        Log.i("SysWebView", "onReceivedTitle: " + str);
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.d(this.AAJ.AAx, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        Log.i("SysWebView", "onShowCustomView");
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    public void onHideCustomView() {
        Log.i("SysWebView", "onHideCustomView");
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Log.i("SysWebView", "onJsAlert");
        if (this.AAJ.AAA != null) {
            return this.AAJ.AAA.a(this.AAJ.AAx, str, str2, new d(jsResult));
        }
        return super.onJsAlert(webView, str, str2, jsResult);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Log.i("SysWebView", "onJsConfirm");
        if (this.AAJ.AAA != null) {
            return this.AAJ.AAA.b(this.AAJ.AAx, str, str2, new d(jsResult));
        }
        return super.onJsConfirm(webView, str, str2, jsResult);
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Log.i("SysWebView", "onJsPrompt");
        if (this.AAJ.AAA == null) {
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return this.AAJ.AAA.a(this.AAJ.AAx, str, str2, str3, new c(jsPromptResult));
    }

    public void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    public void onGeolocationPermissionsHidePrompt() {
        Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
        if (this.AAJ.AAA == null) {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Log.i("SysWebView", "onConsoleMessage " + consoleMessage.message());
        if (this.AAJ.AAA != null) {
            return this.AAJ.AAA.onConsoleMessage(consoleMessage);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        Log.i("SysWebView", "openFileChooser with one param");
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.openFileChooser(valueCallback, null, null);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        Log.i("SysWebView", "openFileChooser with two param");
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.openFileChooser(valueCallback, str, null);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        Log.i("SysWebView", "openFileChooser with three param");
        if (this.AAJ.AAA != null) {
            this.AAJ.AAA.openFileChooser(valueCallback, str, str2);
        } else {
            valueCallback.onReceiveValue(null);
        }
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        Log.i("SysWebView", "onShowFileChooser last method");
        if (this.AAJ.AAA != null) {
            return this.AAJ.AAA.a(this.AAJ.AAx, valueCallback, new b(fileChooserParams));
        }
        return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
    }

    public View getVideoLoadingProgressView() {
        if (this.AAJ.AAA != null) {
            return this.AAJ.AAA.getVideoLoadingProgressView();
        }
        return super.getVideoLoadingProgressView();
    }
}
