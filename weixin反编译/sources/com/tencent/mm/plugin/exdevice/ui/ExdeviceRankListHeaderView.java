package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private Context mContext;
    private TextView mda;
    OnClickListener mdb;
    private Animation mdc;
    private Animation mdd;
    private Runnable mde;
    boolean mdf;

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        ah.K(exdeviceRankListHeaderView.mde);
        if (exdeviceRankListHeaderView.mda.getVisibility() == 4) {
            exdeviceRankListHeaderView.mdc.reset();
            exdeviceRankListHeaderView.mda.startAnimation(exdeviceRankListHeaderView.mdc);
            return;
        }
        exdeviceRankListHeaderView.mdd.reset();
        exdeviceRankListHeaderView.mda.startAnimation(exdeviceRankListHeaderView.mdd);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mdf = true;
        ce(context);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        this.mdf = true;
        ce(context);
    }

    private void ce(Context context) {
        this.mContext = context;
        this.mda = (TextView) LayoutInflater.from(this.mContext).inflate(R.i.dhk, this, true).findViewById(R.h.bSB);
        this.mda.setVisibility(4);
        this.mdc = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_in);
        this.mdd = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_out);
        this.mde = new Runnable() {
            public final void run() {
                ExdeviceRankListHeaderView.this.mda.startAnimation(ExdeviceRankListHeaderView.this.mdd);
            }
        };
        this.mdc.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                ExdeviceRankListHeaderView.this.mda.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ExdeviceRankListHeaderView.this.mdd.reset();
                ah.h(ExdeviceRankListHeaderView.this.mde, 4000);
            }
        });
        this.mdd.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                ExdeviceRankListHeaderView.this.mda.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ExdeviceRankListHeaderView.this.mda.setVisibility(4);
            }
        });
        this.mdc.setFillAfter(true);
        this.mdc.setFillEnabled(true);
        this.mdd.setFillAfter(true);
        this.mdd.setFillAfter(true);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ExdeviceRankListHeaderView.this.mdf) {
                    ExdeviceRankListHeaderView.b(ExdeviceRankListHeaderView.this);
                }
                if (ExdeviceRankListHeaderView.this.mdb != null) {
                    ExdeviceRankListHeaderView.this.mdb.onClick(ExdeviceRankListHeaderView.this);
                }
            }
        });
    }
}
