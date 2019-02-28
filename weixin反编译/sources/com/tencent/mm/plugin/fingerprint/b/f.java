package com.tencent.mm.plugin.fingerprint.b;

import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.f.a.gw;
import com.tencent.mm.f.a.gw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;

public final class f extends c<gw> implements e {
    private String fvC;
    private boolean mEN;
    private gw mEU;
    private int mEV;
    ag mEW;

    private class a implements com.tencent.mm.plugin.fingerprint.b.o.a {
        private a() {
        }

        /* synthetic */ a(f fVar, byte b) {
            this();
        }

        public final void sE(final String str) {
            f.this.mEW.post(new Runnable() {
                public final void run() {
                    if (TextUtils.isEmpty(str)) {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "rsaKey is null");
                    }
                    k eVar = new com.tencent.mm.plugin.fingerprint.c.e(str);
                    g.Dr();
                    g.Dp().gRu.a(eVar, 0);
                }
            });
        }
    }

    public f() {
        this.mEV = 0;
        this.fvC = "";
        this.mEN = false;
        this.mEW = new ag(Looper.getMainLooper());
        this.xmG = gw.class.getName().hashCode();
    }

    private boolean a(gw gwVar) {
        if (g.Do().CF()) {
            x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener callback");
            this.mEN = false;
            if (!(gwVar instanceof gw)) {
                return false;
            }
            if (e.aKP()) {
                this.mEU = gwVar;
                g.Dr();
                g.Dp().gRu.a(385, (e) this);
                boolean z = this.mEU.fxP.fxR;
                this.mEV = this.mEU.fxP.fxS;
                this.fvC = this.mEU.fxP.fxT;
                if (z) {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth should gen rsa key!");
                    z = true;
                } else {
                    Object rsaKey = FingerPrintAuth.getRsaKey(e.cF(ad.getContext()), e.getUserId(), q.yM());
                    if (TextUtils.isEmpty(rsaKey)) {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() return null");
                        z = true;
                    } else {
                        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.getRsaKey() success!");
                        k eVar = new com.tencent.mm.plugin.fingerprint.c.e(rsaKey);
                        g.Dr();
                        g.Dp().gRu.a(eVar, 0);
                        z = false;
                    }
                }
                if (z) {
                    x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth begin asyc gen rsa key!");
                    new o(new a()).aLl();
                }
                return true;
            }
            x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "device is not support FingerPrintAuth");
            b bVar = new b();
            bVar.ftC = false;
            this.mEU.fxQ = bVar;
            this.mEN = true;
            auu();
            return true;
        }
        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "GenFingerPrintRsaKeyEventListener account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.c.e) {
            b bVar = new b();
            bVar.ftC = false;
            x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is success");
                com.tencent.mm.plugin.fingerprint.c.e eVar = (com.tencent.mm.plugin.fingerprint.c.e) kVar;
                String str2 = eVar.mFd;
                String str3 = eVar.fxV;
                String userId = e.getUserId();
                String yM = q.yM();
                String cCi = n.cCi();
                if (TextUtils.isEmpty(FingerPrintAuth.genOpenFPEncrypt(e.cF(ad.getContext()), userId, yM, String.valueOf(this.mEV), cCi, "", str2, str3, Build.MODEL))) {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt failed!");
                } else {
                    x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "FingerPrintAuth.genOpenFPEncrypt success!");
                    bVar.ftC = true;
                }
                String genPayFPEncrypt = FingerPrintAuth.genPayFPEncrypt(e.cF(ad.getContext()), userId, yM, String.valueOf(this.mEV), cCi, this.fvC, Build.MODEL);
                userId = FingerPrintAuth.genOpenFPSign(e.cF(ad.getContext()), e.getUserId(), q.yM(), genPayFPEncrypt);
                bVar.fxU = genPayFPEncrypt;
                bVar.fxV = userId;
            } else {
                x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "NetSceneTenpayGetOpenTouchCert doscene is fail");
            }
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            this.mEU.fxQ = bVar;
            this.mEN = true;
            auu();
        }
    }

    private void auu() {
        x.e("MicroMsg.GenFingerPrintRsaKeyEventListener", "doCallback()");
        if (this.mEU.frD != null) {
            this.mEU.frD.run();
        }
        if (this.mEN) {
            this.mEU = null;
        }
    }
}
