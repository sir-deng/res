package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.brk;
import com.tencent.mm.protocal.c.brl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;

public final class ak extends k implements com.tencent.mm.network.k {
    a fov = null;
    String frp;
    private b gLB;
    e gLE;
    private boolean gNE = false;
    int gNG = 0;
    keep_SceneResult gNH;
    c gNJ = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        private boolean a(mt mtVar) {
            if (mtVar.fFy.filePath.equals(ak.this.vlm.field_fileFullPath)) {
                String str = "";
                try {
                    str = URLEncoder.encode(mtVar.fFy.result, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", e, "", new Object[0]);
                }
                if (ak.this.gNG == 1) {
                    as.Hm();
                    cg dI = com.tencent.mm.y.c.Fh().dI(ak.this.vlm.field_msgInfoId);
                    d dVar = new d();
                    dVar.q("20toUser", ak.this.toUser + ",");
                    dVar.q("21source", "4,");
                    dVar.q("22qrUrl", str + ",");
                    dVar.q("23md5", (ak.this.gNH == null ? "" : ak.this.gNH.field_filemd5) + ",");
                    dVar.q("24cdnFileId", (ak.this.gNH == null ? "" : ak.this.gNH.field_fileId) + ",");
                    dVar.q("25cdnAesKey", (ak.this.gNH == null ? "" : ak.this.gNH.field_aesKey) + ",");
                    str = "";
                    if (dI.aNJ()) {
                        a fV = a.fV(dI.field_content);
                        if (fV != null) {
                            str = fV.appId;
                        }
                    }
                    dVar.q("26appip", str + ",");
                    dVar.q("27toUsersCount", m.gn(ak.this.toUser) + ",");
                    dVar.q("28codeType", Integer.valueOf(mtVar.fFy.fqW));
                    x.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + dVar.SG());
                    o.w(13628, dVar.toString());
                }
                com.tencent.mm.sdk.b.a.xmy.c(ak.this.gNJ);
            }
            return false;
        }
    };
    String hCY = "";
    private i.a hDi = new i.a() {
        public final int a(String str, final int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
            String str2 = "MicroMsg.NetSceneUploadAppAttach";
            String str3 = "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
            Object[] objArr = new Object[7];
            objArr[0] = ak.this.hCY;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = keep_progressinfo;
            objArr[3] = keep_sceneresult;
            objArr[4] = Boolean.valueOf(keep_progressinfo != null);
            objArr[5] = Boolean.valueOf(keep_sceneresult != null);
            objArr[6] = Boolean.valueOf(z);
            x.d(str2, str3, objArr);
            an.aqK().b(ak.this.vlp, ak.this.vlm);
            boolean c;
            if (i == -21005) {
                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", ak.this.hCY);
                return 0;
            } else if (i != 0) {
                l.fs(ak.this.vlm.xrR);
                an.aqK().b(ak.this.vlp, ak.this.vlm);
                ak.this.vlm.field_signature = "";
                c = an.aqK().c(ak.this.vlm, new String[0]);
                x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Long.valueOf(ak.this.vlp), Boolean.valueOf(c));
                ak.this.gLE.a(3, i, "", ak.this);
                g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "");
                return 0;
            } else if (ak.this.vlm.field_status == 105) {
                x.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", Long.valueOf(ak.this.vlm.field_status), Long.valueOf(ak.this.vlp));
                com.tencent.mm.modelcdntran.g.MP().kK(ak.this.hCY);
                ak.this.gLE.a(3, i, "attach  has paused, status" + ak.this.vlm.field_status, ak.this);
                return 0;
            } else if (keep_progressinfo != null) {
                ak.this.vlm.field_lastModifyTime = bi.Wx();
                ak.this.vlm.field_offset = (long) keep_progressinfo.field_finishedLength;
                c = an.aqK().c(ak.this.vlm, new String[0]);
                if (c) {
                    return 0;
                }
                x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
                ak.this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                ak.this.gLE.a(3, i, "", ak.this);
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        l.fs(ak.this.vlm.xrR);
                        an.aqK().b(ak.this.vlp, ak.this.vlm);
                        ak.this.vlm.field_signature = "";
                        c = an.aqK().c(ak.this.vlm, new String[0]);
                        x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", Integer.valueOf(i), Integer.valueOf(keep_sceneresult.field_retCode), Long.valueOf(ak.this.vlp), Boolean.valueOf(c));
                        g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        ak.this.gLE.a(3, keep_sceneresult.field_retCode, "", ak.this);
                    } else {
                        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(keep_sceneresult.field_exist_whencheck), bi.Wz(ak.this.vlm.field_signature));
                        if (!z) {
                            a(i, keep_sceneresult);
                        } else if (keep_sceneresult.field_exist_whencheck) {
                            as.CN().a(new z(ak.this.fov, ak.this.vlm.field_fileFullPath, ak.this.toUser, new z.a() {
                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    boolean z = true;
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = bi.Wz(str2);
                                    objArr[2] = bi.Wz(str3);
                                    objArr[3] = bi.Wz(str4);
                                    objArr[4] = bi.Wz(str5);
                                    if (ak.this.fov != null) {
                                        z = false;
                                    }
                                    objArr[5] = Boolean.valueOf(z);
                                    objArr[6] = Boolean.valueOf(ak.this.hDq);
                                    x.i(str6, str7, objArr);
                                    if (!bi.oN(str3)) {
                                        ak.this.vlm.field_signature = str3;
                                        ak.this.vlm.field_fakeAeskey = str4;
                                        ak.this.vlm.field_fakeSignature = str5;
                                    }
                                    AnonymousClass1.this.a(i, keep_sceneresult);
                                }
                            }), 0);
                        } else {
                            x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
                            as.CN().a(new z(null, ak.this.vlm.field_fileFullPath, ak.this.toUser, new z.a() {
                                public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                                    String str6 = "MicroMsg.NetSceneUploadAppAttach";
                                    String str7 = "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]";
                                    Object[] objArr = new Object[7];
                                    objArr[0] = str;
                                    objArr[1] = bi.Wz(str2);
                                    objArr[2] = bi.Wz(str3);
                                    objArr[3] = bi.Wz(str4);
                                    objArr[4] = bi.Wz(str5);
                                    objArr[5] = Boolean.valueOf(ak.this.fov == null);
                                    objArr[6] = Boolean.valueOf(ak.this.hDq);
                                    x.i(str6, str7, objArr);
                                    if (!bi.oN(str3)) {
                                        ak.this.vlm.field_signature = str3;
                                        ak.this.vlm.field_fakeAeskey = str4;
                                        ak.this.vlm.field_fakeSignature = str5;
                                        ak.this.vlm.field_lastModifyTime = bi.Wy();
                                        if (ak.this.fov != null) {
                                            ak.this.fov.filemd5 = str;
                                            ak.this.fov.hda = str2;
                                            ak.this.fov.hcM = (int) j;
                                            as.Hm();
                                            au dI = com.tencent.mm.y.c.Fh().dI(ak.this.vlm.field_msgInfoId);
                                            dI.setContent(a.a(ak.this.fov, null, null));
                                            as.Hm();
                                            com.tencent.mm.y.c.Fh().a(dI.field_msgId, dI);
                                        }
                                    }
                                    ak.this.hDq = false;
                                    boolean c = an.aqK().c(ak.this.vlm, new String[0]);
                                    if (c) {
                                        as.Dt().F(new Runnable() {
                                            public final void run() {
                                                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                                                ak.this.a(ak.this.hok, ak.this.gLE);
                                            }
                                        });
                                        return;
                                    }
                                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
                                    ak.this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                                    ak.this.gLE.a(3, i, "", ak.this);
                                }
                            }), 0);
                        }
                    }
                }
                return 0;
            }
        }

        final void a(int i, final keep_SceneResult keep_sceneresult) {
            ak.this.vlm.field_status = 199;
            boolean c = an.aqK().c(ak.this.vlm, new String[0]);
            if (c) {
                l.a(ak.this.vlm.field_msgInfoId, ak.this.vlm.field_mediaSvrId, keep_sceneresult);
                as.CN().a(new ai(ak.this.vlm.field_msgInfoId, true, keep_sceneresult, new a() {
                    public final void bn(int i, int i2) {
                        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 4 && i2 == 102) {
                            as.Dt().F(new Runnable() {
                                public final void run() {
                                    ak.this.hDq = false;
                                    ak.this.vlm.field_createTime = bi.Wy();
                                    ak.this.vlm.field_lastModifyTime = bi.Wx();
                                    ak.this.vlm.field_offset = 0;
                                    ak.this.vlm.field_status = 101;
                                    boolean c = an.aqK().c(ak.this.vlm, new String[0]);
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", Boolean.valueOf(ak.this.hDq), Boolean.valueOf(c), Long.valueOf(ak.this.vlm.field_createTime));
                                    ak.this.a(ak.this.hok, ak.this.gLE);
                                }
                            });
                            return;
                        }
                        g.pWK.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        if (i == 0 && i2 == 0) {
                            ak.this.d(keep_sceneresult);
                        }
                        ak.this.gLE.a(i, i2, "", ak.this);
                    }
                }, ak.this.frp, ak.this.vlm), 0);
                return;
            }
            x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + c);
            ak.this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            ak.this.gLE.a(3, i, "", ak.this);
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return null;
        }
    };
    boolean hDq = true;
    private String hcO = null;
    int retCode = 0;
    long startTime = 0;
    String toUser;
    private boolean vlJ = true;
    private long vlK = -1;
    b vlm = null;
    long vlp = -1;

    public ak(long j, String str, String str2) {
        this.vlp = j;
        this.hcO = str;
        this.frp = str2;
        b.a aVar = new b.a();
        aVar.hnT = new brk();
        aVar.hnU = new brl();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadappattach";
        aVar.hnS = 220;
        aVar.hnV = 105;
        aVar.hnW = 1000000105;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", Long.valueOf(j), str, bi.chl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        this.vlm = new b();
        if (!an.aqK().b(this.vlp, this.vlm) || this.vlm == null) {
            x.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.zo() + " summerbig get info failed rowid:" + this.vlp);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            this.vlm = null;
            return -1;
        } else if (this.vlm.field_status != 101) {
            x.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.zo() + " summerbig get field_status failed rowid:" + this.vlp + " status:" + this.vlm.field_status);
            return -1;
        } else {
            Object obj;
            if (this.startTime == 0) {
                this.startTime = bi.Wy();
                this.vlK = this.vlm.field_offset;
            }
            x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", Long.valueOf(this.vlp), this.vlm.field_fileFullPath, Long.valueOf(this.vlm.field_totalLen), Boolean.valueOf(this.vlm.field_isUpload), Integer.valueOf(this.vlm.field_isUseCdn), Long.valueOf(this.vlm.field_type));
            if (bi.oN(this.vlm.field_appId)) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
                if (!(this.vlm.field_type == 8 || this.vlm.field_type == 6)) {
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    return -1;
                }
            }
            if (this.vlm.field_type == 8 || this.vlm.field_type == 9) {
                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", Long.valueOf(this.vlm.field_type));
                obj = null;
            } else {
                com.tencent.mm.modelcdntran.g.MP();
                if (com.tencent.mm.modelcdntran.c.hx(4) || this.vlm.field_isUseCdn == 1) {
                    as.Hm();
                    cg dI = com.tencent.mm.y.c.Fh().dI(this.vlm.field_msgInfoId);
                    if (dI.field_msgId != this.vlm.field_msgInfoId) {
                        x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", Long.valueOf(this.vlm.field_msgInfoId), Long.valueOf(this.vlm.xrR), Long.valueOf(this.vlm.field_createTime), Long.valueOf(this.vlm.field_totalLen), Long.valueOf(this.vlm.field_status), Boolean.valueOf(this.vlm.field_isUpload), Integer.valueOf(this.vlm.field_isUseCdn), this.vlm.field_mediaId);
                        this.toUser = null;
                        obj = null;
                    } else {
                        this.toUser = dI.field_talker;
                        String str = "";
                        if (!bi.oN(dI.field_imgPath)) {
                            str = com.tencent.mm.ap.o.PC().lp(dI.field_imgPath);
                        }
                        int bN = com.tencent.mm.a.e.bN(str);
                        int bN2 = com.tencent.mm.a.e.bN(this.vlm.field_fileFullPath);
                        if (bN >= com.tencent.mm.modelcdntran.b.htQ) {
                            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(bN));
                            obj = null;
                        } else {
                            this.hCY = com.tencent.mm.modelcdntran.d.a("upattach", this.vlm.field_createTime, dI.field_talker, this.vlp);
                            x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", Long.valueOf(this.vlm.field_createTime), this.hCY);
                            if (bi.oN(this.hCY)) {
                                x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", Long.valueOf(this.vlp));
                                obj = null;
                            } else {
                                Object obj2;
                                i iVar = new i();
                                String str2 = dI.field_content;
                                if (s.eX(dI.field_talker)) {
                                    int hR = bb.hR(dI.field_content);
                                    if (hR != -1) {
                                        str2 = (dI.field_content + " ").substring(hR + 2).trim();
                                    }
                                }
                                this.fov = a.fV(bi.Wn(str2));
                                if (this.fov != null) {
                                    x.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", this.fov.hcT, bi.Wz(this.fov.hda), this.fov.filemd5, Integer.valueOf(this.fov.type));
                                    iVar.field_fileId = this.fov.hcT;
                                    iVar.field_aesKey = this.fov.hda;
                                    iVar.field_filemd5 = this.fov.filemd5;
                                    obj2 = (this.fov.hcQ != 0 || this.fov.hcM > 26214400) ? 1 : null;
                                } else {
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                                    obj2 = null;
                                }
                                iVar.hve = this.hDi;
                                iVar.field_mediaId = this.hCY;
                                iVar.field_fullpath = this.vlm.field_fileFullPath;
                                iVar.field_thumbpath = str;
                                iVar.field_fileType = obj2 != null ? com.tencent.mm.modelcdntran.b.htw : com.tencent.mm.modelcdntran.b.MediaType_FILE;
                                iVar.field_svr_signature = obj2 != null ? bi.oM(this.vlm.field_signature) : "";
                                iVar.field_onlycheckexist = obj2 != null ? bi.oN(this.vlm.field_signature) : false;
                                iVar.field_fake_bigfile_signature_aeskey = this.vlm.field_fakeAeskey;
                                iVar.field_fake_bigfile_signature = this.vlm.field_fakeSignature;
                                iVar.field_talker = dI.field_talker;
                                iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                                iVar.field_totalLen = bN2;
                                iVar.field_needStorage = false;
                                iVar.field_isStreamMedia = false;
                                iVar.field_enable_hitcheck = this.hDq;
                                iVar.field_chattype = s.eX(dI.field_talker) ? 1 : 0;
                                iVar.field_force_aeskeycdn = false;
                                iVar.field_trysafecdn = true;
                                x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", Long.valueOf(this.vlm.field_msgInfoId), iVar.field_fullpath, Integer.valueOf(bN2), str, Integer.valueOf(bN), this.hCY, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_onlycheckexist), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn), bi.Wz(iVar.field_aesKey), iVar.field_filemd5, bi.Wz(iVar.field_svr_signature), bi.Wz(iVar.field_fake_bigfile_signature_aeskey), bi.Wz(iVar.field_fake_bigfile_signature));
                                if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                                    if (this.vlm.field_isUseCdn != 1) {
                                        this.vlm.field_isUseCdn = 1;
                                        boolean c = an.aqK().c(this.vlm, new String[0]);
                                        if (!c) {
                                            x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + c);
                                            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                                            this.gLE.a(3, -1, "", this);
                                            obj = null;
                                        }
                                    }
                                    x.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", this.hCY);
                                    obj = 1;
                                } else {
                                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                                    this.hCY = "";
                                    obj = null;
                                }
                            }
                        }
                    }
                } else {
                    r2 = new Object[2];
                    com.tencent.mm.modelcdntran.g.MP();
                    r2[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(4));
                    r2[1] = Integer.valueOf(this.vlm.field_isUseCdn);
                    x.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", r2);
                    obj = null;
                }
            }
            if (obj != null) {
                x.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", Long.valueOf(this.vlp));
                return 0;
            } else if (this.vlm.field_netTimes > 3200) {
                l.fs(this.vlm.xrR);
                x.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.zo() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.vlp);
                return -1;
            } else {
                b bVar = this.vlm;
                bVar.field_netTimes++;
                if (bi.oN(this.vlm.field_clientAppDataId)) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    return -1;
                } else if (this.vlm.field_totalLen <= 0 || this.vlm.field_totalLen > 26214400) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.vlm.field_totalLen);
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    if (this.vlm.field_totalLen > 26214400) {
                        l.fs(this.vlm.xrR);
                    }
                    return -1;
                } else if (bi.oN(this.vlm.field_fileFullPath)) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    return -1;
                } else if (com.tencent.mm.a.e.bN(this.vlm.field_fileFullPath) > 26214400) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
                    l.fs(this.vlm.xrR);
                    return -1;
                } else {
                    byte[] e;
                    if (bi.oN(this.hcO)) {
                        e = com.tencent.mm.a.e.e(this.vlm.field_fileFullPath, (int) this.vlm.field_offset, 8192);
                    } else {
                        e = com.tencent.mm.a.e.e(this.vlm.field_fileFullPath, (int) this.vlm.field_offset, WXMediaMessage.THUMB_LENGTH_LIMIT);
                    }
                    if (bi.by(e)) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
                        this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                        return -1;
                    }
                    brk brk = (brk) this.gLB.hnQ.hnY;
                    brk.nlV = this.vlm.field_appId;
                    brk.vOK = (int) this.vlm.field_sdkVer;
                    brk.wZy = this.vlm.field_clientAppDataId;
                    brk.kzz = (int) this.vlm.field_type;
                    brk.kyG = q.FY();
                    brk.vPs = (int) this.vlm.field_totalLen;
                    brk.vPt = (int) this.vlm.field_offset;
                    if (this.hcO == null || !this.vlJ) {
                        brk.vPu = e.length;
                        brk.weD = new bes().bl(e);
                        if (this.hcO != null) {
                            brk.wgY = this.hcO;
                        }
                        return a(eVar, this.gLB, this);
                    }
                    brk.wgY = this.hcO;
                    brk.vPs = (int) this.vlm.field_totalLen;
                    brk.vPu = 0;
                    brk.weD = new bes().bl(new byte[0]);
                    this.vlJ = false;
                    return a(eVar, this.gLB, this);
                }
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
        if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else if (i2 == 0 && i3 == 0) {
            brl brl = (brl) ((b) qVar).hnR.hnY;
            if (brl.nlV != null && this.hcO == null && (!brl.nlV.equals(this.vlm.field_appId) || !brl.wZy.equals(this.vlm.field_clientAppDataId))) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.gLE.a(3, -1, "", this);
            } else if (brl.vPs < 0 || ((long) brl.vPs) != this.vlm.field_totalLen || brl.vPt < 0 || ((long) brl.vPt) > this.vlm.field_totalLen) {
                x.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
                this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                this.gLE.a(3, -1, "", this);
            } else {
                this.vlm.field_offset = (long) brl.vPt;
                this.vlm.field_mediaSvrId = l.Sl(brl.wgu) ? brl.wgu : "";
                if (this.vlm.field_status == 105) {
                    x.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.vlm.field_mediaSvrId + "," + this.vlm.field_offset + "] ");
                    this.gLE.a(i2, -1, "", this);
                    return;
                }
                if (this.vlm.field_offset == this.vlm.field_totalLen) {
                    if (bi.oN(this.vlm.field_mediaSvrId)) {
                        x.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
                        this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                        this.gLE.a(3, -1, "", this);
                        l.fs(this.vlm.xrR);
                        return;
                    }
                    this.vlm.field_status = 199;
                    g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.vlm.field_totalLen - this.vlK));
                }
                boolean c = an.aqK().c(this.vlm, new String[0]);
                if (!c) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + c);
                    this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
                    d(null);
                    this.gLE.a(3, -1, "", this);
                } else if (this.vlm.field_status == 199) {
                    this.gLE.a(0, 0, "", this);
                } else if (a(this.hok, this.gLE) < 0) {
                    x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
                    this.gLE.a(3, -1, "", this);
                }
            }
        } else {
            x.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + i2 + ", errCode = " + i3);
            this.retCode = -10000 - com.tencent.mm.compatible.util.g.getLine();
            if (i2 == 4) {
                g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Long.valueOf(this.vlm.field_totalLen - this.vlK));
            }
            this.gLE.a(i2, i3, str, this);
        }
    }

    protected final int Bo() {
        return 3200;
    }

    public final int getType() {
        return 220;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    final void d(keep_SceneResult keep_sceneresult) {
        if (this.vlm.field_type == 2) {
            com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100131");
            if (fp.isValid()) {
                this.gNG = t.getInt((String) fp.civ().get("needUploadData"), 1);
            }
            if (!this.gNE && this.gNG != 0) {
                this.gNH = keep_sceneresult;
                this.gNE = true;
                com.tencent.mm.sdk.b.b mrVar = new mr();
                com.tencent.mm.sdk.b.a.xmy.b(this.gNJ);
                mrVar.fFv.filePath = this.vlm.field_fileFullPath;
                com.tencent.mm.sdk.b.a.xmy.m(mrVar);
            }
        }
    }
}
