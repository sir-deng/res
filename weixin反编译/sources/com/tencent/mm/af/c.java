package com.tencent.mm.af;

import android.os.Looper;
import com.tencent.mm.ad.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bii;
import com.tencent.mm.protocal.c.fe;
import com.tencent.mm.protocal.c.hx;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;

public final class c extends i<b> implements e {
    public static final String[] gLy = new String[]{i.a(b.gKN, "BizEnterprise")};
    public static fe hpM;
    private com.tencent.mm.sdk.e.e gLA;
    private final k<a, a> hpN = new k<a, a>() {
        protected final /* synthetic */ void p(Object obj, Object obj2) {
            ((a) obj).a((a) obj2);
        }
    };

    public interface a {

        public static class a {
            public int hpP;
            public String hpQ;
            public b hpR;
        }

        public enum b {
            ;

            static {
                hpS = 1;
                hpT = 2;
                hpU = 3;
                hpV = new int[]{hpS, hpT, hpU};
            }
        }

        void a(a aVar);
    }

    public c(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, b.gKN, "BizEnterprise", null);
        this.gLA = eVar;
        eVar.fD("BizEnterprise", "CREATE INDEX IF NOT EXISTS BizEnterpriseUserNameIndex ON BizEnterprise ( userName )");
        hpM = new fe();
        g.Dp().gRu.a(1343, (e) this);
        g.Dp().gRu.a(1228, (e) this);
    }

    public final void a(a aVar, Looper looper) {
        this.hpN.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.hpN != null) {
            this.hpN.remove(aVar);
        }
    }

    public final b jA(String str) {
        if (bi.oN(str)) {
            return null;
        }
        com.tencent.mm.sdk.e.c bVar = new b();
        bVar.field_userName = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        a(str, null);
        return null;
    }

    public final b jB(String str) {
        b jA = jA(str);
        if (jA != null) {
            return jA;
        }
        jA = new b();
        jA.field_userName = str;
        jA.field_qyUin = 0;
        jA.field_userUin = 0;
        jA.field_userFlag = 0;
        jA.field_wwExposeTimes = 0;
        jA.field_wwMaxExposeTimes = 0;
        jA.field_wwUserVid = 0;
        jA.field_wwCorpId = 0;
        jA.field_chatOpen = false;
        jA.field_wwUnreadCnt = 0;
        return jA;
    }

    public final int jC(String str) {
        b jA = jA(str);
        if (jA == null) {
            return 0;
        }
        return jA.field_qyUin;
    }

    public final boolean iI(String str) {
        boolean z = false;
        if (!bi.oN(str)) {
            com.tencent.mm.sdk.e.c bVar = new b();
            bVar.field_userName = str;
            z = super.a(bVar, "userName");
            if (z) {
                a aVar = new a();
                aVar.hpQ = str;
                aVar.hpP = b.hpT;
                aVar.hpR = bVar;
                this.hpN.cb(aVar);
                this.hpN.doNotify();
            }
        }
        return z;
    }

    private boolean a(b bVar) {
        if (bVar == null) {
            return false;
        }
        boolean z;
        int i;
        boolean b = super.b((com.tencent.mm.sdk.e.c) bVar);
        int i2 = b.hpS;
        if (b) {
            int i3 = i2;
            z = b;
            i = i3;
        } else {
            b = super.a(bVar);
            z = b;
            i = b.hpU;
        }
        if (!z) {
            return z;
        }
        a aVar = new a();
        aVar.hpQ = bVar.field_userName;
        aVar.hpP = i;
        aVar.hpR = bVar;
        this.hpN.cb(aVar);
        this.hpN.doNotify();
        return z;
    }

    private boolean a(hx hxVar) {
        b jB = jB(hxVar.vUh);
        jB.field_userName = hxVar.vUh;
        jB.field_qyUin = hxVar.vUr;
        jB.field_userUin = hxVar.vUs;
        jB.field_wwMaxExposeTimes = hxVar.vUu;
        jB.field_wwUserVid = hxVar.vUv;
        jB.field_wwCorpId = hxVar.vUw;
        jB.field_userType = hxVar.vUx;
        jB.field_chatOpen = hxVar.vUy;
        jB.field_wwUnreadCnt = hxVar.vUz;
        jB.field_show_confirm = hxVar.vUA;
        jB.field_use_preset_banner_tips = hxVar.vUC;
        hpM = hxVar.vUB;
        if (hxVar.vUv == 0 && hxVar.vUw == 0 && hxVar.vUr != 0) {
            jB.field_wwUserVid = (long) hxVar.vUs;
            jB.field_wwCorpId = (long) hxVar.vUr;
        }
        hxVar.vUt &= -9;
        jB.field_userFlag = hxVar.vUt | (jB.field_userFlag & 8);
        return a(jB);
    }

    public static boolean a(String str, e eVar) {
        if (bi.oN(str)) {
            return false;
        }
        int i;
        if (f.ka(str)) {
            i = 1;
        } else if (!f.jZ(str)) {
            return false;
        } else {
            i = 2;
        }
        return g.Dp().gRu.a(new r(str, i, eVar), 0);
    }

    public static x a(String str, boolean z, e eVar) {
        hx hxVar = new hx();
        hxVar.vUh = str;
        hxVar.vUt = z ? 1 : 0;
        hxVar.vUr = 0;
        com.tencent.mm.ad.k xVar = new x(hxVar, eVar);
        return g.Dp().gRu.a(xVar, 0) ? xVar : null;
    }

    public final void jD(String str) {
        b jB = jB(str);
        if (jB.field_wwExposeTimes < jB.field_wwMaxExposeTimes) {
            jB.field_wwExposeTimes++;
            a(jB);
        }
    }

    public static void a(x xVar) {
        g.Dp().gRu.c((com.tencent.mm.ad.k) xVar);
        xVar.data = null;
    }

    public final boolean jE(String str) {
        b jA = jA(str);
        return (jA == null || (jA.field_userFlag & 1) == 0) ? false : true;
    }

    public static String hq(int i) {
        String str = "";
        if (hpM == null) {
            hpM = new fe();
        }
        switch (i) {
            case 0:
                return hpM.vRF;
            case 1:
                return hpM.vRG;
            case 2:
                return hpM.vRH;
            default:
                return str;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        int i3 = -1;
        if (i == 0 && i2 == 0) {
            e eVar;
            if (kVar instanceof r) {
                r rVar = (r) kVar;
                zv zvVar = (rVar.gLB == null || rVar.gLB.hnR.hnY == null) ? null : (zv) rVar.gLB.hnR.hnY;
                if (zvVar != null && zvVar.vUn != null && zvVar.vUn.ret == 0 && zvVar.wqm != null) {
                    if (!a(zvVar.wqm)) {
                        i2 = -1;
                    }
                    eVar = (e) rVar.data;
                    if (eVar != null) {
                        eVar.a(i, i2, str, kVar);
                    }
                } else {
                    return;
                }
            }
            if (kVar instanceof x) {
                x xVar = (x) kVar;
                bii bii = (xVar.gLB == null || xVar.gLB.hnR.hnY == null) ? null : (bii) xVar.gLB.hnR.hnY;
                if (bii != null && bii.vUn != null && bii.vUn.ret == 0 && bii.wqm != null) {
                    if (a(bii.wqm)) {
                        i3 = i2;
                    }
                    eVar = (e) xVar.data;
                    if (eVar != null) {
                        eVar.a(i, i3, str, kVar);
                    }
                }
            }
        }
    }
}
