package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class x extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOQ = "userName".hashCode();
    private static final int fSC = "brandUserName".hashCode();
    private static final int fTd = "headImageUrl".hashCode();
    private static final int fTh = "needToUpdate".hashCode();
    private static final int fTi = "bitFlag".hashCode();
    private static final int fTm = "addMemberUrl".hashCode();
    private static final int fTo = "userId".hashCode();
    private static final int fTs = "userNamePY".hashCode();
    private static final int fTt = "UserVersion".hashCode();
    private static final int fTu = "profileUrl".hashCode();
    private boolean fOu = true;
    private boolean fSR = true;
    private boolean fSV = true;
    private boolean fSW = true;
    private boolean fSo = true;
    private boolean fTa = true;
    private boolean fTn = true;
    private boolean fTp = true;
    private boolean fTq = true;
    private boolean fTr = true;
    public int field_UserVersion;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public String field_brandUserName;
    public String field_headImageUrl;
    public boolean field_needToUpdate;
    public String field_profileUrl;
    public String field_userId;
    public String field_userName;
    public String field_userNamePY;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fTo == hashCode) {
                    this.field_userId = cursor.getString(i);
                    this.fTn = true;
                } else if (fOQ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (fTs == hashCode) {
                    this.field_userNamePY = cursor.getString(i);
                } else if (fSC == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (fTt == hashCode) {
                    this.field_UserVersion = cursor.getInt(i);
                } else if (fTh == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (fTd == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (fTu == hashCode) {
                    this.field_profileUrl = cursor.getString(i);
                } else if (fTi == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (fTm == hashCode) {
                    this.field_addMemberUrl = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fTn) {
            contentValues.put("userId", this.field_userId);
        }
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.fOu) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.field_userNamePY == null) {
            this.field_userNamePY = "";
        }
        if (this.fTp) {
            contentValues.put("userNamePY", this.field_userNamePY);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.fSo) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fTq) {
            contentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
        }
        if (this.fSV) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.fSR) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.fTr) {
            contentValues.put("profileUrl", this.field_profileUrl);
        }
        if (this.fSW) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.fTa) {
            contentValues.put("addMemberUrl", this.field_addMemberUrl);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
