package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int guS = "wallet_region".hashCode();
    private static final int guT = "function_list".hashCode();
    private static final int guU = "new_list".hashCode();
    private static final int guV = "banner_list".hashCode();
    private static final int guW = "type_name_list".hashCode();
    public String field_banner_list;
    public String field_function_list;
    public String field_new_list;
    public String field_type_name_list;
    public int field_wallet_region;
    private boolean guN = true;
    private boolean guO = true;
    private boolean guP = true;
    private boolean guQ = true;
    private boolean guR = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guS == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.guN = true;
                } else if (guT == hashCode) {
                    this.field_function_list = cursor.getString(i);
                } else if (guU == hashCode) {
                    this.field_new_list = cursor.getString(i);
                } else if (guV == hashCode) {
                    this.field_banner_list = cursor.getString(i);
                } else if (guW == hashCode) {
                    this.field_type_name_list = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.guN) {
            contentValues.put("wallet_region", Integer.valueOf(this.field_wallet_region));
        }
        if (this.guO) {
            contentValues.put("function_list", this.field_function_list);
        }
        if (this.guP) {
            contentValues.put("new_list", this.field_new_list);
        }
        if (this.guQ) {
            contentValues.put("banner_list", this.field_banner_list);
        }
        if (this.guR) {
            contentValues.put("type_name_list", this.field_type_name_list);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
