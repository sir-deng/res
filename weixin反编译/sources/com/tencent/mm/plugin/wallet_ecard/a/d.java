package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.protocal.c.avf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    private b gLB;
    private e gLE;
    public int lot;
    public String lou;
    public avf tfZ;
    public String tga;
    public String tgb;
    public String tgc;

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z) {
        this(str, str2, str3, str4, str5, i, z, false);
    }

    public d(String str, String str2, String str3, String str4, String str5, int i, boolean z, boolean z2) {
        this.lot = 0;
        this.lou = "";
        a aVar = new a();
        aVar.hnT = new ave();
        aVar.hnU = new avf();
        aVar.hnS = Exif.PARSE_EXIF_ERROR_CORRUPT;
        aVar.uri = "/cgi-bin/mmpay-bin/openecard";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.gLB = aVar.Kf();
        ave ave = (ave) this.gLB.hnQ.hnY;
        ave.vSz = str;
        ave.vSA = str2;
        this.gLB.hoh = true;
        if (z) {
            ave.wJP = str3;
        } else {
            ave.wJQ = str3;
        }
        if (z2) {
            ave.wJR = 1;
        } else {
            ave.wJR = 0;
        }
        ave.sOP = str4;
        ave.pff = str5;
        ave.fDt = i;
        this.tga = str3;
        this.tgb = str4;
        this.tgc = str5;
        x.d("MicroMsg.NetSceneOpenECard", "cardNo: %s", str3);
        x.i("MicroMsg.NetSceneOpenECard", "cardType: %s, reqSerial: %s, openScene: %s, mobileNo: %s, bankType: %s", str, str2, Integer.valueOf(i), str4, str5);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenECard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.tfZ = (avf) ((b) qVar).hnR.hnY;
        x.i("MicroMsg.NetSceneOpenECard", "ret_code: %d, ret_msg: %s", Integer.valueOf(this.tfZ.kRz), this.tfZ.kRA);
        if (!bi.oN(this.tfZ.wJN)) {
            x.d("MicroMsg.NetSceneOpenECard", "rettext: %s", this.tfZ.wJN);
            try {
                JSONObject jSONObject = new JSONObject(this.tfZ.wJN);
                this.lot = jSONObject.optInt("retcode", 0);
                this.lou = jSONObject.optString("retmsg", "");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOpenECard", e, "", new Object[0]);
            }
        }
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return Exif.PARSE_EXIF_ERROR_CORRUPT;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.gLB, this);
    }
}
