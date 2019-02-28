package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.f.b.el;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class d extends el {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "recordId";
        aVar.xrT.put("recordId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" recordId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "recordId";
        aVar.columns[1] = "link";
        aVar.xrT.put("link", "TEXT");
        stringBuilder.append(" link TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "title";
        aVar.xrT.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "source";
        aVar.xrT.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "imgUrl";
        aVar.xrT.put("imgUrl", "TEXT");
        stringBuilder.append(" imgUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "timeStamp";
        aVar.xrT.put("timeStamp", "LONG");
        stringBuilder.append(" timeStamp LONG");
        aVar.columns[6] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
