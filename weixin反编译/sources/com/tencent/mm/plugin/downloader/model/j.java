package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public abstract class j implements p {
    protected c lya;

    public j(c cVar) {
        this.lya = cVar;
    }

    public static void yw(String str) {
        if (!bi.oN(str)) {
            if (new File(str).exists()) {
                x.i("MicroMsg.FileDownloaderImplBase", "Delete previous file result: %b", Boolean.valueOf(new File(str).delete()));
            }
        }
    }
}
