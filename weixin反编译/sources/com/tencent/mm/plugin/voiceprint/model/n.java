package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class n implements e {
    public String iTh = null;
    public String jPV = null;
    public String smV = null;
    private String sne = null;
    public int snf = -1;
    public a snh = null;

    public interface a {
        void Nf(String str);

        void bGp();

        void bGr();

        void jg(boolean z);
    }

    public n() {
        as.CN().a(618, (e) this);
        as.CN().a(616, (e) this);
        as.CN().a(617, (e) this);
    }

    public final void bGq() {
        as.CN().a(new g(this.iTh), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.VoicePrintLoginService", "onSceneEnd, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 || i2 == 0) {
            if (kVar.getType() == 618) {
                this.iTh = ((e) kVar).liu;
                x.d("MicroMsg.VoicePrintLoginService", "onGetTicket, loginTicket==null:%b", Boolean.valueOf(bi.oN(this.iTh)));
                if (!bi.oN(this.iTh)) {
                    bGq();
                }
            }
            if (kVar.getType() == 616) {
                g gVar = (g) kVar;
                this.snf = gVar.smI;
                this.sne = gVar.smH;
                x.d("MicroMsg.VoicePrintLoginService", "onFinishGetText, resId:%d, voiceText==null:%b", Integer.valueOf(this.snf), Boolean.valueOf(bi.oN(this.sne)));
                if (this.snh != null) {
                    this.snh.Nf(this.sne);
                }
            }
            if (kVar.getType() == 617) {
                h hVar = (h) kVar;
                if (hVar.smS == 0) {
                    x.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, success");
                    this.smV = hVar.smV;
                    if (this.snh != null) {
                        this.snh.jg(true);
                        return;
                    }
                    return;
                }
                x.d("MicroMsg.VoicePrintLoginService", "onFinishVerify, failed");
                if (this.snh != null) {
                    this.snh.jg(false);
                }
            }
        } else if (i2 == -34 && kVar.getType() == 617) {
            x.d("MicroMsg.VoicePrintLoginService", "blocked by limit");
            if (this.snh != null) {
                this.snh.bGr();
            }
        } else if (this.snh != null) {
            this.snh.bGp();
        }
    }
}
