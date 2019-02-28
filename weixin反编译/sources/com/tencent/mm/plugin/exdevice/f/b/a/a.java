package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.f.b.bq;
import java.lang.reflect.Field;

public final class a extends bq {
    public static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "championUrl";
        aVar.xrT.put("championUrl", "TEXT");
        stringBuilder.append(" championUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "championMotto";
        aVar.xrT.put("championMotto", "TEXT");
        stringBuilder.append(" championMotto TEXT");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
