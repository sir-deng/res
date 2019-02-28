package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.protocal.c.agc;
import com.tencent.mm.protocal.c.agd;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

public final class q extends com.tencent.mm.ad.a<agd> {
    private static final long iNj = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.q$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iNk = new int[a.abv().length];

        static {
            try {
                iNk[a.iNm - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iNk[a.iNl - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] abv() {
            return (int[]) iNn.clone();
        }

        static {
            iNl = 1;
            iNm = 2;
            iNn = new int[]{iNl, iNm};
        }
    }

    protected final /* synthetic */ void a(int i, int i2, String str, bek bek, k kVar) {
        agd agd = (agd) bek;
        super.a(i, i2, str, agd, kVar);
        c Zw = e.Zw();
        com.tencent.mm.plugin.appbrand.p.a ZE = e.ZE();
        if (Zw == null || ZE == null) {
            x.e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", Zw, ZE);
            return;
        }
        long j = (i == 0 && i2 == 0 && agd != null) ? (long) agd.wuJ : iNj;
        Zw.aY("GetSearchShowOutWxaApp_interval", String.valueOf(j));
        if (i == 0 && i2 == 0 && agd != null) {
            try {
                ZE.k("GetSearchShowOutWxaApp_resp", agd.toByteArray());
            } catch (Exception e) {
                x.e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", e);
            }
        }
    }

    private q(int i) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        com.tencent.mm.bp.a agc = new agc();
        agc.aAk = (i - 1) + 1;
        aVar.hnT = agc;
        aVar.hnU = new agd();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getsearchshowoutwxaapp";
        this.gLB = aVar.Kf();
    }

    public static void jJ(int i) {
        if (g.Do().gRj) {
            switch (AnonymousClass1.iNk[i - 1]) {
                case 1:
                    if (bi.getLong(e.Zw().get("GetSearchShowOutWxaApp_lastCheck", "$$invalid"), 0) + bi.getLong(e.Zw().get("GetSearchShowOutWxaApp_interval", "$$invalid"), iNj) <= bi.Wx()) {
                        e.Zw().aY("GetSearchShowOutWxaApp_lastCheck", String.valueOf(bi.Wx()));
                        break;
                    }
                    return;
                case 2:
                    if (((Long) g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_SEARCH_SHOW_OUT_DAILY_SYNC_LAST_TIME_SECOND_LONG, Long.valueOf(0))).longValue() + TimeUnit.DAYS.toSeconds(1) <= bi.Wx()) {
                        g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_APP_BRAND_SEARCH_SHOW_OUT_DAILY_SYNC_LAST_TIME_SECOND_LONG, Long.valueOf(bi.Wx()));
                        break;
                    }
                    return;
            }
            new q(i).Kb();
        }
    }

    static agd abu() {
        return (agd) e.ZE().g("GetSearchShowOutWxaApp_resp", agd.class);
    }
}
