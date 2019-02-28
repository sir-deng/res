package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.z.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.downloader.ipc.CDNTaskState;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends j {
    private static final String lxr = (a.bnF + "BigFile");
    private byte[] gUq = new byte[0];
    private com.tencent.mm.plugin.downloader.d.b lwX = new com.tencent.mm.plugin.downloader.d.b() {
        public final void f(String str, int i, int i2, String str2) {
            com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
            if (yn == null) {
                x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
                return;
            }
            x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, url = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), str2);
            switch (i) {
                case 3:
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.lyr, 1);
                    intent.setClass(b.this.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, yn.field_downloadId);
                    try {
                        b.this.mContext.startService(intent);
                    } catch (Exception e) {
                        x.e("MicroMsg.FileCDNDownloader", e.getMessage());
                    }
                    b.this.cancelNotification(yn.field_downloadUrl);
                    return;
                case 4:
                    yn.field_errCode = Math.abs(i2);
                    yn.field_status = 4;
                    e.c(yn);
                    b.this.lya.b(yn.field_downloadId, Math.abs(i2), false);
                    b.a(b.this, yn.field_downloadUrl, 4, 0, false);
                    return;
                default:
                    return;
            }
        }

        public final void k(String str, long j, long j2) {
            com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
            if (yn == null) {
                x.i("MicroMsg.FileCDNDownloader", "onDownloadTaskStateChanged, info is null");
                return;
            }
            Long l = (Long) b.this.lxt.get(yn.field_downloadUrl);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (l == null || valueOf.longValue() - l.longValue() >= 500) {
                b.this.lxt.put(yn.field_downloadUrl, valueOf);
                yn.field_status = 1;
                yn.field_downloadedSize = j;
                yn.field_totalSize = j2;
                e.c(yn);
                b.this.lya.ce(yn.field_downloadId);
                int i = 0;
                if (j2 > 0) {
                    i = (int) ((((float) j) / ((float) j2)) * 100.0f);
                }
                if (i < 0) {
                    i = 0;
                } else if (i > 100) {
                    i = 100;
                }
                b.a(b.this, yn.field_downloadUrl, 1, i, false);
            }
        }
    };
    private HashMap<String, Long> lxs = new HashMap();
    private HashMap<String, Long> lxt = new HashMap();
    private ConcurrentHashMap<String, Integer> lxu = new ConcurrentHashMap();
    private Context mContext = ad.getContext();

    static /* synthetic */ void a(b bVar, String str, int i, int i2, boolean z) {
        x.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
        if (yn == null) {
            x.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
        } else if (yn.field_showNotification) {
            d dVar = new d(bVar.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                bVar.lxs.put(str, Long.valueOf(currentTimeMillis));
                dVar.c(currentTimeMillis);
            } else {
                Long l = (Long) bVar.lxs.get(str);
                if (l != null) {
                    dVar.c(l.longValue());
                }
            }
            dVar.a(yn.field_fileName);
            switch (i) {
                case 1:
                    dVar.U(17301633);
                    dVar.a(100, i2, i2 == 0);
                    dVar.b(bVar.mContext.getString(c.ehr));
                    dVar.c(2, true);
                    long j = yn.field_downloadId;
                    Intent intent = new Intent(bVar.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.sa = PendingIntent.getActivity(bVar.mContext, (int) System.currentTimeMillis(), intent, SQLiteDatabase.CREATE_IF_NECESSARY);
                    break;
                case 4:
                    dVar.U(17301634);
                    dVar.p(true);
                    dVar.sa = PendingIntent.getActivity(ad.getContext(), 0, new Intent(), 0);
                    dVar.b(bVar.mContext.getString(c.ehq));
                    break;
                default:
                    bVar.cancelNotification(str);
                    return;
            }
            synchronized (bVar.gUq) {
                Integer num = (Integer) bVar.lxu.get(str);
                if (num == null) {
                    bVar.lxu.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build())));
                } else {
                    ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), dVar.build());
                }
                if (i == 4) {
                    bVar.lxu.remove(str);
                }
            }
        }
    }

    public b(c cVar) {
        super(cVar);
    }

    public final long a(g gVar) {
        if (gVar == null || bi.oN(gVar.iIj)) {
            x.e("MicroMsg.FileCDNDownloader", "Invalid Request");
            return -1;
        }
        final String str = gVar.iIj;
        com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        if (yn != null) {
            fileDownloadTaskInfo = bZ(yn.field_downloadId);
            x.i("MicroMsg.FileCDNDownloader", "addDownloadTask, status = " + fileDownloadTaskInfo.status);
            if (fileDownloadTaskInfo.status == 1) {
                return fileDownloadTaskInfo.id;
            }
        }
        File file = new File(lxr);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.FileCDNDownloader", "mkdir parent error, %s", parentFile.getAbsolutePath());
                }
            }
            x.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", Boolean.valueOf(file.mkdirs()));
        }
        e.yl(str);
        e.ym(gVar.mAppId);
        yn = h.b(gVar);
        yn.field_downloadId = System.currentTimeMillis();
        yn.field_downloaderType = 3;
        yn.field_filePath = lxr + "/" + ac.VF(str);
        if (fileDownloadTaskInfo == null || !yn.field_filePath.equals(fileDownloadTaskInfo.path)) {
            yn.field_startState = 0;
        } else {
            String str2 = yn.field_filePath;
            String str3 = fileDownloadTaskInfo.path;
            if (!(str2 == null || str3 == null || str2.equals(str3))) {
                if (new File(str3).exists()) {
                    x.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", Boolean.valueOf(new File(str3).delete()));
                }
            }
            if (fileDownloadTaskInfo.status == 2) {
                yn.field_startState = 2;
            } else if (fileDownloadTaskInfo.status == 4) {
                yn.field_startState = 4;
            } else {
                yn.field_startState = 0;
            }
            yn.field_startSize = fileDownloadTaskInfo.fxa;
            x.d("MicroMsg.FileCDNDownloader", "addDownloadTask, startSize = " + fileDownloadTaskInfo.fxa);
        }
        yn.field_startTime = System.currentTimeMillis();
        new Thread(new Runnable() {
            public final void run() {
                int a = com.tencent.mm.plugin.downloader.d.a.aAB().a(b.a(yn));
                x.i("MicroMsg.FileCDNDownloader", "addDownloadTask: " + a);
                if (a == 0) {
                    yn.field_status = 1;
                    e.b(yn);
                    b.this.lya.i(yn.field_downloadId, yn.field_filePath);
                    b.a(b.this, str, 1, 0, true);
                } else if (a == -2) {
                    yn.field_status = 1;
                    e.b(yn);
                } else {
                    yn.field_status = 4;
                    yn.field_errCode = d.lxF;
                    e.b(yn);
                    b.this.lya.b(yn.field_downloadId, yn.field_errCode, false);
                }
            }
        }).start();
        return yn.field_downloadId;
    }

    private static CDNTaskInfo a(com.tencent.mm.plugin.downloader.e.a aVar) {
        CDNTaskInfo cDNTaskInfo = new CDNTaskInfo();
        cDNTaskInfo.hvk = true;
        cDNTaskInfo.mediaId = aVar.field_downloadUrl;
        cDNTaskInfo.downloadUrl = aVar.field_downloadUrl;
        cDNTaskInfo.filePath = aVar.field_filePath;
        cDNTaskInfo.lxk = aVar.field_secondaryUrl;
        cDNTaskInfo.lxm = 15;
        cDNTaskInfo.lxn = 3600;
        cDNTaskInfo.lxo = true;
        JSONObject jSONObject = new JSONObject();
        try {
            if (aVar.field_fileSize > 0) {
                jSONObject.put("Content-Length", aVar.field_fileSize);
            }
            cDNTaskInfo.lxl = jSONObject.toString();
        } catch (JSONException e) {
            x.e("MicroMsg.FileCDNDownloader", "addVerifyHeaders: " + e.getMessage());
        }
        return cDNTaskInfo;
    }

    public final int bY(final long j) {
        new Thread(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
                if (cf != null) {
                    com.tencent.mm.plugin.downloader.d.a.aAB().yh(cf.field_downloadUrl);
                    b.this.cancelNotification(cf.field_downloadUrl);
                    if (cf.field_status != 5) {
                        e.k(cf.field_downloadId, 5);
                        b.this.lya.cc(j);
                    }
                }
            }
        }).start();
        return 1;
    }

    public final FileDownloadTaskInfo bZ(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = null;
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf != null) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            CDNTaskState yi = com.tencent.mm.plugin.downloader.d.a.aAB().yi(cf.field_downloadUrl);
            if (yi != null) {
                switch (yi.taskState) {
                    case 100:
                    case 101:
                        fileDownloadTaskInfo.status = 1;
                        break;
                    case 102:
                        fileDownloadTaskInfo.status = 2;
                        break;
                    default:
                        fileDownloadTaskInfo.status = 0;
                        break;
                }
                fileDownloadTaskInfo.fxa = (long) yi.completeSize;
                fileDownloadTaskInfo.fxb = (long) yi.fileTotalSize;
            } else {
                if (cf.field_status == 1) {
                    fileDownloadTaskInfo.status = 0;
                } else {
                    fileDownloadTaskInfo.status = cf.field_status;
                }
                fileDownloadTaskInfo.fxa = cf.field_downloadedSize;
                fileDownloadTaskInfo.fxb = cf.field_totalSize;
            }
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.fxC = cf.field_downloaderType;
            fileDownloadTaskInfo.lyv = cf.field_autoDownload;
            fileDownloadTaskInfo.path = cf.field_filePath;
            fileDownloadTaskInfo.url = cf.field_downloadUrl;
            fileDownloadTaskInfo.frM = cf.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final boolean ca(final long j) {
        new Thread(new Runnable() {
            public final void run() {
                x.d("MicroMsg.FileCDNDownloader", "pauseDownloadTask");
                FileDownloadTaskInfo bZ = b.this.bZ(j);
                if (bZ != null && bZ.status == 1) {
                    com.tencent.mm.plugin.downloader.d.a.aAB().yg(bZ.url);
                    e.k(bZ.id, 2);
                    b.this.lya.cd(j);
                    b.this.cancelNotification(bZ.url);
                }
            }
        }).start();
        return true;
    }

    public final boolean cb(final long j) {
        final com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null || cf.field_status != 2) {
            return false;
        }
        new Thread(new Runnable() {
            public final void run() {
                long j = 0;
                int b = com.tencent.mm.plugin.downloader.d.a.aAB().b(b.a(cf));
                x.i("MicroMsg.FileCDNDownloader", "resumeDownloadTask: " + b);
                cf.field_startTime = System.currentTimeMillis();
                cf.field_startState = d.lxQ;
                cf.field_startSize = cf.field_downloadedSize;
                if (b == 0) {
                    cf.field_status = 1;
                    cf.field_errCode = 0;
                    e.c(cf);
                    b.this.lya.j(j, cf.field_filePath);
                    if (cf.field_totalSize != 0) {
                        j = cf.field_downloadedSize / cf.field_totalSize;
                    }
                    b.a(b.this, cf.field_downloadUrl, 1, (int) j, true);
                } else if (b == -2) {
                    cf.field_status = 1;
                    cf.field_errCode = 0;
                    e.c(cf);
                } else {
                    cf.field_status = 4;
                    cf.field_errCode = d.lxG;
                    e.c(cf);
                    b.this.lya.b(j, cf.field_errCode, false);
                }
            }
        }).start();
        return true;
    }

    private void cancelNotification(String str) {
        synchronized (this.gUq) {
            Integer num = (Integer) this.lxu.get(str);
            if (num == null) {
                x.i("MicroMsg.FileCDNDownloader", "No notification id found");
                return;
            }
            ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
            x.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = " + num);
            this.lxu.remove(str);
        }
    }
}
