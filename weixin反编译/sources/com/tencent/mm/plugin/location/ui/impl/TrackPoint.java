package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.f;
import com.tencent.mm.pluginsdk.ui.a.b;

public class TrackPoint extends LinearLayout {
    private ImageView hxJ;
    public double jpg = -1.0d;
    public double jph = -1.0d;
    public double jpi = -1.0d;
    public double jpj = -1.0d;
    private Context mContext;
    public ImageView odV;
    public ImageView odW;
    public View odX;
    private double odY = 0.0d;
    private String username;
    public boolean visible = true;

    public TrackPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public TrackPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.dtr, this);
        this.hxJ = (ImageView) inflate.findViewById(R.h.cSP);
        this.odV = (ImageView) inflate.findViewById(R.h.cSR);
        this.odW = (ImageView) inflate.findViewById(R.h.cSQ);
        this.odW.setVisibility(4);
        this.odX = inflate.findViewById(R.h.cSO);
        this.hxJ.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (TrackPoint.this.odX.getVisibility() == 0) {
                    TrackPoint.this.odX.setVisibility(4);
                } else {
                    TrackPoint.this.odX.setVisibility(0);
                }
                return false;
            }
        });
        this.odV.requestFocus();
    }

    public final void f(OnClickListener onClickListener) {
        this.odV.setOnClickListener(onClickListener);
    }

    public final void g(OnClickListener onClickListener) {
        this.hxJ.setOnClickListener(onClickListener);
    }

    public final void Ex(String str) {
        this.username = str;
        this.odV.setTag(str);
        b.o(this.hxJ, str);
        this.hxJ.setTag(str);
    }

    public final void aXo() {
        this.visible = false;
        this.odX.setVisibility(4);
    }

    public final void aXp() {
        this.visible = true;
        this.odX.setVisibility(0);
    }

    public final void o(double d) {
        float f = (float) this.odY;
        float f2 = (float) d;
        Animation rotateAnimation = new RotateAnimation(f.x(f, f2), f.w(f, f2), 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        this.odV.startAnimation(rotateAnimation);
        this.odY = d;
    }

    public final void aXq() {
        this.odW.setVisibility(4);
    }
}
