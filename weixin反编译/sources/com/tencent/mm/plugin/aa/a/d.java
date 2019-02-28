package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.h;
import com.tencent.mm.protocal.c.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.vending.g.b;

public final class d implements e {
    private static int iiG = 20;
    private static int iiH = 20;
    private static int iiI = 20;
    private static long iiJ = 4000000;
    private static long iiK = 200000;
    b iiC;
    public String iiL = "";
    public String iiM = "";

    private d(String str, String str2) {
        this.iiL = str;
        this.iiM = str2;
    }

    public static int WN() {
        g.Dr();
        return ((Integer) g.Dq().Db().get(a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(iiG))).intValue();
    }

    public static int WO() {
        g.Dr();
        return ((Integer) g.Dq().Db().get(a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(iiI))).intValue();
    }

    public static long WP() {
        g.Dr();
        return ((Long) g.Dq().Db().get(a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(iiK))).longValue();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.AAOperationData", "get AAOperation, onSceneEnd, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            m mVar = ((h) kVar).iju;
            x.i("MicroMsg.AAOperationData", "get AAOperation data, retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(mVar.lot), mVar.lou, Integer.valueOf(mVar.vJW), Integer.valueOf(mVar.vJX), Integer.valueOf(mVar.vJY), Long.valueOf(mVar.vJZ), Long.valueOf(mVar.vKa), mVar.loF, mVar.loG);
            if (mVar.lot == 0) {
                g.Dr();
                g.Dq().Db().a(a.USERINFO_AA_MAX_PAYER_NUM_INT, Integer.valueOf(mVar.vJW));
                g.Dr();
                g.Dq().Db().a(a.USERINFO_AA_MAX_RECEIVER_NUM_INT, Integer.valueOf(mVar.vJX));
                g.Dr();
                g.Dq().Db().a(a.USERINFO_AA_MAX_TOTAL_USER_NUM_INT, Integer.valueOf(mVar.vJY));
                g.Dr();
                g.Dq().Db().a(a.USERINFO_AA_MAX_TOTAL_AMOUNT_LONG, Long.valueOf(mVar.vJZ));
                g.Dr();
                g.Dq().Db().a(a.USERINFO_AA_MAX_PER_AMOUNT_LONG, Long.valueOf(mVar.vKa));
                com.tencent.mm.plugin.report.service.g.pWK.a(407, 33, 1, false);
                com.tencent.mm.vending.g.g.a(this.iiC, new d(mVar.loG, mVar.loF));
                return;
            }
            com.tencent.mm.vending.g.g.cAI().cm(Boolean.valueOf(false));
            com.tencent.mm.plugin.report.service.g.pWK.a(407, 35, 1, false);
            return;
        }
        com.tencent.mm.vending.g.g.cAI().cm(Boolean.valueOf(false));
        com.tencent.mm.plugin.report.service.g.pWK.a(407, 34, 1, false);
    }
}
