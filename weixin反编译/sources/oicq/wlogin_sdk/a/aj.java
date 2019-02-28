package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.AFz = 327;
    }

    private static int ce(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2) {
        int ce = ce(bArr);
        int ce2 = ce(bArr2);
        Object obj = new byte[(((ce + 6) + 2) + ce2)];
        util.d(obj, 0, j);
        util.A(obj, 4, ce);
        System.arraycopy(bArr, 0, obj, 6, ce);
        ce += 6;
        util.A(obj, ce, ce2);
        System.arraycopy(bArr2, 0, obj, ce + 2, ce2);
        super.JF(this.AFz);
        super.V(obj, obj.length);
        super.cKJ();
        return super.cKF();
    }
}
