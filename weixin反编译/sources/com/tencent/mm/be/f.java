package com.tencent.mm.be;

import com.tencent.mm.f.b.ay;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class f extends ay {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[8];
        aVar.columns = new String[9];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgContent";
        aVar.xrT.put("msgContent", "TEXT default '' ");
        stringBuilder.append(" msgContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "isSend";
        aVar.xrT.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "talker";
        aVar.xrT.put("talker", "TEXT default '' ");
        stringBuilder.append(" talker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "encryptTalker";
        aVar.xrT.put("encryptTalker", "TEXT default '' ");
        stringBuilder.append(" encryptTalker TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "svrId";
        aVar.xrT.put("svrId", "LONG default '0' ");
        stringBuilder.append(" svrId LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xrT.put("createTime", "LONG default '0' ");
        stringBuilder.append(" createTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "chatroomName";
        aVar.xrT.put("chatroomName", "TEXT default '' ");
        stringBuilder.append(" chatroomName TEXT default '' ");
        aVar.columns[8] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final boolean Tv() {
        return this.field_isSend % 2 == 0;
    }
}
