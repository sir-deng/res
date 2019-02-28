package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.as;

public final class o extends c<hz> implements e {
    private long fqB;

    public o() {
        this.fqB = 0;
        this.xmG = hz.class.getName().hashCode();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof af) {
            String str2 = ((af) kVar).fHQ;
            as.Hm();
            au dI = com.tencent.mm.y.c.Fh().dI(this.fqB);
            if (i == 0 && i2 == 0) {
                dI.eR(2);
            } else {
                dI.eR(5);
            }
            a fV = a.fV(dI.field_content);
            d xp = g.xp(dI.field_content);
            xp.fHQ = str2;
            fV.hdU = g.a(xp);
            fV.fzn = a.a(fV, null, null);
            dI.setContent(a.a(fV, null, null));
            as.Hm();
            com.tencent.mm.y.c.Fh().a(this.fqB, dI);
            as.CN().b(652, (e) this);
        }
    }

    private boolean a(hz hzVar) {
        if (!(hzVar instanceof hz)) {
            return false;
        }
        String str = hzVar.fzm.fzn;
        this.fqB = hzVar.fzm.fqB;
        String str2 = hzVar.fzm.fzo;
        d xp = g.xp(str);
        as.Hm();
        au dI = com.tencent.mm.y.c.Fh().dI(this.fqB);
        dI.eR(1);
        as.Hm();
        com.tencent.mm.y.c.Fh().a(this.fqB, dI);
        if (xp == null) {
            xp = g.xp(dI.field_content);
        }
        if (xp == null) {
            return true;
        }
        as.CN().a(652, (e) this);
        as.CN().a(new af(xp.fHP, str2, 17), 0);
        return true;
    }
}
