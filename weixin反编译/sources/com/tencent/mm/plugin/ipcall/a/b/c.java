package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public boolean fBn;
    public boolean kYN;
    public com.tencent.mm.audio.b.c nKb;
    public final Object nKc;
    int nKd;
    boolean nKe;
    int nKf;
    boolean nKg;
    com.tencent.mm.audio.b.c.a nKh;

    private class a implements Runnable {
        private com.tencent.mm.audio.b.c nKj = null;

        public a(com.tencent.mm.audio.b.c cVar) {
            this.nKj = cVar;
        }

        public final void run() {
            x.d("MicroMsg.IPCallRecorder", "do stopRecord");
            if (this.nKj != null) {
                this.nKj.vj();
                this.nKj = null;
                c cVar = c.this;
                cVar.nKd = 92;
                cVar.nKe = true;
                cVar.nKf = 0;
            }
        }
    }

    public c() {
        this.nKb = null;
        this.nKc = new Object();
        this.fBn = false;
        this.kYN = false;
        this.nKd = 92;
        this.nKe = true;
        this.nKf = 0;
        this.nKg = true;
        this.nKh = new com.tencent.mm.audio.b.c.a() {
            public final void q(byte[] bArr, int i) {
                int i2 = 0;
                synchronized (c.this.nKc) {
                    int bGO;
                    c cVar = c.this;
                    if (cVar.nKd <= 10) {
                        cVar.nKd = 92;
                    }
                    a aVar = i.aUh().nJR;
                    if (aVar.nJL != null) {
                        bGO = aVar.nJL.bGO();
                    } else {
                        bGO = 0;
                    }
                    cVar.nKd = ((bGO + 24) + (cVar.nKd * 3)) / 4;
                    if (cVar.nKe) {
                        x.i("MicroMsg.IPCallRecorder", "preprocessForEcho FirstRefEcho");
                        aVar = i.aUh().nJR;
                        if (aVar.nJL != null) {
                            i2 = aVar.nJL.bGL();
                        }
                        cVar.nKf = i2;
                        if (cVar.nKf >= cVar.nKd) {
                            cVar.nKf -= cVar.nKd;
                        }
                        cVar.nKd = cVar.nKf;
                        cVar.nKe = false;
                    } else {
                        cVar.nKd = 0;
                    }
                    if (i.aUi().nIg == 5) {
                        if (c.this.nKg) {
                            x.i("MicroMsg.IPCallRecorder", "isFirstRecordCallback");
                            c.this.nKg = false;
                        }
                        i.aUf().nKn.recordCallback(bArr, i, c.this.nKd);
                    }
                }
            }

            public final void aK(int i, int i2) {
            }
        };
        this.fBn = false;
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.IPCallRecorder", "setMute: %b", Boolean.valueOf(z));
        if (this.fBn && this.nKb != null) {
            this.nKb.aS(z);
        }
        this.kYN = z;
    }
}
