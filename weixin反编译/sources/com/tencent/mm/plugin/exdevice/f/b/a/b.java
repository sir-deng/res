package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.f.b.bt;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends bt {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.xrT.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "title";
        aVar.xrT.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "score";
        aVar.xrT.put("score", "INTEGER");
        stringBuilder.append(" score INTEGER");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
