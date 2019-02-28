package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.f.b.cx;
import com.tencent.mm.plugin.appbrand.p.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.util.Locale;

public final class w extends cx implements b {
    static final String[] iHh = new String[]{"appId", Columns.TYPE, "version"};
    static final a iHk;

    public final String[] getKeys() {
        return iHh;
    }

    protected final a Aj() {
        return iHk;
    }

    static {
        int i = 0;
        a aVar = new a();
        aVar.hUM = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "version";
        aVar.xrT.put("version", "INTEGER");
        stringBuilder.append(" version INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "pkgMd5";
        aVar.xrT.put("pkgMd5", "TEXT");
        stringBuilder.append(" pkgMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "pkgPath";
        aVar.xrT.put("pkgPath", "TEXT");
        stringBuilder.append(" pkgPath TEXT");
        aVar.columns[5] = "rowid";
        aVar.xrU = stringBuilder.toString();
        iHk = aVar;
        String str = " PRIMARY KEY ( ";
        String[] strArr = iHh;
        int length = strArr.length;
        while (i < length) {
            str = str + ", " + strArr[i];
            i++;
        }
        String str2 = str.replaceFirst(",", "") + " )";
        StringBuilder stringBuilder2 = new StringBuilder();
        a aVar2 = iHk;
        aVar2.xrU = stringBuilder2.append(aVar2.xrU).append(",").append(str2).toString();
    }

    public final String toShortString() {
        return String.format(Locale.US, "EncryptPkgInfo[%s %d %d]", new Object[]{this.field_appId, Integer.valueOf(this.field_type), Integer.valueOf(this.field_version)});
    }
}
