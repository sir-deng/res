package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cy extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOi = "startTime".hashCode();
    private static final int fOj = "endTime".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int gnP = "reportId".hashCode();
    private static final int gof = "launchProtoBlob".hashCode();
    private boolean fOa = true;
    private boolean fOb = true;
    private boolean fPl = true;
    private boolean fPp = true;
    public String field_appId;
    public long field_endTime;
    public byte[] field_launchProtoBlob;
    public long field_reportId;
    public int field_scene;
    public long field_startTime;
    private boolean gnM = true;
    private boolean goe = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (gof == hashCode) {
                    this.field_launchProtoBlob = cursor.getBlob(i);
                } else if (fOi == hashCode) {
                    this.field_startTime = cursor.getLong(i);
                } else if (fOj == hashCode) {
                    this.field_endTime = cursor.getLong(i);
                } else if (gnP == hashCode) {
                    this.field_reportId = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.goe) {
            contentValues.put("launchProtoBlob", this.field_launchProtoBlob);
        }
        if (this.fOa) {
            contentValues.put("startTime", Long.valueOf(this.field_startTime));
        }
        if (this.fOb) {
            contentValues.put("endTime", Long.valueOf(this.field_endTime));
        }
        if (this.gnM) {
            contentValues.put("reportId", Long.valueOf(this.field_reportId));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
