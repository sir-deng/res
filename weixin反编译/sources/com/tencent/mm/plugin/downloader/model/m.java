package com.tencent.mm.plugin.downloader.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;

public final class m extends j {
    private static final String lxr = (a.bnF + "WebNetFile");
    private HashMap<String, Long> lxt = new HashMap();
    private i.a lyB = new i.a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            String str2;
            String str3 = "MicroMsg.FileWebNetDownloader";
            String str4 = "on webnet callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = keep_progressinfo == null ? "null" : keep_progressinfo.toString();
            if (keep_sceneresult == null) {
                str2 = "null";
            } else {
                str2 = keep_sceneresult.toString();
            }
            objArr[3] = str2;
            x.d(str3, str4, objArr);
            if (i == -21006) {
                x.i("MicroMsg.FileWebNetDownloader", "duplicate request, ignore this request, media id is %s", str);
            } else if (i != 0) {
                x.e("MicroMsg.FileWebNetDownloader", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                m.a(m.this, str, 4, i);
            } else if (keep_progressinfo != null) {
                m.a(m.this, str, (long) keep_progressinfo.field_finishedLength, (long) keep_progressinfo.field_toltalLength);
            } else if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("MicroMsg.FileWebNetDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult);
                    m.a(m.this, str, 4, keep_sceneresult.field_retCode);
                } else {
                    x.i("MicroMsg.FileWebNetDownloader", "cdn trans suceess, media id : %s", str);
                    m.a(m.this, str, 3, 0);
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    private Context mContext = ad.getContext();

    static /* synthetic */ void a(m mVar, String str, int i, int i2) {
        x.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, url = %s, state = %d, errCode= %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), null);
        com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
        if (yn == null) {
            x.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, info is null");
            return;
        }
        x.i("MicroMsg.FileWebNetDownloader", "updateDownloadState, url = %s, state = %d, errCode = %d, errMsg = %s", str, Integer.valueOf(i), Integer.valueOf(i2), null);
        switch (i) {
            case 3:
                Intent intent = new Intent();
                intent.putExtra(FileDownloadService.lyr, 1);
                intent.setClass(mVar.mContext, FileDownloadService.class);
                intent.putExtra(FileDownloadService.EXTRA_ID, yn.field_downloadId);
                try {
                    mVar.mContext.startService(intent);
                    return;
                } catch (Exception e) {
                    x.e("MicroMsg.FileWebNetDownloader", e.getMessage());
                    return;
                }
            case 4:
                yn.field_errCode = Math.abs(i2);
                yn.field_status = 4;
                e.c(yn);
                mVar.lya.b(yn.field_downloadId, Math.abs(i2), false);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(m mVar, String str, long j, long j2) {
        com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
        if (yn == null) {
            x.i("MicroMsg.FileWebNetDownloader", "updateProgressChange, info is null");
            return;
        }
        Long l = (Long) mVar.lxt.get(yn.field_downloadUrl);
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (l == null || valueOf.longValue() - l.longValue() >= 500) {
            mVar.lxt.put(yn.field_downloadUrl, valueOf);
            yn.field_status = 1;
            yn.field_downloadedSize = j;
            yn.field_totalSize = j2;
            e.c(yn);
            mVar.lya.ce(yn.field_downloadId);
        }
    }

    public m(c cVar) {
        super(cVar);
    }

    public final long a(g gVar) {
        if (gVar == null || bi.oN(gVar.iIj)) {
            x.e("MicroMsg.FileWebNetDownloader", "Invalid Request");
            return -1;
        }
        x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: %s", gVar.iIj);
        String str = gVar.iIj;
        com.tencent.mm.plugin.downloader.e.a yn = e.yn(str);
        if (yn != null) {
            FileDownloadTaskInfo bZ = bZ(yn.field_downloadId);
            x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask, status = " + bZ.status);
            if (bZ.status == 1) {
                return bZ.id;
            }
        }
        e.yl(str);
        e.ym(gVar.mAppId);
        com.tencent.mm.plugin.downloader.e.a b = h.b(gVar);
        b.field_downloadId = System.currentTimeMillis();
        b.field_downloaderType = 4;
        b.field_filePath = lxr + "/" + ac.VF(str);
        if (yn != null) {
            str = b.field_filePath;
            String str2 = yn.field_filePath;
            if (!(str == null || str2 == null || str.equals(str2))) {
                if (new File(str2).exists()) {
                    x.i("MicroMsg.FileWebNetDownloader", "Delete previous file result: %b", Boolean.valueOf(new File(str2).delete()));
                }
            }
        }
        b.field_startTime = System.currentTimeMillis();
        File file = new File(lxr);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                File parentFile = file.getParentFile();
                File file2 = new File(parentFile.getAbsolutePath() + System.currentTimeMillis());
                if (file2.mkdirs()) {
                    file2.renameTo(parentFile);
                } else {
                    x.e("MicroMsg.FileWebNetDownloader", "mkdir parent error, %s", parentFile.getAbsolutePath());
                }
            }
            x.i("MicroMsg.FileWebNetDownloader", "Make download dir result: %b", Boolean.valueOf(file.mkdirs()));
        }
        i iVar = new i();
        iVar.hvf = gVar.iIj;
        iVar.field_mediaId = gVar.iIj;
        if (gVar.lyj == 2) {
            iVar.field_fileType = b.htI;
            iVar.hvg = 20;
            iVar.hvh = 90;
        }
        iVar.field_fullpath = b.field_filePath;
        iVar.hve = this.lyB;
        boolean b2 = g.MP().b(iVar, -1);
        x.i("MicroMsg.FileWebNetDownloader", "addDownloadTask: " + b2);
        if (b2) {
            b.field_status = 1;
            e.b(b);
            this.lya.i(b.field_downloadId, b.field_filePath);
        } else {
            b.field_status = 4;
            b.field_errCode = d.lxF;
            e.b(b);
            this.lya.b(b.field_downloadId, b.field_errCode, false);
        }
        return b.field_downloadId;
    }

    public final FileDownloadTaskInfo bZ(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
        if (cf != null) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(cf.field_downloadUrl);
            if (cf.field_status != 1 || (httpMultiSocketDownloadTaskState != null && (httpMultiSocketDownloadTaskState.taskState == 100 || httpMultiSocketDownloadTaskState.taskState == 101))) {
                fileDownloadTaskInfo.status = cf.field_status;
            } else {
                fileDownloadTaskInfo.status = 0;
            }
            fileDownloadTaskInfo.fxa = cf.field_downloadedSize;
            fileDownloadTaskInfo.fxb = cf.field_totalSize;
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.fxC = cf.field_downloaderType;
            fileDownloadTaskInfo.lyv = cf.field_autoDownload;
            fileDownloadTaskInfo.path = cf.field_filePath;
            fileDownloadTaskInfo.url = cf.field_downloadUrl;
            fileDownloadTaskInfo.frM = cf.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final int bY(final long j) {
        new Thread(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.downloader.e.a cf = e.cf(j);
                if (cf != null) {
                    g.MP().kL(cf.field_downloadUrl);
                    if (cf.field_status != 5) {
                        e.k(cf.field_downloadId, 5);
                        m.this.lya.cc(j);
                    }
                }
            }
        }).start();
        return 1;
    }

    public final boolean ca(final long j) {
        new Thread(new Runnable() {
            public final void run() {
                x.d("MicroMsg.FileWebNetDownloader", "pauseDownloadTask");
                FileDownloadTaskInfo bZ = m.this.bZ(j);
                if (bZ != null && bZ.status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(bZ.url);
                    e.k(bZ.id, 2);
                    m.this.lya.cd(j);
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
                int resumeHttpMultiSocketDownloadTask = CdnLogic.resumeHttpMultiSocketDownloadTask(cf.field_downloadUrl);
                x.i("MicroMsg.FileWebNetDownloader", "resumeDownloadTask: " + resumeHttpMultiSocketDownloadTask);
                cf.field_startTime = System.currentTimeMillis();
                cf.field_startState = d.lxQ;
                cf.field_startSize = cf.field_downloadedSize;
                if (resumeHttpMultiSocketDownloadTask == 0) {
                    cf.field_status = 1;
                    cf.field_errCode = 0;
                    e.c(cf);
                    m.this.lya.j(j, cf.field_filePath);
                    if (cf.field_totalSize != 0) {
                        long j = cf.field_downloadedSize;
                        j = cf.field_totalSize;
                        return;
                    }
                    return;
                }
                cf.field_status = 4;
                cf.field_errCode = d.lxG;
                e.c(cf);
                m.this.lya.b(j, cf.field_errCode, false);
            }
        }).start();
        return true;
    }
}
