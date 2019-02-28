package com.tencent.mm.bb;

import android.net.Uri;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    private static a hMF = new a();

    public static class a {
        long hGG;
        int hMG;
        long hMH;
        long hMI;
        long hMJ;
        boolean hMK = true;
        int scene;
    }

    public static void t(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pWK.k(i, str);
    }

    public static void a(int i, String str, boolean z, boolean z2, int i2) {
        int i3;
        if (z) {
            i3 = 3;
        } else if (z2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(12042, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i2), bi.aD(str, "").replace(",", " "));
    }

    public static void ir(int i) {
        hMF.scene = i;
        hMF.hMG = 1;
        hMF.hMH = System.currentTimeMillis();
        hMF.hMI = 0;
        hMF.hMJ = System.currentTimeMillis();
        hMF.hGG = 0;
        hMF.hMK = false;
        x.v("MicroMsg.FTS.FTSWebReportLogic", "initReport %d %d", Integer.valueOf(i), Integer.valueOf(1));
    }

    public static void Rf() {
        hMF.hMH = System.currentTimeMillis();
        x.v("MicroMsg.FTS.FTSWebReportLogic", "startH5Report %s", Long.valueOf(hMF.hMH));
    }

    public static void Rg() {
        a aVar = hMF;
        aVar.hMI += System.currentTimeMillis() - hMF.hMH;
        x.v("MicroMsg.FTS.FTSWebReportLogic", "stopH5Report %s", Long.valueOf(hMF.hMI));
    }

    public static void Rh() {
        a aVar = hMF;
        aVar.hGG += System.currentTimeMillis() - hMF.hMJ;
        x.v("MicroMsg.FTS.FTSWebReportLogic", "stopTotalReport %s", Long.valueOf(hMF.hGG));
    }

    public static void Ri() {
        a aVar = hMF;
        if (!aVar.hMK) {
            com.tencent.mm.plugin.report.service.g.pWK.h(12044, Integer.valueOf(aVar.scene), Integer.valueOf(aVar.hMG), Long.valueOf(aVar.hMI / 1000), Long.valueOf(aVar.hGG / 1000));
            aVar.hMK = true;
        }
        x.v("MicroMsg.FTS.FTSWebReportLogic", "reportTime");
    }

    public static void is(int i) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchVisit %d", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.g.pWK.h(12041, Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(0)));
    }

    public static void a(int i, int i2, String str, int i3, int i4, String str2, int i5) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchGuideDisplay %d %d %s %d %d %s %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
        com.tencent.mm.plugin.report.service.g.pWK.h(12098, Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(0)), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), str2, Integer.valueOf(i5));
    }

    public static void d(String str, int i, int i2, int i3) {
        com.tencent.mm.plugin.report.service.g.pWK.h(12639, bi.aD(str, "").replace(",", " "), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(i3));
    }

    public static void b(int i, int i2, String str) {
        a(i, i2, str, false);
    }

    public static void a(int i, int i2, String str, boolean z) {
        int i3 = 1;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(0);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        if (!z) {
            i3 = 0;
        }
        objArr[4] = Integer.valueOf(i3);
        gVar.h(12845, objArr);
    }

    public static void u(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pWK.h(12070, Integer.valueOf(i), Integer.valueOf(com.tencent.mm.plugin.aj.a.g.Af(0)), str, Integer.valueOf(4), Integer.valueOf(0), "", Integer.valueOf(1), Integer.valueOf(0));
    }

    public static void g(int i, String str, String str2) {
        com.tencent.mm.plugin.report.service.g.pWK.h(13809, Integer.valueOf(i), str, str2, Integer.valueOf(0));
    }

    public static void b(String str, String str2, int i, String str3) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchLocalPageClick %s %s %d %s", str, str2, Integer.valueOf(i), str3);
        com.tencent.mm.plugin.report.service.g.pWK.h(14657, Uri.encode(str), str2, Integer.valueOf(i), str3);
    }

    public static void a(String str, String str2, long j, String str3) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "kvReportWebSearchLocalPageExposure:");
        com.tencent.mm.plugin.report.service.g.pWK.h(14663, Uri.encode(str), str2, Long.valueOf(j), str3);
    }

    public static void a(int i, String str, String str2, int i2, int i3) {
        com.tencent.mm.plugin.report.service.g.pWK.h(13810, Integer.valueOf(i), str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(0));
    }

    public static final void lX(String str) {
        x.v("MicroMsg.FTS.FTSWebReportLogic", "reportWebSuggestClick %s", str);
        com.tencent.mm.plugin.report.service.g.pWK.k(12721, str);
    }

    public static final void it(int i) {
        com.tencent.mm.plugin.report.service.g.pWK.a(649, (long) i, 1, true);
    }

    public static final void bk(int i, int i2) {
        if (i == 21) {
            com.tencent.mm.plugin.report.service.g.pWK.a(649, (long) i2, 1, true);
        }
    }

    public static void bl(int i, int i2) {
        c(i, i2, "");
    }

    public static void c(int i, int i2, String str) {
        a(i, i2, 0, 0, str);
    }

    public static void z(int i, int i2, int i3) {
        a(i, 3, i2, i3, "");
    }

    public static void a(int i, int i2, int i3, int i4, String str) {
        int Af;
        if (i == 21) {
            Af = com.tencent.mm.plugin.aj.a.g.Af(1);
        } else {
            Af = com.tencent.mm.plugin.aj.a.g.Af(0);
        }
        com.tencent.mm.plugin.report.service.g.pWK.h(14457, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Af), Integer.valueOf(i3), Integer.valueOf(i4), str);
    }

    public static void n(String str, String str2, String str3) {
        com.tencent.mm.plugin.report.service.g.pWK.h(14752, Integer.valueOf(1), str, str2, str3);
    }
}
