package com.tencent.mm.plugin.webview.fts;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bb.m;
import com.tencent.mm.f.a.hx;
import com.tencent.mm.f.a.mu;
import com.tencent.mm.plugin.aj.a.g;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.protocal.c.bon;
import com.tencent.mm.protocal.c.btb;
import com.tencent.mm.protocal.c.cdf;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.d;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l implements e {
    public static final long ttq = ((long) (d.cmH() + 500));
    private static l tty = new l();
    private ah rtd = new ah("RecommendLogic_worker");
    public c ttA = new c<mu>() {
        {
            this.xmG = mu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            l.this.bPZ();
            return false;
        }
    };
    private Set<String> ttr;
    public a tts = new a();
    public volatile boolean ttt;
    private volatile boolean ttu;
    public volatile CountDownLatch ttv;
    private volatile com.tencent.mm.plugin.aj.a.d ttw;
    public long ttx;
    public volatile boolean ttz;

    private class a implements Comparable {
        public com.tencent.mm.plugin.aj.a.a tsy;
        public a ttF;

        private class a implements Runnable {
            com.tencent.mm.plugin.aj.a.d hlp;
            public volatile boolean kuZ;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }

            public final void run() {
                if (!Thread.interrupted()) {
                    if (bi.oN(this.hlp.foW)) {
                        x.i("RecommendLogic", "error query %d %d %d %d %s %d", Integer.valueOf(this.hlp.hMM), Integer.valueOf(this.hlp.scene), Integer.valueOf(this.hlp.tqs), Integer.valueOf(this.hlp.tqu), this.hlp.lKv, Integer.valueOf(this.hlp.offset));
                        return;
                    }
                    x.i("RecommendLogic", "start New NetScene %s ,  %d", this.hlp.foW, Integer.valueOf(this.hlp.fEg));
                    if (a.this.tsy != null) {
                        as.CN().c(a.this.tsy);
                    }
                    if (this.kuZ) {
                        x.i("RecommendLogic", "was cancelled");
                        return;
                    }
                    f.bSl().tsR.f(this.hlp.scene, this.hlp.foW, this.hlp.hMM);
                    a.this.tsy = a.c(this.hlp);
                    as.CN().a(a.this.tsy.getType(), l.this);
                    as.CN().a(a.this.tsy, 0);
                    x.i("RecommendLogic", "doScene(type : %s)", Integer.valueOf(a.this.tsy.getType()));
                }
            }
        }

        private a() {
        }

        /* synthetic */ a(l lVar, byte b) {
            this();
        }

        static /* synthetic */ com.tencent.mm.plugin.aj.a.a c(com.tencent.mm.plugin.aj.a.d dVar) {
            com.tencent.mm.plugin.aj.a.a hVar = (!l.As(dVar.scene) || m.Rq()) ? l.At(dVar.scene) ? new h(dVar) : new i(dVar) : new com.tencent.mm.modelappbrand.m(dVar);
            hVar.tqo = dVar.fEg;
            return hVar;
        }

        public final void b(com.tencent.mm.plugin.aj.a.d dVar) {
            if (this.ttF != null) {
                this.ttF.kuZ = true;
            }
            this.ttF = new a();
            this.ttF.hlp = dVar;
            l.this.ttw = dVar;
            this.ttF.run();
        }

        public final int compareTo(Object obj) {
            return 0;
        }
    }

    static /* synthetic */ boolean As(int i) {
        return i == 201;
    }

    static /* synthetic */ boolean At(int i) {
        return i == 21;
    }

    public l() {
        x.d("RecommendLogic", "create RecommendLogic");
        x.d("RecommendLogic", "create RecommendLogic, duplicate for patch fix");
        this.ttA.cfB();
        this.ttr = new HashSet();
        this.ttr.add(DownloadInfo.NETTYPE);
        this.ttr.add("time_zone_min");
        this.ttr.add("currentPage");
        this.ttr.add("is_prefetch");
        this.ttr.add(TencentLocation.EXTRA_DIRECTION);
        this.ttr.add("seq");
        this.ttr.add("client_exposed_info");
        this.ttr.add("requestId");
        this.ttr.add("recType");
        bPZ();
    }

    public static l bPY() {
        return tty;
    }

    private boolean g(Set<String> set) {
        return set == null || this.ttr.containsAll(set);
    }

    public final boolean W(Map<String, Object> map) {
        boolean z = true;
        x.i("RecommendLogic", "getSearchData: %s", map.toString());
        h.Bw(bi.p(map.get("webview_instance_id"), -1)).c(f.c(map, Columns.TYPE, 0), f.r(map, "query"), (Map) map);
        if (this.ttt) {
            this.ttt = false;
            int p = bi.p(map.get("webview_instance_id"), -1);
            if (this.ttw != null) {
                this.ttw.fEg = p;
            }
            if (g(aj(map))) {
                if (this.ttv != null) {
                    this.ttv.countDown();
                }
                if (this.ttw != null) {
                    x.i("RecommendLogic", "do not send this call, wait for pre get, webivewId %d, %s", Integer.valueOf(this.ttw.fEg), this.ttw);
                }
            } else {
                x.e("RecommendLogic", "wtf , recv unsupported commKvSet after pre get, interrupt pre get now");
                this.ttu = true;
                if (this.ttv != null) {
                    this.ttv.countDown();
                }
                z = false;
            }
        } else {
            if (this.ttv != null) {
                this.ttv.countDown();
            }
            z = false;
        }
        if (!z) {
            this.tts.b(ak(map));
        }
        return false;
    }

    private static Set<String> aj(Map<String, Object> map) {
        Throwable e;
        String r = f.r(map, "extReqParams");
        if (bi.oN(r)) {
            return Collections.emptySet();
        }
        Set<String> hashSet;
        try {
            hashSet = new HashSet();
            try {
                JSONArray jSONArray = new JSONArray(r);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    oz ozVar = new oz();
                    hashSet.add(jSONObject.optString("key", ""));
                }
                return hashSet;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("RecommendLogic", e, "", new Object[0]);
                return hashSet;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            hashSet = null;
            e = th;
            x.printErrStackTrace("RecommendLogic", e, "", new Object[0]);
            return hashSet;
        }
    }

    private static com.tencent.mm.plugin.aj.a.d ak(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        com.tencent.mm.plugin.aj.a.d dVar = new com.tencent.mm.plugin.aj.a.d();
        dVar.foW = f.r(map, "query");
        dVar.offset = f.c(map, "offset", 0);
        dVar.hMM = f.c(map, Columns.TYPE, 0);
        dVar.scene = f.c(map, "scene", 3);
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
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.getJSONObject(i);
                    oz ozVar = new oz();
                    ozVar.aAM = jSONObject.optString("key", "");
                    ozVar.weB = (long) jSONObject.optInt("uintValue", 0);
                    ozVar.weC = jSONObject.optString("textValue", "");
                    dVar.tqD.add(ozVar);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("RecommendLogic", e, "commKvJSONArray", new Object[0]);
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
                x.printErrStackTrace("RecommendLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        r = f.r(map, "prefixQuery");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    dVar.tqy.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("RecommendLogic", e22, "prefixQueryJSONArray", new Object[0]);
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
                x.printErrStackTrace("RecommendLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        r = f.r(map, "numConditions");
        if (!bi.oN(r)) {
            try {
                jSONArray = new JSONArray(r);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    aty aty = new aty();
                    aty.wIK = jSONObject.optLong("from");
                    aty.wIL = jSONObject.optLong("to");
                    aty.wIJ = jSONObject.optInt("field");
                    dVar.tqE.add(aty);
                }
            } catch (Throwable e2222) {
                x.printErrStackTrace("RecommendLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        dVar.fEg = bi.p(map.get("webview_instance_id"), -1);
        dVar.ael = w.eM(ad.getContext());
        dVar.mRc = f.c(map, "subType", 0);
        if (m.Rq()) {
            dVar.tqF = f.c(map, "isWeAppMore", 0);
            if (dVar.tqF == 1) {
                dVar.tqG = new cdf();
                b hxVar = new hx();
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
        return dVar;
    }

    public final boolean aq(LinkedList<oz> linkedList) {
        Set hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hashSet.add(((oz) it.next()).aAM);
        }
        return this.ttr.equals(hashSet);
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "RecommendLogic";
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
                int Jj = aVar.Jj();
                x.i("RecommendLogic", "callback %s", aVar.tqp);
                b(aVar.tqo, Ji, aVar.bPC(), aVar.tqq);
                if (Jj > 0) {
                    x.i("RecommendLogic", "updateCode %d, need update", Integer.valueOf(Jj));
                    c.vnr;
                    com.tencent.mm.pluginsdk.i.a.b.b.BZ(27);
                    return;
                }
                return;
            }
            x.i("RecommendLogic", "net scene fail %s", aVar.tqp);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", -1);
            } catch (JSONException e) {
            }
            b(aVar.tqo, jSONObject.toString(), aVar.bPC(), aVar.tqq);
        }
    }

    private void b(int i, String str, boolean z, String str2) {
        final int i2 = i;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        this.rtd.F(new Runnable() {
            public final void run() {
                if (l.this.ttv != null) {
                    x.i("RecommendLogic", "waiting for countdown, %d", Long.valueOf(l.this.ttv.getCount()));
                    try {
                        l.this.ttv.await();
                    } catch (Throwable e) {
                        x.printErrStackTrace("RecommendLogic", e, "", new Object[0]);
                    }
                } else {
                    x.i("RecommendLogic", "count down latch null");
                }
                int i = i2;
                if (l.this.ttw != null) {
                    i = l.this.ttw.fEg;
                    if (l.this.ttw.tqL && l.this.ttu) {
                        x.w("RecommendLogic", "ingore pre get data");
                        return;
                    }
                }
                x.i("RecommendLogic", "calling back to webview, id %d, reqId %s,  %s", Integer.valueOf(i), str3, l.this.ttw);
                h.Bw(i).a(str4, z2, str3, null);
            }
        });
    }

    public static void start() {
        try {
            Looper.prepare();
        } catch (Exception e) {
        }
    }

    public final void bPZ() {
        Object bPI = g.bPI();
        x.i("RecommendLogic", "config commKV %s", bPI);
        if (TextUtils.isEmpty(bPI)) {
            this.ttz = true;
        } else {
            this.ttz = g(new HashSet(Arrays.asList(bPI.split(","))));
        }
    }
}
