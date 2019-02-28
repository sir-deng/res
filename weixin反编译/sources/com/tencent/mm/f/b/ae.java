package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public abstract class ae extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS CardQrCodeDataInfo_card_id_index ON CardQrCodeDataInfo(card_id)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fVH = "code_id".hashCode();
    private static final int fVI = TMQQDownloaderOpenSDKConst.UINTYPE_CODE.hashCode();
    private static final int fVd = "card_id".hashCode();
    private boolean fNR = true;
    private boolean fUK = true;
    private boolean fVF = true;
    private boolean fVG = true;
    public String field_card_id;
    public String field_code;
    public String field_code_id;
    public int field_status;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fVH == hashCode) {
                    this.field_code_id = cursor.getString(i);
                } else if (fVd == hashCode) {
                    this.field_card_id = cursor.getString(i);
                } else if (fVI == hashCode) {
                    this.field_code = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.fVF) {
            contentValues.put("code_id", this.field_code_id);
        }
        if (this.fUK) {
            contentValues.put("card_id", this.field_card_id);
        }
        if (this.fVG) {
            contentValues.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, this.field_code);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
