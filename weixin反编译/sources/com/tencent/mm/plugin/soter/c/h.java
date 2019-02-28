package com.tencent.mm.plugin.soter.c;

import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static String TAG = "MicroMsg.SoterUtil";

    public static void bDA() {
        x.i(TAG, "alvinluo dynamic config support soter: %b", Boolean.valueOf(bi.getInt(((a) g.Dm().h(a.class)).Af().getValue("SoterEntry"), 0) == 1));
        if (bi.getInt(((a) g.Dm().h(a.class)).Af().getValue("SoterEntry"), 0) == 1) {
            x.d(TAG, "alvinluo set all soter support flag to true");
            q.gHL.fJK = true;
            q.gHJ.gHS = 1;
            q.gHJ.gHT = 1;
            x.d(TAG, "alvinluo deviceInfo soter support: %b, force status: %d, allow external: %d", Boolean.valueOf(q.gHL.fJK), Integer.valueOf(q.gHJ.gHS), Integer.valueOf(q.gHJ.gHT));
        }
    }

    public static String bDB() {
        try {
            String s = com.tencent.mm.a.g.s(com.tencent.mm.y.q.Gb().getBytes());
            if (s != null) {
                return s.substring(0, 8);
            }
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "alvinluo get md5 exception", new Object[0]);
        }
        return "";
    }

    public static String bDC() {
        return "WechatAuthKeyPay&" + com.tencent.mm.y.q.Gb();
    }

    public static boolean bDD() {
        if (q.gHL.fJK) {
            return com.tencent.d.b.a.cGP();
        }
        x.i(TAG, "hy: dynamic config is not support soter");
        return false;
    }
}
