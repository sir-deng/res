package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.f.a.aw;
import com.tencent.mm.f.a.bf;
import com.tencent.mm.f.a.cl;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.tinker.lib.e.a;
import java.util.HashMap;

public final class d implements ap {
    private final c<aw> lFG = new c<aw>() {
        {
            this.xmG = aw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            aw awVar = (aw) bVar;
            if (d.this.nGm) {
                Context context = ad.getContext();
                String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_after_install", "");
                com.tencent.tinker.lib.e.d dVar = a.ir(context).ArS;
                String str = dVar == null ? "" : dVar.ArX;
                x.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isAfterInstallDialogHaveShow currentVersion :%s tinkerVersion:%s", string, str);
                boolean z = bi.oN(string) || bi.oN(str) || !(bi.oN(string) || bi.oN(str) || !string.equalsIgnoreCase(str));
                if (!z) {
                    str = ad.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                    awVar.fpT.fpU = true;
                    awVar.fpT.fpV = str;
                    if (!bi.oN(str)) {
                        a.ry(2);
                    }
                    context = ad.getContext();
                    Object string2 = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                    if (!TextUtils.isEmpty(string2)) {
                        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_after_install", string2).apply();
                    }
                }
                d.this.nGm = false;
            }
            return false;
        }
    };
    boolean nGm = true;
    private final h nGn = new h();
    private final c<cl> nGo = new c<cl>() {
        {
            this.xmG = cl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            g.cW(ad.getContext());
            com.tinkerboots.sdk.a.cKg().JB(g.cX(ad.getContext()));
            return false;
        }
    };
    private final f nGp = new f();
    private final c<bf> nGq = new c<bf>() {
        {
            this.xmG = bf.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            as.CN().a(new com.tencent.mm.plugin.hp.c.a(), 0);
            return false;
        }
    };

    public final HashMap<Integer, com.tencent.mm.bx.h.d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.pluginsdk.cmd.b.a(new g(), "//tinker");
        as.getSysCmdMsgExtension().a("checktinkerupdate", this.nGn, true);
        com.tencent.mm.sdk.b.a.xmy.b(this.lFG);
        this.nGo.cfB();
        com.tencent.mm.sdk.b.a.xmy.b(this.nGp);
        com.tencent.mm.sdk.b.a.xmy.b(this.nGq);
        x.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        g.cW(ad.getContext());
        try {
            as.Hm();
            long longValue = ((Long) com.tencent.mm.y.c.Db().get(w.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= 3600000) {
                com.tinkerboots.sdk.a.cKg().om(true);
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(currentTimeMillis));
                x.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue));
            } else {
                com.tinkerboots.sdk.a.cKg().om(false);
                x.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            f.dx(currentTimeMillis);
        } catch (Throwable e) {
            x.printErrStackTrace("Tinker.SubCoreHotpatch", e, "", new Object[0]);
        }
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.pluginsdk.cmd.b.D("//tinker");
        as.getSysCmdMsgExtension().b("checktinkerupdate", this.nGn, true);
        com.tencent.mm.sdk.b.a.xmy.c(this.lFG);
        this.nGo.dead();
        com.tencent.mm.sdk.b.a.xmy.c(this.nGp);
        com.tencent.mm.sdk.b.a.xmy.c(this.nGq);
        x.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    }
}
