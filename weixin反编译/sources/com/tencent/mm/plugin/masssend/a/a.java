package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;

public final class a {
    int fEo = -1;
    public int feh = 0;
    public String filename = "";
    String hQI = "";
    int hXq = 0;
    public long hXs = 0;
    long hXt = 0;
    String hiX = "";
    String hiY = "";
    public int msgType = 0;
    String osr = "";
    public String oss = "";
    public int ost = 0;
    public int osu = 0;
    int osv = 0;
    int osw = 0;
    public int osx = 0;
    public int osy = 0;
    int status = 0;

    public final void b(Cursor cursor) {
        this.hQI = cursor.getString(0);
        this.status = cursor.getInt(1);
        this.hXs = cursor.getLong(2);
        this.hXt = cursor.getLong(3);
        this.filename = cursor.getString(4);
        this.osr = cursor.getString(5);
        this.oss = cursor.getString(6);
        this.ost = cursor.getInt(7);
        this.msgType = cursor.getInt(8);
        this.osu = cursor.getInt(9);
        this.osv = cursor.getInt(10);
        this.feh = cursor.getInt(11);
        this.hXq = cursor.getInt(12);
        this.osw = cursor.getInt(13);
        this.osx = cursor.getInt(14);
        this.osy = cursor.getInt(15);
        this.hiX = cursor.getString(16);
        this.hiY = cursor.getString(17);
    }

    public final String aZb() {
        return this.hQI == null ? "" : this.hQI;
    }

    public final String aZc() {
        return this.filename == null ? "" : this.filename;
    }

    public final String aZd() {
        return this.osr == null ? "" : this.osr;
    }

    public final String aZe() {
        return this.oss == null ? "" : this.oss;
    }
}
