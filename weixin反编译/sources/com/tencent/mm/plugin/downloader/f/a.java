package com.tencent.mm.plugin.downloader.f;

import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements com.tencent.xweb.b.a {
    private static a lyH = null;
    private com.tencent.mm.modelcdntran.i.a lxi = new com.tencent.mm.modelcdntran.i.a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            String str2;
            String str3 = "FileDownloaderXWEBProxy";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
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
                x.i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", str);
            } else if (i != 0) {
                x.e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                a.a(a.this, str, 4, i, false);
            } else if (keep_progressinfo != null) {
                a.a(a.this, str, (long) keep_progressinfo.field_finishedLength, (long) keep_progressinfo.field_toltalLength);
            } else if (keep_sceneresult != null) {
                if (keep_sceneresult.field_retCode != 0) {
                    x.e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult);
                    a.a(a.this, str, 4, keep_sceneresult.field_retCode, keep_sceneresult.field_isResume);
                } else {
                    x.i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", str);
                    a.a(a.this, str, 3, 0, keep_sceneresult.field_isResume);
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
    private Map<String, a> lyI = new ConcurrentHashMap();

    private class a {
        public b lyK;
        public String lyL;

        private a() {
            this.lyK = null;
            this.lyL = null;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        x.i("FileDownloaderXWEBProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", str, Integer.valueOf(i), Integer.valueOf(i2), null, Boolean.valueOf(aVar.lyI.containsKey(str)));
        if (aVar.lyI.containsKey(str)) {
            b bVar = ((a) aVar.lyI.get(str)).lyK;
            if (bVar == null) {
                x.e("FileDownloaderXWEBProxy", "error proxy_callback null");
            } else if (i == 3) {
                bVar.x(str, ((a) aVar.lyI.get(str)).lyL, z);
            } else {
                bVar.t(str, i2, z);
            }
        }
    }

    static /* synthetic */ void a(a aVar, String str, long j, long j2) {
        x.d("FileDownloaderXWEBProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(aVar.lyI.containsKey(str)));
        if (aVar.lyI.containsKey(str)) {
            b bVar = ((a) aVar.lyI.get(str)).lyK;
            if (bVar == null) {
                x.e("FileDownloaderXWEBProxy", "error proxy_callback null");
            } else {
                bVar.x(str, j, j2);
            }
        }
    }

    public static synchronized a aAR() {
        a aVar;
        synchronized (a.class) {
            if (lyH == null) {
                lyH = new a();
            }
            com.tencent.mm.plugin.downloader.c.a.aAA();
            aVar = lyH;
        }
        return aVar;
    }

    public final int a(String str, String str2, b bVar) {
        x.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", str, str2);
        i iVar = new i();
        iVar.field_mediaId = str;
        iVar.field_fullpath = str2;
        iVar.hvf = str;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.htJ;
        iVar.hve = this.lxi;
        iVar.hvg = 60;
        iVar.hvh = 600;
        iVar.hvj = false;
        a aVar = new a();
        aVar.lyK = bVar;
        aVar.lyL = str2;
        this.lyI.put(str, aVar);
        int d = com.tencent.mm.plugin.downloader.c.a.aAA().d(iVar);
        x.i("FileDownloaderXWEBProxy", "addDownloadTask: " + d);
        return d;
    }
}
