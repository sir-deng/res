package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.f.b.cv;
import java.lang.reflect.Field;

public final class a extends cv {
    static final com.tencent.mm.sdk.e.c.a iHk;

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return iHk;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "startTime";
        aVar.xrT.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "endTime";
        aVar.xrT.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "sceneList";
        aVar.xrT.put("sceneList", "TEXT");
        stringBuilder.append(" sceneList TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "cgiList";
        aVar.xrT.put("cgiList", "TEXT");
        stringBuilder.append(" cgiList TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportId";
        aVar.xrT.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[7] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
    }
}
