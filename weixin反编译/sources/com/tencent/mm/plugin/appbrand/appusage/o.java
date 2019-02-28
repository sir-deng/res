package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Map;

public final class o {

    public static final class a implements com.tencent.mm.y.bt.a {
        private static final a iNd = new a();

        static /* synthetic */ void qw(String str) {
            int i = 0;
            x.i("MicroMsg.AppBrandUsagePushingUpdateLogic", "parseThenProcess, accReady %b, received xml %s", Boolean.valueOf(g.Do().CF()), str);
            if (g.Do().CF()) {
                Map y = bj.y(str, "sysmsg");
                if (y != null && y.size() > 0) {
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    ArrayList arrayList3;
                    int i2;
                    int i3 = bi.getInt((String) y.get(".sysmsg.UpdateWxaUsageListNotify.Type"), 0);
                    int i4 = bi.getInt((String) y.get(".sysmsg.UpdateWxaUsageListNotify.DeleteCount"), 0);
                    if (i4 > 0) {
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        arrayList3 = new ArrayList();
                        int i5 = 0;
                        while (i5 < i4) {
                            String str2 = ".sysmsg.UpdateWxaUsageListNotify.DeleteList.DeleteAppInfo" + (i5 == 0 ? "" : Integer.valueOf(i5));
                            String str3 = (String) y.get(str2 + ".UserName");
                            String str4 = (String) y.get(str2 + ".AppID");
                            i2 = bi.getInt((String) y.get(str2 + ".AppType"), 0);
                            if (!(bi.oN(str3) || bi.oN(str4))) {
                                arrayList.add(str3);
                                arrayList2.add(str4);
                                arrayList3.add(Integer.valueOf(i2));
                            }
                            i5++;
                        }
                    } else {
                        arrayList3 = null;
                        arrayList2 = null;
                        arrayList = null;
                    }
                    switch (i3) {
                        case 1:
                            new r(4, 1, Integer.MAX_VALUE, 30).Kb();
                            return;
                        case 2:
                            new r(4, 2, 0, 0).Kb();
                            return;
                        case 3:
                            if (!bi.cC(arrayList)) {
                                while (i < arrayList.size()) {
                                    v.k((String) arrayList.get(i), (String) arrayList2.get(i), ((Integer) arrayList3.get(i)).intValue());
                                    i++;
                                }
                                return;
                            }
                            return;
                        case 4:
                            if (!bi.cC(arrayList)) {
                                for (i2 = 0; i2 < arrayList.size(); i2++) {
                                    e.Zy().h((String) arrayList.get(i2), ((Integer) arrayList3.get(i2)).intValue(), false);
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        public static void abp() {
            ((n) g.k(n.class)).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", iNd, true);
        }

        public static void unregister() {
            ((n) g.k(n.class)).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", iNd, true);
        }

        public final void a(com.tencent.mm.ad.d.a aVar) {
            final String a = com.tencent.mm.platformtools.n.a(aVar.hoa.vNO);
            if (!bi.oN(a)) {
                c.Dt().F(new Runnable() {
                    public final void run() {
                        a.qw(a);
                    }
                });
            }
        }
    }
}
