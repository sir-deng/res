package com.tencent.mm.plugin.appbrand.widget;

import com.tencent.mm.f.b.eu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class l extends eu {
    public static a iHk;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appIdHash";
        aVar.xrT.put("appIdHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "appIdHash";
        aVar.columns[1] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "openDebug";
        aVar.xrT.put("openDebug", "INTEGER");
        stringBuilder.append(" openDebug INTEGER");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
    }

    protected final a Aj() {
        return iHk;
    }
}
