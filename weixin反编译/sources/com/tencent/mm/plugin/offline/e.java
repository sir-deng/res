package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.i.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String paP = "";
    private a paQ = new a() {
        public final void bhx() {
            e.this.asP();
        }
    };

    public final void asP() {
        if (this.paM != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.paM.size()) {
                    WeakReference weakReference = (WeakReference) this.paM.get(i2);
                    if (weakReference != null) {
                        b bVar = (b) weakReference.get();
                        if (bVar != null) {
                            bVar.auA();
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public e() {
        k.bhD();
        if (k.bhG() != null) {
            k.bhD();
            k.bhG().pbt = this.paQ;
        }
    }

    private static void bhv() {
        k.bhD();
        k.bhG().di(1, 1);
    }

    public final String k(int i, int i2, String str) {
        int i3 = 0;
        int bhw = bhw();
        if (bhw > 0) {
            if (bhw < k.pbI) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", Integer.valueOf(k.pbI));
                k.bhD();
                k.bhG().dh(2, 2);
            }
            k.bhD();
            String uF = k.uF(196617);
            if (TextUtils.isEmpty(uF)) {
                x.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:" + uF);
                return "";
            }
            com.tencent.mm.wallet_core.c.a.cCe();
            uF = com.tencent.mm.wallet_core.c.a.getToken(uF);
            if (TextUtils.isEmpty(uF)) {
                bhv();
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                return "";
            }
            if (uF != null) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", Integer.valueOf(uF.length()), str, uF);
            }
            k oVar = new o(bhw - 1, i, i2, str);
            g.Dr();
            g.Dp().gRu.a(oVar, 0);
            x.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (bhw - 1));
            LinkedList HB = com.tencent.mm.plugin.offline.c.a.HB(com.tencent.mm.plugin.offline.c.a.biD());
            if (HB == null || HB.size() == 0) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                bhv();
                return "";
            } else if (uF == null || !com.tencent.mm.plugin.offline.c.a.xv(uF)) {
                x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                return "";
            } else {
                long longValue = Long.valueOf(uF, 10).longValue();
                long j = 0;
                while (i3 < HB.size()) {
                    com.tencent.mm.plugin.offline.c.a.a aVar = (com.tencent.mm.plugin.offline.c.a.a) HB.get(i3);
                    if (!(aVar == null || aVar.pfg == null || !aVar.pfg.equals(this.paP))) {
                        j = (long) aVar.pfe;
                    }
                    i3++;
                }
                String valueOf = String.valueOf((j << 48) | longValue);
                if (valueOf.length() == 15) {
                    valueOf = "0" + valueOf;
                } else if (valueOf.length() == 14) {
                    valueOf = "00" + valueOf;
                } else if (valueOf.length() == 13) {
                    valueOf = "000" + valueOf;
                } else if (valueOf.length() == 12) {
                    valueOf = "0000" + valueOf;
                }
                if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.biF())) {
                    return "12" + valueOf;
                }
                return com.tencent.mm.plugin.offline.c.a.biF() + valueOf;
            }
        }
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.dg(ad.getContext()) ? 0 : 1);
        if (ao.isNetworkConnected(ad.getContext())) {
            i3 = 1;
        }
        objArr[2] = Integer.valueOf(i3);
        gVar.h(14163, objArr);
        com.tencent.mm.plugin.report.service.g.pWK.a(135, 29, 1, true);
        if (ao.isNetworkConnected(ad.getContext())) {
            com.tencent.mm.plugin.report.service.g.pWK.a(135, 31, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.pWK.a(135, 30, 1, true);
        }
        bhv();
        x.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        return "";
    }

    public static int bhw() {
        k.bhD();
        k.bhG();
        return i.bhC();
    }
}
