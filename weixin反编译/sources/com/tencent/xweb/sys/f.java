package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import com.tencent.smtt.utils.o;
import com.tencent.xweb.n;

public final class f extends n {
    WebView AAM;
    String AAN = "";

    public f(WebView webView) {
        this.AAM = webView;
        getUserAgentString();
    }

    public final void setSupportZoom(boolean z) {
        this.AAM.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        if (VERSION.SDK_INT >= 17) {
            this.AAM.getSettings().setMediaPlaybackRequiresUserGesture(z);
        }
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.AAM.getSettings().setBuiltInZoomControls(z);
    }

    public final void cJi() {
        this.AAM.getSettings().setDisplayZoomControls(false);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.AAM.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cJj() {
        this.AAM.getSettings().setSaveFormData(false);
    }

    public final void cJk() {
        this.AAM.getSettings().setJavaScriptEnabled(false);
    }

    public final void setTextZoom(int i) {
        this.AAM.getSettings().setTextZoom(i);
    }

    public final void setUseWideViewPort(boolean z) {
        this.AAM.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.AAM.getSettings().setLayoutAlgorithm(layoutAlgorithm);
    }

    public final void cJl() {
        this.AAM.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.AAM.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.AAM.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
        o.b(this.AAM.getSettings(), "setPluginsEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public final void setDatabasePath(String str) {
        this.AAM.getSettings().setDatabasePath(str);
    }

    public final void cJm() {
        this.AAM.getSettings().setJavaScriptEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.AAM.getSettings().setAppCachePath(str);
    }

    public final void cJn() {
        this.AAM.getSettings().setAppCacheMaxSize(10485760);
    }

    public final void cJo() {
        this.AAM.getSettings().setDatabaseEnabled(true);
    }

    public final void cJp() {
        this.AAM.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.AAM.getSettings().setJavaScriptEnabled(z);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.AAM.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
        this.AAM.getSettings().setDefaultTextEncodingName(str);
    }

    public final void setUserAgentString(String str) {
        this.AAN = str;
        this.AAM.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        if (this.AAN == null || this.AAN.isEmpty()) {
            try {
                this.AAN = this.AAM.getSettings().getUserAgentString();
            } catch (Exception e) {
            }
        }
        return this.AAN;
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        this.AAM.getSettings().setRenderPriority(renderPriority);
    }

    public final void cJq() {
        this.AAM.getSettings().setCacheMode(-1);
    }

    public final void cJr() {
        if (VERSION.SDK_INT >= 21) {
            this.AAM.getSettings().setMixedContentMode(0);
        }
    }
}
