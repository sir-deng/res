package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class arh extends a {
    public int afu;
    public String fGh;
    public String frM;
    public int fuw;
    public int hmE;
    public String nkL;
    public String token;
    public String videoPath;
    public int wER;
    public arb wFI;
    public int wFJ;
    public LinkedList<arb> wFK = new LinkedList();
    public int wFL;
    public String wFM;
    public String wFN;
    public String wFO;
    public aqp wFP;
    public int wFQ;
    public String wFk;
    public int wFl;
    public int wFm;
    public int wFu;
    public String wFv;

    protected final int a(int i, Object... objArr) {
        int fU;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.wFl);
            aVar.fX(2, this.wFm);
            aVar.fX(3, this.wER);
            if (this.wFI != null) {
                aVar.fZ(4, this.wFI.bkL());
                this.wFI.a(aVar);
            }
            aVar.fX(5, this.wFJ);
            aVar.d(6, 8, this.wFK);
            aVar.fX(7, this.hmE);
            aVar.fX(8, this.wFL);
            if (this.nkL != null) {
                aVar.g(9, this.nkL);
            }
            if (this.wFM != null) {
                aVar.g(10, this.wFM);
            }
            if (this.token != null) {
                aVar.g(11, this.token);
            }
            if (this.wFv != null) {
                aVar.g(12, this.wFv);
            }
            aVar.fX(13, this.wFu);
            if (this.videoPath != null) {
                aVar.g(14, this.videoPath);
            }
            if (this.wFN != null) {
                aVar.g(15, this.wFN);
            }
            if (this.wFO != null) {
                aVar.g(16, this.wFO);
            }
            if (this.frM != null) {
                aVar.g(17, this.frM);
            }
            if (this.fGh != null) {
                aVar.g(18, this.fGh);
            }
            aVar.fX(19, this.afu);
            aVar.fX(20, this.fuw);
            if (this.wFk != null) {
                aVar.g(21, this.wFk);
            }
            if (this.wFP != null) {
                aVar.fZ(22, this.wFP.bkL());
                this.wFP.a(aVar);
            }
            aVar.fX(23, this.wFQ);
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.wFl) + 0) + e.a.a.a.fU(2, this.wFm)) + e.a.a.a.fU(3, this.wER);
            if (this.wFI != null) {
                fU += e.a.a.a.fW(4, this.wFI.bkL());
            }
            fU = (((fU + e.a.a.a.fU(5, this.wFJ)) + e.a.a.a.c(6, 8, this.wFK)) + e.a.a.a.fU(7, this.hmE)) + e.a.a.a.fU(8, this.wFL);
            if (this.nkL != null) {
                fU += e.a.a.b.b.a.h(9, this.nkL);
            }
            if (this.wFM != null) {
                fU += e.a.a.b.b.a.h(10, this.wFM);
            }
            if (this.token != null) {
                fU += e.a.a.b.b.a.h(11, this.token);
            }
            if (this.wFv != null) {
                fU += e.a.a.b.b.a.h(12, this.wFv);
            }
            fU += e.a.a.a.fU(13, this.wFu);
            if (this.videoPath != null) {
                fU += e.a.a.b.b.a.h(14, this.videoPath);
            }
            if (this.wFN != null) {
                fU += e.a.a.b.b.a.h(15, this.wFN);
            }
            if (this.wFO != null) {
                fU += e.a.a.b.b.a.h(16, this.wFO);
            }
            if (this.frM != null) {
                fU += e.a.a.b.b.a.h(17, this.frM);
            }
            if (this.fGh != null) {
                fU += e.a.a.b.b.a.h(18, this.fGh);
            }
            fU = (fU + e.a.a.a.fU(19, this.afu)) + e.a.a.a.fU(20, this.fuw);
            if (this.wFk != null) {
                fU += e.a.a.b.b.a.h(21, this.wFk);
            }
            if (this.wFP != null) {
                fU += e.a.a.a.fW(22, this.wFP.bkL());
            }
            return fU + e.a.a.a.fU(23, this.wFQ);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.wFK.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            arh arh = (arh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            a arb;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    arh.wFl = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    arh.wFm = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    arh.wER = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        arb = new arb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arb.a(aVar4, arb, a.a(aVar4))) {
                        }
                        arh.wFI = arb;
                    }
                    return 0;
                case 5:
                    arh.wFJ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        arb = new arb();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arb.a(aVar4, arb, a.a(aVar4))) {
                        }
                        arh.wFK.add(arb);
                    }
                    return 0;
                case 7:
                    arh.hmE = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    arh.wFL = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    arh.nkL = aVar3.AEQ.readString();
                    return 0;
                case 10:
                    arh.wFM = aVar3.AEQ.readString();
                    return 0;
                case 11:
                    arh.token = aVar3.AEQ.readString();
                    return 0;
                case 12:
                    arh.wFv = aVar3.AEQ.readString();
                    return 0;
                case 13:
                    arh.wFu = aVar3.AEQ.rz();
                    return 0;
                case 14:
                    arh.videoPath = aVar3.AEQ.readString();
                    return 0;
                case 15:
                    arh.wFN = aVar3.AEQ.readString();
                    return 0;
                case 16:
                    arh.wFO = aVar3.AEQ.readString();
                    return 0;
                case 17:
                    arh.frM = aVar3.AEQ.readString();
                    return 0;
                case 18:
                    arh.fGh = aVar3.AEQ.readString();
                    return 0;
                case 19:
                    arh.afu = aVar3.AEQ.rz();
                    return 0;
                case 20:
                    arh.fuw = aVar3.AEQ.rz();
                    return 0;
                case 21:
                    arh.wFk = aVar3.AEQ.readString();
                    return 0;
                case 22:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        arb = new aqp();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = arb.a(aVar4, arb, a.a(aVar4))) {
                        }
                        arh.wFP = arb;
                    }
                    return 0;
                case 23:
                    arh.wFQ = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
