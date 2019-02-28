package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class m {

    public static class b {
        public String pht;
        public String qwc;
        public String thumbUrl;
        public String title;

        private b() {
        }

        public static b JN(String str) {
            Map y = bj.y(str, "nativepay");
            if (y == null) {
                return null;
            }
            try {
                b bVar = new b();
                bVar.title = bi.oM((String) y.get(".nativepay.title"));
                bVar.thumbUrl = bi.oM((String) y.get(".nativepay.thumburl"));
                bVar.qwc = bi.oM((String) y.get(".nativepay.wx_pay_url"));
                bVar.pht = bi.oM((String) y.get(".nativepay.price"));
                return bVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class e {
        public String fDP;
        public String hPT;
        public String thumbUrl;
        public String title;

        private e() {
        }

        public static e JQ(String str) {
            Map y = bj.y(str, "h5url");
            if (y == null) {
                return null;
            }
            try {
                e eVar = new e();
                eVar.title = bi.oM((String) y.get(".h5url.title"));
                eVar.thumbUrl = bi.oM((String) y.get(".h5url.thumburl"));
                eVar.hPT = bi.oM((String) y.get(".h5url.link"));
                eVar.fDP = bi.oM((String) y.get(".h5url.username"));
                return eVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class c {
        public String id;
        public String thumbUrl;
        public String title;

        private c() {
        }

        public static c JO(String str) {
            Map y = bj.y(str, "product");
            if (y == null) {
                return null;
            }
            try {
                c cVar = new c();
                cVar.title = bi.oM((String) y.get(".product.title"));
                cVar.thumbUrl = bi.oM((String) y.get(".product.thumburl"));
                cVar.id = bi.oM((String) y.get(".product.product_id"));
                return cVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class d {
        public String qwd;
        public String thumbUrl;
        public String title;
        public String username;

        private d() {
        }

        public static d JP(String str) {
            Map y = bj.y(str, "tempsession");
            if (y == null) {
                return null;
            }
            try {
                d dVar = new d();
                dVar.title = bi.oM((String) y.get(".tempsession.title"));
                dVar.thumbUrl = bi.oM((String) y.get(".tempsession.thumburl"));
                dVar.username = bi.oM((String) y.get(".tempsession.username"));
                dVar.qwd = bi.oM((String) y.get(".tempsession.deeplinkjumpurl"));
                return dVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class a {
        public String path;
        public String thumbUrl;
        public String title;
        public String username;
        public int version;

        private a() {
        }

        public static a JM(String str) {
            Map y = bj.y(str, "program");
            if (y == null) {
                return null;
            }
            try {
                a aVar = new a();
                aVar.title = bi.oM((String) y.get(".program.title"));
                aVar.thumbUrl = bi.oM((String) y.get(".program.thumburl"));
                aVar.username = bi.oM((String) y.get(".program.username"));
                aVar.path = bi.oM((String) y.get(".program.path"));
                aVar.version = bi.getInt((String) y.get(".program.version"), 0);
                return aVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static class f {
        public String bgo;
        public String qwe;
        public String userName;

        private f() {
        }

        public static f JR(String str) {
            Map y = bj.y(str, "bizprofile");
            if (y == null) {
                return null;
            }
            try {
                f fVar = new f();
                fVar.bgo = bi.oM((String) y.get(".bizprofile.nickname"));
                fVar.userName = bi.oM((String) y.get(".bizprofile.username"));
                fVar.qwe = bi.oM((String) y.get(".bizprofile.showchat"));
                return fVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
                return null;
            }
        }
    }
}
