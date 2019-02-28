package com.tencent.mm.storage.emotion;

import com.tencent.mm.f.b.at;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends at {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "designerIDAndType";
        aVar.xrT.put("designerIDAndType", "TEXT PRIMARY KEY ");
        stringBuilder.append(" designerIDAndType TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "designerIDAndType";
        aVar.columns[1] = "content";
        aVar.xrT.put("content", "BLOB default '' ");
        stringBuilder.append(" content BLOB default '' ");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return null;
    }
}
