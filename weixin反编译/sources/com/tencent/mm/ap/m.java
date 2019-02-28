package com.tencent.mm.ap;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.bsg;
import com.tencent.mm.protocal.c.bsh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private int gNB;
    private e hDF;
    private a hDG;

    interface a {
        void a(long j, int i, int i2, int i3);
    }

    public m(int i, bsg bsg, e eVar, keep_SceneResult keep_sceneresult, a aVar) {
        int i2;
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new bsg();
        aVar2.hnU = new bsh();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        this.gLB = aVar2.Kf();
        this.hDG = aVar;
        this.gNB = i;
        this.hDF = eVar;
        bsg bsg2 = (bsg) this.gLB.hnQ.hnY;
        bsg2.vNM = bsg.vNM;
        bsg2.vNN = bsg.vNN;
        bsg2.xaa = bsg.xaa;
        bsg2.nlX = bsg.nlX;
        bsg2.vNR = bsg.vNR;
        bsg2.vXH = bsg.vXH;
        Options Vq = d.Vq(o.PC().m(eVar.hBD, "", ""));
        bsg2.xai = Vq != null ? Vq.outWidth : 0;
        if (Vq != null) {
            i2 = Vq.outHeight;
        } else {
            i2 = 0;
        }
        bsg2.xah = i2;
        bsg2.xaf = keep_sceneresult.field_fileId;
        bsg2.xag = keep_sceneresult.field_thumbimgLength;
        bsg2.vPs = keep_sceneresult.field_thumbimgLength;
        bsg2.vPt = 0;
        bsg2.vPu = keep_sceneresult.field_thumbimgLength;
        bsg2.weD = new bes().bl(new byte[0]);
        bsg2.nlV = bsg.nlV;
        bsg2.vMr = bsg.vMr;
        bsg2.vMt = bsg.vMt;
        bsg2.vMs = bsg.vMs;
        bsg2.vXF = 1;
        if (keep_sceneresult.isUploadBySafeCDNWithMD5()) {
            x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(keep_sceneresult.field_upload_by_safecdn), Integer.valueOf(keep_sceneresult.field_UploadHitCacheType), Integer.valueOf(keep_sceneresult.field_filecrc), keep_sceneresult.field_aesKey);
            bsg2.wSq = 1;
            bsg2.vXE = "";
            bsg2.wze = "";
        } else {
            bsg2.vXE = keep_sceneresult.field_aesKey;
            bsg2.wze = keep_sceneresult.field_aesKey;
        }
        bsg2.wto = bsg.wto;
        if (bsg.wto == 1) {
            bsg2.xad = keep_sceneresult.field_fileLength;
            bsg2.xae = keep_sceneresult.field_midimgLength;
            bsg2.xab = keep_sceneresult.field_fileId;
            bsg2.xac = keep_sceneresult.field_fileId;
        } else {
            bsg2.xad = 0;
            bsg2.xae = keep_sceneresult.field_fileLength;
            bsg2.xab = "";
            bsg2.xac = keep_sceneresult.field_fileId;
        }
        bsg2.vXG = keep_sceneresult.field_filecrc;
        bsg2.wgP = keep_sceneresult.field_filemd5;
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", Integer.valueOf(bsg2.vXH), Integer.valueOf(bsg2.wSq), bi.Wz(bsg2.vXE), Integer.valueOf(bsg2.vXG));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", ((bsg) this.gLB.hnQ.hnY).toString());
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        bsh bsh = (bsh) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", Integer.valueOf(bsh.pgR), Long.valueOf(bsh.vNT));
        if (this.hDG != null) {
            this.hDG.a(bsh.vNT, bsh.pgR, i2, i3);
        }
        this.gLE.a(0, 0, "", this);
    }

    public final int getType() {
        return 110;
    }
}
