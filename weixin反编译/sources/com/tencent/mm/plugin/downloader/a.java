package com.tencent.mm.plugin.downloader;

import com.tencent.mm.bx.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.e.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, com.tencent.mm.plugin.downloader.b.a {
    private b lwJ;

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.lwJ = new b(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final b Fl() {
        g.Dr();
        g.Do().CA();
        return this.lwJ;
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        x.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new h.d() {
            public final String[] wn() {
                return b.gLy;
            }
        });
        return hashMap;
    }
}
