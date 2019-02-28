package com.tencent.mm.plugin.emoji.f;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.af.f;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.protocal.c.si;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.x.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bd;
import com.tencent.mm.y.c;
import junit.framework.Assert;

public final class r extends k implements com.tencent.mm.network.k {
    private EmojiInfo fpO;
    private final b gLB;
    private e gLE;
    private long hBI;
    private boolean lEr;

    public r(String str, String str2, EmojiInfo emojiInfo, long j) {
        this(str, str2, emojiInfo, j, (byte) 0);
    }

    private r(String str, String str2, EmojiInfo emojiInfo, long j, byte b) {
        int i = 1;
        this.lEr = true;
        this.hBI = 0;
        boolean z = (str2 == null || str2.length() <= 0 || emojiInfo == null) ? false : true;
        Assert.assertTrue(z);
        this.hBI = j;
        this.fpO = emojiInfo;
        a aVar = new a();
        aVar.hnT = new brs();
        aVar.hnU = new brt();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.hnS = ac.CTRL_BYTE;
        aVar.hnV = 68;
        aVar.hnW = 1000000068;
        this.gLB = aVar.Kf();
        i.aCl().lCw.a(ad.getContext(), emojiInfo);
        brs brs = (brs) this.gLB.hnQ.hnY;
        sh shVar = new sh();
        shVar.wgY = emojiInfo.Nx();
        shVar.whc = str;
        shVar.npV = str2;
        shVar.vPs = emojiInfo.field_size;
        shVar.wha = emojiInfo.wl();
        shVar.kzz = emojiInfo.field_type;
        shVar.vNR = bd.HJ();
        shVar.whd = 0;
        if (str2.endsWith("@chatroom")) {
            i = 2;
        }
        if (emojiInfo.field_catalog == EmojiInfo.xIM) {
            shVar.whb = "56,2," + i;
        } else if (emojiInfo.field_catalog == EmojiInfo.xIL) {
            shVar.whb = "56,1," + i;
        }
        brs.whf.add(shVar);
        brs.wZJ = brs.whf.size();
    }

    public final int getType() {
        return ac.CTRL_BYTE;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        this.gLE = eVar2;
        sh shVar = (sh) ((brs) this.gLB.hnQ.hnY).whf.get(0);
        if (this.lEr) {
            x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + shVar.wgY);
            shVar.wgZ = new bes();
            shVar.vPt = 0;
            return a(eVar, this.gLB, this);
        }
        byte[] bArr;
        int i2 = this.fpO.field_size - this.fpO.field_start;
        if (i2 <= 8192) {
            i = i2;
        }
        if ((this.fpO.field_reserved4 & EmojiInfo.xJc) == EmojiInfo.xJc) {
            byte[] a = com.tencent.mm.plugin.emoji.e.e.aBy().a(this.fpO);
            if (bi.by(a)) {
                x.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                bArr = new byte[0];
            } else {
                Object obj = new byte[i];
                x.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", Integer.valueOf(a.length), Integer.valueOf(i));
                System.arraycopy(a, this.fpO.field_start, obj, 0, i);
                bArr = obj;
            }
        } else {
            bArr = this.fpO.eL(this.fpO.field_start, i);
        }
        if (EmojiLogic.al(bArr) == EmojiInfo.xID && this.lEr) {
            x.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.fpO.cli();
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            x.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            return -1;
        } else {
            i2 = bArr.length;
            shVar.vPt = this.fpO.field_start;
            shVar.wgZ = new bes().b(com.tencent.mm.bp.b.be(bArr));
            if (f.eG(shVar.npV)) {
                as.Hm();
                shVar.vNR = com.tencent.mm.af.a.e.ku(c.Fh().dI(this.hBI).gkD);
                x.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", shVar.vNR);
            }
            x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.fpO.field_start + ", total:" + this.fpO.field_size + ", len:" + i2);
            return a(eVar, this.gLB, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            brs brs = (brs) ((b) qVar).hnQ.hnY;
            brt brt = (brt) ((b) qVar).hnR.hnY;
            if (brs.whf.size() != brt.whf.size()) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + brt.whf.size() + ", resp size:" + brs.whf.size());
                this.gLE.a(i2, i3, str, this);
                return;
            }
            si siVar = (si) brt.whf.get(0);
            if (siVar.wgY == null || !siVar.wgY.equals(this.fpO.Nx()) || siVar.vPt < this.fpO.field_start) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + siVar.vPt + ", size=" + this.fpO.field_size);
                this.gLE.a(4, -2, "", this);
                this.fpO.field_start = 0;
                i.aCl().lCw.q(this.fpO);
                return;
            } else if (brt.wRa.vQL != 0) {
                x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", Integer.valueOf(brt.wRa.vQL));
                this.gLE.a(4, -2, "", this);
                return;
            } else {
                if (this.lEr) {
                    this.lEr = false;
                }
                if (siVar.vPt >= siVar.vPs) {
                    x.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + siVar.whe);
                    as.Hm();
                    au dI = c.Fh().dI(this.hBI);
                    x.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", Integer.valueOf(siVar.whe), Integer.valueOf(com.tencent.mm.platformtools.r.ifO));
                    if (CdnLogic.kMediaTypeFavoriteBigFile == com.tencent.mm.platformtools.r.ifN && com.tencent.mm.platformtools.r.ifO != 0) {
                        siVar.whe = com.tencent.mm.platformtools.r.ifO;
                        com.tencent.mm.platformtools.r.ifO = 0;
                    }
                    dI.ap((long) siVar.whe);
                    as.Hm();
                    c.Fh().a(this.hBI, dI);
                    this.fpO.field_start = 0;
                    this.fpO.field_lastUseTime = System.currentTimeMillis();
                    this.fpO.field_state = EmojiInfo.xIV;
                    i.aCl().lCw.q(this.fpO);
                    if (dI.aNJ()) {
                        com.tencent.mm.modelstat.b.hRo.a(dI, h.g(dI));
                    } else {
                        com.tencent.mm.modelstat.b.hRo.f(dI);
                    }
                    this.gLE.a(i2, i3, "", this);
                    return;
                }
                this.fpO.field_start = siVar.vPt;
                this.fpO.field_lastUseTime = System.currentTimeMillis();
                i.aCl().lCw.q(this.fpO);
                if (a(this.hok, this.gLE) < 0) {
                    this.gLE.a(3, -1, "", this);
                    return;
                }
                return;
            }
        }
        x.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.gLE.a(i2, i3, str, this);
    }

    protected final int Bo() {
        return 256;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }
}
