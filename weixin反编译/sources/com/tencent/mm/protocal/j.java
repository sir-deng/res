package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.x;

public final class j {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public er vHO = new er();
        public byte[] vHP;

        public final byte[] Hw() {
            this.vHO.wQE = k.a(this);
            x.d("MicroMsg.MMBakchatCreateQRcodeOffline.Req", "key:%s  AddrCount:%s  AddrList:%s, PCName:%s, PCAcctName:%s, Scene:%s, DataSize:%s, WifiName:%s, Tickit:%s", this.vHP, Integer.valueOf(this.vHO.vQF), this.vHO.vQG, this.vHO.vQH, this.vHO.vQI, Integer.valueOf(this.vHO.sfa), Long.valueOf(this.vHO.kyU), this.vHO.vQJ, this.vHO.vQK);
            return this.vHO.toByteArray();
        }

        public final int Hx() {
            return 1000;
        }

        public final int getCmdId() {
            return 1000;
        }
    }

    public static class b extends e implements c {
        public et vHQ = new et();

        public final int E(byte[] bArr) {
            this.vHQ = (et) new et().aH(bArr);
            x.d("MicroMsg.MMBakchatCreateQRcodeOffline.Resp", "Ret:%d, QRCodeBuffer:%s, QRCodeUrl:%s", Integer.valueOf(this.vHQ.vQL), this.vHQ.vQM, this.vHQ.vQN);
            return this.vHQ.vQL;
        }

        public final int getCmdId() {
            return 1000;
        }
    }
}
