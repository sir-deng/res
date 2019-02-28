package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.f.a.tx;
import com.tencent.mm.plugin.webview.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessTask;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.List;

public class i {
    private static volatile i tTV = null;

    static /* synthetic */ void a(i iVar, String str, boolean z) {
        if (bi.oN(str)) {
            k(z, str);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "update preload files. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        List QP = h.QP(str);
        if (!bi.cC(QP)) {
            x.i("MicroMsg.Wepkg.WepkgUpdater", "pkgid:%s, %s preload files need to download", str, Integer.valueOf(QP.size()));
        }
        iVar.a(str, QP, z);
    }

    public static i bVY() {
        if (tTV == null) {
            synchronized (i.class) {
                if (tTV == null) {
                    tTV = new i();
                }
            }
        }
        return tTV;
    }

    public final void aU(final String str, final boolean z) {
        if (bi.oN(str)) {
            k(z, str);
            return;
        }
        final a anonymousClass1 = new a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                if (this.object instanceof String) {
                    i.a(i.this, (String) this.object, z);
                } else {
                    i.k(z, str);
                }
            }
        };
        anonymousClass1.object = str;
        x.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        if (bi.oN(str)) {
            k(z, str);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", str, Boolean.valueOf(z));
        WepkgVersion QN = h.QN(str);
        if (QN == null) {
            k(z, str);
        } else if (QN.tUg) {
            anonymousClass1.a(null);
        } else {
            h.a(1, QN.tTK, "", QN.downloadUrl, (long) QN.tUe, QN.version, QN.frM, QN.tTx, new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
                        WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                        if (wepkgDownloadProcessTask.tTy != RetCode.OK || bi.oN(wepkgDownloadProcessTask.fNz) || bi.oN(wepkgDownloadProcessTask.iGz)) {
                            i.k(z, str);
                            return;
                        } else {
                            h.a(wepkgDownloadProcessTask.fNz, wepkgDownloadProcessTask.iGz, true, anonymousClass1);
                            return;
                        }
                    }
                    i.k(z, str);
                }
            });
        }
    }

    private void a(final String str, List<WepkgPreloadFile> list, boolean z) {
        try {
            if (bi.cC(list)) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
                if (bi.oN(str)) {
                    k(z, str);
                    return;
                }
                if (bi.cC(h.QP(str))) {
                    WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                    wepkgCrossProcessTask.pK = 3006;
                    wepkgCrossProcessTask.tTq.tTK = str;
                    wepkgCrossProcessTask.tTq.tUh = true;
                    if (ad.cgj()) {
                        wepkgCrossProcessTask.YA();
                    } else {
                        WepkgMainProcessService.b(wepkgCrossProcessTask);
                    }
                    WepkgVersion QN = h.QN(str);
                    if (!(QN == null || QN.hXs == 0)) {
                        a.b("downloadCompleteTime", "", QN.tTK, QN.version, -1, System.currentTimeMillis() - (QN.hXs * 1000), null);
                        wepkgCrossProcessTask = new WepkgCrossProcessTask();
                        wepkgCrossProcessTask.pK = 3007;
                        wepkgCrossProcessTask.tTq.tTK = str;
                        if (ad.cgj()) {
                            wepkgCrossProcessTask.YA();
                        } else {
                            WepkgMainProcessService.b(wepkgCrossProcessTask);
                        }
                    }
                    k(z, str);
                    x.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
                    return;
                }
                x.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", Integer.valueOf(h.QP(str).size()));
                k(z, str);
                return;
            }
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) list.remove(0);
            if (wepkgPreloadFile != null) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", wepkgPreloadFile.tTK, wepkgPreloadFile.version, wepkgPreloadFile.tTv);
                final List<WepkgPreloadFile> list2 = list;
                final boolean z2 = z;
                a anonymousClass3 = new a() {
                    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                        if ((this.object instanceof WepkgPreloadFile) && (baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
                            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
                            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.object;
                            if (wepkgDownloadProcessTask.tTy != RetCode.OK || bi.oN(wepkgDownloadProcessTask.iGz)) {
                                x.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", wepkgDownloadProcessTask.tTy);
                                i.this.a(str, list2, z2);
                                return;
                            }
                            String str = wepkgPreloadFile.tTK;
                            String str2 = wepkgPreloadFile.tTv;
                            String str3 = wepkgDownloadProcessTask.iGz;
                            WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                            wepkgCrossProcessTask.pK = 4002;
                            wepkgCrossProcessTask.tTs.tTK = str;
                            wepkgCrossProcessTask.tTs.tTv = str2;
                            wepkgCrossProcessTask.tTs.filePath = str3;
                            wepkgCrossProcessTask.tTs.tTL = true;
                            if (ad.cgj()) {
                                wepkgCrossProcessTask.YA();
                            } else {
                                WepkgMainProcessService.b(wepkgCrossProcessTask);
                            }
                            boolean z = wepkgCrossProcessTask.foB;
                            i.this.a(str, list2, z2);
                            return;
                        }
                        x.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
                        i.this.a(str, list2, z2);
                    }
                };
                anonymousClass3.object = wepkgPreloadFile;
                h.a(2, wepkgPreloadFile.tTK, wepkgPreloadFile.tTv, wepkgPreloadFile.downloadUrl, (long) wepkgPreloadFile.size, wepkgPreloadFile.version, wepkgPreloadFile.frM, wepkgPreloadFile.tTx, anonymousClass3);
                return;
            }
            x.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
            a(str, (List) list, z);
        } catch (Exception e) {
            x.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", e.getMessage());
        }
    }

    private static void k(boolean z, String str) {
        if (z) {
            b txVar = new tx();
            txVar.fNy.fql = 0;
            com.tencent.mm.sdk.b.a.xmy.m(txVar);
        }
        WepkgMainProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.pK = TXLiveConstants.PLAY_EVT_PLAY_END;
        wepkgCrossProcessTask.tTq.tTK = str;
        if (ad.cgj()) {
            wepkgCrossProcessTask.YA();
        } else {
            WepkgMainProcessService.b(wepkgCrossProcessTask);
        }
        g.QK(str);
    }
}
