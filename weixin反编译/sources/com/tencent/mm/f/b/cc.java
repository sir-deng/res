package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cc extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOf = "expId".hashCode();
    private static final int fOg = "sequence".hashCode();
    private static final int fOh = "prioritylevel".hashCode();
    private static final int giO = "LabsAppId".hashCode();
    private static final int giP = "Type".hashCode();
    private static final int giQ = "BizType".hashCode();
    private static final int giR = "Switch".hashCode();
    private static final int giS = "AllVer".hashCode();
    private static final int giT = "DetailURL".hashCode();
    private static final int giU = "WeAppUser".hashCode();
    private static final int giV = "WeAppPath".hashCode();
    private static final int giW = "Pos".hashCode();
    private static final int giX = "TitleKey_android".hashCode();
    private static final int giY = "Title_cn".hashCode();
    private static final int giZ = "Title_hk".hashCode();
    private static final int gjA = "ImgUrl_hk".hashCode();
    private static final int gjB = "ImgUrl_tw".hashCode();
    private static final int gjC = "ImgUrl_en".hashCode();
    private static final int gja = "Title_tw".hashCode();
    private static final int gjb = "Title_en".hashCode();
    private static final int gjc = "Desc_cn".hashCode();
    private static final int gjd = "Desc_hk".hashCode();
    private static final int gje = "Desc_tw".hashCode();
    private static final int gjf = "Desc_en".hashCode();
    private static final int gjg = "Introduce_cn".hashCode();
    private static final int gjh = "Introduce_hk".hashCode();
    private static final int gji = "Introduce_tw".hashCode();
    private static final int gjj = "Introduce_en".hashCode();
    private static final int gjk = "starttime".hashCode();
    private static final int gjl = "endtime".hashCode();
    private static final int gjm = "ThumbUrl_cn".hashCode();
    private static final int gjn = "ThumbUrl_hk".hashCode();
    private static final int gjo = "ThumbUrl_tw".hashCode();
    private static final int gjp = "ThumbUrl_en".hashCode();
    private static final int gjq = "ImgUrl_android_cn".hashCode();
    private static final int gjr = "ImgUrl_android_hk".hashCode();
    private static final int gjs = "ImgUrl_android_tw".hashCode();
    private static final int gjt = "ImgUrl_android_en".hashCode();
    private static final int gju = "RedPoint".hashCode();
    private static final int gjv = "WeAppDebugMode".hashCode();
    private static final int gjw = "idkey".hashCode();
    private static final int gjx = "idkeyValue".hashCode();
    private static final int gjy = "Icon".hashCode();
    private static final int gjz = "ImgUrl_cn".hashCode();
    private boolean fNR = true;
    private boolean fNX = true;
    private boolean fNY = true;
    private boolean fNZ = true;
    public int field_AllVer;
    public int field_BizType;
    public String field_Desc_cn;
    public String field_Desc_en;
    public String field_Desc_hk;
    public String field_Desc_tw;
    public String field_DetailURL;
    public String field_Icon;
    public String field_ImgUrl_android_cn;
    public String field_ImgUrl_android_en;
    public String field_ImgUrl_android_hk;
    public String field_ImgUrl_android_tw;
    public String field_ImgUrl_cn;
    public String field_ImgUrl_en;
    public String field_ImgUrl_hk;
    public String field_ImgUrl_tw;
    public String field_Introduce_cn;
    public String field_Introduce_en;
    public String field_Introduce_hk;
    public String field_Introduce_tw;
    public String field_LabsAppId;
    public int field_Pos;
    public int field_RedPoint;
    public int field_Switch;
    public String field_ThumbUrl_cn;
    public String field_ThumbUrl_en;
    public String field_ThumbUrl_hk;
    public String field_ThumbUrl_tw;
    public String field_TitleKey_android;
    public String field_Title_cn;
    public String field_Title_en;
    public String field_Title_hk;
    public String field_Title_tw;
    public int field_Type;
    public int field_WeAppDebugMode;
    public String field_WeAppPath;
    public String field_WeAppUser;
    public long field_endtime;
    public String field_expId;
    public int field_idkey;
    public int field_idkeyValue;
    public int field_prioritylevel;
    public long field_sequence;
    public long field_starttime;
    public int field_status;
    private boolean ghZ = true;
    private boolean giA = true;
    private boolean giB = true;
    private boolean giC = true;
    private boolean giD = true;
    private boolean giE = true;
    private boolean giF = true;
    private boolean giG = true;
    private boolean giH = true;
    private boolean giI = true;
    private boolean giJ = true;
    private boolean giK = true;
    private boolean giL = true;
    private boolean giM = true;
    private boolean giN = true;
    private boolean gia = true;
    private boolean gib = true;
    private boolean gic = true;
    private boolean gid = true;
    private boolean gie = true;
    private boolean gif = true;
    private boolean gig = true;
    private boolean gih = true;
    private boolean gii = true;
    private boolean gij = true;
    private boolean gik = true;
    private boolean gil = true;
    private boolean gim = true;
    private boolean gin = true;
    private boolean gio = true;
    private boolean gip = true;
    private boolean giq = true;
    private boolean gir = true;
    private boolean gis = true;
    private boolean git = true;
    private boolean giu = true;
    private boolean giv = true;
    private boolean giw = true;
    private boolean gix = true;
    private boolean giy = true;
    private boolean giz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (giO == hashCode) {
                    this.field_LabsAppId = cursor.getString(i);
                    this.ghZ = true;
                } else if (fOf == hashCode) {
                    this.field_expId = cursor.getString(i);
                } else if (giP == hashCode) {
                    this.field_Type = cursor.getInt(i);
                } else if (giQ == hashCode) {
                    this.field_BizType = cursor.getInt(i);
                } else if (giR == hashCode) {
                    this.field_Switch = cursor.getInt(i);
                } else if (giS == hashCode) {
                    this.field_AllVer = cursor.getInt(i);
                } else if (giT == hashCode) {
                    this.field_DetailURL = cursor.getString(i);
                } else if (giU == hashCode) {
                    this.field_WeAppUser = cursor.getString(i);
                } else if (giV == hashCode) {
                    this.field_WeAppPath = cursor.getString(i);
                } else if (giW == hashCode) {
                    this.field_Pos = cursor.getInt(i);
                } else if (giX == hashCode) {
                    this.field_TitleKey_android = cursor.getString(i);
                } else if (giY == hashCode) {
                    this.field_Title_cn = cursor.getString(i);
                } else if (giZ == hashCode) {
                    this.field_Title_hk = cursor.getString(i);
                } else if (gja == hashCode) {
                    this.field_Title_tw = cursor.getString(i);
                } else if (gjb == hashCode) {
                    this.field_Title_en = cursor.getString(i);
                } else if (gjc == hashCode) {
                    this.field_Desc_cn = cursor.getString(i);
                } else if (gjd == hashCode) {
                    this.field_Desc_hk = cursor.getString(i);
                } else if (gje == hashCode) {
                    this.field_Desc_tw = cursor.getString(i);
                } else if (gjf == hashCode) {
                    this.field_Desc_en = cursor.getString(i);
                } else if (gjg == hashCode) {
                    this.field_Introduce_cn = cursor.getString(i);
                } else if (gjh == hashCode) {
                    this.field_Introduce_hk = cursor.getString(i);
                } else if (gji == hashCode) {
                    this.field_Introduce_tw = cursor.getString(i);
                } else if (gjj == hashCode) {
                    this.field_Introduce_en = cursor.getString(i);
                } else if (gjk == hashCode) {
                    this.field_starttime = cursor.getLong(i);
                } else if (gjl == hashCode) {
                    this.field_endtime = cursor.getLong(i);
                } else if (fOg == hashCode) {
                    this.field_sequence = cursor.getLong(i);
                } else if (fOh == hashCode) {
                    this.field_prioritylevel = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gjm == hashCode) {
                    this.field_ThumbUrl_cn = cursor.getString(i);
                } else if (gjn == hashCode) {
                    this.field_ThumbUrl_hk = cursor.getString(i);
                } else if (gjo == hashCode) {
                    this.field_ThumbUrl_tw = cursor.getString(i);
                } else if (gjp == hashCode) {
                    this.field_ThumbUrl_en = cursor.getString(i);
                } else if (gjq == hashCode) {
                    this.field_ImgUrl_android_cn = cursor.getString(i);
                } else if (gjr == hashCode) {
                    this.field_ImgUrl_android_hk = cursor.getString(i);
                } else if (gjs == hashCode) {
                    this.field_ImgUrl_android_tw = cursor.getString(i);
                } else if (gjt == hashCode) {
                    this.field_ImgUrl_android_en = cursor.getString(i);
                } else if (gju == hashCode) {
                    this.field_RedPoint = cursor.getInt(i);
                } else if (gjv == hashCode) {
                    this.field_WeAppDebugMode = cursor.getInt(i);
                } else if (gjw == hashCode) {
                    this.field_idkey = cursor.getInt(i);
                } else if (gjx == hashCode) {
                    this.field_idkeyValue = cursor.getInt(i);
                } else if (gjy == hashCode) {
                    this.field_Icon = cursor.getString(i);
                } else if (gjz == hashCode) {
                    this.field_ImgUrl_cn = cursor.getString(i);
                } else if (gjA == hashCode) {
                    this.field_ImgUrl_hk = cursor.getString(i);
                } else if (gjB == hashCode) {
                    this.field_ImgUrl_tw = cursor.getString(i);
                } else if (gjC == hashCode) {
                    this.field_ImgUrl_en = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.ghZ) {
            contentValues.put("LabsAppId", this.field_LabsAppId);
        }
        if (this.field_expId == null) {
            this.field_expId = "";
        }
        if (this.fNX) {
            contentValues.put("expId", this.field_expId);
        }
        if (this.gia) {
            contentValues.put("Type", Integer.valueOf(this.field_Type));
        }
        if (this.gib) {
            contentValues.put("BizType", Integer.valueOf(this.field_BizType));
        }
        if (this.gic) {
            contentValues.put("Switch", Integer.valueOf(this.field_Switch));
        }
        if (this.gid) {
            contentValues.put("AllVer", Integer.valueOf(this.field_AllVer));
        }
        if (this.gie) {
            contentValues.put("DetailURL", this.field_DetailURL);
        }
        if (this.gif) {
            contentValues.put("WeAppUser", this.field_WeAppUser);
        }
        if (this.gig) {
            contentValues.put("WeAppPath", this.field_WeAppPath);
        }
        if (this.gih) {
            contentValues.put("Pos", Integer.valueOf(this.field_Pos));
        }
        if (this.gii) {
            contentValues.put("TitleKey_android", this.field_TitleKey_android);
        }
        if (this.gij) {
            contentValues.put("Title_cn", this.field_Title_cn);
        }
        if (this.gik) {
            contentValues.put("Title_hk", this.field_Title_hk);
        }
        if (this.gil) {
            contentValues.put("Title_tw", this.field_Title_tw);
        }
        if (this.gim) {
            contentValues.put("Title_en", this.field_Title_en);
        }
        if (this.gin) {
            contentValues.put("Desc_cn", this.field_Desc_cn);
        }
        if (this.gio) {
            contentValues.put("Desc_hk", this.field_Desc_hk);
        }
        if (this.gip) {
            contentValues.put("Desc_tw", this.field_Desc_tw);
        }
        if (this.giq) {
            contentValues.put("Desc_en", this.field_Desc_en);
        }
        if (this.gir) {
            contentValues.put("Introduce_cn", this.field_Introduce_cn);
        }
        if (this.gis) {
            contentValues.put("Introduce_hk", this.field_Introduce_hk);
        }
        if (this.git) {
            contentValues.put("Introduce_tw", this.field_Introduce_tw);
        }
        if (this.giu) {
            contentValues.put("Introduce_en", this.field_Introduce_en);
        }
        if (this.giv) {
            contentValues.put("starttime", Long.valueOf(this.field_starttime));
        }
        if (this.giw) {
            contentValues.put("endtime", Long.valueOf(this.field_endtime));
        }
        if (this.fNY) {
            contentValues.put("sequence", Long.valueOf(this.field_sequence));
        }
        if (this.fNZ) {
            contentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gix) {
            contentValues.put("ThumbUrl_cn", this.field_ThumbUrl_cn);
        }
        if (this.giy) {
            contentValues.put("ThumbUrl_hk", this.field_ThumbUrl_hk);
        }
        if (this.giz) {
            contentValues.put("ThumbUrl_tw", this.field_ThumbUrl_tw);
        }
        if (this.giA) {
            contentValues.put("ThumbUrl_en", this.field_ThumbUrl_en);
        }
        if (this.giB) {
            contentValues.put("ImgUrl_android_cn", this.field_ImgUrl_android_cn);
        }
        if (this.giC) {
            contentValues.put("ImgUrl_android_hk", this.field_ImgUrl_android_hk);
        }
        if (this.giD) {
            contentValues.put("ImgUrl_android_tw", this.field_ImgUrl_android_tw);
        }
        if (this.giE) {
            contentValues.put("ImgUrl_android_en", this.field_ImgUrl_android_en);
        }
        if (this.giF) {
            contentValues.put("RedPoint", Integer.valueOf(this.field_RedPoint));
        }
        if (this.giG) {
            contentValues.put("WeAppDebugMode", Integer.valueOf(this.field_WeAppDebugMode));
        }
        if (this.giH) {
            contentValues.put("idkey", Integer.valueOf(this.field_idkey));
        }
        if (this.giI) {
            contentValues.put("idkeyValue", Integer.valueOf(this.field_idkeyValue));
        }
        if (this.giJ) {
            contentValues.put("Icon", this.field_Icon);
        }
        if (this.giK) {
            contentValues.put("ImgUrl_cn", this.field_ImgUrl_cn);
        }
        if (this.giL) {
            contentValues.put("ImgUrl_hk", this.field_ImgUrl_hk);
        }
        if (this.giM) {
            contentValues.put("ImgUrl_tw", this.field_ImgUrl_tw);
        }
        if (this.giN) {
            contentValues.put("ImgUrl_en", this.field_ImgUrl_en);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
