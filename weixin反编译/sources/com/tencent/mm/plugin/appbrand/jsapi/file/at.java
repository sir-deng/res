package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

final class at extends d {
    at() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        Throwable e;
        String optString = jSONObject.optString("targetDirectory", "wxfile://usr");
        if (!optString.startsWith("wxfile://usr")) {
            return new a("fail invalid targetDirectory", new Object[0]);
        }
        switch (jVar.iuk.isU.qp(optString)) {
            case ERR_PERMISSION_DENIED:
            case ERR_IS_FILE:
            case ERR_OP_FAIL:
                return new a(String.format("fail permission denied, open \"%s\"", new Object[]{optString}), new Object[0]);
            default:
                h hVar = new h();
                com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.iuk.isU.a(str, hVar);
                switch (a) {
                    case ERR_PERMISSION_DENIED:
                        return new a("fail permission denied, open \"%s\"", str);
                    case RET_NOT_EXISTS:
                        return new a("fail no such file \"%s\"", str);
                    case OK:
                        Closeable zipInputStream;
                        a aVar;
                        try {
                            zipInputStream = new ZipInputStream(new com.tencent.mm.plugin.appbrand.k.a((ByteBuffer) hVar.jXv));
                            try {
                                com.tencent.mm.plugin.appbrand.appstorage.j d = jVar.iuk.isU.d(optString, zipInputStream);
                                switch (d) {
                                    case ERR_PERMISSION_DENIED:
                                        aVar = new a("fail permission denied, open \"%s\"", str);
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case OK:
                                        aVar = new a("ok", new Object[0]);
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case ERR_PARENT_DIR_NOT_EXISTS:
                                        aVar = new a("fail no such file or directory, open \"%s\"", str);
                                        bi.d(zipInputStream);
                                        return aVar;
                                    case RET_ALREADY_EXISTS:
                                        aVar = new a("fail illegal operation on a directory, open \"%s\"", str);
                                        bi.d(zipInputStream);
                                        return aVar;
                                    default:
                                        aVar = new a("fail " + d.name(), new Object[0]);
                                        bi.d(zipInputStream);
                                        return aVar;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            e = e2;
                        } catch (Exception e3) {
                            e = e3;
                            zipInputStream = null;
                        } catch (Throwable th) {
                            e = th;
                            zipInputStream = null;
                            bi.d(zipInputStream);
                            throw e;
                        }
                        try {
                            x.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", e, "write zip stream", new Object[0]);
                            aVar = new a("fail read zip data", new Object[0]);
                            bi.d(zipInputStream);
                            return aVar;
                        } catch (Throwable th2) {
                            e = th2;
                            bi.d(zipInputStream);
                            throw e;
                        }
                    default:
                        return new a("fail " + a.name(), new Object[0]);
                }
        }
    }

    protected final String p(JSONObject jSONObject) {
        return jSONObject.optString("zipFilePath");
    }
}
