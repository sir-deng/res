package com.tencent.mm.ui.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.mm.v.a.g;
import java.util.LinkedList;
import java.util.Queue;

class SnackContainer extends FrameLayout {
    private final Runnable mde = new Runnable() {
        public final void run() {
            if (SnackContainer.this.getVisibility() == 0) {
                SnackContainer.this.startAnimation(SnackContainer.this.zoS);
            }
        }
    };
    private AnimationSet yIP;
    Queue<a> zoR = new LinkedList();
    private AnimationSet zoS;
    private float zoT;

    private static class a {
        final TextView obt;
        final View zoW;
        final TextView zoX;
        final Snack zoY;
        final c zoZ;

        /* synthetic */ a(Snack snack, View view, c cVar, byte b) {
            this(snack, view, cVar);
        }

        private a(Snack snack, View view, c cVar) {
            this.zoW = view;
            this.obt = (TextView) view.findViewById(g.gXX);
            this.zoX = (TextView) view.findViewById(g.gXZ);
            this.zoY = snack;
            this.zoZ = cVar;
        }
    }

    public SnackContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    SnackContainer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        viewGroup.addView(this, new LayoutParams(-1, -1));
        setVisibility(8);
        setId(g.gXY);
        init();
    }

    private void init() {
        this.yIP = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.yIP.setInterpolator(new DecelerateInterpolator(1.5f));
        this.yIP.addAnimation(translateAnimation);
        this.yIP.addAnimation(alphaAnimation);
        this.zoS = new AnimationSet(false);
        translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 0.0f, 1, 1.0f);
        alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.zoS.addAnimation(translateAnimation);
        this.zoS.addAnimation(alphaAnimation);
        this.zoS.setDuration(300);
        this.zoS.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                if (!SnackContainer.this.isEmpty() && SnackContainer.this.zoR.peek() != null && ((a) SnackContainer.this.zoR.peek()).zoZ != null) {
                    a.nu(false);
                    ((a) SnackContainer.this.zoR.peek()).zoZ.aPu();
                }
            }

            public final void onAnimationEnd(Animation animation) {
                SnackContainer.this.removeAllViews();
                if (!SnackContainer.this.zoR.isEmpty()) {
                    SnackContainer.a((a) SnackContainer.this.zoR.poll());
                }
                if (SnackContainer.this.isEmpty()) {
                    SnackContainer.this.setVisibility(8);
                } else {
                    SnackContainer.this.a((a) SnackContainer.this.zoR.peek(), false);
                }
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yIP.cancel();
        this.zoS.cancel();
        removeCallbacks(this.mde);
        this.zoR.clear();
    }

    public final boolean isEmpty() {
        return this.zoR.isEmpty();
    }

    public final boolean isShowing() {
        return !this.zoR.isEmpty();
    }

    public final void hide() {
        removeCallbacks(this.mde);
        this.mde.run();
    }

    final void a(final a aVar, boolean z) {
        setVisibility(0);
        if (aVar.zoZ != null) {
            a.nu(true);
            aVar.zoZ.onShow();
        }
        addView(aVar.zoW);
        aVar.zoX.setText(aVar.zoY.mMessage);
        if (aVar.zoY.zoD != null) {
            aVar.obt.setVisibility(0);
            aVar.obt.setText(aVar.zoY.zoD);
        } else {
            aVar.obt.setVisibility(8);
        }
        this.yIP.setDuration(500);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.v.a.a.bpZ);
        loadAnimation.setDuration(500);
        startAnimation(this.yIP);
        loadAnimation.setStartOffset(200);
        aVar.obt.startAnimation(loadAnimation);
        aVar.zoX.startAnimation(loadAnimation);
        if (aVar.zoY.zoG > (short) 0) {
            postDelayed(this.mde, (long) aVar.zoY.zoG);
        }
        aVar.zoW.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float y = motionEvent.getY();
                switch (motionEvent.getAction()) {
                    case 4:
                        SnackContainer.this.removeCallbacks(SnackContainer.this.mde);
                        SnackContainer.a(aVar);
                        SnackContainer.this.startAnimation(SnackContainer.this.zoS);
                        if (!SnackContainer.this.zoR.isEmpty()) {
                            SnackContainer.this.zoR.clear();
                            break;
                        }
                        break;
                }
                SnackContainer.this.zoT = y;
                return true;
            }
        });
    }

    private static void a(a aVar) {
        if (aVar.zoZ != null) {
            a.nu(false);
            aVar.zoZ.onHide();
        }
    }

    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if ((i == 0 && a.aHO()) || 8 == i) {
            removeAllViews();
            if (!this.zoR.isEmpty()) {
                a((a) this.zoR.poll());
            }
            if (isEmpty()) {
                setVisibility(8);
            } else {
                a((a) this.zoR.peek(), false);
            }
            a.nu(false);
        }
    }
}
