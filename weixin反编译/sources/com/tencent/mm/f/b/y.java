package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class y extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOQ = "userName".hashCode();
    private static final int fTH = "qyUin".hashCode();
    private static final int fTI = "userUin".hashCode();
    private static final int fTJ = "userFlag".hashCode();
    private static final int fTK = "wwExposeTimes".hashCode();
    private static final int fTL = "wwMaxExposeTimes".hashCode();
    private static final int fTM = "wwCorpId".hashCode();
    private static final int fTN = "wwUserVid".hashCode();
    private static final int fTO = "userType".hashCode();
    private static final int fTP = "chatOpen".hashCode();
    private static final int fTQ = "wwUnreadCnt".hashCode();
    private static final int fTR = "show_confirm".hashCode();
    private static final int fTS = "use_preset_banner_tips".hashCode();
    private boolean fOu = true;
    private boolean fTA = true;
    private boolean fTB = true;
    private boolean fTC = true;
    private boolean fTD = true;
    private boolean fTE = true;
    private boolean fTF = true;
    private boolean fTG = true;
    private boolean fTv = true;
    private boolean fTw = true;
    private boolean fTx = true;
    private boolean fTy = true;
    private boolean fTz = true;
    public boolean field_chatOpen;
    public int field_qyUin;
    public boolean field_show_confirm;
    public boolean field_use_preset_banner_tips;
    public int field_userFlag;
    public String field_userName;
    public int field_userType;
    public int field_userUin;
    public long field_wwCorpId;
    public int field_wwExposeTimes;
    public int field_wwMaxExposeTimes;
    public int field_wwUnreadCnt;
    public long field_wwUserVid;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOQ == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.fOu = true;
                } else if (fTH == hashCode) {
                    this.field_qyUin = cursor.getInt(i);
                } else if (fTI == hashCode) {
                    this.field_userUin = cursor.getInt(i);
                } else if (fTJ == hashCode) {
                    this.field_userFlag = cursor.getInt(i);
                } else if (fTK == hashCode) {
                    this.field_wwExposeTimes = cursor.getInt(i);
                } else if (fTL == hashCode) {
                    this.field_wwMaxExposeTimes = cursor.getInt(i);
                } else if (fTM == hashCode) {
                    this.field_wwCorpId = cursor.getLong(i);
                } else if (fTN == hashCode) {
                    this.field_wwUserVid = cursor.getLong(i);
                } else if (fTO == hashCode) {
                    this.field_userType = cursor.getInt(i);
                } else if (fTP == hashCode) {
                    this.field_chatOpen = cursor.getInt(i) != 0;
                } else if (fTQ == hashCode) {
                    this.field_wwUnreadCnt = cursor.getInt(i);
                } else if (fTR == hashCode) {
                    this.field_show_confirm = cursor.getInt(i) != 0;
                } else if (fTS == hashCode) {
                    this.field_use_preset_banner_tips = cursor.getInt(i) != 0;
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fOu) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fTv) {
            contentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
        }
        if (this.fTw) {
            contentValues.put("userUin", Integer.valueOf(this.field_userUin));
        }
        if (this.fTx) {
            contentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
        }
        if (this.fTy) {
            contentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
        }
        if (this.fTz) {
            contentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
        }
        if (this.fTA) {
            contentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
        }
        if (this.fTB) {
            contentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
        }
        if (this.fTC) {
            contentValues.put("userType", Integer.valueOf(this.field_userType));
        }
        if (this.fTD) {
            contentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
        }
        if (this.fTE) {
            contentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
        }
        if (this.fTF) {
            contentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
        }
        if (this.fTG) {
            contentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
