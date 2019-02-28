package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class z extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fTi = "bitFlag".hashCode();
    private static final int fUh = "brandList".hashCode();
    private static final int fUi = "brandListVersion".hashCode();
    private static final int fUj = "brandListContent".hashCode();
    private static final int fUk = "brandFlag".hashCode();
    private static final int fUl = "extInfo".hashCode();
    private static final int fUm = "brandInfo".hashCode();
    private static final int fUn = "brandIconURL".hashCode();
    private static final int fUo = "hadAlert".hashCode();
    private static final int fUp = "acceptType".hashCode();
    private static final int fUq = "enterpriseFather".hashCode();
    private static final int fUr = "kfWorkerId".hashCode();
    private static final int fUs = "specialType".hashCode();
    private static final int fUt = "attrSyncVersion".hashCode();
    private static final int fUu = "incrementUpdateTime".hashCode();
    private boolean fNR = true;
    private boolean fOz = true;
    private boolean fPX = true;
    private boolean fPY = true;
    private boolean fPp = true;
    private boolean fSW = true;
    private boolean fTT = true;
    private boolean fTU = true;
    private boolean fTV = true;
    private boolean fTW = true;
    private boolean fTX = true;
    private boolean fTY = true;
    private boolean fTZ = true;
    private boolean fUa = true;
    private boolean fUb = true;
    private boolean fUc = true;
    private boolean fUd = true;
    private boolean fUe = true;
    private boolean fUf = true;
    private boolean fUg = true;
    public int field_acceptType;
    public String field_appId;
    public String field_attrSyncVersion;
    public int field_bitFlag;
    public int field_brandFlag;
    public String field_brandIconURL;
    public String field_brandInfo;
    public String field_brandList;
    public String field_brandListContent;
    public String field_brandListVersion;
    public String field_enterpriseFather;
    public String field_extInfo;
    public int field_hadAlert;
    public long field_incrementUpdateTime;
    public String field_kfWorkerId;
    public int field_specialType;
    public int field_status;
    public int field_type;
    public long field_updateTime;
    public String field_username;

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPX = true;
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fUh == hashCode) {
                    this.field_brandList = cursor.getString(i);
                } else if (fUi == hashCode) {
                    this.field_brandListVersion = cursor.getString(i);
                } else if (fUj == hashCode) {
                    this.field_brandListContent = cursor.getString(i);
                } else if (fUk == hashCode) {
                    this.field_brandFlag = cursor.getInt(i);
                } else if (fUl == hashCode) {
                    this.field_extInfo = cursor.getString(i);
                } else if (fUm == hashCode) {
                    this.field_brandInfo = cursor.getString(i);
                } else if (fUn == hashCode) {
                    this.field_brandIconURL = cursor.getString(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fUo == hashCode) {
                    this.field_hadAlert = cursor.getInt(i);
                } else if (fUp == hashCode) {
                    this.field_acceptType = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fUq == hashCode) {
                    this.field_enterpriseFather = cursor.getString(i);
                } else if (fUr == hashCode) {
                    this.field_kfWorkerId = cursor.getString(i);
                } else if (fUs == hashCode) {
                    this.field_specialType = cursor.getInt(i);
                } else if (fUt == hashCode) {
                    this.field_attrSyncVersion = cursor.getString(i);
                } else if (fUu == hashCode) {
                    this.field_incrementUpdateTime = cursor.getLong(i);
                } else if (fTi == hashCode) {
                    this.field_bitFlag = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.field_brandList == null) {
            this.field_brandList = "";
        }
        if (this.fTT) {
            contentValues.put("brandList", this.field_brandList);
        }
        if (this.fTU) {
            contentValues.put("brandListVersion", this.field_brandListVersion);
        }
        if (this.fTV) {
            contentValues.put("brandListContent", this.field_brandListContent);
        }
        if (this.fTW) {
            contentValues.put("brandFlag", Integer.valueOf(this.field_brandFlag));
        }
        if (this.fTX) {
            contentValues.put("extInfo", this.field_extInfo);
        }
        if (this.fTY) {
            contentValues.put("brandInfo", this.field_brandInfo);
        }
        if (this.fTZ) {
            contentValues.put("brandIconURL", this.field_brandIconURL);
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.fUa) {
            contentValues.put("hadAlert", Integer.valueOf(this.field_hadAlert));
        }
        if (this.fUb) {
            contentValues.put("acceptType", Integer.valueOf(this.field_acceptType));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fUc) {
            contentValues.put("enterpriseFather", this.field_enterpriseFather);
        }
        if (this.fUd) {
            contentValues.put("kfWorkerId", this.field_kfWorkerId);
        }
        if (this.fUe) {
            contentValues.put("specialType", Integer.valueOf(this.field_specialType));
        }
        if (this.fUf) {
            contentValues.put("attrSyncVersion", this.field_attrSyncVersion);
        }
        if (this.fUg) {
            contentValues.put("incrementUpdateTime", Long.valueOf(this.field_incrementUpdateTime));
        }
        if (this.fSW) {
            contentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
