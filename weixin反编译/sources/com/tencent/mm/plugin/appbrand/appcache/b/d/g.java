package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.f.b.es;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends es {
    static final a iHk;

    protected final a Aj() {
        return iHk;
    }

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "appVersion";
        aVar.xrT.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "reportId";
        aVar.xrT.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
    }
}
