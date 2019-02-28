package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rr;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class ab extends k implements com.tencent.mm.network.k {
    au fFE;
    public long frh;
    private b gLB;
    e gLE;
    f hCU;
    public String hCY;
    private com.tencent.mm.modelcdntran.i.a hDi;
    private long ksO;
    public String mediaId;
    int retCode;
    long startTime;
    private int type;
    public b vlm;
    long vlp;
    private int vlq;
    String vlr;
    public boolean vls;
    private boolean vlt;
    private boolean vlu;

    public interface a {
        void bZB();
    }

    public ab(String str) {
        this(str, null, 0);
    }

    public ab(long j, String str, f fVar) {
        this(str, fVar, 0);
        this.frh = j;
    }

    public ab(long j, long j2, f fVar) {
        this.vlm = null;
        this.vlp = -1;
        this.mediaId = "";
        this.frh = 0;
        this.fFE = null;
        this.hCY = "";
        this.startTime = 0;
        this.vlq = -1;
        this.vlr = "";
        this.type = 0;
        this.retCode = 0;
        this.vls = false;
        this.vlt = false;
        this.ksO = 0;
        this.vlu = false;
        this.hDi = new com.tencent.mm.modelcdntran.i.a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                String str2 = "MicroMsg.NetSceneDownloadAppAttach";
                String str3 = "summerbig callback mediaId[%s], startRet[%d], progressInfo[%s], sceneResult[%s], finish[%b]";
                Object[] objArr = new Object[5];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                objArr[2] = keep_progressinfo;
                objArr[3] = keep_sceneresult;
                objArr[4] = Boolean.valueOf(keep_progressinfo == null);
                x.d(str2, str3, objArr);
                if (i == -21006) {
                    x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", ab.this.hCY);
                    return 0;
                } else if (i != 0) {
                    l.fs(ab.this.vlm.xrR);
                    g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "");
                    ab.this.gLE.a(3, i, "", ab.this);
                    return 0;
                } else {
                    ab.this.vlm = l.aj(str, ab.this.frh);
                    if (ab.this.vlm == null) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig attachInfo is null");
                        ab.this.gLE.a(3, i, "", ab.this);
                        return 0;
                    } else if (ab.this.vlm.field_status == 102) {
                        x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig dancy attach download has paused, status:%d", Long.valueOf(ab.this.vlm.field_status));
                        com.tencent.mm.modelcdntran.g.MP().kK(ab.this.hCY);
                        ab.this.gLE.a(3, i, "attach  has paused, status=" + ab.this.vlm.field_status, ab.this);
                        return 0;
                    } else if (keep_progressinfo == null) {
                        if (keep_sceneresult != null) {
                            if (keep_sceneresult.field_retCode != 0) {
                                l.fs(ab.this.vlm.xrR);
                                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra sceneResult.retCode :%d", Integer.valueOf(keep_sceneresult.field_retCode));
                                ab.this.gLE.a(3, keep_sceneresult.field_retCode, "", ab.this);
                            } else {
                                new File(ab.this.vlr).renameTo(new File(ab.this.vlm.field_fileFullPath));
                                ab.this.vlm.field_status = 199;
                                ab.this.vlm.field_offset = ab.this.vlm.field_totalLen;
                                an.aqK().c(ab.this.vlm, new String[0]);
                                g.pWK.a(198, 45, ab.this.vlm.field_totalLen, false);
                                g.pWK.a(198, 46, 1, false);
                                g.pWK.a(198, s.eX(ab.this.fFE == null ? "" : ab.this.fFE.field_talker) ? 48 : 47, 1, false);
                                as.Hm();
                                au dI = c.Fh().dI(ab.this.vlm.field_msgInfoId);
                                if (dI.field_status == 5) {
                                    dI.eR(3);
                                    as.Hm();
                                    c.Fh().a(dI.field_msgId, dI);
                                } else {
                                    as.Hm();
                                    c.Fh().a(new com.tencent.mm.plugin.messenger.foundation.a.a.c.c(dI.field_talker, "update", dI));
                                }
                                ab.this.gLE.a(0, 0, "", ab.this);
                            }
                            g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.vlm.field_totalLen), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                            if (keep_sceneresult.field_retCode != 0) {
                                g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(2), Long.valueOf(ab.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(ab.this.vlm.field_totalLen), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                            }
                            if (ab.this.hCU != null) {
                                ah.y(new Runnable() {
                                    public final void run() {
                                        ab.this.hCU.a((int) ab.this.vlm.field_offset, (int) ab.this.vlm.field_totalLen, ab.this);
                                    }
                                });
                            }
                        }
                        return 0;
                    } else if (((long) keep_progressinfo.field_finishedLength) == ab.this.vlm.field_totalLen) {
                        x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra ignore progress 100%");
                        return 0;
                    } else if (ab.this.vlm.field_offset > ((long) keep_progressinfo.field_finishedLength)) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdnEndProc error oldpos:%d newpos:%d", Long.valueOf(ab.this.vlm.field_offset), Integer.valueOf(keep_progressinfo.field_finishedLength));
                        l.fs(ab.this.vlm.xrR);
                        ab.this.gLE.a(3, i, "", ab.this);
                        return 0;
                    } else {
                        ab.this.vlm.field_offset = (long) keep_progressinfo.field_finishedLength;
                        an.aqK().c(ab.this.vlm, new String[0]);
                        if (ab.this.hCU != null) {
                            ah.y(new Runnable() {
                                public final void run() {
                                    ab.this.hCU.a((int) ab.this.vlm.field_offset, (int) ab.this.vlm.field_totalLen, ab.this);
                                }
                            });
                        }
                        x.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig callback cdntra progresscallback id:%s finish:%d total:%d", ab.this.hCY, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength));
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
        this.ksO = j2;
        this.frh = j;
        this.vlm = an.aqK().fp(j);
        this.hCU = fVar;
        this.vlt = true;
        if (this.vlm == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId" + j, Long.valueOf(j2));
            return;
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new rr();
        aVar.hnU = new rs();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hnS = 221;
        aVar.hnV = 106;
        aVar.hnW = 1000000106;
        this.gLB = aVar.Kf();
    }

    public ab(b bVar) {
        this.vlm = null;
        this.vlp = -1;
        this.mediaId = "";
        this.frh = 0;
        this.fFE = null;
        this.hCY = "";
        this.startTime = 0;
        this.vlq = -1;
        this.vlr = "";
        this.type = 0;
        this.retCode = 0;
        this.vls = false;
        this.vlt = false;
        this.ksO = 0;
        this.vlu = false;
        this.hDi = /* anonymous class already generated */;
        this.vlm = bVar;
        this.vls = true;
        this.mediaId = this.vlm.field_mediaId;
        this.hCU = null;
        this.type = 0;
        if (bVar == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
            return;
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new rr();
        aVar.hnU = new rs();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hnS = 221;
        aVar.hnV = 106;
        aVar.hnW = 1000000106;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", bVar.field_fileFullPath, Boolean.valueOf(true), bi.chl());
    }

    public ab(String str, f fVar, int i) {
        this.vlm = null;
        this.vlp = -1;
        this.mediaId = "";
        this.frh = 0;
        this.fFE = null;
        this.hCY = "";
        this.startTime = 0;
        this.vlq = -1;
        this.vlr = "";
        this.type = 0;
        this.retCode = 0;
        this.vls = false;
        this.vlt = false;
        this.ksO = 0;
        this.vlu = false;
        this.hDi = /* anonymous class already generated */;
        this.mediaId = str;
        this.hCU = fVar;
        this.type = i;
        this.vlm = an.aqK().Se(str);
        if (this.vlm == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + str);
            return;
        }
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new rr();
        aVar.hnU = new rs();
        aVar.uri = "/cgi-bin/micromsg-bin/downloadappattach";
        aVar.hnS = 221;
        aVar.hnV = 106;
        aVar.hnW = 1000000106;
        this.gLB = aVar.Kf();
        x.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", Integer.valueOf(i), this.vlm.field_fileFullPath, Long.valueOf(this.vlm.field_type), this.vlm.field_signature, bi.chl());
    }

    public final void bZA() {
        this.vlu = true;
        if (this.vlu) {
            com.tencent.mm.a.e.d(this.vlm.field_fileFullPath, "#!AMR\n".getBytes());
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (this.vlm == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.zo() + " get info failed mediaId:" + this.mediaId);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            return -1;
        }
        as.Hm();
        this.fFE = c.Fh().dI(this.frh);
        if (this.fFE == null || this.fFE.field_msgId != this.frh) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.zo() + " get msginfo failed mediaId:%s  msgId:%d", this.mediaId, Long.valueOf(this.frh));
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            return -1;
        }
        if (this.startTime == 0) {
            this.startTime = bi.Wy();
            this.vlq = (int) this.vlm.field_offset;
        }
        rr rrVar;
        if (this.ksO != 0) {
            rrVar = (rr) this.gLB.hnQ.hnY;
            rrVar.kyG = q.FY();
            rrVar.vPs = (int) this.vlm.field_totalLen;
            rrVar.vPt = (int) this.vlm.field_offset;
            rrVar.vPu = 0;
            rrVar.kzz = 40;
            rrVar.vNT = this.ksO;
            return a(eVar, this.gLB, this);
        }
        Object obj;
        int i;
        String str = this.fFE.field_content;
        if (s.eX(this.fFE.field_talker)) {
            int hR = bb.hR(this.fFE.field_content);
            if (hR != -1) {
                str = (this.fFE.field_content + " ").substring(hR + 2).trim();
            }
        }
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(bi.Wn(str));
        if (fV == null) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", this.mediaId);
            obj = null;
        } else {
            x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", Long.valueOf(this.frh), Long.valueOf(this.vlm.field_totalLen), this.vlm.field_fileFullPath, fV.hcT, bi.Wz(fV.hda));
            if (bi.oN(fV.hcT) || bi.oN(fV.hda)) {
                x.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", Long.valueOf(this.frh), fV.hcT, bi.Wz(fV.hda));
                obj = null;
            } else {
                this.hCY = d.a("downattach", this.vlm.field_createTime, this.fFE.field_talker, this.vlp);
                if (bi.oN(this.hCY)) {
                    x.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.vlp));
                    obj = null;
                } else {
                    com.tencent.mm.a.e.bU(this.vlm.field_fileFullPath);
                    this.vlr = this.vlm.field_fileFullPath + "_tmp";
                    i iVar = new i();
                    iVar.field_mediaId = this.hCY;
                    iVar.field_fullpath = this.vlr;
                    i = (fV.hcQ != 0 || fV.hcM > 26214400) ? com.tencent.mm.modelcdntran.b.htw : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                    iVar.field_fileType = i;
                    iVar.field_totalLen = (int) this.vlm.field_totalLen;
                    iVar.field_aesKey = fV.hda;
                    iVar.field_fileId = fV.hcT;
                    iVar.field_svr_signature = this.vlm.field_signature;
                    iVar.field_fake_bigfile_signature_aeskey = this.vlm.field_fakeAeskey;
                    iVar.field_fake_bigfile_signature = this.vlm.field_fakeSignature;
                    iVar.field_onlycheckexist = false;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                    iVar.hve = this.hDi;
                    iVar.field_chattype = s.eX(this.fFE.field_talker) ? 1 : 0;
                    x.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", Integer.valueOf(iVar.field_fileType), iVar.field_fullpath, bi.Wz(iVar.field_aesKey), bi.Wz(iVar.field_svr_signature), bi.Wz(iVar.field_fake_bigfile_signature_aeskey), bi.Wz(iVar.field_fake_bigfile_signature), Boolean.valueOf(iVar.field_onlycheckexist));
                    if (com.tencent.mm.modelcdntran.g.MP().b(iVar, -1)) {
                        if (this.vlm.field_isUseCdn != 1) {
                            this.vlm.field_isUseCdn = 1;
                            boolean c = an.aqK().c(this.vlm, new String[0]);
                            if (!c) {
                                x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                                this.gLE.a(3, -1, "", this);
                                obj = null;
                            }
                        }
                        obj = 1;
                    } else {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
                        this.hCY = "";
                        obj = null;
                    }
                }
            }
        }
        if (obj != null) {
            x.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", this.mediaId);
            return 0;
        }
        if (this.vlm.field_status == 102) {
            this.vlm.field_status = 101;
            if (!this.vls) {
                an.aqK().c(this.vlm, new String[0]);
            }
        }
        this.vlp = this.vlm.xrR;
        if (bi.oN(this.vlm.field_mediaSvrId) && this.ksO == 0) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            return -1;
        } else if (this.vlm.field_totalLen <= 0 || this.vlm.field_totalLen > 26214400) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.vlm.field_totalLen);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            return -1;
        } else if (bi.oN(this.vlm.field_fileFullPath) && this.ksO == 0) {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            return -1;
        } else {
            i = com.tencent.mm.a.e.bN(this.vlm.field_fileFullPath);
            if (this.vlu) {
                i -= 6;
                if (i <= 0) {
                    i = 0;
                }
            }
            if (((long) i) != this.vlm.field_offset) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.vlm.field_offset);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                return -1;
            }
            x.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", this.vlm.field_appId, this.vlm.field_mediaSvrId, Long.valueOf(this.vlm.field_sdkVer));
            rrVar = (rr) this.gLB.hnQ.hnY;
            rrVar.nlV = this.vlm.field_appId;
            rrVar.wgu = this.vlm.field_mediaSvrId;
            rrVar.vOK = (int) this.vlm.field_sdkVer;
            rrVar.kyG = q.FY();
            rrVar.vPs = (int) this.vlm.field_totalLen;
            rrVar.vPt = (int) this.vlm.field_offset;
            rrVar.vPu = 0;
            if (this.ksO != 0) {
                rrVar.vNT = this.ksO;
            }
            if (this.type != 0) {
                rrVar.kzz = this.type;
            } else {
                rrVar.kzz = (int) this.vlm.field_type;
            }
            return a(eVar, this.gLB, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else if (i2 == 0 && i3 == 0) {
            rs rsVar = (rs) ((b) qVar).hnR.hnY;
            this.vlm.field_totalLen = (long) rsVar.vPs;
            if (rsVar.wgu != null && !rsVar.wgu.equals(this.vlm.field_mediaSvrId)) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.gLE.a(3, -1, "", this);
            } else if (((long) rsVar.vPt) != this.vlm.field_offset) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + rsVar.vPt);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.gLE.a(3, -1, "", this);
            } else if (((long) rsVar.vPu) + this.vlm.field_offset > this.vlm.field_totalLen) {
                x.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + rsVar.vPu + " off:" + this.vlm.field_offset + " total?:" + this.vlm.field_totalLen);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.gLE.a(3, -1, "", this);
            } else {
                byte[] a = n.a(rsVar.weD);
                if (a == null || a.length == 0 || a.length != rsVar.vPu) {
                    x.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    this.gLE.a(3, -1, "", this);
                    return;
                }
                String str2 = new String(a);
                x.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", Boolean.valueOf(this.vlt));
                if (this.vlm.field_offset < this.vlm.field_totalLen && this.vlt) {
                    as.Hm();
                    au dI = c.Fh().dI(this.vlm.field_msgInfoId);
                    StringBuffer stringBuffer;
                    if (!str2.startsWith("<appmsg")) {
                        if (!dI.field_content.startsWith("<msg>")) {
                            stringBuffer = new StringBuffer();
                            stringBuffer.append(dI.field_content).append(str2);
                            this.vlm.field_fullXml = stringBuffer.toString();
                        }
                        if (str2.endsWith("</appmsg>") || this.vlm.field_offset + ((long) a.length) == this.vlm.field_totalLen) {
                            if (s.eX(dI.field_talker)) {
                                String[] split = dI.field_content.split("\n", 2);
                                String str3 = split[0];
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append(str3).append("\n<msg>").append(split[1]).append(str2).append("</msg>");
                                this.vlm.field_fullXml = stringBuffer2.toString();
                            } else {
                                stringBuffer = new StringBuffer();
                                stringBuffer.append("<msg>").append(this.vlm.field_fullXml).append("</msg>");
                                this.vlm.field_fullXml = stringBuffer.toString();
                            }
                        }
                    } else if (!s.eX(dI.field_talker)) {
                        this.vlm.field_fullXml = str2;
                    } else if (!bi.oN(dI.field_content)) {
                        String str4 = dI.field_content.split("\n", 2)[0];
                        this.vlm.field_fullXml = new StringBuffer().append(str4).append("\n").toString();
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(this.vlm.field_fullXml).append(str2);
                        this.vlm.field_fullXml = stringBuffer.toString();
                    }
                    dI.setContent(this.vlm.field_fullXml);
                    as.Hm();
                    c.Fh().a(this.vlm.field_msgInfoId, dI);
                    x.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", str2);
                }
                int d = com.tencent.mm.a.e.d(this.vlm.field_fileFullPath, a);
                if (bi.oN(this.vlm.field_fileFullPath) || d == 0) {
                    b bVar = this.vlm;
                    bVar.field_offset += (long) a.length;
                    if (this.vlm.field_offset == this.vlm.field_totalLen) {
                        this.vlm.field_status = 199;
                    }
                    if (this.hCU != null) {
                        ah.y(new Runnable() {
                            public final void run() {
                                ab.this.hCU.a((int) ab.this.vlm.field_offset, (int) ab.this.vlm.field_totalLen, ab.this);
                            }
                        });
                    }
                    if (!(this.vls ? true : an.aqK().c(this.vlm, new String[0]))) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + d);
                        this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                        this.gLE.a(3, -1, "", this);
                        return;
                    } else if (this.vlm.field_status == 199) {
                        g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.vlm.field_totalLen - ((long) this.vlq)));
                        as.Hm();
                        cg dI2 = c.Fh().dI(this.vlm.field_msgInfoId);
                        as.Hm();
                        c.Fh().a(new com.tencent.mm.plugin.messenger.foundation.a.a.c.c(dI2.field_talker, "update", dI2));
                        this.gLE.a(0, 0, "", this);
                        return;
                    } else if (this.vlm.field_status == 102) {
                        this.gLE.a(3, -1, "", this);
                        this.retCode = -20102;
                        return;
                    } else if (a(this.hok, this.gLE) < 0) {
                        x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
                        this.gLE.a(3, -1, "", this);
                        return;
                    } else {
                        return;
                    }
                }
                x.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + d);
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.gLE.a(3, -1, "", this);
            }
        } else {
            x.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            if (i2 == 4) {
                g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0));
            }
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 221;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 400;
    }

    public final String getMediaId() {
        if (this.vlm == null) {
            return "";
        }
        return this.vlm.field_mediaSvrId;
    }
}
