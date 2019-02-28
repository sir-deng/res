package com.tencent.mm.plugin.report.b;

import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.any;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public any pVQ = new any();

        public final byte[] Hw() {
            this.vHZ = ac.cez();
            this.pVQ.vSZ = new bes().bl(bi.chc());
            this.pVQ.wQE = k.a(this);
            return this.pVQ.toByteArray();
        }

        public final int Hx() {
            return 694;
        }

        public final int getCmdId() {
            return 0;
        }
    }
}
