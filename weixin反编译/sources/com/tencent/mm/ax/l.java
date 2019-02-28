package com.tencent.mm.ax;

import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.ase;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;

@Deprecated
public final class l extends b {
    private ase hKN;

    public l(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        this.hKN = new ase();
        rm rmVar = new rm();
        rmVar.wgj = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        rmVar.wgl = i3;
        rn rnVar = new rn();
        rnVar.wgn = i;
        rnVar.wgo = i2;
        rmVar.wgk = rnVar;
        rnVar.wgn = 0;
        rnVar.wgo = 0;
        rmVar.wgm = rnVar;
        this.hKN.wGJ = rmVar;
        this.ouK = this.hKN;
    }

    public l() {
        this(false, 22, 8);
    }
}
