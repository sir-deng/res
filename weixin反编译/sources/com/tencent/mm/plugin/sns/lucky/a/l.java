package com.tencent.mm.plugin.sns.lucky.a;

import com.tencent.mm.ad.d;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bcm;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blt;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.bt.a;
import java.math.BigInteger;

public final class l implements a {
    public final void a(d.a aVar) {
        if (aVar == null || aVar.hoa == null || aVar.hoa.vNO == null) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv null msg");
            return;
        }
        String a = n.a(aVar.hoa.vNO);
        x.d("MicroMsg.SimpleExperimentLsn", "recv addMsg " + a);
        String R = R(a, "<TimelineObject", "</TimelineObject>");
        if (bi.oN(R)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  timelineObj tag");
            return;
        }
        String R2 = R(a, "<RecXml", "</RecXml>");
        if (bi.oN(R2)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  RecXml tag");
            return;
        }
        a = R(a, "<ADInfo", "</ADInfo>");
        if (bi.oN(a)) {
            x.i("MicroMsg.SimpleExperimentLsn", "recv addMsg has no  ADInfo tag");
            return;
        }
        bpb mK = e.mK(R);
        bcm bcm = new bcm();
        bcm.wPo = n.oK(a);
        blt blt = new blt();
        bcm.wPn = blt;
        blt.wVG = n.oK(R2);
        blf blf = new blf();
        blf.vWS = new BigInteger(mK.nMq).longValue();
        blf.pgR = mK.pgR;
        blf.vPp = mK.kyG;
        blf.wUN = n.N(R.getBytes());
        blt.wUd = blf;
        com.tencent.mm.plugin.sns.model.a.b(bcm);
    }

    private static String R(String str, String str2, String str3) {
        if (bi.oN(str) || bi.oN(str2) || bi.oN(str3)) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        int indexOf2 = indexOf >= 0 ? str.indexOf(str3) : -1;
        if (indexOf < 0 || indexOf2 <= indexOf) {
            return "";
        }
        return str.substring(indexOf, indexOf2 + str3.length());
    }
}
