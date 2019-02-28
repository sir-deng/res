package com.tencent.mm.storage;

import android.util.SparseArray;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.f;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;

public final class g extends i<f> {
    public static final String[] gLy = new String[]{i.a(f.vQ(), "AddContactAntispamTicket")};
    private h hiZ;
    SparseArray<String> xuO = new SparseArray();

    public static class a extends f {
        protected final com.tencent.mm.sdk.e.c.a Aj() {
            return f.vQ();
        }
    }

    public g(e eVar) {
        super(eVar, f.vQ(), "AddContactAntispamTicket", null);
        this.hiZ = (h) eVar;
    }

    public final void y(String str, int i, String str2) {
        if (!bi.oN(str)) {
            c aVar = new a();
            aVar.field_userName = str;
            aVar.field_scene = i;
            aVar.field_ticket = str2;
            a(aVar);
            fH(str, str2);
        }
    }

    public final void cE(List<f> list) {
        if (list.size() != 0) {
            long dA = this.hiZ.dA(Thread.currentThread().getId());
            for (f a : list) {
                a(a);
            }
            this.hiZ.fT(dA);
        }
    }

    public final void fH(String str, String str2) {
        if (!bi.oN(str)) {
            this.xuO.put(str.hashCode(), str2);
        }
    }

    public final String WX(String str) {
        if (bi.oN(str)) {
            return null;
        }
        String str2 = (String) this.xuO.get(str.hashCode());
        if (!bi.oN(str2)) {
            return str2;
        }
        c aVar = new a();
        aVar.field_userName = str;
        if (!b(aVar, "userName")) {
            return null;
        }
        String str3 = aVar.field_userName;
        int i = aVar.field_scene;
        fH(str3, aVar.field_ticket);
        return aVar.field_ticket;
    }
}
