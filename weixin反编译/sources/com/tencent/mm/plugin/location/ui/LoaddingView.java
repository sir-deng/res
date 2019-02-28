package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;

public class LoaddingView extends LinearLayout implements c {
    private TextView nYd;
    private ProgressBar nYe;
    private Animation nYf;
    private View nYg;
    private boolean nYh = false;
    private String nYi = "";

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.nYf = AnimationUtils.loadAnimation(context, R.a.bqH);
        View inflate = LayoutInflater.from(context).inflate(R.i.dmQ, this, true);
        this.nYe = (ProgressBar) inflate.findViewById(R.h.ctZ);
        this.nYd = (TextView) inflate.findViewById(R.h.cuj);
        this.nYg = inflate.findViewById(R.h.ctR);
        this.nYd.setText("");
        this.nYd.setVisibility(0);
        this.nYe.setVisibility(0);
    }

    public final void setText(String str) {
        if (this.nYd != null && this.nYe != null && !this.nYh) {
            if (bi.oN(str)) {
                this.nYd.setText("");
                this.nYd.setVisibility(0);
                this.nYe.setVisibility(0);
                return;
            }
            this.nYd.setText(str);
            this.nYe.setVisibility(8);
            this.nYd.setVisibility(0);
        }
    }

    public final String aWs() {
        return this.nYi;
    }
}
