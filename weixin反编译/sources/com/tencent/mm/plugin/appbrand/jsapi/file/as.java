package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class as extends d {
    as() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j qs = jVar.iuk.isU.qs(str);
        switch (qs) {
            case ERR_PERMISSION_DENIED:
                return new a("fail permission denied, open \"%s\"", str);
            case RET_NOT_EXISTS:
                return new a("fail no such file or directory \"%s\"", str);
            case ERR_IS_DIRECTORY:
                return new a("fail operation not permitted, unlink \"%s\"", str);
            case OK:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + qs.name(), new Object[0]);
        }
    }
}
