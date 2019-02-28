package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.z.d;
import com.tencent.mm.a.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.c.c;
import com.tencent.mm.f.a.hh;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.an;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class f {
    public static Map<Long, Long> lxS = new HashMap();
    private static int lxZ = 2;
    private static f lyb;
    p lxT;
    private p lxU;
    private p lxV;
    private p lxW;
    private p lxX;
    private p lxY;
    public c lya;

    static /* synthetic */ PendingIntent cj(String str, String str2) {
        Intent intent = new Intent();
        Context context = ad.getContext();
        intent.setClass(context, FileDownloadService.class);
        intent.putExtra(FileDownloadService.lyr, 3);
        intent.putExtra(FileDownloadService.lys, str);
        intent.putExtra(FileDownloadService.lyt, str2);
        return PendingIntent.getService(context, (int) System.currentTimeMillis(), intent, 0);
    }

    static /* synthetic */ void yq(String str) {
        x.i("MicroMsg.FileDownloadManager", "APK File Path: %s", str);
        if (!bi.oN(str)) {
            q.e(ad.getContext(), Uri.fromFile(new File(str)));
        }
    }

    public static f aAK() {
        if (lyb == null) {
            lyb = new f();
        }
        return lyb;
    }

    private f() {
        aAP();
        if (g.Do().CF()) {
            g.Do();
            if (!a.Cz()) {
                lxZ = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("FileDownloaderType"), 2);
                x.i("MicroMsg.FileDownloadManager", "get downloader type from dynamic config = %d", Integer.valueOf(lxZ));
                this.lya = new c();
            }
        }
        x.i("MicroMsg.FileDownloadManager", "not login, use the default tmassist downloader");
        this.lya = new c();
    }

    private p aAL() {
        x.i("MicroMsg.FileDownloadManager", "mDownloaderType = " + lxZ);
        if (this.lxT != null) {
            return this.lxT;
        }
        b hhVar = new hh();
        com.tencent.mm.sdk.b.a.xmy.m(hhVar);
        int i = hhVar.fyt.fxC;
        if (i > 0) {
            lxZ = i;
        }
        if (lxZ == 1) {
            this.lxT = aAM();
        } else {
            if (this.lxW == null) {
                this.lxW = new l(this.lya);
            }
            this.lxT = this.lxW;
        }
        return this.lxT;
    }

    public final p aAM() {
        if (this.lxV == null) {
            this.lxV = new i(this.lya);
        }
        return this.lxV;
    }

    public final p aAN() {
        if (this.lxU == null) {
            this.lxU = new k(this.lya);
        }
        return this.lxU;
    }

    public final p aAO() {
        if (this.lxX == null) {
            this.lxX = new b(this.lya);
        }
        return this.lxX;
    }

    public final long a(g gVar) {
        x.i("MicroMsg.FileDownloadManager", "addDownloadTask, filetype:%d, appId = %s", Integer.valueOf(gVar.lyj), gVar.mAppId);
        if (gVar.lyj == 2) {
            if (this.lxY == null) {
                this.lxY = new m(this.lya);
            }
            return this.lxY.a(gVar);
        }
        if (g.Do().CF()) {
            g.Do();
            if (!a.Cz()) {
                return aAL().a(gVar);
            }
        }
        long a = aAM().a(gVar);
        if (a >= 0) {
            lxS.put(Long.valueOf(a), Long.valueOf(0));
            ad.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
            x.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", Long.valueOf(a));
            return a;
        }
        x.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
        aAN().a(gVar);
        return a;
    }

    public final int bY(long j) {
        x.i("MicroMsg.FileDownloadManager", "removeDownloadTask, id = " + j);
        if (ch(j)) {
            return aAM().bY(j);
        }
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null || cf.field_downloaderType != 3) {
            return aAL().bY(j);
        }
        return aAO().bY(j);
    }

    public final FileDownloadTaskInfo bZ(long j) {
        if (ch(j)) {
            return aAM().bZ(j);
        }
        FileDownloadTaskInfo fileDownloadTaskInfo;
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf != null && cf.field_status == 3 && e.bO(cf.field_filePath)) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.url = cf.field_downloadUrl;
            fileDownloadTaskInfo.status = 3;
            fileDownloadTaskInfo.path = cf.field_filePath;
            fileDownloadTaskInfo.frM = cf.field_md5;
            fileDownloadTaskInfo.fxa = cf.field_downloadedSize;
            fileDownloadTaskInfo.fxb = cf.field_totalSize;
            fileDownloadTaskInfo.lyv = cf.field_autoDownload;
            fileDownloadTaskInfo.fxC = cf.field_downloaderType;
        } else if (cf == null || cf.field_downloaderType != 3) {
            fileDownloadTaskInfo = aAL().bZ(j);
            if (cf != null) {
                fileDownloadTaskInfo.lyv = cf.field_autoDownload;
                fileDownloadTaskInfo.fxC = cf.field_downloaderType;
            }
        } else {
            fileDownloadTaskInfo = aAO().bZ(j);
        }
        if (fileDownloadTaskInfo == null) {
            fileDownloadTaskInfo = new FileDownloadTaskInfo();
        }
        x.i("MicroMsg.FileDownloadManager", "getDownloadTaskInfo: id: %d, url: %s, status: %d, path: %s, md5: %s, totalsize: %d, autodownload: %b, downloaderType: %d", Long.valueOf(fileDownloadTaskInfo.id), fileDownloadTaskInfo.url, Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.path, fileDownloadTaskInfo.frM, Long.valueOf(fileDownloadTaskInfo.fxb), Boolean.valueOf(fileDownloadTaskInfo.lyv), Integer.valueOf(fileDownloadTaskInfo.fxC));
        return fileDownloadTaskInfo;
    }

    public final FileDownloadTaskInfo yo(String str) {
        com.tencent.mm.plugin.downloader.e.a yk = e.yk(str);
        if (yk != null) {
            return bZ(yk.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public final FileDownloadTaskInfo yp(String str) {
        com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
        if (yn != null) {
            return bZ(yn.field_downloadId);
        }
        return new FileDownloadTaskInfo();
    }

    public static ArrayList<FileDownloadTaskInfo> n(ArrayList<String> arrayList) {
        ArrayList arrayList2 = null;
        com.tencent.mm.plugin.downloader.e.b Fl = e.Fl();
        if (Fl != null) {
            Cursor rawQuery = Fl.rawQuery("select * from FileDownloadInfo where " + com.tencent.mm.plugin.downloader.e.b.o(arrayList), new String[0]);
            if (rawQuery != null) {
                arrayList2 = new ArrayList();
                if (rawQuery.moveToFirst()) {
                    do {
                        com.tencent.mm.plugin.downloader.e.a aVar = new com.tencent.mm.plugin.downloader.e.a();
                        aVar.b(rawQuery);
                        arrayList2.add(aVar);
                    } while (rawQuery.moveToNext());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        ArrayList<FileDownloadTaskInfo> arrayList3 = new ArrayList();
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.e.a aVar2 = (com.tencent.mm.plugin.downloader.e.a) it.next();
                FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
                if (aVar2.field_status != 3 || e.bO(aVar2.field_filePath)) {
                    fileDownloadTaskInfo.status = aVar2.field_status;
                } else {
                    fileDownloadTaskInfo.status = 0;
                }
                fileDownloadTaskInfo.appId = aVar2.field_appId;
                fileDownloadTaskInfo.id = aVar2.field_downloadId;
                fileDownloadTaskInfo.url = aVar2.field_downloadUrl;
                fileDownloadTaskInfo.path = aVar2.field_filePath;
                fileDownloadTaskInfo.frM = aVar2.field_md5;
                fileDownloadTaskInfo.fxa = aVar2.field_downloadedSize;
                fileDownloadTaskInfo.fxb = aVar2.field_totalSize;
                fileDownloadTaskInfo.lyv = aVar2.field_autoDownload;
                fileDownloadTaskInfo.fxC = aVar2.field_downloaderType;
                arrayList3.add(fileDownloadTaskInfo);
            }
        }
        return arrayList3;
    }

    public final boolean ca(long j) {
        x.i("MicroMsg.FileDownloadManager", "pauseDownloadTask, id = " + j);
        if (ch(j)) {
            return aAM().ca(j);
        }
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null || cf.field_downloaderType != 3) {
            return aAL().ca(j);
        }
        return aAO().ca(j);
    }

    public final boolean cb(long j) {
        x.i("MicroMsg.FileDownloadManager", "resumeDownloadTask, id = " + j);
        if (ch(j)) {
            return aAM().cb(j);
        }
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf == null || cf.field_downloaderType != 3) {
            return aAL().cb(j);
        }
        return aAO().cb(j);
    }

    private static void aAP() {
        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("off_line_download_ids", 0);
        if (sharedPreferences != null) {
            Map all = sharedPreferences.getAll();
            if (all != null && all.size() != 0) {
                lxS.clear();
                for (Entry entry : all.entrySet()) {
                    if (!(entry == null || bi.oN((String) entry.getKey()))) {
                        try {
                            long j = bi.getLong((String) entry.getKey(), 0);
                            long longValue = ((Long) entry.getValue()).longValue();
                            long currentTimeMillis = System.currentTimeMillis() - j;
                            if (currentTimeMillis - j > 0 && currentTimeMillis - j < 86400000) {
                                lxS.put(Long.valueOf(j), Long.valueOf(longValue));
                            }
                        } catch (Throwable e) {
                            x.e("MicroMsg.FileDownloadManager", "parse download task failed: " + e.toString());
                            x.printErrStackTrace("MicroMsg.FileDownloadManager", e, "", new Object[0]);
                        }
                    }
                }
                sharedPreferences.edit().clear();
                for (Entry entry2 : lxS.entrySet()) {
                    sharedPreferences.edit().putLong(entry2.getKey(), ((Long) entry2.getValue()).longValue());
                }
                sharedPreferences.edit().commit();
            }
        }
    }

    static void a(String str, String str2, PendingIntent pendingIntent) {
        d dVar = new d(ad.getContext());
        dVar.a(str);
        dVar.b(str2);
        dVar.U(17301634);
        dVar.p(true);
        if (pendingIntent != null) {
            dVar.sa = pendingIntent;
        } else {
            dVar.sa = PendingIntent.getActivity(ad.getContext(), 0, new Intent(), 0);
        }
        ((com.tencent.mm.plugin.notification.b.a) g.k(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build());
        x.i("MicroMsg.FileDownloadManager", "show notification");
    }

    static boolean ch(long j) {
        return lxS.containsKey(Long.valueOf(j));
    }

    static void s(long j, long j2) {
        lxS.put(Long.valueOf(j), Long.valueOf(j2));
        ad.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(j), j2).commit();
    }

    static long ci(long j) {
        Long l = (Long) lxS.get(Long.valueOf(j));
        return l == null ? -1 : l.longValue();
    }

    final void i(long j, boolean z) {
        x.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded id[%d], stack[%s]", Long.valueOf(j), bi.chl());
        final Context context = ad.getContext();
        if (ch(j)) {
            this.lya.b(j, bZ(j).path, z);
            return;
        }
        final com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf != null) {
            if (bi.oN(cf.field_packageName)) {
                String Sr = q.Sr(cf.field_filePath);
                if (!bi.oN(Sr)) {
                    cf.field_packageName = Sr;
                    x.i("MicroMsg.FileDownloadManager", "get package name from file : %s, %s", cf.field_filePath, Sr);
                    e.c(cf);
                }
            }
            final int Ss = q.Ss(cf.field_filePath);
            x.d("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded field_packageName[%s], field_filePath[%s], versionCode[%d]", cf.field_packageName, cf.field_filePath, Integer.valueOf(Ss));
            final long j2 = j;
            final boolean z2 = z;
            g.Dt().F(new Runnable() {
                public final void run() {
                    new an(cf.field_packageName, Ss).a(g.Dp().gRu.hoF, new com.tencent.mm.ad.e() {
                        public final void a(int i, int i2, String str, k kVar) {
                            kVar.hop = true;
                            com.tencent.mm.plugin.report.service.g gVar;
                            Object[] objArr;
                            if (i == 0 && i2 == 0) {
                                String string = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "yyb_pkg_sig_prefs", 4).getString(cf.field_packageName, "");
                                x.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded sig[%s]", string);
                                if (bi.oN(string)) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(322, 26, 1, false);
                                    gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                    objArr = new Object[2];
                                    objArr[0] = Integer.valueOf(4026);
                                    objArr[1] = String.format("%s,%s", new Object[]{cf.field_packageName, cf.field_filePath});
                                    gVar.h(11098, objArr);
                                } else {
                                    com.tencent.mm.plugin.report.service.g gVar2;
                                    Object[] objArr2;
                                    try {
                                        c.b(new File(cf.field_filePath), string);
                                        x.i("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode done");
                                        com.tencent.mm.plugin.report.service.g.pWK.a(322, 25, 1, false);
                                        gVar2 = com.tencent.mm.plugin.report.service.g.pWK;
                                        objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(4025);
                                        objArr2[1] = String.format("%s,%s,%s", new Object[]{cf.field_packageName, cf.field_filePath, string});
                                        gVar2.h(11098, objArr2);
                                    } catch (Exception e) {
                                        x.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded writeSecurityCode e: " + e.getMessage());
                                        com.tencent.mm.plugin.report.service.g.pWK.a(322, 27, 1, false);
                                        gVar2 = com.tencent.mm.plugin.report.service.g.pWK;
                                        objArr2 = new Object[2];
                                        objArr2[0] = Integer.valueOf(4027);
                                        objArr2[1] = String.format("%s,%s,%s", new Object[]{cf.field_packageName, cf.field_filePath, e.getMessage()});
                                        gVar2.h(11098, objArr2);
                                    }
                                }
                            } else {
                                x.w("MicroMsg.FileDownloadManager", "summertoken onMD5CheckSucceeded get pkg sig error");
                                com.tencent.mm.plugin.report.service.g.pWK.a(322, 28, 1, false);
                                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                                objArr = new Object[2];
                                objArr[0] = Integer.valueOf(4028);
                                objArr[1] = String.format("%s,%s,%d,%d", new Object[]{cf.field_packageName, cf.field_filePath, Integer.valueOf(i), Integer.valueOf(i2)});
                                gVar.h(11098, objArr);
                            }
                            ah.y(new Runnable() {
                                public final void run() {
                                    PendingIntent pendingIntent = null;
                                    if (cf.field_fileType == 1) {
                                        pendingIntent = f.cj(cf.field_filePath, cf.field_md5);
                                    }
                                    f fVar;
                                    String str;
                                    if (cf.field_showNotification && bi.oN(cf.field_fileName)) {
                                        fVar = f.this;
                                        str = cf.field_downloadUrl;
                                        f.a(context.getString(com.tencent.mm.plugin.downloader.b.c.lwN), "", pendingIntent);
                                    } else if (cf.field_showNotification && !bi.oN(cf.field_fileName)) {
                                        fVar = f.this;
                                        str = cf.field_downloadUrl;
                                        f.a(cf.field_fileName, context.getString(com.tencent.mm.plugin.downloader.b.c.lwN), pendingIntent);
                                    }
                                    if (cf.field_autoInstall && cf.field_fileType == 1) {
                                        f.yq(cf.field_filePath);
                                    }
                                    f.this.lya.b(j2, cf.field_filePath, z2);
                                }
                            });
                        }
                    });
                }
            });
        }
    }
}
