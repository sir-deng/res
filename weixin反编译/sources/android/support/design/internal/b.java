package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.view.menu.l;
import android.support.v7.view.menu.p;
import android.support.v7.widget.RecyclerView.t;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;

public final class b implements l {
    ColorStateList ec;
    public NavigationMenuView ed;
    public LinearLayout ee;
    private android.support.v7.view.menu.l.a ef;
    android.support.v7.view.menu.f eg;
    public b eh;
    int ei;
    boolean ej;
    ColorStateList ek;
    Drawable el;
    public int em;
    int en;
    public int mId;
    public LayoutInflater mLayoutInflater;
    final OnClickListener mOnClickListener = new OnClickListener() {
        public final void onClick(View view) {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            b.this.i(true);
            MenuItem menuItem = navigationMenuItemView.eb;
            boolean a = b.this.eg.a(menuItem, b.this, 0);
            if (menuItem != null && menuItem.isCheckable() && a) {
                b.this.eh.d(menuItem);
            }
            b.this.i(false);
            b.this.h(false);
        }
    };

    private interface d {
    }

    private static class g extends j {
        public g(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
            super(layoutInflater.inflate(android.support.design.a.f.bw, viewGroup, false));
            this.VU.setOnClickListener(onClickListener);
        }
    }

    private static class h extends j {
        public h(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.by, viewGroup, false));
        }
    }

    private static class i extends j {
        public i(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(android.support.design.a.f.bz, viewGroup, false));
        }
    }

    private static class e implements d {
        final int et;
        final int eu;

        public e(int i, int i2) {
            this.et = i;
            this.eu = i2;
        }
    }

    private static class f implements d {
        final android.support.v7.view.menu.h ev;

        /* synthetic */ f(android.support.v7.view.menu.h hVar, byte b) {
            this(hVar);
        }

        private f(android.support.v7.view.menu.h hVar) {
            this.ev = hVar;
        }
    }

    private class b extends android.support.v7.widget.RecyclerView.a<j> {
        final ArrayList<d> ep = new ArrayList();
        private android.support.v7.view.menu.h eq;
        private ColorDrawable er;
        boolean es;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            switch (i) {
                case 0:
                    return new g(b.this.mLayoutInflater, viewGroup, b.this.mOnClickListener);
                case 1:
                    return new i(b.this.mLayoutInflater, viewGroup);
                case 2:
                    return new h(b.this.mLayoutInflater, viewGroup);
                case 3:
                    return new a(b.this.ee);
                default:
                    return null;
            }
        }

        public final /* synthetic */ void a(t tVar) {
            j jVar = (j) tVar;
            if (jVar instanceof g) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.VU;
                if (navigationMenuItemView.ea != null) {
                    navigationMenuItemView.ea.removeAllViews();
                }
                navigationMenuItemView.dZ.setCompoundDrawables(null, null, null, null);
            }
        }

        public final /* synthetic */ void a(t tVar, int i) {
            j jVar = (j) tVar;
            switch (getItemViewType(i)) {
                case 0:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) jVar.VU;
                    navigationMenuItemView.ec = b.this.ec;
                    if (navigationMenuItemView.eb != null) {
                        navigationMenuItemView.setIcon(navigationMenuItemView.eb.getIcon());
                    }
                    if (b.this.ej) {
                        navigationMenuItemView.dZ.setTextAppearance(navigationMenuItemView.getContext(), b.this.ei);
                    }
                    if (b.this.ek != null) {
                        navigationMenuItemView.dZ.setTextColor(b.this.ek);
                    }
                    navigationMenuItemView.setBackgroundDrawable(b.this.el != null ? b.this.el.getConstantState().newDrawable() : null);
                    navigationMenuItemView.a(((f) this.ep.get(i)).ev);
                    return;
                case 1:
                    ((TextView) jVar.VU).setText(((f) this.ep.get(i)).ev.getTitle());
                    return;
                case 2:
                    e eVar = (e) this.ep.get(i);
                    jVar.VU.setPadding(0, eVar.et, 0, eVar.eu);
                    return;
                default:
                    return;
            }
        }

        public b() {
            F();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemCount() {
            return this.ep.size();
        }

        public final int getItemViewType(int i) {
            d dVar = (d) this.ep.get(i);
            if (dVar instanceof e) {
                return 2;
            }
            if (dVar instanceof c) {
                return 3;
            }
            if (!(dVar instanceof f)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((f) dVar).ev.hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        final void F() {
            if (!this.es) {
                this.es = true;
                this.ep.clear();
                this.ep.add(new c());
                int i = -1;
                int i2 = 0;
                Object obj = null;
                int size = b.this.eg.dB().size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj2;
                    int i4;
                    int i5;
                    android.support.v7.view.menu.h hVar = (android.support.v7.view.menu.h) b.this.eg.dB().get(i3);
                    if (hVar.isChecked()) {
                        d(hVar);
                    }
                    if (hVar.isCheckable()) {
                        hVar.F(false);
                    }
                    int i6;
                    if (hVar.hasSubMenu()) {
                        SubMenu subMenu = hVar.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i3 != 0) {
                                this.ep.add(new e(b.this.en, 0));
                            }
                            this.ep.add(new f(hVar, (byte) 0));
                            Object obj3 = null;
                            int size2 = this.ep.size();
                            int size3 = subMenu.size();
                            for (i6 = 0; i6 < size3; i6++) {
                                android.support.v7.view.menu.h hVar2 = (android.support.v7.view.menu.h) subMenu.getItem(i6);
                                if (hVar2.isVisible()) {
                                    if (obj3 == null && hVar2.getIcon() != null) {
                                        obj3 = 1;
                                    }
                                    if (hVar2.isCheckable()) {
                                        hVar2.F(false);
                                    }
                                    if (hVar.isChecked()) {
                                        d(hVar);
                                    }
                                    this.ep.add(new f(hVar2, (byte) 0));
                                }
                            }
                            if (obj3 != null) {
                                d(size2, this.ep.size());
                            }
                        }
                        obj2 = obj;
                        i4 = i2;
                        i5 = i;
                    } else {
                        Object obj4;
                        i6 = hVar.getGroupId();
                        if (i6 != i) {
                            i2 = this.ep.size();
                            obj = hVar.getIcon() != null ? 1 : null;
                            if (i3 != 0) {
                                i2++;
                                this.ep.add(new e(b.this.en, b.this.en));
                                obj4 = obj;
                                i5 = i2;
                            }
                            obj4 = obj;
                            i5 = i2;
                        } else {
                            if (obj == null && hVar.getIcon() != null) {
                                obj = 1;
                                d(i2, this.ep.size());
                            }
                            obj4 = obj;
                            i5 = i2;
                        }
                        if (obj4 != null && hVar.getIcon() == null) {
                            hVar.setIcon(17170445);
                        }
                        this.ep.add(new f(hVar, (byte) 0));
                        obj2 = obj4;
                        i4 = i5;
                        i5 = i6;
                    }
                    i3++;
                    i2 = i4;
                    i = i5;
                    obj = obj2;
                }
                this.es = false;
            }
        }

        private void d(int i, int i2) {
            while (i < i2) {
                MenuItem menuItem = ((f) this.ep.get(i)).ev;
                if (menuItem.getIcon() == null) {
                    if (this.er == null) {
                        this.er = new ColorDrawable(0);
                    }
                    menuItem.setIcon(this.er);
                }
                i++;
            }
        }

        public final void d(android.support.v7.view.menu.h hVar) {
            if (this.eq != hVar && hVar.isCheckable()) {
                if (this.eq != null) {
                    this.eq.setChecked(false);
                }
                this.eq = hVar;
                hVar.setChecked(true);
            }
        }

        public final Bundle G() {
            Bundle bundle = new Bundle();
            if (this.eq != null) {
                bundle.putInt("android:menu:checked", this.eq.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.ep.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar = ((f) dVar).ev;
                    View actionView = hVar != null ? hVar.getActionView() : null;
                    if (actionView != null) {
                        SparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(hVar.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }
    }

    private static class c implements d {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    private static abstract class j extends t {
        public j(View view) {
            super(view);
        }
    }

    private static class a extends j {
        public a(View view) {
            super(view);
        }
    }

    public final void a(Context context, android.support.v7.view.menu.f fVar) {
        this.mLayoutInflater = LayoutInflater.from(context);
        this.eg = fVar;
        this.en = context.getResources().getDimensionPixelOffset(android.support.design.a.d.bf);
    }

    public final void h(boolean z) {
        if (this.eh != null) {
            android.support.v7.widget.RecyclerView.a aVar = this.eh;
            aVar.F();
            aVar.UR.notifyChanged();
        }
    }

    public final boolean a(p pVar) {
        return false;
    }

    public final void a(android.support.v7.view.menu.f fVar, boolean z) {
        if (this.ef != null) {
            this.ef.a(fVar, z);
        }
    }

    public final boolean E() {
        return false;
    }

    public final boolean b(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final boolean c(android.support.v7.view.menu.h hVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        if (this.ed != null) {
            SparseArray sparseArray = new SparseArray();
            this.ed.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        if (this.eh != null) {
            bundle.putBundle("android:menu:adapter", this.eh.G());
        }
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.ed.restoreHierarchyState(sparseParcelableArray);
        }
        Bundle bundle2 = bundle.getBundle("android:menu:adapter");
        if (bundle2 != null) {
            d dVar;
            b bVar = this.eh;
            int i = bundle2.getInt("android:menu:checked", 0);
            if (i != 0) {
                bVar.es = true;
                Iterator it = bVar.ep.iterator();
                while (it.hasNext()) {
                    dVar = (d) it.next();
                    if (dVar instanceof f) {
                        android.support.v7.view.menu.h hVar = ((f) dVar).ev;
                        if (hVar != null && hVar.getItemId() == i) {
                            bVar.d(hVar);
                            break;
                        }
                    }
                }
                bVar.es = false;
                bVar.F();
            }
            SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
            Iterator it2 = bVar.ep.iterator();
            while (it2.hasNext()) {
                dVar = (d) it2.next();
                if (dVar instanceof f) {
                    android.support.v7.view.menu.h hVar2 = ((f) dVar).ev;
                    View actionView = hVar2 != null ? hVar2.getActionView() : null;
                    if (actionView != null) {
                        actionView.restoreHierarchyState((SparseArray) sparseParcelableArray2.get(hVar2.getItemId()));
                    }
                }
            }
        }
    }

    public final void a(ColorStateList colorStateList) {
        this.ec = colorStateList;
        h(false);
    }

    public final void b(ColorStateList colorStateList) {
        this.ek = colorStateList;
        h(false);
    }

    public final void o(int i) {
        this.ei = i;
        this.ej = true;
        h(false);
    }

    public final void a(Drawable drawable) {
        this.el = drawable;
        h(false);
    }

    public final void i(boolean z) {
        if (this.eh != null) {
            this.eh.es = z;
        }
    }
}
