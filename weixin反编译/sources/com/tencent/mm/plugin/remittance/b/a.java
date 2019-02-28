package com.tencent.mm.plugin.remittance.b;

import com.tencent.mm.f.b.al;
import java.lang.reflect.Field;

public final class a extends al {
    public static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xrT.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "msgId";
        aVar.columns[1] = "transferId";
        aVar.xrT.put("transferId", "TEXT");
        stringBuilder.append(" transferId TEXT");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
