package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int AGk;
    int AGl;
    int AGm;
    int AGn;
    byte[] AGo;

    public b() {
        this.AGk = 4;
        this.AGl = 14;
        this.AGm = 1;
        this.AGn = 20;
        this.AGo = new byte[2];
        this.AFz = 1;
    }

    public final Boolean cKK() {
        if (this.AGj < 20) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final byte[] g(long j, byte[] bArr) {
        Object obj = new byte[this.AGn];
        util.A(obj, 0, this.AGm);
        util.B(obj, 2, util.cKP());
        util.B(obj, 6, (int) j);
        util.d(obj, 10, util.cKR());
        System.arraycopy(bArr, 0, obj, 14, bArr.length);
        util.A(obj, bArr.length + 14, 0);
        super.JF(this.AFz);
        super.V(obj, this.AGn);
        super.cKJ();
        return super.cKF();
    }
}
