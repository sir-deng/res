package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;

public final class d extends com.tencent.mm.plugin.emoji.sync.d {
    private String idX;
    private e lFJ;
    private k lFS;
    private EmojiInfo lFT;

    public d(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.BKGLoader.EmojiUploadTask", "[cpan] can not create task. md5 is null.");
        }
        this.idX = str;
        this.lFT = i.aCl().lCw.YB(this.idX);
    }

    public final void run() {
        if (this.lFJ != null) {
            this.lFJ.zi(this.idX);
        } else {
            x.w("MicroMsg.BKGLoader.EmojiUploadTask", "call back is null.");
        }
        if (this.lFT == null) {
            this.lFJ.k(this.idX, 1, false);
            return;
        }
        this.lFS = new f(this.lFT);
        as.CN().a(this.lFS, 0);
    }

    public final String getKey() {
        return this.idX;
    }

    public final void a(e eVar) {
        this.lFJ = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            if (!(bi.oN(this.idX) || bi.oN(dVar.idX) || !this.idX.equals(dVar.idX))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
