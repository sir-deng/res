package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.ad.d.a;
import com.tencent.mm.be.h;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.it;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;

public final class b implements d {
    public final com.tencent.mm.ad.d.b b(a aVar) {
        bx bxVar = aVar.hoa;
        if (bxVar == null || bxVar.nlX != 47) {
            x.f("MicroMsg.EmojiExtension", "parseEmojiMsg failed, invalid cmdAM");
        } else {
            String a = n.a(bxVar.vNM);
            String a2 = n.a(bxVar.vNN);
            as.Hm();
            if (!((String) c.Db().get(2, null)).equals(a)) {
                a2 = a;
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(a2, n.a(bxVar.vNO), bxVar.vNT, bxVar.vNR, aVar);
            com.tencent.mm.y.bb.b hW = bb.hW(bxVar.vNR);
            if (hW != null) {
                x.i("MicroMsg.EmojiExtension", "bizClientMsgId = %s", hW.hiq);
                if (hW.his != null && hW.scene == 1) {
                    int i;
                    a2 = n.a(bxVar.vNM);
                    as.Hm();
                    c.Db().set(73729, Integer.valueOf(1));
                    h hVar = new h();
                    hVar.field_content = ad.getContext().getString(R.l.exK);
                    hVar.field_createtime = bi.Wx();
                    hVar.field_imgpath = "";
                    hVar.field_sayhicontent = hVar.field_content;
                    hVar.field_sayhiuser = a2;
                    hVar.field_scene = 18;
                    if (bxVar.kyY > 3) {
                        i = bxVar.kyY;
                    } else {
                        i = 3;
                    }
                    hVar.field_status = i;
                    hVar.field_svrid = bxVar.vNT;
                    hVar.field_talker = a2;
                    hVar.field_type = bxVar.nlX;
                    hVar.field_isSend = 0;
                    hVar.field_sayhiencryptuser = a2;
                    hVar.field_ticket = hW.his;
                    l.TF().a(hVar);
                    com.tencent.mm.sdk.b.b itVar = new it();
                    itVar.fAc.fAd = a2;
                    com.tencent.mm.sdk.b.a.xmy.m(itVar);
                }
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
