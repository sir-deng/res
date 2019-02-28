package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.p;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity extends MMFragmentActivity {
    private static String xQX;
    String className;
    public a jCj = null;
    public p mController = new p() {
        protected final int getLayoutId() {
            return MMActivity.this.getLayoutId();
        }

        protected final void dealContentView(View view) {
            MMActivity.this.dealContentView(view);
        }

        protected final String getIdentString() {
            return MMActivity.this.getIdentString();
        }

        protected final View getLayoutView() {
            return MMActivity.getLayoutView();
        }

        public final void onKeyboardStateChanged() {
            MMActivity.this.onKeyboardStateChanged();
        }

        protected final void onCreateBeforeSetContentView() {
            MMActivity.this.onCreateBeforeSetContentView();
        }

        protected final String getClassName() {
            return MMActivity.this.getClass().getName();
        }

        protected final boolean cnD() {
            return MMActivity.this.cnD();
        }

        public final boolean noActionBar() {
            return MMActivity.this.noActionBar();
        }

        public final boolean needShowIdcError() {
            return MMActivity.this.needShowIdcError();
        }
    };
    public boolean xQT = false;
    private ViewGroup xQU = null;
    public boolean xQV = false;
    private View xQW;
    private long xQY = 0;
    private long xQZ = 0;
    private long xRa = 0;

    public interface a {
        void b(int i, int i2, Intent intent);
    }

    public abstract int getLayoutId();

    @Deprecated
    public void initView() {
    }

    public final void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public static Locale initLanguage(Context context) {
        return p.initLanguage(context);
    }

    public void onCreateBeforeSetContentView() {
    }

    public boolean cnD() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.a(getBaseContext(), (ActionBarActivity) this);
        x.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bi.fc(this));
        initNavigationSwipeBack();
    }

    public void dealContentView(View view) {
        setContentView(view);
    }

    public boolean noActionBar() {
        return false;
    }

    public void onKeyboardStateChanged() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    public void uV(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }

    public void onSwipeBack() {
        if (!alr()) {
            this.mController.callBackMenu();
        }
        super.onSwipeBack();
    }

    public void initSwipeBack() {
        super.initSwipeBack();
        if (getSwipeBackLayout() != null && getSwipeBackLayout().getChildCount() > 0) {
            View childAt = getSwipeBackLayout().getChildAt(0);
            getSwipeBackLayout().removeView(childAt);
            this.xQU = new FrameLayout(this);
            this.xQU.addView(childAt, new LayoutParams(-1, -1));
            getSwipeBackLayout().addView(this.xQU);
            getSwipeBackLayout().Iv = this.xQU;
        }
    }

    public boolean alr() {
        return false;
    }

    public int getForceOrientation() {
        return -1;
    }

    public void afw() {
        if (getForceOrientation() == -1) {
            this.xQT = getSharedPreferences(ad.cgf(), 0).getBoolean("settings_landscape_mode", false);
            if (this.xQT) {
                setRequestedOrientation(-1);
                return;
            } else {
                setRequestedOrientation(1);
                return;
            }
        }
        setRequestedOrientation(getForceOrientation());
    }

    public void onStart() {
        afw();
        super.onStart();
    }

    @TargetApi(17)
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.mController.onKeyUp(i, keyEvent)) {
            return z;
        }
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMActivity", e, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
            return z;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean needShowIdcError() {
        return true;
    }

    public void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        ad.aZ(1, this.className);
        super.onResume();
        x.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        x.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(hashCode()));
        if (this.xQZ > this.xQY) {
            this.xRa += this.xQZ - this.xQY;
        }
        this.xQY = bi.Wz();
        this.xQZ = 0;
    }

    public final void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public final ActionBarActivity cnE() {
        return this.mController.xRr;
    }

    public void onDestroy() {
        x.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s ", getClass().getSimpleName(), Integer.valueOf(hashCode()), bi.fc(this));
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.a.dd(this.mController.contentView);
        com.tencent.mm.sdk.platformtools.a.eG(this.mController.xRr);
        this.mController.onDestroy();
        this.xQV = true;
    }

    public static void cnF() {
        p.cnF();
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        ad.aZ(2, this.className);
        super.onPause();
        this.mController.onPause();
        boolean isFinishing = isFinishing();
        x.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(isFinishing), Integer.valueOf(hashCode()));
        this.xQZ = bi.Wz();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.mController.onCreateOptionsMenu(menu)) {
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public String getIdentString() {
        return "";
    }

    protected static View getLayoutView() {
        return null;
    }

    public final void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public final void setTitleVisibility(int i) {
        this.mController.setTitleVisibility(i);
    }

    public void oj(int i) {
        p pVar = this.mController;
        if (pVar.mActionBar != null) {
            pVar.xRy.setTextColor(i);
        }
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public final void P(CharSequence charSequence) {
        this.mController.P(charSequence);
    }

    public void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public final void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    public final void Ei(int i) {
        this.mController.xRy.setVisibility(i);
    }

    public final void Ej(int i) {
        this.mController.setTitleLogo(0, i);
    }

    public final void cnG() {
        p pVar = this.mController;
        if (pVar.xRx != null) {
            pVar.xRx.setVisibility(8);
        }
    }

    public final void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public final void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public final void enableOptionMenu(boolean z) {
        this.mController.a(true, -1, z);
    }

    public final void enableOptionMenu(int i, boolean z) {
        this.mController.a(false, i, z);
    }

    public final void showOptionMenu(boolean z) {
        this.mController.b(true, -1, z);
    }

    public final void showOptionMenu(int i, boolean z) {
        this.mController.b(false, i, z);
    }

    public final boolean cnH() {
        Iterator it = this.mController.xRu.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.p.a aVar = (com.tencent.mm.ui.p.a) it.next();
            if (aVar.xRW == 0) {
                return aVar.frK;
            }
        }
        return false;
    }

    public final boolean cnI() {
        Iterator it = this.mController.xRu.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ui.p.a aVar = (com.tencent.mm.ui.p.a) it.next();
            if (aVar.xRW == 0) {
                return aVar.visible;
            }
        }
        return false;
    }

    public final void a(p pVar) {
        this.mController.addSearchMenu(true, pVar);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, int i2) {
        this.mController.addTextOptionMenu$7df2a0ca(i, str, onMenuItemClickListener, null, i2);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.a(i, str, drawable, onMenuItemClickListener);
    }

    public final void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    public final void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    public final void a(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.updateOptionMenuListener(1, onMenuItemClickListener, null);
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public final void cnJ() {
        p pVar = this.mController;
        if (pVar.xRA != null) {
            pVar.xRA.setColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP);
        }
    }

    public final void mc(boolean z) {
        p pVar = this.mController;
        if (pVar.xRA == null) {
            return;
        }
        if (z) {
            pVar.xRA.setVisibility(0);
        } else {
            pVar.xRA.setVisibility(8);
        }
    }

    public final boolean removeOptionMenu(int i) {
        return this.mController.removeOptionMenu(i);
    }

    public final void setTitleMuteIconVisibility(int i) {
        this.mController.setTitleMuteIconVisibility(i);
    }

    public void aWY() {
        this.mController.hideVKB();
    }

    public final void df(View view) {
        this.mController.hideVKB(view);
    }

    public void showVKB() {
        this.mController.showVKB();
    }

    public static void showVKB(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }

    public void finish() {
        super.finish();
        int a = t.a(getIntent(), u.FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int a2 = t.a(getIntent(), u.FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (a != -1) {
            super.overridePendingTransition(a, a2);
        }
    }

    public final void G(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void a(Class<?> cls, Intent intent) {
        intent.setClass(this, cls);
        startActivity(intent);
    }

    public final void b(a aVar, Intent intent, int i) {
        this.jCj = aVar;
        startActivityForResult(intent, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jCj != null) {
            this.jCj.b(i, i2, intent);
        }
        this.jCj = null;
    }

    public final void cnK() {
        p pVar = this.mController;
        pVar.xRB.setVisibility(0);
        pVar.xRA.setVisibility(8);
        pVar.xRz.setVisibility(8);
    }

    public final void cnL() {
        p pVar = this.mController;
        if (pVar.mContext != null) {
            pVar.V(pVar.xRr);
        }
    }

    public final void cnM() {
        int i = 0;
        if (ft(this.mController.xRr)) {
            int i2;
            if (this.xQW == null) {
                this.xQW = new View(this.mController.xRr);
                ((ViewGroup) getWindow().getDecorView()).addView(this.xQW);
            }
            Context context = this.mController.xRr;
            Resources resources = context.getResources();
            if (resources.getConfiguration().orientation == 1) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (VERSION.SDK_INT >= 14 && ft(context)) {
                i2 = resources.getIdentifier(i2 != 0 ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
                if (i2 > 0) {
                    i = resources.getDimensionPixelSize(i2);
                }
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, i);
            layoutParams.gravity = 80;
            this.xQW.setLayoutParams(layoutParams);
            this.xQW.setBackgroundColor(-637534208);
            this.xQW.setVisibility(8);
            return;
        }
        x.w("MicroMsg.MMActivity", "has not NavigationBar!");
    }

    public final void Ek(int i) {
        if (this.xQW != null) {
            this.xQW.setVisibility(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                xQX = (String) declaredMethod.invoke(null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable th) {
                xQX = null;
            }
        }
    }

    public static boolean ft(Context context) {
        Resources resources = context.getResources();
        boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            if ("1".equals(xQX)) {
                z = false;
            } else if ("0".equals(xQX)) {
                z = true;
            }
            if (!z || deviceHasKey || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                return false;
            }
            return true;
        } else if (ViewConfiguration.get(context).hasPermanentMenuKey() || deviceHasKey) {
            return false;
        } else {
            return true;
        }
    }

    public final long cnN() {
        long j;
        if (this.xQZ != 0) {
            j = (this.xQZ - this.xQY) + this.xRa;
        } else {
            j = (bi.Wz() - this.xQY) + this.xRa;
        }
        if (j < 0) {
            x.w("MicroMsg.MMActivity", "%d get activity browse time is error, may be something warn here.[%d %d %d %d]", Integer.valueOf(hashCode()), Long.valueOf(j), Long.valueOf(this.xQY), Long.valueOf(this.xQZ), Long.valueOf(this.xRa));
        }
        x.v("MicroMsg.MMActivity", "%d get activity browse time [%d]", Integer.valueOf(hashCode()), Long.valueOf(j));
        return j;
    }
}
