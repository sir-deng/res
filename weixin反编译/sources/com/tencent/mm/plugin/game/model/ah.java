package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.c.ay;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class ah extends ad {
    private br njk;

    public ah(a aVar) {
        if (aVar == null) {
            this.njk = new br();
        } else {
            this.njk = (br) aVar;
        }
    }

    public ah(byte[] bArr) {
        this.njk = new br();
        if (bArr != null && bArr.length != 0) {
            try {
                this.njk.aH(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataDownloadGuidance", "Parsing Failed: %s", e.getMessage());
            }
        }
    }

    public final q aRq() {
        return this.njk != null ? this.njk.nnW : null;
    }

    public final ay aRr() {
        return this.njk != null ? this.njk.nnO : null;
    }
}
