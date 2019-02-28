package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.f.b.ek;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class a extends ek {
    protected static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appIdKey";
        aVar.xrT.put("appIdKey", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appIdKey TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "appIdKey";
        aVar.columns[2] = Columns.VALUE;
        aVar.xrT.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "weight";
        aVar.xrT.put("weight", "TEXT");
        stringBuilder.append(" weight TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expireTime";
        aVar.xrT.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.xrT.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "size";
        aVar.xrT.put("size", "LONG");
        stringBuilder.append(" size LONG");
        aVar.columns[7] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
