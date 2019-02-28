package com.tencent.mm.plugin.card.model;

import com.tencent.mm.f.b.ad;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class i extends ad {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "card_id";
        aVar.xrT.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "card_id";
        aVar.columns[1] = "lower_bound";
        aVar.xrT.put("lower_bound", "INTEGER");
        stringBuilder.append(" lower_bound INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "need_insert_show_timestamp";
        aVar.xrT.put("need_insert_show_timestamp", "INTEGER default 'false' ");
        stringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "show_timestamp_encrypt_key";
        aVar.xrT.put("show_timestamp_encrypt_key", "TEXT");
        stringBuilder.append(" show_timestamp_encrypt_key TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "expire_time_interval";
        aVar.xrT.put("expire_time_interval", "INTEGER");
        stringBuilder.append(" expire_time_interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "show_expire_interval";
        aVar.xrT.put("show_expire_interval", "INTEGER");
        stringBuilder.append(" show_expire_interval INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "fetch_time";
        aVar.xrT.put("fetch_time", "LONG");
        stringBuilder.append(" fetch_time LONG");
        aVar.columns[7] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
