package com.tencent.mm.plugin.order.b;

import com.tencent.mm.f.b.cq;
import java.lang.reflect.Field;

public final class a extends cq {
    protected static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xrT.put("msgId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "msgId";
        aVar.columns[1] = "msgContentXml";
        aVar.xrT.put("msgContentXml", "TEXT");
        stringBuilder.append(" msgContentXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.xrT.put("isRead", "TEXT");
        stringBuilder.append(" isRead TEXT");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
