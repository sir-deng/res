package com.tencent.mm.plugin.accountsync.a;

import android.content.SharedPreferences;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.i.a.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class c implements ap {
    private static int hWi = 0;
    public static int inb = a.ini;
    private static al ind = null;
    private a ina = null;
    private com.tencent.mm.plugin.accountsync.model.a inc;
    private m ine = new m() {
        public final void b(String str, Map<String, String> map, com.tencent.mm.ad.d.a aVar) {
            if (bi.oM(str).equals("ChangeLaunchImage") && map != null) {
                x.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", (String) map.get(".sysmsg.ChangeLaunchImage.BeginTime"), (String) map.get(".sysmsg.ChangeLaunchImage.EndTime"), (String) map.get(".sysmsg.ChangeLaunchImage.ResId.SubType"));
                if (!bi.G(r0, r9, r10)) {
                    g.pWK.a(723, 5, 1, false);
                    int Wo = bi.Wo(r10);
                    if (Wo > 0) {
                        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
                        sharedPreferences.edit().putLong("new_launch_image_begin_time", bi.Wp(r0)).apply();
                        sharedPreferences.edit().putInt("new_launch_image_sub_type", Wo).apply();
                        sharedPreferences.edit().putLong("new_launch_image_end_time", bi.Wp(r9)).commit();
                        c.vnr;
                        c.pb(b.eA(43, Wo));
                    }
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c inf = new com.tencent.mm.sdk.b.c<bc>() {
        {
            this.xmG = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bc bcVar = (bc) bVar;
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
            int i = sharedPreferences.getInt("new_launch_image_sub_type", 0);
            if (bcVar.fqf.fqg == 43 && i > 0 && i == bcVar.fqf.fqh) {
                String str = bcVar.fqf.filePath;
                g.pWK.a(723, 6, 1, false);
                sharedPreferences.edit().putInt("new_launch_image_res_version", bcVar.fqf.fqi).commit();
                x.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
                c.pb(str);
            }
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.accountsync.a.c$4 */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] inh = new int[a.Xy().length];

        static {
            try {
                inh[a.inj - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                inh[a.ini - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                inh[a.ink - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] Xy() {
            return (int[]) inl.clone();
        }

        static {
            ini = 1;
            inj = 2;
            ink = 3;
            inl = new int[]{ini, inj, ink};
        }
    }

    static /* synthetic */ void pb(String str) {
        x.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
        if (!bi.oN(str)) {
            File file = new File(str);
            if (file.exists()) {
                String str2 = e.hbv + "splashWelcomeImg";
                if (com.tencent.mm.loader.stub.b.deleteFile(str2)) {
                    com.tencent.mm.a.e.x(file.getAbsolutePath(), str2);
                }
            }
        }
    }

    static /* synthetic */ int vD() {
        int i = hWi;
        hWi = i + 1;
        return i;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.inc.inq);
        this.inc = null;
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.ine);
        this.inf.dead();
    }

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.inc = new com.tencent.mm.plugin.accountsync.model.a();
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.ine);
        this.inf.cfB();
        c.vnr;
        b.BZ(43);
    }

    public final void bt(boolean z) {
    }

    public static void jh(int i) {
        inb = i;
        switch (AnonymousClass4.inh[i - 1]) {
            case 1:
                hWi = 0;
                if (ind == null) {
                    ind = new al(new com.tencent.mm.sdk.platformtools.al.a() {
                        public final boolean uG() {
                            c.vD();
                            if (c.hWi == 1 || c.hWi == 16 || c.hWi % 96 == 0) {
                                as.getNotification().xg();
                            }
                            return true;
                        }
                    }, true);
                }
                x.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                ind.K(900000, 900000);
                return;
            case 2:
            case 3:
                if (ind != null) {
                    ind.TN();
                }
                x.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                inb = a.ini;
                as.getNotification().xh();
                hWi = 0;
                ind = null;
                return;
            default:
                return;
        }
    }
}
