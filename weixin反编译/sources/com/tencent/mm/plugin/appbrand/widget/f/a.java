package com.tencent.mm.plugin.appbrand.widget.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.ag;

public final class a extends FrameLayout implements OnClickListener, c {
    private TextView kbK;
    private final Runnable kkG = new Runnable() {
        public final void run() {
            a aVar = a.this;
            if (aVar.getAlpha() != 0.0f && aVar.kkI == null) {
                aVar.animate().cancel();
                ViewPropertyAnimator animate = aVar.animate();
                aVar.kkI = animate;
                animate.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        a.this.setVisibility(8);
                        a.this.kkI = null;
                    }

                    public final void onAnimationCancel(Animator animator) {
                        a.this.kkI = null;
                    }
                }).start();
            }
        }
    };
    private ViewPropertyAnimator kkH;
    ViewPropertyAnimator kkI;
    private final ag mHandler = new ag(Looper.getMainLooper());

    public a(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(h.izI, this, true);
        this.kbK = (TextView) findViewById(g.title);
        setOnClickListener(this);
    }

    public final void vN(String str) {
        this.kbK.setText(str);
        this.mHandler.removeCallbacks(this.kkG);
        this.mHandler.postDelayed(this.kkG, kkM);
        if (getAlpha() != 1.0f && this.kkH == null) {
            setVisibility(0);
            animate().cancel();
            ViewPropertyAnimator animate = animate();
            this.kkH = animate;
            animate.alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    a.this.kkH = null;
                }

                public final void onAnimationCancel(Animator animator) {
                    a.this.kkH = null;
                }
            }).start();
            setVisibility(0);
        }
    }

    public final View getView() {
        return this;
    }

    public final void a(FrameLayout frameLayout) {
        frameLayout.addView(this, new LayoutParams(-2, -2, 17));
    }

    public final void onClick(View view) {
    }
}
