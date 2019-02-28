package com.tencent.mm.plugin.qmessage.a;

import android.content.ContentValues;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public final class d {
    String extInfo = "";
    public int fEo = -1;
    int hiV = 0;
    int hne = 0;
    int hnf = 0;
    int hxZ = 0;
    long hyC = 0;
    public int ptd = 0;
    public long pte = 0;
    public long ptf = 0;
    String ptg = "";
    String pth = "";
    String pti = "";
    String ptj = "";
    public String username = "";

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("qq", Long.valueOf(this.hyC));
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("extinfo", bkD());
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("needupdate", Integer.valueOf(this.ptd));
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("extupdateseq", Long.valueOf(this.pte));
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("imgupdateseq", Long.valueOf(this.ptf));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hiV));
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("reserved2", Integer.valueOf(this.hxZ));
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hne));
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnf));
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved5", this.ptg == null ? "" : this.ptg);
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put("reserved6", this.pth == null ? "" : this.pth);
        }
        if ((this.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("reserved7", this.pti == null ? "" : this.pti);
        }
        if ((this.fEo & 8192) != 0) {
            contentValues.put("reserved8", this.ptj == null ? "" : this.ptj);
        }
        return contentValues;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String bkD() {
        return this.extInfo == null ? "" : this.extInfo;
    }
}
