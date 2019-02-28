package com.tencent.mm.plugin.appbrand.appcache;

import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appcache.r.b;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.launching.f;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.report.a.l;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class k implements b {
    private static final ConcurrentHashMap<String, Boolean> iGA = new ConcurrentHashMap();

    private static final class a implements com.tencent.mm.plugin.appbrand.appcache.r.a {
        private final com.tencent.mm.plugin.appbrand.appcache.a.a iGC;
        private final int iGD;
        private final boolean iGE;
        private a iGF;
        private ArrayList<IDKey> iGG;
        private long iGH;
        private long iGI;
        private long iGJ;
        private l iGK;

        private enum a {
            DOWNLOAD(1),
            UPDATE(4),
            LIB_UPDATE(7),
            INCREMENTAL_UPDATE(10),
            LIB_INCREMENTAL_UPDATE(13);
            
            final int value;

            private a(int i) {
                this.value = i;
            }
        }

        /* synthetic */ a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar, byte b) {
            this(aVar);
        }

        private a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
            this.iGH = 0;
            this.iGI = 0;
            this.iGJ = 0;
            this.iGC = aVar;
            this.iGD = k.pS(aVar.appId) ? 776 : 368;
            String[] split = aVar.appId.split(Pattern.quote("$"));
            this.iGE = (split == null ? -1 : split.length) == 2;
        }

        private void jA(int i) {
            bw(this.iGD, i);
        }

        private void bw(int i, int i2) {
            if (this.iGG == null) {
                this.iGG = new ArrayList();
            }
            this.iGG.add(new IDKey(i, i2, 1));
        }

        private void ZU() {
            try {
                d.pVE.a(this.iGG, false);
                this.iGG.clear();
            } catch (Exception e) {
            }
        }

        public final void ZK() {
            int i = 0;
            if (this.iGC instanceof ae) {
                this.iGF = "@LibraryAppId".equals(this.iGC.appId) ? a.LIB_INCREMENTAL_UPDATE : a.INCREMENTAL_UPDATE;
                this.iGK = new l(this.iGC.appId, ((ae) this.iGC).iHA, ((ae) this.iGC).iHB);
                this.iGK.jOy = bi.Wy();
            } else if ("@LibraryAppId".equals(this.iGC.appId)) {
                this.iGF = a.LIB_UPDATE;
            } else if (com.tencent.mm.plugin.appbrand.appcache.d.a.jy(this.iGC.fwH)) {
                WxaPkgWrappingInfo aF = f.aF(this.iGC.appId, 1);
                this.iGF = aF != null ? a.UPDATE : a.DOWNLOAD;
                this.iGK = new l(this.iGC.appId, aF == null ? 0 : aF.iJb, this.iGC.version);
                this.iGK.jOy = bi.Wy();
            } else {
                this.iGF = a.DOWNLOAD;
            }
            switch (AnonymousClass1.iGB[this.iGF.ordinal()]) {
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 10;
                    break;
                case 3:
                    i = 20;
                    break;
                case 4:
                    i = 35;
                    break;
                case 5:
                    i = 46;
                    break;
            }
            jA(i);
            this.iGH = SystemClock.elapsedRealtime();
        }

        public final void ZL() {
            jA(32);
        }

        public final void ZM() {
            int i;
            switch (AnonymousClass1.iGB[this.iGF.ordinal()]) {
                case 3:
                case 5:
                    i = 30;
                    break;
                default:
                    i = 31;
                    break;
            }
            jA(i);
        }

        public final void a(com.tencent.mm.pluginsdk.i.a.d.l lVar) {
            int i;
            String str;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.iGH;
            int i2 = (lVar == null || lVar.status != 2) ? 0 : 1;
            switch (AnonymousClass1.iGB[this.iGF.ordinal()]) {
                case 1:
                    jA(i2 != 0 ? 2 : 3);
                    break;
                case 2:
                    jA(i2 != 0 ? 11 : 12);
                    break;
                case 3:
                    jA(i2 != 0 ? 21 : 22);
                    break;
                case 4:
                    jA(i2 != 0 ? 36 : 37);
                    break;
                case 5:
                    jA(i2 != 0 ? 47 : 48);
                    break;
            }
            if (!(i2 != 0 || "@LibraryAppId".equals(this.iGC.appId) || 999 == this.iGC.fwH)) {
                int i3;
                if (lVar == null || !(lVar.httpStatusCode == TencentLocation.ERROR_UNKNOWN || lVar.httpStatusCode == ap.CTRL_INDEX)) {
                    i3 = 19;
                } else {
                    i3 = 23;
                }
                com.tencent.mm.plugin.appbrand.report.a.C(this.iGC.appId, i3, this.iGC.fwH + 1);
            }
            if (lVar != null) {
                try {
                    if (lVar.status == 2) {
                        i = 1;
                        str = (a.LIB_UPDATE != this.iGF || a.LIB_INCREMENTAL_UPDATE == this.iGF) ? "" : this.iGC.appId;
                        com.tencent.mm.plugin.appbrand.report.a.a(str, this.iGF.value, i, elapsedRealtime, this.iGE);
                        AppBrandPerformanceManager.u(this.iGC.appId, elapsedRealtime);
                        ZU();
                        if (this.iGK == null) {
                            return;
                        }
                        if (i2 != 0) {
                            this.iGK.akJ();
                            if (this.iGC instanceof ae) {
                                this.iGK.lM(0);
                            } else if (lVar != null) {
                                this.iGK.lM(3);
                            } else if (lVar.status != JsApiBatchGetContact.CTRL_INDEX) {
                                this.iGK.lM(1);
                            } else if (lVar.status == TencentLocation.ERROR_UNKNOWN) {
                                this.iGK.lM(2);
                            } else {
                                this.iGK.lM(3);
                            }
                            this.iGK.xd();
                        } else if (this.iGC instanceof ae) {
                            this.iGK.jOx = e.bN(this.iGC.getFilePath());
                        } else {
                            this.iGK.jOw = e.bN(this.iGC.getFilePath());
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.PkgDownloadReporterImpl", e, "report onEnd, appId %s", this.iGC.appId);
                }
            }
            if (lVar != null) {
                if (lVar.status == 4) {
                    i = 3;
                    if (a.LIB_UPDATE != this.iGF) {
                    }
                    com.tencent.mm.plugin.appbrand.report.a.a(str, this.iGF.value, i, elapsedRealtime, this.iGE);
                    AppBrandPerformanceManager.u(this.iGC.appId, elapsedRealtime);
                    ZU();
                    if (this.iGK == null) {
                        if (i2 != 0) {
                            this.iGK.akJ();
                            if (this.iGC instanceof ae) {
                                this.iGK.lM(0);
                            } else if (lVar != null) {
                                this.iGK.lM(3);
                            } else if (lVar.status != JsApiBatchGetContact.CTRL_INDEX) {
                                this.iGK.lM(1);
                            } else if (lVar.status == TencentLocation.ERROR_UNKNOWN) {
                                this.iGK.lM(3);
                            } else {
                                this.iGK.lM(2);
                            }
                            this.iGK.xd();
                        } else if (this.iGC instanceof ae) {
                            this.iGK.jOw = e.bN(this.iGC.getFilePath());
                        } else {
                            this.iGK.jOx = e.bN(this.iGC.getFilePath());
                        }
                    }
                    return;
                }
            }
            i = 2;
            if (a.LIB_UPDATE != this.iGF) {
            }
            com.tencent.mm.plugin.appbrand.report.a.a(str, this.iGF.value, i, elapsedRealtime, this.iGE);
            AppBrandPerformanceManager.u(this.iGC.appId, elapsedRealtime);
            ZU();
            if (this.iGK == null) {
                return;
            }
            if (i2 != 0) {
                this.iGK.akJ();
                if (this.iGC instanceof ae) {
                    this.iGK.lM(0);
                } else if (lVar != null) {
                    this.iGK.lM(3);
                } else if (lVar.status != JsApiBatchGetContact.CTRL_INDEX) {
                    this.iGK.lM(1);
                } else if (lVar.status == TencentLocation.ERROR_UNKNOWN) {
                    this.iGK.lM(2);
                } else {
                    this.iGK.lM(3);
                }
                this.iGK.xd();
            } else if (this.iGC instanceof ae) {
                this.iGK.jOx = e.bN(this.iGC.getFilePath());
            } else {
                this.iGK.jOw = e.bN(this.iGC.getFilePath());
            }
        }

        public final void ZN() {
            this.iGJ = SystemClock.elapsedRealtime();
            bw(697, 1);
        }

        public final void jz(int i) {
            SystemClock.elapsedRealtime();
            if (i == 0) {
                bw(697, 2);
            } else if (i < 0) {
                bw(697, -i);
            } else if (i == 1) {
                bw(697, 10);
            }
            ZU();
            if (this.iGK == null) {
                return;
            }
            if (i != 0) {
                if (i == -4) {
                    this.iGK.lM(4);
                } else {
                    this.iGK.lM(5);
                }
                this.iGK.akJ();
                this.iGK.xd();
                return;
            }
            this.iGK.jOw = e.bN(((ae) this.iGC).aad());
        }

        public final void ZO() {
            if (a.LIB_UPDATE != this.iGF && a.LIB_INCREMENTAL_UPDATE != this.iGF) {
                com.tencent.mm.plugin.appbrand.report.a.C(this.iGC.appId, 20, this.iGC.fwH + 1);
            }
        }

        public final void ZP() {
            this.iGI = SystemClock.elapsedRealtime();
            switch (AnonymousClass1.iGB[this.iGF.ordinal()]) {
                case 1:
                    jA(5);
                    return;
                case 2:
                    jA(14);
                    return;
                case 3:
                    jA(24);
                    return;
                case 4:
                    jA(41);
                    return;
                case 5:
                    jA(49);
                    return;
                default:
                    return;
            }
        }

        public final void cq(boolean z) {
            int i;
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.iGI;
            switch (AnonymousClass1.iGB[this.iGF.ordinal()]) {
                case 1:
                    if (!z) {
                        i = 7;
                        break;
                    } else {
                        i = 6;
                        break;
                    }
                case 2:
                    if (!z) {
                        i = 16;
                        break;
                    } else {
                        i = 15;
                        break;
                    }
                case 3:
                    if (!z) {
                        i = 26;
                        break;
                    } else {
                        i = 25;
                        break;
                    }
                case 4:
                    if (!z) {
                        i = 43;
                        break;
                    } else {
                        i = 42;
                        break;
                    }
                case 5:
                    if (!z) {
                        i = 51;
                        break;
                    } else {
                        i = 50;
                        break;
                    }
                default:
                    i = 0;
                    break;
            }
            jA(i);
            ZU();
            String str = (a.LIB_UPDATE == this.iGF || a.LIB_INCREMENTAL_UPDATE == this.iGF) ? "" : this.iGC.appId;
            com.tencent.mm.plugin.appbrand.report.a.a(str, this.iGF.value + 1, z ? 1 : 2, elapsedRealtime, this.iGE);
            if (!z) {
                com.tencent.mm.plugin.appbrand.report.a.C(this.iGC.appId, 22, this.iGC.fwH + 1);
            }
            if (this.iGK != null) {
                this.iGK.akJ();
                if (this.iGF != a.INCREMENTAL_UPDATE && this.iGF != a.LIB_INCREMENTAL_UPDATE) {
                    this.iGK.jOu = z;
                } else if (z) {
                    this.iGK.jOu = true;
                    this.iGK.jOv = true;
                } else {
                    this.iGK.lM(6);
                }
                this.iGK.xd();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.k$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] iGB = new int[a.values().length];

        static {
            try {
                iGB[a.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iGB[a.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iGB[a.LIB_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iGB[a.INCREMENTAL_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iGB[a.LIB_INCREMENTAL_UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static /* synthetic */ boolean pS(String str) {
        return !bi.oN(str) && Boolean.TRUE.equals(iGA.get(str));
    }

    public final com.tencent.mm.plugin.appbrand.appcache.r.a a(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        if (ai.class == aVar.getClass() || ad.class == aVar.getClass() || ae.class == aVar.getClass()) {
            return new a(aVar, (byte) 0);
        }
        return null;
    }

    public static void pR(String str) {
        if (!bi.oN(str)) {
            iGA.put(str, Boolean.valueOf(true));
        }
    }
}
