package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.h.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class d extends c {
    private final String TAG = "MicroMsg.emoji.EmojiListMineData";

    public d(f fVar) {
        super(fVar);
    }

    public final synchronized void notifyDataSetChanged() {
        List<EmojiGroupInfo> clf = i.aCl().lCx.clf();
        boolean aDF = a.aDF();
        this.mItemList = new ArrayList();
        x.v("MicroMsg.emoji.EmojiListMineData", "============= refresh Data By DB");
        for (EmojiGroupInfo ckN : clf) {
            sx ckN2 = ckN.ckN();
            f fVar = new f(ckN2);
            if (a.d(ckN2) && aDF) {
                this.lAu.put(ckN2.vPI, new ak(ckN2.vPI));
            }
            fVar.eR(9);
            this.mItemList.add(fVar);
        }
    }

    public final void clear() {
        super.clear();
    }

    public final void aBr() {
    }
}
