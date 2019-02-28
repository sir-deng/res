package com.tencent.xweb.x5;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebSettings.TextSize;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.n.a;

public final class k extends n {
    WebView ABv;

    public k(WebView webView) {
        this.ABv = webView;
    }

    public final void setSupportZoom(boolean z) {
        this.ABv.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        this.ABv.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.ABv.getSettings().setBuiltInZoomControls(z);
    }

    public final void cJi() {
        this.ABv.getSettings().setDisplayZoomControls(false);
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.ABv.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cJj() {
        this.ABv.getSettings().setSaveFormData(false);
    }

    public final void cJk() {
        this.ABv.getSettings().setJavaScriptEnabled(false);
    }

    public final void setTextZoom(int i) {
        this.ABv.getSettings().setTextZoom(i);
    }

    public final synchronized void a(a aVar) {
        this.ABv.getSettings().setTextSize(TextSize.valueOf(aVar.name()));
    }

    public final void setUseWideViewPort(boolean z) {
        this.ABv.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.ABv.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
    }

    public final void cJl() {
        this.ABv.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.ABv.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.ABv.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
        this.ABv.getSettings().setPluginsEnabled(z);
    }

    public final void setDatabasePath(String str) {
        this.ABv.getSettings().setDatabasePath(str);
    }

    public final void cJm() {
        this.ABv.getSettings().setJavaScriptEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.ABv.getSettings().setAppCachePath(str);
    }

    public final void cJn() {
        this.ABv.getSettings().setAppCacheMaxSize(10485760);
    }

    public final void cJo() {
        this.ABv.getSettings().setDatabaseEnabled(true);
    }

    public final void cJp() {
        this.ABv.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
        this.ABv.getSettings().setJavaScriptEnabled(z);
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.ABv.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
        this.ABv.getSettings().setDefaultTextEncodingName(str);
    }

    public final void setUserAgentString(String str) {
        this.ABv.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        return this.ABv.getSettings().getUserAgentString();
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
        this.ABv.getSettings().setRenderPriority(WebSettings.RenderPriority.values()[renderPriority.ordinal()]);
    }

    public final void cJq() {
        this.ABv.getSettings().setCacheMode(-1);
    }

    public final void cJr() {
        this.ABv.getSettings().setMixedContentMode(0);
    }
}
