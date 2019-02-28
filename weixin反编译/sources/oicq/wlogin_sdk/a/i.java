package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int AGA;

    public i() {
        this.AGA = 6;
        this.AFz = 263;
    }

    public final byte[] A(int i, int i2, int i3, int i4) {
        byte[] bArr = new byte[this.AGA];
        util.A(bArr, 0, 0);
        util.z(bArr, 2, 1);
        util.A(bArr, 3, 102400);
        util.z(bArr, 5, 1);
        super.JF(this.AFz);
        super.V(bArr, this.AGA);
        super.cKJ();
        return super.cKF();
    }
}
