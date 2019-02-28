package com.tencent.mm.protocal;

import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class m {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public hd vIg = new hd();

        public final byte[] Hw() {
            this.vHZ = ac.cey();
            this.vIg.vSZ = new bes().bl(bi.chc());
            this.vIg.wQE = k.a(this);
            return this.vIg.toByteArray();
        }

        public final int Hx() {
            return c.CTRL_INDEX;
        }
    }

    public static class b extends e implements k.c {
        public he vIh = new he();

        public final int E(byte[] bArr) {
            this.vIh = (he) new he().aH(bArr);
            k.a(this, this.vIh.wRa);
            return this.vIh.wRa.vQL;
        }
    }
}
