package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public final class v {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public atp vIA = new atp();

        public final byte[] Hw() {
            this.vIA.wQE = k.a(this);
            return this.vIA.toByteArray();
        }

        public final int Hx() {
            return com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX;
        }

        public final int getCmdId() {
            return 27;
        }
    }

    public static class b extends e implements c {
        public atq vIB = new atq();

        public final int E(byte[] bArr) {
            this.vIB = (atq) new atq().aH(bArr);
            k.a(this, this.vIB.wRa);
            return this.vIB.wRa.vQL;
        }

        public final int getCmdId() {
            return 1000000027;
        }
    }
}
