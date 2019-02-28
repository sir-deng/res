package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.ck;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class c {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public ck nDW = new ck();

        public final byte[] Hw() {
            this.nDW.wQE = k.a(this);
            return this.nDW.toByteArray();
        }

        public final int getCmdId() {
            return 289;
        }

        public final int Hx() {
            return 623;
        }
    }

    public static class b extends e implements com.tencent.mm.protocal.k.c {
        public cl nDX = new cl();

        public final int E(byte[] bArr) {
            this.nDX = (cl) new cl().aH(bArr);
            k.a(this, this.nDX.wRa);
            return this.nDX.wRa.vQL;
        }

        public final int getCmdId() {
            return 1000000289;
        }
    }
}
