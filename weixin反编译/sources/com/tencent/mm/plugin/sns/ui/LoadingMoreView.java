package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.rtmp.TXLiveConstants;

public class LoadingMoreView extends LinearLayout {
    private Context context;
    private ImageView fzb;
    protected LinearLayout kUr;
    protected LinearLayout kUs;
    protected LinearLayout rzX;
    protected LinearLayout rzY;
    protected TextView rzZ;

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public LoadingMoreView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.context).inflate(g.qNH, this, true);
        this.fzb = (ImageView) findViewById(f.bJS);
        this.kUr = (LinearLayout) inflate.findViewById(f.ctB);
        this.kUs = (LinearLayout) inflate.findViewById(f.ctz);
        this.rzX = (LinearLayout) inflate.findViewById(f.qLI);
        this.rzY = (LinearLayout) inflate.findViewById(f.qJi);
        this.rzZ = (TextView) inflate.findViewById(f.qJj);
        this.kUr.setVisibility(0);
        this.kUs.setVisibility(8);
        this.rzX.setVisibility(8);
        this.rzY.setVisibility(8);
        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.fzb.startAnimation(rotateAnimation);
    }

    public final void iJ(boolean z) {
        this.kUr.setVisibility(8);
        if (z) {
            this.rzX.setVisibility(0);
            this.kUs.setVisibility(8);
        } else {
            this.kUs.setVisibility(0);
            this.rzX.setVisibility(8);
        }
        this.rzY.setVisibility(8);
    }

    public final void xN(int i) {
        this.kUr.setVisibility(8);
        this.rzX.setVisibility(8);
        this.kUs.setVisibility(8);
        this.rzY.setVisibility(0);
        if (i == 2001) {
            this.rzZ.setText(getContext().getResources().getString(j.qSa));
        } else if (i == 2003) {
            this.rzZ.setText(getContext().getResources().getString(j.qQq));
        } else if (i == TXLiveConstants.PLAY_EVT_PLAY_BEGIN) {
            this.rzZ.setText(getContext().getResources().getString(j.qSb));
        }
    }
}
