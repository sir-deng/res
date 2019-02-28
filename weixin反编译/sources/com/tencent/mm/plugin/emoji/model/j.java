package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.f.a.cr;
import com.tencent.mm.f.a.tm;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.y.as;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j {
    Set<String> lDV;
    Set<String> lDW;
    Set<String> lDX;
    c lDY = new c<tm>() {
        {
            this.xmG = tm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            tm tmVar = (tm) bVar;
            switch (tmVar.fMT.fql) {
                case 1:
                    j.this.lDV.addAll(bi.F(tmVar.fMT.fMU));
                    j.this.lDW.addAll(j.this.lDV);
                    j.this.aCp();
                    break;
            }
            return false;
        }
    };
    c lDZ = new c<cr>() {
        {
            this.xmG = cr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cr crVar = (cr) bVar;
            if (j.this.lDV.contains(crVar.frL.frM)) {
                j.this.lDX.remove(crVar.frL.frM);
                if (crVar.frL.success) {
                    x.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", crVar.frL.frM);
                    i.aCl().lCx.Yx(crVar.frL.frM);
                    as.CN().a(new q(crVar.frL.frM, 2), 0);
                } else {
                    x.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", crVar.frL.frM);
                }
                j.this.aCp();
            }
            return false;
        }
    };

    public j() {
        a.xmy.b(this.lDY);
        a.xmy.b(this.lDZ);
        this.lDV = Collections.synchronizedSet(new HashSet());
        this.lDW = Collections.synchronizedSet(new HashSet());
        this.lDX = Collections.synchronizedSet(new HashSet());
    }

    final void aCp() {
        while (!this.lDW.isEmpty()) {
            if (this.lDX.isEmpty()) {
                Iterator it = this.lDW.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.lDW.remove(str);
                    EmojiGroupInfo bg = i.aCl().lCx.bg(str, true);
                    if (bg == null || (bg.field_flag & 256) <= 0) {
                        x.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", str);
                        this.lDX.add(str);
                        as.CN().a(new g(str, ""), 0);
                        return;
                    }
                    x.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", str);
                } else {
                    return;
                }
            }
            x.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", this.lDX.toString());
            return;
        }
        x.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
    }
}
