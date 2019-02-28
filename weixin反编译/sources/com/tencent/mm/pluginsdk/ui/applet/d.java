package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.af.a.e;
import com.tencent.mm.af.a.j;
import com.tencent.mm.af.f;
import com.tencent.mm.af.y;
import com.tencent.mm.ap.a.a.c;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.plugin.biz.b;
import com.tencent.mm.sdk.platformtools.bi;

public final class d implements n {
    public final boolean SR(String str) {
        return f.eG(str);
    }

    public final Object SS(String str) {
        Object ca = y.Mp().ca(str);
        if (ca != null && !bi.oN(ca.field_userId) && ca.field_userId.equals(str)) {
            return ca;
        }
        j jVar = new j();
        jVar.field_userId = str;
        return jVar;
    }

    public final c ST(String str) {
        a aVar = new a();
        aVar.hFo = e.kx(str);
        aVar.hFl = true;
        aVar.hFI = true;
        aVar.hFA = b.a.bBC;
        return aVar.PQ();
    }

    public final String bQ(Object obj) {
        return ((j) obj).field_userName;
    }

    public final String bR(Object obj) {
        return ((j) obj).field_headImageUrl;
    }

    public final String bS(Object obj) {
        return ((j) obj).field_userId;
    }
}
