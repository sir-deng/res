package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.an;
import android.support.v4.view.ao;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.g;
import android.support.v7.view.h;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d extends ActionBar implements android.support.v7.widget.ActionBarOverlayLayout.a {
    private static final Interpolator Io = new AccelerateInterpolator();
    private static final Interpolator Ip = new DecelerateInterpolator();
    private static final boolean Iq = (VERSION.SDK_INT >= 14);
    u HT;
    private boolean HX;
    private ArrayList<Object> HY = new ArrayList();
    b IA;
    android.support.v7.view.b.a IB;
    private int IE = 0;
    private boolean IF = true;
    private boolean IG;
    private boolean IH;
    private boolean II;
    private boolean IJ = true;
    private h IK;
    private boolean IL;
    final am IN = new an() {
        public final void q(View view) {
            if (d.this.IF && d.this.Iv != null) {
                z.c(d.this.Iv, 0.0f);
                z.c(d.this.It, 0.0f);
            }
            d.this.It.setVisibility(8);
            d.this.It.K(false);
            d.this.IK = null;
            d dVar = d.this;
            if (dVar.IB != null) {
                dVar.IB.a(dVar.IA);
                dVar.IA = null;
                dVar.IB = null;
            }
        }
    };
    final am IO = new an() {
        public final void q(View view) {
            d.this.IK = null;
            d.this.It.requestLayout();
        }
    };
    final ao IP = new ao() {
        public final void cb() {
            ((View) d.this.It.getParent()).invalidate();
        }
    };
    private Context Ir;
    private ActionBarContainer It;
    private ActionBarContextView Iu;
    private View Iv;
    private boolean Iy;
    private Activity mActivity;
    private Context mContext;
    a yee;

    public class a extends b implements android.support.v7.view.menu.f.a {
        private final Context IR;
        private android.support.v7.view.b.a IS;
        private WeakReference<View> IT;
        private final f eg;

        public a(Context context, android.support.v7.view.b.a aVar) {
            this.IR = context;
            this.IS = aVar;
            f fVar = new f(context);
            this.eg = fVar;
            this.eg.a((android.support.v7.view.menu.f.a) this);
        }

        public final MenuInflater getMenuInflater() {
            return new g(this.IR);
        }

        public final Menu getMenu() {
            return this.eg;
        }

        public final void finish() {
            if (d.this.yee == this) {
                if (d.a(d.this.IG, d.this.IH, false)) {
                    this.IS.a(this);
                } else {
                    d.this.IA = this;
                    d.this.IB = this.IS;
                }
                this.IS = null;
                d.this.D(false);
                d.this.Iu.dP();
                d.this.HT.eI().sendAccessibilityEvent(32);
                d.this.yee = null;
            }
        }

        public final void invalidate() {
            if (d.this.yee == this) {
                this.eg.dx();
                try {
                    this.IS.b(this, this.eg);
                } finally {
                    this.eg.dy();
                }
            }
        }

        public final boolean df() {
            this.eg.dx();
            try {
                boolean a = this.IS.a((b) this, this.eg);
                return a;
            } finally {
                this.eg.dy();
            }
        }

        public final void setCustomView(View view) {
            d.this.Iu.setCustomView(view);
            this.IT = new WeakReference(view);
        }

        public final void setSubtitle(CharSequence charSequence) {
            d.this.Iu.setSubtitle(charSequence);
        }

        public final void setTitle(CharSequence charSequence) {
            d.this.Iu.setTitle(charSequence);
        }

        public final void setTitle(int i) {
            setTitle(d.this.mContext.getResources().getString(i));
        }

        public final void setSubtitle(int i) {
            setSubtitle(d.this.mContext.getResources().getString(i));
        }

        public final CharSequence getTitle() {
            return d.this.Iu.uU;
        }

        public final CharSequence getSubtitle() {
            return d.this.Iu.uV;
        }

        public final void setTitleOptionalHint(boolean z) {
            super.setTitleOptionalHint(z);
            d.this.Iu.L(z);
        }

        public final boolean isTitleOptional() {
            return d.this.Iu.ML;
        }

        public final View getCustomView() {
            return this.IT != null ? (View) this.IT.get() : null;
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            if (this.IS != null) {
                return this.IS.a((b) this, menuItem);
            }
            return false;
        }

        public final void b(f fVar) {
            if (this.IS != null) {
                invalidate();
                d.this.Iu.showOverflowMenu();
            }
        }
    }

    public d(Activity activity, ViewGroup viewGroup) {
        u uVar;
        this.mActivity = activity;
        View findViewById = viewGroup.findViewById(android.support.v7.a.a.f.action_bar);
        if (findViewById instanceof u) {
            uVar = (u) findViewById;
        } else if (findViewById instanceof Toolbar) {
            uVar = ((Toolbar) findViewById).gZ();
        } else {
            throw new IllegalStateException(new StringBuilder("Can't make a decor toolbar out of ").append(findViewById).toString() != null ? findViewById.getClass().getSimpleName() : "null");
        }
        this.HT = uVar;
        this.Iu = (ActionBarContextView) viewGroup.findViewById(android.support.v7.a.a.f.action_context_bar);
        this.It = (ActionBarContainer) viewGroup.findViewById(android.support.v7.a.a.f.action_bar_container);
        if (this.HT == null || this.Iu == null || this.It == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        boolean z;
        this.mContext = this.HT.getContext();
        if ((this.HT.getDisplayOptions() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.Iy = true;
        }
        android.support.v7.view.a.p(this.mContext).dh();
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, k.ActionBar, android.support.v7.a.a.a.actionBarStyle, 0);
        obtainStyledAttributes.getBoolean(k.ActionBar_hideOnContentScroll, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        this.Iv = null;
    }

    public final void setElevation(float f) {
        z.g(this.It, f);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        LayoutParams layoutParams = this.HT.eI().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = com.tencent.mm.compatible.util.a.g(this.mActivity);
        }
        this.HT.eI().setLayoutParams(layoutParams);
    }

    public final void onWindowVisibilityChanged(int i) {
        this.IE = i;
    }

    public final void y(boolean z) {
        this.IL = z;
        if (!z && this.IK != null) {
            this.IK.cancel();
        }
    }

    public final void z(boolean z) {
        if (z != this.HX) {
            this.HX = z;
            int size = this.HY.size();
            for (int i = 0; i < size; i++) {
                this.HY.get(i);
            }
        }
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i, this.HT.eI(), false));
    }

    public final void cO() {
        setDisplayOptions(0, 2);
    }

    public final void setDisplayHomeAsUpEnabled(boolean z) {
        setDisplayOptions(z ? 4 : 0, 4);
    }

    public final void cP() {
        setDisplayOptions(0, 8);
    }

    public final void cQ() {
        setDisplayOptions(16, 16);
    }

    public final void e(CharSequence charSequence) {
        this.HT.e(charSequence);
    }

    public final void setDisplayOptions(int i) {
        if ((i & 4) != 0) {
            this.Iy = true;
        }
        this.HT.setDisplayOptions(i);
    }

    private void setDisplayOptions(int i, int i2) {
        int displayOptions = this.HT.getDisplayOptions();
        if ((i2 & 4) != 0) {
            this.Iy = true;
        }
        this.HT.setDisplayOptions((displayOptions & (i2 ^ -1)) | (i & i2));
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.It.m(drawable);
    }

    public final View getCustomView() {
        return this.HT.getCustomView();
    }

    public final CharSequence getTitle() {
        return this.HT.getTitle();
    }

    public final int getDisplayOptions() {
        return this.HT.getDisplayOptions();
    }

    public final b a(android.support.v7.view.b.a aVar) {
        if (this.yee != null) {
            this.yee.finish();
        }
        this.Iu.dQ();
        b aVar2 = new a(this.Iu.getContext(), aVar);
        if (!aVar2.df()) {
            return null;
        }
        aVar2.invalidate();
        this.Iu.c(aVar2);
        D(true);
        this.Iu.sendAccessibilityEvent(32);
        this.yee = aVar2;
        return aVar2;
    }

    public final int getHeight() {
        return this.It.getHeight();
    }

    public final void B(boolean z) {
        this.IF = z;
    }

    public final void show() {
        if (this.IG) {
            this.IG = false;
            C(false);
        }
    }

    public final void dc() {
        if (this.IH) {
            this.IH = false;
            C(true);
        }
    }

    public final void hide() {
        if (!this.IG) {
            this.IG = true;
            C(false);
        }
    }

    public final void dd() {
        if (!this.IH) {
            this.IH = true;
            C(true);
        }
    }

    private static boolean a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void C(boolean z) {
        float f;
        h hVar;
        ai s;
        if (a(this.IG, this.IH, this.II)) {
            if (!this.IJ) {
                this.IJ = true;
                if (this.IK != null) {
                    this.IK.cancel();
                }
                this.It.setVisibility(0);
                if (this.IE == 0 && Iq && (this.IL || z)) {
                    z.c(this.It, 0.0f);
                    f = (float) (-this.It.getHeight());
                    if (z) {
                        int[] iArr = new int[]{0, 0};
                        this.It.getLocationInWindow(iArr);
                        f -= (float) iArr[1];
                    }
                    z.c(this.It, f);
                    hVar = new h();
                    s = z.U(this.It).s(0.0f);
                    s.a(this.IP);
                    hVar.g(s);
                    if (this.IF && this.Iv != null) {
                        z.c(this.Iv, f);
                        hVar.g(z.U(this.Iv).s(0.0f));
                    }
                    hVar.c(Ip);
                    hVar.dm();
                    hVar.b(this.IO);
                    this.IK = hVar;
                    hVar.start();
                    return;
                }
                z.d(this.It, 1.0f);
                z.c(this.It, 0.0f);
                if (this.IF && this.Iv != null) {
                    z.c(this.Iv, 0.0f);
                }
                this.IO.q(null);
            }
        } else if (this.IJ) {
            this.IJ = false;
            if (this.IK != null) {
                this.IK.cancel();
            }
            if (this.IE == 0 && Iq && (this.IL || z)) {
                z.d(this.It, 1.0f);
                this.It.K(true);
                hVar = new h();
                f = (float) (-this.It.getHeight());
                if (z) {
                    int[] iArr2 = new int[]{0, 0};
                    this.It.getLocationInWindow(iArr2);
                    f -= (float) iArr2[1];
                }
                s = z.U(this.It).s(f);
                s.a(this.IP);
                hVar.g(s);
                if (this.IF && this.Iv != null) {
                    hVar.g(z.U(this.Iv).s(f));
                }
                hVar.c(Io);
                hVar.dm();
                hVar.b(this.IN);
                this.IK = hVar;
                hVar.start();
                return;
            }
            this.IN.q(null);
        }
    }

    public final boolean isShowing() {
        int height = this.It.getHeight();
        return this.IJ && (height == 0 || height > 0);
    }

    public final void D(boolean z) {
        ai c;
        ai c2;
        if (z) {
            if (!this.II) {
                this.II = true;
                C(false);
            }
        } else if (this.II) {
            this.II = false;
            C(false);
        }
        if (z) {
            c = this.HT.c(8, 100);
            c2 = this.Iu.c(0, 200);
        } else {
            c2 = this.HT.c(0, 200);
            c = this.Iu.c(8, 100);
        }
        h hVar = new h();
        hVar.a(c, c2);
        hVar.start();
    }

    public final Context getThemedContext() {
        if (this.Ir == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.Ir = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.Ir = this.mContext;
            }
        }
        return this.Ir;
    }

    public final void setHomeActionContentDescription(int i) {
        this.HT.setNavigationContentDescription(i);
    }

    public final void de() {
        if (this.IK != null) {
            this.IK.cancel();
            this.IK = null;
        }
    }

    public final boolean collapseActionView() {
        if (this.HT == null || !this.HT.hasExpandedActionView()) {
            return false;
        }
        this.HT.collapseActionView();
        return true;
    }

    public final void setCustomView(View view) {
        this.HT.setCustomView(view);
    }

    public final void setIcon(int i) {
        this.HT.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.HT.setLogo(drawable);
    }

    public final void x(boolean z) {
        if (!this.Iy) {
            setDisplayHomeAsUpEnabled(z);
        }
    }
}
