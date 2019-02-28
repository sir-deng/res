package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ax extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)"};
    private static final int fNO = "rowid".hashCode();
    private static final int gam = "state".hashCode();
    private static final int gbA = "addScene".hashCode();
    private static final int gbB = "fmsgSysRowId".hashCode();
    private static final int gbC = "fmsgIsSend".hashCode();
    private static final int gbD = "fmsgType".hashCode();
    private static final int gbE = "fmsgContent".hashCode();
    private static final int gbF = "recvFmsgType".hashCode();
    private static final int gbG = "contentFromUsername".hashCode();
    private static final int gbH = "contentNickname".hashCode();
    private static final int gbI = "contentPhoneNumMD5".hashCode();
    private static final int gbJ = "contentFullPhoneNumMD5".hashCode();
    private static final int gbK = "contentVerifyContent".hashCode();
    private static final int gbv = "talker".hashCode();
    private static final int gbw = "encryptTalker".hashCode();
    private static final int gbx = "displayName".hashCode();
    private static final int gby = "lastModifiedTime".hashCode();
    private static final int gbz = "isNew".hashCode();
    private boolean fZN = true;
    public int field_addScene;
    public String field_contentFromUsername;
    public String field_contentFullPhoneNumMD5;
    public String field_contentNickname;
    public String field_contentPhoneNumMD5;
    public String field_contentVerifyContent;
    public String field_displayName;
    public String field_encryptTalker;
    public String field_fmsgContent;
    public int field_fmsgIsSend;
    public long field_fmsgSysRowId;
    public int field_fmsgType;
    public int field_isNew;
    public long field_lastModifiedTime;
    public int field_recvFmsgType;
    public int field_state;
    public String field_talker;
    private boolean gbf = true;
    private boolean gbg = true;
    private boolean gbh = true;
    private boolean gbi = true;
    private boolean gbj = true;
    private boolean gbk = true;
    private boolean gbl = true;
    private boolean gbm = true;
    private boolean gbn = true;
    private boolean gbo = true;
    private boolean gbp = true;
    private boolean gbq = true;
    private boolean gbr = true;
    private boolean gbs = true;
    private boolean gbt = true;
    private boolean gbu = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gbv == hashCode) {
                    this.field_talker = cursor.getString(i);
                    this.gbf = true;
                } else if (gbw == hashCode) {
                    this.field_encryptTalker = cursor.getString(i);
                } else if (gbx == hashCode) {
                    this.field_displayName = cursor.getString(i);
                } else if (gam == hashCode) {
                    this.field_state = cursor.getInt(i);
                } else if (gby == hashCode) {
                    this.field_lastModifiedTime = cursor.getLong(i);
                } else if (gbz == hashCode) {
                    this.field_isNew = cursor.getInt(i);
                } else if (gbA == hashCode) {
                    this.field_addScene = cursor.getInt(i);
                } else if (gbB == hashCode) {
                    this.field_fmsgSysRowId = cursor.getLong(i);
                } else if (gbC == hashCode) {
                    this.field_fmsgIsSend = cursor.getInt(i);
                } else if (gbD == hashCode) {
                    this.field_fmsgType = cursor.getInt(i);
                } else if (gbE == hashCode) {
                    this.field_fmsgContent = cursor.getString(i);
                } else if (gbF == hashCode) {
                    this.field_recvFmsgType = cursor.getInt(i);
                } else if (gbG == hashCode) {
                    this.field_contentFromUsername = cursor.getString(i);
                } else if (gbH == hashCode) {
                    this.field_contentNickname = cursor.getString(i);
                } else if (gbI == hashCode) {
                    this.field_contentPhoneNumMD5 = cursor.getString(i);
                } else if (gbJ == hashCode) {
                    this.field_contentFullPhoneNumMD5 = cursor.getString(i);
                } else if (gbK == hashCode) {
                    this.field_contentVerifyContent = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_talker == null) {
            this.field_talker = "0";
        }
        if (this.gbf) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.field_encryptTalker == null) {
            this.field_encryptTalker = "";
        }
        if (this.gbg) {
            contentValues.put("encryptTalker", this.field_encryptTalker);
        }
        if (this.field_displayName == null) {
            this.field_displayName = "";
        }
        if (this.gbh) {
            contentValues.put("displayName", this.field_displayName);
        }
        if (this.fZN) {
            contentValues.put("state", Integer.valueOf(this.field_state));
        }
        if (this.gbi) {
            contentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
        }
        if (this.gbj) {
            contentValues.put("isNew", Integer.valueOf(this.field_isNew));
        }
        if (this.gbk) {
            contentValues.put("addScene", Integer.valueOf(this.field_addScene));
        }
        if (this.gbl) {
            contentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
        }
        if (this.gbm) {
            contentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
        }
        if (this.gbn) {
            contentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
        }
        if (this.field_fmsgContent == null) {
            this.field_fmsgContent = "";
        }
        if (this.gbo) {
            contentValues.put("fmsgContent", this.field_fmsgContent);
        }
        if (this.gbp) {
            contentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
        }
        if (this.field_contentFromUsername == null) {
            this.field_contentFromUsername = "";
        }
        if (this.gbq) {
            contentValues.put("contentFromUsername", this.field_contentFromUsername);
        }
        if (this.field_contentNickname == null) {
            this.field_contentNickname = "";
        }
        if (this.gbr) {
            contentValues.put("contentNickname", this.field_contentNickname);
        }
        if (this.field_contentPhoneNumMD5 == null) {
            this.field_contentPhoneNumMD5 = "";
        }
        if (this.gbs) {
            contentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
        }
        if (this.field_contentFullPhoneNumMD5 == null) {
            this.field_contentFullPhoneNumMD5 = "";
        }
        if (this.gbt) {
            contentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
        }
        if (this.field_contentVerifyContent == null) {
            this.field_contentVerifyContent = "";
        }
        if (this.gbu) {
            contentValues.put("contentVerifyContent", this.field_contentVerifyContent);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
