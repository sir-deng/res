package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bw extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int ghp = "wechatUsername".hashCode();
    private static final int ghq = "systemAddressBookUsername".hashCode();
    private static final int ghr = "contactId".hashCode();
    private static final int ghs = "sortKey".hashCode();
    public String field_contactId;
    public String field_sortKey;
    public String field_systemAddressBookUsername;
    public String field_wechatUsername;
    private boolean ghl = true;
    private boolean ghm = true;
    private boolean ghn = true;
    private boolean gho = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ghp == hashCode) {
                    this.field_wechatUsername = cursor.getString(i);
                } else if (ghq == hashCode) {
                    this.field_systemAddressBookUsername = cursor.getString(i);
                } else if (ghr == hashCode) {
                    this.field_contactId = cursor.getString(i);
                } else if (ghs == hashCode) {
                    this.field_sortKey = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.ghl) {
            contentValues.put("wechatUsername", this.field_wechatUsername);
        }
        if (this.ghm) {
            contentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
        }
        if (this.ghn) {
            contentValues.put("contactId", this.field_contactId);
        }
        if (this.gho) {
            contentValues.put("sortKey", this.field_sortKey);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
