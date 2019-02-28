package oicq.wlogin_sdk.a;

public final class k extends a {
    int AGC;

    public k() {
        this.AGC = 0;
        this.AFz = 265;
    }

    public final byte[] cb(byte[] bArr) {
        this.AGC = bArr.length;
        Object obj = new byte[this.AGC];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.JF(this.AFz);
        super.V(obj, this.AGC);
        super.cKJ();
        return super.cKF();
    }
}
