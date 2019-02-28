package com.tencent.mm.bl;

import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.p;

public final class c {
    public static n vGy;
    public static m vGz;

    public static void TG(String str) {
        if (((h) g.Dn().CU()).DZ()) {
            d.a(str, vGy, vGz);
        }
    }

    public static void b(final String str, final p pVar) {
        new a() {
            public final void execute(com.tencent.mm.kernel.b.g gVar) {
                String str = str;
                p pVar = pVar;
                d.a(str, c.vGy, c.vGz);
                if (pVar == null) {
                    pVar = new p(c.TH(str));
                }
                p.a("plugin." + str, pVar);
            }
        }.alone();
    }

    public static p.a TH(final String str) {
        x.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new p.a() {
            public final ap createSubCore() {
                return d.TJ(str);
            }
        }, str);
        return /* anonymous class already generated */;
    }
}
