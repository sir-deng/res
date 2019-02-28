package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.c.b;
import com.tencent.mm.protocal.k.d;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ad.e gLE = null;
    private q hoZ;
    private String nEa = null;
    private int uin = 0;

    public static class a implements q {
        private final com.tencent.mm.plugin.gcm.modelgcm.c.a nEb = new com.tencent.mm.plugin.gcm.modelgcm.c.a();
        private final b nEc = new b();
        int uin;

        public final /* bridge */ /* synthetic */ com.tencent.mm.protocal.k.e Hv() {
            return this.nEc;
        }

        public final int getType() {
            return 623;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/androidgcmreg";
        }

        public final d Kh() {
            this.nEb.vHU = com.tencent.mm.compatible.e.q.yM();
            this.nEb.vHT = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.nEb.vHS = com.tencent.mm.protocal.d.vHl;
            this.nEb.eE(this.uin);
            return this.nEb;
        }

        public final boolean Ki() {
            return false;
        }

        public final int Ke() {
            return 0;
        }
    }

    public e(String str, int i) {
        this.nEa = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        this.hoZ = new a();
        ((a) this.hoZ).uin = this.uin;
        ((com.tencent.mm.plugin.gcm.modelgcm.c.a) this.hoZ.Kh()).nDW.vKH = this.nEa;
        return a(eVar, this.hoZ, this);
    }

    public final int getType() {
        return 623;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gLE.a(i2, i3, str, this);
    }
}
