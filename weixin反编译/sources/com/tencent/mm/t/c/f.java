package com.tencent.mm.t.c;

import com.tencent.mm.t.b.d;
import com.tencent.mm.t.d.a;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f {
    public d gQD;
    public g gQG;
    public a gQs;

    public f(d dVar, g gVar, a aVar) {
        Assert.assertNotNull(dVar);
        Assert.assertNotNull(gVar);
        Assert.assertNotNull(aVar);
        this.gQD = dVar;
        this.gQG = gVar;
        this.gQs = aVar;
    }

    public static String Cj() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }
}
