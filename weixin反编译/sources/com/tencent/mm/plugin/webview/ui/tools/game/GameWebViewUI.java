package com.tencent.mm.plugin.webview.ui.tools.game;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass60;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.o;
import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameWebViewUI extends GameBaseWebViewUI {
    private static String tLV = "wx_fullscreen";
    private Map<Integer, arl> nfE = new HashMap();
    private boolean nhE = false;
    private com.tencent.mm.plugin.webview.wepkg.a tLI;
    private int tLT;
    private boolean tLU = false;
    private HashMap<String, String> tLW = new HashMap();
    private Drawable tLX;
    private Drawable tLY;
    private String tLZ = null;
    private String tMa;
    private GameMenuImageButton tMb;
    private boolean tMc;
    private boolean tMd = false;
    private boolean tMe = false;
    private boolean tMf = false;
    private BroadcastReceiver tMg = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "com.tencent.mm.ACTION_RELOAD".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("hashcode", 0);
                if (intExtra == GameWebViewUI.this.hashCode()) {
                    GameWebViewUI.this.tMf = true;
                    if (GameWebViewUI.this.tMe) {
                        GameWebViewUI.this.bUQ();
                        return;
                    }
                    return;
                }
                a aVar = GameWebViewUI.this.tLx;
                if (intExtra == (aVar.jAa != null ? aVar.jAa.hashCode() : -1)) {
                    GameWebViewUI.this.tLx.bUQ();
                }
            }
        }
    };

    private class a extends g {
        private a() {
            super();
        }

        /* synthetic */ a(GameWebViewUI gameWebViewUI, byte b) {
            this();
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object onMiscCallBack = GameWebViewUI.this.tLI.tRU.onMiscCallBack(str, bundle);
            return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
        }
    }

    private class b extends a {
        private b() {
            super();
        }

        /* synthetic */ b(GameWebViewUI gameWebViewUI, byte b) {
            this();
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            GameWebViewUI.this.tLI.tRT.b(webView, str, bitmap);
            super.b(webView, str, bitmap);
        }

        public final void a(WebView webView, String str) {
            GameWebViewUI.J(GameWebViewUI.this);
            GameWebViewUI.this.tLI.tRT.a(webView, str);
            super.a(webView, str);
        }

        public final void a(WebView webView, int i, String str, String str2) {
            GameWebViewUI.J(GameWebViewUI.this);
            super.a(webView, i, str, str2);
        }

        public final m c(WebView webView, String str) {
            m c = GameWebViewUI.this.tLI.tRT.c(webView, str);
            return c != null ? c : super.c(webView, str);
        }

        public final m a(WebView webView, l lVar) {
            m a = GameWebViewUI.this.tLI.tRT.a(webView, lVar);
            return a != null ? a : super.a(webView, lVar);
        }

        public final m a(WebView webView, l lVar, Bundle bundle) {
            m a = GameWebViewUI.this.tLI.tRT.a(webView, lVar, bundle);
            return a != null ? a : super.a(webView, lVar, bundle);
        }
    }

    static /* synthetic */ void J(GameWebViewUI gameWebViewUI) {
        if (gameWebViewUI.tEN != null) {
            gameWebViewUI.tEN.setVisibility(8);
        }
    }

    static /* synthetic */ void af(GameWebViewUI gameWebViewUI) {
        gameWebViewUI.tLU = false;
        gameWebViewUI.Bo(255);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.Wepkg.GameWebViewUI", "GameWebViewUI oncreate");
        x.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", d.QX(this.fJB), d.QV(this.fJB));
        Intent intent = getIntent();
        if (intent != null) {
            com.tencent.mm.plugin.webview.wepkg.utils.b.tUu = intent.getBooleanExtra("disable_wepkg", false);
            if (intent.getBooleanExtra("disable_progress_bar", false)) {
                this.tEM.yiL = false;
                bUV();
            }
        }
        this.tGv = new o() {
            public final boolean z(MotionEvent motionEvent) {
                if (GameWebViewUI.this.pzt == null) {
                    return false;
                }
                return GameWebViewUI.this.pzt.O(motionEvent);
            }

            public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
                if (GameWebViewUI.this.pzt == null) {
                    return false;
                }
                return GameWebViewUI.this.pzt.b(i, i2, i3, i4, i5, i6, i7, i8, z);
            }

            public final void aik() {
                if (GameWebViewUI.this.pzt != null) {
                    GameWebViewUI.this.pzt.czP();
                }
            }

            @TargetApi(9)
            public final void b(int i, int i2, boolean z, boolean z2) {
                if (GameWebViewUI.this.pzt != null) {
                    GameWebViewUI.this.pzt.c(i, i2, z, z2);
                }
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                if (GameWebViewUI.this.pzt != null) {
                    GameWebViewUI.this.pzt.y(i, i2, i3, i4);
                    if (!GameWebViewUI.this.nhE) {
                        return;
                    }
                    if (i2 >= GameWebViewUI.this.tLT) {
                        if (GameWebViewUI.this.tLU) {
                            GameWebViewUI.af(GameWebViewUI.this);
                        }
                    } else if (i2 < GameWebViewUI.this.tLT) {
                        GameWebViewUI.this.Bo((int) ((((float) i2) / ((float) GameWebViewUI.this.tLT)) * 255.0f));
                    }
                }
            }

            public final boolean A(MotionEvent motionEvent) {
                if (GameWebViewUI.this.pzt == null) {
                    return false;
                }
                return GameWebViewUI.this.pzt.P(motionEvent);
            }

            public final boolean B(MotionEvent motionEvent) {
                if (GameWebViewUI.this.pzt == null) {
                    return false;
                }
                return GameWebViewUI.this.pzt.Q(motionEvent);
            }
        };
        if (!bi.oN(this.fJB)) {
            try {
                a(new URI(this.fJB));
            } catch (Exception e) {
                x.e("MicroMsg.Wepkg.GameWebViewUI", "parseUrl error, %s,  rawUrl = %s", e.getMessage(), this.fJB);
            }
        }
        this.tLT = bTm();
        if (this.tLW.containsKey(tLV) && ((String) this.tLW.get(tLV)).equals("1")) {
            this.nhE = true;
        }
        this.pzt.setWebViewClient(new b());
        if (this.pzt.isX5Kernel) {
            this.pzt.setWebViewClientExtension(new a());
        }
        this.tLI = new com.tencent.mm.plugin.webview.wepkg.a(this, this.pzt);
        this.tLI.tRR = new com.tencent.mm.plugin.webview.wepkg.a.a() {
            public final boolean aQe() {
                return GameWebViewUI.this.tFe;
            }
        };
        if (this.tLI.Qs(this.fJB)) {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.tMd = true;
            bUV();
        }
        this.tLx = new a(this, this.tES);
        this.tMb = new GameMenuImageButton(this.mController.xRr);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.ACTION_RELOAD");
        registerReceiver(this.tMg, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
    }

    private n aQh() {
        try {
            List list;
            List list2 = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.tMj;
            Bundle bundle = new Bundle();
            bundle.putString("game_hv_menu_appid", this.tMa);
            if (this.jAm != null) {
                bundle = this.jAm.e(92, bundle);
            } else {
                bundle = null;
            }
            if (bundle != null) {
                String string = bundle.getString("game_hv_menu_pbcache");
                if (!bi.oN(string)) {
                    byte[] bytes = string.getBytes("ISO-8859-1");
                    akd akd = new akd();
                    akd.aH(bytes);
                    if (!bi.cC(akd.wxT)) {
                        LinkedList linkedList = akd.wxT;
                        x.i("MicroMsg.Wepkg.GameWebViewUI", "use net menu data");
                        list = linkedList;
                        this.nfE.clear();
                        for (arl arl : list) {
                            this.nfE.put(Integer.valueOf(arl.wFZ), arl);
                        }
                        return c.bUW().i(list, Vi());
                    }
                }
            }
            list = list2;
            this.nfE.clear();
            for (arl arl2 : list) {
                this.nfE.put(Integer.valueOf(arl2.wFZ), arl2);
            }
            return c.bUW().i(list, Vi());
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", e.getMessage());
            return null;
        }
    }

    protected final void aQg() {
        if (this.tMb == null || !this.tMb.tMk) {
            super.aQg();
            return;
        }
        final com.tencent.mm.plugin.webview.ui.tools.game.menu.d dVar = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(this.mController.xRr);
        dVar.a(new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c() {
            public final void g(MenuItem menuItem) {
                arl arl = (arl) GameWebViewUI.this.nfE.get(Integer.valueOf(menuItem.getItemId()));
                if (arl != null) {
                    aj.d bRR;
                    switch (com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.Bq(arl.wnV)) {
                        case HVGAME_MENU_ACTION_JUMP_H5:
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", arl.wnW);
                            com.tencent.mm.bl.d.b(GameWebViewUI.this.mController.xRr, "webview", ".ui.tools.game.GameWebViewUI", intent);
                            return;
                        case HVGAME_MENU_ACTION_EXIT:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(32), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            if (!GameWebViewUI.this.aPV()) {
                                GameWebViewUI.this.finish();
                                return;
                            }
                            return;
                        case HVGAME_MENU_ACTION_SHARE_TO_FRIEND:
                            String stringExtra = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
                            String stringExtra2 = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
                            String stringExtra3 = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
                            aj.d bRR2 = GameWebViewUI.this.tyl.bRR();
                            bRR2.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                            bRR2.c(GameWebViewUI.this.jAm);
                            GameWebViewUI.this.tFd = GameWebViewUI.this.jAn.bTg().cep();
                            GameWebViewUI.this.aQk();
                            return;
                        case HVGAME_MENU_ACTION_COLLECT:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(3), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            g.pWK.a(157, 6, 1, false);
                            GameWebViewUI.this.tFd = GameWebViewUI.this.jAn.bTg().cep();
                            GameWebViewUI.this.aQr();
                            return;
                        case HVGAME_MENU_ACTION_STICK_ON:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(29), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            GameWebViewUI.this.aQn();
                            return;
                        case HVGAME_MENU_ACTION_STICK_OFF:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(30), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            GameWebViewUI.this.aQo();
                            return;
                        case HVGAME_MENU_ACTION_REFRESH:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(10), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            if (GameWebViewUI.this.pzt != null) {
                                GameWebViewUI.this.pzt.reload();
                                return;
                            }
                            return;
                        case HVGAME_MENU_ACTION_ADD_TO_DESKTOP:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(31), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            GameWebViewUI.this.aQq();
                            return;
                        case HVGAME_MENU_ACTION_COMPLAINT:
                            bRR = GameWebViewUI.this.tyl.bRR();
                            bRR.tzv = new Object[]{GameWebViewUI.this.fJB, Integer.valueOf(11), Integer.valueOf(1)};
                            bRR.c(GameWebViewUI.this.jAm);
                            GameWebViewUI.this.bTG();
                            return;
                        case HVGAME_MENU_ACTION_CUSTOM:
                            if (GameWebViewUI.this.tsa != null) {
                                com.tencent.mm.plugin.webview.ui.tools.jsapi.d E = GameWebViewUI.this.tsa;
                                int i = arl.wFZ;
                                x.i("MicroMsg.JsApiHandler", com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
                                Map hashMap = new HashMap();
                                hashMap.put("itemId", Integer.valueOf(i));
                                ah.y(new AnonymousClass60(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME, hashMap, E.tNq, E.tNr)));
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        dVar.tMD = new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b() {
            public final void a(n nVar) {
                g.pWK.a(480, 0, 1, false);
                n F = GameWebViewUI.this.aQh();
                if (F != null) {
                    nVar.ykH.addAll(F.ykH);
                }
            }
        };
        if (this.tEU) {
            dVar.tMI = true;
            dVar.tMJ = true;
        } else {
            dVar.tMI = false;
            dVar.tMJ = false;
        }
        if (this.tEY == null || !this.tEY.isShown()) {
            aWY();
            ah.h(new Runnable() {
                public final void run() {
                    if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.tGm) {
                        x.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                    } else {
                        dVar.bUX();
                    }
                }
            }, 100);
            return;
        }
        this.tEY.hide();
        ah.h(new Runnable() {
            public final void run() {
                if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.tGm) {
                    x.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                } else {
                    dVar.bUX();
                }
            }
        }, 100);
    }

    protected final void cD(String str, int i) {
        super.cD(str, i);
    }

    protected final int bTu() {
        return super.bTu();
    }

    protected final void U(Bundle bundle) {
        super.U(bundle);
    }

    protected final void alu() {
        Bundle e;
        super.alu();
        this.tMc = true;
        try {
            boolean z;
            e = this.jAm.e(j.CTRL_INDEX, null);
            e.setClassLoader(GameSettingParams.class.getClassLoader());
            GameSettingParams gameSettingParams = (GameSettingParams) e.getParcelable("game_setting_params");
            if (!this.nhE && this.nrY == null && this.nrX == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (!bi.oN(gameSettingParams.fyv)) {
                    try {
                        this.nrX = Color.parseColor(gameSettingParams.fyv);
                    } catch (IllegalArgumentException e2) {
                        x.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + e2.getMessage());
                    }
                }
                this.nrY = gameSettingParams.fyw;
                bTq();
                kA(true);
            }
        } catch (Exception e3) {
            x.e("MicroMsg.Wepkg.GameWebViewUI", e3.getMessage());
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            this.tLZ = intent.getStringExtra("game_transparent_float_url");
            if (bi.oN(this.tLZ)) {
                intent = new Intent();
                intent.putExtra("game_check_float", true);
                intent.putExtra("game_sourceScene", intExtra);
                com.tencent.mm.bl.d.b(this, "game", ".ui.GameCenterUI", intent);
                return;
            }
            try {
                e = new Bundle();
                e.putInt("game_sourceScene", intExtra);
                if (this.jAm != null) {
                    this.jAm.e(91, e);
                }
                a aVar = this.tLx;
                String str = this.tLZ;
                aVar.ndH = str;
                aVar.tLI.Qs(str);
                if (aVar.jAa != null && aVar.jAa.getParent() == null) {
                    aVar.Fl.addView(aVar.jAa, new LayoutParams(-1, -1));
                }
                if (!(aVar.jAa == null || aVar.tLJ == null)) {
                    aVar.jAa.post(new com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass2(str));
                }
                this.tLZ = null;
            } catch (RemoteException e4) {
            }
        }
    }

    protected final void kA(boolean z) {
        super.kA(z);
        kD(false);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        if (this.tMc) {
            super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroy() {
        super.onDestroy();
        this.tLI.onDestroy();
        unregisterReceiver(this.tMg);
    }

    public void initView() {
        super.initView();
        this.tLX = new ColorDrawable(android.support.v4.content.a.c(this, R.e.brg));
        this.tLY = new ColorDrawable(android.support.v4.content.a.c(this, R.e.brg));
    }

    protected final void bTv() {
        super.bTv();
        this.tMa = getIntent().getStringExtra("game_hv_menu_appid");
        if (this.tEU && !bi.oN(this.tMa)) {
            if (this.tET != null) {
                this.tET.setVisibility(8);
            }
            this.tMb.a(this.tER, new com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a() {
                public final void aQf() {
                    GameWebViewUI.this.aQg();
                }
            });
        }
    }

    protected final boolean PP(String str) {
        return this.tLI.Qt(str);
    }

    protected final void Ct(String str) {
        if (!this.tLI.bVL()) {
            super.Ct(str);
        } else if (this.pzt != null) {
            this.pzt.loadUrl(str);
        }
    }

    protected final void afw() {
        if (VERSION.SDK_INT <= 10) {
            super.afw();
        } else if (this.screenOrientation == -1) {
            this.xQT = getSharedPreferences(ad.cgf(), 4).getBoolean("settings_landscape_mode", false);
            if (this.xQT) {
                setRequestedOrientation(2);
            } else {
                setRequestedOrientation(1);
            }
        } else {
            setRequestedOrientation(this.screenOrientation);
        }
    }

    protected final void bTH() {
        this.tMe = true;
        if (this.tMf) {
            bUQ();
        }
    }

    private void bUV() {
        if (this.tEN != null) {
            this.tEN.setVisibility(0);
        }
    }

    private void bUQ() {
        this.tMe = false;
        this.tMf = false;
        if (this.tMd) {
            ah.h(new Runnable() {
                public final void run() {
                    if (GameWebViewUI.this.pzt != null) {
                        if (GameWebViewUI.this.tLI != null) {
                            GameWebViewUI.this.tLI.bVK();
                        }
                        x.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", GameWebViewUI.this.mKN);
                        GameWebViewUI.this.pzt.stopLoading();
                        GameWebViewUI.this.pzt.loadUrl(GameWebViewUI.this.mKN);
                    }
                }
            }, 100);
        } else {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "no use wepkg, dont reload");
        }
    }

    private void a(URI uri) {
        String[] split = bi.oM(uri.getQuery()).split("&");
        if (split != null && split.length != 0) {
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    this.tLW.put(split3[0], split3[1]);
                }
            }
        }
    }

    protected final boolean bTl() {
        return true;
    }

    protected final void a(ViewGroup viewGroup, WindowInsets windowInsets) {
        super.a(viewGroup, windowInsets);
        if (this.nhE && this.pzt.isX5Kernel) {
            this.tLU = true;
            this.tEV = true;
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setBackgroundDrawable(this.tLX);
                this.tLX.setAlpha(0);
                if (supportActionBar.getCustomView() != null) {
                    supportActionBar.getCustomView().setBackground(this.tLY);
                    this.tLY.setAlpha(0);
                    supportActionBar.getCustomView().invalidate();
                }
            }
            setStatusBarColor(0);
            if (this.nrV != null) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.nrV.getLayoutParams();
                marginLayoutParams.topMargin = this.jSO;
                this.nrV.setLayoutParams(marginLayoutParams);
            }
            Ei(8);
        }
    }

    protected boolean bTo() {
        return true;
    }

    private void Bo(int i) {
        if (i < 10) {
            Ei(8);
        } else {
            Ei(0);
        }
        if (i < 255) {
            this.tLU = true;
        } else {
            this.tLU = false;
        }
        if (this.tLX != null) {
            this.tLX.setAlpha(i);
        }
    }
}
