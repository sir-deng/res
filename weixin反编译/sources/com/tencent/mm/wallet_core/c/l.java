package com.tencent.mm.wallet_core.c;

import android.os.Bundle;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;

public abstract class l extends k implements com.tencent.mm.network.k {
    public String gQd = "";
    public int itU = 0;
    private int lPI = 0;
    public long mmh = 0;
    private long tgW;
    public Bundle vf;

    public abstract void e(int i, int i2, String str, q qVar);

    public int aXN() {
        return -1;
    }

    public void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis() - this.tgW;
        String str2 = "";
        String str3 = "";
        this.lPI = aXN();
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.vf != null) {
            str2 = this.vf.getString("key_TransId");
            str3 = this.vf.getString("key_reqKey");
            if (this.mmh == 0) {
                this.mmh = this.vf.getLong("key_SessionId", 0);
            }
            if (this.itU == 0) {
                this.itU = this.vf.getInt("key_scene");
            }
        }
        g.pWK.h(11170, Integer.valueOf(getType()), Integer.valueOf(this.lPI), Long.valueOf(currentTimeMillis), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(ao.getNetType(ad.getContext())), this.gQd, str2, str3, Long.valueOf(this.mmh), Long.valueOf(currentTimeMillis2));
        p.a(getType(), aXN(), i2, i3, currentTimeMillis, this.itU, this.gQd);
        e(i2, i3, str, qVar);
    }

    public final int a(e eVar, q qVar, com.tencent.mm.network.k kVar) {
        this.tgW = System.currentTimeMillis();
        return super.a(eVar, qVar, kVar);
    }
}
