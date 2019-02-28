package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    private Map<String, a> iOp = new HashMap();

    private static class a {
        public static e iOq = new e();
    }

    public e() {
        a(new h());
        a(new f());
        a(new g());
        a(new i());
        a(new d());
        a(new b());
        a(new c());
        a(new j());
    }

    public final Path d(JSONArray jSONArray) {
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            return path;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return path;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("method");
                JSONArray optJSONArray = optJSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                a aVar = (a) this.iOp.get(optString);
                if (aVar != null) {
                    aVar.a(path, optJSONArray);
                }
            }
            i = i2 + 1;
        }
    }

    private void a(a aVar) {
        this.iOp.put(aVar.getMethod(), aVar);
    }
}
