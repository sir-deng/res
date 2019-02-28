package com.tencent.mm.pluginsdk.i.a.d;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.bx.h;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class r extends i<q> {
    private static final String[] gLy = new String[]{i.a(q.gKN, "ResDownloaderRecordTable")};
    private static final String voJ = (w.hbv + g.s(String.format("mm%d", new Object[]{Integer.valueOf(Integer.MIN_VALUE)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, d> voK;
    private final h hiZ;
    private final HashMap<String, Object> voL = new HashMap();

    public final /* synthetic */ boolean b(c cVar) {
        return i((q) cVar);
    }

    static {
        HashMap hashMap = new HashMap();
        voK = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return r.gLy;
            }
        });
        Iterator it = p.caq().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private r(h hVar) {
        super(hVar, q.gKN, "ResDownloaderRecordTable", null);
        this.hiZ = hVar;
        Iterator it = p.caq().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static r car() {
        try {
            new File(voJ).mkdirs();
            h hVar = new h();
            if (hVar.a(voJ + "ResDown.db", voJ + "EnResDown.db", -2147483648L, q.yL(), voK)) {
                return new r(hVar);
            }
            x.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", e);
            return null;
        }
    }

    public final boolean iI(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            return false;
        }
        c qVar = new q();
        qVar.field_urlKey_hashcode = str.hashCode();
        return super.a(qVar, "urlKey_hashcode");
    }

    public final boolean h(q qVar) {
        if (bi.oN(qVar.field_urlKey)) {
            return false;
        }
        qVar.field_urlKey_hashcode = qVar.field_urlKey.hashCode();
        return super.c(qVar, "urlKey_hashcode");
    }

    public final boolean i(q qVar) {
        if (bi.oN(qVar.field_urlKey)) {
            return false;
        }
        qVar.field_urlKey_hashcode = qVar.field_urlKey.hashCode();
        return super.b((c) qVar);
    }

    public final q SB(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            return null;
        }
        c qVar = new q();
        qVar.field_urlKey_hashcode = str.hashCode();
        if (super.b(qVar, "urlKey_hashcode")) {
            return qVar;
        }
        return null;
    }
}
