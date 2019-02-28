package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.bp;
import com.tencent.mm.f.a.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.c.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<bp> implements e {
    private bp mEM;
    private boolean mEN;

    public b() {
        this.mEN = false;
        this.xmG = bp.class.getName().hashCode();
    }

    private boolean a(bp bpVar) {
        if (g.Do().CF()) {
            this.mEN = false;
            if (!(bpVar instanceof bp)) {
                return false;
            }
            this.mEM = bpVar;
            x.i("MicroMsg.CloseFingerPrintEventListener", "handle CloseFingerPrintEvent");
            g.Dr();
            g.Dp().gRu.a(385, (e) this);
            k dVar = new d();
            g.Dr();
            g.Dp().gRu.a(dVar, 0);
            return true;
        }
        x.e("MicroMsg.CloseFingerPrintEventListener", "CloseFingerPrintEvent account is not ready");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            a aVar = new a();
            x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is success");
                aVar.retCode = 0;
            } else {
                x.i("MicroMsg.CloseFingerPrintEventListener", "NetSceneTenpayCloseTouchPay doscene is fail");
                aVar.retCode = i2;
            }
            g.Dr();
            g.Dp().gRu.b(385, (e) this);
            this.mEM.fqD = aVar;
            this.mEN = true;
            if (this.mEM.frD != null) {
                this.mEM.frD.run();
            }
            if (this.mEN) {
                this.mEM = null;
            }
        }
    }
}
