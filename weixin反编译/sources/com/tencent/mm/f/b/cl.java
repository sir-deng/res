package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class cl extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int gmR = "reqkey".hashCode();
    private static final int gmS = "ack_key".hashCode();
    private static final int gmT = "receive_time".hashCode();
    private boolean fNR = true;
    public String field_ack_key;
    public long field_receive_time;
    public String field_reqkey;
    public int field_status;
    private boolean gmO = true;
    private boolean gmP = true;
    private boolean gmQ = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmR == hashCode) {
                    this.field_reqkey = cursor.getString(i);
                    this.gmO = true;
                } else if (gmS == hashCode) {
                    this.field_ack_key = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (gmT == hashCode) {
                    this.field_receive_time = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gmO) {
            contentValues.put("reqkey", this.field_reqkey);
        }
        if (this.gmP) {
            contentValues.put("ack_key", this.field_ack_key);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.gmQ) {
            contentValues.put("receive_time", Long.valueOf(this.field_receive_time));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
