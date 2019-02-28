package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.bh;
import com.tencent.mm.plugin.game.c.cc;
import com.tencent.mm.plugin.game.c.cf;
import com.tencent.mm.plugin.game.c.ci;
import com.tencent.mm.plugin.game.c.cz;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class af extends ad {
    public bh njb;
    private boolean njc;
    public d njd;
    public ag nje;

    public static class a {
        public String desc;
        public String title;
        public String url;
    }

    public static class b {
        public String desc;
        public String fED;
        public String title;
        public String url;
    }

    public af(com.tencent.mm.bp.a aVar) {
        if (aVar == null) {
            this.njb = new bh();
            return;
        }
        this.njb = (bh) aVar;
        this.njc = false;
        Xc();
    }

    public af(byte[] bArr) {
        this.njb = new bh();
        if (bArr != null && bArr.length != 0) {
            try {
                this.njb.aH(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataDetail", "Parsing Failed: %s", e.getMessage());
            }
            this.njc = true;
            Xc();
        }
    }

    private void Xc() {
        d a = ad.a(this.njb.nkO);
        if (a != null) {
            a.scene = 12;
            a.fGe = 1201;
        }
        this.njd = a;
        if (this.njc) {
            this.nje = new ag(this.njd.field_appId);
        } else {
            this.nje = new ag(this.njd.field_appId, this.njb.nnE != null ? this.njb.nnE.npz : null);
        }
        if (!this.njc) {
            d.a(this.njd);
            SubCoreGameCenter.aRO().a(this.njd.field_appId, this.njb);
        }
    }

    public final String aRg() {
        if (this.njb.nnI != null) {
            return this.njb.nnI.title;
        }
        if (this.njb.nnD != null) {
            return this.njb.nnD.fpg;
        }
        return null;
    }

    public final LinkedList<b> aRh() {
        LinkedList<b> linkedList;
        Iterator it;
        b bVar;
        if (this.njb.nnI != null && this.njb.nnI.kTc != null) {
            linkedList = new LinkedList();
            it = this.njb.nnI.kTc.iterator();
            while (it.hasNext()) {
                ci ciVar = (ci) it.next();
                bVar = new b();
                bVar.fED = ciVar.fED;
                bVar.desc = ciVar.desc;
                linkedList.add(bVar);
            }
            return linkedList;
        } else if (this.njb.nnD == null || this.njb.nnD.nox == null) {
            return null;
        } else {
            linkedList = new LinkedList();
            it = this.njb.nnD.nox.iterator();
            while (it.hasNext()) {
                cc ccVar = (cc) it.next();
                bVar = new b();
                bVar.fED = ccVar.noA;
                bVar.title = ccVar.fpg;
                bVar.desc = ccVar.nlZ;
                bVar.url = ccVar.nkQ;
                linkedList.add(bVar);
            }
            return linkedList;
        }
    }

    public final int aRi() {
        if (this.njb.nnI != null) {
            return 2;
        }
        return 1;
    }

    public final LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> aRj() {
        LinkedList<com.tencent.mm.plugin.game.ui.GameMediaList.a> linkedList = new LinkedList();
        if (this.njb.nnB == null || this.njb.nnB.noZ == null) {
            return linkedList;
        }
        Iterator it = this.njb.nnB.noZ.iterator();
        while (it.hasNext()) {
            cz czVar = (cz) it.next();
            com.tencent.mm.plugin.game.ui.GameMediaList.a aVar = new com.tencent.mm.plugin.game.ui.GameMediaList.a();
            aVar.type = czVar.nph;
            aVar.nyC = czVar.npi;
            aVar.url = czVar.npj;
            linkedList.add(aVar);
        }
        return linkedList;
    }

    public final String aRk() {
        if (this.njb.nnB == null || this.njb.nnB.fpg == null) {
            return null;
        }
        return this.njb.nnB.fpg;
    }

    public final String aRl() {
        if (this.njb.nnB == null || this.njb.nnB.nlZ == null) {
            return null;
        }
        return this.njb.nnB.nlZ;
    }

    public final String aRm() {
        if (this.njb.nnC == null) {
            return null;
        }
        return this.njb.nnC.fpg;
    }

    public final LinkedList<cf> aRn() {
        if (this.njb.nnC == null) {
            return null;
        }
        return this.njb.nnC.noD;
    }
}
