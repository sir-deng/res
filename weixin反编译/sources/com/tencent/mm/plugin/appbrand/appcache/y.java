package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.f.b.cz;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends cz implements b {
    static final String[] iHh = new String[]{"appId", "appVersion"};
    static final a iHk;

    protected final a Aj() {
        return iHk;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "appVersion";
        aVar.xrT.put("appVersion", "INTEGER");
        stringBuilder.append(" appVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "decryptKey";
        aVar.xrT.put("decryptKey", "TEXT");
        stringBuilder.append(" decryptKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "pkgMd5";
        aVar.xrT.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "reportId";
        aVar.xrT.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = iHh;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = iHk;
        aVar2.xrU = stringBuilder2.append(aVar2.xrU).append(",").append(str2).toString();
    }

    public final String[] getKeys() {
        return iHh;
    }
}
