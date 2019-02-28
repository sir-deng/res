package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.plugin.search.ui.a.k.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.as;
import com.tencent.mm.y.r;

public final class c extends k {
    public q qid;
    public CharSequence qjK;
    private a qjL = new a();

    public class a extends b {
        public a() {
            super();
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
            c cVar = (c) bVar;
            com.tencent.mm.plugin.search.ui.a.k.a aVar2 = (com.tencent.mm.plugin.search.ui.a.k.a) aVar;
            cm(aVar2.contentView);
            if (bi.oN(cVar.iZi.talker)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.ikK, cVar.iZi.mRd);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(aVar2.ikK, cVar.iZi.talker);
            }
            e.a(cVar.qjK, aVar2.kHt);
            e.a(cVar.ikH, aVar2.lju);
            e.a(cVar.qkA, aVar2.ljv);
        }
    }

    public c(int i) {
        super(i);
    }

    public final com.tencent.mm.plugin.fts.d.a.b.b adG() {
        return this.qjL;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        CharSequence gw;
        super.a(context, aVar, objArr);
        as.Hm();
        ag Xv = com.tencent.mm.y.c.Ff().Xv(this.iZi.talker);
        if (Xv == null) {
            gw = r.gw(this.iZi.mRd);
        } else if (!bi.oN(Xv.field_conRemark)) {
            gw = Xv.field_conRemark;
        } else if (this.qid != null) {
            gw = this.qid.gw(this.iZi.talker);
            if (bi.oN(gw)) {
                gw = r.gv(this.iZi.talker);
            }
        } else {
            gw = r.gv(this.iZi.talker);
        }
        if (!bi.oN(gw)) {
            this.qjK = i.d(context, gw, (float) d.b.mUu);
        }
    }
}
