package com.tencent.mm.plugin.emoji.f;

import android.text.TextUtils;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.a.mi;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.g.c.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.acb;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.sr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.c;
import java.util.Iterator;
import java.util.List;

public final class k extends com.tencent.mm.ad.k implements com.tencent.mm.network.k {
    public final b gLB;
    private e gQm;
    private a lEH;
    private boolean lEI = false;
    private mi lEJ = null;
    public String lEi = "";

    public k(String str) {
        b.a aVar = new b.a();
        aVar.hnT = new acb();
        aVar.hnU = new acc();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar.hnS = 521;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        this.lEi = str;
        this.lEJ = new mi();
    }

    public k(String str, a aVar) {
        b.a aVar2 = new b.a();
        aVar2.hnT = new acb();
        aVar2.hnU = new acc();
        aVar2.uri = "/cgi-bin/micromsg-bin/getemotiondesc";
        aVar2.hnS = 521;
        aVar2.hnV = 0;
        aVar2.hnW = 0;
        this.gLB = aVar2.Kf();
        this.lEi = str;
        this.lEH = aVar;
        this.lEI = true;
        this.lEJ = new mi();
    }

    public final int getType() {
        return 521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionDesc", "getEmotionDesc %s ", this.lEi);
        this.gQm = eVar2;
        ((acb) this.gLB.hnQ.hnY).vPI = this.lEi;
        if (!TextUtils.isEmpty(this.lEi)) {
            return a(eVar, this.gLB, this);
        }
        x.w("MicroMsg.emoji.NetSceneGetEmotionDesc", "get emoji desc faild. product id is null.");
        return -1;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 != 0 || i3 != 0) {
            x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, & errType:%d, errCode:%d, productId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.lEi);
            if (this.lEI) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion get des failed. ignore");
            }
        } else if (!this.lEI) {
            List<sr> list = ((acc) this.gLB.hnR.hnY).kyB;
            c cVar = i.aCl().lCy;
            String str2 = this.lEi;
            int i4 = ((acc) this.gLB.hnR.hnY).wrF;
            int aCy = aCy();
            if (cVar.xJd != null) {
                cVar.xJd.edit().putLong("274544" + str2, System.currentTimeMillis()).commit();
            }
            if (list != null && list.size() > 0) {
                long dA;
                h hVar;
                if (cVar.gLA instanceof h) {
                    h hVar2 = (h) cVar.gLA;
                    dA = hVar2.dA(Thread.currentThread().getId());
                    hVar = hVar2;
                } else {
                    hVar = null;
                    dA = -1;
                }
                cVar.gLA.delete("EmojiInfoDesc", "groupId=?", new String[]{str2});
                com.tencent.mm.storage.emotion.b bVar = new com.tencent.mm.storage.emotion.b();
                bVar.field_groupId = str2;
                bVar.field_click_flag = i4;
                bVar.field_download_flag = aCy;
                for (sr srVar : list) {
                    bVar.field_md5 = srVar.wgP;
                    Iterator it = srVar.kyB.iterator();
                    while (it.hasNext()) {
                        aok aok = (aok) it.next();
                        bVar.field_desc = aok.nkL;
                        bVar.field_lang = aok.nnm;
                        bVar.field_md5_lang = bVar.field_md5 + bVar.field_lang;
                        if (cVar.gLA.replace("EmojiInfoDesc", "md5_lang", bVar.vP()) < 0) {
                            if (hVar != null) {
                                hVar.fT(dA);
                            }
                        }
                    }
                }
                cVar.gLA.replace("EmojiInfoDesc", "md5_lang", bVar.vP());
                if (hVar != null) {
                    hVar.fT(dA);
                }
            }
            if (list != null && list.size() > 0) {
                x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "end getEmojiDesc, productId: %s ", this.lEi);
                this.lEJ.fEY.frQ = this.lEi;
                com.tencent.mm.sdk.b.a.xmy.m(this.lEJ);
            }
        } else if ((aCy() & 1) == 1) {
            com.tencent.mm.plugin.emoji.g.c.a(this.lEH);
        } else {
            x.i("MicroMsg.emoji.NetSceneGetEmotionDesc", "new emotion is can't download. ignore");
        }
        this.gQm.a(i2, i3, str, this);
    }

    private int aCy() {
        return ((acc) this.gLB.hnR.hnY).wrH;
    }

    protected final int Bo() {
        return 50;
    }

    protected final int a(q qVar) {
        return b.hoz;
    }
}
