package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int AGJ;

    public aa() {
        this.AGJ = 0;
        this.AFz = 296;
    }

    private static int W(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        int W = W(bArr, 32);
        int W2 = W(bArr2, 16);
        this.AGJ = (((W + 11) + 2) + W2) + 2;
        Object obj = new byte[this.AGJ];
        util.A(obj, 0, 0);
        util.z(obj, 2, i);
        util.z(obj, 3, i2);
        util.z(obj, 4, i3);
        util.B(obj, 5, 0);
        util.A(obj, 9, W);
        System.arraycopy(bArr, 0, obj, 11, W);
        W += 11;
        util.A(obj, W, W2);
        W += 2;
        System.arraycopy(bArr2, 0, obj, W, W2);
        util.A(obj, W + W2, 0);
        super.JF(this.AFz);
        super.V(obj, this.AGJ);
        super.cKJ();
        return super.cKF();
    }
}
