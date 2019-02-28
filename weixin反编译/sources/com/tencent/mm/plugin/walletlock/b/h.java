package com.tencent.mm.plugin.walletlock.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static long mmh = -1;

    public static void eh(int i, int i2) {
        int i3;
        switch (i2) {
            case 5:
                i3 = 5;
                break;
            case 10:
                i3 = 6;
                break;
            case 26:
                if (i != 3) {
                    i3 = -1;
                    break;
                } else {
                    i3 = 4;
                    break;
                }
            default:
                i3 = -1;
                break;
        }
        if (i3 != -1) {
            x.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock idkey report id: %d, key: %d, value: %d", Integer.valueOf(713), Integer.valueOf(i3), Long.valueOf(1));
            g.pWK.a(713, (long) i3, 1, false);
        }
    }

    public static void kh(boolean z) {
        long j;
        x.i("MicroMsg.WalletLockReportManager", "alvinluo idkey fingerprint open result: %b", Boolean.valueOf(z));
        g gVar = g.pWK;
        if (z) {
            j = 0;
        } else {
            j = 1;
        }
        gVar.a(713, j, 1, false);
    }

    public static void bOY() {
        x.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report fingerprintlock verify by passwd success");
        g.pWK.a(713, 2, 1, false);
    }

    public static void bOZ() {
        x.i("MicroMsg.WalletLockReportManager", "alvinluo idkey report close wallet lock success");
        g.pWK.a(713, 3, 1, false);
    }

    public static void bPa() {
        mmh = System.currentTimeMillis();
        x.i("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report create session: %d", Long.valueOf(mmh));
    }

    public static void aa(int i, int i2, int i3) {
        if (mmh == -1) {
            x.e("MicroMsg.WalletLockReportManager", "alvinluo wallet lock report sessionId is -1, not create session, ignore");
        } else if (i != -1) {
            x.i("MicroMsg.WalletLockReportManager", "alvinluo reportVerifyWalletLock session: %d, protectScene: %d, walletLockType: %d, result: %d", Long.valueOf(mmh), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            g.pWK.h(14839, Long.valueOf(mmh), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }
}
