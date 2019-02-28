package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int AGD;
    int AGE;

    public r() {
        this.AGD = 0;
        this.AGE = 0;
        this.AFz = 278;
    }

    public final byte[] a(int i, int i2, long[] jArr) {
        this.AGD = 10;
        byte[] bArr = new byte[this.AGD];
        util.z(bArr, 0, this.AGE);
        util.B(bArr, 1, i);
        util.B(bArr, 5, i2);
        util.z(bArr, 9, 0);
        super.JF(this.AFz);
        super.V(bArr, this.AGD);
        super.cKJ();
        return super.cKF();
    }
}
