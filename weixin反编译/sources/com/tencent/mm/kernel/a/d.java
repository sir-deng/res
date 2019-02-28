package com.tencent.mm.kernel.a;

import com.tencent.mm.compatible.e.n;
import com.tencent.mm.f.a.lt;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ag;
import java.util.HashSet;
import java.util.Iterator;

public abstract class d implements b {
    private final HashSet<String> gTA = new HashSet();
    public e<Object> gTz = e.DM();

    public void tO() {
        x.i("MicroMsg.ParallelsBootStep", "core num %s for parallels", Integer.valueOf((int) Math.min(Math.floor((((h) g.Dn().CU()).DZ() ? 1.5d : 1.0d) * ((double) n.yF())), 6.0d)));
        this.gTz.init(r0);
        c DA = c.DA();
        DA.gSX.a(b.class);
        DA.gSW.a(com.tencent.mm.kernel.a.c.b.class);
        DA.gSY.a(com.tencent.mm.kernel.api.h.class, a.class, com.tencent.mm.kernel.api.e.class, ag.class, c.class);
        com.tencent.mm.kernel.a.b.g gVar = DA.gSY;
        Object obj = new Class[]{c.class};
        gVar.gUl = new Class[1];
        System.arraycopy(obj, 0, gVar.gUl, 0, 1);
        ((h) g.Dn().CU()).gRM.gSR = new com.tencent.mm.kernel.a.a.b() {
            public final void a(Class cls, Object obj, Object obj2) {
                if (cls == com.tencent.mm.kernel.a.c.b.class) {
                    c.DA().gSW.a(cls, obj, obj2);
                } else if (cls == com.tencent.mm.kernel.b.b.class) {
                    c.DA().gSX.a(cls, obj, obj2);
                }
            }
        };
        com.tencent.mm.blink.a.ee("helloWeChat");
    }

    public static void o(Class<? extends f> cls) {
        g.Dm().f(cls);
    }

    public static void fR(String str) {
        g.Dm().fL(str);
    }

    public final void fS(String str) {
        this.gTA.add(str);
    }

    public final void Dy() {
        g.Dm().CS();
        this.gTz.prepare();
        for (e.c cVar : this.gTz.DO()) {
            c.DA().b(cVar.ffw.getLooper());
        }
        com.tencent.mm.blink.a.ee("makeDependency");
    }

    public void a(com.tencent.mm.kernel.b.g gVar) {
        this.gTz.a(new e.b(), c.gTg, c.DA().gSX, "configure-functional plugins");
        com.tencent.mm.blink.a.ee("configurePlugins");
    }

    public final void Dz() {
        this.gTz.a(new e.b(), c.gTh, c.DA().gSW, "task-functional plugins");
        com.tencent.mm.blink.a.ee("executeTasks");
    }

    public void b(com.tencent.mm.kernel.b.g gVar) {
        a.a("startup final step, account initialize... for parallels", new Object[0]);
        if (gVar.DZ()) {
            c DA = c.DA();
            for (f aC : g.Dm().CT()) {
                DA.aC(aC);
            }
            if (g.Do().CF()) {
                g.Do().Cv();
            }
        }
        com.tencent.mm.blink.a.ee("installPendingPlugins");
        long nanoTime = System.nanoTime();
        if (this.gTA.size() > 0) {
            Iterator it = this.gTA.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                g.Dr();
                g.Dm().p(str, true);
            }
            this.gTA.clear();
            com.tencent.mm.blink.a.h("installPendingPlugins installed", nanoTime);
            g.Dr();
            g.Dm().CS();
            com.tencent.mm.blink.a.ee("installPendingPlugins dependency made.");
            com.tencent.mm.sdk.b.a.xmy.m(new lt());
        }
        boolean tR = tR();
        boolean z = gVar.DZ() && g.Do().CF();
        if (z && !tR) {
            g.Do().CG();
        }
        com.tencent.mm.blink.b.wv().aT(tR);
        if (z && tR) {
            g.Do().CG();
        }
        com.tencent.mm.blink.a.ee("afterAccountInit");
    }

    public boolean tR() {
        return true;
    }
}
