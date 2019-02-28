package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.f.a.bd;
import com.tencent.mm.pluginsdk.i.a.d.f;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.pluginsdk.i.a.d.t;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

final class k extends f<a> {
    private final a vnS = new a(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new t());

    private static final class a extends d<a> {
        protected a(a aVar) {
            super(aVar);
        }

        public final void run() {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", ((a) aat()).vmK);
            a aVar = (a) aat();
            int i = aVar.fqg;
            int i2 = aVar.fqh;
            int i3 = aVar.fqi;
            try {
                l lVar;
                aVar = (a) aat();
                l lVar2 = new l(aVar.fqg, aVar.fqh, aVar.filePath, aVar.vmL, aVar.vmM, aVar.vmN, aVar.vmO, aVar.vmR, aVar.fqj, aVar.vmP, aVar.vmQ, aVar.vmT, aVar.vmS, aVar.url, aVar.vmU, aVar.vmV, aVar.fqi);
                if (lVar2.vnt) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", lVar2.vmK);
                    lVar2.vnV = lVar2.filePath + ".decompressed";
                    lVar2.state = 32;
                    if (lVar2.cag() != null) {
                        lVar2.state = 16;
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.vmK);
                    }
                    lVar = lVar2;
                } else if (lVar2.vnu) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", lVar2.vmK);
                    lVar2.vnV = lVar2.filePath + ".decrypted";
                    lVar2.state = 32;
                    if (lVar2.cag() != null) {
                        lVar2.state = 16;
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.vmK);
                    }
                    lVar = lVar2;
                } else {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", lVar2.vmK);
                    lVar2.vnV = lVar2.filePath;
                    lVar2.state = 32;
                    if (lVar2.cag() != null) {
                        lVar2.state = 16;
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", lVar2.vmK);
                    }
                    lVar = lVar2;
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.cah(), lVar.vmK);
                if (16 != lVar.state) {
                    if (lVar.vnu) {
                        lVar.vnV = lVar.filePath;
                        lVar.vnW = lVar.filePath + ".decrypted";
                        lVar.state = 1;
                    } else if (lVar.vnt) {
                        lVar.vnV = lVar.filePath;
                        lVar.vnW = lVar.filePath + ".decompressed";
                        lVar.state = 2;
                    } else {
                        lVar.vnV = lVar.filePath;
                        lVar.state = 4;
                    }
                }
                String cag = lVar.cae().caf().cag();
                if (bi.oN(cag)) {
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decompressed");
                    if (Thread.interrupted()) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) aat()).vmK);
                        com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath);
                        com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decrypted");
                        com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decompressed");
                    }
                    aVar = (a) aat();
                    a.voG.handler.post(new Runnable() {
                        public final void run() {
                            b bdVar = new bd();
                            bdVar.fqk.fqg = aVar.fqg;
                            bdVar.fqk.fqh = aVar.fqh;
                            bdVar.fqk.fqn = aVar.vmR;
                            bdVar.fqk.fql = 1;
                            bdVar.fqk.fqm = false;
                            com.tencent.mm.sdk.b.a.xmy.m(bdVar);
                        }
                    });
                    return;
                }
                c.vnr.b(i, i2, cag, i3);
                if (Thread.interrupted()) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) aat()).vmK);
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath);
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decompressed");
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                if (Thread.interrupted()) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", ((a) aat()).vmK);
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath);
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decrypted");
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(((a) aat()).filePath + ".decompressed");
                }
            }
        }
    }

    protected final /* synthetic */ d a(f.b bVar) {
        return new a((a) bVar);
    }

    k() {
    }

    static void f(q qVar) {
        new a(a.a(qVar)).run();
    }

    final void a(a aVar) {
        if (Sz(aVar.vmK)) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", aVar.vmK);
            return;
        }
        int i;
        if (!(aVar.vmL && aVar.fqi == aVar.vmO && aVar.vmO >= 0) && (aVar.vmL || !aVar.vmM)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", aVar.vmK);
            super.b(aVar);
        }
    }

    protected final a cad() {
        return this.vnS;
    }
}
