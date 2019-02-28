package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ahy;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;

public final class u {

    public static class a extends d implements b {
        public ahy vIz = new ahy();

        public final byte[] Hw() {
            this.vHZ = ac.ceA();
            this.vIz.vSZ = new bes().bl(bi.chc());
            this.vIz.wQE = k.a(this);
            return this.vIz.toByteArray();
        }

        public final int Hx() {
            return 107;
        }

        public final int getCmdId() {
            return 48;
        }
    }
}
