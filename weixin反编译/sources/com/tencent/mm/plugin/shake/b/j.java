package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.plugin.shake.a.a.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class j extends b {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.xrT.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[1] = "lastshaketime";
        aVar.xrT.put("lastshaketime", "INTEGER default '0' ");
        stringBuilder.append(" lastshaketime INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "isshowed";
        aVar.xrT.put("isshowed", "INTEGER default 'false' ");
        stringBuilder.append(" isshowed INTEGER default 'false' ");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
