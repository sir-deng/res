package com.tencent.mm.modelfriend;

import android.content.ContentValues;

public final class k {
    int fEo = -1;
    public int fXa = 0;
    public int fXj = 0;
    public String fXk = "";
    public String fXl = "";
    public String signature = "";
    public String username = "";

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("sex", Integer.valueOf(this.fXa));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("personalcard", Integer.valueOf(this.fXj));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("province", this.fXk == null ? "" : this.fXk);
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("city", this.fXl == null ? "" : this.fXl);
        }
        if ((this.fEo & 32) != 0) {
            String str;
            String str2 = "signature";
            if (this.signature == null) {
                str = "";
            } else {
                str = this.signature;
            }
            contentValues.put(str2, str);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }
}
