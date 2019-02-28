package com.tencent.mm.plugin.wallet_core.model;

import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public double pQB = 0.0d;
    public int sFA = 0;
    public int sFB = 0;
    public double sFC = 0.0d;
    public int sFz = 0;
    public String sQT;
    public LinkedList<b> sQU;
    public String sQV;
    public String sQW;
    public a sQX;

    public static class b {
        public String aAM;
        public String value;
    }

    public static class c {
        public String desc;
        public String kPA;
        public String kRm;
        public int sGd;
        public String title;
    }

    public static class a {
        public String sQY = "";
        public c[] sQZ = new c[0];
    }

    public static a V(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            try {
                aVar.sQY = jSONObject.optString("sector_title", "");
                JSONArray optJSONArray = jSONObject.optJSONArray("label");
                if (optJSONArray != null) {
                    aVar.sQZ = new c[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        c cVar = new c();
                        cVar.title = jSONObject2.optString("title", "");
                        cVar.desc = jSONObject2.optString("desc", "");
                        cVar.kPA = jSONObject2.optString("logo_url", "");
                        cVar.sGd = jSONObject2.optInt("jump_type");
                        cVar.kRm = jSONObject2.optString("jump_url", "");
                        aVar.sQZ[i] = cVar;
                    }
                }
            } catch (JSONException e) {
            }
        }
        return aVar;
    }
}
