package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.brq;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class f extends k implements com.tencent.mm.network.k {
    private EmojiInfo fpO;
    private final b gLB;
    private e gLE;
    private boolean lEr = true;

    public f(EmojiInfo emojiInfo) {
        this.fpO = emojiInfo;
        a aVar = new a();
        aVar.hnT = new sj();
        aVar.hnU = new sk();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.hnS = 703;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        sj sjVar = (sj) this.gLB.hnQ.hnY;
        brq brq = new brq();
        if (this.fpO != null) {
            i.aCl().lCw.a(ad.getContext(), this.fpO);
            brq.wgY = this.fpO.Nx();
            brq.vPs = this.fpO.field_size;
            sjVar.whf.add(brq);
        }
    }

    public final int getType() {
        return 703;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        int i = 8192;
        int i2 = -1;
        this.gLE = eVar2;
        brq brq = (brq) ((sj) this.gLB.hnQ.hnY).whf.get(0);
        int i3;
        byte[] a;
        byte[] bArr;
        Object obj;
        if (this.lEr) {
            x.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + brq.wgY);
            brq.vPt = 0;
            i3 = this.fpO.field_size + 0;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.fpO.field_reserved4 & EmojiInfo.xJc) == EmojiInfo.xJc) {
                a = com.tencent.mm.plugin.emoji.e.e.aBy().a(this.fpO);
                if (bi.by(a)) {
                    x.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    x.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(a.length), Integer.valueOf(i));
                    System.arraycopy(a, 0, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.fpO.eL(0, i);
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            brq.vPt = 0;
            brq.wZI = new com.tencent.mm.bp.b(bArr);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Integer.valueOf(brq.wZI.oz.length);
            objArr[2] = Integer.valueOf(this.fpO == null ? -1 : this.fpO.field_start);
            if (this.fpO != null) {
                i2 = this.fpO.field_size;
            }
            objArr[3] = Integer.valueOf(i2);
            x.i(str, str2, objArr);
            return a(eVar, this.gLB, this);
        } else if (this.fpO == null || this.fpO.field_start == 0) {
            x.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            return -1;
        } else {
            i3 = this.fpO.field_size - this.fpO.field_start;
            if (i3 <= 8192) {
                i = i3;
            }
            if ((this.fpO.field_reserved4 & EmojiInfo.xJc) == EmojiInfo.xJc) {
                a = com.tencent.mm.plugin.emoji.e.e.aBy().a(this.fpO);
                if (bi.by(a)) {
                    x.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    obj = new byte[i];
                    x.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", Integer.valueOf(a.length), Integer.valueOf(i));
                    System.arraycopy(a, this.fpO.field_start, obj, 0, i);
                    bArr = obj;
                }
            } else {
                bArr = this.fpO.eL(this.fpO.field_start, i);
            }
            if (bArr == null || bArr.length <= 0) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                return -1;
            }
            i3 = bArr.length;
            brq.vPt = this.fpO.field_start;
            brq.wZI = new com.tencent.mm.bp.b(bArr);
            x.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", Integer.valueOf(bArr.length), Integer.valueOf(brq.wZI.oz.length));
            x.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.fpO.field_start + ", total:" + this.fpO.field_size + ", len:" + i3);
            return a(eVar, this.gLB, this);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            sj sjVar = (sj) ((b) qVar).hnQ.hnY;
            sk skVar = (sk) ((b) qVar).hnR.hnY;
            if (sjVar.whf.size() != skVar.whf.size()) {
                x.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + sjVar.whf.size() + ", resp size:" + skVar.whf.size());
                aCv();
                this.gLE.a(i2, i3, str, this);
                d(this.fpO, false);
                return;
            }
            brr brr = null;
            if (skVar.whf != null && skVar.whf.size() > 0) {
                brr = (brr) skVar.whf.get(0);
            }
            String str2;
            if (brr == null || brr.wgY == null || !brr.wgY.equals(this.fpO.Nx()) || brr.vPt < this.fpO.field_start) {
                int i4;
                String str3 = "MicroMsg.emoji.NetSceneEmojiUpload";
                str2 = "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d";
                Object[] objArr = new Object[5];
                objArr[0] = brr.wgY;
                objArr[1] = Integer.valueOf(brr.vPs);
                objArr[2] = Integer.valueOf(brr == null ? -1 : brr.vPt);
                if (this.fpO == null) {
                    i4 = -1;
                } else {
                    i4 = this.fpO.field_start;
                }
                objArr[3] = Integer.valueOf(i4);
                if (this.fpO == null) {
                    i4 = -1;
                } else {
                    i4 = this.fpO.field_size;
                }
                objArr[4] = Integer.valueOf(i4);
                x.e(str3, str2, objArr);
                aCv();
                this.gLE.a(4, -2, "", this);
                d(this.fpO, false);
                return;
            } else if (brr != null && this.fpO != null && brr.vQL != 0 && brr.vPt == brr.vPs && brr.vPt > 0) {
                x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", this.fpO.Nx(), Integer.valueOf(brr.vQL), Integer.valueOf(brr.vPt), Integer.valueOf(brr.vPs));
                aCv();
                this.gLE.a(i2, i3, "", this);
                return;
            } else if (skVar.wRa.vQL == 0 && (brr == null || brr.vQL == 0)) {
                if (this.lEr) {
                    this.lEr = false;
                }
                if (brr.vPt >= brr.vPs) {
                    this.fpO.field_start = 0;
                    this.fpO.field_state = EmojiInfo.xIV;
                    this.fpO.field_needupload = EmojiInfo.xJa;
                    i.aCl().lCw.p(this.fpO);
                    this.gLE.a(i2, i3, "", this);
                    d(this.fpO, true);
                    x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    return;
                }
                x.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", Integer.valueOf(brr.vPt));
                this.fpO.field_start = brr.vPt;
                i.aCl().lCw.p(this.fpO);
                if (a(this.hok, this.gLE) < 0) {
                    this.gLE.a(3, -1, "", this);
                    d(this.fpO, false);
                    return;
                }
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(skVar.wRa.vQL);
                objArr2[1] = Integer.valueOf(brr == null ? -1 : brr.vQL);
                x.e(str2, str4, objArr2);
                aCv();
                this.gLE.a(i2, i3, "", this);
                return;
            }
        }
        aCv();
        this.gLE.a(i2, i3, str, this);
        d(this.fpO, false);
    }

    protected final int Bo() {
        return 256;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    private void aCv() {
        this.fpO.field_start = 0;
        i.aCl().lCw.p(this.fpO);
    }

    private static void d(EmojiInfo emojiInfo, boolean z) {
        if (emojiInfo != null && !bi.oN(emojiInfo.Nx())) {
            x.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", emojiInfo.Nx(), Boolean.valueOf(z));
            com.tencent.mm.sdk.b.b crVar = new cr();
            crVar.frL.frM = emojiInfo.Nx();
            crVar.frL.fql = 0;
            crVar.frL.success = z;
            com.tencent.mm.sdk.b.a.xmy.m(crVar);
        }
    }
}
