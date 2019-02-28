package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.r.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class au extends d {
    au() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        InputStream aVar;
        String optString = jSONObject.optString("encoding");
        l.a(jVar, jSONObject, this.jmL);
        Object opt = jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA);
        if (opt instanceof String) {
            e eVar;
            if (bi.oN(optString)) {
                eVar = (e) e.a.jmM.get("utf8");
            } else {
                e eVar2 = (e) e.a.jmM.get(optString.toLowerCase());
                if (eVar2 == null) {
                    return new a("fail invalid encoding", new Object[0]);
                }
                eVar = eVar2;
            }
            try {
                aVar = new com.tencent.mm.plugin.appbrand.k.a(eVar.sJ((String) opt));
            } catch (Exception e) {
                return new a("fail " + e.getMessage(), new Object[0]);
            }
        } else if (opt instanceof ByteBuffer) {
            aVar = new com.tencent.mm.plugin.appbrand.k.a((ByteBuffer) opt);
        } else if (opt != null) {
            return new a("fail invalid data", new Object[0]);
        } else {
            aVar = new ByteArrayInputStream(new byte[0]);
        }
        com.tencent.mm.plugin.appbrand.appstorage.j d = jVar.iuk.isU.d(str, aVar);
        switch (d) {
            case ERR_PARENT_DIR_NOT_EXISTS:
                return new a("fail no such file or directory, open \"%s\"", str);
            case RET_ALREADY_EXISTS:
                return new a("fail illegal operation on a directory, open \"%s\"", str);
            case ERR_PERMISSION_DENIED:
                return new a("fail permission denied, open \"%s\"", str);
            case ERR_SYMLINK:
                return new a("fail \"%s\" is not a regular file", str);
            case OK:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + d.name(), new Object[0]);
        }
    }
}
