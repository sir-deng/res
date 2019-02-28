package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.b.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e, d {
    private String mFy = null;
    boolean pud = false;
    a tlY = null;
    private a tlZ = null;
    private boolean tma = false;

    public final void a(a aVar, Bundle bundle) {
        this.mFy = bundle.getString("key_pay_passwd");
        this.tma = bundle.getBoolean("key_fp_lock_offline_mode");
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", this.mFy, Boolean.valueOf(this.tma));
        this.tlY = aVar;
        this.pud = false;
        g.tnR.tnS = null;
        g.tnR.tnT = null;
        com.tencent.mm.kernel.g.CN().a(1967, (e) this);
        com.tencent.mm.kernel.g.CN().a(1548, (e) this);
        if (this.tma) {
            g.tnR.tnS = String.valueOf(System.currentTimeMillis());
            kc(false);
            return;
        }
        final SharedPreferences cgg = ad.cgg();
        if (cgg != null) {
            String string = cgg.getString("cpu_id", null);
            String string2 = cgg.getString("uid", null);
            x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", string, string2);
            if (bi.oN(string) || bi.oN(string2)) {
                b.a(true, true, new com.tencent.mm.plugin.soter.c.e() {
                    public final void yu(int i) {
                        if (!c.this.pud) {
                            if (i == 0) {
                                c.eK(cgg.getString("cpu_id", null), cgg.getString("uid", null));
                            } else if (c.this.tlY != null) {
                                c.this.tlY.ai(2, "init soter failed");
                            }
                        }
                    }
                });
            } else {
                eK(string, string2);
            }
        } else if (this.tlY != null) {
            this.tlY.ai(2, "system error");
        }
    }

    private void kc(boolean z) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", Boolean.valueOf(z));
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>() {
            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey onResult errCode: %d, errMsg: %s, isCancelled: %b", Integer.valueOf(cVar.errCode), cVar.foE, Boolean.valueOf(c.this.pud));
                if (!c.this.pud) {
                    if (cVar.isSuccess()) {
                        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo update wallet lock auth key success");
                        if (c.this.tlY != null) {
                            c.this.tlY.ai(0, "prepare auth key ok");
                            return;
                        }
                        return;
                    }
                    x.e("MicroMsg.FingerprintLockOpenDelegate", "alvinluo error when prepare auth key");
                    h.eh(2, cVar.errCode);
                    if (c.this.tlY != null) {
                        c.this.tlY.ai(2, cVar.foE);
                    }
                }
            }
        }, z, 3, this.tma ? null : new g(this.mFy), new com.tencent.mm.plugin.soter.b.e());
    }

    static void eK(String str, String str2) {
        com.tencent.mm.kernel.g.CN().a(new e(str, str2), 0);
    }

    public final void a(a aVar, String str, String str2, String str3) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
        this.tlZ = aVar;
        com.tencent.mm.kernel.g.CN().a(new f(str2, str3, str), 0);
    }

    public final void release() {
        x.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
        this.tlY = null;
        this.tlZ = null;
        this.pud = true;
        com.tencent.mm.kernel.g.CN().b(1967, (e) this);
        com.tencent.mm.kernel.g.CN().b(1548, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType()));
        if (!this.pud) {
            if (kVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    e eVar = (e) kVar;
                    g.tnR.tnS = eVar.mFv;
                    kc(eVar.tmd);
                } else if (this.tlY != null) {
                    this.tlY.ai(7, "get challenge failed");
                }
            } else if (!(kVar instanceof f)) {
            } else {
                if (i == 0 && i2 == 0) {
                    h.kh(true);
                    if (this.tlZ != null) {
                        this.tlZ.ai(0, "open touch lock ok");
                        return;
                    }
                    return;
                }
                h.kh(false);
                if (this.tlZ != null) {
                    this.tlZ.ai(6, "open touch lock failed");
                }
            }
        }
    }
}
