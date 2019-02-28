package com.tencent.mm.ac;

import android.content.ContentValues;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.wcdb.FileUtils;

public final class f {
    int fEo = -1;
    int hmW;
    int hmX;
    String hmY;
    int hmZ;
    int hna;
    int hnb;
    String hnc;
    String hnd;
    int hne;
    int hnf;
    String username;

    public f() {
        reset();
    }

    public final void reset() {
        this.username = "";
        this.hmW = 0;
        this.hmX = 0;
        this.hmY = "";
        this.hmZ = 0;
        this.hna = 0;
        this.hnb = 0;
        this.hnc = "";
        this.hnd = "";
        this.hne = 0;
        this.hnf = 0;
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("username", this.username == null ? "" : this.username);
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("imgwidth", Integer.valueOf(this.hmW));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("imgheigth", Integer.valueOf(this.hmX));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("imgformat", JK());
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("totallen", Integer.valueOf(this.hmZ));
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("startpos", Integer.valueOf(this.hna));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("headimgtype", Integer.valueOf(this.hnb));
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved1", this.hnc == null ? "" : this.hnc);
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("reserved2", this.hnd == null ? "" : this.hnd);
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hne));
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnf));
        }
        return contentValues;
    }

    public final String JK() {
        return this.hmY == null ? "" : this.hmY;
    }
}
