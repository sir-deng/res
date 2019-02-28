package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.brd;
import com.tencent.mm.protocal.c.bre;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class c {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public brd rYg = new brd();

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.rYg.vSZ = new bes().bl(bi.chc());
            this.rYg.wQE = k.a(this);
            this.vHY = this.rYg.vSZ.wRm.toByteArray();
            return this.rYg.toByteArray();
        }

        public final int Hx() {
            return 627;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements com.tencent.mm.protocal.k.c {
        public bre rYh = new bre();

        public final int E(byte[] bArr) {
            this.rYh = (bre) new bre().aH(bArr);
            k.a(this, this.rYh.wRa);
            return this.rYh.wRa.vQL;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
