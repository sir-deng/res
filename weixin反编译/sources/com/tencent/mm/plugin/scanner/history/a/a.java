package com.tencent.mm.plugin.scanner.history.a;

import com.tencent.mm.f.b.df;
import java.lang.reflect.Field;

public final class a extends df {
    protected static com.tencent.mm.sdk.e.c.a gKN;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productId";
        aVar.xrT.put("productId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "productId";
        aVar.columns[1] = "xmlContent";
        aVar.xrT.put("xmlContent", "TEXT");
        stringBuilder.append(" xmlContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "ScanTime";
        aVar.xrT.put("ScanTime", "LONG");
        stringBuilder.append(" ScanTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "funcType";
        aVar.xrT.put("funcType", "INTEGER");
        stringBuilder.append(" funcType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "qrcodeUrl";
        aVar.xrT.put("qrcodeUrl", "TEXT");
        stringBuilder.append(" qrcodeUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "scene";
        aVar.xrT.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }
}
