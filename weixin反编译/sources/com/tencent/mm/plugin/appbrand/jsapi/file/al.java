package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class al extends d {
    al() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        boolean z = true;
        com.tencent.mm.plugin.appbrand.appstorage.j qp = jVar.iuk.isU.qp(str);
        switch (qp) {
            case RET_NOT_EXISTS:
                return new a("fail no such file or directory \"%s\"", str);
            case OK:
            case ERR_IS_FILE:
                a aVar = new a("ok", new Object[0]);
                String str2 = "result";
                if (qp != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                    z = false;
                }
                return aVar.s(str2, Boolean.valueOf(z));
            default:
                return new a("fail " + qp.name(), new Object[0]);
        }
    }
}
