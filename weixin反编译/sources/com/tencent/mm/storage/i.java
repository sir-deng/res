package com.tencent.mm.storage;

import com.tencent.mm.f.b.r;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends r {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceId";
        aVar.xrT.put("deviceId", "TEXT default '' ");
        stringBuilder.append(" deviceId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "sessionName";
        aVar.xrT.put("sessionName", "TEXT default '' ");
        stringBuilder.append(" sessionName TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "moveTime";
        aVar.xrT.put("moveTime", "BLOB default '' ");
        stringBuilder.append(" moveTime BLOB default '' ");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
