package com.tencent.mm.plugin.auth;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.y;
import com.tencent.mm.y.at;

public class PluginAuth extends f implements b {
    private final a knO = new a();

    private static final class a extends com.tencent.mm.cc.a<com.tencent.mm.plugin.auth.a.a> implements com.tencent.mm.plugin.auth.a.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(final i.f fVar, final g gVar, final boolean z) {
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.plugin.auth.a.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.plugin.auth.a.a) obj).a(fVar, gVar, z);
                }
            });
        }

        public final void a(y.b bVar, String str, int i, String str2, String str3, int i2) {
            final y.b bVar2 = bVar;
            final String str4 = str;
            final int i3 = i;
            final String str5 = str2;
            final String str6 = str3;
            final int i4 = i2;
            a(new com.tencent.mm.cc.a.a<com.tencent.mm.plugin.auth.a.a>() {
                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.plugin.auth.a.a) obj).a(bVar2, str4, i3, str5, str6, i4);
                }
            });
        }
    }

    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(com.tencent.mm.kernel.b.g gVar) {
        at.a(new com.tencent.mm.y.at.a() {
            public final void a(i.f fVar, g gVar) {
                com.tencent.mm.y.y.a(gVar.vHL, true);
                PluginAuth.this.getHandleAuthResponseCallbacks().a(fVar, gVar, true);
            }
        });
    }

    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    public String toString() {
        return "plugin-auth";
    }

    public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a aVar) {
        return this.knO.aE(aVar);
    }

    public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks() {
        return this.knO;
    }
}
