package com.tencent.mm.x;

import com.tencent.mm.f.b.cg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public class o extends cg {
    protected static a gKN;

    static {
        a aVar = new a();
        aVar.hUM = new Field[20];
        aVar.columns = new String[21];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xrT.put("msgId", "LONG PRIMARY KEY ");
        stringBuilder.append(" msgId LONG PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "msgId";
        aVar.columns[1] = "msgSvrId";
        aVar.xrT.put("msgSvrId", "LONG");
        stringBuilder.append(" msgSvrId LONG");
        stringBuilder.append(", ");
        aVar.columns[2] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isSend";
        aVar.xrT.put("isSend", "INTEGER");
        stringBuilder.append(" isSend INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "isShowTimer";
        aVar.xrT.put("isShowTimer", "INTEGER");
        stringBuilder.append(" isShowTimer INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "createTime";
        aVar.xrT.put("createTime", "LONG");
        stringBuilder.append(" createTime LONG");
        stringBuilder.append(", ");
        aVar.columns[7] = "talker";
        aVar.xrT.put("talker", "TEXT");
        stringBuilder.append(" talker TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "content";
        aVar.xrT.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "imgPath";
        aVar.xrT.put("imgPath", "TEXT");
        stringBuilder.append(" imgPath TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved";
        aVar.xrT.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "lvbuffer";
        aVar.xrT.put("lvbuffer", "BLOB");
        stringBuilder.append(" lvbuffer BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "talkerId";
        aVar.xrT.put("talkerId", "INTEGER");
        stringBuilder.append(" talkerId INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "transContent";
        aVar.xrT.put("transContent", "TEXT default '' ");
        stringBuilder.append(" transContent TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "transBrandWording";
        aVar.xrT.put("transBrandWording", "TEXT default '' ");
        stringBuilder.append(" transBrandWording TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "bizClientMsgId";
        aVar.xrT.put("bizClientMsgId", "TEXT default '' ");
        stringBuilder.append(" bizClientMsgId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "bizChatId";
        aVar.xrT.put("bizChatId", "LONG default '-1' ");
        stringBuilder.append(" bizChatId LONG default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "bizChatUserId";
        aVar.xrT.put("bizChatUserId", "TEXT default '' ");
        stringBuilder.append(" bizChatUserId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "msgSeq";
        aVar.xrT.put("msgSeq", "LONG");
        stringBuilder.append(" msgSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[19] = "flag";
        aVar.xrT.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        aVar.columns[20] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }
}
