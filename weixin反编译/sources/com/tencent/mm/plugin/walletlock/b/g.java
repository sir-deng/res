package com.tencent.mm.plugin.walletlock.b;

import com.tencent.d.a.c.i;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.plugin.walletlock.gesture.a.b;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public enum g {
    ;
    
    int mType;
    public String tnS;
    public i tnT;

    private g(String str) {
        this.mType = -1;
    }

    public final void zR(int i) {
        x.i("MicroMsg.WalletLockManager", "alvinluo old wallet lock type: %d, new type: %d", Integer.valueOf(this.mType), Integer.valueOf(i));
        this.mType = i;
        com.tencent.mm.kernel.g.Dq().Db().a(a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(i));
        com.tencent.mm.kernel.g.Dq().Db().lO(true);
    }

    public final int bOV() {
        if (this.mType == -1) {
            this.mType = ((Integer) com.tencent.mm.kernel.g.Dq().Db().get(a.USERINFO_WALLETLOCK_CURRENT_USED_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        }
        return this.mType;
    }

    public static boolean bOC() {
        return b.bOC();
    }

    public static void kd(boolean z) {
        x.i("MicroMsg.GestureGuardManager", "alvinluo setUserSetGesturePwd: %b", Boolean.valueOf(z));
        com.tencent.mm.kernel.g.Dq().Db().a(a.USERINFO_WALLETLOCK_GESTURE_IS_OPENED_BOOLEAN_SYNC, Boolean.valueOf(z));
        com.tencent.mm.kernel.g.Dq().Db().lO(true);
    }

    public static boolean bOr() {
        x.i("MicroMsg.WalletLockManager", "isUserSetFingerprintLock: %b", Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOr()));
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOr();
    }

    public static void ke(boolean z) {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.kb(true);
    }

    public final void kf(boolean z) {
        x.i("MicroMsg.WalletLockManager", "alvinluo closeAllWalletLock");
        kg(z);
        kd(false);
    }

    public static void kg(boolean z) {
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.kb(false);
        if (z) {
            com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOq();
        }
    }

    public final boolean bOo() {
        if (this.mType == 1) {
            return b.bOD();
        }
        if (this.mType != 2) {
            return false;
        }
        x.i("MicroMsg.WalletLockManager", "alvinluo isUserBlockedInFingerprint: %b", Boolean.valueOf(com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOs()));
        return com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOs();
    }

    public static void bOt() {
        d.bOt();
        com.tencent.mm.plugin.walletlock.fingerprint.a.a.bOt();
    }

    public static boolean bOW() {
        boolean z;
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("TouchLockFunction", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        return h.bDD() && !z;
    }

    public static boolean bOX() {
        return ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("TouchLockFunction", 0) != 1;
    }
}
