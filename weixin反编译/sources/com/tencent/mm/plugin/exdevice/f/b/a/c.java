package com.tencent.mm.plugin.exdevice.f.b.a;

import com.tencent.mm.f.b.bu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bu {
    public static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appusername";
        aVar.xrT.put("appusername", "TEXT");
        stringBuilder.append(" appusername TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "rankID";
        aVar.xrT.put("rankID", "TEXT");
        stringBuilder.append(" rankID TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "username";
        aVar.xrT.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "step";
        aVar.xrT.put("step", "INTEGER");
        stringBuilder.append(" step INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "sort";
        aVar.xrT.put("sort", "INTEGER default '0' ");
        stringBuilder.append(" sort INTEGER default '0' ");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final String toString() {
        return ("{" + "username: " + this.field_username + " step: " + this.field_step + " rankId: " + this.field_rankID + " appname: " + this.field_appusername) + "}";
    }
}
