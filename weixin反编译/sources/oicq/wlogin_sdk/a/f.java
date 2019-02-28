package oicq.wlogin_sdk.a;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;

public final class f extends a {
    int AGs;

    public f() {
        this.AGs = 0;
        this.AFz = GameJsApiLaunchApplication.CTRL_BYTE;
    }

    public final byte[] bZ(byte[] bArr) {
        this.AGs = bArr.length;
        Object obj = new byte[this.AGs];
        System.arraycopy(bArr, 0, obj, 0, bArr.length);
        super.JF(this.AFz);
        super.V(obj, this.AGs);
        super.cKJ();
        return super.cKF();
    }
}
