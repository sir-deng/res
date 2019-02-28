package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class e extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fOP = "snsId".hashCode();
    private static final int fOQ = "userName".hashCode();
    private static final int fOR = "localFlag".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOT = "head".hashCode();
    private static final int fOU = "localPrivate".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fOW = "sourceType".hashCode();
    private static final int fOX = "likeFlag".hashCode();
    private static final int fOY = "pravited".hashCode();
    private static final int fOZ = "stringSeq".hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fPb = "attrBuf".hashCode();
    private static final int fPc = "postBuf".hashCode();
    private static final int fPd = "adinfo".hashCode();
    private static final int fPe = "adxml".hashCode();
    private static final int fPf = "createAdTime".hashCode();
    private static final int fPg = "exposureTime".hashCode();
    private static final int fPh = "firstControlTime".hashCode();
    private static final int fPi = "recxml".hashCode();
    private static final int fPj = "subType".hashCode();
    private static final int fPk = "exposureCount".hashCode();
    private boolean fOA = true;
    private boolean fOB = true;
    private boolean fOC = true;
    private boolean fOD = true;
    private boolean fOE = true;
    private boolean fOF = true;
    private boolean fOG = true;
    private boolean fOH = true;
    private boolean fOI = true;
    private boolean fOJ = true;
    private boolean fOK = true;
    private boolean fOL = true;
    private boolean fOM = true;
    private boolean fON = true;
    private boolean fOO = true;
    private boolean fOt = true;
    private boolean fOu = true;
    private boolean fOv = true;
    private boolean fOw = true;
    private boolean fOx = true;
    private boolean fOy = true;
    private boolean fOz = true;
    public String field_adinfo;
    public String field_adxml;
    public byte[] field_attrBuf;
    public byte[] field_content;
    public int field_createAdTime;
    public int field_createTime;
    public int field_exposureCount;
    public int field_exposureTime;
    public int field_firstControlTime;
    public int field_head;
    public int field_likeFlag;
    public int field_localFlag;
    public int field_localPrivate;
    public byte[] field_postBuf;
    public int field_pravited;
    public String field_recxml;
    public long field_snsId;
    public int field_sourceType;
    public String field_stringSeq;
    public int field_subType;
    public int field_type;
    public String field_userName;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fOP == hashCode) {
                    this.field_snsId = cursor.getLong(i);
                } else if (fOQ == hashCode) {
                    this.field_userName = cursor.getString(i);
                } else if (fOR == hashCode) {
                    this.field_localFlag = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getInt(i);
                } else if (fOT == hashCode) {
                    this.field_head = cursor.getInt(i);
                } else if (fOU == hashCode) {
                    this.field_localPrivate = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fOW == hashCode) {
                    this.field_sourceType = cursor.getInt(i);
                } else if (fOX == hashCode) {
                    this.field_likeFlag = cursor.getInt(i);
                } else if (fOY == hashCode) {
                    this.field_pravited = cursor.getInt(i);
                } else if (fOZ == hashCode) {
                    this.field_stringSeq = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getBlob(i);
                } else if (fPb == hashCode) {
                    this.field_attrBuf = cursor.getBlob(i);
                } else if (fPc == hashCode) {
                    this.field_postBuf = cursor.getBlob(i);
                } else if (fPd == hashCode) {
                    this.field_adinfo = cursor.getString(i);
                } else if (fPe == hashCode) {
                    this.field_adxml = cursor.getString(i);
                } else if (fPf == hashCode) {
                    this.field_createAdTime = cursor.getInt(i);
                } else if (fPg == hashCode) {
                    this.field_exposureTime = cursor.getInt(i);
                } else if (fPh == hashCode) {
                    this.field_firstControlTime = cursor.getInt(i);
                } else if (fPi == hashCode) {
                    this.field_recxml = cursor.getString(i);
                } else if (fPj == hashCode) {
                    this.field_subType = cursor.getInt(i);
                } else if (fPk == hashCode) {
                    this.field_exposureCount = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fOt) {
            contentValues.put("snsId", Long.valueOf(this.field_snsId));
        }
        if (this.fOu) {
            contentValues.put("userName", this.field_userName);
        }
        if (this.fOv) {
            contentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
        }
        if (this.fOw) {
            contentValues.put("createTime", Integer.valueOf(this.field_createTime));
        }
        if (this.fOx) {
            contentValues.put("head", Integer.valueOf(this.field_head));
        }
        if (this.fOy) {
            contentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fOA) {
            contentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
        }
        if (this.fOB) {
            contentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
        }
        if (this.fOC) {
            contentValues.put("pravited", Integer.valueOf(this.field_pravited));
        }
        if (this.fOD) {
            contentValues.put("stringSeq", this.field_stringSeq);
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.fOF) {
            contentValues.put("attrBuf", this.field_attrBuf);
        }
        if (this.fOG) {
            contentValues.put("postBuf", this.field_postBuf);
        }
        if (this.fOH) {
            contentValues.put("adinfo", this.field_adinfo);
        }
        if (this.fOI) {
            contentValues.put("adxml", this.field_adxml);
        }
        if (this.fOJ) {
            contentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
        }
        if (this.fOK) {
            contentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
        }
        if (this.fOL) {
            contentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
        }
        if (this.fOM) {
            contentValues.put("recxml", this.field_recxml);
        }
        if (this.fON) {
            contentValues.put("subType", Integer.valueOf(this.field_subType));
        }
        if (this.fOO) {
            contentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
