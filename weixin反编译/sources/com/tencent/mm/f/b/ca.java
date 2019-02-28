package com.tencent.mm.f.b;

import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class ca extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int ghN = "logId".hashCode();
    private static final int ghO = "liftTime".hashCode();
    public long field_liftTime;
    public int field_logId;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "logId";
        aVar.xrT.put("logId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" logId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "logId";
        aVar.columns[1] = "liftTime";
        aVar.xrT.put("liftTime", "LONG");
        stringBuilder.append(" liftTime LONG");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }
}
