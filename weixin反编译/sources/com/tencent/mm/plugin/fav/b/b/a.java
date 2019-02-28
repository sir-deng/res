package com.tencent.mm.plugin.fav.b.b;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.nf;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vq;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private e gLE = null;
    private b hGV;

    public a(List<vf> list) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new nf();
        aVar.hnU = new ng();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.hnS = 405;
        aVar.hnV = 196;
        aVar.hnW = 1000000196;
        this.hGV = aVar.Kf();
        nf nfVar = (nf) this.hGV.hnQ.hnY;
        nfVar.wcM = new LinkedList();
        nfVar.wcM.addAll(list);
        nfVar.sfa = 1;
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", Integer.valueOf(list.size()));
    }

    public a(vq vqVar) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new nf();
        aVar.hnU = new ng();
        aVar.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        aVar.hnS = 405;
        aVar.hnV = 196;
        aVar.hnW = 1000000196;
        this.hGV = aVar.Kf();
        nf nfVar = (nf) this.hGV.hnQ.hnY;
        nfVar.wcN = vqVar;
        nfVar.sfa = 2;
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", Integer.valueOf(vqVar.vNB));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hGV, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        ng ngVar = (ng) ((b) qVar).hnR.hnY;
        if (i2 == 0 && i3 == 0) {
            Iterator it = ngVar.wcO.iterator();
            while (it.hasNext()) {
                nh nhVar = (nh) it.next();
                x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", Integer.valueOf(nhVar.vNB), Integer.valueOf(nhVar.vQL));
            }
            this.gLE.a(i2, i3, str, this);
            return;
        }
        x.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", Integer.valueOf(i3), Integer.valueOf(i2));
        this.gLE.a(i2, i3, str, this);
    }

    protected final int a(q qVar) {
        return b.hoz;
    }

    protected final int Bo() {
        return 10;
    }

    public final int getType() {
        return 405;
    }
}
