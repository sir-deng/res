package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.protocal.c.bjh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.rtmp.TXLiveConstants;

public final class g extends e {
    private final b gLB;
    private e gLE;

    public g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        a aVar = new a();
        aVar.hnT = new bjg();
        aVar.hnU = new bjh();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.hnS = av.CTRL_INDEX;
        aVar.hnV = i5;
        aVar.hnW = i5;
        this.gLB = aVar.Kf();
        bjg bjg = (bjg) this.gLB.hnQ.hnY;
        bjg.weD = new bes().bl(bArr);
        bjg.wTc = i2;
        bjg.vSa = z ? 1 : i5;
        bjg.wTd = (float) i;
        if (!ab.bC(ad.getContext())) {
            i4 = 2;
        }
        bjg.wdO = i4;
        bjg.vOK = i3;
        try {
            as.Hm();
            float f3 = bi.getFloat((String) c.Db().get(w.a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                as.Hm();
                f = bi.getFloat((String) c.Db().get(w.a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                try {
                    as.Hm();
                    i5 = bi.Wo((String) c.Db().get(w.a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
                    f2 = f;
                    f = f3;
                } catch (Exception e) {
                    f2 = f;
                    f = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
                f = f3;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        bjg.vXy = f;
        bjg.wTe = f2;
        o.a(TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION, bjg.wTe, bjg.vXy, i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bjg bjg = (bjg) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(bjg.wTc), Integer.valueOf(bjg.weD.wRk), Integer.valueOf(bjg.vSa), Float.valueOf(bjg.wTd), Integer.valueOf(bjg.wdO), Integer.valueOf(bjg.vOK));
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bjg bjg = (bjg) this.gLB.hnQ.hnY;
        x.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bjg.wTc), Integer.valueOf(((bjh) this.gLB.hnR.hnY).vSa));
        if (i2 == 0 && i3 == 0 && r1.vSa == 1) {
            this.qvK = true;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final bek bsP() {
        return (bjh) this.gLB.hnR.hnY;
    }

    public final int getType() {
        return av.CTRL_INDEX;
    }
}
