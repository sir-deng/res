package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class l implements e {
    public int smP;
    public int snd;
    private String sne;
    public int snf;
    public a sng;

    public interface a {
        void Nd(String str);

        void Ne(String str);

        void bGp();

        void v(boolean z, int i);
    }

    public l() {
        this.snd = 71;
        this.sne = null;
        this.snf = 0;
        this.smP = 0;
        this.sng = null;
        as.CN().a(611, (e) this);
        as.CN().a(612, (e) this);
    }

    public l(a aVar) {
        this();
        this.sng = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoicePrintCreateService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.snf = dVar.smI;
                this.sne = dVar.smH;
                x.d("MicroMsg.VoicePrintCreateService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.snf), Boolean.valueOf(bi.oN(this.sne)));
                if (this.sng != null) {
                    if (this.snd == 71) {
                        this.sng.Nd(this.sne);
                    } else if (this.snd == 72) {
                        this.sng.Ne(this.sne);
                    }
                }
            }
            if (kVar.getType() == 612) {
                boolean z;
                f fVar = (f) kVar;
                if ((fVar.smR == 72 && fVar.smS == 0) || fVar.smR == 71) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    x.d("MicroMsg.VoicePrintCreateService", "onRegister, ok, step:%d", Integer.valueOf(fVar.smR));
                    this.smP = fVar.smP;
                    if (this.sng != null) {
                        this.sng.v(true, fVar.smR);
                    }
                } else {
                    x.d("MicroMsg.VoicePrintCreateService", "onRegister, not ok, step:%d", Integer.valueOf(fVar.smR));
                    if (this.sng != null) {
                        this.sng.v(false, fVar.smR);
                    }
                }
                if (z && fVar.smR == 71 && this.sng != null) {
                    this.sng.Ne(this.sne);
                }
            }
        } else if (this.sng != null) {
            this.sng.bGp();
        }
    }
}
