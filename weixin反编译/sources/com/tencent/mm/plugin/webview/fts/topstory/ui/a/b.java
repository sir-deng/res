package com.tencent.mm.plugin.webview.fts.topstory.ui.a;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.webview.fts.topstory.ui.f;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public TextView ikn;
    public View lTf;
    public TextView qdW;
    public f twD;
    public FrameLayout twE;
    public View twF;
    public ImageView twG;
    public TextView twH;
    public TextView twI;
    public View twJ;
    public View twK;
    public View twL;

    public final void bQU() {
        x.d("MicroMsg.WebSearch.TopStoryTimeLineItemViewHolder", "showMaskView %d", Integer.valueOf(hashCode()));
        this.twL.animate().cancel();
        this.twK.animate().cancel();
        this.twJ.animate().cancel();
        this.twJ.setAlpha(0.8f);
        this.twL.setAlpha(0.8f);
        this.twK.setAlpha(0.8f);
    }

    public final void bQm() {
        this.twL.animate().cancel();
        this.twK.animate().cancel();
        this.twL.setAlpha(0.0f);
        this.twK.setAlpha(0.0f);
    }

    public final void bQl() {
        this.twL.animate().cancel();
        this.twK.animate().cancel();
        this.twL.animate().alpha(0.8f).setDuration(200).setStartDelay(3000).start();
        this.twK.animate().alpha(0.8f).setDuration(200).setStartDelay(3000).start();
    }
}
