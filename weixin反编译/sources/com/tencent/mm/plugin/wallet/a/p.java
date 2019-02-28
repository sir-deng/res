package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ad.d;
import com.tencent.mm.bx.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.r.c;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.q;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class p implements ap {
    private int fLt = 0;
    private int sJV = 0;
    private o sJW = new o();
    private v sJX = new v();
    private i sJY = new i();
    private b sJZ = new b() {
        public final void a(int i, m mVar, Object obj) {
            int intValue;
            if (bi.p(obj, 0) == 339975) {
                g.Dr();
                intValue = ((Integer) g.Dq().Db().get(339975, Integer.valueOf(0))).intValue();
                if (intValue != p.this.sJV) {
                    ao.bZI().reset();
                    p.this.sJV = intValue;
                }
            } else if (a.USERINFO_WALLET_REGION_TYPE_INT_SYNC.equals(obj)) {
                g.Dr();
                intValue = ((Integer) g.Dq().Db().get(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
                if (intValue != p.this.fLt) {
                    ao.bZI().reset();
                    p.this.fLt = intValue;
                }
            }
        }
    };
    private com.tencent.mm.plugin.messenger.foundation.a.m sKa = new com.tencent.mm.plugin.messenger.foundation.a.m() {
        public final void b(String str, Map<String, String> map, d.a aVar) {
            if ("paymsg".equals(str) && PayuSecureEncrypt.ENCRYPT_VERSION_HASH.equals(map.get(".sysmsg.paymsg.PayMsgType"))) {
                Object obj = (String) map.get(".sysmsg.paymsg.NewTagBankSerial");
                Object obj2 = (String) map.get(".sysmsg.paymsg.WalletRedDotWording");
                x.i("MicroMsg.SubCoreMMWallet", "moreTabWallet: %s, walletBankCard: %s, bankSerial: %s", Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.BankCardRedDot"), 0)), obj);
                if (bi.getInt((String) map.get(".sysmsg.paymsg.WalletRedDot"), 0) == 1) {
                    c.Bx().b(a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, true);
                } else {
                    c.Bx().b(a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, false);
                }
                if (r3 == 1) {
                    c.Bx().b(a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, true);
                } else {
                    c.Bx().b(a.NEW_BANDAGE_DATASOURCE_WALLET_BANKCARD_STRING_SYNC, false);
                }
                if (!bi.oN(obj2)) {
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, obj2);
                }
                if (!bi.oN(obj)) {
                    g.Dr();
                    String str2 = (String) g.Dq().Db().get(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, (Object) "");
                    if (!bi.oN(str2)) {
                        obj = str2 + "," + obj;
                    }
                    g.Dr();
                    g.Dq().Db().a(a.USERINFO_WALLET_BANKCARD_SERIAL_STRING_SYNC, obj);
                }
            }
        }
    };
    private j sKb = new j();

    static {
        com.tencent.mm.wallet_core.a.i("ForgotPwdProcess", com.tencent.mm.plugin.wallet.pwd.a.class);
        com.tencent.mm.wallet_core.a.i("BindCardProcess", com.tencent.mm.plugin.wallet_core.b.b.class);
    }

    public p() {
        File file = new File(com.tencent.mm.plugin.wallet_core.d.b.bMW());
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static p bKx() {
        return (p) com.tencent.mm.y.p.s(p.class);
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        g.Dr();
        this.sJV = ((Integer) g.Dq().Db().get(339975, Integer.valueOf(0))).intValue();
        g.Dr();
        this.fLt = ((Integer) g.Dq().Db().get(a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue();
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.sKa);
        com.tencent.mm.sdk.b.a.xmy.b(this.sJW);
        com.tencent.mm.sdk.b.a.xmy.b(this.sJX);
        com.tencent.mm.sdk.b.a.xmy.b(this.sJY);
        this.sKb.cfB();
        g.Dr();
        g.Dq().Db().a(this.sJZ);
        g.Dr();
        g.Dq().Db().a(a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.valueOf(false));
    }

    public final void onAccountRelease() {
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.sKa);
        com.tencent.mm.sdk.b.a.xmy.c(this.sJW);
        com.tencent.mm.sdk.b.a.xmy.c(this.sJX);
        com.tencent.mm.sdk.b.a.xmy.c(this.sJY);
        this.sKb.dead();
        g.Dr();
        g.Dq().Db().b(this.sJZ);
    }

    public static ag bKy() {
        return o.bMc();
    }

    public static String Oe() {
        g.Dr();
        String str = (String) g.Dq().Db().get(6, null);
        String DK = com.tencent.mm.sdk.platformtools.ap.DK(str);
        if (bi.oN(str)) {
            return "";
        }
        return str.substring(DK.length() + 1);
    }

    public static String bKz() {
        g.Dr();
        String str = (String) g.Dq().Db().get(6, null);
        if (bi.oN(str)) {
            str = "";
        } else {
            str = com.tencent.mm.sdk.platformtools.ap.DK(str.replace("+", ""));
        }
        if (!bi.oN(str)) {
            return str;
        }
        if (q.Gl()) {
            return "27";
        }
        return "86";
    }
}
