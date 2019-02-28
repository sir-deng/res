package com.tencent.mm.q;

import com.tencent.mm.f.b.bj;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public final class d extends bj {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "cgi";
        aVar.xrT.put("cgi", "TEXT");
        stringBuilder.append(" cgi TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cmdid";
        aVar.xrT.put("cmdid", "INTEGER");
        stringBuilder.append(" cmdid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "functionmsgid";
        aVar.xrT.put("functionmsgid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "functionmsgid";
        aVar.columns[3] = "version";
        aVar.xrT.put("version", "LONG");
        stringBuilder.append(" version LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "preVersion";
        aVar.xrT.put("preVersion", "LONG");
        stringBuilder.append(" preVersion LONG");
        stringBuilder.append(", ");
        aVar.columns[5] = "retryinterval";
        aVar.xrT.put("retryinterval", "INTEGER");
        stringBuilder.append(" retryinterval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "reportid";
        aVar.xrT.put("reportid", "INTEGER");
        stringBuilder.append(" reportid INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "successkey";
        aVar.xrT.put("successkey", "INTEGER");
        stringBuilder.append(" successkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "failkey";
        aVar.xrT.put("failkey", "INTEGER");
        stringBuilder.append(" failkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "finalfailkey";
        aVar.xrT.put("finalfailkey", "INTEGER");
        stringBuilder.append(" finalfailkey INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "custombuff";
        aVar.xrT.put("custombuff", "TEXT");
        stringBuilder.append(" custombuff TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "addMsg";
        aVar.xrT.put("addMsg", "BLOB");
        stringBuilder.append(" addMsg BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER default '-1' ");
        stringBuilder.append(" status INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "needShow";
        aVar.xrT.put("needShow", "INTEGER default 'false' ");
        stringBuilder.append(" needShow INTEGER default 'false' ");
        aVar.columns[14] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void b(bx bxVar) {
        if (bxVar != null) {
            this.field_addMsg = bxVar;
        }
    }
}
