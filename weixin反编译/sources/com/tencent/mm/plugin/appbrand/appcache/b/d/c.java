package com.tencent.mm.plugin.appbrand.appcache.b.d;

import com.tencent.mm.f.b.cw;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class c extends cw implements b {
    static final String[] iHh = new String[]{"appId", Columns.TYPE, "version"};
    static final a iHk;

    protected final a Aj() {
        return iHk;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[11];
        aVar.columns = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xrT.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "retryTimes";
        aVar.xrT.put("retryTimes", "INTEGER");
        stringBuilder.append(" retryTimes INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "retriedCount";
        aVar.xrT.put("retriedCount", "INTEGER");
        stringBuilder.append(" retriedCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryInterval";
        aVar.xrT.put("retryInterval", "LONG");
        stringBuilder.append(" retryInterval LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "networkType";
        aVar.xrT.put("networkType", "INTEGER");
        stringBuilder.append(" networkType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "pkgMd5";
        aVar.xrT.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "lastRetryTime";
        aVar.xrT.put("lastRetryTime", "LONG");
        stringBuilder.append(" lastRetryTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "firstTimeTried";
        aVar.xrT.put("firstTimeTried", "INTEGER");
        stringBuilder.append(" firstTimeTried INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "reportId";
        aVar.xrT.put("reportId", "INTEGER");
        stringBuilder.append(" reportId INTEGER");
        aVar.columns[11] = "rowid";
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
