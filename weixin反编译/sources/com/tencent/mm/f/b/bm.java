package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm extends c {
    public static final String[] fNF = new String[0];
    private static final int fNN = "msgId".hashCode();
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fOs = "rawXML".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fSN = "msgType".hashCode();
    private static final int gfg = "mergerId".hashCode();
    private static final int gfh = "gameMsgId".hashCode();
    private static final int gfi = "expireTime".hashCode();
    private static final int gfj = "showInMsgList".hashCode();
    private static final int gfk = "isRead".hashCode();
    private static final int gfl = "label".hashCode();
    private static final int gfm = "isHidden".hashCode();
    private static final int gfn = "weight".hashCode();
    private static final int gfo = "receiveTime".hashCode();
    private boolean fNJ = true;
    private boolean fOo = true;
    private boolean fOw = true;
    private boolean fPp = true;
    private boolean fSz = true;
    public String field_appId;
    public long field_createTime;
    public long field_expireTime;
    public String field_gameMsgId;
    public boolean field_isHidden;
    public boolean field_isRead;
    public String field_label;
    public String field_mergerId;
    public long field_msgId;
    public int field_msgType;
    public String field_rawXML;
    public long field_receiveTime;
    public boolean field_showInMsgList;
    public String field_weight;
    private boolean geX = true;
    private boolean geY = true;
    private boolean geZ = true;
    private boolean gfa = true;
    private boolean gfb = true;
    private boolean gfc = true;
    private boolean gfd = true;
    private boolean gfe = true;
    private boolean gff = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fNN == hashCode) {
                    this.field_msgId = cursor.getLong(i);
                    this.fNJ = true;
                } else if (gfg == hashCode) {
                    this.field_mergerId = cursor.getString(i);
                } else if (gfh == hashCode) {
                    this.field_gameMsgId = cursor.getString(i);
                } else if (fSN == hashCode) {
                    this.field_msgType = cursor.getInt(i);
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gfi == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gfj == hashCode) {
                    this.field_showInMsgList = cursor.getInt(i) != 0;
                } else if (gfk == hashCode) {
                    this.field_isRead = cursor.getInt(i) != 0;
                } else if (gfl == hashCode) {
                    this.field_label = cursor.getString(i);
                } else if (gfm == hashCode) {
                    this.field_isHidden = cursor.getInt(i) != 0;
                } else if (gfn == hashCode) {
                    this.field_weight = cursor.getString(i);
                } else if (fOs == hashCode) {
                    this.field_rawXML = cursor.getString(i);
                } else if (gfo == hashCode) {
                    this.field_receiveTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fNJ) {
            contentValues.put("msgId", Long.valueOf(this.field_msgId));
        }
        if (this.geX) {
            contentValues.put("mergerId", this.field_mergerId);
        }
        if (this.geY) {
            contentValues.put("gameMsgId", this.field_gameMsgId);
        }
        if (this.fSz) {
            contentValues.put("msgType", Integer.valueOf(this.field_msgType));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.geZ) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gfa) {
            contentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
        }
        if (this.gfb) {
            contentValues.put("isRead", Boolean.valueOf(this.field_isRead));
        }
        if (this.field_label == null) {
            this.field_label = "";
        }
        if (this.gfc) {
            contentValues.put("label", this.field_label);
        }
        if (this.gfd) {
            contentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
        }
        if (this.field_weight == null) {
            this.field_weight = "";
        }
        if (this.gfe) {
            contentValues.put("weight", this.field_weight);
        }
        if (this.field_rawXML == null) {
            this.field_rawXML = "";
        }
        if (this.fOo) {
            contentValues.put("rawXML", this.field_rawXML);
        }
        if (this.gff) {
            contentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
