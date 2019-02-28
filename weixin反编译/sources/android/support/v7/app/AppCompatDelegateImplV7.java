package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.v;
import android.support.v4.view.ae;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.ap;
import android.support.v4.view.k;
import android.support.v4.view.z;
import android.support.v4.widget.m;
import android.support.v7.view.menu.e;
import android.support.v7.view.menu.f;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.at;
import android.support.v7.widget.h;
import android.support.v7.widget.t;
import android.support.v7.widget.x;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

class AppCompatDelegateImplV7 extends f implements k, android.support.v7.view.menu.f.a {
    private TextView FN;
    private t GX;
    private a GY;
    private d GZ;
    android.support.v7.view.b Ha;
    ActionBarContextView Hb;
    PopupWindow Hc;
    Runnable Hd;
    ai He = null;
    private boolean Hf;
    private ViewGroup Hg;
    private View Hh;
    private boolean Hi;
    private boolean Hj;
    private boolean Hk;
    private PanelFeatureState[] Hl;
    private PanelFeatureState Hm;
    private boolean Hn;
    private boolean Ho;
    private int Hp;
    private final Runnable Hq = new Runnable() {
        public final void run() {
            if ((AppCompatDelegateImplV7.this.Hp & 1) != 0) {
                AppCompatDelegateImplV7.a(AppCompatDelegateImplV7.this, 0);
            }
            if ((AppCompatDelegateImplV7.this.Hp & Downloads.RECV_BUFFER_SIZE) != 0) {
                AppCompatDelegateImplV7.a(AppCompatDelegateImplV7.this, 108);
            }
            AppCompatDelegateImplV7.this.Ho = false;
            AppCompatDelegateImplV7.this.Hp = 0;
        }
    };
    private boolean Hr;
    private k Hs;
    private Rect hl;
    private Rect hm;

    private static final class PanelFeatureState {
        boolean Ec;
        View HA;
        f HB;
        e HC;
        Context HD;
        boolean HE;
        boolean HF;
        public boolean HG;
        boolean HH = false;
        boolean HI;
        Bundle HJ;
        int Hx;
        ViewGroup Hy;
        View Hz;
        int background;
        int gravity;
        int windowAnimations;
        int x;
        int y;

        private static class SavedState implements Parcelable {
            public static final Creator<SavedState> CREATOR = android.support.v4.os.b.a(new android.support.v4.os.c<SavedState>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new SavedState[i];
                }
            });
            boolean Ec;
            int Hx;
            Bundle ja;

            private SavedState() {
            }

            static /* synthetic */ SavedState a(Parcel parcel, ClassLoader classLoader) {
                boolean z = true;
                SavedState savedState = new SavedState();
                savedState.Hx = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                savedState.Ec = z;
                if (savedState.Ec) {
                    savedState.ja = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.Hx);
                parcel.writeInt(this.Ec ? 1 : 0);
                if (this.Ec) {
                    parcel.writeBundle(this.ja);
                }
            }
        }

        PanelFeatureState(int i) {
            this.Hx = i;
        }

        final void e(f fVar) {
            if (fVar != this.HB) {
                if (this.HB != null) {
                    this.HB.b(this.HC);
                }
                this.HB = fVar;
                if (fVar != null && this.HC != null) {
                    fVar.a(this.HC);
                }
            }
        }
    }

    private final class a implements android.support.v7.view.menu.l.a {
        private a() {
        }

        /* synthetic */ a(AppCompatDelegateImplV7 appCompatDelegateImplV7, byte b) {
            this();
        }

        public final boolean d(f fVar) {
            Callback callback = AppCompatDelegateImplV7.this.Ft.getCallback();
            if (callback != null) {
                callback.onMenuOpened(108, fVar);
            }
            return true;
        }

        public final void a(f fVar, boolean z) {
            AppCompatDelegateImplV7.this.c(fVar);
        }
    }

    class b implements android.support.v7.view.b.a {
        private android.support.v7.view.b.a Hv;

        public b(android.support.v7.view.b.a aVar) {
            this.Hv = aVar;
        }

        public final boolean a(android.support.v7.view.b bVar, Menu menu) {
            return this.Hv.a(bVar, menu);
        }

        public final boolean b(android.support.v7.view.b bVar, Menu menu) {
            return this.Hv.b(bVar, menu);
        }

        public final boolean a(android.support.v7.view.b bVar, MenuItem menuItem) {
            return this.Hv.a(bVar, menuItem);
        }

        public final void a(android.support.v7.view.b bVar) {
            this.Hv.a(bVar);
            if (AppCompatDelegateImplV7.this.Hc != null) {
                AppCompatDelegateImplV7.this.Ft.getDecorView().removeCallbacks(AppCompatDelegateImplV7.this.Hd);
            }
            if (AppCompatDelegateImplV7.this.Hb != null) {
                AppCompatDelegateImplV7.this.cZ();
                AppCompatDelegateImplV7.this.He = z.U(AppCompatDelegateImplV7.this.Hb).q(0.0f);
                AppCompatDelegateImplV7.this.He.a(new an() {
                    public final void q(View view) {
                        AppCompatDelegateImplV7.this.Hb.setVisibility(8);
                        if (AppCompatDelegateImplV7.this.Hc != null) {
                            AppCompatDelegateImplV7.this.Hc.dismiss();
                        } else if (AppCompatDelegateImplV7.this.Hb.getParent() instanceof View) {
                            z.Y((View) AppCompatDelegateImplV7.this.Hb.getParent());
                        }
                        AppCompatDelegateImplV7.this.Hb.removeAllViews();
                        AppCompatDelegateImplV7.this.He.a(null);
                        AppCompatDelegateImplV7.this.He = null;
                    }
                });
            }
            if (AppCompatDelegateImplV7.this.GI != null) {
                AppCompatDelegateImplV7.this.GI.onSupportActionModeFinished(AppCompatDelegateImplV7.this.Ha);
            }
            AppCompatDelegateImplV7.this.Ha = null;
        }
    }

    private class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImplV7.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                boolean z = x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
                if (z) {
                    AppCompatDelegateImplV7.this.a(AppCompatDelegateImplV7.this.aD(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(h.ez().a(getContext(), i, false));
        }
    }

    private final class d implements android.support.v7.view.menu.l.a {
        private d() {
        }

        /* synthetic */ d(AppCompatDelegateImplV7 appCompatDelegateImplV7, byte b) {
            this();
        }

        public final void a(f fVar, boolean z) {
            Menu fVar2;
            Menu dE = fVar2.dE();
            boolean z2 = dE != fVar2;
            AppCompatDelegateImplV7 appCompatDelegateImplV7 = AppCompatDelegateImplV7.this;
            if (z2) {
                fVar2 = dE;
            }
            PanelFeatureState a = appCompatDelegateImplV7.a(fVar2);
            if (a == null) {
                return;
            }
            if (z2) {
                AppCompatDelegateImplV7.this.a(a.Hx, a, dE);
                AppCompatDelegateImplV7.this.a(a, true);
                return;
            }
            AppCompatDelegateImplV7.this.a(a, z);
        }

        public final boolean d(f fVar) {
            if (fVar == null && AppCompatDelegateImplV7.this.GJ) {
                Callback callback = AppCompatDelegateImplV7.this.Ft.getCallback();
                if (!(callback == null || AppCompatDelegateImplV7.this.GO)) {
                    callback.onMenuOpened(108, fVar);
                }
            }
            return true;
        }
    }

    static /* synthetic */ void a(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        PanelFeatureState aD = appCompatDelegateImplV7.aD(i);
        if (aD.HB != null) {
            Bundle bundle = new Bundle();
            aD.HB.c(bundle);
            if (bundle.size() > 0) {
                aD.HJ = bundle;
            }
            aD.HB.dx();
            aD.HB.clear();
        }
        aD.HI = true;
        aD.HH = true;
        if ((i == 108 || i == 0) && appCompatDelegateImplV7.GX != null) {
            aD = appCompatDelegateImplV7.aD(0);
            if (aD != null) {
                aD.HE = false;
                appCompatDelegateImplV7.b(aD, null);
            }
        }
    }

    static /* synthetic */ int b(AppCompatDelegateImplV7 appCompatDelegateImplV7, int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (appCompatDelegateImplV7.Hb == null || !(appCompatDelegateImplV7.Hb.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) appCompatDelegateImplV7.Hb.getLayoutParams();
            if (appCompatDelegateImplV7.Hb.isShown()) {
                if (appCompatDelegateImplV7.hl == null) {
                    appCompatDelegateImplV7.hl = new Rect();
                    appCompatDelegateImplV7.hm = new Rect();
                }
                Rect rect = appCompatDelegateImplV7.hl;
                Rect rect2 = appCompatDelegateImplV7.hm;
                rect.set(0, i, 0, 0);
                at.a(appCompatDelegateImplV7.Hg, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (appCompatDelegateImplV7.Hh == null) {
                        appCompatDelegateImplV7.Hh = new View(appCompatDelegateImplV7.mContext);
                        appCompatDelegateImplV7.Hh.setBackgroundColor(appCompatDelegateImplV7.mContext.getResources().getColor(android.support.v7.a.a.c.abc_input_method_navigation_guard));
                        appCompatDelegateImplV7.Hg.addView(appCompatDelegateImplV7.Hh, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = appCompatDelegateImplV7.Hh.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            appCompatDelegateImplV7.Hh.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (appCompatDelegateImplV7.Hh == null) {
                    i3 = 0;
                }
                if (!(appCompatDelegateImplV7.GL || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                appCompatDelegateImplV7.Hb.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (appCompatDelegateImplV7.Hh != null) {
            View view = appCompatDelegateImplV7.Hh;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    static /* synthetic */ void d(AppCompatDelegateImplV7 appCompatDelegateImplV7) {
        if (appCompatDelegateImplV7.GX != null) {
            appCompatDelegateImplV7.GX.dY();
        }
        if (appCompatDelegateImplV7.Hc != null) {
            appCompatDelegateImplV7.Ft.getDecorView().removeCallbacks(appCompatDelegateImplV7.Hd);
            if (appCompatDelegateImplV7.Hc.isShowing()) {
                try {
                    appCompatDelegateImplV7.Hc.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            appCompatDelegateImplV7.Hc = null;
        }
        appCompatDelegateImplV7.cZ();
        PanelFeatureState aD = appCompatDelegateImplV7.aD(0);
        if (aD != null && aD.HB != null) {
            aD.HB.close();
        }
    }

    AppCompatDelegateImplV7(Context context, Window window, d dVar) {
        super(context, window, dVar);
    }

    public void onCreate(Bundle bundle) {
        if ((this.GG instanceof Activity) && v.b((Activity) this.GG) != null) {
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null) {
                this.Hr = true;
            } else {
                actionBar.x(true);
            }
        }
    }

    public final void cS() {
        cY();
    }

    public final void cW() {
        cY();
        if (this.GJ && this.mActionBar == null) {
            if (this.GG instanceof Activity) {
                this.mActionBar = new o((Activity) this.GG, this.GK);
            } else if (this.GG instanceof Dialog) {
                this.mActionBar = new o((Dialog) this.GG);
            }
            if (this.mActionBar != null) {
                this.mActionBar.x(this.Hr);
            }
        }
    }

    public final void setSupportActionBar(Toolbar toolbar) {
        if (this.GG instanceof Activity) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar instanceof o) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.iY = null;
            if (supportActionBar != null) {
                supportActionBar.onDestroy();
            }
            if (toolbar != null) {
                ActionBar lVar = new l(toolbar, ((Activity) this.mContext).getTitle(), this.GH);
                this.mActionBar = lVar;
                this.Ft.setCallback(lVar.HV);
            } else {
                this.mActionBar = null;
                this.Ft.setCallback(this.GH);
            }
            invalidateOptionsMenu();
        }
    }

    public final View findViewById(int i) {
        cY();
        return this.Ft.findViewById(i);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        if (this.GJ && this.Hf) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.onConfigurationChanged(configuration);
            }
        }
        cU();
    }

    public final void onStop() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.y(false);
        }
    }

    public final void onPostResume() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.y(true);
        }
    }

    public final void setContentView(View view) {
        cY();
        ViewGroup viewGroup = (ViewGroup) this.Hg.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.GG.onContentChanged();
    }

    public final void setContentView(int i) {
        cY();
        ViewGroup viewGroup = (ViewGroup) this.Hg.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.GG.onContentChanged();
    }

    public final void setContentView(View view, LayoutParams layoutParams) {
        cY();
        ViewGroup viewGroup = (ViewGroup) this.Hg.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.GG.onContentChanged();
    }

    public final void addContentView(View view, LayoutParams layoutParams) {
        cY();
        ((ViewGroup) this.Hg.findViewById(16908290)).addView(view, layoutParams);
        this.GG.onContentChanged();
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.mActionBar != null) {
            this.mActionBar.onDestroy();
        }
    }

    private void cY() {
        if (!this.Hf) {
            TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
            if (obtainStyledAttributes.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowActionBar)) {
                View view;
                View view2;
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowNoTitle, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionBar, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionBarOverlay, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_windowActionModeOverlay, false)) {
                    requestWindowFeature(10);
                }
                this.GM = obtainStyledAttributes.getBoolean(android.support.v7.a.a.k.AppCompatTheme_android_windowIsFloating, false);
                obtainStyledAttributes.recycle();
                this.Ft.getDecorView();
                LayoutInflater from = LayoutInflater.from(this.mContext);
                View view3;
                if (this.GN) {
                    view = this.GL ? (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_screen_simple, null);
                    if (VERSION.SDK_INT >= 21) {
                        z.b(view, new android.support.v4.view.t() {
                            public final ap a(View view, ap apVar) {
                                int systemWindowInsetTop = apVar.getSystemWindowInsetTop();
                                int b = AppCompatDelegateImplV7.b(AppCompatDelegateImplV7.this, systemWindowInsetTop);
                                if (systemWindowInsetTop != b) {
                                    apVar = apVar.e(apVar.getSystemWindowInsetLeft(), b, apVar.getSystemWindowInsetRight(), apVar.getSystemWindowInsetBottom());
                                }
                                return z.a(view, apVar);
                            }
                        });
                        view2 = view;
                    } else {
                        ((x) view).a(new android.support.v7.widget.x.a() {
                            public final void d(Rect rect) {
                                rect.top = AppCompatDelegateImplV7.b(AppCompatDelegateImplV7.this, rect.top);
                            }
                        });
                        view2 = view;
                    }
                } else if (this.GM) {
                    view3 = (ViewGroup) from.inflate(android.support.v7.a.a.h.abc_dialog_title_material, null);
                    this.GK = false;
                    this.GJ = false;
                    view2 = view3;
                } else if (this.GJ) {
                    TypedValue typedValue = new TypedValue();
                    this.mContext.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    view3 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new android.support.v7.view.d(this.mContext, typedValue.resourceId) : this.mContext).inflate(android.support.v7.a.a.h.abc_screen_toolbar, null);
                    this.GX = (t) view3.findViewById(android.support.v7.a.a.f.decor_content_parent);
                    this.GX.b(this.Ft.getCallback());
                    if (this.GK) {
                        this.GX.aH(109);
                    }
                    if (this.Hi) {
                        this.GX.aH(2);
                    }
                    if (this.Hj) {
                        this.GX.aH(5);
                    }
                    view2 = view3;
                } else {
                    view2 = null;
                }
                if (view2 == null) {
                    throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.GJ + ", windowActionBarOverlay: " + this.GK + ", android:windowIsFloating: " + this.GM + ", windowActionModeOverlay: " + this.GL + ", windowNoTitle: " + this.GN + " }");
                }
                if (this.GX == null) {
                    this.FN = (TextView) view2.findViewById(android.support.v7.a.a.f.title);
                }
                at.bw(view2);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view2.findViewById(android.support.v7.a.a.f.action_bar_activity_content);
                ViewGroup viewGroup = (ViewGroup) this.Ft.findViewById(16908290);
                if (viewGroup != null) {
                    while (viewGroup.getChildCount() > 0) {
                        View childAt = viewGroup.getChildAt(0);
                        viewGroup.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup instanceof FrameLayout) {
                        ((FrameLayout) viewGroup).setForeground(null);
                    }
                }
                this.Ft.setContentView(view2);
                contentFrameLayout.QN = new android.support.v7.widget.ContentFrameLayout.a() {
                    public final void onDetachedFromWindow() {
                        AppCompatDelegateImplV7.d(AppCompatDelegateImplV7.this);
                    }
                };
                this.Hg = view2;
                CharSequence title = this.GG instanceof Activity ? ((Activity) this.GG).getTitle() : this.uU;
                if (!TextUtils.isEmpty(title)) {
                    f(title);
                }
                contentFrameLayout = (ContentFrameLayout) this.Hg.findViewById(16908290);
                view = this.Ft.getDecorView();
                contentFrameLayout.QM.set(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                if (z.ai(contentFrameLayout)) {
                    contentFrameLayout.requestLayout();
                }
                TypedArray obtainStyledAttributes2 = this.mContext.obtainStyledAttributes(android.support.v7.a.a.k.AppCompatTheme);
                int i = android.support.v7.a.a.k.AppCompatTheme_windowMinWidthMajor;
                if (contentFrameLayout.QG == null) {
                    contentFrameLayout.QG = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout.QG);
                i = android.support.v7.a.a.k.AppCompatTheme_windowMinWidthMinor;
                if (contentFrameLayout.QH == null) {
                    contentFrameLayout.QH = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i, contentFrameLayout.QH);
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMajor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMajor;
                    if (contentFrameLayout.QI == null) {
                        contentFrameLayout.QI = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QI);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMinor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedWidthMinor;
                    if (contentFrameLayout.QJ == null) {
                        contentFrameLayout.QJ = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QJ);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMajor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMajor;
                    if (contentFrameLayout.QK == null) {
                        contentFrameLayout.QK = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QK);
                }
                if (obtainStyledAttributes2.hasValue(android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMinor)) {
                    i = android.support.v7.a.a.k.AppCompatTheme_windowFixedHeightMinor;
                    if (contentFrameLayout.QL == null) {
                        contentFrameLayout.QL = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i, contentFrameLayout.QL);
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout.requestLayout();
                this.Hf = true;
                PanelFeatureState aD = aD(0);
                if (!this.GO) {
                    if (aD == null || aD.HB == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                return;
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = 109;
        }
        if (this.GN && i == 108) {
            return false;
        }
        if (this.GJ && i == 1) {
            this.GJ = false;
        }
        switch (i) {
            case 1:
                da();
                this.GN = true;
                return true;
            case 2:
                da();
                this.Hi = true;
                return true;
            case 5:
                da();
                this.Hj = true;
                return true;
            case 10:
                da();
                this.GL = true;
                return true;
            case 108:
                da();
                this.GJ = true;
                return true;
            case 109:
                da();
                this.GK = true;
                return true;
            default:
                return this.Ft.requestFeature(i);
        }
    }

    final void f(CharSequence charSequence) {
        if (this.GX != null) {
            this.GX.e(charSequence);
        } else if (this.mActionBar != null) {
            this.mActionBar.e(charSequence);
        } else if (this.FN != null) {
            this.FN.setText(charSequence);
        }
    }

    final void aA(int i) {
        if (i == 108) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.z(false);
            }
        } else if (i == 0) {
            PanelFeatureState aD = aD(i);
            if (aD.Ec) {
                a(aD, false);
            }
        }
    }

    final boolean aB(int i) {
        if (i != 108) {
            return false;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return true;
        }
        supportActionBar.z(true);
        return true;
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        Callback callback = this.Ft.getCallback();
        if (!(callback == null || this.GO)) {
            PanelFeatureState a = a(fVar.dE());
            if (a != null) {
                return callback.onMenuItemSelected(a.Hx, menuItem);
            }
        }
        return false;
    }

    public final void b(f fVar) {
        if (this.GX == null || !this.GX.dV() || (ae.b(ViewConfiguration.get(this.mContext)) && !this.GX.dW())) {
            PanelFeatureState aD = aD(0);
            aD.HH = true;
            a(aD, false);
            a(aD, null);
            return;
        }
        Callback callback = this.Ft.getCallback();
        if (this.GX.isOverflowMenuShowing()) {
            this.GX.hideOverflowMenu();
            if (!this.GO) {
                callback.onPanelClosed(108, aD(0).HB);
            }
        } else if (callback != null && !this.GO) {
            if (this.Ho && (this.Hp & 1) != 0) {
                this.Ft.getDecorView().removeCallbacks(this.Hq);
                this.Hq.run();
            }
            PanelFeatureState aD2 = aD(0);
            if (aD2.HB != null && !aD2.HI && callback.onPreparePanel(0, aD2.HA, aD2.HB)) {
                callback.onMenuOpened(108, aD2.HB);
                this.GX.showOverflowMenu();
            }
        }
    }

    public final android.support.v7.view.b startSupportActionMode(android.support.v7.view.b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.Ha != null) {
            this.Ha.finish();
        }
        android.support.v7.view.b.a bVar = new b(aVar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            this.Ha = supportActionBar.a(bVar);
            if (!(this.Ha == null || this.GI == null)) {
                this.GI.onSupportActionModeStarted(this.Ha);
            }
        }
        if (this.Ha == null) {
            this.Ha = b(bVar);
        }
        return this.Ha;
    }

    public final void invalidateOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null || !supportActionBar.cR()) {
            invalidatePanelMenu(0);
        }
    }

    final android.support.v7.view.b b(android.support.v7.view.b.a aVar) {
        android.support.v7.view.b onWindowStartingSupportActionMode;
        ViewStubCompat viewStubCompat;
        TypedValue typedValue;
        Theme theme;
        Theme newTheme;
        Context dVar;
        Context context;
        ActionBarContextView actionBarContextView;
        boolean z;
        android.support.v7.view.b eVar;
        cZ();
        if (this.Ha != null) {
            this.Ha.finish();
        }
        android.support.v7.view.b.a bVar = new b(aVar);
        if (!(this.GI == null || this.GO)) {
            try {
                onWindowStartingSupportActionMode = this.GI.onWindowStartingSupportActionMode(bVar);
            } catch (AbstractMethodError e) {
            }
            if (onWindowStartingSupportActionMode == null) {
                this.Ha = onWindowStartingSupportActionMode;
            } else {
                if (this.Hb == null) {
                    if (this.GM) {
                        viewStubCompat = (ViewStubCompat) this.Hg.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                        if (viewStubCompat != null) {
                            viewStubCompat.DF = LayoutInflater.from(cX());
                            this.Hb = (ActionBarContextView) viewStubCompat.inflate();
                        }
                    } else {
                        typedValue = new TypedValue();
                        theme = this.mContext.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId == 0) {
                            newTheme = this.mContext.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            dVar = new android.support.v7.view.d(this.mContext, 0);
                            dVar.getTheme().setTo(newTheme);
                        } else {
                            dVar = this.mContext;
                        }
                        this.Hb = new ActionBarContextView(dVar);
                        this.Hc = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                        m.a(this.Hc, 2);
                        this.Hc.setContentView(this.Hb);
                        this.Hc.setWidth(-1);
                        dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                        this.Hb.aF(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                        this.Hc.setHeight(-2);
                        this.Hd = new Runnable() {
                            public final void run() {
                                AppCompatDelegateImplV7.this.Hc.showAtLocation(AppCompatDelegateImplV7.this.Hb, 55, 0, 0);
                                AppCompatDelegateImplV7.this.cZ();
                                z.d(AppCompatDelegateImplV7.this.Hb, 0.0f);
                                AppCompatDelegateImplV7.this.He = z.U(AppCompatDelegateImplV7.this.Hb).q(1.0f);
                                AppCompatDelegateImplV7.this.He.a(new an() {
                                    public final void q(View view) {
                                        z.d(AppCompatDelegateImplV7.this.Hb, 1.0f);
                                        AppCompatDelegateImplV7.this.He.a(null);
                                        AppCompatDelegateImplV7.this.He = null;
                                    }

                                    public final void p(View view) {
                                        AppCompatDelegateImplV7.this.Hb.setVisibility(0);
                                    }
                                });
                            }
                        };
                    }
                }
                if (this.Hb != null) {
                    cZ();
                    this.Hb.dQ();
                    context = this.Hb.getContext();
                    actionBarContextView = this.Hb;
                    if (this.Hc != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    eVar = new android.support.v7.view.e(context, actionBarContextView, bVar, z);
                    if (aVar.a(eVar, eVar.getMenu())) {
                        this.Ha = null;
                    } else {
                        eVar.invalidate();
                        this.Hb.c(eVar);
                        this.Ha = eVar;
                        z.d(this.Hb, 0.0f);
                        this.He = z.U(this.Hb).q(1.0f);
                        this.He.a(new an() {
                            public final void q(View view) {
                                z.d(AppCompatDelegateImplV7.this.Hb, 1.0f);
                                AppCompatDelegateImplV7.this.He.a(null);
                                AppCompatDelegateImplV7.this.He = null;
                            }

                            public final void p(View view) {
                                AppCompatDelegateImplV7.this.Hb.setVisibility(0);
                                AppCompatDelegateImplV7.this.Hb.sendAccessibilityEvent(32);
                                if (AppCompatDelegateImplV7.this.Hb.getParent() != null) {
                                    z.Y((View) AppCompatDelegateImplV7.this.Hb.getParent());
                                }
                            }
                        });
                        if (this.Hc != null) {
                            this.Ft.getDecorView().post(this.Hd);
                        }
                    }
                }
            }
            if (!(this.Ha == null || this.GI == null)) {
                this.GI.onSupportActionModeStarted(this.Ha);
            }
            return this.Ha;
        }
        onWindowStartingSupportActionMode = null;
        if (onWindowStartingSupportActionMode == null) {
            if (this.Hb == null) {
                if (this.GM) {
                    viewStubCompat = (ViewStubCompat) this.Hg.findViewById(android.support.v7.a.a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.DF = LayoutInflater.from(cX());
                        this.Hb = (ActionBarContextView) viewStubCompat.inflate();
                    }
                } else {
                    typedValue = new TypedValue();
                    theme = this.mContext.getTheme();
                    theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId == 0) {
                        dVar = this.mContext;
                    } else {
                        newTheme = this.mContext.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new android.support.v7.view.d(this.mContext, 0);
                        dVar.getTheme().setTo(newTheme);
                    }
                    this.Hb = new ActionBarContextView(dVar);
                    this.Hc = new PopupWindow(dVar, null, android.support.v7.a.a.a.actionModePopupWindowStyle);
                    m.a(this.Hc, 2);
                    this.Hc.setContentView(this.Hb);
                    this.Hc.setWidth(-1);
                    dVar.getTheme().resolveAttribute(android.support.v7.a.a.a.actionBarSize, typedValue, true);
                    this.Hb.aF(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.Hc.setHeight(-2);
                    this.Hd = /* anonymous class already generated */;
                }
            }
            if (this.Hb != null) {
                cZ();
                this.Hb.dQ();
                context = this.Hb.getContext();
                actionBarContextView = this.Hb;
                if (this.Hc != null) {
                    z = false;
                } else {
                    z = true;
                }
                eVar = new android.support.v7.view.e(context, actionBarContextView, bVar, z);
                if (aVar.a(eVar, eVar.getMenu())) {
                    this.Ha = null;
                } else {
                    eVar.invalidate();
                    this.Hb.c(eVar);
                    this.Ha = eVar;
                    z.d(this.Hb, 0.0f);
                    this.He = z.U(this.Hb).q(1.0f);
                    this.He.a(/* anonymous class already generated */);
                    if (this.Hc != null) {
                        this.Ft.getDecorView().post(this.Hd);
                    }
                }
            }
        } else {
            this.Ha = onWindowStartingSupportActionMode;
        }
        this.GI.onSupportActionModeStarted(this.Ha);
        return this.Ha;
    }

    private void cZ() {
        if (this.He != null) {
            this.He.cancel();
        }
    }

    final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null && supportActionBar.onKeyShortcut(i, keyEvent)) {
            return true;
        }
        if (this.Hm == null || !a(this.Hm, keyEvent.getKeyCode(), keyEvent)) {
            if (this.Hm == null) {
                PanelFeatureState aD = aD(0);
                b(aD, keyEvent);
                boolean a = a(aD, keyEvent.getKeyCode(), keyEvent);
                aD.HE = false;
                if (a) {
                    return true;
                }
            }
            return false;
        } else if (this.Hm == null) {
            return true;
        } else {
            this.Hm.HF = true;
            return true;
        }
    }

    final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.GG.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            switch (keyCode) {
                case 4:
                    this.Hn = (keyEvent.getFlags() & FileUtils.S_IWUSR) != 0;
                    break;
                case 82:
                    if (keyEvent.getRepeatCount() != 0) {
                        return true;
                    }
                    PanelFeatureState aD = aD(0);
                    if (aD.Ec) {
                        return true;
                    }
                    b(aD, keyEvent);
                    return true;
            }
            if (VERSION.SDK_INT < 11) {
                onKeyShortcut(keyCode, keyEvent);
            }
            return false;
        }
        PanelFeatureState aD2;
        switch (keyCode) {
            case 4:
                z = this.Hn;
                this.Hn = false;
                aD2 = aD(0);
                if (aD2 == null || !aD2.Ec) {
                    if (this.Ha != null) {
                        this.Ha.finish();
                        z = true;
                    } else {
                        ActionBar supportActionBar = getSupportActionBar();
                        z = supportActionBar != null && supportActionBar.collapseActionView();
                    }
                    if (z) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    a(aD2, true);
                    return true;
                }
                break;
            case 82:
                if (this.Ha != null) {
                    return true;
                }
                aD2 = aD(0);
                if (this.GX == null || !this.GX.dV() || ae.b(ViewConfiguration.get(this.mContext))) {
                    if (aD2.Ec || aD2.HF) {
                        z = aD2.Ec;
                        a(aD2, true);
                    } else {
                        if (aD2.HE) {
                            if (aD2.HI) {
                                aD2.HE = false;
                                z = b(aD2, keyEvent);
                            } else {
                                z = true;
                            }
                            if (z) {
                                a(aD2, keyEvent);
                                z = true;
                            }
                        }
                        z = false;
                    }
                } else if (this.GX.isOverflowMenuShowing()) {
                    z = this.GX.hideOverflowMenu();
                } else {
                    if (!this.GO && b(aD2, keyEvent)) {
                        z = this.GX.showOverflowMenu();
                    }
                    z = false;
                }
                if (!z) {
                    return true;
                }
                AudioManager audioManager = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (audioManager == null) {
                    return true;
                }
                audioManager.playSoundEffect(0);
                return true;
        }
        return false;
    }

    public final void cT() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            android.support.v4.view.h.a(from, this);
        } else {
            android.support.v4.view.h.a(from);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r8, java.lang.String r9, android.content.Context r10, android.util.AttributeSet r11) {
        /*
        r7 = this;
        r3 = 1;
        r4 = 0;
        r0 = r7.a(r9, r10, r11);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r0 >= r1) goto L_0x0059;
    L_0x000f:
        r2 = r3;
    L_0x0010:
        r0 = r7.Hs;
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r0 = new android.support.v7.app.k;
        r0.<init>();
        r7.Hs = r0;
    L_0x001b:
        if (r2 == 0) goto L_0x007c;
    L_0x001d:
        r0 = r8;
        r0 = (android.view.ViewParent) r0;
        if (r0 != 0) goto L_0x005b;
    L_0x0022:
        r0 = r4;
    L_0x0023:
        if (r0 == 0) goto L_0x007c;
    L_0x0025:
        r0 = r3;
    L_0x0026:
        r5 = r7.Hs;
        r1 = android.support.v7.widget.ar.hd();
        if (r0 == 0) goto L_0x0176;
    L_0x002e:
        if (r8 == 0) goto L_0x0176;
    L_0x0030:
        r0 = r8.getContext();
    L_0x0034:
        r0 = android.support.v7.app.k.a(r0, r11, r2, r3);
        if (r1 == 0) goto L_0x003e;
    L_0x003a:
        r0 = android.support.v7.widget.am.r(r0);
    L_0x003e:
        r1 = 0;
        r2 = -1;
        r6 = r9.hashCode();
        switch(r6) {
            case -1946472170: goto L_0x00fe;
            case -1455429095: goto L_0x00d7;
            case -1346021293: goto L_0x00f1;
            case -938935918: goto L_0x007e;
            case -937446323: goto L_0x00b4;
            case -658531749: goto L_0x010b;
            case -339785223: goto L_0x00a9;
            case 776382189: goto L_0x00cb;
            case 1125864064: goto L_0x0088;
            case 1413872058: goto L_0x00e4;
            case 1601505219: goto L_0x00bf;
            case 1666676343: goto L_0x009e;
            case 2001146706: goto L_0x0093;
            default: goto L_0x0047;
        };
    L_0x0047:
        r4 = r2;
    L_0x0048:
        switch(r4) {
            case 0: goto L_0x0118;
            case 1: goto L_0x011f;
            case 2: goto L_0x0126;
            case 3: goto L_0x012d;
            case 4: goto L_0x0134;
            case 5: goto L_0x013b;
            case 6: goto L_0x0142;
            case 7: goto L_0x0149;
            case 8: goto L_0x0150;
            case 9: goto L_0x0157;
            case 10: goto L_0x015e;
            case 11: goto L_0x0165;
            case 12: goto L_0x016c;
            default: goto L_0x004b;
        };
    L_0x004b:
        if (r1 != 0) goto L_0x0173;
    L_0x004d:
        if (r10 == r0) goto L_0x0173;
    L_0x004f:
        r0 = r5.a(r0, r9, r11);
    L_0x0053:
        if (r0 == 0) goto L_0x0008;
    L_0x0055:
        android.support.v7.app.k.a(r0, r11);
        goto L_0x0008;
    L_0x0059:
        r2 = r4;
        goto L_0x0010;
    L_0x005b:
        r1 = r7.Ft;
        r5 = r1.getDecorView();
        r1 = r0;
    L_0x0062:
        if (r1 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r3;
        goto L_0x0023;
    L_0x0066:
        if (r1 == r5) goto L_0x0075;
    L_0x0068:
        r0 = r1 instanceof android.view.View;
        if (r0 == 0) goto L_0x0075;
    L_0x006c:
        r0 = r1;
        r0 = (android.view.View) r0;
        r0 = android.support.v4.view.z.ak(r0);
        if (r0 == 0) goto L_0x0077;
    L_0x0075:
        r0 = r4;
        goto L_0x0023;
    L_0x0077:
        r1 = r1.getParent();
        goto L_0x0062;
    L_0x007c:
        r0 = r4;
        goto L_0x0026;
    L_0x007e:
        r3 = "TextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0087:
        goto L_0x0048;
    L_0x0088:
        r4 = "ImageView";
        r4 = r9.equals(r4);
        if (r4 == 0) goto L_0x0047;
    L_0x0091:
        r4 = r3;
        goto L_0x0048;
    L_0x0093:
        r3 = "Button";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x009c:
        r4 = 2;
        goto L_0x0048;
    L_0x009e:
        r3 = "EditText";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00a7:
        r4 = 3;
        goto L_0x0048;
    L_0x00a9:
        r3 = "Spinner";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00b2:
        r4 = 4;
        goto L_0x0048;
    L_0x00b4:
        r3 = "ImageButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00bd:
        r4 = 5;
        goto L_0x0048;
    L_0x00bf:
        r3 = "CheckBox";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00c8:
        r4 = 6;
        goto L_0x0048;
    L_0x00cb:
        r3 = "RadioButton";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00d4:
        r4 = 7;
        goto L_0x0048;
    L_0x00d7:
        r3 = "CheckedTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00e0:
        r4 = 8;
        goto L_0x0048;
    L_0x00e4:
        r3 = "AutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00ed:
        r4 = 9;
        goto L_0x0048;
    L_0x00f1:
        r3 = "MultiAutoCompleteTextView";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x00fa:
        r4 = 10;
        goto L_0x0048;
    L_0x00fe:
        r3 = "RatingBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0107:
        r4 = 11;
        goto L_0x0048;
    L_0x010b:
        r3 = "SeekBar";
        r3 = r9.equals(r3);
        if (r3 == 0) goto L_0x0047;
    L_0x0114:
        r4 = 12;
        goto L_0x0048;
    L_0x0118:
        r1 = new android.support.v7.widget.AppCompatTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x011f:
        r1 = new android.support.v7.widget.AppCompatImageView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0126:
        r1 = new android.support.v7.widget.AppCompatButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x012d:
        r1 = new android.support.v7.widget.AppCompatEditText;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0134:
        r1 = new android.support.v7.widget.AppCompatSpinner;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x013b:
        r1 = new android.support.v7.widget.AppCompatImageButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0142:
        r1 = new android.support.v7.widget.AppCompatCheckBox;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0149:
        r1 = new android.support.v7.widget.AppCompatRadioButton;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0150:
        r1 = new android.support.v7.widget.AppCompatCheckedTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0157:
        r1 = new android.support.v7.widget.AppCompatAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x015e:
        r1 = new android.support.v7.widget.AppCompatMultiAutoCompleteTextView;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0165:
        r1 = new android.support.v7.widget.AppCompatRatingBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x016c:
        r1 = new android.support.v7.widget.AppCompatSeekBar;
        r1.<init>(r0, r11);
        goto L_0x004b;
    L_0x0173:
        r0 = r1;
        goto L_0x0053;
    L_0x0176:
        r0 = r10;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    View a(String str, Context context, AttributeSet attributeSet) {
        if (this.GG instanceof Factory) {
            View onCreateView = ((Factory) this.GG).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.support.v7.app.AppCompatDelegateImplV7.PanelFeatureState r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r2 = -2;
        r3 = 0;
        r9 = 1;
        r0 = r11.Ec;
        if (r0 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r10.GO;
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.Hx;
        if (r0 != 0) goto L_0x0032;
    L_0x0011:
        r4 = r10.mContext;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0022:
        r0 = r9;
    L_0x0023:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002d:
        r4 = r9;
    L_0x002e:
        if (r0 == 0) goto L_0x0032;
    L_0x0030:
        if (r4 != 0) goto L_0x000c;
    L_0x0032:
        r0 = r10.Ft;
        r0 = r0.getCallback();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.Hx;
        r5 = r11.HB;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.a(r11, r9);
        goto L_0x000c;
    L_0x0048:
        r0 = r3;
        goto L_0x0023;
    L_0x004a:
        r4 = r3;
        goto L_0x002e;
    L_0x004c:
        r0 = r10.mContext;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000c;
    L_0x005a:
        r0 = r10.b(r11, r12);
        if (r0 == 0) goto L_0x000c;
    L_0x0060:
        r0 = r11.Hy;
        if (r0 == 0) goto L_0x0068;
    L_0x0064:
        r0 = r11.HH;
        if (r0 == 0) goto L_0x01bf;
    L_0x0068:
        r0 = r11.Hy;
        if (r0 != 0) goto L_0x0153;
    L_0x006c:
        r0 = r10.cX();
        r1 = new android.util.TypedValue;
        r1.<init>();
        r4 = r0.getResources();
        r4 = r4.newTheme();
        r5 = r0.getTheme();
        r4.setTo(r5);
        r5 = android.support.v7.a.a.a.actionBarPopupTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x0092;
    L_0x008d:
        r5 = r1.resourceId;
        r4.applyStyle(r5, r9);
    L_0x0092:
        r5 = android.support.v7.a.a.a.panelMenuListTheme;
        r4.resolveAttribute(r5, r1, r9);
        r5 = r1.resourceId;
        if (r5 == 0) goto L_0x014c;
    L_0x009b:
        r1 = r1.resourceId;
        r4.applyStyle(r1, r9);
    L_0x00a0:
        r1 = new android.support.v7.view.d;
        r1.<init>(r0, r3);
        r0 = r1.getTheme();
        r0.setTo(r4);
        r11.HD = r1;
        r0 = android.support.v7.a.a.k.AppCompatTheme;
        r0 = r1.obtainStyledAttributes(r0);
        r1 = android.support.v7.a.a.k.AppCompatTheme_panelBackground;
        r1 = r0.getResourceId(r1, r3);
        r11.background = r1;
        r1 = android.support.v7.a.a.k.AppCompatTheme_android_windowAnimationStyle;
        r1 = r0.getResourceId(r1, r3);
        r11.windowAnimations = r1;
        r0.recycle();
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$c;
        r1 = r11.HD;
        r0.<init>(r1);
        r11.Hy = r0;
        r0 = 81;
        r11.gravity = r0;
        r0 = r11.Hy;
        if (r0 == 0) goto L_0x000c;
    L_0x00d8:
        r0 = r11.HA;
        if (r0 == 0) goto L_0x0166;
    L_0x00dc:
        r0 = r11.HA;
        r11.Hz = r0;
        r0 = r9;
    L_0x00e1:
        if (r0 == 0) goto L_0x000c;
    L_0x00e3:
        r0 = r11.Hz;
        if (r0 == 0) goto L_0x01bc;
    L_0x00e7:
        r0 = r11.HA;
        if (r0 == 0) goto L_0x01ad;
    L_0x00eb:
        r0 = r9;
    L_0x00ec:
        if (r0 == 0) goto L_0x000c;
    L_0x00ee:
        r0 = r11.Hz;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x01d2;
    L_0x00f6:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x00fc:
        r0 = r11.background;
        r4 = r11.Hy;
        r4.setBackgroundResource(r0);
        r0 = r11.Hz;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x0116;
    L_0x010b:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x0116;
    L_0x010f:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.Hz;
        r0.removeView(r4);
    L_0x0116:
        r0 = r11.Hy;
        r4 = r11.Hz;
        r0.addView(r4, r1);
        r0 = r11.Hz;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x012a;
    L_0x0125:
        r0 = r11.Hz;
        r0.requestFocus();
    L_0x012a:
        r1 = r2;
    L_0x012b:
        r11.HF = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.x;
        r4 = r11.y;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.gravity;
        r0.gravity = r1;
        r1 = r11.windowAnimations;
        r0.windowAnimations = r1;
        r1 = r11.Hy;
        r8.addView(r1, r0);
        r11.Ec = r9;
        goto L_0x000c;
    L_0x014c:
        r1 = android.support.v7.a.a.j.Theme_AppCompat_CompactMenu;
        r4.applyStyle(r1, r9);
        goto L_0x00a0;
    L_0x0153:
        r0 = r11.HH;
        if (r0 == 0) goto L_0x00d8;
    L_0x0157:
        r0 = r11.Hy;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x00d8;
    L_0x015f:
        r0 = r11.Hy;
        r0.removeAllViews();
        goto L_0x00d8;
    L_0x0166:
        r0 = r11.HB;
        if (r0 == 0) goto L_0x01aa;
    L_0x016a:
        r0 = r10.GZ;
        if (r0 != 0) goto L_0x0175;
    L_0x016e:
        r0 = new android.support.v7.app.AppCompatDelegateImplV7$d;
        r0.<init>(r10, r3);
        r10.GZ = r0;
    L_0x0175:
        r0 = r10.GZ;
        r1 = r11.HB;
        if (r1 != 0) goto L_0x0187;
    L_0x017b:
        r0 = 0;
    L_0x017c:
        r0 = (android.view.View) r0;
        r11.Hz = r0;
        r0 = r11.Hz;
        if (r0 == 0) goto L_0x01aa;
    L_0x0184:
        r0 = r9;
        goto L_0x00e1;
    L_0x0187:
        r1 = r11.HC;
        if (r1 != 0) goto L_0x01a1;
    L_0x018b:
        r1 = new android.support.v7.view.menu.e;
        r4 = r11.HD;
        r5 = android.support.v7.a.a.h.abc_list_menu_item_layout;
        r1.<init>(r4, r5);
        r11.HC = r1;
        r1 = r11.HC;
        r1.ef = r0;
        r0 = r11.HB;
        r1 = r11.HC;
        r0.a(r1);
    L_0x01a1:
        r0 = r11.HC;
        r1 = r11.Hy;
        r0 = r0.c(r1);
        goto L_0x017c;
    L_0x01aa:
        r0 = r3;
        goto L_0x00e1;
    L_0x01ad:
        r0 = r11.HC;
        r0 = r0.getAdapter();
        r0 = r0.getCount();
        if (r0 <= 0) goto L_0x01bc;
    L_0x01b9:
        r0 = r9;
        goto L_0x00ec;
    L_0x01bc:
        r0 = r3;
        goto L_0x00ec;
    L_0x01bf:
        r0 = r11.HA;
        if (r0 == 0) goto L_0x01cf;
    L_0x01c3:
        r0 = r11.HA;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x01cf;
    L_0x01cb:
        r0 = r0.width;
        if (r0 == r1) goto L_0x012b;
    L_0x01cf:
        r1 = r2;
        goto L_0x012b;
    L_0x01d2:
        r1 = r0;
        goto L_0x00fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.AppCompatDelegateImplV7.a(android.support.v7.app.AppCompatDelegateImplV7$PanelFeatureState, android.view.KeyEvent):void");
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        if (this.GO) {
            return false;
        }
        if (panelFeatureState.HE) {
            return true;
        }
        if (!(this.Hm == null || this.Hm == panelFeatureState)) {
            a(this.Hm, false);
        }
        Callback callback = this.Ft.getCallback();
        if (callback != null) {
            panelFeatureState.HA = callback.onCreatePanelView(panelFeatureState.Hx);
        }
        boolean z = panelFeatureState.Hx == 0 || panelFeatureState.Hx == 108;
        if (z && this.GX != null) {
            this.GX.dX();
        }
        if (panelFeatureState.HA == null && !(z && (this.mActionBar instanceof l))) {
            if (panelFeatureState.HB == null || panelFeatureState.HI) {
                if (panelFeatureState.HB == null) {
                    Context dVar;
                    f fVar;
                    Context context = this.mContext;
                    if ((panelFeatureState.Hx == 0 || panelFeatureState.Hx == 108) && this.GX != null) {
                        Theme newTheme;
                        TypedValue typedValue = new TypedValue();
                        Theme theme = context.getTheme();
                        theme.resolveAttribute(android.support.v7.a.a.a.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            newTheme = context.getResources().newTheme();
                            newTheme.setTo(theme);
                            newTheme.applyStyle(typedValue.resourceId, true);
                            newTheme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(android.support.v7.a.a.a.actionBarWidgetTheme, typedValue, true);
                            newTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (newTheme == null) {
                                newTheme = context.getResources().newTheme();
                                newTheme.setTo(theme);
                            }
                            newTheme.applyStyle(typedValue.resourceId, true);
                        }
                        Theme theme2 = newTheme;
                        if (theme2 != null) {
                            dVar = new android.support.v7.view.d(context, 0);
                            dVar.getTheme().setTo(theme2);
                            fVar = new f(dVar);
                            fVar.a((android.support.v7.view.menu.f.a) this);
                            panelFeatureState.e(fVar);
                            if (panelFeatureState.HB == null) {
                                return false;
                            }
                        }
                    }
                    dVar = context;
                    fVar = new f(dVar);
                    fVar.a((android.support.v7.view.menu.f.a) this);
                    panelFeatureState.e(fVar);
                    if (panelFeatureState.HB == null) {
                        return false;
                    }
                }
                if (z && this.GX != null) {
                    if (this.GY == null) {
                        this.GY = new a();
                    }
                    this.GX.a(panelFeatureState.HB, this.GY);
                }
                panelFeatureState.HB.dx();
                if (callback.onCreatePanelMenu(panelFeatureState.Hx, panelFeatureState.HB)) {
                    panelFeatureState.HI = false;
                } else {
                    panelFeatureState.e(null);
                    if (!z || this.GX == null) {
                        return false;
                    }
                    this.GX.a(null, this.GY);
                    return false;
                }
            }
            panelFeatureState.HB.dx();
            if (panelFeatureState.HJ != null) {
                panelFeatureState.HB.d(panelFeatureState.HJ);
                panelFeatureState.HJ = null;
            }
            if (callback.onPreparePanel(0, panelFeatureState.HA, panelFeatureState.HB)) {
                boolean z2;
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.HG = z2;
                panelFeatureState.HB.setQwertyMode(panelFeatureState.HG);
                panelFeatureState.HB.dy();
            } else {
                if (z && this.GX != null) {
                    this.GX.a(null, this.GY);
                }
                panelFeatureState.HB.dy();
                return false;
            }
        }
        panelFeatureState.HE = true;
        panelFeatureState.HF = false;
        this.Hm = panelFeatureState;
        return true;
    }

    private void c(f fVar) {
        if (!this.Hk) {
            this.Hk = true;
            this.GX.dY();
            Callback callback = this.Ft.getCallback();
            if (!(callback == null || this.GO)) {
                callback.onPanelClosed(108, fVar);
            }
            this.Hk = false;
        }
    }

    private void a(PanelFeatureState panelFeatureState, boolean z) {
        if (z && panelFeatureState.Hx == 0 && this.GX != null && this.GX.isOverflowMenuShowing()) {
            c(panelFeatureState.HB);
            return;
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.Ec || panelFeatureState.Hy == null)) {
            windowManager.removeView(panelFeatureState.Hy);
            if (z) {
                a(panelFeatureState.Hx, panelFeatureState, null);
            }
        }
        panelFeatureState.HE = false;
        panelFeatureState.HF = false;
        panelFeatureState.Ec = false;
        panelFeatureState.Hz = null;
        panelFeatureState.HH = true;
        if (this.Hm == panelFeatureState) {
            this.Hm = null;
        }
    }

    private void a(int i, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i >= 0 && i < this.Hl.length) {
                panelFeatureState = this.Hl[i];
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.HB;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.Ec) && !this.GO) {
            this.GG.onPanelClosed(i, menu);
        }
    }

    private PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.Hl;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i = 0; i < length; i++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i];
            if (panelFeatureState != null && panelFeatureState.HB == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    private PanelFeatureState aD(int i) {
        Object obj = this.Hl;
        if (obj == null || obj.length <= i) {
            Object obj2 = new PanelFeatureState[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.Hl = obj2;
            obj = obj2;
        }
        PanelFeatureState panelFeatureState = obj[i];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        panelFeatureState = new PanelFeatureState(i);
        obj[i] = panelFeatureState;
        return panelFeatureState;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.HE || b(panelFeatureState, keyEvent)) && panelFeatureState.HB != null) {
            return panelFeatureState.HB.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    private void invalidatePanelMenu(int i) {
        this.Hp |= 1 << i;
        if (!this.Ho) {
            z.a(this.Ft.getDecorView(), this.Hq);
            this.Ho = true;
        }
    }

    private void da() {
        if (this.Hf) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }
}
