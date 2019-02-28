package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int AGY;
    int AGZ;

    public ao() {
        this.AGY = 0;
        this.AGZ = 0;
        this.AFz = 2;
    }

    public final byte[] n(byte[] bArr, byte[] bArr2) {
        this.AGY = (bArr.length + 6) + bArr2.length;
        Object obj = new byte[this.AGY];
        util.A(obj, 0, this.AGZ);
        util.A(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        int length = bArr.length + 4;
        util.A(obj, length, bArr2.length);
        System.arraycopy(bArr2, 0, obj, length + 2, bArr2.length);
        super.JF(this.AFz);
        super.V(obj, this.AGY);
        super.cKJ();
        return super.cKF();
    }
}
