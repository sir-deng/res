package com.tencent.mm.plugin.game.gamewebview.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonLogicTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebViewMainProcessService;
import com.tencent.mm.plugin.game.gamewebview.model.a;
import com.tencent.mm.plugin.game.model.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.model.GameWebViewLaunchParams;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class GameWebViewUI extends MMActivity {
    protected c nea;
    protected int nfX = -1;
    private boolean nfY;
    private boolean nfZ;
    GameSettingParams nga;

    static /* synthetic */ void a(GameWebViewUI gameWebViewUI) {
        b bVar = (b) gameWebViewUI.nea.nee.peek();
        if (bVar != null) {
            bVar.nco.aPT();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.GameWebViewUI", "onCreate");
        if (VERSION.SDK_INT >= 11) {
            getWindow().setFlags(16777216, 16777216);
        }
        getWindow().setFormat(-3);
        final GWMainProcessTask commonLogicTask = new CommonLogicTask();
        commonLogicTask.type = 10;
        commonLogicTask.nby = new Runnable() {
            public final void run() {
                commonLogicTask.afz();
                commonLogicTask.mym.setClassLoader(GameSettingParams.class.getClassLoader());
                GameWebViewUI.this.nga = (GameSettingParams) commonLogicTask.mym.getParcelable("game_setting_params");
                GameWebViewUI.a(GameWebViewUI.this);
            }
        };
        commonLogicTask.afy();
        GameWebViewMainProcessService.a(commonLogicTask);
        this.nfY = getIntent().getBooleanExtra("disable_swipe_back", false);
        initView();
    }

    public void onNewIntent(Intent intent) {
        x.i("MicroMsg.GameWebViewUI", "onNewIntent: " + System.currentTimeMillis());
        d(intent, false);
    }

    protected void onResume() {
        super.onResume();
        x.i("MicroMsg.GameWebViewUI", "onResume");
        if (getSwipeBackLayout() != null) {
            if (this.nfY) {
                getSwipeBackLayout().mEnable = false;
            } else {
                getSwipeBackLayout().mEnable = this.nfZ;
            }
        }
        afw();
        b bVar = (b) this.nea.nee.peek();
        if (bVar != null) {
            bVar.aeJ();
        }
    }

    public void onPause() {
        super.onPause();
        x.i("MicroMsg.GameWebViewUI", "onPause");
        b bVar = (b) this.nea.nee.peek();
        if (bVar != null) {
            bVar.fz(true);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.GameWebViewUI", "onDestroy");
        a.cleanup();
        this.nea.cleanup();
        System.gc();
    }

    protected void initView() {
        View frameLayout = new FrameLayout(this);
        frameLayout.setBackgroundResource(17170443);
        frameLayout.setId(R.h.ckK);
        setContentView(frameLayout);
        this.nea = new c(this);
        this.nea.setBackgroundResource(17170443);
        this.nea.setId(R.h.ckU);
        frameLayout.addView(this.nea);
        d(getIntent(), true);
    }

    private void d(Intent intent, boolean z) {
        x.d("MicroMsg.GameWebViewUI", "loadIntent: " + System.currentTimeMillis());
        setIntent(intent);
        this.nea.c(intent, z);
        this.nfX = intent.getIntExtra("screen_orientation", -1);
        intent.setExtrasClassLoader(GameWebViewLaunchParams.class.getClassLoader());
        GameWebViewLaunchParams gameWebViewLaunchParams = (GameWebViewLaunchParams) intent.getParcelableExtra("launchParams");
        if (gameWebViewLaunchParams != null) {
            final GameFloatLayerInfo gameFloatLayerInfo = gameWebViewLaunchParams.nka;
            if (gameFloatLayerInfo != null) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", gameFloatLayerInfo.url);
                        intent.putExtra("show_full_screen", gameFloatLayerInfo.nhE);
                        intent.putExtra("screen_orientation", gameFloatLayerInfo.orientation);
                        intent.putExtra("transparent_page", true);
                        intent.putExtra("needAnimation", false);
                        GameWebViewUI.this.d(intent, false);
                    }
                }, 200);
            }
        }
        if (aQw()) {
            d.cI(this.mController.xRr);
        } else {
            d.cJ(this.mController.xRr);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        this.nea.fA(true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.nea.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean noActionBar() {
        return true;
    }

    protected final void onCreateBeforeSetContentView() {
        super.onCreateBeforeSetContentView();
        getWindow().requestFeature(10);
        getWindow().getDecorView().setFitsSystemWindows(true);
        supportRequestWindowFeature(10);
        supportRequestWindowFeature(1);
    }

    protected void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        super.onActivityResult(r6, r7, r8);
        r0 = r5.nea;
        if (r0 == 0) goto L_0x0028;
    L_0x0009:
        r0 = r5.nea;
        r0 = r0.nee;
        r0 = r0.peek();
        r0 = (com.tencent.mm.plugin.game.gamewebview.ui.b) r0;
        if (r0 == 0) goto L_0x0041;
    L_0x0015:
        r0 = r0.nco;
        r3 = r0.neO;
        if (r3 == 0) goto L_0x0029;
    L_0x001b:
        r3 = r0.neO;
        r4 = r0.nef;
        r3 = r3.b(r4, r6, r7, r8);
        if (r3 == 0) goto L_0x0029;
    L_0x0025:
        r0 = r1;
    L_0x0026:
        if (r0 == 0) goto L_0x0028;
    L_0x0028:
        return;
    L_0x0029:
        r3 = r0.neq;
        if (r3 == 0) goto L_0x003f;
    L_0x002d:
        r0 = r0.neq;
        r3 = r0.nfA;
        if (r3 == 0) goto L_0x003d;
    L_0x0033:
        r0 = r0.nfA;
        r0 = r0.onActivityResult(r6, r7, r8);
    L_0x0039:
        if (r0 == 0) goto L_0x003f;
    L_0x003b:
        r0 = r1;
        goto L_0x0026;
    L_0x003d:
        r0 = r2;
        goto L_0x0039;
    L_0x003f:
        r0 = r2;
        goto L_0x0026;
    L_0x0041:
        r0 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void K(final Intent intent) {
        runOnUiThread(new Runnable() {
            public final void run() {
                GameWebViewUI.this.d(intent, false);
            }
        });
    }

    public final void rb(int i) {
        if (!this.nfY && getSwipeBackLayout() != null) {
            if (aQw() || i > 1) {
                this.nfZ = false;
                getSwipeBackLayout().mEnable = false;
                return;
            }
            this.nfZ = true;
            getSwipeBackLayout().mEnable = true;
        }
    }

    private boolean aQw() {
        return getIntent().getBooleanExtra("from_shortcut", false);
    }

    protected final void afw() {
        if (this.nfX != -1) {
            setRequestedOrientation(this.nfX);
            return;
        }
        this.xQT = getSharedPreferences(ad.cgf(), 4).getBoolean("settings_landscape_mode", false);
        if (this.xQT) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    public final void rc(int i) {
        this.nfX = i;
        afw();
    }
}
