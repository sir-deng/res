package com.tencent.mm.y;

import com.tencent.mm.bx.h.d;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.f;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class p implements com.tencent.mm.kernel.api.a, c, f, h, com.tencent.mm.kernel.b.c {
    private static ConcurrentHashMap<String, p> hgS = new ConcurrentHashMap();
    private volatile a hgO;
    private volatile Class<? extends ap> hgP;
    private volatile ap hgQ;
    private volatile boolean hgR = false;

    public interface a {
        ap createSubCore();
    }

    public p(Class<? extends ap> cls) {
        this.hgP = cls;
        a(this.hgP.getName(), this);
    }

    public p(a aVar) {
        this.hgO = aVar;
    }

    public final synchronized ap FV() {
        if (this.hgQ == null) {
            a(createSubCore());
        }
        return this.hgQ;
    }

    public final void a(ap apVar) {
        synchronized (this) {
            this.hgQ = apVar;
            if (this.hgP == null && this.hgQ != null) {
                this.hgP = this.hgQ.getClass();
            }
        }
    }

    private ap createSubCore() {
        try {
            x.i("MicroMsg.CompatSubCore", "createSubCore(), %s %s", this.hgP, this.hgO);
            if (this.hgO != null) {
                return this.hgO.createSubCore();
            }
            return (ap) this.hgP.newInstance();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CompatSubCore", e, "", new Object[0]);
            throw new IllegalAccessError(e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.CompatSubCore", e2, "", new Object[0]);
            throw new IllegalAccessError(e2.getMessage());
        }
    }

    private synchronized void reset() {
        this.hgQ = null;
        this.hgR = false;
    }

    public static p a(String str, p pVar) {
        p pVar2 = (p) hgS.putIfAbsent(str, pVar);
        if (pVar2 == null) {
            com.tencent.mm.kernel.a.c DA = com.tencent.mm.kernel.a.c.DA();
            x.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", pVar);
            DA.gTm.putIfAbsent(pVar, DA.gTm);
        } else {
            pVar = pVar2;
        }
        x.i("MicroMsg.CompatSubCore", "registerCompatSubCoreWithNameIfAbsent %s, %s", str, pVar);
        return pVar;
    }

    public static p gs(String str) {
        p pVar = (p) hgS.get(str);
        if (pVar == null) {
            x.i("MicroMsg.CompatSubCore", "compatSubCore is null by name %s", str);
        } else {
            com.tencent.mm.kernel.a.c.DA().aD(pVar);
        }
        return pVar;
    }

    public static void FW() {
        for (p reset : hgS.values()) {
            reset.reset();
        }
    }

    public static void gL(int i) {
        for (p FV : hgS.values()) {
            ap FV2 = FV.FV();
            if (FV2 != null) {
                FV2.ge(i);
            }
        }
    }

    public static <T extends ap> T s(Class<T> cls) {
        p gs = gs(cls.getName());
        if (gs == null) {
            gs = new p((Class) cls);
            a(cls.getName(), gs);
        }
        return gs.FV();
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        ap FV = FV();
        if (FV == null) {
            return null;
        }
        return FV.Bu();
    }

    public void onAccountInitialized(e.c cVar) {
        ap FV = FV();
        if (FV != null) {
            FV.bs(cVar.gSl);
            this.hgR = true;
        }
    }

    public void onAccountRelease() {
        ap FV = FV();
        if (FV != null) {
            FV.onAccountRelease();
        }
    }

    public final void Dw() {
        ap FV = FV();
        if (FV != null && this.hgR) {
            FV.bt(com.tencent.mm.compatible.util.f.zl());
        }
    }

    public void fP(String str) {
    }

    public final void Dx() {
        FV();
    }

    public String toString() {
        return super.toString() + " " + this.hgP + " " + this.hgO + " " + this.hgQ;
    }
}
