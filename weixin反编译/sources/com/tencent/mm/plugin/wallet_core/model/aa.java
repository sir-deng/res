package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ad.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.e.c;
import com.tencent.mm.y.bt.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class aa {
    static ArrayList<j> mnb = null;
    private static aa sVK = null;
    a lnL = new a() {
        public final void a(d.a aVar) {
            String a = n.a(aVar.hoa.vNO);
            x.d("MicroMsg.WalletPushNotifyManager", "PayMsg:" + a);
            Map y = bj.y(a, "sysmsg");
            int i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            if (!aa.a(aa.this, i, y)) {
                ah.y(new Runnable(i, y) {
                    public final void run() {
                        if (aa.mnb != null) {
                            Iterator it = aa.mnb.iterator();
                            while (it.hasNext()) {
                                j jVar = (j) it.next();
                                if (jVar != null) {
                                    jVar.sH(r1);
                                }
                            }
                        }
                    }
                });
            }
        }
    };

    static /* synthetic */ boolean a(aa aaVar, int i, Map map) {
        if (map == null) {
            x.w("MicroMsg.WalletPushNotifyManager", "hy: log is null. handle failed");
            return true;
        } else if (i < 0) {
            x.w("MicroMsg.WalletPushNotifyManager", "hy: paymsgtype error. maybe not found in xml");
            return true;
        } else if (i != 12) {
            return false;
        } else {
            final int i2 = bi.getInt((String) map.get(".sysmsg.paymsg.avail_balance"), -1);
            final long j = bi.getLong((String) map.get(".sysmsg.paymsg.balance_version"), -1);
            final long j2 = bi.getLong((String) map.get(".sysmsg.paymsg.time_out"), 7200);
            final int i3 = i;
            final Map map2 = map;
            e.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new e.a() {
                public final void T(Map<String, Object> map) {
                    if (map != null) {
                        long a = bi.a((Long) map.get("wallet_balance_version"), -1);
                        long a2 = bi.a((Long) map.get("wallet_balance_last_update_time"), -1);
                        if (a2 < 0 || a < 0 || a2 + j2 > bi.Wz() || j >= a) {
                            e.a(new c("wallet_balance_version", Long.valueOf(j)), new c("wallet_balance_last_update_time", Long.valueOf(bi.Wz())), new c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                            ah.y(/* anonymous class already generated */);
                            return;
                        }
                        x.w("MicroMsg.WalletPushNotifyManager", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                    }
                }
            });
            return true;
        }
    }

    private aa() {
    }

    public static aa bMm() {
        if (sVK == null) {
            sVK = new aa();
        }
        return sVK;
    }

    public static boolean a(j jVar) {
        if (jVar == null) {
            x.e("MicroMsg.WalletPushNotifyManager", "hy: the callback for registering is null. register failed");
            return false;
        }
        if (mnb == null) {
            mnb = new ArrayList();
        }
        mnb.add(jVar);
        return true;
    }

    public static boolean b(j jVar) {
        if (mnb == null) {
            x.e("MicroMsg.WalletPushNotifyManager", "hy: callback pool is null. release failed");
            return false;
        }
        mnb.remove(jVar);
        return true;
    }
}
