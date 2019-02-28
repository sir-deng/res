package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.f;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bbb;
import com.tencent.mm.protocal.c.bbc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static i pVR = i.X(ad.getContext());
    private static int pVS = 2;

    static /* synthetic */ int vE() {
        int i = pVS;
        pVS = i - 1;
        return i;
    }

    public static String boK() {
        try {
            i.a(new f() {
                public final void bH(String str) {
                    x.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", str, Integer.valueOf(d.pVS));
                    if (d.vE() <= 0) {
                        x.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", Integer.valueOf(d.pVS));
                        return;
                    }
                    a aVar = new a();
                    aVar.hnT = new bbb();
                    aVar.hnU = new bbc();
                    aVar.uri = "/cgi-bin/micromsg-bin/querymid";
                    aVar.hnS = 684;
                    b Kf = aVar.Kf();
                    ((bbb) Kf.hnQ.hnY).jsl = str;
                    ((bbb) Kf.hnQ.hnY).nne = 1;
                    u.a(Kf, new u.a() {
                        public final int a(int i, int i2, String str, b bVar, k kVar) {
                            x.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            return 0;
                        }
                    }, true);
                }
            });
            x.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", pVR.sL(), pVR.sM());
            return pVR.sL();
        } catch (Throwable e) {
            x.e("MicroMsg.MidHelper", "QueryMid Error e:%s", bi.i(e));
            return "";
        }
    }

    public static void Jb(String str) {
        try {
            i iVar = pVR;
            if (i.mContext != null) {
                i.bpv = System.currentTimeMillis();
                n.bpG = -1;
                try {
                    Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.bpv);
                    edit.commit();
                } catch (Exception e) {
                }
                if (i.mHandler != null) {
                    i.mHandler.post(new com.tencent.b.a.a.i.AnonymousClass1(str));
                }
            }
            x.i("MicroMsg.MidHelper", "QueryMid local:%s", pVR.sM());
        } catch (Throwable e2) {
            x.e("MicroMsg.MidHelper", "procReturnData Error e:%s", bi.i(e2));
        }
    }

    public static int n(int i, int i2, String str) {
        if (g.Do().CF()) {
            long Wx = bi.Wx();
            if (i == 3 && bi.a((Long) g.Dq().Db().get(331778, null), 0) >= Wx) {
                return 0;
            }
            int i3;
            if (ao.is2G(ad.getContext())) {
                i3 = 1;
            } else if (ao.isWifi(ad.getContext())) {
                i3 = 3;
            } else if (ao.is3G(ad.getContext())) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            String boK = boK();
            x.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i), boK);
            com.tencent.mm.plugin.report.d.pVE.h(11402, boK, Integer.valueOf(i), Integer.valueOf(i3), q.yM(), Integer.valueOf(i2), str, ao.getISPName(ad.getContext()), Integer.valueOf(0), q.getDeviceID(ad.getContext()));
            g.Dq().Db().set(331778, Long.valueOf(259200 + Wx));
            return 0;
        }
        x.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
        return -1;
    }
}
