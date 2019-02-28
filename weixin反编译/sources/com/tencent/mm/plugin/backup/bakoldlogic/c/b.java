package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.backup.f.b {
    private ab kxk = new ab();
    private ac kxl = new ac();

    public b(int i) {
        this.kxk.kym = i;
    }

    public final a aqo() {
        return this.kxl;
    }

    public final a aqp() {
        return this.kxk;
    }

    public final void nd(int i) {
        if (this.kxl.kyY == 0) {
            f(0, 0, "ok");
            return;
        }
        x.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", Integer.valueOf(this.kxk.kym), Integer.valueOf(this.kxl.kyY));
        f(4, this.kxl.kyY, "fail");
    }

    public final int getType() {
        return 3;
    }
}
