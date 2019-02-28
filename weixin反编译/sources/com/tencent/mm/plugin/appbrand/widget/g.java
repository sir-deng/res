package com.tencent.mm.plugin.appbrand.widget;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.f.b.ao;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class g extends ao {
    public static a iHk;

    static {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = SlookAirButtonFrequentContactAdapter.ID;
        aVar.xrT.put(SlookAirButtonFrequentContactAdapter.ID, "TEXT");
        stringBuilder.append(" id TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "cacheKey";
        aVar.xrT.put("cacheKey", "TEXT");
        stringBuilder.append(" cacheKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookAirButtonFrequentContactAdapter.DATA;
        aVar.xrT.put(SlookAirButtonFrequentContactAdapter.DATA, "TEXT");
        stringBuilder.append(" data TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "interval";
        aVar.xrT.put("interval", "INTEGER");
        stringBuilder.append(" interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "updateTime";
        aVar.xrT.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
    }

    protected final a Aj() {
        return iHk;
    }
}
