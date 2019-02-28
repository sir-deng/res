package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.ab;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.g.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bso;
import com.tencent.mm.protocal.c.bsp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import junit.framework.Assert;

public final class h extends k implements com.tencent.mm.network.k {
    String fileName = null;
    private b gLB;
    private e gLE;
    private int hWm = 0;
    private keep_SceneResult hWn = null;
    private a hWo = null;

    interface a {
        void bn(int i, int i2);
    }

    public h(String str, int i, keep_SceneResult keep_sceneresult, a aVar) {
        boolean z = false;
        Assert.assertTrue(str != null);
        if (keep_sceneresult != null) {
            z = true;
        }
        Assert.assertTrue(z);
        Assert.assertTrue(true);
        this.fileName = str;
        this.hWn = keep_sceneresult;
        this.hWo = aVar;
        this.hWm = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        r nJ = t.nJ(this.fileName);
        if (nJ == null) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "Get info Failed file:" + this.fileName);
            this.hWo.bn(3, -1);
            return -1;
        }
        String HJ;
        int i;
        String str;
        String str2;
        Object[] objArr;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new bso();
        aVar.hnU = new bsp();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvideo";
        aVar.hnS = f.CTRL_INDEX;
        aVar.hnV = 39;
        aVar.hnW = 1000000039;
        this.gLB = aVar.Kf();
        bso bso = (bso) this.gLB.hnQ.hnY;
        bso.xap = 0;
        bso.xao = this.hWn.field_fileLength;
        bso.xaq = new bes().bl(new byte[0]);
        bso.wEB = 0;
        bso.wEA = this.hWn.field_thumbimgLength;
        bso.wEC = new bes().bl(new byte[0]);
        bso.npW = q.FY();
        bso.npV = this.hWn.field_toUser;
        bso.vOL = this.fileName;
        if (nJ.hXz == 1) {
            bso.xas = 2;
        }
        if (nJ.hXC == 3) {
            bso.xas = 3;
        }
        bso.xar = nJ.hXv;
        bso.wgy = ab.bC(ad.getContext()) ? 1 : 2;
        bso.wED = 2;
        bso.xag = this.hWn.field_thumbimgLength;
        bso.xat = this.hWn.field_fileId;
        bso.wzc = this.hWn.field_fileId;
        bso.vXF = 1;
        if (this.hWn.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", TS(), Boolean.valueOf(this.hWn.field_upload_by_safecdn), Integer.valueOf(this.hWn.field_UploadHitCacheType), Integer.valueOf(this.hWn.field_filecrc), this.hWn.field_aesKey);
            bso.wSq = 1;
            bso.vXE = "";
            bso.wze = "";
        } else {
            bso.vXE = this.hWn.field_aesKey;
            bso.wze = this.hWn.field_aesKey;
        }
        bso.xav = this.hWn.field_filemd5;
        bso.xaF = this.hWn.field_mp4identifymd5;
        bso.vXG = this.hWn.field_filecrc;
        if (this.hWm <= 0 || this.hWm > 1048576) {
            HJ = bd.HJ();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msgsource>");
            stringBuilder.append("<videopreloadlen>").append(this.hWm).append("</videopreloadlen>");
            stringBuilder.append("</msgsource>");
            g.pWK.a(354, 35, 1, false);
            HJ = stringBuilder.toString();
        }
        bso.vNR = HJ;
        bso.xaE = nJ.fHB;
        bnp bnp = nJ.hXE;
        if (bnp != null && !bi.oN(bnp.heZ)) {
            bso.xaw = bi.aD(bnp.heZ, "");
            bso.xax = bnp.wlG;
            bso.xay = bi.aD(bnp.hfb, "");
            bso.xaA = bi.aD(bnp.hfd, "");
            bso.xaz = bi.aD(bnp.hfc, "");
            bso.xaB = bi.aD(bnp.hfe, "");
        } else if (!(bnp == null || bi.oN(bnp.hfd) || bi.oN(bnp.hfc))) {
            bso.xaA = bnp.hfd;
            bso.xaz = bnp.hfc;
        }
        if (bnp != null) {
            bso.xaD = bi.aD(bnp.hff, "");
            bso.xaC = bi.aD(bnp.hfg, "");
        }
        o.Ub();
        Options Vq = d.Vq(s.ny(this.fileName));
        if (Vq != null) {
            bso.xai = Vq.outWidth;
            bso.xah = Vq.outHeight;
        } else {
            x.w("MicroMsg.NetSceneUploadVideoForCdn", "cdntra getImageOptions for thumb failed path:%s", HJ);
        }
        o.Ub();
        HJ = s.nx(this.fileName);
        n TZ = n.TZ();
        if (!bi.oN(HJ)) {
            a aVar2 = (a) TZ.hWJ.get(HJ);
            if (aVar2 != null) {
                i = aVar2.hXa;
                switch (i) {
                    case 1:
                        bso.vXH = 1;
                        bso.vON = 2;
                        break;
                    case 2:
                        bso.vXH = 1;
                        bso.vON = 1;
                        break;
                    case 3:
                    case 6:
                        bso.vXH = 2;
                        bso.vON = 3;
                        break;
                    case 7:
                        bso.vXH = 3;
                        bso.vON = 4;
                        break;
                    case 8:
                        bso.vXH = 1;
                        bso.vON = 5;
                        break;
                    default:
                        bso.vXH = 0;
                        bso.vON = 0;
                        break;
                }
                str = "MicroMsg.NetSceneUploadVideoForCdn";
                str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
                objArr = new Object[22];
                objArr[0] = TS();
                objArr[1] = this.fileName;
                objArr[2] = this.hWn.field_toUser;
                if (this.hWn.field_aesKey != null) {
                    i = -1;
                } else {
                    i = this.hWn.field_aesKey.length();
                }
                objArr[3] = Integer.valueOf(i);
                objArr[4] = this.hWn.field_fileId;
                objArr[5] = Integer.valueOf(this.hWn.field_thumbimgLength);
                objArr[6] = Integer.valueOf(bso.xai);
                objArr[7] = Integer.valueOf(bso.xah);
                objArr[8] = bi.Wz(bso.wze);
                objArr[9] = Integer.valueOf(bso.xas);
                objArr[10] = bso.xav;
                objArr[11] = Integer.valueOf(bso.wSq);
                objArr[12] = Integer.valueOf(bso.vXG);
                objArr[13] = bso.xaF;
                objArr[14] = bi.Wz(bso.vXE);
                objArr[15] = bso.xaw;
                objArr[16] = Integer.valueOf(bso.xax);
                objArr[17] = bso.xay;
                objArr[18] = bso.xaB;
                objArr[19] = bso.vNR;
                objArr[20] = Integer.valueOf(bso.vXH);
                objArr[21] = Integer.valueOf(bso.vON);
                x.i(str, str2, objArr);
                return a(eVar, this.gLB, this);
            }
        }
        i = 0;
        switch (i) {
            case 1:
                bso.vXH = 1;
                bso.vON = 2;
                break;
            case 2:
                bso.vXH = 1;
                bso.vON = 1;
                break;
            case 3:
            case 6:
                bso.vXH = 2;
                bso.vON = 3;
                break;
            case 7:
                bso.vXH = 3;
                bso.vON = 4;
                break;
            case 8:
                bso.vXH = 1;
                bso.vON = 5;
                break;
            default:
                bso.vXH = 0;
                bso.vON = 0;
                break;
        }
        str = "MicroMsg.NetSceneUploadVideoForCdn";
        str2 = "%s summersafecdn cdntra doscene file:%s touser:%s aes:%d fileid:%s thumb:[%d %d %d], thumbaeskey [%s] funcFlag: %d, md5:%s HitMd5:%d CRC32:%d, VideoNewMd5:%s AESKey:%s stream %s streamtime: %d title %s thumburl %s msgSource[%s] msgForwardType[%d] Source[%d]";
        objArr = new Object[22];
        objArr[0] = TS();
        objArr[1] = this.fileName;
        objArr[2] = this.hWn.field_toUser;
        if (this.hWn.field_aesKey != null) {
            i = this.hWn.field_aesKey.length();
        } else {
            i = -1;
        }
        objArr[3] = Integer.valueOf(i);
        objArr[4] = this.hWn.field_fileId;
        objArr[5] = Integer.valueOf(this.hWn.field_thumbimgLength);
        objArr[6] = Integer.valueOf(bso.xai);
        objArr[7] = Integer.valueOf(bso.xah);
        objArr[8] = bi.Wz(bso.wze);
        objArr[9] = Integer.valueOf(bso.xas);
        objArr[10] = bso.xav;
        objArr[11] = Integer.valueOf(bso.wSq);
        objArr[12] = Integer.valueOf(bso.vXG);
        objArr[13] = bso.xaF;
        objArr[14] = bi.Wz(bso.vXE);
        objArr[15] = bso.xaw;
        objArr[16] = Integer.valueOf(bso.xax);
        objArr[17] = bso.xay;
        objArr[18] = bso.xaB;
        objArr[19] = bso.vNR;
        objArr[20] = Integer.valueOf(bso.vXH);
        objArr[21] = Integer.valueOf(bso.vON);
        x.i(str, str2, objArr);
        return a(eVar, this.gLB, this);
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 1;
    }

    protected final void a(a aVar) {
        t.nC(this.fileName);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s cdntra onGYNetEnd errtype[%d %d]", TS(), Integer.valueOf(i2), Integer.valueOf(i3));
        bsp bsp = (bsp) ((b) qVar).hnR.hnY;
        r nJ = t.nJ(this.fileName);
        if (nJ == null) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd Get INFO FAILED :" + this.fileName);
            this.gLE.a(i2, i3, str, this);
            this.hWo.bn(3, -1);
        } else if (i2 == 4 && i3 == 102) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "summersafecdn ERR: MM_ERR_GET_AESKEY_FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nJ.Uk());
            this.gLE.a(i2, i3, str, this);
            this.hWo.bn(i2, i3);
        } else if (i2 == 4 && i3 == -22) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd BLACK  errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nJ.Uk());
            t.nD(this.fileName);
            this.gLE.a(i2, i3, str, this);
            this.hWo.bn(i2, i3);
        } else if (i2 == 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd SERVER FAILED errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nJ.Uk());
            t.nC(this.fileName);
            this.gLE.a(i2, i3, str, this);
            this.hWo.bn(i2, i3);
        } else if (i2 == 0 && i3 == 0) {
            nJ.hXt = bi.Wx();
            nJ.fGj = bsp.vNT;
            x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s dkmsgid  set svrmsgid %d -> %d", TS(), Long.valueOf(nJ.fGj), Integer.valueOf(r.ifO));
            if (!(CdnLogic.kMediaTypeFavoriteBigFile != r.ifN || r.ifO == 0 || nJ.fGj == 0)) {
                nJ.fGj = (long) r.ifO;
                r.ifO = 0;
            }
            nJ.status = 199;
            nJ.fEo = 1284;
            if (this.hWn.isUploadBySafeCDNWithMD5()) {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], old RecvXml[%s]", TS(), bsp.vXE, nJ.Un());
                if (bi.oN(bsp.vXE)) {
                    x.w("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn need aeskey but ret null", TS());
                } else {
                    x.i("MicroMsg.NetSceneUploadVideoForCdn", "cdn callback new build cdnInfo:%s", ((("<msg><videomsg aeskey=\"" + bsp.vXE + "\" cdnthumbaeskey=\"" + bsp.vXE + "\" cdnvideourl=\"" + this.hWn.field_fileId + "\" ") + "cdnthumburl=\"" + this.hWn.field_fileId + "\" ") + "length=\"" + this.hWn.field_fileLength + "\" ") + "cdnthumblength=\"" + this.hWn.field_thumbimgLength + "\"/></msg>");
                    nJ.hXB = r1;
                    s Ub = o.Ub();
                    o.Ub();
                    boolean p = Ub.p(s.nx(this.fileName), this.hWn.field_fileId, bsp.vXE);
                    g gVar = g.pWK;
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf((p ? 1 : 2) + 900);
                    objArr[1] = Integer.valueOf(nJ.hmZ);
                    gVar.h(12696, objArr);
                    x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s summersafecdn aeskey[%s], new RecvXml[%s], saveret[%b]", TS(), bsp.vXE, nJ.Un(), Boolean.valueOf(p));
                }
            }
            t.e(nJ);
            t.c(nJ);
            com.tencent.mm.modelstat.b.hRo.f(((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI((long) nJ.hXw));
            com.tencent.mm.k.a Xv = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Ff().Xv(nJ.Uk());
            boolean ciN = (Xv == null || ((int) Xv.gKO) <= 0) ? false : Xv.ciN();
            if (ciN || s.gU(nJ.Uk())) {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s upload to biz :%s", TS(), nJ.Uk());
                if (nJ.fGj < 0) {
                    x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + nJ.fGj + " file:" + this.fileName + " toUser:" + nJ.Uk());
                    t.nC(this.fileName);
                    this.hWo.bn(3, -1);
                }
            } else {
                x.i("MicroMsg.NetSceneUploadVideoForCdn", "%s not upload to biz", TS());
                if (nJ.fGj <= 0) {
                    x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: finish video invaild MSGSVRID :" + nJ.fGj + " file:" + this.fileName + " toUser:" + nJ.Uk());
                    t.nC(this.fileName);
                    this.hWo.bn(3, -1);
                }
            }
            this.gLE.a(i2, i3, str, this);
            this.hWo.bn(0, 0);
        } else {
            x.e("MicroMsg.NetSceneUploadVideoForCdn", "ERR: onGYNetEnd FAILED (WILL RETRY) errtype:" + i2 + " errCode:" + i3 + "  file:" + this.fileName + " user:" + nJ.Uk());
            t.nC(this.fileName);
            this.gLE.a(i2, i3, str, this);
            this.hWo.bn(i2, i3);
        }
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    private String TS() {
        return this.fileName + "_" + hashCode();
    }
}
