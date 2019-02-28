package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.ap.g;
import com.tencent.mm.bx.h;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.d;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.ae;
import com.tencent.mm.y.b;

public final class c {
    String gRT;
    public h gRU = null;
    g kvA;
    d kvB;
    public f kvC;
    s kvD;
    ae kvE;
    public k kvF;
    public i kvG;
    com.tencent.mm.pluginsdk.model.app.c kvH;
    t kvw;
    ar kvx;
    com.tencent.mm.plugin.messenger.foundation.a.a.c kvy;
    as kvz;
    be kyi;
    com.tencent.mm.bx.g kyj = null;
    Boolean kyk = null;
    public int uin = 0;

    public final t Db() {
        if (this.uin != 0) {
            return this.kvw;
        }
        throw new b();
    }

    public final ar Ff() {
        if (this.uin != 0) {
            return this.kvx;
        }
        throw new b();
    }

    public final com.tencent.mm.plugin.messenger.foundation.a.a.c Fh() {
        if (this.uin != 0) {
            return this.kvy;
        }
        throw new b();
    }

    public final as Fk() {
        if (this.uin != 0) {
            return this.kvz;
        }
        throw new b();
    }

    public final g aqI() {
        if (this.uin != 0) {
            return this.kvA;
        }
        throw new b();
    }

    public final d aqJ() {
        if (this.uin != 0) {
            return this.kvB;
        }
        throw new b();
    }

    public final s Ub() {
        if (this.uin != 0) {
            return this.kvD;
        }
        throw new b();
    }

    public final String Fw() {
        if (this.uin != 0) {
            return this.gRT + "emoji/";
        }
        throw new b();
    }

    public final com.tencent.mm.pluginsdk.model.app.c aqK() {
        if (this.uin != 0) {
            return this.kvH;
        }
        throw new b();
    }

    public final void arx() {
        x.i("MicroMsg.BakOldTempStorage", "closeDB isTempDb:%s datadb:%s memdb:%s %s", this.kyk, this.gRU, this.kyj, bi.chl());
        if (this.kyk == null || this.kyk.booleanValue()) {
            if (this.gRU != null) {
                x.i("MicroMsg.BakOldTempStorage", "closeDB true DB[%s]!!! ", this.gRU);
                this.gRU.EZ();
                this.gRU = null;
            }
            if (this.kyj != null) {
                com.tencent.mm.bx.g gVar = this.kyj;
                com.tencent.mm.bx.g.xJM = bi.chl().toString();
                if (gVar.xJn != null) {
                    gVar.xJn.close();
                    gVar.xJn = null;
                }
                this.kyj = null;
            }
            this.kyk = null;
            return;
        }
        this.kyk = null;
    }
}
