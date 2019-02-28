package com.tencent.mm.plugin.scanner.history.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class b extends i<a> {
    public static final String[] gLy = new String[]{i.a(a.gKN, "ScanHistoryItem")};
    public e gLA;

    public b(e eVar) {
        super(eVar, a.gKN, "ScanHistoryItem", null);
        this.gLA = eVar;
    }

    public final Cursor Tq() {
        return this.gLA.rawQuery("select * from ScanHistoryItem order by ScanTime desc", null);
    }
}
