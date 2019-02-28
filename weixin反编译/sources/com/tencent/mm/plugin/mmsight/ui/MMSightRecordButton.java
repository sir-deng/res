package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public class MMSightRecordButton extends FrameLayout {
    private static final float oGA = (((float) ad.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.oJS)) / ((float) ad.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.u.a.b.oJR)));
    private static final int wR = ViewConfiguration.getTapTimeout();
    private boolean frK = true;
    private ag hbP = new ag(Looper.getMainLooper());
    private boolean isAnimating = false;
    private float kHQ = -1.0f;
    private long oGB = -1;
    private View oGC;
    private View oGD;
    View oGE;
    MMSightCircularProgressBar oGF;
    private boolean oGG = false;
    private boolean oGH = false;
    private ViewPropertyAnimator oGI;
    private ViewPropertyAnimator oGJ;
    private ViewPropertyAnimator oGK;
    private ViewPropertyAnimator oGL;
    private boolean oGM = false;
    d oGN;
    b oGO;
    c oGP;
    a oGQ;
    private Drawable oGR;
    private Drawable oGS;
    private boolean oGT = false;
    private boolean oGU = false;
    private Runnable oGV = new Runnable() {
        public final void run() {
            x.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.oGG), Boolean.valueOf(MMSightRecordButton.this.oGH));
            if (!MMSightRecordButton.this.oGG) {
                MMSightRecordButton.this.oGH = true;
                if (MMSightRecordButton.this.oGO != null) {
                    MMSightRecordButton.this.oGO.bcc();
                }
            }
        }
    };
    private Runnable oGW = new Runnable() {
        public final void run() {
            x.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", Boolean.valueOf(MMSightRecordButton.this.oGM));
            if (MMSightRecordButton.this.oGM) {
                MMSightRecordButton.f(MMSightRecordButton.this);
            }
        }
    };

    public interface d {
        void bce();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorListenerAdapter oHa = null;

        AnonymousClass3(AnimatorListenerAdapter animatorListenerAdapter) {
        }

        public final void onAnimationStart(Animator animator) {
            MMSightRecordButton.this.isAnimating = true;
            if (this.oHa != null) {
                this.oHa.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            MMSightRecordButton.this.isAnimating = false;
            if (this.oHa != null) {
                this.oHa.onAnimationEnd(animator);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$1 */
    class AnonymousClass1 implements com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a {
        final /* synthetic */ com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a oGX;

        AnonymousClass1(com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a aVar) {
            this.oGX = aVar;
        }

        public final void bbY() {
            x.k("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
            MMSightRecordButton.this.bbZ();
            MMSightRecordButton.this.a(new AnimatorListenerAdapter() {
                public final void onAnimationEnd(Animator animator) {
                    x.k("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
                    if (AnonymousClass1.this.oGX != null) {
                        AnonymousClass1.this.oGX.bbY();
                    }
                }
            });
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$2 */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorListenerAdapter oHa = null;

        AnonymousClass2(AnimatorListenerAdapter animatorListenerAdapter) {
        }

        public final void onAnimationStart(Animator animator) {
            MMSightRecordButton.this.isAnimating = true;
            if (this.oHa != null) {
                this.oHa.onAnimationStart(animator);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            MMSightRecordButton.this.isAnimating = false;
            if (this.oHa != null) {
                this.oHa.onAnimationEnd(animator);
            }
        }
    }

    public interface a {
        void bca();
    }

    public interface b {
        void bcb();

        void bcc();

        void bcd();
    }

    public interface c {
        void tq(int i);

        void tr(int i);
    }

    static /* synthetic */ void f(MMSightRecordButton mMSightRecordButton) {
        mMSightRecordButton.isAnimating = true;
        if (mMSightRecordButton.oGI != null) {
            mMSightRecordButton.oGI.cancel();
            mMSightRecordButton.oGI = null;
        }
        mMSightRecordButton.oGI = mMSightRecordButton.oGC.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.oGI.setListener(new AnonymousClass2(null)).setDuration(150).start();
        if (mMSightRecordButton.oGJ != null) {
            mMSightRecordButton.oGJ.cancel();
            mMSightRecordButton.oGJ = null;
        }
        mMSightRecordButton.oGJ = mMSightRecordButton.oGD.animate().scaleX(oGA).scaleY(oGA);
        mMSightRecordButton.oGJ.setListener(new AnonymousClass3(null)).setDuration(150).start();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        x.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", Integer.valueOf(500), Integer.valueOf(wR));
        this.oGR = getContext().getResources().getDrawable(com.tencent.mm.plugin.u.a.c.oJV);
        this.oGS = getContext().getResources().getDrawable(com.tencent.mm.plugin.u.a.c.oJW);
        v.fw(getContext()).inflate(e.oKD, this, true);
        this.oGC = findViewById(com.tencent.mm.plugin.u.a.d.oKi);
        this.oGD = findViewById(com.tencent.mm.plugin.u.a.d.oKk);
        this.oGE = findViewById(com.tencent.mm.plugin.u.a.d.cEf);
        this.oGF = (MMSightCircularProgressBar) findViewById(com.tencent.mm.plugin.u.a.d.oJY);
        this.oGC.setBackgroundDrawable(this.oGR);
        this.oGD.setBackgroundDrawable(this.oGS);
        this.frK = true;
    }

    public final void gM(boolean z) {
        x.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", Boolean.valueOf(z));
        this.frK = z;
    }

    public final void bbZ() {
        MMSightCircularProgressBar mMSightCircularProgressBar = this.oGF;
        mMSightCircularProgressBar.oGw = null;
        mMSightCircularProgressBar.oGs = 0;
        mMSightCircularProgressBar.oGt = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.fBn = false;
        if (mMSightCircularProgressBar.oGv != null) {
            b bVar = mMSightCircularProgressBar.oGv;
            bVar.fBn = false;
            bVar.oHH = 0;
            mMSightCircularProgressBar.oGv = null;
        }
        this.oGF.setVisibility(8);
    }

    private void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        this.isAnimating = true;
        if (this.oGK != null) {
            this.oGK.cancel();
            this.oGK = null;
        }
        this.oGK = this.oGC.animate().scaleX(1.0f).scaleY(1.0f);
        this.oGK.setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                MMSightRecordButton.this.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                MMSightRecordButton.this.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
        if (this.oGL != null) {
            this.oGL.cancel();
            this.oGL = null;
        }
        this.oGL = this.oGD.animate().scaleX(1.0f).scaleY(1.0f);
        this.oGL.setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                MMSightRecordButton.this.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
            }

            public final void onAnimationEnd(Animator animator) {
                MMSightRecordButton.this.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
            }
        }).setDuration(150).start();
    }

    public void setVisibility(final int i) {
        x.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", Boolean.valueOf(this.isAnimating));
        if (this.isAnimating) {
            postDelayed(new Runnable() {
                public final void run() {
                    super.setVisibility(i);
                }
            }, 150);
        } else {
            super.setVisibility(i);
        }
    }

    public final void reset() {
        setClipChildren(false);
        this.frK = true;
        this.oGC.setScaleX(1.0f);
        this.oGC.setScaleY(1.0f);
        this.oGD.setScaleX(1.0f);
        this.oGD.setScaleY(1.0f);
        this.oGE.setVisibility(8);
        bbZ();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.frK) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.oGM = true;
                    this.oGB = System.currentTimeMillis();
                    this.oGG = false;
                    this.oGH = false;
                    this.kHQ = motionEvent.getRawY();
                    if (this.oGO != null) {
                        this.oGO.bcb();
                    }
                    this.hbP.postDelayed(this.oGV, 550);
                    this.hbP.postDelayed(this.oGW, 250);
                    this.oGU = true;
                    this.oGT = true;
                    break;
                case 1:
                case 3:
                    this.oGM = false;
                    this.hbP.removeCallbacks(this.oGW, Integer.valueOf(wR));
                    this.hbP.removeCallbacks(this.oGV);
                    if (!(this.oGI == null || this.oGJ == null)) {
                        this.oGI.cancel();
                        this.oGJ.cancel();
                    }
                    final long currentTimeMillis = System.currentTimeMillis() - this.oGB;
                    x.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", Boolean.valueOf(this.oGH), Boolean.valueOf(this.oGG), Long.valueOf(this.oGB), Long.valueOf(currentTimeMillis));
                    bbZ();
                    a(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            if (MMSightRecordButton.this.oGB > 0 && currentTimeMillis <= 500) {
                                x.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.oGG), Boolean.valueOf(MMSightRecordButton.this.oGH));
                                MMSightRecordButton.this.oGG = true;
                                if (!MMSightRecordButton.this.oGH && MMSightRecordButton.this.oGN != null) {
                                    MMSightRecordButton.this.oGN.bce();
                                }
                            } else if (MMSightRecordButton.this.oGH) {
                                x.i("MicroMsg.MMSightRecordButton", "on Long Press finish");
                                if (MMSightRecordButton.this.oGO != null) {
                                    MMSightRecordButton.this.oGO.bcd();
                                }
                            } else {
                                x.i("MicroMsg.MMSightRecordButton", "error action up");
                                if (MMSightRecordButton.this.oGQ != null) {
                                    MMSightRecordButton.this.oGQ.bca();
                                }
                            }
                        }
                    });
                    break;
                case 2:
                    x.d("MicroMsg.MMSightRecordButton", "move, x: %s, y: %s, top: %s", Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getRawY()), Integer.valueOf(getTop()));
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.oGH) {
                        if (this.kHQ > 0.0f) {
                            float abs = Math.abs(rawY - this.kHQ);
                            int min;
                            c cVar;
                            if (rawY >= this.kHQ || abs < 10.0f) {
                                if (rawY > this.kHQ && abs >= 10.0f) {
                                    x.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oGU));
                                    min = Math.min(min, 3);
                                    if (this.oGP != null) {
                                        cVar = this.oGP;
                                        if (this.oGU) {
                                            min = 1;
                                        }
                                        cVar.tr(min);
                                    }
                                    this.oGU = false;
                                    this.kHQ = rawY;
                                    break;
                                }
                            }
                            x.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oGT));
                            min = Math.min(min, 3);
                            if (this.oGP != null) {
                                cVar = this.oGP;
                                if (this.oGT) {
                                    min = 1;
                                }
                                cVar.tq(min);
                            }
                            this.kHQ = rawY;
                            this.oGT = false;
                            break;
                        }
                        this.kHQ = motionEvent.getRawY();
                        break;
                    }
                    break;
            }
        }
        x.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
        return true;
    }
}
