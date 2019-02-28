package com.tencent.mm.storage;

import com.tencent.mm.f.b.dz;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.reflect.Field;

public final class bl extends dz {
    protected static a gKN;

    protected final a Aj() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xrT.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "msgId";
        aVar.columns[1] = "cmsgId";
        aVar.xrT.put("cmsgId", "TEXT");
        stringBuilder.append(" cmsgId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "content";
        aVar.xrT.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    public final void Yu(String str) {
        if (!bi.oN(str)) {
            this.field_cmsgId = str;
        }
    }
}
