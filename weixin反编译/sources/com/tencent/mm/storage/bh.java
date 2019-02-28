package com.tencent.mm.storage;

import com.tencent.mm.f.b.du;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bh extends du {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tableHash";
        aVar.xrT.put("tableHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "tableHash";
        aVar.columns[1] = "tableSQLMD5";
        aVar.xrT.put("tableSQLMD5", "TEXT");
        stringBuilder.append(" tableSQLMD5 TEXT");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
