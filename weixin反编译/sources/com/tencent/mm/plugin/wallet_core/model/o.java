package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.cc.c;
import com.tencent.mm.cc.h;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a.nm;
import com.tencent.mm.f.a.tf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet_core.d.e;
import com.tencent.mm.plugin.wallet_core.d.f;
import com.tencent.mm.plugin.wallet_core.d.i;
import com.tencent.mm.plugin.wallet_core.d.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import com.tencent.mm.y.q;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class o implements ap {
    private static HashMap<Integer, d> gyG;
    private volatile q sUZ = new q();
    private h<ag> sVa = new h(new c<ag>() {
        public final /* synthetic */ Object get() {
            return new ag();
        }
    });
    private volatile aa sVb = null;
    private h<ad> sVc = new h(new c<ad>() {
        public final /* synthetic */ Object get() {
            return new ad();
        }
    });
    private h<j> sVd = new h(new c<j>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new j(g.Dq().gRU);
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.c> sVe = new h(new c<com.tencent.mm.plugin.wallet_core.d.c>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new com.tencent.mm.plugin.wallet_core.d.c(g.Dq().gRU);
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.a> sVf = new h(new c<com.tencent.mm.plugin.wallet_core.d.a>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new com.tencent.mm.plugin.wallet_core.d.a(g.Dq().gRU);
        }
    });
    private h<f> sVg = new h(new c<f>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new f(g.Dq().gRU);
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.d> sVh = new h(new c<com.tencent.mm.plugin.wallet_core.d.d>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new com.tencent.mm.plugin.wallet_core.d.d(g.Dq().gRU);
        }
    });
    private u sVi = new u();
    private h<e> sVj = new h(new c<e>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new e(g.Dq().gRU);
        }
    });
    private h<i> sVk = new h(new c<i>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new i(g.Dq().gRU);
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.h> sVl = new h(new c<com.tencent.mm.plugin.wallet_core.d.h>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new com.tencent.mm.plugin.wallet_core.d.h(g.Dq().gRU);
        }
    });
    private h<com.tencent.mm.plugin.wallet_core.d.g> sVm = new h(new c<com.tencent.mm.plugin.wallet_core.d.g>() {
        public final /* synthetic */ Object get() {
            g.Dr();
            return new com.tencent.mm.plugin.wallet_core.d.g(g.Dq().gRU);
        }
    });
    private com.tencent.mm.plugin.wallet_core.id_verify.util.a sVn = new com.tencent.mm.plugin.wallet_core.id_verify.util.a();
    private com.tencent.mm.sdk.b.c sVo = new com.tencent.mm.sdk.b.c<nm>() {
        {
            this.xmG = nm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nm nmVar = (nm) bVar;
            o.t(nmVar.fGp.context, nmVar.fGp.intent);
            return true;
        }
    };
    private com.tencent.mm.sdk.b.c<tf> sVp = new com.tencent.mm.sdk.b.c<tf>() {
        {
            this.xmG = tf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            y yVar;
            tf tfVar = (tf) bVar;
            com.tencent.mm.plugin.wallet_core.d.g bLZ = o.bLZ();
            String str = tfVar.fMv.fMx;
            if (!bi.oN(str)) {
                if (com.tencent.mm.plugin.wallet_core.d.g.ijA.containsKey(str)) {
                    yVar = (y) com.tencent.mm.plugin.wallet_core.d.g.ijA.get(str);
                } else {
                    yVar = bLZ.NK(str);
                    if (yVar != null) {
                        com.tencent.mm.plugin.wallet_core.d.g.ijA.put(str, yVar);
                    }
                }
                if (yVar != null) {
                    tfVar.fMw.fMy = yVar.field_hbStatus;
                    tfVar.fMw.fMz = yVar.field_receiveStatus;
                }
                return false;
            }
            yVar = null;
            if (yVar != null) {
                tfVar.fMw.fMy = yVar.field_hbStatus;
                tfVar.fMw.fMz = yVar.field_receiveStatus;
            }
            return false;
        }
    };
    private com.tencent.mm.y.bt.a sVq = new com.tencent.mm.y.bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            Map y = bj.y(n.a(aVar.hoa.vNO), "sysmsg");
            if (y != null) {
                int i = bi.getInt((String) y.get(".sysmsg.paymsg.PayMsgType"), -1);
                x.i("MicroMsg.SubCoreNfc", "got a pay msg, type = " + i);
                switch (i) {
                    case 16:
                        i = bi.getInt((String) y.get(".sysmsg.paymsg.Flag"), 0);
                        x.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                        if (i == 1) {
                            x.i("MicroMsg.SubCoreNfc", "open wallet");
                            q.Gi();
                            return;
                        } else if (i == 2) {
                            x.i("MicroMsg.SubCoreNfc", "close wallet");
                            i = q.Ge() & -32769;
                            g.Dr();
                            g.Dq().Db().set(40, Integer.valueOf(i));
                            return;
                        } else {
                            return;
                        }
                    case 17:
                        i = bi.getInt((String) y.get(".sysmsg.paymsg.WalletType"), -1);
                        x.i("MicroMsg.SubCoreNfc", "MSG_TYPE_WALLET_TYPE_CHANGE,wallet_type=" + i);
                        if (i >= 0) {
                            g.Dr();
                            g.Dq().Db().set(339975, Integer.valueOf(i));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    static class a implements com.tencent.mm.pluginsdk.cmd.a {
        a() {
        }

        public final boolean a(Context context, String[] strArr) {
            String str = strArr[0];
            boolean z = true;
            switch (str.hashCode()) {
                case -1912590262:
                    if (str.equals("//cleanpaycn")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    com.tencent.mm.wallet_core.c.a.cCe();
                    com.tencent.mm.wallet_core.c.a.clean();
                    return true;
                default:
                    return false;
            }
        }
    }

    static {
        k.b("tenpay_utils", o.class.getClassLoader());
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("WALLET_USER_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return j.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_BANKCARD_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.wallet_core.d.c.gLy;
            }
        });
        gyG.put(Integer.valueOf("LOAN_ENTRY_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.wallet_core.d.a.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_KIND_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return f.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_BULLETIN_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.wallet_core.d.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_PREF_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.wallet_core.d.h.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_FUNCTIOIN_INFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return e.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_GREY_ITEM_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
        gyG.put(Integer.valueOf("WALLET_LUKCY_MONEY".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.plugin.wallet_core.d.g.gLy;
            }
        });
    }

    public static o bLX() {
        return (o) p.s(o.class);
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public static j bLY() {
        if (g.Do().CF()) {
            return (j) bLX().sVd.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.g bLZ() {
        if (g.Do().CF()) {
            return (com.tencent.mm.plugin.wallet_core.d.g) bLX().sVm.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.c bMa() {
        if (g.Do().CF()) {
            return (com.tencent.mm.plugin.wallet_core.d.c) bLX().sVe.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.h bMb() {
        if (g.Do().CF()) {
            return (com.tencent.mm.plugin.wallet_core.d.h) bLX().sVl.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static ag bMc() {
        if (g.Do().CF()) {
            return (ag) bLX().sVa.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static ad bMd() {
        if (g.Do().CF()) {
            return (ad) bLX().sVc.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.a bMe() {
        if (g.Do().CF()) {
            return (com.tencent.mm.plugin.wallet_core.d.a) bLX().sVf.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static f bMf() {
        if (g.Do().CF()) {
            return (f) bLX().sVg.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static com.tencent.mm.plugin.wallet_core.d.d bMg() {
        if (g.Do().CF()) {
            return (com.tencent.mm.plugin.wallet_core.d.d) bLX().sVh.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static e bMh() {
        if (g.Do().CF()) {
            return (e) bLX().sVj.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public static i bMi() {
        if (g.Do().CF()) {
            return (i) bLX().sVk.get();
        }
        throw new com.tencent.mm.y.b();
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public static aa bMj() {
        return bLX().sVb;
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreNfc", "onAccountPostReset subcore walletCore");
        com.tencent.mm.wallet_core.c.a.cCe();
        com.tencent.mm.wallet_core.c.a.init(ad.getContext());
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("paymsg", this.sVq, true);
        bMc().bMH();
        this.sVb = aa.bMm();
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("paymsg", this.sVb.lnL, true);
        com.tencent.mm.sdk.b.a.xmy.b(this.sVo);
        com.tencent.mm.sdk.b.a.xmy.b(this.sVi);
        com.tencent.mm.sdk.b.a.xmy.a(this.sVp);
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), "//cleanpaycn");
    }

    public final void onAccountRelease() {
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("paymsg", this.sVq, true);
        bMc().aJO();
        ad bMd = bMd();
        bMd.sWe = null;
        bMd.sWd.clear();
        bMd.sWd = new ArrayList();
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("paymsg", this.sVb.lnL, true);
        if (aa.mnb != null) {
            aa.mnb.clear();
        }
        this.sVb = null;
        com.tencent.mm.sdk.b.a.xmy.c(this.sVo);
        com.tencent.mm.sdk.b.a.xmy.c(this.sVi);
        com.tencent.mm.sdk.b.a.xmy.c(this.sVp);
    }

    public static void t(Context context, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (q.Gm()) {
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            x.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is h5,jump to ibg");
            com.tencent.mm.bl.d.b(context, "wallet_core", ".ui.ibg.WalletIbgAdapterUI", intent);
        } else if (q.Gn()) {
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            com.tencent.mm.bl.d.b(context, "mall", ".ui.MallIndexOSUI", intent);
        } else {
            x.i("MicroMsg.SubCoreNfc", "entryWalletIndexPage wallet type is native");
            intent.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            com.tencent.mm.bl.d.b(context, "mall", ".ui.MallIndexUI", intent);
            g.Dr();
            if (g.Dq().isSDCardAvailable()) {
                com.tencent.mm.ad.k kVar = new com.tencent.mm.ay.k(11);
                g.Dr();
                g.Dp().gRu.a(kVar, 0);
            }
        }
    }

    public static q bMk() {
        return bLX().sUZ;
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar, com.tencent.mm.plugin.wallet_core.id_verify.util.a.a aVar) {
        return bLX().sVn.a(mMActivity, eVar, false, 1008);
    }

    public static boolean a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.e eVar) {
        return bLX().sVn.a(mMActivity, eVar, false, 1006);
    }
}
