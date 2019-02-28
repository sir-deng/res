package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.b;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.protocal.c.alm;
import com.tencent.mm.protocal.c.aln;
import com.tencent.mm.protocal.c.anx;
import com.tencent.mm.protocal.c.atu;
import com.tencent.mm.protocal.c.bnn;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.oj;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil {
    public static oi toMMReportKvReq(i iVar) {
        oi oiVar = new oi();
        oiVar.wdP = iVar.vIP;
        oiVar.wdQ = iVar.vJf;
        oiVar.wdR = iVar.vJd;
        for (int i = 0; i < iVar.vJg.size(); i++) {
            e eVar = (e) iVar.vJg.get(i);
            oh ohVar = new oh();
            ohVar.lTO = eVar.uin;
            ohVar.vRR = eVar.vIN;
            ohVar.wdO = eVar.nettype;
            ohVar.vUY = eVar.vIZ;
            ohVar.vUW = eVar.vIX;
            ohVar.vUX = eVar.vIY;
            ohVar.vUZ = eVar.vJa;
            ohVar.vVa = eVar.vJb;
            ohVar.kzE = eVar.vJc;
            for (int i2 = 0; i2 < eVar.vIO.size(); i2++) {
                d dVar = (d) eVar.vIO.get(i2);
                anx anx = new anx();
                anx.wBF = dVar.vIM;
                anx.wBG = dVar.vIV;
                anx.wBH = dVar.vIW;
                anx.wgo = dVar.quA;
                anx.kyA = dVar.count;
                ohVar.nmz.add(anx);
            }
            oiVar.wdS.add(ohVar);
        }
        return oiVar;
    }

    public static oi toMMReportIdkeyReq(g gVar) {
        oi oiVar = new oi();
        oiVar.wdP = gVar.vIP;
        oiVar.wdQ = gVar.vJf;
        oiVar.wdR = 0;
        for (int i = 0; i < gVar.vJg.size(); i++) {
            b bVar = (b) gVar.vJg.get(i);
            oh ohVar = new oh();
            ohVar.lTO = bVar.uin;
            ohVar.vRR = bVar.vIN;
            ohVar.wdO = bVar.nettype;
            for (int i2 = 0; i2 < bVar.vIO.size(); i2++) {
                a aVar = (a) bVar.vIO.get(i2);
                anx anx = new anx();
                anx.wBF = aVar.vIM;
                anx.wgo = 0;
                anx.wBH = 0;
                anx.kyA = aVar.count;
                anx.wBG = com.tencent.mm.bp.b.be(Integer.toString(aVar.value).getBytes());
                ohVar.nmz.add(anx);
            }
            oiVar.wdS.add(ohVar);
        }
        return oiVar;
    }

    private static o fillStrategyTable(LinkedList<bnn> linkedList) {
        o oVar = new o();
        for (int i = 0; i < linkedList.size(); i++) {
            bnn bnn = (bnn) linkedList.get(i);
            m mVar = new m();
            mVar.vJs = bnn.wXA;
            mVar.vJt = bnn.wXB;
            for (int i2 = 0; i2 < bnn.wXC.size(); i2++) {
                atu atu = (atu) bnn.wXC.get(i2);
                n nVar = new n();
                nVar.vIM = atu.wBF;
                nVar.vJv = atu.wIB;
                nVar.vJw = atu.wIz;
                nVar.vJx = atu.wIA;
                nVar.vJy = atu.wIC;
                nVar.vJz = atu.wID;
                nVar.vJA = atu.wIE;
                mVar.vJu.add(nVar);
            }
            oVar.vJB.add(mVar);
        }
        return oVar;
    }

    public static j toSmcReportKvResp(oj ojVar) {
        j jVar = new j();
        jVar.ret = ojVar.vQL;
        jVar.vIP = ojVar.wdV;
        jVar.vIQ = ojVar.wdW;
        jVar.vJd = ojVar.wdX;
        jVar.vIT = ojVar.web;
        jVar.vJi = ojVar.wec;
        jVar.vIU = ojVar.wed;
        jVar.vIR = fillStrategyTable(ojVar.wdY);
        jVar.vIS = fillStrategyTable(ojVar.wdZ);
        jVar.vJe = fillStrategyTable(ojVar.wea);
        return jVar;
    }

    public static h toSmcReportIdkeyResp(oj ojVar) {
        h hVar = new h();
        hVar.ret = ojVar.vQL;
        hVar.vIP = ojVar.wdV;
        hVar.vIQ = ojVar.wdW;
        hVar.vIT = ojVar.web;
        hVar.vJi = ojVar.wec;
        hVar.vIU = ojVar.wed;
        hVar.vIR = fillStrategyTable(ojVar.wdY);
        hVar.vIS = fillStrategyTable(ojVar.wdZ);
        return hVar;
    }

    public static abh toMMGetStrategyReq() {
        abh abh = new abh();
        ArrayList strategyVersions = SmcLogic.getStrategyVersions();
        if (strategyVersions.size() != 6) {
            return null;
        }
        abh.wdP = ((Integer) strategyVersions.get(0)).intValue();
        abh.wdQ = ((Integer) strategyVersions.get(1)).intValue();
        abh.wdR = ((Integer) strategyVersions.get(2)).intValue();
        abh.wrb = ((Integer) strategyVersions.get(3)).intValue();
        abh.wrc = ((Integer) strategyVersions.get(4)).intValue();
        abh.wrd = ((Integer) strategyVersions.get(5)).intValue();
        return abh;
    }

    public static f toSmcKVStrategyResp(abi abi) {
        f fVar = new f();
        fVar.ret = abi.vQL;
        fVar.vIP = abi.wrb;
        fVar.vIQ = abi.wrc;
        fVar.vJd = abi.wrd;
        fVar.vIT = abi.web;
        fVar.vIU = abi.wed;
        fVar.vIR = fillStrategyTable(abi.wre);
        fVar.vIS = fillStrategyTable(abi.wrf);
        fVar.vJe = fillStrategyTable(abi.wrg);
        return fVar;
    }

    public static c toSmcIdkeyStrategyResp(abi abi) {
        c cVar = new c();
        cVar.ret = abi.vQL;
        cVar.vIP = abi.wdV;
        cVar.vIQ = abi.wdW;
        cVar.vIT = abi.web;
        cVar.vIU = abi.wed;
        cVar.vIR = fillStrategyTable(abi.wdY);
        cVar.vIS = fillStrategyTable(abi.wdZ);
        return cVar;
    }

    public static alm toMMSelfMonitor(k kVar) {
        alm alm = new alm();
        alm.wzm = kVar.vJj;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= kVar.vJk.size()) {
                return alm;
            }
            aln aln = new aln();
            l lVar = (l) kVar.vJk.get(i2);
            aln.wzn = lVar.vJl;
            aln.fpf = lVar.action;
            aln.wzo = lVar.vJm;
            aln.wzp = lVar.vJn;
            aln.wzq = lVar.vJo;
            aln.wzr = lVar.vJp;
            aln.wzs = lVar.vJq;
            aln.wzt = lVar.vJr;
            alm.nmz.add(aln);
            i = i2 + 1;
        }
    }
}
