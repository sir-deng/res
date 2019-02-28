package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int AGV;
    int AGW;
    int AGX;

    public an() {
        this.AGV = 22;
        this.AGW = 1;
        this.AGX = 1536;
        this.AFz = 24;
    }

    public final byte[] a(long j, int i, long j2, int i2) {
        byte[] bArr = new byte[this.AGV];
        util.A(bArr, 0, this.AGW);
        util.B(bArr, 2, this.AGX);
        util.B(bArr, 6, (int) j);
        util.B(bArr, 10, i);
        util.B(bArr, 14, (int) j2);
        util.A(bArr, 18, 0);
        util.A(bArr, 20, 0);
        super.JF(this.AFz);
        super.V(bArr, this.AGV);
        super.cKJ();
        return super.cKF();
    }
}
