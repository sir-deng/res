package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;

public abstract class o extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fNU = DownloadInfo.STATUS.hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fPU = "signature".hashCode();
    private static final int fQY = "appName".hashCode();
    private static final int fQZ = "appDiscription".hashCode();
    private static final int fRa = "appIconUrl".hashCode();
    private static final int fRb = "appStoreUrl".hashCode();
    private static final int fRc = "appVersion".hashCode();
    private static final int fRd = "appWatermarkUrl".hashCode();
    private static final int fRe = DownloadInfoColumns.PACKAGENAME.hashCode();
    private static final int fRf = "modifyTime".hashCode();
    private static final int fRg = "appName_en".hashCode();
    private static final int fRh = "appName_tw".hashCode();
    private static final int fRi = "appName_hk".hashCode();
    private static final int fRj = "appDiscription_en".hashCode();
    private static final int fRk = "appDiscription_tw".hashCode();
    private static final int fRl = "appType".hashCode();
    private static final int fRm = "openId".hashCode();
    private static final int fRn = "authFlag".hashCode();
    private static final int fRo = "appInfoFlag".hashCode();
    private static final int fRp = "lvbuff".hashCode();
    private static final int fRq = "serviceAppType".hashCode();
    private static final int fRr = "serviceAppInfoFlag".hashCode();
    private static final int fRs = "serviceShowFlag".hashCode();
    private static final int fRt = "appSupportContentType".hashCode();
    private static final int fRu = "svrAppSupportContentType".hashCode();
    private boolean fNR = true;
    private boolean fPD = true;
    private boolean fPp = true;
    private boolean fQB = true;
    private boolean fQC = true;
    private boolean fQD = true;
    private boolean fQE = true;
    private boolean fQF = true;
    private boolean fQG = true;
    private boolean fQH = true;
    private boolean fQI = true;
    private boolean fQJ = true;
    private boolean fQK = true;
    private boolean fQL = true;
    private boolean fQM = true;
    private boolean fQN = true;
    private boolean fQO = true;
    private boolean fQP = true;
    private boolean fQQ = true;
    private boolean fQR = true;
    public boolean fQS = true;
    private boolean fQT = true;
    private boolean fQU = true;
    private boolean fQV = true;
    private boolean fQW = true;
    private boolean fQX = true;
    public String fRA;
    public String fRB;
    public String fRC;
    public String fRD;
    public String fRE;
    public String fRF;
    public int fRG;
    public String fRH;
    public String fRI;
    public String fRJ;
    public String fRK;
    public String fRL;
    public int fRM;
    public String fRN;
    private int fRO;
    public String fRP;
    public String fRQ;
    public String fRR;
    public int fRS;
    public String fRv;
    public String fRw;
    public String fRx;
    public int fRy;
    public int fRz;
    public String field_appDiscription;
    public String field_appDiscription_en;
    public String field_appDiscription_tw;
    public String field_appIconUrl;
    public String field_appId;
    public int field_appInfoFlag;
    public String field_appName;
    public String field_appName_en;
    public String field_appName_hk;
    public String field_appName_tw;
    public String field_appStoreUrl;
    public long field_appSupportContentType;
    public String field_appType;
    public int field_appVersion;
    public String field_appWatermarkUrl;
    public int field_authFlag;
    public byte[] field_lvbuff;
    public long field_modifyTime;
    public String field_openId;
    public String field_packageName;
    public int field_serviceAppInfoFlag;
    public int field_serviceAppType;
    public int field_serviceShowFlag;
    public String field_signature;
    public int field_status;
    public long field_svrAppSupportContentType;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                    this.fPp = true;
                } else if (fQY == hashCode) {
                    this.field_appName = cursor.getString(i);
                } else if (fQZ == hashCode) {
                    this.field_appDiscription = cursor.getString(i);
                } else if (fRa == hashCode) {
                    this.field_appIconUrl = cursor.getString(i);
                } else if (fRb == hashCode) {
                    this.field_appStoreUrl = cursor.getString(i);
                } else if (fRc == hashCode) {
                    this.field_appVersion = cursor.getInt(i);
                } else if (fRd == hashCode) {
                    this.field_appWatermarkUrl = cursor.getString(i);
                } else if (fRe == hashCode) {
                    this.field_packageName = cursor.getString(i);
                } else if (fNU == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (fPU == hashCode) {
                    this.field_signature = cursor.getString(i);
                } else if (fRf == hashCode) {
                    this.field_modifyTime = cursor.getLong(i);
                } else if (fRg == hashCode) {
                    this.field_appName_en = cursor.getString(i);
                } else if (fRh == hashCode) {
                    this.field_appName_tw = cursor.getString(i);
                } else if (fRi == hashCode) {
                    this.field_appName_hk = cursor.getString(i);
                } else if (fRj == hashCode) {
                    this.field_appDiscription_en = cursor.getString(i);
                } else if (fRk == hashCode) {
                    this.field_appDiscription_tw = cursor.getString(i);
                } else if (fRl == hashCode) {
                    this.field_appType = cursor.getString(i);
                } else if (fRm == hashCode) {
                    this.field_openId = cursor.getString(i);
                } else if (fRn == hashCode) {
                    this.field_authFlag = cursor.getInt(i);
                } else if (fRo == hashCode) {
                    this.field_appInfoFlag = cursor.getInt(i);
                } else if (fRp == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (fRq == hashCode) {
                    this.field_serviceAppType = cursor.getInt(i);
                } else if (fRr == hashCode) {
                    this.field_serviceAppInfoFlag = cursor.getInt(i);
                } else if (fRs == hashCode) {
                    this.field_serviceShowFlag = cursor.getInt(i);
                } else if (fRt == hashCode) {
                    this.field_appSupportContentType = cursor.getLong(i);
                } else if (fRu == hashCode) {
                    this.field_svrAppSupportContentType = cursor.getLong(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                    u uVar = new u();
                    int bt = uVar.bt(this.field_lvbuff);
                    if (bt != 0) {
                        x.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + bt);
                        return;
                    }
                    this.fRv = uVar.getString();
                    this.fRw = uVar.getString();
                    this.fRx = uVar.getString();
                    this.fRy = uVar.getInt();
                    this.fRz = uVar.getInt();
                    this.fRA = uVar.getString();
                    this.fRB = uVar.getString();
                    this.fRC = uVar.getString();
                    this.fRD = uVar.getString();
                    if (!uVar.cfJ()) {
                        this.fRE = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRF = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRG = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.fRH = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRI = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRJ = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRK = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRL = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRM = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.fRN = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRO = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.fRP = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRQ = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRR = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.fRS = uVar.getInt();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
            }
        }
    }

    public ContentValues vP() {
        try {
            if (this.fQS) {
                u uVar = new u();
                uVar.cfK();
                uVar.VA(this.fRv);
                uVar.VA(this.fRw);
                uVar.VA(this.fRx);
                uVar.Dw(this.fRy);
                uVar.Dw(this.fRz);
                uVar.VA(this.fRA);
                uVar.VA(this.fRB);
                uVar.VA(this.fRC);
                uVar.VA(this.fRD);
                uVar.VA(this.fRE);
                uVar.VA(this.fRF);
                uVar.Dw(this.fRG);
                uVar.VA(this.fRH);
                uVar.VA(this.fRI);
                uVar.VA(this.fRJ);
                uVar.VA(this.fRK);
                uVar.VA(this.fRL);
                uVar.Dw(this.fRM);
                uVar.VA(this.fRN);
                uVar.Dw(this.fRO);
                uVar.VA(this.fRP);
                uVar.VA(this.fRQ);
                uVar.VA(this.fRR);
                uVar.Dw(this.fRS);
                this.field_lvbuff = uVar.cfL();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_appId == null) {
            this.field_appId = "";
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.fQB) {
            contentValues.put("appName", this.field_appName);
        }
        if (this.fQC) {
            contentValues.put("appDiscription", this.field_appDiscription);
        }
        if (this.fQD) {
            contentValues.put("appIconUrl", this.field_appIconUrl);
        }
        if (this.fQE) {
            contentValues.put("appStoreUrl", this.field_appStoreUrl);
        }
        if (this.fQF) {
            contentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
        }
        if (this.fQG) {
            contentValues.put("appWatermarkUrl", this.field_appWatermarkUrl);
        }
        if (this.fQH) {
            contentValues.put(DownloadInfoColumns.PACKAGENAME, this.field_packageName);
        }
        if (this.fNR) {
            contentValues.put(DownloadInfo.STATUS, Integer.valueOf(this.field_status));
        }
        if (this.fPD) {
            contentValues.put("signature", this.field_signature);
        }
        if (this.fQI) {
            contentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
        }
        if (this.fQJ) {
            contentValues.put("appName_en", this.field_appName_en);
        }
        if (this.fQK) {
            contentValues.put("appName_tw", this.field_appName_tw);
        }
        if (this.fQL) {
            contentValues.put("appName_hk", this.field_appName_hk);
        }
        if (this.fQM) {
            contentValues.put("appDiscription_en", this.field_appDiscription_en);
        }
        if (this.fQN) {
            contentValues.put("appDiscription_tw", this.field_appDiscription_tw);
        }
        if (this.fQO) {
            contentValues.put("appType", this.field_appType);
        }
        if (this.fQP) {
            contentValues.put("openId", this.field_openId);
        }
        if (this.fQQ) {
            contentValues.put("authFlag", Integer.valueOf(this.field_authFlag));
        }
        if (this.fQR) {
            contentValues.put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
        }
        if (this.fQS) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.fQT) {
            contentValues.put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
        }
        if (this.fQU) {
            contentValues.put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
        }
        if (this.fQV) {
            contentValues.put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
        }
        if (this.fQW) {
            contentValues.put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
        }
        if (this.fQX) {
            contentValues.put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }

    public final void cM(String str) {
        this.fRv = str;
        this.fQS = true;
    }

    public final void cN(String str) {
        this.fRw = str;
        this.fQS = true;
    }

    public final String vR() {
        return this.fRx;
    }

    public final void cO(String str) {
        this.fRx = str;
        this.fQS = true;
    }

    public final void cP(String str) {
        this.fRA = str;
        this.fQS = true;
    }

    public final void cQ(String str) {
        this.fRB = str;
        this.fQS = true;
    }

    public final String vS() {
        return this.fRC;
    }

    public final void cR(String str) {
        this.fRC = str;
        this.fQS = true;
    }

    public final String vT() {
        return this.fRD;
    }

    public final void cS(String str) {
        this.fRD = str;
        this.fQS = true;
    }

    public final void cT(String str) {
        this.fRE = str;
        this.fQS = true;
    }

    public final void cU(String str) {
        this.fRF = str;
        this.fQS = true;
    }

    public final void ev(int i) {
        this.fRG = i;
        this.fQS = true;
    }

    public final void cV(String str) {
        this.fRH = str;
        this.fQS = true;
    }

    public final void cW(String str) {
        this.fRI = str;
        this.fQS = true;
    }

    public final void cX(String str) {
        this.fRJ = str;
        this.fQS = true;
    }

    public final void cY(String str) {
        this.fRK = str;
        this.fQS = true;
    }

    public final void ew(int i) {
        this.fRM = i;
        this.fQS = true;
    }
}
