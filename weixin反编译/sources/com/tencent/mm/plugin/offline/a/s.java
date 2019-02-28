package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class s {
    private List<WeakReference<a>> kOg = new ArrayList();
    public ArrayList<Long> oZO = new ArrayList();
    public b pcG = null;
    private HashSet<String> pcH = new HashSet();

    public interface a {
        boolean a(c cVar);
    }

    public class c {
        public int pcN;
    }

    public class b extends c {
        public String pcK;
        public String pcL;
        public String pcM;

        public b() {
            super();
        }
    }

    public class d extends c {
        public String fxT;

        public d() {
            super();
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.a.s$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ boolean pcI = false;

        AnonymousClass1(boolean z) {
        }

        public final void run() {
            x.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
            com.tencent.mm.kernel.g.Dr();
            com.tencent.mm.kernel.g.Dp().gRu.a(new b(this.pcI), 0);
        }
    }

    public class e extends c {
        public String pcO;
        public String pcP;
        public String pcQ;
        public String pcR;
        public String pcS;
        public boolean pcT = true;

        public e() {
            super();
        }
    }

    public class g extends c {
        public String fxT;
        public String id;
        public String pcW;
        public String pcX;
        public int pcY;

        public g() {
            super();
        }
    }

    public class f extends c {
        public h fMh;
        public String pcU;
        public Orders pcV;

        public f() {
            super();
        }
    }

    public class h {
        public String fLK;
        public String fLL;
        public String fLM;
        public String fLN;
        public String fLO;
        public boolean pcZ;

        public h(Map<String, String> map) {
            this.fLK = (String) map.get(".sysmsg.paymsg.guide_flag");
            this.fLL = (String) map.get(".sysmsg.paymsg.guide_wording");
            this.fLM = (String) map.get(".sysmsg.paymsg.left_button_wording");
            this.fLN = (String) map.get(".sysmsg.paymsg.right_button_wording");
            this.fLO = (String) map.get(".sysmsg.paymsg.upload_credit_url");
            this.pcZ = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
        }
    }

    public s() {
        Object biw = com.tencent.mm.plugin.offline.c.a.biw();
        if (!TextUtils.isEmpty(biw)) {
            Map y = bj.y(biw, "sysmsg");
            if (y != null) {
                int i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    b(J(y));
                }
            }
        }
        this.oZO.clear();
    }

    public final boolean dY(long j) {
        if (this.oZO == null || this.oZO.size() == 0) {
            x.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
            return false;
        }
        for (int i = 0; i < this.oZO.size(); i++) {
            if (((Long) this.oZO.get(i)).longValue() == j) {
                return true;
            }
        }
        return false;
    }

    private void b(c cVar) {
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null && aVar.a(cVar)) {
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(a aVar) {
        if (this.kOg == null) {
            this.kOg = new ArrayList();
        }
        if (aVar != null) {
            this.kOg.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kOg != null && aVar != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            this.kOg.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void Hu(String str) {
        com.tencent.mm.plugin.offline.c.a.HH("");
        com.tencent.mm.plugin.offline.c.a.HJ("");
        com.tencent.mm.plugin.offline.c.a.HI("");
        Map y = bj.y(str, "sysmsg");
        if (y != null) {
            int i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            int i2 = bi.getInt((String) y.get(".sysmsg.paymsg.pay_cmd"), -1);
            String str2 = (String) y.get(".sysmsg.paymsg.req_key");
            com.tencent.mm.plugin.offline.c.a.HH((String) y.get(".sysmsg.paymsg.ack_key"));
            com.tencent.mm.plugin.offline.c.a.uM(i);
            com.tencent.mm.plugin.offline.c.a.HI(str2);
            int i3 = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
            x.i("MicroMsg.WalletOfflineMsgManager", "msg type is " + i3);
            x.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", Integer.valueOf(i3), str);
            c fVar;
            if (i3 >= 0 && i3 == 4) {
                b(J(y));
                com.tencent.mm.plugin.offline.c.a.Hy(str);
            } else if (i3 >= 0 && i3 == 5) {
                boolean z;
                if (i2 == 1) {
                    x.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
                    k.bhD();
                    k.bhG().dg(4, 4);
                    z = false;
                } else {
                    z = true;
                }
                c eVar = new e();
                eVar.pcN = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                eVar.pcO = (String) y.get(".sysmsg.paymsg.cftretcode");
                eVar.pcP = (String) y.get(".sysmsg.paymsg.cftretmsg");
                eVar.pcQ = (String) y.get(".sysmsg.paymsg.wxretcode");
                eVar.pcR = (String) y.get(".sysmsg.paymsg.wxretmsg");
                eVar.pcS = (String) y.get(".sysmsg.paymsg.error_detail_url");
                eVar.pcT = true;
                eVar.pcT = z;
                b(eVar);
            } else if (i3 >= 0 && i3 == 6) {
                str2 = (String) y.get(".sysmsg.paymsg.transid");
                x.i("helios", "MSG_TYPE_ORDER trasid=" + str2);
                if (!bi.oN(str2)) {
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().a(com.tencent.mm.storage.w.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(true));
                }
                x.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", str);
                fVar = new f();
                fVar.pcN = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.pcU = (String) y.get(".sysmsg.paymsg.transid");
                fVar.pcV = com.tencent.mm.plugin.offline.c.a.K(y);
                if (fVar.pcV.sUf.size() > 0) {
                    com.tencent.mm.plugin.offline.c.a.HJ(((Commodity) fVar.pcV.sUf.get(0)).fvD);
                }
                if (y.containsKey(".sysmsg.paymsg.real_name_info")) {
                    fVar.fMh = new h(y);
                }
                b(fVar);
            } else if (i3 >= 0 && i3 == 7) {
                o.bMc().aJO();
            } else if (i3 >= 0 && i3 == 8) {
                fVar = new g();
                fVar.pcN = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.pcW = (String) y.get(".sysmsg.paymsg.good_name");
                fVar.pcX = (String) y.get(".sysmsg.paymsg.total_fee");
                fVar.fxT = (String) y.get(".sysmsg.paymsg.req_key");
                fVar.id = (String) y.get(".sysmsg.paymsg.id");
                str2 = (String) y.get(".sysmsg.paymsg.confirm_type");
                x.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + fVar.pcY);
                if (TextUtils.isEmpty(str2) || !str2.equals("1")) {
                    fVar.pcY = 0;
                } else {
                    fVar.pcY = 1;
                }
                b(fVar);
            } else if (i3 >= 0 && i3 == 10) {
                k.bhD();
                k.bhG().dg(4, 4);
            } else if (i3 >= 0 && i3 == 20) {
                com.tencent.mm.sdk.b.b syVar = new sy();
                syVar.fMg.fMh = new h(y);
                com.tencent.mm.sdk.b.a.xmy.m(syVar);
            } else if (i3 >= 0 && i3 == 23) {
                fVar = new d();
                fVar.pcN = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.fxT = (String) y.get(".sysmsg.paymsg.req_key");
                synchronized (this.pcH) {
                    if (this.pcH.contains(fVar.fxT)) {
                        x.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", fVar.fxT);
                        return;
                    }
                    this.pcH.add(fVar.fxT);
                    b(fVar);
                }
            } else if (i3 >= 0 && i3 == 24) {
                fVar = new d();
                fVar.pcN = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                fVar.fxT = (String) y.get(".sysmsg.paymsg.req_key");
                b(fVar);
            }
        }
    }

    private b J(Map<String, String> map) {
        if (this.pcG == null) {
            this.pcG = new b();
        }
        this.pcG.pcN = bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.pcG.pcK = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.pcG.pcL = (String) map.get(".sysmsg.paymsg.freezetype");
        this.pcG.pcM = (String) map.get(".sysmsg.paymsg.freezemsg");
        return this.pcG;
    }

    public final void Hv(String str) {
        int i = bi.getInt((String) bj.y(str, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
        Set hashSet = new HashSet();
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pbb));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pba));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.pbc));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.paZ));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.paW));
        if (hashSet.contains(Integer.valueOf(i))) {
            com.tencent.mm.kernel.g.Dt().F(new AnonymousClass1(false));
        }
    }
}
