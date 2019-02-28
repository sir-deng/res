package com.tencent.mm.plugin.freewifi.g;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.b.bh;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class c extends bh {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[14];
        aVar.columns = new String[15];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "ssidmd5";
        aVar.xrT.put("ssidmd5", "TEXT PRIMARY KEY ");
        stringBuilder.append(" ssidmd5 TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "ssidmd5";
        aVar.columns[1] = "ssid";
        aVar.xrT.put("ssid", "TEXT");
        stringBuilder.append(" ssid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "mid";
        aVar.xrT.put("mid", "TEXT");
        stringBuilder.append(" mid TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = SlookSmartClipMetaTag.TAG_TYPE_URL;
        aVar.xrT.put(SlookSmartClipMetaTag.TAG_TYPE_URL, "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "connectState";
        aVar.xrT.put("connectState", "INTEGER default '-1' ");
        stringBuilder.append(" connectState INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "expiredTime";
        aVar.xrT.put("expiredTime", "LONG");
        stringBuilder.append(" expiredTime LONG");
        stringBuilder.append(", ");
        aVar.columns[6] = "wifiType";
        aVar.xrT.put("wifiType", "INTEGER default '1' ");
        stringBuilder.append(" wifiType INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "action";
        aVar.xrT.put("action", "INTEGER default '0' ");
        stringBuilder.append(" action INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "showUrl";
        aVar.xrT.put("showUrl", "TEXT");
        stringBuilder.append(" showUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "showWordEn";
        aVar.xrT.put("showWordEn", "TEXT");
        stringBuilder.append(" showWordEn TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "showWordCn";
        aVar.xrT.put("showWordCn", "TEXT");
        stringBuilder.append(" showWordCn TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "showWordTw";
        aVar.xrT.put("showWordTw", "TEXT");
        stringBuilder.append(" showWordTw TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "mac";
        aVar.xrT.put("mac", "TEXT");
        stringBuilder.append(" mac TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "verifyResult";
        aVar.xrT.put("verifyResult", "INTEGER default '1' ");
        stringBuilder.append(" verifyResult INTEGER default '1' ");
        aVar.columns[14] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
