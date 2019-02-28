package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.f.b.ei;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;

public final class a {
    private static final SparseArray<a> tzQ = new SparseArray();
    private static volatile b tzR = null;
    private static final byte[] tzS = new byte[0];
    public final String appId;
    public final String path;
    public final b tzP = bRW();

    private static final class a extends ei {
        private static final com.tencent.mm.sdk.e.c.a iHk = ei.vQ();

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        protected final com.tencent.mm.sdk.e.c.a Aj() {
            return iHk;
        }
    }

    private static final class b extends i<a> {
        public final boolean jbr;

        static /* synthetic */ void a(b bVar, String str, long j) {
            if (bVar.jbr) {
                c aVar = new a();
                aVar.field_appId = str;
                if (bVar.b(aVar, new String[0])) {
                    aVar.field_occupation += j;
                    bVar.c(aVar, new String[0]);
                    return;
                }
                aVar.field_occupation = j;
                bVar.b(aVar);
            }
        }

        public b(e eVar) {
            super(eVar, a.iHk, "WebViewCacheAppIdOccupation", null);
            this.jbr = eVar != null;
        }
    }

    public static com.tencent.mm.plugin.webview.modelcache.d.a bRV() {
        return new com.tencent.mm.plugin.webview.modelcache.d.a("WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode(), new String[]{i.a(ei.vQ(), "WebViewCacheAppIdOccupation")});
    }

    public static a Pb(String str) {
        if (bi.oN(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) tzQ.get(hashCode);
        if (aVar == null) {
            aVar = new a(str);
            tzQ.put(hashCode, aVar);
            return aVar;
        }
        FileOp.ml(aVar.path);
        return aVar;
    }

    static void clearCache() {
        tzQ.clear();
    }

    private static b bRW() {
        if (!as.Hp()) {
            return new b(null);
        }
        b bVar;
        synchronized (tzS) {
            if (tzR == null || !tzR.jbr) {
                as.Hm();
                tzR = new b(com.tencent.mm.y.c.Fc());
            }
            bVar = tzR;
        }
        return bVar;
    }

    private a(String str) {
        this.appId = str;
        FileOp.ml(com.tencent.mm.compatible.util.e.gJr + "sfs");
        this.path = com.tencent.mm.compatible.util.e.gJr + String.valueOf(str.hashCode());
        FileOp.ml(this.path);
    }
}
