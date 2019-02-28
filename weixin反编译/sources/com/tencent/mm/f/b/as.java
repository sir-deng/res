package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gaM = "desc".hashCode();
    private static final int gaQ = "groupID".hashCode();
    public String field_desc;
    public String field_groupID;
    private boolean gaI = true;
    private boolean gaP = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaQ == hashCode) {
                    this.field_groupID = cursor.getString(i);
                } else if (gaM == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gaP) {
            contentValues.put("groupID", this.field_groupID);
        }
        if (this.gaI) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
