package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.f.b.ct;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class s extends ct {
    static final String[] iHh = new String[]{"key", "version"};
    static final a iHi;

    protected final a Aj() {
        return iHi;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xrT.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xrT.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "scene";
        aVar.xrT.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "updateTime";
        aVar.xrT.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[4] = "rowid";
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
