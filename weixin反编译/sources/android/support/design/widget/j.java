package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;

class j extends l {
    private int ik;
    private r il = new r();
    private boolean im;
    o in;

    private abstract class a extends Animation {
        private float is;
        private float it;

        protected abstract float ab();

        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }

        public void reset() {
            super.reset();
            this.is = j.this.in.jk;
            this.it = ab() - this.is;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            o oVar = j.this.in;
            oVar.d(this.is + (this.it * f), oVar.ji);
        }
    }

    private class c extends a {
        private c() {
            super(j.this, (byte) 0);
        }

        /* synthetic */ c(j jVar, byte b) {
            this();
        }

        protected final float ab() {
            return j.this.iB;
        }
    }

    private class b extends a {
        private b() {
            super(j.this, (byte) 0);
        }

        /* synthetic */ b(j jVar, byte b) {
            this();
        }

        protected final float ab() {
            return j.this.iB + j.this.iC;
        }
    }

    j(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        super(visibilityAwareImageButton, pVar);
        this.ik = visibilityAwareImageButton.getResources().getInteger(17694720);
        r rVar = this.il;
        View ar = rVar.ar();
        if (ar != visibilityAwareImageButton) {
            if (ar != null) {
                View ar2 = rVar.ar();
                int size = rVar.jI.size();
                for (int i = 0; i < size; i++) {
                    if (ar2.getAnimation() == ((a) rVar.jI.get(i)).mAnimation) {
                        ar2.clearAnimation();
                    }
                }
                rVar.fq = null;
                rVar.jJ = null;
                rVar.jK = null;
            }
            if (visibilityAwareImageButton != null) {
                rVar.fq = new WeakReference(visibilityAwareImageButton);
            }
        }
        this.il.a(PRESSED_ENABLED_STATE_SET, c(new b()));
        this.il.a(iD, c(new b()));
        this.il.a(EMPTY_STATE_SET, c(new c()));
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.ix = android.support.v4.b.a.a.h(l.ag());
        android.support.v4.b.a.a.a(this.ix, colorStateList);
        if (mode != null) {
            android.support.v4.b.a.a.a(this.ix, mode);
        }
        this.iy = android.support.v4.b.a.a.h(l.ag());
        Drawable drawable = this.iy;
        r1 = new int[3][];
        int[] iArr = new int[]{iD, i, PRESSED_ENABLED_STATE_SET};
        iArr[1] = i;
        r1[2] = new int[0];
        iArr[2] = 0;
        android.support.v4.b.a.a.a(drawable, new ColorStateList(r1, iArr));
        if (i2 > 0) {
            this.iz = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.iz, this.ix, this.iy};
        } else {
            this.iz = null;
            drawableArr = new Drawable[]{this.ix, this.iy};
        }
        this.iA = new LayerDrawable(drawableArr);
        this.in = new o(this.iE.getResources(), this.iA, this.iF.Y(), this.iB, this.iB + this.iC);
        o oVar = this.in;
        oVar.jp = false;
        oVar.invalidateSelf();
        this.iF.setBackgroundDrawable(this.in);
    }

    final void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.ix != null) {
            android.support.v4.b.a.a.a(this.ix, colorStateList);
        }
        if (this.iz != null) {
            this.iz.c(colorStateList);
        }
    }

    final void setBackgroundTintMode(Mode mode) {
        if (this.ix != null) {
            android.support.v4.b.a.a.a(this.ix, mode);
        }
    }

    void j(float f) {
        if (this.in != null) {
            this.in.d(f, this.iC + f);
            ae();
        }
    }

    void k(float f) {
        if (this.in != null) {
            o oVar = this.in;
            oVar.d(oVar.jk, this.iB + f);
            ae();
        }
    }

    void b(int[] iArr) {
        a aVar;
        r rVar = this.il;
        int size = rVar.jI.size();
        for (int i = 0; i < size; i++) {
            a aVar2 = (a) rVar.jI.get(i);
            if (StateSet.stateSetMatches(aVar2.jN, iArr)) {
                aVar = aVar2;
                break;
            }
        }
        aVar = null;
        if (aVar != rVar.jJ) {
            View ar;
            if (!(rVar.jJ == null || rVar.jK == null)) {
                ar = rVar.ar();
                if (ar != null && ar.getAnimation() == rVar.jK) {
                    ar.clearAnimation();
                }
                rVar.jK = null;
            }
            rVar.jJ = aVar;
            ar = (View) rVar.fq.get();
            if (aVar != null && ar != null && ar.getVisibility() == 0) {
                rVar.jK = aVar.mAnimation;
                ar = rVar.ar();
                if (ar != null) {
                    ar.startAnimation(rVar.jK);
                }
            }
        }
    }

    void aa() {
        r rVar = this.il;
        if (rVar.jK != null) {
            View ar = rVar.ar();
            if (ar != null && ar.getAnimation() == rVar.jK) {
                ar.clearAnimation();
            }
        }
    }

    void a(final a aVar, boolean z) {
        if (!this.im && this.iE.getVisibility() == 0) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iE.getContext(), android.support.design.a.a.aP);
            loadAnimation.setInterpolator(a.eC);
            loadAnimation.setDuration(200);
            loadAnimation.setAnimationListener(new b(false) {
            });
            this.iE.startAnimation(loadAnimation);
        }
    }

    void b(final a aVar, boolean z) {
        if (this.iE.getVisibility() != 0 || this.im) {
            this.iE.clearAnimation();
            this.iE.b(0, false);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.iE.getContext(), android.support.design.a.a.aO);
            loadAnimation.setDuration(200);
            loadAnimation.setInterpolator(a.eD);
            loadAnimation.setAnimationListener(new b() {
            });
            this.iE.startAnimation(loadAnimation);
        }
    }

    void b(Rect rect) {
        this.in.getPadding(rect);
    }

    private Animation c(Animation animation) {
        animation.setInterpolator(a.eB);
        animation.setDuration((long) this.ik);
        return animation;
    }
}
