package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class aq {
    private static volatile aq iIW = null;
    private final Map<String, Map<a, Boolean>> iIX = new android.support.v4.e.a();
    public final ah iIY = new ah();

    public static final class b {
        public final String appId;
        public final String filePath;
        public final int iIZ;
        public final int version;

        public b(String str, String str2, int i, int i2) {
            this.appId = str;
            this.filePath = str2;
            this.version = i;
            this.iIZ = i2;
        }
    }

    public interface a extends com.tencent.mm.plugin.appbrand.appcache.a.b.a<b> {
    }

    public static aq aaA() {
        if (((c) g.h(c.class)).Zf() == null) {
            iIW = null;
            return null;
        }
        if (iIW == null) {
            synchronized (aq.class) {
                if (iIW == null) {
                    iIW = new aq();
                }
            }
        }
        return iIW;
    }

    public static void shutdown() {
        aq aqVar;
        synchronized (aq.class) {
            aqVar = iIW;
            iIW = null;
        }
        if (aqVar != null) {
            aqVar.iIY.iHX.shutdown();
        }
    }

    public static boolean a(String str, a aVar) {
        return a("@LibraryAppId", 999, str, aVar);
    }

    public static boolean a(String str, int i, a aVar) {
        return b("@LibraryAppId", 0, i, str, aVar);
    }

    static void b(String str, a aVar) {
        if (!bi.oN(str) && aVar != null) {
            aq aaA = aaA();
            if (aaA != null) {
                synchronized (aq.class) {
                    Map map = (Map) aaA.iIX.get(str);
                    if (map == null) {
                        map = new HashMap();
                        aaA().iIX.put(str, map);
                    }
                    map.put(aVar, Boolean.valueOf(true));
                }
            }
        }
    }

    static Map<a, Boolean> qg(String str) {
        if (!bi.oN(str)) {
            aq aaA = aaA();
            if (aaA != null) {
                Map<a, Boolean> map;
                synchronized (aq.class) {
                    map = (Map) aaA.iIX.remove(str);
                }
                return map;
            }
        }
        return null;
    }

    static void aO(String str, String str2) {
        a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
    }

    static boolean a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar, a aVar2) {
        if (aaA() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        } else if (aVar == null) {
            return false;
        } else {
            b(aVar.vmK, aVar2);
            int b = aaA().iIY.b(aVar);
            if (b == 0 || b == 2) {
                return true;
            }
            a(aVar.vmK, aVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
            return false;
        }
    }

    public static boolean a(String str, int i, int i2, int i3, String str2, a aVar) {
        com.tencent.mm.plugin.appbrand.appcache.a.a aVar2 = null;
        if (aaA() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, get null updater instance!!!");
            return false;
        }
        com.tencent.mm.plugin.appbrand.appcache.a.a aiVar;
        if (!bi.oN(str) && !bi.oN(str2)) {
            switch (i) {
                case 0:
                    aiVar = new ai(str, i, i2, str2);
                    break;
                case 1:
                case 2:
                case 999:
                    aiVar = new ad(str, str2, i);
                    break;
                case 10000:
                case 10001:
                case 10002:
                case 10100:
                case 10101:
                case 10102:
                    aiVar = new ar(str2, str, i2, i);
                    break;
                default:
                    aiVar = null;
                    break;
            }
        }
        aiVar = null;
        if (aiVar != null) {
            boolean z = "@LibraryAppId".equals(str) ? false : i == 0;
            aiVar.iJg = z;
            if (i3 > 2097152) {
                aiVar.setReadTimeout(aiVar.getReadTimeout() * 2);
                aiVar.setConnectTimeout(aiVar.getConnectTimeout() * 2);
            }
            aVar2 = aiVar;
        }
        if (aVar2 != null) {
            return a(aVar2, aVar);
        }
        x.e("MicroMsg.AppBrandWxaPkgUpdater", "startDownloadPkg, create Null request, appId %s, pkgType %d, pkgVersion %d, url %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
        return false;
    }

    public static boolean b(String str, int i, int i2, String str2, a aVar) {
        return a(str, i, i2, 0, str2, aVar);
    }

    public static boolean a(String str, int i, String str2, a aVar) {
        return b(str, i, 1, str2, aVar);
    }

    static void a(String str, String str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar, b bVar) {
        Map qg = qg(str);
        if (qg != null) {
            for (a aVar2 : qg.keySet()) {
                if (aVar2 != null) {
                    aVar2.a(str2, aVar, bVar);
                }
            }
            return;
        }
        x.d("MicroMsg.AppBrandWxaPkgUpdater", "callback, null callback appId = %s", str2);
    }

    static void a(String str, String str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar) {
        if (aaA() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadFail, get instance null !!!");
        } else {
            a(str, str2, aVar, null);
        }
    }

    static void a(String str, String str2, String str3, int i, int i2, com.tencent.mm.plugin.appbrand.appcache.r.a aVar) {
        boolean hi = com.tencent.mm.plugin.appbrand.appcache.d.a.hi(i2);
        if (aaA() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, get instance null !!!");
        } else if (bi.oN(str3)) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, filePath is null or nil");
            a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.LOCAL_FILE_NOT_FOUND, null);
            aVar.ZO();
        } else if (!new File(str3).exists()) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg file not exists");
            a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.LOCAL_FILE_NOT_FOUND, null);
            aVar.ZO();
        } else if (((c) g.h(c.class)).Zf() == null) {
            x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, WxaPkgStorage is null");
            aO(str, str2);
        } else {
            al a = ((c) g.h(c.class)).Zf().a(str2, !hi ? i : 1, i2, new String[0]);
            if (a == null) {
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, no manifest record!!! with given appId(%s) version(%d) debugType(%d)", str2, Integer.valueOf(i), Integer.valueOf(i2));
                a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.FAILED, null);
                return;
            }
            boolean z;
            aVar.ZP();
            File file = new File(str3);
            String str4 = a.field_versionMd5;
            if (!hi) {
                if (!bi.oM(str4).equals(com.tencent.mm.a.g.i(file))) {
                    x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, record.md5(%s) != file.md5(%s)", str4, com.tencent.mm.a.g.i(file));
                    z = false;
                    aVar.cq(z);
                    if (z) {
                        com.tencent.mm.loader.stub.b.deleteFile(str3);
                        a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.PKG_INVALID, null);
                    }
                    x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", Boolean.valueOf(((c) g.h(c.class)).Zf().d(str2, i2, r1, str3)), str2, Integer.valueOf(i2), Integer.valueOf(r1), str3);
                    a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK, new b(str2, str3, i, i2));
                    return;
                }
            }
            ag agVar = new ag(file);
            if (!agVar.iHO) {
                agVar.close();
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg invalid");
                file.delete();
                z = false;
            } else if (agVar.aai()) {
                agVar.close();
                z = true;
            } else {
                agVar.close();
                x.e("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, pkg readInfo failed");
                file.delete();
                z = false;
            }
            aVar.cq(z);
            if (z) {
                x.i("MicroMsg.AppBrandWxaPkgUpdater", "onDownloadComplete, update ret = %b, appId = %s, debugType = %d, pkgVersion = %d, String filePath = %s", Boolean.valueOf(((c) g.h(c.class)).Zf().d(str2, i2, r1, str3)), str2, Integer.valueOf(i2), Integer.valueOf(r1), str3);
                a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.OK, new b(str2, str3, i, i2));
                return;
            }
            com.tencent.mm.loader.stub.b.deleteFile(str3);
            a(str, str2, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.PKG_INVALID, null);
        }
    }
}
