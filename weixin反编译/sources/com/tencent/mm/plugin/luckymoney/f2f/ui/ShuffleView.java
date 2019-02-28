package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView extends FrameLayout {
    public static DisplayMetrics ieH;
    GestureDetector mbL = new GestureDetector(new OnGestureListener() {
        public final boolean onDown(MotionEvent motionEvent) {
            x.d("ShuffleView", "gesture down");
            switch (ShuffleView.this.ogs.ogV) {
                case 4:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int i = 0;
                    while (i < ShuffleView.this.ogF) {
                        Rect a = ShuffleView.this.sq(i);
                        if (a == null || !a.contains(x, y)) {
                            i++;
                        } else {
                            View view = (View) ShuffleView.this.ogr.get(i);
                            if (ShuffleView.this.ogB != view && ShuffleView.this.ogB != null) {
                                ShuffleView.this.aXF();
                            } else if (ShuffleView.this.ogB == view) {
                                x.i("ShuffleView", "down on the select card");
                                return true;
                            }
                            ShuffleView.b(ShuffleView.this, i);
                            return true;
                        }
                    }
                    return false;
                default:
                    return false;
            }
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            switch (ShuffleView.this.ogs.ogV) {
                case 4:
                    if (ShuffleView.this.ogB != null) {
                        x.d("ShuffleView", "click the select card");
                        if (ShuffleView.this.ogy != null) {
                            ShuffleView.this.ogy.cO(ShuffleView.this.ogC, ShuffleView.this.ogF);
                        }
                        ShuffleView.this.aXF();
                    }
                    if (ShuffleView.this.ogD != null) {
                        if (ShuffleView.this.ogy != null) {
                            ShuffleView.this.ogy.sl(ShuffleView.this.ogF);
                        }
                        ShuffleView.this.sp(ShuffleView.this.ogE);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (motionEvent2.getActionMasked() == 2) {
                int x = (int) motionEvent2.getX();
                int y = (int) motionEvent2.getY();
                switch (ShuffleView.this.ogs.ogV) {
                    case 4:
                        View view;
                        if (Math.abs(f2) < ((float) ShuffleView.this.ogO)) {
                            for (int i = 0; i < ShuffleView.this.ogF; i++) {
                                Rect a = ShuffleView.this.sq(i);
                                if (a != null && a.contains(x, y)) {
                                    view = (View) ShuffleView.this.ogr.get(i);
                                    if (ShuffleView.this.ogB != view && ShuffleView.this.ogB != null) {
                                        ShuffleView.this.aXF();
                                    } else if (ShuffleView.this.ogB == view) {
                                        x.i("ShuffleView", "scroll on the select card");
                                    }
                                    if (ShuffleView.this.ogD != view) {
                                        ShuffleView.this.aXG();
                                        ShuffleView.b(ShuffleView.this, i);
                                    }
                                }
                            }
                        }
                        if (Math.abs(f) < ((float) ShuffleView.this.ogO)) {
                            x.d("ShuffleView", "scroll distanceY:" + f2);
                            if (ShuffleView.this.ogD != null) {
                                view = ShuffleView.this.ogD;
                            } else if (ShuffleView.this.ogB != null) {
                                view = ShuffleView.this.ogB;
                            } else {
                                view = null;
                            }
                            if (view != null) {
                                x.i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                                if (((int) view.getTranslationY()) > (-view.getHeight()) / 7) {
                                    if (view.getTranslationY() != 0.0f) {
                                        if (f2 >= 0.0f) {
                                            if (((int) (view.getTranslationY() - f2)) > (-view.getHeight()) / 7) {
                                                view.setTranslationY(view.getTranslationY() - f2);
                                                break;
                                            }
                                            view.setTranslationY((float) ((-view.getHeight()) / 7));
                                            break;
                                        } else if (view.getTranslationY() - f2 < 0.0f) {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                            break;
                                        } else {
                                            view.setTranslationY(0.0f);
                                            break;
                                        }
                                    } else if (f2 > 0.0f && Math.abs(f2) > ((float) ShuffleView.this.ogO)) {
                                        if (((int) f2) < view.getHeight() / 7) {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                            break;
                                        }
                                        view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        break;
                                    }
                                } else if (f2 < 0.0f && Math.abs(f2) > ((float) ShuffleView.this.ogO)) {
                                    if (((int) f2) <= (-view.getHeight()) / 7) {
                                        view.setTranslationY(0.0f);
                                    } else {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                    }
                                    if (view == ShuffleView.this.ogB) {
                                        ShuffleView.this.ogD = ShuffleView.this.ogB;
                                        ShuffleView.this.ogE = ShuffleView.this.ogC;
                                        if (ShuffleView.this.ogw.isStarted()) {
                                            x.i("ShuffleView", "scroll when select view is animation");
                                            ShuffleView.this.ogw.cancel();
                                        }
                                        ShuffleView.this.ogB = null;
                                        ShuffleView.this.ogC = 0;
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
            }
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            x.i("ShuffleView", "fling up " + f2);
            if (f2 >= ((float) (-ShuffleView.this.ogP))) {
                return false;
            }
            switch (ShuffleView.this.ogs.ogV) {
                case 4:
                    if (ShuffleView.this.ogB != null) {
                        ShuffleView.this.aXF();
                    }
                    if (ShuffleView.this.ogD != null) {
                        if (ShuffleView.this.ogy != null) {
                            ShuffleView.this.ogy.sl(ShuffleView.this.ogF);
                        }
                        ShuffleView.this.sp(ShuffleView.this.ogE);
                        break;
                    }
                    break;
            }
            return true;
        }
    });
    private View ogA;
    View ogB;
    int ogC;
    View ogD;
    int ogE;
    int ogF;
    private float ogG;
    private float ogH;
    private final float ogI = 0.23f;
    private final float ogJ = 0.28f;
    private final float ogK = 0.33f;
    private ArrayList<Float> ogL = new ArrayList();
    private ArrayList<Float> ogM = new ArrayList();
    private boolean ogN;
    private int ogO = getResources().getDimensionPixelSize(d.uiz);
    private int ogP = 2500;
    List<View> ogr = new ArrayList();
    c ogs = new c();
    ValueAnimator ogt;
    private ValueAnimator ogu;
    ValueAnimator ogv;
    ValueAnimator ogw;
    a ogx;
    b ogy;
    View ogz;

    interface a {
        void a(ValueAnimator valueAnimator, View view);
    }

    static class c {
        public int ogU = 1;
        public int ogV = 1;
        public int ogW = 2;
        public float ogX = 0.01f;
        public float ogY = 0.01f;
        public int ogZ = 200;
        public int oha = 80;

        c() {
        }
    }

    interface b {
        void cN(int i, int i2);

        void cO(int i, int i2);

        void sl(int i);
    }

    static /* synthetic */ void b(ShuffleView shuffleView, int i) {
        if (i >= 0 && i < shuffleView.ogF) {
            x.i("ShuffleView", "touch card " + i);
            if (shuffleView.ogw.isStarted()) {
                shuffleView.ogw.cancel();
            }
            shuffleView.ogw.removeAllUpdateListeners();
            shuffleView.ogw.removeAllListeners();
            shuffleView.ogD = (View) shuffleView.ogr.get(i);
            shuffleView.ogE = i;
            switch (shuffleView.ogs.ogV) {
                case 4:
                    if (i > 0) {
                        final int i2 = i - 1;
                        final int i3 = (shuffleView.ogF - 1) - i;
                        shuffleView.ogw.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.ogL.clear();
                                    ShuffleView.this.ogM.clear();
                                    while (i < ShuffleView.this.ogF) {
                                        ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                                        ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                int i2;
                                if (i2 <= 0) {
                                    while (true) {
                                        i2 = i;
                                        if (i2 >= ShuffleView.this.ogE) {
                                            break;
                                        }
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i2) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                        i = i2 + 1;
                                    }
                                } else {
                                    while (true) {
                                        i2 = i;
                                        if (i2 >= ShuffleView.this.ogE - 1) {
                                            break;
                                        }
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(i2) - (((float) (i2 + 1)) * ShuffleView.j(ShuffleView.this))) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                        i = i2 + 1;
                                    }
                                    ((View) ShuffleView.this.ogr.get(ShuffleView.this.ogE - 1)).setTranslationX((((Float) ShuffleView.this.ogL.get(ShuffleView.this.ogE - 1)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(ShuffleView.this.ogE - 1) - ((ShuffleView.j(ShuffleView.this) * ((float) i2)) / 2.0f)) * floatValue));
                                }
                                int i3;
                                if (i3 > 0) {
                                    ShuffleView.this.ogD.setTranslationX((((Float) ShuffleView.this.ogL.get(ShuffleView.this.ogE)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(ShuffleView.this.ogE) + ((ShuffleView.j(ShuffleView.this) * ((float) i3)) / 2.0f)) * floatValue));
                                    ShuffleView.this.ogD.setTranslationY((((Float) ShuffleView.this.ogM.get(ShuffleView.this.ogE)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(ShuffleView.this.ogE) * floatValue));
                                    i3 = ShuffleView.this.ogE + 1;
                                    while (true) {
                                        i2 = i3;
                                        if (i2 < ShuffleView.this.ogF) {
                                            ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(i2) + (((float) (ShuffleView.this.ogF - i2)) * ShuffleView.j(ShuffleView.this))) * floatValue));
                                            ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                            i3 = i2 + 1;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                i3 = ShuffleView.this.ogE;
                                while (true) {
                                    i2 = i3;
                                    if (i2 < ShuffleView.this.ogF) {
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i2) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                        i3 = i2 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        });
                    } else {
                        shuffleView.ogw.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.ogL.clear();
                                    ShuffleView.this.ogM.clear();
                                    for (int i = 0; i < ShuffleView.this.ogF; i++) {
                                        ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                                        ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                                    }
                                    return;
                                }
                                ((View) ShuffleView.this.ogr.get(0)).setTranslationX((((Float) ShuffleView.this.ogL.get(0)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(0) * floatValue));
                                ((View) ShuffleView.this.ogr.get(0)).setTranslationY((((Float) ShuffleView.this.ogM.get(0)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(0) * floatValue));
                                int i2 = 1;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 < ShuffleView.this.ogF) {
                                        ((View) ShuffleView.this.ogr.get(i3)).setTranslationX((((Float) ShuffleView.this.ogL.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i3) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i3)).setTranslationY((((Float) ShuffleView.this.ogM.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i3) * floatValue));
                                        i2 = i3 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        });
                    }
                    if (shuffleView.ogy != null) {
                        shuffleView.ogy.cN(shuffleView.ogE, shuffleView.ogF);
                        break;
                    }
                    break;
            }
            shuffleView.ogw.start();
        }
    }

    static /* synthetic */ float g(ShuffleView shuffleView) {
        if (shuffleView.ogB != null) {
            float width = (0.33f * ((float) shuffleView.ogB.getWidth())) - shuffleView.ogG;
            int i = shuffleView.ogC - 1;
            int i2 = (shuffleView.ogF - 1) - shuffleView.ogC;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    static /* synthetic */ float j(ShuffleView shuffleView) {
        if (shuffleView.ogD != null) {
            float width = (0.28f * ((float) shuffleView.ogD.getWidth())) - shuffleView.ogG;
            int i = shuffleView.ogE - 1;
            int i2 = (shuffleView.ogF - 1) - shuffleView.ogE;
            int i3 = 0;
            if (i > 0) {
                i3 = i + 0;
            }
            if (i2 > 0) {
                i3 += i2;
            }
            if (i3 > 0) {
                return (width * 2.0f) / ((float) i3);
            }
        }
        return 0.0f;
    }

    public ShuffleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void aXD() {
        if (this.ogF > 1) {
            x.d("ShuffleView", "card width: %d,height: %d", Integer.valueOf(((View) this.ogr.get(0)).getWidth()), Integer.valueOf(((View) this.ogr.get(0)).getHeight()));
            if (this.ogs.ogU == 2) {
                this.ogG = (((float) ((View) this.ogr.get(0)).getWidth()) * 1.5f) / ((float) this.ogF);
                if (this.ogG > ((float) ((View) this.ogr.get(0)).getWidth()) * 0.23f) {
                    this.ogG = ((float) ((View) this.ogr.get(0)).getWidth()) * 0.23f;
                    return;
                }
                return;
            } else if (this.ogs.ogU == 1) {
                this.ogH = (((float) ((View) this.ogr.get(0)).getHeight()) * 1.0f) / ((float) this.ogF);
                return;
            } else {
                return;
            }
        }
        this.ogG = 0.0f;
        this.ogH = 0.0f;
    }

    final void y(View view, int i) {
        if (this.ogs.ogU == 1) {
            view.setScaleX(1.0f - (this.ogs.ogX * ((float) i)));
            view.setTranslationY(so(i));
        } else if (this.ogs.ogU == 2) {
            view.setScaleY(1.0f - (this.ogs.ogY * ((float) i)));
            view.setTranslationX(sn(i));
        }
    }

    public final float sn(int i) {
        if (this.ogs.ogU == 2 && this.ogF > 0) {
            if (this.ogs.ogV == 3) {
                return ((((float) (this.ogF - 1)) * 0.5f) * this.ogG) - (this.ogG * ((float) i));
            }
            if (this.ogs.ogV == 4) {
                return (this.ogG * ((float) i)) - ((((float) (this.ogF - 1)) * 0.5f) * this.ogG);
            }
        }
        return 0.0f;
    }

    public final float so(int i) {
        if (this.ogs.ogU == 1) {
            if (this.ogs.ogV == 1) {
                return ((((float) (this.ogF - 1)) * 0.5f) * this.ogH) - (this.ogH * ((float) i));
            }
            if (this.ogs.ogV == 2) {
                return (this.ogH * ((float) i)) - ((((float) (this.ogF - 1)) * 0.5f) * this.ogH);
            }
        }
        return 0.0f;
    }

    final int aXE() {
        return (int) (Math.random() * ((double) this.ogF));
    }

    private void aXF() {
        if (this.ogB != null) {
            x.i("ShuffleView", "selectView != null, cancel select");
            if (this.ogw.isStarted()) {
                this.ogw.cancel();
            }
            this.ogw.removeAllUpdateListeners();
            this.ogw.removeAllListeners();
            switch (this.ogs.ogV) {
                case 4:
                    if (this.ogC >= 0) {
                        this.ogw.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.ogL.clear();
                                    ShuffleView.this.ogM.clear();
                                    while (i < ShuffleView.this.ogF) {
                                        ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                                        ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                while (true) {
                                    int i2 = i;
                                    if (i2 < ShuffleView.this.ogF) {
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i2) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                        i = i2 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
            this.ogB = null;
            this.ogC = 0;
            this.ogw.start();
        }
    }

    final void sp(int i) {
        if (i >= 0 && i < this.ogF) {
            x.i("ShuffleView", "select card " + i);
            if (this.ogw.isStarted()) {
                this.ogw.cancel();
            }
            this.ogw.removeAllUpdateListeners();
            this.ogw.removeAllListeners();
            this.ogB = (View) this.ogr.get(i);
            this.ogC = i;
            this.ogD = null;
            this.ogE = -1;
            switch (this.ogs.ogV) {
                case 4:
                    if (i <= 0) {
                        this.ogw.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.ogL.clear();
                                    ShuffleView.this.ogM.clear();
                                    while (i < ShuffleView.this.ogF) {
                                        ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                                        ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                ShuffleView.this.ogB.setTranslationY((((Float) ShuffleView.this.ogM.get(0)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.ogB.getHeight()) * floatValue) / 7.0f));
                                int i2 = 1;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 < ShuffleView.this.ogF) {
                                        ((View) ShuffleView.this.ogr.get(i3)).setTranslationX((((Float) ShuffleView.this.ogL.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i3) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i3)).setTranslationY((((Float) ShuffleView.this.ogM.get(i3)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i3) * floatValue));
                                        i2 = i3 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        });
                        break;
                    }
                    final int i2 = i - 1;
                    final int i3 = (this.ogF - 1) - i;
                    this.ogw.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            int i = 0;
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            if (floatValue == 0.0f) {
                                ShuffleView.this.ogL.clear();
                                ShuffleView.this.ogM.clear();
                                while (i < ShuffleView.this.ogF) {
                                    ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                                    ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                                    i++;
                                }
                                return;
                            }
                            int i2;
                            if (i2 <= 0) {
                                while (true) {
                                    i2 = i;
                                    if (i2 >= ShuffleView.this.ogC) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i2) * floatValue));
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                    i = i2 + 1;
                                }
                            } else {
                                while (true) {
                                    i2 = i;
                                    if (i2 >= ShuffleView.this.ogC - 1) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(i2) - (((float) (i2 + 1)) * ShuffleView.g(ShuffleView.this))) * floatValue));
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                    i = i2 + 1;
                                }
                                ((View) ShuffleView.this.ogr.get(ShuffleView.this.ogC - 1)).setTranslationX((((Float) ShuffleView.this.ogL.get(ShuffleView.this.ogC - 1)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(ShuffleView.this.ogC - 1) - ((ShuffleView.g(ShuffleView.this) * ((float) i2)) / 2.0f)) * floatValue));
                                ((View) ShuffleView.this.ogr.get(ShuffleView.this.ogC - 1)).setTranslationY((((Float) ShuffleView.this.ogM.get(ShuffleView.this.ogC - 1)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(ShuffleView.this.ogC - 1) * floatValue));
                            }
                            int f;
                            if (i3 <= 0) {
                                f = ShuffleView.this.ogC;
                                while (true) {
                                    i2 = f;
                                    if (i2 >= ShuffleView.this.ogF) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i2) * floatValue));
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                    f = i2 + 1;
                                }
                            } else {
                                ShuffleView.this.ogB.setTranslationX((((Float) ShuffleView.this.ogL.get(ShuffleView.this.ogC)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(ShuffleView.this.ogC) + ((ShuffleView.g(ShuffleView.this) * ((float) i3)) / 2.0f)) * floatValue));
                                f = ShuffleView.this.ogC + 1;
                                while (true) {
                                    i2 = f;
                                    if (i2 >= ShuffleView.this.ogF) {
                                        break;
                                    }
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + ((ShuffleView.this.sn(i2) + (((float) (ShuffleView.this.ogF - i2)) * ShuffleView.g(ShuffleView.this))) * floatValue));
                                    ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                    f = i2 + 1;
                                }
                            }
                            ShuffleView.this.ogB.setTranslationY((((Float) ShuffleView.this.ogM.get(ShuffleView.this.ogC)).floatValue() * (1.0f - floatValue)) - ((((float) ShuffleView.this.ogB.getHeight()) * floatValue) / 7.0f));
                        }
                    });
                    break;
            }
            this.ogw.start();
        }
    }

    private void aXG() {
        if (this.ogD != null) {
            x.i("ShuffleView", "touchView != null,cancel touch");
            if (this.ogw.isStarted()) {
                this.ogw.cancel();
            }
            this.ogw.removeAllUpdateListeners();
            this.ogw.removeAllListeners();
            switch (this.ogs.ogV) {
                case 4:
                    if (this.ogE >= 0) {
                        this.ogw.addUpdateListener(new AnimatorUpdateListener() {
                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int i = 0;
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (floatValue == 0.0f) {
                                    ShuffleView.this.ogL.clear();
                                    ShuffleView.this.ogM.clear();
                                    while (i < ShuffleView.this.ogF) {
                                        ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                                        ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                                        i++;
                                    }
                                    return;
                                }
                                while (true) {
                                    int i2 = i;
                                    if (i2 < ShuffleView.this.ogF) {
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.sn(i2) * floatValue));
                                        ((View) ShuffleView.this.ogr.get(i2)).setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (ShuffleView.this.so(i2) * floatValue));
                                        i = i2 + 1;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        });
                        break;
                    }
                    break;
            }
            this.ogD = null;
            this.ogE = -1;
            this.ogw.start();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ogN) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (this.ogF <= 0) {
            return false;
        }
        x.d("ShuffleView", "y:%d,packet largest:%d", Integer.valueOf(y), Integer.valueOf((getHeight() - ((View) this.ogr.get(0)).getHeight()) - (((View) this.ogr.get(0)).getHeight() / 7)));
        if (y >= (getHeight() - ((View) this.ogr.get(0)).getHeight()) - (((View) this.ogr.get(0)).getHeight() / 7)) {
            int i;
            for (i = 0; i < this.ogF; i++) {
                Rect sq = sq(i);
                if (sq != null && sq.contains(x, y)) {
                    i = 1;
                    break;
                }
            }
            boolean z = false;
            if (i == 0) {
                x.d("ShuffleView", "event %d out of cards,%d,%d", Integer.valueOf(motionEvent.getActionMasked()), Integer.valueOf(x), Integer.valueOf(y));
                if (this.ogB != null && motionEvent.getActionMasked() == 0) {
                    if (this.ogy != null) {
                        this.ogy.cO(this.ogC, this.ogF);
                    }
                    aXF();
                } else if (this.ogD != null && this.ogD.getTranslationY() == ((float) ((-this.ogD.getHeight()) / 7))) {
                    if (this.ogy != null) {
                        this.ogy.sl(this.ogF);
                    }
                    sp(this.ogE);
                } else if (this.ogD != null) {
                    aXG();
                }
            }
            if (this.ogF <= 1) {
                return false;
            }
            x.i("ShuffleView", "ret:%s,action:%s", Boolean.valueOf(this.mbL.onTouchEvent(motionEvent)), Integer.valueOf(motionEvent.getActionMasked()));
            if (!this.mbL.onTouchEvent(motionEvent) && motionEvent.getActionMasked() == 1) {
                if (this.ogD != null && this.ogD.getTranslationY() == ((float) ((-this.ogD.getHeight()) / 7))) {
                    if (this.ogy != null) {
                        this.ogy.sl(this.ogF);
                    }
                    sp(this.ogE);
                } else if (this.ogD != null) {
                    aXG();
                }
            }
            return true;
        } else if (this.ogB != null && motionEvent.getActionMasked() == 0) {
            if (this.ogy != null) {
                this.ogy.cO(this.ogC, this.ogF);
            }
            aXF();
            return false;
        } else if (this.ogD != null && this.ogD.getTranslationY() == ((float) ((-this.ogD.getHeight()) / 7))) {
            if (this.ogy != null) {
                this.ogy.sl(this.ogF);
            }
            sp(this.ogE);
            return false;
        } else if (this.ogD == null) {
            return false;
        } else {
            aXG();
            return false;
        }
    }

    private Rect sq(int i) {
        if (i >= 0 && i < this.ogF) {
            View view = (View) this.ogr.get(i);
            switch (this.ogs.ogV) {
                case 4:
                    if (i == 0) {
                        return new Rect(view.getLeft() + ((int) view.getTranslationX()), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
                    }
                    View view2 = (View) this.ogr.get(i - 1);
                    return new Rect(((int) view2.getTranslationX()) + view2.getRight(), view.getTop() + ((int) view.getTranslationY()), view.getRight() + ((int) view.getTranslationX()), ((int) view.getTranslationY()) + view.getBottom());
            }
        }
        return null;
    }

    final void sr(final int i) {
        this.ogv.removeAllUpdateListeners();
        this.ogv.removeAllListeners();
        if (this.ogr.size() < this.ogF) {
            this.ogF--;
            if (this.ogF == 1) {
                ((View) this.ogr.get(0)).findViewById(f.uuq).setVisibility(0);
            }
            aXD();
            this.ogv.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i = 0;
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue == 0.0f) {
                        ShuffleView.this.ogL.clear();
                        ShuffleView.this.ogM.clear();
                        while (i < ShuffleView.this.ogF) {
                            ShuffleView.this.ogL.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationX()));
                            ShuffleView.this.ogM.add(Float.valueOf(((View) ShuffleView.this.ogr.get(i)).getTranslationY()));
                            i++;
                        }
                        return;
                    }
                    while (true) {
                        int i2 = i;
                        if (i2 < ShuffleView.this.ogF) {
                            View view = (View) ShuffleView.this.ogr.get(i2);
                            if (ShuffleView.this.ogs.ogU == 1) {
                                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogs.ogX) + (1.0f - (ShuffleView.this.ogs.ogX * ((float) (i2 + 1)))));
                                view.setTranslationY((((Float) ShuffleView.this.ogM.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.so(i2)));
                            } else if (ShuffleView.this.ogs.ogU == 2) {
                                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogs.ogY) + (1.0f - (ShuffleView.this.ogs.ogY * ((float) (i2 + 1)))));
                                view.setTranslationX((((Float) ShuffleView.this.ogL.get(i2)).floatValue() * (1.0f - floatValue)) + (floatValue * ShuffleView.this.sn(i2)));
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            });
            this.ogv.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    ShuffleView.this.ogN = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    ShuffleView.this.ogN = false;
                    ShuffleView.this.ogD = null;
                    ShuffleView.this.ogE = -1;
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        } else {
            this.ogA = (View) this.ogr.get(this.ogF - 1);
            y(this.ogA, this.ogF - 1);
            addView(this.ogA, 0);
            if (this.ogu != null) {
                switch (this.ogs.ogW) {
                    case 1:
                        this.ogA.setTranslationY((float) (-ieH.heightPixels));
                        break;
                    case 2:
                        this.ogA.setTranslationY((float) ieH.heightPixels);
                        break;
                    case 3:
                        this.ogA.setTranslationX((float) (-ieH.widthPixels));
                        break;
                    case 4:
                        this.ogA.setTranslationX((float) ieH.widthPixels);
                        break;
                }
            }
            this.ogA.setVisibility(4);
            this.ogv.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int i = i;
                    while (true) {
                        int i2 = i;
                        if (i2 < ShuffleView.this.ogF - 1) {
                            View view = (View) ShuffleView.this.ogr.get(i2);
                            if (ShuffleView.this.ogs.ogU == 1) {
                                view.setScaleX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogs.ogX) + (1.0f - (ShuffleView.this.ogs.ogX * ((float) (i2 + 1)))));
                                if (ShuffleView.this.ogs.ogV == 2) {
                                    view.setTranslationY(ShuffleView.this.so(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogH));
                                } else if (ShuffleView.this.ogs.ogV == 1) {
                                    view.setTranslationY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogH) + ShuffleView.this.so(i2 + 1));
                                }
                            } else if (ShuffleView.this.ogs.ogU == 2) {
                                view.setScaleY((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogs.ogY) + (1.0f - (ShuffleView.this.ogs.ogY * ((float) (i2 + 1)))));
                                if (ShuffleView.this.ogs.ogV == 3) {
                                    view.setTranslationX((((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogG) + ShuffleView.this.sn(i2 + 1));
                                } else if (ShuffleView.this.ogs.ogV == 4) {
                                    view.setTranslationX(ShuffleView.this.sn(i2 + 1) - (((Float) valueAnimator.getAnimatedValue()).floatValue() * ShuffleView.this.ogG));
                                }
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            });
            this.ogv.addListener(new AnimatorListener() {
                public final void onAnimationStart(Animator animator) {
                    ShuffleView.this.ogN = true;
                }

                public final void onAnimationEnd(Animator animator) {
                    ShuffleView.this.ogN = false;
                    ShuffleView.this.ogA.setVisibility(0);
                    if (ShuffleView.this.ogu != null) {
                        ShuffleView.this.ogu.start();
                    }
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
        }
        this.ogv.start();
    }
}
