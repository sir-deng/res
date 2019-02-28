package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.btm;
import com.tencent.mm.protocal.c.btn;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class k {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public btm mkT = new btm();

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.mkT.vSZ = new bes().bl(bi.chc());
            this.mkT.wQE = com.tencent.mm.protocal.k.a(this);
            this.vHY = this.mkT.vSZ.wRm.toByteArray();
            return this.mkT.toByteArray();
        }

        public final int Hx() {
            return 930;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public btn mkU = new btn();

        public final int E(byte[] bArr) {
            this.mkU = (btn) new btn().aH(bArr);
            com.tencent.mm.protocal.k.a(this, this.mkU.wRa);
            return this.mkU.wRa.vQL;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
