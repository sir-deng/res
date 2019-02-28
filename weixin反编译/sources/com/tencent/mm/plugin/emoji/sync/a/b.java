package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.f.a.cr;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.y.as;

public final class b extends d {
    private boolean lEN = false;
    private String lEs;
    private e lFJ;
    private g lFR;

    public b(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.lEs = str;
    }

    public b(String str, byte b) {
        if (bi.oN(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "[cpan]");
        }
        this.lEs = str;
        this.lEN = true;
    }

    public final void run() {
        if (this.lFJ != null) {
            this.lFJ.zi(getKey());
        } else {
            x.w("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "call back is null");
        }
        EmojiGroupInfo bg = i.aCl().lCx.bg(getKey(), true);
        if (this.lEN || bg == null || bg.field_sync != 2 || bg.field_status != 7) {
            this.lFR = new g(this.lEs);
            as.CN().a(this.lFR, 0);
            ace ace = new ace();
            com.tencent.mm.storage.emotion.i YH = i.aCl().lCA.YH(this.lEs);
            if (!(YH == null || YH.field_content == null)) {
                try {
                    ace.aH(YH.field_content);
                } catch (Throwable e) {
                    x.e("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "exception:%s", bi.i(e));
                }
            }
            if (ace.wrI == null) {
                as.CN().a(new l(this.lEs, 15), 0);
                return;
            }
            return;
        }
        com.tencent.mm.sdk.b.b crVar = new cr();
        crVar.frL.frM = getKey();
        crVar.frL.fql = 2;
        crVar.frL.success = true;
        a.xmy.m(crVar);
    }

    public final String getKey() {
        return this.lEs == null ? "" : this.lEs;
    }

    public final void a(e eVar) {
        this.lFJ = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (!(bi.oN(this.lEs) || bi.oN(bVar.getKey()) || !this.lEs.equals(bVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        if (this.lFR == null || bi.oN(this.lFR.hCY)) {
            x.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "failed cancel exchange emotion pack.");
            return;
        }
        com.tencent.mm.modelcdntran.g.MP().kL(this.lFR.hCY);
        x.i("MicroMsg.BKGLoader.EmojiStoreEmojiSyncTask", "success cancel exchange emotion pack clientid:%s", this.lFR.hCY);
    }
}
