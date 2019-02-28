package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.FileUtils;

public final class bc {
    int fEo;
    public String name;
    int status;
    public a xIx;
    public int xIy;

    public static class a {
        private String fEx;
        private String fNc;

        public a(String str) {
            int indexOf = str.indexOf("@");
            if (indexOf >= 0) {
                this.fEx = str.substring(0, indexOf);
                this.fNc = str.substring(indexOf);
                return;
            }
            this.fEx = str;
            this.fNc = "";
        }

        public final String Yo(String str) {
            return this.fNc != null ? this.fNc : str;
        }
    }

    public bc() {
        this.fEo = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        this.name = "";
        this.xIx = null;
        this.xIx = null;
        this.name = "";
        this.status = 0;
        this.xIy = 0;
    }

    public bc(String str, boolean z, int i) {
        this.fEo = com.tencent.mm.plugin.appbrand.jsapi.map.a.CTRL_INDEX;
        this.name = "";
        this.xIx = null;
        this.xIx = new a(str);
        this.name = str;
        this.status = (z ? 1 : 0) | 2;
        this.xIy = i;
    }

    public final void gi(boolean z) {
        if (z) {
            this.status = (z ? 1 : 0) | this.status;
            return;
        }
        this.status &= -2;
    }

    public final boolean isEnable() {
        return (this.status & 1) != 0;
    }

    public final boolean ckH() {
        return (this.status & 2) != 0;
    }

    public final void b(Cursor cursor) {
        if ((this.fEo & 2) != 0) {
            this.name = cursor.getString(1);
            if (this.xIx == null) {
                this.xIx = new a(this.name);
            }
        }
        if ((this.fEo & 4) != 0) {
            this.status = cursor.getInt(2);
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            this.xIy = cursor.getInt(7);
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 2) != 0) {
            contentValues.put("name", this.name);
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("int_reserved1", Integer.valueOf(this.xIy));
        }
        return contentValues;
    }
}
