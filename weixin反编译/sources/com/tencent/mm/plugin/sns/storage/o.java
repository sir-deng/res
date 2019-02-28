package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.f.b.dq;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class o extends dq {
    protected static a gKN;
    public int ruM;

    static {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logtime";
        aVar.xrT.put("logtime", "LONG");
        stringBuilder.append(" logtime LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "offset";
        aVar.xrT.put("offset", "INTEGER default '0' ");
        stringBuilder.append(" offset INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "logsize";
        aVar.xrT.put("logsize", "INTEGER");
        stringBuilder.append(" logsize INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "errorcount";
        aVar.xrT.put("errorcount", "INTEGER");
        stringBuilder.append(" errorcount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = Columns.VALUE;
        aVar.xrT.put(Columns.VALUE, "BLOB");
        stringBuilder.append(" value BLOB");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.ruM = (int) this.xrR;
        } catch (Exception e) {
            String message = e.getMessage();
            x.e("MicroMsg.SnsKvReport", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ae.bwk().byN();
            }
            throw e;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsKvReport", e2, "", new Object[0]);
        }
    }
}
