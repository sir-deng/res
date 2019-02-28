package com.tencent.mm.plugin.downloader;

import android.database.Cursor;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.b.b;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class PluginDownloader extends f implements c, b {
    public void execute(g gVar) {
        x.d("MicroMsg.PluginDownloader", "execute");
        com.tencent.mm.kernel.g.a(a.class, new a());
    }

    public void onAccountInitialized(e.c cVar) {
        new Thread(new Runnable() {
            public final void run() {
                Object obj = null;
                com.tencent.mm.plugin.downloader.e.b Fl = com.tencent.mm.plugin.downloader.model.e.Fl();
                if (Fl != null) {
                    x.i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
                    Cursor rawQuery = Fl.rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
                    if (rawQuery == null) {
                        x.i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
                    } else {
                        obj = new LinkedList();
                        while (rawQuery.moveToNext()) {
                            com.tencent.mm.plugin.downloader.e.a aVar = new com.tencent.mm.plugin.downloader.e.a();
                            aVar.b(rawQuery);
                            obj.add(aVar);
                        }
                        rawQuery.close();
                    }
                }
                if (!bi.cC(obj)) {
                    Iterator it = obj.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.plugin.downloader.e.a aVar2 = (com.tencent.mm.plugin.downloader.e.a) it.next();
                        x.i("MicroMsg.PluginDownloader", "download fail, appId: " + aVar2.field_appId);
                        aVar2.field_status = 4;
                        aVar2.field_errCode = d.lxJ;
                        com.tencent.mm.plugin.downloader.model.e.c(aVar2);
                        com.tencent.mm.plugin.downloader.model.f aAK = com.tencent.mm.plugin.downloader.model.f.aAK();
                        long j = aVar2.field_downloadId;
                        int i = aVar2.field_errCode;
                        if (aAK.lya != null) {
                            aAK.lya.b(j, i, false);
                        }
                    }
                }
            }
        }).start();
    }

    public void onAccountRelease() {
    }
}
