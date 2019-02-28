package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.l;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MMFragmentActivity extends ActionBarActivity implements com.tencent.mm.ui.widget.SwipeBackLayout.a, com.tencent.mm.ui.widget.l.a, com.tencent.mm.vending.e.b {
    public static final long DURATION = 240;
    private static final String TAG = "MicroMsg.MMFragmentActivity";
    String className;
    private a mActivityAnimStyle = new a();
    private View mContentViewForSwipeBack = null;
    private boolean mIsPaused;
    private com.tencent.mm.vending.a.a mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    private b mNfcFilterHelper;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean mSwiping;
    ArrayList<WeakReference<u>> record = new ArrayList();

    public static class a {
        public static int xSL;
        public static int xSM;
        public static int xSN;
        public static int xSO;
        public static int xSP = xSL;
        public static int xSQ = xSM;
        public static int xSR = xSN;
        public static int xSS = xSO;

        static {
            int i;
            int zj = com.tencent.mm.compatible.i.a.zj() & d.fN(19);
            xSL = zj != 0 ? com.tencent.mm.v.a.a.bqB : com.tencent.mm.v.a.a.bqk;
            xSM = zj != 0 ? com.tencent.mm.v.a.a.bqA : com.tencent.mm.v.a.a.bpQ;
            xSN = zj != 0 ? com.tencent.mm.v.a.a.bqz : com.tencent.mm.v.a.a.bpQ;
            if (zj != 0) {
                i = com.tencent.mm.v.a.a.bqC;
            } else {
                i = com.tencent.mm.v.a.a.bql;
            }
            xSO = i;
        }

        public static void cnR() {
            u uVar = q.gHK;
            boolean zb = u.zb();
            x.i(MMFragmentActivity.TAG, "lm: setAnimationStyle swipbackType = " + zb);
            if (zb) {
                boolean zj = com.tencent.mm.compatible.i.a.zj() & d.fN(19);
                x.i(MMFragmentActivity.TAG, "lm: setAnimationStyle supportSwipe = " + zj);
                xSL = zj ? com.tencent.mm.v.a.a.bqB : com.tencent.mm.v.a.a.bqk;
                xSM = zj ? com.tencent.mm.v.a.a.bqA : com.tencent.mm.v.a.a.bpQ;
                xSN = zj ? com.tencent.mm.v.a.a.bqz : com.tencent.mm.v.a.a.bpQ;
                xSO = zj ? com.tencent.mm.v.a.a.bqC : com.tencent.mm.v.a.a.bql;
                xSP = xSL;
                xSQ = xSM;
                xSR = xSN;
                xSS = xSO;
            }
        }
    }

    private final class b {
        PendingIntent aJE;
        NfcAdapter xST;
        IntentFilter[] xSU;
        String[][] xSV;

        private b() {
        }

        /* synthetic */ b(MMFragmentActivity mMFragmentActivity, byte b) {
            this();
        }

        final void init() {
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            this.aJE = PendingIntent.getActivity(MMFragmentActivity.this, 0, intent, 0);
            try {
                new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
                new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataScheme("vnd.android.nfc");
                this.xSU = new IntentFilter[]{r0, r1, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
                String[][] strArr = new String[1][];
                strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName()};
                this.xSV = strArr;
            } catch (Throwable e) {
                throw new RuntimeException("fail", e);
            }
        }
    }

    public void keep(com.tencent.mm.vending.e.a aVar) {
        this.mLifeCycleKeeper.zJV.keep(aVar);
    }

    protected com.tencent.mm.vending.e.b theCreate() {
        return this.mLifeCycleKeeper.zJV;
    }

    protected com.tencent.mm.vending.e.b theResume() {
        return this.mLifeCycleKeeper.zJW;
    }

    protected com.tencent.mm.vending.e.b theStart() {
        return this.mLifeCycleKeeper.zJW;
    }

    public void onCreate(Bundle bundle) {
        this.className = getClass().getName();
        ad.aZ(3, this.className);
        super.onCreate(bundle);
        this.mNfcFilterHelper = new b();
        b bVar = this.mNfcFilterHelper;
        bVar.xST = NfcAdapter.getDefaultAdapter(bVar.xSK);
        bVar.init();
    }

    public void onDestroy() {
        this.mLifeCycleKeeper.zJV.dead();
        super.onDestroy();
    }

    public void onStop() {
        this.mLifeCycleKeeper.zJX.dead();
        super.onStop();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        ad.aZ(2, this.className);
        this.mIsPaused = true;
        super.onPause();
        if (isSupportNavigationSwipeBack()) {
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().mEnable = false;
            }
            if (!isFinishing()) {
                l.a(this);
            }
        }
        if (this.mNfcFilterHelper != null) {
            b bVar = this.mNfcFilterHelper;
            if (bVar.xST != null) {
                try {
                    bVar.xST.disableForegroundDispatch(bVar.xSK);
                } catch (IllegalStateException e) {
                    x.e(TAG, "lo-nfc-onPause: exp:" + e.getLocalizedMessage());
                }
            }
        }
        this.mLifeCycleKeeper.zJW.dead();
    }

    public void onResume() {
        ad.aZ(1, this.className);
        this.mIsPaused = false;
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            l.b(this);
            onSwipe(1.0f);
            if (getSwipeBackLayout() != null) {
                getSwipeBackLayout().mEnable = true;
                getSwipeBackLayout().zBF = false;
            }
        }
        if (this.mNfcFilterHelper != null) {
            b bVar = this.mNfcFilterHelper;
            if (bVar.xST != null) {
                if (bVar.aJE == null || bVar.xSU == null || bVar.xSV == null) {
                    bVar.init();
                }
                try {
                    bVar.xST.enableForegroundDispatch(bVar.xSK, bVar.aJE, bVar.xSU, bVar.xSV);
                } catch (IllegalStateException e) {
                    x.e(TAG, "lo-nfc-onResume: exp:" + e.getLocalizedMessage());
                }
            }
        }
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment) {
        if (fragment != null) {
            switchFragmentInternalWithoutAnim(fragment, fragment.getId());
        }
    }

    public void switchFragmentInternalWithoutAnim(Fragment fragment, int i) {
        switchFragment(fragment, i, false, false, 0, 0);
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment) {
        if (fragment != null) {
            switchFragmentInternalFarwardWithAnim(fragment, fragment.getId());
        }
    }

    public void switchFragmentInternalFarwardWithAnim(Fragment fragment, int i) {
        switchFragment(fragment, i, false, true, com.tencent.mm.v.a.a.bqB, com.tencent.mm.v.a.a.bqA);
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment) {
        switchFragmentInternalBackwardWithAnim(fragment, fragment.getId());
    }

    public void switchFragmentInternalBackwardWithAnim(Fragment fragment, int i) {
        switchFragment(fragment, i, false, true, com.tencent.mm.v.a.a.bqz, com.tencent.mm.v.a.a.bqC);
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, View view) {
        if (fragment != null) {
            switchFragmentInternalBackwardWithAnimLeftSelfView(fragment, fragment.getId(), view);
        }
    }

    public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment fragment, int i, View view) {
        switchFragment(fragment, i, false, true, 0, com.tencent.mm.v.a.a.bqC);
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(this, com.tencent.mm.v.a.a.bqz);
            if (loadAnimation != null) {
                view.startAnimation(loadAnimation);
            }
            view.setVisibility(0);
        }
    }

    public void switchFragmentActivity(Fragment fragment) {
        if (fragment != null) {
            switchFragmentActivity(fragment, fragment.getId());
        }
    }

    public void switchFragmentActivity(Fragment fragment, int i) {
        switchFragment(fragment, i, true, true, com.tencent.mm.v.a.a.bqk, com.tencent.mm.v.a.a.bql);
        this.record.add(new WeakReference((u) fragment));
    }

    public boolean popBackStackImmediate() {
        if (this.record.size() == 0) {
            return false;
        }
        this.record.remove(this.record.size() - 1);
        return getSupportFragmentManager().popBackStackImmediate();
    }

    public void switchFragment(Fragment fragment, int i, boolean z, boolean z2, int i2, int i3) {
        if (fragment != null && i != 0) {
            m supportFragmentManager = getSupportFragmentManager();
            android.support.v4.app.q aT = supportFragmentManager.aT();
            if (z2) {
                aT.j(i2, i3);
            }
            if (supportFragmentManager.N(i) == null) {
                aT.a(i, fragment, fragment.getTag());
            } else if (fragment.isHidden()) {
                aT.b(fragment);
            }
            if (z) {
                aT.m(null);
            }
            aT.commit();
            supportFragmentManager.executePendingTransactions();
        }
    }

    public u getCurrentFragmet() {
        int size = this.record.size();
        if (size == 0) {
            return null;
        }
        u uVar = (u) ((WeakReference) this.record.get(size - 1)).get();
        if (uVar == null || !uVar.isShowing()) {
            return null;
        }
        return uVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    public void putActivityOpenAnimation(int i, int i2) {
        if (enableActivityAnimation()) {
            a.xSP = i;
            a.xSQ = i2;
        }
        super.overridePendingTransition(i, i2);
    }

    public void putActivityCloseAnimation(int i, int i2) {
        if (enableActivityAnimation()) {
            a.xSR = i;
            a.xSS = i2;
        }
        super.overridePendingTransition(i, i2);
    }

    public final boolean enableActivityAnimation() {
        return true;
    }

    public void initActivityOpenAnimation(Intent intent) {
        if (enableActivityAnimation()) {
            ComponentName component = intent == null ? null : intent.getComponent();
            if (component != null) {
                Object obj;
                String className = component.getClassName().startsWith(component.getPackageName()) ? component.getClassName() : component.getPackageName() + component.getClassName();
                if ((com.tencent.mm.ui.base.b.Zk(className) & 2) == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    super.overridePendingTransition(a.xSP, a.xSQ);
                    return;
                }
                Object obj2;
                if ((com.tencent.mm.ui.base.b.Zk(className) & 4) != 0) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 == null) {
                    com.tencent.mm.ui.base.b.fF(this);
                } else {
                    com.tencent.mm.ui.base.b.fI(this);
                }
            }
        }
    }

    public void initActivityCloseAnimation() {
        Object obj = 1;
        if (enableActivityAnimation()) {
            if (((com.tencent.mm.ui.base.b.H(getClass()) & 2) == 0 ? 1 : null) != null) {
                super.overridePendingTransition(a.xSR, a.xSS);
                return;
            }
            if ((com.tencent.mm.ui.base.b.H(getClass()) & 4) == 0) {
                obj = null;
            }
            if (obj == null) {
                com.tencent.mm.ui.base.b.fH(this);
            } else {
                com.tencent.mm.ui.base.b.fI(this);
            }
        }
    }

    public void finish() {
        super.finish();
        initActivityCloseAnimation();
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, intentArr, bundle)) {
            super.startActivities(intentArr, bundle);
            initActivityOpenAnimation(null);
        }
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
        initActivityOpenAnimation(null);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        initActivityOpenAnimation(intent);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
        initActivityOpenAnimation(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        initActivityOpenAnimation(intent);
    }

    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, new Intent[]{intent}, Integer.valueOf(i), bundle)) {
            super.startActivityForResult(intent, i, bundle);
            initActivityOpenAnimation(intent);
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        super.startActivityFromFragment(fragment, intent, i);
        initActivityOpenAnimation(intent);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (!d.a(this, this.mIsPaused, new Intent[]{intent}, fragment, Integer.valueOf(i))) {
            super.startActivityFromFragment(fragment, intent, i, bundle);
        }
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public boolean isSwiping() {
        return this.mSwiping;
    }

    public final boolean isSupportNavigationSwipeBack() {
        if (d.fN(19) && com.tencent.mm.compatible.i.a.zj() && supportNavigationSwipeBack() && com.tencent.mm.ui.base.b.I(getClass())) {
            return true;
        }
        return false;
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    public boolean convertActivityFromTranslucent() {
        return true;
    }

    public boolean initNavigationSwipeBack() {
        if (d.fN(19)) {
            if (com.tencent.mm.ui.base.b.I(getClass()) && convertActivityFromTranslucent()) {
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.ui.base.b.Z(MMFragmentActivity.this);
                    }
                });
            } else {
                boolean z;
                if ((com.tencent.mm.ui.base.b.H(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ah.y(new Runnable() {
                        public final void run() {
                            com.tencent.mm.ui.base.b.Z(MMFragmentActivity.this);
                        }
                    });
                }
            }
        }
        if (!isSupportNavigationSwipeBack()) {
            return false;
        }
        initSwipeBack();
        return true;
    }

    public void initSwipeBack() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(this).inflate(h.gZQ, viewGroup, false);
        this.mSwipeBackLayout.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(com.tencent.mm.v.a.d.transparent);
        viewGroup.removeView(viewGroup2);
        this.mSwipeBackLayout.addView(viewGroup2);
        this.mSwipeBackLayout.Iv = viewGroup2;
        viewGroup.addView(this.mSwipeBackLayout);
        this.mSwipeBackLayout.zFD = this;
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            return v.b((LayoutInflater) systemService);
        }
        return systemService;
    }

    public Resources getResources() {
        if (getAssets() == null || ad.getResources() == null) {
            return super.getResources();
        }
        return ad.getResources();
    }

    public void onSwipe(float f) {
        x.v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f), Long.valueOf(240));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ae.a(getWindow(), getSupportActionBar() != null ? getSupportActionBar().getCustomView() : null);
        }
        View view = this.mContentViewForSwipeBack;
        if (Float.compare(1.0f, f) <= 0) {
            j.n(view, 0.0f);
        } else {
            j.n(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        }
    }

    public void onSettle(boolean z, int i) {
        long j = 120;
        x.v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.mContentViewForSwipeBack == null) {
            this.mContentViewForSwipeBack = ae.a(getWindow(), getSupportActionBar().getCustomView());
        }
        View view = this.mContentViewForSwipeBack;
        if (z) {
            if (i <= 0) {
                j = 240;
            }
            j.a(view, j, 0.0f, null);
            return;
        }
        if (i <= 0) {
            j = 240;
        }
        j.a(view, j, (float) ((view.getWidth() * -1) / 4), null);
    }

    public void onSwipeBack() {
        if (!isFinishing()) {
            finish();
        }
        overridePendingTransition(0, 0);
        this.mSwiping = false;
    }

    public void onCancel() {
        this.mSwiping = false;
    }

    public void onDrag() {
        this.mSwiping = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isSupportNavigationSwipeBack() || keyEvent.getKeyCode() != 4 || !getSwipeBackLayout().czU()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        x.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        return true;
    }

    public boolean forceRemoveNoMatchOnPath() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getSupportActionBar() != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(g.decor_content_parent);
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(g.action_bar);
                if (findViewById != null && (findViewById instanceof Toolbar)) {
                    Toolbar toolbar = (Toolbar) findViewById;
                    LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = com.tencent.mm.compatible.util.a.g(this);
                    }
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void supportInvalidateOptionsMenu() {
        if (getCurrentFragmet() == null || !getCurrentFragmet().interceptSupportInvalidateOptionsMenu()) {
            super.supportInvalidateOptionsMenu();
        }
    }
}
