package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class ci extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOQ = "userName".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int gkU = "wxGroupId".hashCode();
    private static final int gkY = "inviteUserName".hashCode();
    private static final int glc = "memberUuid".hashCode();
    private static final int gld = "memberId".hashCode();
    private boolean fNR = true;
    private boolean fOu = true;
    private boolean fOw = true;
    public long field_createTime;
    public String field_inviteUserName;
    public long field_memberId;
    public long field_memberUuid;
    public int field_status;
    public String field_userName;
    public String field_wxGroupId;
    private boolean gkO = true;
    private boolean gkS = true;
    private boolean gla = true;
    private boolean glb = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (glc == hashCode) {
                    this.field_memberUuid = cursor.getLong(i);
                } else if (gkU == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                } else if (fOQ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (gkY == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (gld == hashCode) {
                    this.field_memberId = cursor.getLong(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gla) {
            contentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
        }
        if (this.gkO) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.fOu) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.gkS) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.glb) {
            contentValues.put("memberId", Long.valueOf(this.field_memberId));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
