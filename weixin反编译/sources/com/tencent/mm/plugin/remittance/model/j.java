package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ad.b;
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.protocal.c.jb;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    private e gLE;
    private b hPx;
    public jc pQg;

    public j(cg cgVar, String str) {
        a aVar = new a();
        aVar.hnT = new jb();
        aVar.hnU = new jc();
        aVar.uri = "/cgi-bin/mmpay-bin/busif2fsucpage";
        aVar.hnV = 0;
        aVar.hnW = 0;
        this.hPx = aVar.Kf();
        jb jbVar = (jb) this.hPx.hnQ.hnY;
        jbVar.vVL = cgVar;
        jbVar.vVV = str;
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "NetSceneBusiF2fSucpage suc_page_extend %s req %s", str, a.a(cgVar));
    }

    public final int getType() {
        return 2504;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gLE = eVar2;
        return a(eVar, this.hPx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.pQg = (jc) ((b) qVar).hnR.hnY;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.pQg.sUS != null) {
            stringBuffer.append("response: " + this.pQg.vWh);
            stringBuffer.append("is_show_btn: " + this.pQg.sUS.wiy);
            if (this.pQg.sUS.wix != null) {
                stringBuffer.append("single_exposure_info_list " + this.pQg.sUS.wix.size());
            }
        }
        x.i("MicroMsg.NetSceneBusiF2fSucpage", "ret_code: %s, ret_msg: %s %s", Integer.valueOf(this.pQg.kRz), this.pQg.kRA, stringBuffer.toString());
        if (this.gLE != null) {
            this.gLE.a(i2, i3, str, this);
        }
    }
}
