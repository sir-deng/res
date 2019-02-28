package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class v extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fSC = "brandUserName".hashCode();
    private static final int fSL = "chatType".hashCode();
    private static final int fTb = "bizChatLocalId".hashCode();
    private static final int fTc = "bizChatServId".hashCode();
    private static final int fTd = "headImageUrl".hashCode();
    private static final int fTe = "chatName".hashCode();
    private static final int fTf = "chatNamePY".hashCode();
    private static final int fTg = "chatVersion".hashCode();
    private static final int fTh = "needToUpdate".hashCode();
    private static final int fTi = "bitFlag".hashCode();
    private static final int fTj = "maxMemberCnt".hashCode();
    private static final int fTk = "ownerUserId".hashCode();
    private static final int fTl = "userList".hashCode();
    private static final int fTm = "addMemberUrl".hashCode();
    private boolean fSP = true;
    private boolean fSQ = true;
    private boolean fSR = true;
    private boolean fSS = true;
    private boolean fST = true;
    private boolean fSU = true;
    private boolean fSV = true;
    private boolean fSW = true;
    private boolean fSX = true;
    private boolean fSY = true;
    private boolean fSZ = true;
    private boolean fSo = true;
    private boolean fSx = true;
    private boolean fTa = true;
    public String field_addMemberUrl;
    public int field_bitFlag;
    public long field_bizChatLocalId;
    public String field_bizChatServId;
    public String field_brandUserName;
    public String field_chatName;
    public String field_chatNamePY;
    public int field_chatType;
    public int field_chatVersion;
    public String field_headImageUrl;
    public int field_maxMemberCnt;
    public boolean field_needToUpdate;
    public String field_ownerUserId;
    public String field_userList;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fTb == hashCode) {
                    this.field_bizChatLocalId = cursor.getLong(i);
                    this.fSP = true;
                } else if (fTc == hashCode) {
                    this.field_bizChatServId = cursor.getString(i);
                } else if (fSC == hashCode) {
                    this.field_brandUserName = cursor.getString(i);
                } else if (fSL == hashCode) {
                    this.field_chatType = cursor.getInt(i);
                } else if (fTd == hashCode) {
                    this.field_headImageUrl = cursor.getString(i);
                } else if (fTe == hashCode) {
                    this.field_chatName = cursor.getString(i);
                } else if (fTf == hashCode) {
                    this.field_chatNamePY = cursor.getString(i);
                } else if (fTg == hashCode) {
                    this.field_chatVersion = cursor.getInt(i);
                } else if (fTh == hashCode) {
                    this.field_needToUpdate = cursor.getInt(i) != 0;
                } else if (fTi == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (fTj == hashCode) {
                    this.field_maxMemberCnt = cursor.getInt(i);
                } else if (fTk == hashCode) {
                    this.field_ownerUserId = cursor.getString(i);
                } else if (fTl == hashCode) {
                    this.field_userList = cursor.getString(i);
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
        if (this.fSP) {
            contentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
        }
        if (this.fSQ) {
            contentValues.put("bizChatServId", this.field_bizChatServId);
        }
        if (this.field_brandUserName == null) {
            this.field_brandUserName = "";
        }
        if (this.fSo) {
            contentValues.put("brandUserName", this.field_brandUserName);
        }
        if (this.fSx) {
            contentValues.put("chatType", Integer.valueOf(this.field_chatType));
        }
        if (this.fSR) {
            contentValues.put("headImageUrl", this.field_headImageUrl);
        }
        if (this.field_chatName == null) {
            this.field_chatName = "";
        }
        if (this.fSS) {
            contentValues.put("chatName", this.field_chatName);
        }
        if (this.field_chatNamePY == null) {
            this.field_chatNamePY = "";
        }
        if (this.fST) {
            contentValues.put("chatNamePY", this.field_chatNamePY);
        }
        if (this.fSU) {
            contentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
        }
        if (this.fSV) {
            contentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
        }
        if (this.fSW) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.fSX) {
            contentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
        }
        if (this.fSY) {
            contentValues.put("ownerUserId", this.field_ownerUserId);
        }
        if (this.fSZ) {
            contentValues.put("userList", this.field_userList);
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
