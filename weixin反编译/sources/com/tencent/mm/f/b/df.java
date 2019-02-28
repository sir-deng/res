package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fPn = "scene".hashCode();
    private static final int gpA = "productId".hashCode();
    private static final int gpB = "xmlContent".hashCode();
    private static final int gpC = "ScanTime".hashCode();
    private static final int gpD = "funcType".hashCode();
    private static final int gpE = "qrcodeUrl".hashCode();
    private boolean fPl = true;
    public long field_ScanTime;
    public int field_funcType;
    public String field_productId;
    public String field_qrcodeUrl;
    public int field_scene;
    public String field_xmlContent;
    private boolean gpv = true;
    private boolean gpw = true;
    private boolean gpx = true;
    private boolean gpy = true;
    private boolean gpz = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gpA == hashCode) {
                    this.field_productId = cursor.getString(i);
                    this.gpv = true;
                } else if (gpB == hashCode) {
                    this.field_xmlContent = cursor.getString(i);
                } else if (gpC == hashCode) {
                    this.field_ScanTime = cursor.getLong(i);
                } else if (gpD == hashCode) {
                    this.field_funcType = cursor.getInt(i);
                } else if (gpE == hashCode) {
                    this.field_qrcodeUrl = cursor.getString(i);
                } else if (fPn == hashCode) {
                    this.field_scene = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gpv) {
            contentValues.put("productId", this.field_productId);
        }
        if (this.gpw) {
            contentValues.put("xmlContent", this.field_xmlContent);
        }
        if (this.gpx) {
            contentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
        }
        if (this.gpy) {
            contentValues.put("funcType", Integer.valueOf(this.field_funcType));
        }
        if (this.gpz) {
            contentValues.put("qrcodeUrl", this.field_qrcodeUrl);
        }
        if (this.fPl) {
            contentValues.put("scene", Integer.valueOf(this.field_scene));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
