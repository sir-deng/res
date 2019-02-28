package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bo extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int gao = "reserved1".hashCode();
    private static final int gap = "reserved2".hashCode();
    private static final int gaq = "reserved3".hashCode();
    private static final int gar = "reserved4".hashCode();
    private static final int gfA = "newMsgId".hashCode();
    private static final int gfB = "fromUserName".hashCode();
    private static final int gfC = "toUserName".hashCode();
    private static final int gfD = "msgSource".hashCode();
    private static final int gfE = "msgSeq".hashCode();
    private static final int gfz = "originSvrId".hashCode();
    private boolean fOE = true;
    private boolean fOw = true;
    private boolean fSb = true;
    private boolean fZP = true;
    private boolean fZQ = true;
    private boolean fZR = true;
    private boolean fZS = true;
    public String field_content;
    public long field_createTime;
    public int field_flag;
    public String field_fromUserName;
    public int field_msgSeq;
    public String field_msgSource;
    public long field_newMsgId;
    public long field_originSvrId;
    public int field_reserved1;
    public long field_reserved2;
    public String field_reserved3;
    public String field_reserved4;
    public String field_toUserName;
    private boolean gft = true;
    private boolean gfu = true;
    private boolean gfv = true;
    private boolean gfw = true;
    private boolean gfx = true;
    private boolean gfy = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gfz == hashCode) {
                    this.field_originSvrId = cursor.getLong(i);
                    this.gft = true;
                } else if (gfA == hashCode) {
                    this.field_newMsgId = cursor.getLong(i);
                } else if (gfB == hashCode) {
                    this.field_fromUserName = cursor.getString(i);
                } else if (gfC == hashCode) {
                    this.field_toUserName = cursor.getString(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gfD == hashCode) {
                    this.field_msgSource = cursor.getString(i);
                } else if (gfE == hashCode) {
                    this.field_msgSeq = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (gao == hashCode) {
                    this.field_reserved1 = cursor.getInt(i);
                } else if (gap == hashCode) {
                    this.field_reserved2 = cursor.getLong(i);
                } else if (gaq == hashCode) {
                    this.field_reserved3 = cursor.getString(i);
                } else if (gar == hashCode) {
                    this.field_reserved4 = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gft) {
            contentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
        }
        if (this.gfu) {
            contentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
        }
        if (this.field_fromUserName == null) {
            this.field_fromUserName = "";
        }
        if (this.gfv) {
            contentValues.put("fromUserName", this.field_fromUserName);
        }
        if (this.field_toUserName == null) {
            this.field_toUserName = "";
        }
        if (this.gfw) {
            contentValues.put("toUserName", this.field_toUserName);
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.field_content == null) {
            this.field_content = "";
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgSource == null) {
            this.field_msgSource = "";
        }
        if (this.gfx) {
            contentValues.put("msgSource", this.field_msgSource);
        }
        if (this.gfy) {
            contentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
        }
        if (this.fSb) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fZP) {
            contentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
        }
        if (this.fZQ) {
            contentValues.put("reserved2", Long.valueOf(this.field_reserved2));
        }
        if (this.field_reserved3 == null) {
            this.field_reserved3 = "";
        }
        if (this.fZR) {
            contentValues.put("reserved3", this.field_reserved3);
        }
        if (this.field_reserved4 == null) {
            this.field_reserved4 = "";
        }
        if (this.fZS) {
            contentValues.put("reserved4", this.field_reserved4);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
