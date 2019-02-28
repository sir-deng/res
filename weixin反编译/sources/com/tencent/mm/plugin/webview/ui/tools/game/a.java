package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.c;
import com.tencent.xweb.l;
import java.io.File;
import java.util.Map;
import org.xwalk.core.R;

public final class a {
    ViewGroup Fl;
    MMWebView jAa;
    Context mContext;
    String ndH;
    c nff = new c() {
        protected final void A(Bundle bundle) {
            try {
                if (a.this.tLG != null && bundle != null) {
                    a.this.tLG.e(96, bundle);
                }
            } catch (RemoteException e) {
            }
        }
    };
    GameWebViewUI tLE;
    private d tLF;
    d tLG;
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d tLH;
    com.tencent.mm.plugin.webview.wepkg.a tLI;
    a tLJ;
    f tLK;
    g tLL = new g() {
        public final void O(Bundle bundle) {
            x.i("MicroMsg.GameFloatWebView", m.NAME);
            try {
                a.this.Fl.removeView(a.this.jAa);
                a.this.onDestroy();
            } catch (Exception e) {
            }
        }

        public final Bundle e(int i, final Bundle bundle) {
            x.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = " + i);
            final Bundle bundle2 = new Bundle();
            final String string;
            final int i2;
            boolean z;
            String aeH;
            int init;
            switch (i) {
                case 18:
                    bundle2.putString("KPublisherId", d.fHA);
                    bundle2.putInt("getA8KeyScene", a.this.cE(d.tMi, d.fNt));
                    break;
                case 37:
                    string = bundle.getString("show_kb_placeholder");
                    i2 = bundle.getInt("show_kb_max_length");
                    a.this.tLE.runOnUiThread(new Runnable() {
                        public final void run() {
                            a.this.tLE.cD(string, i2);
                        }
                    });
                    break;
                case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    string = bundle.getString("set_page_title_text");
                    i2 = com.tencent.mm.plugin.webview.ui.tools.d.aM(bundle.getString("set_page_title_color"), a.this.tLE.getResources().getColor(com.tencent.mm.R.e.brf));
                    a.this.tLE.runOnUiThread(new Runnable() {
                        public final void run() {
                            if (string != null) {
                                a.this.tLE.setMMTitle(string);
                            }
                            a.this.tLE.oj(i2);
                        }
                    });
                    break;
                case 53:
                    a.this.tLE.runOnUiThread(new Runnable() {
                        public final void run() {
                            a.this.tLE.U(bundle);
                        }
                    });
                    break;
                case 54:
                    z = bundle.getBoolean("add_shortcut_status");
                    if (a.this.tLH != null) {
                        a.this.tLH.kH(z);
                        break;
                    }
                    break;
                case 79:
                    a.this.tLE.runOnUiThread(new Runnable() {
                        public final void run() {
                            bundle2.putInt("height", a.this.tLE.bTu());
                        }
                    });
                    break;
                case 84:
                    CharSequence mMTitle = a.this.tLE.mController.getMMTitle();
                    aeH = aeH();
                    bundle2.putString("webview_current_url", aeH);
                    bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                    bundle2.putString("webview_current_desc", aeH);
                    break;
                case R.styleable.AppCompatTheme_colorControlHighlight /*87*/:
                    z = a.this.tLJ.tQI;
                    aeH = a.this.tLJ.neN;
                    Map map = a.this.tLJ.tQK;
                    if (!z) {
                        bundle2.putString("full_url", bi.oM(aeH));
                        if (map != null && map.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            c.iQ(ad.getContext());
                            com.tencent.xweb.b cJc = com.tencent.xweb.b.cJc();
                            for (String string2 : map.keySet()) {
                                cJc.setCookie(bi.oM(aeH), string2 + "=" + ((String) map.get(string2)));
                            }
                            c.cJe();
                            c.sync();
                            x.i("MicroMsg.GameFloatWebView", "cookies:%s", cJc.getCookie(bi.oM(aeH)));
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                    break;
                case 95:
                    a.this.nff.tLR.Z(bundle);
                    x.i("MicroMsg.GameFloatWebView", "set game float page time data");
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", d.fNt);
                    x.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", Integer.valueOf(init));
                    break;
                case 101:
                    bundle.setClassLoader(GameWebViewUI.class.getClassLoader());
                    com.tencent.mm.bl.d.b(a.this.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", d.fHA));
                    break;
                case 5001:
                    if (a.this.tLG.isSDCardAvailable()) {
                        x.i("MicroMsg.GameFloatWebView", "availableSize = %d", Long.valueOf(ax.cgQ()));
                        if (ax.cgQ() < 524288000) {
                            x.e("MicroMsg.GameFloatWebView", "available size not enough");
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.trw);
                            z = true;
                            if (!file.exists()) {
                                z = file.mkdirs();
                                x.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z));
                            }
                            if (z) {
                                init = FactoryProxyManager.getPlayManager().init(a.this.mContext, com.tencent.mm.plugin.webview.a.trw);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
                    } else {
                        x.i("MicroMsg.GameFloatWebView", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case 5002:
                    aeH = bundle.getString("webview_video_proxy_cdn_urls");
                    String string3 = bundle.getString("webview_video_proxy_fileId");
                    int i3 = bundle.getInt("webview_video_proxy_file_size");
                    init = FactoryProxyManager.getPlayManager().startPlay(aeH, bundle.getInt("webview_video_proxy_file_type"), string3, (long) i3, bundle.getInt("webview_video_proxy_file_duration"));
                    x.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", aeH, string3, Integer.valueOf(i3), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init));
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", r4);
                    break;
                case 5003:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    x.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", Integer.valueOf(init));
                    if (init > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(init);
                        break;
                    }
                    break;
                case 5004:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case 5005:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case 5006:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    x.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, i2));
                    break;
                case 6001:
                    x.i("MicroMsg.GameFloatWebView", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                    a.this.mContext.sendBroadcast(intent);
                    break;
                case 90001:
                    x.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", aeH(), com.tencent.xweb.b.cJc().getCookie(aeH()));
                    bundle2.putString("cookie", aeH);
                    break;
                case 90002:
                    com.tencent.mm.plugin.webview.ui.tools.g.tEG.eW(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    x.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                    break;
            }
            return bundle2;
        }
    };

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass2(String str) {
            this.val$url = str;
        }

        public final void run() {
            a.this.jAa.setVisibility(8);
            a.this.tLJ.Qc(this.val$url);
        }
    }

    private class b extends com.tencent.xweb.x5.a.a.a.a.b {
        private b() {
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            Object onMiscCallBack = a.this.tLI.tRU.onMiscCallBack(str, bundle);
            return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
        }
    }

    private class a extends b {
        public a(MMWebView mMWebView) {
            super(mMWebView);
        }

        protected final void a(WebView webView, String str, Bitmap bitmap) {
            x.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = " + str);
            a.this.nff.tLR.bUT();
            a.this.tLI.tRT.b(webView, str, bitmap);
        }

        protected final void e(WebView webView, String str) {
            x.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s", str);
            this.jAa.setVisibility(0);
            a.this.tLI.tRT.a(webView, str);
            a.this.tLI.onDestroy();
            a.this.nff.tLR.bUU();
        }

        protected final void a(d dVar, e eVar) {
            a.this.tLG = dVar;
        }

        protected final void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
            x.i("MicroMsg.GameFloatWebView", "jsapi ready");
            a.this.tLH = dVar;
        }

        protected final void a(f fVar) {
            x.i("MicroMsg.GameFloatWebView", "jsloader ready");
            a.this.tLK = fVar;
        }

        protected final boolean PP(String str) {
            return a.this.tLI.Qt(str);
        }

        protected final void Ct(String str) {
            if (a.this.tLI.bVL()) {
                this.jAa.loadUrl(str);
            } else {
                super.Ct(str);
            }
        }

        protected final boolean Qc(String str) {
            return super.Qc(str);
        }

        protected final void Qd(String str) {
            try {
                x.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", str);
                a.this.Fl.removeView(this.jAa);
            } catch (Exception e) {
            }
        }

        protected final void bUR() {
            if (VERSION.SDK_INT >= 11) {
                this.jAa.removeJavascriptInterface("MicroMsg");
                this.jAa.removeJavascriptInterface("JsApi");
            }
            try {
                this.jAa.setWebChromeClient(null);
                this.jAa.setWebViewClient(null);
                this.jAa.setOnTouchListener(null);
                this.jAa.setOnLongClickListener(null);
                this.jAa.setVisibility(8);
                this.jAa.removeAllViews();
                this.jAa.clearView();
            } catch (Exception e) {
                x.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", e.getMessage());
            }
            try {
                this.jAa.destroy();
            } catch (Exception e2) {
                x.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", e2.getMessage());
            }
        }

        protected final g ail() {
            return a.this.tLL;
        }

        public final com.tencent.xweb.m c(WebView webView, String str) {
            com.tencent.xweb.m c = a.this.tLI.tRT.c(webView, str);
            return c != null ? c : super.c(webView, str);
        }

        public final com.tencent.xweb.m a(WebView webView, l lVar) {
            com.tencent.xweb.m a = a.this.tLI.tRT.a(webView, lVar);
            return a != null ? a : super.a(webView, lVar);
        }

        public final com.tencent.xweb.m a(WebView webView, l lVar, Bundle bundle) {
            com.tencent.xweb.m a = a.this.tLI.tRT.a(webView, lVar, bundle);
            return a != null ? a : super.a(webView, lVar, bundle);
        }
    }

    public a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup) {
        this.mContext = gameWebViewUI;
        this.tLE = gameWebViewUI;
        this.Fl = viewGroup;
        WebView dT = com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a.dT(this.mContext);
        dT.setBackgroundResource(17170445);
        dT.setBackgroundColor(0);
        dT.setVisibility(4);
        this.tLJ = new a(dT);
        dT.setWebViewClient(this.tLJ);
        if (dT.isX5Kernel) {
            dT.setWebViewClientExtension(new b());
        }
        dT.getSettings().setJavaScriptEnabled(true);
        dT.getSettings().cJp();
        dT.getSettings().setBuiltInZoomControls(false);
        dT.getSettings().setUseWideViewPort(true);
        dT.getSettings().setLoadWithOverviewMode(true);
        dT.getSettings().cJk();
        dT.getSettings().cJj();
        dT.getSettings().setGeolocationEnabled(true);
        dT.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        dT.getSettings().cJr();
        dT.getSettings().cJn();
        dT.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        dT.getSettings().cJm();
        dT.getSettings().cJo();
        dT.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.hbu + "databases/");
        com.tencent.xweb.b.cJc().cJd();
        com.tencent.xweb.b.cJc().b(dT);
        this.jAa = dT;
        this.tLF = new d(gameWebViewUI.getIntent());
        this.tLI = new com.tencent.mm.plugin.webview.wepkg.a(gameWebViewUI, this.jAa, this.jAa.hashCode());
    }

    public final void bUQ() {
        if (this.tLI == null || !this.tLI.Qt(this.ndH)) {
            x.i("MicroMsg.GameFloatWebView", "no use wepkg, dont reload");
            return;
        }
        x.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", this.ndH);
        this.tLI.bVK();
        if (this.jAa != null && this.jAa.getParent() != null && this.tLJ != null && !bi.oN(this.ndH)) {
            this.jAa.stopLoading();
            this.tLJ.Qc(this.ndH);
        }
    }

    final int cE(String str, int i) {
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else if (this.tLG == null) {
                i = 1;
            } else {
                try {
                    i = this.tLG.hq(str) ? 8 : this.tLG.gI(str) ? 7 : 1;
                } catch (Exception e) {
                    x.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e.getMessage());
                    i = 1;
                }
            }
        }
        x.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", Integer.valueOf(i));
        return i;
    }

    public final void onDestroy() {
        c.a(this.nff.tLR.tLS);
    }
}
