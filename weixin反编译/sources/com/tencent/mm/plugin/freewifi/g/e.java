package com.tencent.mm.plugin.freewifi.g;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.f.b.bi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class e extends bi {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xrT.put(SlookAirButtonFrequentContactAdapter.ID, "TEXT PRIMARY KEY ");
        stringBuilder.append(" id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = SlookAirButtonFrequentContactAdapter.ID;
        aVar.columns[1] = "protocolNumber";
        aVar.xrT.put("protocolNumber", "INTEGER");
        stringBuilder.append(" protocolNumber INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "logContent";
        aVar.xrT.put("logContent", "TEXT");
        stringBuilder.append(" logContent TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
