package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bgx;
import com.tencent.mm.protocal.c.bgy;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class z {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bgx vIG = new bgx();

        public final byte[] Hw() {
            this.vIG.wQE = k.a(this);
            return this.vIG.toByteArray();
        }

        public final int getCmdId() {
            return 42;
        }

        public final int Hx() {
            return 131;
        }
    }

    public static class b extends e implements c {
        public bgy vIH = new bgy();

        public final int E(byte[] bArr) {
            this.vIH = (bgy) new bgy().aH(bArr);
            k.a(this, this.vIH.wRa);
            return this.vIH.wRa.vQL;
        }
    }
}
