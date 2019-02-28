package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fRm = "openId".hashCode();
    private static final int fUA = "headImgUrl".hashCode();
    private static final int fUB = "nickname".hashCode();
    private static final int fUC = "kfType".hashCode();
    private static final int fUz = "brandUsername".hashCode();
    private boolean fPY = true;
    private boolean fQP = true;
    private boolean fUv = true;
    private boolean fUw = true;
    private boolean fUx = true;
    private boolean fUy = true;
    public String field_brandUsername;
    public String field_headImgUrl;
    public int field_kfType;
    public String field_nickname;
    public String field_openId;
    public long field_updateTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fRm == hashCode) {
                    this.field_openId = cursor.getString(i);
                    this.fQP = true;
                } else if (fUz == hashCode) {
                    this.field_brandUsername = cursor.getString(i);
                } else if (fUA == hashCode) {
                    this.field_headImgUrl = cursor.getString(i);
                } else if (fUB == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (fUC == hashCode) {
                    this.field_kfType = cursor.getInt(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fQP) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.field_brandUsername == null) {
            this.field_brandUsername = "";
        }
        if (this.fUv) {
            contentValues.put("brandUsername", this.field_brandUsername);
        }
        if (this.fUw) {
            contentValues.put("headImgUrl", this.field_headImgUrl);
        }
        if (this.fUx) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fUy) {
            contentValues.put("kfType", Integer.valueOf(this.field_kfType));
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
