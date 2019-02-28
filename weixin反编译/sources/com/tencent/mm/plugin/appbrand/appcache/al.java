package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.f.b.n;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class al extends n {
    static final a iHk;
    public static final String[] iIB = new String[]{"appId", "version", "debugType"};

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[10];
        aVar.columns = new String[11];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xrT.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "versionMd5";
        aVar.xrT.put("versionMd5", "TEXT");
        stringBuilder.append(" versionMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "versionState";
        aVar.xrT.put("versionState", "INTEGER");
        stringBuilder.append(" versionState INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.xrT.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "debugType";
        aVar.xrT.put("debugType", "INTEGER default '0' ");
        stringBuilder.append(" debugType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "downloadURL";
        aVar.xrT.put("downloadURL", "TEXT");
        stringBuilder.append(" downloadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "startTime";
        aVar.xrT.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "endTime";
        aVar.xrT.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        aVar.columns[10] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
        String str = " PRIMARY KEY (";
        String[] strArr = iIB;
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

    protected final a Aj() {
        return iHk;
    }
}
