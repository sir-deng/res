package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

final class an extends d {
    an() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j jVar2;
        Uri parse = Uri.parse(str);
        List<h> linkedList = new LinkedList();
        if (parse.getScheme().equals("wxfile") && bi.oN(parse.getAuthority())) {
            com.tencent.mm.plugin.appbrand.q.h hVar = new com.tencent.mm.plugin.appbrand.q.h();
            ((com.tencent.mm.plugin.appbrand.appstorage.a) jVar.iuk.isU.x(com.tencent.mm.plugin.appbrand.appstorage.a.class)).b("", hVar);
            if (!bi.cC((List) hVar.jXv)) {
                for (h hVar2 : (List) hVar.jXv) {
                    hVar2.fileName = hVar2.fileName.replaceFirst(Pattern.quote(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX), "");
                }
            }
            e.e(linkedList, (List) hVar.jXv);
            hVar = new com.tencent.mm.plugin.appbrand.q.h();
            ((com.tencent.mm.plugin.appbrand.appstorage.e) jVar.iuk.isU.x(com.tencent.mm.plugin.appbrand.appstorage.e.class)).b("wxfile://usr", hVar);
            e.e(linkedList, (List) hVar.jXv);
            jVar2 = com.tencent.mm.plugin.appbrand.appstorage.j.OK;
        } else {
            com.tencent.mm.plugin.appbrand.q.h hVar3 = new com.tencent.mm.plugin.appbrand.q.h();
            com.tencent.mm.plugin.appbrand.appstorage.j b = jVar.iuk.isU.b(str, hVar3);
            e.e(linkedList, (List) hVar3.jXv);
            jVar2 = b;
        }
        switch (jVar2) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                return new a("fail no such file or directory \"%s\"", str);
            case ERR_IS_FILE:
                return new a("fail not a directory \"%s\"", str);
            case ERR_PERMISSION_DENIED:
                return new a("fail permission denied, open \"%s\"", str);
            case ERR_SYMLINK:
                return new a("fail \"%s\" is not a regular file", str);
            case OK:
                JSONArray jSONArray = new JSONArray();
                for (h hVar22 : linkedList) {
                    jSONArray.put(hVar22.fileName);
                }
                return new a("ok", new Object[0]).s("files", jSONArray);
            default:
                return new a("fail " + jVar2.name(), new Object[0]);
        }
    }
}
