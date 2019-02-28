package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fWK = "conRemark".hashCode();
    private static final int fWU = "encryptUsername".hashCode();
    private static final int gso = "contactLabels".hashCode();
    private static final int gsp = "conDescription".hashCode();
    private static final int gsq = "conPhone".hashCode();
    private boolean fWE = true;
    private boolean fWu = true;
    public String field_conDescription;
    public String field_conPhone;
    public String field_conRemark;
    public String field_contactLabels;
    public String field_encryptUsername;
    private boolean gsl = true;
    private boolean gsm = true;
    private boolean gsn = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fWU == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                    this.fWE = true;
                } else if (fWK == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (gso == hashCode) {
                    this.field_contactLabels = cursor.getString(i);
                } else if (gsp == hashCode) {
                    this.field_conDescription = cursor.getString(i);
                } else if (gsq == hashCode) {
                    this.field_conPhone = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fWE) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.fWu) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_contactLabels == null) {
            this.field_contactLabels = "";
        }
        if (this.gsl) {
            contentValues.put("contactLabels", this.field_contactLabels);
        }
        if (this.field_conDescription == null) {
            this.field_conDescription = "";
        }
        if (this.gsm) {
            contentValues.put("conDescription", this.field_conDescription);
        }
        if (this.field_conPhone == null) {
            this.field_conPhone = "";
        }
        if (this.gsn) {
            contentValues.put("conPhone", this.field_conPhone);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
