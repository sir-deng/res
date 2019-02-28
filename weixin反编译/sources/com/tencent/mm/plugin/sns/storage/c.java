package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.f.b.ab;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends ab {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "canvasId";
        aVar.xrT.put("canvasId", "LONG PRIMARY KEY ");
        stringBuilder.append(" canvasId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "canvasId";
        aVar.columns[1] = "canvasXml";
        aVar.xrT.put("canvasXml", "TEXT");
        stringBuilder.append(" canvasXml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
