package com.tencent.mm.storage;

import com.tencent.mm.f.b.aj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class aa extends aj {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "labelId";
        aVar.xrT.put("labelId", "TEXT");
        stringBuilder.append(" labelId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "contactName";
        aVar.xrT.put("contactName", "TEXT");
        stringBuilder.append(" contactName TEXT");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
