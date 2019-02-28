package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bjc;
import com.tencent.mm.protocal.c.bjd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class f extends e {
    private final b gLB;
    private e gLE;

    public f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        int Wo;
        float f2;
        int i4 = 1;
        float f3 = 0.0f;
        super(j);
        a aVar = new a();
        aVar.hnT = new bjc();
        aVar.hnU = new bjd();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        this.gLB = aVar.Kf();
        bjc bjc = (bjc) this.gLB.hnQ.hnY;
        bjc.weD = new bes().bl(bArr);
        bjc.wTc = i2;
        bjc.vSa = z ? 1 : 0;
        bjc.wTd = (float) i;
        bjc.wdO = ab.bC(ad.getContext()) ? 1 : 2;
        bjc.vOK = i3;
        try {
            as.Hm();
            f = bi.getFloat((String) c.Db().get(w.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                as.Hm();
                f3 = bi.getFloat((String) c.Db().get(w.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                as.Hm();
                Wo = bi.Wo((String) c.Db().get(w.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
            } catch (Exception e) {
                f2 = f3;
                f3 = f;
            }
        } catch (Exception e2) {
            f2 = 0.0f;
        }
        bjc.vXy = f;
        bjc.wTe = f3;
        bjc.wud = com.tencent.mm.au.c.QG() ? 0 : 1;
        if (!com.tencent.mm.au.c.QF()) {
            i4 = 0;
        }
        bjc.wue = i4;
        o.a(2014, bjc.wTe, bjc.vXy, Wo);
        f = f3;
        f3 = f2;
        Wo = 0;
        bjc.vXy = f;
        bjc.wTe = f3;
        if (com.tencent.mm.au.c.QG()) {
        }
        bjc.wud = com.tencent.mm.au.c.QG() ? 0 : 1;
        if (com.tencent.mm.au.c.QF()) {
            i4 = 0;
        }
        bjc.wue = i4;
        o.a(2014, bjc.wTe, bjc.vXy, Wo);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bjc bjc = (bjc) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(bjc.wTc), Integer.valueOf(bjc.weD.wRk), Integer.valueOf(bjc.vSa), Float.valueOf(bjc.wTd), Integer.valueOf(bjc.wdO), Integer.valueOf(bjc.vOK));
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bjc bjc = (bjc) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bjc.wTc), Integer.valueOf(((bjd) this.gLB.hnR.hnY).vSa));
        if (i2 == 0 && i3 == 0 && r1.vSa == 1) {
            this.qvK = true;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final bek bsP() {
        return (bjd) this.gLB.hnR.hnY;
    }

    public final int getType() {
        return 367;
    }
}
