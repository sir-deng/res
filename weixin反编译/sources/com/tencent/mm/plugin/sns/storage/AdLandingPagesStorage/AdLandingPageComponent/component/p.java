package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class p extends i {
    MMWebView jAa;
    FrameLayout rqw;

    public p(Context context, v vVar, ViewGroup viewGroup) {
        super(context, vVar, viewGroup);
    }

    protected final void bxK() {
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        int width = windowManager.getDefaultDisplay().getWidth();
        int height = windowManager.getDefaultDisplay().getHeight();
        this.jAa.setVerticalScrollBarEnabled(false);
        this.jAa.setHorizontalScrollBarEnabled(false);
        this.jAa.getSettings().setJavaScriptEnabled(true);
        this.jAa.loadUrl(((v) this.rpm).nAW);
        this.jAa.setLayoutParams(new LayoutParams(-1, -1));
        this.jAa.setVisibility(0);
        this.rqw.setPadding(this.rqw.getPaddingLeft(), (int) ((v) this.rpm).rmP, this.rqw.getPaddingRight(), (int) ((v) this.rpm).rmQ);
        this.rqw.setLayoutParams(new LinearLayout.LayoutParams(width, height));
    }

    public final View bxG() {
        this.rqw = (FrameLayout) this.contentView;
        this.jAa = a.co(this.context);
        this.rqw.addView(this.jAa);
        return this.rqw;
    }

    protected final int bkr() {
        return Integer.MAX_VALUE;
    }

    protected final View bxL() {
        return new FrameLayout(this.context);
    }
}
