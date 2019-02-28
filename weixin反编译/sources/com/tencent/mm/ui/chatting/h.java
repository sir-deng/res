package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class h {

    private static class a implements com.tencent.mm.sdk.platformtools.at.a {
        private Set<Long> yAg;
        private r yAh;
        private ac yAi;

        public a(Set<Long> set, r rVar, ac acVar) {
            this.yAg = set;
            this.yAh = rVar;
            this.yAi = acVar;
        }

        public final boolean JH() {
            Set<Long> set = this.yAg;
            List linkedList = new LinkedList();
            for (Long l : set) {
                as.Hm();
                cg dI = c.Fh().dI(l.longValue());
                if (dI.field_msgId == l.longValue()) {
                    if (dI.aNJ()) {
                        b.hRo.c(dI, com.tencent.mm.x.h.g(dI));
                    } else {
                        b.hRo.v(dI);
                    }
                }
                linkedList.add(l);
                com.tencent.mm.sdk.b.b mvVar = new mv();
                mvVar.fFz.type = 3;
                mvVar.fFz.frh = l.longValue();
                com.tencent.mm.sdk.b.a.xmy.m(mvVar);
            }
            bb.E(linkedList);
            if (this.yAi != null) {
                this.yAi.a(com.tencent.mm.ui.chatting.ac.a.del);
            }
            return true;
        }

        public final boolean JI() {
            if (this.yAh != null) {
                this.yAh.dismiss();
                if (this.yAi != null) {
                    this.yAi.b(com.tencent.mm.ui.chatting.ac.a.del);
                }
            }
            return true;
        }
    }

    public static void a(Context context, Set<Long> set, ac acVar) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
        } else if (set == null || set.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
        } else {
            context.getString(R.l.dGZ);
            s.yCw.c(new a(set, com.tencent.mm.ui.base.h.a(context, context.getString(R.l.dYI), false, null), acVar));
            g.pWK.h(10811, Integer.valueOf(4), Integer.valueOf(set.size()));
        }
    }
}
