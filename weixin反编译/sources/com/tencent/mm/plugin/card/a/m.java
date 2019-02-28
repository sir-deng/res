package com.tencent.mm.plugin.card.a;

import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.card.model.u;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class m implements e {
    public float gAh = -85.0f;
    public float gAi = -1000.0f;
    private long gMW = 0;

    public final void u(float f, float f2) {
        this.gAh = f;
        this.gAi = f2;
        this.gMW = System.currentTimeMillis() / 1000;
    }

    public final void o(String str, String str2, int i) {
        if ((System.currentTimeMillis() / 1000) - this.gMW > 1800) {
            this.gAh = -85.0f;
            this.gAi = -1000.0f;
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid time is out");
        }
        if (this.gAh == -85.0f) {
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLatitude ==  LocationGeo.INVALID_LAT");
        }
        if (this.gAi == -1000.0f) {
            x.i("MicroMsg.CardReportLBSManager", "checkDataValid lbsLongitude ==  LocationGeo.INVALID_LNG");
        }
        as.CN().a(1253, (e) this);
        as.CN().a(new u(this.gAh, this.gAi, str, str2, i), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.CardReportLBSManager", "rplbs onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        as.CN().b(1253, (e) this);
    }
}
