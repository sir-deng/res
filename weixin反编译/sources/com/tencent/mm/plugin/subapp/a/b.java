package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.ak.c;
import com.tencent.mm.y.as;

public final class b implements c {

    private static class a implements e {
        public a() {
            as.CN().a(167, (e) this);
            as.CN().a(new a(), 0);
        }

        public final void a(int i, int i2, String str, k kVar) {
            as.CN().b(167, (e) this);
        }
    }

    public final String gP(int i) {
        return Q(i, true);
    }

    public final String gQ(int i) {
        return Q(i, false);
    }

    private String Q(int i, boolean z) {
        int i2 = 0;
        as.Hm();
        if (!com.tencent.mm.y.c.isSDCardAvailable()) {
            return null;
        }
        int i3;
        if (i != 0) {
            i3 = 0;
            while (i3 < 32) {
                i = (i >> 1) & Integer.MAX_VALUE;
                if (i == 0) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            i2 = 1 << i3;
        }
        String q = i2 == 0 ? null : q(i2, z);
        if (com.tencent.mm.a.e.bO(q)) {
            return q;
        }
        GX();
        return null;
    }

    public final void GX() {
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            as.Hm();
            long a = bi.a((Long) com.tencent.mm.y.c.Db().get(66051, null), 0);
            long Wy = bi.Wy();
            if (432000000 <= Wy - a) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(66051, Long.valueOf(Wy));
                a aVar = new a();
            }
        }
    }

    public final boolean gR(int i) {
        if (i == 0) {
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (!com.tencent.mm.a.e.bO(q((1 << i2) & i, false)) || !com.tencent.mm.a.e.bO(q((1 << i2) & i, true))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final String q(int i, boolean z) {
        if (i == 0) {
            return null;
        }
        return com.tencent.mm.compatible.util.e.gJg + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : "") + ".png";
    }
}
