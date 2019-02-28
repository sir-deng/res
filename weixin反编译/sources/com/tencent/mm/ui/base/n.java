package com.tencent.mm.ui.base;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class n implements ContextMenu {
    public CharSequence Lp;
    public List<MenuItem> ykH = new ArrayList();

    public final boolean cqg() {
        return this.ykH.size() == 0;
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        MenuItem oVar = new o(i2, i);
        oVar.setTitle(i4);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        MenuItem oVar = new o(i2, i);
        oVar.setTitle(charSequence);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem add(int i) {
        MenuItem oVar = new o(0, 0);
        oVar.setTitle(i);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem add(CharSequence charSequence) {
        MenuItem oVar = new o(0, 0);
        oVar.setTitle(charSequence);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem aj(int i, int i2, int i3) {
        MenuItem oVar = new o(i, 0);
        oVar.setTitle(i2);
        oVar.setIcon(i3);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2, Drawable drawable, boolean z) {
        MenuItem oVar = new o(i, 0);
        oVar.setTitle(charSequence);
        oVar.qkf = charSequence2;
        oVar.setIcon(drawable);
        oVar.wXJ = z;
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, CharSequence charSequence2) {
        MenuItem oVar = new o(i, 0);
        oVar.setTitle(charSequence);
        oVar.qkf = charSequence2;
        oVar.setIcon(0);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem eT(int i, int i2) {
        MenuItem oVar = new o(i, 0);
        oVar.setTitle(i2);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem f(int i, CharSequence charSequence) {
        MenuItem oVar = new o(i, 0);
        oVar.setTitle(charSequence);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem a(int i, CharSequence charSequence, int i2) {
        MenuItem oVar = new o(i, 0);
        oVar.setTitle(charSequence);
        oVar.setIcon(i2);
        this.ykH.add(oVar);
        return oVar;
    }

    public final MenuItem a(int i, int i2, CharSequence charSequence) {
        MenuItem oVar = new o(i, 0);
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i2), 0, spannableString.length(), 0);
        oVar.setTitle(spannableString);
        this.ykH.add(oVar);
        return oVar;
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return null;
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return null;
    }

    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        return 0;
    }

    public final void removeItem(int i) {
        Collection arrayList = new ArrayList();
        for (MenuItem menuItem : this.ykH) {
            if (menuItem.getItemId() == i) {
                arrayList.add(menuItem);
            }
        }
        this.ykH.removeAll(arrayList);
    }

    public final void removeGroup(int i) {
    }

    public final void clear() {
        for (MenuItem menuItem : this.ykH) {
            ((o) menuItem).ykK = null;
            ((o) menuItem).setOnMenuItemClickListener(null);
        }
        this.ykH.clear();
        this.Lp = null;
    }

    public final void setGroupCheckable(int i, boolean z, boolean z2) {
    }

    public final void setGroupVisible(int i, boolean z) {
    }

    public final void setGroupEnabled(int i, boolean z) {
    }

    public final boolean hasVisibleItems() {
        return false;
    }

    public final MenuItem findItem(int i) {
        for (MenuItem menuItem : this.ykH) {
            if (menuItem.getItemId() == i) {
                return menuItem;
            }
        }
        return null;
    }

    public final int size() {
        return this.ykH == null ? 0 : this.ykH.size();
    }

    public final MenuItem getItem(int i) {
        return (MenuItem) this.ykH.get(i);
    }

    public final void close() {
    }

    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return false;
    }

    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean performIdentifierAction(int i, int i2) {
        return false;
    }

    public final void setQwertyMode(boolean z) {
    }

    public final ContextMenu setHeaderTitle(int i) {
        if (i > 0) {
            return setHeaderTitle(ad.getContext().getString(i));
        }
        return this;
    }

    public final ContextMenu setHeaderTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.Lp = charSequence;
        }
        return this;
    }

    public final ContextMenu setHeaderIcon(int i) {
        return this;
    }

    public final ContextMenu setHeaderIcon(Drawable drawable) {
        return this;
    }

    public final ContextMenu setHeaderView(View view) {
        return this;
    }

    public final void clearHeader() {
    }
}
