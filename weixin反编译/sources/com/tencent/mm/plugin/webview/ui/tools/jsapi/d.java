package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.m;
import com.tencent.mm.bg.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ax;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements b, b {
    private static final int tNh = (com.tencent.mm.compatible.util.d.fO(19) ? 200 : 20);
    public com.tencent.mm.plugin.webview.stub.d jAm;
    public int tBL;
    public long tNA = 0;
    public MMWebView tNi;
    private final List<String> tNj = new LinkedList();
    private final LinkedList<i> tNk = new LinkedList();
    private ag tNl = null;
    Map<String, Object> tNm;
    public Map<String, Object> tNn;
    public boolean tNo = false;
    private e tNp;
    public boolean tNq = false;
    public String tNr = "";
    private Set<a> tNs;
    private final List<String> tNt = new LinkedList();
    volatile String tNu = null;
    volatile int tNv = 0;
    private JSONObject tNw = new JSONObject();
    private JSONArray tNx = new JSONArray();
    private List<String> tNy = new LinkedList();
    private al tNz = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBeaconsInRange", d.this.tNw, d.this.tNq, d.this.tNr) + ")", null);
            d.this.tNy.clear();
            d.this.tNw = new JSONObject();
            d.this.tNx = new JSONArray();
            return false;
        }
    }, false);

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$40 */
    class AnonymousClass40 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass40(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$41 */
    class AnonymousClass41 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass41(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$43 */
    class AnonymousClass43 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass43(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$17 */
    class AnonymousClass17 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass17(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onBackgroundAudioStateChange fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$19 */
    class AnonymousClass19 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass19(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onNfcTouch fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$30 */
    class AnonymousClass30 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass30(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$31 */
    class AnonymousClass31 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass31(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$32 */
    class AnonymousClass32 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass32(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetMatchContactList fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$34 */
    class AnonymousClass34 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass34(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                x.d("MicroMsg.JsApiHandler", "onSearchHistoryReady %s", this.jau);
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass4(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange, %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$54 */
    class AnonymousClass54 implements Runnable {
        final /* synthetic */ String tNF;

        public AnonymousClass54(String str) {
            this.tNF = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript(this.tNF, null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onPullDownRefresh fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$36 */
    class AnonymousClass36 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass36(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetPoiInfoReturn fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$56 */
    class AnonymousClass56 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass56(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$58 */
    class AnonymousClass58 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass58(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$60 */
    class AnonymousClass60 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass60(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass6(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange, %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass10(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$21 */
    class AnonymousClass21 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass21(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$39 */
    class AnonymousClass39 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass39(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass3(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onScanWXDeviceResult, %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$52 */
    class AnonymousClass52 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass52(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, ex = %s", e.getMessage());
            }
        }
    }

    public interface a {
        void onReady();
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$18 */
    class AnonymousClass18 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass18(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onArticleReadingBtnClicked fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$37 */
    class AnonymousClass37 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass37(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiHandler", "onFocusSearchInput fail, ex = %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass5(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onWXDeviceBluetoothStateChange, %s", e.getMessage());
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.d$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ String jau;

        public AnonymousClass7(String str) {
            this.jau = str;
        }

        public final void run() {
            try {
                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.jau + ")", null);
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "onActivityStateChanged, ex = %s", e.getMessage());
            }
        }
    }

    static /* synthetic */ Map C(String[] strArr) {
        int length = strArr == null ? 0 : strArr.length;
        if (length == 0) {
            return null;
        }
        Map hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            if (hashMap.keySet().contains(strArr[i])) {
                hashMap.put(strArr[i], Integer.valueOf(((Integer) hashMap.get(strArr[i])).intValue() + 1));
            } else {
                hashMap.put(strArr[i], Integer.valueOf(1));
            }
        }
        return hashMap;
    }

    static /* synthetic */ void c(d dVar) {
        if (dVar.tNj.size() <= 0) {
            x.i("MicroMsg.JsApiHandler", "dealMsgQueue fail, resultValueList is empty");
            return;
        }
        x.i("MicroMsg.JsApiHandler", "dealMsgQueue, pre msgList = " + dVar.tNk.size());
        Collection d = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.d((String) dVar.tNj.remove(0), dVar.tNq, dVar.tNr);
        if (!bi.cC(d)) {
            dVar.tNk.addAll(d);
            x.i("MicroMsg.JsApiHandler", "now msg list size : %d", Integer.valueOf(dVar.tNk.size()));
        }
        x.i("MicroMsg.JsApiHandler", "dealMsgQueue, post msgList = " + dVar.tNk.size());
        dVar.bVc();
        if (dVar.tNl != null) {
            dVar.tNl.post(new Runnable() {
                public final void run() {
                    d.c(d.this);
                }
            });
        }
    }

    static /* synthetic */ void l(d dVar) {
        do {
        } while (dVar.bVd());
    }

    public d(MMWebView mMWebView, e eVar, Map<String, Object> map, com.tencent.mm.plugin.webview.stub.d dVar, int i) {
        this.tNi = mMWebView;
        this.tNp = eVar;
        this.tNl = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        String str = (String) message.obj;
                        if (!bi.oN(str)) {
                            d.this.tNj.add(str);
                        }
                        d.c(d.this);
                        return;
                    case 2:
                        x.v("MicroMsg.JsApiHandler", "handle msg from wx done, msg = " + message.obj);
                        return;
                    default:
                        return;
                }
            }
        };
        this.jAm = dVar;
        this.tNm = map;
        this.tBL = i;
    }

    public final void bUZ() {
        this.tNq = true;
        this.tNr = bi.Dz(16);
        x.i("MicroMsg.JsApiHandler", "js digest verification randomStr = %s", this.tNr);
    }

    public final void aQ(String str, boolean z) {
        try {
            this.jAm.i(str, z, this.tBL);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "addInvokedJsApiFromMenu, ex = " + e);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        if (this.tNl != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = str;
            this.tNl.sendMessage(obtain);
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(final String str) {
        if (str != null) {
            this.tNl.post(new Runnable() {
                public final void run() {
                    Map C = d.C(str.split(","));
                    String a = d.this.Ql("hosts");
                    if (!d.p(a, C)) {
                        x.e("MicroMsg.JsApiHandler", "failed to write Hosts file");
                    } else if (d.this.jAm != null && d.this.tNi != null) {
                        try {
                            d.this.jAm.y(0, d.this.tNi.getUrl(), a);
                        } catch (RemoteException e) {
                            x.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e.getMessage());
                        }
                    }
                }
            });
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(final String str) {
        if (str != null) {
            this.tNl.post(new Runnable() {
                public final void run() {
                    String a = d.this.Ql("html");
                    if (!d.eZ(a, str)) {
                        x.e("MicroMsg.JsApiHandler", "failed to write Html file");
                    } else if (d.this.jAm != null && d.this.tNi != null) {
                        try {
                            d.this.jAm.y(1, d.this.tNi.getUrl(), a);
                        } catch (RemoteException e) {
                            x.e("MicroMsg.JsApiHandler", "uploadFileToCDN error ", e.getMessage());
                        }
                    }
                }
            });
        }
    }

    public final boolean Cy(String str) {
        if (bi.oN(str)) {
            return false;
        }
        return s.eL(str, "weixin://dispatch_message/");
    }

    public final boolean Cz(final String str) {
        this.tNi.evaluateJavascript("javascript:WeixinJSBridge._fetchQueue()", new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                String str = (String) obj;
                x.i("MicroMsg.JsApiHandler", "handle url %s, re %s", str, str);
            }
        });
        return true;
    }

    public final void al(Map<String, Object> map) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onPreloadWebViewInit success, ready");
            String str = "MicroMsg.JsApiHandler";
            String str2 = "onPreloadWebViewInit,params %s";
            Object[] objArr = new Object[1];
            objArr[0] = map == null ? "" : map.toString();
            x.i(str, str2, objArr);
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onUiInit", (Map) map, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onPreloadWebViewInit fail, not ready");
    }

    public final void bVa() {
        this.tNo = true;
        if (this.tNs != null) {
            for (a aVar : this.tNs) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.tNs == null) {
            this.tNs = new HashSet();
        }
        this.tNs.add(aVar);
    }

    public final void bVb() {
        x.v("MicroMsg.JsApiHandler", "doAttachRunOn3rdApis, ready(%s).", Boolean.valueOf(this.tNo));
        if (this.tNi != null && this.tNo) {
            MMWebView mMWebView = this.tNi;
            StringBuilder stringBuilder = new StringBuilder("javascript:WeixinJSBridge._handleMessageFromWeixin(");
            String str = "sys:attach_runOn3rd_apis";
            Map hashMap = new HashMap();
            JsapiPermissionWrapper bTf = this.tNp.bTf();
            Collection linkedList = new LinkedList();
            if (bTf != null) {
                if (bTf.go(88)) {
                    linkedList.add("menu:share:timeline");
                }
                if (bTf.go(89)) {
                    linkedList.add("menu:share:appmessage");
                }
                if (bTf.go(94)) {
                    linkedList.add("menu:share:qq");
                }
                if (bTf.go(109)) {
                    linkedList.add("menu:share:weiboApp");
                }
                if (bTf.go(c.CTRL_INDEX)) {
                    linkedList.add("menu:share:QZone");
                }
                if (bTf.go(219)) {
                    linkedList.add("sys:record");
                }
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
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME);
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
                linkedList.add("onGetPoiInfoReturn");
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
                linkedList.add(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME);
                linkedList.add("onBackgroundAudioStateChange");
                linkedList.add("onArticleReadingBtnClicked");
                if (!bi.cC(null)) {
                    linkedList.addAll(null);
                }
            }
            hashMap.put("__runOn3rd_apis", new JSONArray(linkedList));
            mMWebView.evaluateJavascript(stringBuilder.append(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(str, hashMap, this.tNq, this.tNr)).append(")").toString(), new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    x.i("MicroMsg.JsApiHandler", "sys:attach_runOn3rd_apis back %s\t", (String) obj);
                }
            });
        }
    }

    private void bVc() {
        do {
        } while (bVd());
    }

    private boolean bVd() {
        if (bi.cC(this.tNk)) {
            x.i("MicroMsg.JsApiHandler", "dealNextMsg stop, msgList is empty");
            return false;
        }
        boolean AL;
        try {
            AL = this.jAm.AL(this.tBL);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "isBusy, ex = " + e.getMessage());
            AL = false;
        }
        if (AL) {
            x.w("MicroMsg.JsApiHandler", "dealNextMsg fail, msgHandler is busy now");
            return false;
        } else if (this.tNk.size() == 0) {
            x.w("MicroMsg.JsApiHandler", "msgList size is 0.");
            return false;
        } else {
            i iVar = (i) this.tNk.remove(0);
            if (iVar == null) {
                x.e("MicroMsg.JsApiHandler", "dealNextMsg fail, msg is null");
                return true;
            } else if (iVar.tQg == null || iVar.pug == null || iVar.type == null || this.tNi == null) {
                x.e("MicroMsg.JsApiHandler", "dealNextMsg fail, can cause nullpointer, function = " + iVar.tQg + ", params = " + iVar.pug + ", type = " + iVar.type + ", wv = " + this.tNi);
                return true;
            } else {
                if (!(this.tNn == null || this.tNn.get("srcUsername") == null || bi.oN(this.tNn.get("srcUsername").toString()))) {
                    iVar.pug.put("src_username", this.tNn.get("srcUsername").toString());
                }
                if (!(this.tNn == null || this.tNn.get("srcDisplayname") == null || bi.oN(this.tNn.get("srcDisplayname").toString()))) {
                    iVar.pug.put("src_displayname", this.tNn.get("srcDisplayname").toString());
                }
                if (!(this.tNn == null || this.tNn.get("KTemplateId") == null || bi.oN(this.tNn.get("KTemplateId").toString()))) {
                    iVar.pug.put("tempalate_id", this.tNn.get("KTemplateId").toString());
                }
                if (this.tNn != null) {
                    iVar.pug.put("message_id", this.tNn.get("message_id"));
                    iVar.pug.put("message_index", this.tNn.get("message_index"));
                    iVar.pug.put("webview_scene", this.tNn.get("scene"));
                    iVar.pug.put("pay_channel", this.tNn.get("pay_channel"));
                    iVar.pug.put("pay_scene", this.tNn.get("pay_scene"));
                    iVar.pug.put("stastic_scene", this.tNn.get("stastic_scene"));
                    iVar.pug.put("open_from_scene", this.tNn.get("from_scence"));
                    Bundle bundle = new Bundle();
                    bundle.putString("__jsapi_fw_ext_info_key_current_url", this.tNi.getUrl());
                    iVar.pug.put("__jsapi_fw_ext_info", bundle);
                }
                if (!(iVar.tQg.equals("shareWeibo") || iVar.tQg.equals("openUrlByExtBrowser") || iVar.tQg.equals(af.NAME) || iVar.tQg.equals(ab.NAME) || iVar.tQg.equals("openGameWebView") || iVar.tQg.equals(com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c.NAME) || iVar.tQg.equals(ax.NAME) || iVar.tQg.equals(ae.NAME))) {
                    iVar.pug.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.tNi.getUrl());
                    x.i("MicroMsg.JsApiHandler", "cuiqi wv.getUrl" + this.tNi.getUrl());
                }
                if (iVar.tQg.equalsIgnoreCase("openDesignerEmojiView") || iVar.tQg.equalsIgnoreCase("openEmotionDetailViewLocal") || iVar.tQg.equalsIgnoreCase("openDesignerEmojiView") || iVar.tQg.equalsIgnoreCase("openDesignerEmojiViewLocal") || iVar.tQg.equalsIgnoreCase("openDesignerEmojiView") || iVar.tQg.equalsIgnoreCase("openDesignerProfile") || iVar.tQg.equalsIgnoreCase("openDesignerProfileLocal") || iVar.tQg.equalsIgnoreCase("getSearchEmotionData")) {
                    iVar.pug.put("searchID", Long.valueOf(bVg()));
                    x.d("MicroMsg.JsApiHandler", "emoji search id:%d", Long.valueOf(bVg()));
                }
                try {
                    JsapiPermissionWrapper bTf = this.tNp.bTf();
                    Bundle bundle2 = new Bundle();
                    if (bTf != null) {
                        bTf.toBundle(bundle2);
                    }
                    AL = this.jAm.a(iVar.type, iVar.tQg, iVar.tQe, bundle2, i.ap(iVar.pug), this.tBL);
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "handleMsg, ex = " + e2.getMessage());
                    AL = false;
                }
                x.i("MicroMsg.JsApiHandler", "dealNextMsg, %s, handleRet = %s", iVar.tQg, Boolean.valueOf(AL));
                if (AL) {
                    return false;
                }
                return true;
            }
        }
    }

    public final void detach() {
        this.tNo = false;
        this.tNk.clear();
        this.tNj.clear();
        this.tNl = null;
    }

    public final void keep_setReturnValue(String str, String str2) {
        x.i("MicroMsg.JsApiHandler", "setResultValue, scene = " + str + ", resultValue = " + str2);
        x.i("MicroMsg.JsApiHandler", "edw setResultValue = threadId = " + Thread.currentThread().getId() + ", threadName = " + Thread.currentThread().getName());
        if (this.tNl != null) {
            Message obtain = Message.obtain();
            obtain.obj = str2;
            if (str.equals("SCENE_FETCHQUEUE")) {
                obtain.what = 1;
            } else if (str.equals("SCENE_HANDLEMSGFROMWX")) {
                obtain.what = 2;
            }
            this.tNl.sendMessage(obtain);
        }
    }

    public final void bVe() {
        if (this.tNo) {
            Map hashMap = new HashMap();
            hashMap.put("scene", "friend");
            this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("menu:share:appmessage", hashMap, this.tNq, this.tNr) + ")", null);
            try {
                this.jAm.G("scene", "friend", this.tBL);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.JsApiHandler", "jsapiBundlePutString, ex = " + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.JsApiHandler", "onSendToFriend fail, not ready");
    }

    public final void f(Bundle bundle, String str) {
        if (!this.tNo || bundle == null) {
            x.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
            return;
        }
        long j = bundle.getLong("download_manager_downloadid");
        String string = bundle.getString("download_manager_appid", "");
        int i = bundle.getInt("download_manager_errcode");
        x.i("MicroMsg.JsApiHandler", "onDownloadStateChange, downloadId = " + j + ", state = " + str + ", errCode = " + i);
        Map hashMap = new HashMap();
        hashMap.put("appid", string);
        hashMap.put("download_id", Long.valueOf(j));
        hashMap.put("err_code", Integer.valueOf(i));
        hashMap.put("state", str);
        final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.c.NAME, hashMap, this.tNq, this.tNr);
        ah.y(new Runnable() {
            public final void run() {
                try {
                    d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    x.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e.getMessage());
                }
            }
        });
    }

    public final void g(String str, long j, int i) {
        if (this.tNo) {
            Map hashMap = new HashMap();
            hashMap.put("appid", str);
            hashMap.put("download_id", Long.valueOf(j));
            hashMap.put("progress", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.b.NAME, hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiHandler", "onDownloadStateChange, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onDownloadStateChange fail, not ready");
    }

    public final void cF(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onExdeviceStateChange: device id = %s, state = %s", str, Integer.valueOf(i));
            if (bi.oN(str)) {
                x.e("MicroMsg.JsApiHandler", "parameter error!!!");
                return;
            }
            Map hashMap = new HashMap();
            hashMap.put("deviceId", str);
            if (i == 2) {
                hashMap.put("state", "connected");
            } else if (i == 1) {
                hashMap.put("state", "connecting");
            } else {
                hashMap.put("state", "disconnected");
            }
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onWXDeviceStateChange", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiHandler", "onExdeviceStateChange, %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onExdeviceStateChange fail, not ready");
    }

    public final void am(Map<String, Object> map) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onVoicePlayEnd");
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onVoicePlayEnd", (Map) map, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoicePlayEnd fail, not ready");
    }

    public final void an(Map<String, Object> map) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd");
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onVoiceRecordEnd", (Map) map, this.tNq, this.tNr);
            x.i("MicroMsg.JsApiHandler", "onVoiceRecordEnd event : %s", a);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceRecordEnd fail, not ready");
    }

    public final void cG(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onImageUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onImageUploadProgress", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onLocalImageUploadProgress fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onImageUploadProgress fail, not ready");
    }

    public final void cH(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onImageDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i));
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onImageDownloadProgress", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onImageDownloadProgress fail, not ready");
    }

    public final void cI(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onVoiceUploadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onVoiceUploadProgress", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceUploadProgress fail, not ready");
    }

    public final void cJ(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onVoiceDownloadProgress, serverId id : %s, percent : %d", str, Integer.valueOf(i));
            Map hashMap = new HashMap();
            hashMap.put("serverId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onVoiceDownloadProgress", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVoiceDownloadProgress fail, not ready");
    }

    public final void cK(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onVideoUploadoadProgress, local id : %s, percent : %d", str, Integer.valueOf(i));
            Map hashMap = new HashMap();
            hashMap.put("localId", str);
            hashMap.put("percent", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onVideoUploadProgress", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onVideoUploadoadProgress fail, not ready");
    }

    public final void Qg(String str) {
        try {
            Bundle bundle = new Bundle();
            JsapiPermissionWrapper bTf = this.tNp.bTf();
            if (bTf != null) {
                bTf.toBundle(bundle);
            }
            this.jAm.a(str, bundle, this.tBL);
        } catch (Exception e) {
            x.w("MicroMsg.JsApiHandler", "doProfile, ex = " + e.getMessage());
        }
    }

    public final void Br(int i) {
        Map hashMap = new HashMap();
        hashMap.put("height", Integer.valueOf(com.tencent.mm.bu.a.ad(ad.getContext(), i)));
        final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetKeyboardHeight", hashMap, this.tNq, this.tNr);
        ah.y(new Runnable() {
            public final void run() {
                try {
                    d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiHandler", "onGetKeyboardHeight fail, ex = %s", e.getMessage());
                }
            }
        });
    }

    public final void kH(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("success", Boolean.valueOf(z));
        final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onAddShortcutStatus", hashMap, this.tNq, this.tNr);
        ah.y(new Runnable() {
            public final void run() {
                try {
                    d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiHandler", "onGetSmiley fail, ex = %s", e.getMessage());
                }
            }
        });
    }

    public final void Qh(String str) {
        Map hashMap = new HashMap();
        hashMap.put("err_msg", str);
        final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBeaconMonitoring", hashMap, this.tNq, this.tNr);
        ah.y(new Runnable() {
            public final void run() {
                try {
                    d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiHandler", "onBeaconMonitoring fail, ex = %s", e.getMessage());
                }
            }
        });
    }

    public final void o(final String str, final Map<String, String> map) {
        x.d("MicroMsg.JsApiHandler", "onGetA8KeyUrl, fullUrl = %s", str);
        if (!bi.oN(str)) {
            this.tNu = str;
            if (map == null || map.size() == 0) {
                this.tNv = 0;
            } else {
                this.tNv = 1;
            }
            final String cL = cL(str, this.tNv);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        if (!(map == null || map.size() == 0)) {
                            com.tencent.xweb.c.iQ(ad.getContext());
                            com.tencent.xweb.b cJc = com.tencent.xweb.b.cJc();
                            for (String str : map.keySet()) {
                                cJc.setCookie(bi.WF(str), str + "=" + ((String) map.get(str)));
                            }
                            cJc.setCookie(bi.WF(str), "httponly");
                            com.tencent.xweb.c.cJe();
                            com.tencent.xweb.c.sync();
                            x.i("MicroMsg.JsApiHandler", "cookies:%s", cJc.getCookie(bi.WF(str)));
                        }
                        d.this.tNi.evaluateJavascript(String.format("javascript:(function(){ window.getA8KeyUrl='%s'; })()", new Object[]{str}), null);
                        d.this.tNi.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                        if (d.this.tNo) {
                            d.this.tNi.evaluateJavascript(cL, null);
                            d.this.tNu = null;
                            d.this.tNv = 0;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onGetA8KeyUrl fail, ex = %s", e.getMessage());
                    }
                }
            });
        }
    }

    final String cL(String str, int i) {
        Map hashMap = new HashMap(2);
        hashMap.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
        hashMap.put("set_cookie", Integer.valueOf(i));
        return Qj(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onGetA8KeyUrl", hashMap, this.tNq, this.tNr));
    }

    public final synchronized void a(String str, int i, int i2, double d, double d2, float f) {
        if (this.tNz.cgx()) {
            this.tNz.K(1000, 1000);
        }
        JSONObject jSONObject = new JSONObject();
        int i3 = 0;
        if (d > 0.0d && d < 0.5d) {
            i3 = 1;
        }
        try {
            if (!this.tNy.contains(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2))) {
                this.tNy.add(String.valueOf(str) + String.valueOf(i) + String.valueOf(i2));
                jSONObject.put("uuid", String.valueOf(str));
                jSONObject.put("major", String.valueOf(i));
                jSONObject.put("minor", String.valueOf(i2));
                jSONObject.put("accuracy", String.valueOf(d));
                jSONObject.put("rssi", String.valueOf(d2));
                jSONObject.put("heading", String.valueOf(f));
                jSONObject.put("proximity", String.valueOf(i3));
                this.tNx.put(jSONObject);
                this.tNw.put("beacons", this.tNx);
                this.tNw.put("err_msg", "onBeaconsInRange:ok");
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiHandler", "parse json error in onBeaconsInRange!! ", e.getMessage());
        }
        com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onBeaconsInRange", this.tNw, this.tNq, this.tNr);
        return;
    }

    public final void a(String str, String str2, Map<String, Object> map, boolean z) {
        if (!bi.oN(str)) {
            if (str2 == null || str2.length() == 0 || str == null) {
                x.e("MicroMsg.JsApiHandler", "doCallback, invalid args, ret = " + str2);
            } else {
                Map hashMap = new HashMap();
                hashMap.put("err_msg", str2);
                if (map != null && map.size() > 0) {
                    x.i("MicroMsg.JsApiHandler", "doCallback, retValue size = " + map.size());
                    hashMap.putAll(map);
                }
                final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("callback", str, hashMap, null, this.tNq, this.tNr);
                x.i("MicroMsg.JsApiHandler", "doCallback, ret = " + str2 + ", cb = " + a);
                if (!(a == null || this.tNi == null)) {
                    ah.y(new Runnable() {
                        public final void run() {
                            try {
                                d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                            } catch (Exception e) {
                                x.w("MicroMsg.JsApiHandler", "doCallback, ex = %s", e.getMessage());
                            }
                        }
                    });
                }
            }
        }
        if (z) {
            bSC();
        }
    }

    public final void bSC() {
        if (this.tNl != null) {
            this.tNl.post(new Runnable() {
                public final void run() {
                    d.l(d.this);
                }
            });
        }
    }

    public final void bSB() {
        if (this.tNk != null) {
            this.tNk.clear();
        }
    }

    public final void ao(Map<String, Object> map) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSelectContact success, ready");
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSelectContact", (Map) map, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSelectContact fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSelectContact fail, not ready");
    }

    public final void c(String str, boolean z, String str2) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            hashMap.put("newQuery", Boolean.valueOf(z));
            hashMap.put("requestId", str2);
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchDataReady", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchDataReady fail, not ready");
    }

    public final void a(String str, boolean z, String str2, String str3) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback success, ready");
            Map hashMap = new HashMap();
            hashMap.put("eventId", str);
            hashMap.put("widgetId", str3);
            hashMap.put("hitTest", Boolean.valueOf(z));
            hashMap.put("err_msg", str2);
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetOnTapCallback", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOnTapCallback fail, not ready");
    }

    public final void cM(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", str);
            hashMap.put("state", Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetStateChange", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
    }

    public final void a(String str, String str2, JSONArray jSONArray) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSearchInputChange success, ready %s %s %s", str, str2, jSONArray.toString());
            Map hashMap = new HashMap();
            hashMap.put("query", str);
            hashMap.put("custom", str2);
            hashMap.put("tagList", jSONArray);
            hashMap.put("isCancelButtonClick", Integer.valueOf(0));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchInputChange", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchInputChange fail, not ready");
    }

    public final void b(String str, String str2, JSONArray jSONArray) {
        Map hashMap = new HashMap();
        hashMap.put("query", str);
        hashMap.put("custom", str2);
        hashMap.put("tagList", jSONArray);
        a("onSearchInputChange", hashMap, null);
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, Map<String, Object> map, Map<String, Object> map2) {
        JSONObject jSONObject = new JSONObject();
        if (map2 != null) {
            for (Entry entry : map2.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                    } catch (Throwable e) {
                        Throwable th = e;
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                        } catch (JSONException e2) {
                            try {
                                jSONObject.put((String) entry.getKey(), entry.getValue());
                            } catch (JSONException e3) {
                                x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                            }
                        }
                    }
                }
            }
        }
        try {
            for (Entry entry2 : map.entrySet()) {
                jSONObject.put((String) entry2.getKey(), entry2.getValue());
            }
        } catch (Throwable e4) {
            x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
        }
        try {
            jSONObject.put("scene", str);
            jSONObject.put(Columns.TYPE, str2);
            jSONObject.put("isSug", str3);
            jSONObject.put("isLocalSug", str4);
            jSONObject.put("sessionId", str5);
        } catch (Throwable e42) {
            x.printErrStackTrace("MicroMsg.JsApiHandler", e42, "", new Object[0]);
        }
        a("switchToTabSearch", null, jSONObject);
        return true;
    }

    public final void a(final String str, Map<String, Object> map, JSONObject jSONObject) {
        if (!this.tNo || (map == null && jSONObject == null)) {
            x.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s", str);
            return;
        }
        String a;
        String str2 = "MicroMsg.JsApiHandler";
        String str3 = "onSendEventToJSBridge success, event=%s, params=%s, jsonParams=%s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = map == null ? "" : map.toString();
        objArr[2] = jSONObject == null ? "" : jSONObject.toString();
        x.i(str2, str3, objArr);
        if (map != null) {
            a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(str, (Map) map, this.tNq, this.tNr);
        } else {
            a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(str, jSONObject, this.tNq, this.tNr);
        }
        ah.y(new Runnable() {
            public final void run() {
                try {
                    d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiHandler", "onSendEventToJSBridge fail, event=%s, ex=%s", str, e.getMessage());
                }
            }
        });
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONArray jSONArray, String str8, int i, Map<String, Object> map) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "switchToTabSearch success, ready %s %s %s %s %s", str, str2, str3, str4, str5);
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (Throwable e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put(Columns.TYPE, str);
                jSONObject.put("isMostSearchBiz", str2);
                jSONObject.put("isSug", str3);
                jSONObject.put("isLocalSug", str5);
                jSONObject.put("scene", str4);
                jSONObject.put("query", str6);
                jSONObject.put("custom", str7);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", 0);
                jSONObject.put("sugId", str8);
                jSONObject.put("sugClickType", i);
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("switchToTabSearch", jSONObject, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, ex = %s", e.getMessage());
                    }
                }
            });
            return true;
        }
        x.e("MicroMsg.JsApiHandler", "switchToTabSearch fail, not ready");
        return false;
    }

    public final void a(String str, String str2, JSONArray jSONArray, int i, Map<String, Object> map) {
        String str3 = "";
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSearchInputConfirm success, ready %s %s %s", str, str2, jSONArray.toString());
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    if (entry.getValue() != null) {
                        try {
                            jSONObject.put((String) entry.getKey(), new JSONObject(entry.getValue().toString()));
                        } catch (Throwable e) {
                            Throwable th = e;
                            try {
                                jSONObject.put((String) entry.getKey(), new JSONArray(entry.getValue().toString()));
                            } catch (JSONException e2) {
                                try {
                                    jSONObject.put((String) entry.getKey(), entry.getValue());
                                } catch (JSONException e3) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", th, "", new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
            try {
                jSONObject.put("query", str);
                jSONObject.put("custom", str2);
                jSONObject.put("tagList", jSONArray);
                jSONObject.put("isBackButtonClick", i);
                jSONObject.put("sugId", str3);
                jSONObject.put("sugClickType", 0);
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
            }
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchInputConfirm", jSONObject, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchInputConfirm fail, not ready");
    }

    public final void Qi(String str) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("json", str);
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchSuggestionDataReady", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchSuggestionDataReady fail, not ready");
    }

    public final void aU(int i, String str) {
        if (this.tNo) {
            Map hashMap = new HashMap();
            hashMap.put("ret", Integer.valueOf(i));
            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchImageListReady", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchImageListReady fail, not ready");
    }

    public final void g(int i, String str, int i2) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onTeachSearchDataReady success, ready");
            Map hashMap = new HashMap();
            hashMap.put("requestType", Integer.valueOf(i));
            hashMap.put("json", str);
            hashMap.put("isCacheData", Integer.valueOf(i2));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onTeachSearchDataReady", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onTeachSearchDataReady fail, not ready");
    }

    public final void cN(String str, int i) {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onMusicStatusChanged success, ready");
            Map hashMap = new HashMap();
            hashMap.put("snsid", str);
            hashMap.put(DownloadInfo.STATUS, Integer.valueOf(i));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onMusicStatusChanged", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onMusicStatusChanged fail, not ready");
    }

    public static String Qj(String str) {
        return String.format("javascript:WeixinJSBridge._handleMessageFromWeixin(%s)", new Object[]{bi.oM(str)});
    }

    public final void kI(boolean z) {
        x.i("MicroMsg.JsApiHandler", "getHtmlContent, ready(%s).", Boolean.valueOf(this.tNo));
        if (this.tNi != null && this.jAm != null && this.tNo) {
            if (z) {
                this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:get_html_content", new HashMap(), this.tNq, this.tNr) + ")", null);
                return;
            }
            List bSP;
            try {
                bSP = this.jAm.bSP();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                bSP = null;
            }
            Uri parse = Uri.parse(this.tNi.getUrl());
            if (parse != null) {
                x.d("MicroMsg.JsApiHandler", "wv hijack url host" + parse.getHost());
            }
            if (bSP != null && parse != null && bSP.contains(parse.getHost())) {
                this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("sys:get_html_content", new HashMap(), this.tNq, this.tNr) + ")", null);
            }
        }
    }

    public final void bVf() {
        if (this.tNo) {
            x.i("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading success, ready");
            Map hashMap = new HashMap();
            hashMap.put("needShow", Boolean.valueOf(true));
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("showLoading", hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, ex = %s", e.getMessage());
                    }
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onEmojiStoreShowLoading fail, not ready");
    }

    public final void Qk(String str) {
        if (!bi.oN(str)) {
            Map hashMap = new HashMap();
            hashMap.put(DownloadInfo.NETTYPE, str);
            final String a = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a(com.tencent.mm.plugin.game.gamewebview.b.a.d.NAME, hashMap, this.tNq, this.tNr);
            ah.y(new Runnable() {
                public final void run() {
                    try {
                        d.this.tNi.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + a + ")", null);
                    } catch (Exception e) {
                        x.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, ex = %s", e.getMessage());
                    }
                }
            });
        }
    }

    public final long bVg() {
        x.d("MicroMsg.JsApiHandler", "cpan emoji get SearchID:%d", Long.valueOf(this.tNA));
        return this.tNA;
    }

    private String Ql(String str) {
        String url = this.tNi.getUrl();
        try {
            x.i("MicroMsg.JsApiHandler", "generate upload file name, url=%s, tag=%s, fullName=%s", url, str, com.tencent.mm.compatible.util.e.gJi + m.bX(url + str));
            return com.tencent.mm.compatible.util.e.gJi + m.bX(url + str);
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiHandler", "generating temp file name failed, url is " + url);
            x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean p(String str, Map<String, Integer> map) {
        Throwable e;
        if (bi.oN(str) || map == null) {
            x.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiHandler", "creating file failed, filePath is " + str);
                x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        OutputStream bufferedOutputStream;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                for (String str2 : map.keySet()) {
                    bufferedOutputStream.write((((Integer) map.get(str2)).intValue() + " " + str2).getBytes());
                    bufferedOutputStream.write(13);
                    bufferedOutputStream.write(10);
                }
                bufferedOutputStream.flush();
                try {
                    bufferedOutputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                }
                x.d("MicroMsg.JsApiHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e3) {
                e22 = e3;
                outputStream = bufferedOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e222) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e222 = th;
                    bufferedOutputStream = outputStream;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e4, "", new Object[0]);
                        }
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw e222;
            }
        } catch (Exception e5) {
            e222 = e5;
            x.printErrStackTrace("MicroMsg.JsApiHandler", e222, "", new Object[0]);
            x.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                outputStream.close();
            }
            return false;
        } catch (Throwable th3) {
            e222 = th3;
            bufferedOutputStream = null;
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw e222;
        }
    }

    private static boolean eZ(String str, String str2) {
        Throwable e;
        if (bi.oN(str) || bi.oN(str2)) {
            x.w("MicroMsg.JsApiHandler", "write to file error, path is null or empty, or data is empty");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.e("MicroMsg.JsApiHandler", "creating file failed, filePath is " + str);
                x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                return false;
            }
        }
        OutputStream outputStream = null;
        try {
            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str, true));
            try {
                outputStream = new FileOutputStream(str);
                outputStream.write(str2.getBytes());
                outputStream.write(13);
                outputStream.write(10);
                outputStream.flush();
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e3, "", new Object[0]);
                }
                x.d("MicroMsg.JsApiHandler", "writeToFile ok! " + str);
                return true;
            } catch (Exception e4) {
                e2 = e4;
                outputStream = bufferedOutputStream;
                try {
                    x.printErrStackTrace("MicroMsg.JsApiHandler", e2, "", new Object[0]);
                    x.w("MicroMsg.JsApiHandler", "write to file error");
                    if (outputStream != null) {
                        return false;
                    }
                    try {
                        outputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.JsApiHandler", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                outputStream = bufferedOutputStream;
                if (outputStream != null) {
                    outputStream.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            x.printErrStackTrace("MicroMsg.JsApiHandler", e22, "", new Object[0]);
            x.w("MicroMsg.JsApiHandler", "write to file error");
            if (outputStream != null) {
                return false;
            }
            outputStream.close();
            return false;
        }
    }
}
