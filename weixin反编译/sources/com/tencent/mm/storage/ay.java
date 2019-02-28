package com.tencent.mm.storage;

import com.tencent.mm.f.b.ck;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class ay extends ck {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[12];
        aVar.columns = new String[13];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "tipId";
        aVar.xrT.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "tipId";
        aVar.columns[1] = "tipVersion";
        aVar.xrT.put("tipVersion", "INTEGER");
        stringBuilder.append(" tipVersion INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "tipkey";
        aVar.xrT.put("tipkey", "TEXT");
        stringBuilder.append(" tipkey TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "tipType";
        aVar.xrT.put("tipType", "INTEGER");
        stringBuilder.append(" tipType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isExit";
        aVar.xrT.put("isExit", "INTEGER");
        stringBuilder.append(" isExit INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "hadRead";
        aVar.xrT.put("hadRead", "INTEGER");
        stringBuilder.append(" hadRead INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "isReject";
        aVar.xrT.put("isReject", "INTEGER");
        stringBuilder.append(" isReject INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "beginShowTime";
        aVar.xrT.put("beginShowTime", "LONG");
        stringBuilder.append(" beginShowTime LONG");
        stringBuilder.append(", ");
        aVar.columns[8] = "disappearTime";
        aVar.xrT.put("disappearTime", "LONG");
        stringBuilder.append(" disappearTime LONG");
        stringBuilder.append(", ");
        aVar.columns[9] = "overdueTime";
        aVar.xrT.put("overdueTime", "LONG");
        stringBuilder.append(" overdueTime LONG");
        stringBuilder.append(", ");
        aVar.columns[10] = "tipsShowInfo";
        aVar.xrT.put("tipsShowInfo", "BLOB");
        stringBuilder.append(" tipsShowInfo BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "extInfo";
        aVar.xrT.put("extInfo", "TEXT");
        stringBuilder.append(" extInfo TEXT");
        aVar.columns[12] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
