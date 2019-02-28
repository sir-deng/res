package com.tencent.mm.plugin.voip_cs.b.a;

import com.tencent.mm.audio.b.c.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class c {
    private a nKh = new a() {
        public final void q(byte[] bArr, int i) {
            if (i <= 0) {
                x.e("MicroMsg.cs.VoipCsAudioManager", "pcm data len <= 0");
                return;
            }
            x.d("MicroMsg.cs.VoipCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
            x.d("MicroMsg.cs.VoipCsAudioManager", "recordCallback,ret:" + b.bJC().nKn.recordCallback(bArr, i, 200));
        }

        public final void aK(int i, int i2) {
            x.i("MicroMsg.cs.VoipCsAudioManager", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i), Integer.valueOf(i2));
        }
    };
    private com.tencent.mm.plugin.voip.model.a oLA = new com.tencent.mm.plugin.voip.model.a() {
        public final int M(byte[] bArr, int i) {
            x.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
            int playCallback = b.bJC().nKn.playCallback(bArr, i);
            if (playCallback != 0) {
                x.d("MicroMsg.cs.VoipCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
            }
            return playCallback != 0 ? 1 : 0;
        }
    };
    public com.tencent.mm.audio.b.c oLx = new com.tencent.mm.audio.b.c(v2protocal.oLp, 1, 1);
    public com.tencent.mm.plugin.voip.model.b sqD;

    public c() {
        this.oLx.et(20);
        this.oLx.aR(true);
        this.oLx.vr();
        this.oLx.n(1, false);
        this.oLx.aQ(true);
        this.oLx.fle = this.nKh;
        this.sqD = new com.tencent.mm.plugin.voip.model.b();
        this.sqD.Y(v2protocal.oLp, 20, 0);
        this.sqD.l(ad.getContext(), false);
        this.sqD.soY = this.oLA;
    }

    private boolean ji(boolean z) {
        if (this.sqD != null) {
            return this.sqD.ji(z);
        }
        return false;
    }

    public final void jk(boolean z) {
        x.j("MicroMsg.cs.VoipCsAudioManager", "enableSpeaker: " + z, new Object[0]);
        x.d("MicroMsg.cs.VoipCsAudioManager", "MMCore.getAudioManager() " + as.Hn().xW());
        if (as.Hn().xS()) {
            z = false;
        }
        if (q.gHG.gEr) {
            q.gHG.dump();
            if (q.gHG.gEs > 0) {
                ji(z);
            }
        }
        if (q.gHG.gEU >= 0 || q.gHG.gEV >= 0) {
            ji(z);
        }
        if (this.sqD != null) {
            as.Hn().b(z, this.sqD.bGR());
            com.tencent.mm.plugin.voip_cs.b.b.a bJC = b.bJC();
            int tv = z ? bJC.nKn.tv(401) : bJC.nKn.tv(e.CTRL_INDEX);
            if (tv < 0) {
                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:" + tv);
            }
        }
    }
}
