package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bs;
import com.tencent.mm.y.bs.a;

public final class b implements c, com.tencent.mm.plugin.zero.b.b {
    private bs vhg;
    private r vhh;

    public final r Qj() {
        g.Dr();
        g.Do().CA();
        if (this.vhh == null) {
            this.vhh = new r();
        }
        return this.vhh;
    }

    public final bs bYG() {
        g.Dr();
        g.Do().CA();
        if (this.vhg == null) {
            this.vhg = new bs(new a() {
                public final boolean Ij() {
                    return b.this.Qj().hIZ == null;
                }
            });
        }
        return this.vhg;
    }

    public final void onAccountInitialized(e.c cVar) {
    }

    public final void onAccountRelease() {
        if (this.vhh != null) {
            r rVar = this.vhh;
            x.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", Integer.valueOf(rVar.hIW.size()), Integer.valueOf(rVar.hIX.size()), rVar.hIZ);
            rVar.hIW.clear();
            rVar.hIX.clear();
        }
        if (this.vhg != null) {
            this.vhg.Ie();
        }
    }
}
