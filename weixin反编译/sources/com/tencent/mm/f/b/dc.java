package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dc extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int fYw = "transferId".hashCode();
    private static final int gov = "locaMsgId".hashCode();
    private static final int gow = "receiveStatus".hashCode();
    private boolean fSy = true;
    private boolean fYv = true;
    public boolean field_isSend;
    public long field_locaMsgId;
    public int field_receiveStatus;
    public String field_transferId;
    private boolean got = true;
    private boolean gou = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYw == hashCode) {
                    this.field_transferId = cursor.getString(i);
                    this.fYv = true;
                } else if (gov == hashCode) {
                    this.field_locaMsgId = cursor.getLong(i);
                } else if (gow == hashCode) {
                    this.field_receiveStatus = cursor.getInt(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fYv) {
            contentValues.put("transferId", this.field_transferId);
        }
        if (this.got) {
            contentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
        }
        if (this.gou) {
            contentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
        }
        if (this.fSy) {
            contentValues.put("isSend", Boolean.valueOf(this.field_isSend));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
