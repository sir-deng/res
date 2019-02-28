package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.o;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import com.tencent.mm.plugin.appbrand.appstorage.g;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public final class a implements l {
    private final List<l> jmH = new LinkedList();
    private final l jmI = new g();

    public static a p(e eVar) {
        return new a(eVar);
    }

    private a(e eVar) {
        l i = aj.i(eVar);
        com.tencent.mm.plugin.appbrand.appstorage.a aVar = new com.tencent.mm.plugin.appbrand.appstorage.a(eVar.mAppId);
        this.jmH.add(new com.tencent.mm.plugin.appbrand.appstorage.e(o.getString(eVar.isS.uin), eVar.mAppId));
        this.jmH.add(aVar);
        this.jmH.add(i);
        initialize();
    }

    final <T extends l> T x(Class<T> cls) {
        for (l lVar : this.jmH) {
            if (lVar.getClass() == cls) {
                return lVar;
            }
        }
        return null;
    }

    private l sI(String str) {
        if (bi.oN(str)) {
            return this.jmI;
        }
        for (l lVar : this.jmH) {
            if (lVar.bE(str)) {
                return lVar;
            }
        }
        return this.jmI;
    }

    public final j qk(String str) {
        return sI(str).qk(str);
    }

    public final j qp(String str) {
        return sI(str).qp(str);
    }

    public final j qq(String str) {
        return sI(str).qq(str);
    }

    public final j qr(String str) {
        return sI(str).qr(str);
    }

    public final j b(String str, h<List<com.tencent.mm.plugin.appbrand.appstorage.h>> hVar) {
        return sI(str).b(str, hVar);
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        return sI(str).a(str, (h) hVar);
    }

    public final j d(String str, InputStream inputStream) {
        return sI(str).d(str, inputStream);
    }

    public final j qs(String str) {
        return sI(str).qs(str);
    }

    public final j a(String str, FileStructStat fileStructStat) {
        return sI(str).a(str, fileStructStat);
    }

    public final j a(String str, File file, boolean z) {
        return sI(str).a(str, file, z);
    }

    public final File ql(String str) {
        return sI(str).ql(str);
    }

    public final boolean bE(String str) {
        return true;
    }

    public final void initialize() {
        for (l initialize : this.jmH) {
            initialize.initialize();
        }
        this.jmI.initialize();
    }

    public final void release() {
        for (l release : this.jmH) {
            release.release();
        }
        this.jmI.release();
    }
}
