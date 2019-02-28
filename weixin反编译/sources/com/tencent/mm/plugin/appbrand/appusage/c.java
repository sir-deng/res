package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.aji;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.protocal.c.ccn;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c extends j {
    private static volatile c iLR = null;

    static /* synthetic */ void a(c cVar, int i, int i2, long j, boolean z, Bundle bundle) {
        if (g.Do().CF()) {
            Object obj = (1 == i || 3 == i) ? 1 : null;
            if (obj != null) {
                long longValue = ((Long) g.Dq().Db().get(a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf(-1))).longValue();
                int i3 = (z || longValue <= 0) ? Integer.MAX_VALUE : (int) longValue;
                final int i4 = i2;
                final int i5 = i;
                final Bundle bundle2 = bundle;
                final long j2 = j;
                new r(i, i2, i3) {
                    protected final /* synthetic */ void a(int i, int i2, String str, bek bek, k kVar) {
                        aji aji = (aji) bek;
                        if (g.Do().CF()) {
                            String str2;
                            if (aji == null) {
                                str2 = "null";
                            } else {
                                Locale locale = Locale.US;
                                String str3 = "%d %d %d";
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(aji.wxC == null ? -1 : aji.wxC.size());
                                objArr[1] = Integer.valueOf(aji.wxD == null ? -1 : aji.wxD.size());
                                objArr[2] = Integer.valueOf(aji.status);
                                str2 = String.format(locale, str3, objArr);
                            }
                            x.i("MicroMsg.AppBrandHistoryLogic", "onCgiBack, errType %d, errCode %d, errMsg %s, resp %s", Integer.valueOf(i), Integer.valueOf(i2), str, str2);
                            if (aji != null && i == 0 && i2 == 0) {
                                if ((i4 & 4) > 0 && !i.abe() && (aji.status & 8) > 0) {
                                    i.abf();
                                }
                                g.Dq().Db().a(a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.valueOf((aji.status & 4) > 0));
                                b.jE(aji.status);
                                if (!bi.cC(aji.wxD)) {
                                    p Zx = e.Zx();
                                    List<ccn> list = aji.wxD;
                                    a aVar = new a();
                                    List linkedList = new LinkedList();
                                    List linkedList2 = new LinkedList();
                                    long dA = Zx.iIR.dA(Thread.currentThread().getId());
                                    for (ccn ccn : list) {
                                        if (!bi.oN(ccn.username)) {
                                            aVar.field_brandId = ccn.username;
                                            aVar.field_versionType = ccn.vVl;
                                            aVar.field_scene = 2;
                                            if (Zx.iNf.b((com.tencent.mm.sdk.e.c) aVar, new String[0])) {
                                                aVar.field_updateTime = Math.max((long) ccn.wbg, aVar.field_updateTime);
                                                if (Zx.iNf.c(aVar, new String[0])) {
                                                    linkedList2.add(String.valueOf(aVar.field_recordId));
                                                }
                                            } else {
                                                aVar.field_updateTime = (long) ccn.wbg;
                                                if (Zx.a(aVar)) {
                                                    linkedList.add(String.valueOf(aVar.field_recordId));
                                                }
                                            }
                                        }
                                    }
                                    Zx.iIR.fT(dA);
                                    if (!bi.cC(linkedList)) {
                                        Zx.b("batch", 2, linkedList);
                                    }
                                    if (!bi.cC(linkedList2)) {
                                        Zx.b("batch", 3, linkedList2);
                                    }
                                    if (!bi.cC(aji.wxD)) {
                                        int i3;
                                        int i4 = ((ccn) aji.wxD.getFirst()).wbg;
                                        Iterator it = aji.wxD.iterator();
                                        while (true) {
                                            i3 = i4;
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            i4 = Math.min(i3, ((ccn) it.next()).wbg);
                                        }
                                        if (i3 > 0) {
                                            g.Dq().Db().a(a.USERINFO_APP_BRAND_HISTORY_LIST_PAGING_LAST_SERVER_MIN_UPDATE_TIME_LONG, Long.valueOf((long) i3));
                                        }
                                    }
                                    n.a(i5, bundle2, aji.wxD);
                                }
                                m.a(i5, i, i2, (b) kVar.hoq);
                            }
                            c.this.b("batch", 3, Long.valueOf(j2));
                        }
                    }
                }.Kb();
            }
        }
    }

    private c() {
    }

    public static c aaX() {
        if (iLR == null) {
            synchronized (c.class) {
                if (iLR == null) {
                    iLR = new c();
                }
            }
        }
        return iLR;
    }

    public static void release() {
        iLR = null;
    }

    public final void a(long j, boolean z, Bundle bundle) {
        final boolean z2 = z;
        final long j2 = j;
        final Bundle bundle2 = bundle;
        com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
            public final void run() {
                c.a(c.this, 3, ((z2 & 1) != 0 ? 2 : 0) | 1, j2, z2, bundle2);
            }
        });
    }

    public static boolean aaY() {
        if (g.Do().CF()) {
            return ((Boolean) g.Dq().Db().get(a.USERINFO_APP_BRAND_HISTORY_HAS_MORE_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        }
        return false;
    }
}
