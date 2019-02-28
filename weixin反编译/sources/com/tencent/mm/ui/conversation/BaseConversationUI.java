package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;

public class BaseConversationUI extends MMFragmentActivity {
    private static final long BACK_INTERVAL_MAX = 30000;
    private static final String LAST_RESTORE_TALKER = "last_restore_talker";
    static final String TAG = "MicroMsg.BaseConversationUI";
    private OnLayoutChangedLinearLayout chattingFragmentView;
    private com.tencent.mm.ui.chatting.ChattingUI.a chattingFragmet;
    private int chattingID = -1;
    private View chattingUIAbVeiwCache;
    private View chattingUIContentViewCache;
    private TestTimeForChatting chattingView;
    private long chattinguiResumeTime = 0;
    public b conversationFm;
    private boolean isAnimating;
    private String lastRestoreTalker;
    private a launcherUIStatus = a.ACTIVITY_CREATE;
    private ActionBar mActionBar;
    private com.tencent.mm.ui.b mActionBarHelper;
    private long mBackOnKeyDownTS = 0;
    public boolean mChattingClosed = true;
    private Animation mChattingInAnim;
    private Animation mChattingOutAnim;
    private boolean mHasBackOnKeyDown = false;
    private boolean mNeedChattingAnim = false;
    private Bitmap mPrepareBitmap;
    private com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a() {
        long start = 0;

        public final void con() {
            if (BaseConversationUI.this.mChattingInAnim == null) {
                BaseConversationUI.this.mChattingInAnim = AnimationUtils.loadAnimation(BaseConversationUI.this, com.tencent.mm.ui.MMFragmentActivity.a.xSL);
                BaseConversationUI.this.mChattingInAnim.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        x.i(BaseConversationUI.TAG, "klem onAnimationStart onDrawed->onAnimationStart:%sms", Long.valueOf(System.currentTimeMillis() - AnonymousClass8.this.start));
                        BaseConversationUI.this.isAnimating = true;
                        BaseConversationUI.this.doJobOnChattingAnimStart();
                        BaseConversationUI.this.onSettle(false, 0);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        BaseConversationUI.this.isAnimating = false;
                        x.i(BaseConversationUI.TAG, "klem animationEnd");
                        BaseConversationUI.this.doJobOnChattingAnimEnd();
                    }
                });
            }
            if (BaseConversationUI.this.mNeedChattingAnim) {
                BaseConversationUI.this.chattingView.zws = new com.tencent.mm.ui.tools.TestTimeForChatting.a() {
                    public final void coo() {
                        x.i(BaseConversationUI.TAG, "[onDrawed]");
                        AnonymousClass8.this.start = System.currentTimeMillis();
                        if (BaseConversationUI.this.chattingFragmet.getSwipeBackLayout() != null) {
                            BaseConversationUI.this.chattingFragmet.getSwipeBackLayout().startAnimation(BaseConversationUI.this.mChattingInAnim);
                        } else {
                            BaseConversationUI.this.chattingFragmet.getView().startAnimation(BaseConversationUI.this.mChattingInAnim);
                        }
                        BaseConversationUI.this.chattingView.zws = null;
                    }
                };
                BaseConversationUI.this.mNeedChattingAnim = false;
            } else {
                BaseConversationUI.this.doJobOnChattingAnimStart();
                BaseConversationUI.this.doJobOnChattingAnimEnd();
            }
            BaseConversationUI.this.chattingFragmentView.ypk = null;
            x.i(BaseConversationUI.TAG, "klem CHATTING ONLAYOUT ");
        }
    };
    Bundle pendingBundle;
    String pendingUser;
    private c selectImageJob = new c();
    Runnable startChattingRunnable = new Runnable() {
        public final void run() {
            BaseConversationUI.this.mChattingClosed = false;
            if (!BaseConversationUI.this.isFinishing()) {
                boolean z;
                String str = BaseConversationUI.TAG;
                String str2 = "ashutest::startChatting, ishow:%b";
                Object[] objArr = new Object[1];
                if (BaseConversationUI.this.chattingView == null) {
                    z = false;
                } else {
                    z = BaseConversationUI.this.chattingView.isShown();
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                Intent putExtra = new Intent().putExtra("Chat_User", BaseConversationUI.this.pendingUser);
                if (BaseConversationUI.this.pendingBundle != null) {
                    putExtra.putExtras(BaseConversationUI.this.pendingBundle);
                }
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                BaseConversationUI.this.prepareChattingFragment(putExtra);
                BaseConversationUI.this.chattingFragmentView.ypk = BaseConversationUI.this.onChattingLayoutChangedListener;
                BaseConversationUI.this.chattingView.setTranslationX((BaseConversationUI.this.getWindow().getDecorView().getWidth() == 0 ? (float) BaseConversationUI.this.getResources().getDisplayMetrics().widthPixels : (float) BaseConversationUI.this.getWindow().getDecorView().getWidth()) - 0.1f);
                BaseConversationUI.this.chattingView.setVisibility(0);
                BaseConversationUI.this.pauseMainFragment();
                if (BaseConversationUI.this.chattingFragmet.isSupportNavigationSwipeBack()) {
                    l.a(BaseConversationUI.this);
                }
                e.post(new Runnable() {
                    public final void run() {
                        d.b(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                        d.b(3, "ChattingUI" + BaseConversationUI.this.chattingFragmet.ctz(), BaseConversationUI.this.chattingFragmet.hashCode());
                    }
                }, "directReport_startChattingRunnable");
                BaseConversationUI.this.chattinguiResumeTime = bi.Wx();
            }
        }

        public final String toString() {
            return super.toString() + "|startChattingRunnable";
        }
    };
    private String title;

    private enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE
    }

    private class c implements Runnable {
        int bjW;
        int fzQ;
        Intent fzR;
        int xUy;

        private c() {
            this.xUy = 0;
        }

        /* synthetic */ c(BaseConversationUI baseConversationUI, byte b) {
            this();
        }

        public final void run() {
            if (as.Hp()) {
                x.i(BaseConversationUI.TAG, "on post select image job, acc has ready, retry count %d", Integer.valueOf(this.xUy));
                BaseConversationUI.this.startChatting(BaseConversationUI.this.lastRestoreTalker);
                ah.y(new Runnable() {
                    public final void run() {
                        boolean z = true;
                        String str = BaseConversationUI.TAG;
                        String str2 = "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B";
                        Object[] objArr = new Object[1];
                        if (BaseConversationUI.this.chattingFragmet != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        x.d(str, str2, objArr);
                        if (BaseConversationUI.this.chattingFragmet != null) {
                            x.d(BaseConversationUI.TAG, "on select image ActivityResult. do post activity result");
                            BaseConversationUI.this.chattingFragmet.onActivityResult(c.this.fzQ & 65535, c.this.bjW, c.this.fzR);
                        }
                    }

                    public final String toString() {
                        return super.toString() + "|PostSelectImageJob_onActivityResult";
                    }
                });
            } else if (this.xUy >= 3) {
                x.w(BaseConversationUI.TAG, "on post select image job, match max retry count");
            } else {
                x.w(BaseConversationUI.TAG, "on post select image job, acc not ready, cur retry count %d", Integer.valueOf(this.xUy));
                this.xUy++;
                ah.h(this, 300);
            }
        }

        public final String toString() {
            return super.toString() + "|PostSelectImageJob";
        }
    }

    public static class b extends u {
        private a fmStatus = a.ACTIVITY_CREATE;
        public BaseConversationUI ui;

        public int getLayoutId() {
            return 0;
        }

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            this.fmStatus = a.ACTIVITY_CREATE;
            this.ui = (BaseConversationUI) thisActivity();
            View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            setHasOptionsMenu(true);
            return inflate;
        }

        public void setMMTitle(String str) {
            if (this.ui != null) {
                this.ui.setTitle(str);
            }
        }

        public void finish() {
            thisActivity().finish();
        }

        public void onResume() {
            super.onResume();
            this.fmStatus = a.ACTIVITY_RESUME;
        }

        public void onPause() {
            super.onPause();
            this.fmStatus = a.ACTIVITY_PAUSE;
        }

        public void onDestroy() {
            if (this.fmStatus != a.ACTIVITY_PAUSE) {
                x.w(BaseConversationUI.TAG, "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
                onPause();
            }
            super.onDestroy();
        }

        public String getUserName() {
            return null;
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.e.O(this);
        super.onCreate(bundle);
        getWindow().setCallback(new com.tencent.mm.ui.b.c(getWindow().getCallback(), this));
        this.mActionBar = getSupportActionBar();
        initNavigationSwipeBack();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        x.i(TAG, "onNewIntent");
        setIntent(intent);
    }

    protected void onResume() {
        super.onResume();
        l.b(this);
        onSwipe(1.0f);
        this.launcherUIStatus = a.ACTIVITY_RESUME;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        e.post(new Runnable() {
            public final void run() {
                d.b(3, z ? "ChattingUI" + BaseConversationUI.this.chattingFragmet.ctz() : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
            }
        }, "directReport_onResume");
        if (!z) {
            this.chattinguiResumeTime = bi.Wx();
        }
        if (com.tencent.mm.compatible.util.d.fN(19) && com.tencent.mm.compatible.i.a.zj()) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (BaseConversationUI.this.chattingView == null) {
                        if (BaseConversationUI.this.chattingUIContentViewCache == null) {
                            BaseConversationUI.this.chattingUIContentViewCache = v.fw(BaseConversationUI.this).inflate(R.i.dcZ, null);
                        }
                        if (BaseConversationUI.this.chattingUIAbVeiwCache == null) {
                            BaseConversationUI.this.chattingUIAbVeiwCache = v.fw(BaseConversationUI.this).inflate(R.i.dac, null);
                        }
                    }
                    x.d(BaseConversationUI.TAG, "prepare chattingUI view use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            });
            if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                this.chattingFragmet.getSwipeBackLayout().mEnable = true;
            }
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (BaseConversationUI.this.chattingView == null) {
                        String FY;
                        if (BaseConversationUI.this.conversationFm == null || bi.oN(BaseConversationUI.this.conversationFm.getUserName())) {
                            FY = q.FY();
                        } else {
                            FY = BaseConversationUI.this.conversationFm.getUserName();
                        }
                        BaseConversationUI.this.prepareChattingFragment(new Intent().putExtra("Chat_User", FY));
                        BaseConversationUI.this.chattingFragmet.ocy = true;
                        BaseConversationUI.this.chattingFragmet.ctx();
                        BaseConversationUI.this.chattingView.setVisibility(8);
                        BaseConversationUI.this.chattingFragmet.isPreLoaded = true;
                        BaseConversationUI.this.chattingFragmet.onPause();
                        BaseConversationUI.this.chattingFragmet.ctv();
                        BaseConversationUI.this.chattingFragmet.hJu = false;
                        BaseConversationUI.this.resumeMainFragment();
                    }
                    BaseConversationUI.this.chattingUIContentViewCache = null;
                    BaseConversationUI.this.chattingUIAbVeiwCache = null;
                    x.d(BaseConversationUI.TAG, "prepare chattingUI logic use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return false;
                }
            });
        }
        initActionBar();
        this.mActionBar.show();
    }

    protected void onPause() {
        x.i(TAG, "on pause");
        super.onPause();
        if (!isFinishing()) {
            l.a(this);
        }
        this.launcherUIStatus = a.ACTIVITY_PAUSE;
        final boolean z = this.chattingView != null && this.chattingView.isShown();
        e.post(new Runnable() {
            public final void run() {
                d.b(4, z ? "ChattingUI" + BaseConversationUI.this.chattingFragmet.ctz() : BaseConversationUI.this.getLocalClassName(), z ? BaseConversationUI.this.chattingFragmet.hashCode() : BaseConversationUI.this.hashCode());
                if (z) {
                    d.g("ChattingUI" + BaseConversationUI.this.chattingFragmet.ctz(), BaseConversationUI.this.chattinguiResumeTime, t.Wx());
                }
            }
        }, "directReport_onPause");
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().mEnable = false;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
            this.mPrepareBitmap.recycle();
        }
        this.chattingFragmet = null;
        this.chattingFragmentView = null;
        this.chattingView = null;
        this.conversationFm = null;
        this.mActionBarHelper = null;
        this.mChattingInAnim = null;
        this.mChattingOutAnim = null;
    }

    public void onSwipe(float f) {
        x.v(TAG, "ashutest::on swipe %f, duration %d, status %s", Float.valueOf(f), Long.valueOf(240), this.launcherUIStatus);
        if (com.tencent.mm.compatible.util.d.fN(19) && com.tencent.mm.compatible.i.a.zj()) {
            ImageView imageView;
            if (f == 0.0f && !this.mChattingClosed) {
                imageView = (ImageView) getWindow().getDecorView().findViewById(R.h.cDu);
                if (imageView != null) {
                    ViewGroup viewGroup = (ViewGroup) imageView.getTag();
                    if (viewGroup != null) {
                        Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup);
                        if (magicDrawingCache != null) {
                            x.i(TAG, "[onSwipe] prepareView VISIBLE");
                            imageView.setVisibility(0);
                            imageView.setImageBitmap(magicDrawingCache);
                            viewGroup.setVisibility(8);
                        } else {
                            x.i(TAG, "[onSwipe] prepareView GONE");
                            viewGroup.setVisibility(0);
                            imageView.setVisibility(8);
                            imageView.setImageDrawable(null);
                        }
                    }
                }
                if (this.mChattingInAnim != null) {
                    this.mChattingInAnim.cancel();
                }
            } else if (f == 1.0f && !this.mChattingClosed && !this.mChattingClosed && this.chattingFragmet.isSupportNavigationSwipeBack()) {
                getWindow().setBackgroundDrawableResource(R.e.btF);
                imageView = (ImageView) getWindow().getDecorView().findViewById(R.h.cDu);
                if (!(imageView == null || imageView.getVisibility() != 0 || imageView.getTag() == null)) {
                    ((View) imageView.getTag()).setVisibility(0);
                    x.i(TAG, "[onSwipe] prepareView GONE");
                    imageView.setVisibility(8);
                }
            }
            if (a.ACTIVITY_RESUME == this.launcherUIStatus || Float.compare(1.0f, f) <= 0) {
                View findViewById = findViewById(R.h.csD);
                imageView = (ImageView) findViewById(R.h.cDu);
                if (!(imageView == null || imageView.getVisibility() != 8 || imageView.getDrawable() == null || this.mChattingClosed || f == 1.0f || f == 0.0f)) {
                    imageView.setVisibility(0);
                    x.i(TAG, "[onSwipe] !1 && !0 prepareView VISIBLE");
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                }
                resetViewTranX(findViewById, imageView, f);
                return;
            }
            x.i(TAG, "[onSwipe] return! consumedSuperCall:%s", Float.valueOf(f));
        }
    }

    private void resetViewTranX(View view, ImageView imageView, float f) {
        x.i(TAG, "[resetViewTranX] scrollParent:%s", Float.valueOf(f));
        if (Float.compare(1.0f, f) <= 0) {
            j.n(view, 0.0f);
            j.n(imageView, 0.0f);
        } else if (imageView == null || imageView.getDrawable() == null) {
            x.i(TAG, "[resetViewTranX] container");
            j.n(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        } else {
            x.i(TAG, "[resetViewTranX] prepareView");
            j.n(imageView, (((float) (imageView.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.conversationFm != null) {
            this.conversationFm.onActivityResult(i, i2, intent);
        }
        if (i2 == -1) {
            if (i == 2001 && this.chattingFragmet != null) {
                this.chattingFragmet.onActivityResult(i, i2, intent);
            }
            if (acceptRequestCode(i) && this.chattingFragmet == null) {
                x.i(TAG, "on select image ActivityResult. the chattingUI maybe kill in the background.");
                ah.K(this.selectImageJob);
                this.selectImageJob.xUy = 0;
                this.selectImageJob.fzQ = i;
                this.selectImageJob.bjW = i2;
                this.selectImageJob.fzR = intent;
                ah.y(this.selectImageJob);
            }
        }
    }

    private void doJobOnChattingAnimStart() {
        this.chattingView.setTranslationX(0.0f);
        this.chattingView.gVd = 0;
    }

    private void doJobOnChattingAnimEnd() {
        ah.y(new Runnable() {
            public final void run() {
                BaseConversationUI.this.onSwipe(1.0f);
                as.Dt().cgr();
                ah.Dy(0);
                BaseConversationUI.this.onSwipe(1.0f);
                if (!(BaseConversationUI.this.chattingView == null || BaseConversationUI.this.chattingFragmet == null)) {
                    BaseConversationUI.this.chattingView.cyU();
                    BaseConversationUI.this.chattingFragmet.ocy = true;
                    BaseConversationUI.this.chattingFragmet.ctx();
                    BaseConversationUI.this.chattingFragmet.mS(false);
                }
                BaseConversationUI.this.tryResetChattingSwipeStatus();
            }

            public final String toString() {
                return super.toString() + "|chattingView_onAnimationEnd";
            }
        });
    }

    private void tryResetChattingSwipeStatus() {
        boolean z = true;
        if (com.tencent.mm.compatible.util.d.fN(19) && com.tencent.mm.compatible.i.a.zj()) {
            String str = TAG;
            String str2 = "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.chattingFragmet != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.chattingFragmet != null) {
                this.chattingFragmet.getSwipeBackLayout().zBF = false;
            }
        }
    }

    public void startChatting(String str) {
        startChatting(str, null, false);
    }

    public void startChatting(String str, Bundle bundle, boolean z) {
        String str2 = TAG;
        String str3 = "try startChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        x.i(str2, str3, objArr);
        this.pendingBundle = bundle;
        this.pendingUser = str;
        this.mNeedChattingAnim = z;
        as.Dt().cgp();
        ah.Dy(-8);
        ah.y(this.startChattingRunnable);
    }

    @TargetApi(19)
    private void prepareChattingFragment(Intent intent) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.chattingFragmet == null) {
            this.chattingFragmet = getChattingUIFragment();
            this.chattingFragmet.d(this.chattingUIContentViewCache, this.chattingUIAbVeiwCache);
            this.chattingUIContentViewCache = null;
            this.chattingUIAbVeiwCache = null;
            z = true;
        } else {
            z = false;
        }
        final int[] iArr;
        View findRootContainer;
        if (this.chattingView == null) {
            if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
                ViewGroup viewGroup;
                iArr = new int[2];
                getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                View testTimeForChatting = new TestTimeForChatting(this);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                testTimeForChatting.setId(R.h.bTQ);
                this.chattingID = testTimeForChatting.getId();
                testTimeForChatting.setOrientation(1);
                testTimeForChatting.setLayoutParams(layoutParams);
                final View fitSystemWindowLayoutView = new FitSystemWindowLayoutView(this);
                fitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                findRootContainer = findRootContainer();
                if (findRootContainer == null) {
                    findRootContainer = ((ViewGroup) getWindow().getDecorView()).getChildAt(0);
                }
                if (findRootContainer instanceof SwipeBackLayout) {
                    viewGroup = (ViewGroup) ((ViewGroup) findRootContainer).getChildAt(0);
                } else {
                    viewGroup = (ViewGroup) findRootContainer;
                }
                View imageView = new ImageView(this);
                imageView.setId(R.h.cDu);
                imageView.setLayoutParams(testTimeForChatting.getLayoutParams());
                imageView.setVisibility(8);
                ((ViewGroup) getWindow().getDecorView()).removeView(findRootContainer);
                findRootContainer.setId(R.h.csD);
                fitSystemWindowLayoutView.addView(findRootContainer);
                fitSystemWindowLayoutView.addView(imageView);
                fitSystemWindowLayoutView.addView(testTimeForChatting);
                ((ViewGroup) getWindow().getDecorView()).addView(fitSystemWindowLayoutView);
                getWindow().getDecorView().requestFitSystemWindows();
                int i = iArr[1];
                if (i > 0) {
                    updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                } else {
                    getSupportActionBar().getCustomView().post(new Runnable() {
                        public final void run() {
                            BaseConversationUI.this.getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                            int i = iArr[1];
                            if (i > 0) {
                                BaseConversationUI.this.updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), viewGroup);
                            } else if (com.tencent.mm.compatible.util.d.fN(20)) {
                                fitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                                    @TargetApi(20)
                                    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                        if (windowInsets != null) {
                                            x.i(BaseConversationUI.TAG, "OnApplyWindowInsetsListener %s", windowInsets);
                                            windowInsets.consumeSystemWindowInsets();
                                            BaseConversationUI.this.updateRootViewSystemWindowsInsets(fitSystemWindowLayoutView, windowInsets.getSystemWindowInsetTop(), new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), viewGroup);
                                        }
                                        return windowInsets;
                                    }
                                });
                            }
                        }
                    });
                }
                this.chattingView = (TestTimeForChatting) findViewById(this.chattingID);
                x.i(TAG, "ashu::prepareChattingFragment init chattingView, top %s", Integer.valueOf(iArr[1]));
            } else {
                this.chattingView = (TestTimeForChatting) findViewById(R.h.bTu);
                this.chattingID = this.chattingView.getId();
            }
        } else if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
            iArr = new int[2];
            this.chattingView.getLocationInWindow(iArr);
            if (iArr[1] == 0) {
                ViewGroup viewGroup2 = (ViewGroup) getWindow().getDecorView();
                int i2 = 0;
                while (i2 < viewGroup2.getChildCount()) {
                    findRootContainer = ((ViewGroup) getWindow().getDecorView()).getChildAt(i2);
                    if (findRootContainer instanceof FitSystemWindowLayoutView) {
                        getSupportActionBar().getCustomView().getLocationInWindow(iArr);
                        FitSystemWindowLayoutView fitSystemWindowLayoutView2 = (FitSystemWindowLayoutView) findRootContainer;
                        fitSystemWindowLayoutView2.fitSystemWindows(new Rect(0, fitSystemWindowLayoutView2.xPi, 0, 0));
                        x.i(TAG, "rootLayout2 fitSystemWindows, top %s", Integer.valueOf(iArr[1]));
                        viewGroup2 = (ViewGroup) viewGroup2.findViewById(R.h.csD);
                        ImageView imageView2 = (ImageView) fitSystemWindowLayoutView2.findViewById(R.h.cDu);
                        imageView2.setTag(viewGroup2);
                        imageView2.setLayoutParams(viewGroup2.getLayoutParams());
                        Bitmap magicDrawingCache = getMagicDrawingCache(viewGroup2);
                        if (magicDrawingCache != null) {
                            imageView2.setImageBitmap(magicDrawingCache);
                            viewGroup2.setVisibility(8);
                            imageView2.setVisibility(0);
                            x.i(TAG, "[prepareChattingFragment] prepareView VISIBLE");
                        } else {
                            imageView2.setImageBitmap(null);
                        }
                    } else {
                        x.e(TAG, "on position %d, rootLayout not found!", Integer.valueOf(i2));
                        i2++;
                    }
                }
            }
            x.i(TAG, "ashu::prepareChattingFragment has chattingView, top %s", Integer.valueOf(iArr[1]));
        }
        if (z) {
            this.chattingFragmet.hJu = true;
            this.chattingFragmet.ocy = false;
            this.chattingFragmet.setArguments(com.tencent.mm.sdk.platformtools.t.ah(intent));
            getSupportFragmentManager().aT().a(this.chattingID, this.chattingFragmet).commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            this.chattingFragmentView = (OnLayoutChangedLinearLayout) this.chattingFragmet.getView().findViewById(R.h.bTC);
            this.chattingFragmet.mS(true);
        } else {
            this.chattingFragmet.hJu = true;
            this.chattingFragmet.ocy = false;
            this.chattingFragmet.getArguments().putAll(com.tencent.mm.sdk.platformtools.t.ah(intent));
            this.chattingFragmet.crK();
            this.chattingFragmet.onResume();
            this.chattingFragmet.mS(true);
        }
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
            this.chattingFragmet.getSwipeBackLayout().nM(false);
        }
        x.i(TAG, "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z), intent);
    }

    public Bitmap getMagicDrawingCache(View view) {
        int measuredWidth;
        int measuredHeight;
        long currentTimeMillis = System.currentTimeMillis();
        int width = view.getWidth();
        int height = view.getHeight();
        if (width <= 0) {
            measuredWidth = view.getMeasuredWidth();
        } else {
            measuredWidth = width;
        }
        if (height <= 0) {
            measuredHeight = view.getMeasuredHeight();
        } else {
            measuredHeight = height;
        }
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            x.e(TAG, "viewWidth:%s viewHeight:%s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            return null;
        }
        if (this.chattingFragmet != null) {
            x.i(TAG, "getBottom:%s keyboardState:%s", Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()));
        }
        if (this.chattingFragmet != null && this.chattingFragmet.keyboardState() == 1 && this.chattingFragmet.getView().getBottom() < (getResources().getDisplayMetrics().heightPixels * 2) / 3) {
            x.e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            return null;
        } else if (this.chattingFragmet == null || this.chattingFragmet.keyboardState() != 1) {
            if (this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled() || this.mPrepareBitmap.getWidth() != measuredWidth || this.mPrepareBitmap.getHeight() != measuredHeight) {
                if (!(this.mPrepareBitmap == null || this.mPrepareBitmap.isRecycled())) {
                    this.mPrepareBitmap.recycle();
                }
                try {
                    this.mPrepareBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_4444);
                } catch (OutOfMemoryError e) {
                    x.e(TAG, "[getMagicDrawingCache] e:%s", e);
                    return null;
                }
            }
            this.mPrepareBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mPrepareBitmap);
            width = (int) getResources().getDimension(R.f.byt);
            int dimension = (int) getResources().getDimension(R.f.buI);
            Paint paint = new Paint();
            paint.setColor(-1);
            canvas.drawRect(0.0f, (float) width, (float) measuredWidth, (float) (measuredHeight - dimension), paint);
            view.draw(canvas);
            x.i(TAG, "[getMagicDrawingCache] cost%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return this.mPrepareBitmap;
        } else {
            x.e(TAG, "hardKeyboardHidden:%s", Integer.valueOf(this.chattingFragmet.keyboardState()));
            return null;
        }
    }

    private void updateRootViewSystemWindowsInsets(FitSystemWindowLayoutView fitSystemWindowLayoutView, int i, Rect rect, ViewGroup viewGroup) {
        int i2;
        int bottom = getWindow().getDecorView().getBottom();
        int bottom2 = getSupportActionBar().getCustomView().getBottom();
        if (this.conversationFm == null || this.conversationFm.getView() == null) {
            i2 = 0;
        } else {
            i2 = bottom - ((i + bottom2) + this.conversationFm.getView().getBottom());
        }
        x.i(TAG, "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", Integer.valueOf(bottom), Integer.valueOf(i), Integer.valueOf(bottom2), Integer.valueOf(i2));
        fitSystemWindowLayoutView.xPj = viewGroup;
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    private ViewGroup findRootContainer() {
        ViewParent parent = this.mActionBar.getCustomView().getParent();
        ViewParent viewParent = null;
        ViewParent viewParent2 = (ViewGroup) getWindow().getDecorView();
        while (parent != viewParent2 && parent != null) {
            ViewParent viewParent3 = parent;
            parent = parent.getParent();
            viewParent = viewParent3;
        }
        return (ViewGroup) viewParent;
    }

    public void pauseMainFragment() {
        if (this.conversationFm != null && !this.conversationFm.isSupportNavigationSwipeBack()) {
            this.conversationFm.showOptionMenu(false);
        }
    }

    public void resumeMainFragment() {
        if (this.conversationFm != null) {
            this.conversationFm.onResume();
            if (!this.conversationFm.isSupportNavigationSwipeBack()) {
                this.conversationFm.showOptionMenu(true);
            }
        }
    }

    public void closeChatting(boolean z) {
        String str = TAG;
        String str2 = "try closeChatting, ishow:%b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.chattingView == null ? false : this.chattingView.isShown());
        x.i(str, str2, objArr);
        if (this.chattingFragmet != null && this.chattingFragmet.isSupportNavigationSwipeBack()) {
            l.b(this);
        }
        if (this.chattingView != null && this.chattingView.getVisibility() != 8 && this.chattingFragmet != null) {
            x.i(TAG, "[closeChatting] needAnim:%s", Boolean.valueOf(z));
            this.chattingView.setVisibility(8);
            this.mChattingClosed = true;
            if (this.mChattingOutAnim == null) {
                this.mChattingOutAnim = AnimationUtils.loadAnimation(this, com.tencent.mm.ui.MMFragmentActivity.a.xSO);
                this.mChattingOutAnim.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                        as.Dt().cgp();
                        ah.Dy(-8);
                        x.i(BaseConversationUI.TAG, "klem pop out onAnimationStart");
                        BaseConversationUI.this.onSettle(true, 0);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        as.Dt().cgr();
                        ah.Dy(0);
                        BaseConversationUI.this.tryResetChattingSwipeStatus();
                        x.i(BaseConversationUI.TAG, "klem pop out onAnimationEnd");
                    }
                });
            }
            this.chattingFragmet.onPause();
            this.chattingFragmet.ctv();
            this.chattingFragmet.hJu = false;
            if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
                ImageView imageView = (ImageView) getWindow().getDecorView().findViewById(R.h.cDu);
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(8);
                    x.i(TAG, "[closeChatting] prepareView GONE");
                    if (imageView.getTag() != null) {
                        ((View) imageView.getTag()).setVisibility(0);
                    }
                }
            }
            if (z) {
                this.chattingView.startAnimation(this.mChattingOutAnim);
            } else {
                onSwipe(1.0f);
                tryResetChattingSwipeStatus();
            }
            if (!this.chattingFragmet.isSupportNavigationSwipeBack()) {
                initActionBar();
            }
            supportInvalidateOptionsMenu();
            resumeMainFragment();
            e.post(new Runnable() {
                public final void run() {
                    d.b(4, "ChattingUI" + BaseConversationUI.this.chattingFragmet.ctz(), BaseConversationUI.this.chattingFragmet.hashCode());
                    d.g("ChattingUI" + BaseConversationUI.this.chattingFragmet.ctz(), BaseConversationUI.this.chattinguiResumeTime, t.Wx());
                    d.b(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                }
            }, "directReport_closeChatting");
        }
    }

    private void initActionBar() {
        if (this.chattingFragmet == null || !this.chattingFragmet.hJu) {
            View inflate = v.fw(this).inflate(R.i.dac, null);
            this.mActionBarHelper = new com.tencent.mm.ui.b(inflate);
            this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
            this.mActionBar.cP();
            this.mActionBar.setDisplayHomeAsUpEnabled(false);
            this.mActionBar.cO();
            this.mActionBar.cQ();
            this.mActionBar.setCustomView(inflate);
            updateTitle();
            this.mActionBarHelper.o(new OnClickListener() {
                public final void onClick(View view) {
                    BaseConversationUI.this.finish();
                }
            });
        }
    }

    public void updateTitle() {
        if (this.mActionBarHelper != null) {
            this.mActionBarHelper.setTitle(r.gw(this.title));
        }
    }

    public void setTitle(String str) {
        this.title = str;
        if (this.mActionBarHelper != null) {
            updateTitle();
        }
    }

    public ActionMode onWindowStartingActionMode(Callback callback) {
        if (this.chattingFragmet == null || this.chattingFragmet.yEP.yHW == null || !this.chattingFragmet.isSupportNavigationSwipeBack()) {
            return super.onWindowStartingActionMode(callback);
        }
        if (com.tencent.mm.compatible.util.d.fP(22)) {
            return super.onWindowStartingActionMode(callback);
        }
        ActionMode startActionMode = this.chattingFragmet.yEP.yHW.startActionMode(callback);
        if (startActionMode == null) {
            return super.onWindowStartingActionMode(callback);
        }
        return startActionMode;
    }

    private boolean acceptRequestCode(int i) {
        x.w(TAG, "check request code %d", Integer.valueOf(65535 & i));
        switch (65535 & i) {
            case com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX /*217*/:
            case 218:
                return true;
            default:
                return false;
        }
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.lastRestoreTalker = bundle.getString(LAST_RESTORE_TALKER);
        x.d(TAG, "onRestoreInstantceState:%s", this.lastRestoreTalker);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.chattingFragmet != null && !bi.oN(this.chattingFragmet.csn())) {
            x.d(TAG, "onSaveInstanceState:%s", this.chattingFragmet.csn());
            bundle.putString(LAST_RESTORE_TALKER, this.chattingFragmet.csn());
        }
    }

    public void onSettle(boolean z, int i) {
        long j = 120;
        x.v(TAG, "ashutest: on settle %B, speed %d, resumeStatus %s", Boolean.valueOf(z), Integer.valueOf(i), this.launcherUIStatus);
        if (!com.tencent.mm.compatible.util.d.fN(19) || !com.tencent.mm.compatible.i.a.zj()) {
            return;
        }
        if (a.ACTIVITY_RESUME != this.launcherUIStatus) {
            super.onSettle(z, i);
            return;
        }
        View findViewById = findViewById(R.h.csD);
        if (findViewById == null) {
            x.e(TAG, "[onSettle] null == container");
            return;
        }
        View view = (ImageView) findViewById(R.h.cDu);
        if (!(view == null || view.getVisibility() != 8 || view.getDrawable() == null)) {
            view.setVisibility(0);
            x.i(TAG, "[onSettle] prepareView VISIBLE");
            findViewById.setVisibility(8);
        }
        if (view == null || view.getVisibility() != 0) {
            if (z) {
                if (i <= 0) {
                    j = 240;
                }
                j.a(findViewById, j, 0.0f, 0.125f);
                return;
            }
            if (i <= 0) {
                j = 240;
            }
            j.a(findViewById, j, (float) ((findViewById.getWidth() * -1) / 4), 0.75f);
        } else if (z) {
            if (i <= 0) {
                j = 240;
            }
            j.a(view, j, 0.0f, 0.125f);
        } else {
            if (i <= 0) {
                j = 240;
            }
            j.a(view, j, (float) ((view.getWidth() * -1) / 4), 0.75f);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Object[] objArr;
        int i = 1;
        x.i(TAG, "ui group onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ah.K(this.startChattingRunnable);
        }
        if (this.isAnimating) {
            return i;
        }
        if (this.chattingFragmet == null || !this.chattingFragmet.hJu || this.chattingFragmet.yFy) {
            if (keyEvent.getKeyCode() == 4) {
                if (keyEvent.getAction() == 0) {
                    this.mHasBackOnKeyDown = i;
                    this.mBackOnKeyDownTS = System.currentTimeMillis();
                }
                if (keyEvent.getAction() != i) {
                    return i;
                }
                x.d(TAG, "hasBack %B, %d", Boolean.valueOf(this.mHasBackOnKeyDown), Long.valueOf(System.currentTimeMillis() - this.mBackOnKeyDownTS));
                if (!this.mHasBackOnKeyDown || System.currentTimeMillis() - this.mBackOnKeyDownTS > BACK_INTERVAL_MAX) {
                    return i;
                }
                finish();
                return i;
            }
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e) {
                objArr = new Object[i];
                objArr[0] = e.getMessage();
                x.w(TAG, "dispatch key event catch exception %s", objArr);
                x.printErrStackTrace(TAG, e, "", new Object[0]);
                return 0;
            }
        } else if (this.chattingFragmet.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return i;
        } else {
            try {
                return super.dispatchKeyEvent(keyEvent);
            } catch (Throwable e2) {
                objArr = new Object[i];
                objArr[0] = e2.getMessage();
                x.w(TAG, "dispatch key event catch exception %s", objArr);
                x.printErrStackTrace(TAG, e2, "", new Object[0]);
                return 0;
            }
        }
    }

    protected com.tencent.mm.ui.chatting.ChattingUI.a getChattingUIFragment() {
        return com.tencent.mm.ui.chatting.ChattingUI.a.cts();
    }
}
