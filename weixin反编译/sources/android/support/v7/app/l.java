package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.v4.view.z;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
import android.support.v7.view.i;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.aq;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;
import java.util.ArrayList;

final class l extends ActionBar {
    u HT;
    boolean HU;
    Callback HV;
    private boolean HW;
    private boolean HX;
    private ArrayList<Object> HY = new ArrayList();
    e HZ;
    private final Runnable Ia = new Runnable() {
        public final void run() {
            f fVar;
            l lVar = l.this;
            Menu menu = lVar.getMenu();
            if (menu instanceof f) {
                fVar = (f) menu;
            } else {
                fVar = null;
            }
            if (fVar != null) {
                fVar.dx();
            }
            try {
                menu.clear();
                if (!(lVar.HV.onCreatePanelMenu(0, menu) && lVar.HV.onPreparePanel(0, null, menu))) {
                    menu.clear();
                }
                if (fVar != null) {
                    fVar.dy();
                }
            } catch (Throwable th) {
                if (fVar != null) {
                    fVar.dy();
                }
            }
        }
    };
    private final android.support.v7.widget.Toolbar.b Ib = new android.support.v7.widget.Toolbar.b() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            return l.this.HV.onMenuItemSelected(0, menuItem);
        }
    };

    private final class a implements android.support.v7.view.menu.l.a {
        private boolean Hk;

        private a() {
        }

        /* synthetic */ a(l lVar, byte b) {
            this();
        }

        public final boolean d(f fVar) {
            if (l.this.HV == null) {
                return false;
            }
            l.this.HV.onMenuOpened(108, fVar);
            return true;
        }

        public final void a(f fVar, boolean z) {
            if (!this.Hk) {
                this.Hk = true;
                l.this.HT.dismissPopupMenus();
                if (l.this.HV != null) {
                    l.this.HV.onPanelClosed(108, fVar);
                }
                this.Hk = false;
            }
        }
    }

    private final class b implements android.support.v7.view.menu.f.a {
        private b() {
        }

        /* synthetic */ b(l lVar, byte b) {
            this();
        }

        public final boolean a(f fVar, MenuItem menuItem) {
            return false;
        }

        public final void b(f fVar) {
            if (l.this.HV == null) {
                return;
            }
            if (l.this.HT.isOverflowMenuShowing()) {
                l.this.HV.onPanelClosed(108, fVar);
            } else if (l.this.HV.onPreparePanel(0, null, fVar)) {
                l.this.HV.onMenuOpened(108, fVar);
            }
        }
    }

    private final class c implements android.support.v7.view.menu.l.a {
        private c() {
        }

        /* synthetic */ c(l lVar, byte b) {
            this();
        }

        public final void a(f fVar, boolean z) {
            if (l.this.HV != null) {
                l.this.HV.onPanelClosed(0, fVar);
            }
        }

        public final boolean d(f fVar) {
            if (fVar == null && l.this.HV != null) {
                l.this.HV.onMenuOpened(0, fVar);
            }
            return true;
        }
    }

    private class d extends i {
        public d(Callback callback) {
            super(callback);
        }

        public final boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !l.this.HU) {
                l.this.HT.dX();
                l.this.HU = true;
            }
            return onPreparePanel;
        }

        public final View onCreatePanelView(int i) {
            switch (i) {
                case 0:
                    Menu menu = l.this.HT.getMenu();
                    if (onPreparePanel(i, null, menu) && onMenuOpened(i, menu)) {
                        l lVar = l.this;
                        if (lVar.HZ == null && (menu instanceof f)) {
                            f fVar = (f) menu;
                            Context context = lVar.HT.getContext();
                            TypedValue typedValue = new TypedValue();
                            Theme newTheme = context.getResources().newTheme();
                            newTheme.setTo(context.getTheme());
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarPopupTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            }
                            newTheme.resolveAttribute(android.support.v7.a.a.a.panelMenuListTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                newTheme.applyStyle(typedValue.resourceId, true);
                            } else {
                                newTheme.applyStyle(j.Theme_AppCompat_CompactMenu, true);
                            }
                            Context contextThemeWrapper = new ContextThemeWrapper(context, 0);
                            contextThemeWrapper.getTheme().setTo(newTheme);
                            lVar.HZ = new e(contextThemeWrapper, h.abc_list_menu_item_layout);
                            lVar.HZ.ef = new c(lVar, (byte) 0);
                            fVar.a(lVar.HZ);
                        }
                        if (menu == null || lVar.HZ == null) {
                            return null;
                        }
                        return lVar.HZ.getAdapter().getCount() > 0 ? (View) lVar.HZ.c(lVar.HT.eI()) : null;
                    }
                    break;
            }
            return super.onCreatePanelView(i);
        }
    }

    public l(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.HT = new aq(toolbar, false);
        this.HV = new d(callback);
        this.HT.b(this.HV);
        toolbar.ZT = this.Ib;
        this.HT.e(charSequence);
    }

    public final void setCustomView(View view) {
        LayoutParams layoutParams = new ActionBar.LayoutParams(-2, -2);
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.HT.setCustomView(view);
    }

    public final void setCustomView(int i) {
        setCustomView(LayoutInflater.from(this.HT.getContext()).inflate(i, this.HT.eI(), false));
    }

    public final void setIcon(int i) {
        this.HT.setIcon(i);
    }

    public final void setLogo(Drawable drawable) {
        this.HT.setLogo(drawable);
    }

    public final void setElevation(float f) {
        z.g(this.HT.eI(), f);
    }

    public final Context getThemedContext() {
        return this.HT.getContext();
    }

    public final void x(boolean z) {
    }

    public final void setHomeActionContentDescription(int i) {
        this.HT.setNavigationContentDescription(i);
    }

    public final void y(boolean z) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void e(CharSequence charSequence) {
        this.HT.e(charSequence);
    }

    public final boolean requestFocus() {
        ViewGroup eI = this.HT.eI();
        if (eI == null || eI.hasFocus()) {
            return false;
        }
        eI.requestFocus();
        return true;
    }

    public final void setDisplayOptions(int i) {
        setDisplayOptions(i, -1);
    }

    private void setDisplayOptions(int i, int i2) {
        this.HT.setDisplayOptions((this.HT.getDisplayOptions() & (i2 ^ -1)) | (i & i2));
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

    public final void setBackgroundDrawable(Drawable drawable) {
        this.HT.setBackgroundDrawable(drawable);
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

    public final int getHeight() {
        return this.HT.getHeight();
    }

    public final void show() {
        this.HT.setVisibility(0);
    }

    public final void hide() {
        this.HT.setVisibility(8);
    }

    public final boolean isShowing() {
        return this.HT.getVisibility() == 0;
    }

    public final boolean cR() {
        this.HT.eI().removeCallbacks(this.Ia);
        z.a(this.HT.eI(), this.Ia);
        return true;
    }

    public final boolean collapseActionView() {
        if (!this.HT.hasExpandedActionView()) {
            return false;
        }
        this.HT.collapseActionView();
        return true;
    }

    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu != null) {
            boolean z;
            if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                z = true;
            } else {
                z = false;
            }
            menu.setQwertyMode(z);
            menu.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    final void onDestroy() {
        this.HT.eI().removeCallbacks(this.Ia);
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

    final Menu getMenu() {
        if (!this.HW) {
            this.HT.a(new a(), new b());
            this.HW = true;
        }
        return this.HT.getMenu();
    }
}
