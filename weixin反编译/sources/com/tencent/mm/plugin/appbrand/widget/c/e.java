package com.tencent.mm.plugin.appbrand.widget.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.q.a;
import java.util.LinkedList;

public final class e extends FrameLayout implements i {
    public final g kcg = new g(this);
    public final LinkedList<h> kch = new LinkedList();
    private final Runnable kci = new Runnable() {
        public final void run() {
            e.this.removeAllViews();
            e.this.setVisibility(4);
        }
    };
    private h kcj;
    public h kck;
    public final OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            if (view == e.this) {
                e.a(e.this);
            }
        }
    };

    static /* synthetic */ void a(e eVar) {
        h hVar = (h) eVar.kch.peekLast();
        if (hVar == null) {
            eVar.setVisibility(8);
        } else if (hVar.ana()) {
            hVar.onCancel();
            eVar.b(hVar);
        }
    }

    public e(Context context) {
        super(context);
        setVisibility(4);
        setBackgroundColor(0);
        setOnClickListener(this.mOnClickListener);
    }

    public final void b(final h hVar) {
        if (hVar.getContentView().getParent() == this && this.kcj != hVar) {
            this.kcj = hVar;
            final View contentView = hVar.getContentView();
            contentView.animate().cancel();
            contentView.clearAnimation();
            TimeInterpolator loadInterpolator = AnimationUtils.loadInterpolator(contentView.getContext(), a.iuP);
            TimeInterpolator loadInterpolator2 = AnimationUtils.loadInterpolator(contentView.getContext(), a.iuO);
            Animator animatorSet = new AnimatorSet();
            r4 = new Animator[3];
            Animator duration = ObjectAnimator.ofFloat(contentView, "scaleX", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[0] = duration;
            duration = ObjectAnimator.ofFloat(contentView, "scaleY", new float[]{1.0f, 0.9f}).setDuration(220);
            duration.setInterpolator(loadInterpolator);
            r4[1] = duration;
            Animator duration2 = ObjectAnimator.ofFloat(contentView, "alpha", new float[]{1.0f, 0.0f}).setDuration(150);
            duration2.setInterpolator(loadInterpolator2);
            r4[2] = duration2;
            animatorSet.playTogether(r4);
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public final void onAnimationCancel(Animator animator) {
                    onAnimationEnd(animator);
                }

                public final void onAnimationEnd(Animator animator) {
                    contentView.setVisibility(8);
                    e.this.removeView(contentView);
                    e.this.kch.remove(hVar);
                    e.this.kcj = null;
                }
            });
            animatorSet.start();
            if (this.kch.size() <= 1) {
                this.kcg.b(0, this.kci);
            }
        }
    }

    public static void bQ(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getChildCount() == 0) {
            return false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
