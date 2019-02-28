package com.tencent.mm.storage;

import com.tencent.mm.f.b.s;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class k extends s {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgListDataId";
        aVar.xrT.put("msgListDataId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" msgListDataId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "msgListDataId";
        aVar.columns[1] = "sessionName";
        aVar.xrT.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
