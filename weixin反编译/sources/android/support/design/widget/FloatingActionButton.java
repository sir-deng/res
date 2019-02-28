package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.h;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.design.widget.Snackbar.SnackbarLayout;
import android.support.v4.view.z;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.List;

@android.support.design.widget.CoordinatorLayout.b(a.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private ColorStateList hT;
    private Mode hU;
    private int hV;
    private int hW;
    private int hX;
    private int hY;
    private boolean hZ;
    private final Rect ia;
    private i ib;
    private l ic;

    public static class a extends Behavior<FloatingActionButton> {
        private static final boolean ie = (VERSION.SDK_INT >= 11);
        private Rect gO;
        private u if;
        private float ig;

        public final /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            int i2;
            int i3 = 0;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List n = coordinatorLayout.n(floatingActionButton);
            int size = n.size();
            for (i2 = 0; i2 < size; i2++) {
                View view2 = (View) n.get(i2);
                if ((view2 instanceof AppBarLayout) && a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.e(floatingActionButton, i);
            Rect c = floatingActionButton.ia;
            if (c != null && c.centerX() > 0 && c.centerY() > 0) {
                d dVar = (d) floatingActionButton.getLayoutParams();
                i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - dVar.rightMargin ? c.right : floatingActionButton.getLeft() <= dVar.leftMargin ? -c.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getBottom() - dVar.bottomMargin) {
                    i3 = c.bottom;
                } else if (floatingActionButton.getTop() <= dVar.topMargin) {
                    i3 = -c.top;
                }
                floatingActionButton.offsetTopAndBottom(i3);
                floatingActionButton.offsetLeftAndRight(i2);
            }
            return true;
        }

        public final /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            final FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof SnackbarLayout) {
                float min;
                float f = 0.0f;
                List n = coordinatorLayout.n(floatingActionButton);
                int size = n.size();
                int i = 0;
                while (i < size) {
                    View view3 = (View) n.get(i);
                    if (view3 instanceof SnackbarLayout) {
                        boolean z;
                        if (floatingActionButton.getVisibility() == 0 && view3.getVisibility() == 0) {
                            Rect rect = coordinatorLayout.hl;
                            coordinatorLayout.a((View) floatingActionButton, floatingActionButton.getParent() != coordinatorLayout, rect);
                            Rect rect2 = coordinatorLayout.hm;
                            coordinatorLayout.a(view3, view3.getParent() != coordinatorLayout, rect2);
                            z = rect.left <= rect2.right && rect.top <= rect2.bottom && rect.right >= rect2.left && rect.bottom >= rect2.top;
                        } else {
                            z = false;
                        }
                        if (z) {
                            min = Math.min(f, z.R(view3) - ((float) view3.getHeight()));
                            i++;
                            f = min;
                        }
                    }
                    min = f;
                    i++;
                    f = min;
                }
                if (this.ig != f) {
                    min = z.R(floatingActionButton);
                    if (this.if != null && this.if.ls.isRunning()) {
                        this.if.ls.cancel();
                    }
                    if (!floatingActionButton.isShown() || Math.abs(min - f) <= ((float) floatingActionButton.getHeight()) * 0.667f) {
                        z.c(floatingActionButton, f);
                    } else {
                        if (this.if == null) {
                            this.if = aa.az();
                            this.if.setInterpolator(a.eB);
                            this.if.a(new c() {
                                public final void a(u uVar) {
                                    z.c(floatingActionButton, uVar.ls.aB());
                                }
                            });
                        }
                        this.if.e(min, f);
                        this.if.ls.start();
                    }
                    this.ig = f;
                }
            } else if (view2 instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            }
            return false;
        }

        public final /* bridge */ /* synthetic */ boolean e(View view) {
            return ie && (view instanceof SnackbarLayout);
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            if (((d) floatingActionButton.getLayoutParams()).hG != appBarLayout.getId()) {
                return false;
            }
            if (floatingActionButton.lT != 0) {
                return false;
            }
            if (this.gO == null) {
                this.gO = new Rect();
            }
            Rect rect = this.gO;
            x.a(coordinatorLayout, appBarLayout, rect);
            int i2 = rect.bottom;
            int J = appBarLayout.J();
            int T = z.T(appBarLayout);
            if (T != 0) {
                i = (T * 2) + J;
            } else {
                T = appBarLayout.getChildCount();
                if (T > 0) {
                    i = (z.T(appBarLayout.getChildAt(T - 1)) * 2) + J;
                }
            }
            if (i2 <= i) {
                floatingActionButton.X().a(null, false);
            } else {
                floatingActionButton.X().b(null, false);
            }
            return true;
        }
    }

    private class b implements p {
        private b() {
        }

        /* synthetic */ b(FloatingActionButton floatingActionButton, byte b) {
            this();
        }

        public final float Y() {
            return ((float) FloatingActionButton.this.W()) / 2.0f;
        }

        public final void d(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.ia.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(FloatingActionButton.this.hY + i, FloatingActionButton.this.hY + i2, FloatingActionButton.this.hY + i3, FloatingActionButton.this.hY + i4);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final boolean Z() {
            return FloatingActionButton.this.hZ;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        Mode mode;
        super(context, attributeSet, i);
        this.ia = new Rect();
        t.e(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.i.cC, i, h.bJ);
        this.hT = obtainStyledAttributes.getColorStateList(android.support.design.a.i.cJ);
        switch (obtainStyledAttributes.getInt(android.support.design.a.i.cK, -1)) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            default:
                mode = null;
                break;
        }
        this.hU = mode;
        this.hW = obtainStyledAttributes.getColor(android.support.design.a.i.cE, 0);
        this.hX = obtainStyledAttributes.getInt(android.support.design.a.i.cF, 0);
        this.hV = obtainStyledAttributes.getDimensionPixelSize(android.support.design.a.i.cH, 0);
        float dimension = obtainStyledAttributes.getDimension(android.support.design.a.i.cD, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(android.support.design.a.i.cG, 0.0f);
        this.hZ = obtainStyledAttributes.getBoolean(android.support.design.a.i.cI, false);
        obtainStyledAttributes.recycle();
        this.ib = new i(this, android.support.v7.widget.h.ez());
        this.ib.b(attributeSet, i);
        this.hY = (W() - ((int) getResources().getDimension(android.support.design.a.d.bb))) / 2;
        X().a(this.hT, this.hU, this.hW, this.hV);
        l X = X();
        if (X.iB != dimension) {
            X.iB = dimension;
            X.j(dimension);
        }
        l X2 = X();
        if (X2.iC != dimension2) {
            X2.iC = dimension2;
            X2.k(dimension2);
        }
        X().ae();
    }

    protected void onMeasure(int i, int i2) {
        int W = W();
        W = Math.min(resolveAdjustedSize(W, i), resolveAdjustedSize(W, i2));
        setMeasuredDimension((this.ia.left + W) + this.ia.right, (W + this.ia.top) + this.ia.bottom);
    }

    public ColorStateList getBackgroundTintList() {
        return this.hT;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.hT != colorStateList) {
            this.hT = colorStateList;
            X().setBackgroundTintList(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.hU;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.hU != mode) {
            this.hU = mode;
            X().setBackgroundTintMode(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setImageResource(int i) {
        this.ib.setImageResource(i);
    }

    final int W() {
        switch (this.hX) {
            case 1:
                return getResources().getDimensionPixelSize(android.support.design.a.d.bc);
            default:
                return getResources().getDimensionPixelSize(android.support.design.a.d.bd);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l X = X();
        if (X.ac()) {
            if (X.iG == null) {
                X.iG = new OnPreDrawListener() {
                    public final boolean onPreDraw() {
                        l.this.ad();
                        return true;
                    }
                };
            }
            X.iE.getViewTreeObserver().addOnPreDrawListener(X.iG);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l X = X();
        if (X.iG != null) {
            X.iE.getViewTreeObserver().removeOnPreDrawListener(X.iG);
            X.iG = null;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        X().b(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        X().aa();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private l X() {
        if (this.ic == null) {
            int i = VERSION.SDK_INT;
            l mVar = i >= 21 ? new m(this, new b()) : i >= 14 ? new k(this, new b()) : new j(this, new b());
            this.ic = mVar;
        }
        return this.ic;
    }
}
