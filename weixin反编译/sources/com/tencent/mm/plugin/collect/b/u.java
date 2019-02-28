package com.tencent.mm.plugin.collect.b;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.on;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g.a;
import com.tencent.mm.wallet_core.ui.g;

public final class u extends c<on> {
    Dialog ikw;

    public u() {
        this.xmG = on.class.getName().hashCode();
    }

    private boolean a(final on onVar) {
        x.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", Integer.valueOf(onVar.fHl.type));
        if (onVar.fHl.frC == null || onVar.fHl.frC.get() == null) {
            x.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
            onVar.fHl.frD.run();
        } else {
            Context context = (Context) onVar.fHl.frC.get();
            k kVar;
            if (onVar.fHl.type == 0) {
                this.ikw = g.a(context, false, null);
                kVar = new k(onVar.fHl.fHn, onVar.fHl.scene);
                com.tencent.mm.kernel.g.CN().a(1800, new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        if (u.this.ikw != null && u.this.ikw.isShowing()) {
                            u.this.ikw.dismiss();
                            u.this.ikw = null;
                        }
                        com.tencent.mm.kernel.g.CN().b(1800, (e) this);
                        final k kVar2 = (k) kVar;
                        kVar2.a(new a<k>() {
                            public final /* bridge */ /* synthetic */ void f(int i, int i2, String str, k kVar) {
                                k kVar2 = (k) kVar;
                                onVar.fHm.actionType = kVar2.lor.kRj;
                                onVar.fHm.fHo = kVar2.lor.wRu;
                            }
                        }).b(new a() {
                            public final void f(int i, int i2, String str, k kVar) {
                                onVar.fHm.foE = kVar2.lor.lou;
                            }
                        }).c(new a() {
                            public final void f(int i, int i2, String str, k kVar) {
                                onVar.fHm.foE = str;
                            }
                        });
                        onVar.fHl.frD.run();
                    }
                });
                com.tencent.mm.kernel.g.CN().a(kVar, 0);
            } else if (onVar.fHl.type == 1) {
                this.ikw = g.a(context, false, null);
                kVar = new com.tencent.mm.plugin.collect.reward.a.c(onVar.fHl.fHn, onVar.fHl.scene);
                com.tencent.mm.kernel.g.CN().a(2811, new e() {
                    public final void a(int i, int i2, String str, k kVar) {
                        if (u.this.ikw != null && u.this.ikw.isShowing()) {
                            u.this.ikw.dismiss();
                            u.this.ikw = null;
                        }
                        com.tencent.mm.kernel.g.CN().b(2811, (e) this);
                        final com.tencent.mm.plugin.collect.reward.a.c cVar = (com.tencent.mm.plugin.collect.reward.a.c) kVar;
                        cVar.a(new a<com.tencent.mm.plugin.collect.reward.a.c>() {
                            public final /* bridge */ /* synthetic */ void f(int i, int i2, String str, k kVar) {
                                com.tencent.mm.plugin.collect.reward.a.c cVar = (com.tencent.mm.plugin.collect.reward.a.c) kVar;
                                onVar.fHm.actionType = cVar.lpg.kRj;
                                onVar.fHm.fHo = cVar.lpg.wRu;
                            }
                        }).b(new a() {
                            public final void f(int i, int i2, String str, k kVar) {
                                onVar.fHm.foE = cVar.lpg.lou;
                            }
                        }).c(new a() {
                            public final void f(int i, int i2, String str, k kVar) {
                                onVar.fHm.foE = str;
                            }
                        });
                        onVar.fHl.frD.run();
                    }
                });
                com.tencent.mm.kernel.g.CN().a(kVar, 0);
            } else {
                x.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", Integer.valueOf(onVar.fHl.type));
            }
        }
        return false;
    }
}
