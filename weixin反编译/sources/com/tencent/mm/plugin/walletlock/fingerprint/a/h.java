package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.d.a.c.i;
import com.tencent.d.b.a.e;
import com.tencent.d.b.c.a;
import com.tencent.d.b.c.b;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    public a mFo = null;

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h$1 */
    class AnonymousClass1 implements b {
        final /* synthetic */ com.tencent.mm.plugin.walletlock.b.b tme;

        public AnonymousClass1(com.tencent.mm.plugin.walletlock.b.b bVar) {
            this.tme = bVar;
        }

        public final void aLi() {
            x.v("MicroMsg.SoterFingerprintAuthManager", "alvinluo onStartAuthentication");
            if (this.tme != null) {
                this.tme.bOB();
            }
        }

        public final void onAuthenticationHelp(int i, CharSequence charSequence) {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationHelp errCode: %d, errMsg: %s and do nothing", Integer.valueOf(i), charSequence);
        }

        public final void aLj() {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationSucceed");
            h.this.mFo = null;
        }

        public final void onAuthenticationFailed() {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationFailed");
            if (this.tme != null) {
                this.tme.K(1, "not match");
            }
        }

        public final void aLk() {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationCancelled");
            h.this.mFo = null;
        }

        public final void onAuthenticationError(int i, CharSequence charSequence) {
            x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo onAuthenticationError errCode: %d, errMsg: %s", Integer.valueOf(i), charSequence);
            h.this.mFo = null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.walletlock.fingerprint.a.h$2 */
    class AnonymousClass2 implements com.tencent.d.b.a.b<com.tencent.d.b.a.a> {
        final /* synthetic */ com.tencent.mm.plugin.walletlock.b.b tme;

        public AnonymousClass2(com.tencent.mm.plugin.walletlock.b.b bVar) {
            this.tme = bVar;
        }

        public final /* synthetic */ void a(e eVar) {
            com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
            x.i("MicroMsg.SoterFingerprintAuthManager", "request auth onResult errCode: %d, errMsg: %s", Integer.valueOf(aVar.errCode), aVar.foE);
            if (aVar.isSuccess()) {
                g.tnR.tnT = (i) aVar.AlN;
                if (this.tme != null) {
                    this.tme.K(0, "authenticate ok");
                    return;
                }
                return;
            }
            com.tencent.mm.plugin.walletlock.b.h.eh(3, aVar.errCode);
            if (aVar.errCode == 25) {
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo too many trial");
                if (this.tme != null) {
                    this.tme.K(3, "too many trial");
                }
            } else if (aVar.errCode == 24) {
                x.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo user cancelled");
                if (this.tme != null) {
                    this.tme.K(4, "user cancelled");
                }
            } else if (aVar.errCode == 18) {
                if (this.tme != null) {
                    this.tme.K(8, "no fingerprint enrolled in system");
                }
            } else if (this.tme != null) {
                this.tme.K(2, aVar.foE);
            }
        }
    }
}
