package com.tencent.mm.protocal.c;

import e.a.a.b;
import e.a.a.c.a;
import java.util.LinkedList;

public final class bvp extends bea {
    public String npV;
    public int wMS;
    public String wNo;
    public int wil;
    public long wim;
    public long xcm;
    public bwq xdg;
    public int xdh;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.xdg == null) {
                throw new b("Not all required fields were included: ReportData");
            }
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.wNo != null) {
                aVar.g(2, this.wNo);
            }
            aVar.fX(3, this.wil);
            aVar.S(4, this.wim);
            if (this.npV != null) {
                aVar.g(6, this.npV);
            }
            if (this.xdg != null) {
                aVar.fZ(8, this.xdg.bkL());
                this.xdg.a(aVar);
            }
            aVar.fX(9, this.xdh);
            aVar.S(10, this.xcm);
            aVar.fX(11, this.wMS);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.wNo != null) {
                fW += e.a.a.b.b.a.h(2, this.wNo);
            }
            fW = (fW + e.a.a.a.fU(3, this.wil)) + e.a.a.a.R(4, this.wim);
            if (this.npV != null) {
                fW += e.a.a.b.b.a.h(6, this.npV);
            }
            if (this.xdg != null) {
                fW += e.a.a.a.fW(8, this.xdg.bkL());
            }
            return ((fW + e.a.a.a.fU(9, this.xdh)) + e.a.a.a.R(10, this.xcm)) + e.a.a.a.fU(11, this.wMS);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.xdg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReportData");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            bvp bvp = (bvp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList JD;
            int size;
            byte[] bArr;
            com.tencent.mm.bp.a fhVar;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new fh();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvp.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    bvp.wNo = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bvp.wil = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    bvp.wim = aVar3.AEQ.rA();
                    return 0;
                case 6:
                    bvp.npV = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    JD = aVar3.JD(intValue);
                    size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        fhVar = new bwq();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        bvp.xdg = fhVar;
                    }
                    return 0;
                case 9:
                    bvp.xdh = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    bvp.xcm = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    bvp.wMS = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
