package oicq.wlogin_sdk.a;

public final class ah extends a {
    public int AGQ;

    public ah() {
        this.AGQ = 0;
        this.AFz = 325;
    }

    public final byte[] cd(byte[] bArr) {
        int length;
        if (bArr != null) {
            length = bArr.length + 0;
        } else {
            length = 0;
        }
        Object obj = new byte[length];
        if (obj.length > 0) {
            System.arraycopy(bArr, 0, obj, 0, length);
        }
        this.AGQ = obj.length;
        super.JF(this.AFz);
        super.V(obj, obj.length);
        super.cKJ();
        return super.cKF();
    }
}
