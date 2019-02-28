package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.resdownload;

import com.tencent.mm.a.g;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.f.a.bd;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a;
import com.tencent.mm.pluginsdk.i.a.b.i;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public enum d {
    ;
    
    public ConcurrentLinkedQueue<a> jzO;

    private d(String str) {
        this.jzO = new ConcurrentLinkedQueue();
    }

    public final void a(a aVar) {
        if (this.jzO != null && aVar != null) {
            this.jzO.remove(aVar);
        }
    }

    public final void bM(int i, int i2) {
        bd bdVar = new bd();
        bdVar.fqk.fqm = false;
        bdVar.fqk.fql = 1;
        bdVar.fqk.fqg = i;
        bdVar.fqk.fqh = i2;
        bdVar.fqk.fqn = true;
        Iterator it = this.jzO.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(bdVar);
        }
    }

    public static boolean bN(int i, int i2) {
        String str;
        c.vnr;
        q SB = a.voG.SB(i.eB(i, i2));
        if (SB == null) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "getRawCachedFilePath, %d.%d, get null info, return", Integer.valueOf(i), Integer.valueOf(i2));
        } else if (!(SB.field_deleted || bi.oN(SB.field_filePath) || !bi.oM(g.bV(SB.field_filePath)).equals(SB.field_md5))) {
            str = SB.field_filePath;
            if (bi.oN(str)) {
                return new File(str).exists();
            }
            x.e("MicroMsg.ResDownloadManager", "alvinluo isResDownloaded filePath is null");
            return false;
        }
        str = null;
        if (bi.oN(str)) {
            return new File(str).exists();
        }
        x.e("MicroMsg.ResDownloadManager", "alvinluo isResDownloaded filePath is null");
        return false;
    }

    public static boolean b(bc bcVar) {
        boolean z = false;
        if (new File(bcVar.fqf.filePath).exists()) {
            String str = bcVar.fqf.filePath;
            try {
                int i = f.jzB;
                f.kT(1);
                if (!bi.oN(str)) {
                    int fz = bi.fz(str, a.lb(bcVar.fqf.fqh));
                    x.i("MicroMsg.ResDownloadManager", "alvinluo unzipRes zipFilePath: %s, targetDir: %s", str, r3);
                    if (fz == 0) {
                        x.i("MicroMsg.ResDownloadManager", "alvinluo VoiceResUpdate unzip success");
                        z = true;
                    } else {
                        x.e("MicroMsg.ResDownloadManager", "alvinluo VoiceResUpdate unzip failed");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ResDownloadManager", e, "alvinluo unzipRes exception", new Object[0]);
            }
            b.deleteFile(str);
            int i2;
            if (z) {
                i2 = f.jzB;
                f.kT(2);
            } else {
                i2 = f.jzB;
                f.kT(3);
            }
        } else {
            x.i("MicroMsg.ResDownloadManager", "alvinluo unzipRes zipFile not exist");
        }
        return z;
    }
}
