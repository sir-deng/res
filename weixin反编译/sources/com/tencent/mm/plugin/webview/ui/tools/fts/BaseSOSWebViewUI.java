package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.aj.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass34;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass41;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI extends BaseSearchWebviewUI implements com.tencent.mm.ui.fts.widget.FTSEditTextView.a {
    protected ImageButton oTl;
    protected View qmW;
    View tID;
    protected SOSEditTextView tIE;
    private List<c> tIF;
    protected int tIG = 0;
    private com.tencent.mm.plugin.webview.fts.b tIH;
    boolean tII;
    boolean tIJ;
    private boolean tIg;

    protected class c {
        List<com.tencent.mm.ui.fts.widget.a.b> rNc;
        String tIR = "";
        String tIS = "";
        Map<String, Object> tIT = new HashMap();
        int type;

        protected c() {
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.type == this.type && cVar.tIS.equals(this.tIS)) {
                return true;
            }
            return false;
        }
    }

    public class a implements com.tencent.mm.ui.fts.widget.a.b {
        String tIP;
        int tIQ;
        String userName;

        public final String getTagName() {
            return this.tIP;
        }

        public final int compareTo(Object obj) {
            if (obj == null || !(obj instanceof com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a)) {
                return -1;
            }
            return this.tIP.compareTo(((com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a) obj).tIP);
        }
    }

    private class b extends a {
        private b() {
            super();
        }

        /* synthetic */ b(BaseSOSWebViewUI baseSOSWebViewUI, byte b) {
            this();
        }

        public final void a(WebView webView, String str) {
            super.a(webView, str);
            x.i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", Integer.valueOf(BaseSOSWebViewUI.this.scene), str);
            BaseSOSWebViewUI.this.showOptionMenu(false);
            if (!(BaseSOSWebViewUI.this.tIE == null || BaseSOSWebViewUI.this.tIg)) {
                BaseSOSWebViewUI.bUm();
                BaseSOSWebViewUI.this.tIE.yqL.clearFocus();
                BaseSOSWebViewUI.this.aWY();
            }
            BaseSOSWebViewUI.this.tIJ = true;
            BaseSOSWebViewUI.this.bUi();
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            super.b(webView, str, bitmap);
            x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", str);
            BaseSOSWebViewUI.this.showOptionMenu(false);
            if (BaseSOSWebViewUI.this.tIE != null && !BaseSOSWebViewUI.this.tIg) {
                BaseSOSWebViewUI.bUn();
                BaseSOSWebViewUI.this.tIE.yqL.clearFocus();
                BaseSOSWebViewUI.this.aWY();
            }
        }

        public final m a(WebView webView, l lVar, Bundle bundle) {
            if (!(lVar == null || lVar.getUrl() == null || !lVar.getUrl().toString().startsWith("weixin://fts"))) {
                m PZ = PZ(lVar.getUrl().toString());
                if (PZ != null) {
                    return PZ;
                }
            }
            return super.a(webView, lVar);
        }

        public final m a(WebView webView, l lVar) {
            if (!(lVar == null || lVar.getUrl() == null || !lVar.getUrl().toString().startsWith("weixin://fts"))) {
                m PZ = PZ(lVar.getUrl().toString());
                if (PZ != null) {
                    return PZ;
                }
            }
            return super.a(webView, lVar);
        }

        public final m c(WebView webView, String str) {
            if (str.startsWith("weixin://fts")) {
                m PZ = PZ(str);
                if (PZ != null) {
                    return PZ;
                }
            }
            return super.c(webView, str);
        }

        private static m PZ(String str) {
            InputStream openRead;
            x.i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                openRead = FileOp.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e) {
                openRead = null;
            }
            if (openRead != null) {
                return new m("image/*", "utf8", openRead);
            }
            return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        this.tIH = new com.tencent.mm.plugin.webview.fts.b(this.mController.xRr, this.pzt);
    }

    protected final int bTn() {
        return this.jSO;
    }

    protected void alu() {
        super.alu();
        this.tIg = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.tID = findViewById(R.h.cJQ);
        this.tIE = (SOSEditTextView) findViewById(R.h.cPd);
        this.tIE.znb = this;
        this.tIE.MB(getHint());
        this.qmW = findViewById(R.h.bPp);
        this.qmW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BaseSOSWebViewUI.this.bUh();
            }
        });
        this.oTl = (ImageButton) findViewById(R.h.bLU);
        this.oTl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BaseSOSWebViewUI.this.bUe();
            }
        });
        this.pzt.setWebViewClient(new b());
        this.pzt.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                BaseSOSWebViewUI.this.bUl().yqL.clearFocus();
                BaseSOSWebViewUI.this.aWY();
                return false;
            }
        });
        if (this.tGC != null) {
            this.tGC.ky(true);
        }
        this.pzt.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return true;
            }
        });
        this.tIH.tsa = this.tsa;
    }

    protected void onResume() {
        super.onResume();
        this.tIH.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.tIH.onPause();
    }

    public final String bQy() {
        return this.frp;
    }

    protected final void bUe() {
        aWY();
        if (this.tIF != null && this.tIF.size() > 1) {
            this.tIF.remove(0);
            final c cVar = (c) this.tIF.get(0);
            this.tIE.t(cVar.tIS, cVar.rNc);
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BaseSOSWebViewUI.this.tsa != null) {
                        BaseSOSWebViewUI.this.bUf();
                        int i = BaseSOSWebViewUI.this.tIY;
                        BaseSOSWebViewUI.this.tIY = cVar.type;
                        BaseSOSWebViewUI.this.bUg();
                        Bundle bundle = new Bundle();
                        bundle.putInt(Columns.TYPE, BaseSOSWebViewUI.this.tIY);
                        bundle.putBoolean("isHomePage", true);
                        bundle.putInt("scene", BaseSOSWebViewUI.this.aRY());
                        try {
                            Bundle o = BaseSOSWebViewUI.this.jAm.o(4, bundle);
                            Map hashMap = new HashMap();
                            hashMap.put("isBackButtonClick", "1");
                            hashMap.put("custom", BaseSOSWebViewUI.this.bUr());
                            if (BaseSOSWebViewUI.this.tIY != i) {
                                BaseSOSWebViewUI.this.tsa.a(o.getString("scene", "0"), o.getString(Columns.TYPE, "0"), o.getString("isSug", "0"), o.getString("isLocalSug", "0"), BaseSOSWebViewUI.this.bQy(), hashMap, cVar.tIT);
                            } else {
                                BaseSOSWebViewUI.this.tsa.a(BaseSOSWebViewUI.this.bUp(), BaseSOSWebViewUI.this.bUr(), BaseSOSWebViewUI.this.bUs(), 1, cVar.tIT);
                            }
                            if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.bUr())) {
                                f.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.frp, BaseSOSWebViewUI.this.tpV, BaseSOSWebViewUI.this.bUr(), BaseSOSWebViewUI.this.type);
                            }
                        } catch (RemoteException e) {
                        }
                    }
                }
            });
        } else if (this.tII) {
            bUh();
        } else {
            finish();
        }
    }

    protected void bUf() {
    }

    protected void bUg() {
    }

    protected void bUh() {
        this.tIE.t("", null);
        aWY();
        this.handler.post(new Runnable() {
            public final void run() {
                if (BaseSOSWebViewUI.this.tsa != null) {
                    d f = BaseSOSWebViewUI.this.tsa;
                    int i = BaseSOSWebViewUI.this.scene;
                    Map hashMap = new HashMap();
                    hashMap.put("isCancelButtonClick", Integer.valueOf(1));
                    hashMap.put("isInputChange", Integer.valueOf(1));
                    hashMap.put("scene", Integer.valueOf(i));
                    f.a("onSearchInputChange", hashMap, null);
                }
            }
        });
        this.tIF = null;
        this.tII = false;
        this.tIH.onDestroy();
    }

    protected final boolean bTI() {
        return true;
    }

    public final void bqJ() {
        if (!this.tIE.yqL.hasFocus()) {
            this.tIE.cxS();
            showVKB();
        }
    }

    protected final boolean bTx() {
        return false;
    }

    protected final int getType() {
        return this.type;
    }

    protected final int aRY() {
        return this.scene;
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, com.tencent.mm.ui.fts.widget.FTSEditTextView.b bVar) {
        x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", str, str2, bVar);
        if (bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.UserInput || bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BaseSOSWebViewUI.this.tsa != null) {
                        BaseSOSWebViewUI.this.tsa.b(BaseSOSWebViewUI.this.bUp(), BaseSOSWebViewUI.this.bUr(), BaseSOSWebViewUI.this.bUs());
                    }
                }
            });
        }
    }

    public void hQ(boolean z) {
        if (z && !bi.oN(this.tIE.bUp())) {
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BaseSOSWebViewUI.this.tsa != null) {
                        BaseSOSWebViewUI.this.tsa.b(BaseSOSWebViewUI.this.bUp(), BaseSOSWebViewUI.this.bUr(), BaseSOSWebViewUI.this.bUs());
                    }
                }
            });
        }
    }

    public final void cs(View view) {
        if (this.tIE != null) {
            if (!this.tIE.yqL.hasFocus()) {
                this.tIE.cxS();
                showVKB();
            }
            this.tIE.MB(getHint());
        }
    }

    protected String getHint() {
        return null;
    }

    public boolean als() {
        this.tIE.yqL.clearFocus();
        aWY();
        if (this.tIE.bUp().length() > 0) {
            this.handler.post(new Runnable() {
                public final void run() {
                    if (BaseSOSWebViewUI.this.tsa != null) {
                        Map hashMap = new HashMap();
                        if (BaseSOSWebViewUI.this.bUk() != 0) {
                            hashMap.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.bUk()));
                            hashMap.put("sugId", BaseSOSWebViewUI.this.bUj());
                        }
                        d l = BaseSOSWebViewUI.this.tsa;
                        String bUp = BaseSOSWebViewUI.this.bUp();
                        String bUr = BaseSOSWebViewUI.this.bUr();
                        JSONArray bUs = BaseSOSWebViewUI.this.bUs();
                        Map hashMap2 = new HashMap();
                        hashMap2.putAll(hashMap);
                        hashMap2.put("query", bUp);
                        hashMap2.put("custom", bUr);
                        hashMap2.put("tagList", bUs);
                        l.a("onSearchInputConfirm", hashMap2, null);
                        if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.bUr())) {
                            f.a(BaseSOSWebViewUI.this.tIX, BaseSOSWebViewUI.this.frp, BaseSOSWebViewUI.this.tpV, BaseSOSWebViewUI.this.bUr(), BaseSOSWebViewUI.this.tIY);
                        }
                    }
                }
            });
            aWY();
            this.tII = true;
        }
        return true;
    }

    protected void bUi() {
    }

    protected String bUj() {
        return "";
    }

    protected int bUk() {
        return 0;
    }

    public final SOSEditTextView bUl() {
        return this.tIE;
    }

    protected static boolean bUm() {
        return true;
    }

    protected static boolean bUn() {
        return true;
    }

    protected final boolean bTN() {
        return false;
    }

    protected final void bTt() {
        bUe();
    }

    public void onDestroy() {
        try {
            if (this.jAm != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.jAm.h(1, bundle);
            }
            this.tIH.onDestroy();
        } catch (RemoteException e) {
        }
        aWY();
        super.onDestroy();
    }

    protected void h(int i, Bundle bundle) {
        int i2 = 0;
        final String string;
        final String string2;
        switch (i) {
            case 60:
                com.tencent.mm.plugin.webview.fts.b.bPS();
                com.tencent.mm.bb.l.lZ("");
                if (bUt()) {
                    this.tIH.a(bundle, this.scene);
                    return;
                } else {
                    x.w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
                    return;
                }
            case 61:
                this.tIH.M(bundle);
                return;
            case 62:
                this.tIH.N(bundle);
                return;
            case 119:
                final String string3 = bundle.getString("fts_key_json_data");
                final String string4 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa == null) {
                            return;
                        }
                        if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                            BaseSOSWebViewUI.this.tsa.c(string3, z, string4);
                            return;
                        }
                        d r = BaseSOSWebViewUI.this.tsa;
                        String string = bundle2.getString("widgetId");
                        String str = string3;
                        if (r.tNo) {
                            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish success, ready");
                            Map hashMap = new HashMap();
                            hashMap.put("widgetId", string);
                            hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, str);
                            ah.y(new AnonymousClass41(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchWAWidgetReloadDataFinish", hashMap, r.tNq, r.tNr)));
                            return;
                        }
                        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadDataFinish fail, not ready");
                    }
                });
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa != null) {
                            BaseSOSWebViewUI.this.tsa.aU(i2, string);
                        }
                    }
                });
                return;
            case 121:
                string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa != null) {
                            BaseSOSWebViewUI.this.tsa.g(i3, string, i2);
                        }
                    }
                });
                return;
            case 122:
                string = bundle.getString("fts_key_new_query");
                String string5 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string6 = bundle.getString("fts_key_tag_list");
                x.i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string, Boolean.valueOf(z2));
                List arrayList = new ArrayList();
                try {
                    if (!bi.oN(string6)) {
                        JSONArray jSONArray = new JSONArray(string6);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            a aVar = new a();
                            aVar.tIP = jSONObject.getString("tagName");
                            aVar.tIQ = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.tIE != null) {
                    if (arrayList.size() > 0) {
                        this.tIE.t(string5, arrayList);
                    } else {
                        this.tIE.t(string, arrayList);
                        this.tIE.cxV();
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable() {
                        public final void run() {
                            if (BaseSOSWebViewUI.this.tsa != null) {
                                BaseSOSWebViewUI.this.tsa.b(BaseSOSWebViewUI.this.bUp(), BaseSOSWebViewUI.this.bUr(), BaseSOSWebViewUI.this.bUs());
                            }
                        }
                    });
                    if (this.tIE != null) {
                        this.tIE.cxS();
                    }
                    bTP();
                    return;
                } else if (this.tIE != null) {
                    this.tIE.yqL.clearFocus();
                    return;
                } else {
                    return;
                }
            case 124:
                string2 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa != null) {
                            BaseSOSWebViewUI.this.tsa.Qi(string2);
                        }
                    }
                });
                return;
            case 125:
                string = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa != null) {
                            BaseSOSWebViewUI.this.tsa.cN(string, i2);
                        }
                    }
                });
                return;
            case FileUtils.S_IWUSR /*128*/:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                final Map hashMap = new HashMap();
                for (String string22 : bundle.keySet()) {
                    hashMap.put(string22, bundle.get(string22));
                }
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa != null) {
                            BaseSOSWebViewUI.this.tsa.ao(hashMap);
                        }
                    }
                });
                return;
            case 138:
                string = bundle.getString("fts_key_data");
                if (bi.oN(string)) {
                    this.tIG = 0;
                    return;
                } else if ("index".equals(string)) {
                    this.tIG = 1;
                    return;
                } else if ("result".equals(string)) {
                    this.tIG = 2;
                    return;
                } else if ("suggestion".equals(string)) {
                    this.tIG = 3;
                    return;
                } else if ("teach".equals(string)) {
                    this.tIG = 4;
                    return;
                } else if ("local".equals(string)) {
                    this.tIG = 5;
                    return;
                } else {
                    this.tIG = 0;
                    return;
                }
            case 143:
                string22 = bundle.getString(SlookAirButtonFrequentContactAdapter.DATA);
                this.handler.post(new Runnable() {
                    public final void run() {
                        if (BaseSOSWebViewUI.this.tsa != null) {
                            d u = BaseSOSWebViewUI.this.tsa;
                            String str = string22;
                            if (u.tNo) {
                                x.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                                try {
                                    ah.y(new AnonymousClass34(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("onSearchHistoryReady", new JSONObject(str), u.tNq, u.tNr)));
                                    return;
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.JsApiHandler", e, "", new Object[0]);
                                    return;
                                }
                            }
                            x.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                        }
                    }
                });
                return;
            case e.CTRL_INDEX /*144*/:
                com.tencent.mm.plugin.webview.fts.b.bPS();
                com.tencent.mm.bb.l.lY(bundle.getString("appid"));
                return;
            case 100001:
                this.tIH.L(bundle);
                return;
            default:
                super.h(i, bundle);
                return;
        }
    }

    protected final com.tencent.mm.plugin.webview.fts.b bUo() {
        return this.tIH;
    }

    protected final String bUp() {
        return this.tIE.bUp();
    }

    protected final int bUq() {
        return this.tIY;
    }

    protected final String bUr() {
        return this.tIE.bUr();
    }

    public final JSONArray bUs() {
        List<com.tencent.mm.ui.fts.widget.a.b> list = this.tIE.rNc;
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.ui.fts.widget.a.b bVar : list) {
            a aVar = (a) bVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.tIP);
                jSONObject.put("tagType", aVar.tIQ);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray;
    }

    public void onBackPressed() {
        bUe();
    }

    protected final void b(int i, String str, Map<String, Object> map) {
        c cVar;
        x.v("MicroMsg.FTS.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", Integer.valueOf(i), str, map);
        if (this.tIF == null) {
            this.tIF = new ArrayList();
        }
        if (bUp().length() > 0) {
            cVar = new c();
            cVar.type = this.tIY;
            cVar.rNc = new ArrayList(this.tIE.rNc);
            cVar.tIS = this.tIE.bUr();
            cVar.tIR = this.tIE.bUp();
            if (this.tIF.size() == 0) {
                this.tIF.add(cVar);
            } else if (!cVar.equals((c) this.tIF.get(0))) {
                this.tIF.add(0, cVar);
            }
        }
        if (this.tIF != null && !this.tIF.isEmpty()) {
            c cVar2 = (c) this.tIF.get(0);
            cVar = new c();
            cVar.type = i;
            cVar.tIR = str;
            cVar.tIT = map;
            if (cVar2 != null) {
                int i2;
                if (cVar2 == cVar) {
                    i2 = 1;
                } else {
                    cVar = cVar;
                    i2 = (cVar.type == cVar2.type && cVar.tIR.trim().equals(cVar2.tIR.trim())) ? 1 : 0;
                }
                if (i2 != 0) {
                    cVar2.tIT = map;
                }
            }
        }
    }

    protected boolean bUt() {
        return true;
    }

    public final String Bh(int i) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("key", "educationTab");
            Bundle o = this.jAm.o(2, bundle);
            String string = o.getString("result");
            String string2 = o.getString("result_1");
            if (string2 != null) {
                string = string2;
            }
            JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
            if (optJSONArray == null) {
                return "";
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject.optInt("businessType") == i) {
                    return optJSONObject.optString("hotword");
                }
            }
            return "";
        } catch (Exception e) {
        }
    }
}
