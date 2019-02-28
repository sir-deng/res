package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.plugin.shake.a.a.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class f extends a {
    protected static c.a gKN;

    static {
        c.a aVar = new c.a();
        aVar.hUM = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "svrid";
        aVar.xrT.put("svrid", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "svrid";
        aVar.columns[1] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "subtype";
        aVar.xrT.put("subtype", "INTEGER default '0' ");
        stringBuilder.append(" subtype INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createtime";
        aVar.xrT.put("createtime", "LONG");
        stringBuilder.append(" createtime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "tag";
        aVar.xrT.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "title";
        aVar.xrT.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "desc";
        aVar.xrT.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "thumburl";
        aVar.xrT.put("thumburl", "TEXT");
        stringBuilder.append(" thumburl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.xrT.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.xrT.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.xrT.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reservedBuf";
        aVar.xrT.put("reservedBuf", "BLOB");
        stringBuilder.append(" reservedBuf BLOB");
        aVar.columns[13] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final c.a Aj() {
        return gKN;
    }
}
