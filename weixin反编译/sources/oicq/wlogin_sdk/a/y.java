package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import oicq.wlogin_sdk.tools.util;

public final class y extends a {
    int AGG;

    public y() {
        this.AGG = 0;
        this.AFz = JsApiSetAudioState.CTRL_INDEX;
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

    public final byte[] a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        int W = W(bArr, 16);
        int W2 = W(bArr2, 16);
        int W3 = W(bArr3, 16);
        int W4 = W(bArr4, 32);
        int W5 = W(bArr5, 16);
        this.AGG = (((((((((W + 2) + 2) + W2) + 2) + 2) + W3) + 2) + W4) + 2) + W5;
        Object obj = new byte[this.AGG];
        util.A(obj, 0, W);
        System.arraycopy(bArr, 0, obj, 2, W);
        W += 2;
        util.A(obj, W, W2);
        W += 2;
        System.arraycopy(bArr2, 0, obj, W, W2);
        W += W2;
        util.A(obj, W, i);
        W += 2;
        util.A(obj, W, W3);
        W += 2;
        System.arraycopy(bArr3, 0, obj, W, W3);
        W += W3;
        util.A(obj, W, W4);
        W += 2;
        System.arraycopy(bArr4, 0, obj, W, W4);
        W += W4;
        util.A(obj, W, W5);
        System.arraycopy(bArr5, 0, obj, W + 2, W5);
        super.JF(this.AFz);
        super.V(obj, this.AGG);
        super.cKJ();
        return super.cKF();
    }
}
