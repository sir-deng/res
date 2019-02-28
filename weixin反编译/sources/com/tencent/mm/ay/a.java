package com.tencent.mm.ay;

import android.content.ContentValues;
import android.database.Cursor;

public final class a {
    int fEo = -1;
    public int hKZ = 0;
    private String hnc = "";
    private String hnd = "";
    private int hne = 0;
    private int hnf = 0;
    private String path = "";
    public String username = "";

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.hKZ = cursor.getInt(1);
        this.path = cursor.getString(2);
        this.hnc = cursor.getString(3);
        this.hnd = cursor.getString(4);
        this.hne = cursor.getInt(5);
        this.hnf = cursor.getInt(6);
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("bgflag", Integer.valueOf(this.hKZ));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("path", this.path == null ? "" : this.path);
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("reserved1", this.hnc == null ? "" : this.hnc);
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("reserved2", this.hnd == null ? "" : this.hnd);
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hne));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnf));
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
