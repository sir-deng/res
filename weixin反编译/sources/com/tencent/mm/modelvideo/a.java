package com.tencent.mm.modelvideo;

import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void a(r rVar, int i) {
        if (rVar == null) {
            x.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            return;
        }
        int i2;
        long Wz = bi.Wz();
        o.Ub();
        String nx = s.nx(rVar.getFileName());
        long j = 0;
        long j2 = 0;
        if (c.oQ(nx)) {
            i2 = 1;
            b bVar = new b();
            j = bVar.oP(nx);
            j2 = bVar.iha != null ? bVar.iha.igW : 0;
        } else {
            x.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        long j3 = rVar.fGj;
        nx = r.nu(rVar.Un());
        long j4 = (long) rVar.hmZ;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j3).append(";").append(nx).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j).append(";");
        stringBuilder.append(j2).append(";").append(i);
        x.d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + bi.bB(Wz));
        g.pWK.h(11098, Integer.valueOf(8000), r0);
    }
}
