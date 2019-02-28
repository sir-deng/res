package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.e.c;

public abstract class ao extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int fQg = SlookAirButtonFrequentContactAdapter.DATA.hashCode();
    private static final int fYG = SlookAirButtonFrequentContactAdapter.ID.hashCode();
    private static final int fYH = "cacheKey".hashCode();
    private static final int fYI = "interval".hashCode();
    private boolean fPY = true;
    private boolean fPp = true;
    private boolean fQd = true;
    private boolean fYD = true;
    private boolean fYE = true;
    private boolean fYF = true;
    public String field_appId;
    public String field_cacheKey;
    public String field_data;
    public String field_id;
    public int field_interval;
    public long field_updateTime;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fYG == hashCode) {
                    this.field_id = cursor.getString(i);
                } else if (fYH == hashCode) {
                    this.field_cacheKey = cursor.getString(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fQg == hashCode) {
                    this.field_data = cursor.getString(i);
                } else if (fYI == hashCode) {
                    this.field_interval = cursor.getInt(i);
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
        if (this.fYD) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, this.field_id);
        }
        if (this.fYE) {
            contentValues.put("cacheKey", this.field_cacheKey);
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fQd) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.DATA, this.field_data);
        }
        if (this.fYF) {
            contentValues.put("interval", Integer.valueOf(this.field_interval));
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
