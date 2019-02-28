package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.f.b.cu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class u extends cu {
    static final String[] iHh = new String[]{"appId", Columns.TYPE};
    static final a iHi;

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "hit";
        aVar.xrT.put("hit", "INTEGER");
        stringBuilder.append(" hit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "hitTimeMS";
        aVar.xrT.put("hitTimeMS", "LONG");
        stringBuilder.append(" hitTimeMS LONG");
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

    protected final a Aj() {
        return iHi;
    }
}
