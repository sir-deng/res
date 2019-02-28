package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bu.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;

public class SnsTranslateResultView extends LinearLayout {
    private static final int rQQ = Color.parseColor("#19000000");
    private Drawable hFD;
    public TextView qdX;
    private TextView rQO;
    public View rQP;
    private int rQR = -1;
    private float rQS = -1.0f;
    private int rQT = -1;

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(g.qOr, this);
        this.rQO = (TextView) findViewById(f.qLE);
        this.qdX = (TextView) findViewById(f.qLF);
        this.rQP = findViewById(f.qLR);
        this.hFD = getResources().getDrawable(e.qFW);
        this.hFD.setBounds(0, 0, (int) (this.qdX.getTextSize() * 0.8f), (int) (this.qdX.getTextSize() * 0.8f));
        this.hFD.setColorFilter(rQQ, Mode.SRC_IN);
    }

    public final void yh(int i) {
        this.qdX.setCompoundDrawables(this.hFD, null, null, null);
        this.qdX.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.qdX.setText(j.qSF);
        com.tencent.mm.ui.tools.j.a(this.qdX, null);
        this.rQO.setVisibility(4);
        this.rQR = i;
        this.qdX.setTextSize(0, this.rQO.getTextSize());
        this.qdX.setTextColor(getContext().getResources().getColor(c.qEH));
    }

    public final void ay(float f) {
        this.qdX.setTextSize(1, f);
        this.rQS = f;
        this.rQT = 1;
    }

    public final void az(float f) {
        this.qdX.setTextSize(0, f);
        this.rQS = f;
        this.rQT = 0;
    }

    @TargetApi(11)
    public final void a(final b bVar, int i, String str, String str2, boolean z) {
        this.rQR = i;
        if (this.rQS != -1.0f || this.rQT != -1) {
            this.qdX.setTextSize(this.rQT, this.rQS);
        } else if (this.rQR == 2) {
            this.qdX.setTextSize(1, 14.0f * a.ev(getContext()));
        } else if (this.rQR == 1) {
            this.qdX.setTextSize(1, 15.0f * a.ev(getContext()));
        }
        if (this.rQR == 2) {
            this.qdX.setTextColor(getContext().getResources().getColor(c.qEG));
        } else if (this.rQR == 1) {
            this.qdX.setTextColor(getContext().getResources().getColor(c.qEI));
        }
        if (bi.oN(str)) {
            this.qdX.setText(j.qSD);
        } else {
            this.qdX.setText(str);
            i.f(this.qdX, 2);
        }
        this.qdX.setCompoundDrawables(null, null, null, null);
        if (z && d.fN(11)) {
            com.tencent.mm.ui.tools.j.a(this.qdX, new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    if (bVar != null) {
                        ao.a(bVar);
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        if (bi.oN(str2)) {
            this.rQO.setText(j.dTu);
        } else {
            this.rQO.setText(str2);
        }
        this.rQO.setVisibility(0);
    }
}
