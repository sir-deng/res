package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.f.a.kj;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.h.a;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import java.util.Locale;

public abstract class u extends i implements OnAttachStateChangeListener, a {
    protected static final int DEFAULT_TOAST_TIME = 3000;
    public static final String FLAG_OVERRIDE_ENTER_ANIMATION = "MMActivity.OverrideEnterAnimation";
    public static final String FLAG_OVERRIDE_EXIT_ANIMATION = "MMActivity.OverrideExitAnimation";
    private static final String TAG = "MicroMsg.MMFragment";
    private static final String TAG2 = "MicroMsg.INIT";
    String className;
    public boolean isPreLoaded = false;
    public p mController = new p() {
        protected final int getLayoutId() {
            return u.this.getLayoutId();
        }

        protected final void dealContentView(View view) {
            u.this.dealContentView(view);
        }

        protected final String getIdentString() {
            return u.this.getIdentString();
        }

        protected final View getLayoutView() {
            return u.this.getLayoutView();
        }

        public final void onKeyboardStateChanged() {
            u.this.onKeyboardStateChanged();
        }

        protected final void onCreateBeforeSetContentView() {
            u.this.onCreateBeforeSetContentView();
        }

        protected final String getClassName() {
            return u.this.getClass().getName();
        }

        protected final boolean cnD() {
            return false;
        }

        public final boolean noActionBar() {
            return u.this.noActionBar();
        }
    };
    private boolean mCurVisible = false;
    private a mListener;
    protected ActionBarActivity mParent;
    private u mParentFragment;
    private boolean mParentVisible = false;
    private SwipeBackLayout mSwipeBackLayout;

    public abstract int getLayoutId();

    public u(boolean z) {
        super(z);
    }

    public void setBackGroundColorResource(int i) {
        this.mController.setBackGroundColorResource(i);
    }

    public static Locale initLanguage(Context context) {
        return p.initLanguage(context);
    }

    protected void onCreateBeforeSetContentView() {
    }

    public void setActivityController(p pVar) {
        if (pVar != null) {
            this.mController = pVar;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.a(thisActivity().getBaseContext(), (ActionBarActivity) thisActivity());
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (isSupportNavigationSwipeBack()) {
            initSwipeBack();
        }
        getView().addOnAttachStateChangeListener(this);
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.mSwipeBackLayout;
    }

    public final boolean isSupportNavigationSwipeBack() {
        if (d.fN(19) && com.tencent.mm.compatible.i.a.zj()) {
            return supportNavigationSwipeBack();
        }
        return false;
    }

    public boolean supportNavigationSwipeBack() {
        return true;
    }

    public boolean noActionBar() {
        return false;
    }

    public void onSwipeBack() {
    }

    public void onDragBegin() {
    }

    public void onCancelDrag() {
    }

    private void initSwipeBack() {
        View contentView = getContentView();
        ViewGroup viewGroup = (ViewGroup) contentView.getParent();
        if (viewGroup != null) {
            this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(thisActivity()).inflate(h.gZQ, viewGroup, false);
            viewGroup.removeView(contentView);
            viewGroup.addView(this.mSwipeBackLayout);
        } else {
            this.mSwipeBackLayout = (SwipeBackLayout) LayoutInflater.from(thisActivity()).inflate(h.gZQ, null);
        }
        this.mSwipeBackLayout.addView(contentView);
        this.mSwipeBackLayout.Iv = contentView;
        this.mSwipeBackLayout.nL(true);
        this.mSwipeBackLayout.zFD = new SwipeBackLayout.a() {
            public final void onSwipeBack() {
                u.this.onSwipeBack();
            }

            public final void onCancel() {
                u.this.onCancelDrag();
            }

            public final void onDrag() {
                u.this.onDragBegin();
            }
        };
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        setHasOptionsMenu(true);
        return getContentView();
    }

    public void dealContentView(View view) {
    }

    public int keyboardState() {
        return this.mController.xRL;
    }

    public void onKeyboardStateChanged() {
    }

    public void setParent(ActionBarActivity actionBarActivity) {
        this.mParent = actionBarActivity;
    }

    public final Activity getContext() {
        return this.mController.xRr;
    }

    public p getController() {
        return this.mController;
    }

    public boolean isScreenEnable() {
        return this.mController.xRh;
    }

    public void setScreenEnable(boolean z) {
        this.mController.setScreenEnable(z);
    }

    protected final void setBodyView(int i) {
        p pVar = this.mController;
        if (pVar.xRg == null) {
            pVar.xRg = (FrameLayout) pVar.contentView.findViewById(g.cwr);
        }
        if (pVar.xRe != null) {
            pVar.xRg.removeView(pVar.xRe);
        }
        pVar.xRg.removeView(pVar.xRd);
        pVar.xRd = ((LayoutInflater) pVar.mContext.getSystemService("layout_inflater")).inflate(i, null);
        pVar.xRg.addView(pVar.xRd, 0, new LayoutParams(-1, -1));
        if (pVar.xRe != null) {
            pVar.xRg.addView(pVar.xRe, pVar.xRg.getChildCount(), new LayoutParams(-1, b.b(pVar.mContext, 47.0f)));
        }
        pVar.xRg.invalidate();
    }

    public View getBodyView() {
        return this.mController.xRd;
    }

    public final View getContentView() {
        return this.mController.contentView;
    }

    public int getForceOrientation() {
        return p.getForceOrientation();
    }

    public boolean getLandscapeMode() {
        return this.mController.getLandscapeMode();
    }

    public int getStreamVolume(int i) {
        return this.mController.hYt.getStreamVolume(i);
    }

    public int getStreamMaxVolume(int i) {
        return this.mController.hYt.getStreamMaxVolume(i);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.mController.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
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
        x.v(TAG2, "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - currentTimeMillis));
        this.mController.onResume();
        x.v(TAG2, "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - currentTimeMillis));
        onParentVisibilityChanged(true);
    }

    public void addDialog(Dialog dialog) {
        this.mController.addDialog(dialog);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mController.onDestroy();
    }

    public void activateBroadcast(boolean z) {
        this.mController.activateBroadcast(z);
    }

    public void onPause() {
        long currentTimeMillis = System.currentTimeMillis();
        ad.aZ(2, this.className);
        super.onPause();
        if (this.isPreLoaded) {
            this.isPreLoaded = false;
        } else {
            this.mController.onPause();
        }
        x.v(TAG2, "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - currentTimeMillis));
        onParentVisibilityChanged(false);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (!this.mController.onCreateOptionsMenu(menu)) {
            super.onCreateOptionsMenu(menu, menuInflater);
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        this.mController.onPrepareOptionsMenu(menu);
        super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mController.onOptionsItemSelected(menuItem);
    }

    public boolean callBackMenu() {
        return this.mController.callBackMenu();
    }

    public String getIdentString() {
        return "";
    }

    public View getLayoutView() {
        return null;
    }

    @Deprecated
    public void setToTop(OnClickListener onClickListener) {
    }

    @Deprecated
    public void setTitleClickAction(SimpleOnGestureListener simpleOnGestureListener) {
    }

    @Deprecated
    public void setRedDotVisibilty(int i) {
    }

    public void fullScreenNoTitleBar(boolean z) {
        this.mController.fullScreenNoTitleBar(z);
    }

    public void fullScreenWithTitleBar(boolean z) {
        p pVar = this.mController;
        if (z) {
            pVar.xRr.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            pVar.xRr.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
    }

    public void setTitleVisibility(int i) {
        this.mController.setTitleVisibility(i);
    }

    public void setMMTitle(String str) {
        this.mController.setMMTitle(str);
    }

    public void updateDescription(String str) {
        this.mController.updateDescription(str);
    }

    public void setMMTitle(int i) {
        this.mController.setMMTitle(i);
    }

    public void setMMSubTitle(String str) {
        this.mController.setMMSubTitle(str);
    }

    public void setMMSubTitle(int i) {
        this.mController.setMMSubTitle(i);
    }

    public void setMMSubTitleColor(int i) {
    }

    public void setTitleLogo(int i, int i2) {
        this.mController.setTitleLogo(i, i2);
    }

    public void showHomeBtn(boolean z) {
        this.mController.showHomeBtn(z);
    }

    public void enableBackMenu(boolean z) {
        this.mController.enableBackMenu(z);
    }

    public void enableOptionMenu(boolean z) {
        this.mController.a(true, -1, z);
    }

    public void enableOptionMenu(int i, boolean z) {
        this.mController.a(false, i, z);
    }

    public void showOptionMenu(boolean z) {
        this.mController.b(true, -1, z);
    }

    public void showOptionMenu(int i, boolean z) {
        this.mController.b(false, i, z);
    }

    public void addSearchMenu(boolean z, p pVar) {
        this.mController.addSearchMenu(z, pVar);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.a(i, 0, str, false, onMenuItemClickListener, onLongClickListener, p.b.xSd);
    }

    public void addTextOptionMenu$7df2a0ca(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i2) {
        this.mController.addTextOptionMenu$7df2a0ca(i, str, onMenuItemClickListener, onLongClickListener, i2);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, String str, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, str, i2, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.addIconOptionMenu(i, i2, i3, onMenuItemClickListener);
    }

    public void addIconOptionMenu(int i, int i2, int i3, boolean z, OnMenuItemClickListener onMenuItemClickListener) {
        p pVar = this.mController;
        pVar.a(i, i3, pVar.mContext.getString(i2), z, onMenuItemClickListener, null, p.b.xSd);
    }

    public void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.a(i, i2, "", false, onMenuItemClickListener, onLongClickListener, p.b.xSd);
    }

    public void addIconOptionMenu(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        p pVar = this.mController;
        pVar.a(i, i3, pVar.mContext.getString(i2), false, onMenuItemClickListener, onLongClickListener, p.b.xSd);
    }

    public void updateOptionMenuIcon(int i, int i2) {
        p pVar = this.mController;
        p.a Em = pVar.Em(i);
        if (Em != null && Em.xRX != i2) {
            Em.xRX = i2;
            pVar.supportInvalidateOptionsMenu();
        }
    }

    public void updateOptionMenuText(int i, String str) {
        this.mController.updateOptionMenuText(i, str);
    }

    public void updateOptionMenuListener(int i, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener) {
        this.mController.updateOptionMenuListener(i, onMenuItemClickListener, onLongClickListener);
    }

    public void setTitleBarDoubleClickListener(Runnable runnable) {
        this.mController.setTitleBarDoubleClickListener(runnable);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.mController.setBackBtn(onMenuItemClickListener, 0);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.mController.setBackBtn(onMenuItemClickListener, i);
    }

    public void removeAllOptionMenu() {
        this.mController.removeAllOptionMenu();
    }

    public boolean removeOptionMenu(int i) {
        return this.mController.removeOptionMenu(i);
    }

    public CharSequence getMMTitle() {
        return this.mController.getMMTitle();
    }

    public void hideTitleView() {
        this.mController.hideTitleView();
    }

    public void showTitleView() {
        this.mController.showTitleView();
    }

    public boolean isTitleShowing() {
        return this.mController.isTitleShowing();
    }

    public int getTitleLocation() {
        return this.mController.getTitleLocation();
    }

    public void setTitlePhoneIconVisibility(int i) {
        p pVar = this.mController;
        pVar.xRq = i == 0;
        pVar.cnP();
    }

    public void setTitleMuteIconVisibility(int i) {
        this.mController.setTitleMuteIconVisibility(i);
    }

    public boolean hideVKB() {
        return this.mController.hideVKB();
    }

    public boolean hideVKB(View view) {
        return this.mController.hideVKB(view);
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
        int intExtra = thisActivity().getIntent().getIntExtra(FLAG_OVERRIDE_ENTER_ANIMATION, -1);
        int intExtra2 = thisActivity().getIntent().getIntExtra(FLAG_OVERRIDE_EXIT_ANIMATION, -1);
        if (intExtra != -1) {
            getContext().overridePendingTransition(intExtra, intExtra2);
        }
    }

    public void startActivity(Intent intent) {
        startActivityReal(intent);
    }

    public void startActivityReal(Intent intent) {
        super.startActivity(intent);
    }

    public Resources thisResources() {
        FragmentActivity activity = super.getActivity();
        if (activity == null) {
            return ad.getContext().getResources();
        }
        return activity.getResources();
    }

    public FragmentActivity thisActivity() {
        if (this.mController.xRr != null) {
            return this.mController.xRr;
        }
        return super.getActivity();
    }

    public Resources getMMResources() {
        return thisActivity().getResources();
    }

    public String getMMString(int i) {
        return thisActivity().getString(i);
    }

    public String getMMString(int i, Object... objArr) {
        return thisActivity().getString(i, objArr);
    }

    public boolean interceptSupportInvalidateOptionsMenu() {
        if (!this.mController.interceptSupportInvalidateOptionsMenu()) {
            return false;
        }
        this.mController.supportInvalidateOptionsMenu();
        return true;
    }

    public void onStart() {
        this.mController.onStart();
        super.onStart();
        onParentVisibilityChanged(true);
    }

    public void onStop() {
        super.onStop();
        onParentVisibilityChanged(false);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        filterAndNotifyVisibility(!z, z);
    }

    public void setUserVisibleHint(boolean z) {
        x.i(TAG, "[setUserVisibleHint] isVisibleToUser:%s name:%s", Boolean.valueOf(z), getClass().getName());
        super.setUserVisibleHint(z);
        filterAndNotifyVisibility(z);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null && (parentFragment instanceof u)) {
            this.mParentFragment = (u) parentFragment;
            this.mParentFragment.setOnVisibilityChangedListener(this);
        }
        filterAndNotifyVisibility(true);
    }

    public void onDetach() {
        if (this.mParentFragment != null) {
            this.mParentFragment.setOnVisibilityChangedListener(null);
        }
        super.onDetach();
        filterAndNotifyVisibility(false);
        this.mParentFragment = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        getView().removeOnAttachStateChangeListener(this);
    }

    public void onViewAttachedToWindow(View view) {
        filterAndNotifyVisibility(true);
    }

    public void onViewDetachedFromWindow(View view) {
        filterAndNotifyVisibility(false);
    }

    public void onFragmentVisibilityChanged(boolean z) {
        filterAndNotifyVisibility(z);
    }

    protected void onParentVisibilityChanged(boolean z) {
        this.mParentVisible = z;
        filterAndNotifyVisibility(z);
    }

    public void setOnVisibilityChangedListener(a aVar) {
        this.mListener = aVar;
    }

    protected void onVisibilityChanged(boolean z) {
        if (this.mListener != null) {
            this.mListener.onFragmentVisibilityChanged(z);
        }
        int i = -1;
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(getClass().getName())) {
            i = arguments.getInt(getClass().getName());
        }
        x.i(TAG, "[onVisibilityChanged] visible:%s name:%s id:%s", Boolean.valueOf(z), getClass().getName(), Integer.valueOf(i));
        com.tencent.mm.sdk.b.b kjVar = new kj();
        kjVar.fCA.name = getClass().getName();
        kjVar.fCA.id = i;
        kjVar.fCA.visible = z;
        com.tencent.mm.sdk.b.a.xmy.m(kjVar);
    }

    public boolean isFragmentVisible() {
        return this.mCurVisible;
    }

    private void filterAndNotifyVisibility(boolean z) {
        filterAndNotifyVisibility(z, false);
    }

    private void filterAndNotifyVisibility(boolean z, boolean z2) {
        if (z != this.mCurVisible) {
            boolean z3;
            boolean isFragmentVisible = this.mParentFragment == null ? this.mParentVisible : this.mParentFragment.isFragmentVisible();
            boolean isVisible = super.isVisible();
            boolean userVisibleHint = getUserVisibleHint();
            if (isFragmentVisible && isVisible && userVisibleHint && !z2) {
                z3 = true;
            } else {
                z3 = false;
            }
            x.i(TAG, "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", Boolean.valueOf(z3), Boolean.valueOf(isFragmentVisible), Boolean.valueOf(isVisible), Boolean.valueOf(userVisibleHint), getClass().getName());
            if (z3 != this.mCurVisible) {
                this.mCurVisible = z3;
                onVisibilityChanged(this.mCurVisible);
            }
        }
    }
}
