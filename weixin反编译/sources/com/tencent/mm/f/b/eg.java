package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eg extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int guS = "wallet_region".hashCode();
    private static final int gvA = "wallet_grey_item_buf".hashCode();
    public byte[] field_wallet_grey_item_buf;
    public int field_wallet_region;
    private boolean guN = true;
    private boolean gvz = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (guS == hashCode) {
                    this.field_wallet_region = cursor.getInt(i);
                    this.guN = true;
                } else if (gvA == hashCode) {
                    this.field_wallet_grey_item_buf = cursor.getBlob(i);
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
        if (this.gvz) {
            contentValues.put("wallet_grey_item_buf", this.field_wallet_grey_item_buf);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
