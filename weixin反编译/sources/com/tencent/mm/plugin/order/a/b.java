package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bt.a;
import com.tencent.mm.y.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements ap {
    private static HashMap<Integer, d> gyG;
    private List<WeakReference<Object>> kOg = new ArrayList();
    private a lnL = new a() {
        public final void a(final com.tencent.mm.ad.d.a aVar) {
            final String a = n.a(aVar.hoa.vNO);
            x.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:" + a);
            b.this.mHandler.post(new Runnable() {
                public final void run() {
                    c bjc = b.bjc();
                    String str = a;
                    String str2 = aVar.hoa.vNL;
                    if (!TextUtils.isEmpty(str)) {
                        j HN = c.HN(str);
                        if (HN == null) {
                            x.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                        } else if (!TextUtils.isEmpty(HN.pgY) || !TextUtils.isEmpty(HN.php) || !TextUtils.isEmpty(HN.pho) || !TextUtils.isEmpty(HN.fEK) || !TextUtils.isEmpty(HN.phk) || !TextUtils.isEmpty(HN.phl) || !TextUtils.isEmpty(HN.phj) || !TextUtils.isEmpty(HN.phn) || !TextUtils.isEmpty(HN.phm) || !TextUtils.isEmpty(HN.phi)) {
                            if (HN.phi != null && com.tencent.mm.plugin.order.c.c.xv(HN.phi)) {
                                int intValue = Integer.valueOf(HN.phi).intValue();
                                if (!(intValue == 2 || intValue == 1)) {
                                    return;
                                }
                            }
                            if (TextUtils.isEmpty(HN.phk)) {
                                HN.fEE = str2;
                            } else {
                                HN.fEE = str2 + HN.phk;
                            }
                            x.i("MicroMsg.MallPayMsgManager", "msgid: " + HN.fEE);
                            x.i("MicroMsg.MallPayMsgManager", "msgType: " + HN.phi);
                            if (bjc.HP(HN.fEE)) {
                                x.e("MicroMsg.MallPayMsgManager", "msg for id " + HN.fEE + " is exist!!");
                                com.tencent.mm.plugin.order.b.a HR = bjc.HR(HN.fEE);
                                bjc.HO(HN.fEE);
                                bjc.kPq.add(HN);
                                bjc.a(HN, str, HR.field_isRead);
                            } else {
                                bjc.kPq.add(HN);
                                bjc.a(HN, str, "0");
                            }
                            bjc.bjg();
                            b biZ = b.biZ();
                            if (HN != null) {
                                axl axl = new axl();
                                if (TextUtils.isEmpty(HN.phk) || !com.tencent.mm.plugin.order.c.c.xv(HN.phk)) {
                                    axl.pgR = (int) (System.currentTimeMillis() / 1000);
                                    axl.pgT = (int) (System.currentTimeMillis() / 1000);
                                } else {
                                    axl.pgR = Integer.valueOf(HN.phk).intValue();
                                    axl.pgT = Integer.valueOf(HN.phk).intValue();
                                }
                                axl.pgW = 100000;
                                axl.pgY = HN.pgY;
                                axl.pgO = HN.fEE;
                                axl.pgS = HN.phm;
                                axl.wLB = -1;
                                axl.pgZ = HN.phj;
                                axl.pha = HN.phm;
                                axl.phb = HN.fEK;
                            }
                            biZ.bja();
                        }
                    }
                }
            });
        }
    };
    private ag mHandler = new ag(Looper.getMainLooper());
    com.tencent.mm.plugin.order.model.b pfu = null;
    private com.tencent.mm.plugin.order.b.b pfv;
    private c pfw = null;
    private a pfx = new a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            final String a = n.a(aVar.hoa.vNO);
            x.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:" + a);
            b.this.mHandler.post(new Runnable() {
                public final void run() {
                    b bVar = b.this;
                    g.Do().CA();
                    if (bVar.pfu == null) {
                        bVar.pfu = new com.tencent.mm.plugin.order.model.b();
                    }
                    com.tencent.mm.plugin.order.model.b bVar2 = bVar.pfu;
                    String str = a;
                    if (!bi.oN(str)) {
                        Map y = bj.y(str, "sysmsg");
                        if (y != null) {
                            try {
                                str = (String) y.get(".sysmsg.wxpay.transid");
                                if (!bi.oN(str)) {
                                    x.d("MicroMsg.WalletOrdersManager", "transid " + str);
                                    if (!bVar2.pfO.contains(str)) {
                                        bVar2.pfO.add(str);
                                        g.Dr();
                                        g.Dq().Db().set(204817, Integer.valueOf(bVar2.pfO.size()));
                                        x.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.pfO.size());
                                        bVar2.bjd();
                                        b.biZ().asP();
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.WalletOrdersManager", "cmdid error");
                            }
                        }
                    }
                }
            });
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.order.b.b.gLy;
            }
        });
        com.tencent.mm.wallet_core.a.i("ShowOrdersInfoProcess", a.class);
    }

    public static b biZ() {
        return (b) p.s(b.class);
    }

    public final void bja() {
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void asP() {
        if (this.kOg != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.kOg.size()) {
                    WeakReference weakReference = (WeakReference) this.kOg.get(i2);
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        this.pfu = null;
        this.pfw = null;
    }

    public final void onAccountRelease() {
    }

    public static com.tencent.mm.plugin.order.b.b bjb() {
        g.Do().CA();
        if (biZ().pfv == null) {
            b biZ = biZ();
            g.Dr();
            biZ.pfv = new com.tencent.mm.plugin.order.b.b(g.Dq().gRU);
        }
        return biZ().pfv;
    }

    public static c bjc() {
        g.Do().CA();
        if (biZ().pfw == null) {
            biZ().pfw = new c();
        }
        return biZ().pfw;
    }

    public static String aXx() {
        if (g.Do().CF()) {
            return com.tencent.mm.plugin.n.c.Fp() + "order";
        }
        return "";
    }
}
