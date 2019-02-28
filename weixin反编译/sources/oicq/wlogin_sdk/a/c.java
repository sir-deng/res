package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int AGp;
    int AGq;
    int AGr;

    public c() {
        this.AGp = 1;
        this.AGq = util.AHv;
        this.AGr = 22;
        this.AFz = 256;
    }

    public final byte[] a(long j, long j2, int i, int i2) {
        byte[] bArr = new byte[this.AGr];
        util.A(bArr, 0, this.AGp);
        util.B(bArr, 2, this.AGq);
        util.B(bArr, 6, (int) j);
        util.B(bArr, 10, 1);
        util.B(bArr, 14, i);
        util.B(bArr, 18, i2);
        super.JF(this.AFz);
        super.V(bArr, this.AGr);
        super.cKJ();
        return super.cKF();
    }
}
