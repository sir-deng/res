package com.tencent.mm.storage.emotion;

import com.tencent.mm.f.b.au;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends au {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.xrT.put("productID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" productID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "productID";
        aVar.columns[1] = "content";
        aVar.xrT.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lan";
        aVar.xrT.put("lan", "TEXT default '' ");
        stringBuilder.append(" lan TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
