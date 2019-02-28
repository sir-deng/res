package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

final class ap extends d {
    ap() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        String format = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[]{str, jSONObject.optString("newPath")});
        String format2 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[]{str, r0});
        File ql = jVar.iuk.isU.ql(str);
        if (ql == null || !ql.exists()) {
            return new a(format, new Object[0]);
        }
        if (k.u(ql)) {
            return new a("fail \"%s\" not a regular file", str);
        }
        com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.iuk.isU.a(r0, ql, true);
        switch (a) {
            case ERR_PERMISSION_DENIED:
                return new a(format2, new Object[0]);
            case ERR_PARENT_DIR_NOT_EXISTS:
                return new a(format, new Object[0]);
            case ERR_FS_NOT_MOUNTED:
                return new a("fail sdcard not mounted", new Object[0]);
            case OK:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }

    protected final String p(JSONObject jSONObject) {
        return jSONObject.optString("oldPath");
    }
}
