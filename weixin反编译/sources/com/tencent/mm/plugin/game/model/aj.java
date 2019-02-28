package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.ai;
import com.tencent.mm.plugin.game.c.ak;
import com.tencent.mm.plugin.game.c.al;
import com.tencent.mm.plugin.game.c.ar;
import com.tencent.mm.plugin.game.c.bn;
import com.tencent.mm.plugin.game.c.ch;
import com.tencent.mm.plugin.game.c.ec;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public final class aj extends ad {
    private bn nju;
    public ch njv;
    public a njw;
    public ak njx;
    public ec njy;
    public ar njz;

    public static class a {
        public String desc;
        public ai njA;
        public com.tencent.mm.plugin.game.c.aj njB;
        public al njC;
        public d njs;
    }

    public aj(bn bnVar) {
        if (bnVar == null) {
            this.nju = new bn();
            return;
        }
        this.nju = bnVar;
        fG(true);
    }

    public aj(byte[] bArr) {
        this.nju = new bn();
        if (bArr != null && bArr.length != 0) {
            try {
                this.nju.aH(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataIndex4", "Parsing Failed: %s", e.getMessage());
            }
            fG(false);
        }
    }

    private void fG(boolean z) {
        if (this.nju != null) {
            this.njv = this.nju.noi;
            if (!(this.nju.nof == null || this.nju.nof.nkO == null)) {
                this.njw = new a();
                this.njw.njs = ad.a(this.nju.nof.nkO);
                if (this.njw.njs != null) {
                    this.njw.njs.ngz = this.nju.nof.nkL;
                    this.njw.njs.scene = 10;
                    this.njw.njs.fGe = 1002;
                    this.njw.njs.position = 1;
                }
                this.njw.njA = this.nju.nof.nmy;
                this.njw.njB = this.nju.nof.nmx;
                this.njw.desc = this.nju.nof.nkL;
                this.njw.njC = this.nju.noh;
            }
            this.njx = this.nju.nog;
            this.njy = this.nju.nnR;
            this.njz = this.nju.noj;
        }
        if (this.nju != null && z) {
            if (!(this.nju.nof == null || this.nju.nof.nkO == null)) {
                d.a(ad.a(this.nju.nof.nkO));
            }
            SubCoreGameCenter.aRQ().init(ad.getContext());
        }
    }
}
