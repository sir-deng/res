package com.tencent.mm.modelvoice;

import com.tencent.mm.ad.h;
import com.tencent.mm.audio.b.a;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.audio.c.e;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class k implements a {
    private static int hZh = 100;
    private int fkc = 0;
    public c fkr;
    c.a fle = new c.a() {
        public final void q(byte[] bArr, int i) {
            if (k.this.hZi != null) {
                k.this.hZi.a(new g.a(bArr, i), 0, false);
            }
            k.a(k.this, bArr, i);
        }

        public final void aK(int i, int i2) {
        }
    };
    private e hZi;
    private String mFileName = null;
    public int mStatus = 0;

    static /* synthetic */ void a(k kVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > kVar.fkc) {
                kVar.fkc = s;
            }
        }
    }

    public final boolean cI(String str) {
        if (bi.oN(this.mFileName)) {
            this.mStatus = 1;
            this.fkc = 0;
            this.fkr = new c(16000, 1, 0);
            this.fkr.fkT = -19;
            if (q.gHP.gGB > 0) {
                this.fkr.n(q.gHP.gGB, true);
            } else {
                this.fkr.n(5, false);
            }
            this.fkr.aQ(false);
            this.fkr.fle = this.fle;
            this.hZi = new e();
            if (!this.hZi.cL(str)) {
                x.e("MicroMsg.SpeexRecorder", "init speex writer failed");
                clean();
                this.mStatus = -1;
                return false;
            } else if (this.fkr.vs()) {
                this.mFileName = str;
                return true;
            } else {
                x.e("MicroMsg.SpeexRecorder", "start record failed");
                clean();
                this.mStatus = -1;
                return false;
            }
        }
        x.e("MicroMsg.SpeexRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
        return false;
    }

    public final void a(h.a aVar) {
    }

    public final boolean vj() {
        this.mFileName = null;
        this.mStatus = 0;
        clean();
        return true;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    private void clean() {
        if (this.fkr != null) {
            this.fkr.vj();
            this.fkr = null;
        }
        if (this.hZi != null) {
            this.hZi.vK();
            this.hZi = null;
        }
    }

    public final int getMaxAmplitude() {
        int i = this.fkc;
        this.fkc = 0;
        if (i > hZh) {
            hZh = i;
        }
        return (i * 100) / hZh;
    }

    public final int vk() {
        return this.fkr.flj;
    }
}
