package com.tencent.mm.storage;

import com.tencent.mm.f.b.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c extends d implements Serializable {
    protected static a gKN;
    private Map<String, String> xuK = null;

    static {
        a aVar = new a();
        aVar.hUM = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "layerId";
        aVar.xrT.put("layerId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" layerId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "layerId";
        aVar.columns[1] = "business";
        aVar.xrT.put("business", "TEXT");
        stringBuilder.append(" business TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "expId";
        aVar.xrT.put("expId", "TEXT");
        stringBuilder.append(" expId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "sequence";
        aVar.xrT.put("sequence", "LONG");
        stringBuilder.append(" sequence LONG");
        stringBuilder.append(", ");
        aVar.columns[4] = "prioritylevel";
        aVar.xrT.put("prioritylevel", "INTEGER default '0' ");
        stringBuilder.append(" prioritylevel INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "startTime";
        aVar.xrT.put("startTime", "LONG");
        stringBuilder.append(" startTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "endTime";
        aVar.xrT.put("endTime", "LONG");
        stringBuilder.append(" endTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "needReport";
        aVar.xrT.put("needReport", "INTEGER");
        stringBuilder.append(" needReport INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "rawXML";
        aVar.xrT.put("rawXML", "TEXT default '' ");
        stringBuilder.append(" rawXML TEXT default '' ");
        aVar.columns[9] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final boolean isValid() {
        long Wx = bi.Wx();
        return Wx >= this.field_startTime && Wx <= this.field_endTime;
    }

    public final Map<String, String> civ() {
        if (this.xuK == null) {
            this.xuK = com.tencent.mm.y.c.a.iq(this.field_rawXML);
        }
        return this.xuK;
    }
}
