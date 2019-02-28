package com.tencent.mm.plugin.favorite.a;

import android.util.SparseArray;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class s extends k implements com.tencent.mm.network.k {
    private final b gLB;
    private e gLE = null;
    private List<Integer> mwD;
    private a mwE = null;
    private SparseArray<String> mwF = new SparseArray();
    private int scene;
    private String toUser;

    public interface a {
        void a(SparseArray<String> sparseArray);
    }

    public s(String str, List<Integer> list, a aVar) {
        com.tencent.mm.ad.b.a aVar2 = new com.tencent.mm.ad.b.a();
        aVar2.hnT = new bjo();
        aVar2.hnU = new bjp();
        aVar2.uri = "/cgi-bin/micromsg-bin/sharefav";
        aVar2.hnS = 608;
        aVar2.hnV = 246;
        aVar2.hnW = 1000000246;
        this.gLB = aVar2.Kf();
        this.toUser = str;
        this.scene = 2;
        this.mwD = list;
        this.mwE = aVar;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.mwF.clear();
        if (i2 == 0 && i3 == 0) {
            bjp bjp = (bjp) ((b) qVar).hnR.hnY;
            if (bjp.wvu != this.mwD.size()) {
                x.w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", Integer.valueOf(this.mwD.size()), Integer.valueOf(bjp.wvu));
            }
            int i4 = 0;
            while (i4 < bjp.wTz.size() && i4 < this.mwD.size()) {
                x.d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", this.mwD.get(i4), bjp.wTz.get(i4));
                this.mwF.put(((Integer) this.mwD.get(i4)).intValue(), ((bet) bjp.wTz.get(i4)).wRo);
                i4++;
            }
        }
        this.gLE.a(i2, i3, str, this);
        if (this.mwE != null) {
            this.mwE.a(this.mwF);
        }
    }

    public final int getType() {
        return 608;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        bjo bjo = (bjo) this.gLB.hnQ.hnY;
        bjo.wTy = this.toUser;
        bjo.sfa = this.scene;
        bjo.vRW = new LinkedList(this.mwD);
        bjo.kyA = bjo.vRW.size();
        x.d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", bjo.wTy, Integer.valueOf(bjo.sfa), bjo.vRW, Integer.valueOf(bjo.kyA));
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
