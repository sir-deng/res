package com.tencent.mm.plugin.webview.fts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e implements com.tencent.mm.ad.e {
    private long jEJ;
    public com.tencent.mm.sdk.b.c jil = new com.tencent.mm.sdk.b.c<jt>() {
        {
            this.xmG = jt.class.getName().hashCode();
        }

        private boolean a(jt jtVar) {
            ati ati = jtVar.fBu.fBq;
            if (ati != null && com.tencent.mm.au.b.d(ati)) {
                switch (jtVar.fBu.action) {
                    case 0:
                    case 1:
                        for (Integer intValue : e.this.tsL) {
                            h.Bw(intValue.intValue()).cN(ati.wdd, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        for (Integer intValue2 : e.this.tsL) {
                            h.Bw(intValue2.intValue()).cN(ati.wdd, 0);
                        }
                        break;
                }
            }
            return false;
        }
    };
    public com.tencent.mm.plugin.fts.a.a.a mRL;
    public k pni = new k() {
        public final void b(final com.tencent.mm.plugin.fts.a.a.h hVar) {
            if (hVar.bjW == 0) {
                final ArrayList arrayList = new ArrayList();
                for (j jVar : hVar.mRN) {
                    arrayList.add(jVar.content);
                }
                ah.y(new Runnable() {
                    public final void run() {
                        if (e.this.mRL != null && e.this.mRL.mQY != null) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(((Integer) e.this.mRL.mQY).intValue());
                            String str = hVar.mON.fEe;
                            x.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", arrayList.toString());
                            Bundle bundle = new Bundle();
                            bundle.putString("query", str);
                            bundle.putStringArrayList("result", r2);
                            try {
                                if (Bw.fCC != null) {
                                    Bw.fCC.n(126, bundle);
                                }
                            } catch (RemoteException e) {
                                x.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + e.getMessage());
                            }
                        }
                    }
                });
            }
        }
    };
    public Set<Integer> tsL;
    public k tsM = new k() {
        public final void b(final com.tencent.mm.plugin.fts.a.a.h hVar) {
            final f fVar = (f) hVar.mON;
            x.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener ret %d, webViewId %s", Integer.valueOf(hVar.bjW), Integer.valueOf(fVar.ttm));
            if (hVar.bjW == 0) {
                final ArrayList arrayList = new ArrayList();
                for (j jVar : hVar.mRN) {
                    arrayList.add(jVar.content);
                }
                ah.y(new Runnable() {
                    public final void run() {
                        if (fVar.ttm != 0) {
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "historySearchResultListener callback， id %d", Integer.valueOf(fVar.ttm));
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(fVar.ttm);
                            String str = hVar.mON.fEe;
                            try {
                                x.i("MicroMsg.MsgHandler", "onGetSearchHistory %s", arrayList.toString());
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("ret", 0);
                                JSONArray jSONArray = new JSONArray();
                                JSONArray jSONArray2 = new JSONArray();
                                Iterator it = r0.iterator();
                                while (it.hasNext()) {
                                    str = (String) it.next();
                                    JSONObject jSONObject2 = new JSONObject();
                                    jSONObject2.put("word", str);
                                    jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, System.currentTimeMillis());
                                    jSONObject2.put("timeStamp", System.currentTimeMillis());
                                    jSONArray2.put(jSONObject2);
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("items", jSONArray2);
                                jSONArray.put(jSONObject3);
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                                Bundle bundle = new Bundle();
                                bundle.putString(SlookAirButtonFrequentContactAdapter.DATA, jSONObject.toString());
                                try {
                                    if (Bw.fCC != null) {
                                        Bw.fCC.n(143, bundle);
                                    } else {
                                        x.i("MicroMsg.MsgHandler", "callbacker is null");
                                    }
                                } catch (RemoteException e) {
                                    x.w("MicroMsg.MsgHandler", "onGetSearchHistory exception" + e.getMessage());
                                }
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.MsgHandler", e2, "", new Object[0]);
                            }
                        }
                    }
                });
            }
        }
    };
    private HashMap<String, b> tsN;
    public k tsO;
    public com.tencent.mm.bb.h tsP;
    private Map<Integer, g> tsQ = new HashMap();
    public e tsR = new e();
    public List<ati> tsS;
    private com.tencent.mm.plugin.webview.fts.a.c tsT;
    com.tencent.mm.plugin.webview.fts.a.d tsU;

    private class c {
        public String fEe;
        public String fqG;
        public String iVa;
        public String pnr;
        public int position;
        public py pot;
        public int scene;
        public String signature;
        public int tqu;
        public int tth;
        public boolean tti;
        public String ttj;
        public String username;

        private c() {
        }

        /* synthetic */ c(e eVar, byte b) {
            this();
        }
    }

    public class e {
        public String fEe;
        public boolean fpa;
        public int mVj;
        public int scene;
        public boolean skB;
        public boolean ttl = true;

        public final void f(int i, String str, int i2) {
            this.fEe = str;
            this.scene = i;
            this.fpa = false;
            this.mVj = i2;
            this.skB = false;
            this.ttl = false;
        }
    }

    private class f extends com.tencent.mm.plugin.fts.a.a.g {
        public int ttm;

        private f() {
        }

        public /* synthetic */ f(e eVar, byte b) {
            this();
        }
    }

    private class a implements Runnable {
        public String data;
        public boolean ttd;

        private a() {
        }

        public /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            Object arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    bpb mK = ((m) com.tencent.mm.kernel.g.h(m.class)).mK(jSONArray.getString(i));
                    com.tencent.mm.au.a.a aVar = (com.tencent.mm.au.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.au.a.a.class);
                    as.Hm();
                    ati a = aVar.a(com.tencent.mm.y.c.FJ(), mK, 9);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (!this.ttd || e.this.tsS == null) {
                    e.this.tsS = arrayList;
                } else {
                    e.this.tsS.addAll(arrayList);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
        }
    }

    private class b {
        String fxH;
        boolean hNZ;
        String lKv;
        int scene;
        long tte;
        long ttf;
        private String ttg;
        int type;

        private b() {
            this.hNZ = false;
            this.ttg = null;
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        final boolean isAvailable() {
            if (this.hNZ || bi.oN(this.fxH) || (System.currentTimeMillis() / 1000) - this.ttf > this.tte) {
                return false;
            }
            return true;
        }

        final String bPV() {
            if (this.ttg == null) {
                this.ttg = "";
                try {
                    JSONArray optJSONArray = new JSONObject(this.fxH).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject("hotwords").optJSONArray("items");
                    Iterable arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Uri.encode(optJSONArray.optJSONObject(i).optString("hotword")));
                    }
                    this.ttg = TextUtils.join("|", arrayList);
                } catch (Exception e) {
                }
            }
            return this.ttg;
        }

        final void ek(int i, int i2) {
            aqk aqk = new aqk();
            as.Hm();
            String Fu = com.tencent.mm.y.c.Fu();
            String n = e.n(i, i2, false);
            if (!n.equals(e.n(i, i2, true))) {
                this.hNZ = true;
            }
            File file = new File(Fu, n);
            byte[] d = com.tencent.mm.a.e.d(file.getAbsolutePath(), 0, (int) file.length());
            if (d != null) {
                try {
                    aqk.aH(d);
                    this.scene = aqk.scene;
                    this.fxH = aqk.vUV;
                    this.tte = aqk.wDP;
                    this.ttf = aqk.wDQ;
                    this.lKv = aqk.vWw;
                    this.type = aqk.kzz;
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", file.getAbsolutePath(), Integer.valueOf(d.length));
                } catch (IOException e) {
                }
            }
        }
    }

    private class d {
        public String country;
        public String fEe;
        public int fXa;
        public String fXk;
        public String fXl;
        public String fqG;
        public String ggL;
        public int scene;
        public String signature;
        public int ttk;
        public String username;

        private d() {
        }

        /* synthetic */ d(e eVar, byte b) {
            this();
        }
    }

    private static class g {
        public String fxH;
        public long sAT;
        public int scene;
        public long ttf;

        public g() {
            this.scene = 0;
            this.fxH = "";
            this.sAT = 0;
            this.ttf = 0;
        }

        public g(byx byx) {
            this.scene = 0;
            this.fxH = "";
            this.sAT = 0;
            this.ttf = 0;
            this.scene = 201;
            this.fxH = byx.fxH;
            this.sAT = (long) byx.hZI;
            this.ttf = System.currentTimeMillis() / 1000;
        }

        public static g Aq(int i) {
            as.Hm();
            File file = new File(com.tencent.mm.y.c.Fu(), Ar(201));
            byte[] d = com.tencent.mm.a.e.d(file.getAbsolutePath(), 0, (int) file.length());
            try {
                aql aql = new aql();
                aql.aH(d);
                g gVar = new g();
                try {
                    gVar.scene = aql.sfa;
                    gVar.fxH = aql.vUV;
                    gVar.sAT = aql.wDR;
                    gVar.ttf = aql.wDQ;
                    return gVar;
                } catch (Exception e) {
                    return gVar;
                }
            } catch (Exception e2) {
                return null;
            }
        }

        static String Ar(int i) {
            return "SearchGuide_" + i + "-" + w.eM(ad.getContext());
        }

        public final boolean bPW() {
            return this.ttf + this.sAT <= System.currentTimeMillis() / 1000;
        }
    }

    public e() {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.tsN = new HashMap();
        this.tsL = Collections.synchronizedSet(new HashSet());
        com.tencent.mm.sdk.b.a.xmy.b(this.jil);
    }

    public static Bundle o(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 2:
                try {
                    String string = bundle.getString("key");
                    bundle2.putString("result", com.tencent.mm.plugin.aj.a.h.Oy(string).toString());
                    if ("educationTab".equals(string)) {
                        JSONObject Oy = com.tencent.mm.plugin.aj.a.h.Oy("discoverSearchGuide");
                        if (Oy.optJSONArray("items").length() > 0) {
                            bundle2.putString("result_1", Oy.toString());
                            break;
                        }
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            case 4:
                Map b = com.tencent.mm.bb.b.b(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt(Columns.TYPE));
                bundle2.putString(Columns.TYPE, (String) b.get(Columns.TYPE));
                bundle2.putString("isMostSearchBiz", (String) b.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", (String) b.get("isLocalSug"));
                bundle2.putString("isSug", (String) b.get("isSug"));
                bundle2.putString("scene", (String) b.get("scene"));
                break;
            case 6:
                try {
                    bundle2.putString("result", com.tencent.mm.plugin.aj.a.h.Oz(bundle.getString("key")));
                    break;
                } catch (Exception e2) {
                    break;
                }
            case 7:
                bundle2.putString(SlookAirButtonFrequentContactAdapter.DATA, com.tencent.mm.plugin.webview.modeltools.f.bSl().bPT());
                break;
        }
        return bundle2;
    }

    public final boolean ab(Map<String, Object> map) {
        String r;
        int c;
        switch (f.c(map, "action", 0)) {
            case 1:
                if (com.tencent.mm.bb.c.hMr == null) {
                    com.tencent.mm.bb.c.Rb();
                }
                com.tencent.mm.bb.c.hMr.kyB.clear();
                SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    sharedPreferences.edit().putString(com.tencent.mm.bb.c.Rc(), Base64.encodeToString(com.tencent.mm.bb.c.hMr.toByteArray(), 0)).apply();
                    x.i("MicroMsg.FTS.FTSHistorySearchLogic", "addHistory pbListString %s", r);
                    break;
                } catch (IOException e) {
                    break;
                }
            case 2:
                int c2 = f.c(map, Columns.TYPE, 0);
                c = f.c(map, "scene", 0);
                if (System.currentTimeMillis() - this.jEJ > 1000) {
                    this.jEJ = System.currentTimeMillis();
                    if (!com.tencent.mm.plugin.aj.a.g.Ae(0)) {
                        x.e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                    com.tencent.mm.bb.g.b(c2, c, com.tencent.mm.plugin.aj.a.h.Oz("searchID"));
                    Intent QT = com.tencent.mm.bb.b.QT();
                    QT.putExtra("ftsneedkeyboard", true);
                    QT.putExtra("ftsbizscene", c);
                    QT.putExtra("ftsType", c2);
                    QT.putExtra("rawUrl", com.tencent.mm.bb.b.r(com.tencent.mm.bb.b.b(c, true, c2)));
                    QT.putExtra("key_load_js_without_delay", true);
                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", QT);
                    break;
                }
                break;
            case 3:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(f.c(map, "webview_instance_id", -1));
                c = f.c(map, "scene", 0);
                r = f.r(map, "query");
                if (c == 20 && !bi.oN(r)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("fts_key_new_query", r);
                    try {
                        if (Bw.fCC != null) {
                            Bw.fCC.n(com.tencent.mm.plugin.appbrand.jsapi.map.h.CTRL_INDEX, bundle);
                            break;
                        }
                    } catch (Exception e2) {
                        x.w("MicroMsg.MsgHandler", "doSearchHotWordOperation exception" + e2.getMessage());
                        break;
                    }
                }
                x.w("MicroMsg.MsgHandler", "doSearchHotWordOperation warning, scene=%d, query=%s", Integer.valueOf(c), r);
                break;
                break;
        }
        return false;
    }

    public final String bPT() {
        String n = n(20, 0, true);
        if (this.tsN.get(n) == null) {
            b bVar = new b();
            bVar.ek(20, 0);
            this.tsN.put(n, bVar);
        }
        b bVar2 = (b) this.tsN.get(n);
        n = bVar2.isAvailable() ? bVar2.fxH : "";
        return bi.oN(n) ? "" : n;
    }

    public final boolean ac(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", map);
        int c = f.c(map, "scene", 0);
        int c2 = f.c(map, Columns.TYPE, 0);
        int c3 = f.c(map, "requestType", 0);
        int p = bi.p(map.get("webview_instance_id"), -1);
        String str = (String) map.get("requestId");
        boolean t = f.t(map, "ignoreCache");
        String n;
        if (c3 == 0) {
            b bVar;
            n = n(c, c2, true);
            if (this.tsN.get(n) == null) {
                bVar = new b();
                bVar.ek(c, c2);
                this.tsN.put(n, bVar);
            }
            bVar = (b) this.tsN.get(n);
            if (!(bi.oN(bVar.fxH) || t)) {
                x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d, cache %s", Integer.valueOf(p), bVar.fxH);
                if (!(bVar.scene == 20 && bVar.type == 0 && (bVar.hNZ || !bVar.isAvailable()))) {
                    h.Bw(p).c(c3, bVar.fxH, 1, str);
                }
            }
            if (!bVar.isAvailable() || t) {
                as.CN().a(1048, (com.tencent.mm.ad.e) this);
                x.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", Integer.valueOf(p));
                this.tsP = new com.tencent.mm.bb.h(c, c2, com.tencent.mm.plugin.aj.a.g.Af(0), p, w.eM(ad.getContext()), com.tencent.mm.plugin.aj.a.h.Oy("discoverSearchEntry").optLong("guideParam"), str);
                as.CN().a(this.tsP, 0);
            } else {
                x.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d, data %s", Integer.valueOf(bVar.scene), Long.valueOf(bVar.tte), Long.valueOf(bVar.ttf), Integer.valueOf(bVar.type), bVar.fxH);
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.bb.g.a(bVar.scene, 0, bVar.lKv, bVar.type, 2, bVar.bPV(), 1);
                } else {
                    com.tencent.mm.bb.g.a(bVar.scene, 0, bVar.lKv, bVar.type, 1, "", 0);
                }
                return false;
            }
        }
        atd Re = com.tencent.mm.bb.d.Re();
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            for (c = Re.kyB.size() - 1; c >= 0; c--) {
                JSONObject jSONObject3 = new JSONObject();
                atc atc = (atc) Re.kyB.get(c);
                if (s.gH(atc.vPp)) {
                    com.tencent.mm.af.d jV = com.tencent.mm.af.f.jV(atc.vPp);
                    if (jV != null) {
                        jSONObject3.put("avatarUrl", jV.field_brandIconURL);
                        jSONObject3.put("userName", jV.field_username);
                        jSONObject3.put("nickName", r.gw(jV.field_username));
                        jSONArray2.put(jSONObject3);
                    }
                }
            }
            jSONObject2.put("items", jSONArray2);
            jSONObject2.put(Columns.TYPE, 5);
            jSONObject2.put("title", "");
            jSONArray.put(jSONObject2);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
            x.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", jSONObject.toString());
            h.Bw(p).c(1, n, 1, str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "gen mostSearchBizContactList error", new Object[0]);
        }
        return false;
    }

    public final boolean ad(Map<String, Object> map) {
        g Aq;
        int i = 1;
        int p = bi.p(map.get("webview_instance_id"), -1);
        if (this.tsQ.get(Integer.valueOf(201)) == null) {
            Aq = g.Aq(201);
            if (Aq != null) {
                this.tsQ.put(Integer.valueOf(201), Aq);
            }
        }
        Aq = (g) this.tsQ.get(Integer.valueOf(201));
        if (Aq != null) {
            h.Bw(p).W(Aq.fxH, 1, Aq.bPW() ? 1 : 0);
            i = Aq.bPW();
        }
        if (i != 0) {
            as.CN().a(1866, (com.tencent.mm.ad.e) this);
            com.tencent.mm.ad.k gVar = new g();
            if (map != null) {
                gVar.fEg = f.c(map, "webview_instance_id", -1);
            }
            as.CN().a(gVar, 0);
        }
        return false;
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar) {
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        boolean t;
        Bundle bundle;
        int c;
        String r;
        Intent intent;
        Object obj;
        int c2;
        Map a;
        String zZ;
        x.i("MicroMsg.FTS.FTSWebViewLogic", "openSearchWebView %s", map.toString());
        int Wo = bi.Wo((String) map.get("actionType"));
        int c3 = f.c(map, Columns.TYPE, 0);
        String str5 = (String) map.get("extParams");
        String str6 = (String) map.get("jumpTo");
        String str7 = (String) map.get("navBarColor");
        String str8 = (String) map.get("nativeConfig");
        if (!TextUtils.isEmpty(str8)) {
            try {
                JSONObject jSONObject = new JSONObject(str8);
                if (jSONObject.has("title")) {
                    str8 = jSONObject.optString("title");
                } else {
                    str8 = null;
                }
                str = str8;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
            i = 0;
            if (!bi.oN(str7)) {
                try {
                    i = Color.parseColor(str7);
                } catch (IllegalArgumentException e2) {
                    x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e2.getMessage());
                    return true;
                }
            }
            str2 = (String) map.get("statusBarStyle");
            str3 = (String) map.get("tagId");
            str4 = (String) map.get("sessionId");
            switch (Wo) {
                case 1:
                    switch (c3) {
                        case 1:
                            a(af(map), false);
                            break;
                        case 8:
                            f.r(map, "snsid");
                            str6 = f.r(map, "objectXmlDesc");
                            str7 = f.r(map, "userName");
                            t = f.t(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.f.bSl();
                            p(str6, str7, t);
                            break;
                        case 32:
                            a(ag(map));
                            break;
                        default:
                            str6 = f.r(map, "jumpUrl");
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str6);
                            bundle = null;
                            if (gVar != null) {
                                bundle = gVar.bVv();
                            }
                            if (!bi.oN(str6)) {
                                com.tencent.mm.plugin.webview.modeltools.f.bSl();
                                a(str6, bundle, i, str2, "", 0);
                                break;
                            }
                            break;
                    }
                case 2:
                    str6 = f.r(map, "jumpUrl");
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str6);
                    bundle = null;
                    if (gVar != null) {
                        bundle = gVar.bVv();
                    }
                    if (!bi.oN(str6)) {
                        com.tencent.mm.plugin.webview.modeltools.f.bSl();
                        a(str6, bundle, i, str2, "", 0);
                        break;
                    }
                    break;
                case 3:
                    str7 = f.r(map, "query");
                    c = f.c(map, "scene", 0);
                    r = f.r(map, "searchId");
                    intent = new Intent();
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("key_load_js_without_delay", true);
                    intent.putExtra("ftsQuery", str7);
                    intent.putExtra("ftsType", c3);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    intent.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str6));
                    if (str != null) {
                        intent.putExtra("title", str);
                    }
                    if (com.tencent.mm.bb.m.Rq()) {
                        obj = f.c(map, "isWeAppMore", 0) != 1 ? 1 : null;
                        c2 = f.c(map, "tabPageType", 0);
                        if (obj == null) {
                            a = com.tencent.mm.bb.b.a(c, false, c3, str5);
                            a.put("query", str7);
                            a.put("searchId", r);
                            if (!TextUtils.isEmpty(str4)) {
                                a.put("sessionId", str4);
                                intent.putExtra("sessionId", str4);
                            }
                            zZ = com.tencent.mm.plugin.aj.a.g.zZ(c);
                            a.put("subSessionId", zZ);
                            intent.putExtra("subSessionId", zZ);
                            intent.putExtra("rawUrl", com.tencent.mm.bb.b.c(c, a));
                            intent.putExtra("ftsQuery", str7);
                            intent.putExtra("customize_status_bar_color", i);
                            intent.putExtra("status_bar_style", str2);
                            intent.putExtra("tabId", str3);
                            if (c2 == 1) {
                                if (c != 20 || c == 22 || c == 33) {
                                    obj = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                                } else {
                                    obj = ".ui.tools.fts.FTSSearchTabWebViewUI";
                                }
                                if (!TextUtils.isEmpty(obj)) {
                                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", obj, intent);
                                    break;
                                }
                            }
                            intent.putExtra("ftscaneditable", false);
                            com.tencent.mm.bb.b.a(ad.getContext(), str7, intent, str, str5, r, str4, zZ);
                            return false;
                        }
                        a = com.tencent.mm.bb.m.a(c, false, c3, str5);
                        a.put("query", str7);
                        a.put("searchId", r);
                        a.put("subType", String.valueOf(f.c(map, "subType", 0)));
                        a.put("isWeAppMore", String.valueOf(f.c(map, "isWeAppMore", 0)));
                        str7 = com.tencent.mm.modelappbrand.b.Ja();
                        a.put("sessionId", str7);
                        intent.putExtra("key_session_id", str7);
                        intent.putExtra("rawUrl", com.tencent.mm.bb.m.r(a));
                        intent.putExtra("ftsbizscene", c);
                        intent.putExtra("customize_status_bar_color", i);
                        intent.putExtra("status_bar_style", str2);
                        if (c != 20 || c == 22) {
                            str6 = ".ui.AppBrandSOSUI";
                        } else {
                            str6 = ".ui.AppBrandSearchUI";
                        }
                        com.tencent.mm.bl.d.b(ad.getContext(), "appbrand", str6, intent);
                        break;
                    }
                    a = com.tencent.mm.bb.b.bj(c, c3);
                    a.put("query", str7);
                    a.put("searchId", r);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.b.c(c, a));
                    if (c != 20 || c == 22 || c == 33) {
                        str6 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str6 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", str6, intent);
                    break;
                    break;
                case 4:
                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.fts.FtsBrowseHistoryUI", new Intent());
                    break;
            }
            return false;
        }
        str = null;
        i = 0;
        if (bi.oN(str7)) {
            i = Color.parseColor(str7);
        }
        str2 = (String) map.get("statusBarStyle");
        str3 = (String) map.get("tagId");
        str4 = (String) map.get("sessionId");
        switch (Wo) {
            case 1:
                switch (c3) {
                    case 1:
                        a(af(map), false);
                        break;
                    case 8:
                        f.r(map, "snsid");
                        str6 = f.r(map, "objectXmlDesc");
                        str7 = f.r(map, "userName");
                        t = f.t(map, "fromMusicItem");
                        com.tencent.mm.plugin.webview.modeltools.f.bSl();
                        p(str6, str7, t);
                        break;
                    case 32:
                        a(ag(map));
                        break;
                    default:
                        str6 = f.r(map, "jumpUrl");
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str6);
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.bVv();
                        }
                        if (bi.oN(str6)) {
                            com.tencent.mm.plugin.webview.modeltools.f.bSl();
                            a(str6, bundle, i, str2, "", 0);
                            break;
                        }
                        break;
                }
            case 2:
                str6 = f.r(map, "jumpUrl");
                x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", str6);
                bundle = null;
                if (gVar != null) {
                    bundle = gVar.bVv();
                }
                if (bi.oN(str6)) {
                    com.tencent.mm.plugin.webview.modeltools.f.bSl();
                    a(str6, bundle, i, str2, "", 0);
                    break;
                }
                break;
            case 3:
                str7 = f.r(map, "query");
                c = f.c(map, "scene", 0);
                r = f.r(map, "searchId");
                intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str7);
                intent.putExtra("ftsType", c3);
                intent.putExtra("customize_status_bar_color", i);
                intent.putExtra("status_bar_style", str2);
                intent.putExtra("jumpto_sns_contact_page", "snsContactPage".equalsIgnoreCase(str6));
                if (str != null) {
                    intent.putExtra("title", str);
                }
                if (com.tencent.mm.bb.m.Rq()) {
                    a = com.tencent.mm.bb.b.bj(c, c3);
                    a.put("query", str7);
                    a.put("searchId", r);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.b.c(c, a));
                    if (c != 20) {
                        break;
                    }
                    str6 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", str6, intent);
                    break;
                }
                if (f.c(map, "isWeAppMore", 0) != 1) {
                }
                c2 = f.c(map, "tabPageType", 0);
                if (obj == null) {
                    a = com.tencent.mm.bb.m.a(c, false, c3, str5);
                    a.put("query", str7);
                    a.put("searchId", r);
                    a.put("subType", String.valueOf(f.c(map, "subType", 0)));
                    a.put("isWeAppMore", String.valueOf(f.c(map, "isWeAppMore", 0)));
                    str7 = com.tencent.mm.modelappbrand.b.Ja();
                    a.put("sessionId", str7);
                    intent.putExtra("key_session_id", str7);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.m.r(a));
                    intent.putExtra("ftsbizscene", c);
                    intent.putExtra("customize_status_bar_color", i);
                    intent.putExtra("status_bar_style", str2);
                    if (c != 20) {
                        break;
                    }
                    str6 = ".ui.AppBrandSOSUI";
                    com.tencent.mm.bl.d.b(ad.getContext(), "appbrand", str6, intent);
                    break;
                }
                a = com.tencent.mm.bb.b.a(c, false, c3, str5);
                a.put("query", str7);
                a.put("searchId", r);
                if (TextUtils.isEmpty(str4)) {
                    a.put("sessionId", str4);
                    intent.putExtra("sessionId", str4);
                }
                zZ = com.tencent.mm.plugin.aj.a.g.zZ(c);
                a.put("subSessionId", zZ);
                intent.putExtra("subSessionId", zZ);
                intent.putExtra("rawUrl", com.tencent.mm.bb.b.c(c, a));
                intent.putExtra("ftsQuery", str7);
                intent.putExtra("customize_status_bar_color", i);
                intent.putExtra("status_bar_style", str2);
                intent.putExtra("tabId", str3);
                if (c2 == 1) {
                    if (c != 20) {
                        break;
                    }
                    obj = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    if (TextUtils.isEmpty(obj)) {
                        com.tencent.mm.bl.d.b(ad.getContext(), "webview", obj, intent);
                        break;
                    }
                }
                intent.putExtra("ftscaneditable", false);
                com.tencent.mm.bb.b.a(ad.getContext(), str7, intent, str, str5, r, str4, zZ);
                return false;
                break;
            case 4:
                com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.fts.FtsBrowseHistoryUI", new Intent());
                break;
        }
        return false;
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar, String str) {
        this.tsR.skB = true;
        boolean t = f.t(map, "isTeachPage");
        boolean t2 = f.t(map, "isMoreButton");
        Object obj = f.c(map, "isFeedBack", 0) == 1 ? 1 : null;
        Object obj2 = f.c(map, "isWeAppMore", 0) == 1 ? 1 : null;
        String r = f.r(map, "sessionId");
        String str2 = (String) map.get("navBarColor");
        int i = 0;
        if (!bi.oN(str2)) {
            try {
                i = Color.parseColor(str2);
            } catch (IllegalArgumentException e) {
                x.e("MicroMsg.FTS.FTSWebViewLogic", "startSearchItemDetailPage: " + e.getMessage());
                return true;
            }
        }
        String str3 = (String) map.get("statusBarStyle");
        String r2;
        Bundle bundle;
        if (obj == null) {
            int c = f.c(map, Columns.TYPE, 0);
            int c2 = f.c(map, "opType", 0);
            if (c2 <= 0) {
                if (!t2) {
                    str2 = (String) map.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", Integer.valueOf(c), str2);
                    switch (c) {
                        case 1:
                            a(af(map), false);
                            break;
                        case 8:
                            f.r(map, "snsid");
                            str2 = f.r(map, "objectXmlDesc");
                            r2 = f.r(map, "userName");
                            boolean t3 = f.t(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.modeltools.f.bSl();
                            p(str2, r2, t3);
                            break;
                        case 32:
                            a(ag(map));
                            break;
                        default:
                            str2 = f.r(map, "jumpUrl");
                            x.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s, publishId = %s, payScene = %d", str2, f.r(map, "publishId"), Integer.valueOf(f.c(map, "payScene", 0)));
                            Bundle bundle2 = null;
                            if (gVar != null) {
                                bundle2 = gVar.bVv();
                            }
                            if (!bi.oN(str2)) {
                                com.tencent.mm.plugin.webview.modeltools.f.bSl();
                                a(str2, bundle2, i, str3, r4, r5);
                                break;
                            }
                            break;
                    }
                }
                str2 = f.r(map, "query");
                i = f.c(map, "scene", 0);
                str3 = f.r(map, "searchId");
                Intent intent = new Intent();
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("key_load_js_without_delay", true);
                intent.putExtra("ftsQuery", str2);
                intent.putExtra("ftsType", c);
                intent.putExtra("sessionId", r);
                Map bj;
                if (!com.tencent.mm.bb.m.Rq()) {
                    bj = com.tencent.mm.bb.b.bj(i, c);
                    try {
                        bj.put("query", p.encode(str2, "UTF-8"));
                    } catch (Exception e2) {
                        bj.put("query", str2);
                    }
                    bj.put("searchId", str3);
                    bj.put("sessionId", r);
                    str2 = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) bj.get("scene")));
                    bj.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", r);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.b.c(i, bj));
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", str2, intent);
                } else if (obj2 != null) {
                    bj = com.tencent.mm.bb.m.a(i, false, c, str);
                    try {
                        bj.put("query", p.encode(str2, "UTF-8"));
                    } catch (Exception e3) {
                        bj.put("query", str2);
                    }
                    bj.put("searchId", str3);
                    bj.put("subType", String.valueOf(f.c(map, "subType", 0)));
                    bj.put("isWeAppMore", String.valueOf(f.c(map, "isWeAppMore", 0)));
                    bj.put("sessionId", r);
                    str3 = com.tencent.mm.modelappbrand.b.Ja();
                    bj.put("sessionId", str3);
                    str2 = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) bj.get("scene")));
                    bj.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("key_session_id", str3);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.m.r(bj));
                    intent.putExtra("ftsbizscene", i);
                    if (i == 20 || i == 22 || i == 24) {
                        str2 = ".ui.AppBrandSOSUI";
                    } else {
                        str2 = ".ui.AppBrandSearchUI";
                    }
                    com.tencent.mm.bl.d.b(ad.getContext(), "appbrand", str2, intent);
                } else {
                    bj = com.tencent.mm.bb.b.a(i, false, c, str);
                    try {
                        bj.put("query", p.encode(str2, "UTF-8"));
                    } catch (Exception e4) {
                        bj.put("query", str2);
                    }
                    bj.put("searchId", str3);
                    bj.put("sessionId", r);
                    str2 = com.tencent.mm.plugin.aj.a.g.zZ(bi.Wo((String) bj.get("scene")));
                    bj.put("subSessionId", str2);
                    intent.putExtra("subSessionId", str2);
                    intent.putExtra("rawUrl", com.tencent.mm.bb.b.c(i, bj));
                    intent.putExtra("key_session_id", r);
                    intent.putExtra("searchId", str3);
                    if (i == 20 || i == 22 || i == 24 || i == 33) {
                        str2 = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str2 = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", str2, intent);
                }
            } else {
                switch (c2) {
                    case 2:
                        a(af(map), t);
                        break;
                    case 3:
                        c af = af(map);
                        if (!s.gH(af.username)) {
                            a(af, t);
                            break;
                        }
                        com.tencent.mm.bb.d.lW(af.username);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Chat_User", af.username);
                        intent2.putExtra("finish_direct", true);
                        intent2.putExtra("key_temp_session_show_type", 0);
                        com.tencent.mm.bl.d.a(ad.getContext(), ".ui.chatting.ChattingUI", intent2);
                        break;
                    case 4:
                        r2 = f.r(map, "jumpUrl");
                        bundle = null;
                        if (gVar != null) {
                            bundle = gVar.bVv();
                        }
                        com.tencent.mm.plugin.webview.modeltools.f.bSl();
                        e(r2, bundle);
                        break;
                }
            }
        }
        r2 = f.r(map, "jumpUrl");
        bundle = null;
        if (gVar != null) {
            bundle = gVar.bVv();
        }
        com.tencent.mm.plugin.webview.modeltools.f.bSl();
        e(r2, bundle);
        return false;
    }

    public final boolean ae(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", map.toString());
        bdu bdu = new bdu();
        bdu.wQx = f.r(map, "logString");
        as.CN().a(1134, (com.tencent.mm.ad.e) this);
        as.CN().a(new j(bdu), 0);
        return false;
    }

    private static void e(String str, Bundle bundle) {
        a(str, bundle, 0, "", "", 0);
    }

    private static void a(String str, Bundle bundle, int i, String str2, String str3, int i2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        intent.putExtra("customize_status_bar_color", i);
        intent.putExtra("status_bar_style", str2);
        if (!bi.oN(str3)) {
            intent.putExtra("prePublishId", str3);
            intent.putExtra("KPublisherId", str3);
        } else if (!(bundle == null || bi.oN(str))) {
            String str4 = bundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.s(str.getBytes());
            intent.putExtra("prePublishId", str4);
            intent.putExtra("KPublisherId", str4);
        }
        if (i2 > 0) {
            intent.putExtra("pay_channel", i2);
        }
        com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    private static void p(String str, String str2, boolean z) {
        bpb mK = ((m) com.tencent.mm.kernel.g.h(m.class)).mK(str);
        Intent intent = new Intent();
        intent.putExtra("INTENT_TALKER", str2);
        intent.putExtra("INTENT_SNSID", new BigInteger(mK.nMq).longValue());
        intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
        try {
            intent.putExtra("INTENT_SNS_TIMELINEOBJECT", mK.toByteArray());
        } catch (IOException e) {
        }
        com.tencent.mm.bl.d.b(ad.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
    }

    private static void a(d dVar) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", dVar.username);
        intent.putExtra("Contact_Nick", dVar.fqG);
        intent.putExtra("Contact_Alias", dVar.ggL);
        intent.putExtra("Contact_Sex", dVar.fXa);
        intent.putExtra("Contact_Scene", dVar.scene);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(dVar.country, dVar.fXk, dVar.fXl));
        intent.putExtra("Contact_Signature", dVar.signature);
        intent.putExtra("Contact_KSnsIFlag", dVar.ttk);
        intent.putExtra("Contact_full_Mobile_MD5", dVar.fEe);
        com.tencent.mm.bl.d.b(ad.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    private static void a(c cVar, boolean z) {
        int i;
        if (cVar.tqu == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i = 39;
        } else if (cVar.tti) {
            i = 88;
        } else {
            i = 87;
        }
        com.tencent.mm.bb.d.lW(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.fqG);
        intent.putExtra("Contact_BrandIconURL", cVar.pnr);
        intent.putExtra("Contact_Signature", cVar.signature);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.tth);
        intent.putExtra("Contact_Scene", i);
        if (cVar.pot != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.pot.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.iVa);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.fEe);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.ttj);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.bl.d.b(ad.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    public static int c(Map<String, Object> map, Map<String, Object> map2) {
        try {
            JSONArray jSONArray = new JSONArray(f.r(map, SlookAirButtonFrequentContactAdapter.DATA));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object string;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has(SlookAirButtonFrequentContactAdapter.ID)) {
                    string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                } else {
                    String string2 = "";
                }
                String string3 = jSONObject.has("userName") ? jSONObject.getString("userName") : "";
                String gw = r.gw(string3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string2);
                jSONObject2.put("userName", string3);
                jSONObject2.put("displayName", gw);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray2.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        return 0;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        String n;
        int i3;
        String Fu;
        File file;
        byte[] bArr;
        if (kVar instanceof com.tencent.mm.bb.h) {
            as.CN().b(1048, (com.tencent.mm.ad.e) this);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.bb.h hVar = (com.tencent.mm.bb.h) kVar;
                b bVar = new b();
                bVar.scene = hVar.scene;
                bVar.tte = (long) hVar.hML.wDW;
                bVar.fxH = hVar.hML.vUV;
                bVar.ttf = System.currentTimeMillis() / 1000;
                bVar.lKv = hVar.hML.wDX;
                bVar.type = hVar.hMM;
                n = n(bVar.scene, bVar.type, true);
                x.i("MicroMsg.FTS.FTSWebViewLogic", "NetSceneWebSearchGuide cgi data %s ", bVar.fxH);
                if (!bi.oN(bVar.fxH)) {
                    h.Bw(hVar.fEg).c(0, bVar.fxH, 0, hVar.hMN);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", bVar.fxH);
                }
                this.tsN.put(n, bVar);
                if (bVar.tte == 0) {
                    i3 = bVar.scene;
                    int i4 = bVar.type;
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", Integer.valueOf(i3), Integer.valueOf(i4));
                    as.Hm();
                    Fu = com.tencent.mm.y.c.Fu();
                    file = new File(Fu, n(i3, i4, true));
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new File(Fu, n(i3, i4, false));
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    aqk aqk = new aqk();
                    aqk.scene = bVar.scene;
                    aqk.vUV = bVar.fxH;
                    aqk.wDP = bVar.tte;
                    aqk.wDQ = bVar.ttf;
                    aqk.vWw = bVar.lKv;
                    aqk.kzz = bVar.type;
                    bArr = null;
                    try {
                        bArr = aqk.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        as.Hm();
                        file = new File(com.tencent.mm.y.c.Fu(), n(bVar.scene, bVar.type, true));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", file.getAbsolutePath(), Integer.valueOf(bArr.length));
                    } else {
                        x.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.bb.g.a(bVar.scene, 1, bVar.lKv, bVar.type, 2, bVar.bPV(), 1);
                    return;
                } else {
                    com.tencent.mm.bb.g.a(bVar.scene, 1, bVar.lKv, bVar.type, 1, "", 0);
                    return;
                }
            }
            x.e("MicroMsg.FTS.FTSWebViewLogic", "onSceneEnd errType %d,errCode %d", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (kVar instanceof j) {
            as.CN().b(1134, (com.tencent.mm.ad.e) this);
        } else if (kVar instanceof k) {
            as.CN().b(1161, (com.tencent.mm.ad.e) this);
            if (i == 0 && i2 == 0) {
                n = this.tsO.Ji();
                final ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(n);
                    JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    Fu = jSONObject.optString("suggestionID", "");
                    jSONObject = null;
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (optJSONObject.optInt(Columns.TYPE) != 1) {
                            optJSONObject = jSONObject;
                        }
                        i5++;
                        jSONObject = optJSONObject;
                    }
                    if (jSONObject != null) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.optJSONObject(i3).optString("word");
                            if (!bi.oN(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    n = Fu;
                } catch (Exception e2) {
                    n = "";
                }
                ah.y(new Runnable() {
                    public final void run() {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(e.this.tsO.hlp.fEg);
                        String str = e.this.tsO.hlp.foW;
                        String str2 = n;
                        x.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", arrayList.toString());
                        Bundle bundle = new Bundle();
                        bundle.putString("query", str);
                        bundle.putString("suggestionId", str2);
                        bundle.putStringArrayList("result", r3);
                        try {
                            if (Bw.fCC != null) {
                                Bw.fCC.n(127, bundle);
                            }
                        } catch (RemoteException e) {
                            x.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + e.getMessage());
                        }
                    }
                });
            }
        } else if (kVar instanceof g) {
            as.CN().b(1866, (com.tencent.mm.ad.e) this);
            if (i == 0 && i2 == 0) {
                g gVar = (g) kVar;
                if (gVar.fEg != -1) {
                    h.Bw(gVar.fEg).W(((byx) gVar.gLB.hnR.hnY).fxH, 0, 0);
                }
                g gVar2 = new g((byx) gVar.gLB.hnR.hnY);
                aql aql = new aql();
                aql.sfa = gVar2.scene;
                aql.vUV = gVar2.fxH;
                aql.wDR = gVar2.sAT;
                aql.wDQ = gVar2.ttf;
                bArr = null;
                try {
                    bArr = aql.toByteArray();
                } catch (IOException e3) {
                }
                if (bArr != null) {
                    as.Hm();
                    file = new File(com.tencent.mm.y.c.Fu(), g.Ar(gVar2.scene));
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                    x.i("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj saved, scene:%d", Integer.valueOf(gVar2.scene));
                } else {
                    x.w("MicroMsg.FTS.FTSWebViewLogic", "SearchGuideCacheObj toBytes fail, scene:%d!", Integer.valueOf(gVar2.scene));
                }
                this.tsQ.put(Integer.valueOf(gVar2.scene), gVar2);
            }
        }
    }

    private c af(Map<String, Object> map) {
        c cVar = new c();
        cVar.username = f.r(map, "userName");
        cVar.fqG = f.r(map, "nickName");
        cVar.pnr = f.r(map, "headHDImgUrl");
        cVar.tth = f.c(map, "verifyFlag", 0);
        cVar.signature = f.r(map, "signature");
        cVar.scene = f.c(map, "scene", 0);
        cVar.tqu = f.c(map, "sceneActionType", 1);
        cVar.pot = new py();
        cVar.pot.hxs = f.c(map, "brandFlag", 0);
        cVar.pot.hxv = f.r(map, "iconUrl");
        cVar.pot.hxu = f.r(map, "brandInfo");
        cVar.pot.hxt = f.r(map, "externalInfo");
        cVar.iVa = f.r(map, "searchId");
        cVar.fEe = f.r(map, "query");
        cVar.position = f.c(map, "position", 0);
        cVar.tti = f.t(map, "isCurrentDetailPage");
        cVar.ttj = f.r(map, "extraParams");
        return cVar;
    }

    private d ag(Map<String, Object> map) {
        int i = 3;
        d dVar = new d();
        dVar.username = f.r(map, "userName");
        dVar.fqG = f.r(map, "nickName");
        dVar.ggL = f.r(map, "alias");
        dVar.signature = f.r(map, "signature");
        dVar.fXa = f.c(map, "sex", 0);
        dVar.country = f.r(map, "country");
        dVar.fXl = f.r(map, "city");
        dVar.fXk = f.r(map, "province");
        dVar.ttk = f.c(map, "snsFlag", 0);
        String r = f.r(map, "query");
        if (bi.oN(r)) {
            dVar.scene = 3;
        } else {
            if (Character.isDigit(r.charAt(0))) {
                i = 15;
            }
            dVar.scene = i;
            if (dVar.scene == 15) {
                if ("mobile".equals(f.r(map, "matchType"))) {
                    dVar.fEe = r;
                } else {
                    dVar.scene = 1;
                }
            }
        }
        return dVar;
    }

    static String n(int i, int i2, boolean z) {
        String str = "FTS_BizCacheObj" + i + "-" + i2;
        String str2 = str + "-" + w.eM(ad.getContext());
        if (z) {
            return str2;
        }
        as.Hm();
        if (new File(com.tencent.mm.y.c.Fu(), str2).exists()) {
            return str2;
        }
        return str;
    }

    public static boolean ah(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", map);
        String r = f.r(map, "word");
        boolean t = f.t(map, "isInputChange");
        String r2 = f.r(map, "custom");
        String r3 = f.r(map, "tagList");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(bi.p(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", r);
        bundle.putString("fts_key_custom_query", r2);
        bundle.putBoolean("fts_key_need_keyboard", t);
        bundle.putString("fts_key_tag_list", r3);
        try {
            if (Bw.fCC != null) {
                Bw.fCC.n(122, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        return false;
    }

    public final boolean ai(Map<String, Object> map) {
        String str = (String) map.get("query");
        String str2 = (String) map.get("sortedContacts");
        final int Wo = bi.Wo((String) map.get("offset"));
        final int Wo2 = bi.Wo((String) map.get("count"));
        final int p = bi.p(map.get("webview_instance_id"), -1);
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        List arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
        }
        if (this.tsT == null) {
            this.tsT = new com.tencent.mm.plugin.webview.fts.a.b();
        }
        com.tencent.mm.plugin.webview.fts.a.a dVar = new com.tencent.mm.plugin.webview.fts.a.d(str, arrayList);
        if (this.tsU == null || !this.tsU.equals(dVar)) {
            this.tsU = dVar;
            this.tsT.a(dVar, new com.tencent.mm.plugin.webview.fts.a.c.a() {
                public final void bPU() {
                    e.a(e.this.tsU, Wo, Wo2, p);
                }
            });
        } else if (this.tsU.fpa) {
            a(this.tsU, Wo, Wo2, p);
        }
        return false;
    }

    static void a(com.tencent.mm.plugin.webview.fts.a.d dVar, int i, int i2, int i3) {
        JSONObject el = dVar.el(i, i2);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = h.Bw(i3);
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_json_data", el.toString());
        try {
            if (Bw.fCC != null) {
                Bw.fCC.n(137, bundle);
            }
        } catch (RemoteException e) {
            x.w("MicroMsg.MsgHandler", "onSearchSuggestionDataReady exception" + e.getMessage());
        }
    }
}
