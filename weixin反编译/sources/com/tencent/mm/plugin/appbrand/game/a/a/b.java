package com.tencent.mm.plugin.appbrand.game.a.a;

import com.tencent.mm.f.b.ev;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends ev {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[9];
        aVar.columns = new String[10];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "RecordId";
        aVar.xrT.put("RecordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" RecordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "RecordId";
        aVar.columns[1] = "AppId";
        aVar.xrT.put("AppId", "TEXT");
        stringBuilder.append(" AppId TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "AppName";
        aVar.xrT.put("AppName", "TEXT");
        stringBuilder.append(" AppName TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "UserName";
        aVar.xrT.put("UserName", "TEXT");
        stringBuilder.append(" UserName TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "IconUrl";
        aVar.xrT.put("IconUrl", "TEXT");
        stringBuilder.append(" IconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "BriefIntro";
        aVar.xrT.put("BriefIntro", "TEXT");
        stringBuilder.append(" BriefIntro TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "isSync";
        aVar.xrT.put("isSync", "INTEGER default 'false' ");
        stringBuilder.append(" isSync INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "debugType";
        aVar.xrT.put("debugType", "INTEGER");
        stringBuilder.append(" debugType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        aVar.columns[9] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
