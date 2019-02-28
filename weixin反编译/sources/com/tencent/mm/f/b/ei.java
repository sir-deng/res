package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class ei extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int gwq = "occupation".hashCode();
    private boolean fPp = true;
    public String field_appId;
    public long field_occupation;
    private boolean gwp = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "appId";
        aVar.xrT.put("appId", "TEXT PRIMARY KEY ");
        stringBuilder.append(" appId TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "appId";
        aVar.columns[1] = "occupation";
        aVar.xrT.put("occupation", "LONG");
        stringBuilder.append(" occupation LONG");
        aVar.columns[2] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.fPp = true;
                } else if (gwq == hashCode) {
                    this.field_occupation = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gwp) {
            contentValues.put("occupation", Long.valueOf(this.field_occupation));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
