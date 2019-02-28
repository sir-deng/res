package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class q implements e {
    private String smJ;
    private int smP;
    public String sne;
    public int snf;
    public a snu;

    public interface a {
        void Nf(String str);

        void bGp();

        void jh(boolean z);
    }

    public q() {
        this.snu = null;
        this.snf = -1;
        this.sne = null;
        this.smJ = null;
        this.smP = 0;
        as.CN().a(611, (e) this);
        as.CN().a(613, (e) this);
    }

    public q(a aVar) {
        this();
        this.snu = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoicePrintUnLockService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 611) {
                d dVar = (d) kVar;
                this.snf = dVar.smI;
                this.sne = dVar.smH;
                this.smJ = dVar.smJ;
                x.d("MicroMsg.VoicePrintUnLockService", "onGetVoiceText, resId:%d, verifyKey:%s, voiceText==null:%b", Integer.valueOf(this.snf), this.smJ, Boolean.valueOf(bi.oN(this.sne)));
                if (this.snu != null) {
                    this.snu.Nf(this.sne);
                }
            }
            if (kVar.getType() != 613) {
                return;
            }
            if (((j) kVar).smS == 0) {
                x.d("MicroMsg.VoicePrintUnLockService", "onVerify, success");
                if (this.snu != null) {
                    this.snu.jh(true);
                    return;
                }
                return;
            }
            x.d("MicroMsg.VoicePrintUnLockService", "onVerify, failed");
            if (this.snu != null) {
                this.snu.jh(false);
            }
        } else if (this.snu != null) {
            this.snu.bGp();
        }
    }
}
