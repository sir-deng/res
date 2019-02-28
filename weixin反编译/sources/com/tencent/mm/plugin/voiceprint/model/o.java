package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.mm.f.a.sm;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public k sni;
    public al snj;
    int snk;
    int snl;

    public o() {
        this.sni = null;
        this.snj = null;
        this.snk = 0;
        this.snl = 0;
        this.sni = new k();
        this.snj = new al(Looper.getMainLooper(), new a() {
            public final boolean uG() {
                o.this.snk += 100;
                o.this.snl += (o.this.sni.getMaxAmplitude() * 100) / 100;
                if (o.this.snk < 3000) {
                    return true;
                }
                boolean z;
                o oVar = o.this;
                x.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
                oVar.sni.vj();
                oVar.snj.TN();
                oVar.snl /= 30;
                if (oVar.snl >= 30) {
                    z = true;
                } else {
                    z = false;
                }
                x.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", Integer.valueOf(oVar.snl), Boolean.valueOf(z));
                b smVar = new sm();
                smVar.fLa.fLb = z;
                com.tencent.mm.sdk.b.a.xmy.m(smVar);
                return false;
            }
        }, true);
    }

    public final void reset() {
        this.sni.vj();
        x.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        this.snj.TN();
        this.snk = 0;
        this.snl = 0;
    }
}
