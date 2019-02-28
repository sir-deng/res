package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;

public abstract class br extends c {
    public static final String[] fNF = new String[0];
    private static final int fNO = "rowid".hashCode();
    private static final int fVi = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int get = "mac".hashCode();
    private static final int ggA = "closeStrategy".hashCode();
    private static final int ggB = "md5Str".hashCode();
    private static final int ggC = "authKey".hashCode();
    private static final int ggD = "sessionKey".hashCode();
    private static final int ggE = "sessionBuf".hashCode();
    private static final int ggF = "authBuf".hashCode();
    private static final int ggG = "lvbuffer".hashCode();
    private static final int ggv = "deviceID".hashCode();
    private static final int ggw = "brandName".hashCode();
    private static final int ggx = "deviceType".hashCode();
    private static final int ggy = "connProto".hashCode();
    private static final int ggz = "connStrategy".hashCode();
    public String category;
    private boolean fUP = true;
    public byte[] field_authBuf;
    public String field_authKey;
    public String field_brandName;
    public int field_closeStrategy;
    public String field_connProto;
    public int field_connStrategy;
    public String field_deviceID;
    public String field_deviceType;
    public byte[] field_lvbuffer;
    public long field_mac;
    public String field_md5Str;
    public byte[] field_sessionBuf;
    public byte[] field_sessionKey;
    public String field_url;
    private boolean geg = true;
    public int ggH;
    public int ggI;
    public long ggJ;
    private long ggK;
    public String ggL;
    public String ggM;
    public String ggN;
    private int ggO;
    public int ggP;
    public long ggQ;
    public String ggR;
    public String ggS;
    private String ggT;
    public String ggU;
    private boolean ggj = true;
    private boolean ggk = true;
    private boolean ggl = true;
    private boolean ggm = true;
    private boolean ggn = true;
    private boolean ggo = true;
    private boolean ggp = true;
    private boolean ggq = true;
    private boolean ggr = true;
    private boolean ggs = true;
    private boolean ggt = true;
    public boolean ggu = true;
    public String iconUrl;
    public String jumpUrl;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (ggv == hashCode) {
                    this.field_deviceID = cursor.getString(i);
                    this.ggj = true;
                } else if (ggw == hashCode) {
                    this.field_brandName = cursor.getString(i);
                } else if (get == hashCode) {
                    this.field_mac = cursor.getLong(i);
                } else if (ggx == hashCode) {
                    this.field_deviceType = cursor.getString(i);
                } else if (ggy == hashCode) {
                    this.field_connProto = cursor.getString(i);
                } else if (ggz == hashCode) {
                    this.field_connStrategy = cursor.getInt(i);
                } else if (ggA == hashCode) {
                    this.field_closeStrategy = cursor.getInt(i);
                } else if (ggB == hashCode) {
                    this.field_md5Str = cursor.getString(i);
                } else if (ggC == hashCode) {
                    this.field_authKey = cursor.getString(i);
                } else if (fVi == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (ggD == hashCode) {
                    this.field_sessionKey = cursor.getBlob(i);
                } else if (ggE == hashCode) {
                    this.field_sessionBuf = cursor.getBlob(i);
                } else if (ggF == hashCode) {
                    this.field_authBuf = cursor.getBlob(i);
                } else if (ggG == hashCode) {
                    this.field_lvbuffer = cursor.getBlob(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
            try {
                if (this.field_lvbuffer != null && this.field_lvbuffer.length != 0) {
                    u uVar = new u();
                    int bt = uVar.bt(this.field_lvbuffer);
                    if (bt != 0) {
                        x.e("MicroMsg.SDK.BaseHardDeviceInfo", "parse LVBuffer error:" + bt);
                        return;
                    }
                    if (!uVar.cfJ()) {
                        this.ggH = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.ggI = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.ggJ = uVar.getLong();
                    }
                    if (!uVar.cfJ()) {
                        this.ggK = uVar.getLong();
                    }
                    if (!uVar.cfJ()) {
                        this.ggL = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.iconUrl = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.jumpUrl = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.ggM = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.ggN = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.category = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.ggO = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.ggP = uVar.getInt();
                    }
                    if (!uVar.cfJ()) {
                        this.ggQ = uVar.getLong();
                    }
                    if (!uVar.cfJ()) {
                        this.ggR = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.ggS = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.ggT = uVar.getString();
                    }
                    if (!uVar.cfJ()) {
                        this.ggU = uVar.getString();
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed");
            }
        }
    }

    public final ContentValues vP() {
        try {
            if (this.ggu) {
                u uVar = new u();
                uVar.cfK();
                uVar.Dw(this.ggH);
                uVar.Dw(this.ggI);
                uVar.fG(this.ggJ);
                uVar.fG(this.ggK);
                uVar.VA(this.ggL);
                uVar.VA(this.iconUrl);
                uVar.VA(this.jumpUrl);
                uVar.VA(this.ggM);
                uVar.VA(this.ggN);
                uVar.VA(this.category);
                uVar.Dw(this.ggO);
                uVar.Dw(this.ggP);
                uVar.fG(this.ggQ);
                uVar.VA(this.ggR);
                uVar.VA(this.ggS);
                uVar.VA(this.ggT);
                uVar.VA(this.ggU);
                this.field_lvbuffer = uVar.cfL();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SDK.BaseHardDeviceInfo", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.ggj) {
            contentValues.put("deviceID", this.field_deviceID);
        }
        if (this.ggk) {
            contentValues.put("brandName", this.field_brandName);
        }
        if (this.geg) {
            contentValues.put("mac", Long.valueOf(this.field_mac));
        }
        if (this.ggl) {
            contentValues.put("deviceType", this.field_deviceType);
        }
        if (this.ggm) {
            contentValues.put("connProto", this.field_connProto);
        }
        if (this.ggn) {
            contentValues.put("connStrategy", Integer.valueOf(this.field_connStrategy));
        }
        if (this.ggo) {
            contentValues.put("closeStrategy", Integer.valueOf(this.field_closeStrategy));
        }
        if (this.ggp) {
            contentValues.put("md5Str", this.field_md5Str);
        }
        if (this.ggq) {
            contentValues.put("authKey", this.field_authKey);
        }
        if (this.fUP) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.ggr) {
            contentValues.put("sessionKey", this.field_sessionKey);
        }
        if (this.ggs) {
            contentValues.put("sessionBuf", this.field_sessionBuf);
        }
        if (this.ggt) {
            contentValues.put("authBuf", this.field_authBuf);
        }
        if (this.ggu) {
            contentValues.put("lvbuffer", this.field_lvbuffer);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }

    public final void cZ(String str) {
        this.ggL = str;
        this.ggu = true;
    }

    public final void dL(String str) {
        this.iconUrl = str;
        this.ggu = true;
    }

    public final void dM(String str) {
        this.jumpUrl = str;
        this.ggu = true;
    }

    public final void dN(String str) {
        this.ggM = str;
        this.ggu = true;
    }

    public final void dO(String str) {
        this.ggN = str;
        this.ggu = true;
    }

    public final void dP(String str) {
        this.category = str;
        this.ggu = true;
    }

    public final void eZ(int i) {
        this.ggO = i;
        this.ggu = true;
    }

    public final void fa(int i) {
        this.ggP = i;
        this.ggu = true;
    }

    public final void an(long j) {
        this.ggQ = j;
        this.ggu = true;
    }

    public final void dQ(String str) {
        this.ggR = str;
        this.ggu = true;
    }

    public final void dR(String str) {
        this.ggS = str;
        this.ggu = true;
    }

    public final void dS(String str) {
        this.ggT = str;
        this.ggu = true;
    }

    public final void dT(String str) {
        this.ggU = str;
        this.ggu = true;
    }
}
