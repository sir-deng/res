package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private ImageButton mAF;
    private LayoutParams nxG;
    private ImageButton yBa;
    private ImageButton yBb;
    private ImageButton yBc;
    private ImageButton yBd;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.g.bzZ);
        this.nxG = new LayoutParams(0, getResources().getDimensionPixelSize(R.f.bvS), 1.0f);
        this.nxG.topMargin = a.fromDPToPix(getContext(), 0);
        this.yBa = new ImageButton(getContext());
        this.yBa.setImageResource(R.g.bAO);
        this.yBa.setScaleType(ScaleType.CENTER);
        this.yBa.setBackgroundResource(0);
        this.yBa.setContentDescription(context.getString(R.l.dSs));
        this.yBd = new ImageButton(getContext());
        this.yBd.setImageResource(R.g.bAM);
        this.yBd.setScaleType(ScaleType.CENTER);
        this.yBd.setBackgroundResource(0);
        this.yBd.setContentDescription(context.getString(R.l.dSr));
        this.mAF = new ImageButton(getContext());
        this.mAF.setImageResource(R.g.bAK);
        this.mAF.setScaleType(ScaleType.CENTER);
        this.mAF.setBackgroundResource(0);
        this.mAF.setContentDescription(context.getString(R.l.dSp));
        this.yBc = new ImageButton(getContext());
        this.yBc.setImageResource(R.g.bAN);
        this.yBc.setScaleType(ScaleType.CENTER);
        this.yBc.setBackgroundResource(0);
        this.yBc.setContentDescription(context.getString(R.l.dSo));
        this.yBb = new ImageButton(getContext());
        this.yBb.setImageResource(R.g.bAL);
        this.yBb.setScaleType(ScaleType.CENTER);
        this.yBb.setBackgroundResource(0);
        this.yBb.setContentDescription(context.getString(R.l.dSq));
        csu();
    }

    public final void csu() {
        removeAllViews();
        addView(this.yBa, this.nxG);
        addView(this.yBd, this.nxG);
        addView(this.mAF, this.nxG);
        if (i.csd().size() > 0) {
            addView(this.yBc, this.nxG);
        } else {
            addView(this.yBb, this.nxG);
        }
    }

    public final void FN(int i) {
        boolean z = i > 0;
        this.yBa.setClickable(z);
        this.yBa.setEnabled(z);
        if (i.csd().size() > 0) {
            this.yBc.setClickable(z);
            this.yBc.setEnabled(z);
        } else {
            this.yBb.setClickable(z);
            this.yBb.setEnabled(z);
        }
        this.mAF.setClickable(z);
        this.mAF.setEnabled(z);
        this.yBd.setClickable(z);
        this.yBd.setEnabled(z);
    }

    public final void c(int i, OnClickListener onClickListener) {
        switch (i) {
            case 0:
                this.yBa.setOnClickListener(onClickListener);
                return;
            case 1:
                this.yBb.setOnClickListener(onClickListener);
                return;
            case 2:
                this.yBc.setOnClickListener(onClickListener);
                return;
            case 3:
                this.mAF.setOnClickListener(onClickListener);
                return;
            case 4:
                this.yBd.setOnClickListener(onClickListener);
                return;
            default:
                x.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i));
                return;
        }
    }
}
