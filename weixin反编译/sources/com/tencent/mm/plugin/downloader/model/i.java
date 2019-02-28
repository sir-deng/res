package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class i extends j {
    al ind = new al(new a() {
        public final boolean uG() {
            g.Dt().F(new Runnable() {
                public final void run() {
                    try {
                        Iterator it = i.this.lyx.iterator();
                        while (it.hasNext()) {
                            i.a(i.this, Long.valueOf(((Long) it.next()).longValue()));
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.FileDownloaderImpl23", e.getMessage());
                    }
                }
            });
            i iVar = i.this;
            boolean z = iVar.lyx == null || iVar.lyx.size() == 0;
            if (z) {
                x.d("MicroMsg.FileDownloaderImpl23", "timer stop");
            } else {
                i.this.ind.K(1000, 1000);
            }
            return false;
        }
    }, false);
    private DownloadManager lyw = ((DownloadManager) this.mContext.getSystemService("download"));
    CopyOnWriteArraySet<Long> lyx = new CopyOnWriteArraySet();
    private Context mContext = ad.getContext();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.downloader.model.i r11, java.lang.Long r12) {
        /*
        r0 = "MicroMsg.FileDownloaderImpl23";
        r1 = "updateDownloadStatus";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = r12.longValue();
        r1 = com.tencent.mm.plugin.downloader.model.e.cf(r0);
        if (r1 == 0) goto L_0x003f;
    L_0x0013:
        r0 = new android.app.DownloadManager$Query;
        r0.<init>();
        r2 = 1;
        r2 = new long[r2];
        r3 = 0;
        r4 = r1.field_sysDownloadId;
        r2[r3] = r4;
        r0.setFilterById(r2);
        r2 = r11.lyw;	 Catch:{ Exception -> 0x0040 }
        r2 = r2.query(r0);	 Catch:{ Exception -> 0x0040 }
        if (r2 != 0) goto L_0x0063;
    L_0x002b:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r2 = "query download status failed: cursor is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        r0 = r11.lyx;
        r0.remove(r12);
        r0 = 4;
        r1.field_status = r0;
        com.tencent.mm.plugin.downloader.model.e.c(r1);
    L_0x003f:
        return;
    L_0x0040:
        r0 = move-exception;
        r2 = "MicroMsg.FileDownloaderImpl23";
        r3 = "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r0.toString();
        r4[r5] = r0;
        r0 = 1;
        r4[r0] = r12;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
        r0 = r11.lyx;
        r0.remove(r12);
        r0 = 4;
        r1.field_status = r0;
        com.tencent.mm.plugin.downloader.model.e.c(r1);
        goto L_0x003f;
    L_0x0063:
        r0 = r2.moveToFirst();
        if (r0 == 0) goto L_0x00a2;
    L_0x0069:
        r0 = "status";
        r0 = r2.getColumnIndex(r0);
        r3 = "local_uri";
        r3 = r2.getColumnIndex(r3);
        r4 = "bytes_so_far";
        r4 = r2.getColumnIndex(r4);
        r5 = "total_size";
        r5 = r2.getColumnIndex(r5);
        r6 = -1;
        if (r0 == r6) goto L_0x00a2;
    L_0x0088:
        r0 = r2.getInt(r0);	 Catch:{ Exception -> 0x00c8 }
        r6 = "MicroMsg.FileDownloaderImpl23";
        r7 = "status = %d";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x00c8 }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00c8 }
        r8[r9] = r10;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);	 Catch:{ Exception -> 0x00c8 }
        switch(r0) {
            case 1: goto L_0x00a6;
            case 2: goto L_0x00a6;
            case 4: goto L_0x0100;
            case 8: goto L_0x0115;
            case 16: goto L_0x00e8;
            default: goto L_0x00a2;
        };
    L_0x00a2:
        r2.close();
        goto L_0x003f;
    L_0x00a6:
        r0 = -1;
        if (r4 == r0) goto L_0x00af;
    L_0x00a9:
        r6 = r2.getLong(r4);	 Catch:{ Exception -> 0x00c8 }
        r1.field_downloadedSize = r6;	 Catch:{ Exception -> 0x00c8 }
    L_0x00af:
        r0 = -1;
        if (r5 == r0) goto L_0x00b8;
    L_0x00b2:
        r4 = r2.getLong(r5);	 Catch:{ Exception -> 0x00c8 }
        r1.field_totalSize = r4;	 Catch:{ Exception -> 0x00c8 }
    L_0x00b8:
        r0 = 1;
        r1.field_status = r0;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.plugin.downloader.model.e.c(r1);	 Catch:{ Exception -> 0x00c8 }
        r0 = r11.lya;	 Catch:{ Exception -> 0x00c8 }
        r4 = r12.longValue();	 Catch:{ Exception -> 0x00c8 }
        r0.ce(r4);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00a2;
    L_0x00c8:
        r0 = move-exception;
        r3 = r11.lyx;
        r3.remove(r12);
        r3 = 4;
        r1.field_status = r3;
        com.tencent.mm.plugin.downloader.model.e.c(r1);
        r1 = "MicroMsg.FileDownloaderImpl23";
        r3 = "query download info failed: [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r0.toString();
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r3, r4);
        goto L_0x00a2;
    L_0x00e8:
        r0 = r11.lyx;	 Catch:{ Exception -> 0x00c8 }
        r0.remove(r12);	 Catch:{ Exception -> 0x00c8 }
        r0 = com.tencent.mm.plugin.downloader.model.d.lxO;	 Catch:{ Exception -> 0x00c8 }
        r3 = 4;
        r1.field_status = r3;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.plugin.downloader.model.e.c(r1);	 Catch:{ Exception -> 0x00c8 }
        r3 = r11.lya;	 Catch:{ Exception -> 0x00c8 }
        r4 = r12.longValue();	 Catch:{ Exception -> 0x00c8 }
        r6 = 0;
        r3.b(r4, r0, r6);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00a2;
    L_0x0100:
        r0 = r11.lyx;	 Catch:{ Exception -> 0x00c8 }
        r0.remove(r12);	 Catch:{ Exception -> 0x00c8 }
        r0 = 2;
        r1.field_status = r0;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.plugin.downloader.model.e.c(r1);	 Catch:{ Exception -> 0x00c8 }
        r0 = r11.lya;	 Catch:{ Exception -> 0x00c8 }
        r4 = r12.longValue();	 Catch:{ Exception -> 0x00c8 }
        r0.cd(r4);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00a2;
    L_0x0115:
        r0 = r11.lyx;	 Catch:{ Exception -> 0x00c8 }
        r0.remove(r12);	 Catch:{ Exception -> 0x00c8 }
        r0 = -1;
        if (r3 == r0) goto L_0x00a2;
    L_0x011d:
        r0 = r1.field_filePath;	 Catch:{ Exception -> 0x00c8 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);	 Catch:{ Exception -> 0x00c8 }
        if (r0 != 0) goto L_0x012d;
    L_0x0125:
        r0 = r1.field_filePath;	 Catch:{ Exception -> 0x00c8 }
        r0 = com.tencent.mm.a.e.bO(r0);	 Catch:{ Exception -> 0x00c8 }
        if (r0 != 0) goto L_0x0146;
    L_0x012d:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r3 = "path not exists, path = %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00c8 }
        r5 = 0;
        r6 = r1.field_filePath;	 Catch:{ Exception -> 0x00c8 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.sdk.platformtools.x.e(r0, r3, r4);	 Catch:{ Exception -> 0x00c8 }
        r0 = 4;
        r1.field_status = r0;	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.plugin.downloader.model.e.c(r1);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x003f;
    L_0x0146:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00c8 }
        r0.<init>();	 Catch:{ Exception -> 0x00c8 }
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00c8 }
        r4 = com.tencent.mm.plugin.downloader.model.FileDownloadService.class;
        r0.setClass(r3, r4);	 Catch:{ Exception -> 0x00c8 }
        r3 = com.tencent.mm.plugin.downloader.model.FileDownloadService.EXTRA_ID;	 Catch:{ Exception -> 0x00c8 }
        r4 = r1.field_downloadId;	 Catch:{ Exception -> 0x00c8 }
        r0.putExtra(r3, r4);	 Catch:{ Exception -> 0x00c8 }
        r3 = com.tencent.mm.plugin.downloader.model.FileDownloadService.lyr;	 Catch:{ Exception -> 0x00c8 }
        r4 = 1;
        r0.putExtra(r3, r4);	 Catch:{ Exception -> 0x00c8 }
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ Exception -> 0x00c8 }
        r0 = r3.startService(r0);	 Catch:{ Exception -> 0x00c8 }
        r3 = "MicroMsg.FileDownloaderImpl23";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c8 }
        r5 = "start download service: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00c8 }
        r5 = r0.getClassName();	 Catch:{ Exception -> 0x00c8 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00c8 }
        r5 = ", ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00c8 }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x00c8 }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x00c8 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c8 }
        com.tencent.mm.sdk.platformtools.x.d(r3, r0);	 Catch:{ Exception -> 0x00c8 }
        goto L_0x00a2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.model.i.a(com.tencent.mm.plugin.downloader.model.i, java.lang.Long):void");
    }

    public i(c cVar) {
        super(cVar);
    }

    public final long a(final g gVar) {
        if (gVar == null || bi.oN(gVar.iIj)) {
            x.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            return -1;
        } else if (gVar.lyn) {
            x.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", gVar.mAppId);
            return -1;
        } else {
            String str = gVar.iIj;
            String str2 = "";
            com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
            if (yn != null) {
                FileDownloadTaskInfo ck = ck(yn.field_sysDownloadId);
                if (ck.status == 1) {
                    return ck.id;
                }
                str2 = yn.field_filePath;
                this.lyw.remove(new long[]{yn.field_sysDownloadId});
            }
            String absolutePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!bi.oN(absolutePath)) {
                File file = new File(absolutePath);
                if (!file.exists()) {
                    boolean mkdir = file.mkdir();
                    x.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", Boolean.valueOf(mkdir));
                }
            }
            j.yw(str2);
            e.yl(str);
            e.ym(gVar.mAppId);
            final com.tencent.mm.plugin.downloader.e.a b = h.b(gVar);
            b.field_downloadId = System.currentTimeMillis();
            b.field_status = 0;
            b.field_downloaderType = 1;
            b.field_filePath = h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + ac.VF(str);
            b.field_startTime = System.currentTimeMillis();
            e.b(b);
            g.Dt().F(new Runnable() {
                public final void run() {
                    if (gVar.lym) {
                        b.field_md5 = h.yv(b.field_downloadUrl);
                    }
                    long d = i.this.d(b);
                    if (d > 0) {
                        b.field_sysDownloadId = d;
                        b.field_status = 1;
                        e.c(b);
                        i.this.lya.i(b.field_downloadId, b.field_filePath);
                        f.aAK();
                        if (f.ch(b.field_downloadId)) {
                            f.aAK();
                            f.s(b.field_downloadId, d);
                        }
                        i.this.lyx.add(Long.valueOf(b.field_downloadId));
                        if (i.this.ind.cgx()) {
                            i.this.ind.K(100, 100);
                        }
                        x.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(b.field_downloadId), b.field_downloadUrl, b.field_filePath);
                        return;
                    }
                    b.field_status = 4;
                    e.c(b);
                    i.this.lya.b(b.field_downloadId, d.lxO, false);
                    x.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
                }
            });
            return b.field_downloadId;
        }
    }

    public final int bY(long j) {
        int remove;
        Exception e;
        f.aAK();
        if (f.ch(j)) {
            f.aAK();
            long ci = f.ci(j);
            return this.lyw.remove(new long[]{ci});
        }
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null) {
            x.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            return 0;
        }
        try {
            remove = this.lyw.remove(new long[]{cf.field_sysDownloadId});
            try {
                x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", Long.valueOf(j));
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
                b.deleteFile(cf.field_filePath);
                x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", cf.field_filePath);
                cf.field_status = 5;
                e.c(cf);
                this.lya.cc(j);
                this.lyx.remove(Long.valueOf(j));
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
        }
        b.deleteFile(cf.field_filePath);
        x.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", cf.field_filePath);
        cf.field_status = 5;
        e.c(cf);
        this.lya.cc(j);
        this.lyx.remove(Long.valueOf(j));
        return remove;
    }

    public final FileDownloadTaskInfo bZ(long j) {
        f.aAK();
        FileDownloadTaskInfo ck;
        if (f.ch(j)) {
            f.aAK();
            ck = ck(f.ci(j));
            ck.id = j;
            ck.fxC = 1;
            return ck;
        }
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null) {
            return new FileDownloadTaskInfo();
        }
        if (cf.field_status == 4 || cf.field_status == 2 || cf.field_status == 5 || cf.field_status == 3) {
            this.lyx.remove(Long.valueOf(j));
        }
        ck = new FileDownloadTaskInfo();
        ck.id = cf.field_downloadId;
        ck.url = cf.field_downloadUrl;
        ck.status = cf.field_status;
        ck.path = cf.field_filePath;
        ck.frM = cf.field_md5;
        ck.lyv = cf.field_autoDownload;
        ck.fxC = cf.field_downloaderType;
        ck.fxa = cf.field_downloadedSize;
        ck.fxb = cf.field_totalSize;
        return ck;
    }

    final long d(com.tencent.mm.plugin.downloader.e.a aVar) {
        try {
            Request request = new Request(Uri.parse(aVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(aVar.field_showNotification);
            request.setVisibleInDownloadsUi(aVar.field_showNotification);
            if (!bi.oN(aVar.field_fileName)) {
                request.setTitle(aVar.field_fileName);
            }
            request.setDestinationUri(Uri.fromFile(new File(aVar.field_filePath)));
            long enqueue = this.lyw.enqueue(request);
            if (enqueue > 0) {
                return enqueue;
            }
            x.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            return -1;
        } catch (Exception e) {
            x.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", e.toString(), aVar.field_downloadUrl);
            return -1;
        }
    }

    private FileDownloadTaskInfo ck(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.lyw.query(query);
            if (query2 == null) {
                x.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex(DownloadInfo.STATUS);
                    int columnIndex2 = query2.getColumnIndex("uri");
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 8:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 16:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (bi.oN(string)) {
                            x.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            x.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", string);
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            x.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", fileDownloadTaskInfo.path);
                        }
                    }
                    if (columnIndex4 != -1) {
                        fileDownloadTaskInfo.fxa = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fileDownloadTaskInfo.fxb = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                x.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
            }
        } catch (Exception e2) {
            x.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), Long.valueOf(j));
        }
        return fileDownloadTaskInfo;
    }

    public final boolean ca(long j) {
        FileDownloadTaskInfo bZ = bZ(j);
        if (bZ == null) {
            x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            return false;
        }
        this.lyx.remove(Long.valueOf(j));
        if (bZ.status != 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", Long.valueOf(j));
            return true;
        }
        x.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", Long.valueOf(j), Integer.valueOf(bY(j)));
        if (bY(j) > 0) {
            return true;
        }
        return false;
    }

    public final boolean cb(long j) {
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            return false;
        } else if (cf.field_downloaderType != 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", Long.valueOf(j));
            b.deleteFile(cf.field_filePath);
            e.cg(j);
            return false;
        } else if (cf.field_status == 1) {
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", Long.valueOf(j));
            return false;
        } else {
            this.lyw.remove(new long[]{cf.field_sysDownloadId});
            long d = d(cf);
            if (d > 0) {
                this.lyx.add(Long.valueOf(cf.field_downloadId));
                if (this.ind.cgx()) {
                    this.ind.K(100, 100);
                }
                cf.field_sysDownloadId = d;
                cf.field_status = 1;
                e.c(cf);
                return true;
            }
            x.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            return false;
        }
    }
}
