package com.tencent.mm.plugin.wallet_ecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.cm;
import com.tencent.mm.f.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_ecard.a.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import java.util.HashMap;

public class a implements ap {
    private c<cm> tfo = new c<cm>() {
        {
            this.xmG = cm.class.getName().hashCode();
        }

        private boolean a(final cm cmVar) {
            final com.tencent.mm.f.a.cm.a aVar = cmVar.frw;
            HashMap hashMap = new HashMap();
            if (!bi.oN(aVar.packageExt)) {
                String[] split = aVar.packageExt.split("&");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bi.oN(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bi.oN(split2[0])) {
                                hashMap.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
            final String str = (String) hashMap.get("extradata");
            x.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", str, hashMap);
            k aVar2 = new com.tencent.mm.plugin.wallet_core.c.a(aVar.appId, aVar.fry, aVar.nonceStr, aVar.packageExt, aVar.signType, aVar.signature, aVar.frz, 15, "openECard", aVar.frE);
            g.Dr();
            g.Dp().gRu.a(580, new e() {
                public final void a(int i, int i2, String str, k kVar) {
                    g.Dr();
                    g.Dp().gRu.b(580, (e) this);
                    if (i == 0 && i2 == 0) {
                        x.i("MicroMsg.SubCoreECard", "jsapi check success");
                        f.TF(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bLs());
                        Context context = (Context) aVar.frC.get();
                        if (context == null || !(context instanceof Activity)) {
                            cmVar.frx.retCode = -1;
                            cmVar.frw.frD.run();
                            return;
                        }
                        b.a(bi.getInt(cmVar.frw.frB, 0), cmVar.frw.token, cmVar.frw.frA, str, context, new com.tencent.mm.wallet_core.c.a() {
                            public final Intent l(int i, Bundle bundle) {
                                x.i("MicroMsg.SubCoreECard", "open process end: %s", Integer.valueOf(i));
                                if (i == -1) {
                                    cmVar.frx.retCode = 0;
                                    com.tencent.mm.plugin.report.service.g.pWK.h(14954, f.cdH(), "openEcard:ok");
                                } else {
                                    cmVar.frx.retCode = -1;
                                    if (!f.cdG()) {
                                        com.tencent.mm.plugin.report.service.g.pWK.h(14954, f.cdH(), "openEcard:fail");
                                    }
                                }
                                cmVar.frw.frD.run();
                                if (!f.cdG()) {
                                    f.cdI();
                                }
                                return null;
                            }
                        });
                        return;
                    }
                    x.e("MicroMsg.SubCoreECard", "jsapi check fail");
                    cmVar.frx.retCode = -1;
                    cmVar.frw.frD.run();
                }
            });
            g.Dr();
            g.Dp().gRu.a(aVar2, 0);
            return false;
        }
    };
    private c<le> tfp = new c<le>() {
        {
            this.xmG = le.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            le leVar = (le) bVar;
            int i = 1;
            if (leVar.fDp.scene > 0) {
                i = leVar.fDp.scene;
            }
            Context context = (Context) leVar.fDp.frC.get();
            if (context != null) {
                b.a(i, null, "WEB_DEBIT", null, context, null);
            }
            return false;
        }
    };

    public final HashMap<Integer, d> Bu() {
        return null;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        this.tfo.cfB();
        this.tfp.cfB();
    }

    public final void bt(boolean z) {
    }

    public final void onAccountRelease() {
        this.tfo.dead();
        this.tfp.dead();
    }
}
