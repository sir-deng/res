package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.wcdb.FileUtils;

public final class ab {
    int fEo = -1;
    String hyA = "";
    String hyB = "";
    int hyu = 0;
    int hyv = 0;
    int hyw = 0;
    int hyx = 0;
    int hyy = 0;
    int hyz = 0;

    public final void b(Cursor cursor) {
        this.hyu = cursor.getInt(0);
        this.hyv = cursor.getInt(1);
        this.hyw = cursor.getInt(2);
        this.hyx = cursor.getInt(3);
        this.hyy = cursor.getInt(4);
        this.hyz = cursor.getInt(5);
        this.hyA = cursor.getString(6);
        this.hyB = cursor.getString(7);
    }

    public final ContentValues Ox() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("grouopid", Integer.valueOf(this.hyu));
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("membernum", Integer.valueOf(this.hyv));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("weixinnum", Integer.valueOf(this.hyw));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("insert_time", Integer.valueOf(this.hyx));
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("lastupdate_time", Integer.valueOf(this.hyy));
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.hyz));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("updatekey", Oy());
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("groupname", Oz());
        }
        return contentValues;
    }

    public final String Oy() {
        return this.hyA == null ? "" : this.hyA;
    }

    public final String Oz() {
        return this.hyB == null ? "" : this.hyB;
    }
}
