package com.tencent.mm.plugin.emoji.model;

import android.util.Base64;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.q;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.fp;
import com.tencent.mm.protocal.c.fq;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;
import java.io.File;

public final class c implements e {
    private com.tencent.mm.ap.a.c.c lDa = new com.tencent.mm.ap.a.c.c() {
        public final void a(boolean z, Object... objArr) {
            boolean booleanValue;
            sf sfVar;
            String I;
            String str;
            long currentTimeMillis;
            boolean f;
            Throwable e;
            String str2;
            String str3;
            Object[] objArr2;
            c cVar;
            File file;
            int bN;
            byte[] d;
            if (objArr == null || objArr.length < 2) {
                x.w("MicroMsg.emoji.EmojiAppMsgDownloadService", "extra obj error");
                return;
            }
            booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (objArr[0] instanceof sf) {
                sfVar = (sf) objArr[0];
            } else {
                sfVar = null;
            }
            if (sfVar == null) {
                x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msginfo or  emojiInfo");
                return;
            } else if (z) {
                as.Hm();
                I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", sfVar.wgP);
                str = I + "_encrypt";
                if (booleanValue) {
                    if (com.tencent.mm.a.e.bN(str) > 0) {
                        currentTimeMillis = System.currentTimeMillis();
                        try {
                            f = a.f(Base64.encodeToString(bi.Wj(sfVar.wgS), 0), str, I);
                            if (f) {
                                try {
                                    com.tencent.mm.plugin.emoji.c.cn(7);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                if (f) {
                                    b.deleteFile(str);
                                } else {
                                    str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                    str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                    objArr2 = new Object[5];
                                    objArr2[0] = sfVar.wgP;
                                    objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
                                    objArr2[2] = g.bV(str) == null ? "" : g.bV(str);
                                    objArr2[3] = sfVar.wgS;
                                    objArr2[4] = sfVar.wgR;
                                    x.i(str2, str3, objArr2);
                                    com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 0, 1, "", 1, "");
                                    b.deleteFile(str);
                                    cVar = c.this;
                                    c.bh(sfVar.wgP, 2);
                                    return;
                                }
                            }
                            com.tencent.mm.plugin.emoji.c.cn(8);
                            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            if (f) {
                                b.deleteFile(str);
                            } else {
                                str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                                str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                                objArr2 = new Object[5];
                                objArr2[0] = sfVar.wgP;
                                objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
                                if (g.bV(str) == null) {
                                }
                                objArr2[2] = g.bV(str) == null ? "" : g.bV(str);
                                objArr2[3] = sfVar.wgS;
                                objArr2[4] = sfVar.wgR;
                                x.i(str2, str3, objArr2);
                                com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 0, 1, "", 1, "");
                                b.deleteFile(str);
                                cVar = c.this;
                                c.bh(sfVar.wgP, 2);
                                return;
                            }
                        } catch (Throwable e3) {
                            Throwable th = e3;
                            f = false;
                            e = th;
                        }
                    } else {
                        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file aes download failed., try to download by cgi.emojiMd5:%s", sfVar.wgP);
                        com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 1, 1, "", 1, "");
                        cVar = c.this;
                        c.bh(sfVar.wgP, 2);
                        return;
                    }
                }
                file = new File(I);
                bN = com.tencent.mm.a.e.bN(I);
                d = com.tencent.mm.a.e.d(I, 0, 10);
                if (bN > 0 || d == null) {
                    c.a(c.this, sfVar, booleanValue);
                }
                String i = g.i(file);
                if (bi.oN(i) || !i.equalsIgnoreCase(sfVar.wgP)) {
                    x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult md5 check failed, try to download by cgi. buf md5:%s emojiMd5:%s field_cdnUrl:%s", i, sfVar.wgP, sfVar.nlE);
                    file.delete();
                    cVar = c.this;
                    c.bh(sfVar.wgP, 2);
                    if (booleanValue) {
                        com.tencent.mm.plugin.emoji.c.cn(5);
                        com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 0, 1, "", 1, "");
                        return;
                    }
                    com.tencent.mm.plugin.emoji.c.cn(5);
                    com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 2, 0, 1, "", 1, "");
                    return;
                }
                if (booleanValue) {
                    com.tencent.mm.plugin.emoji.c.cn(4);
                    com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 0, 0, "", 0, "");
                } else {
                    com.tencent.mm.plugin.emoji.c.cn(4);
                    com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 2, 0, 0, "", 1, "");
                }
                int i2 = EmojiInfo.xIS;
                if (p.bq(d)) {
                    i2 = EmojiInfo.xIR;
                } else {
                    i2 = EmojiInfo.xIS;
                }
                EmojiInfo YB = i.aCl().lCw.YB(i);
                if (YB == null) {
                    YB = new EmojiInfo();
                    YB.field_md5 = i;
                    YB.field_catalog = EmojiInfo.xIH;
                    YB.field_size = com.tencent.mm.a.e.bN(I);
                }
                YB.field_type = i2;
                YB.field_state = EmojiInfo.xIV;
                i.aCl().lCw.p(YB);
                c.bh(sfVar.wgP, 1);
                EmojiLogic.a(ad.getContext(), null, YB.Nx(), YB.ptV, YB);
                return;
            } else {
                c.a(c.this, sfVar, booleanValue);
                return;
            }
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file failed. exception:%s", bi.i(e));
            com.tencent.mm.plugin.emoji.c.cn(8);
            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "encrypt file use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (f) {
                str2 = "MicroMsg.emoji.EmojiAppMsgDownloadService";
                str3 = "handleCNDDownloadResult file aes failed. try to download by cgi.emojiMd5:%s buf size:%d buf md5:%s key:%s eUrl:%s ";
                objArr2 = new Object[5];
                objArr2[0] = sfVar.wgP;
                objArr2[1] = Integer.valueOf(com.tencent.mm.a.e.bN(str));
                if (g.bV(str) == null) {
                }
                objArr2[2] = g.bV(str) == null ? "" : g.bV(str);
                objArr2[3] = sfVar.wgS;
                objArr2[4] = sfVar.wgR;
                x.i(str2, str3, objArr2);
                com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 0, 1, "", 1, "");
                b.deleteFile(str);
                cVar = c.this;
                c.bh(sfVar.wgP, 2);
                return;
            }
            b.deleteFile(str);
            file = new File(I);
            bN = com.tencent.mm.a.e.bN(I);
            d = com.tencent.mm.a.e.d(I, 0, 10);
            if (bN > 0) {
            }
            c.a(c.this, sfVar, booleanValue);
        }
    };

    static /* synthetic */ void a(c cVar, sf sfVar, boolean z) {
        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "handleCNDDownloadResult file no exist., try to download by cgi.emojiMd5:%s", sfVar.wgP);
        if (z) {
            com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 3, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.cn(8);
        } else {
            com.tencent.mm.plugin.emoji.c.a(sfVar.wgP, 2, 1, 1, "", 1, "");
            com.tencent.mm.plugin.emoji.c.cn(3);
        }
        bh(sfVar.wgP, 2);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        switch (kVar.getType()) {
            case 221:
                return;
            case 697:
                String str2 = "";
                com.tencent.mm.plugin.emoji.f.e eVar = (com.tencent.mm.plugin.emoji.f.e) kVar;
                if (eVar.lEp == com.tencent.mm.plugin.emoji.f.e.lEn) {
                    fp fpVar = eVar.gLB == null ? null : (fp) eVar.gLB.hnQ.hnY;
                    if (!(fpVar == null || fpVar.vRZ == null || fpVar.vRZ.size() <= 0)) {
                        str2 = (String) fpVar.vRZ.get(0);
                    }
                    if (i == 0 && i2 == 0) {
                        fq fqVar = eVar.gLB == null ? null : (fq) eVar.gLB.hnR.hnY;
                        if (fqVar == null || fqVar.vSb == null || fqVar.vSb.size() <= 0) {
                            bh(str2, 2);
                            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "NetSceneBatchEmojiDownLoad MD5 to URL failed.");
                            return;
                        }
                        sf sfVar = (sf) fqVar.vSb.get(0);
                        as.Hm();
                        String I = EmojiLogic.I(com.tencent.mm.y.c.Fw(), "", sfVar.wgP);
                        com.tencent.mm.ap.a.a aBL;
                        String str3;
                        String str4;
                        if (!bi.oN(sfVar.wgR) && !bi.oN(sfVar.wgS)) {
                            aBL = i.aBL();
                            str3 = sfVar.wgR;
                            str4 = sfVar.wgR;
                            aBL.a(str3, f.i(I + "_encrypt", sfVar, Boolean.valueOf(true)), this.lDa);
                            com.tencent.mm.plugin.emoji.c.cn(6);
                            return;
                        } else if (bi.oN(sfVar.nlE)) {
                            x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no url info. download faild.");
                            bh(str2, 2);
                            return;
                        } else {
                            aBL = i.aBL();
                            str3 = sfVar.nlE;
                            str4 = sfVar.nlE;
                            aBL.a(str3, f.h(I, sfVar, Boolean.valueOf(false)), this.lDa);
                            com.tencent.mm.plugin.emoji.c.cn(1);
                            return;
                        }
                    }
                    bh(str2, 2);
                    return;
                }
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no request type ");
                return;
            default:
                x.i("MicroMsg.emoji.EmojiAppMsgDownloadService", "no download app attach scene");
                return;
        }
    }

    public static void bh(String str, int i) {
        com.tencent.mm.sdk.b.b qVar = new q();
        qVar.foq.for = str;
        qVar.foq.status = i;
        qVar.foq.fos = 0;
        com.tencent.mm.sdk.b.a.xmy.m(qVar);
        x.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "attachid:%s percentage:%d status:%d", str, Integer.valueOf(0), Integer.valueOf(i));
    }
}
