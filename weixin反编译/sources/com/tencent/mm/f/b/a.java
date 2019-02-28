package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a extends c {
    public static final String[] fNF = new String[0];
    private static final int fNK = "payMsgId".hashCode();
    private static final int fNL = "insertmsg".hashCode();
    private static final int fNM = "chatroom".hashCode();
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private boolean fNG = true;
    private boolean fNH = true;
    private boolean fNI = true;
    private boolean fNJ = true;
    public String field_chatroom;
    public boolean field_insertmsg;
    public long field_msgId;
    public String field_payMsgId;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNK == hashCode) {
                    this.field_payMsgId = cursor.getString(i);
                    this.fNG = true;
                } else if (fNL == hashCode) {
                    this.field_insertmsg = cursor.getInt(i) != 0;
                } else if (fNM == hashCode) {
                    this.field_chatroom = cursor.getString(i);
                } else if (fNN == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fNG) {
            contentValues.put("payMsgId", this.field_payMsgId);
        }
        if (this.fNH) {
            contentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
        }
        if (this.fNI) {
            contentValues.put("chatroom", this.field_chatroom);
        }
        if (this.fNJ) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
