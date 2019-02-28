package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.fn;
import com.tencent.mm.protocal.c.fo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE;
    private ArrayList<String> lEl;

    public d(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.hnT = new fn();
        aVar.hnU = new fo();
        aVar.uri = "/cgi-bin/micromsg-bin/mmbatchemojibackup";
        this.gLB = aVar.Kf();
        this.lEl = arrayList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "netId:%d, errType:%d, errCode:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 == -434) {
            x.w("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] batch backup emoji failed. over size.");
            as.Hm();
            c.Db().a(w.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.valueOf(true));
            g.pWK.a(164, 4, 1, false);
        }
        if (i2 == 0 && i3 == 0) {
            as.Hm();
            c.Db().a(w.a.USERINFO_EMOJI_BACKUP_OVERSIZE_BOOLEAN, Boolean.valueOf(false));
            com.tencent.mm.storage.emotion.d dVar = i.aCl().lCw;
            List list = this.lEl;
            if (list == null || list.size() <= 0) {
                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji failed. list is null");
            } else {
                x.i("MicroMsg.emoji.EmojiInfoStorage", "[cpan] LocalCustomEmoji list size :%d.", Integer.valueOf(list.size()));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UPDATE");
                stringBuilder.append(" EmojiInfo ");
                stringBuilder.append(" SET ");
                stringBuilder.append("source");
                stringBuilder.append("=");
                stringBuilder.append(EmojiInfo.xIZ);
                stringBuilder.append(" where ");
                stringBuilder.append("md5");
                stringBuilder.append(" IN (");
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        break;
                    }
                    stringBuilder.append("'" + ((String) list.get(i5)) + "'");
                    if (i5 < list.size() - 1) {
                        stringBuilder.append(",");
                    }
                    i4 = i5 + 1;
                }
                stringBuilder.append(")");
                x.d("MicroMsg.emoji.EmojiInfoStorage", stringBuilder.toString());
                dVar.gLA.fD("EmojiInfo", stringBuilder.toString());
            }
            g.pWK.a(164, 2, 1, false);
        } else {
            g.pWK.a(164, 3, 1, false);
        }
        fo foVar = (fo) this.gLB.hnR.hnY;
        if (foVar.vQD != null && foVar.vQD.size() > 0) {
            x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "[cpan] there are some emoji need to upload.");
            i.aCl().lCw.ay(foVar.vQD);
            as.Hm();
            c.Db().set(348165, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.c.a.ex(true);
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 696;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        ((fn) this.gLB.hnQ.hnY).vQB = new LinkedList(this.lEl);
        if (this.lEl != null && this.lEl.size() > 0) {
            return a(eVar, this.gLB, this);
        }
        x.i("MicroMsg.emoji.NetSceneBatchEmojiBackup", "need no backup custom emoji, list is null.");
        as.Hm();
        c.Db().set(348162, Boolean.valueOf(false));
        return -1;
    }
}
