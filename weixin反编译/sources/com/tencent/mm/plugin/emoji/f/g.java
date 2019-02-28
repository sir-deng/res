package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.cr;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.e.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.sp;
import com.tencent.mm.protocal.c.ti;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.y.as;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class g extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    public String hCY;
    boolean hpb;
    private int itU;
    public String lEs;
    public String lEt;
    public String lEu;
    private int lEv;
    private a lEw;
    EmojiGroupInfo lEx;

    static /* synthetic */ void ac(String str, boolean z) {
        if (!bi.oN(str)) {
            x.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", str, Boolean.valueOf(z));
            com.tencent.mm.sdk.b.b crVar = new cr();
            crVar.frL.frM = str;
            crVar.frL.fql = 2;
            crVar.frL.success = z;
            com.tencent.mm.sdk.b.a.xmy.m(crVar);
        }
    }

    private g(String str, String str2, String str3, int i, int i2) {
        this.hCY = "";
        this.lEw = new a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                if (bi.oN(g.this.hCY) || !str.equals(g.this.hCY)) {
                    x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
                } else if (i == -21006) {
                    x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", g.this.hCY);
                    g.g(g.this.lEs, 6, 0, g.this.hCY);
                } else if (i != 0) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", g.this.lEs);
                    g.g(g.this.lEs, -1, 0, g.this.hCY);
                } else if (keep_progressinfo != null) {
                    if (keep_progressinfo.field_finishedLength == keep_progressinfo.field_toltalLength) {
                        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
                    } else {
                        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", g.this.hCY, Integer.valueOf(keep_progressinfo.field_finishedLength), Integer.valueOf(keep_progressinfo.field_toltalLength));
                        if (!g.this.hpb) {
                            g.g(g.this.lEs, 6, (int) ((((float) keep_progressinfo.field_finishedLength) / ((float) keep_progressinfo.field_toltalLength)) * 100.0f), g.this.hCY);
                        }
                    }
                } else if (keep_sceneresult != null) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(10625, Integer.valueOf(2), keep_sceneresult.field_fileId, g.this.lEs, keep_sceneresult.field_transInfo);
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", g.this.lEs, Integer.valueOf(keep_sceneresult.field_retCode));
                        g.g(g.this.lEs, -1, 0, g.this.hCY);
                    } else {
                        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                        try {
                            c aBv = c.aBv();
                            String str2 = g.this.lEs;
                            if (aBv.lBi != null && aBv.lBi.contains(str2)) {
                                aBv.lBi.remove(str2);
                            }
                            EmojiLogic.a(g.this.lEs, g.this.lEt, g.this.lEx);
                            i.aCl().lCw.doNotify();
                            g.g(g.this.lEs, 7, 100, g.this.hCY);
                            File file = new File(com.tencent.mm.compatible.util.e.gJd + g.this.lEs);
                            if (file.isFile() && file.exists()) {
                                file.delete();
                            }
                            g.ac(g.this.lEs, true);
                        } catch (Exception e) {
                            x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bi.chl());
                            g.g(g.this.lEs, -1, 0, g.this.hCY);
                            g.ac(g.this.lEs, false);
                            return 0;
                        } catch (OutOfMemoryError e2) {
                            x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bi.chl());
                            g.g(g.this.lEs, -1, 0, g.this.hCY);
                            g.ac(g.this.lEs, false);
                            return 0;
                        }
                    }
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] h(String str, byte[] bArr) {
                return null;
            }
        };
        this.lEs = str;
        this.lEt = str3;
        this.lEu = str2;
        this.lEx = null;
        this.lEv = i;
        this.itU = i2;
        b.a aVar = new b.a();
        aVar.hnT = new ti();
        aVar.hnU = new tj();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.hnS = 423;
        aVar.hnV = com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX;
        aVar.hnW = 1000000213;
        this.gLB = aVar.Kf();
    }

    public g(String str, String str2, String str3) {
        this(str, str2, str3, 0, 0);
    }

    public g(String str, String str2) {
        this(str, null, str2, 0, 0);
    }

    public g(String str) {
        this(str, null, "", 1, 0);
    }

    public g(String str, byte b) {
        this(str, null, "", 1, 1);
    }

    public final int getType() {
        return 423;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (this.itU == 0) {
                File file = new File(com.tencent.mm.compatible.util.e.gJd);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                this.hCY = d.a("downzip", currentTimeMillis, stringBuilder.append(com.tencent.mm.y.c.Cn()).toString(), "emoji");
                sp spVar = ((tj) this.gLB.hnR.hnY).wiu;
                com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                iVar.field_mediaId = this.hCY;
                iVar.field_fullpath = com.tencent.mm.compatible.util.e.gJd + this.lEs;
                iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
                iVar.field_totalLen = spVar.wfl;
                iVar.field_aesKey = spVar.wgS;
                iVar.field_fileId = spVar.nlE;
                iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                iVar.hve = this.lEw;
                iVar.field_needStorage = true;
                this.hpb = false;
                if (!com.tencent.mm.modelcdntran.g.MP().b(iVar, -1)) {
                    x.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                x.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.gQm.a(i2, i3, str, this);
            as.CN().a(new k(this.lEs), 0);
            return;
        }
        this.gQm.a(i2, i3, str, this);
        g(this.lEs, -1, 0, this.hCY);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.gQm = eVar2;
        if (this.itU == 0) {
            g(this.lEs, 6, 0, this.hCY);
        }
        ti tiVar = (ti) this.gLB.hnQ.hnY;
        tiVar.vPI = this.lEs;
        tiVar.wis = this.lEu;
        tiVar.wit = this.lEv;
        tiVar.sfa = this.itU;
        return a(eVar, this.gLB, this);
    }

    static void g(String str, int i, int i2, String str2) {
        i.aCn().g(str, i, i2, str2);
    }

    protected final void cancel() {
        super.cancel();
        this.hpb = true;
    }
}
