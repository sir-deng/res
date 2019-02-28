package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.f.b.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class b extends i {
    public static final a iHk;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xrT.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "key";
        aVar.columns[1] = Columns.VALUE;
        aVar.xrT.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
    }

    protected final a Aj() {
        return iHk;
    }
}
