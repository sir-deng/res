package com.tencent.mm.modelvideo;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.ab;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.messenger.foundation.a.a.c.c;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.rt;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;
import junit.framework.Assert;

public final class d extends k implements com.tencent.mm.network.k {
    String fileName;
    private b gLB;
    e gLE;
    String hCY;
    String hDf;
    int hDg;
    private a hDi;
    boolean hVD;
    boolean hVE;
    r hVF;
    j hVG;
    int hVH;
    private boolean hVI;
    boolean hVJ;
    long hVK;
    int hmZ;
    private al hmy;
    private String mediaId;
    int retCode;
    private int startOffset;
    long startTime;

    protected final void cancel() {
        vp();
        super.cancel();
    }

    final boolean vp() {
        boolean z = false;
        if (!bi.oN(this.mediaId)) {
            if (this.hVD) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s cancel online video task.", TS());
                o.Uc().b(this.mediaId, null);
            } else {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s cancel offline video task.", TS());
                g.MP().kL(this.mediaId);
            }
            z = true;
        }
        this.hVI = true;
        return z;
    }

    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        this.hVF = null;
        this.hCY = "";
        this.startOffset = 0;
        this.startTime = 0;
        this.hmZ = 0;
        this.retCode = 0;
        this.hVH = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.hVI = false;
        this.hVJ = true;
        this.hDf = null;
        this.hDg = 0;
        this.hVK = 0;
        this.hDi = new a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                if (i == -21006) {
                    x.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", d.this.TS(), d.this.hCY);
                    return 0;
                } else if (i != 0) {
                    t.nC(d.this.fileName);
                    com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(d.this.hVH), Integer.valueOf(d.this.hmZ), "");
                    com.tencent.mm.plugin.report.service.g.pWK.h(13937, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(d.this.hVH), Integer.valueOf(d.this.hmZ), "");
                    d.this.gLE.a(3, i, "", d.this);
                    return 0;
                } else {
                    d.this.hVF = t.nJ(d.this.fileName);
                    int i2;
                    if (d.this.hVF == null || d.this.hVF.status == 113) {
                        x.i("MicroMsg.NetSceneDownloadVideo", "%s upload video info is null or has paused, status:%d", d.this.TS(), Integer.valueOf(d.this.hVF == null ? -1 : d.this.hVF.status));
                        d.this.vp();
                        d.this.gLE.a(3, i, "upload video info is null or has paused, status" + i2, d.this);
                        return 0;
                    } else if (keep_progressinfo == null) {
                        if (keep_sceneresult != null) {
                            x.i("MicroMsg.NetSceneDownloadVideo", "%s cdntra sceneResult.retCode:%d useTime:%d ", d.this.TS(), Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(bi.Wy() - d.this.hVK));
                            d dVar = d.this;
                            j jVar = d.this.hVG;
                            if (jVar == null || keep_sceneresult == null) {
                                x.w("MicroMsg.NetSceneDownloadVideo", "it had not task info or scene Result, don't report.");
                            } else if (jVar.field_smallVideoFlag == 1) {
                                x.i("MicroMsg.NetSceneDownloadVideo", "it download short video, don't report.");
                            } else if (!(jVar == null || keep_sceneresult == null)) {
                                x.i("MicroMsg.NetSceneDownloadVideo", "%s sceneResult.field_recvedBytes %d, time [%d, %d]", dVar.TS(), Integer.valueOf(keep_sceneresult.field_recvedBytes), Long.valueOf(keep_sceneresult.field_startTime), Long.valueOf(keep_sceneresult.field_endTime));
                                o.Uc();
                                f.a(null, keep_sceneresult, jVar, true);
                            }
                            if (keep_sceneresult.field_retCode != 0) {
                                t.nC(d.this.fileName);
                                if (d.this.hVD) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 13, 1, false);
                                }
                                if (d.this.hVE) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 136, 1, false);
                                }
                                d.this.gLE.a(3, keep_sceneresult.field_retCode, "", d.this);
                            } else {
                                if (d.this.hVD) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 12, 1, false);
                                }
                                if (d.this.hVE) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 137, 1, false);
                                }
                                d.this.iM(keep_sceneresult.field_fileLength);
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(d.this.hVH), Integer.valueOf(d.this.hmZ), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                            if (keep_sceneresult.field_retCode != 0) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(d.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(d.this.hVH), Integer.valueOf(d.this.hmZ), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                            }
                            a.a(d.this.hVF, 1);
                            d.this.hVG = null;
                        }
                        return 0;
                    } else if (keep_progressinfo.field_finishedLength == d.this.hmZ) {
                        x.d("MicroMsg.NetSceneDownloadVideo", "cdntra ignore progress 100%");
                        return 0;
                    } else if (d.this.hVF.hXp <= keep_progressinfo.field_finishedLength || d.this.hVD) {
                        i2 = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                        d.this.hVF.hXt = bi.Wx();
                        if (d.this.hVF.hXp < keep_progressinfo.field_finishedLength) {
                            d.this.hVF.hXp = keep_progressinfo.field_finishedLength;
                            i2 = 1040;
                        }
                        d.this.hVF.fEo = i2;
                        t.e(d.this.hVF);
                        x.d("MicroMsg.NetSceneDownloadVideo", "%s cdntra progresscallback id:%s finish:%d total:%d", d.this.TS(), d.this.hCY, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength));
                        return 0;
                    } else {
                        x.e("MicroMsg.NetSceneDownloadVideo", "%s cdnEndProc error oldpos:%d newpos:%d", d.this.TS(), Integer.valueOf(d.this.hVF.hXp), Integer.valueOf(keep_progressinfo.field_finishedLength));
                        t.nC(d.this.fileName);
                        d.this.gLE.a(3, i, "", d.this);
                        return 0;
                    }
                }
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return null;
            }
        };
        this.hmy = new al(new al.a() {
            public final boolean uG() {
                if (d.this.a(d.this.hok, d.this.gLE) == -1) {
                    d.this.gLE.a(3, -1, "doScene failed", d.this);
                }
                return false;
            }
        }, false);
        Assert.assertTrue(str != null);
        this.fileName = str;
        this.hVD = z;
        x.i("MicroMsg.NetSceneDownloadVideo", "%s NetSceneDownloadVideo:  file [%s] isCompleteOnlineVideo [%b]", TS(), str, Boolean.valueOf(z));
    }

    private boolean TR() {
        x.d("MicroMsg.NetSceneDownloadVideo", "%s parseVideoMsgXML content: %s", TS(), this.hVF.Un());
        Map y = bj.y(this.hVF.Un(), "msg");
        if (y == null) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 214, 1, false);
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", TS());
            return false;
        }
        String str = (String) y.get(".msg.videomsg.$cdnvideourl");
        if (bi.oN(str)) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 213, 1, false);
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra parse video recv xml failed", TS());
            return false;
        }
        String str2 = (String) y.get(".msg.videomsg.$aeskey");
        this.hmZ = Integer.valueOf((String) y.get(".msg.videomsg.$length")).intValue();
        String str3 = (String) y.get(".msg.videomsg.$fileparam");
        this.hCY = com.tencent.mm.modelcdntran.d.a("downvideo", this.hVF.hXs, this.hVF.Uk(), this.hVF.getFileName());
        if (bi.oN(this.hCY)) {
            x.w("MicroMsg.NetSceneDownloadVideo", "%s cdntra genClientId failed not use cdn file:%s", TS(), this.hVF.getFileName());
            return false;
        }
        int i;
        Object obj;
        String Uk;
        int i2;
        NetworkInfo activeNetworkInfo;
        int subtype;
        if (!this.hVD && this.hmZ < 1048576 && this.hVF != null && this.hVF.fAP > 0) {
            this.hVD = true;
            x.i("MicroMsg.NetSceneDownloadVideo", "%s less 1M and had preload, reset isCompleteOnlineVideo [%b]", TS(), Boolean.valueOf(this.hVD));
        }
        String str4 = (String) y.get(".msg.videomsg.$md5");
        StringBuilder stringBuilder = new StringBuilder();
        o.Ub();
        String stringBuilder2 = stringBuilder.append(s.nx(this.fileName)).append(".tmp").toString();
        this.hVG = new j();
        this.hVG.filename = this.hVF.getFileName();
        this.hVG.hvs = str4;
        this.hVG.hvt = this.hmZ;
        this.hVG.hvu = 0;
        this.hVG.fAJ = this.hVF.Ul();
        this.hVG.hvv = this.hVF.Uk();
        this.hVG.fAL = s.eX(this.hVF.Uk()) ? m.gn(this.hVF.Uk()) : 0;
        this.hVG.field_mediaId = this.hCY;
        this.hVG.field_fullpath = stringBuilder2;
        this.hVG.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        this.hVG.field_totalLen = this.hmZ;
        this.hVG.field_aesKey = str2;
        this.hVG.field_fileId = str;
        this.hVG.field_priority = com.tencent.mm.modelcdntran.b.htu;
        this.hVG.hve = this.hDi;
        this.hVG.field_wxmsgparam = str3;
        this.hVG.field_chattype = s.eX(this.hVF.Uk()) ? 1 : 0;
        this.hVG.hvw = this.hVF.hvw;
        cg G = ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().G(this.hVF.Uk(), this.hVF.fGj);
        this.hVG.hvy = G.field_createTime;
        this.hVG.fGj = G.field_msgSvrId;
        bb.b hW = bb.hW(G.gkD);
        this.hVG.hvz = hW != null ? hW.hiB : 0;
        if (this.hVF.Uk().equals(G.field_talker)) {
            this.hVG.field_limitrate = hW == null ? 0 : hW.hiz / 8;
        }
        x.d("MicroMsg.NetSceneDownloadVideo", "%s limitrate:%d file:%s", TS(), Integer.valueOf(this.hVG.field_limitrate), this.hVF.getFileName());
        if (g.MP().huj.contains("video_" + this.hVF.hXw)) {
            g.MP().huj.remove("video_" + this.hVF.hXw);
            this.hVG.field_autostart = true;
        } else {
            this.hVG.field_autostart = false;
        }
        if (3 == this.hVF.hXC) {
            this.hVG.field_smallVideoFlag = 1;
        }
        if (!(bi.oN(str4) || this.hVD)) {
            str2 = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Fm().df(str4, this.hmZ);
            int bN = com.tencent.mm.a.e.bN(str2);
            int i3 = this.hmZ - bN;
            o.Ub();
            str3 = s.nx(this.fileName);
            if (com.tencent.mm.a.e.bN(str3) > 0) {
                x.w("MicroMsg.NetSceneDownloadVideo", "%s already copy dup file, but download again, something error here.", TS());
                boolean deleteFile = com.tencent.mm.loader.stub.b.deleteFile(str3);
                at Fm = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Fm();
                int i4 = this.hmZ;
                i = 0;
                if (!bi.oN(str4)) {
                    i = Fm.gLA.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str4, String.valueOf(i4), "100"});
                }
                r nJ = t.nJ(this.fileName);
                nJ.hXp = 0;
                nJ.fEo = 16;
                t.e(nJ);
                x.w("MicroMsg.NetSceneDownloadVideo", "%s don't copy dup file, go to download now. target video len %d, delete file:%b,delete db: %d", TS(), Integer.valueOf(r11), Boolean.valueOf(deleteFile), Integer.valueOf(i));
                str2 = "";
            }
            x.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage: totallen:%s md5:%s  dup(len:%d path:%s) diffLen:%d to:%s target video len %d", TS(), Integer.valueOf(this.hmZ), str4, Integer.valueOf(bN), str2, Integer.valueOf(i3), stringBuilder2, Integer.valueOf(r11));
            if (bi.oN(str2)) {
                this.hDf = str4;
                this.hDg = this.hmZ;
            } else if (i3 >= 0 && i3 <= 16) {
                x.i("MicroMsg.NetSceneDownloadVideo", "%s MediaCheckDuplicationStorage copy dup file now :%s -> %s", TS(), str2, stringBuilder2);
                com.tencent.mm.sdk.platformtools.k.fv(str2, stringBuilder2);
                iM(this.hmZ);
                ((h) com.tencent.mm.kernel.g.h(h.class)).aZO().a(new c(G.field_talker, "update", G));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
                Object[] objArr = new Object[7];
                objArr[0] = str;
                objArr[1] = Long.valueOf(this.hVF.fGj);
                objArr[2] = str4;
                objArr[3] = Long.valueOf(this.hVF.hXs);
                objArr[4] = this.hVF.Uk();
                objArr[5] = Integer.valueOf(3 != this.hVF.hXC ? 43 : 62);
                objArr[6] = Integer.valueOf(bN);
                gVar.h(13267, objArr);
                obj = 1;
                if (obj == null) {
                    this.mediaId = this.hVG.field_mediaId;
                    this.hVK = bi.Wy();
                    this.hVE = this.hVF.videoFormat != 2;
                    x.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", TS(), Boolean.valueOf(this.hVE), Boolean.valueOf(this.hVD));
                    if (this.hVE && this.hVD) {
                        this.hVJ = false;
                        j jVar = this.hVG;
                        o.Ub();
                        jVar.field_fullpath = s.nx(this.fileName);
                        o.Uc().a(this.hVG, false);
                    } else if (!g.MP().b(this.hVG, -1)) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(111, 212, 1, false);
                        x.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", TS());
                        this.hCY = "";
                        return false;
                    } else if (this.hVE) {
                        com.tencent.mm.plugin.report.service.g.pWK.a(354, 135, 1, false);
                    }
                }
                if (this.hVF.hXA != 1) {
                    this.hVF.hXA = 1;
                    this.hVF.fEo = SQLiteGlobal.journalSizeLimit;
                    t.e(this.hVF);
                }
                if (3 != this.hVF.hXC) {
                    Uk = this.hVF.Uk();
                    if (!bi.oN(Uk)) {
                        if (s.eX(Uk)) {
                            i2 = 0;
                        } else {
                            i2 = m.gn(Uk);
                        }
                        try {
                            activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                            subtype = activeNetworkInfo.getSubtype();
                            if (activeNetworkInfo.getType() != 1) {
                                i = 1;
                            } else if (subtype != 13 || subtype == 15 || subtype == 14) {
                                i = 4;
                            } else if (subtype == 3 || subtype == 4 || subtype == 5 || subtype == 6 || subtype == 12) {
                                i = 3;
                            } else if (subtype == 1 || subtype == 2) {
                                i = 2;
                            } else {
                                i = 0;
                            }
                        } catch (Throwable e) {
                            x.e("MicroMsg.NetSceneDownloadVideo", "getNetType : %s", bi.i(e));
                            i = 0;
                        }
                        x.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", TS(), Uk + "," + i2 + "," + str + "," + this.hmZ + "," + i);
                        com.tencent.mm.plugin.report.service.g.pWK.k(12024, str);
                    }
                }
                return true;
            }
        }
        obj = null;
        if (obj == null) {
            this.mediaId = this.hVG.field_mediaId;
            this.hVK = bi.Wy();
            if (this.hVF.videoFormat != 2) {
            }
            this.hVE = this.hVF.videoFormat != 2;
            x.i("MicroMsg.NetSceneDownloadVideo", "%s check use cdn isHadHevcLocalFile[%b] isCompleteOnlineVideo[%b]", TS(), Boolean.valueOf(this.hVE), Boolean.valueOf(this.hVD));
            if (this.hVE) {
            }
            if (!g.MP().b(this.hVG, -1)) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 212, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "%s cdntra addSendTask failed.", TS());
                this.hCY = "";
                return false;
            } else if (this.hVE) {
                com.tencent.mm.plugin.report.service.g.pWK.a(354, 135, 1, false);
            }
        }
        if (this.hVF.hXA != 1) {
            this.hVF.hXA = 1;
            this.hVF.fEo = SQLiteGlobal.journalSizeLimit;
            t.e(this.hVF);
        }
        if (3 != this.hVF.hXC) {
            Uk = this.hVF.Uk();
            if (bi.oN(Uk)) {
                if (s.eX(Uk)) {
                    i2 = 0;
                } else {
                    i2 = m.gn(Uk);
                }
                activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                subtype = activeNetworkInfo.getSubtype();
                if (activeNetworkInfo.getType() != 1) {
                    if (subtype != 13) {
                    }
                    i = 4;
                } else {
                    i = 1;
                }
                x.i("MicroMsg.NetSceneDownloadVideo", "%s dk12024 report:%s", TS(), Uk + "," + i2 + "," + str + "," + this.hmZ + "," + i);
                com.tencent.mm.plugin.report.service.g.pWK.k(12024, str);
            }
        }
        return true;
    }

    final void iM(final int i) {
        boolean renameTo;
        if (this.hVJ) {
            StringBuilder stringBuilder = new StringBuilder();
            o.Ub();
            File file = new File(stringBuilder.append(s.nx(this.fileName)).append(".tmp").toString());
            o.Ub();
            renameTo = file.renameTo(new File(s.nx(this.fileName)));
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            o.Ub();
            com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(s.nx(this.fileName)).append(".tmp").toString());
            renameTo = true;
        }
        com.tencent.mm.kernel.g.Dt().F(new Runnable() {
            public final void run() {
                Map y = bj.y(d.this.hVF.Un(), "msg");
                if (y != null) {
                    s Ub = o.Ub();
                    o.Ub();
                    Ub.p(s.nx(d.this.fileName), (String) y.get(".msg.videomsg.$cdnvideourl"), (String) y.get(".msg.videomsg.$aeskey"));
                }
                boolean z = false;
                if (renameTo) {
                    z = t.X(d.this.fileName, i);
                    if (d.this.hVE) {
                        r nJ = t.nJ(d.this.fileName);
                        if (nJ != null) {
                            nJ.videoFormat = 1;
                            nJ.fEo = 2;
                            o.Ub().b(nJ);
                        }
                    }
                } else if (d.this.hVE) {
                    t.nC(d.this.fileName);
                    com.tencent.mm.plugin.report.service.g.pWK.a(354, 138, 1, false);
                } else {
                    z = t.X(d.this.fileName, i);
                }
                x.i("MicroMsg.NetSceneDownloadVideo", "%s ashutest::cdntra !FIN! file:%s svrid:%d human:%s user:%s updatedbsucc:%b  MediaCheckDuplicationStorage MD5:%s SIZE:%d renameFlag %b needRename %b", d.this.TS(), d.this.fileName, Long.valueOf(d.this.hVF.fGj), d.this.hVF.Ul(), d.this.hVF.Uk(), Boolean.valueOf(z), d.this.hDf, Integer.valueOf(d.this.hDg), Boolean.valueOf(renameTo), Boolean.valueOf(d.this.hVJ));
                if (!bi.oN(d.this.hDf) && d.this.hDg > 0) {
                    at Fm = ((com.tencent.mm.plugin.r.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.r.a.a.class)).Fm();
                    String str = d.this.hDf;
                    int i = d.this.hDg;
                    o.Ub();
                    Fm.z(str, i, s.nx(d.this.fileName));
                }
                if (d.this.hVF.hXC == 3) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 38, (long) d.this.hVF.hmZ, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 40, (long) d.this.hVF.hXv, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 41, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, s.eX(d.this.hVF.Uk()) ? 43 : 42, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 31, (long) d.this.hVF.hmZ, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 33, (long) d.this.hVF.hXv, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, 34, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(198, s.eX(d.this.hVF.Uk()) ? 36 : 35, 1, false);
                }
                d.this.gLE.a(0, 0, "", d.this);
            }
        });
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 1;
        this.gLE = eVar2;
        this.hVF = t.nJ(this.fileName);
        if (this.hVF == null) {
            x.e("MicroMsg.NetSceneDownloadVideo", "ERR: Get INFO FAILED :" + this.fileName);
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            return -1;
        }
        if (this.hVF != null && 3 == this.hVF.hXC) {
            this.hVH = com.tencent.mm.modelcdntran.b.MediaType_TinyVideo;
        }
        if (this.startTime == 0) {
            this.startTime = bi.Wy();
            this.startOffset = this.hVF.hXp;
        }
        if (TR()) {
            x.d("MicroMsg.NetSceneDownloadVideo", "cdntra use cdn return -1 for onGYNetEnd clientid:%s", this.fileName);
            return 0;
        } else if (this.hVF.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
            x.e("MicroMsg.NetSceneDownloadVideo", "ERR: STATUS: " + this.hVF.status + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "]");
            this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
            return -1;
        } else {
            x.d("MicroMsg.NetSceneDownloadVideo", "start doScene  [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "]  filesize:" + this.hVF.hXp + " file:" + this.hVF.hmZ + " netTimes:" + this.hVF.hXx);
            if (!t.nB(this.fileName)) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: NET TIMES: " + this.hVF.hXx + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else if (this.hVF.fGj <= 0) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: MSGSVRID: " + this.hVF.fGj + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else if (this.hVF.hXp < 0 || this.hVF.hmZ <= this.hVF.hXp || this.hVF.hmZ <= 0) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: fileSize:" + this.hVF.hXp + " total:" + this.hVF.hmZ + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                return -1;
            } else {
                b.a aVar = new b.a();
                aVar.hnT = new rt();
                aVar.hnU = new ru();
                aVar.uri = "/cgi-bin/micromsg-bin/downloadvideo";
                aVar.hnS = 150;
                aVar.hnV = 40;
                aVar.hnW = 1000000040;
                this.gLB = aVar.Kf();
                rt rtVar = (rt) this.gLB.hnQ.hnY;
                rtVar.vNT = this.hVF.fGj;
                rtVar.vPt = this.hVF.hXp;
                rtVar.vPs = this.hVF.hmZ;
                if (!ab.bC(ad.getContext())) {
                    i = 2;
                }
                rtVar.wgy = i;
                return a(eVar, this.gLB, this);
            }
        }
    }

    protected final int a(q qVar) {
        rt rtVar = (rt) ((b) qVar).hnQ.hnY;
        if (rtVar.vNT > 0 && rtVar.vPt >= 0 && rtVar.vPs > 0 && rtVar.vPs > rtVar.vPt) {
            return b.hoz;
        }
        x.e("MicroMsg.NetSceneDownloadVideo", "ERR: SECURITY CHECK FAILED [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
        t.nC(this.fileName);
        return b.hoA;
    }

    protected final int Bo() {
        return 2500;
    }

    public final boolean Kk() {
        boolean Kk = super.Kk();
        if (Kk) {
            com.tencent.mm.plugin.report.service.g.pWK.a(111, 210, 1, false);
        }
        return Kk;
    }

    protected final void a(a aVar) {
        com.tencent.mm.plugin.report.service.g.pWK.a(111, 211, 1, false);
        t.nC(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (this.hVI) {
            x.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd Call Stop by Service  [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
            this.gLE.a(i2, i3, str, this);
        } else if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w("MicroMsg.NetSceneDownloadVideo", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else {
            ru ruVar = (ru) ((b) qVar).hnR.hnY;
            rt rtVar = (rt) ((b) qVar).hnQ.hnY;
            this.hVF = t.nJ(this.fileName);
            if (this.hVF == null) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
                this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine()) - 10000;
                this.gLE.a(i2, i3, str, this);
            } else if (this.hVF.status == 113) {
                x.w("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd STATUS PAUSE [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                this.gLE.a(i2, i3, str, this);
            } else if (this.hVF.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd STATUS ERR: status:" + this.hVF.status + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                this.gLE.a(i2, i3, str, this);
            } else if (i2 == 4 && i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 208, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                com.tencent.mm.plugin.report.service.g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(this.hVH), Integer.valueOf(this.hmZ - this.startOffset));
                this.gLE.a(i2, i3, str, this);
            } else if (i2 != 0 || i3 != 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(111, 207, 1, false);
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd SERVER FAILED (SET PAUSE) errtype:" + i2 + " errCode:" + i3 + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                this.hVF.status = 113;
                t.e(this.hVF);
                this.gLE.a(i2, i3, str, this);
            } else if (bi.by(ruVar.weD.wRm.oz)) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd Recv BUF ZERO length  [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else if (ruVar.vPt != rtVar.vPt) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd OFFSET ERROR respStartPos:" + ruVar.vPt + " reqStartPos:" + rtVar.vPt + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else if (ruVar.vPs != rtVar.vPs) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + ruVar.vPs + " reqTotal:" + rtVar.vPs + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else if (rtVar.vPs < ruVar.vPt) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respTotal:" + ruVar.vPs + " respStartPos:" + rtVar.vPt + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else if (ruVar.vNT != rtVar.vNT) {
                x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd respMsgId:" + ruVar.vNT + " reqMsgId:" + rtVar.vNT + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                t.nC(this.fileName);
                this.gLE.a(i2, i3, str, this);
            } else {
                x.d("MicroMsg.NetSceneDownloadVideo", "onGYNetEnd respBuf:" + ruVar.weD.wRk + " reqStartPos:" + rtVar.vPt + " totallen:" + rtVar.vPs + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                o.Ub();
                int a = s.a(s.nx(this.fileName), rtVar.vPt, ruVar.weD.wRm.toByteArray());
                if (a < 0) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE RET:" + a + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                    t.nC(this.fileName);
                    this.gLE.a(i2, i3, str, this);
                } else if (a > this.hVF.hmZ) {
                    x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd WRITEFILE newOffset:" + a + " totalLen:" + this.hVF.hmZ + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                    t.nC(this.fileName);
                    this.gLE.a(i2, i3, str, this);
                } else {
                    int line;
                    String str2 = this.fileName;
                    r nJ = t.nJ(str2);
                    if (nJ == null) {
                        x.e("MicroMsg.VideoLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str2);
                        line = 0 - com.tencent.mm.compatible.util.g.getLine();
                    } else {
                        nJ.hXp = a;
                        nJ.hXt = bi.Wx();
                        nJ.fEo = 1040;
                        line = 0;
                        if (nJ.hmZ > 0 && a >= nJ.hmZ) {
                            t.d(nJ);
                            nJ.status = 199;
                            nJ.fEo |= 256;
                            x.i("MicroMsg.VideoLogic", "END!!!  updateRecv  file:" + str2 + " newsize:" + a + " total:" + nJ.hmZ + " status:" + nJ.status + " netTimes:" + nJ.hXx);
                            line = 1;
                        }
                        x.d("MicroMsg.VideoLogic", "updateRecv " + com.tencent.mm.compatible.util.g.zo() + " file:" + str2 + " newsize:" + a + " total:" + nJ.hmZ + " status:" + nJ.status);
                        if (!t.e(nJ)) {
                            line = 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    if (line < 0) {
                        x.e("MicroMsg.NetSceneDownloadVideo", "ERR: onGYNetEnd updateAfterRecv Ret:" + line + " newOffset :" + a + " [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "] ");
                        this.gLE.a(i2, i3, str, this);
                    } else if (line == 1) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(this.hVH), Integer.valueOf(this.hmZ - this.startOffset));
                        a.a(this.hVF, 1);
                        x.i("MicroMsg.NetSceneDownloadVideo", "!!!FIN [" + this.fileName + "," + this.hVF.fGj + "," + this.hVF.Ul() + "," + this.hVF.Uk() + "]");
                        this.gLE.a(i2, i3, str, this);
                    } else if (this.hVI) {
                        this.gLE.a(i2, i3, str, this);
                    } else {
                        this.hmy.K(0, 0);
                    }
                }
            }
        }
    }

    public final int getType() {
        return 150;
    }

    final String TS() {
        return this.fileName + "_" + hashCode();
    }
}
