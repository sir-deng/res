package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;

public abstract class bh extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fVi = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gei = "ssidmd5".hashCode();
    private static final int gej = "ssid".hashCode();
    private static final int gek = "mid".hashCode();
    private static final int gel = "connectState".hashCode();
    private static final int gem = "expiredTime".hashCode();
    private static final int gen = "wifiType".hashCode();
    private static final int geo = "action".hashCode();
    private static final int gep = "showUrl".hashCode();
    private static final int geq = "showWordEn".hashCode();
    private static final int ger = "showWordCn".hashCode();
    private static final int ges = "showWordTw".hashCode();
    private static final int get = "mac".hashCode();
    private static final int geu = "verifyResult".hashCode();
    private boolean fUP = true;
    public int field_action;
    public int field_connectState;
    public long field_expiredTime;
    public String field_mac;
    public String field_mid;
    public String field_showUrl;
    public String field_showWordCn;
    public String field_showWordEn;
    public String field_showWordTw;
    public String field_ssid;
    public String field_ssidmd5;
    public String field_url;
    public int field_verifyResult;
    public int field_wifiType;
    private boolean gdV = true;
    private boolean gdW = true;
    private boolean gdX = true;
    private boolean gdY = true;
    private boolean gdZ = true;
    private boolean gea = true;
    private boolean geb = true;
    private boolean gec = true;
    private boolean ged = true;
    private boolean gee = true;
    private boolean gef = true;
    private boolean geg = true;
    private boolean geh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gei == hashCode) {
                    this.field_ssidmd5 = cursor.getString(i);
                    this.gdV = true;
                } else if (gej == hashCode) {
                    this.field_ssid = cursor.getString(i);
                } else if (gek == hashCode) {
                    this.field_mid = cursor.getString(i);
                } else if (fVi == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (gel == hashCode) {
                    this.field_connectState = cursor.getInt(i);
                } else if (gem == hashCode) {
                    this.field_expiredTime = cursor.getLong(i);
                } else if (gen == hashCode) {
                    this.field_wifiType = cursor.getInt(i);
                } else if (geo == hashCode) {
                    this.field_action = cursor.getInt(i);
                } else if (gep == hashCode) {
                    this.field_showUrl = cursor.getString(i);
                } else if (geq == hashCode) {
                    this.field_showWordEn = cursor.getString(i);
                } else if (ger == hashCode) {
                    this.field_showWordCn = cursor.getString(i);
                } else if (ges == hashCode) {
                    this.field_showWordTw = cursor.getString(i);
                } else if (get == hashCode) {
                    this.field_mac = cursor.getString(i);
                } else if (geu == hashCode) {
                    this.field_verifyResult = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gdV) {
            contentValues.put("ssidmd5", this.field_ssidmd5);
        }
        if (this.gdW) {
            contentValues.put("ssid", this.field_ssid);
        }
        if (this.gdX) {
            contentValues.put("mid", this.field_mid);
        }
        if (this.fUP) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.gdY) {
            contentValues.put("connectState", Integer.valueOf(this.field_connectState));
        }
        if (this.gdZ) {
            contentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.gea) {
            contentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
        }
        if (this.geb) {
            contentValues.put("action", Integer.valueOf(this.field_action));
        }
        if (this.gec) {
            contentValues.put("showUrl", this.field_showUrl);
        }
        if (this.ged) {
            contentValues.put("showWordEn", this.field_showWordEn);
        }
        if (this.gee) {
            contentValues.put("showWordCn", this.field_showWordCn);
        }
        if (this.gef) {
            contentValues.put("showWordTw", this.field_showWordTw);
        }
        if (this.geg) {
            contentValues.put("mac", this.field_mac);
        }
        if (this.geh) {
            contentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
