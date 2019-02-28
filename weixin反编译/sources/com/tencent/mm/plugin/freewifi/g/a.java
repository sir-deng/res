package com.tencent.mm.plugin.freewifi.g;

import com.tencent.mm.f.b.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class a extends bg {
    protected static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xrT.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "key";
        aVar.columns[1] = Columns.VALUE;
        aVar.xrT.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "modifyTime";
        aVar.xrT.put("modifyTime", "LONG default '0' ");
        stringBuilder.append(" modifyTime LONG default '0' ");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
