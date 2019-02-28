package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class dh extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPa = "content".hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int fSM = "isSend".hashCode();
    private static final int gaj = "svrid".hashCode();
    private static final int gbv = "talker".hashCode();
    private static final int ghU = "createtime".hashCode();
    private static final int ghV = "sayhiuser".hashCode();
    private static final int ghW = "sayhicontent".hashCode();
    private static final int ghX = "imgpath".hashCode();
    private boolean fNR = true;
    private boolean fOE = true;
    private boolean fOz = true;
    private boolean fPl = true;
    private boolean fSy = true;
    private boolean fZK = true;
    public String field_content;
    public long field_createtime;
    public String field_imgpath;
    public int field_isSend;
    public String field_sayhicontent;
    public String field_sayhiuser;
    public int field_scene;
    public int field_status;
    public long field_svrid;
    public String field_talker;
    public int field_type;
    private boolean gbf = true;
    private boolean ghP = true;
    private boolean ghQ = true;
    private boolean ghR = true;
    private boolean ghS = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gaj == hashCode) {
                    this.field_svrid = cursor.getLong(i);
                    this.fZK = true;
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (ghU == hashCode) {
                    this.field_createtime = cursor.getLong(i);
                } else if (gbv == hashCode) {
                    this.field_talker = cursor.getString(i);
                } else if (fPa == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (ghV == hashCode) {
                    this.field_sayhiuser = cursor.getString(i);
                } else if (ghW == hashCode) {
                    this.field_sayhicontent = cursor.getString(i);
                } else if (ghX == hashCode) {
                    this.field_imgpath = cursor.getString(i);
                } else if (fSM == hashCode) {
                    this.field_isSend = cursor.getInt(i);
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
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.ghP) {
            contentValues.put("createtime", Long.valueOf(this.field_createtime));
        }
        if (this.gbf) {
            contentValues.put("talker", this.field_talker);
        }
        if (this.fOE) {
            contentValues.put("content", this.field_content);
        }
        if (this.ghQ) {
            contentValues.put("sayhiuser", this.field_sayhiuser);
        }
        if (this.ghR) {
            contentValues.put("sayhicontent", this.field_sayhicontent);
        }
        if (this.ghS) {
            contentValues.put("imgpath", this.field_imgpath);
        }
        if (this.fSy) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
