package com.tencent.mm.plugin.webview.fts;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.aj.a.d;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.protocal.c.cbg;
import com.tencent.mm.protocal.c.cdf;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements e {
    public com.tencent.mm.plugin.fts.a.a.a mRL;
    private k pni = new k() {
        public final void b(h hVar) {
            switch (hVar.bjW) {
                case -3:
                case -2:
                case -1:
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(((Integer) c.this.mRL.mQY).intValue()).Qi("");
                    return;
                case 0:
                    if (hVar.mRN == null || hVar.mRN.size() == 0) {
                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "local contact search size 0");
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(((Integer) c.this.mRL.mQY).intValue()).Qi("");
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        for (j jVar : hVar.mRN) {
                            if (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                                jSONArray2.put(f.a(jVar, hVar.mON.fEe, bi.F(hVar.mRM.mRn)));
                            }
                        }
                        jSONObject2.put("items", jSONArray2);
                        jSONObject2.put("title", ad.getContext().getString(R.l.ekV));
                        jSONObject2.put("count", jSONArray2.length());
                        jSONObject2.put(Columns.TYPE, 3);
                        jSONArray.put(jSONObject2);
                        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                        jSONObject.put("ret", 0);
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(((Integer) c.this.mRL.mQY).intValue()).Qi(jSONObject.toString());
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "onSearchDone", new Object[0]);
                        return;
                    }
                default:
                    return;
            }
        }
    };
    public cbg tqH;
    public int tsq = 0;
    public cbg tsr;
    com.tencent.mm.plugin.webview.fts.a.c tss = new com.tencent.mm.plugin.webview.fts.a.b();
    public a tst = new a();
    public b tsu = new b();

    private class a implements Comparable {
        public a tsA;
        public com.tencent.mm.plugin.aj.a.a tsy;
        ThreadPoolExecutor tsz;

        private class a implements Runnable {
            d hlp;
            public volatile boolean kuZ;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }

            public final void run() {
                if (!Thread.interrupted()) {
                    if (bi.oN(this.hlp.foW)) {
                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.hlp.hMM), Integer.valueOf(this.hlp.scene), Integer.valueOf(this.hlp.tqs), Integer.valueOf(this.hlp.tqu), this.hlp.lKv, Integer.valueOf(this.hlp.offset));
                        return;
                    }
                    com.tencent.mm.plugin.webview.fts.a.e eVar;
                    LinkedList linkedList;
                    btb btb;
                    switch (this.hlp.scene) {
                        case 3:
                        case 16:
                        case 20:
                            ((m) g.k(m.class)).addSOSHistory(this.hlp.foW);
                            break;
                    }
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "start New NetScene %s ,  %d", this.hlp.foW, Integer.valueOf(this.hlp.fEg));
                    if (a.this.tsy != null) {
                        as.CN().c(a.this.tsy);
                    }
                    if (this.hlp.tqt == null || this.hlp.tqt.isEmpty()) {
                        int i;
                        long currentTimeMillis;
                        Object obj = this.hlp.foW;
                        int i2 = this.hlp.scene;
                        int i3 = this.hlp.hMM;
                        if (this.hlp.tqs == 1) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (!TextUtils.isEmpty(obj) && com.tencent.mm.bb.b.QU()) {
                            int QV = com.tencent.mm.bb.b.QV();
                            if (QV <= 0 || obj.length() <= QV) {
                                if ((i2 == 3 || i2 == 20) && (i != 0 || i3 == 8)) {
                                    i = 1;
                                    if (i != 0) {
                                        eVar = (com.tencent.mm.plugin.webview.fts.a.e) c.this.tss.OD(this.hlp.foW);
                                        currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                                        com.tencent.mm.plugin.report.service.g.pWK.h(14717, this.hlp.foW, Integer.valueOf(s.GP()), Integer.valueOf(eVar.mUI.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hlp.scene));
                                        if (this.kuZ) {
                                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                                            return;
                                        }
                                        f.bSl().tsR.f(this.hlp.scene, this.hlp.foW, this.hlp.hMM);
                                        a.this.tsy = a.a(this.hlp);
                                        if (eVar != null) {
                                            linkedList = new LinkedList();
                                            for (com.tencent.mm.plugin.webview.fts.a.e.a aVar : eVar.mUI) {
                                                btb = new btb();
                                                btb.kyG = aVar.userName;
                                                btb.xbi = aVar.ttN;
                                                btb.kzN = aVar.bgo;
                                                btb.weS = aVar.iLo;
                                                btb.hxj = aVar.ggL;
                                                btb.vPF = aVar.desc;
                                                linkedList.add(btb);
                                            }
                                            a.this.tsy.ap(linkedList);
                                        }
                                        as.CN().a(a.this.tsy.getType(), c.this);
                                        as.CN().a(a.this.tsy, 0);
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.this.tsy.getType()));
                                    }
                                } else if ((i2 == 14 || i2 == 22) && i3 == 8) {
                                    i = 1;
                                    if (i != 0) {
                                        eVar = (com.tencent.mm.plugin.webview.fts.a.e) c.this.tss.OD(this.hlp.foW);
                                        currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                                        com.tencent.mm.plugin.report.service.g.pWK.h(14717, this.hlp.foW, Integer.valueOf(s.GP()), Integer.valueOf(eVar.mUI.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hlp.scene));
                                        if (this.kuZ) {
                                            f.bSl().tsR.f(this.hlp.scene, this.hlp.foW, this.hlp.hMM);
                                            a.this.tsy = a.a(this.hlp);
                                            if (eVar != null) {
                                                linkedList = new LinkedList();
                                                for (com.tencent.mm.plugin.webview.fts.a.e.a aVar2 : eVar.mUI) {
                                                    btb = new btb();
                                                    btb.kyG = aVar2.userName;
                                                    btb.xbi = aVar2.ttN;
                                                    btb.kzN = aVar2.bgo;
                                                    btb.weS = aVar2.iLo;
                                                    btb.hxj = aVar2.ggL;
                                                    btb.vPF = aVar2.desc;
                                                    linkedList.add(btb);
                                                }
                                                a.this.tsy.ap(linkedList);
                                            }
                                            as.CN().a(a.this.tsy.getType(), c.this);
                                            as.CN().a(a.this.tsy, 0);
                                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.this.tsy.getType()));
                                        }
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                                        return;
                                    }
                                } else if (i2 == 16) {
                                    i = 1;
                                    if (i != 0) {
                                        eVar = (com.tencent.mm.plugin.webview.fts.a.e) c.this.tss.OD(this.hlp.foW);
                                        currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                                        com.tencent.mm.plugin.report.service.g.pWK.h(14717, this.hlp.foW, Integer.valueOf(s.GP()), Integer.valueOf(eVar.mUI.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hlp.scene));
                                        if (this.kuZ) {
                                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                                            return;
                                        }
                                        f.bSl().tsR.f(this.hlp.scene, this.hlp.foW, this.hlp.hMM);
                                        a.this.tsy = a.a(this.hlp);
                                        if (eVar != null) {
                                            linkedList = new LinkedList();
                                            for (com.tencent.mm.plugin.webview.fts.a.e.a aVar22 : eVar.mUI) {
                                                btb = new btb();
                                                btb.kyG = aVar22.userName;
                                                btb.xbi = aVar22.ttN;
                                                btb.kzN = aVar22.bgo;
                                                btb.weS = aVar22.iLo;
                                                btb.hxj = aVar22.ggL;
                                                btb.vPF = aVar22.desc;
                                                linkedList.add(btb);
                                            }
                                            a.this.tsy.ap(linkedList);
                                        }
                                        as.CN().a(a.this.tsy.getType(), c.this);
                                        as.CN().a(a.this.tsy, 0);
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.this.tsy.getType()));
                                    }
                                }
                            }
                        }
                        i = 0;
                        if (i != 0) {
                            eVar = (com.tencent.mm.plugin.webview.fts.a.e) c.this.tss.OD(this.hlp.foW);
                            currentTimeMillis = System.currentTimeMillis() - System.currentTimeMillis();
                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "match contact cost %d ms", Long.valueOf(currentTimeMillis));
                            com.tencent.mm.plugin.report.service.g.pWK.h(14717, this.hlp.foW, Integer.valueOf(s.GP()), Integer.valueOf(eVar.mUI.size()), Long.valueOf(currentTimeMillis), Integer.valueOf(this.hlp.scene));
                            if (this.kuZ) {
                                f.bSl().tsR.f(this.hlp.scene, this.hlp.foW, this.hlp.hMM);
                                a.this.tsy = a.a(this.hlp);
                                if (eVar != null) {
                                    linkedList = new LinkedList();
                                    for (com.tencent.mm.plugin.webview.fts.a.e.a aVar222 : eVar.mUI) {
                                        btb = new btb();
                                        btb.kyG = aVar222.userName;
                                        btb.xbi = aVar222.ttN;
                                        btb.kzN = aVar222.bgo;
                                        btb.weS = aVar222.iLo;
                                        btb.hxj = aVar222.ggL;
                                        btb.vPF = aVar222.desc;
                                        linkedList.add(btb);
                                    }
                                    a.this.tsy.ap(linkedList);
                                }
                                as.CN().a(a.this.tsy.getType(), c.this);
                                as.CN().a(a.this.tsy, 0);
                                x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.this.tsy.getType()));
                            }
                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                            return;
                        }
                    }
                    eVar = null;
                    if (this.kuZ) {
                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "was cancelled");
                        return;
                    }
                    f.bSl().tsR.f(this.hlp.scene, this.hlp.foW, this.hlp.hMM);
                    a.this.tsy = a.a(this.hlp);
                    if (eVar != null) {
                        linkedList = new LinkedList();
                        for (com.tencent.mm.plugin.webview.fts.a.e.a aVar2222 : eVar.mUI) {
                            btb = new btb();
                            btb.kyG = aVar2222.userName;
                            btb.xbi = aVar2222.ttN;
                            btb.kzN = aVar2222.bgo;
                            btb.weS = aVar2222.iLo;
                            btb.hxj = aVar2222.ggL;
                            btb.vPF = aVar2222.desc;
                            linkedList.add(btb);
                        }
                        a.this.tsy.ap(linkedList);
                    }
                    as.CN().a(a.this.tsy.getType(), c.this);
                    as.CN().a(a.this.tsy, 0);
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", Integer.valueOf(a.this.tsy.getType()));
                }
            }
        }

        private a() {
            this.tsz = new ThreadPoolExecutor(0, 10, 120, TimeUnit.SECONDS, new ArrayBlockingQueue(32));
        }

        /* synthetic */ a(c cVar, byte b) {
            this();
        }

        static /* synthetic */ com.tencent.mm.plugin.aj.a.a a(d dVar) {
            com.tencent.mm.plugin.aj.a.a hVar;
            if (!c.Ap(dVar.scene) || com.tencent.mm.bb.m.Rq()) {
                hVar = (dVar.scene == 21 ? 1 : null) != null ? new h(dVar) : new i(dVar);
            } else {
                hVar = new com.tencent.mm.modelappbrand.m(dVar);
            }
            hVar.tqo = dVar.fEg;
            return hVar;
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    private class b {
        public com.tencent.mm.plugin.aj.a.b tsC;

        private b() {
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.fts.c$1 */
    class AnonymousClass1 implements com.tencent.mm.ad.u.a {
        final /* synthetic */ String iVz;
        final /* synthetic */ int tsv;
        final /* synthetic */ String tsw;

        public AnonymousClass1(int i, String str, String str2) {
            this.tsv = i;
            this.iVz = str;
            this.tsw = str2;
        }

        public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, com.tencent.mm.ad.k kVar) {
            if (kVar.getType() == 2608) {
                if (i != 0 || i2 != 0) {
                    x.e("MicroMsg.FTS.FTSWebSearchLogic", "getPoiInfo onSceneEnd errType:" + i + " errCode:" + i2 + " will retry");
                } else if (bVar != null) {
                    bgo bgo = (bgo) bVar.hnR.hnY;
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(this.tsv);
                    String str2 = this.iVz;
                    String str3 = this.tsw;
                    String str4 = bgo.vUV;
                    Bundle bundle = new Bundle();
                    bundle.putString("searchId", str2);
                    bundle.putString("poiId", str3);
                    bundle.putString("json", str4);
                    try {
                        if (Bw.fCC != null) {
                            Bw.fCC.n(com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX, bundle);
                        }
                    } catch (RemoteException e) {
                        x.w("MicroMsg.MsgHandler", "onGetPoiReady exception" + e.getMessage());
                    }
                }
            }
            return 0;
        }
    }

    static /* synthetic */ boolean Ap(int i) {
        return i == 201;
    }

    public c() {
        x.d("MicroMsg.FTS.FTSWebSearchLogic", "create FTSWebSearchLogic");
    }

    public final boolean W(Map<String, Object> map) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData: %s", map.toString());
        int c = f.c(map, "scene", 3);
        d dVar = new d();
        dVar.foW = f.r(map, "query");
        dVar.offset = f.c(map, "offset", 0);
        dVar.hMM = f.c(map, Columns.TYPE, 0);
        dVar.scene = c;
        dVar.tqv = f.r(map, "sugId");
        dVar.tqx = f.c(map, "sugType", 0);
        dVar.tqw = f.r(map, "prefixSug");
        dVar.tqI = f.r(map, "poiInfo");
        dVar.tqs = f.t(map, "isHomePage") ? 1 : 0;
        dVar.lKv = f.r(map, "searchId");
        if (map.containsKey("sessionId")) {
            dVar.frp = f.r(map, "sessionId");
        }
        dVar.tqu = f.c(map, "sceneActionType", 1);
        dVar.tqz = f.c(map, "displayPattern", 2);
        dVar.tqA = f.c(map, "sugPosition", 0);
        dVar.tqB = f.r(map, "sugBuffer");
        dVar.hMN = f.r(map, "requestId");
        dVar.frp = f.r(map, "sessionId");
        dVar.tpV = f.r(map, "subSessionId");
        dVar.tqJ = f.r(map, "tagId");
        String r = f.r(map, "extReqParams");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (c = 0; c < jSONArray.length(); c++) {
                    jSONObject = jSONArray.getJSONObject(c);
                    oz ozVar = new oz();
                    ozVar.aAM = jSONObject.optString("key", "");
                    ozVar.weB = (long) jSONObject.optInt("uintValue", 0);
                    ozVar.weC = jSONObject.optString("textValue", "");
                    dVar.tqD.add(ozVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "matchUser");
        if (!bi.oN(r)) {
            try {
                jSONObject2 = new JSONObject(r);
                btb btb = new btb();
                btb.kyG = jSONObject2.optString("userName");
                btb.xbi = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(btb.kyG)) {
                    dVar.tqt.add(btb);
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "prefixQuery");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (c = 0; c < jSONArray.length(); c++) {
                    dVar.tqy.add(jSONArray.getString(c));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "tagInfo");
        if (!bi.oN(r)) {
            try {
                jSONObject2 = new JSONObject(r);
                dVar.tqC = new bon();
                dVar.tqC.wXV = jSONObject2.optString("tagText");
                dVar.tqC.wXU = jSONObject2.optInt("tagType");
                dVar.tqC.wXW = jSONObject2.optString("tagExtValue");
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        r = f.r(map, "numConditions");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (c = 0; c < jSONArray.length(); c++) {
                    jSONObject = jSONArray.optJSONObject(c);
                    aty aty = new aty();
                    aty.wIK = jSONObject.optLong("from");
                    aty.wIL = jSONObject.optLong("to");
                    aty.wIJ = jSONObject.optInt("field");
                    dVar.tqE.add(aty);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        dVar.fEg = bi.p(map.get("webview_instance_id"), -1);
        dVar.ael = w.eM(ad.getContext());
        dVar.mRc = f.c(map, "subType", 0);
        if (com.tencent.mm.bb.m.Rq()) {
            dVar.tqF = f.c(map, "isWeAppMore", 0);
            if (dVar.tqF == 1) {
                dVar.tqG = new cdf();
                com.tencent.mm.sdk.b.b hxVar = new hx();
                com.tencent.mm.sdk.b.a.xmy.m(hxVar);
                dVar.tqG.xiy = hxVar.fzj.fzk;
                dVar.tqG.xiA = com.tencent.mm.modelappbrand.b.hli;
                dVar.tqG.xiz = f.c(map, "subType", 0);
                dVar.tqG.wZx = com.tencent.mm.modelappbrand.b.hlh;
                dVar.tqG.xiB = dVar.tqA;
                as.Hm();
                Object obj = com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    dVar.tqG.xhO = (String) obj;
                }
            }
        }
        if (this.tsq == 1) {
            dVar.tqH = this.tqH;
        } else {
            dVar.tqH = null;
        }
        if (dVar.scene == 33 && this.tsr != null) {
            if (dVar.tqH == null) {
                dVar.tqH = new cbg();
            }
            if (dVar.tqH.xhj == null) {
                dVar.tqH.xhj = new io();
            }
            if (this.tsr.xhj != null) {
                dVar.tqH.xhj.vVt = this.tsr.xhj.vVt;
                x.i("MicroMsg.FTS.FTSWebSearchLogic", "websearch from url [%s]", this.tsr.xhj.vVt);
            }
            this.tsr = null;
        }
        if (dVar.hMM == 262144 && this.tsr != null && this.tsr.xhj.vVq == 1) {
            Bundle bundle = new Bundle();
            bundle.putInt("isRefresh", 1);
            bundle.putString("widgetId", f.r(map, "widgetId"));
            dVar.tqK = bundle;
            dVar.tqH = this.tsr;
            this.tsr = null;
        }
        a aVar = this.tst;
        if (aVar.tsA != null) {
            aVar.tsA.kuZ = true;
        }
        aVar.tsA = new a(aVar, (byte) 0);
        aVar.tsA.hlp = dVar;
        aVar.tsz.execute(aVar.tsA);
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(dVar.fEg).c(dVar.hMM, dVar.foW, (Map) map);
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        String str2 = "MicroMsg.FTS.FTSWebSearchLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(kVar != null ? kVar.getType() : 0);
        x.v(str2, str3, objArr);
        if (kVar instanceof com.tencent.mm.plugin.aj.a.a) {
            as.CN().b(kVar.getType(), (e) this);
            com.tencent.mm.plugin.aj.a.a aVar = (com.tencent.mm.plugin.aj.a.a) kVar;
            if (i == 0 && i2 == 0) {
                String Ji = aVar.Ji();
                cy(Ji, aVar.tqo);
                int Jj = aVar.Jj();
                x.i("MicroMsg.FTS.FTSWebSearchLogic", "callback %s", aVar.tqp);
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(aVar.tqo).a(Ji, aVar.bPC(), aVar.tqq, aVar.tqr);
                if (Jj > 0) {
                    x.i("MicroMsg.FTS.FTSWebSearchLogic", "updateCode %d, need update", Integer.valueOf(Jj));
                    c.vnr;
                    com.tencent.mm.pluginsdk.i.a.b.b.BZ(27);
                    return;
                }
                return;
            }
            x.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", aVar.tqp);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(aVar.tqo).a(jSONObject.toString(), true, aVar.tqq, aVar.tqr);
        } else if (kVar instanceof com.tencent.mm.plugin.aj.a.b) {
            as.CN().b(kVar.getType(), (e) this);
            com.tencent.mm.plugin.aj.a.b bVar = (com.tencent.mm.plugin.aj.a.b) kVar;
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(bVar.tqo).Qi(bVar.Ji());
                return;
            }
            x.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", bVar.iUY);
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(bVar.tqo).Qi("{}");
        }
    }

    private static void cy(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONObject(str).getJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null && jSONObject.optInt(Columns.TYPE) == 262144) {
                            x.i("MicroMsg.FTS.FTSWebSearchLogic", "reportRecvWidget found widget");
                            JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                            if (jSONArray2 != null) {
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    jSONObject = jSONArray2.getJSONObject(i3);
                                    if (jSONObject != null) {
                                        x.i("MicroMsg.FTS.FTSWebSearchLogic", "reportRecvWidget found widget appid %s", jSONObject.optString("appID"));
                                        com.tencent.mm.plugin.webview.ui.tools.jsapi.g Bw = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(i);
                                        Bundle bundle = new Bundle();
                                        bundle.putString("appid", r0);
                                        try {
                                            if (Bw.fCC != null) {
                                                Bw.fCC.n(com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, bundle);
                                            }
                                        } catch (RemoteException e) {
                                            x.w("MicroMsg.MsgHandler", "onRecvWidget exception" + e.getMessage());
                                        }
                                    }
                                }
                                continue;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (JSONException e2) {
                x.e("MicroMsg.FTS.FTSWebSearchLogic", "", e2);
            }
        }
    }

    public final boolean X(Map<String, Object> map) {
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "getSuggestionData %s", map);
        d dVar = new d();
        dVar.foW = f.r(map, "query");
        try {
            dVar.foW = URLDecoder.decode(dVar.foW, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        dVar.hMM = f.c(map, Columns.TYPE, 0);
        dVar.scene = f.c(map, "scene", 3);
        dVar.tqs = f.t(map, "isHomePage") ? 1 : 0;
        dVar.fEg = bi.p(map.get("webview_instance_id"), -1);
        dVar.tqy.add(f.r(map, "prefixQuery"));
        int c = f.c(map, "requestType", 0);
        dVar.mRc = f.c(map, "subtype", 0);
        x.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData, webviewID = %d", Integer.valueOf(dVar.fEg));
        if (com.tencent.mm.bb.m.Rq()) {
            dVar.tqF = f.c(map, "isWeAppMore", 0);
            if (dVar.tqF == 1) {
                dVar.tqG = new cdf();
                com.tencent.mm.sdk.b.b hxVar = new hx();
                com.tencent.mm.sdk.b.a.xmy.m(hxVar);
                dVar.tqG.xiy = hxVar.fzj.fzk;
                dVar.tqG.xiA = com.tencent.mm.modelappbrand.b.hli;
                dVar.tqG.xiz = f.c(map, "subType", 0);
                dVar.tqG.wZx = com.tencent.mm.modelappbrand.b.hlh;
                as.Hm();
                Object obj = com.tencent.mm.y.c.Db().get(com.tencent.mm.storage.w.a.USERINFO_WXA_SEARCH_INPUT_HINT_CONTENT_ID_STRING_SYNC, null);
                if (obj != null && (obj instanceof String)) {
                    dVar.tqG.xhO = (String) obj;
                }
            }
        }
        switch (c) {
            case 0:
                b bVar = this.tsu;
                if (bVar.tsC != null) {
                    as.CN().b(bVar.tsC.getType(), bVar.tsx);
                    as.CN().c(bVar.tsC);
                    bVar.tsC = null;
                }
                if (bVar.tsC == null) {
                    com.tencent.mm.plugin.aj.a.b nVar = !com.tencent.mm.bb.m.Rq() ? Ap(dVar.scene) ? new n(dVar.foW, dVar.scene, dVar.fEg) : new k(dVar) : new k(dVar);
                    bVar.tsC = nVar;
                    as.CN().a(bVar.tsC.getType(), bVar.tsx);
                    as.CN().a(bVar.tsC, 0);
                    break;
                }
                break;
            case 1:
                String str = dVar.foW;
                int i = dVar.hMM;
                int i2 = dVar.fEg;
                if (!bi.oN(str)) {
                    int[] iArr;
                    if (this.mRL != null) {
                        ((m) g.k(m.class)).cancelSearchTask(this.mRL);
                        this.mRL = null;
                    }
                    switch (i) {
                        case 8:
                            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
                            break;
                        default:
                            iArr = null;
                            break;
                    }
                    if (iArr != null) {
                        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
                        gVar.mRC = 16;
                        gVar.fEe = str;
                        gVar.mRF = iArr;
                        gVar.mRH = 5;
                        gVar.mRJ = com.tencent.mm.plugin.fts.a.c.b.mSk;
                        gVar.mRI = new HashSet();
                        gVar.mRK = this.pni;
                        this.mRL = ((m) g.k(m.class)).search(2, gVar);
                        this.mRL.mQY = Integer.valueOf(i2);
                        break;
                    }
                }
                break;
            case 2:
                com.tencent.mm.plugin.webview.ui.tools.jsapi.h.Bw(dVar.fEg).Qi(com.tencent.mm.bb.c.Rd());
                break;
        }
        return false;
    }
}
