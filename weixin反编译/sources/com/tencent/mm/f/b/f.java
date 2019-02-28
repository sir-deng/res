package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public abstract class f extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOQ = "userName".hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int fPo = "ticket".hashCode();
    private boolean fOu = true;
    private boolean fPl = true;
    private boolean fPm = true;
    public int field_scene;
    public String field_ticket;
    public String field_userName;

    public static a vQ() {
        a aVar = new a();
        aVar.hUM = new Field[3];
        aVar.columns = new String[4];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "userName";
        aVar.xrT.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "scene";
        aVar.xrT.put("scene", "INTEGER");
        stringBuilder.append(" scene INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "ticket";
        aVar.xrT.put("ticket", "TEXT");
        stringBuilder.append(" ticket TEXT");
        aVar.columns[3] = "rowid";
        aVar.xrU = stringBuilder.toString();
        return aVar;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOQ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fPo == hashCode) {
                    this.field_ticket = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fOu) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.fPm) {
            contentValues.put("ticket", this.field_ticket);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
