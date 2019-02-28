package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOQ = "userName".hashCode();
    private static final int gai = "md5".hashCode();
    private static final int grJ = "newerIds".hashCode();
    private static final int grK = "bgId".hashCode();
    private static final int grL = "bgUrl".hashCode();
    private static final int grM = "older_bgId".hashCode();
    private static final int grN = "local_flag".hashCode();
    private static final int grO = "istyle".hashCode();
    private static final int grP = "iFlag".hashCode();
    private static final int grQ = "icount".hashCode();
    private static final int grR = "faultS".hashCode();
    private static final int grS = "snsBgId".hashCode();
    private static final int grT = "snsuser".hashCode();
    private static final int grU = "adsession".hashCode();
    private static final int grV = "lastFirstPageRequestErrCode".hashCode();
    private static final int grW = "lastFirstPageRequestErrType".hashCode();
    private boolean fOu = true;
    private boolean fZJ = true;
    public byte[] field_adsession;
    public String field_bgId;
    public String field_bgUrl;
    public byte[] field_faultS;
    public int field_iFlag;
    public int field_icount;
    public int field_istyle;
    public int field_lastFirstPageRequestErrCode;
    public int field_lastFirstPageRequestErrType;
    public int field_local_flag;
    public String field_md5;
    public String field_newerIds;
    public String field_older_bgId;
    public long field_snsBgId;
    public byte[] field_snsuser;
    public String field_userName;
    private boolean grA = true;
    private boolean grB = true;
    private boolean grC = true;
    private boolean grD = true;
    private boolean grE = true;
    private boolean grF = true;
    private boolean grG = true;
    private boolean grH = true;
    private boolean grI = true;
    private boolean grv = true;
    private boolean grw = true;
    private boolean grx = true;
    private boolean gry = true;
    private boolean grz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOQ == hashCode) {
                    this.field_userName = cursor.getString(i);
                    this.fOu = true;
                } else if (gai == hashCode) {
                    this.field_md5 = cursor.getString(i);
                } else if (grJ == hashCode) {
                    this.field_newerIds = cursor.getString(i);
                } else if (grK == hashCode) {
                    this.field_bgId = cursor.getString(i);
                } else if (grL == hashCode) {
                    this.field_bgUrl = cursor.getString(i);
                } else if (grM == hashCode) {
                    this.field_older_bgId = cursor.getString(i);
                } else if (grN == hashCode) {
                    this.field_local_flag = cursor.getInt(i);
                } else if (grO == hashCode) {
                    this.field_istyle = cursor.getInt(i);
                } else if (grP == hashCode) {
                    this.field_iFlag = cursor.getInt(i);
                } else if (grQ == hashCode) {
                    this.field_icount = cursor.getInt(i);
                } else if (grR == hashCode) {
                    this.field_faultS = cursor.getBlob(i);
                } else if (grS == hashCode) {
                    this.field_snsBgId = cursor.getLong(i);
                } else if (grT == hashCode) {
                    this.field_snsuser = cursor.getBlob(i);
                } else if (grU == hashCode) {
                    this.field_adsession = cursor.getBlob(i);
                } else if (grV == hashCode) {
                    this.field_lastFirstPageRequestErrCode = cursor.getInt(i);
                } else if (grW == hashCode) {
                    this.field_lastFirstPageRequestErrType = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_userName == null) {
            this.field_userName = "";
        }
        if (this.fOu) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fZJ) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.grv) {
            contentValues.put("newerIds", this.field_newerIds);
        }
        if (this.grw) {
            contentValues.put("bgId", this.field_bgId);
        }
        if (this.grx) {
            contentValues.put("bgUrl", this.field_bgUrl);
        }
        if (this.gry) {
            contentValues.put("older_bgId", this.field_older_bgId);
        }
        if (this.grz) {
            contentValues.put("local_flag", Integer.valueOf(this.field_local_flag));
        }
        if (this.grA) {
            contentValues.put("istyle", Integer.valueOf(this.field_istyle));
        }
        if (this.grB) {
            contentValues.put("iFlag", Integer.valueOf(this.field_iFlag));
        }
        if (this.grC) {
            contentValues.put("icount", Integer.valueOf(this.field_icount));
        }
        if (this.grD) {
            contentValues.put("faultS", this.field_faultS);
        }
        if (this.grE) {
            contentValues.put("snsBgId", Long.valueOf(this.field_snsBgId));
        }
        if (this.grF) {
            contentValues.put("snsuser", this.field_snsuser);
        }
        if (this.grG) {
            contentValues.put("adsession", this.field_adsession);
        }
        if (this.grH) {
            contentValues.put("lastFirstPageRequestErrCode", Integer.valueOf(this.field_lastFirstPageRequestErrCode));
        }
        if (this.grI) {
            contentValues.put("lastFirstPageRequestErrType", Integer.valueOf(this.field_lastFirstPageRequestErrType));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
