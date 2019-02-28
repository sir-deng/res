package com.tencent.mm.ay;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;

public final class m {
    int fEo = -1;
    private String fvn = (this.id + "_" + this.fwH);
    public int fwH = 0;
    String hLz = "";
    private String hnc = "";
    private String hnd = "";
    private int hne = 0;
    private int hnf = 0;
    public int id = 0;
    String name = "";
    int size = 0;
    public int status = 0;
    public int version = 0;

    public final void b(Cursor cursor) {
        this.version = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.size = cursor.getInt(4);
        this.hLz = cursor.getString(5);
        this.status = cursor.getInt(6);
        this.hnc = cursor.getString(8);
        this.hnd = cursor.getString(9);
        this.fwH = cursor.getInt(7);
        this.hnf = cursor.getInt(11);
        this.id = cursor.getInt(1);
        this.hne = cursor.getInt(10);
        this.fvn = cursor.getString(0);
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 2) != 0) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.id));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("version", Integer.valueOf(this.version));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("name", this.name == null ? "" : this.name);
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("size", Integer.valueOf(this.size));
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("packname", QK());
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.fwH));
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("reserved1", this.hnc == null ? "" : this.hnc);
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved2", this.hnd == null ? "" : this.hnd);
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hne));
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnf));
        }
        if ((this.fEo & 1) != 0) {
            contentValues.put("localId", this.id + "_" + this.fwH);
        }
        return contentValues;
    }

    public final String QK() {
        return this.hLz == null ? "" : this.hLz;
    }
}
