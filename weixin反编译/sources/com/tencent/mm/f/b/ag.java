package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class ag extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOV = Columns.TYPE.hashCode();
    private static final int fPZ = "username".hashCode();
    private static final int fRp = "lvbuff".hashCode();
    private static final int fUB = "nickname".hashCode();
    private static final int fWJ = "alias".hashCode();
    private static final int fWK = "conRemark".hashCode();
    private static final int fWL = "domainList".hashCode();
    private static final int fWM = "pyInitial".hashCode();
    private static final int fWN = "quanPin".hashCode();
    private static final int fWO = "showHead".hashCode();
    private static final int fWP = "weiboFlag".hashCode();
    private static final int fWQ = "weiboNickname".hashCode();
    private static final int fWR = "conRemarkPYFull".hashCode();
    private static final int fWS = "conRemarkPYShort".hashCode();
    private static final int fWT = "verifyFlag".hashCode();
    private static final int fWU = "encryptUsername".hashCode();
    private static final int fWV = "chatroomFlag".hashCode();
    private static final int fWW = "deleteFlag".hashCode();
    private static final int fWX = "contactLabelIds".hashCode();
    private static final int fWY = "descWordingId".hashCode();
    private static final int ppl = "openImAppid".hashCode();
    private int cPf;
    public String fBa;
    private boolean fOz = false;
    private boolean fPX = false;
    private boolean fQS = false;
    private boolean fUx = false;
    private boolean fWA = false;
    private boolean fWB = false;
    private boolean fWC = false;
    private boolean fWD = false;
    private boolean fWE = false;
    private boolean fWF = false;
    private boolean fWG = false;
    private boolean fWH = false;
    public boolean fWI = false;
    public int fWZ;
    private boolean fWt = false;
    private boolean fWu = false;
    private boolean fWv = false;
    private boolean fWw = false;
    private boolean fWx = false;
    private boolean fWy = false;
    private boolean fWz = false;
    public String fXA;
    private int fXB;
    public int fXD;
    public String fXE;
    public int fXa;
    public String fXb;
    public long fXc;
    public String fXd;
    public int fXe;
    public int fXf;
    public String fXg;
    public String fXh;
    public int fXi;
    public int fXj;
    private String fXk;
    private String fXl;
    public String fXm;
    public int fXn;
    public String fXo;
    public String fXp;
    public String fXq;
    public int fXr;
    public int fXs;
    public String fXt;
    public String fXu;
    public String fXv;
    public String fXw;
    public String fXx;
    public String fXy;
    public String fXz;
    private String field_alias;
    public int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_descWordingId;
    public String field_domainList;
    public String field_encryptUsername;
    public byte[] field_lvbuff;
    public String field_nickname;
    public String field_openImAppid;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    private boolean ppk = false;
    private String ppm;
    public String signature;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.fPX = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public void cZ(String str) {
        this.field_alias = str;
        this.fWt = true;
    }

    public String vU() {
        return this.field_alias;
    }

    public void da(String str) {
        this.field_conRemark = str;
        this.fWu = true;
    }

    public final String vV() {
        return this.field_conRemark;
    }

    public void db(String str) {
        this.field_domainList = str;
        this.fWv = true;
    }

    public void dc(String str) {
        this.field_nickname = str;
        this.fUx = true;
    }

    public final String vW() {
        return this.field_nickname;
    }

    public void dd(String str) {
        this.field_pyInitial = str;
        this.fWw = true;
    }

    public String vX() {
        return this.field_pyInitial;
    }

    public void de(String str) {
        this.field_quanPin = str;
        this.fWx = true;
    }

    public String vY() {
        return this.field_quanPin;
    }

    public void ex(int i) {
        this.field_showHead = i;
        this.fWy = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.fOz = true;
    }

    public void ey(int i) {
        this.field_weiboFlag = i;
        this.fWz = true;
    }

    public void df(String str) {
        this.field_weiboNickname = str;
        this.fWA = true;
    }

    public void dg(String str) {
        this.field_conRemarkPYFull = str;
        this.fWB = true;
    }

    public void dh(String str) {
        this.field_conRemarkPYShort = str;
        this.fWC = true;
    }

    public void z(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.fQS = true;
    }

    public void ez(int i) {
        this.field_verifyFlag = i;
        this.fWD = true;
    }

    public void di(String str) {
        this.field_encryptUsername = str;
        this.fWE = true;
    }

    public final String vZ() {
        return this.field_encryptUsername;
    }

    public void eA(int i) {
        this.field_chatroomFlag = i;
        this.fWF = true;
    }

    public void eB(int i) {
        this.field_deleteFlag = i;
        this.fWG = true;
    }

    public void dj(String str) {
        this.field_contactLabelIds = str;
        this.fWH = true;
    }

    public final void dE(String str) {
        this.field_openImAppid = str;
        this.ppk = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPZ == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.fPX = true;
                } else if (fWJ == hashCode) {
                    this.field_alias = cursor.getString(i);
                } else if (fWK == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (fWL == hashCode) {
                    this.field_domainList = cursor.getString(i);
                } else if (fUB == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (fWM == hashCode) {
                    this.field_pyInitial = cursor.getString(i);
                } else if (fWN == hashCode) {
                    this.field_quanPin = cursor.getString(i);
                } else if (fWO == hashCode) {
                    this.field_showHead = cursor.getInt(i);
                } else if (fOV == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (fWP == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i);
                } else if (fWQ == hashCode) {
                    this.field_weiboNickname = cursor.getString(i);
                } else if (fWR == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i);
                } else if (fWS == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i);
                } else if (fRp == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (fWT == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i);
                } else if (fWU == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                } else if (fWV == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i);
                } else if (fWW == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i);
                } else if (fWX == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i);
                } else if (fWY == hashCode) {
                    this.field_descWordingId = cursor.getString(i);
                } else if (ppl == hashCode) {
                    this.field_openImAppid = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
            wa();
        }
    }

    public final ContentValues vP() {
        try {
            if (this.fQS) {
                u uVar = new u();
                uVar.cfK();
                uVar.Dw(this.fWZ);
                uVar.Dw(this.fXa);
                uVar.VA(this.fXb);
                uVar.fG(this.fXc);
                uVar.Dw(this.uin);
                uVar.VA(this.fXd);
                uVar.VA(this.fBa);
                uVar.Dw(this.fXe);
                uVar.Dw(this.fXf);
                uVar.VA(this.fXg);
                uVar.VA(this.fXh);
                uVar.Dw(this.fXi);
                uVar.Dw(this.fXj);
                uVar.VA(this.signature);
                uVar.VA(this.fXk);
                uVar.VA(this.fXl);
                uVar.VA(this.fXm);
                uVar.Dw(this.fXn);
                uVar.Dw(this.cPf);
                uVar.VA(this.fXo);
                uVar.Dw(this.field_verifyFlag);
                uVar.VA(this.fXp);
                uVar.VA(this.fXq);
                uVar.Dw(this.fXr);
                uVar.Dw(this.fXs);
                uVar.VA(this.fXt);
                uVar.VA(this.fXu);
                uVar.VA(this.fXv);
                uVar.VA(this.fXw);
                uVar.VA(this.fXx);
                uVar.VA(this.fXy);
                uVar.VA(this.fXz);
                uVar.VA(this.fXA);
                uVar.Dw(this.fXB);
                uVar.VA(this.ppm);
                uVar.Dw(this.fXD);
                uVar.VA(this.fXE);
                this.field_lvbuff = uVar.cfL();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.fPX) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = "";
        }
        if (this.fWt) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.fWu) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = "";
        }
        if (this.fWv) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.fUx) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.fWw) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = "";
        }
        if (this.fWx) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.fWy) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.fOz) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.fWz) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = "";
        }
        if (this.fWA) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = "";
        }
        if (this.fWB) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = "";
        }
        if (this.fWC) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.fQS) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.fWD) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.fWE) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.fWF) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.fWG) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = "";
        }
        if (this.fWH) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.field_descWordingId == null) {
            this.field_descWordingId = "";
        }
        if (this.fWI) {
            contentValues.put("descWordingId", this.field_descWordingId);
        }
        if (this.ppk) {
            contentValues.put("openImAppid", this.field_openImAppid);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }

    public void eC(int i) {
        this.fWZ = i;
        this.fQS = true;
    }

    public void eD(int i) {
        this.fXa = i;
        this.fQS = true;
    }

    public void dk(String str) {
        this.fXb = str;
        this.fQS = true;
    }

    public void ai(long j) {
        this.fXc = j;
        this.fQS = true;
    }

    public void eE(int i) {
        this.uin = i;
        this.fQS = true;
    }

    public void dl(String str) {
        this.fXd = str;
        this.fQS = true;
    }

    public void dm(String str) {
        this.fBa = str;
        this.fQS = true;
    }

    public void eF(int i) {
        this.fXe = i;
        this.fQS = true;
    }

    public void eG(int i) {
        this.fXf = i;
        this.fQS = true;
    }

    public void dn(String str) {
        this.fXg = str;
        this.fQS = true;
    }

    public void do(String str) {
        this.fXh = str;
        this.fQS = true;
    }

    public void eH(int i) {
        this.fXi = i;
        this.fQS = true;
    }

    public void eI(int i) {
        this.fXj = i;
        this.fQS = true;
    }

    public void dp(String str) {
        this.signature = str;
        this.fQS = true;
    }

    public String getProvince() {
        return this.fXk;
    }

    public void dq(String str) {
        this.fXk = str;
        this.fQS = true;
    }

    public String getCity() {
        return this.fXl;
    }

    public void dr(String str) {
        this.fXl = str;
        this.fQS = true;
    }

    public void ds(String str) {
        this.fXm = str;
        this.fQS = true;
    }

    public void eJ(int i) {
        this.fXn = i;
        this.fQS = true;
    }

    public int getSource() {
        return this.cPf;
    }

    public void setSource(int i) {
        this.cPf = i;
        this.fQS = true;
    }

    public void dt(String str) {
        this.fXo = str;
        this.fQS = true;
    }

    public void du(String str) {
        this.fXp = str;
        this.fQS = true;
    }

    public void dv(String str) {
        this.fXq = str;
        this.fQS = true;
    }

    public void eK(int i) {
        this.fXr = i;
        this.fQS = true;
    }

    public void eL(int i) {
        this.fXs = i;
        this.fQS = true;
    }

    public void dw(String str) {
        this.fXt = str;
        this.fQS = true;
    }

    public void dx(String str) {
        this.fXu = str;
        this.fQS = true;
    }

    public void dy(String str) {
        this.fXv = str;
        this.fQS = true;
    }

    public void dz(String str) {
        this.fXw = str;
        this.fQS = true;
    }

    public void dA(String str) {
        this.fXx = str;
        this.fQS = true;
    }

    public void dB(String str) {
        this.fXy = str;
        this.fQS = true;
    }

    public void dC(String str) {
        this.fXz = str;
        this.fQS = true;
    }

    public void dD(String str) {
        this.fXA = str;
        this.fQS = true;
    }

    public final void eM(int i) {
        this.fXB = i;
        this.fQS = true;
    }

    public final void eN(int i) {
        this.fXD = i;
        this.fQS = true;
    }

    public final void dF(String str) {
        this.fXE = str;
        this.fQS = true;
    }

    public final void wa() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                u uVar = new u();
                int bt = uVar.bt(this.field_lvbuff);
                if (bt != 0) {
                    x.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + bt);
                    return;
                }
                this.fWZ = uVar.getInt();
                this.fXa = uVar.getInt();
                this.fXb = uVar.getString();
                this.fXc = uVar.getLong();
                this.uin = uVar.getInt();
                this.fXd = uVar.getString();
                this.fBa = uVar.getString();
                this.fXe = uVar.getInt();
                this.fXf = uVar.getInt();
                this.fXg = uVar.getString();
                this.fXh = uVar.getString();
                this.fXi = uVar.getInt();
                this.fXj = uVar.getInt();
                this.signature = uVar.getString();
                this.fXk = uVar.getString();
                this.fXl = uVar.getString();
                this.fXm = uVar.getString();
                this.fXn = uVar.getInt();
                this.cPf = uVar.getInt();
                this.fXo = uVar.getString();
                this.field_verifyFlag = uVar.getInt();
                this.fXp = uVar.getString();
                if (!uVar.cfJ()) {
                    this.fXq = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXr = uVar.getInt();
                }
                if (!uVar.cfJ()) {
                    this.fXs = uVar.getInt();
                }
                if (!uVar.cfJ()) {
                    this.fXt = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXu = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXv = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXw = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXx = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXy = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXz = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXA = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXB = uVar.getInt();
                }
                if (!uVar.cfJ()) {
                    this.ppm = uVar.getString();
                }
                if (!uVar.cfJ()) {
                    this.fXD = uVar.getInt();
                }
                if (!uVar.cfJ()) {
                    this.fXE = uVar.getString();
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }
}
