package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.mm.t.c.d;

public class n {
    private static volatile d iWN;
    private static volatile d iWO;

    public static d jY(int i) {
        if (i == 1) {
            return adn();
        }
        return adm();
    }

    private static d adm() {
        if (iWN == null) {
            synchronized (n.class) {
                if (iWN == null) {
                    d dVar = new d();
                    dVar.a(new l(312));
                    dVar.a(new d(306));
                    dVar.a(new e(306));
                    dVar.a(new b(305));
                    dVar.a(new c(307));
                    dVar.a(new k(309));
                    dVar.a(new j(310));
                    dVar.a(new f(311));
                    dVar.a(new m());
                    iWN = dVar;
                }
            }
        }
        return iWN;
    }

    private static d adn() {
        if (iWO == null) {
            synchronized (n.class) {
                if (iWO == null) {
                    d dVar = new d();
                    dVar.a(new l(289));
                    dVar.a(new d(266));
                    dVar.a(new e(266));
                    dVar.a(new b(265));
                    dVar.a(new c(267));
                    dVar.a(new k(281));
                    dVar.a(new j(282));
                    dVar.a(new f(287));
                    dVar.a(new h());
                    dVar.a(new i());
                    dVar.a(new m());
                    dVar.a(new h());
                    dVar.a(new g());
                    dVar.a(new a());
                    iWO = dVar;
                }
            }
        }
        return iWO;
    }
}
