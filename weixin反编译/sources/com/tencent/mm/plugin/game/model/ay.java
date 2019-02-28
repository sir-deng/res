package com.tencent.mm.plugin.game.model;

import android.os.Build.VERSION;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.c.be;
import com.tencent.mm.plugin.game.c.bf;
import com.tencent.mm.plugin.game.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ay extends k implements com.tencent.mm.network.k {
    private e gLE;
    private final b lSH;

    public ay() {
        a aVar = new a();
        aVar.hnT = new be();
        aVar.hnU = new bf();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        this.lSH = aVar.Kf();
        be beVar = (be) this.lSH.hnQ.hnY;
        beVar.nnm = w.cfV();
        String cP = g.cP(ad.getContext());
        if (bi.oN(cP)) {
            cP = bi.chi();
        }
        beVar.hxn = cP;
        beVar.nnn = f.fei;
        beVar.nno = new d();
        beVar.nno.nkT = VERSION.SDK_INT;
        beVar.nno.mGy = com.b.a.a.b.t(ad.getContext());
        x.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", beVar.nnm, beVar.hxn, Integer.valueOf(beVar.nnn), Integer.valueOf(beVar.nno.nkT), Integer.valueOf(beVar.nno.mGy));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            bf bfVar = (bf) ((b) qVar).hnR.hnY;
            if (bfVar == null) {
                this.gLE.a(i2, i3, str, this);
                return;
            }
            SubCoreGameCenter.aRO().a("pb_game_global_config", bfVar);
            i.aQI().XQ();
            this.gLE.a(i2, i3, str, this);
            return;
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1311;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.lSH, this);
    }
}
