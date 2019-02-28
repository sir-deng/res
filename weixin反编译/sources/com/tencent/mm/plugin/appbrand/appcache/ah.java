package com.tencent.mm.plugin.appbrand.appcache;

import android.net.Uri;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.f.a.ty;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.jsapi.ap;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.pluginsdk.i.a.d.e;
import com.tencent.mm.pluginsdk.i.a.d.j;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m;
import com.tencent.mm.pluginsdk.i.a.d.t;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLException;

public final class ah {
    final b iHX = new b();

    private static final class c extends com.tencent.mm.pluginsdk.i.a.d.m.a<com.tencent.mm.plugin.appbrand.appcache.a.a> {
        private static final ThreadLocal<a> iIi = new ThreadLocal<a>() {
            protected final /* synthetic */ Object initialValue() {
                return new a();
            }
        };
        String iIj = null;
        final com.tencent.mm.plugin.appbrand.appcache.r.a iIk;

        protected final /* bridge */ /* synthetic */ com.tencent.mm.pluginsdk.i.a.d.f.b aat() {
            return (com.tencent.mm.plugin.appbrand.appcache.a.a) super.aat();
        }

        c(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
            super(aVar);
            com.tencent.mm.plugin.appbrand.appcache.r.a a = r.a(aVar);
            if (a == null) {
                a = g.iGn;
            }
            this.iIk = a;
        }

        protected final com.tencent.mm.plugin.appbrand.appcache.a.a aal() {
            return (com.tencent.mm.plugin.appbrand.appcache.a.a) super.aat();
        }

        public final String getURL() {
            return this.iIj;
        }

        protected final l a(j jVar) {
            l a;
            com.tencent.mm.plugin.appbrand.appcache.a.a aVar = (com.tencent.mm.plugin.appbrand.appcache.a.a) super.aat();
            com.tencent.mm.loader.stub.b.deleteFile(aVar.getFilePath());
            this.iIj = aVar.url;
            com.tencent.mm.plugin.appbrand.appcache.r.a aVar2 = this.iIk;
            this.iIj.startsWith("https");
            aVar2.ZK();
            l a2 = ((a) iIi.get()).a(this);
            Object obj = ((a2 == null || a2.status == 3) && this.iIj.startsWith("http://")) ? 1 : null;
            if ((a2 == null || a2.status == 3) && this.iIj.startsWith("https")) {
                Object obj2;
                this.iIk.ZM();
                if (aVar instanceof ad) {
                    obj2 = null;
                } else {
                    int obj22 = 1;
                }
                if (obj22 != null) {
                    this.iIj = this.iIj.replaceFirst("https", "http");
                    a = super.a(jVar);
                }
                a = a2;
            } else {
                if (a2 == null || obj != null) {
                    a = super.a(jVar);
                }
                a = a2;
            }
            this.iIk.a(a);
            if (a == null) {
                return new l(this, null, -1, 3);
            }
            return a;
        }

        public final boolean bE(long j) {
            StatFs statFs = new StatFs(new File(getFilePath()).getParentFile().getAbsolutePath());
            long availableBlocks = (long) (statFs.getAvailableBlocks() * statFs.getBlockSize());
            return availableBlocks < 0 || availableBlocks > j;
        }

        public final String aam() {
            return "AppBrandWxaPkgDownloader";
        }

        public final boolean aan() {
            return true;
        }

        public final boolean aao() {
            return false;
        }

        public final boolean aap() {
            return true;
        }

        protected final boolean aaq() {
            return false;
        }

        public final boolean aar() {
            return true;
        }

        public final boolean aas() {
            switch (w.zc()) {
                case 1:
                    return super.aas();
                default:
                    return false;
            }
        }
    }

    private final class d implements com.tencent.mm.pluginsdk.i.a.d.c {
        final ag iIl = new ag(new com.tencent.mm.sdk.platformtools.ah("WxaPkgDownloadPerformerEventDispatchThread").oFY.getLooper());

        d() {
        }

        public final void a(final e eVar, final l lVar) {
            this.iIl.post(new Runnable() {
                public final void run() {
                    switch (lVar.status) {
                        case 2:
                            d.c(eVar, lVar);
                            return;
                        case 3:
                            d.b(eVar, lVar);
                            return;
                        case 4:
                            d.d(eVar, lVar);
                            return;
                        default:
                            return;
                    }
                }
            });
        }

        public final void q(String str, int i, int i2) {
        }

        public final void s(String str, long j) {
        }

        public static void b(e eVar, l lVar) {
            a((c) eVar, lVar);
        }

        public static void c(e eVar, l lVar) {
            com.tencent.mm.plugin.appbrand.appcache.a.a aal = ((c) eVar).aal();
            if (aal instanceof ae) {
                ae aeVar = (ae) aal;
                com.tencent.mm.plugin.appbrand.appcache.r.a aVar = ((c) eVar).iIk;
                ap Zf = ((com.tencent.mm.plugin.appbrand.a.c) g.h(com.tencent.mm.plugin.appbrand.a.c.class)).Zf();
                if (Zf == null) {
                    aq.a(aeVar.vmK, aeVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    return;
                }
                String str = aeVar.appId;
                int i = aeVar.iHA;
                int i2 = aeVar.iHB;
                String aad = aeVar.aad();
                al a = Zf.a(str, i, 0, "pkgPath");
                al a2 = Zf.a(str, i2, 0, "versionMd5");
                if (a == null || a2 == null) {
                    aq.a(aeVar.vmK, aeVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    return;
                }
                aVar.ZN();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int x = h.x(a.field_pkgPath, aad, aeVar.getFilePath());
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                x.i("MicroMsg.AppBrand.IncrementalPkgLogic[incremental]", "applyPkgPatch, appId[%s], oldPath[%s], newPath[%s], patchPath[%s], cost %d, ret %d", aeVar.appId, a.field_pkgPath, aad, aeVar.getFilePath(), Long.valueOf(elapsedRealtime), Integer.valueOf(x));
                aVar.jz(x);
                if (x == 0) {
                    aq.a(aeVar.vmK, aeVar.appId, aad, i2, 0, aVar);
                    return;
                }
                com.tencent.mm.loader.stub.b.deleteFile(aad);
                al a3 = Zf.a(aeVar.appId, aeVar.iHB, 0, "downloadURL");
                if (a3 == null) {
                    aq.a(aeVar.vmK, aeVar.appId, com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.ENV_ERR, null);
                    return;
                }
                aq.qg(aeVar.vmK);
                aq.b(aeVar.appId, 0, aeVar.iHB, a3.field_downloadURL, aeVar.iHC);
            } else if (aal instanceof f) {
                e eVar2 = e.iGj;
                f fVar = (f) aal;
                com.tencent.mm.plugin.appbrand.appcache.r.a aVar2 = ((c) eVar).iIk;
                eVar2.a(fVar, lVar);
            } else {
                String str2 = ((c) eVar).aal().appId;
                try {
                    aq.a(lVar.vmK, str2, lVar.filePath, ((c) eVar).aal().version, ((c) eVar).aal().fwH, ((c) eVar).iIk);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrandWxaPkgDownloadPerformer", e, "dispatchComplete", new Object[0]);
                    aq.aO(lVar.vmK, str2);
                }
            }
        }

        public static void d(e eVar, l lVar) {
            a((c) eVar, lVar);
        }

        private static void a(c cVar, l lVar) {
            com.tencent.mm.loader.stub.b.deleteFile(lVar.filePath);
            if (cVar.aal() instanceof f) {
                e eVar = e.iGj;
                f fVar = (f) cVar.aal();
                com.tencent.mm.plugin.appbrand.appcache.r.a aVar = cVar.iIk;
                eVar.a(fVar, lVar);
                return;
            }
            com.tencent.mm.plugin.appbrand.appcache.a.b.a.a aVar2;
            String str = cVar.aal().appId;
            if (!(lVar.vox instanceof com.tencent.mm.pluginsdk.i.a.c.a)) {
                switch (lVar.httpStatusCode) {
                    case ap.CTRL_INDEX /*403*/:
                    case TencentLocation.ERROR_UNKNOWN /*404*/:
                        aVar2 = com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.SEVER_FILE_NOT_FOUND;
                        break;
                    default:
                        aVar2 = com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.FAILED;
                        break;
                }
            }
            aVar2 = com.tencent.mm.plugin.appbrand.appcache.a.b.a.a.DISK_FULL;
            aq.a(lVar.vmK, str, aVar2);
        }
    }

    private final class b extends m {
        b() {
            super(new t("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new d());
        }

        public final void shutdown() {
            super.shutdown();
            ((d) this.voz).iIl.getLooper().quit();
        }

        protected final d a(k kVar) {
            d cVar = new c((com.tencent.mm.plugin.appbrand.appcache.a.a) kVar);
            cVar.voC = this.voz;
            return cVar;
        }

        protected final int b(k kVar) {
            int b = super.b(kVar);
            if (b != 1) {
                return b;
            }
            super.b(kVar);
            return 2;
        }
    }

    private static final class a {

        static abstract class a implements com.tencent.mm.modelcdntran.i.a {
            private final c iIf;
            private final ty iIg = new ty();

            abstract void b(l lVar);

            a(c cVar) {
                this.iIf = cVar;
            }

            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                if (i != 0) {
                    b(new l(this.iIf, new SSLException(String.format(Locale.US, "CdnHttpsAddTaskFailed$%s$%d", new Object[]{this.iIf.bZW(), Integer.valueOf(i)})), 3));
                    x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, startRet %d", this.iIf.bZW(), Integer.valueOf(i));
                    return 0;
                } else if (keep_progressinfo != null) {
                    try {
                        this.iIg.fNC.fND = str;
                        this.iIg.fNC.fNE = (int) ((((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength)) * 100.0f);
                        com.tencent.mm.sdk.b.a.xmy.a(this.iIg, Looper.getMainLooper());
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", e, "notify progress", new Object[0]);
                    }
                    return 0;
                } else {
                    if (keep_sceneresult != null) {
                        x.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "urlKey %s, retCode %d, responseHeader %s", this.iIf.bZW(), Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_httpResponseHeader);
                        if (keep_sceneresult.field_retCode != 0) {
                            l lVar;
                            if (keep_sceneresult.field_fileLength <= 0 || this.iIf.bE((long) keep_sceneresult.field_fileLength)) {
                                lVar = new l(this.iIf, new SSLException(String.format(Locale.US, "CdnHttpsDownloadFailed$%s$%d", new Object[]{this.iIf.bZW(), Integer.valueOf(keep_sceneresult.field_retCode)})), keep_sceneresult.field_httpStatusCode, 3);
                            } else {
                                lVar = new l(this.iIf, new com.tencent.mm.pluginsdk.i.a.c.a(), keep_sceneresult.field_httpStatusCode, 3);
                            }
                            b(lVar);
                        } else {
                            b(new l(this.iIf, (long) keep_sceneresult.field_fileLength, null));
                            int bN = com.tencent.mm.a.e.bN(this.iIf.aal().getFilePath());
                            if (com.tencent.mm.y.ak.a.hhw != null) {
                                com.tencent.mm.y.ak.a.hhw.aV(bN, 0);
                            }
                        }
                    }
                    return 0;
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return new byte[0];
            }
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final l a(c cVar) {
            String bZW = cVar.bZW();
            x.i("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "downloadUsingCDN, url %s", cVar.iIj);
            try {
                al alVar;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                final h hVar = new h();
                final k aal = cVar.aal();
                final String str = aal.vmK;
                final com.tencent.mm.plugin.appbrand.appcache.r.a aVar = cVar.iIk;
                if (cVar.aal().iJg) {
                    alVar = new al(com.tencent.mm.by.a.cma().getLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                        public final boolean uG() {
                            com.tencent.mm.modelcdntran.g.MP().kL(str);
                            aVar.ZL();
                            com.tencent.mm.loader.stub.b.deleteFile(aal.getFilePath());
                            hVar.jXv = null;
                            countDownLatch.countDown();
                            return false;
                        }
                    }, false);
                } else {
                    alVar = null;
                }
                final h hVar2 = hVar;
                final CountDownLatch countDownLatch2 = countDownLatch;
                com.tencent.mm.modelcdntran.i.a anonymousClass2 = new a(cVar) {
                    final void b(l lVar) {
                        if (alVar != null) {
                            alVar.TN();
                        }
                        hVar2.jXv = lVar;
                        countDownLatch2.countDown();
                    }
                };
                i iVar = new i();
                iVar.field_mediaId = str;
                iVar.field_fullpath = aal.getFilePath();
                iVar.hvf = aal.url;
                iVar.fMC = false;
                iVar.hve = anonymousClass2;
                iVar.hvg = (int) TimeUnit.MILLISECONDS.toSeconds((long) aal.getConnectTimeout());
                iVar.hvh = (int) TimeUnit.MILLISECONDS.toSeconds((long) aal.getReadTimeout());
                iVar.field_fileType = com.tencent.mm.modelcdntran.b.htG;
                if (aal instanceof f) {
                    iVar.hvj = false;
                }
                String host = Uri.parse(iVar.hvf).getHost();
                if (!bi.oN(host)) {
                    ArrayList arrayList = new ArrayList();
                    try {
                        g.Dp().gRu.hoF.getHostByName(host, arrayList);
                        iVar.hvi = new String[arrayList.size()];
                        arrayList.toArray(iVar.hvi);
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https getHostByName e = %s", e);
                    }
                }
                com.tencent.mm.modelcdntran.g.MP().b(iVar, -1);
                if (alVar != null) {
                    long readTimeout = (long) aal.getReadTimeout();
                    alVar.K(readTimeout, readTimeout);
                }
                try {
                    countDownLatch.await();
                    return (l) hVar.jXv;
                } catch (Exception e2) {
                    x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform, urlKey %s semaphore await e = %s", bZW, e2);
                    return null;
                }
            } catch (Exception e22) {
                x.e("MicroMsg.AppBrand.CdnHttpsDownloadPerformer", "cdn https perform urlKey %s exp %s", bZW, e22);
                return null;
            }
        }
    }

    ah() {
    }

    static String aak() {
        String str = g.Dq().cachePath;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "appbrand/pkg/";
        com.tencent.mm.sdk.platformtools.i.QZ(str);
        return str;
    }

    public final int b(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        if (this.iHX.Sz(aVar.vmK)) {
            x.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s already in queue", aVar.vmK);
            return 0;
        }
        x.i("MicroMsg.AppBrandWxaPkgDownloadPerformer", "addRequestIfNotRunning, urlKey %s, addResult %d", aVar.vmK, Integer.valueOf(this.iHX.b(aVar)));
        return this.iHX.b(aVar);
    }
}
