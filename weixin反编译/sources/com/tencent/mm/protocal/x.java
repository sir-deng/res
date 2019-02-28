package com.tencent.mm.protocal;

import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class x {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] fwk = null;
        public long hJs = -1;

        public final byte[] Hw() {
            Object obj = new byte[(this.fwk.length + 8)];
            int Wy = (int) (bi.Wy() - this.hJs);
            obj[0] = (byte) ((Wy >> 24) & 255);
            obj[1] = (byte) ((Wy >> 16) & 255);
            obj[2] = (byte) ((Wy >> 8) & 255);
            obj[3] = (byte) (Wy & 255);
            obj[4] = (byte) ((this.fwk.length >> 24) & 255);
            obj[5] = (byte) ((this.fwk.length >> 16) & 255);
            obj[6] = (byte) ((this.fwk.length >> 8) & 255);
            obj[7] = (byte) (this.fwk.length & 255);
            System.arraycopy(this.fwk, 0, obj, 8, this.fwk.length);
            bi.bx(obj);
            return obj;
        }

        public final int getCmdId() {
            return 1000000190;
        }

        public final int Hx() {
            return 268369922;
        }

        public final boolean KN() {
            return false;
        }
    }

    public static class b extends e implements c {
        public final int E(byte[] bArr) {
            return 0;
        }

        public final int getCmdId() {
            return -1;
        }
    }
}
