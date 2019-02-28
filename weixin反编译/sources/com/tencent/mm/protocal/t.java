package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.protocal.c.agv;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class t {

    public static class b extends e implements c {
        public agv vIy = new agv();

        public final int E(byte[] bArr) {
            this.vIy = (agv) new agv().aH(bArr);
            k.a(this, this.vIy.wRa);
            return this.vIy.wRa.vQL;
        }
    }

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public agu vIx = new agu();

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.vIx.vSZ = new bes().bl(bi.chc());
            this.vIx.wQE = k.a(this);
            return this.vIx.toByteArray();
        }

        public final int Hx() {
            return 429;
        }
    }
}
