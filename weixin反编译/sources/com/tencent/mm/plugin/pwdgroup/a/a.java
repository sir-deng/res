package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.mm.ac.h;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uu;
import com.tencent.mm.protocal.c.uv;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public int prg;

    public a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new uu();
        aVar.hnU = new uv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        this.gLB = aVar.Kf();
        uu uuVar = (uu) this.gLB.hnQ.hnY;
        this.prg = i;
        uuVar.vKI = i;
        uuVar.wju = str;
        uuVar.wgO = str2;
        uuVar.vXx = f2;
        uuVar.vXy = f;
        uuVar.wjv = i2;
        if (!bi.oN(str3)) {
            uuVar.wjw = str3;
        }
        if (!bi.oN(str4)) {
            uuVar.wjx = str4;
        }
        uuVar.wjy = i3;
        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3));
        o.a(TXLiveConstants.PLAY_EVT_PLAY_LOADING, f2, f, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.prg == 0) {
            uv bku = bku();
            if (bku != null) {
                LinkedList linkedList = bku.vNu;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    List arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        uw uwVar = (uw) linkedList.get(i4);
                        h hVar = new h();
                        if (bi.oN(uwVar.kyG)) {
                            hVar.username = uwVar.wjz;
                        } else {
                            hVar.username = uwVar.kyG;
                        }
                        x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", uwVar.kyG, uwVar.whs);
                        hVar.hnh = uwVar.whs;
                        hVar.bC(true);
                        arrayList.add(hVar);
                    }
                    n.JW().H(arrayList);
                    x.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
        this.gLE.a(i2, i3, str, this);
    }

    public final int getType() {
        return 653;
    }

    public final uv bku() {
        return (uv) this.gLB.hnR.hnY;
    }
}
