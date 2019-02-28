package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.f.b.em;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends em {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "host";
        aVar.xrT.put("host", "TEXT");
        stringBuilder.append(" host TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "expireTime";
        aVar.xrT.put("expireTime", "LONG");
        stringBuilder.append(" expireTime LONG");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
