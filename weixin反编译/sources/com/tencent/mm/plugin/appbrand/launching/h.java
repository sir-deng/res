package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.f.b.am;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class h extends am {
    static final String[] iHh = new String[]{"appId", "versionType"};
    static final a iHi;

    protected final a Aj() {
        return null;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "versionType";
        aVar.xrT.put("versionType", "INTEGER");
        stringBuilder.append(" versionType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "extJson";
        aVar.xrT.put("extJson", "TEXT");
        stringBuilder.append(" extJson TEXT");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHi = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = iHh;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = iHi;
        aVar2.xrU = stringBuilder2.append(aVar2.xrU).append(",").append(str2).toString();
    }
}
