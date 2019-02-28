package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class et extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPU = "signature".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fUB = "nickname".hashCode();
    private static final int fUn = "brandIconURL".hashCode();
    private static final int gjV = "versionInfo".hashCode();
    private static final int gkv = "reserved".hashCode();
    private static final int gyd = "usernameHash".hashCode();
    private static final int gye = "roundedSquareIconURL".hashCode();
    private static final int gyf = "bigHeadURL".hashCode();
    private static final int gyg = "smallHeadURL".hashCode();
    private static final int gyh = "appOpt".hashCode();
    private static final int gyi = "registerSource".hashCode();
    private static final int gyj = "appInfo".hashCode();
    private static final int gyk = "bindWxaInfo".hashCode();
    private static final int gyl = "dynamicInfo".hashCode();
    private static final int gym = "syncTimeSecond".hashCode();
    private static final int gyn = "syncVersion".hashCode();
    private static final int gyo = "bizMenu".hashCode();
    private boolean fPD = true;
    private boolean fPX = true;
    private boolean fPp = true;
    private boolean fTZ = true;
    private boolean fUx = true;
    public String field_appId;
    public String field_appInfo;
    public int field_appOpt;
    public String field_bigHeadURL;
    public String field_bindWxaInfo;
    public String field_bizMenu;
    public String field_brandIconURL;
    public String field_dynamicInfo;
    public String field_nickname;
    public String field_registerSource;
    public String field_reserved;
    public String field_roundedSquareIconURL;
    public String field_signature;
    public String field_smallHeadURL;
    public long field_syncTimeSecond;
    public String field_syncVersion;
    public String field_username;
    public int field_usernameHash;
    public String field_versionInfo;
    private boolean gjQ = true;
    private boolean gkm = true;
    private boolean gxR = true;
    private boolean gxS = true;
    private boolean gxT = true;
    private boolean gxU = true;
    private boolean gxV = true;
    private boolean gxW = true;
    private boolean gxX = true;
    private boolean gxY = true;
    private boolean gxZ = true;
    private boolean gya = true;
    private boolean gyb = true;
    private boolean gyc = true;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gyd == hashCode) {
                    this.field_usernameHash = cursor.getInt(i);
                    this.gxR = true;
                } else if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fUB == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (fUn == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (gye == hashCode) {
                    this.field_roundedSquareIconURL = cursor.getString(i);
                } else if (gyf == hashCode) {
                    this.field_bigHeadURL = cursor.getString(i);
                } else if (gyg == hashCode) {
                    this.field_smallHeadURL = cursor.getString(i);
                } else if (fPU == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (gyh == hashCode) {
                    this.field_appOpt = cursor.getInt(i);
                } else if (gyi == hashCode) {
                    this.field_registerSource = cursor.getString(i);
                } else if (gyj == hashCode) {
                    this.field_appInfo = cursor.getString(i);
                } else if (gjV == hashCode) {
                    this.field_versionInfo = cursor.getString(i);
                } else if (gyk == hashCode) {
                    this.field_bindWxaInfo = cursor.getString(i);
                } else if (gyl == hashCode) {
                    this.field_dynamicInfo = cursor.getString(i);
                } else if (gkv == hashCode) {
                    this.field_reserved = cursor.getString(i);
                } else if (gym == hashCode) {
                    this.field_syncTimeSecond = cursor.getLong(i);
                } else if (gyn == hashCode) {
                    this.field_syncVersion = cursor.getString(i);
                } else if (gyo == hashCode) {
                    this.field_bizMenu = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gxR) {
            contentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
        }
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fUx) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.fTZ) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.gxS) {
            contentValues.put("roundedSquareIconURL", this.field_roundedSquareIconURL);
        }
        if (this.gxT) {
            contentValues.put("bigHeadURL", this.field_bigHeadURL);
        }
        if (this.gxU) {
            contentValues.put("smallHeadURL", this.field_smallHeadURL);
        }
        if (this.fPD) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.gxV) {
            contentValues.put("appOpt", Integer.valueOf(this.field_appOpt));
        }
        if (this.gxW) {
            contentValues.put("registerSource", this.field_registerSource);
        }
        if (this.gxX) {
            contentValues.put("appInfo", this.field_appInfo);
        }
        if (this.gjQ) {
            contentValues.put("versionInfo", this.field_versionInfo);
        }
        if (this.gxY) {
            contentValues.put("bindWxaInfo", this.field_bindWxaInfo);
        }
        if (this.gxZ) {
            contentValues.put("dynamicInfo", this.field_dynamicInfo);
        }
        if (this.gkm) {
            contentValues.put("reserved", this.field_reserved);
        }
        if (this.gya) {
            contentValues.put("syncTimeSecond", Long.valueOf(this.field_syncTimeSecond));
        }
        if (this.gyb) {
            contentValues.put("syncVersion", this.field_syncVersion);
        }
        if (this.gyc) {
            contentValues.put("bizMenu", this.field_bizMenu);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
