package oicq.wlogin_sdk.a;

public final class j extends a {
    int AGB;

    public j() {
        this.AGB = 0;
        this.AFz = 264;
    }

    public final byte[] ca(byte[] bArr) {
        this.AGB = bArr.length;
        Object obj = new byte[this.AGB];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.JF(this.AFz);
        super.V(obj, this.AGB);
        super.cKJ();
        return super.cKF();
    }
}
