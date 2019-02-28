package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static volatile com.tencent.mm.cc.c<f> vhy;
    private final f vhz;

    public c() {
        if (vhy != null) {
            this.vhz = (f) vhy.get();
        } else {
            this.vhz = null;
        }
    }

    public final void bw(Object obj) {
        if (this.vhz != null) {
            this.vhz.bw(obj);
        }
    }

    public final boolean a(ot otVar, boolean z) {
        if (g.Do().CF()) {
            long Wy = bi.Wy();
            byte[] a = n.a(otVar.weu);
            x.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", Long.valueOf(Wy), Integer.valueOf(otVar.wet), Integer.valueOf(bi.bz(a)), Long.valueOf(Thread.currentThread().getId()));
            if (bi.by(a)) {
                x.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                return false;
            }
            try {
                if (this.vhz != null) {
                    this.vhz.a(otVar, a, z);
                }
                x.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", Long.valueOf(Wy), Integer.valueOf(otVar.wet), Long.valueOf(bi.bA(Wy)));
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e, "", new Object[0]);
                return false;
            }
        }
        x.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        return false;
    }

    public final void bx(Object obj) {
        if (this.vhz != null) {
            this.vhz.bx(obj);
        }
    }

    public final void by(Object obj) {
        if (this.vhz != null) {
            this.vhz.by(obj);
        }
    }
}
