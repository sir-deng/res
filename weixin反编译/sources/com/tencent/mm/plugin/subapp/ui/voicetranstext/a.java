package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbd;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bum;
import com.tencent.mm.protocal.c.bur;
import com.tencent.mm.protocal.c.od;
import com.tencent.mm.protocal.c.oe;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public static int sfc = 1;
    public static int sfd = 2;
    public static int sfe = 3;
    private String fHE;
    private b hnL;
    private String mFileName;
    public int mState = -1;
    private e oVh;
    private String seW;
    private int seX;
    private bum seY;
    private long seZ;
    private int sfa;
    private String sfb;
    public bur sff;
    public bsq sfg;
    public bbd sfh;
    int sfi;

    public a(String str, int i, String str2) {
        a(str, i, -1, -1, str2, 0, "", "");
    }

    public a(String str, int i, int i2, long j, String str2) {
        a(str, i, i2, j, str2, 0, "", "");
    }

    public a(String str, int i, String str2, int i2, String str3, String str4) {
        a(str, i, -1, -1, str2, i2, str3, str4);
    }

    public a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        a(str, i, i2, j, str2, i3, str3, str4);
    }

    private void a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new od();
        aVar.hnU = new oe();
        aVar.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        aVar.hnS = 546;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.mFileName = str2;
        this.hnL = aVar.Kf();
        x.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if (i2 >= 0) {
            this.seY = d.aN(i2, str2);
        }
        if (j > 0) {
            this.seZ = j;
        }
        this.seW = str;
        this.seX = i;
        this.sfa = i3;
        this.sfb = str3;
        this.fHE = str4;
    }

    public final int getType() {
        return 546;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oVh = eVar2;
        od odVar = (od) this.hnL.hnQ.hnY;
        odVar.wdG = this.seW;
        odVar.vPs = this.seX;
        odVar.wdH = this.seY;
        odVar.vNT = this.seZ;
        odVar.sfa = this.sfa;
        odVar.npW = this.sfb;
        odVar.npV = this.fHE;
        return a(eVar, this.hnL, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            oe oeVar = (oe) this.hnL.hnR.hnY;
            if (oeVar != null) {
                this.sff = oeVar.wdI;
                this.mState = oeVar.kyY;
                this.sfg = oeVar.wdJ;
                this.sfh = oeVar.wdK;
                this.sfi = oeVar.wdL;
            } else {
                return;
            }
        }
        x.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.seW);
        this.oVh.a(i2, i3, str, this);
    }

    public final boolean bEU() {
        return (this.sff == null || bi.oN(this.sff.xcd)) ? false : true;
    }
}
