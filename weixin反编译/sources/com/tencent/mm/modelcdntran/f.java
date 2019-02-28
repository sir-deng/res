package com.tencent.mm.modelcdntran;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.jk;
import com.tencent.mm.f.a.la;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.w;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class f implements e, a {
    Map<String, j> huJ = new HashMap();
    Map<String, keep_SceneResult> huK = new HashMap();
    Queue<String> hud = new LinkedList();
    Map<String, j> hue = new HashMap();
    Map<String, j> huf = new HashMap();

    public f() {
        g.CN().a(379, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 379) {
            x.i("MicroMsg.OnlineVideoService", "it get cdn dns success[%d, %d], try to start.", Integer.valueOf(i), Integer.valueOf(i2));
            if (g.Do().CF()) {
                g.Dt().F(new Runnable() {
                    public final void run() {
                        f.this.bL(true);
                    }
                });
            }
        }
    }

    public final boolean a(final j jVar, boolean z) {
        if (jVar == null) {
            x.e("MicroMsg.OnlineVideoService", "add download task, but task is null.");
            return false;
        } else if (bi.oN(jVar.field_mediaId)) {
            x.e("MicroMsg.OnlineVideoService", "add download task, but task mediaId is null.");
            return false;
        } else {
            x.i("MicroMsg.OnlineVideoService", "add download task : " + jVar.field_mediaId + " delay : " + z);
            if (jVar.field_fileId == null) {
                jVar.field_fileId = "";
            }
            if (jVar.field_aesKey == null) {
                jVar.field_aesKey = "";
            }
            jVar.fMC = false;
            if (b(jVar.field_mediaId, null) || z) {
                g.Dt().F(new Runnable() {
                    public final void run() {
                        f.this.hud.add(jVar.field_mediaId);
                        f.this.hue.put(jVar.field_mediaId, jVar);
                        f.this.bL(false);
                    }
                });
            } else {
                g.Dt().F(new Runnable() {
                    public final void run() {
                        f.this.hud.add(jVar.field_mediaId);
                        f.this.hue.put(jVar.field_mediaId, jVar);
                        f.this.bL(false);
                    }
                });
            }
            return true;
        }
    }

    public final boolean b(final String str, final Object[] objArr) {
        boolean z = false;
        if (!bi.oN(str)) {
            if (this.huf.containsKey(str)) {
                z = true;
            } else {
                g.MP().kL(str);
            }
            g.Dt().F(new Runnable() {
                public final void run() {
                    j jVar = (j) f.this.huf.remove(str);
                    keep_SceneResult keep_sceneresult;
                    if (jVar != null) {
                        keep_sceneresult = new keep_SceneResult();
                        if (g.MQ().a(jVar.field_mediaId, keep_sceneresult) == 0) {
                            f.a(objArr, keep_sceneresult, jVar, false);
                        } else {
                            x.w("MicroMsg.OnlineVideoService", "stop video stream download error. ret %d, mediaId %s", Integer.valueOf(g.MQ().a(jVar.field_mediaId, keep_sceneresult)), jVar.field_mediaId);
                        }
                    } else {
                        jVar = (j) f.this.huJ.remove(str);
                        keep_sceneresult = (keep_SceneResult) f.this.huK.remove(str);
                        if (!(jVar == null || keep_sceneresult == null)) {
                            f.a(objArr, keep_sceneresult, jVar, true);
                        }
                    }
                    f.this.hue.remove(str);
                }
            });
        }
        x.i("MicroMsg.OnlineVideoService", "cancelDownloadTask mediaId : " + str + " remove : " + z);
        return z;
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (((j) this.huf.get(str)) == null) {
            x.i("MicroMsg.OnlineVideoService", "this media[%s] don't download now.", str);
            return false;
        }
        g.MQ();
        x.i("MicroMsg.OnlineVideoService", "is video[%s] data[%d, %d] available[%b]", str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(b.isVideoDataAvailable(str, i, i2)));
        return b.isVideoDataAvailable(str, i, i2);
    }

    public static int f(String str, int i, int i2) {
        g.MQ();
        x.i("MicroMsg.OnlineVideoService", "request video video[%s], offset[%d], length[%d] duration[%d] ret[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0), Integer.valueOf(b.requestVideoData(str, i, i2, 0)));
        return b.requestVideoData(str, i, i2, 0);
    }

    public final void bL(boolean z) {
        if (g.Do().CF()) {
            if (!z && g.MQ().MJ()) {
                g.Do();
                if (a.CE()) {
                    x.w("MicroMsg.OnlineVideoService", "cdn engine not init cdn dnsinfo , will retry after set info");
                    g.MP().bL(z);
                    return;
                }
            }
            c.MK();
            while (!this.hud.isEmpty()) {
                String str = (String) this.hud.poll();
                i iVar = (j) this.hue.remove(str);
                if (iVar != null) {
                    iVar.field_startTime = bi.Wy();
                    if (!iVar.fMC) {
                        Object obj;
                        b laVar;
                        int a;
                        boolean MT;
                        int i;
                        r nJ;
                        int i2;
                        if (((Integer) g.Dq().Db().get(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                            x.i("MicroMsg.OnlineVideoService", "command set do not check media duplication.");
                        } else if (!iVar.MU()) {
                            String str2 = iVar.hvs;
                            int i3 = iVar.hvt;
                            String df = ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().df(str2, i3);
                            int bN = i3 - com.tencent.mm.a.e.bN(df);
                            if (!bi.oN(df) && bN >= 0 && bN <= 16) {
                                x.i("MicroMsg.OnlineVideoService", "it had download this video[%d, %s, %s].", Integer.valueOf(i3), str2, df);
                                com.tencent.mm.sdk.platformtools.k.fv(df, iVar.field_fullpath);
                                r nJ2 = t.nJ(iVar.filename);
                                a(nJ2, i3, str2);
                                cg dI = ((h) g.h(h.class)).aZO().dI((long) nJ2.hXw);
                                ((h) g.h(h.class)).aZO().a(new c(dI.field_talker, "update", dI));
                                obj = 1;
                                if (obj == null) {
                                    laVar = new la();
                                    laVar.fDe.fvG = 6;
                                    laVar.fDe.mediaId = str;
                                    com.tencent.mm.sdk.b.a.xmy.m(laVar);
                                } else {
                                    if (iVar.MT()) {
                                        g.MQ();
                                        a = b.a(iVar, iVar.hvu);
                                    } else if (iVar.MS()) {
                                        if ((iVar.hvp != 3 ? 1 : null) == null) {
                                            g.MQ();
                                            a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hvu, iVar.field_preloadRatio, iVar.concurrentCount);
                                        } else {
                                            g.MQ();
                                            a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hvu, iVar.huZ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.field_preloadRatio);
                                        }
                                    } else {
                                        g.MQ();
                                        a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hvu, iVar.huZ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.isColdSnsData, iVar.signalQuality, iVar.snsScene, iVar.field_preloadRatio);
                                    }
                                    x.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", iVar, Integer.valueOf(a));
                                    if (a == 0) {
                                        x.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + iVar.field_mediaId);
                                        MT = iVar.MT();
                                        i = iVar.hvu;
                                        if (MT) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 210, 1, false);
                                            if (i != 1) {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 211, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 212, 1, false);
                                            }
                                            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(200), Long.valueOf(bi.Wx()), "");
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 3, 1, false);
                                            if (i != 1) {
                                                if (a == -21006) {
                                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 100, 1, false);
                                                } else if (a != -20003) {
                                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 101, 1, false);
                                                } else {
                                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 102, 1, false);
                                                }
                                            } else if (a == -21006) {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 106, 1, false);
                                            } else if (a != -20003) {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 107, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 108, 1, false);
                                            }
                                            com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(100), Long.valueOf(bi.Wx()), "");
                                        }
                                    } else {
                                        iVar.hvr = bi.Wy();
                                        if (iVar.MT()) {
                                            nJ = t.nJ(iVar.filename);
                                            if (nJ != null) {
                                                i2 = nJ.status;
                                                if (!(i2 == 120 || i2 == 122 || i2 == 121)) {
                                                    nJ.status = 120;
                                                    nJ.fEo = 256;
                                                    o.Ub().b(nJ);
                                                }
                                            }
                                        }
                                        this.huf.put(iVar.field_mediaId, iVar);
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                            if (iVar.MT()) {
                                g.MQ();
                                a = b.a(iVar, iVar.hvu);
                            } else if (iVar.MS()) {
                                if (iVar.hvp != 3) {
                                }
                                if ((iVar.hvp != 3 ? 1 : null) == null) {
                                    g.MQ();
                                    a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hvu, iVar.huZ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.field_preloadRatio);
                                } else {
                                    g.MQ();
                                    a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hvu, iVar.field_preloadRatio, iVar.concurrentCount);
                                }
                            } else {
                                g.MQ();
                                a = b.a(iVar.field_mediaId, iVar.url, iVar.referer, iVar.field_fullpath, iVar.hvu, iVar.huZ, iVar.initialDownloadOffset, iVar.initialDownloadLength, iVar.isColdSnsData, iVar.signalQuality, iVar.snsScene, iVar.field_preloadRatio);
                            }
                            x.i("MicroMsg.OnlineVideoService", "start task %s streaming download. ret %d ", iVar, Integer.valueOf(a));
                            if (a == 0) {
                                iVar.hvr = bi.Wy();
                                if (iVar.MT()) {
                                    nJ = t.nJ(iVar.filename);
                                    if (nJ != null) {
                                        i2 = nJ.status;
                                        nJ.status = 120;
                                        nJ.fEo = 256;
                                        o.Ub().b(nJ);
                                    }
                                }
                                this.huf.put(iVar.field_mediaId, iVar);
                            } else {
                                x.w("MicroMsg.OnlineVideoService", "start stream video error. ret : " + a + " media id: " + iVar.field_mediaId);
                                MT = iVar.MT();
                                i = iVar.hvu;
                                if (MT) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 210, 1, false);
                                    if (i != 1) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 212, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 211, 1, false);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(200), Long.valueOf(bi.Wx()), "");
                                } else {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 3, 1, false);
                                    if (i != 1) {
                                        if (a == -21006) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 106, 1, false);
                                        } else if (a != -20003) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 108, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 107, 1, false);
                                        }
                                    } else if (a == -21006) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 100, 1, false);
                                    } else if (a != -20003) {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 102, 1, false);
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 101, 1, false);
                                    }
                                    com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(100), Long.valueOf(bi.Wx()), "");
                                }
                            }
                        } else {
                            laVar = new la();
                            laVar.fDe.fvG = 6;
                            laVar.fDe.mediaId = str;
                            com.tencent.mm.sdk.b.a.xmy.m(laVar);
                        }
                    }
                }
            }
        }
    }

    public final void onMoovReady(final String str, final int i, final int i2) {
        x.i("MicroMsg.OnlineVideoService", "onMoovReady mediaId[%s]", str);
        if (!bi.oN(str)) {
            g.Dt().F(new Runnable() {
                public final void run() {
                    boolean z = false;
                    j jVar = (j) f.this.huf.get(str);
                    if (jVar != null) {
                        jVar.hvA = (long) i;
                        if (jVar.hvB != null) {
                            jVar.hvB.onMoovReady(str, i, i2);
                        } else if (q.nq(jVar.field_fullpath)) {
                            x.w("MicroMsg.OnlineVideoService", "it is qt video, need finish all file. isPlayMode" + jVar.hvu);
                            if (jVar.hvu == 1) {
                                f.f(jVar.field_mediaId, 0, jVar.field_totalLen);
                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 19, 1, false);
                            }
                        } else {
                            b laVar = new la();
                            laVar.fDe.fvG = 1;
                            laVar.fDe.retCode = 0;
                            laVar.fDe.mediaId = str;
                            laVar.fDe.offset = i;
                            laVar.fDe.length = i2;
                            laVar.fDe.fDf = jVar.hvr;
                            la.a aVar = laVar.fDe;
                            if (jVar.initialDownloadLength > 0) {
                                z = true;
                            }
                            aVar.fDg = z;
                            com.tencent.mm.sdk.b.a.xmy.m(laVar);
                            r nJ = t.nJ(jVar.filename);
                            if (nJ != null) {
                                x.i("MicroMsg.OnlineVideoService", "on moov ready info: " + nJ.getFileName() + " status : " + nJ.status);
                                if (nJ.status != 130 && nJ.status != 122) {
                                    nJ = t.nJ(jVar.filename);
                                    if (nJ != null) {
                                        nJ.status = 121;
                                        nJ.fEo = 256;
                                        o.Ub().b(nJ);
                                    }
                                    if (jVar.hvu == 0) {
                                        x.i("MicroMsg.OnlineVideoService", "stop download video");
                                        o.Ug().Uz();
                                        o.Ug().run();
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public final void onDataAvailable(final String str, final int i, final int i2) {
        x.i("MicroMsg.OnlineVideoService", "onDataAvailable. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!bi.oN(str)) {
            g.Dt().F(new Runnable() {
                public final void run() {
                    j jVar = (j) f.this.huf.get(str);
                    if (jVar != null) {
                        if (jVar.hvB != null) {
                            jVar.hvB.onDataAvailable(str, i, i2);
                        }
                        b laVar = new la();
                        laVar.fDe.fvG = 2;
                        laVar.fDe.retCode = 0;
                        laVar.fDe.mediaId = str;
                        laVar.fDe.offset = i;
                        laVar.fDe.length = i2;
                        com.tencent.mm.sdk.b.a.xmy.m(laVar);
                    }
                }
            });
        }
    }

    public final void onDownloadToEnd(final String str, final int i, final int i2) {
        x.i("MicroMsg.OnlineVideoService", "onDownloadToEnd. offset %d, length %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (!bi.oN(str)) {
            g.Dt().F(new Runnable() {
                public final void run() {
                    j jVar = (j) f.this.huf.get(str);
                    if (jVar != null) {
                        b laVar = new la();
                        laVar.fDe.fvG = 3;
                        laVar.fDe.retCode = 0;
                        laVar.fDe.mediaId = str;
                        laVar.fDe.offset = i;
                        laVar.fDe.length = i2;
                        com.tencent.mm.sdk.b.a.xmy.m(laVar);
                        if (i == 0 && i2 >= jVar.hvt) {
                            f.a(t.nJ(jVar.filename), jVar.hvt, jVar.hvs);
                        }
                    }
                }
            });
        }
    }

    public final int a(final String str, final keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult) {
        if (bi.oN(str)) {
            x.e("MicroMsg.OnlineVideoService", "cdn callback mediaid is null.");
            return -1;
        } else if (keep_progressinfo == null && keep_sceneresult == null) {
            x.e("MicroMsg.OnlineVideoService", "cdn callback info all null.");
            return -2;
        } else {
            g.Dt().F(new Runnable() {
                public final void run() {
                    j jVar = (j) f.this.huf.get(str);
                    if (jVar != null) {
                        if (jVar.hvB == null) {
                            r nJ = t.nJ(jVar.filename);
                            b laVar;
                            if (nJ == null) {
                                x.w("MicroMsg.OnlineVideoService", "stream download video callback, but video info is null.[%s]", jVar.filename);
                            } else if (jVar.hve != null) {
                                jVar.hve.a(str, 0, keep_progressinfo, keep_sceneresult, jVar.field_onlycheckexist);
                                if (keep_sceneresult != null) {
                                    f.this.huf.remove(str);
                                }
                            } else if (keep_progressinfo != null) {
                                if (keep_progressinfo.field_finishedLength == nJ.hmZ) {
                                    x.i("MicroMsg.OnlineVideoService", "stream download finish.");
                                } else if (nJ.status == 130 || nJ.hXp <= keep_progressinfo.field_finishedLength) {
                                    x.i("MicroMsg.OnlineVideoService", "callback progress info " + keep_progressinfo.field_finishedLength);
                                    nJ.hXt = bi.Wx();
                                    nJ.hXp = keep_progressinfo.field_finishedLength;
                                    nJ.fEo = 1040;
                                    t.e(nJ);
                                    laVar = new la();
                                    laVar.fDe.fvG = 5;
                                    laVar.fDe.mediaId = str;
                                    laVar.fDe.offset = keep_progressinfo.field_finishedLength;
                                    laVar.fDe.length = keep_progressinfo.field_toltalLength;
                                    com.tencent.mm.sdk.b.a.xmy.m(laVar);
                                } else {
                                    x.w("MicroMsg.OnlineVideoService", "set video error. db now size %d, cdn callback %d.", Integer.valueOf(nJ.hXp), Integer.valueOf(keep_progressinfo.field_finishedLength));
                                }
                            } else if (keep_sceneresult != null) {
                                x.i("MicroMsg.OnlineVideoService", "callback result info " + keep_sceneresult.field_retCode + ", filesize:" + keep_sceneresult.field_fileLength + ",recved:" + keep_sceneresult.field_recvedBytes);
                                if (keep_sceneresult.field_retCode != 0) {
                                    if (keep_sceneresult.field_retCode != -10012) {
                                        t.nC(nJ.getFileName());
                                    }
                                    boolean MT = jVar.MT();
                                    int i = keep_sceneresult.field_retCode;
                                    int i2 = jVar.hvu;
                                    if (MT) {
                                        if (i2 == 1) {
                                            if (i == -5103059) {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 111, 1, false);
                                            } else if (i == -5103087) {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 112, 1, false);
                                            } else if (i == -10012) {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 113, 1, false);
                                            } else {
                                                com.tencent.mm.plugin.report.service.g.pWK.a(354, 114, 1, false);
                                            }
                                        } else if (i == -5103059) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 116, 1, false);
                                        } else if (i == -5103087) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 117, 1, false);
                                        } else if (i == -10012) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 118, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 119, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(101), Long.valueOf(bi.Wx()), Integer.valueOf(i));
                                    } else {
                                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 213, 1, false);
                                        if (i2 == 1) {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 214, 1, false);
                                        } else {
                                            com.tencent.mm.plugin.report.service.g.pWK.a(354, 215, 1, false);
                                        }
                                        com.tencent.mm.plugin.report.service.g.pWK.h(13836, Integer.valueOf(201), Long.valueOf(bi.Wx()), Integer.valueOf(i));
                                    }
                                } else {
                                    f.a(nJ, keep_sceneresult.field_fileLength, jVar.hvs);
                                    f.this.huJ.put(jVar.field_mediaId, jVar);
                                    f.this.huK.put(jVar.field_mediaId, keep_sceneresult);
                                }
                                laVar = new la();
                                laVar.fDe.fvG = 4;
                                laVar.fDe.mediaId = str;
                                laVar.fDe.offset = 0;
                                laVar.fDe.retCode = keep_sceneresult.field_retCode;
                                laVar.fDe.length = keep_sceneresult.field_fileLength;
                                com.tencent.mm.sdk.b.a.xmy.m(laVar);
                                f.this.huf.remove(str);
                            }
                        } else if (keep_progressinfo != null) {
                            jVar.hvB.g(str, keep_progressinfo.field_finishedLength, keep_progressinfo.field_toltalLength);
                        } else if (keep_sceneresult != null) {
                            jVar.hvB.K(str, keep_sceneresult.field_retCode);
                            f.this.huf.remove(str);
                        }
                    }
                }
            });
            if (this.huf.get(str) != null) {
                return 1;
            }
            return 0;
        }
    }

    static void a(r rVar, int i, String str) {
        x.i("MicroMsg.OnlineVideoService", "download finish. totalLen %d ", Integer.valueOf(i));
        if (rVar != null) {
            t.X(rVar.getFileName(), i);
            String fileName = rVar.getFileName();
            if (!bi.oN(str)) {
                o.Ub();
                String nx = s.nx(fileName);
                if (bi.oN(str) || i <= 0 || bi.oN(nx)) {
                    x.w("MicroMsg.OnlineVideoService", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, nx);
                    return;
                }
                ((com.tencent.mm.plugin.r.a.a) g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().z(str, i, nx);
            }
        }
    }

    public static j a(an anVar, String str, String str2, String str3, int i) {
        if (anVar == null) {
            x.w("MicroMsg.OnlineVideoService", "check can sns online video, scene is null.");
            return null;
        } else if (bi.oN(str)) {
            x.w("MicroMsg.OnlineVideoService", "check can sns online video, url is null.");
            return null;
        } else {
            r nJ = t.nJ(str3);
            if (nJ == null) {
                x.w("MicroMsg.OnlineVideoService", "check can sns online video, video info is null. %s", str3);
                return null;
            }
            String a = d.a("snsvideo", (long) anVar.time, "sns", str);
            if (bi.oN(a)) {
                x.w("MicroMsg.OnlineVideoService", "check can http online video, can not create media id. url %s ", str);
                return null;
            }
            j jVar = new j();
            jVar.filename = str3;
            jVar.field_fullpath = str2;
            jVar.field_mediaId = a;
            jVar.hvp = 2;
            jVar.hvu = i;
            jVar.hvw = nJ.hvw;
            String str4 = "";
            if (anVar == null) {
                a = "";
            } else if (anVar.equals(an.xHq)) {
                a = "album_friend";
            } else if (anVar.equals(an.xHr)) {
                a = "album_self";
            } else if (anVar.equals(an.xHs)) {
                a = "album_stranger";
            } else if (anVar.equals(an.xHt)) {
                a = "profile_friend";
            } else if (anVar.equals(an.xHu)) {
                a = "profile_stranger";
            } else if (anVar.equals(an.xHv)) {
                a = FFmpegMetadataRetriever.METADATA_KEY_COMMENT;
            } else if (anVar.equals(an.xHp)) {
                a = "timeline";
            } else if (anVar.equals(an.xHy)) {
                a = "snssight";
            } else {
                a = str4;
            }
            String str5 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
            r3 = new Object[5];
            g.Dr();
            g.Do();
            r3[1] = com.tencent.mm.a.o.getString(a.Cn());
            r3[2] = Integer.valueOf(ao.getNetTypeForStat(ad.getContext()));
            r3[3] = Integer.valueOf(ao.getStrength(ad.getContext()));
            r3[4] = !bi.oN(a) ? "&scene=" + a : "";
            jVar.referer = String.format(str5, r3);
            jVar.url = str;
            long j = (long) ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("SnsSightMainStandbyIpSwitchTime", 0);
            x.i("MicroMsg.OnlineVideoService", "hostvalue %s dcipTime %s scene.time[%d]", ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("SnsSightDomainList"), Long.valueOf(j), Integer.valueOf(anVar.time));
            if (j <= 0) {
                j = 259200;
            }
            boolean a2 = a(anVar, jVar.url, j, r5);
            try {
                jVar.host = new URL(jVar.url).getHost();
                List arrayList = new ArrayList();
                com.tencent.mm.network.b.a(a2, arrayList, jVar.host);
                jVar.huZ = new String[arrayList.size()];
                arrayList.toArray(jVar.huZ);
                jVar.isColdSnsData = bi.bz((long) anVar.time) > j;
                jVar.signalQuality = ao.getStrength(ad.getContext());
                jVar.snsScene = a;
                return jVar;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.OnlineVideoService", e, "check can sns online video error taskInfo %s", jVar);
                return null;
            }
        }
    }

    private static boolean a(an anVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (anVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || anVar.time == 0 || bi.bz((long) anVar.time) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoService", "error for check dcip %s", e.getMessage());
            return false;
        }
    }

    public static void a(Object[] objArr, keep_SceneResult keep_sceneresult, j jVar, boolean z) {
        if (jVar == null || keep_sceneresult == null) {
            x.w("MicroMsg.OnlineVideoService", "video task info is null or download result is null.");
        } else if (jVar.MS() || jVar.MT()) {
            r nJ;
            String str;
            int intValue;
            int intValue2;
            int intValue3;
            int intValue4;
            int intValue5;
            int intValue6;
            int i;
            int i2;
            int i3;
            String str2;
            String str3 = keep_sceneresult.field_clientIP;
            x.i("MicroMsg.OnlineVideoService", "rpt online video format[%d] clientIp[%s] isCrossNet[%d]", Integer.valueOf(keep_sceneresult.field_videoFormat), str3, Integer.valueOf(keep_sceneresult.field_isCrossNet ? 1 : 0));
            if (keep_sceneresult.field_videoFormat == 2) {
                nJ = t.nJ(jVar.filename);
                if (nJ != null) {
                    nJ.videoFormat = 2;
                    nJ.fEo = 2;
                    boolean b = o.Ub().b(nJ);
                    x.i("MicroMsg.VideoLogic", "set VideoFormat ret[%b] filename[%s] format[%d]", Boolean.valueOf(b), str, Integer.valueOf(2));
                }
            }
            if (bi.oN(str3)) {
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 45, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 46, 1, false);
            }
            if (keep_sceneresult.field_isCrossNet) {
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 47, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 48, 1, false);
            }
            boolean MT = jVar.MT();
            PInt pInt = new PInt();
            PInt pInt2 = new PInt();
            pInt2.value = 0;
            pInt.value = 0;
            t.a(jVar.field_fullpath, pInt, pInt2);
            int i4 = pInt.value * 1000;
            int i5 = pInt2.value;
            int i6 = 0;
            if (objArr != null) {
                intValue = ((Integer) objArr[0]).intValue() * 1000;
                intValue2 = ((Integer) objArr[1]).intValue();
                intValue3 = ((Integer) objArr[2]).intValue();
                intValue4 = ((Integer) objArr[3]).intValue();
                intValue5 = ((Integer) objArr[4]).intValue();
                intValue6 = ((Integer) objArr[5]).intValue();
                i6 = ((Integer) objArr[6]).intValue();
            } else {
                intValue5 = 0;
                intValue4 = 0;
                intValue3 = 0;
                intValue2 = 0;
                intValue = 0;
                intValue6 = 0;
            }
            int i7 = jVar.hvw;
            if (i7 <= 0) {
                if (MT) {
                    i7 = 10;
                } else {
                    i7 = 31;
                }
            }
            int eR = ao.eR(ad.getContext());
            String rptIpList = keep_sceneresult.getRptIpList();
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            String str4 = jVar.filename;
            int i8 = jVar.hvz;
            r nJ2 = t.nJ(str4);
            if (nJ2 != null) {
                i = nJ2.fAP;
                i2 = nJ2.hmZ;
                i3 = i;
                i = i2;
            } else {
                i3 = 0;
                i = 0;
            }
            if (i8 <= 0) {
                i2 = 1;
            } else {
                i2 = i3 < ((int) ((((float) i8) / 100.0f) * ((float) i))) ? 2 : 3;
                x.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo %d * %d = configSize[%d] preloadSize[%d]", Integer.valueOf(i8), Integer.valueOf(i), Integer.valueOf((int) ((((float) i8) / 100.0f) * ((float) i))), Integer.valueOf(i3));
            }
            pInt3.value = i3;
            pInt4.value = i2;
            x.d("MicroMsg.OnlineVideoService", "getPreloadVideoInfo pHadPreloadSize[%d] pHadPreloadCompletion[%d]", Integer.valueOf(pInt3.value), Integer.valueOf(pInt4.value));
            StringBuffer stringBuffer = new StringBuffer();
            if (MT) {
                stringBuffer.append(jVar.field_fileId).append(",").append(jVar.field_aesKey).append(",");
            } else {
                stringBuffer.append(jVar.url).append(",").append(jVar.hvx).append(",");
            }
            stringBuffer.append(keep_sceneresult.field_fileLength).append(",").append(i4).append(",");
            stringBuffer.append(keep_sceneresult.field_recvedBytes).append(",");
            stringBuffer.append(intValue + ",").append(intValue2 + ",").append(intValue3 + ",");
            stringBuffer.append(intValue4 + ",").append(intValue5 + ",");
            stringBuffer.append(eR).append(",");
            stringBuffer.append(i7).append(",");
            stringBuffer.append(keep_sceneresult.field_startTime).append(",");
            stringBuffer.append(keep_sceneresult.field_endTime).append(",");
            if (MT) {
                stringBuffer.append(jVar.hvv != null ? com.tencent.mm.a.g.s(jVar.hvv.getBytes()) : Integer.valueOf(0)).append(",");
                stringBuffer.append(com.tencent.mm.y.s.eX(jVar.hvv) ? 1 : 0).append(",");
            } else {
                stringBuffer.append(0).append(",");
                stringBuffer.append(keep_sceneresult.field_httpStatusCode).append(",");
            }
            stringBuffer.append(keep_sceneresult.field_retCode).append(",");
            stringBuffer.append(keep_sceneresult.field_enQueueTime).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestCost).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestSize).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestDownloadSize).append(",");
            stringBuffer.append(keep_sceneresult.field_firstRequestCompleted ? 1 : 0).append(",");
            stringBuffer.append(keep_sceneresult.field_averageSpeed).append(",");
            stringBuffer.append(keep_sceneresult.field_averageConnectCost).append(",");
            stringBuffer.append(keep_sceneresult.field_firstConnectCost).append(",");
            stringBuffer.append(keep_sceneresult.field_netConnectTimes).append(",");
            stringBuffer.append(keep_sceneresult.field_moovRequestTimes).append(",");
            stringBuffer.append(keep_sceneresult.field_moovCost).append(",");
            stringBuffer.append(keep_sceneresult.field_moovSize).append(",");
            stringBuffer.append(keep_sceneresult.field_moovCompleted ? 1 : 0).append(",");
            stringBuffer.append(keep_sceneresult.field_moovFailReason).append(",");
            stringBuffer.append(intValue6).append(",");
            stringBuffer.append(i6).append(",");
            if (MT) {
                stringBuffer.append(i5).append(",");
            } else {
                stringBuffer.append(i5).append(",");
                stringBuffer.append(jVar.hvv != null ? com.tencent.mm.a.g.s(jVar.hvv.getBytes()) : Integer.valueOf(0)).append(",");
            }
            stringBuffer.append(rptIpList).append(",");
            if (MT) {
                stringBuffer.append(jVar.hvy).append(",");
                stringBuffer.append(jVar.fGj).append(",");
                stringBuffer.append(jVar.initialDownloadLength).append(",");
                stringBuffer.append(keep_sceneresult.field_videoFormat).append(",");
            } else {
                stringBuffer.append(jVar.fAR).append(",");
            }
            stringBuffer.append(str3).append(",");
            stringBuffer.append(r11).append(",");
            stringBuffer.append(jVar.hvA).append(",");
            stringBuffer.append(pInt3.value).append(",");
            stringBuffer.append(pInt4.value);
            x.i("MicroMsg.OnlineVideoService", "report online video %d:%s", Integer.valueOf(MT ? 13570 : 13790), stringBuffer.toString());
            com.tencent.mm.plugin.report.service.g.pWK.k(i6, str2);
            if (z) {
                str = jVar.fAJ;
                str2 = jVar.hvv;
                intValue5 = jVar.fAL;
                String str5 = keep_sceneresult.field_fileId;
                long j = keep_sceneresult.field_startTime;
                long j2 = keep_sceneresult.field_endTime;
                String str6 = jVar.field_fullpath;
                String[] strArr = keep_sceneresult.field_usedSvrIps;
                String str7 = jVar.url;
                i3 = pInt3.value;
                int i9 = pInt4.value;
                String str8 = jVar.fAR;
                b jkVar = new jk();
                jkVar.fAI.fAJ = str;
                jkVar.fAI.fAK = str2;
                jkVar.fAI.fAL = intValue5;
                jkVar.fAI.fAM = str5;
                jkVar.fAI.netType = eR;
                jkVar.fAI.startTime = j;
                jkVar.fAI.endTime = j2;
                jkVar.fAI.path = str6;
                jkVar.fAI.fAN = strArr;
                jkVar.fAI.fAO = str7;
                jkVar.fAI.fAP = i3;
                jkVar.fAI.fAQ = i9;
                jkVar.fAI.fAR = str8;
                com.tencent.mm.sdk.b.a.xmy.m(jkVar);
            }
            if (MT) {
                if (keep_sceneresult.field_videoFormat == 2) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 132, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 133, 1, false);
                }
                nJ = t.nJ(jVar.filename);
                if (nJ != null) {
                    cg dI = ((h) g.h(h.class)).aZO().dI((long) nJ.hXw);
                    ((h) g.h(h.class)).aZO().a(new c(dI.field_talker, "update", dI));
                }
            }
        }
    }
}
