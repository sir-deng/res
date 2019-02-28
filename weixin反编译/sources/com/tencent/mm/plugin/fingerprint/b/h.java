package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h implements j {
    private String fxV = null;
    ag mEW = new ag(new com.tencent.mm.sdk.platformtools.ag.a() {
        public final boolean handleMessage(Message message) {
            if (1 != message.what) {
                return false;
            }
            Object string = message.getData().getString("rsaKey");
            if (TextUtils.isEmpty(string)) {
                x.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
                ah.y(new Runnable() {
                    public final void run() {
                        h.this.mFa.ai(-1, h.this.mFc.getString(i.uPL));
                    }
                });
            }
            h.this.mFc.b(new e(string), false);
            return true;
        }
    });
    com.tencent.mm.pluginsdk.wallet.a mFa = null;
    private com.tencent.mm.pluginsdk.wallet.a mFb = null;
    WalletBaseUI mFc = null;
    private String mFd = null;
    private String mFe = null;

    private class a implements com.tencent.mm.plugin.fingerprint.b.o.a {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void sE(final String str) {
            if (TextUtils.isEmpty(str)) {
                ah.y(new Runnable() {
                    public final void run() {
                        h.this.mFa.ai(-1, h.this.mFc.getString(i.uPL));
                    }
                });
                x.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
                return;
            }
            ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
                    Message obtainMessage = h.this.mEW.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("rsaKey", str);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                }
            });
        }
    }

    public final void a(Context context, com.tencent.mm.pluginsdk.wallet.a aVar, String str) {
        this.mFc = (WalletBaseUI) context;
        this.mFa = aVar;
        this.mFe = str;
        Object rsaKey = FingerPrintAuth.getRsaKey(e.cF(ad.getContext()), e.getUserId(), q.yM());
        com.tencent.mm.plugin.soter.c.a.bDv();
        if (TextUtils.isEmpty(rsaKey)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new o(new a()).aLl();
            return;
        }
        x.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.mFc.b(new e(rsaKey), false);
    }

    public final void clear() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        if (kVar instanceof e) {
            com.tencent.mm.pluginsdk.wallet.a aVar;
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) kVar;
                this.mFd = eVar.mFd;
                this.fxV = eVar.fxV;
                aVar = this.mFa;
                str = "";
            } else {
                x.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                aVar = this.mFa;
                i3 = -1;
                if (bi.oN(str)) {
                    str = this.mFc.getString(i.uPL);
                }
            }
            aVar.ai(i3, str);
            return true;
        } else if (!(kVar instanceof f)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.soter.c.a.bDw();
                com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
                this.mFb.ai(0, "");
            } else {
                this.mFb.ai(-2, "");
            }
            return true;
        }
    }

    public final void a(com.tencent.mm.pluginsdk.wallet.a aVar, String str, int i) {
        this.mFb = aVar;
        if (TextUtils.isEmpty(this.mFe)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            aVar.ai(-1, this.mFc.getString(i.uPL));
            return;
        }
        String userId = e.getUserId();
        String yM = q.yM();
        String cCi = n.cCi();
        String str2 = "";
        CharSequence charSequence = "";
        if (e.aKP()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(e.cF(ad.getContext()), userId, yM, str, cCi, "", this.mFd, this.fxV, Build.MODEL);
            charSequence = FingerPrintAuth.genOpenFPSign(e.cF(ad.getContext()), e.getUserId(), q.yM(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.mFd)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(charSequence)) {
            x.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.mFc.b(new f(userId, charSequence, this.mFe, i), false);
    }
}
