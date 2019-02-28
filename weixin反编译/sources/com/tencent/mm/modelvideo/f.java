package com.tencent.mm.modelvideo;

import com.tencent.mm.a.e;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.b;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f {
    long frh;
    public String fsC;
    private com.tencent.mm.modelcdntran.i.a hDi = new com.tencent.mm.modelcdntran.i.a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
            if (i != 0) {
                x.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(i));
                if (f.this.hVY != null) {
                    f.this.hVY.a(f.this, false, 0, 0);
                }
            }
            if (keep_progressinfo != null) {
                x.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength), str);
            }
            if (keep_sceneresult != null) {
                x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(keep_sceneresult.field_retCode));
                if (keep_sceneresult.field_retCode == 0) {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", Integer.valueOf(f.this.hashCode()));
                    f.this.f(f.this.hVS, keep_sceneresult.field_fileLength, f.this.hvs);
                } else if (f.this.hVY != null) {
                    f.this.hVY.a(f.this, false, 0, 0);
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
    private j hVG;
    boolean hVR = false;
    String hVS;
    private long hVT;
    long hVU;
    long hVV;
    int hVW;
    private String hVX;
    public a hVY;
    private b hvq = new b() {
        public final void b(String str, keep_SceneResult keep_sceneresult) {
            if (keep_sceneresult == null) {
                x.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", Integer.valueOf(f.this.hashCode()));
                if (f.this.hVY != null) {
                    f.this.hVY.a(f.this, false, 0, 0);
                    return;
                }
                return;
            }
            int i = keep_sceneresult.field_recvedBytes;
            int i2 = keep_sceneresult.field_fileLength;
            x.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", Integer.valueOf(f.this.hashCode()), str, f.this.hVS, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(keep_sceneresult.field_videoFormat));
            if (i > 0 && i2 > 0) {
                f.this.hVV = (long) f.c(f.this.hVS, i, true);
            }
            if (f.this.hVY != null) {
                a aVar = f.this.hVY;
                f fVar = f.this;
                boolean z = i > 0 && i2 > 0;
                aVar.a(fVar, z, i, i2);
            }
            f.this.hVU = bi.Wx();
            f.this.nm(keep_sceneresult.getRptIpList());
            if (f.this.hVR) {
                g.pWK.a(354, 142, 1, false);
                if (f.this.hVW == 1) {
                    g.pWK.a(354, 123, 1, false);
                } else {
                    g.pWK.a(354, 124, 1, false);
                }
                g.pWK.a(354, (long) (keep_sceneresult.field_videoFormat + 240), 1, false);
                return;
            }
            g.pWK.a(354, 143, 1, false);
        }
    };
    String hvs;
    private String mediaId;

    public interface a {
        void a(f fVar, boolean z, int i, int i2);
    }

    public f(long j) {
        this.frh = j;
        this.hVR = true;
    }

    public f(j jVar, String str) {
        this.hVG = jVar;
        this.fsC = str;
        this.hVR = false;
    }

    public final String TT() {
        return this.hVR ? this.frh : this.fsC;
    }

    public final void stop() {
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.mediaId);
        if (!bi.oN(this.mediaId)) {
            keep_SceneResult keep_sceneresult = new keep_SceneResult();
            c MP = com.tencent.mm.modelcdntran.g.MP();
            String str = this.mediaId;
            int i = 0;
            if (((i) MP.huf.remove(str)) != null) {
                i = com.tencent.mm.modelcdntran.g.MQ().a(str, keep_sceneresult);
                g.pWK.h(10769, Integer.valueOf(d.huz), Integer.valueOf(r0.field_fileType), Long.valueOf(bi.Wy() - r0.field_startTime));
            }
            MP.hue.remove(str);
            MP.hug.remove(str);
            x.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(i));
            this.hVU = bi.Wx();
            this.hVV = (long) c(this.hVS, keep_sceneresult.field_recvedBytes, false);
            nm(keep_sceneresult.getRptIpList());
        }
        this.hVY = null;
    }

    public final int a(a aVar) {
        this.hVY = aVar;
        try {
            String str;
            String str2;
            i iVar;
            Object obj;
            x.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.frh));
            i iVar2;
            if (this.hVR) {
                cg dI = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().dI(this.frh);
                bb.b hW = bb.hW(dI.gkD);
                if (hW == null || hW.hiB <= 0) {
                    x.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", Integer.valueOf(hashCode()));
                    iVar2 = null;
                } else {
                    String str3 = dI.field_imgPath;
                    r nJ = t.nJ(str3);
                    if (nJ == null) {
                        iVar2 = null;
                    } else {
                        Map y = bj.y(nJ.Un(), "msg");
                        if (y == null) {
                            x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                            iVar2 = null;
                        } else {
                            str = (String) y.get(".msg.videomsg.$cdnvideourl");
                            if (bi.oN(str)) {
                                x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                                iVar2 = null;
                            } else {
                                int intValue = Integer.valueOf((String) y.get(".msg.videomsg.$length")).intValue();
                                String str4 = (String) y.get(".msg.videomsg.$md5");
                                str2 = (String) y.get(".msg.videomsg.$newmd5");
                                String str5 = (String) y.get(".msg.videomsg.$aeskey");
                                String str6 = (String) y.get(".msg.videomsg.$fileparam");
                                String a = d.a("downvideo", nJ.hXs, nJ.Uk(), nJ.getFileName());
                                if (bi.oN(a)) {
                                    x.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", nJ.getFileName());
                                    iVar2 = null;
                                } else {
                                    o.Ub();
                                    String nx = s.nx(str3);
                                    i jVar = new j();
                                    jVar.filename = str3;
                                    jVar.hvs = str4;
                                    jVar.hvt = intValue;
                                    jVar.hvu = 2;
                                    jVar.fAJ = nJ.Ul();
                                    jVar.hvv = nJ.Uk();
                                    jVar.fAL = s.eX(nJ.Uk()) ? m.gn(nJ.Uk()) : 0;
                                    jVar.field_mediaId = a;
                                    jVar.field_fullpath = nx;
                                    jVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
                                    jVar.field_totalLen = intValue;
                                    jVar.field_aesKey = str5;
                                    jVar.field_fileId = str;
                                    jVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                                    jVar.field_wxmsgparam = str6;
                                    jVar.field_chattype = s.eX(nJ.Uk()) ? 1 : 0;
                                    jVar.field_autostart = false;
                                    jVar.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, nJ);
                                    jVar.field_preloadRatio = hW.hiB;
                                    jVar.feA = str2;
                                    iVar2 = jVar;
                                }
                            }
                        }
                    }
                }
                if (iVar2 != null) {
                    this.hVW = s.eX(iVar2.hvv) ? 2 : 1;
                    g.pWK.a(354, 140, 1, false);
                    if (this.hVW == 1) {
                        g.pWK.a(354, 121, 1, false);
                    } else {
                        g.pWK.a(354, 122, 1, false);
                    }
                }
                if (this.hVG == null) {
                    this.hVG = iVar2;
                    iVar = iVar2;
                } else {
                    iVar = iVar2;
                }
            } else {
                this.hVW = 3;
                iVar2 = this.hVG;
                g.pWK.a(354, 141, 1, false);
                iVar = iVar2;
            }
            if (iVar == null) {
                x.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", Integer.valueOf(hashCode()));
                obj = null;
            } else {
                if (((Integer) com.tencent.mm.kernel.g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
                } else if (!iVar.MU()) {
                    str2 = iVar.hvs;
                    int i = iVar.hvt;
                    str = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().df(str2, i);
                    int bN = i - e.bN(str);
                    if (!bi.oN(str) && bN >= 0 && bN <= 16) {
                        x.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, str);
                        k.fv(str, iVar.field_fullpath);
                        f(iVar.filename, i, str2);
                        obj = 1;
                        if (obj == null) {
                            x.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                            obj = null;
                        } else {
                            iVar.hvq = this.hvq;
                            iVar.hve = this.hDi;
                            iVar.hvo = 2;
                            this.hvs = iVar.hvs;
                            this.mediaId = iVar.field_mediaId;
                            this.hVS = iVar.filename;
                            this.hVT = bi.Wx();
                            this.hVX = iVar.feA;
                            x.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), iVar);
                            com.tencent.mm.modelcdntran.g.MP().b(iVar, -1);
                            obj = 1;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    iVar.hvq = this.hvq;
                    iVar.hve = this.hDi;
                    iVar.hvo = 2;
                    this.hvs = iVar.hvs;
                    this.mediaId = iVar.field_mediaId;
                    this.hVS = iVar.filename;
                    this.hVT = bi.Wx();
                    this.hVX = iVar.feA;
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), iVar);
                    com.tencent.mm.modelcdntran.g.MP().b(iVar, -1);
                    obj = 1;
                } else {
                    x.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                    obj = null;
                }
            }
            if (obj != null) {
                return 0;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", e, "", new Object[0]);
        }
        this.hVY = null;
        return -1;
    }

    static int c(String str, int i, boolean z) {
        r nJ = t.nJ(str);
        if (nJ == null) {
            return i;
        }
        int i2;
        int i3 = nJ.fAP;
        if (z) {
            nJ.fAP = i;
        } else {
            nJ.fAP = i3 + i;
        }
        x.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(nJ.fAP), Boolean.valueOf(z));
        nJ.hXt = bi.Wx();
        nJ.fEo = 1025;
        t.e(nJ);
        if (z) {
            i2 = i - i3;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    final void f(String str, int i, String str2) {
        x.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), str2);
        if (t.nJ(str) != null) {
            t.X(str, i);
            if (!bi.oN(str2)) {
                o.Ub();
                String nx = s.nx(str);
                if (bi.oN(str2) || i <= 0 || bi.oN(nx) || !e.bO(nx)) {
                    x.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str2, nx);
                    return;
                }
                ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().z(str2, i, nx);
            }
        }
    }

    final void nm(String str) {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.hVT).append(",");
        stringBuffer.append(this.hVU).append(",");
        stringBuffer.append(this.hVV).append(",");
        stringBuffer.append(this.hVX).append(",");
        stringBuffer.append(this.hVW).append(",");
        try {
            i = (int) ((this.hVV / 1024) / (this.hVU - this.hVT));
        } catch (Exception e) {
            i = 0;
        }
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(this.hVG.fAJ).append(",");
        stringBuffer.append(this.hVG.hvv).append(",");
        stringBuffer.append(this.hVG.fAL).append(",");
        stringBuffer.append(this.hVG.field_fileId).append(",");
        stringBuffer.append(this.hVG.url).append(",");
        stringBuffer.append(this.hVG.fAR);
        x.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        g.pWK.k(14499, r0);
    }
}
