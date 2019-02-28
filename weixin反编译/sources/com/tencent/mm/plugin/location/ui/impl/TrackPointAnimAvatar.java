package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;

public class TrackPointAnimAvatar extends RelativeLayout {
    private ImageView hxJ;
    private Context mContext;
    private LinearLayout oea;
    private Animation oeb;
    private Animation oec;

    public TrackPointAnimAvatar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPointAnimAvatar(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.dts, this);
        this.oea = (LinearLayout) inflate.findViewById(R.h.bKk);
        this.hxJ = (ImageView) inflate.findViewById(R.h.bKj);
        this.oeb = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.5f);
        this.oeb.setDuration(500);
        this.oeb.setFillAfter(true);
        this.oec = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.5f, 1, 0.0f);
        this.oec.setDuration(500);
        this.oec.setFillAfter(true);
        this.oeb.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                TrackPointAnimAvatar.this.bringToFront();
                TrackPointAnimAvatar.this.oea.startAnimation(TrackPointAnimAvatar.this.oec);
            }
        });
        this.oec.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                TrackPointAnimAvatar.this.bringToFront();
                TrackPointAnimAvatar.this.oea.startAnimation(TrackPointAnimAvatar.this.oeb);
            }
        });
    }
}
