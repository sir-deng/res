package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bwg;
import com.tencent.mm.protocal.c.bwh;
import com.tencent.mm.protocal.c.bwj;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends n<bwg, bwh> {
    public h(int i, long j, int i2, int i3, int i4, int[] iArr) {
        int i5 = 0;
        a aVar = new a();
        aVar.hnT = new bwg();
        aVar.hnU = new bwh();
        aVar.uri = "/cgi-bin/micromsg-bin/voipRedirect";
        aVar.hnS = HardCoderJNI.IDKEY_HARDCODER_FEATURES;
        this.gLB = aVar.Kf();
        bwg bwg = (bwg) this.gLB.hnQ.hnY;
        bwg.wil = i;
        bwg.wim = j;
        bwg.wNd = i2;
        bwg.xeb = i3;
        bwg.xec = i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            bwj bwj = new bwj();
            int i8 = i6 + 1;
            bwj.xem = iArr[i6];
            i6 = i8 + 1;
            bwj.xen = iArr[i8];
            i8 = i6 + 1;
            bwj.xeo = iArr[i6];
            int i9 = i8 + 1;
            bwj.xep = iArr[i8];
            i6 = i9 + 1;
            bwj.xeq = iArr[i9];
            bwg.xed.add(bwj);
        }
        if (this.sqC.sqj.svN.sry != 0) {
            i5 = (int) ((System.currentTimeMillis() - this.sqC.sqj.svN.sry) / 1000);
        }
        bwg.xee = i5;
    }

    public final int getType() {
        return HardCoderJNI.IDKEY_HARDCODER_FEATURES;
    }

    public final void dT(int i, int i2) {
        if (i == 0 && i2 == 0) {
            if (((bwh) this.gLB.hnR.hnY) != null) {
                x.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", Integer.valueOf(((bwh) this.gLB.hnR.hnY).wil), Long.valueOf(((bwh) this.gLB.hnR.hnY).wim), Integer.valueOf(((bwh) this.gLB.hnR.hnY).wNd));
                return;
            }
            return;
        }
        x.i("MicroMsg.Voip.Redirect", "Redirect error");
    }

    public final e bIt() {
        return new e() {
            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.Redirect", "Redirect response:" + i + " errCode:" + i2 + " status:" + h.this.sqC.mStatus);
                if (i2 != 0) {
                    com.tencent.mm.plugin.voip.b.a.ez("MicroMsg.Voip.Redirect", " redirect response with error code:" + i2);
                    return;
                }
                bwh bwh = (bwh) h.this.bIx();
                com.tencent.mm.plugin.voip.b.a.eA("MicroMsg.Voip.Redirect", "room " + bwh.wil + " member " + bwh.wNd + " key " + bwh.wim + " relay addr cnt " + bwh.xef + " RedirectThreshold " + bwh.xek + " RedirectDecision " + bwh.xel);
                buw buw = new buw();
                buw buw2 = new buw();
                buw buw3 = new buw();
                buw.xct = bwh.xef;
                buw.xcu = bwh.xeg;
                buw2.xct = bwh.xeh;
                buw2.xcu = bwh.xei;
                buw3.xct = bwh.xej;
                buw3.xcu = bwh.xcY;
                h.this.sqC.sqj.a(buw, buw2, buw3, bwh.xek, bwh.xel);
            }
        };
    }
}
