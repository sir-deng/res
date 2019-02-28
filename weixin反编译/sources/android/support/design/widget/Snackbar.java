package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.e;
import android.support.design.a.f;
import android.support.design.a.i;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class Snackbar {
    private static final Handler jr = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            Snackbar snackbar;
            switch (message.what) {
                case 0:
                    snackbar = (Snackbar) message.obj;
                    if (snackbar.jt.getParent() == null) {
                        LayoutParams layoutParams = snackbar.jt.getLayoutParams();
                        if (layoutParams instanceof d) {
                            Behavior aVar = new a();
                            aVar.jT = s.c(0.0f, 0.1f, 1.0f);
                            aVar.jU = s.c(0.0f, 0.6f, 1.0f);
                            aVar.jR = 0;
                            aVar.jO = new android.support.design.widget.s.a() {
                                public final void onDismiss(View view) {
                                    view.setVisibility(8);
                                    Snackbar.a(Snackbar.this);
                                }

                                public final void G(int i) {
                                    switch (i) {
                                        case 0:
                                            q.aq().b(Snackbar.this.jv);
                                            return;
                                        case 1:
                                        case 2:
                                            q.aq().a(Snackbar.this.jv);
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                            ((d) layoutParams).a(aVar);
                        }
                        snackbar.js.addView(snackbar.jt);
                    }
                    snackbar.jt.jC = new a() {
                        public final void ao() {
                            if (q.aq().c(Snackbar.this.jv)) {
                                Snackbar.jr.post(new Runnable() {
                                    public final void run() {
                                        Snackbar.this.al();
                                    }
                                });
                            }
                        }
                    };
                    if (!z.ai(snackbar.jt)) {
                        snackbar.jt.jB = new b() {
                            public final void ap() {
                                Snackbar.this.jt.jB = null;
                                if (Snackbar.this.am()) {
                                    Snackbar.this.aj();
                                } else {
                                    Snackbar.this.ak();
                                }
                            }
                        };
                    } else if (snackbar.am()) {
                        snackbar.aj();
                    } else {
                        snackbar.ak();
                    }
                    return true;
                case 1:
                    snackbar = (Snackbar) message.obj;
                    int i = message.arg1;
                    if (!snackbar.am() || snackbar.jt.getVisibility() != 0) {
                        snackbar.al();
                    } else if (VERSION.SDK_INT >= 14) {
                        z.U(snackbar.jt).s((float) snackbar.jt.getHeight()).b(a.eB).d(250).a(new AnonymousClass8(i)).start();
                    } else {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snackbar.jt.getContext(), android.support.design.a.a.aR);
                        loadAnimation.setInterpolator(a.eB);
                        loadAnimation.setDuration(250);
                        loadAnimation.setAnimationListener(new AnonymousClass2(i));
                        snackbar.jt.startAnimation(loadAnimation);
                    }
                    return true;
                default:
                    return false;
            }
        }
    });
    final ViewGroup js;
    final SnackbarLayout jt;
    private final AccessibilityManager ju;
    final a jv;

    /* renamed from: android.support.design.widget.Snackbar$2 */
    class AnonymousClass2 implements AnimationListener {
        final /* synthetic */ int val$event;

        AnonymousClass2(int i) {
            this.val$event = i;
        }

        public final void onAnimationEnd(Animation animation) {
            Snackbar.this.al();
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.Snackbar$8 */
    class AnonymousClass8 extends an {
        final /* synthetic */ int val$event;

        AnonymousClass8(int i) {
            this.val$event = i;
        }

        public final void p(View view) {
            SnackbarLayout c = Snackbar.this.jt;
            z.d(c.jy, 1.0f);
            z.U(c.jy).q(0.0f).d(180).e(0).start();
            if (c.jz.getVisibility() == 0) {
                z.d(c.jz, 1.0f);
                z.U(c.jz).q(0.0f).d(180).e(0).start();
            }
        }

        public final void q(View view) {
            Snackbar.this.al();
        }
    }

    public static class SnackbarLayout extends LinearLayout {
        private int iX;
        private int jA;
        b jB;
        a jC;
        TextView jy;
        Button jz;

        interface a {
            void ao();
        }

        interface b {
            void ap();
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.dg);
            this.iX = obtainStyledAttributes.getDimensionPixelSize(i.dh, -1);
            this.jA = obtainStyledAttributes.getDimensionPixelSize(i.dj, -1);
            if (obtainStyledAttributes.hasValue(i.di)) {
                z.g((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(i.di, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(f.bt, this);
            z.N(this);
            z.i(this, 1);
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.jy = (TextView) findViewById(e.bo);
            this.jz = (Button) findViewById(e.bn);
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.iX > 0 && getMeasuredWidth() > this.iX) {
                i = MeasureSpec.makeMeasureSpec(this.iX, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(android.support.design.a.d.bh);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(android.support.design.a.d.bg);
            int i3 = this.jy.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.jA <= 0 || this.jz.getMeasuredWidth() <= this.jA) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (f(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (f(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.jB != null) {
                this.jB.ap();
            }
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.jC != null) {
                this.jC.ao();
            }
        }

        private boolean f(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.jy.getPaddingTop() == i2 && this.jy.getPaddingBottom() == i3) {
                return z;
            }
            View view = this.jy;
            if (z.ad(view)) {
                z.c(view, z.O(view), i2, z.P(view), i3);
            } else {
                view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
            }
            return true;
        }
    }

    final class a extends s<SnackbarLayout> {
        a() {
        }

        public final boolean r(View view) {
            return view instanceof SnackbarLayout;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.b(snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        q.aq().a(Snackbar.this.jv);
                        break;
                    case 1:
                    case 3:
                        q.aq().b(Snackbar.this.jv);
                        break;
                }
            }
            return super.a(coordinatorLayout, snackbarLayout, motionEvent);
        }
    }

    static /* synthetic */ void a(Snackbar snackbar) {
        q aq = q.aq();
        a aVar = snackbar.jv;
        synchronized (aq.mLock) {
            if (aq.d(aVar)) {
                aq.a(aq.jE);
            } else if (aq.e(aVar)) {
                aq.a(aq.jF);
            }
        }
    }

    final void aj() {
        if (VERSION.SDK_INT >= 14) {
            z.c(this.jt, (float) this.jt.getHeight());
            z.U(this.jt).s(0.0f).b(a.eB).d(250).a(new an() {
                public final void p(View view) {
                    SnackbarLayout c = Snackbar.this.jt;
                    z.d(c.jy, 0.0f);
                    z.U(c.jy).q(1.0f).d(180).e(70).start();
                    if (c.jz.getVisibility() == 0) {
                        z.d(c.jz, 0.0f);
                        z.U(c.jz).q(1.0f).d(180).e(70).start();
                    }
                }

                public final void q(View view) {
                    Snackbar.this.ak();
                }
            }).start();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.jt.getContext(), android.support.design.a.a.aQ);
        loadAnimation.setInterpolator(a.eB);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
                Snackbar.this.ak();
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.jt.startAnimation(loadAnimation);
    }

    final void ak() {
        q aq = q.aq();
        a aVar = this.jv;
        synchronized (aq.mLock) {
            if (aq.d(aVar)) {
                aq.b(aq.jE);
            }
        }
    }

    final void al() {
        q aq = q.aq();
        a aVar = this.jv;
        synchronized (aq.mLock) {
            if (aq.d(aVar)) {
                aq.jE = null;
                if (!(aq.jF == null || aq.jF == null)) {
                    aq.jE = aq.jF;
                    aq.jF = null;
                    if (((a) aq.jE.jH.get()) == null) {
                        aq.jE = null;
                    }
                }
            }
        }
        ViewParent parent = this.jt.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.jt);
        }
    }

    final boolean am() {
        return !this.ju.isEnabled();
    }
}
