package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.mm.f.a.tr;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.i.a.d.d;
import com.tencent.mm.pluginsdk.i.a.d.g;
import com.tencent.mm.pluginsdk.i.a.d.h;
import com.tencent.mm.pluginsdk.i.a.d.i;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.l;
import com.tencent.mm.pluginsdk.i.a.d.m;
import com.tencent.mm.pluginsdk.i.a.d.o;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class WebViewCacheDownloadHelper {
    private static final byte[] tAE = new byte[0];
    private static volatile WebViewCacheDownloadHelper tAF = null;

    public static final class ResDownloaderPlugin implements g {
        private final d tAG = new d() {
            public final void a(String str, l lVar) {
                b.c(str, lVar);
            }

            public final void b(String str, l lVar) {
                AnonymousClass1.Pk(str);
                b.c(str, lVar);
            }

            public final void Pj(String str) {
                AnonymousClass1.Pk(str);
            }

            public final String aam() {
                return "WebViewCache";
            }

            private static void Pk(String str) {
                q SB = a.voG.SB(str);
                if (SB != null) {
                    a.SF(SB.field_filePath);
                }
            }
        };

        public final void bSf() {
            a.voG.a("WebViewCache", this.tAG);
        }

        public final void onAccountRelease() {
            c.clearCache();
            o cap = a.voG;
            String str = "WebViewCache";
            d dVar = this.tAG;
            if (cap.jbr) {
                i iVar = cap.voF;
                if (dVar != null) {
                    int hashCode = str.hashCode();
                    synchronized (iVar.voo) {
                        List list = (List) iVar.von.get(hashCode);
                        if (list == null) {
                            return;
                        }
                        list.remove(dVar);
                    }
                }
            }
        }

        public final String aam() {
            return "WebViewCache";
        }

        public final m.a c(k kVar) {
            if (kVar != null && (kVar instanceof e)) {
                return new c((e) kVar);
            }
            x.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = " + kVar);
            return null;
        }

        public final h bSg() {
            return new d();
        }
    }

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper bSd() {
        if (tAF == null) {
            synchronized (tAE) {
                if (tAF == null) {
                    tAF = new WebViewCacheDownloadHelper();
                }
            }
        }
        return tAF;
    }

    public static void bSe() {
        FileOp.G(a.tAD, false);
    }

    static void a(f fVar) {
        b trVar = new tr();
        trVar.fNb.url = fVar.url;
        trVar.fNb.filePath = fVar.filePath;
        trVar.fNb.version = fVar.version;
        trVar.fNb.appId = fVar.appId;
        trVar.fNb.fNc = fVar.fNc;
        trVar.fNb.fNd = fVar.fNd;
        trVar.fNb.fNe = fVar.fNe;
        trVar.fNb.aBD = fVar.aBD;
        trVar.fNb.exception = fVar.exception;
        trVar.fNb.fNf = fVar.fNf;
        com.tencent.mm.sdk.b.a.xmy.a(trVar, Looper.getMainLooper());
    }
}
