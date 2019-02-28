package com.tencent.mm.plugin.downloader.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

final class k extends j {
    public k(c cVar) {
        super(cVar);
    }

    public final long a(g gVar) {
        if (bi.oN(gVar.iIj)) {
            return -1;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(gVar.iIj));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        try {
            ad.getContext().startActivity(intent);
            return 0;
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImplNormal", "Add download task failed: " + e.toString());
            return -1;
        }
    }

    public final int bY(long j) {
        return 1;
    }

    public final FileDownloadTaskInfo bZ(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        fileDownloadTaskInfo.status = -1;
        return fileDownloadTaskInfo;
    }

    public final boolean ca(long j) {
        return false;
    }

    public final boolean cb(long j) {
        return false;
    }
}
