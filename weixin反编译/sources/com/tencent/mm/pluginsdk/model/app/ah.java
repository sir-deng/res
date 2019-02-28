package com.tencent.mm.pluginsdk.model.app;

import android.util.Base64;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.f;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.n;
import com.tencent.mm.f.a.tw;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.c.bgw;
import com.tencent.mm.protocal.c.bnd;
import com.tencent.mm.protocal.c.db;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.t;
import com.tencent.mm.y.u;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.Locale;
import junit.framework.Assert;

public final class ah extends k implements com.tencent.mm.network.k {
    au fFE = null;
    long frh = 0;
    private b gLB;
    e gLE;
    String hCY = "";
    private a hDi = new a() {
        public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, final keep_SceneResult keep_sceneresult, boolean z) {
            x.d("MicroMsg.NetSceneSendAppMsg", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", ah.this.hCY, Integer.valueOf(i), keep_progressinfo, keep_sceneresult);
            if (i == -21005) {
                x.d("MicroMsg.NetSceneSendAppMsg", "cdntra  ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", ah.this.hCY);
                return 0;
            } else if (i != 0) {
                ah.this.fFE.eR(5);
                d.pVE.a(111, 34, 1, true);
                as.Hm();
                c.Fh().a(ah.this.fFE.field_msgId, ah.this.fFE);
                g.pWK.h(10421, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(0), "");
                ah.this.gLE.a(3, i, "", ah.this);
                return 0;
            } else {
                if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.NetSceneSendAppMsg", "cdntra sceneResult.retCode :%d arg[%s] info[%s]", Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult.field_arg, keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        ah.this.fFE.eR(5);
                        d.pVE.a(111, 34, 1, true);
                        as.Hm();
                        c.Fh().a(ah.this.fFE.field_msgId, ah.this.fFE);
                        g.pWK.h(10421, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        g.pWK.h(13937, Integer.valueOf(keep_sceneresult.field_retCode), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                        ah.this.gLE.a(3, keep_sceneresult.field_retCode, "", ah.this);
                    } else {
                        if (ah.this.hWg > 0 && keep_sceneresult.field_fileLength > 0) {
                            ak.s("SendAppMsgThumbTooBig", ah.this.hWg + "," + keep_sceneresult.field_fileLength + "," + keep_sceneresult.field_fileId, ah.this.hWg * 2 > keep_sceneresult.field_fileLength);
                        }
                        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(keep_sceneresult.field_exist_whencheck), bi.Wz(keep_sceneresult.field_aesKey), keep_sceneresult.field_filemd5);
                        as.CN().a(new ai(ah.this.frh, false, keep_sceneresult, new a() {
                            public final void bn(int i, int i2) {
                                x.d("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra NetSceneSendAppMsgForCdn callback %d,%d", Integer.valueOf(i), Integer.valueOf(i2));
                                g.pWK.h(10421, Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(ah.this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_FILE), Integer.valueOf(keep_sceneresult.field_fileLength), keep_sceneresult.field_transInfo, "", "", "", "", "", "", "", keep_sceneresult.report_Part2);
                                ah.this.gLE.a(i, i2, "", ah.this);
                            }
                        }, ah.this.iNG, null), 0);
                    }
                }
                return 0;
            }
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] h(String str, byte[] bArr) {
            return null;
        }
    };
    int hWg = 0;
    String iNG;
    private String rRn;
    private tw rah;
    long startTime = 0;
    private n vlC;

    public ah(long j, String str, String str2) {
        this.frh = j;
        this.iNG = str;
        this.rRn = str2;
        b.a aVar = new b.a();
        aVar.hnT = new bgv();
        aVar.hnU = new bgw();
        aVar.uri = "/cgi-bin/micromsg-bin/sendappmsg";
        aVar.hnS = 222;
        aVar.hnV = 107;
        aVar.hnW = 1000000107;
        this.gLB = aVar.Kf();
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn NetSceneSendAppMsg msgid[%d], sessionid[%s], signature[%s], stack[%s]", Long.valueOf(j), str, bi.Wz(str2), bi.chl());
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        if (this.startTime == 0) {
            this.startTime = bi.Wy();
        }
        as.Hm();
        this.fFE = c.Fh().dI(this.frh);
        if (this.fFE == null || this.fFE.field_msgId != this.frh) {
            return -1;
        }
        com.tencent.mm.x.g.a aVar;
        com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.fFE.field_content);
        if (fV == null) {
            aj XW = aj.XW(this.fFE.field_content);
            if (bi.oN(XW.xGZ)) {
                fV = new com.tencent.mm.x.g.a();
                fV.hcO = XW.frM;
                fV.type = 8;
                x.i("MicroMsg.NetSceneSendAppMsg", "create new content. loss appid");
                aVar = fV;
            } else {
                aVar = com.tencent.mm.x.g.a.fV(XW.xGZ);
            }
        } else {
            aVar = fV;
        }
        Assert.assertTrue("content != null [[" + this.fFE.field_content + "]]", aVar != null);
        if (aVar == null) {
            this.fFE = null;
            return -1;
        }
        String str;
        Object obj;
        String str2 = "";
        if (bi.oN(this.fFE.field_imgPath)) {
            str = str2;
        } else {
            str = o.PC().lp(this.fFE.field_imgPath);
        }
        if (aVar.type == 8 || aVar.type == 9 || aVar.type == 6) {
            x.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support Emoji or voiceremind now type:%d", Integer.valueOf(aVar.type));
            obj = null;
        } else if (bi.oN(str)) {
            x.i("MicroMsg.NetSceneSendAppMsg", "cdntra cdn not support no thumb msg type:%d", Integer.valueOf(aVar.type));
            obj = null;
        } else {
            this.hWg = com.tencent.mm.a.e.bN(str);
            if (aVar.type == 33 || aVar.type == 36 || this.hWg < 262144) {
                x.i("MicroMsg.NetSceneSendAppMsg", "cdntra content.type:%d  thumbPath:%s,  thumbLength:%d ", Integer.valueOf(aVar.type), str, Integer.valueOf(this.hWg));
                if (bi.oN(aVar.for)) {
                    com.tencent.mm.modelcdntran.g.MP();
                    if (com.tencent.mm.modelcdntran.c.hx(4)) {
                        this.hCY = com.tencent.mm.modelcdntran.d.a("upappmsg", this.fFE.field_createTime, this.fFE.field_talker, this.fFE.field_msgId);
                        if (bi.oN(this.hCY)) {
                            x.w("MicroMsg.NetSceneSendAppMsg", "cdntra genClientId failed not use cdn msgid:%d", Long.valueOf(this.fFE.field_msgId));
                            obj = null;
                        } else {
                            i iVar = new i();
                            iVar.hve = this.hDi;
                            iVar.field_mediaId = this.hCY;
                            iVar.field_fullpath = "";
                            iVar.field_thumbpath = str;
                            iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                            iVar.field_talker = this.fFE.field_talker;
                            iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                            iVar.field_needStorage = false;
                            iVar.field_isStreamMedia = false;
                            iVar.hve = this.hDi;
                            iVar.field_force_aeskeycdn = true;
                            iVar.field_trysafecdn = false;
                            x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra checkUseCdn content.type[%d], thumb[%s], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b], force_aeskeycdn[%b], trysafecdn[%b]", Integer.valueOf(aVar.type), str, this.hCY, Integer.valueOf(iVar.field_fileType), Boolean.valueOf(iVar.field_enable_hitcheck), Boolean.valueOf(iVar.field_onlycheckexist), Boolean.valueOf(iVar.field_force_aeskeycdn), Boolean.valueOf(iVar.field_trysafecdn));
                            if (com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                                obj = 1;
                            } else {
                                x.e("MicroMsg.NetSceneSendAppMsg", "cdntra addSendTask failed.");
                                this.hCY = "";
                                obj = null;
                            }
                        }
                    } else {
                        Object[] objArr = new Object[1];
                        com.tencent.mm.modelcdntran.g.MP();
                        objArr[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hx(4));
                        x.w("MicroMsg.NetSceneSendAppMsg", "cdntra not use cdn flag:%b ", objArr);
                        obj = null;
                    }
                } else {
                    x.w("MicroMsg.NetSceneSendAppMsg", "cdntra attach has been upload by cdn msgid:%d", Long.valueOf(this.frh));
                    obj = null;
                }
            } else {
                x.w("MicroMsg.NetSceneSendAppMsg", "cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", str, Integer.valueOf(this.hWg));
                obj = null;
            }
        }
        if (obj != null) {
            x.d("MicroMsg.NetSceneSendAppMsg", "cdntra use cdn return -1 for onGYNetEnd clientId:%s", this.hCY);
            return 0;
        }
        String str3;
        bgv bgv = (bgv) this.gLB.hnQ.hnY;
        db dbVar = new db();
        dbVar.nlV = aVar.appId;
        dbVar.vOL = this.fFE.field_talker + this.fFE.field_msgId + "T" + this.fFE.field_createTime;
        dbVar.noL = com.tencent.mm.x.g.a.a(aVar, null, null, 0, 0);
        dbVar.pgR = (int) bi.Wx();
        dbVar.npV = this.fFE.field_talker;
        dbVar.npW = q.FY();
        dbVar.kzz = aVar.type;
        dbVar.vOK = aVar.sdkVer;
        dbVar.vON = aVar.hcP;
        if (f.eG(this.fFE.field_talker)) {
            dbVar.vNR = com.tencent.mm.af.a.e.ku(this.fFE.gkD);
        } else {
            dbVar.vNR = bd.HJ();
        }
        dbVar.vOP = aVar.fHx;
        dbVar.vOQ = aVar.fHy;
        dbVar.vOR = aVar.fHz;
        u.b hB = u.GQ().hB(this.iNG);
        if (hB != null) {
            this.rah = new tw();
            this.rah.fNj.url = aVar.url;
            this.rah.fNj.fNk = hB.getString("prePublishId", "");
            this.rah.fNj.fNm = hB.getString("preUsername", "");
            this.rah.fNj.fNn = hB.getString("preChatName", "");
            this.rah.fNj.fNo = hB.getInt("preMsgIndex", 0);
            this.rah.fNj.fNs = hB.getInt("sendAppMsgScene", 0);
            this.rah.fNj.fNt = hB.getInt("getA8KeyScene", 0);
            this.rah.fNj.fNu = hB.getString("referUrl", null);
            this.rah.fNj.fNv = hB.getString("adExtStr", null);
            this.rah.fNj.fNp = this.fFE.field_talker;
            this.rah.fNj.fNw = aVar.title;
            as.Hm();
            com.tencent.mm.storage.x Xv = c.Ff().Xv(this.fFE.field_talker);
            if (Xv != null) {
                this.rah.fNj.fNq = Xv.AW();
            }
            this.rah.fNj.fNr = m.gn(this.fFE.field_talker);
            str3 = "";
            if (aVar.fHB != null) {
                bnd bnd = new bnd();
                try {
                    bnd.aH(Base64.decode(aVar.fHB, 0));
                    if (bnd.wXe != null) {
                        str3 = bnd.wXe.nhB;
                    }
                } catch (Exception e) {
                }
            }
            bgv.wSp = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.rah.fNj.fNk, this.rah.fNj.fNm, this.rah.fNj.fNn, Integer.valueOf(t.N(this.rah.fNj.fNm, this.rah.fNj.fNn)), Integer.valueOf(this.rah.fNj.fNt), str3});
        }
        if (hB != null && aVar.type == 33) {
            this.vlC = new n();
            int i = hB.getInt("fromScene", 1);
            this.vlC.fog.scene = i;
            this.vlC.fog.foo = hB.getInt("appservicetype", 0);
            String string = hB.getString("preChatName", "");
            if (2 == i) {
                this.vlC.fog.foi = string + ":" + hB.getString("preUsername", "");
            } else {
                this.vlC.fog.foi = string;
            }
            str3 = this.fFE.field_talker;
            boolean z = hB.getBoolean("moreRetrAction", false);
            if (str3.endsWith("@chatroom")) {
                this.vlC.fog.action = z ? 5 : 2;
            } else {
                this.vlC.fog.action = z ? 4 : 1;
            }
            this.vlC.fog.foh = aVar.hfp + 1;
            this.vlC.fog.foj = aVar.hfh;
            this.vlC.fog.foe = aVar.hfi;
            this.vlC.fog.appId = aVar.hfj;
            this.vlC.fog.fol = bi.Wx();
            this.vlC.fog.fom = 1;
        }
        x.d("MicroMsg.NetSceneSendAppMsg", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", aVar.fHx, aVar.fHy, aVar.fHz);
        if (!bi.oN(str)) {
            byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
            if (!bi.by(d)) {
                dbVar.vOM = new bes().bl(d);
            }
        }
        str3 = "MicroMsg.NetSceneSendAppMsg";
        String str4 = "doScene thumbFile:[%s] thumbdata:%d";
        Object[] objArr2 = new Object[2];
        objArr2[0] = str;
        objArr2[1] = Integer.valueOf(dbVar.vOM != null ? dbVar.vOM.wRk : -1);
        x.d(str3, str4, objArr2);
        bgv.wSn = dbVar;
        if (aVar.hcQ != 0 || aVar.hcM > 26214400) {
            bgv.vPv = com.tencent.mm.modelcdntran.b.htw;
        }
        bgv.wgP = aVar.filemd5;
        bgv.hxh = this.rRn;
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn file md5[%s], signature[%s], type[%d], fromScene[%s]", bgv.wgP, bi.Wz(bgv.hxh), Integer.valueOf(bgv.vPv), bgv.wSp);
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendAppMsg", "summersafecdn cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(this.frh), this.fFE.field_content);
        if (i2 == 3 && i3 == -1 && !bi.oN(this.hCY)) {
            x.w("MicroMsg.NetSceneSendAppMsg", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", this.hCY);
        } else if (i2 == 0 && i3 == 0) {
            bgw bgw = (bgw) ((b) qVar).hnR.hnY;
            bgv bgv = (bgv) ((b) qVar).hnQ.hnY;
            this.fFE.eR(2);
            this.fFE.ap(bgw.vNT);
            as.Hm();
            c.Fh().a(this.fFE.field_msgId, this.fFE);
            com.tencent.mm.modelstat.b.hRo.a(this.fFE, h.g(this.fFE));
            if (!(this.rah == null || bi.oN(this.rah.fNj.url))) {
                this.rah.fNj.fNl = "msg_" + Long.toString(bgw.vNT);
                com.tencent.mm.sdk.b.a.xmy.m(this.rah);
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.fFE.field_content);
            if (fV != null && "wx4310bbd51be7d979".equals(fV.appId)) {
                Object obj = (bi.oN(this.fFE.field_talker) || !this.fFE.field_talker.endsWith("@chatroom")) ? null : 1;
                String str2 = "";
                try {
                    str2 = URLEncoder.encode(fV.description, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneSendAppMsg", e, "", new Object[0]);
                }
                x.i("MicroMsg.NetSceneSendAppMsg", "androidSystemShareFixed(13717) %s", "1," + (obj != null ? 2 : 1) + ",," + str2);
                g.pWK.k(13717, r0);
            }
            if (this.vlC != null) {
                this.vlC.fog.fok = "msg_" + this.fFE.field_msgSvrId;
                com.tencent.mm.sdk.b.a.xmy.m(this.vlC);
            }
            if (bgv.wSn.vOM != null) {
                g.pWK.h(10420, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(bgv.wSn.vOM.wRk));
            }
            this.gLE.a(i2, i3, str, this);
        } else {
            this.fFE.eR(5);
            d.pVE.a(111, 34, 1, true);
            as.Hm();
            c.Fh().a(this.fFE.field_msgId, this.fFE);
            x.e("MicroMsg.NetSceneSendAppMsg", "send app msg failed, err=" + i2 + "," + i3 + ", msgId " + this.fFE.field_msgId);
            if (i2 == 4) {
                g.pWK.h(10420, Integer.valueOf(i3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bi.Wy()), Integer.valueOf(com.tencent.mm.modelcdntran.d.bi(ad.getContext())), Integer.valueOf(com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE), Integer.valueOf(0));
            }
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 222;
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }
}
