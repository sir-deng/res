package com.tencent.mm.storage;

import com.tencent.mm.f.b.dw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class bj extends dw {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "openId";
        aVar.xrT.put("openId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" openId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "openId";
        aVar.columns[1] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xrT.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public bj(String str, String str2, String str3) {
        this.field_appId = str;
        this.field_username = str2;
        this.field_openId = str3;
    }
}
