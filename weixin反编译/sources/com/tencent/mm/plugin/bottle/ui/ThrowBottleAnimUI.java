package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@SuppressLint({"HandlerLeak"})
public class ThrowBottleAnimUI extends FrameLayout {
    int Rn;
    int Ro;
    BottleBeachUI kIt;
    private int kJA;
    private int kJB;
    private int kJC;
    int kJD;
    a kJE;
    boolean kJF;
    private ag kJG = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (ThrowBottleAnimUI.this.kJv == null && ThrowBottleAnimUI.this.kIt != null) {
                ThrowBottleAnimUI.this.kJv = (SprayLayout) ThrowBottleAnimUI.this.kIt.findViewById(R.h.bOA);
            }
            if (ThrowBottleAnimUI.this.kJv != null) {
                ThrowBottleAnimUI.this.kJv.stop();
            }
            if (ThrowBottleAnimUI.this.kJE != null) {
                ThrowBottleAnimUI.this.kJE.asD();
            }
        }
    };
    private SprayLayout kJv;
    private BottleImageView kJw;
    private TextView kJx;
    private AnimationSet kJy;
    private int kJz;

    public interface a {
        void asD();
    }

    static /* synthetic */ void f(ThrowBottleAnimUI throwBottleAnimUI) {
        float f;
        int i;
        throwBottleAnimUI.kJx.setVisibility(0);
        if (throwBottleAnimUI.kJF) {
            throwBottleAnimUI.kJx.setBackgroundDrawable(com.tencent.mm.bu.a.b(throwBottleAnimUI.kIt, R.g.bEY));
            throwBottleAnimUI.kJx.setWidth(throwBottleAnimUI.kJD);
            f = 1.0f;
            i = 120;
        } else {
            throwBottleAnimUI.kJx.setBackgroundDrawable(com.tencent.mm.bu.a.b(throwBottleAnimUI.kIt, R.g.bzW));
            f = 0.5f;
            i = 25;
        }
        throwBottleAnimUI.kJy = new AnimationSet(true);
        throwBottleAnimUI.kJy.setInterpolator(throwBottleAnimUI.kIt, 17432582);
        Animation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.0f, 1, 0.0f);
        scaleAnimation.setDuration(700);
        Animation rotateAnimation = new RotateAnimation(0.0f, (float) i, 1, f, 1, 1.0f);
        rotateAnimation.setDuration(700);
        int intrinsicWidth = throwBottleAnimUI.kJw.getBackground().getIntrinsicWidth() / 2;
        int intrinsicHeight = throwBottleAnimUI.kJw.getBackground().getIntrinsicHeight() / 2;
        int b = b.b(throwBottleAnimUI.kIt, 40.0f);
        x.v("MicroMsg.ThrowBottleAnimView", "tran from (" + throwBottleAnimUI.Rn + "," + throwBottleAnimUI.Ro + ") to (" + ((throwBottleAnimUI.asE() - b) - intrinsicWidth) + " , " + ((throwBottleAnimUI.asF() - b) - intrinsicHeight));
        Animation translateAnimation = new TranslateAnimation((float) throwBottleAnimUI.Rn, (float) ((throwBottleAnimUI.asE() - b) - intrinsicWidth), (float) throwBottleAnimUI.Ro, (float) ((throwBottleAnimUI.asF() - b) - intrinsicHeight));
        translateAnimation.setDuration(700);
        throwBottleAnimUI.kJy.addAnimation(rotateAnimation);
        throwBottleAnimUI.kJy.addAnimation(scaleAnimation);
        throwBottleAnimUI.kJy.addAnimation(translateAnimation);
        throwBottleAnimUI.kJy.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ThrowBottleAnimUI.this.kJx.setVisibility(8);
                ThrowBottleAnimUI.this.asH();
            }
        });
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kIt = (BottleBeachUI) context;
        initView();
    }

    public ThrowBottleAnimUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kIt = (BottleBeachUI) context;
        initView();
    }

    public final void release() {
        this.kIt = null;
        this.kJy = null;
        this.kJv = null;
        if (this.kJw != null) {
            BottleImageView bottleImageView = this.kJw;
            bottleImageView.context = null;
            bottleImageView.kHL = null;
        }
        this.kJw = null;
        this.kJE = null;
    }

    public boolean isInEditMode() {
        return false;
    }

    private void initView() {
        inflate(this.kIt, R.i.dbE, this);
        this.kJw = (BottleImageView) findViewById(R.h.bOH);
        this.kJx = (TextView) findViewById(R.h.bOK);
        DisplayMetrics displayMetrics = this.kIt.getResources().getDisplayMetrics();
        this.kJB = displayMetrics.widthPixels;
        this.kJC = displayMetrics.heightPixels;
    }

    private int asE() {
        int abs = Math.abs(getWidth());
        if (abs <= 0) {
            return this.kJB;
        }
        return abs;
    }

    private int asF() {
        int abs = Math.abs(getHeight());
        if (abs <= 0) {
            return this.kJC;
        }
        return abs;
    }

    final void asG() {
        this.kJw.setImageDrawable(null);
        int intrinsicWidth = this.kJw.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.kJw.getBackground().getIntrinsicHeight();
        this.kJw.setVisibility(0);
        int b = b.b(this.kIt, 40.0f);
        this.kJw.setLayoutParams(new LayoutParams(-2, -2, asE() - (intrinsicWidth + b), asF() - (intrinsicHeight + b)));
    }

    final void asH() {
        int intrinsicWidth = this.kJw.getBackground().getIntrinsicWidth();
        int intrinsicHeight = this.kJw.getBackground().getIntrinsicHeight();
        this.kJw.setVisibility(0);
        int b = b.b(this.kIt, 40.0f);
        setBackgroundDrawable(com.tencent.mm.bu.a.b(this.kIt, bi.chd() ? R.g.bzQ : R.g.bzR));
        if (this.kJF) {
            this.kJw.setImageDrawable(com.tencent.mm.bu.a.b(this.kIt, R.g.bzY));
        } else {
            this.kJw.setImageDrawable(com.tencent.mm.bu.a.b(this.kIt, R.g.bzX));
        }
        this.kJw.setLayoutParams(new LayoutParams(-2, -2, 0, 0));
        BottleImageView bottleImageView = this.kJw;
        int asE = asE() - (intrinsicWidth + b);
        intrinsicWidth = this.kJz - (intrinsicWidth / 2);
        b = asF() - (b + intrinsicHeight);
        intrinsicHeight = this.kJA - (intrinsicHeight / 2);
        AnimationListener anonymousClass3 = new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ThrowBottleAnimUI.this.kJw.setVisibility(8);
                if (ThrowBottleAnimUI.this.kJv == null) {
                    ThrowBottleAnimUI.this.kJv = (SprayLayout) ThrowBottleAnimUI.this.kIt.findViewById(R.h.bOA);
                }
                ThrowBottleAnimUI.this.kJv.G(1, ThrowBottleAnimUI.this.kJz, ThrowBottleAnimUI.this.kJA);
                ThrowBottleAnimUI.this.kJG.sendEmptyMessageDelayed(0, 2000);
            }
        };
        bottleImageView.Rn = asE;
        bottleImageView.Rp = intrinsicWidth;
        bottleImageView.Ro = b;
        bottleImageView.Rq = intrinsicHeight;
        bottleImageView.kHL.setAnimationListener(anonymousClass3);
        bottleImageView.kHL.setDuration(2000);
        bottleImageView.kHL.setRepeatCount(0);
        bottleImageView.kHL.setStartOffset(500);
        bottleImageView.kHL.setInterpolator(bottleImageView.context, 17432582);
        bottleImageView.startAnimation(bottleImageView.kHL);
    }

    final void asI() {
        this.kJz = asE() / 2;
        this.kJA = (asF() * 460) / 800;
        x.v("MicroMsg.ThrowBottleAnimView", "to (" + this.kJz + "," + this.kJA + ")  bottle (" + this.kJw.getDrawable().getIntrinsicWidth() + "," + this.kJw.getDrawable().getIntrinsicHeight() + ")");
    }
}
