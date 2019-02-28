package com.tencent.mm.protocal.c;

import e.a.a.c.a;
import java.util.LinkedList;

public final class rv extends bea {
    public int vNL;
    public long vNT;
    public String vOL;
    public int vUN;
    public String wfN;
    public int wgA;
    public long wgB;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            a aVar = (a) objArr[0];
            aVar.fX(1, this.vNL);
            aVar.fX(2, this.vUN);
            aVar.fX(3, this.wgA);
            if (this.vOL != null) {
                aVar.g(4, this.vOL);
            }
            if (this.wQE != null) {
                aVar.fZ(5, this.wQE.bkL());
                this.wQE.a(aVar);
            }
            aVar.S(6, this.vNT);
            if (this.wfN != null) {
                aVar.g(7, this.wfN);
            }
            aVar.S(8, this.wgB);
            return 0;
        } else if (i == 1) {
            fU = ((e.a.a.a.fU(1, this.vNL) + 0) + e.a.a.a.fU(2, this.vUN)) + e.a.a.a.fU(3, this.wgA);
            if (this.vOL != null) {
                fU += e.a.a.b.b.a.h(4, this.vOL);
            }
            if (this.wQE != null) {
                fU += e.a.a.a.fW(5, this.wQE.bkL());
            }
            fU += e.a.a.a.R(6, this.vNT);
            if (this.wfN != null) {
                fU += e.a.a.b.b.a.h(7, this.wfN);
            }
            return fU + e.a.a.a.R(8, this.wgB);
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = com.tencent.mm.bp.a.a(aVar2); fU > 0; fU = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            rv rvVar = (rv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    rvVar.vNL = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    rvVar.vUN = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    rvVar.wgA = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    rvVar.vOL = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a fhVar = new fh();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fhVar.a(aVar4, fhVar, com.tencent.mm.bp.a.a(aVar4))) {
                        }
                        rvVar.wQE = fhVar;
                    }
                    return 0;
                case 6:
                    rvVar.vNT = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    rvVar.wfN = aVar3.AEQ.readString();
                    return 0;
                case 8:
                    rvVar.wgB = aVar3.AEQ.rA();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
