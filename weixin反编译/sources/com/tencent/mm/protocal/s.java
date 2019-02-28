package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;

public final class s {

    public static class a extends d implements b {
        public afv vIw = new afv();

        public final byte[] Hw() {
            this.vHZ = ac.ceA();
            this.vIw.vSZ = new bes().bl(bi.chc());
            this.vIw.wQE = k.a(this);
            return this.vIw.toByteArray();
        }

        public final int Hx() {
            return 572;
        }
    }
}
