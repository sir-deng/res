package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class aq extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fQi = "size".hashCode();
    private static final int fSa = "source".hashCode();
    private static final int fZB = "idx".hashCode();
    private static final int fZx = "lastUseTime".hashCode();
    private static final int gaA = "encrypturl".hashCode();
    private static final int gaB = "aeskey".hashCode();
    private static final int gaC = "width".hashCode();
    private static final int gaD = "height".hashCode();
    private static final int gaE = "externUrl".hashCode();
    private static final int gaF = "externMd5".hashCode();
    private static final int gaG = "activityid".hashCode();
    private static final int gai = "md5".hashCode();
    private static final int gaj = "svrid".hashCode();
    private static final int gak = "catalog".hashCode();
    private static final int gal = "start".hashCode();
    private static final int gam = "state".hashCode();
    private static final int gan = "name".hashCode();
    private static final int gao = "reserved1".hashCode();
    private static final int gap = "reserved2".hashCode();
    private static final int gaq = "reserved3".hashCode();
    private static final int gar = "reserved4".hashCode();
    private static final int gas = "app_id".hashCode();
    private static final int gat = "groupId".hashCode();
    private static final int gau = "framesInfo".hashCode();
    private static final int gav = "temp".hashCode();
    private static final int gaw = "needupload".hashCode();
    private static final int gax = "designerID".hashCode();
    private static final int gay = "thumbUrl".hashCode();
    private static final int gaz = "cdnUrl".hashCode();
    private boolean fOE = true;
    private boolean fOz = true;
    private boolean fQf = true;
    private boolean fRW = true;
    private boolean fYX = true;
    private boolean fZJ = true;
    private boolean fZK = true;
    private boolean fZL = true;
    private boolean fZM = true;
    private boolean fZN = true;
    private boolean fZO = true;
    private boolean fZP = true;
    private boolean fZQ = true;
    private boolean fZR = true;
    private boolean fZS = true;
    private boolean fZT = true;
    private boolean fZU = true;
    private boolean fZV = true;
    private boolean fZW = true;
    private boolean fZX = true;
    private boolean fZY = true;
    private boolean fZZ = true;
    private boolean fZb = true;
    public String field_activityid;
    public String field_aeskey;
    public String field_app_id;
    public int field_catalog;
    public String field_cdnUrl;
    public String field_content;
    public String field_designerID;
    public String field_encrypturl;
    public String field_externMd5;
    public String field_externUrl;
    public String field_framesInfo;
    public String field_groupId;
    public int field_height;
    public int field_idx;
    public long field_lastUseTime;
    public String field_md5;
    public String field_name;
    public int field_needupload;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public int field_reserved4;
    public int field_size;
    public int field_source;
    public int field_start;
    public int field_state;
    public String field_svrid;
    public int field_temp;
    public String field_thumbUrl;
    public int field_type;
    public int field_width;
    private boolean gaa = true;
    private boolean gab = true;
    private boolean gac = true;
    private boolean gad = true;
    private boolean gae = true;
    private boolean gaf = true;
    private boolean gag = true;
    private boolean gah = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gai == hashCode) {
                    this.field_md5 = cursor.getString(i);
                    this.fZJ = true;
                } else if (gaj == hashCode) {
                    this.field_svrid = cursor.getString(i);
                } else if (gak == hashCode) {
                    this.field_catalog = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fQi == hashCode) {
                    this.field_size = cursor.getInt(i);
                } else if (gal == hashCode) {
                    this.field_start = cursor.getInt(i);
                } else if (gam == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (gan == hashCode) {
                    this.field_name = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (gao == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (gap == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (gaq == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (gar == hashCode) {
                    this.field_reserved4 = cursor.getInt(i);
                } else if (gas == hashCode) {
                    this.field_app_id = cursor.getString(i);
                } else if (gat == hashCode) {
                    this.field_groupId = cursor.getString(i);
                } else if (fZx == hashCode) {
                    this.field_lastUseTime = cursor.getLong(i);
                } else if (gau == hashCode) {
                    this.field_framesInfo = cursor.getString(i);
                } else if (fZB == hashCode) {
                    this.field_idx = cursor.getInt(i);
                } else if (gav == hashCode) {
                    this.field_temp = cursor.getInt(i);
                } else if (fSa == hashCode) {
                    this.field_source = cursor.getInt(i);
                } else if (gaw == hashCode) {
                    this.field_needupload = cursor.getInt(i);
                } else if (gax == hashCode) {
                    this.field_designerID = cursor.getString(i);
                } else if (gay == hashCode) {
                    this.field_thumbUrl = cursor.getString(i);
                } else if (gaz == hashCode) {
                    this.field_cdnUrl = cursor.getString(i);
                } else if (gaA == hashCode) {
                    this.field_encrypturl = cursor.getString(i);
                } else if (gaB == hashCode) {
                    this.field_aeskey = cursor.getString(i);
                } else if (gaC == hashCode) {
                    this.field_width = cursor.getInt(i);
                } else if (gaD == hashCode) {
                    this.field_height = cursor.getInt(i);
                } else if (gaE == hashCode) {
                    this.field_externUrl = cursor.getString(i);
                } else if (gaF == hashCode) {
                    this.field_externMd5 = cursor.getString(i);
                } else if (gaG == hashCode) {
                    this.field_activityid = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fZJ) {
            contentValues.put("md5", this.field_md5);
        }
        if (this.fZK) {
            contentValues.put("svrid", this.field_svrid);
        }
        if (this.fZL) {
            contentValues.put("catalog", Integer.valueOf(this.field_catalog));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fQf) {
            contentValues.put("size", Integer.valueOf(this.field_size));
        }
        if (this.fZM) {
            contentValues.put("start", Integer.valueOf(this.field_start));
        }
        if (this.fZN) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.fZO) {
            contentValues.put("name", this.field_name);
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.fZP) {
            contentValues.put("reserved1", this.field_reserved1);
        }
        if (this.fZQ) {
            contentValues.put("reserved2", this.field_reserved2);
        }
        if (this.fZR) {
            contentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
        }
        if (this.fZS) {
            contentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
        }
        if (this.fZT) {
            contentValues.put("app_id", this.field_app_id);
        }
        if (this.field_groupId == null) {
            this.field_groupId = "";
        }
        if (this.fZU) {
            contentValues.put("groupId", this.field_groupId);
        }
        if (this.fYX) {
            contentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
        }
        if (this.field_framesInfo == null) {
            this.field_framesInfo = "";
        }
        if (this.fZV) {
            contentValues.put("framesInfo", this.field_framesInfo);
        }
        if (this.fZb) {
            contentValues.put("idx", Integer.valueOf(this.field_idx));
        }
        if (this.fZW) {
            contentValues.put("temp", Integer.valueOf(this.field_temp));
        }
        if (this.fRW) {
            contentValues.put("source", Integer.valueOf(this.field_source));
        }
        if (this.fZX) {
            contentValues.put("needupload", Integer.valueOf(this.field_needupload));
        }
        if (this.fZY) {
            contentValues.put("designerID", this.field_designerID);
        }
        if (this.fZZ) {
            contentValues.put("thumbUrl", this.field_thumbUrl);
        }
        if (this.gaa) {
            contentValues.put("cdnUrl", this.field_cdnUrl);
        }
        if (this.gab) {
            contentValues.put("encrypturl", this.field_encrypturl);
        }
        if (this.gac) {
            contentValues.put("aeskey", this.field_aeskey);
        }
        if (this.gad) {
            contentValues.put("width", Integer.valueOf(this.field_width));
        }
        if (this.gae) {
            contentValues.put("height", Integer.valueOf(this.field_height));
        }
        if (this.gaf) {
            contentValues.put("externUrl", this.field_externUrl);
        }
        if (this.gag) {
            contentValues.put("externMd5", this.field_externMd5);
        }
        if (this.gah) {
            contentValues.put("activityid", this.field_activityid);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }

    public void reset() {
    }
}
