package com.tencent.mm.storage;

import com.tencent.mm.f.b.ah;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends ah {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "cmdbuf";
        aVar.xrT.put("cmdbuf", "BLOB default '' ");
        stringBuilder.append(" cmdbuf BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
