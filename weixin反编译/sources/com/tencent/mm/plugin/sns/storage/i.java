package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.f.b.dn;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class i extends dn {
    protected static a gKN;
    public int ruQ;

    static {
        a aVar = new a();
        aVar.hUM = new Field[13];
        aVar.columns = new String[14];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsID";
        aVar.xrT.put("snsID", "LONG");
        stringBuilder.append(" snsID LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "parentID";
        aVar.xrT.put("parentID", "LONG");
        stringBuilder.append(" parentID LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = "isRead";
        aVar.xrT.put("isRead", "SHORT default '0' ");
        stringBuilder.append(" isRead SHORT default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xrT.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "talker";
        aVar.xrT.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSend";
        aVar.xrT.put("isSend", "INTEGER default 'false' ");
        stringBuilder.append(" isSend INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "curActionBuf";
        aVar.xrT.put("curActionBuf", "BLOB");
        stringBuilder.append(" curActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[8] = "refActionBuf";
        aVar.xrT.put("refActionBuf", "BLOB");
        stringBuilder.append(" refActionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[9] = "commentSvrID";
        aVar.xrT.put("commentSvrID", "LONG");
        stringBuilder.append(" commentSvrID LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = ClientInfoTable.Columns.CLIENTID;
        aVar.xrT.put(ClientInfoTable.Columns.CLIENTID, "TEXT");
        stringBuilder.append(" clientId TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "commentflag";
        aVar.xrT.put("commentflag", "INTEGER");
        stringBuilder.append(" commentflag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "isSilence";
        aVar.xrT.put("isSilence", "INTEGER default '0' ");
        stringBuilder.append(" isSilence INTEGER default '0' ");
        aVar.columns[13] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            this.ruQ = (int) this.xrR;
        } catch (Exception e) {
            String message = e.getMessage();
            x.e("MicroMsg.SnsComment", "error " + message);
            if (message != null && message.contains("Unable to convert")) {
                ae.bwk().byN();
            }
            throw e;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsComment", e2, "", new Object[0]);
        }
    }

    public final void byJ() {
        this.field_commentflag |= 1;
    }
}
