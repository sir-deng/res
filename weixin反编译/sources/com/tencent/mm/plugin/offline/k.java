package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.sz;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.b.b;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt.a;
import com.tencent.mm.y.p;
import java.util.HashMap;
import java.util.Map;

public class k implements ap {
    private static Map<String, String> gOF = new HashMap();
    private static HashMap<Integer, d> gyG = new HashMap();
    public static boolean pbH = false;
    public static int pbI = 10;
    private b iFJ;
    private a lnL = new a() {
        public final void a(final com.tencent.mm.ad.d.a aVar) {
            final String a = n.a(aVar.hoa.vNO);
            x.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:" + a);
            k.this.mHandler.post(new Runnable() {
                public final void run() {
                    s bhE = k.bhE();
                    String str = a;
                    long j = aVar.hoa.vNT;
                    x.v("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :" + j);
                    x.v("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :" + str);
                    if (!TextUtils.isEmpty(str)) {
                        if (bhE.dY(j)) {
                            x.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:" + j);
                            return;
                        }
                        String str2 = null;
                        int i = -1;
                        Map y = bj.y(str, "sysmsg");
                        if (y != null) {
                            String str3 = (String) y.get(".sysmsg.paymsg.ack_key");
                            str2 = str3;
                            i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                        }
                        if (com.tencent.mm.plugin.offline.c.a.biP()) {
                            x.v("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", Integer.valueOf(i));
                            if (i == 7 || i == 10) {
                                bhE.Hu(str);
                                bhE.Hv(str);
                            } else if (g.dM(str2, str)) {
                                g.pWK.a(135, 70, 1, true);
                                bhE.Hu(str);
                                bhE.Hv(str);
                            }
                        } else {
                            g.dM(str2, str);
                            bhE.Hu(str);
                            bhE.Hv(str);
                        }
                        if (bhE.oZO.size() > 10) {
                            bhE.oZO.remove(bhE.oZO.size() - 1);
                        }
                        bhE.oZO.add(0, Long.valueOf(j));
                    }
                }
            });
        }
    };
    private ag mHandler = new ag(Looper.getMainLooper());
    private s pbB = null;
    private e pbC = null;
    private i pbD = null;
    private com.tencent.mm.plugin.offline.b.a pbE = null;
    private com.tencent.mm.plugin.offline.ui.d pbF = new com.tencent.mm.plugin.offline.ui.d();
    public f pbG = new f();
    private c<sz> pbJ = new c<sz>() {
        {
            this.xmG = sz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            sz szVar = (sz) bVar;
            if (!bi.oN(szVar.fMi.fMj)) {
                com.tencent.mm.plugin.offline.c.a.Hz(szVar.fMi.fMj);
            }
            return false;
        }
    };
    private m pbK;

    static {
        com.tencent.mm.wallet_core.a.i("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.i("OfflineBindCardProcess", c.class);
        gyG.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.offline.b.a.gLy;
            }
        });
    }

    public static k bhD() {
        return (k) p.s(k.class);
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        this.iFJ = ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
            public final void a(f fVar, i.g gVar, boolean z) {
                x.i("MicroMsg.SubCoreOffline", "autoAuth: %s", Boolean.valueOf(z));
                if (!z) {
                    k.bhG().dg(7, 7);
                }
            }

            public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
            }
        });
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("paymsg", this.lnL, true);
        com.tencent.mm.sdk.b.a.xmy.b(this.pbF);
        com.tencent.mm.sdk.b.a.xmy.b(this.pbJ);
        this.pbB = null;
        this.pbC = null;
        this.pbD = null;
        this.pbK = new m();
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("paymsg", this.lnL, true);
        com.tencent.mm.sdk.b.a.xmy.c(this.pbF);
        com.tencent.mm.sdk.b.a.xmy.c(this.pbJ);
        if (this.pbK != null) {
            s.a aVar = this.pbK;
            bhD();
            bhE().b(aVar);
            com.tencent.mm.sdk.b.a.xmy.c(aVar.ojq);
        }
        this.pbK = null;
        this.iFJ.dead();
    }

    public static s bhE() {
        com.tencent.mm.kernel.g.Do().CA();
        if (bhD().pbB == null) {
            bhD().pbB = new s();
        }
        return bhD().pbB;
    }

    public static e bhF() {
        com.tencent.mm.kernel.g.Do().CA();
        if (bhD().pbC == null) {
            bhD().pbC = new e();
        }
        return bhD().pbC;
    }

    public static i bhG() {
        com.tencent.mm.kernel.g.Do().CA();
        if (bhD().pbD == null) {
            bhD().pbD = new i();
        }
        return bhD().pbD;
    }

    public static void aA(int i, String str) {
        if (str != null) {
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().Db().set(i, str);
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dq().Db().lO(true);
        }
    }

    public static String uF(int i) {
        com.tencent.mm.kernel.g.Dr();
        return (String) com.tencent.mm.kernel.g.Dq().Db().get(i, null);
    }

    public static com.tencent.mm.plugin.offline.b.a bhH() {
        if (com.tencent.mm.kernel.g.Do().CF()) {
            if (bhD().pbE == null) {
                k bhD = bhD();
                com.tencent.mm.kernel.g.Dr();
                bhD.pbE = new com.tencent.mm.plugin.offline.b.a(com.tencent.mm.kernel.g.Dq().gRU);
            }
            return bhD().pbE;
        }
        throw new com.tencent.mm.y.b();
    }
}
