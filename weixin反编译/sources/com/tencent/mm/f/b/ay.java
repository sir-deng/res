package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ay extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int gbO = "msgContent".hashCode();
    private static final int gbP = "svrId".hashCode();
    private static final int gbQ = "chatroomName".hashCode();
    private static final int gbv = "talker".hashCode();
    private static final int gbw = "encryptTalker".hashCode();
    private boolean fOw = true;
    private boolean fOz = true;
    private boolean fSy = true;
    public String field_chatroomName;
    public long field_createTime;
    public String field_encryptTalker;
    public int field_isSend;
    public String field_msgContent;
    public long field_svrId;
    public String field_talker;
    public int field_type;
    private boolean gbL = true;
    private boolean gbM = true;
    private boolean gbN = true;
    private boolean gbf = true;
    private boolean gbg = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbO == hashCode) {
                    this.field_msgContent = cursor.getString(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (gbv == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (gbw == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (gbP == hashCode) {
                    this.field_svrId = cursor.getLong(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gbQ == hashCode) {
                    this.field_chatroomName = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_msgContent == null) {
            this.field_msgContent = "";
        }
        if (this.gbL) {
            contentValues.put("msgContent", this.field_msgContent);
        }
        if (this.fSy) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.field_talker == null) {
            this.field_talker = "";
        }
        if (this.gbf) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.gbg) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.gbM) {
            contentValues.put("svrId", Long.valueOf(this.field_svrId));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_chatroomName == null) {
            this.field_chatroomName = "";
        }
        if (this.gbN) {
            contentValues.put("chatroomName", this.field_chatroomName);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
