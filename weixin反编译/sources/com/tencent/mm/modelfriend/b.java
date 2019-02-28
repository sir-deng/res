package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class b {
    String bgo = "";
    public int fEo = -1;
    String fXd = "";
    private String frM = "";
    String gKZ = "";
    public String hnc = "";
    public int hnf = 0;
    String hwT = "";
    long hwU = 0;
    String hwV = "";
    String hwW = "";
    String hwX = "";
    String hwY = "";
    String hwZ = "";
    public int hxa = 0;
    public byte[] hxb;
    public int hxc;
    public String hxd = "";
    public int hxe = 0;
    public String hxf = "";
    public String hxg = "";
    public String hxh = "";
    int hxi = 0;
    public String hxj = "";
    int hxk = 0;
    int hxl = 0;
    String hxm = "";
    public String hxn = "";
    String hxo = "";
    int hxp = -1;
    String hxq = "";
    long hxr = -1;
    int hxs = -1;
    String hxt = "";
    String hxu = "";
    String hxv = "";
    long hxw = 0;
    private int id = 0;
    public int status = 0;
    public int type = 0;
    public String username = "";

    public final void b(Cursor cursor) {
        kT(cursor.getString(1));
        this.hwT = cursor.getString(2);
        this.hwU = cursor.getLong(3);
        this.gKZ = cursor.getString(4);
        this.hwV = cursor.getString(5);
        this.hwW = cursor.getString(6);
        this.username = cursor.getString(7);
        this.bgo = cursor.getString(8);
        this.hwX = cursor.getString(9);
        this.hwY = cursor.getString(10);
        this.type = cursor.getInt(11);
        this.hwZ = cursor.getString(12);
        this.fXd = cursor.getString(13);
        int i = cursor.getInt(14);
        if (i == 65536) {
            this.status = 0;
        } else {
            this.status = i;
        }
        this.hxa = cursor.getInt(17);
        this.hnc = cursor.getString(15);
        this.hnf = cursor.getInt(18);
        this.hxb = cursor.getBlob(19);
        if (!bi.by(this.hxb)) {
            byte[] bArr = this.hxb;
            try {
                u uVar = new u();
                i = uVar.bt(bArr);
                if (i != 0) {
                    x.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
                } else {
                    this.hxd = uVar.getString();
                    this.hxe = uVar.getInt();
                    this.hxf = uVar.getString();
                    this.hxg = uVar.getString();
                    this.hxh = uVar.getString();
                    this.hxi = uVar.getInt();
                    this.hxj = uVar.getString();
                    this.hxk = uVar.getInt();
                    this.hxl = uVar.getInt();
                    this.hxm = uVar.getString();
                    this.hxn = uVar.getString();
                    this.hxo = uVar.getString();
                    this.hxp = uVar.getInt();
                    this.hxq = uVar.getString();
                    this.hxr = uVar.getLong();
                    this.hxs = uVar.getInt();
                    this.hxt = uVar.getString();
                    this.hxu = uVar.getString();
                    this.hxv = uVar.getString();
                    this.hxw = uVar.getLong();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            }
        }
        this.hxc = cursor.getInt(20);
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if ((this.fEo & 1) != 0) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Integer.valueOf(this.id));
        }
        if ((this.fEo & 2) != 0) {
            contentValues.put("md5", Nx());
        }
        if ((this.fEo & 4) != 0) {
            contentValues.put("peopleid", Ny());
        }
        if ((this.fEo & 8) != 0) {
            contentValues.put("uploadtime", Long.valueOf(this.hwU));
        }
        if ((this.fEo & 16) != 0) {
            contentValues.put("realname", Nz());
        }
        if ((this.fEo & 32) != 0) {
            contentValues.put("realnamepyinitial", NA());
        }
        if ((this.fEo & 64) != 0) {
            contentValues.put("realnamequanpin", NB());
        }
        if ((this.fEo & FileUtils.S_IWUSR) != 0) {
            contentValues.put("username", getUsername());
        }
        if ((this.fEo & 256) != 0) {
            contentValues.put("nickname", NC());
        }
        if ((this.fEo & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamepyinitial", ND());
        }
        if ((this.fEo & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            contentValues.put("nicknamequanpin", NE());
        }
        if ((this.fEo & 2048) != 0) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.type));
        }
        if ((this.fEo & Downloads.RECV_BUFFER_SIZE) != 0) {
            contentValues.put("moblie", NF());
        }
        if ((this.fEo & 8192) != 0) {
            contentValues.put("email", NG());
        }
        if ((this.fEo & 16384) != 0) {
            int i = this.status;
            if (i == 0) {
                contentValues.put(DownloadInfo.STATUS, Integer.valueOf(65536));
            } else {
                contentValues.put(DownloadInfo.STATUS, Integer.valueOf(i));
            }
        }
        if ((this.fEo & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0) {
            contentValues.put("reserved1", this.hnc);
        }
        if ((this.fEo & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) != 0) {
            contentValues.put("reserved3", Integer.valueOf(this.hxa));
        }
        if ((this.fEo & 262144) != 0) {
            contentValues.put("reserved4", Integer.valueOf(this.hnf));
        }
        if ((this.fEo & SQLiteGlobal.journalSizeLimit) != 0) {
            this.hxb = Nw();
            contentValues.put("lvbuf", this.hxb);
        }
        if ((this.fEo & 1048576) != 0) {
            contentValues.put("showhead", Integer.valueOf(this.hxc));
        }
        return contentValues;
    }

    private byte[] Nw() {
        try {
            u uVar = new u();
            uVar.cfK();
            uVar.VA(this.hxd);
            uVar.Dw(this.hxe);
            uVar.VA(this.hxf);
            uVar.VA(this.hxg);
            uVar.VA(this.hxh);
            uVar.Dw(this.hxi);
            uVar.VA(this.hxj);
            uVar.Dw(this.hxk);
            uVar.Dw(this.hxl);
            uVar.VA(this.hxm);
            uVar.VA(this.hxn);
            uVar.VA(this.hxo);
            uVar.Dw(this.hxp);
            uVar.VA(this.hxq);
            uVar.fG(this.hxr);
            uVar.Dw(this.hxs);
            uVar.VA(this.hxt);
            uVar.VA(this.hxu);
            uVar.VA(this.hxv);
            uVar.fG(this.hxw);
            return uVar.cfL();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUpload", e, "", new Object[0]);
            return null;
        }
    }

    public static int kS(String str) {
        long j = 0;
        try {
            j = Long.parseLong(str.substring(0, 8), 16);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AddrUpload", e, "md5: %s", str);
        }
        return (int) j;
    }

    public final void kT(String str) {
        this.frM = str;
        this.id = kS(str);
    }

    public final String Nx() {
        return this.frM == null ? "" : this.frM;
    }

    public final String Ny() {
        return this.hwT == null ? "" : this.hwT;
    }

    public final String Nz() {
        return this.gKZ == null ? "" : this.gKZ;
    }

    public final String NA() {
        return this.hwV == null ? "" : this.hwV;
    }

    public final String NB() {
        return this.hwW == null ? "" : this.hwW;
    }

    public final String getUsername() {
        return this.username == null ? "" : this.username;
    }

    public final String NC() {
        return this.bgo == null ? "" : this.bgo;
    }

    public final String ND() {
        return this.hwX == null ? "" : this.hwX;
    }

    public final String NE() {
        return this.hwY == null ? "" : this.hwY;
    }

    public final String NF() {
        return this.hwZ == null ? "" : this.hwZ;
    }

    public final String NG() {
        return this.fXd == null ? "" : this.fXd;
    }

    public final void NH() {
        this.hxa |= 1;
    }

    public final boolean NI() {
        return (this.hxa & 1) == 0;
    }

    public final int Ak() {
        int i = 32;
        if (!bi.oN(NA())) {
            i = NA().charAt(0);
        } else if (!bi.oN(NB())) {
            i = NB().charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }
}
