package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.f.b.eo;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class ae extends eo {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xrT.put("recordId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" recordId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "recordId";
        aVar.columns[1] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "domin";
        aVar.xrT.put("domin", "TEXT");
        stringBuilder.append(" domin TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "key";
        aVar.xrT.put("key", "TEXT");
        stringBuilder.append(" key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = Columns.VALUE;
        aVar.xrT.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
