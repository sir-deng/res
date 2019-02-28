package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a {
    public b iPE;
    private Map<String, d> iPF;
    public e iPG;
    public c iPH;
    public a iPI;
    public boolean iPJ = true;
    public JSONObject iPK;
    public String iPL;

    public static class a {
        String iPM;
        public boolean iPN;
    }

    public static class c {
        public int fMf;
        public int iPO;
        public int iPP;
        public int iPQ;
    }

    public static class e {
        public ArrayList<f> fCP = new ArrayList();
        public String hdx;
        public String iPR;
        public String iPS;
        public String iPT;
        public String iPU;

        public final boolean qV(String str) {
            Iterator it = this.fCP.iterator();
            while (it.hasNext()) {
                if (((f) it.next()).url.equals(l.vh(str))) {
                    return true;
                }
            }
            return false;
        }
    }

    private static abstract class g {
        static final JSONObject iQh = new JSONObject();
        public String iPT;
        public String iPW;
        public String iPX;
        public double iPY;
        protected String iPZ;
        public String iQa;
        public String iQb;
        public String iQc;
        public boolean iQd;
        public boolean iQe;
        public boolean iQf;
        public String iQg;

        private g() {
            this.iPY = 1.0d;
            this.iQd = false;
            this.iQe = false;
            this.iQf = false;
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    public static class b extends g {
        b() {
            super();
            this.iPZ = "default";
            this.iQa = "#000000";
        }

        public final boolean acd() {
            return "custom".equalsIgnoreCase(this.iPZ);
        }
    }

    public static class d extends g {
        public d() {
            super();
        }
    }

    public static class f {
        public String fED;
        public String iPV;
        public String text;
        public String url;
    }

    public final d qU(String str) {
        if (this.iPF.containsKey(str)) {
            return (d) this.iPF.get(str);
        }
        return b(null, this.iPE);
    }

    public final String acb() {
        return this.iPI == null ? com.tencent.mm.plugin.appbrand.config.d.b.PORTRAIT.name().toLowerCase() : this.iPI.iPM;
    }

    public final String acc() {
        if (bi.oN(this.iPL)) {
            return "index.html";
        }
        return this.iPL;
    }

    public static a m(com.tencent.mm.plugin.appbrand.e eVar) {
        JSONObject jSONObject;
        String a = ao.a(eVar, "app-config.json");
        a aVar = new a();
        try {
            jSONObject = new JSONObject(a);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAppConfig", e.getMessage());
            jSONObject = new JSONObject();
        }
        aVar.iPL = jSONObject.optString("entryPagePath");
        aVar.iPK = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("global");
        g bVar = new b();
        a(optJSONObject, bVar, bVar);
        if (ad.cgh().getBoolean("appbrand_new_actionbar", false)) {
            bVar.iPZ = "custom";
        }
        aVar.iPE = bVar;
        aVar.iPF = a(jSONObject.optJSONObject("page"), aVar.iPE);
        aVar.iPG = g(jSONObject.optJSONObject("tabBar"));
        optJSONObject = jSONObject.optJSONObject("networkTimeout");
        c cVar = new c();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        cVar.fMf = optJSONObject.optInt("request");
        cVar.iPO = optJSONObject.optInt("connectSocket");
        cVar.iPQ = optJSONObject.optInt("downloadFile");
        cVar.iPP = optJSONObject.optInt("uploadFile");
        aVar.iPH = cVar;
        if (eVar.YI()) {
            a aVar2 = new a();
            aVar2.iPM = jSONObject.optString("deviceOrientation", "portrait");
            aVar2.iPN = jSONObject.optBoolean("showStatusBar", false);
            aVar.iPI = aVar2;
        }
        aVar.iPJ = jSONObject.optBoolean("preloadEnabled", true);
        return aVar;
    }

    private static <T extends g> T a(JSONObject jSONObject, T t, g gVar) {
        if (jSONObject == null) {
            jSONObject = g.iQh;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("window");
        if (optJSONObject == null) {
            optJSONObject = g.iQh;
        }
        t.iPW = optJSONObject.optString("navigationBarTitleText", gVar.iPW);
        t.iPX = optJSONObject.optString("navigationBarTextStyle", gVar.iPX);
        t.iPZ = optJSONObject.optString("navigationStyle", gVar.iPZ);
        t.iQa = optJSONObject.optString("navigationBarBackgroundColor", gVar.iQa);
        t.iPT = optJSONObject.optString("backgroundColor", gVar.iPT);
        t.iQf = optJSONObject.optBoolean("enablePullDownRefresh", gVar.iQf);
        t.iQg = optJSONObject.optString("backgroundTextStyle", gVar.iQg);
        t.iQe = optJSONObject.optBoolean("enableFullScreen", gVar.iQe);
        optJSONObject = optJSONObject.optJSONObject("navigationBarRightButton");
        if (optJSONObject == null) {
            optJSONObject = g.iQh;
        }
        t.iQd = optJSONObject.optBoolean("hide", gVar.iQd);
        t.iQb = optJSONObject.optString("text", gVar.iQb);
        t.iQc = optJSONObject.optString("iconPath", gVar.iQc);
        return t;
    }

    private static Map<String, d> a(JSONObject jSONObject, b bVar) {
        Map<String, d> hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            hashMap.put(str, b(jSONObject.optJSONObject(str), bVar));
        }
        return hashMap;
    }

    private static d b(JSONObject jSONObject, b bVar) {
        return (d) a(jSONObject, new d(), bVar);
    }

    private static e g(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        e eVar = new e();
        eVar.iPR = jSONObject.optString("position");
        eVar.hdx = jSONObject.optString("color");
        eVar.iPS = jSONObject.optString("selectedColor");
        eVar.iPT = jSONObject.optString("backgroundColor");
        eVar.iPU = jSONObject.optString("borderStyle");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("list");
            for (int i = 0; i < jSONArray.length(); i++) {
                ArrayList arrayList = eVar.fCP;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.url = jSONObject2.optString("pagePath");
                fVar.text = jSONObject2.optString("text");
                fVar.fED = jSONObject2.optString("iconData");
                fVar.iPV = jSONObject2.optString("selectedIconData");
                arrayList.add(fVar);
            }
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandAppConfig", e.getMessage());
        }
        return eVar;
    }
}
