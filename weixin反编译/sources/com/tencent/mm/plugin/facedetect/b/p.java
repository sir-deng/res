package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.protocal.c.ir;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public abstract class p extends l implements k {
    static String mle = null;
    protected e gLE = null;

    abstract void An(String str);

    abstract void c(int i, int i2, String str, q qVar);

    abstract int g(com.tencent.mm.network.e eVar);

    protected abstract atl g(q qVar);

    protected static String Oc() {
        return mle;
    }

    public static void Ao(String str) {
        mle = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (bi.oN(mle)) {
            return getType();
        }
        x.i("MicroMsg.NetSceneFaceRsaBase", "hy: has ticket: %s", mle);
        An(mle);
        return g(eVar);
    }

    public final ir c(q qVar) {
        atl g = g(qVar);
        if (g != null) {
            return g.vTi;
        }
        return null;
    }

    public final atk d(q qVar) {
        atl g = g(qVar);
        if (g != null) {
            return g.vTj;
        }
        return null;
    }

    public final akv e(q qVar) {
        atl g = g(qVar);
        if (g != null) {
            return g.vTh;
        }
        return null;
    }

    public final void Kp() {
        if (this.gLE != null) {
            this.gLE.a(3, -1, "", this);
        }
    }

    public final e Kq() {
        return this.gLE;
    }

    public final void a(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneFaceRsaBase", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 4 && i2 == -102) {
            final int i3 = qVar.Kh().vHZ.ver;
            x.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i3));
            g.Dt().F(new Runnable() {
                public final void run() {
                    new m().a(p.this.hok, new e() {
                        public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
                            x.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                p.this.g(p.this.hok);
                                return;
                            }
                            x.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
                            p.mle = null;
                            p.this.An(p.Oc());
                            p.this.gLE.a(i, i2, "", p.this);
                        }
                    });
                }
            });
            return;
        }
        c(i, i2, str, qVar);
    }
}
