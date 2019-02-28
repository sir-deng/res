package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.f.b.h;
import java.lang.reflect.Field;

public final class a extends h {
    static final com.tencent.mm.sdk.e.c.a iHk;

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return iHk;
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT PRIMARY KEY ");
        stringBuilder.append(" username TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "updateTime";
        aVar.xrT.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
    }
}
