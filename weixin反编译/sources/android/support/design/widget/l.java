package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.a.c;
import android.view.ViewTreeObserver.OnPreDrawListener;

abstract class l {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] PRESSED_ENABLED_STATE_SET = new int[]{16842919, 16842910};
    static final int[] iD = new int[]{16842908, 16842910};
    private final Rect gO = new Rect();
    Drawable iA;
    float iB;
    float iC;
    final VisibilityAwareImageButton iE;
    final p iF;
    OnPreDrawListener iG;
    Drawable ix;
    Drawable iy;
    d iz;

    interface a {
    }

    abstract void a(ColorStateList colorStateList, Mode mode, int i, int i2);

    abstract void a(a aVar, boolean z);

    abstract void aa();

    abstract void b(Rect rect);

    abstract void b(a aVar, boolean z);

    abstract void b(int[] iArr);

    abstract void j(float f);

    abstract void k(float f);

    abstract void setBackgroundTintList(ColorStateList colorStateList);

    abstract void setBackgroundTintMode(Mode mode);

    l(VisibilityAwareImageButton visibilityAwareImageButton, p pVar) {
        this.iE = visibilityAwareImageButton;
        this.iF = pVar;
    }

    final void ae() {
        Rect rect = this.gO;
        b(rect);
        c(rect);
        this.iF.d(rect.left, rect.top, rect.right, rect.bottom);
    }

    void c(Rect rect) {
    }

    boolean ac() {
        return false;
    }

    final d a(int i, ColorStateList colorStateList) {
        Resources resources = this.iE.getResources();
        d af = af();
        int color = resources.getColor(c.aZ);
        int color2 = resources.getColor(c.aY);
        int color3 = resources.getColor(c.aW);
        int color4 = resources.getColor(c.aX);
        af.fG = color;
        af.fH = color2;
        af.fI = color3;
        af.fJ = color4;
        float f = (float) i;
        if (af.fF != f) {
            af.fF = f;
            af.fC.setStrokeWidth(f * 1.3333f);
            af.fM = true;
            af.invalidateSelf();
        }
        af.c(colorStateList);
        return af;
    }

    d af() {
        return new d();
    }

    void ad() {
    }

    static GradientDrawable ag() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }
}
