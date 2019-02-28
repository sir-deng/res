package com.tencent.mm.plugin.emoji.sync.a;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.d;
import com.tencent.mm.plugin.emoji.sync.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class c extends d {
    private String lEs;
    private e lFJ;

    public c(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "[cpan] empty productid");
        }
        this.lEs = str;
    }

    public final void run() {
        if (this.lFJ != null) {
            this.lFJ.zi(getKey());
        } else {
            x.w("MicroMsg.BKGLoader.EmojiStoreTukaziSyncTask", "call back is null");
        }
        com.tencent.mm.sdk.e.c bg = i.aCl().lCx.bg(EmojiGroupInfo.xIE, false);
        bg.field_flag = 0;
        i.aCl().lCx.a(bg);
        if (this.lFJ != null) {
            this.lFJ.k(getKey(), 2, true);
        }
    }

    public final String getKey() {
        return this.lEs == null ? "" : this.lEs;
    }

    public final void a(e eVar) {
        this.lFJ = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (!(bi.oN(this.lEs) || bi.oN(cVar.getKey()) || !this.lEs.equals(cVar.getKey()))) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
    }
}
