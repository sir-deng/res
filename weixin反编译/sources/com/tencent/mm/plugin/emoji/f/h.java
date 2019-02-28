package com.tencent.mm.plugin.emoji.f;

import android.content.ContentValues;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.protocal.c.abs;
import com.tencent.mm.protocal.c.bes;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.g;

public final class h extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gQm;
    public int hAF;
    public byte[] lEA;
    private int lEB;
    private String lEC;
    private int lED;
    private int lEz;

    public h(int i, int i2, int i3, String str, int i4, byte[] bArr) {
        a aVar = new a();
        aVar.hnT = new abr();
        aVar.hnU = new abs();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetdesigneremojilist";
        this.gLB = aVar.Kf();
        this.hAF = i;
        this.lEz = i2;
        this.lEB = i3;
        this.lEC = str;
        this.lEA = bArr;
        this.lED = i4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (((i2 == 0 && i3 == 0) || (i2 == 4 && (i3 == 2 || i3 == 3))) && ((this.lEA == null || this.lEA.length <= 0) && this.hAF != 3)) {
            com.tencent.mm.storage.emotion.h hVar = i.aCl().lCC;
            String str2 = this.lEz;
            abs aCw = aCw();
            if (bi.oN(str2) || aCw == null) {
                x.w("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerEmojiListResponseByUIN failed. designerID or response is null.");
            } else {
                try {
                    g gVar = new g();
                    gVar.field_designerIDAndType = str2 + com.tencent.mm.storage.emotion.h.a.DesignerEmojiList.value;
                    gVar.field_content = aCw.toByteArray();
                    ContentValues vP = gVar.vP();
                    new String[1][0] = str2 + com.tencent.mm.storage.emotion.h.a.DesignerEmojiList.value;
                    if (hVar.gLA.replace("EmotionDesignerInfo", "designerIDAndType", vP) > 0) {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN success. designerID:%s", str2);
                    } else {
                        x.i("MicroMsg.emoji.EmotionDesignerInfo", "savePersonalDesignerResponseByUIN failed. designerID:%s", str2);
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmotionDesignerInfo", "saveDesignerSimpleInfoResponseByID exception:%s", bi.i(e));
                }
            }
        }
        abs abs = (abs) ((b) qVar).hnR.hnY;
        if (abs.wru != null) {
            this.lEA = n.a(abs.wru);
        }
        this.gQm.a(i2, i3, str, this);
    }

    public final int getType() {
        return 821;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gQm = eVar2;
        abr abr = (abr) this.gLB.hnQ.hnY;
        if (this.lEA != null) {
            abr.wru = n.N(this.lEA);
        } else {
            abr.wru = new bes();
        }
        x.d("MicroMsg.emoji.NetSceneGetDesignerEmojiList", abr.wru == null ? "Buf is NULL" : abr.wru.toString());
        abr.wrt = this.lEz;
        abr.vKI = this.hAF;
        abr.wgW = this.lEB;
        abr.wrv = this.lEC;
        abr.wrw = this.lED;
        return a(eVar, this.gLB, this);
    }

    public final abs aCw() {
        return this.gLB == null ? null : (abs) this.gLB.hnR.hnY;
    }
}
