package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cm extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int gmZ = "acctTypeId".hashCode();
    private static final int gna = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int gnb = "accTypeRec".hashCode();
    private boolean fPY = true;
    public ar field_accTypeRec;
    public String field_acctTypeId;
    public String field_language;
    public long field_updateTime;
    private boolean gmV = true;
    private boolean gmW = true;
    private boolean gmX = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmZ == hashCode) {
                    this.field_acctTypeId = cursor.getString(i);
                } else if (gna == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (gnb == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_accTypeRec = (ar) new ar().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e.getMessage());
                    }
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
        if (this.gmV) {
            contentValues.put("acctTypeId", this.field_acctTypeId);
        }
        if (this.gmW) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.gmX && this.field_accTypeRec != null) {
            try {
                contentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", e.getMessage());
            }
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
