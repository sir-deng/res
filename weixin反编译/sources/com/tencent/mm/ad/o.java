package com.tencent.mm.ad;

import com.tencent.mm.network.c;
import com.tencent.mm.network.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class o implements c {
    private final d hoV;

    public o(d dVar) {
        this.hoV = dVar;
    }

    public final byte[] Ky() {
        try {
            return this.hoV.Ky();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final byte[] CM() {
        try {
            return this.hoV.CM();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final int Cn() {
        int i = 0;
        try {
            return this.hoV.Cn();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return i;
        }
    }

    private String getUsername() {
        try {
            return this.hoV.getUsername();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final boolean Kz() {
        boolean z = false;
        try {
            return this.hoV.Kz();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return z;
        }
    }

    public final void setUsername(String str) {
        try {
            this.hoV.setUsername(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
        }
    }

    public final void v(byte[] bArr, int i) {
        try {
            this.hoV.v(bArr, i);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
        }
    }

    public final void reset() {
        try {
            this.hoV.reset();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
        }
    }

    public final String toString() {
        return (((("RAccInfo:\n" + "|-uin     =" + Cn() + "\n") + "|-user    =" + getUsername() + "\n") + "|-session =" + CM() + "\n") + "|-ecdhkey =" + bi.bx(KA()) + "\n") + "`-cookie  =" + bi.bx(Ky());
    }

    public final void g(String str, byte[] bArr) {
        try {
            this.hoV.g(str, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
        }
    }

    public final byte[] js(String str) {
        try {
            return this.hoV.js(str);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final byte[] KA() {
        try {
            return this.hoV.KA();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
            return null;
        }
    }

    public final void bF(boolean z) {
        try {
            this.hoV.bF(z);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
        }
    }

    public final boolean KB() {
        boolean z = true;
        try {
            return this.hoV.KB();
        } catch (Throwable e) {
            Object[] objArr = new Object[z];
            objArr[0] = bi.i(e);
            x.e("MicroMsg.RAccInfo", "exception:%s", objArr);
            return z;
        }
    }

    public final byte[] KC() {
        try {
            return this.hoV.KC();
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", bi.i(e));
            return null;
        }
    }

    public final int G(byte[] bArr) {
        try {
            return this.hoV.G(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "AccInfoCacheInWorker parseBuf exception:%s", bi.i(e));
            return -6;
        }
    }

    public final void eE(int i) {
        try {
            this.hoV.eE(i);
        } catch (Throwable e) {
            x.e("MicroMsg.RAccInfo", "exception:%s", bi.i(e));
        }
    }
}
