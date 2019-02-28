package oicq.wlogin_sdk.request;

import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.AFz = 2064;
        this.AFA = 2;
        this.AFC = iVar;
    }

    public final byte[] bY(byte[] bArr) {
        int length;
        int i;
        int i2 = this.AFC.AFM;
        byte[] cKI = this.AFC.AFH.cKI();
        oicq.wlogin_sdk.a.g gVar = this.AFC.AFI;
        Object obj = new byte[gVar.AGu];
        if (gVar.AGu > 0) {
            System.arraycopy(gVar.AFt, gVar.AGw, obj, 0, gVar.AGu);
        }
        f fVar = new f();
        ao aoVar = new ao();
        Object bZ = fVar.bZ(cKI);
        Object n = aoVar.n(bArr, obj);
        Object obj2 = new byte[(bZ.length + n.length)];
        if (cKI.length > 0) {
            System.arraycopy(bZ, 0, obj2, 0, bZ.length);
            length = bZ.length + 0;
            i = 1;
        } else {
            length = 0;
            i = 0;
        }
        System.arraycopy(n, 0, obj2, length, n.length);
        a(this.AFu, this.AFz, AFv, this.AFC._uin, this.AFw, this.AFx, i2, this.AFy, super.u(obj2, this.AFA, i + 1));
        return super.cKF();
    }
}
