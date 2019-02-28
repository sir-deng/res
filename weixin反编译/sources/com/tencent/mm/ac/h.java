package com.tencent.mm.ac;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bi;

public final class h {
    public int fEo = -1;
    public int fWZ = 0;
    int hng = 0;
    public String hnh = "";
    public String hni = "";
    private int hnj = 0;
    int hnk = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        this.username = cursor.getString(0);
        this.fWZ = cursor.getInt(1);
        this.hng = cursor.getInt(2);
        this.hni = cursor.getString(3);
        this.hnh = cursor.getString(4);
        this.hnj = cursor.getInt(5);
        this.hnk = cursor.getInt(6);
    }

    public final ContentValues JL() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("imgflag", Integer.valueOf(this.fWZ));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("lastupdatetime", Integer.valueOf(this.hng));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("reserved1", JM());
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("reserved2", JN());
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hnj));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnk));
        }
        return contentValues;
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String JM() {
        return this.hni == null ? "" : this.hni;
    }

    public final void jo(String str) {
        this.hnh = str;
    }

    public final String JN() {
        return this.hnh == null ? "" : this.hnh;
    }

    public final void bC(boolean z) {
        this.hnj = z ? 1 : 0;
    }

    public final void JO() {
        this.hnk = (int) (bi.Wx() / 60);
        this.fEo |= 64;
    }
}
