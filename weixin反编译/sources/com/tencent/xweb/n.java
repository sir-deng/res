package com.tencent.xweb;

import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.RenderPriority;

public abstract class n {

    public enum a {
        SMALLEST(50),
        SMALLER(75),
        NORMAL(100),
        LARGER(150),
        LARGEST(200);
        
        int value;

        private a(int i) {
            this.value = i;
        }
    }

    public abstract void cJi();

    public abstract void cJj();

    @Deprecated
    public abstract void cJk();

    public abstract void cJl();

    public abstract void cJm();

    @Deprecated
    public abstract void cJn();

    public abstract void cJo();

    public abstract void cJp();

    public abstract void cJq();

    public abstract void cJr();

    public abstract String getUserAgentString();

    public abstract void setAppCachePath(String str);

    public abstract void setBuiltInZoomControls(boolean z);

    @Deprecated
    public abstract void setDatabasePath(String str);

    public abstract void setDefaultTextEncodingName(String str);

    public abstract void setGeolocationEnabled(boolean z);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(boolean z);

    public abstract void setJavaScriptEnabled(boolean z);

    public abstract void setLayoutAlgorithm(LayoutAlgorithm layoutAlgorithm);

    public abstract void setLoadWithOverviewMode(boolean z);

    public abstract void setLoadsImagesAutomatically(boolean z);

    public abstract void setMediaPlaybackRequiresUserGesture(boolean z);

    public abstract void setPluginsEnabled(boolean z);

    @Deprecated
    public abstract void setRenderPriority(RenderPriority renderPriority);

    public abstract void setSupportZoom(boolean z);

    public abstract void setTextZoom(int i);

    public abstract void setUseWideViewPort(boolean z);

    public abstract void setUserAgentString(String str);

    public synchronized void a(a aVar) {
        setTextZoom(aVar.value);
    }
}
