package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class s extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fSj = "sessionName".hashCode();
    private static final int fSm = "msgListDataId".hashCode();
    private boolean fSg = true;
    private boolean fSl = true;
    public String field_msgListDataId;
    public String field_sessionName;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSm == hashCode) {
                    this.field_msgListDataId = cursor.getString(i);
                    this.fSl = true;
                } else if (fSj == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fSl) {
            contentValues.put("msgListDataId", this.field_msgListDataId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fSg) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
