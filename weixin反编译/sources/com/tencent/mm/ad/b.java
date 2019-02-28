package com.tencent.mm.ad;

import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.bea;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.bkb;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;

public final class b extends i {
    public int fKU;
    public b hnQ;
    public c hnR;
    public int hnS;
    public String uri;

    public static class a {
        public int hnS = 1355;
        public com.tencent.mm.bp.a hnT;
        public com.tencent.mm.bp.a hnU;
        public int hnV = 0;
        public int hnW = 0;
        public boolean hnX = true;
        public String uri;

        public final void a(com.tencent.mm.bp.a aVar) {
            this.hnT = aVar;
        }

        public final void b(com.tencent.mm.bp.a aVar) {
            this.hnU = aVar;
        }

        public final void jr(String str) {
            this.uri = str;
        }

        public final void hk(int i) {
            this.hnS = x.CTRL_INDEX;
        }

        public final void hl(int i) {
            this.hnV = com.tencent.mm.plugin.appbrand.jsapi.a.c.CTRL_INDEX;
        }

        public final void hm(int i) {
            this.hnW = 1000000209;
        }

        public final b Kf() {
            if (this.hnT != null && this.hnU != null && !bi.oN(this.uri) && this.hnS > 0 && this.hnV != Integer.MIN_VALUE && this.hnW != Integer.MIN_VALUE) {
                return new b(this.hnT, this.hnU, this.uri, this.hnS, this.hnV, this.hnW, this.hnX, (byte) 0);
            }
            throw new IllegalArgumentException();
        }
    }

    public static final class b extends d implements com.tencent.mm.protocal.k.b {
        public int cmdId;
        private int hnS;
        public com.tencent.mm.bp.a hnY;
        private boolean hnZ;

        public b(com.tencent.mm.bp.a aVar, int i, int i2, boolean z) {
            this.hnY = aVar;
            this.hnS = i;
            this.cmdId = i2;
            this.hnZ = z;
        }

        public final int getCmdId() {
            return this.cmdId;
        }

        public final int Hx() {
            return this.hnS;
        }

        public final byte[] Hw() {
            if (this.hnY instanceof bea) {
                ((bea) this.hnY).wQE = k.a(this);
            }
            return this.hnY.toByteArray();
        }
    }

    public static final class c extends e implements com.tencent.mm.protocal.k.c {
        public int cmdId;
        public com.tencent.mm.bp.a hnY = null;
        private boolean hnZ;

        public c(com.tencent.mm.bp.a aVar, int i, boolean z) {
            this.hnY = aVar;
            this.cmdId = i;
            this.hnZ = z;
        }

        public final int E(byte[] bArr) {
            this.hnY = this.hnY.aH(bArr);
            if (this.hnY instanceof bkb) {
                return ((bkb) this.hnY).getRet();
            }
            k.a(this, ((bek) this.hnY).wRa);
            return ((bek) this.hnY).wRa.vQL;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }

    /* synthetic */ b(com.tencent.mm.bp.a aVar, com.tencent.mm.bp.a aVar2, String str, int i, int i2, int i3, boolean z, byte b) {
        this(aVar, aVar2, str, i, i2, i3, z);
    }

    protected final /* bridge */ /* synthetic */ d Hu() {
        return this.hnQ;
    }

    public final /* bridge */ /* synthetic */ e Hv() {
        return this.hnR;
    }

    private b(com.tencent.mm.bp.a aVar, com.tencent.mm.bp.a aVar2, String str, int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        this.hnQ = null;
        this.hnR = null;
        this.fKU = 0;
        if (z && (aVar instanceof bea)) {
            z2 = true;
        }
        this.hnQ = new b(aVar, i, i2, z2);
        this.hnR = new c(aVar2, i3, z);
        this.uri = str;
        this.hnS = i;
    }

    public final com.tencent.mm.bp.a Kc() {
        return this.hnQ.hnY;
    }

    public final com.tencent.mm.bp.a Kd() {
        return this.hnR.hnY;
    }

    public final int getType() {
        return this.hnS;
    }

    public final String getUri() {
        return this.uri;
    }

    public final void a(ac acVar) {
        this.hnQ.vHZ = acVar;
    }

    public final int Ke() {
        return this.fKU;
    }
}
