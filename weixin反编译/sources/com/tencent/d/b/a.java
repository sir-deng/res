package com.tencent.d.b;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.e.e;
import com.tencent.d.b.f.d;
import com.tencent.d.b.f.f;
import com.tencent.d.b.f.h;
import com.tencent.d.b.f.j;
import com.tencent.d.b.f.k;

public final class a {
    public static void a(b<c> bVar, boolean z, e eVar) {
        com.tencent.d.a.c.c.i("Soter.SoterWrapperApi", "soter: starting prepare ask key. ", new Object[0]);
        d jVar = new j(eVar, z);
        jVar.Amm = bVar;
        if (!f.cHb().a(jVar, new c())) {
            com.tencent.d.a.c.c.d("Soter.SoterWrapperApi", "soter: add prepareAppSecureKey task failed.", new Object[0]);
        }
    }

    public static void a(b<c> bVar, boolean z, int i, e eVar, e eVar2) {
        com.tencent.d.a.c.c.i("Soter.SoterWrapperApi", "soter: starting prepare auth key: %d", Integer.valueOf(i));
        d kVar = new k(i, eVar, eVar2, z, true);
        kVar.Amm = bVar;
        if (!f.cHb().a(kVar, new c())) {
            com.tencent.d.a.c.c.d("Soter.SoterWrapperApi", "soter: add prepareAuthKey task failed.", new Object[0]);
        }
    }

    public static void a(b<com.tencent.d.b.a.a> bVar, com.tencent.d.b.f.b bVar2) {
        com.tencent.d.a.c.c.i("Soter.SoterWrapperApi", "soter: request authorize provide challenge. scene: %d", Integer.valueOf(bVar2.itU));
        d hVar = new h(bVar2);
        hVar.Amm = bVar;
        if (!f.cHb().a(hVar, new com.tencent.d.b.a.a())) {
            com.tencent.d.a.c.c.d("Soter.SoterWrapperApi", "soter: add requestAuthorizeAndSign task failed.", new Object[0]);
        }
    }

    public static boolean cGP() {
        return com.tencent.d.b.b.a.cGQ().isInit() && com.tencent.d.b.b.a.cGQ().cGP();
    }

    public static boolean Is(int i) {
        boolean isInit = com.tencent.d.b.b.a.cGQ().isInit();
        String str = (String) com.tencent.d.b.b.a.cGQ().cGS().get(i);
        if (isInit && !com.tencent.d.a.c.f.oN(str)) {
            return com.tencent.d.a.a.bt(str, false).errCode == 0;
        } else {
            if (isInit) {
                com.tencent.d.a.c.c.w("Soter.SoterWrapperApi", "soter: scene not registered in init. please make sure", new Object[0]);
                return false;
            }
            com.tencent.d.a.c.c.w("Soter.SoterWrapperApi", "soter: not initialized yet", new Object[0]);
            return false;
        }
    }
}
