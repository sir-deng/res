package com.tencent.mm.storage.emotion;

import com.tencent.mm.f.b.ar;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends ar {
    protected static a gKN;

    protected final a Aj() {
        return null;
    }

    static {
        a aVar = new a();
        aVar.hUM = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5_lang";
        aVar.xrT.put("md5_lang", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5_lang TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xrS = "md5_lang";
        aVar.columns[1] = "md5";
        aVar.xrT.put("md5", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[2] = "lang";
        aVar.xrT.put("lang", "TEXT COLLATE NOCASE ");
        stringBuilder.append(" lang TEXT COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.columns[3] = "desc";
        aVar.xrT.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "groupId";
        aVar.xrT.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "click_flag";
        aVar.xrT.put("click_flag", "INTEGER");
        stringBuilder.append(" click_flag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "download_flag";
        aVar.xrT.put("download_flag", "INTEGER");
        stringBuilder.append(" download_flag INTEGER");
        aVar.columns[7] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    public final String Nx() {
        return this.field_md5 == null ? "" : this.field_md5;
    }
}
