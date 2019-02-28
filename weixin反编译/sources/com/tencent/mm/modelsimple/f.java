package com.tencent.mm.modelsimple;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.i;
import com.tencent.mm.ad.k;
import com.tencent.mm.j.g;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class f extends k implements com.tencent.mm.network.k {
    private e gLE;
    private q hoZ = new a();

    public static class a extends i {
        private final com.tencent.mm.protocal.l.a hOs = new com.tencent.mm.protocal.l.a();
        private final b hOt = new b();

        protected final d Hu() {
            return this.hOs;
        }

        public final com.tencent.mm.protocal.k.e Hv() {
            return this.hOt;
        }

        public final int getType() {
            return 0;
        }

        public final String getUri() {
            return null;
        }
    }

    public static void bU(boolean z) {
        x.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", Boolean.valueOf(z), Boolean.valueOf(as.Hp()), bi.chl());
        if (!as.Hp()) {
            return;
        }
        if (as.CN() == null || as.CN().hoF == null || as.CN().hoF.KD() == null) {
            x.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
            return;
        }
        as.CN().hoF.KD().bF(z);
        if (z) {
            as.CN().a(new f(true), 0);
            return;
        }
        as.CN().a(new f(RI()), 0);
    }

    private static boolean RI() {
        int i;
        if (r.igt != -1) {
            i = r.igt;
        } else {
            try {
                i = bi.getInt(g.Af().getValue("MuteRoomDisable"), 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneBgFg", e, "", new Object[0]);
                i = 0;
            }
        }
        x.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", Integer.valueOf(1), Integer.valueOf(r.igt), Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground));
        if ((i & 1) != 0) {
            return true;
        }
        return r3;
    }

    private f(boolean z) {
        com.tencent.mm.protocal.l.a aVar = (com.tencent.mm.protocal.l.a) this.hoZ.Kh();
        aVar.netType = com.tencent.mm.protocal.a.getNetType(ad.getContext());
        aVar.vIe = z ? 1 : 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hoZ, this);
    }

    public final int getType() {
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBgFg", " ret[%d]", Integer.valueOf(((b) qVar.Hv()).vIf.lot));
        this.gLE.a(i2, i3, str, this);
    }
}
