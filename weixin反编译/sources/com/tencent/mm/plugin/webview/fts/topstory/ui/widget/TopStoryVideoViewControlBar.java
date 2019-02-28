package com.tencent.mm.plugin.webview.fts.topstory.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoViewControlBar;
import com.tencent.mm.sdk.platformtools.ad;

public class TopStoryVideoViewControlBar extends FtsWebVideoViewControlBar {
    public View twX;
    public TextView twY;
    private ViewGroup twZ;
    private int txa;
    public a txb;

    public interface a {
        void bQM();

        void bQN();

        void update(int i, int i2);
    }

    public TopStoryVideoViewControlBar(Context context) {
        super(context);
    }

    public TopStoryVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopStoryVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final int getLayoutId() {
        return R.i.dtp;
    }

    protected final void init() {
        super.init();
        this.twX = this.contentView.findViewById(R.h.cNT);
        this.twY = (TextView) this.contentView.findViewById(R.h.cks);
        this.twZ = (ViewGroup) findViewById(R.h.cCQ);
        this.txa = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 20);
    }

    public final void bQV() {
        super.bQV();
        this.twX.setVisibility(0);
        this.twY.setVisibility(0);
        this.twZ.setPadding(0, 0, this.txa, 0);
    }

    public final void agI() {
        super.agI();
        this.twX.setVisibility(8);
        this.twY.setVisibility(8);
        this.twZ.setPadding(0, 0, 0, 0);
    }

    public final void kp(boolean z) {
        this.txU.setVisibility(0);
        super.kp(z);
    }

    protected final void Ax(int i) {
        super.Ax(i);
        if (this.txb != null) {
            this.txb.update(i, this.qAp.getWidth());
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.txb != null) {
                this.txb.bQN();
            }
        } else if (i == 0 && this.txb != null) {
            this.txb.bQM();
        }
    }
}
