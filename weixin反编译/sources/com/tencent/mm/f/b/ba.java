package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public abstract class ba extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOe = Columns.VALUE.hashCode();
    private static final int gce = "configId".hashCode();
    private boolean fNW = true;
    public int field_configId;
    public String field_value;
    private boolean gcd = true;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "configId";
        aVar.xrT.put("configId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" configId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xrS = "configId";
        aVar.columns[1] = Columns.VALUE;
        aVar.xrT.put(Columns.VALUE, "TEXT");
        stringBuilder.append(" value TEXT");
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
                if (gce == hashCode) {
                    this.field_configId = cursor.getInt(i);
                    this.gcd = true;
                } else if (fOe == hashCode) {
                    this.field_value = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gcd) {
            contentValues.put("configId", Integer.valueOf(this.field_configId));
        }
        if (this.fNW) {
            contentValues.put(Columns.VALUE, this.field_value);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
