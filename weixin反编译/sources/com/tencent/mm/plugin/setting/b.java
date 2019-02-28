package com.tencent.mm.plugin.setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ad.d;
import com.tencent.mm.bx.h;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.k.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.ayi;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.e.g;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.bt;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public final class b implements ap {
    private com.tencent.mm.sdk.e.m.b qlS = new com.tencent.mm.sdk.e.m.b() {
        public final void a(int i, m mVar, Object obj) {
            if (i == 2) {
                final String str = (String) obj;
                as.Hm();
                ag Xq = c.Ff().Xq(str);
                if (Xq != null && !a.ga(Xq.field_type) && Xq.AK() && !Xq.AL()) {
                    as.Dt().g(new Runnable() {
                        public final void run() {
                            as.Hm();
                            ag Xv = c.Ff().Xv(str);
                            if (Xv != null && !a.ga(Xv.field_type) && Xv.AK() && !Xv.AL()) {
                                au auVar = new au();
                                auVar.eS(0);
                                auVar.dU(str);
                                auVar.eR(6);
                                auVar.setContent(ad.getContext().getString(R.l.eLN));
                                auVar.aq(bb.n(str, System.currentTimeMillis() / 1000));
                                auVar.setType(10000);
                                as.Hm();
                                c.Fh().Q(auVar);
                                x.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", str);
                            }
                        }
                    }, 5000);
                }
            }
        }
    };
    private bt.a qlT = new bt.a() {
        public final void a(d.a aVar) {
            String a = n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreSetting", "onReceiveMsg, ShakeCardRedDotMsg msgContent is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y != null) {
                String aD = bi.aD((String) y.get(".sysmsg.RedPoints.redPoint.path"), "");
                int Wo = bi.Wo(bi.aD((String) y.get(".sysmsg.RedPoints.redPoint.redPointId"), ""));
                bi.Wo(bi.aD((String) y.get(".sysmsg.RedPoints.redPoint.mustClearInSameTime"), ""));
                if (!bi.oN(aD)) {
                    if (aD.equals("my_setting_privaty_recentOption")) {
                        as.Hm();
                        if (((Integer) c.Db().get(w.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(0))).intValue() < Wo) {
                            as.Hm();
                            c.Db().a(w.a.USERINFO_SETTING_RECENT_RED_DOT_ID_INT, Integer.valueOf(Wo));
                            as.Hm();
                            c.Db().a(w.a.USERINFO_MY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(Wo));
                            as.Hm();
                            c.Db().a(w.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(Wo));
                            as.Hm();
                            c.Db().a(w.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(Wo));
                            as.Hm();
                            c.Db().a(w.a.USERINFO_RECENT_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(Wo));
                            com.tencent.mm.r.c.Bx().p(266260, true);
                        }
                    } else if (aD.equals("my_setting_plugin_switch")) {
                        String aD2 = bi.aD((String) y.get(".sysmsg.RedPoints.redPoint.ext"), "");
                        if (!bi.oN(aD2)) {
                            as.Hm();
                            if (((Integer) c.Db().get(w.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(0))).intValue() < Wo) {
                                Object concat;
                                as.Hm();
                                c.Db().a(w.a.USERINFO_SETTING_PLUGIN_SWITCH_REDDOT_INT, Integer.valueOf(Wo));
                                as.Hm();
                                a = (String) c.Db().get(w.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, (Object) "");
                                if (bi.oN(a)) {
                                    a = aD2;
                                } else {
                                    concat = aD2.concat(",").concat(a);
                                }
                                as.Hm();
                                c.Db().a(w.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, concat);
                                com.tencent.mm.r.c.Bx().p(262158, true);
                            }
                        }
                    }
                }
            }
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.m qlU = new com.tencent.mm.plugin.messenger.foundation.a.m() {
        public final void b(String str, Map<String, String> map, d.a aVar) {
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.showtrustedfriends.wording");
                if (!bi.oN(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra(g.xMR, str2);
                    com.tencent.mm.bl.d.b(ad.getContext(), "setting", ".ui.setting.SettingsTrustFriendUI", intent);
                }
            }
        }
    };
    private bt.a qlV = new bt.a() {
        public final void a(d.a aVar) {
            String a = n.a(aVar.hoa.vNO);
            if (a == null || a.length() == 0) {
                x.e("MicroMsg.SubCoreSetting", "onReceiveMsg, crowdtest msgContent is null");
                return;
            }
            Map y = bj.y(a, "sysmsg");
            if (y != null) {
                int i = bi.getInt((String) y.get(".sysmsg.crowdtest.$clientversion"), 0);
                if (i > com.tencent.mm.protocal.d.vHl) {
                    long j = 0;
                    try {
                        j = new SimpleDateFormat("yyyy-MM-dd").parse((String) y.get(".sysmsg.crowdtest.apply.$expire")).getTime();
                    } catch (Exception e) {
                    }
                    if (j < System.currentTimeMillis()) {
                        b.bra();
                        return;
                    }
                    Object obj = (String) y.get(".sysmsg.crowdtest.apply.link");
                    Object obj2 = (String) y.get(".sysmsg.crowdtest.feedback.link");
                    as.Hm();
                    c.Db().a(w.a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(i));
                    as.Hm();
                    c.Db().a(w.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(j));
                    as.Hm();
                    c.Db().a(w.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, obj);
                    as.Hm();
                    c.Db().a(w.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, obj2);
                    int i2 = bi.getInt((String) y.get(".sysmsg.crowdtest.apply.reddotlevel"), 0);
                    com.tencent.mm.r.c.Bx().p(262157, i2 > 0);
                    if (i2 < 3) {
                        com.tencent.mm.r.c.Bx().aS(262157, 266261);
                    }
                    if (i2 < 2) {
                        com.tencent.mm.r.c.Bx().aS(262157, 266262);
                    }
                }
            }
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.m qlW = new com.tencent.mm.plugin.messenger.foundation.a.m() {
        public final void b(String str, Map<String, String> map, d.a aVar) {
            if (map != null) {
                String str2 = (String) map.get(".sysmsg.security");
                if (!bi.oN(str2)) {
                    try {
                        int i = bi.getInt(str2, 0);
                        as.Hm();
                        c.Db().a(w.a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(i));
                        if (i != 0) {
                            com.tencent.mm.r.c.Bx().b(w.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, true);
                        } else {
                            com.tencent.mm.r.c.Bx().b(w.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreSetting", e, "device protect security value is not number!", new Object[0]);
                    }
                }
            }
        }
    };

    public b() {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting constructor: " + System.currentTimeMillis());
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting clearPluginData: " + System.currentTimeMillis());
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountPostReset: " + System.currentTimeMillis());
        as.getSysCmdMsgExtension().a("redpointinfo", this.qlT, true);
        as.getSysCmdMsgExtension().a("crowdtest", this.qlV, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("showtrustedfriends", this.qlU);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("DeviceProtectRedSpot", this.qlW);
        as.Hm();
        int intValue = ((Integer) c.Db().get(w.a.USERINFO_CROWDTEST_CLIENT_VERSION_INT, Integer.valueOf(com.tencent.mm.protocal.d.vHl))).intValue();
        as.Hm();
        long longValue = ((Long) c.Db().get(w.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(0))).longValue();
        if (intValue <= com.tencent.mm.protocal.d.vHl || longValue < System.currentTimeMillis()) {
            bra();
        }
        if (z) {
            int Gj = (q.Gj() & -1048577) & -4194305;
            as.Hm();
            c.Db().set(34, Integer.valueOf(Gj));
            com.tencent.mm.bp.a ayi = new ayi();
            ayi.vMg = 1048576;
            ayi.wLZ = 0;
            as.Hm();
            c.Fe().b(new e.a(39, ayi));
            ayi = new ayi();
            ayi.vMg = 4194304;
            ayi.wLZ = 0;
            as.Hm();
            c.Fe().b(new e.a(39, ayi));
            x.i("MicroMsg.SubCoreSetting", "set void default open");
        }
        if (com.tencent.mm.j.g.Af().getInt("ShowTurnOnFriendVerificationSysmsgSwitch", 0) == 1 && (q.Gc() & 32) == 0) {
            as.Hm();
            c.Ff().a(this.qlS);
        }
    }

    public final void bt(boolean z) {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onSdcardMount: " + System.currentTimeMillis());
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.SubCoreSetting", "SubCoreSetting onAccountRelease: " + System.currentTimeMillis());
        as.getSysCmdMsgExtension().b("redpointinfo", this.qlT, true);
        as.getSysCmdMsgExtension().b("crowdtest", this.qlV, true);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("showtrustedfriends", this.qlU);
        ((com.tencent.mm.plugin.messenger.foundation.a.n) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("DeviceProtectRedSpot", this.qlW);
        as.Hm();
        c.Ff().b(this.qlS);
    }

    static void bra() {
        as.Hm();
        c.Db().a(w.a.USERINFO_CROWDTEST_APPLY_EXPIRE_LONG, Long.valueOf(0));
        as.Hm();
        c.Db().a(w.a.USERINFO_CROWDTEST_APPLY_LINK_STRING, (Object) "");
        com.tencent.mm.r.c.Bx().p(262157, false);
    }
}
