package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class beb extends bea {
    public int pNg;
    public String pNt;
    public String pNu;
    public String pff;
    public String vPB;
    public int wQF;
    public String wQG;
    public int wQH;
    public int wQI;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.wQE != null) {
                aVar.fZ(1, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            if (this.pNt != null) {
                aVar.g(2, this.pNt);
            }
            if (this.pNu != null) {
                aVar.g(3, this.pNu);
            }
            if (this.pff != null) {
                aVar.g(4, this.pff);
            }
            aVar.fX(5, this.pNg);
            aVar.fX(6, this.wQF);
            if (this.wQG != null) {
                aVar.g(7, this.wQG);
            }
            aVar.fX(8, this.wQH);
            aVar.fX(9, this.wQI);
            if (this.vPB == null) {
                return 0;
            }
            aVar.g(10, this.vPB);
            return 0;
        } else if (i == 1) {
            if (this.wQE != null) {
                fW = e.a.a.a.fW(1, this.wQE.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.pNt != null) {
                fW += e.a.a.b.b.a.h(2, this.pNt);
            }
            if (this.pNu != null) {
                fW += e.a.a.b.b.a.h(3, this.pNu);
            }
            if (this.pff != null) {
                fW += e.a.a.b.b.a.h(4, this.pff);
            }
            fW = (fW + e.a.a.a.fU(5, this.pNg)) + e.a.a.a.fU(6, this.wQF);
            if (this.wQG != null) {
                fW += e.a.a.b.b.a.h(7, this.wQG);
            }
            fW = (fW + e.a.a.a.fU(8, this.wQH)) + e.a.a.a.fU(9, this.wQI);
            if (this.vPB != null) {
                fW += e.a.a.b.b.a.h(10, this.vPB);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = com.tencent.mm.bp.a.a(aVar2); fW > 0; fW = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            beb beb = (beb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        beb.wQE = fhVar;
                    }
                    return 0;
                case 2:
                    beb.pNt = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    beb.pNu = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    beb.pff = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    beb.pNg = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    beb.wQF = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    beb.wQG = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    beb.wQH = aVar3.AEQ.rz();
                    return 0;
                case 9:
                    beb.wQI = aVar3.AEQ.rz();
                    return 0;
                case 10:
                    beb.vPB = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
