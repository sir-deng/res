package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.f.a.ob;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<ob> {
    public d() {
        this.xmG = ob.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ob obVar = (ob) bVar;
        if (obVar instanceof ob) {
            if (obVar.fGN.frh == 0) {
                com.tencent.mm.plugin.emoji.model.d aCf = i.aCf();
                long j = obVar.fGN.fGQ;
                aCf.lDd.put(Long.valueOf(j), obVar.fGN.fGO);
            } else {
                x.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        return false;
    }
}
