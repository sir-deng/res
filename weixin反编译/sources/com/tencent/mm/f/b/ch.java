package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ch extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int gam = "state".hashCode();
    private static final int gat = "groupId".hashCode();
    private static final int gkU = "wxGroupId".hashCode();
    private static final int gkV = "roomId".hashCode();
    private static final int gkW = "roomKey".hashCode();
    private static final int gkX = "routeId".hashCode();
    private static final int gkY = "inviteUserName".hashCode();
    private static final int gkZ = "memberCount".hashCode();
    private boolean fOw = true;
    private boolean fZN = true;
    private boolean fZU = true;
    public long field_createTime;
    public String field_groupId;
    public String field_inviteUserName;
    public int field_memberCount;
    public int field_roomId;
    public long field_roomKey;
    public int field_routeId;
    public int field_state;
    public String field_wxGroupId;
    private boolean gkO = true;
    private boolean gkP = true;
    private boolean gkQ = true;
    private boolean gkR = true;
    private boolean gkS = true;
    private boolean gkT = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gkU == hashCode) {
                    this.field_wxGroupId = cursor.getString(i);
                    this.gkO = true;
                } else if (gat == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (gkV == hashCode) {
                    this.field_roomId = cursor.getInt(i);
                } else if (gkW == hashCode) {
                    this.field_roomKey = cursor.getLong(i);
                } else if (gkX == hashCode) {
                    this.field_routeId = cursor.getInt(i);
                } else if (gkY == hashCode) {
                    this.field_inviteUserName = cursor.getString(i);
                } else if (gkZ == hashCode) {
                    this.field_memberCount = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gam == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gkO) {
            contentValues.put("wxGroupId", this.field_wxGroupId);
        }
        if (this.fZU) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.gkP) {
            contentValues.put("roomId", Integer.valueOf(this.field_roomId));
        }
        if (this.gkQ) {
            contentValues.put("roomKey", Long.valueOf(this.field_roomKey));
        }
        if (this.gkR) {
            contentValues.put("routeId", Integer.valueOf(this.field_routeId));
        }
        if (this.gkS) {
            contentValues.put("inviteUserName", this.field_inviteUserName);
        }
        if (this.gkT) {
            contentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.fZN) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
