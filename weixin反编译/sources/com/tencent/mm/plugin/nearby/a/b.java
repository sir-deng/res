package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.f.b.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bb.a;
import com.tencent.mm.y.c;

public final class b {
    public static final int oTB = 1;
    private static final /* synthetic */ int[] oTC = new int[]{oTB};

    public static boolean dG(String str, String str2) {
        ag xVar = new x();
        xVar.dc(str2);
        xVar.setUsername(str);
        as.Hm();
        ar Ff = c.Ff();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LbsroomLogic", "Save lbsroom contact name:" + xVar.field_username);
        if (!Ff.Xx(xVar.field_username)) {
            Ff.S(xVar);
        }
        as.Hm();
        c.Db().set(143873, str);
        as.Hm();
        c.Db().set(143874, Long.valueOf(bi.Wx()));
        return true;
    }

    public static void bP(String str, int i) {
        as.Hm();
        as.CN().a(new d(str, (int) bi.bz(bi.c((Long) c.Db().get(143874, Long.valueOf(0)))), i), 0);
    }

    public static void uf(int i) {
        as.Hm();
        String oM = bi.oM((String) c.Db().get(143873, (Object) ""));
        if (!oM.equals("")) {
            as.Hm();
            if (bi.bz(bi.c((Long) c.Db().get(143874, Long.valueOf(0)))) < 7200) {
                bP(oM, i);
            } else {
                He(oM);
            }
        }
    }

    public static boolean bfw() {
        as.Hm();
        return bi.e((Integer) c.Db().get(143875, Integer.valueOf(0))) == 1;
    }

    public static void bfx() {
        as.Hm();
        c.Db().set(143875, Integer.valueOf(1));
    }

    public static void bfy() {
        as.Hm();
        c.Db().set(143875, Integer.valueOf(0));
    }

    public static void He(String str) {
        as.Hm();
        ar Ff = c.Ff();
        if (Ff.Xx(str)) {
            Ff.XB(str);
        }
        bb.a(str, new a() {
            public final boolean HH() {
                return false;
            }

            public final void HG() {
            }
        });
        as.Hm();
        c.Db().set(143873, "");
        as.Hm();
        c.Db().set(143874, Long.valueOf(0));
        bfy();
    }
}
