package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class r extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fSi = "deviceId".hashCode();
    private static final int fSj = "sessionName".hashCode();
    private static final int fSk = "moveTime".hashCode();
    private boolean fSf = true;
    private boolean fSg = true;
    private boolean fSh = true;
    public String field_deviceId;
    public eq field_moveTime;
    public String field_sessionName;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fSi == hashCode) {
                    this.field_deviceId = cursor.getString(i);
                } else if (fSj == hashCode) {
                    this.field_sessionName = cursor.getString(i);
                } else if (fSk == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_moveTime = (eq) new eq().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
                    }
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.field_deviceId == null) {
            this.field_deviceId = "";
        }
        if (this.fSf) {
            contentValues.put("deviceId", this.field_deviceId);
        }
        if (this.field_sessionName == null) {
            this.field_sessionName = "";
        }
        if (this.fSg) {
            contentValues.put("sessionName", this.field_sessionName);
        }
        if (this.fSh && this.field_moveTime != null) {
            try {
                contentValues.put("moveTime", this.field_moveTime.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseBackupMoveTime", e.getMessage());
            }
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
