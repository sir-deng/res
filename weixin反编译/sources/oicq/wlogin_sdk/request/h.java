package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.AFz = 2064;
        this.AFA = 3;
        this.AFC = iVar;
    }

    public final int w(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        int U = super.U(bArr, i + 2);
        super.cKG();
        int i3 = i + 5;
        switch (U) {
            case 2:
                int y = fVar.y(bArr, i3, this.AFo - i3);
                if (y >= 0) {
                    this.AFC.AFH = fVar;
                    y = gVar.y(bArr, i3, this.AFo - i3);
                    if (y >= 0) {
                        this.AFC.AFI = gVar;
                        return U;
                    }
                }
                return y;
            case 5:
                super.v(bArr, i3, (this.AFo - i3) - 1);
                return U;
            default:
                v(bArr, i3, (this.AFo - i3) - 1);
                return U;
        }
    }
}
