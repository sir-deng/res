package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.f.b.ee;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class y extends ee {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "mNativeUrl";
        aVar.xrT.put("mNativeUrl", "TEXT PRIMARY KEY ");
        stringBuilder.append(" mNativeUrl TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "mNativeUrl";
        aVar.columns[1] = "hbType";
        aVar.xrT.put("hbType", "INTEGER");
        stringBuilder.append(" hbType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "receiveAmount";
        aVar.xrT.put("receiveAmount", "LONG");
        stringBuilder.append(" receiveAmount LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "receiveTime";
        aVar.xrT.put("receiveTime", "LONG");
        stringBuilder.append(" receiveTime LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "receiveStatus";
        aVar.xrT.put("receiveStatus", "INTEGER");
        stringBuilder.append(" receiveStatus INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hbStatus";
        aVar.xrT.put("hbStatus", "INTEGER");
        stringBuilder.append(" hbStatus INTEGER");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
