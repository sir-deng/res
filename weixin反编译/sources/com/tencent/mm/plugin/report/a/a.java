package com.tencent.mm.plugin.report.a;

import com.tencent.mm.f.b.an;
import java.lang.reflect.Field;

public final class a extends an {
    protected static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "bakLogId";
        aVar.xrT.put("bakLogId", "INTEGER");
        stringBuilder.append(" bakLogId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[1] = "valueStr";
        aVar.xrT.put("valueStr", "TEXT");
        stringBuilder.append(" valueStr TEXT");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
