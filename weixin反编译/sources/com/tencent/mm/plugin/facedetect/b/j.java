package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bcw;
import com.tencent.mm.protocal.c.bcx;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public bcw mkR = new bcw();

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.mkR.vSZ = new bes().bl(bi.chc());
            this.mkR.wQE = k.a(this);
            this.vHY = this.mkR.vSZ.wRm.toByteArray();
            return this.mkR.toByteArray();
        }

        public final int Hx() {
            return 931;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public bcx mkS = new bcx();

        public final int E(byte[] bArr) {
            this.mkS = (bcx) new bcx().aH(bArr);
            k.a(this, this.mkS.wRa);
            return this.mkS.wRa.vQL;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
