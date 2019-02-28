package com.tencent.mm.plugin.shake.a.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class a extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fRY = "title".hashCode();
    private static final int gaM = "desc".hashCode();
    private static final int gaj = "svrid".hashCode();
    private static final int gao = "reserved1".hashCode();
    private static final int gap = "reserved2".hashCode();
    private static final int gaq = "reserved3".hashCode();
    private static final int gcO = "subtype".hashCode();
    private static final int gdc = "tag".hashCode();
    private static final int ghU = "createtime".hashCode();
    private static final int qtt = "thumburl".hashCode();
    private static final int qtu = "reservedBuf".hashCode();
    private boolean fNR = true;
    private boolean fOz = true;
    private boolean fRU = true;
    private boolean fZK = true;
    private boolean fZP = true;
    private boolean fZQ = true;
    private boolean fZR = true;
    public long field_createtime;
    public String field_desc;
    public String field_reserved1;
    public String field_reserved2;
    public int field_reserved3;
    public byte[] field_reservedBuf;
    public int field_status;
    public int field_subtype;
    public long field_svrid;
    public String field_tag;
    public String field_thumburl;
    public String field_title;
    public int field_type;
    private boolean gaI = true;
    private boolean gcM = true;
    private boolean gcS = true;
    private boolean ghP = true;
    private boolean qtr = true;
    private boolean qts = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaj == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.fZK = true;
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gcO == hashCode) {
                    this.field_subtype = cursor.getInt(i);
                } else if (ghU == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gdc == hashCode) {
                    this.field_tag = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fRY == hashCode) {
                    this.field_title = cursor.getString(i);
                } else if (gaM == hashCode) {
                    this.field_desc = cursor.getString(i);
                } else if (qtt == hashCode) {
                    this.field_thumburl = cursor.getString(i);
                } else if (gao == hashCode) {
                    this.field_reserved1 = cursor.getString(i);
                } else if (gap == hashCode) {
                    this.field_reserved2 = cursor.getString(i);
                } else if (gaq == hashCode) {
                    this.field_reserved3 = cursor.getInt(i);
                } else if (qtu == hashCode) {
                    this.field_reservedBuf = cursor.getBlob(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fZK) {
            contentValues.put("svrid", Long.valueOf(this.field_svrid));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gcM) {
            contentValues.put("subtype", Integer.valueOf(this.field_subtype));
        }
        if (this.ghP) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gcS) {
            contentValues.put("tag", this.field_tag);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fRU) {
            contentValues.put("title", this.field_title);
        }
        if (this.gaI) {
            contentValues.put("desc", this.field_desc);
        }
        if (this.qtr) {
            contentValues.put("thumburl", this.field_thumburl);
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
        if (this.qts) {
            contentValues.put("reservedBuf", this.field_reservedBuf);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
