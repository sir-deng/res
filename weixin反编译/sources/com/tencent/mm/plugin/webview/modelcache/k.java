package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.plugin.webview.modelcache.d.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.LinkedList;
import java.util.List;

public final class k extends i<f> {
    private static volatile k tAc = null;
    private final e gLA;
    public final boolean jbr;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public static List<a> bRY() {
        List linkedList = new LinkedList();
        linkedList.add(new a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{i.a(f.gKN, "WebViewResourceCache")}));
        return linkedList;
    }

    public static k bRZ() {
        if (!as.Hp()) {
            return new k(null);
        }
        if (tAc == null) {
            synchronized (k.class) {
                if (tAc == null || !tAc.jbr) {
                    as.Hm();
                    tAc = new k(com.tencent.mm.y.c.Fc());
                }
            }
        }
        return tAc;
    }

    private k(e eVar) {
        super(eVar, f.gKN, "WebViewResourceCache", null);
        this.gLA = eVar;
        this.jbr = eVar != null;
        if (!this.jbr) {
            x.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
    }

    static String AG(int i) {
        String str = "1=1";
        if (b.a.AC(i) && b.a.AB(i)) {
            return str;
        }
        return String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
    }

    public final List<f> n(String str, String... strArr) {
        List<f> list = null;
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    f fVar = new f();
                    fVar.b(rawQuery);
                    list.add(fVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    public final boolean checkIsCached(String str, int i) {
        if (!this.jbr || bi.oN(str)) {
            return false;
        }
        String AG = AG(i);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", AG}), String.valueOf(ac.VF(str).hashCode()));
        if (rawQuery == null) {
            return false;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        rawQuery.close();
        return false;
    }

    private boolean a(f fVar) {
        if (!this.jbr) {
            return false;
        }
        if (bi.oN(fVar.field_url)) {
            x.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            return false;
        }
        String VF = ac.VF(fVar.field_url);
        if (bi.oN(VF)) {
            x.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", fVar.field_url);
            return false;
        }
        fVar.field_urlMd5Hashcode = VF.hashCode();
        long Wx = bi.Wx();
        fVar.field_accessTime = Wx;
        fVar.field_createTime = Wx;
        return a((c) fVar, false);
    }

    public final boolean insert(f fVar, int i, int i2) {
        return a(fVar);
    }

    public final boolean update(f fVar, int i, int i2) {
        return b(fVar);
    }

    public final boolean b(f fVar) {
        if (!this.jbr) {
            return false;
        }
        if (bi.oN(fVar.field_url)) {
            x.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            return false;
        }
        long Wx = bi.Wx();
        fVar.field_accessTime = Wx;
        fVar.field_createTime = Wx;
        x.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = " + fVar);
        return b(fVar, false, "urlMd5Hashcode", "appId", "domain", "cacheType", "packageId");
    }
}
