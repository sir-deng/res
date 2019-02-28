package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class ExdeviceLikeView extends RelativeLayout {
    private Context mContext;
    int mas;
    a mat;
    private int mau;
    TextView mav;
    private ImageView maw;
    private ProgressBar may;

    public interface a {
        boolean aFH();

        void jo(int i);
    }

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, R.a.bqf);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.maw.startAnimation(loadAnimation);
    }

    static /* synthetic */ int pE(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                x.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                return 2;
        }
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mau = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dgU, this, true);
        this.mav = (TextView) inflate.findViewById(R.h.cfd);
        this.maw = (ImageView) inflate.findViewById(R.h.cfc);
        this.may = (ProgressBar) inflate.findViewById(R.h.cfh);
        setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ExdeviceLikeView.this.mat == null || ExdeviceLikeView.this.mat.aFH() || ExdeviceLikeView.this.mau != 0) {
                    x.d("MicroMsg.ExdeviceLikeView", "hy: loading or has liked or consumed. abort event");
                    return;
                }
                x.d("MicroMsg.ExdeviceLikeView", "click listener is not null");
                ExdeviceLikeView.this.pD(ExdeviceLikeView.pE(ExdeviceLikeView.this.mau));
                if (ExdeviceLikeView.this.mau == 1) {
                    ExdeviceLikeView.c(ExdeviceLikeView.this);
                }
                if (ExdeviceLikeView.this.mat != null) {
                    ExdeviceLikeView.this.mat.jo(ExdeviceLikeView.this.mau);
                }
            }
        });
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void pD(int i) {
        this.mau = i;
        if (this.mau == 1) {
            this.may.setVisibility(8);
            this.mav.setVisibility(0);
            this.maw.setVisibility(0);
            this.maw.setImageResource(R.k.dyB);
        } else if (this.mau == 0) {
            this.may.setVisibility(8);
            this.mav.setVisibility(0);
            this.maw.setVisibility(0);
            this.maw.setImageResource(R.k.dyC);
        } else if (this.mau == 2) {
            this.mav.setVisibility(8);
            this.may.setVisibility(0);
            this.maw.setVisibility(8);
        } else {
            x.w("MicroMsg.ExdeviceLikeView", "hy: error state");
        }
    }
}
