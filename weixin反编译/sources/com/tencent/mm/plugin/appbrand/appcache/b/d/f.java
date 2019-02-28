package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.f.b.cy;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class f extends cy implements b {
    static final String[] iHh = new String[]{"appId", "scene"};
    static final a iHk;

    protected final a Aj() {
        return iHk;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.xrT.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "launchProtoBlob";
        aVar.xrT.put("launchProtoBlob", "BLOB");
        stringBuilder.append(" launchProtoBlob BLOB");
        stringBuilder.append(", ");
        aVar.columns[3] = "startTime";
        aVar.xrT.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "endTime";
        aVar.xrT.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "reportId";
        aVar.xrT.put("reportId", "LONG");
        stringBuilder.append(" reportId LONG");
        aVar.columns[6] = "rowid";
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
