package com.tencent.mm.openim.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    public List<a> idy = new LinkedList();

    public static class a {
        public List<b> idz = new LinkedList();
        public String title = "";

        final a d(JSONObject jSONObject) {
            this.title = jSONObject.optString("title", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("detail");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    b bVar = new b();
                    List list = this.idz;
                    bVar.fED = jSONObject2.optString("icon");
                    bVar.desc = jSONObject2.optString("desc");
                    bVar.idA = jSONObject2.optInt("desc_type");
                    bVar.action = jSONObject2.optInt("action");
                    bVar.idB = jSONObject2.optString("action_param");
                    list.add(bVar);
                }
            }
            return this;
        }
    }

    public static class b {
        public int action;
        String desc;
        public String fED;
        public int idA;
        public String idB;

        public final String oA(String str) {
            if (this.idA == 1) {
                return ((b) g.h(b.class)).aB(str, this.desc);
            }
            return this.desc;
        }
    }

    public final c oz(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("custom_info");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    this.idy.add(new a().d(jSONObject));
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OpenIMCustomDetail", e, "parse", new Object[0]);
        }
        return this;
    }
}
