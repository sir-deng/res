package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class ar extends d {
    ar() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        FileStructStat fileStructStat = new FileStructStat();
        com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.iuk.isU.a(str, fileStructStat);
        switch (a) {
            case OK:
                return new a("ok", new Object[0]).s("mode", Integer.valueOf(fileStructStat.st_mode)).s("size", Long.valueOf(fileStructStat.st_size)).s("lastAccessedTime", Long.valueOf(fileStructStat.st_atime)).s("lastModifiedTime", Long.valueOf(fileStructStat.st_mtime));
            case RET_NOT_EXISTS:
            case ERR_PARENT_DIR_NOT_EXISTS:
                return new a("fail no such file or directory \"%s\"", str);
            case ERR_PERMISSION_DENIED:
                return new a("fail permission denied, open \"%s\"", str);
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }
}
