package com.tencent.mm.plugin.appbrand.appstorage;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.f.b.j;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends j {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "key";
        aVar.xrT.put("key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "key";
        aVar.columns[1] = SlookAirButtonFrequentContactAdapter.DATA;
        aVar.xrT.put(SlookAirButtonFrequentContactAdapter.DATA, "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "dataType";
        aVar.xrT.put("dataType", "TEXT");
        stringBuilder.append(" dataType TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "size";
        aVar.xrT.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
