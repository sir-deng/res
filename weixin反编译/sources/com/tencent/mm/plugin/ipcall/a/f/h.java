package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class h extends a {
    public int nMh = 1;
    public boolean nMi = false;

    public final int[] aUq() {
        return new int[]{723};
    }

    public final int LI() {
        return 4;
    }

    public final void aUr() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            x.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", Integer.valueOf(cVar.nJe), Integer.valueOf(cVar.nJh));
            as.CN().a(new n(cVar.nJe, cVar.nJf, cVar.nJg, this.nMh), 0);
        }
    }
}
