package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public abstract class cn extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fQa = "updateTime".hashCode();
    private static final int gmY = "appid".hashCode();
    private static final int gmZ = "acctTypeId".hashCode();
    private static final int gna = FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE.hashCode();
    private static final int gnd = "appRec".hashCode();
    private boolean fPY = true;
    public String field_acctTypeId;
    public cx field_appRec;
    public String field_appid;
    public String field_language;
    public long field_updateTime;
    private boolean gmU = true;
    private boolean gmV = true;
    private boolean gmW = true;
    private boolean gnc = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gmY == hashCode) {
                    this.field_appid = cursor.getString(i);
                } else if (gna == hashCode) {
                    this.field_language = cursor.getString(i);
                } else if (gnd == hashCode) {
                    try {
                        byte[] blob = cursor.getBlob(i);
                        if (blob != null && blob.length > 0) {
                            this.field_appRec = (cx) new cx().aH(blob);
                        }
                    } catch (IOException e) {
                        x.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", e.getMessage());
                    }
                } else if (fQa == hashCode) {
                    this.field_updateTime = cursor.getLong(i);
                } else if (gmZ == hashCode) {
                    this.field_acctTypeId = cursor.getString(i);
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
        if (this.gmW) {
            contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, this.field_language);
        }
        if (this.gnc && this.field_appRec != null) {
            try {
                contentValues.put("appRec", this.field_appRec.toByteArray());
            } catch (IOException e) {
                x.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", e.getMessage());
            }
        }
        if (this.fPY) {
            contentValues.put("updateTime", Long.valueOf(this.field_updateTime));
        }
        if (this.gmV) {
            contentValues.put("acctTypeId", this.field_acctTypeId);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
