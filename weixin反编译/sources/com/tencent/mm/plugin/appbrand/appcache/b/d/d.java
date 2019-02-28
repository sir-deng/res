package com.tencent.mm.plugin.appbrand.appcache.b.d;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class d extends c<c> {
    public static final String[] iHj = new String[]{i.a(c.iHk, "PredownloadCmdGetCodePersistentInfo")};
    private final e iHl;

    public d(e eVar) {
        super(eVar, c.iHk, "PredownloadCmdGetCodePersistentInfo", c.fNF);
        this.iHl = eVar;
    }

    public final List<c> e(String str, String... strArr) {
        Cursor query = this.iHl.query("PredownloadCmdGetCodePersistentInfo", null, str, strArr, null, null, null);
        if (query == null || query.isClosed()) {
            return Collections.emptyList();
        }
        List<c> linkedList = new LinkedList();
        if (query.moveToFirst()) {
            do {
                c cVar = new c();
                cVar.b(query);
                linkedList.add(cVar);
            } while (query.moveToNext());
        }
        query.close();
        return linkedList;
    }
}
