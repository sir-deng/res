package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;

public final class i {
    public String fEe = "";
    public long hjV = 0;
    public long mRO = 0;
    public long mRP = 0;
    public long mRQ = 0;
    public String mRR = "";
    public int mRc = 0;
    public String mRd = "";
    public long timestamp = 0;
    public int type = 0;

    public final void b(Cursor cursor) {
        this.mRO = cursor.getLong(0);
        this.fEe = cursor.getString(1);
        this.mRP = cursor.getLong(2);
        this.hjV = cursor.getLong(3);
        this.mRd = cursor.getString(4);
        this.mRQ = cursor.getLong(5);
        this.type = cursor.getInt(6);
        this.mRc = cursor.getInt(7);
        this.timestamp = cursor.getLong(8);
        this.mRR = cursor.getString(9);
    }
}
