package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Vector;

public final class z extends k implements com.tencent.mm.network.k, d {
    private static Vector<String> raS = new Vector();
    private final int fqY;
    private boolean fva;
    private b gLB;
    public e gLE;
    private boolean qZN;
    private long qZO = 0;
    long qZP = 0;
    public int qZR = 0;
    private long raG = 0;
    private boolean raH = false;
    private boolean raI = false;
    private int raT = 0;
    private boolean raU = false;
    private boolean raV = false;
    public long raW;
    private String rap = "";
    String userName;

    public static synchronized boolean KK(String str) {
        boolean z;
        synchronized (z.class) {
            if (raS.contains(str)) {
                z = false;
            } else {
                raS.add(str);
                z = true;
            }
        }
        return z;
    }

    public static synchronized boolean KL(String str) {
        synchronized (z.class) {
            raS.remove(str);
        }
        return true;
    }

    public z(String str, long j, boolean z, int i) {
        long j2 = 0;
        boolean z2 = false;
        this.userName = str;
        this.qZO = j;
        this.fva = z;
        if (j == 0) {
            x.i("MicroMsg.NetSceneSnsUserPage", "fp userName " + str);
        } else {
            x.i("MicroMsg.NetSceneSnsUserPage", "np userName " + str);
        }
        this.fqY = z ? 4 : 8;
        a aVar = new a();
        aVar.hnT = new bml();
        aVar.hnU = new bmm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsuserpage";
        aVar.hnS = com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
        aVar.hnV = 99;
        aVar.hnW = 1000000099;
        this.gLB = aVar.Kf();
        bml bml = (bml) this.gLB.hnQ.hnY;
        bml.vPp = str;
        bml.wUB = j;
        if (j == 0) {
            z2 = true;
        }
        this.qZN = z2;
        int KU = ae.bvV().KU(str);
        n bwf = ae.bwf();
        if (!this.qZN) {
            j2 = j;
        }
        this.qZP = bwf.a(j2, KU, str, z);
        bml.wVX = this.qZP;
        int a = c.a(this.qZP, j, str);
        bml.wVY = a;
        bml.vON = i;
        if (this.qZN) {
            this.rap = ae.bwj().LV(str).field_md5;
            if (this.rap == null) {
                this.rap = "";
            }
            bml.wUA = this.rap;
        }
        this.raG = j;
        x.i("MicroMsg.NetSceneSnsUserPage", "nextCount: " + KU + " maxId:" + i.er(j) + " minId:" + i.er(this.qZP) + " lastReqTime:" + a + " snsSource " + i);
    }

    private void bvC() {
        n bwf = ae.bwf();
        String str = this.userName;
        boolean z = this.fva;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo ").append(n.aG(str, z)).append(" AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25 , 26) and  (snsId != 0  )  limit ").append(4);
        Cursor rawQuery = bwf.gLA.rawQuery(stringBuilder.toString(), null);
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count <= 3 && count > 0) {
            this.raI = true;
        } else if (count == 0) {
            this.raH = true;
        }
    }

    private void a(bmm bmm, String str) {
        ai.a(this.userName, this.fqY, bmm.vSf, str);
        if (this.qZO == 0) {
            this.qZO = ((blf) bmm.vSf.getFirst()).vWS;
        } else {
            this.qZO = c.ev(this.qZO);
        }
        this.qZP = ((blf) bmm.vSf.getLast()).vWS;
        x.i("MicroMsg.NetSceneSnsUserPage", "insertListAndUpdateFaultInfo userName %s maxId %s minId %s NewRequestTime %s", this.userName, Long.valueOf(this.qZO), Long.valueOf(this.qZP), Integer.valueOf(bmm.wWb));
        c.d(this.userName, this.qZO, this.qZP, bmm.wWb);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSnsUserPage", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bmm bmm = (bmm) ((b) qVar).hnR.hnY;
        if (qVar.Hv().vIb == 207 || qVar.Hv().vIb == 203 || qVar.Hv().vIb == 0 || qVar.Hv().vIb == 2001 || qVar.Hv().vIb == TXLiveConstants.PLAY_EVT_PLAY_BEGIN || qVar.Hv().vIb == 2003) {
            String str2;
            if (qVar.Hv().vIb == 2003) {
                n bwf = ae.bwf();
                str2 = this.userName;
                boolean fD = bwf.gLA.fD("SnsInfo", "DELETE FROM SnsInfo" + " where SnsInfo.userName=\"" + bi.oL(str2) + "\"");
                x.d("MicroMsg.SnsInfoStorage", "del snsinfo " + str2 + " res " + fD);
                Boolean.valueOf(fD);
            }
            this.qZR = bmm.wUE;
            x.i("MicroMsg.NetSceneSnsUserPage", "for same md5 count: " + bmm.wUE + " , objCount:  " + bmm.wGO);
            this.raW = bmm.wWl;
            str2 = i.es(this.qZO);
            if (!this.qZN) {
                x.d("MicroMsg.NetSceneSnsUserPage", "np  " + bmm.vSf.size());
                if (bmm.vSf.isEmpty()) {
                    this.raV = qVar.Hv().vIb == 203;
                    ae.bwf().a(this.userName, this.fva, str2);
                    this.raH = true;
                    this.qZP = this.qZO;
                } else {
                    a(bmm, str2);
                }
                KL(this.userName);
                this.gLE.a(i2, i3, str, this);
                return;
            } else if (this.rap.equals(bmm.wUA)) {
                this.qZP = ae.bwf().a(this.qZN ? 0 : this.raG, this.qZR, this.userName, this.fva);
                x.i("MicroMsg.NetSceneSnsUserPage", "md5 is nochange the new minid %s", Long.valueOf(this.qZP));
                bvC();
                KL(this.userName);
                com.tencent.mm.plugin.sns.storage.k LV = ae.bwj().LV(this.userName);
                this.gLE.a(LV.field_lastFirstPageRequestErrType, LV.field_lastFirstPageRequestErrCode, str, this);
                return;
            } else {
                String er;
                String str3;
                x.i("MicroMsg.NetSceneSnsUserPage", "fp  " + bmm.vSf.size());
                if (this.qZN && !this.rap.equals(bmm.wUA)) {
                    this.raT = bmm.wWk;
                    com.tencent.mm.plugin.sns.storage.k LV2 = ae.bwj().LV(this.userName);
                    LV2.field_icount = this.raT;
                    bmk bmk = bmm.wCw;
                    if (bmk != null) {
                        er = i.er(bmk.hxr);
                        String accSnsPath = ae.getAccSnsPath();
                        str3 = this.userName + "bg_";
                        String str4 = this.userName + "tbg_";
                        if (LV2.field_bgUrl == null || !LV2.field_bgId.equals(er)) {
                            LV2.field_older_bgId = LV2.field_bgId;
                            if (FileOp.bO(am.r(accSnsPath, this.userName) + str3)) {
                                FileOp.deleteFile(am.r(accSnsPath, this.userName) + str4);
                                FileOp.g(am.r(accSnsPath, this.userName), str3, str4);
                            }
                            this.raU = true;
                            LV2.byO();
                            x.d("MicroMsg.NetSceneSnsUserPage", "get new  bgid " + bmk.hxq);
                        }
                        LV2.field_bgId = er;
                        LV2.field_bgUrl = bmk.hxq;
                        LV2.field_snsBgId = bmk.hxr;
                    }
                    ae.bwj().a(LV2);
                }
                ae.bwj().n(this.userName, bmm.wUA, i2, i3);
                if (qVar.Hv().vIb == 207 || qVar.Hv().vIb == 2001 || qVar.Hv().vIb == TXLiveConstants.PLAY_EVT_PLAY_BEGIN) {
                    ae.bwj().et(this.userName, "");
                    String str5;
                    if (bmm.vSf.isEmpty()) {
                        n bwf2 = ae.bwf();
                        str5 = this.userName;
                        boolean z = this.fva;
                        bwf2.i(z, n.aG(str5, z) + " AND  (snsId != 0  ) ");
                        this.qZP = this.qZO;
                    } else {
                        n bwf3 = ae.bwf();
                        er = this.userName;
                        boolean z2 = this.fva;
                        str3 = i.es(((blf) bmm.vSf.getFirst()).vWS);
                        str5 = n.aG(er, z2) + " AND  (snsId != 0  ) ";
                        if (n.LZ(str3)) {
                            str5 = str5 + " AND " + bwf3.Mc(str3);
                        }
                        bwf3.i(z2, str5);
                        ae.bwf().a(this.userName, this.fva, i.es(((blf) bmm.vSf.getLast()).vWS));
                        a(bmm, str2);
                    }
                    bvC();
                    KL(this.userName);
                    this.gLE.a(i2, i3, str, this);
                    return;
                } else if (bmm.vSf.size() == 0) {
                    x.d("MicroMsg.NetSceneSnsUserPage", "error: server give size zero");
                    this.gLE.a(i2, i3, str, this);
                    return;
                } else {
                    a(bmm, str2);
                    KL(this.userName);
                    this.gLE.a(i2, i3, str, this);
                    return;
                }
            }
        }
        KL(this.userName);
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final long bvp() {
        return this.qZP;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final boolean bvl() {
        return this.qZN;
    }

    public final boolean bvm() {
        return this.raH;
    }

    public final boolean bvq() {
        return this.raU;
    }

    public final boolean bvo() {
        return this.raV;
    }

    public final boolean bvn() {
        return this.raI;
    }

    public final long bvr() {
        return this.raW;
    }
}
