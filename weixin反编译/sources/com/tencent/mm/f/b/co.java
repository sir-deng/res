package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;

public abstract class co extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int gmY = "appid".hashCode();
    private static final int gna = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int gni = "wordingId".hashCode();
    private static final int gnj = "wording".hashCode();
    private static final int gnk = "pinyin".hashCode();
    private static final int gnl = "quanpin".hashCode();
    private boolean fPY = true;
    public String field_appid;
    public String field_language;
    public String field_pinyin;
    public String field_quanpin;
    public long field_updateTime;
    public String field_wording;
    public String field_wordingId;
    private boolean gmU = true;
    private boolean gmW = true;
    private boolean gne = true;
    private boolean gnf = true;
    private boolean gng = true;
    private boolean gnh = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmY == hashCode) {
                    this.field_appid = cursor.getString(i);
                } else if (gni == hashCode) {
                    this.field_wordingId = cursor.getString(i);
                } else if (gna == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (gnj == hashCode) {
                    this.field_wording = cursor.getString(i);
                } else if (gnk == hashCode) {
                    this.field_pinyin = cursor.getString(i);
                } else if (gnl == hashCode) {
                    this.field_quanpin = cursor.getString(i);
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gmU) {
            contentValues.put("appid", this.field_appid);
        }
        if (this.gne) {
            contentValues.put("wordingId", this.field_wordingId);
        }
        if (this.gmW) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.gnf) {
            contentValues.put("wording", this.field_wording);
        }
        if (this.gng) {
            contentValues.put("pinyin", this.field_pinyin);
        }
        if (this.gnh) {
            contentValues.put("quanpin", this.field_quanpin);
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
