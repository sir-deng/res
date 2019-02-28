package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ad.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bmt;
import com.tencent.mm.protocal.c.bmu;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

public final class c extends d implements e, k {
    public b gLB;
    private com.tencent.mm.ad.e gLE;
    private com.tencent.d.b.e.b<e.b> mFx = null;
    private String mFy = null;

    public final /* synthetic */ void br(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hnT = new bmt();
        aVar2.hnU = new bmu();
        aVar2.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar2.hnS = 1665;
        aVar2.hnV = 0;
        aVar2.hnW = 0;
        this.gLB = aVar2.Kf();
        bmt bmt = (bmt) this.gLB.hnQ.hnY;
        bmt.wWp = this.mFy;
        bmt.wWq = aVar.Amc;
        bmt.wWr = aVar.Amd;
        bmt.fzi = TenpayUtil.signWith3Des("passwd=" + bmt.wWp);
        try {
            JSONObject jSONObject = new JSONObject(aVar.Amc);
            com.tencent.mm.plugin.soter.c.b.ex(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e, "save device info exception", new Object[0]);
        }
    }

    public c(String str) {
        this.mFy = str;
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ad.e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.gLE != null) {
            this.gLE.a(i, i2, str, this);
        }
        if (this.mFx == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.mFx.cz(new e.b(true));
        } else {
            this.mFx.cz(new e.b(false));
        }
    }

    public final void aLm() {
        x.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.gLE != null) {
            this.gLE.a(4, -1, "", this);
        }
        if (this.mFx != null) {
            x.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.mFx.cz(new e.b(false));
        }
    }

    public final void cC(int i, int i2) {
        x.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i2));
        if (this.gLE != null) {
            this.gLE.a(4, -1, "", this);
        }
    }

    public final void execute() {
        g.CN().a((com.tencent.mm.ad.k) this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.mFx = bVar;
    }
}
