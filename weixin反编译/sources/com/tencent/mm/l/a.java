package com.tencent.mm.l;

import com.tencent.mm.f.b.ak;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class a extends ak {
    public static com.tencent.mm.sdk.e.c.a gKN;
    public static final String gKQ = null;

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hUM = new Field[25];
        aVar.columns = new String[26];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgCount";
        aVar.xrT.put("msgCount", "INTEGER default '0' ");
        stringBuilder.append(" msgCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[1] = "username";
        aVar.xrT.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "username";
        aVar.columns[2] = "unReadCount";
        aVar.xrT.put("unReadCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "chatmode";
        aVar.xrT.put("chatmode", "INTEGER default '0' ");
        stringBuilder.append(" chatmode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[4] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER default '0' ");
        stringBuilder.append(" status INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "isSend";
        aVar.xrT.put("isSend", "INTEGER default '0' ");
        stringBuilder.append(" isSend INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "conversationTime";
        aVar.xrT.put("conversationTime", "LONG default '0' ");
        stringBuilder.append(" conversationTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "content";
        aVar.xrT.put("content", "TEXT default '' ");
        stringBuilder.append(" content TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[8] = "msgType";
        aVar.xrT.put("msgType", "TEXT default '' ");
        stringBuilder.append(" msgType TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "customNotify";
        aVar.xrT.put("customNotify", "TEXT default '' ");
        stringBuilder.append(" customNotify TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "showTips";
        aVar.xrT.put("showTips", "INTEGER default '0' ");
        stringBuilder.append(" showTips INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "flag";
        aVar.xrT.put("flag", "LONG default '0' ");
        stringBuilder.append(" flag LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "digest";
        aVar.xrT.put("digest", "TEXT default '' ");
        stringBuilder.append(" digest TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "digestUser";
        aVar.xrT.put("digestUser", "TEXT default '' ");
        stringBuilder.append(" digestUser TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "hasTrunc";
        aVar.xrT.put("hasTrunc", "INTEGER default '0' ");
        stringBuilder.append(" hasTrunc INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "parentRef";
        aVar.xrT.put("parentRef", "TEXT");
        stringBuilder.append(" parentRef TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "attrflag";
        aVar.xrT.put("attrflag", "INTEGER default '0' ");
        stringBuilder.append(" attrflag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "editingMsg";
        aVar.xrT.put("editingMsg", "TEXT default '' ");
        stringBuilder.append(" editingMsg TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "atCount";
        aVar.xrT.put("atCount", "INTEGER default '0' ");
        stringBuilder.append(" atCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "sightTime";
        aVar.xrT.put("sightTime", "LONG default '0' ");
        stringBuilder.append(" sightTime LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "unReadMuteCount";
        aVar.xrT.put("unReadMuteCount", "INTEGER default '0' ");
        stringBuilder.append(" unReadMuteCount INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "lastSeq";
        aVar.xrT.put("lastSeq", "LONG");
        stringBuilder.append(" lastSeq LONG");
        stringBuilder.append(", ");
        aVar.columns[22] = "UnDeliverCount";
        aVar.xrT.put("UnDeliverCount", "INTEGER");
        stringBuilder.append(" UnDeliverCount INTEGER");
        stringBuilder.append(", ");
        aVar.columns[23] = "UnReadInvite";
        aVar.xrT.put("UnReadInvite", "INTEGER");
        stringBuilder.append(" UnReadInvite INTEGER");
        stringBuilder.append(", ");
        aVar.columns[24] = "firstUnDeliverSeq";
        aVar.xrT.put("firstUnDeliverSeq", "LONG");
        stringBuilder.append(" firstUnDeliverSeq LONG");
        aVar.columns[25] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final com.tencent.mm.sdk.e.c.a Aj() {
        return gKN;
    }

    public a(String str) {
        setUsername(str);
    }

    public final void gc(int i) {
        eU(this.field_attrflag | i);
    }

    public final void Bb() {
        eU(this.field_attrflag & -16777217);
    }

    public final boolean gd(int i) {
        return (this.field_attrflag & i) != 0;
    }
}
