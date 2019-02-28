package com.tencent.mm.ao;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.c.gy;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    public static int hAC = 0;
    public static int hAD = 1;
    public static int hAE = -85;
    private final b gLB;
    private e gLE;
    private int hAF = -1;
    private String hAG;
    private int hAH = 0;

    /* renamed from: com.tencent.mm.ao.a$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] hAI = new int[a.Pf().length];

        static {
            try {
                hAI[a.hAJ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                hAI[a.hAK - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum a {
        ;

        public static int[] Pf() {
            return (int[]) hAL.clone();
        }

        static {
            hAJ = 1;
            hAK = 2;
            hAL = new int[]{hAJ, hAK};
        }
    }

    public a(int i, String str, int i2) {
        switch (AnonymousClass1.hAI[i - 1]) {
            case 1:
                this.hAF = 1;
                break;
            case 2:
                this.hAF = 2;
                break;
        }
        this.hAG = str;
        this.hAH = i2;
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnT = new gx();
        aVar.hnU = new gy();
        aVar.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar.hnS = 487;
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.gLE = eVar2;
        gx gxVar = (gx) this.gLB.hnQ.hnY;
        gxVar.vQC = this.hAF;
        gxVar.vSF = this.hAG;
        gxVar.vSG = this.hAH;
        return a(eVar, this.gLB, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gLE.a(i2, i3, str, this);
        } else {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 487;
    }
}
