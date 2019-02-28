package com.tencent.xweb.xwalk;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;
import com.tencent.xweb.n;
import org.xwalk.core.XWalkSettings;
import org.xwalk.core.XWalkView;

public final class i extends n {
    XWalkView ACD;

    public i(XWalkView xWalkView) {
        this.ACD = xWalkView;
    }

    public final void setSupportZoom(boolean z) {
        this.ACD.getSettings().setSupportZoom(z);
    }

    public final void setMediaPlaybackRequiresUserGesture(boolean z) {
        this.ACD.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setBuiltInZoomControls(boolean z) {
        this.ACD.getSettings().setBuiltInZoomControls(z);
    }

    public final void cJi() {
    }

    public final void setLoadWithOverviewMode(boolean z) {
        this.ACD.getSettings().setLoadWithOverviewMode(z);
    }

    public final void cJj() {
        this.ACD.getSettings().setSaveFormData(false);
    }

    public final void cJk() {
    }

    public final void setTextZoom(int i) {
        this.ACD.getSettings().setTextZoom(i);
    }

    public final void setUseWideViewPort(boolean z) {
        this.ACD.getSettings().setUseWideViewPort(z);
    }

    public final void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm) {
        this.ACD.getSettings().setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.values()[layoutAlgorithm.ordinal()]);
    }

    public final void cJl() {
        this.ACD.getSettings().setDefaultFontSize(8);
    }

    public final void setLoadsImagesAutomatically(boolean z) {
        this.ACD.getSettings().setLoadsImagesAutomatically(z);
    }

    public final void setJavaScriptEnabled(boolean z) {
        this.ACD.getSettings().setJavaScriptEnabled(z);
    }

    public final void setPluginsEnabled(boolean z) {
    }

    public final void setDatabasePath(String str) {
    }

    public final void cJm() {
        this.ACD.getSettings().setAppCacheEnabled(true);
    }

    public final void setAppCachePath(String str) {
        this.ACD.getSettings().setAppCachePath(str);
    }

    public final void cJn() {
    }

    public final void cJo() {
        this.ACD.getSettings().setDatabaseEnabled(true);
    }

    public final void cJp() {
        this.ACD.getSettings().setDomStorageEnabled(true);
    }

    public final void setGeolocationEnabled(boolean z) {
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(boolean z) {
        this.ACD.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setDefaultTextEncodingName(String str) {
    }

    public final void setUserAgentString(String str) {
        this.ACD.getSettings().setUserAgentString(str);
    }

    public final String getUserAgentString() {
        return this.ACD.getUserAgentString();
    }

    public final void setRenderPriority(RenderPriority renderPriority) {
    }

    public final void cJq() {
        this.ACD.getSettings().setCacheMode(-1);
    }

    public final void cJr() {
    }
}
