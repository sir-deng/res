package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.zk;
import com.tencent.mm.protocal.c.zl;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class i {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public zk mkP = new zk();

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.mkP.vSZ = new bes().bl(bi.chc());
            this.mkP.wQE = k.a(this);
            this.vHY = this.mkP.vSZ.wRm.toByteArray();
            return this.mkP.toByteArray();
        }

        public final int Hx() {
            return 733;
        }

        public final int getCmdId() {
            return 0;
        }
    }

    public static class b extends e implements c {
        public zl mkQ = new zl();

        public final int E(byte[] bArr) {
            this.mkQ = (zl) new zl().aH(bArr);
            k.a(this, this.mkQ.wRa);
            return this.mkQ.wRa.vQL;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
