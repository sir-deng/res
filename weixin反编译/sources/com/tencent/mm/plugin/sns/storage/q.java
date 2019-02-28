package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public final class q {
    long hXs;
    private int hxa;
    public int offset;
    public int ruM;
    private long rvq;
    public int rvr;
    public String rvs;
    private int rvt;
    private long rvu;
    public String rvv;
    public byte[] rvw;
    public int type;
    private String userName;

    public final ContentValues bzv() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("seqId", Long.valueOf(this.rvq));
        contentValues.put(Columns.TYPE, Integer.valueOf(this.type));
        contentValues.put("createTime", Long.valueOf(this.hXs));
        contentValues.put("userName", this.userName);
        contentValues.put("totallen", Integer.valueOf(this.rvr));
        contentValues.put("offset", Integer.valueOf(this.offset));
        contentValues.put("local_flag", Integer.valueOf(this.hxa));
        contentValues.put("tmp_path", this.rvs);
        contentValues.put("nums", Integer.valueOf(this.rvt));
        contentValues.put("try_times", Long.valueOf(this.rvu));
        contentValues.put("StrId", this.rvv);
        contentValues.put("upload_buf", this.rvw);
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.ruM = cursor.getInt(0);
        long j = cursor.getLong(1);
        this.rvq = j;
        this.rvv = i.er(j);
        this.type = cursor.getInt(2);
        this.hXs = cursor.getLong(3);
        this.userName = cursor.getString(4);
        this.rvr = cursor.getInt(5);
        this.offset = cursor.getInt(6);
        this.hxa = cursor.getInt(7);
        this.rvs = cursor.getString(8);
        this.rvt = cursor.getInt(9);
        this.rvu = cursor.getLong(10);
        this.rvv = cursor.getString(11);
        this.rvw = cursor.getBlob(12);
    }

    public final void bzw() {
        this.hxa |= 4;
    }

    public final void bzx() {
        this.hxa &= -5;
    }
}
