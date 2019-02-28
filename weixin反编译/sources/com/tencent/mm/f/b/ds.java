package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.e.c;

public abstract class ds extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fYG = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int gdi = "timestamp".hashCode();
    private static final int ghe = "step".hashCode();
    private static final int gsk = FFmpegMetadataRetriever.METADATA_KEY_DATE.hashCode();
    private boolean fYD = true;
    public String field_date;
    public int field_id;
    public int field_step;
    public long field_timestamp;
    private boolean gcY = true;
    private boolean ghd = true;
    private boolean gsj = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYG == hashCode) {
                    this.field_id = cursor.getInt(i);
                    this.fYD = true;
                } else if (gsk == hashCode) {
                    this.field_date = cursor.getString(i);
                } else if (ghe == hashCode) {
                    this.field_step = cursor.getInt(i);
                } else if (gdi == hashCode) {
                    this.field_timestamp = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fYD) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.field_id));
        }
        if (this.gsj) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DATE, this.field_date);
        }
        if (this.ghd) {
            contentValues.put("step", Integer.valueOf(this.field_step));
        }
        if (this.gcY) {
            contentValues.put("timestamp", Long.valueOf(this.field_timestamp));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
