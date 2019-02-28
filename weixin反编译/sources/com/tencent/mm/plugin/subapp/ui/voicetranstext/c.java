package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bsq;
import com.tencent.mm.protocal.c.bsr;
import com.tencent.mm.protocal.c.bss;
import com.tencent.mm.protocal.c.bum;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class c extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private String fHE;
    private b hnL;
    private String mFileName;
    private e oVh;
    private String seW;
    private bum seY;
    private int sfa;
    private String sfb;
    public bsq sfg;

    public c(c cVar) {
        this.seW = cVar.seW;
        this.seY = cVar.seY;
        this.sfg = cVar.sfg;
        this.mFileName = cVar.mFileName;
        this.sfa = cVar.sfa;
        this.sfb = cVar.sfb;
        this.fHE = cVar.fHE;
        x.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(cVar.sfa), cVar.sfb, cVar.fHE);
        bEV();
    }

    public c(String str, bsq bsq, int i, String str2) {
        Assert.assertTrue(str2 != null);
        this.seW = str;
        this.sfg = bsq;
        this.seY = d.aN(i, str2);
        this.mFileName = str2;
        bEV();
    }

    public c(String str, bsq bsq, int i, String str2, int i2, String str3, String str4) {
        Assert.assertTrue(str2 != null);
        x.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(i2), str3, str4);
        this.seW = str;
        this.sfg = bsq;
        this.seY = d.aN(i, str2);
        this.mFileName = str2;
        this.sfa = i2;
        this.sfb = str3;
        this.fHE = str4;
        bEV();
    }

    public final int getType() {
        return 547;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oVh = eVar2;
        Object obj = (bi.oN(this.mFileName) || bi.oN(this.seW) || this.sfg == null || this.seY == null) ? null : 1;
        if (obj == null) {
            x.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            return -1;
        }
        bsr bsr = (bsr) this.hnL.hnQ.hnY;
        bsr.wdG = this.seW;
        bsr.wdH = this.seY;
        bsr.wdJ = this.sfg;
        String str = this.mFileName;
        int i = this.sfg.vPt;
        int i2 = this.sfg.vPu;
        bes bes = new bes();
        com.tencent.mm.modelvoice.b nX = q.nX(str);
        if (nX != null) {
            bes = n.N(nX.bp(i, i2).buf);
        }
        bsr.weD = bes;
        bsr.sfa = this.sfa;
        bsr.npW = this.sfb;
        bsr.npV = this.fHE;
        return a(eVar, this.hnL, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        bEW();
        if (i2 == 0 && i3 == 0) {
            this.sfg = ((bss) this.hnL.hnR.hnY).wdJ;
        } else {
            x.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.oVh.a(i2, i3, str, this);
        if (bEW()) {
            boolean z;
            String str2 = "MicroMsg.NetSceneUploadVoiceForTrans";
            String str3 = "succeeed finish: %B";
            Object[] objArr = new Object[1];
            if (this.sfg != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
        }
    }

    private void bEV() {
        a aVar = new a();
        aVar.hnT = new bsr();
        aVar.hnU = new bss();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.hnS = 547;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hnL = aVar.Kf();
    }

    public final boolean bEW() {
        if (this.sfg == null || this.sfg.vPu <= 0) {
            return true;
        }
        return false;
    }
}
