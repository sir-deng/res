package com.tencent.mm.plugin.aj;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.mm.plugin.game.gamewebview.b.a.c;
import com.tencent.mm.plugin.game.gamewebview.b.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.b;
import com.tencent.xweb.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e implements a {
    String TAG = "MicroMsg.WebViewPreLoadMgr";
    private ah hPO;
    private boolean jPc = false;
    private HashSet<Object> jPe = new HashSet();
    int tqe;
    boolean tqf;
    List<c> tqg = new LinkedList();
    long tqh;

    /* renamed from: com.tencent.mm.plugin.aj.e$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass7(String str) {
            this.val$url = str;
        }

        public final void run() {
            e eVar = e.this;
            String str = this.val$url;
            try {
                x.i(eVar.TAG, "preLoadWebView cached webview size %d", Integer.valueOf(eVar.tqg.size()));
                if (eVar.tqg.size() <= 0) {
                    eVar.tqh = System.currentTimeMillis();
                    WebView co = com.tencent.mm.ui.widget.MMWebView.a.co(new MutableContextWrapper(ad.getContext()));
                    eVar.tqf = false;
                    x.i(eVar.TAG, "preload %s", co.toString());
                    co.zEG = true;
                    co.tNr = bi.Dz(16);
                    co.getSettings().setJavaScriptEnabled(true);
                    co.getSettings().setPluginsEnabled(true);
                    co.getSettings().cJp();
                    co.getSettings().setBuiltInZoomControls(false);
                    co.getSettings().setUseWideViewPort(true);
                    co.getSettings().setLoadWithOverviewMode(true);
                    co.getSettings().cJk();
                    co.getSettings().cJj();
                    co.getSettings().setGeolocationEnabled(true);
                    co.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    co.getSettings().cJr();
                    co.getSettings().cJn();
                    co.getSettings().setAppCachePath(co.getContext().getDir("webviewcache", 0).getAbsolutePath());
                    co.getSettings().cJm();
                    co.getSettings().cJo();
                    co.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.hbu + "databases/");
                    b.cJc().cJd();
                    b.cJc().b(co);
                    co.getSettings().setUserAgentString(f.aL(co.getContext(), co.getSettings().getUserAgentString()));
                    b bVar = new b();
                    co.addJavascriptInterface(bVar, "__wx");
                    co.loadUrl(str);
                    co.setWebViewClient(new AnonymousClass2(co));
                    Uri parse = Uri.parse(str);
                    eVar.tqg.add(new c(co, parse.getQueryParameter("sessionId"), parse.getQueryParameter("subSessionId"), bVar));
                    g.pWK.h(15005, Integer.valueOf(eVar.tqe), Integer.valueOf(1), Integer.valueOf(0));
                }
            } catch (Throwable e) {
                x.printErrStackTrace(eVar.TAG, e, "", new Object[0]);
            }
            e.this.done();
        }
    }

    public static class a {
        static String e(String str, String str2, Map<String, Object> map) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("__msg_type", str);
                if (str.equals("event")) {
                    jSONObject.put("__event_id", str2);
                }
                jSONObject.put("__params", U(map));
                return jSONObject.toString();
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPreLoadMgr.Builder", "build fail, exception = " + e.getMessage());
                return null;
            }
        }

        private static JSONObject U(Map<String, Object> map) {
            if (map == null || map.size() == 0) {
                return new JSONObject();
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    if (str != null) {
                        jSONObject.put(str, map.get(str));
                    }
                }
                return jSONObject;
            } catch (Exception e) {
                x.e("MicroMsg.WebViewPreLoadMgr.Builder", "convertMapToJSON fail, exception = " + e.getMessage());
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.aj.e$2 */
    class AnonymousClass2 extends p {
        final /* synthetic */ MMWebView tqj;

        AnonymousClass2(MMWebView mMWebView) {
            this.tqj = mMWebView;
        }

        public final void a(WebView webView, String str) {
            x.i(e.this.TAG, "onPageFinished, view %s", webView.toString());
            e.this.a(this.tqj);
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            super.b(webView, str, bitmap);
            x.i(e.this.TAG, "onPageStarted, view %s", webView.toString());
            f.a(this.tqj);
        }

        public final boolean b(WebView webView, String str) {
            if (!f.eL(str, "weixin://private/setresult/")) {
                return false;
            }
            x.i(e.this.TAG, "handleUrl %s ,view %s", str, webView.toString());
            this.tqj.evaluateJavascript("javascript:WeixinJSBridge._continueSetResult()", null);
            return true;
        }
    }

    public e(int i) {
        this.tqe = i;
        this.TAG += "_" + i;
        this.hPO = new ah();
    }

    public final void Ow(final String str) {
        if (!ad.cgl()) {
            x.w(this.TAG, "preload please call from tools proc");
        } else if (!ad.cgl()) {
            x.w(this.TAG, "preload please call from tools proc");
        } else if (!ah.isMainThread()) {
            x.w(this.TAG, "preload please call from main thread");
        } else if (!this.jPc) {
            this.jPc = true;
            x.i(this.TAG, "preloading");
            this.hPO.F(new Runnable() {
                public final void run() {
                    x.i(e.this.TAG, "preload start");
                    Runnable anonymousClass7 = new AnonymousClass7(str);
                    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                        anonymousClass7.run();
                    } else {
                        ah.y(anonymousClass7);
                    }
                }
            });
        }
    }

    final boolean a(final MMWebView mMWebView) {
        String convertStreamToString;
        x.i(this.TAG, "begin jsapi init,wv %s", mMWebView.toString());
        try {
            convertStreamToString = bi.convertStreamToString(mMWebView.getContext().getAssets().open("jsapi/wxjs.js"));
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "", new Object[0]);
            convertStreamToString = null;
        }
        if (convertStreamToString == null) {
            x.e(this.TAG, "loadJavaScript fail, jsContent is null");
            return false;
        } else if (mMWebView == null) {
            x.e(this.TAG, "loadJavaScript, viewWV is null");
            return false;
        } else {
            mMWebView.evaluateJavascript("javascript:" + convertStreamToString, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    x.i(e.this.TAG, "loadJavaScript, jsContent evaluateJavascript cb, ret = %s, view %s", str, mMWebView.toString());
                }
            });
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            Map hashMap = new HashMap();
            hashMap.put("webview_type", "1");
            hashMap.put("init_url", mMWebView.getUrl());
            hashMap.put("init_font_size", "1");
            String str = mMWebView.tNr;
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", "sys:init", hashMap)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    x.i(e.this.TAG, "loadJS, sys:init callback %s,view %s", str, mMWebView.toString());
                }
            });
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str2 = mMWebView.tNr;
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", "sys:bridged", null)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    x.i(e.this.TAG, "loadJS, sys:bridged callback %s,view %s", str, mMWebView.toString());
                }
            });
            stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            convertStreamToString = "sys:attach_runOn3rd_apis";
            hashMap = new HashMap();
            Collection linkedList = new LinkedList();
            linkedList.add("menu:share:timeline");
            linkedList.add("menu:share:appmessage");
            linkedList.add("menu:share:weiboApp");
            linkedList.add("menu:share:QZone");
            linkedList.add("menu:share:qq");
            linkedList.add("onVoiceRecordEnd");
            linkedList.add("onVoicePlayBegin");
            linkedList.add("onVoicePlayEnd");
            linkedList.add("onLocalImageUploadProgress");
            linkedList.add("onImageDownloadProgress");
            linkedList.add("onVoiceUploadProgress");
            linkedList.add("onVoiceDownloadProgress");
            linkedList.add("onVideoUploadProgress");
            linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.e.NAME);
            linkedList.add("menu:setfont");
            linkedList.add("menu:share:weibo");
            linkedList.add("menu:share:email");
            linkedList.add(c.NAME);
            linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME);
            linkedList.add("hdOnDeviceStateChanged");
            linkedList.add("activity:state_change");
            linkedList.add("onWXDeviceBluetoothStateChange");
            linkedList.add("onWXDeviceLanStateChange");
            linkedList.add("onWXDeviceBindStateChange");
            linkedList.add("onReceiveDataFromWXDevice");
            linkedList.add("onScanWXDeviceResult");
            linkedList.add("onWXDeviceStateChange");
            linkedList.add("onNfcTouch");
            linkedList.add("onBeaconMonitoring");
            linkedList.add("onBeaconsInRange");
            linkedList.add("menu:custom");
            linkedList.add("onSearchWAWidgetOpenApp");
            linkedList.add("onSearchDataReady");
            linkedList.add("onSearchHistoryReady");
            linkedList.add("onSearchWAWidgetOnTapCallback");
            linkedList.add("onSearchImageListReady");
            linkedList.add("onTeachSearchDataReady");
            linkedList.add("onSearchGuideDataReady");
            linkedList.add("onSearchInputChange");
            linkedList.add("onSearchInputConfirm");
            linkedList.add("onSearchSuggestionDataReady");
            linkedList.add("onMusicStatusChanged");
            linkedList.add("switchToTabSearch");
            linkedList.add("onVideoPlayerCallback");
            linkedList.add("onSelectContact");
            linkedList.add("onSearchWAWidgetAttrChanged");
            linkedList.add("onSearchWAWidgetReloadData");
            linkedList.add("onSearchWAWidgetReloadDataFinish");
            linkedList.add("onSearchWAWidgetStateChange");
            linkedList.add("onSearchWAWidgetDataPush");
            linkedList.add("onPullDownRefresh");
            linkedList.add("onPageStateChange");
            linkedList.add("onGetKeyboardHeight");
            linkedList.add("onGetSmiley");
            linkedList.add("onAddShortcutStatus");
            linkedList.add("onFocusSearchInput");
            linkedList.add("onGetA8KeyUrl");
            linkedList.add("deleteAccountSuccess");
            linkedList.add("onGetMsgProofItems");
            linkedList.add("WNJSHandlerInsert");
            linkedList.add("WNJSHandlerMultiInsert");
            linkedList.add("WNJSHandlerExportData");
            linkedList.add("WNJSHandlerHeaderAndFooterChange");
            linkedList.add("WNJSHandlerEditableChange");
            linkedList.add("WNJSHandlerEditingChange");
            linkedList.add("WNJSHandlerSaveSelectionRange");
            linkedList.add("WNJSHandlerLoadSelectionRange");
            linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.a.NAME);
            linkedList.add("showLoading");
            linkedList.add("getSearchEmotionDataCallBack");
            linkedList.add("onNavigationBarRightButtonClick");
            linkedList.add("onSearchActionSheetClick");
            linkedList.add("onGetMatchContactList");
            linkedList.add("onUiInit");
            linkedList.add(d.NAME);
            linkedList.add("onBackgroundAudioStateChange");
            if (!bi.cC(null)) {
                linkedList.addAll(null);
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            String str3 = mMWebView.tNr;
            mMWebView.evaluateJavascript(stringBuilder.append(a.e("event", convertStreamToString, hashMap)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    String str = (String) obj;
                    x.i(e.this.TAG, "loadJS, sys:attach_runOn3rd_apis callback %s,view %s", str, mMWebView.toString());
                    e.this.tqf = true;
                    long currentTimeMillis = System.currentTimeMillis() - e.this.tqh;
                    g.pWK.h(15005, Integer.valueOf(e.this.tqe), Integer.valueOf(2), Long.valueOf(currentTimeMillis));
                }
            });
            x.i(this.TAG, "jsapi init done");
            return true;
        }
    }

    public final Object dM(Context context) {
        if (ad.cgl()) {
            x.i(this.TAG, "getWebView cached webview size %d", Integer.valueOf(this.tqg.size()));
            if (this.tqg.size() <= 0) {
                return null;
            }
            if (this.tqf) {
                c cVar = (c) this.tqg.get(0);
                if (cVar == null) {
                    this.tqg.remove(0);
                    return null;
                }
                MMWebView mMWebView = (MMWebView) cVar.tpU;
                if (mMWebView.getContext() instanceof MutableContextWrapper) {
                    ((MutableContextWrapper) mMWebView.getContext()).setBaseContext(context);
                }
                this.tqg.remove(cVar);
                this.tqf = false;
                return cVar;
            }
            x.i(this.TAG, "preload unfinished");
            return null;
        }
        x.w(this.TAG, "getWebView please call from tools proc");
        return null;
    }

    final synchronized void done() {
        x.i(this.TAG, "preInit finished");
        this.jPc = false;
        Iterator it = this.jPe.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.jPe.clear();
    }
}
