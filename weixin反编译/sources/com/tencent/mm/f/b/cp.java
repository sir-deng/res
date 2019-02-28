package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class cp extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fRe = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int gnp = "sceneFlag".hashCode();
    private static final int gnq = "msgTypeFlag".hashCode();
    private static final int gnr = "msgState".hashCode();
    private boolean fNR = true;
    private boolean fPp = true;
    private boolean fQH = true;
    public String field_appId;
    public int field_msgState;
    public int field_msgTypeFlag;
    public String field_packageName;
    public int field_sceneFlag;
    public int field_status;
    private boolean gnm = true;
    private boolean gnn = true;
    private boolean gno = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.fPp = true;
                } else if (fRe == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gnp == hashCode) {
                    this.field_sceneFlag = cursor.getInt(i);
                } else if (gnq == hashCode) {
                    this.field_msgTypeFlag = cursor.getInt(i);
                } else if (gnr == hashCode) {
                    this.field_msgState = cursor.getInt(i);
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
        if (this.fQH) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gnm) {
            contentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
        }
        if (this.gnn) {
            contentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
        }
        if (this.gno) {
            contentValues.put("msgState", Integer.valueOf(this.field_msgState));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
