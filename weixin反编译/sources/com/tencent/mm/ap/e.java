package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class e {
    int cPf;
    public int fEo = -2;
    public long fGj;
    int gkI = 0;
    public long hBA;
    public String hBB = "";
    public String hBC = "";
    public String hBD = "";
    public int hBE;
    int hBF;
    private String hBG = "";
    int hBH;
    public long hBI;
    int hBJ;
    public int hBK = 0;
    public String hBL = "";
    int hBM = 1;
    private boolean hBN;
    private boolean hBO;
    private boolean hBP;
    private boolean hBQ;
    private boolean hBR;
    private boolean hBS;
    private boolean hBT;
    private boolean hBU;
    private boolean hBV;
    private boolean hBW;
    private boolean hBX;
    private boolean hBY;
    boolean hBZ;
    private boolean hCa;
    boolean hCb;
    private boolean hCc;
    private boolean hCd;
    private boolean hCe;
    private boolean hCf;
    public int hmZ;
    public int offset;
    public int status;

    public final void li(String str) {
        this.hBG = str;
        this.hCd = true;
    }

    public final void eR(int i) {
        this.status = i;
        this.hBW = true;
    }

    public final void hM(int i) {
        this.hBJ = i;
        this.hBX = true;
    }

    public final void hN(int i) {
        this.hBH = i;
        this.hBU = true;
    }

    public final void bg(long j) {
        this.hBI = j;
        this.hBV = true;
    }

    public final void bh(long j) {
        this.hBA = j;
        this.hBN = true;
    }

    public final void ap(long j) {
        if (this.fGj != j) {
            this.hBO = true;
        }
        this.fGj = j;
    }

    public final void setOffset(int i) {
        int i2 = 0;
        if (this.offset != i) {
            this.hBP = true;
        }
        this.offset = i;
        x.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", Integer.valueOf(i), Long.valueOf(this.hBI), Integer.valueOf(this.hmZ));
        if (i >= this.hmZ) {
            i2 = 1;
        }
        hR(i2);
    }

    public final void hO(int i) {
        this.hmZ = i;
        this.hBQ = true;
    }

    public final void lj(String str) {
        this.hBB = str;
        this.hBR = true;
    }

    public final void lk(String str) {
        this.hBC = str;
        this.hBS = true;
    }

    public final void ll(String str) {
        this.hBD = str;
        this.hBT = true;
    }

    public final void hP(int i) {
        this.hBK = i;
        this.hBY = true;
    }

    public final void hQ(int i) {
        this.hBF = i;
        this.hCf = true;
    }

    public final boolean Pj() {
        return this.hmZ != 0 && this.hmZ == this.offset;
    }

    public final boolean Pk() {
        return this.hBK > 0;
    }

    public final void lm(String str) {
        if ((this.hBL == null && str != null) || !(this.hBL == null || this.hBL.equals(str))) {
            this.hCa = true;
        }
        this.hBL = str;
    }

    public final void b(Cursor cursor) {
        this.hBA = (long) cursor.getInt(0);
        this.fGj = cursor.getLong(1);
        this.offset = cursor.getInt(2);
        this.hmZ = cursor.getInt(3);
        this.hBB = cursor.getString(4);
        this.hBD = cursor.getString(5);
        this.hBH = cursor.getInt(6);
        this.hBI = (long) cursor.getInt(7);
        this.status = cursor.getInt(8);
        this.hBJ = cursor.getInt(9);
        this.hBK = cursor.getInt(10);
        this.cPf = cursor.getInt(11);
        this.hBL = cursor.getString(12);
        this.gkI = cursor.getInt(14);
        this.hBM = cursor.getInt(15);
        this.hBG = cursor.getString(16);
        this.hBE = cursor.getInt(17);
        this.hBC = cursor.getString(18);
        this.hBF = cursor.getInt(19);
    }

    public final void hR(int i) {
        if (this.hBM != i) {
            this.hCc = true;
        }
        this.hBM = i;
    }

    public final void hS(int i) {
        this.hBE = i;
        this.hCe = true;
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.hBN) {
            contentValues.put(SlookAirButtonFrequentContactAdapter.ID, Long.valueOf(this.hBA));
        }
        if (this.hBO) {
            contentValues.put("msgSvrId", Long.valueOf(this.fGj));
        }
        if (this.hBP) {
            contentValues.put("offset", Integer.valueOf(this.offset));
        }
        if (this.hBQ) {
            contentValues.put("totalLen", Integer.valueOf(this.hmZ));
        }
        if (this.hBR) {
            contentValues.put("bigImgPath", this.hBB);
        }
        if (this.hBS) {
            contentValues.put("midImgPath", this.hBC);
        }
        if (this.hBT) {
            contentValues.put("thumbImgPath", this.hBD);
        }
        if (this.hBU) {
            contentValues.put("createtime", Integer.valueOf(this.hBH));
        }
        if (this.hBV) {
            contentValues.put("msglocalid", Long.valueOf(this.hBI));
        }
        if (this.hBW) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.status));
        }
        if (this.hBX) {
            contentValues.put("nettimes", Integer.valueOf(this.hBJ));
        }
        if (this.hBY) {
            contentValues.put("reserved1", Integer.valueOf(this.hBK));
        }
        if (this.hBZ) {
            contentValues.put("reserved2", Integer.valueOf(this.cPf));
        }
        if (this.hCa) {
            contentValues.put("reserved3", this.hBL);
        }
        if (this.hCb) {
            contentValues.put("hashdthumb", Integer.valueOf(this.gkI));
        }
        if (this.hCc) {
            contentValues.put("iscomplete", Integer.valueOf(this.offset < this.hmZ ? 0 : 1));
        }
        if (this.hCd) {
            contentValues.put("origImgMD5", this.hBG);
        }
        if (this.hCe) {
            contentValues.put("compressType", Integer.valueOf(this.hBE));
        }
        if (this.hCf) {
            contentValues.put("forwardType", Integer.valueOf(this.hBF));
        }
        return contentValues;
    }

    public final void Pl() {
        this.hBN = false;
        this.hBO = false;
        this.hBP = false;
        this.hBQ = false;
        this.hBR = false;
        this.hBS = false;
        this.hBT = false;
        this.hBU = false;
        this.hBV = false;
        this.hBW = false;
        this.hBX = false;
        this.hBY = false;
        this.hBZ = false;
        this.hCa = false;
        this.hCb = false;
        this.hCc = false;
        this.hCd = false;
        this.hCe = false;
        this.hCf = false;
    }
}
