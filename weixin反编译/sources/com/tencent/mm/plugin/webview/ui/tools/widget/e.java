package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebView;
import com.tencent.xweb.h;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class e extends p {
    protected Activity iTL;
    public MMWebView jAa;
    ag mHandler;
    private Set<String> neK;
    public String neM;
    public String neN;
    private String neR;
    public boolean neT;
    private final Map<String, Map<String, String>> tGe;
    public d tLG;
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d tLH;
    private f tLK;
    public com.tencent.mm.plugin.webview.ui.tools.e tNp;
    protected b tQA;
    public a tQB;
    private com.tencent.mm.plugin.webview.model.ag tQC;
    public String tQD;
    private String tQE;
    private List<com.tencent.mm.plugin.webview.ui.tools.jsapi.b> tQF;
    private final Map<String, String> tQG;
    public boolean tQH;
    public boolean tQI;
    private boolean tQJ;
    public Map<String, String> tQK;
    public c tQL;
    public g tQM;

    protected class c implements ServiceConnection {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.i("MicroMsg.MMWebViewClient", "onServiceConnected");
            if (e.this.jAa == null) {
                x.e("MicroMsg.MMWebViewClient", "onServiceConnected, activity destroyed");
                return;
            }
            try {
                e.this.tLG = com.tencent.mm.plugin.webview.stub.d.a.X(iBinder);
                e.this.tLG.a(e.this.tQM, e.this.jAa.hashCode());
                e.this.a(e.this.tLG, e.this.tNp);
                e.this.bVC();
                e.this.bUS();
            } catch (Exception e) {
                x.e("MicroMsg.MMWebViewClient", "addCallback fail, ex = %s", e.getMessage());
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            x.i("MicroMsg.MMWebViewClient", "edw onServiceDisconnected");
            if (e.this.iTL.isFinishing()) {
                e.this.tLG = null;
                return;
            }
            x.i("MicroMsg.MMWebViewClient", "maybe mm process crash, try rebind service");
            e.this.bTk();
        }
    }

    protected static class a {
        private static final Pattern ndA = Pattern.compile(".*#.*wechat_redirect");
        private String ndB = null;

        public a(String str) {
            this.ndB = str;
        }

        public final int Cn(String str) {
            if (bi.oN(str)) {
                x.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
                return 0;
            } else if (str.equals(this.ndB)) {
                return 0;
            } else {
                if (ndA.matcher(str).find()) {
                    return 2;
                }
                return 1;
            }
        }
    }

    protected class b {
        int tHW = 0;

        protected b() {
        }
    }

    static /* synthetic */ boolean a(e eVar, com.tencent.mm.plugin.webview.stub.c cVar) {
        int type = cVar.getType();
        int bSx = cVar.bSx();
        int bSy = cVar.bSy();
        cVar.KS();
        Bundle data = cVar.getData();
        if (data == null) {
            data = new Bundle();
        }
        if (eVar.jAa != null) {
            if (!eVar.iTL.isFinishing() && eVar.tNp != null) {
                x.i("MicroMsg.MMWebViewClient", "get hash code = %d, self hash code = %d", Integer.valueOf(data.getInt("scene_end_listener_hash_code")), Integer.valueOf(eVar.jAa.hashCode()));
                x.i("MicroMsg.MMWebViewClient", "edw onSceneEnd, type = " + type + ", errCode = " + bSy + ", errType = " + bSx);
                if (data.getInt("scene_end_listener_hash_code") == eVar.jAa.hashCode()) {
                    switch (type) {
                        case 233:
                            b bVar = eVar.tQA;
                            bVar.tHW--;
                            if (bVar.tHW <= 0) {
                                bVar.tQN.Ba(233);
                            }
                            JsapiPermissionWrapper jsapiPermissionWrapper = new JsapiPermissionWrapper(data.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
                            GeneralControlWrapper generalControlWrapper = new GeneralControlWrapper(data.getInt("geta8key_result_general_ctrl_b1"));
                            int i = data.getInt("geta8key_result_reason");
                            x.i("MicroMsg.MMWebViewClient", "edw geta8key onSceneEnd, req reason = " + i);
                            switch (i) {
                                case 0:
                                case 2:
                                    if ((bSx == 0 && bSy == 0) || (bSx == 4 && bSy == -2005)) {
                                        eVar.a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        eVar.ab(data);
                                        break;
                                    }
                                case 1:
                                case 5:
                                    if (bSx != 0 || bSy != 0) {
                                        if (bSx != 4 || bSy != -2005) {
                                            if (bSx != 0 && bSy == -3300) {
                                                eVar.tQJ = true;
                                                break;
                                            }
                                        }
                                        eVar.jAa.stopLoading();
                                        eVar.a(data.getString("geta8key_result_req_url"), data.getString("geta8key_result_full_url"), jsapiPermissionWrapper, generalControlWrapper);
                                        eVar.ab(data);
                                        break;
                                    }
                                    String string = data.getString("geta8key_result_req_url");
                                    eVar.tNp.b(string, jsapiPermissionWrapper, generalControlWrapper);
                                    eVar.neK.remove(string);
                                    break;
                                    break;
                            }
                            break;
                    }
                }
                x.e("MicroMsg.MMWebViewClient", "hash code not equal");
            } else {
                x.w("MicroMsg.MMWebViewClient", "onSceneEnd, isFinishing, do nothing");
            }
        } else {
            x.w("MicroMsg.MMWebViewClient", "onSceneEnd, viewWV is null, do nothing");
        }
        return true;
    }

    public e() {
        this.tLK = null;
        this.tLH = null;
        this.neT = false;
        this.neR = "";
        this.neK = new HashSet();
        this.tQA = new b();
        this.tQB = new a(null);
        this.tQC = new com.tencent.mm.plugin.webview.model.ag();
        this.tQD = null;
        this.neM = null;
        this.tQE = null;
        this.tQF = new ArrayList();
        this.tQG = new HashMap();
        this.tGe = new ConcurrentHashMap();
        this.tQH = false;
        this.tQI = false;
        this.tQJ = false;
        this.tQL = new c();
        this.tQM = new g() {
            private g tQO = new g();

            private g bVD() {
                g ail = e.this.ail();
                if (ail == null) {
                    return this.tQO;
                }
                return ail;
            }

            public final boolean AJ(int i) {
                return bVD().AJ(i);
            }

            public final boolean n(int i, final Bundle bundle) {
                x.i("MicroMsg.MMWebViewClient", "callback, actionCode = " + i);
                final String string;
                final Map hashMap;
                final String string2;
                final int i2;
                switch (i) {
                    case 90:
                        if (e.this.tLH != null) {
                            e.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    if (e.this.tLH != null) {
                                        e.this.tLH.Qk(bundle.getString("webview_network_type"));
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    case 1002:
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null && e.this.tNp != null && e.this.tNp.bTf() != null && e.this.tNp.bTf().go(42)) {
                                    e.this.tLH.f(bundle, "download_succ");
                                }
                            }
                        });
                        break;
                    case 1003:
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null && e.this.tNp != null && e.this.tNp.bTf() != null && e.this.tNp.bTf().go(42)) {
                                    e.this.tLH.f(bundle, "download_fail");
                                }
                            }
                        });
                        break;
                    case 1006:
                        if (e.this.tLH != null) {
                            e.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    boolean z = false;
                                    byte[] byteArray = bundle.getByteArray("jsapi_control_bytes");
                                    if (byteArray == null || e.this.tNp == null || e.this.tNp.bTf() == null) {
                                        String str = "MicroMsg.MMWebViewClient";
                                        String str2 = "has JSAPI_CONTROL_BYTES %b, has wvPerm %b";
                                        Object[] objArr = new Object[2];
                                        objArr[0] = Boolean.valueOf(byteArray != null);
                                        if (e.this.tNp != null) {
                                            z = true;
                                        }
                                        objArr[1] = Boolean.valueOf(z);
                                        x.e(str, str2, objArr);
                                    } else {
                                        x.i("MicroMsg.MMWebViewClient", "update control bytes, %d", Integer.valueOf(byteArray.length));
                                        e.this.tNp.bTf().vHC = byteArray;
                                    }
                                    if (e.this.tLH != null) {
                                        e.this.tLH.bVb();
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    case 1007:
                        final long j = bundle.getLong("download_manager_downloadid");
                        final int i3 = bundle.getInt("download_manager_progress");
                        string = bundle.getString("download_manager_appid", "");
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null && e.this.tNp != null && e.this.tNp.bTf() != null && e.this.tNp.bTf().go(42)) {
                                    e.this.tLH.g(string, j, i3);
                                }
                            }
                        });
                        break;
                    case 1008:
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null && e.this.tNp != null && e.this.tNp.bTf() != null && e.this.tNp.bTf().go(42)) {
                                    e.this.tLH.f(bundle, "download_removed");
                                }
                            }
                        });
                        break;
                    case 2002:
                        hashMap = new HashMap();
                        hashMap.put("err_msg", bundle.getString("playResult"));
                        hashMap.put("localId", bundle.getString("localId"));
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.am(hashMap);
                                }
                            }
                        });
                        break;
                    case 2003:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.cG(string2, i2);
                                }
                            }
                        });
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_BEGIN /*2004*/:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.cH(string2, i2);
                                }
                            }
                        });
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.cI(string2, i2);
                                }
                            }
                        });
                        break;
                    case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.cJ(string2, i2);
                                }
                            }
                        });
                        break;
                    case TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER /*2008*/:
                        hashMap = new HashMap();
                        hashMap.put("localId", bundle.getString("localId"));
                        hashMap.put("err_msg", bundle.getString("recordResult"));
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.an(hashMap);
                                }
                            }
                        });
                        break;
                    case 2010:
                        string2 = bundle.getString("webview_jssdk_file_item_local_id");
                        i2 = bundle.getInt("webview_jssdk_file_item_progreess");
                        e.this.mHandler.post(new Runnable() {
                            public final void run() {
                                if (e.this.tLH != null) {
                                    e.this.tLH.cK(string2, i2);
                                }
                            }
                        });
                        break;
                    case 40001:
                        if (e.this.tLH != null) {
                            string2 = bundle.getString("err_msg");
                            e.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    if (e.this.tLH != null) {
                                        e.this.tLH.Qh(string2);
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    case 40002:
                        string = bundle.getString("uuid");
                        final int i4 = bundle.getInt("major");
                        final int i5 = bundle.getInt("minor");
                        final double d = bundle.getDouble("accuracy");
                        final double d2 = bundle.getDouble("rssi");
                        final float f = bundle.getFloat("heading");
                        if (e.this.tLH != null) {
                            final String string3 = bundle.getString("err_msg");
                            e.this.mHandler.post(new Runnable() {
                                public final void run() {
                                    if (e.this.tLH != null) {
                                        e.this.tLH.Qh(string3);
                                        e.this.tLH.a(string, i4, i5, d, d2, f);
                                    }
                                }
                            });
                            break;
                        }
                        break;
                    default:
                        x.e("MicroMsg.MMWebViewClient", "undefine action code!!!");
                        break;
                }
                bVD().n(i, bundle);
                return true;
            }

            public final boolean a(final com.tencent.mm.plugin.webview.stub.c cVar) {
                if (e.this.jAa == null) {
                    return true;
                }
                x.i("MicroMsg.MMWebViewClient", "onSceneEnd, instance hashcode = " + e.this.jAa.hashCode());
                e.this.mHandler.post(new Runnable() {
                    public final void run() {
                        try {
                            e.a(e.this, cVar);
                        } catch (Exception e) {
                            x.e("MicroMsg.MMWebViewClient", e.getMessage());
                        }
                    }
                });
                return bVD().a(cVar);
            }

            public final boolean a(String str, String str2, Bundle bundle, boolean z) {
                if (e.this.tLH != null) {
                    final String str3 = str;
                    final String str4 = str2;
                    final Bundle bundle2 = bundle;
                    final boolean z2 = z;
                    e.this.mHandler.post(new Runnable() {
                        public final void run() {
                            e.this.tLH.a(str3, str4, i.aa(bundle2), z2);
                        }
                    });
                    bVD().a(str, str2, bundle, z);
                }
                return false;
            }

            public final String bSz() {
                return e.this.tQD;
            }

            public final String aeH() {
                return e.this.aPR();
            }

            public final String bSA() {
                return bVD().bSA();
            }

            public final void kv(boolean z) {
                bVD().kv(z);
            }

            public final void kw(boolean z) {
                bVD().kw(z);
            }

            public final void p(int i, Bundle bundle) {
                bVD().p(i, bundle);
            }

            public final void bSB() {
                if (e.this.tLH != null) {
                    e.this.tLH.bSB();
                }
            }

            public final void O(Bundle bundle) {
                bVD().O(bundle);
            }

            public final void Po(String str) {
                bVD().Po(str);
            }

            public final void eT(String str, String str2) {
                bVD().eT(str, str2);
            }

            public final void bSC() {
                if (e.this.tLH != null) {
                    e.this.tLH.bSC();
                }
            }

            public final void f(String str, String str2, int i, int i2) {
                bVD().f(str, str2, i, i2);
            }

            public final Bundle e(int i, Bundle bundle) {
                return bVD().e(i, bundle);
            }

            public final void P(Bundle bundle) {
                bVD().P(bundle);
            }

            public final void kx(boolean z) {
                bVD().kx(z);
            }

            public final void eU(String str, String str2) {
                bVD().eU(str, str2);
            }
        };
    }

    public e(MMWebView mMWebView) {
        this(mMWebView, false);
    }

    public e(MMWebView mMWebView, boolean z) {
        this.tLK = null;
        this.tLH = null;
        this.neT = false;
        this.neR = "";
        this.neK = new HashSet();
        this.tQA = new b();
        this.tQB = new a(null);
        this.tQC = new com.tencent.mm.plugin.webview.model.ag();
        this.tQD = null;
        this.neM = null;
        this.tQE = null;
        this.tQF = new ArrayList();
        this.tQG = new HashMap();
        this.tGe = new ConcurrentHashMap();
        this.tQH = false;
        this.tQI = false;
        this.tQJ = false;
        this.tQL = new c();
        this.tQM = /* anonymous class already generated */;
        this.iTL = (Activity) mMWebView.getContext();
        this.jAa = mMWebView;
        this.mHandler = new ag();
        this.tNp = new com.tencent.mm.plugin.webview.ui.tools.e(this.iTL, mMWebView);
        this.neT = z;
    }

    public void Qd(String str) {
    }

    public void a(d dVar, com.tencent.mm.plugin.webview.ui.tools.e eVar) {
    }

    public g ail() {
        return null;
    }

    public int aim() {
        return 0;
    }

    public void a(com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
    }

    public void a(f fVar) {
    }

    public void e(Bundle bundle, String str) {
    }

    public boolean PP(String str) {
        if (this.jAa != null) {
            return o.a(str, this.tLG, this.jAa.hashCode());
        }
        return false;
    }

    public boolean IA(String str) {
        return false;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
    }

    public void e(WebView webView, String str) {
    }

    public void bUR() {
    }

    public final boolean Qr(String str) {
        for (com.tencent.mm.plugin.webview.ui.tools.jsapi.b bVar : this.tQF) {
            if (bVar.Cy(str)) {
                x.i("MicroMsg.MMWebViewClient", "url handled, ret = " + bVar.Cz(str) + ", url = " + str);
                return true;
            }
        }
        return IA(str);
    }

    public final boolean b(WebView webView, final String str) {
        x.i("MicroMsg.MMWebViewClient", "edw opt, shouldOverride url = " + str);
        if (this.tLG == null) {
            x.e("MicroMsg.MMWebViewClient", "Service not ready yet, make sure url loading happens after service connected");
            return true;
        } else if (!aa.ON(str)) {
            x.f("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, URL load failed, url = " + str);
            Qd(str);
            return true;
        } else if (str.equals(this.tQE)) {
            this.tQE = "";
            return true;
        } else {
            boolean Qr = Qr(str);
            if (!Qr && str.startsWith("weixin://")) {
                x.e("MicroMsg.MMWebViewClient", "shouldOverrideUrlLoading, can not deal with this weixin scheme, stop directly, url = %s", str);
                return true;
            } else if (Qr) {
                return true;
            } else {
                int Cn = this.tQB.Cn(str);
                if ((Cn != 0 && Cn != 2) || this.neT) {
                    return false;
                }
                x.i("MicroMsg.MMWebViewClient", "edw shouldOverride, should not continue, reason = " + Cn);
                if (PP(str)) {
                    this.jAa.stopLoading();
                    this.jAa.post(new Runnable() {
                        public final void run() {
                            e.this.Ct(str);
                        }
                    });
                } else {
                    this.jAa.stopLoading();
                }
                if (str.equals(this.neR)) {
                    x.w("MicroMsg.MMWebViewClient", "shouldOverride, url equals lastGetA8KeyUrl, not trigger geta8key");
                    return false;
                }
                aR(str, true);
                return true;
            }
        }
    }

    public final void a(WebView webView, String str, boolean z) {
        x.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory, url = %s, isReload = %b", str, Boolean.valueOf(z));
        super.a(webView, str, z);
        String url = webView.getUrl();
        if (this.neT) {
            aR(url, false);
        }
        if (this.tNp != null && !this.tNp.has(url)) {
            x.i("MicroMsg.MMWebViewClient", "doUpdateVisitedHistory start geta8key, url = %s", url);
            aR(url, false);
        }
    }

    public final void b(WebView webView, String str, Bitmap bitmap) {
        x.d("MicroMsg.MMWebViewClient", "onPageStarted url = %s", str);
        if (Qc(str)) {
            if (!this.tQH) {
                webView.stopLoading();
            }
        } else if (!aa.ON(str)) {
            x.f("MicroMsg.MMWebViewClient", "onPageStarted, canLoadUrl fail, url = " + str);
            Qd(str);
        } else if (Qr(str)) {
            this.tQE = str;
        } else {
            this.neM = str;
            super.b(webView, str, bitmap);
            this.tLK.bUT();
            if (PP(str)) {
                this.jAa.evaluateJavascript("javascript:(function(){ window.isWeixinCached=true; })()", null);
                if (this.tLH != null) {
                    this.tLH.o((String) this.tQG.get(str), (Map) this.tGe.get(str));
                }
            }
            aR(str, false);
            a(webView, str, bitmap);
        }
    }

    public final void a(WebView webView, String str) {
        x.d("MicroMsg.MMWebViewClient", "onPageFinished url = %s", str);
        if (this.tLG != null) {
            super.a(webView, str);
            if (aa.ON(str)) {
                this.tQE = "";
                if (str.equals("file:///android_asset/jsapi/wxjs.js")) {
                    x.i("MicroMsg.MMWebViewClient", "onPageFinished, js is finished loaded");
                    e(webView, str);
                    return;
                }
                this.tLK.bUU();
                e(webView, str);
                return;
            }
            x.f("MicroMsg.MMWebViewClient", "onPageFinished, canLoadUrl fail, url = " + str);
            Qd(str);
        }
    }

    public final void a(WebView webView, h hVar, SslError sslError) {
        super.a(webView, hVar, sslError);
    }

    public final void a(WebView webView, int i, String str, String str2) {
        super.a(webView, i, str, str2);
    }

    public void f(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "edw onLoadResource opt, url = " + str);
        super.f(webView, str);
    }

    public m c(WebView webView, String str) {
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s", str);
        return this.tQC.a(str, true, this.tLG);
    }

    public m a(WebView webView, l lVar) {
        if (lVar == null || lVar.getUrl() == null || bi.oN(lVar.getUrl().toString())) {
            return super.a(webView, lVar);
        }
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame()));
        return this.tQC.a(lVar.getUrl().toString(), false, this.tLG);
    }

    public m a(WebView webView, l lVar, Bundle bundle) {
        if (lVar == null || lVar.getUrl() == null || bi.oN(lVar.getUrl().toString())) {
            return super.a(webView, lVar, bundle);
        }
        x.i("MicroMsg.MMWebViewClient", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", lVar.getUrl(), lVar.getMethod(), Boolean.valueOf(lVar.isForMainFrame()));
        if (WebView.getCurWebType() != com.tencent.xweb.WebView.c.WV_KIND_X5 || WebView.getTbsCoreVersion(this.iTL) > 36541) {
            try {
                int i = bundle.getInt("resourceType");
                if (i == 1 || i == 7) {
                    x.i("MicroMsg.MMWebViewClient", "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i));
                    f(lVar.getUrl().toString(), false, 5);
                }
            } catch (Exception e) {
                x.w("MicroMsg.MMWebViewClient", "get resource type failed Exception ; %s", e.getMessage());
            } catch (Throwable th) {
                x.w("MicroMsg.MMWebViewClient", "get resource type failed Throwable ; %s", th.getMessage());
            }
        }
        return this.tQC.a(lVar.getUrl().toString(), true, this.tLG);
    }

    public final void cleanup() {
        if (this.tQL != null) {
            try {
                this.iTL.unbindService(this.tQL);
            } catch (Exception e) {
                x.e("MicroMsg.MMWebViewClient", e.getMessage());
            }
        }
        if (this.tLH != null) {
            this.tLH.detach();
        }
        if (this.tLK != null) {
            this.tLK.detach();
        }
        Ba(233);
        try {
            this.tLG.AM(this.jAa.hashCode());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.MMWebViewClient", e2, "", new Object[0]);
        }
        bUR();
    }

    public final void bVC() {
        int i;
        Map hashMap = new HashMap();
        hashMap.put("init_url", this.tQD);
        hashMap.put("webview_type", "1");
        hashMap.put("init_font_size", "1");
        this.tLH = new com.tencent.mm.plugin.webview.ui.tools.jsapi.d(this.jAa, this.tNp, hashMap, this.tLG, this.jAa.hashCode());
        this.tLH.tNn = null;
        this.jAa.addJavascriptInterface(this.tLH, "__wx");
        this.tQF.add(this.tLH);
        this.tQF.add(new com.tencent.mm.plugin.webview.ui.tools.jsapi.e(this.jAa, this.tLH));
        this.tLK = new f(this.jAa, this.tLG, this.tLH, new com.tencent.mm.plugin.webview.ui.tools.jsapi.f.a() {
            public final void bTX() {
                e.this.a(e.this.tLH);
            }
        }, false);
        a(this.tLK);
        try {
            i = bi.getInt(this.tLG.Pv("WebviewDisableDigestVerify"), 0);
        } catch (Exception e) {
            x.w("MicroMsg.MMWebViewClient", "getting js digest verification config fails, ex = " + e.getMessage());
            i = 0;
        }
        x.i("MicroMsg.MMWebViewClient", "js digest verification config = %d", Integer.valueOf(i));
        if (i == 0 && this.iTL.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("wvsha1", true)) {
            this.tLH.bUZ();
            this.tQC.tzb = this.tLH.tNr;
        }
    }

    public void bUS() {
        try {
            this.tLG.a(this.tQD, true, null);
        } catch (Exception e) {
            x.w("MicroMsg.MMWebViewClient", "postBinded, jumpToActivity, ex = " + e.getMessage());
        }
        if (!Qr(this.tQD)) {
            Uri parse = Uri.parse(this.tQD);
            if (parse.getScheme() == null) {
                this.tQD += "http://";
                parse = Uri.parse(this.tQD);
            }
            if (parse.getScheme().startsWith("http")) {
                x.i("MicroMsg.MMWebViewClient", "uri scheme not startwith http, scheme = " + parse.getScheme());
                this.tQB = new a(this.tQH ? "" : this.tQD);
                this.tQH = false;
                if (this.neT || this.tNp.has(this.tQD)) {
                    this.jAa.loadUrl(this.tQD);
                } else {
                    aR(this.tQD, false);
                }
            } else if (aa.ON(this.tQD)) {
                this.jAa.loadUrl(this.tQD);
            } else {
                Qd(this.tQD);
            }
        }
    }

    private void bTk() {
        x.i("MicroMsg.MMWebViewClient", "tryBindService");
        this.iTL.bindService(new Intent(this.iTL, WebViewStubService.class), this.tQL, 1);
    }

    public boolean Qc(String str) {
        if (this.tLG != null) {
            return false;
        }
        this.tQD = str;
        bTk();
        return true;
    }

    public void Ct(String str) {
        Map hashMap = new HashMap(2);
        hashMap.put("Pragma", "no-cache");
        hashMap.put("Cache-Control", "no-cache");
        this.jAa.loadUrl(str, hashMap);
    }

    public final void aR(String str, boolean z) {
        f(str, z, aim());
    }

    private void f(String str, boolean z, int i) {
        boolean z2 = false;
        if (!this.iTL.isFinishing()) {
            if (this.tNp == null) {
                x.e("MicroMsg.MMWebViewClient", "startGetA8Key fail, after onDestroy");
            } else if (this.neT) {
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, nevergeta8key");
                this.tNp.b(str, null, null);
            } else {
                boolean z3;
                if (this.tLG != null && this.neK.contains(str) && PP(str)) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                if ((this.tNp.has(str) || z3) && !z) {
                    x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key no need, wvPerm already has value, url = " + str);
                    return;
                }
                String str2 = "";
                int Cn = this.tQB.Cn(str);
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, url = " + str + ", scene = " + i + ", username = " + str2 + ", reason = " + Cn + ", force = " + z);
                x.i("MicroMsg.MMWebViewClient", "edw startGetA8Key, begin, set a default permission");
                this.neK.add(str);
                this.tNp.b(str, null, null);
                this.tQI = true;
                b bVar = this.tQA;
                if (bVar.tHW == 0) {
                    e eVar = bVar.tQN;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("scene_end_type", 233);
                        bundle.putInt("scene_end_listener_hash_code", eVar.jAa.hashCode());
                        eVar.tLG.a(5, bundle, eVar.jAa.hashCode());
                    } catch (Exception e) {
                        x.e("MicroMsg.MMWebViewClient", "addSceneEnd, ex = " + e.getMessage());
                    }
                }
                bVar.tHW++;
                Bundle bundle2 = new Bundle();
                bundle2.putString("geta8key_data_req_url", str);
                bundle2.putString("geta8key_data_username", str2);
                bundle2.putInt("geta8key_data_scene", i);
                bundle2.putInt("geta8key_data_reason", Cn);
                if (this.jAa.isX5Kernel) {
                    bundle2.putInt("geta8key_data_flag", 1);
                } else {
                    bundle2.putInt("geta8key_data_flag", z2);
                }
                bundle2.putString("geta8key_data_net_type", s.bRI());
                this.neR = str;
                e(bundle2, str);
                try {
                    z2 = this.tLG.r(233, bundle2);
                } catch (Exception e2) {
                    x.w("MicroMsg.MMWebViewClient", "startGetA8Key, ex = " + e2.getMessage());
                }
                x.i("MicroMsg.MMWebViewClient", "startGetA8Key, doScene ret = " + z2);
            }
        }
    }

    private void Ba(int i) {
        try {
            if (this.tLG != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("scene_end_type", 233);
                bundle.putInt("scene_end_listener_hash_code", this.jAa.hashCode());
                this.tLG.a(6, bundle, this.jAa.hashCode());
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", "removeSceneEnd, ex = " + e.getMessage());
        }
    }

    private void n(String str, Map<String, String> map) {
        String aD = bi.aD(aPR(), this.tQD);
        if (bi.oN(aD)) {
            x.e("MicroMsg.MMWebViewClient", "after getA8Key, currentURL is null or nil, wtf");
            this.jAa.loadUrl(str);
        } else if (this.tLH == null) {
            if (map.size() > 0) {
                this.jAa.loadUrl(str, map);
            } else {
                this.jAa.loadUrl(str);
            }
        } else if (!bi.oM(str).contains("#wechat_redirect")) {
            if (!eX(aD, str)) {
                String Pg = com.tencent.mm.plugin.webview.modelcache.p.Pg(aD);
                String Pg2 = com.tencent.mm.plugin.webview.modelcache.p.Pg(str);
                Object obj = (bi.oN(Pg2) || bi.oN(Pg) || !Pg2.equals(Pg) || this.tLG == null || !PP(aD)) ? null : 1;
                if (obj == null) {
                    if (map.size() > 0) {
                        this.jAa.loadUrl(str, map);
                        return;
                    } else {
                        this.jAa.loadUrl(str);
                        return;
                    }
                }
            }
            this.tQG.put(aD, str);
            this.tGe.put(aD, map);
            this.tLH.o(str, map);
        } else if (map.size() > 0) {
            this.jAa.loadUrl(str, map);
        } else {
            this.jAa.loadUrl(str);
        }
    }

    private boolean eX(String str, String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            return false;
        }
        if (com.tencent.mm.plugin.webview.a.trv.matcher(str).matches() && com.tencent.mm.plugin.webview.a.trv.matcher(str2).matches()) {
            String replaceFirst = str.replaceFirst("http://", "").replaceFirst("https://", "");
            int indexOf = replaceFirst.indexOf(35);
            if (indexOf > 0) {
                replaceFirst = replaceFirst.substring(0, indexOf);
            }
            if (str2.replaceFirst("http://", "").replaceFirst("https://", "").startsWith(replaceFirst) && this.tLG != null && PP(str)) {
                return true;
            }
        }
        return false;
    }

    private boolean ab(Bundle bundle) {
        x.d("MicroMsg.MMWebViewClient", "[cpan] process a8 key:%d", Long.valueOf(System.currentTimeMillis()));
        int i = bundle.getInt("geta8key_result_action_code");
        String string = bundle.getString("geta8key_result_title");
        String string2 = bundle.getString("geta8key_result_full_url");
        String string3 = bundle.getString("geta8key_result_content");
        x.i("MicroMsg.MMWebViewClient", "processGetA8Key, actionCode = " + i + ", title = " + string + ", fullUrl = " + string2 + ", content = " + string3);
        String[] stringArray = bundle.getStringArray("geta8key_result_http_header_key_list");
        String[] stringArray2 = bundle.getStringArray("geta8key_result_http_header_value_list");
        Map hashMap = new HashMap();
        if (stringArray != null && stringArray2 != null && stringArray.length > 0 && stringArray2.length > 0 && stringArray.length == stringArray2.length) {
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                hashMap.put(stringArray[i2], stringArray2[i2]);
            }
        }
        this.tQK = hashMap;
        switch (i) {
            case 1:
                x.i("MicroMsg.MMWebViewClient", "getA8key-text: " + string3);
                if (string3 == null || string3.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-text fail, invalid content");
                    return false;
                }
                this.jAa.getSettings().setJavaScriptEnabled(false);
                this.jAa.loadData(string3, "text/html", ProtocolPackage.ServerEncoding);
                return true;
            case 2:
            case 7:
                x.i("MicroMsg.MMWebViewClient", "getA8key-webview/no-notice: title = " + string + ", fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-webview fail, invalid fullUrl");
                    return false;
                } else if (aa.ON(string2)) {
                    n(string2, hashMap);
                    return true;
                } else {
                    x.f("MicroMsg.MMWebViewClient", "processGetA8Key qrcode, canLoadUrl fail, url = " + string2);
                    Qd(string2);
                    return true;
                }
            case 6:
                x.i("MicroMsg.MMWebViewClient", "getA8key-special_webview: fullUrl = " + string2);
                if (string2 == null || string2.length() == 0) {
                    x.e("MicroMsg.MMWebViewClient", "getA8key-special_webview fail, invalid fullUrl");
                    return false;
                } else if (aa.ON(string2)) {
                    this.jAa.loadUrl(string2);
                    return true;
                } else {
                    x.f("MicroMsg.MMWebViewClient", "processGetA8Key special, canLoadUrl fail, url = " + string2);
                    Qd(string2);
                    return true;
                }
            default:
                x.i("MicroMsg.MMWebViewClient", "qrcode-getA8key-not_catch: action code = " + i);
                return false;
        }
    }

    private void a(String str, String str2, JsapiPermissionWrapper jsapiPermissionWrapper, GeneralControlWrapper generalControlWrapper) {
        if (!bi.oN(str2)) {
            this.tNp.b(str2, jsapiPermissionWrapper, generalControlWrapper);
            this.neK.remove(str2);
            this.tQI = false;
            this.neN = str2;
        }
        if (eX(str, str2)) {
            this.tNp.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.neK.remove(str);
        } else if (this.tLG != null && !bi.oN(str) && PP(str2)) {
            this.tNp.b(str, jsapiPermissionWrapper, generalControlWrapper);
            this.neK.remove(str);
        }
    }

    String aPR() {
        if (!bi.oN(this.neM)) {
            return this.neM;
        }
        if (this.mHandler == null) {
            return null;
        }
        if (Thread.currentThread().getId() == this.mHandler.getLooper().getThread().getId()) {
            return this.jAa == null ? "" : this.jAa.getUrl();
        } else {
            return (String) new bd<String>("") {
                protected final /* synthetic */ Object run() {
                    return e.this.jAa == null ? "" : e.this.jAa.getUrl();
                }
            }.b(this.mHandler);
        }
    }
}
