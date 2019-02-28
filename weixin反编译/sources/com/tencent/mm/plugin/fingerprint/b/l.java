package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.lang.ref.WeakReference;

public final class l implements j {
    private a mFa = null;
    private a mFb = null;
    private String mFe = "";
    WeakReference<WalletBaseUI> mFr = null;

    public final void a(Context context, a aVar, String str) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.mFr = new WeakReference((WalletBaseUI) context);
        this.mFa = aVar;
        this.mFe = str;
        ((WalletBaseUI) this.mFr.get()).jl(1586);
        ((WalletBaseUI) this.mFr.get()).jl(1638);
        com.tencent.mm.plugin.soter.c.a.bDv();
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        com.tencent.d.b.a.a(new b<c>() {
            public final /* synthetic */ void a(e eVar) {
                c cVar = (c) eVar;
                x.i("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.foE);
                if (cVar.isSuccess()) {
                    x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                    if (l.this.mFr == null || l.this.mFr.get() == null) {
                        l.this.aj(-1, "base ui is null");
                        return;
                    } else {
                        ((WalletBaseUI) l.this.mFr.get()).b(new com.tencent.mm.plugin.fingerprint.c.a(), false);
                        return;
                    }
                }
                com.tencent.mm.plugin.soter.c.a.dQ(2, cVar.errCode);
                if (cVar.errCode == 12) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 5) {
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed");
                } else if (cVar.errCode == 10) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.d.b.a.Is(1);
                    com.tencent.mm.plugin.soter.c.a.c(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.c.a.c(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 9) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.c.a.c(3, 4, cVar.errCode, cVar.foE);
                } else {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.c.a.c(1000, -1000223, cVar.errCode, cVar.foE);
                }
                l.this.aj(-1, cVar.foE);
            }
        }, true, 1, new com.tencent.mm.plugin.fingerprint.c.c(this.mFe), new com.tencent.mm.plugin.soter.b.e());
    }

    public final void clear() {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.mFr == null || this.mFr.get() == null)) {
            ((WalletBaseUI) this.mFr.get()).jm(1586);
            ((WalletBaseUI) this.mFr.get()).jm(1638);
        }
        this.mFa = null;
        s.sVy.reset();
        if (this.mFr != null && this.mFr.get() != null) {
            this.mFr.clear();
        }
    }

    final void aj(int i, String str) {
        if (this.mFa != null) {
            this.mFa.ai(i, str);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (bi.oN(str)) {
            str = ad.getContext().getString(i.uPL);
        }
        if (kVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (bi.oN(((com.tencent.mm.plugin.fingerprint.c.a) kVar).mFv)) {
                    aj(-1, str);
                    return true;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        l.this.aj(0, "");
                    }
                });
            } else {
                x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                aj(i2, str);
                com.tencent.mm.plugin.soter.c.a.c(7, i, i2, "get challenge failed");
                return true;
            }
        }
        if (!(kVar instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
            return false;
        }
        if (i2 == 0 && i == 0) {
            x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
            com.tencent.mm.plugin.soter.c.a.bDw();
            com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
            ak(0, str);
        } else {
            x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
            com.tencent.mm.plugin.soter.c.a.c(8, i, i2, "open fp pay failed");
            ak(-1, str);
        }
        return true;
    }

    private void ak(int i, String str) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.mFb.ai(i, str);
        this.mFb = null;
    }

    public final void a(a aVar, String str, int i) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.mFb = aVar;
        com.tencent.d.a.c.i iVar = s.sVy.sVA;
        if (iVar == null) {
            x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.c.a.c(9, -1000223, -1, "signature is null");
            aj(-1, ad.getContext().getString(i.uPL));
        } else if (this.mFr != null && this.mFr.get() != null) {
            ((WalletBaseUI) this.mFr.get()).l(new com.tencent.mm.plugin.fingerprint.c.b(iVar.AlM, iVar.signature, this.mFe));
        }
    }
}
