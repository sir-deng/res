package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends a {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public int netType;
        public int vIe = 0;

        public final byte[] Hw() {
            gq gqVar = new gq();
            gqVar.vRR = d.vHl;
            gqVar.vSw = 2;
            gqVar.vSx = this.netType;
            gqVar.vSy = this.vIe;
            x.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", Integer.valueOf(gqVar.vSy), Integer.valueOf(gqVar.vSx), Integer.valueOf(gqVar.vRR), Integer.valueOf(gqVar.vSw));
            byte[] bArr = null;
            try {
                return gqVar.toByteArray();
            } catch (Throwable e) {
                x.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", bi.i(e));
                return bArr;
            }
        }

        public final int Hx() {
            return 0;
        }

        public final int getCmdId() {
            return 312;
        }

        public final boolean cev() {
            return true;
        }

        public final boolean KN() {
            return false;
        }
    }

    public static class b extends e implements c {
        public gr vIf = new gr();

        public final int E(byte[] bArr) {
            this.vIf = (gr) new gr().aH(bArr);
            x.d("MicroMsg.MMBgFg", "retcode:" + this.vIf.lot);
            return this.vIf.lot;
        }

        public final int getCmdId() {
            return 1000000312;
        }

        public final boolean cev() {
            return true;
        }
    }
}
