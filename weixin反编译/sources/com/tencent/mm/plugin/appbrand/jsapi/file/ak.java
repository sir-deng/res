package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ak extends d {
    ak() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j d;
        String optString = jSONObject.optString("destPath");
        String format = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        String format2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        File ql = jVar.iuk.isU.ql(str);
        if (ql == null || !ql.exists() || !ql.isFile()) {
            h hVar = new h();
            jVar.iuk.isU.a(str, hVar);
            if (hVar.jXv == null) {
                return new a(format, new Object[0]);
            }
            Closeable aVar = new com.tencent.mm.plugin.appbrand.k.a((ByteBuffer) hVar.jXv);
            d = jVar.iuk.isU.d(optString, aVar);
            bi.d(aVar);
        } else if (k.u(ql)) {
            return new a("fail \"%s\" not a regular file", str);
        } else {
            d = jVar.iuk.isU.a(optString, ql, false);
        }
        switch (d) {
            case ERR_PERMISSION_DENIED:
                return new a(format2, new Object[0]);
            case ERR_PARENT_DIR_NOT_EXISTS:
                return new a(format, new Object[0]);
            case ERR_FS_NOT_MOUNTED:
                return new a("fail sdcard not mounted", new Object[0]);
            case RET_ALREADY_EXISTS:
                return new a("fail illegal operation on a directory, open \"%s\"", optString);
            case ERR_SYMLINK:
                return new a("fail \"%s\" is not a regular file", optString);
            case OK:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + d.name(), new Object[0]);
        }
    }

    protected final String p(JSONObject jSONObject) {
        return jSONObject.optString("srcPath");
    }
}
