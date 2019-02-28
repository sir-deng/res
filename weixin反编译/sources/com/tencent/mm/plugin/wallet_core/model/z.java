package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.f.b.ef;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class z extends ef {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[4];
        aVar.columns = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "pref_key";
        aVar.xrT.put("pref_key", "TEXT PRIMARY KEY ");
        stringBuilder.append(" pref_key TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "pref_key";
        aVar.columns[1] = "pref_title";
        aVar.xrT.put("pref_title", "TEXT");
        stringBuilder.append(" pref_title TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "pref_url";
        aVar.xrT.put("pref_url", "TEXT");
        stringBuilder.append(" pref_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "is_show";
        aVar.xrT.put("is_show", "INTEGER default '1' ");
        stringBuilder.append(" is_show INTEGER default '1' ");
        aVar.columns[4] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
