package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.audio.b.c;
import com.tencent.mm.plugin.talkroom.component.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private c fkr;
    private c.a flv = new c.a() {
        public final void q(byte[] bArr, int i) {
            x.d("MicroMsg.MicRecoder", "pcm len: " + i);
            if (i <= 0) {
                x.e("MicroMsg.MicRecoder", "pcm data too low");
                return;
            }
            f.a(f.this, bArr, i);
            int Send = f.this.sgv.Send(bArr, (short) i);
            if (Send < 0) {
                x.e("MicroMsg.MicRecoder", "send failed, ret: " + Send);
            }
        }

        public final void aK(int i, int i2) {
        }
    };
    private v2engine sgv;
    private short sgw;
    private short sgx;

    static /* synthetic */ void a(f fVar, byte[] bArr, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
            if (s > fVar.sgw) {
                fVar.sgw = s;
            }
        }
    }

    public f(v2engine v2engine) {
        this.sgv = v2engine;
    }

    public final void bFh() {
        if (this.fkr != null) {
            this.fkr.vj();
            this.fkr = null;
        }
    }

    public final void bFi() {
        this.fkr = new c(com.tencent.mm.plugin.talkroom.model.a.sgK, 1, 2);
        this.fkr.n(8, false);
        this.fkr.fle = this.flv;
        this.fkr.et(20);
        this.fkr.vs();
        this.sgx = (short) 0;
        this.sgw = (short) 0;
    }

    public final int bFj() {
        if (this.sgx < this.sgw) {
            this.sgx = this.sgw;
        }
        if (this.sgx == (short) 0) {
            return 0;
        }
        short s = (short) ((this.sgw * 100) / this.sgx);
        this.sgw = (short) 0;
        return s;
    }

    public final void start() {
    }

    public final void release() {
        bFh();
    }
}
