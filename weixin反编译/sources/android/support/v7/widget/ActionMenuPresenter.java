package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ae;
import android.support.v7.a.a.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.p;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

final class ActionMenuPresenter extends android.support.v7.view.menu.b implements android.support.v4.view.d.a {
    private int NA;
    private final SparseBooleanArray NB = new SparseBooleanArray();
    private View NC;
    e ND;
    a NE;
    c NF;
    private b NG;
    final f NH = new f();
    int NI;
    d No;
    private Drawable Np;
    private boolean Nq;
    private boolean Nr;
    private boolean Ns;
    private int Nt;
    private int Nu;
    int Nv;
    boolean Nw;
    private boolean Nx;
    private boolean Ny;
    boolean Nz;

    private static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int NO;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.NO = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.NO);
        }
    }

    private class c implements Runnable {
        private e NK;

        public c(e eVar) {
            this.NK = eVar;
        }

        public final void run() {
            android.support.v7.view.menu.f fVar = ActionMenuPresenter.this.eg;
            if (fVar.Lh != null) {
                fVar.Lh.b(fVar);
            }
            View view = (View) ActionMenuPresenter.this.KL;
            if (!(view == null || view.getWindowToken() == null || !this.NK.dN())) {
                ActionMenuPresenter.this.ND = this.NK;
            }
            ActionMenuPresenter.this.NF = null;
        }
    }

    private class b extends android.support.v7.view.menu.ActionMenuItemView.b {
        private b() {
        }

        /* synthetic */ b(ActionMenuPresenter actionMenuPresenter, byte b) {
            this();
        }

        public final ListPopupWindow dq() {
            return ActionMenuPresenter.this.NE != null ? ActionMenuPresenter.this.NE.Mc : null;
        }
    }

    private class f implements android.support.v7.view.menu.l.a {
        private f() {
        }

        /* synthetic */ f(ActionMenuPresenter actionMenuPresenter, byte b) {
            this();
        }

        public final boolean d(android.support.v7.view.menu.f fVar) {
            if (fVar == null) {
                return false;
            }
            ActionMenuPresenter.this.NI = ((p) fVar).getItem().getItemId();
            android.support.v7.view.menu.l.a aVar = ActionMenuPresenter.this.ef;
            return aVar != null ? aVar.d(fVar) : false;
        }

        public final void a(android.support.v7.view.menu.f fVar, boolean z) {
            if (fVar instanceof p) {
                ((p) fVar).Mk.E(false);
            }
            android.support.v7.view.menu.l.a aVar = ActionMenuPresenter.this.ef;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }
    }

    private class a extends k {
        private p LD;
        final /* synthetic */ ActionMenuPresenter NJ;

        public a(ActionMenuPresenter actionMenuPresenter, Context context, p pVar) {
            boolean z = false;
            this.NJ = actionMenuPresenter;
            super(context, pVar, null, false, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.LD = pVar;
            if (!((h) pVar.getItem()).dJ()) {
                this.hH = actionMenuPresenter.No == null ? (View) actionMenuPresenter.KL : actionMenuPresenter.No;
            }
            this.LC = actionMenuPresenter.NH;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            this.KX = z;
        }

        public final void onDismiss() {
            super.onDismiss();
            this.NJ.NE = null;
            this.NJ.NI = 0;
        }
    }

    private class d extends AppCompatImageView implements android.support.v7.widget.ActionMenuView.a {
        private final float[] NL = new float[2];

        public d(Context context) {
            super(context, null, android.support.v7.a.a.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, ActionMenuPresenter.this) {
                public final ListPopupWindow dq() {
                    if (ActionMenuPresenter.this.ND == null) {
                        return null;
                    }
                    return ActionMenuPresenter.this.ND.Mc;
                }

                public final boolean dr() {
                    ActionMenuPresenter.this.showOverflowMenu();
                    return true;
                }

                public final boolean ec() {
                    if (ActionMenuPresenter.this.NF != null) {
                        return false;
                    }
                    ActionMenuPresenter.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        public final boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        public final boolean do() {
            return false;
        }

        public final boolean dp() {
            return false;
        }

        protected final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.b.a.a.a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class e extends k {
        public e(Context context, android.support.v7.view.menu.f fVar, View view) {
            super(context, fVar, view, true, android.support.v7.a.a.a.actionOverflowMenuStyle);
            this.LC = ActionMenuPresenter.this.NH;
        }

        public final void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.eg != null) {
                ActionMenuPresenter.this.eg.close();
            }
            ActionMenuPresenter.this.ND = null;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, android.support.v7.a.a.h.abc_action_menu_layout, android.support.v7.a.a.h.abc_action_menu_item_layout);
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        boolean z = true;
        super.a(context, fVar);
        Resources resources = context.getResources();
        android.support.v7.view.a p = android.support.v7.view.a.p(context);
        if (!this.Ns) {
            if (VERSION.SDK_INT < 19 && ae.b(ViewConfiguration.get(p.mContext))) {
                z = false;
            }
            this.Nr = z;
        }
        if (!this.Ny) {
            this.Nt = p.mContext.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.Nw) {
            this.Nv = p.mContext.getResources().getInteger(g.abc_max_action_buttons);
        }
        int i = this.Nt;
        if (this.Nr) {
            if (this.No == null) {
                this.No = new d(this.KH);
                if (this.Nq) {
                    this.No.setImageDrawable(this.Np);
                    this.Np = null;
                    this.Nq = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.No.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.No.getMeasuredWidth();
        } else {
            this.No = null;
        }
        this.Nu = i;
        this.NA = (int) (56.0f * resources.getDisplayMetrics().density);
        this.NC = null;
    }

    public final void dZ() {
        this.Nr = true;
        this.Ns = true;
    }

    public final m c(ViewGroup viewGroup) {
        m c = super.c(viewGroup);
        ((ActionMenuView) c).a(this);
        return c;
    }

    public final View a(h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.dM()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.c(layoutParams));
        }
        return actionView;
    }

    public final void a(h hVar, android.support.v7.view.menu.m.a aVar) {
        aVar.a(hVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.Ky = (ActionMenuView) this.KL;
        if (this.NG == null) {
            this.NG = new b();
        }
        actionMenuItemView.KA = this.NG;
    }

    public final boolean e(h hVar) {
        return hVar.dJ();
    }

    public final void h(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.KL).getParent();
        super.h(z);
        ((View) this.KL).requestLayout();
        if (this.eg != null) {
            android.support.v7.view.menu.f fVar = this.eg;
            fVar.dC();
            ArrayList arrayList = fVar.Lk;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                android.support.v4.view.d dVar = ((h) arrayList.get(i)).LH;
                if (dVar != null) {
                    dVar.wJ = this;
                }
            }
        }
        ArrayList dD = this.eg != null ? this.eg.dD() : null;
        if (this.Nr && dD != null) {
            i = dD.size();
            if (i == 1) {
                int i4;
                if (((h) dD.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.No == null) {
                this.No = new d(this.KH);
            }
            ViewGroup viewGroup = (ViewGroup) this.No.getParent();
            if (viewGroup != this.KL) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.No);
                }
                ((ActionMenuView) this.KL).addView(this.No, ActionMenuView.ee());
            }
        } else if (this.No != null && this.No.getParent() == this.KL) {
            ((ViewGroup) this.KL).removeView(this.No);
        }
        ((ActionMenuView) this.KL).Nr = this.Nr;
    }

    public final boolean c(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.No) {
            return false;
        }
        return super.c(viewGroup, i);
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        View view;
        p pVar2 = pVar;
        while (pVar2.Mk != this.eg) {
            pVar2 = (p) pVar2.Mk;
        }
        h item = pVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.KL;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof android.support.v7.view.menu.m.a) && ((android.support.v7.view.menu.m.a) childAt).C() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.No == null) {
                return false;
            }
            view = this.No;
        }
        this.NI = pVar.getItem().getItemId();
        this.NE = new a(this, this.mContext, pVar);
        this.NE.hH = view;
        if (this.NE.dN()) {
            super.a(pVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean showOverflowMenu() {
        if (!this.Nr || isOverflowMenuShowing() || this.eg == null || this.KL == null || this.NF != null || this.eg.dD().isEmpty()) {
            return false;
        }
        this.NF = new c(new e(this.mContext, this.eg, this.No));
        ((View) this.KL).post(this.NF);
        super.a(null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.NF == null || this.KL == null) {
            k kVar = this.ND;
            if (kVar == null) {
                return false;
            }
            kVar.dismiss();
            return true;
        }
        ((View) this.KL).removeCallbacks(this.NF);
        this.NF = null;
        return true;
    }

    public final boolean ea() {
        return hideOverflowMenu() | eb();
    }

    public final boolean eb() {
        if (this.NE == null) {
            return false;
        }
        this.NE.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        return this.ND != null && this.ND.isShowing();
    }

    public final boolean E() {
        h hVar;
        int i;
        int i2;
        ArrayList dB = this.eg.dB();
        int size = dB.size();
        int i3 = this.Nv;
        int i4 = this.Nu;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.KL;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            hVar = (h) dB.get(i7);
            if (hVar.dL()) {
                i5++;
            } else if (hVar.dK()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.Nz && hVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.Nr && (obj != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.NB;
        sparseBooleanArray.clear();
        if (this.Nx) {
            i2 = i4 / this.NA;
            i6 = ((i4 % this.NA) / i2) + this.NA;
            i = i2;
        } else {
            i6 = 0;
            i = 0;
        }
        i3 = 0;
        int i8 = 0;
        i5 = i;
        while (i8 < size) {
            h hVar2 = (h) dB.get(i8);
            View a;
            int i9;
            if (hVar2.dL()) {
                a = a(hVar2, this.NC, viewGroup);
                if (this.NC == null) {
                    this.NC = a;
                }
                if (this.Nx) {
                    i = i5 - ActionMenuView.d(a, i6, i5, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i5;
                }
                i5 = a.getMeasuredWidth();
                i9 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = hVar2.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                hVar2.I(true);
                i2 = i9;
                i3 = i7;
            } else if (hVar2.dK()) {
                boolean z;
                int groupId = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.Nx || i5 > 0);
                if (z3) {
                    a = a(hVar2, this.NC, viewGroup);
                    if (this.NC == null) {
                        this.NC = a;
                    }
                    if (this.Nx) {
                        int d = ActionMenuView.d(a, i6, i5, makeMeasureSpec, 0);
                        i5 -= d;
                        if (d == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i9 = a.getMeasuredWidth();
                    i4 -= i9;
                    if (i3 == 0) {
                        i3 = i9;
                    }
                    if (this.Nx) {
                        z = i & (i4 >= 0 ? 1 : 0);
                        i9 = i5;
                    } else {
                        z = i & (i4 + i3 > 0 ? 1 : 0);
                        i9 = i5;
                    }
                } else {
                    z = z3;
                    i9 = i5;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        hVar = (h) dB.get(i7);
                        if (hVar.getGroupId() == groupId) {
                            if (hVar.dJ()) {
                                i5++;
                            }
                            hVar.I(false);
                        }
                    }
                    i = i5;
                } else {
                    i = i7;
                }
                if (z) {
                    i--;
                }
                hVar2.I(z);
                i5 = i3;
                i2 = i4;
                i3 = i;
                i = i9;
            } else {
                hVar2.I(false);
                i = i5;
                i2 = i4;
                i5 = i3;
                i3 = i7;
            }
            i8++;
            i4 = i2;
            i7 = i3;
            i3 = i5;
            i5 = i;
        }
        return true;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        ea();
        super.a(fVar, z);
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.NO = this.NI;
        return savedState;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            if (savedState.NO > 0) {
                MenuItem findItem = this.eg.findItem(savedState.NO);
                if (findItem != null) {
                    a((p) findItem.getSubMenu());
                }
            }
        }
    }

    public final void r(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.eg.E(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.KL = actionMenuView;
        actionMenuView.eg = this.eg;
    }
}
