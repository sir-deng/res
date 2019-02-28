package com.tencent.mm.storage;

import com.tencent.mm.f.b.t;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class m extends t {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "sessionName";
        aVar.xrT.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "startTime";
        aVar.xrT.put("startTime", "LONG default '0' ");
        stringBuilder.append(" startTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "endTime";
        aVar.xrT.put("endTime", "LONG default '0' ");
        stringBuilder.append(" endTime LONG default '0' ");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
