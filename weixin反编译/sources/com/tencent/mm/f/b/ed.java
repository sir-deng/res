package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int gvd = "wallet_tpa_country".hashCode();
    private static final int gve = "wallet_type".hashCode();
    private static final int gvf = "wallet_name".hashCode();
    private static final int gvg = "wallet_selected".hashCode();
    private static final int gvh = "wallet_balance".hashCode();
    private static final int gvi = "wallet_tpa_country_mask".hashCode();
    public int field_wallet_balance;
    public String field_wallet_name;
    public int field_wallet_selected;
    public String field_wallet_tpa_country;
    public int field_wallet_tpa_country_mask;
    public int field_wallet_type;
    private boolean guX = true;
    private boolean guY = true;
    private boolean guZ = true;
    private boolean gva = true;
    private boolean gvb = true;
    private boolean gvc = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gvd == hashCode) {
                    this.field_wallet_tpa_country = cursor.getString(i);
                    this.guX = true;
                } else if (gve == hashCode) {
                    this.field_wallet_type = cursor.getInt(i);
                } else if (gvf == hashCode) {
                    this.field_wallet_name = cursor.getString(i);
                } else if (gvg == hashCode) {
                    this.field_wallet_selected = cursor.getInt(i);
                } else if (gvh == hashCode) {
                    this.field_wallet_balance = cursor.getInt(i);
                } else if (gvi == hashCode) {
                    this.field_wallet_tpa_country_mask = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.guX) {
            contentValues.put("wallet_tpa_country", this.field_wallet_tpa_country);
        }
        if (this.guY) {
            contentValues.put("wallet_type", Integer.valueOf(this.field_wallet_type));
        }
        if (this.guZ) {
            contentValues.put("wallet_name", this.field_wallet_name);
        }
        if (this.gva) {
            contentValues.put("wallet_selected", Integer.valueOf(this.field_wallet_selected));
        }
        if (this.gvb) {
            contentValues.put("wallet_balance", Integer.valueOf(this.field_wallet_balance));
        }
        if (this.gvc) {
            contentValues.put("wallet_tpa_country_mask", Integer.valueOf(this.field_wallet_tpa_country_mask));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
