package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int AGM;
    int AGN;

    public ae() {
        this.AGM = 0;
        this.AGN = 0;
        this.AFz = 322;
    }

    public final byte[] cc(byte[] bArr) {
        this.AGN = bArr.length + 4;
        Object obj = new byte[this.AGN];
        util.A(obj, 0, this.AGM);
        util.A(obj, 2, bArr.length);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        super.JF(this.AFz);
        super.V(obj, obj.length);
        super.cKJ();
        return super.cKF();
    }
}
