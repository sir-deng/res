package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class p {
    public String clientId = "";
    public int fEo = -1;
    public String fEx = "";
    public long fGj = 0;
    public String fileName = "";
    int gkC = 0;
    String gkD = "";
    int hGx = 0;
    public int hWd = 0;
    public String hXn = "";
    public int hXp = 0;
    public long hXs = 0;
    public long hXt = 0;
    public int hXw = 0;
    int hXx = 0;
    String hYj = "";
    int hYq = 0;
    public int hZq = 0;
    long hZr = 0;
    int hZs = 0;
    public int hmZ = 0;
    public int status = 0;

    public final boolean UN() {
        if (this.status == 5 || this.status == 6) {
            return true;
        }
        return false;
    }

    public final boolean UO() {
        if ((this.status <= 1 || this.status > 3) && this.status != 8) {
            return false;
        }
        return true;
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put("FileName", this.fileName);
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("User", this.fEx);
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("MsgId", Long.valueOf(this.fGj));
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("NetOffset", Integer.valueOf(this.hWd));
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("FileNowSize", Integer.valueOf(this.hXp));
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("TotalLen", Integer.valueOf(this.hmZ));
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("Status", Integer.valueOf(this.status));
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("CreateTime", Long.valueOf(this.hXs));
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("LastModifyTime", Long.valueOf(this.hXt));
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("ClientId", this.clientId);
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("VoiceLength", Integer.valueOf(this.hZq));
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put("MsgLocalId", Integer.valueOf(this.hXw));
        }
        if ((this.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("Human", this.hXn);
        }
        if ((this.fEo & 8192) != 0) {
            contentValues.put("reserved1", Integer.valueOf(this.hXx));
        }
        if ((this.fEo & 16384) != 0) {
            contentValues.put("reserved2", this.hYj);
        }
        if ((this.fEo & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("MsgSource", this.gkD);
        }
        if ((this.fEo & 65536) != 0) {
            contentValues.put("MsgFlag", Integer.valueOf(this.gkC));
        }
        if ((this.fEo & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("MsgSeq", Integer.valueOf(this.hGx));
        }
        if ((this.fEo & 262144) != 0) {
            contentValues.put("MasterBufId", Long.valueOf(this.hZr));
        }
        if ((this.fEo & SQLiteGlobal.journalSizeLimit) != 0) {
            contentValues.put("checksum", Integer.valueOf(this.hZs));
        }
        return contentValues;
    }

    public final void b(Cursor cursor) {
        this.fileName = cursor.getString(0);
        this.fEx = cursor.getString(1);
        this.fGj = cursor.getLong(2);
        this.hWd = cursor.getInt(3);
        this.hXp = cursor.getInt(4);
        this.hmZ = cursor.getInt(5);
        this.status = cursor.getInt(6);
        this.hXs = cursor.getLong(7);
        this.hXt = cursor.getLong(8);
        this.clientId = cursor.getString(9);
        this.hZq = cursor.getInt(10);
        this.hXw = cursor.getInt(11);
        this.hXn = cursor.getString(12);
        this.hXx = cursor.getInt(13);
        this.hYj = cursor.getString(14);
        this.gkD = cursor.getString(15);
        this.gkC = cursor.getInt(16);
        this.hGx = cursor.getInt(17);
        this.hZr = cursor.getLong(18);
        this.hZs = cursor.getInt(19);
    }
}
