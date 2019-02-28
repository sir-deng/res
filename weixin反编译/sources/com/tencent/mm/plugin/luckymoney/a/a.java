package com.tencent.mm.plugin.luckymoney.a;

import android.text.TextUtils;
import com.tencent.mm.bx.h;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.tj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.b.b;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class a implements ap {
    private com.tencent.mm.y.bt.a lnL = new com.tencent.mm.y.bt.a() {
        public final void a(com.tencent.mm.ad.d.a aVar) {
            Map y = bj.y(n.a(aVar.hoa.vNO), "sysmsg");
            x.i("MicroMsg.SubCoreLuckyMoney", "helios::::mPayMsgListener");
            if (y == null) {
                x.e("MicroMsg.SubCoreLuckyMoney", "Resolve msg error");
                return;
            }
            if ("14".equals((String) y.get(".sysmsg.paymsg.PayMsgType"))) {
                String decode = URLDecoder.decode((String) y.get(".sysmsg.paymsg.appmsgcontent"));
                if (TextUtils.isEmpty(decode)) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "msgxml illegal");
                    return;
                }
                Map y2 = bj.y(decode, "msg");
                if (y2 == null) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "Resolve appmsgxml error");
                    return;
                }
                String str = (String) y2.get(".msg.appmsg.wcpayinfo.paymsgid");
                if (bi.oN(str)) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "paymsgid is null");
                    return;
                }
                String str2 = (String) y.get(".sysmsg.paymsg.tousername");
                if (bi.oN(decode) || bi.oN(str2)) {
                    x.e("MicroMsg.SubCoreLuckyMoney", "onRecieveMsg get a illegal msg,which content or toUserName is null");
                } else if (a.this.aXy().Ez(str)) {
                    x.i("MicroMsg.SubCoreLuckyMoney", "insert a local msg for luckymoney");
                    if (!com.tencent.mm.plugin.luckymoney.b.n.B(decode, str2, 1)) {
                        a.this.aXy().EA(str);
                    }
                }
            }
        }
    };
    private d oer;
    private f oes;
    private b oet = new b();
    private ai oeu;
    private c<tj> oev = new c<tj>() {
        {
            this.xmG = tj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            tj tjVar = (tj) bVar;
            if (!bi.oN(tjVar.fMF.fEK)) {
                com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(tjVar.fMF.fEK);
                if (!bi.oN(fV.hes)) {
                    x.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", fV.hes);
                    y NK = o.bLZ().NK(fV.hes);
                    if (NK == null) {
                        NK = new y();
                    }
                    if (bi.oN(NK.field_mNativeUrl)) {
                        NK.field_mNativeUrl = fV.hes;
                        NK.field_receiveStatus = 0;
                    }
                    o.bLZ().a(NK);
                }
            }
            return false;
        }
    };

    public static a aXv() {
        return (a) p.s(a.class);
    }

    public a() {
        File file = new File(aXx());
        if (!file.exists()) {
            file.mkdir();
        }
        file = new File(e.gJo);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public final HashMap<Integer, h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bt(boolean z) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.e bZI = ao.bZI();
        if (g.Do().CF()) {
            com.tencent.mm.plugin.y.a.aRP().a(4, (t) bZI);
            g.Dr();
            g.Dp().gRu.a(1060, bZI);
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().a("paymsg", this.lnL, true);
        boolean z2 = false;
        g.Dr();
        if (System.currentTimeMillis() - g.Dq().Db().DF(352276) >= 43200000) {
            z2 = true;
        }
        x.i("MicroMsg.SubCoreLuckyMoney", "isTime=" + z2 + ", isUpdate=" + z);
        if (z || z2) {
            x.i("MicroMsg.SubCoreLuckyMoney", "get service applist");
            ao.bZI().ek(ad.getContext());
        }
        com.tencent.mm.sdk.b.a.xmy.b(this.oet);
        com.tencent.mm.sdk.b.a.xmy.b(this.oev);
        this.oeu = new ai();
    }

    public final void onAccountRelease() {
        com.tencent.mm.ad.e bZI = ao.bZI();
        if (g.Do().CF()) {
            com.tencent.mm.plugin.y.a.aRP().b(4, bZI);
            g.Dr();
            g.Dp().gRu.b(1060, bZI);
            bZI.vmc = false;
            bZI.vmd = false;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.n) g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class)).getSysCmdMsgExtension().b("paymsg", this.lnL, true);
        synchronized (this) {
            this.oes = null;
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.oet);
        com.tencent.mm.sdk.b.a.xmy.c(this.oev);
        if (this.oeu != null) {
            ai aiVar = this.oeu;
            com.tencent.mm.sdk.b.a.xmy.c(aiVar.ojq);
            if (aiVar.ojn != null) {
                g.Dr();
                g.Dp().gRu.c(aiVar.ojn);
                aiVar.ojn = null;
            }
            if (aiVar.ojo != null) {
                g.Dr();
                g.Dp().gRu.c(aiVar.ojo);
                aiVar.ojo = null;
            }
        }
    }

    public static d aXw() {
        g.Do().CA();
        if (aXv().oer == null) {
            aXv().oer = new d();
        }
        return aXv().oer;
    }

    public static String aXx() {
        if (g.Do().CF()) {
            return com.tencent.mm.plugin.n.c.Fp() + "luckymoney";
        }
        return "";
    }

    public final synchronized f aXy() {
        if (this.oes == null) {
            this.oes = new f();
        }
        return this.oes;
    }
}
