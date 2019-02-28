package com.tencent.mm.plugin.downloader.c;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.modelcdntran.b.b;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements b {
    private static a lwP = null;
    private ah gSq = new ah();
    Queue<String> hud = new LinkedList();
    public Map<String, i> hue = new ConcurrentHashMap();
    public Map<String, i> huf = new ConcurrentHashMap();
    public Map<String, Integer> hug = new ConcurrentHashMap();
    private String huh = "";
    private long hui = 0;
    public HashSet<String> huj = new HashSet();
    com.tencent.mm.modelcdntran.b lwQ = new com.tencent.mm.modelcdntran.b(ad.getContext().getFilesDir() + "/NativeCDNInfo", this);

    /* renamed from: com.tencent.mm.plugin.downloader.c.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hul = -1;
        final /* synthetic */ i hum;

        AnonymousClass1(int i, i iVar) {
            this.hum = iVar;
        }

        public final void run() {
            if (this.hul != -1) {
                a.this.hug.put(this.hum.field_mediaId, Integer.valueOf(this.hul));
            }
            a.this.hud.add(this.hum.field_mediaId);
            a.this.hue.put(this.hum.field_mediaId, this.hum);
            a aVar = a.this;
            x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn tryStart queue:%d", Integer.valueOf(aVar.hud.size()));
            while (!aVar.hud.isEmpty()) {
                i iVar = (i) aVar.hue.remove((String) aVar.hud.poll());
                if (iVar == null) {
                    x.e("MicroMsg.CdnDownloadNativeService", "summersafecdn task queue is empty , maybe bug here");
                    return;
                }
                x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn id:%s cdnautostart :%s chatroom:%s", iVar.field_mediaId, Boolean.valueOf(iVar.field_autostart), Integer.valueOf(iVar.field_chattype));
                iVar.field_startTime = bi.Wy();
                String str;
                int b;
                if (iVar.fMC) {
                    String str2 = "MicroMsg.CdnDownloadNativeService";
                    str = "summersafecdn tryStart send file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                    Object[] objArr = new Object[7];
                    objArr[0] = Integer.valueOf(iVar.field_fullpath == null ? -1 : iVar.field_fullpath.length());
                    objArr[1] = Integer.valueOf(iVar.field_thumbpath == null ? -1 : iVar.field_thumbpath.length());
                    objArr[2] = bi.Wz(iVar.field_svr_signature);
                    objArr[3] = bi.Wz(iVar.field_aesKey);
                    objArr[4] = Integer.valueOf(iVar.field_fileType);
                    objArr[5] = iVar.field_mediaId;
                    objArr[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                    x.i(str2, str, objArr);
                    if (iVar.field_fullpath == null) {
                        iVar.field_fullpath = "";
                    }
                    if (iVar.field_thumbpath == null) {
                        iVar.field_thumbpath = "";
                    }
                    b = com.tencent.mm.modelcdntran.b.b(iVar);
                    if (b != 0) {
                        x.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia error:%d clientid:%s", Integer.valueOf(b), iVar.field_mediaId);
                        if (iVar.hve != null) {
                            iVar.hve.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                        }
                    } else {
                        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupUploadMedia ok, field_mediaId[%s]", iVar.field_mediaId);
                        aVar.huf.put(iVar.field_mediaId, iVar);
                    }
                } else {
                    int i = -1;
                    String str3;
                    Object[] objArr2;
                    if (iVar.field_fileType == com.tencent.mm.modelcdntran.b.htG || iVar.field_fileType == com.tencent.mm.modelcdntran.b.htI || iVar.field_fileType == com.tencent.mm.modelcdntran.b.htJ || iVar.field_fileType == com.tencent.mm.modelcdntran.b.htK || iVar.field_fileType == com.tencent.mm.modelcdntran.b.htL) {
                        if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                            i = com.tencent.mm.modelcdntran.b.a(iVar.field_mediaId, iVar.hvf, iVar.field_fullpath, iVar.field_fileType, iVar.hvg, iVar.hvh, iVar.hvi, iVar.hvj);
                        }
                        str = "MicroMsg.CdnDownloadNativeService";
                        str3 = "url download tryStart recv file:%d field_mediaId[%s], download_url[%s], filetype:[%d], ret:%d";
                        objArr2 = new Object[5];
                        objArr2[0] = Integer.valueOf(iVar.field_fullpath == null ? -1 : iVar.field_fullpath.length());
                        objArr2[1] = iVar.field_mediaId;
                        objArr2[2] = iVar.hvf;
                        objArr2[3] = Integer.valueOf(iVar.field_fileType);
                        objArr2[4] = Integer.valueOf(i);
                        x.i(str, str3, objArr2);
                        b = i;
                    } else if (iVar.hvk) {
                        if (!(iVar.field_fullpath == null || iVar.field_fullpath.isEmpty())) {
                            i = com.tencent.mm.modelcdntran.b.a(iVar.field_mediaId, iVar.field_fullpath, iVar.hvf, iVar.hvl, iVar.hvm, iVar.allow_mobile_net_download, iVar.hvg, iVar.hvh, iVar.is_resume_task, iVar.hvi);
                        }
                        str = "MicroMsg.CdnDownloadNativeService";
                        str3 = "game package download tryStart recv file:%s field_mediaId[%s], download_url[%s] https url[%s]";
                        objArr2 = new Object[4];
                        objArr2[0] = iVar.field_fullpath == null ? "" : iVar.field_fullpath;
                        objArr2[1] = iVar.field_mediaId;
                        objArr2[2] = iVar.hvf;
                        objArr2[3] = iVar.hvl;
                        x.i(str, str3, objArr2);
                        b = i;
                    } else {
                        str = "MicroMsg.CdnDownloadNativeService";
                        str3 = "summersafecdn tryStart recv file:%d thumb:%d, field_svr_signature[%s], field_aesKey[%s], field_fileType[%d], field_mediaId[%s], onlycheckexist[%b]";
                        objArr2 = new Object[7];
                        objArr2[0] = Integer.valueOf(iVar.field_fullpath == null ? -1 : iVar.field_fullpath.length());
                        objArr2[1] = Integer.valueOf(iVar.field_thumbpath == null ? -1 : iVar.field_thumbpath.length());
                        objArr2[2] = iVar.field_svr_signature;
                        objArr2[3] = iVar.field_aesKey;
                        objArr2[4] = Integer.valueOf(iVar.field_fileType);
                        objArr2[5] = iVar.field_mediaId;
                        objArr2[6] = Boolean.valueOf(iVar.field_onlycheckexist);
                        x.i(str, str3, objArr2);
                        if (iVar.hvo != 2) {
                            b = CdnLogic.startC2CDownload(com.tencent.mm.modelcdntran.b.a(iVar));
                        } else if (iVar instanceof j) {
                            j jVar = (j) iVar;
                            if (jVar.MT()) {
                                b = com.tencent.mm.modelcdntran.b.a(iVar, 2);
                            } else {
                                if (jVar.MS()) {
                                    i = com.tencent.mm.modelcdntran.b.a(jVar.field_mediaId, jVar.url, jVar.referer, jVar.field_fullpath, jVar.hvu, jVar.huZ, jVar.initialDownloadOffset, jVar.initialDownloadLength, jVar.isColdSnsData, jVar.signalQuality, jVar.snsScene, jVar.field_preloadRatio);
                                }
                                b = i;
                            }
                        } else {
                            b = -1;
                        }
                    }
                    if (b != 0) {
                        x.e("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia error:%d clientid:%s", Integer.valueOf(b), iVar.field_mediaId);
                        if (iVar.hve != null) {
                            iVar.hve.a(iVar.field_mediaId, b, null, null, iVar.field_onlycheckexist);
                        }
                    } else {
                        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn startupDownloadMedia ok, field_mediaId[%s]", iVar.field_mediaId);
                        aVar.huf.put(iVar.field_mediaId, iVar);
                    }
                }
            }
        }

        public final String toString() {
            return super.toString() + "|addRecvTask";
        }
    }

    static /* synthetic */ boolean a(keep_ProgressInfo keep_progressinfo) {
        return keep_progressinfo == null || keep_progressinfo.field_finishedLength == keep_progressinfo.field_toltalLength;
    }

    public static synchronized a aAA() {
        a aVar;
        synchronized (a.class) {
            if (lwP == null) {
                lwP = new a();
            }
            aVar = lwP;
        }
        return aVar;
    }

    public final int d(i iVar) {
        if (bi.oN(iVar.field_mediaId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId is null");
            return -1;
        }
        if (iVar.field_fileId == null) {
            iVar.field_fileId = "";
        }
        if (iVar.field_aesKey == null) {
            iVar.field_aesKey = "";
        }
        if (this.hud.contains(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in queueTask");
            return -2;
        } else if (this.hue.containsKey(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapWaitTask");
            return -2;
        } else if (this.huf.containsKey(iVar.field_fileId)) {
            x.e("MicroMsg.CdnDownloadNativeService", "addRecvTask mediaId  exists in mapTaskInJni");
            return -2;
        } else {
            iVar.fMC = false;
            this.gSq.F(new AnonymousClass1(-1, iVar));
            return 0;
        }
    }

    public static boolean yj(String str) {
        x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn cdntra pauseRecvTask mediaid:%s, ret:%d", str, Integer.valueOf(CdnLogic.pauseHttpMultiSocketDownloadTask(str)));
        if (CdnLogic.pauseHttpMultiSocketDownloadTask(str) == 0) {
            return true;
        }
        return false;
    }

    public final int a(final String str, final keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback mediaid is null");
            return -1;
        } else if (keep_progressinfo == null && keep_sceneresult == null) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback info all null");
            return -2;
        } else {
            if (keep_progressinfo != null) {
                x.d("MicroMsg.CdnDownloadNativeService", "CDN progress. total:%d, cur:%d, canshow:%b", Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength), Boolean.valueOf(keep_progressinfo.field_mtlnotify));
            }
            this.hui = bi.Wy();
            this.huh = str;
            this.gSq.F(new Runnable() {
                public final void run() {
                    i iVar = (i) a.this.huf.get(str);
                    if (iVar == null) {
                        x.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str);
                        return;
                    }
                    if (keep_progressinfo != null) {
                        keep_progressinfo.mediaId = str;
                        x.i("MicroMsg.CdnDownloadNativeService", "MTL: total:%d, cur:%d, mtl:%b", Integer.valueOf(keep_progressinfo.field_toltalLength), Integer.valueOf(keep_progressinfo.field_finishedLength), Boolean.valueOf(keep_progressinfo.field_mtlnotify));
                    }
                    if (keep_sceneresult != null) {
                        keep_sceneresult.mediaId = str;
                    }
                    if (iVar.hve != null) {
                        long Wy = bi.Wy();
                        if (keep_sceneresult != null || keep_progressinfo == null || keep_progressinfo.field_mtlnotify || ao.getNetWorkType(ad.getContext()) != -1) {
                            iVar.field_lastProgressCallbackTime = Wy;
                            iVar.hve.a(str, 0, keep_progressinfo, keep_sceneresult, iVar.field_onlycheckexist);
                        } else {
                            return;
                        }
                    }
                    if (a.a(keep_progressinfo)) {
                        a.this.hug.remove(str);
                    }
                    if (keep_sceneresult != null) {
                        a.this.huf.remove(str);
                        if (keep_sceneresult.field_retCode == -5103011) {
                            x.i("MicroMsg.CdnDownloadNativeService", "summersafecdn ERR_VALIDATE_AUTHKEY");
                            g.pWK.a(546, 4, 1, true);
                            a.this.lwQ.keep_OnRequestDoGetCdnDnsInfo(999);
                        }
                    }
                }

                public final String toString() {
                    return super.toString() + "|callback";
                }
            });
            return 0;
        }
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback getauthbuf mediaid is null");
            return;
        }
        i iVar = (i) this.huf.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " getauthbuf task in jni get info failed mediaid:%s", str);
        } else if (iVar.hve != null) {
            iVar.hve.a(str, byteArrayOutputStream);
        } else {
            x.e("MicroMsg.CdnDownloadNativeService", "getCdnAuthInfo fail, null taskcallback.");
        }
    }

    public final byte[] h(String str, byte[] bArr) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CdnDownloadNativeService", "cdn callback decodePrepareResponse mediaid is null");
            return null;
        }
        i iVar = (i) this.huf.get(str);
        if (iVar == null) {
            x.e("MicroMsg.CdnDownloadNativeService", " decodePrepareResponse task in jni get info failed mediaid:%s", str);
            return null;
        } else if (iVar.hve != null) {
            return iVar.hve.h(str, bArr);
        } else {
            x.e("MicroMsg.CdnDownloadNativeService", "decodePrepareResponse fail, null taskcallback.");
            return null;
        }
    }

    public final void b(final String str, final keep_SceneResult keep_sceneresult) {
        if (!bi.oN(str)) {
            this.gSq.F(new Runnable() {
                public final void run() {
                    i iVar = (i) a.this.huf.get(str);
                    if (iVar == null) {
                        x.e("MicroMsg.CdnDownloadNativeService", " task in jni get info failed mediaid:%s", str);
                    } else if (iVar.hvq != null) {
                        iVar.hvq.b(str, keep_sceneresult);
                    }
                }
            });
        }
    }
}
