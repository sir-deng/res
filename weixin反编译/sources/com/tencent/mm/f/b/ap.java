package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ap extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fSd = "flag".hashCode();
    private static final int fZA = "sync".hashCode();
    private static final int fZB = "idx".hashCode();
    private static final int fZC = "BigIconUrl".hashCode();
    private static final int fZD = "MutiLanName".hashCode();
    private static final int fZE = "recommandType".hashCode();
    private static final int fZF = "lang".hashCode();
    private static final int fZG = "recommandWord".hashCode();
    private static final int fZH = "buttonType".hashCode();
    private static final int fZI = "count".hashCode();
    private static final int fZj = "productID".hashCode();
    private static final int fZk = "packIconUrl".hashCode();
    private static final int fZl = "packGrayIconUrl".hashCode();
    private static final int fZm = "packCoverUrl".hashCode();
    private static final int fZn = "packName".hashCode();
    private static final int fZo = "packDesc".hashCode();
    private static final int fZp = "packAuthInfo".hashCode();
    private static final int fZq = "packPrice".hashCode();
    private static final int fZr = "packType".hashCode();
    private static final int fZs = "packFlag".hashCode();
    private static final int fZt = "packExpire".hashCode();
    private static final int fZu = "packTimeStamp".hashCode();
    private static final int fZv = "packCopyright".hashCode();
    private static final int fZw = "sort".hashCode();
    private static final int fZx = "lastUseTime".hashCode();
    private static final int fZy = "packStatus".hashCode();
    private static final int fZz = "recommand".hashCode();
    private boolean fNR = true;
    private boolean fOz = true;
    private boolean fSb = true;
    private boolean fYJ = true;
    private boolean fYK = true;
    private boolean fYL = true;
    private boolean fYM = true;
    private boolean fYN = true;
    private boolean fYO = true;
    private boolean fYP = true;
    private boolean fYQ = true;
    private boolean fYR = true;
    private boolean fYS = true;
    private boolean fYT = true;
    private boolean fYU = true;
    private boolean fYV = true;
    private boolean fYW = true;
    private boolean fYX = true;
    private boolean fYY = true;
    private boolean fYZ = true;
    private boolean fZa = true;
    private boolean fZb = true;
    private boolean fZc = true;
    private boolean fZd = true;
    private boolean fZe = true;
    private boolean fZf = true;
    private boolean fZg = true;
    private boolean fZh = true;
    private boolean fZi = true;
    public String field_BigIconUrl;
    public String field_MutiLanName;
    public int field_buttonType;
    public int field_count;
    public int field_flag;
    public int field_idx;
    public String field_lang;
    public long field_lastUseTime;
    public String field_packAuthInfo;
    public String field_packCopyright;
    public String field_packCoverUrl;
    public String field_packDesc;
    public long field_packExpire;
    public int field_packFlag;
    public String field_packGrayIconUrl;
    public String field_packIconUrl;
    public String field_packName;
    public String field_packPrice;
    public int field_packStatus;
    public long field_packTimeStamp;
    public int field_packType;
    public String field_productID;
    public int field_recommand;
    public int field_recommandType;
    public String field_recommandWord;
    public int field_sort;
    public int field_status;
    public int field_sync;
    public int field_type;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fZj == hashCode) {
                    this.field_productID = cursor.getString(i);
                    this.fYJ = true;
                } else if (fZk == hashCode) {
                    this.field_packIconUrl = cursor.getString(i);
                } else if (fZl == hashCode) {
                    this.field_packGrayIconUrl = cursor.getString(i);
                } else if (fZm == hashCode) {
                    this.field_packCoverUrl = cursor.getString(i);
                } else if (fZn == hashCode) {
                    this.field_packName = cursor.getString(i);
                } else if (fZo == hashCode) {
                    this.field_packDesc = cursor.getString(i);
                } else if (fZp == hashCode) {
                    this.field_packAuthInfo = cursor.getString(i);
                } else if (fZq == hashCode) {
                    this.field_packPrice = cursor.getString(i);
                } else if (fZr == hashCode) {
                    this.field_packType = cursor.getInt(i);
                } else if (fZs == hashCode) {
                    this.field_packFlag = cursor.getInt(i);
                } else if (fZt == hashCode) {
                    this.field_packExpire = cursor.getLong(i);
                } else if (fZu == hashCode) {
                    this.field_packTimeStamp = cursor.getLong(i);
                } else if (fZv == hashCode) {
                    this.field_packCopyright = cursor.getString(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fZw == hashCode) {
                    this.field_sort = cursor.getInt(i);
                } else if (fZx == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (fZy == hashCode) {
                    this.field_packStatus = cursor.getInt(i);
                } else if (fSd == hashCode) {
                    this.field_flag = cursor.getInt(i);
                } else if (fZz == hashCode) {
                    this.field_recommand = cursor.getInt(i);
                } else if (fZA == hashCode) {
                    this.field_sync = cursor.getInt(i);
                } else if (fZB == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (fZC == hashCode) {
                    this.field_BigIconUrl = cursor.getString(i);
                } else if (fZD == hashCode) {
                    this.field_MutiLanName = cursor.getString(i);
                } else if (fZE == hashCode) {
                    this.field_recommandType = cursor.getInt(i);
                } else if (fZF == hashCode) {
                    this.field_lang = cursor.getString(i);
                } else if (fZG == hashCode) {
                    this.field_recommandWord = cursor.getString(i);
                } else if (fZH == hashCode) {
                    this.field_buttonType = cursor.getInt(i);
                } else if (fZI == hashCode) {
                    this.field_count = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fYJ) {
            contentValues.put("productID", this.field_productID);
        }
        if (this.fYK) {
            contentValues.put("packIconUrl", this.field_packIconUrl);
        }
        if (this.fYL) {
            contentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
        }
        if (this.fYM) {
            contentValues.put("packCoverUrl", this.field_packCoverUrl);
        }
        if (this.fYN) {
            contentValues.put("packName", this.field_packName);
        }
        if (this.fYO) {
            contentValues.put("packDesc", this.field_packDesc);
        }
        if (this.fYP) {
            contentValues.put("packAuthInfo", this.field_packAuthInfo);
        }
        if (this.fYQ) {
            contentValues.put("packPrice", this.field_packPrice);
        }
        if (this.fYR) {
            contentValues.put("packType", Integer.valueOf(this.field_packType));
        }
        if (this.fYS) {
            contentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
        }
        if (this.fYT) {
            contentValues.put("packExpire", Long.valueOf(this.field_packExpire));
        }
        if (this.fYU) {
            contentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
        }
        if (this.fYV) {
            contentValues.put("packCopyright", this.field_packCopyright);
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fYW) {
            contentValues.put("sort", Integer.valueOf(this.field_sort));
        }
        if (this.fYX) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.fYY) {
            contentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
        }
        if (this.fSb) {
            contentValues.put("flag", Integer.valueOf(this.field_flag));
        }
        if (this.fYZ) {
            contentValues.put("recommand", Integer.valueOf(this.field_recommand));
        }
        if (this.fZa) {
            contentValues.put("sync", Integer.valueOf(this.field_sync));
        }
        if (this.fZb) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.fZc) {
            contentValues.put("BigIconUrl", this.field_BigIconUrl);
        }
        if (this.fZd) {
            contentValues.put("MutiLanName", this.field_MutiLanName);
        }
        if (this.fZe) {
            contentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
        }
        if (this.fZf) {
            contentValues.put("lang", this.field_lang);
        }
        if (this.fZg) {
            contentValues.put("recommandWord", this.field_recommandWord);
        }
        if (this.fZh) {
            contentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
        }
        if (this.fZi) {
            contentValues.put("count", Integer.valueOf(this.field_count));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
