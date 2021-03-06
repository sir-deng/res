package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.d;
import android.support.v4.view.m;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class f implements android.support.v4.c.a.a {
    private static final int[] Le = new int[]{1, 4, 5, 3, 2, 0};
    private boolean Lf;
    private boolean Lg;
    public a Lh;
    private ArrayList<h> Li;
    private boolean Lj;
    public ArrayList<h> Lk;
    private ArrayList<h> Ll;
    private boolean Lm;
    public int Ln = 1;
    private ContextMenuInfo Lo;
    CharSequence Lp;
    Drawable Lq;
    View Lr;
    private boolean Ls = false;
    private boolean Lt = false;
    boolean Lu = false;
    private boolean Lv = false;
    private ArrayList<h> Lw = new ArrayList();
    public CopyOnWriteArrayList<WeakReference<l>> Lx = new CopyOnWriteArrayList();
    h Ly;
    public boolean Lz;
    ArrayList<h> ep;
    public final Context mContext;
    private final Resources mResources;

    public interface a {
        boolean a(f fVar, MenuItem menuItem);

        void b(f fVar);
    }

    public interface b {
        boolean f(h hVar);
    }

    public f(Context context) {
        boolean z = true;
        this.mContext = context;
        this.mResources = context.getResources();
        this.ep = new ArrayList();
        this.Li = new ArrayList();
        this.Lj = true;
        this.Lk = new ArrayList();
        this.Ll = new ArrayList();
        this.Lm = true;
        if (this.mResources.getConfiguration().keyboard == 1 || !this.mResources.getBoolean(android.support.v7.a.a.b.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z = false;
        }
        this.Lg = z;
    }

    public final void a(l lVar) {
        a(lVar, this.mContext);
    }

    public final void a(l lVar, Context context) {
        this.Lx.add(new WeakReference(lVar));
        lVar.a(context, this);
        this.Lm = true;
    }

    public final void b(l lVar) {
        Iterator it = this.Lx.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            l lVar2 = (l) weakReference.get();
            if (lVar2 == null || lVar2 == lVar) {
                this.Lx.remove(weakReference);
            }
        }
    }

    public final void dispatchSaveInstanceState(Bundle bundle) {
        if (!this.Lx.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator it = this.Lx.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Lx.remove(weakReference);
                } else {
                    int id = lVar.getId();
                    if (id > 0) {
                        Parcelable onSaveInstanceState = lVar.onSaveInstanceState();
                        if (onSaveInstanceState != null) {
                            sparseArray.put(id, onSaveInstanceState);
                        }
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        }
    }

    public final void c(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = m.a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (m.d(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((p) item.getSubMenu()).c(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(du(), sparseArray);
        }
    }

    public final void d(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(du());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = m.a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((p) item.getSubMenu()).d(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    m.b(item);
                }
            }
        }
    }

    protected String du() {
        return "android:menu:actionviewstates";
    }

    public void a(a aVar) {
        this.Lh = aVar;
    }

    public final MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4 = (-65536 & i3) >> 16;
        if (i4 < 0 || i4 >= Le.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i5 = (Le[i4] << 16) | (65535 & i3);
        MenuItem hVar = new h(this, i, i2, i3, i5, charSequence, this.Ln);
        if (this.Lo != null) {
            hVar.LK = this.Lo;
        }
        this.ep.add(a(this.ep, i5), hVar);
        j(true);
        return hVar;
    }

    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return a(0, 0, 0, this.mResources.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.mResources.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        SubMenu pVar = new p(this.mContext, this, hVar);
        hVar.b(pVar);
        return pVar;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.mResources.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        int i2;
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (((h) this.ep.get(i3)).getItemId() == i) {
                i2 = i3;
                break;
            }
        }
        i2 = -1;
        f(i2, true);
    }

    public void removeGroup(int i) {
        int i2;
        int size = size();
        for (i2 = 0; i2 < size; i2++) {
            if (((h) this.ep.get(i2)).getGroupId() == i) {
                size = i2;
                break;
            }
        }
        size = -1;
        if (size >= 0) {
            int size2 = this.ep.size() - size;
            int i3 = 0;
            while (true) {
                i2 = i3 + 1;
                if (i3 >= size2 || ((h) this.ep.get(size)).getGroupId() != i) {
                    j(true);
                } else {
                    f(size, false);
                    i3 = i2;
                }
            }
            j(true);
        }
    }

    private void f(int i, boolean z) {
        if (i >= 0 && i < this.ep.size()) {
            this.ep.remove(i);
            if (z) {
                j(true);
            }
        }
    }

    public void clear() {
        if (this.Ly != null) {
            h(this.Ly);
        }
        this.ep.clear();
        j(true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.ep.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.ep.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.F(z2);
                hVar.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.ep.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            h hVar = (h) this.ep.get(i2);
            if (hVar.getGroupId() == i && hVar.H(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            j(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.ep.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.ep.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.Lz) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((h) this.ep.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) this.ep.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu()) {
                MenuItem findItem = hVar.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int size() {
        return this.ep.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.ep.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.Lf = z;
        j(false);
    }

    boolean dv() {
        return this.Lf;
    }

    public boolean dw() {
        return this.Lg;
    }

    boolean b(f fVar, MenuItem menuItem) {
        return this.Lh != null && this.Lh.a(fVar, menuItem);
    }

    private static int a(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((h) arrayList.get(size)).Kq <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = a(a, null, i2);
        }
        if ((i2 & 2) != 0) {
            E(true);
        }
        return z;
    }

    private void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean dv = dv();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.ep.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = (h) this.ep.get(i2);
                if (hVar.hasSubMenu()) {
                    ((f) hVar.getSubMenu()).a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = dv ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (dv && alphabeticShortcut == 8 && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    private h a(int i, KeyEvent keyEvent) {
        List list = this.Lw;
        list.clear();
        a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (h) list.get(0);
        }
        boolean dv = dv();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = (h) list.get(i2);
            char alphabeticShortcut = dv ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return hVar;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return hVar;
            }
            if (dv && alphabeticShortcut == 8 && i == 67) {
                return hVar;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), null, i2);
    }

    public final boolean a(MenuItem menuItem, l lVar, int i) {
        boolean z = false;
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean z2;
        boolean dF = hVar.dF();
        d dVar = hVar.LH;
        if (dVar == null || !dVar.hasSubMenu()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean expandActionView;
        if (hVar.dM()) {
            expandActionView = hVar.expandActionView() | dF;
            if (!expandActionView) {
                return expandActionView;
            }
            E(true);
            return expandActionView;
        } else if (hVar.hasSubMenu() || z2) {
            E(false);
            if (!hVar.hasSubMenu()) {
                hVar.b(new p(this.mContext, this, hVar));
            }
            p pVar = (p) hVar.getSubMenu();
            if (z2) {
                dVar.onPrepareSubMenu(pVar);
            }
            if (!this.Lx.isEmpty()) {
                if (lVar != null) {
                    z = lVar.a(pVar);
                }
                Iterator it = this.Lx.iterator();
                boolean z3 = z;
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    l lVar2 = (l) weakReference.get();
                    if (lVar2 == null) {
                        this.Lx.remove(weakReference);
                    } else {
                        if (z3) {
                            z = z3;
                        } else {
                            z = lVar2.a(pVar);
                        }
                        z3 = z;
                    }
                }
                z = z3;
            }
            expandActionView = dF | r2;
            if (expandActionView) {
                return expandActionView;
            }
            E(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                E(true);
            }
            return dF;
        }
    }

    public final void E(boolean z) {
        if (!this.Lv) {
            this.Lv = true;
            Iterator it = this.Lx.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Lx.remove(weakReference);
                } else {
                    lVar.a(this, z);
                }
            }
            this.Lv = false;
        }
    }

    public void close() {
        E(true);
    }

    public void j(boolean z) {
        if (this.Ls) {
            this.Lt = true;
            return;
        }
        if (z) {
            this.Lj = true;
            this.Lm = true;
        }
        if (!this.Lx.isEmpty()) {
            dx();
            Iterator it = this.Lx.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Lx.remove(weakReference);
                } else {
                    lVar.h(z);
                }
            }
            dy();
        }
    }

    public final void dx() {
        if (!this.Ls) {
            this.Ls = true;
            this.Lt = false;
        }
    }

    public final void dy() {
        this.Ls = false;
        if (this.Lt) {
            this.Lt = false;
            j(true);
        }
    }

    final void dz() {
        this.Lj = true;
        j(true);
    }

    final void dA() {
        this.Lm = true;
        j(true);
    }

    public final ArrayList<h> dB() {
        if (!this.Lj) {
            return this.Li;
        }
        this.Li.clear();
        int size = this.ep.size();
        for (int i = 0; i < size; i++) {
            h hVar = (h) this.ep.get(i);
            if (hVar.isVisible()) {
                this.Li.add(hVar);
            }
        }
        this.Lj = false;
        this.Lm = true;
        return this.Li;
    }

    public final void dC() {
        ArrayList dB = dB();
        if (this.Lm) {
            Iterator it = this.Lx.iterator();
            int i = 0;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Lx.remove(weakReference);
                } else {
                    i = lVar.E() | i;
                }
            }
            if (i != 0) {
                this.Lk.clear();
                this.Ll.clear();
                i = dB.size();
                for (int i2 = 0; i2 < i; i2++) {
                    h hVar = (h) dB.get(i2);
                    if (hVar.dJ()) {
                        this.Lk.add(hVar);
                    } else {
                        this.Ll.add(hVar);
                    }
                }
            } else {
                this.Lk.clear();
                this.Ll.clear();
                this.Ll.addAll(dB());
            }
            this.Lm = false;
        }
    }

    public final ArrayList<h> dD() {
        dC();
        return this.Ll;
    }

    public void clearHeader() {
        this.Lq = null;
        this.Lp = null;
        this.Lr = null;
        j(false);
    }

    final void a(CharSequence charSequence, Drawable drawable, View view) {
        if (view != null) {
            this.Lr = view;
            this.Lp = null;
            this.Lq = null;
        } else {
            if (charSequence != null) {
                this.Lp = charSequence;
            }
            if (drawable != null) {
                this.Lq = drawable;
            }
            this.Lr = null;
        }
        j(false);
    }

    protected final f g(CharSequence charSequence) {
        a(charSequence, null, null);
        return this;
    }

    protected final f l(Drawable drawable) {
        a(null, drawable, null);
        return this;
    }

    public f dE() {
        return this;
    }

    public boolean g(h hVar) {
        boolean z = false;
        if (!this.Lx.isEmpty()) {
            dx();
            Iterator it = this.Lx.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Lx.remove(weakReference);
                } else {
                    z = lVar.b(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dy();
            if (z) {
                this.Ly = hVar;
            }
        }
        return z;
    }

    public boolean h(h hVar) {
        boolean z = false;
        if (!this.Lx.isEmpty() && this.Ly == hVar) {
            dx();
            Iterator it = this.Lx.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                l lVar = (l) weakReference.get();
                if (lVar == null) {
                    this.Lx.remove(weakReference);
                } else {
                    z = lVar.c(hVar);
                    if (z) {
                        break;
                    }
                    z2 = z;
                }
            }
            z = z2;
            dy();
            if (z) {
                this.Ly = null;
            }
        }
        return z;
    }
}
