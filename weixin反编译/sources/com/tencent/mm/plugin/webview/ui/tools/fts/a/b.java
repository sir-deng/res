package com.tencent.mm.plugin.webview.ui.tools.fts.a;

import android.database.Cursor;
import com.tencent.mm.plugin.webview.b.d;
import com.tencent.mm.plugin.webview.b.e;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements d {
    private List<c> list = new ArrayList();
    private Map<String, String> tLw = new HashMap();

    public final List<c> bUO() {
        this.list.clear();
        e bSs = f.bSs();
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = bSs.rawQuery(new StringBuilder("select * from WebViewHistory order by timeStamp desc limit 200").toString(), new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    d dVar = new d();
                    dVar.b(rawQuery);
                    linkedList.add(dVar);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        if (!linkedList.isEmpty()) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                c cVar;
                d dVar2 = (d) it.next();
                if (dVar2 == null) {
                    cVar = null;
                } else {
                    cVar = dVar2.field_timeStamp < (System.currentTimeMillis() / 1000) - 604800 ? null : new c(dVar2.field_link, dVar2.field_title, dVar2.field_source, dVar2.field_imgUrl, dVar2.field_timeStamp * 1000);
                }
                if (cVar != null) {
                    this.list.add(cVar);
                    this.tLw.put(cVar.url, dVar2.field_recordId);
                }
            }
        }
        return this.list;
    }

    public final void c(c cVar) {
        this.list.remove(cVar);
        f.bSs().iI(String.valueOf(f.bSs().iI((String) this.tLw.get(cVar.url))));
    }

    public final void bUP() {
        this.list.clear();
        x.i("MicroMsg.WebViewHistoryStorage", "clear: " + f.bSs().fD("WebViewHistory", "delete from WebViewHistory"));
    }

    public final boolean isEmpty() {
        return this.list == null || this.list.isEmpty();
    }
}
