package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class au extends a {
    public int kzz;
    public String nlE;
    public int sfa;
    public da vMA;
    public cz vMB;
    public cz vMC;
    public String vMu;
    public String vMv;
    public String vMw;
    public as vMx;
    public String vMy;
    public cs vMz;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.kzz);
            if (this.nlE != null) {
                aVar.g(2, this.nlE);
            }
            aVar.fX(3, this.sfa);
            if (this.vMu != null) {
                aVar.g(4, this.vMu);
            }
            if (this.vMv != null) {
                aVar.g(5, this.vMv);
            }
            if (this.vMw != null) {
                aVar.g(6, this.vMw);
            }
            if (this.vMx != null) {
                aVar.fZ(7, this.vMx.bkL());
                this.vMx.a(aVar);
            }
            if (this.vMy != null) {
                aVar.g(8, this.vMy);
            }
            if (this.vMz != null) {
                aVar.fZ(9, this.vMz.bkL());
                this.vMz.a(aVar);
            }
            if (this.vMA != null) {
                aVar.fZ(10, this.vMA.bkL());
                this.vMA.a(aVar);
            }
            if (this.vMB != null) {
                aVar.fZ(11, this.vMB.bkL());
                this.vMB.a(aVar);
            }
            if (this.vMC != null) {
                aVar.fZ(12, this.vMC.bkL());
                this.vMC.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            fU = e.a.a.a.fU(1, this.kzz) + 0;
            if (this.nlE != null) {
                fU += e.a.a.b.b.a.h(2, this.nlE);
            }
            fU += e.a.a.a.fU(3, this.sfa);
            if (this.vMu != null) {
                fU += e.a.a.b.b.a.h(4, this.vMu);
            }
            if (this.vMv != null) {
                fU += e.a.a.b.b.a.h(5, this.vMv);
            }
            if (this.vMw != null) {
                fU += e.a.a.b.b.a.h(6, this.vMw);
            }
            if (this.vMx != null) {
                fU += e.a.a.a.fW(7, this.vMx.bkL());
            }
            if (this.vMy != null) {
                fU += e.a.a.b.b.a.h(8, this.vMy);
            }
            if (this.vMz != null) {
                fU += e.a.a.a.fW(9, this.vMz.bkL());
            }
            if (this.vMA != null) {
                fU += e.a.a.a.fW(10, this.vMA.bkL());
            }
            if (this.vMB != null) {
                fU += e.a.a.a.fW(11, this.vMB.bkL());
            }
            if (this.vMC != null) {
                return fU + e.a.a.a.fW(12, this.vMC.bkL());
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            au auVar = (au) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            a asVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    auVar.kzz = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    auVar.nlE = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    auVar.sfa = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    auVar.vMu = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    auVar.vMv = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    auVar.vMw = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asVar = new as();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, a.a(aVar4))) {
                        }
                        auVar.vMx = asVar;
                    }
                    return 0;
                case 8:
                    auVar.vMy = aVar3.AEQ.readString();
                    return 0;
                case 9:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asVar = new cs();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, a.a(aVar4))) {
                        }
                        auVar.vMz = asVar;
                    }
                    return 0;
                case 10:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asVar = new da();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, a.a(aVar4))) {
                        }
                        auVar.vMA = asVar;
                    }
                    return 0;
                case 11:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asVar = new cz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, a.a(aVar4))) {
                        }
                        auVar.vMB = asVar;
                    }
                    return 0;
                case 12:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        asVar = new cz();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = asVar.a(aVar4, asVar, a.a(aVar4))) {
                        }
                        auVar.vMC = asVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
