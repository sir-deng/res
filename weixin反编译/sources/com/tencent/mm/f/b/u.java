package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class u extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fSB = "bizChatId".hashCode();
    private static final int fSC = "brandUserName".hashCode();
    private static final int fSD = "unReadCount".hashCode();
    private static final int fSE = "newUnReadCount".hashCode();
    private static final int fSF = "lastMsgID".hashCode();
    private static final int fSG = "lastMsgTime".hashCode();
    private static final int fSH = "digest".hashCode();
    private static final int fSI = "digestUser".hashCode();
    private static final int fSJ = "atCount".hashCode();
    private static final int fSK = "editingMsg".hashCode();
    private static final int fSL = "chatType".hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int fSN = "msgType".hashCode();
    private static final int fSO = "msgCount".hashCode();
    private static final int fSd = "flag".hashCode();
    private boolean fNR = true;
    private boolean fOE = true;
    private boolean fSA = true;
    private boolean fSb = true;
    private boolean fSn = true;
    private boolean fSo = true;
    private boolean fSp = true;
    private boolean fSq = true;
    private boolean fSr = true;
    private boolean fSs = true;
    private boolean fSt = true;
    private boolean fSu = true;
    private boolean fSv = true;
    private boolean fSw = true;
    private boolean fSx = true;
    private boolean fSy = true;
    private boolean fSz = true;
    public int field_atCount;
    public long field_bizChatId;
    public String field_brandUserName;
    public int field_chatType;
    public String field_content;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_flag;
    public int field_isSend;
    public long field_lastMsgID;
    public long field_lastMsgTime;
    public int field_msgCount;
    public String field_msgType;
    public int field_newUnReadCount;
    public int field_status;
    public int field_unReadCount;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSB == hashCode) {
                    this.field_bizChatId = cursor.getLong(i);
                    this.fSn = true;
                } else if (fSC == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (fSD == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (fSE == hashCode) {
                    this.field_newUnReadCount = cursor.getInt(i);
                } else if (fSF == hashCode) {
                    this.field_lastMsgID = cursor.getLong(i);
                } else if (fSG == hashCode) {
                    this.field_lastMsgTime = cursor.getLong(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (fSH == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (fSI == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (fSJ == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (fSK == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (fSL == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (fSN == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (fSO == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fSn) {
            contentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
        }
        if (this.fSo) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fSp) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.fSq) {
            contentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
        }
        if (this.fSr) {
            contentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
        }
        if (this.fSs) {
            contentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_digest == null) {
            this.field_digest = "";
        }
        if (this.fSt) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = "";
        }
        if (this.fSu) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.fSv) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.fSw) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.fSx) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fSy) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_msgType == null) {
            this.field_msgType = "";
        }
        if (this.fSz) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.fSA) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.fSb) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
