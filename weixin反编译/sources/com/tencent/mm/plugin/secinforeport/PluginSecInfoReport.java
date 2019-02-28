package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.mm.a.h;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.normsg.a;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.y;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSecInfoReport extends f implements b {
    private static HandlerThread qkW = null;
    private static ag qkX = null;

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(d.class);
        dependsOn(b.class);
        dependsOn(a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.plugin.secinforeport.a.d.a(c.qla);
        com.tencent.mm.plugin.secinforeport.a.a.a(a.qkU);
    }

    public void execute(g gVar) {
        if (qkW == null) {
            try {
                HandlerThread WL = e.WL("SIRWorker");
                qkW = WL;
                WL.start();
                qkX = new ag(qkW.getLooper());
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        com.tencent.mm.sdk.b.a.xmy.a(new c<lw>() {
            {
                this.xmG = lw.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                PluginSecInfoReport.this.reportSecurityInfoAsync(0);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xmy.a(new c<com.tencent.mm.f.a.e>() {
            {
                this.xmG = com.tencent.mm.f.a.e.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                if (!((com.tencent.mm.f.a.e) bVar).fnJ.fnK) {
                    PluginSecInfoReport.this.reportSecurityInfoAsync(0);
                }
                return false;
            }
        });
        ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
            public final void a(i.f fVar, i.g gVar, boolean z) {
                PluginSecInfoReport.this.reportSecurityInfoAsync(z ? 0 : 540999680);
            }

            public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
                PluginSecInfoReport.this.reportSecurityInfoAsync(540999681);
            }
        });
    }

    private void reportSecurityInfoAsync(final int i) {
        if (qkX == null) {
            x.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
        } else {
            qkX.post(new Runnable() {
                public final void run() {
                    try {
                        if (com.tencent.mm.plugin.secinforeport.a.d.qli.G(1, 86400000)) {
                            boolean z;
                            int i = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("DisableRiskScanSdkProb", 0);
                            int i2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("DisableInstalledPkgInfoReportProb", 0);
                            com.tencent.mm.kernel.g.Do();
                            int aJ = h.aJ(com.tencent.mm.kernel.a.Cn(), 101);
                            i = (i <= 0 || aJ < 0 || aJ > i) ? 0 : 1;
                            if (i2 <= 0 || aJ < 0 || aJ > i2) {
                                i2 = 0;
                            } else {
                                i2 = 1;
                            }
                            com.tencent.mm.plugin.normsg.a.d dVar = com.tencent.mm.plugin.normsg.a.d.oXY;
                            if (i == 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            String t = dVar.t(z, i2 == 0);
                            com.tencent.mm.plugin.secinforeport.a.d.qli.JC(t);
                            com.tencent.mm.plugin.secinforeport.a.d.qli.ca(t, i);
                        }
                        if (com.tencent.mm.plugin.secinforeport.a.d.qli.G(2, 129600000)) {
                            com.tencent.mm.plugin.secinforeport.a.d.qli.bqZ();
                        }
                    } catch (Throwable th) {
                        x.printErrStackTrace("MicroMsg.PSIR", th, "unexpected exception was thrown.", new Object[0]);
                    }
                }
            });
        }
    }
}
