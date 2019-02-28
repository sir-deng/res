package com.tencent.mm.plugin.exdevice.h;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.br;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class b extends br {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "deviceID";
        aVar.xrT.put("deviceID", "TEXT PRIMARY KEY ");
        stringBuilder.append(" deviceID TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "deviceID";
        aVar.columns[1] = "brandName";
        aVar.xrT.put("brandName", "TEXT");
        stringBuilder.append(" brandName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mac";
        aVar.xrT.put("mac", "LONG");
        stringBuilder.append(" mac LONG");
        stringBuilder.append(", ");
        aVar.columns[3] = "deviceType";
        aVar.xrT.put("deviceType", "TEXT");
        stringBuilder.append(" deviceType TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connProto";
        aVar.xrT.put("connProto", "TEXT");
        stringBuilder.append(" connProto TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "connStrategy";
        aVar.xrT.put("connStrategy", "INTEGER");
        stringBuilder.append(" connStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "closeStrategy";
        aVar.xrT.put("closeStrategy", "INTEGER");
        stringBuilder.append(" closeStrategy INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "md5Str";
        aVar.xrT.put("md5Str", "TEXT");
        stringBuilder.append(" md5Str TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "authKey";
        aVar.xrT.put("authKey", "TEXT");
        stringBuilder.append(" authKey TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xrT.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "sessionKey";
        aVar.xrT.put("sessionKey", "BLOB");
        stringBuilder.append(" sessionKey BLOB");
        stringBuilder.append(", ");
        aVar.columns[11] = "sessionBuf";
        aVar.xrT.put("sessionBuf", "BLOB");
        stringBuilder.append(" sessionBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "authBuf";
        aVar.xrT.put("authBuf", "BLOB");
        stringBuilder.append(" authBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuffer";
        aVar.xrT.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        aVar.columns[14] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
