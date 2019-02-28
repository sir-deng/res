package com.tencent.mm.plugin.appbrand.dynamic.f;

import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.t.b.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends c {
    public Map<String, String> iXp;
    public String iXq;
    public int iXr;
    public int iXs;
    public String path;
    public String title;

    public b() {
        super("onCanvasInsert");
    }

    b(int i) {
        super("onCanvasInsert", i);
    }

    public final JSONObject sO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", this.title);
            jSONObject.put("path", this.path);
            jSONObject.put("query", new JSONObject(this.iXp == null ? new HashMap() : this.iXp));
            jSONObject.put("cacheKey", this.iXq);
            jSONObject.put("width", f.lZ(this.iXr));
            jSONObject.put("height", f.lZ(this.iXs));
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
