package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.aaw;
import com.tencent.mm.protocal.c.aax;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class r {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public aaw vIu = new aaw();

        public final byte[] Hw() {
            this.vHZ = ac.ceA();
            this.vIu.vSZ = new bes().bl(bi.chc());
            this.vIu.wqD = ac.cey().ver;
            this.vIu.wQE = k.a(this);
            return this.vIu.toByteArray();
        }

        public final int Hx() {
            return 381;
        }

        public final int getCmdId() {
            return 179;
        }
    }

    public static class b extends e implements c {
        public aax vIv = new aax();

        public final int E(byte[] bArr) {
            this.vIv = (aax) new aax().aH(bArr);
            k.a(this, this.vIv.wRa);
            return this.vIv.wRa.vQL;
        }

        public final int getCmdId() {
            return 1000000179;
        }
    }
}
