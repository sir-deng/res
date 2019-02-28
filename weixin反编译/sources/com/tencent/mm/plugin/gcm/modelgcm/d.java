package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class d {

    public static class a extends com.tencent.mm.protocal.k.d implements com.tencent.mm.protocal.k.b {
        public cm nDY = new cm();

        public final byte[] Hw() {
            this.nDY.wQE = k.a(this);
            return this.nDY.toByteArray();
        }

        public final int getCmdId() {
            return GameJsApiGetGameCommInfo.CTRL_BYTE;
        }

        public final int Hx() {
            return 624;
        }
    }

    public static class b extends e implements c {
        public cn nDZ = new cn();

        public final int E(byte[] bArr) {
            this.nDZ = (cn) new cn().aH(bArr);
            k.a(this, this.nDZ.wRa);
            return this.nDZ.wRa.vQL;
        }

        public final int getCmdId() {
            return 1000000241;
        }
    }
}
